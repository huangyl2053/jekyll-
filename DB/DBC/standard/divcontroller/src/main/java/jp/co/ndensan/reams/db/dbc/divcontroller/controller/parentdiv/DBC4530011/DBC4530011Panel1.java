/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.DBC4530011;

import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC4530011.DBC4530011Panel1Div;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC4530011.DBC4530011StateName;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC4530011.DBC4530011TransitionEventName;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC4530011.DBC4530011Panel1Handler;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC4530011.DBC4530011Panel1ValidationHandler;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 高額合算自己負担額補正・支払場所Divを制御します。
 *
 * @reamsid_L DBC-3360-010 xuxin
 */
public class DBC4530011Panel1 {

    private DBC4530011Panel1Handler getHandler(DBC4530011Panel1Div div) {
        return new DBC4530011Panel1Handler(div);
    }

    private DBC4530011Panel1ValidationHandler getValidationHandler(DBC4530011Panel1Div div) {
        return new DBC4530011Panel1ValidationHandler(div);
    }

    /**
     * 高額合算自己負担額補正・支払場所作成画面初期化を処理します。
     *
     * @param div DBC4530011Panel1Div
     * @return ResponseData<DBC4530011Panel1Div>
     */
    public ResponseData<DBC4530011Panel1Div> onLoad(DBC4530011Panel1Div div) {
        getHandler(div).initialize();
        return ResponseData.of(div).setState(DBC4530011StateName.初期登録状態);
    }

    /**
     * 「保存する」ボタン押下時のイベントメソッドです。
     *
     * @param div DBC4530011Panel1Div
     * @return ResponseData<DBC4530011Panel1Div>
     */
    public ResponseData<DBC4530011Panel1Div> onClick_btnSave(DBC4530011Panel1Div div) {

        ValidationMessageControlPairs valid = getValidationHandler(div).validate();
        if (valid.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(valid).respond();
        }

        if (!ResponseHolder.isReRequest()) {
            return ResponseData.of(div).addMessage(UrQuestionMessages.保存の確認.getMessage()).respond();
        }
        if (MessageDialogSelectedResult.Yes.equals(ResponseHolder.getButtonType())) {
            getHandler(div).config保存();
            return ResponseData.of(div).setState(DBC4530011StateName.完了状態);
        }
        return ResponseData.of(div).setState(DBC4530011StateName.初期登録状態);
    }

    /**
     * 「戻る」ボタン押下時のイベントメソッドです。
     *
     * @param div DBC4530011Panel1Div
     * @return ResponseData<DBC4530011Panel1Div>
     */
    public ResponseData<DBC4530011Panel1Div> onClick_btnBack(DBC4530011Panel1Div div) {
        return ResponseData.of(div).forwardWithEventName(DBC4530011TransitionEventName.処理完了).respond();
    }

    /**
     * 「完了する」ボタン押下時のイベントメソッドです。
     *
     * @param div DBC4530011Panel1Div
     * @return ResponseData<DBC4530011Panel1Div>
     */
    public ResponseData<DBC4530011Panel1Div> onClick_btnComplete(DBC4530011Panel1Div div) {
        return ResponseData.of(div).forwardWithEventName(DBC4530011TransitionEventName.処理完了).respond();
    }

}
