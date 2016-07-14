/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.DBC6100011;

import java.io.Serializable;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.basic.KokuhorenInterfaceKanri;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC6100011.DBC6100011StateName;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC6100011.DBC6100011TransitionEventName;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC6100011.KyufuTaishoshaScheduleSetteiPanelDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC6100011.KyufuTaishoshaScheduleSetteiPanelHandler;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC6100011.KyufuTaishoshaScheduleSetteiPanelValidationHandler;
import jp.co.ndensan.reams.db.dbc.service.core.kogakukaigoservicehikyufutaishoshatoroku.KogakuKaigoServicehiKyufuTaishoshaScheduleSettei;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
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

    /**
     * 画面初期化です。
     *
     * @param div 画面Div
     * @return ResponseData
     */
    public ResponseData<KyufuTaishoshaScheduleSetteiPanelDiv> onLoad(KyufuTaishoshaScheduleSetteiPanelDiv div) {
        // TODO QA961
//        List<KokuhorenInterfaceKanri> スケジュール履歴情報 = KogakuKaigoServicehiKyufuTaishoshaScheduleSettei
//                .createInstance().sukijyuruRirekiJyoho(ResponseHolder.getMenuID());
        List<KokuhorenInterfaceKanri> スケジュール履歴情報 = KogakuKaigoServicehiKyufuTaishoshaScheduleSettei
                .createInstance().sukijyuruRirekiJyoho(new RString("999"));
        getHandler(div).initialize(スケジュール履歴情報);
        ViewStateHolder.put(ViewStateKeys.スケジュール履歴情報, (Serializable) スケジュール履歴情報);
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
        getHandler(div).set確定処理();
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
        RString 保存の確認Flag = new RString(UrQuestionMessages.保存の確認.getMessage().getCode());
        RString 処理実行の確認Flag = new RString(UrQuestionMessages.処理実行の確認.getMessage().getCode());

        if (!保存の確認Flag.equals(ResponseHolder.getMessageCode())
                && !処理実行の確認Flag.equals(ResponseHolder.getMessageCode())) {
            QuestionMessage message = new QuestionMessage(UrQuestionMessages.保存の確認.getMessage().getCode(),
                    UrQuestionMessages.保存の確認.getMessage().evaluate());
            return ResponseData.of(div).addMessage(message).respond();
        }
        if (new RString(UrQuestionMessages.保存の確認.getMessage().getCode())
                .equals(ResponseHolder.getMessageCode())
                && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            try {
                getHandler(div).save処理(スケジュール履歴情報List, true);
            } catch (ApplicationException e) {
                throw new ApplicationException(e.getMessage());
            }
            return ResponseData.of(div).setState(DBC6100011StateName.完了メッセージ);
        } else if (new RString(UrQuestionMessages.処理実行の確認.getMessage().getCode())
                .equals(ResponseHolder.getMessageCode())
                && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            try {
                getHandler(div).save処理(スケジュール履歴情報List, false);
            } catch (ApplicationException e) {
                throw new ApplicationException(e.getMessage());
            }
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

    private KyufuTaishoshaScheduleSetteiPanelHandler getHandler(KyufuTaishoshaScheduleSetteiPanelDiv div) {
        return new KyufuTaishoshaScheduleSetteiPanelHandler(div);
    }

    private KyufuTaishoshaScheduleSetteiPanelValidationHandler getValidationHandler(KyufuTaishoshaScheduleSetteiPanelDiv div) {
        return new KyufuTaishoshaScheduleSetteiPanelValidationHandler(div);
    }
}
