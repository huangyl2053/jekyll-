/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.controller.commonchilddiv.kyufugengaku1go;

import jp.co.ndensan.reams.db.dbd.divcontroller.entity.commonchilddiv.kyufugengaku1go.KyufuGengaku1Go.KyufuGengaku1GoDiv;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.commonchilddiv.kyufugengaku1go.KyufuGengaku1Go.KyufuGengaku1GoHandler;
import jp.co.ndensan.reams.ur.urz.definition.message.UrWarningMessages;
import jp.co.ndensan.reams.uz.uza.core.ui.response.IDialogResponse;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 *
 * 【共有子Div】1号給付額減額ダイアログのcontrolクラスです。
 *
 * @reamsid_L DBD-3620-043 panxiaobo
 */
public class KyufuGengaku1Go {

    /**
     * 画面初期化です。
     *
     * @param div KyufuGengaku1GoDiv
     * @return ResponseData<KyufuGengaku1GoDiv>
     */
    public ResponseData<KyufuGengaku1GoDiv> onLoad(KyufuGengaku1GoDiv div) {
        Message message = getHandler(div).onLoad();
        if (message != null) {
            return ResponseData.of(div).addMessage(message).respond();
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 「取消」ボタンを押下します。
     *
     * @param div KyufuGengaku1GoDiv
     * @return ResponseData<KyufuGengaku1GoDiv>
     */
    public ResponseData<KyufuGengaku1GoDiv> onClick_BtnTorikeshi(KyufuGengaku1GoDiv div) {
        IDialogResponse dialogResponse = ResponseData.of(div);
        if (!ResponseHolder.isReRequest() && getHandler(div).onClick_BtnTorikeshi()) {
            return dialogResponse.addMessage(UrWarningMessages.未保存情報の破棄確認.getMessage().replace("処理中のデータ")).respond();
        }
        return dialogResponse.dialogNGClose();
    }

    /**
     * 「確定」ボタンを押下します。
     *
     * @param div KyufuGengaku1GoDiv
     * @return ResponseData<KyufuGengaku1GoDiv>
     */
    public ResponseData<KyufuGengaku1GoDiv> onClick_BtnKakutei(KyufuGengaku1GoDiv div) {
        ResponseData<KyufuGengaku1GoDiv> response = new ResponseData();
        IDialogResponse dialogResponse = ResponseData.of(div);
        ValidationMessageControlPairs pairs = getHandler(div).onClick_BtnKakutei();
        if (pairs.iterator().hasNext()) {
            return dialogResponse.addValidationMessages(pairs).respond();
        }
        response.data = div;
        return dialogResponse.dialogOKClose();
    }

    /**
     * 滞納状況ダイアログを開く前に実行されるイベントを設定します。
     *
     * @param div KyufuGengaku1GoDiv
     * @return ResponseData<KyufuGengaku1GoDiv>
     */
    public ResponseData<KyufuGengaku1GoDiv> onBeforeOpenDialog_BtnTainoJokyo(KyufuGengaku1GoDiv div) {
        getHandler(div).onBeforeOpenDialog_BtnTainoJokyo();
        return ResponseData.of(div).respond();
    }

    /**
     * 滞納状況ダイアログが確定クローズイベントで閉じられたときにダイアログが完全に閉じた後に実行されるイベントを設定します。
     *
     * @param div KyufuGengaku1GoDiv
     * @return ResponseData<KyufuGengaku1GoDiv>
     */
    public ResponseData<KyufuGengaku1GoDiv> onOkClose_BtnTainoJokyo(KyufuGengaku1GoDiv div) {
        getHandler(div).onOkClose_BtnTainoJokyo();
        return ResponseData.of(div).respond();
    }

    private KyufuGengaku1GoHandler getHandler(KyufuGengaku1GoDiv div) {
        return new KyufuGengaku1GoHandler(div);
    }
}
