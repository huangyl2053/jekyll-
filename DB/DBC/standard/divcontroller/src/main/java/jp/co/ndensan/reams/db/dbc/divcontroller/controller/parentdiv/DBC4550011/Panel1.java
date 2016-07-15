/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.DBC4550011;

import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC4550011.DBC4550011StateName;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC4550011.DBC4550011TransitionEventName;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC4550011.Panel1Div;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC4550011.Panel1Handler;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;

/**
 * 国保連取込媒体管理Divを制御します。
 *
 * @reamsid_L DBC-3361-010 xuxin
 */
public class Panel1 {

    private Panel1Handler getHandler(Panel1Div div) {
        return new Panel1Handler(div);
    }

    /**
     * 国保連取込媒体管理作成画面初期化を処理します。
     *
     * @param div 国保連取込媒体管理DIV
     * @return ResponseData<Panel1Div>
     */
    public ResponseData<Panel1Div> onLoad(Panel1Div div) {

        getHandler(div).初期登録状態();
        getHandler(div).initialize();
        return ResponseData.of(div).setState(DBC4550011StateName.初期登録状態);
    }

    /**
     * 「保存する」ボタン押下時のイベントメソッドです。
     *
     * @param div Panel1Div
     * @return ResponseData<Panel1Div>
     */
    public ResponseData<Panel1Div> onClick_btnSave(Panel1Div div) {

        if (!ResponseHolder.isReRequest()) {
            return ResponseData.of(div).addMessage(UrQuestionMessages.保存の確認.getMessage()).respond();
        }
        if (MessageDialogSelectedResult.Yes.equals(ResponseHolder.getButtonType())) {
            getHandler(div).config保存();
            return ResponseData.of(div).setState(DBC4550011StateName.完了状態);
        }
        return ResponseData.of(div).setState(DBC4550011StateName.初期登録状態);
    }

    /**
     * 「戻る」ボタン押下時のイベントメソッドです。
     *
     * @param div Panel1Div
     * @return ResponseData<Panel1Div>
     */
    public ResponseData<Panel1Div> onClick_btnBack(Panel1Div div) {

        return ResponseData.of(div).respond();
    }

    /**
     * 「選択」ボタン押下時のイベントメソッドです。
     *
     * @param div Panel1Div
     * @return ResponseData<Panel1Div>
     */
    public ResponseData<Panel1Div> onClick_btnSelect(Panel1Div div) {

        getHandler(div).選択状態();
        getHandler(div).選択ボタン押下時();
        return ResponseData.of(div).setState(DBC4550011StateName.初期登録状態);
    }

    /**
     * 「完了する」ボタン押下時のイベントメソッドです。
     *
     * @param div Panel1Div
     * @return ResponseData<Panel1Div>
     */
    public ResponseData<Panel1Div> onClick_btnComplete(Panel1Div div) {

        return ResponseData.of(div).forwardWithEventName(DBC4550011TransitionEventName.処理完了).respond();
    }

    /**
     * 「実行」ボタン押下時のイベントメソッドです。
     *
     * @param div Panel1Div
     * @return ResponseData<Panel1Div>
     */
    public ResponseData<Panel1Div> onClick_btnSetting(Panel1Div div) {

        getHandler(div).初期登録状態();
        return ResponseData.of(div).setState(DBC4550011StateName.初期登録状態);
    }

    /**
     * 「取消」ボタン押下時のイベントメソッドです。
     *
     * @param div Panel1Div
     * @return ResponseData<Panel1Div>
     */
    public ResponseData<Panel1Div> onClick_btnCancle(Panel1Div div) {

        getHandler(div).初期登録状態();
        getHandler(div).set入力値破棄();
        return ResponseData.of(div).setState(DBC4550011StateName.初期登録状態);
    }

}
