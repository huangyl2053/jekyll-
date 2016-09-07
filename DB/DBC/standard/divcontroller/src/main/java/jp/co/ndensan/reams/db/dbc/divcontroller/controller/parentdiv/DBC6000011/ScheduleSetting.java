/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.DBC6000011;

import jp.co.ndensan.reams.db.dbc.business.core.hihokenshashikakuteisei.SukejuruRirekiJohoListEntity;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC6000011.DBC6000011TransitionEventName;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC6000011.ScheduleSettingDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC6000011.ScheduleSettingHandler;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.ur.urz.definition.message.UrInformationMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.ButtonSelectPattern;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.message.QuestionMessage;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * ScheduleSetting_国保連連携スケジュール設定クラスです。
 *
 * @reamsid_L DBC-2930-010 liuxiaoyu
 */
public class ScheduleSetting {

    /**
     * 画面初期化
     *
     * @param div 画面div
     *
     * @return ResponseData<ScheduleSettingDiv>
     */
    public ResponseData<ScheduleSettingDiv> onLoad(ScheduleSettingDiv div) {
        RString menuID = ResponseHolder.getMenuID();
        SukejuruRirekiJohoListEntity entity = getHandler(div).onLoad(menuID);
        ViewStateHolder.put(ViewStateKeys.スケジュール履歴情報Entity, entity);
        return ResponseData.of(div).respond();
    }

    /**
     * 「保存しないで戻る」ボタンを押下すると、画面に遷移する。
     *
     * @param div 画面div
     *
     * @return ResponseData<ScheduleSettingDiv>
     */
    public ResponseData<ScheduleSettingDiv> onClick_btnComplete(ScheduleSettingDiv div) {
        return ResponseData.of(div).forwardWithEventName(DBC6000011TransitionEventName.情報送付取込へ戻る).respond();
    }

    /**
     * 「表示」ボタンを押下する。
     *
     * @param div 画面div
     *
     * @return ResponseData<ScheduleSettingDiv>
     */
    public ResponseData<ScheduleSettingDiv> onClick_btnDisplay(ScheduleSettingDiv div) {
        RDate 画面処理年月 = div.getTxtShoriNengetsu().getValue();
        if (画面処理年月 != null) {
            div.getTxtHyojiTaishoNengetsu().setValue(画面処理年月);
            FlexibleYearMonth 処理年月 = new FlexibleYearMonth(画面処理年月.getYearMonth().toDateString());
            getHandler(div).画面表示(処理年月);
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 「保存する」ボタンを押下する。
     *
     * @param div 画面div
     *
     * @return ResponseData<ScheduleSettingDiv>
     */
    public ResponseData<ScheduleSettingDiv> onClick_btnSave(ScheduleSettingDiv div) {
        if (!new RString(UrQuestionMessages.保存の確認.getMessage().getCode()).equals(ResponseHolder.getMessageCode())
                && !new RString(UrInformationMessages.保存終了.getMessage().getCode()).equals(ResponseHolder.getMessageCode())) {
            QuestionMessage 保存の確認MESSAGE = new QuestionMessage(
                    UrQuestionMessages.保存の確認.getMessage().getCode(),
                    UrQuestionMessages.保存の確認.getMessage().evaluate(),
                    ButtonSelectPattern.OKCancel);
            return ResponseData.of(div).addMessage(保存の確認MESSAGE).respond();
        }
        if (new RString(UrQuestionMessages.保存の確認.getMessage().getCode()).equals(ResponseHolder.getMessageCode())
                && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            SukejuruRirekiJohoListEntity entity
                    = ViewStateHolder.get(ViewStateKeys.スケジュール履歴情報Entity, SukejuruRirekiJohoListEntity.class);
            getHandler(div).保存処理(entity);

        }
        if (!new RString(UrInformationMessages.保存終了.getMessage().getCode()).equals(ResponseHolder.getMessageCode())) {
            QuestionMessage 保存終了MESSAGE = new QuestionMessage(
                    UrInformationMessages.保存終了.getMessage().getCode(),
                    UrInformationMessages.保存終了.getMessage().evaluate(),
                    ButtonSelectPattern.OKCancel);
            return ResponseData.of(div).addMessage(保存終了MESSAGE).respond();
        }
        if (new RString(UrInformationMessages.保存終了.getMessage().getCode()).equals(ResponseHolder.getMessageCode())
                && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            return ResponseData.of(div).forwardWithEventName(DBC6000011TransitionEventName.メニューへ戻る).respond();
        }
        return ResponseData.of(div).respond();
    }

    private ScheduleSettingHandler getHandler(ScheduleSettingDiv div) {
        return ScheduleSettingHandler.of(div);
    }
}
