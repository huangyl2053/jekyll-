/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.DBC6100011;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbc.business.core.basic.KokuhorenInterfaceKanri;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC6100011.DBC6100011StateName;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC6100011.DBC6100011TransitionEventName;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC6100011.KyufuTaishoshaScheduleSetteiPanelDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC6100011.KyufuTaishoshaScheduleSetteiPanelHandler;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC6100011.KyufuTaishoshaScheduleSetteiPanelValidationHandler;
import jp.co.ndensan.reams.db.dbc.service.core.kogakukaigoservicehikyufutaishoshatoroku.KogakuKaigoServicehiKyufuTaishoshaScheduleSettei;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.ur.urz.definition.message.UrInformationMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.message.QuestionMessage;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * DBCMN41001_高額介護サービス費給付対象者-スケジュール設定のクラスです。
 *
 * @reamsid_L DBC-2010-010 wangkanglei
 */
public class KyufuTaishoshaScheduleSetteiPanel {

    private static final RString 出力文言 = new RString("登録");
    private static final RString 高額介護場合 = new RString("341");
    private static final RString 総合事業高額介護場合 = new RString("342");
    private static final RString 高額介護_メニューID = new RString("DBCMN41001");
    private static final RString 総合事業高額介護_メニューID = new RString("DBCMNL1001");
    private static final RString STR_ONE = new RString("1");

    /**
     * 画面初期化です。
     *
     * @param div 画面Div
     * @return ResponseData
     */
    public ResponseData<KyufuTaishoshaScheduleSetteiPanelDiv> onLoad(KyufuTaishoshaScheduleSetteiPanelDiv div) {
        RString 交換情報識別番号 = null;
        if (高額介護_メニューID.equals(ResponseHolder.getMenuID())) {
            交換情報識別番号 = 高額介護場合;
        } else if (総合事業高額介護_メニューID.equals(ResponseHolder.getMenuID())) {
            交換情報識別番号 = 総合事業高額介護場合;
        }
        List<KokuhorenInterfaceKanri> スケジュール履歴情報 = KogakuKaigoServicehiKyufuTaishoshaScheduleSettei
                .createInstance().sukijyuruRirekiJyoho(交換情報識別番号);
        getHandler(div).initialize(スケジュール履歴情報);
        ViewStateHolder.put(ViewStateKeys.スケジュール履歴情報, (Serializable) スケジュール履歴情報);
        ViewStateHolder.put(ViewStateKeys.変更前処理状況, (Serializable) getHandler(div).get変更前処理状況());
        return ResponseData.of(div).respond();
    }

    /**
     * 「最新処理年月を追加する」ボタンのイベント処理です。
     *
     * @param div 画面Div
     * @return ResponseData
     */
    public ResponseData<KyufuTaishoshaScheduleSetteiPanelDiv> onClick_btnAdd(
            KyufuTaishoshaScheduleSetteiPanelDiv div) {
        getHandler(div).set最新処理年月入力エリア状態(false);
        if (STR_ONE.equals(div.getHdnFlag())) {
            getHandler(div).set最新処理年月入力エリア_２回目以降();
        } else {
            getHandler(div).set最新処理年月入力エリア_初期化();
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 「確定する」ボタンのイベント処理です。
     *
     * @param div 画面Div
     * @return ResponseData
     */
    public ResponseData<KyufuTaishoshaScheduleSetteiPanelDiv> onClick_btnKakutei(
            KyufuTaishoshaScheduleSetteiPanelDiv div) {
        ValidationMessageControlPairs validPairs = getValidationHandler(div).前後順チェックValidate();
        if (validPairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(validPairs).respond();
        }
        RString 交換情報識別番号 = null;
        if (高額介護_メニューID.equals(ResponseHolder.getMenuID())) {
            交換情報識別番号 = 高額介護場合;
        } else if (総合事業高額介護_メニューID.equals(ResponseHolder.getMenuID())) {
            交換情報識別番号 = 総合事業高額介護場合;
        }
        getHandler(div).set確定処理(交換情報識別番号);
        ViewStateHolder.put(ViewStateKeys.変更前処理状況, (Serializable) getHandler(div).get変更前処理状況());
        return ResponseData.of(div).respond();
    }

    /**
     * 「取消する」ボタンのイベント処理です。
     *
     * @param div 画面Div
     * @return ResponseData
     */
    public ResponseData<KyufuTaishoshaScheduleSetteiPanelDiv> onClick_btnTorikeshi(
            KyufuTaishoshaScheduleSetteiPanelDiv div) {
        getHandler(div).set最新処理年月入力エリア状態(true);
        return ResponseData.of(div).respond();
    }

    /**
     * 「保存する」ボタンのイベント処理です。
     *
     * @param div 画面Div
     * @return ResponseData
     */
    public ResponseData<KyufuTaishoshaScheduleSetteiPanelDiv> onClick_btnUpdate(
            KyufuTaishoshaScheduleSetteiPanelDiv div) {
        List<KokuhorenInterfaceKanri> スケジュール履歴情報List
                = ViewStateHolder.get(ViewStateKeys.スケジュール履歴情報, List.class);
        getHandler(div).to起動中チェック();
        RString 保存の確認Flag = new RString(UrQuestionMessages.保存の確認.getMessage().getCode());
        RString 交換情報識別番号 = null;
        if (高額介護_メニューID.equals(ResponseHolder.getMenuID())) {
            交換情報識別番号 = 高額介護場合;
        } else if (総合事業高額介護_メニューID.equals(ResponseHolder.getMenuID())) {
            交換情報識別番号 = 総合事業高額介護場合;
        }
        if (!保存の確認Flag.equals(ResponseHolder.getMessageCode())) {
            QuestionMessage message = new QuestionMessage(UrQuestionMessages.保存の確認.getMessage().getCode(),
                    UrQuestionMessages.保存の確認.getMessage().evaluate());
            return ResponseData.of(div).addMessage(message).respond();
        }
        if (new RString(UrQuestionMessages.保存の確認.getMessage().getCode())
                .equals(ResponseHolder.getMessageCode())
                && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            getHandler(div).save処理(スケジュール履歴情報List, true, 交換情報識別番号);
            div.getCcdKaigoKanryoMessage().setSuccessMessage(new RString(
                    UrInformationMessages.正常終了.getMessage().replace(出力文言.toString()).evaluate()));
            return ResponseData.of(div).setState(DBC6100011StateName.完了メッセージ);
        } else {
            return ResponseData.of(div).respond();
        }
    }

    /**
     * 「完了する」ボタンのイベント処理です。
     *
     * @param div 画面Div
     * @return ResponseData
     */
    public ResponseData<KyufuTaishoshaScheduleSetteiPanelDiv> onClick_btnComplete(
            KyufuTaishoshaScheduleSetteiPanelDiv div) {
        return ResponseData.of(div).forwardWithEventName(DBC6100011TransitionEventName.完了).respond();
    }

    /**
     * 処理状況変更のイベント処理です。
     *
     * @param div 画面Div
     * @return ResponseData
     */
    public ResponseData<KyufuTaishoshaScheduleSetteiPanelDiv> onChange_ddlShoriJokyo(
            KyufuTaishoshaScheduleSetteiPanelDiv div) {
        Map<Integer, RString> map = ViewStateHolder.get(ViewStateKeys.変更前処理状況, Map.class);
        getHandler(div).to処理状況変更チェック(map);
        ViewStateHolder.put(ViewStateKeys.変更前処理状況, (Serializable) getHandler(div).get変更前処理状況());
        return ResponseData.of(div).respond();
    }

    private KyufuTaishoshaScheduleSetteiPanelHandler getHandler(KyufuTaishoshaScheduleSetteiPanelDiv div) {
        return new KyufuTaishoshaScheduleSetteiPanelHandler(div);
    }

    private KyufuTaishoshaScheduleSetteiPanelValidationHandler getValidationHandler(KyufuTaishoshaScheduleSetteiPanelDiv div) {
        return new KyufuTaishoshaScheduleSetteiPanelValidationHandler(div);
    }
}
