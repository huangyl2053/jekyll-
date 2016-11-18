/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.DBC0210011;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.basic.JukyushaIdoRenrakuhyo;
import jp.co.ndensan.reams.db.dbc.definition.message.DbcInformationMessages;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0210011.DBC0210011StateName;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0210011.DBC0210011TransitionEventName;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0210011.JukyushaIdoRenrakuhyoTorokuPanelDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC0210011.JukyushaIdoRenrakuhyoTorokuPanelHandler;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC0210011.JukyushaIdoRenrakuhyoTorokuPanelValidationHandler;
import jp.co.ndensan.reams.db.dbc.service.core.basic.JukyushaIdoRenrakuhyoManager;
import jp.co.ndensan.reams.db.dbc.service.core.jukyushaidorenrakuhyotoroku.JukyushaIdoRenrakuhyoToroku;
import jp.co.ndensan.reams.db.dbd.definition.message.DbdErrorMessages;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.db.dbz.service.TaishoshaKey;
import jp.co.ndensan.reams.ur.urz.definition.message.UrInformationMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.exclusion.LockingKey;
import jp.co.ndensan.reams.uz.uza.exclusion.PessimisticLockingException;
import jp.co.ndensan.reams.uz.uza.exclusion.RealInitialLocker;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.message.QuestionMessage;
import jp.co.ndensan.reams.uz.uza.report.SourceDataCollection;
import jp.co.ndensan.reams.uz.uza.ui.servlets.CommonButtonHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 受給者異動連絡票（追加）登録です。
 *
 * @reamsid_L DBC-2100-010 jiangzongyue
 */
public class JukyushaIdoRenrakuhyoTorokuPanel {

    private static final RString DBCHIHOKENSHANO = new RString("DBCHihokenshaNo");
    private static final RString ZERO = new RString("0");
    private static final RString ONE = new RString("1");
    private static final RString 新規モード = new RString("新規モード");
    private static final RString 起動 = new RString("1");
    private static final RString 停止 = new RString("0");
    private static final RString ボタン名 = new RString("btnSave");
    private static final RString TRUE = new RString("true");
    private static final RString FALSE = new RString("false");

    private JukyushaIdoRenrakuhyoTorokuPanelHandler getHandler(JukyushaIdoRenrakuhyoTorokuPanelDiv div) {
        return new JukyushaIdoRenrakuhyoTorokuPanelHandler(div);
    }

    private JukyushaIdoRenrakuhyoTorokuPanelValidationHandler getValidationHandler(JukyushaIdoRenrakuhyoTorokuPanelDiv div) {
        return new JukyushaIdoRenrakuhyoTorokuPanelValidationHandler(div);
    }

    /**
     * 画面初期化のメソッドです。
     *
     * @param div SearchHihokenshaDiv
     *
     * @return ResponseData
     */
    public ResponseData<JukyushaIdoRenrakuhyoTorokuPanelDiv> onLoad(JukyushaIdoRenrakuhyoTorokuPanelDiv div) {
        if (ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes && ResponseHolder.isReRequest()) {
            return ResponseData.of(div).respond();
        }
        TaishoshaKey 資格対象者 = ViewStateHolder.get(ViewStateKeys.資格対象者, TaishoshaKey.class);
        JukyushaIdoRenrakuhyoTorokuPanelHandler handler = getHandler(div);
        if (資格対象者 == null || 資格対象者.get被保険者番号() == null || 資格対象者.get被保険者番号().isEmpty()
                && !ResponseHolder.isReRequest()) {
            div.getJukyushaIdoRenrakuhyoShinkiTorokuPanel().getJukyushaIdoRenrakuhyo().setDisabled(true);
            div.getJukyushaIdoRenrakuhyoShinkiTorokuPanel().getOutputJukyushaIdoRenrakuhyo().setDisabled(true);
            CommonButtonHolder.setDisabledByCommonButtonFieldName(ボタン名, true);
            return ResponseData.of(div).addMessage(
                    DbcInformationMessages.被保険者でないデータ.getMessage()).respond();
        }
        RString 前排他キー = DBCHIHOKENSHANO.concat(資格対象者.get被保険者番号().getColumnValue());
        LockingKey key = new LockingKey(前排他キー);
        if (!RealInitialLocker.tryGetLock(key)) {
            throw new PessimisticLockingException();
        }
        if (handler.get被保険者番号チェック(資格対象者.get被保険者番号())) {
            div.getJukyushaIdoRenrakuhyoShinkiTorokuPanel().getJukyushaIdoRenrakuhyo().setDisabled(true);
            div.getJukyushaIdoRenrakuhyoShinkiTorokuPanel().getOutputJukyushaIdoRenrakuhyo().setDisabled(true);
            CommonButtonHolder.setDisabledByCommonButtonFieldName(ボタン名, true);
            return ResponseData.of(div).addMessage(
                    DbdErrorMessages.受給共通_受給者_事業対象者登録なし.getMessage()).respond();
        }
        div.getJukyushaIdoRenrakuhyoShinkiTorokuPanel().getJukyushaIdoRenrakuhyo()
                .initialize(新規モード, 資格対象者.get識別コード(), 資格対象者.get被保険者番号(), 0, false, FlexibleDate.getNowDate());
        div.getJukyushaIdoRenrakuhyoShinkiTorokuPanel().getOutputJukyushaIdoRenrakuhyo()
                .getOutputJukyushaIdoRenrakuhyoSetting().initialize(true, null, true, false, null, false);
        handler.printLog識別コード照会(資格対象者.get識別コード(), 資格対象者.get被保険者番号().getColumnValue());
        return ResponseData.of(div).setState(DBC0210011StateName.登録);
    }

    /**
     * 「保存する」ボタンクリック時のイベントメソッドです。
     *
     * @param div SearchHihokenshaDiv
     *
     * @return ResponseData<SearchHihokenshaDiv>
     */
    public ResponseData<JukyushaIdoRenrakuhyoTorokuPanelDiv> onClick_btnSave(JukyushaIdoRenrakuhyoTorokuPanelDiv div) {
        if (DBC0210011StateName.完了メッセージ.getName().equals(ResponseHolder.getState())) {
            RString 完了メッセージ対象情報1 = div.getJukyushaIdoRenrakuhyoShinkiTorokuPanel()
                    .getJukyushaIdoRenrakuhyo().get受給者異動送付().get被保険者番号().getColumnValue();
            RString 完了メッセージ対象情報2 = div.getJukyushaIdoRenrakuhyoShinkiTorokuPanel()
                    .getJukyushaIdoRenrakuhyo().get受給者異動送付().get被保険者氏名カナ();
            div.getCcdKanryoMessage().setMessage(new RString(UrInformationMessages.保存終了.getMessage().evaluate()),
                    完了メッセージ対象情報1, 完了メッセージ対象情報2, true);
            return ResponseData.of(div).setState(DBC0210011StateName.完了メッセージ);
        }
        ValidationMessageControlPairs pair
                = div.getJukyushaIdoRenrakuhyoShinkiTorokuPanel().getJukyushaIdoRenrakuhyo().validateCheck();
        if (pair.iterator().hasNext() && !ResponseHolder.isReRequest()) {
            return ResponseData.of(div).addValidationMessages(pair).respond();
        }
        JukyushaIdoRenrakuhyoTorokuPanelValidationHandler validationHander = getValidationHandler(div);
        ValidationMessageControlPairs pairs = validationHander.validate();
        if (pairs.iterator().hasNext() && !ResponseHolder.isReRequest()) {
            return ResponseData.of(div).addValidationMessages(pairs).respond();
        }
        if (!ResponseHolder.isReRequest()) {
            QuestionMessage message = new QuestionMessage(UrQuestionMessages.保存の確認.getMessage().getCode(),
                    UrQuestionMessages.保存の確認.getMessage().evaluate());
            return ResponseData.of(div).addMessage(message).respond();
        }
        if (ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            JukyushaIdoRenrakuhyoTorokuPanelHandler handler = getHandler(div);
            RString 被保険者番号 = div.getJukyushaIdoRenrakuhyoShinkiTorokuPanel().
                    getJukyushaIdoRenrakuhyo().get受給者異動送付().get被保険者番号().getColumnValue();
            RString 異動日 = new RString(div.getJukyushaIdoRenrakuhyoShinkiTorokuPanel().
                    getJukyushaIdoRenrakuhyo().get受給者異動送付().get異動年月日().toString());
            RString 異動区分 = div.getJukyushaIdoRenrakuhyoShinkiTorokuPanel().
                    getJukyushaIdoRenrakuhyo().get受給者異動送付().get異動区分コード();
            JukyushaIdoRenrakuhyoToroku jukyushaIdoRen = JukyushaIdoRenrakuhyoToroku.createInstance();
            RString エラー有無 = jukyushaIdoRen.regJukyushaIdoJoho(被保険者番号, new RDate(異動日.toString()), 異動区分);
            List<RString> チェック状態 = handler.getチェックボックス状態();
            if (ZERO.equals(エラー有無) && !チェック状態.isEmpty()) {
                div.getJukyushaIdoRenrakuhyoShinkiTorokuPanel().getHdnFlag().setValue(起動);
            } else {
                div.getJukyushaIdoRenrakuhyoShinkiTorokuPanel().getHdnFlag().setValue(停止);
            }
            if (停止.equals(div.getJukyushaIdoRenrakuhyoShinkiTorokuPanel().getHdnFlag().getValue())) {
                dataSave(エラー有無, 被保険者番号, 異動日, div);
            }
            RString flag = div.getHdnFlg();
            if (TRUE.equals(flag)) {
                RString 完了メッセージ対象情報1 = div.getJukyushaIdoRenrakuhyoShinkiTorokuPanel()
                        .getJukyushaIdoRenrakuhyo().get受給者異動送付().get被保険者番号().getColumnValue();
                RString 完了メッセージ対象情報2 = div.getJukyushaIdoRenrakuhyoShinkiTorokuPanel()
                        .getJukyushaIdoRenrakuhyo().get受給者異動送付().get被保険者氏名カナ();
                div.getCcdKanryoMessage().setMessage(new RString(UrInformationMessages.保存終了.getMessage().evaluate()),
                        完了メッセージ対象情報1, 完了メッセージ対象情報2, true);
                return ResponseData.of(div).setState(DBC0210011StateName.完了メッセージ);
            } else {
                return ResponseData.of(div).respond();
            }
        } else {
            return ResponseData.of(div).respond();
        }
    }

    private JukyushaIdoRenrakuhyo getDataEdit(RString 被保険者番号, RString 異動日,
            JukyushaIdoRenrakuhyoTorokuPanelDiv div, JukyushaIdoRenrakuhyoManager manager) {
        JukyushaIdoRenrakuhyoTorokuPanelHandler handler = getHandler(div);
        JukyushaIdoRenrakuhyo entity = manager.get受給者異動連絡票情報(被保険者番号, 異動日);
        JukyushaIdoRenrakuhyo result = div.getJukyushaIdoRenrakuhyoShinkiTorokuPanel().getJukyushaIdoRenrakuhyo().get受給者異動送付();
        if (entity != null) {
            result = handler.editResult(result, entity);
        }
        return result;
    }

    private boolean getSaveState(RString エラー有無, RString 被保険者番号, RString 異動日, JukyushaIdoRenrakuhyoTorokuPanelDiv div) {
        TaishoshaKey 資格対象者 = ViewStateHolder.get(ViewStateKeys.資格対象者, TaishoshaKey.class);
        JukyushaIdoRenrakuhyoManager manager = InstanceProvider.create(JukyushaIdoRenrakuhyoManager.class);
        JukyushaIdoRenrakuhyoTorokuPanelHandler handler = getHandler(div);
        if (ZERO.equals(エラー有無)) {
            JukyushaIdoRenrakuhyo result = getDataEdit(被保険者番号, 異動日, div, manager);
            boolean falg = div.getJukyushaIdoRenrakuhyoShinkiTorokuPanel().getOutputJukyushaIdoRenrakuhyo()
                    .getChkJukyushaIdoRearakuhyoHakkou().isAllSelected();
            JukyushaIdoRenrakuhyo resultEntity = result.createBuilderForEdit().set訂正連絡票フラグ(falg).build();
            resultEntity.toEntity().setState(EntityDataState.Added);
            boolean flag = manager.save受給者異動送付(resultEntity);
            handler.printLog識別コード更新(資格対象者.get識別コード(), 資格対象者.get被保険者番号().getColumnValue());
            List<RString> チェック状態 = handler.getチェックボックス状態();
            if (flag && !チェック状態.isEmpty()) {
                return false;
            }
            if (flag && チェック状態.isEmpty()) {
                return true;
            }
        }
        return false;
    }

    private void dataSave(RString エラー有無, RString 被保険者番号, RString 異動日, JukyushaIdoRenrakuhyoTorokuPanelDiv div) {
        boolean flag1 = getSaveState(エラー有無, 被保険者番号, 異動日, div);
        if (flag1) {
            div.setHdnFlg(TRUE);
        } else {
            div.setHdnFlg(FALSE);
        }
    }

    /**
     * 「処理実行の確認」.「はい」ボタンのメソッドです。
     *
     * @param div 画面Div
     *
     * @return ResponseData
     */
    public ResponseData<SourceDataCollection> onClick_btnReportPublish(JukyushaIdoRenrakuhyoTorokuPanelDiv div) {
        RString 被保険者番号 = div.getJukyushaIdoRenrakuhyoShinkiTorokuPanel().
                getJukyushaIdoRenrakuhyo().get受給者異動送付().get被保険者番号().getColumnValue();
        RString 異動日 = new RString(div.getJukyushaIdoRenrakuhyoShinkiTorokuPanel().
                getJukyushaIdoRenrakuhyo().get受給者異動送付().get異動年月日().toString());
        RString エラー有無 = null;
        if (起動.equals(div.getJukyushaIdoRenrakuhyoShinkiTorokuPanel().getHdnFlag().getValue())) {
            エラー有無 = ZERO;
        } else {
            エラー有無 = ONE;
        }
        if (div.getHdnFlg() == null) {
            boolean flag1 = getSaveState(エラー有無, 被保険者番号, 異動日, div);
            if (flag1) {
                div.setHdnFlg(TRUE);
            } else {
                div.setHdnFlg(FALSE);
            }
        }
        return ResponseData.of(getHandler(div).to帳票発行(
                div.getJukyushaIdoRenrakuhyoShinkiTorokuPanel().getJukyushaIdoRenrakuhyo())).respond();
    }

    /**
     * 「発行」ボタンを更新完了に状態遷移のメソッドです。
     *
     * @param div 画面Div
     * @return ResponseData
     */
    public ResponseData<JukyushaIdoRenrakuhyoTorokuPanelDiv> toAfterPrint(JukyushaIdoRenrakuhyoTorokuPanelDiv div) {
        RString 完了メッセージ対象情報1 = div.getJukyushaIdoRenrakuhyoShinkiTorokuPanel()
                .getJukyushaIdoRenrakuhyo().get受給者異動送付().get被保険者番号().getColumnValue();
        RString 完了メッセージ対象情報2 = div.getJukyushaIdoRenrakuhyoShinkiTorokuPanel()
                .getJukyushaIdoRenrakuhyo().get受給者異動送付().get被保険者氏名カナ();
        div.getCcdKanryoMessage().setMessage(new RString(UrInformationMessages.保存終了.getMessage().evaluate()),
                完了メッセージ対象情報1, 完了メッセージ対象情報2, true);
        return ResponseData.of(div).setState(DBC0210011StateName.完了メッセージ);
    }

    /**
     * 「完了する」ボタンの処理です。
     *
     * @param div div
     * @return ResponseData
     */
    public ResponseData<JukyushaIdoRenrakuhyoTorokuPanelDiv> onSelect_Compelete(
            JukyushaIdoRenrakuhyoTorokuPanelDiv div) {
        return ResponseData.of(div).forwardWithEventName(DBC0210011TransitionEventName.完了).respond();
    }

    /**
     * 「検索結果一覧へ」ボタンクリック時の事件です。
     *
     * @param div 画面Div
     * @return ResponseData
     */
    public ResponseData<JukyushaIdoRenrakuhyoTorokuPanelDiv> onClick_btnReSearch(JukyushaIdoRenrakuhyoTorokuPanelDiv div) {
        div.getJukyushaIdoRenrakuhyoShinkiTorokuPanel().getHdnFlag().setValue(停止);
        return getCheckMessage(div, DBC0210011TransitionEventName.該当者検索へ);
    }

    /**
     * 「再検索する」ボタンクリック時の事件です。
     *
     * @param div 画面Div
     * @return ResponseData
     */
    public ResponseData<JukyushaIdoRenrakuhyoTorokuPanelDiv> onClick_btnResultDg(JukyushaIdoRenrakuhyoTorokuPanelDiv div) {
        div.getJukyushaIdoRenrakuhyoShinkiTorokuPanel().getHdnFlag().setValue(停止);
        return getCheckMessage(div, DBC0210011TransitionEventName.検索条件);
    }

    private ResponseData<JukyushaIdoRenrakuhyoTorokuPanelDiv> getCheckMessage(
            JukyushaIdoRenrakuhyoTorokuPanelDiv div,
            DBC0210011TransitionEventName eventName) {
        TaishoshaKey 資格対象者 = ViewStateHolder.get(ViewStateKeys.資格対象者, TaishoshaKey.class);
        HihokenshaNo 被保険者番号 = 資格対象者.get被保険者番号();
        if (被保険者番号 != null && !被保険者番号.isEmpty()) {
            if (DBC0210011StateName.完了メッセージ.getName().equals(ResponseHolder.getState())) {
                前排他キーの解除(被保険者番号.getColumnValue());
                return ResponseData.of(div).forwardWithEventName(eventName).respond();
            }
            if (!ResponseHolder.isReRequest()) {
                QuestionMessage message = new QuestionMessage(UrQuestionMessages.入力内容の破棄.getMessage().getCode(),
                        UrQuestionMessages.入力内容の破棄.getMessage().evaluate());
                return ResponseData.of(div).addMessage(message).respond();
            }
            if (new RString(UrQuestionMessages.入力内容の破棄.getMessage().getCode())
                    .equals(ResponseHolder.getMessageCode())
                    && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
                前排他キーの解除(被保険者番号.getColumnValue());
                return ResponseData.of(div).forwardWithEventName(eventName).respond();
            } else {
                return ResponseData.of(div).respond();
            }
        } else {
            return ResponseData.of(div).forwardWithEventName(eventName).respond();
        }
    }

    /**
     * 前排他のンメソッドです。
     *
     * @param 被保険者番号 RString
     * @return boolean
     */
    public boolean get前排他(RString 被保険者番号) {
        LockingKey 排他キー = new LockingKey(DBCHIHOKENSHANO.concat(被保険者番号));
        return RealInitialLocker.tryGetLock(排他キー);
    }

    /**
     * 前排他キーの解除のンメソッドです。
     *
     * @param 被保険者番号 RString
     */
    public void 前排他キーの解除(RString 被保険者番号) {
        LockingKey 排他キー = new LockingKey(DBCHIHOKENSHANO.concat(被保険者番号));
        RealInitialLocker.release(排他キー);
    }

    /**
     * 前排他キーのセットのンメソッドです。
     *
     * @param 被保険者番号 RString
     */
    public void 前排他キーのセット(RString 被保険者番号) {
        LockingKey 排他キー = new LockingKey(DBCHIHOKENSHANO.concat(被保険者番号));
        RealInitialLocker.lock(排他キー);
    }

}
