/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.DBC0220012;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.basic.JukyushaIdoRenrakuhyo;
import jp.co.ndensan.reams.db.dbc.business.core.jukyushateiseirenrakuhyotorokumanager.JukyushaTeiseiRenrakuhyoTorokuManagerResult;
import jp.co.ndensan.reams.db.dbc.business.core.kyodojukyushataishosha.KyodoJukyushaTaishoshaEntity;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0220012.DBC0220012StateName;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0220012.DBC0220012TransitionEventName;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0220012.JukyushaTeiseiRenrakuhyoTorokuPanelDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC0220012.JukyushaTeiseiRenrakuhyoTorokuPanelHandler;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC0220012.JukyushaTeiseiRenrakuhyoTorokuPanelValidationHandler;
import jp.co.ndensan.reams.db.dbc.service.core.jukyushateiseirenrakuhyotorokumanager.JukyushaTeiseiRenrakuhyoTorokuManager;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.db.dbz.definition.message.DbzErrorMessages;
import jp.co.ndensan.reams.db.dbz.definition.message.DbzWarningMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.exclusion.PessimisticLockingException;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.SystemException;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogType;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogger;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.message.QuestionMessage;
import jp.co.ndensan.reams.uz.uza.message.WarningMessage;
import jp.co.ndensan.reams.uz.uza.report.SourceDataCollection;
import jp.co.ndensan.reams.uz.uza.ui.servlets.CommonButtonHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * 画面設計_DBCMN81002_受給者訂正連絡票登録
 *
 * @reamsid_L DBC-2101-020 quxiaodong
 */
public class JukyushaTeiseiRenrakuhyoTorokuPanel {

    private static final RString 引き継ぎ情報なし = new RString("引き継ぎ情報なし");
    private static final RString 訂正モード = new RString("訂正モード");
    private static final RString 照会モード = new RString("照会モード");
    private static final RString 修正モード_TWO = new RString("修正モード2");
    private static final RString 修正モード_THREE = new RString("修正モード3");
    private static final RString ONE = new RString("1");
    private static final RString TWO = new RString("2");
    private static final RString THREE = new RString("3");
    private static final RString T_O_Z = new RString("E00210");
    private static final RString T_S_Z = new RString("E00360");
    private static final RString 履歴番号 = new RString("履歴番号");
    private static final RString 保存確認 = new RString("保存確認");
    private static final RString 起動 = new RString("1");
    private static final RString 停止 = new RString("0");
    private static final RString 連絡票を = new RString("btnUpdate");
    private static final RString 新規データを削除しようとしています = new RString("新規データを削除しようとしています。");
    private static final RString 終了データを削除しようとしています = new RString("終了データを削除しようとしています。");

    /**
     * 画面初期化です。
     *
     * @param div JukyushaIdoRenrakuhyoHenkoMainPanelDiv
     * @return ResponseData
     */
    public ResponseData<JukyushaTeiseiRenrakuhyoTorokuPanelDiv> onLoad(JukyushaTeiseiRenrakuhyoTorokuPanelDiv div) {
        KyodoJukyushaTaishoshaEntity 引き継ぎ情報 = ViewStateHolder.get(
                ViewStateKeys.一覧検索キー, KyodoJukyushaTaishoshaEntity.class);
        if (引き継ぎ情報 == null || ((引き継ぎ情報.get被保番号() == null || 引き継ぎ情報.get被保番号().isEmpty())
                && (引き継ぎ情報.get異動日() == null || 引き継ぎ情報.get異動日().isEmpty()))) {
            throw new ApplicationException(
                    DbzErrorMessages.理由付き登録不可.getMessage().replace(引き継ぎ情報なし.toString()));
        }
        div.setDisabled(false);
        CommonButtonHolder.setDisabledByCommonButtonFieldName(連絡票を, false);
        ViewStateHolder.put(ViewStateKeys.被保険者番号, 引き継ぎ情報.get被保番号());
        if (!getHandler(div).is前排他キーのセット(引き継ぎ情報.get被保番号())) {
            throw new PessimisticLockingException();
        }
        if (!引き継ぎ情報.is論理削除フラグ()) {
            div.getJukyushaIdoRenrakuhyo().initialize(訂正モード, ShikibetsuCode.EMPTY,
                    引き継ぎ情報.get被保番号(), 引き継ぎ情報.get履歴番号(),
                    引き継ぎ情報.is論理削除フラグ(), 引き継ぎ情報.get異動日());
            ViewStateHolder.put(ViewStateKeys.モード, 訂正モード);
        } else {
            div.getJukyushaIdoRenrakuhyo().initialize(照会モード, ShikibetsuCode.EMPTY,
                    引き継ぎ情報.get被保番号(), 引き継ぎ情報.get履歴番号(),
                    引き継ぎ情報.is論理削除フラグ(), 引き継ぎ情報.get異動日());
            ViewStateHolder.put(ViewStateKeys.モード, 照会モード);
        }
        div.getOutputJukyushaIdoRenrakuhyo().getJukyushaIdoRenrakuhyoHenkoPrintSetting().
                initialize(true, null, true, false, null, false);
        ShikibetsuCode 識別コード = ViewStateHolder.get(ViewStateKeys.識別コード, ShikibetsuCode.class);
        AccessLogger.log(AccessLogType.照会,
                getHandler(div).toPersonalData(識別コード,
                引き継ぎ情報.get被保番号().getColumnValue()));
        return ResponseData.of(div).respond();
    }

    /**
     * 「連絡票を保存する」ボタンです。
     *
     * @param div JukyushaTeiseiRenrakuhyoTorokuPanelDiv
     * @return ResponseData
     */
    public ResponseData<JukyushaTeiseiRenrakuhyoTorokuPanelDiv> onClick_btnUpdate(
            JukyushaTeiseiRenrakuhyoTorokuPanelDiv div) {
        ValidationMessageControlPairs validPairs = getCheckHandler(div).get入力チェック();
        if (validPairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(validPairs).respond();
        }
        div.setDialogFlag(保存確認);
        KyodoJukyushaTaishoshaEntity 引き継ぎ情報 = ViewStateHolder.get(
                ViewStateKeys.一覧検索キー, KyodoJukyushaTaishoshaEntity.class);
        JukyushaIdoRenrakuhyo 受給者訂正連絡票登録画面Div = div.getJukyushaIdoRenrakuhyo().get受給者異動送付();
        JukyushaTeiseiRenrakuhyoTorokuManagerResult result = JukyushaTeiseiRenrakuhyoTorokuManager.
                createInstance().regJukyushaTeiseiJoho(引き継ぎ情報.get履歴番号(),
                        引き継ぎ情報.is論理削除フラグ(), 受給者訂正連絡票登録画面Div);
        if (THREE.equals(受給者訂正連絡票登録画面Div.get訂正区分コード())) {
            ViewStateHolder.put(ViewStateKeys.利用モード, 照会モード);
        }
        if (TWO.equals(result.get警告メッセージコード_新規())) {
            if (!ResponseHolder.isReRequest()
                    && !new RString(DbzWarningMessages.確認.getMessage().getCode()).
                    equals(ResponseHolder.getMessageCode())
                    && !new RString(UrQuestionMessages.保存の確認.getMessage().
                            getCode()).equals(ResponseHolder.getMessageCode())) {
                WarningMessage message = new WarningMessage(
                        DbzWarningMessages.確認.getMessage().getCode(),
                        DbzWarningMessages.確認.getMessage().
                        replace(新規データを削除しようとしています.toString()).evaluate());
                return ResponseData.of(div).addMessage(message).respond();
            }
            setエラー有無(div, result);
        } else if (TWO.equals(result.get警告メッセージコード_終了())) {
            if (!ResponseHolder.isReRequest() && !new RString(DbzWarningMessages.確認.getMessage().
                    getCode()).equals(ResponseHolder.getMessageCode())
                    && !new RString(UrQuestionMessages.保存の確認.getMessage().
                            getCode()).equals(ResponseHolder.getMessageCode())) {
                WarningMessage message = new WarningMessage(
                        DbzWarningMessages.確認.getMessage().getCode(),
                        DbzWarningMessages.確認.getMessage().
                        replace(終了データを削除しようとしています.toString()).evaluate());
                return ResponseData.of(div).addMessage(message).respond();
            }
            setエラー有無(div, result);
        }
        List<RString> チェック状態 = getHandler(div).getチェックボックス状態();
        if (0 == result.getエラー有無() && !チェック状態.isEmpty()) {
            div.getHdnFlag().setValue(起動);
        } else {
            div.getHdnFlag().setValue(停止);
        }
        if (!new RString(UrQuestionMessages.保存の確認.getMessage().
                getCode()).equals(ResponseHolder.getMessageCode()) && 保存確認.equals(div.getDialogFlag())) {
            QuestionMessage message = new QuestionMessage(UrQuestionMessages.保存の確認.getMessage().getCode(),
                    UrQuestionMessages.保存の確認.getMessage().evaluate());
            return ResponseData.of(div).addMessage(message).respond();
        }
        if (new RString(UrQuestionMessages.保存の確認.getMessage().getCode())
                .equals(ResponseHolder.getMessageCode())
                && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            if (停止.equals(div.getHdnFlag().getValue())) {
                getErrorMessages(result);
                return get更新と状態遷移(div, 受給者訂正連絡票登録画面Div, 引き継ぎ情報);
            } else {
                getErrorMessages(result);
                return ResponseData.of(div).respond();
            }
        } else {
            div.setDialogFlag(RString.EMPTY);
            return ResponseData.of(div).respond();
        }
    }

    private void setエラー有無(
            JukyushaTeiseiRenrakuhyoTorokuPanelDiv div,
            JukyushaTeiseiRenrakuhyoTorokuManagerResult result) {
        if (new RString(DbzWarningMessages.確認.getMessage().getCode())
                .equals(ResponseHolder.getMessageCode())
                && ResponseHolder.getButtonType() == MessageDialogSelectedResult.No) {
            result.setエラー有無(1);
            div.setDialogFlag(RString.EMPTY);
        } else {
            div.setDialogFlag(保存確認);
        }
    }

    /**
     * 「発行」ボタンのメソッドです。
     *
     * @param div KyodoIdoRenrakuhyoTorokuMainDiv
     * @return ResponseData
     */
    public ResponseData<SourceDataCollection> onClick_btnReportPublish(JukyushaTeiseiRenrakuhyoTorokuPanelDiv div) {
        KyodoJukyushaTaishoshaEntity 引き継ぎ情報 = ViewStateHolder.get(
                ViewStateKeys.一覧検索キー, KyodoJukyushaTaishoshaEntity.class);
        JukyushaIdoRenrakuhyo 受給者訂正連絡票登録画面Div = div.getJukyushaIdoRenrakuhyo().get受給者異動送付();
        RString 利用モード = ViewStateHolder.get(ViewStateKeys.利用モード, RString.class);
        return ResponseData.of(getHandler(div).to帳票発行処理(引き継ぎ情報.get被保番号(),
                引き継ぎ情報.get履歴番号(), 引き継ぎ情報.is論理削除フラグ(),
                引き継ぎ情報.get異動日(), 受給者訂正連絡票登録画面Div, 利用モード)).respond();
    }

    /**
     * 「発行」ボタンを更新完了に状態遷移のメソッドです。
     *
     * @param div 画面Div
     * @return ResponseData
     */
    public ResponseData<JukyushaTeiseiRenrakuhyoTorokuPanelDiv> toAfterPrint(
            JukyushaTeiseiRenrakuhyoTorokuPanelDiv div) {
        JukyushaIdoRenrakuhyo 受給者訂正連絡票登録画面Div = div.getJukyushaIdoRenrakuhyo().get受給者異動送付();
        div.getCcdKanryoMessage().setMessage(
                new RString("受給者異動連絡票の登録が完了しました。"),
                受給者訂正連絡票登録画面Div.get被保険者番号().value(),
                受給者訂正連絡票登録画面Div.get被保険者氏名カナ(), true);
        return ResponseData.of(div).setState(DBC0220012StateName.完了メッセージ);
    }

    /**
     * 「検索結果一覧へ」ボタンのメソッドです。
     *
     * @param div KyodoIdoRenrakuhyoTorokuMainDiv
     * @return ResponseData
     */
    public ResponseData<JukyushaTeiseiRenrakuhyoTorokuPanelDiv> onClick_btnSearchResult(
            JukyushaTeiseiRenrakuhyoTorokuPanelDiv div) {
        div.getHdnFlag().setValue(停止);
        return getCheckMessage(div, DBC0220012TransitionEventName.対象者一覧);
    }

    /**
     * 「再検索する」ボタンのメソッドです。
     *
     * @param div KyodoIdoRenrakuhyoTorokuMainDiv
     * @return ResponseData
     */
    public ResponseData<JukyushaTeiseiRenrakuhyoTorokuPanelDiv> onClick_btnResearch(
            JukyushaTeiseiRenrakuhyoTorokuPanelDiv div) {
        div.getHdnFlag().setValue(停止);
        return getCheckMessage(div, DBC0220012TransitionEventName.検索条件);
    }

    private ResponseData<JukyushaTeiseiRenrakuhyoTorokuPanelDiv> getCheckMessage(
            JukyushaTeiseiRenrakuhyoTorokuPanelDiv div,
            DBC0220012TransitionEventName eventName) {
        HihokenshaNo 被保険者番号 = ViewStateHolder.get(ViewStateKeys.被保険者番号, HihokenshaNo.class);
        if (被保険者番号 != null && !被保険者番号.isEmpty()) {
            if (!ResponseHolder.isReRequest()) {
                QuestionMessage message = new QuestionMessage(UrQuestionMessages.入力内容の破棄.getMessage().getCode(),
                        UrQuestionMessages.入力内容の破棄.getMessage().evaluate());
                return ResponseData.of(div).addMessage(message).respond();
            }
            if (new RString(UrQuestionMessages.入力内容の破棄.getMessage().getCode())
                    .equals(ResponseHolder.getMessageCode())
                    && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
                getHandler(div).前排他キーの解除(被保険者番号);
                return ResponseData.of(div).forwardWithEventName(eventName).respond();
            } else {
                return ResponseData.of(div).respond();
            }
        } else {
            return ResponseData.of(div).forwardWithEventName(eventName).respond();
        }
    }

    private void getErrorMessages(
            JukyushaTeiseiRenrakuhyoTorokuManagerResult result) {
        if (1 == result.getエラー有無() && result.getエラーメッセージコード().equals(T_S_Z)) {
            throw new ApplicationException(UrErrorMessages.対象データなし.getMessage());
        } else if (1 == result.getエラー有無() && result.getエラーメッセージコード().equals(T_O_Z)) {
            throw new ApplicationException(UrErrorMessages.既に存在.getMessage().replace(
                    履歴番号.toString()));
        }
    }

    private ResponseData<JukyushaTeiseiRenrakuhyoTorokuPanelDiv> get更新と状態遷移(
            JukyushaTeiseiRenrakuhyoTorokuPanelDiv div,
            JukyushaIdoRenrakuhyo 受給者訂正連絡票登録画面Div,
            KyodoJukyushaTaishoshaEntity 引き継ぎ情報) {
        try {
            int 登録件数 = 0;
            if (!引き継ぎ情報.is論理削除フラグ()) {
                登録件数 = get登録件数(受給者訂正連絡票登録画面Div, div, 引き継ぎ情報);
            } else {
                登録件数 = getHandler(div).save受給者訂正連絡票(
                        受給者訂正連絡票登録画面Div, null, null, 修正モード_TWO);
            }
            ShikibetsuCode 識別コード = ViewStateHolder.get(ViewStateKeys.識別コード, ShikibetsuCode.class);
            AccessLogger.log(AccessLogType.更新,
                    getHandler(div).toPersonalData(識別コード,
                    引き継ぎ情報.get被保番号().getColumnValue()));
            if (登録件数 == 1) {
                getHandler(div).is前排他キーのセット(引き継ぎ情報.get被保番号());
                List<RString> チェック状態 = getHandler(div).getチェックボックス状態();
                if (!チェック状態.isEmpty()) {
                    return ResponseData.of(div).respond();
                } else {
                    div.getCcdKanryoMessage().setMessage(
                            new RString("受給者異動連絡票の登録が完了しました。"),
                            受給者訂正連絡票登録画面Div.get被保険者番号().value(),
                            受給者訂正連絡票登録画面Div.get被保険者氏名カナ(), true);
                    return ResponseData.of(div).setState(DBC0220012StateName.完了メッセージ);
                }
            }
        } catch (SystemException | ApplicationException e) {
            throw new ApplicationException(e.getMessage());
        }
        return ResponseData.of(div).respond();
    }

    private int get登録件数(JukyushaIdoRenrakuhyo 受給者訂正連絡票登録画面Div,
            JukyushaTeiseiRenrakuhyoTorokuPanelDiv div,
            KyodoJukyushaTaishoshaEntity 引き継ぎ情報) {
        int 登録件数 = 0;
        JukyushaIdoRenrakuhyo 初期化データ = ViewStateHolder.get(
                ViewStateKeys.受給者異動送付, JukyushaIdoRenrakuhyo.class);
        JukyushaIdoRenrakuhyo 訂正対象データ = null;
        if (ONE.equals(div.getOutputJukyushaIdoRenrakuhyo().getRadTeiseiKomokuHantei().getSelectedKey())) {
            訂正対象データ = JukyushaTeiseiRenrakuhyoTorokuManager.createInstance().
                    get訂正対象データ(引き継ぎ情報.get被保番号(), 引き継ぎ情報.get異動日(), 1);
        } else if (TWO.equals(div.getOutputJukyushaIdoRenrakuhyo().getRadTeiseiKomokuHantei().getSelectedKey())) {
            訂正対象データ = JukyushaTeiseiRenrakuhyoTorokuManager.createInstance().
                    get訂正対象データ(引き継ぎ情報.get被保番号(), 引き継ぎ情報.get異動日(), 引き継ぎ情報.get履歴番号());
        }
        boolean flag = false;
        if (訂正対象データ != null) {
            flag = getHandler(div).is受給者異動連絡票内容変更状態(
                    受給者訂正連絡票登録画面Div, 訂正対象データ);
        }
        if (TWO.equals(受給者訂正連絡票登録画面Div.get訂正区分コード())) {
            if (!flag) {
                throw new ApplicationException(UrErrorMessages.編集なしで更新不可.getMessage());
            } else {
                登録件数 = getHandler(div).save受給者訂正連絡票(
                        受給者訂正連絡票登録画面Div, 訂正対象データ, null, 修正モード_THREE);
            }
        } else if (THREE.equals(受給者訂正連絡票登録画面Div.get訂正区分コード())) {
            登録件数 = getHandler(div).save受給者訂正連絡票(
                    受給者訂正連絡票登録画面Div, null, 初期化データ, 照会モード);
        }
        return 登録件数;
    }

    /**
     * 「登録処理を続ける」ボタンクリック時の事件です。
     *
     * @param div JikoFutangakuHoseiDiv
     * @return ResponseData
     */
    public ResponseData<JukyushaTeiseiRenrakuhyoTorokuPanelDiv> onClick_btnContinue(
            JukyushaTeiseiRenrakuhyoTorokuPanelDiv div) {

        ViewStateHolder.put(ViewStateKeys.退避用データ, null);
        KyodoJukyushaTaishoshaEntity 引き継ぎ情報 = ViewStateHolder.get(
                ViewStateKeys.一覧検索キー, KyodoJukyushaTaishoshaEntity.class);
        getHandler(div).前排他キーの解除(引き継ぎ情報.get被保番号());
        return ResponseData.of(div).forwardWithEventName(DBC0220012TransitionEventName.検索条件).respond();
    }

    private JukyushaTeiseiRenrakuhyoTorokuPanelHandler getHandler(JukyushaTeiseiRenrakuhyoTorokuPanelDiv div) {
        return new JukyushaTeiseiRenrakuhyoTorokuPanelHandler(div);
    }

    private JukyushaTeiseiRenrakuhyoTorokuPanelValidationHandler getCheckHandler(
            JukyushaTeiseiRenrakuhyoTorokuPanelDiv div) {
        return new JukyushaTeiseiRenrakuhyoTorokuPanelValidationHandler(div);
    }

}
