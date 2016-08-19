/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.DBC0210011;

import jp.co.ndensan.reams.db.dbc.business.core.basic.JukyushaIdoRenrakuhyo;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0210011.DBC0210011StateName;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0210011.DBC0210011TransitionEventName;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0210011.JukyushaIdoRenrakuhyoTorokuPanelDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC0210011.JukyushaIdoRenrakuhyoTorokuPanelHandler;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC0210011.JukyushaIdoRenrakuhyoTorokuPanelValidationHandler;
import jp.co.ndensan.reams.db.dbc.service.core.basic.JukyushaIdoRenrakuhyoManager;
import jp.co.ndensan.reams.db.dbc.service.core.jukyushaidorenrakuhyotoroku.JukyushaIdoRenrakuhyoToroku;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.db.dbz.definition.message.DbzErrorMessages;
import jp.co.ndensan.reams.db.dbz.service.TaishoshaKey;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.exclusion.LockingKey;
import jp.co.ndensan.reams.uz.uza.exclusion.PessimisticLockingException;
import jp.co.ndensan.reams.uz.uza.exclusion.RealInitialLocker;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.message.QuestionMessage;
import jp.co.ndensan.reams.uz.uza.report.SourceDataCollection;
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

    private static final RString 被保険者番号なし = new RString("被保険者番号なし");
    private static final RString DBCHIHOKENSHANO = new RString("DBCHihokenshaNo");
    private static final RString ZERO = new RString("0");
    private static final RString 新規モード = new RString("新規モード");

    private JukyushaIdoRenrakuhyoTorokuPanelHandler getHandler(JukyushaIdoRenrakuhyoTorokuPanelDiv div) {
        return new JukyushaIdoRenrakuhyoTorokuPanelHandler(div);
    }

    private JukyushaIdoRenrakuhyoTorokuPanelValidationHandler getValidationHandler(JukyushaIdoRenrakuhyoTorokuPanelDiv div) {
        return new JukyushaIdoRenrakuhyoTorokuPanelValidationHandler(div);
    }

    /**
     * 画面初期化のメソッドます。
     *
     * @param div SearchHihokenshaDiv
     *
     * @return ResponseData
     */
    public ResponseData<JukyushaIdoRenrakuhyoTorokuPanelDiv> onLoad(JukyushaIdoRenrakuhyoTorokuPanelDiv div) {
        TaishoshaKey 資格対象者 = ViewStateHolder.get(ViewStateKeys.資格対象者, TaishoshaKey.class);
        JukyushaIdoRenrakuhyoTorokuPanelHandler handler = getHandler(div);
        if (資格対象者 != null) {
            if (資格対象者.get被保険者番号() == null) {
                throw new ApplicationException(DbzErrorMessages.理由付き登録不可.getMessage().replace(被保険者番号なし.toString()));
            }
        }
//        ShikibetsuCode 識別コード = new ShikibetsuCode(new RString("209007"));
//        HihokenshaNo 被保険者番号 = new HihokenshaNo(new RString("1034567002"));
        RString 前排他キー = DBCHIHOKENSHANO.concat(資格対象者.get被保険者番号().getColumnValue());
        LockingKey key = new LockingKey(前排他キー);
        if (!RealInitialLocker.tryGetLock(key)) {
            throw new PessimisticLockingException();
        }
        //div.getJukyushaIdoRenrakuhyoShinkiTorokuPanel().getJukyushaIdoRenrakuhyo().initialize(new RString("訂正モード"), 識別コード, 被保険者番号, 1, false, new FlexibleDate(new RString("20160811")));
        div.getJukyushaIdoRenrakuhyoShinkiTorokuPanel().getJukyushaIdoRenrakuhyo().initialize(新規モード, 資格対象者.get識別コード(), 資格対象者.get被保険者番号(), 0, false, FlexibleDate.getNowDate());
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
        //div.getJukyushaIdoRenrakuhyoShinkiTorokuPanel().getJukyushaIdoRenrakuhyo()
        JukyushaIdoRenrakuhyoManager manager = InstanceProvider.create(JukyushaIdoRenrakuhyoManager.class);
        JukyushaIdoRenrakuhyoTorokuPanelValidationHandler validationHander = getValidationHandler(div);
        ValidationMessageControlPairs pairs = validationHander.validate();
        if (pairs.iterator().hasNext() && !ResponseHolder.isReRequest()) {
            return ResponseData.of(div).addValidationMessages(pairs).respond();
        }
        if (!ResponseHolder.isReRequest()) {
            QuestionMessage message = new QuestionMessage(UrQuestionMessages.処理実行の確認.getMessage().getCode(),
                    UrQuestionMessages.処理実行の確認.getMessage().evaluate());
            return ResponseData.of(div).addMessage(message).respond();
        }
        if (ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            RString 被保険者番号 = div.getJukyushaIdoRenrakuhyoShinkiTorokuPanel().
                    getJukyushaIdoRenrakuhyo().get受給者異動送付().get被保険者番号().getColumnValue();
            RString 異動日 = new RString(div.getJukyushaIdoRenrakuhyoShinkiTorokuPanel().
                    getJukyushaIdoRenrakuhyo().get受給者異動送付().get異動年月日().toString());
            RString 異動区分 = div.getJukyushaIdoRenrakuhyoShinkiTorokuPanel().
                    getJukyushaIdoRenrakuhyo().get受給者異動送付().get異動区分コード();
            JukyushaIdoRenrakuhyoToroku jukyushaIdoRen = JukyushaIdoRenrakuhyoToroku.createInstance();
            RString エラー有無 = jukyushaIdoRen.regJukyushaIdoJoho(被保険者番号, new RDate(異動日.toString()), 異動区分);
            if (ZERO.equals(エラー有無)) {
                JukyushaIdoRenrakuhyo result = getDataEdit(被保険者番号, 異動日, div);
                result = result.createBuilderForEdit().set証記載保険者番号(new ShoKisaiHokenshaNo(new RString("000001"))).build();
                result.toEntity().setState(EntityDataState.Added);
                manager.save受給者異動送付(result);
            }
        } else {
            return ResponseData.of(div).respond();
        }
        return ResponseData.of(div).setState(DBC0210011StateName.完了メッセージ);

    }

    private JukyushaIdoRenrakuhyo getDataEdit(RString 被保険者番号, RString 異動日, JukyushaIdoRenrakuhyoTorokuPanelDiv div) {
        JukyushaIdoRenrakuhyoTorokuPanelHandler handler = getHandler(div);
        JukyushaIdoRenrakuhyoManager manager = InstanceProvider.create(JukyushaIdoRenrakuhyoManager.class);
        JukyushaIdoRenrakuhyo entity = manager.get受給者異動連絡票情報(被保険者番号, 異動日);
        JukyushaIdoRenrakuhyo result = div.getJukyushaIdoRenrakuhyoShinkiTorokuPanel().getJukyushaIdoRenrakuhyo().get受給者異動送付();
        if (entity != null) {
            result = handler.editResult(result);
        }
        return result;
    }

    /**
     * 「処理実行の確認」.「はい」ボタンのメソッドです。
     *
     * @param div 画面Div
     *
     * @return ResponseData
     */
    public ResponseData<SourceDataCollection> onClick_btnReportPublish(JukyushaIdoRenrakuhyoTorokuPanelDiv div) {
        return ResponseData.of(getHandler(div).to帳票発行(div.getJukyushaIdoRenrakuhyoShinkiTorokuPanel().getJukyushaIdoRenrakuhyo()))
                .setState(DBC0210011StateName.完了メッセージ);
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
     * 「再検索する」ボタンクリック時の事件です。
     *
     * @param div JukyushaIdoRenrakuhyoTorokuPanelDiv
     * @return ResponseData
     */
    public ResponseData<JukyushaIdoRenrakuhyoTorokuPanelDiv> onClick_btnReSearch(
            JukyushaIdoRenrakuhyoTorokuPanelDiv div) {
        return ResponseData.of(div).forwardWithEventName(DBC0210011TransitionEventName.該当者検索へ).respond();
    }

    /**
     * 「再検索する」ボタンのメソッドです。
     *
     * @param div 画面Div
     * @return ResponseData
     */
    public ResponseData<JukyushaIdoRenrakuhyoTorokuPanelDiv> onClick_btnResearch(JukyushaIdoRenrakuhyoTorokuPanelDiv div) {
        return getCheckMessage(div, DBC0210011TransitionEventName.該当者検索へ);
    }

    private ResponseData<JukyushaIdoRenrakuhyoTorokuPanelDiv> getCheckMessage(
            JukyushaIdoRenrakuhyoTorokuPanelDiv div,
            DBC0210011TransitionEventName eventName) {
        TaishoshaKey 資格対象者 = ViewStateHolder.get(ViewStateKeys.資格対象者, TaishoshaKey.class);
        HihokenshaNo 被保険者番号 = 資格対象者.get被保険者番号();
        if (被保険者番号 != null && !被保険者番号.isEmpty()) {
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
     * 前排他のンメソッドます。
     *
     * @param 被保険者番号 RString
     * @return boolean
     */
    public boolean get前排他(RString 被保険者番号) {
        LockingKey 排他キー = new LockingKey(DBCHIHOKENSHANO.concat(被保険者番号));
        return RealInitialLocker.tryGetLock(排他キー);
    }

    /**
     * 前排他キーの解除のンメソッドます。
     *
     * @param 被保険者番号 RString
     */
    public void 前排他キーの解除(RString 被保険者番号) {
        LockingKey 排他キー = new LockingKey(DBCHIHOKENSHANO.concat(被保険者番号));
        RealInitialLocker.release(排他キー);
    }

    /**
     * 前排他キーのセットのンメソッドます。
     *
     * @param 被保険者番号 RString
     */
    public void 前排他キーのセット(RString 被保険者番号) {
        LockingKey 排他キー = new LockingKey(DBCHIHOKENSHANO.concat(被保険者番号));
        RealInitialLocker.lock(排他キー);
    }

}
