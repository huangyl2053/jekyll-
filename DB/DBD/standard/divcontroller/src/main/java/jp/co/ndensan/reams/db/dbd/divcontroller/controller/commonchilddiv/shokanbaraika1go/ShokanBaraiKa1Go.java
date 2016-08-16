/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.controller.commonchilddiv.shokanbaraika1go;

import jp.co.ndensan.reams.db.dbd.divcontroller.entity.commonchilddiv.shokanbaraika1go.ShokanBaraiKa1Go.ShokanBaraiKa1GoDiv;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.commonchilddiv.shokanbaraika1go.ShokanBaraiKa1Go.ShokanBaraiKa1GoHandler;
import jp.co.ndensan.reams.ur.urz.definition.message.UrWarningMessages;
import jp.co.ndensan.reams.uz.uza.core.ui.response.IDialogResponse;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 *
 * 【共有子Div】 1号償還払い化ダイアログのDivControllerです。
 *
 * @reamsid_L DBD-3620-041 mawy
 */
public class ShokanBaraiKa1Go {

    /**
     * 画面初期化です。
     *
     * @param div ShokanBaraiKa1GoDiv
     * @return ResponseData<ShokanBaraiKa1GoDiv>
     */
    public ResponseData<ShokanBaraiKa1GoDiv> onLoad(ShokanBaraiKa1GoDiv div) {
        getHandler(div).onLoad();
        return ResponseData.of(div).respond();
    }

    /**
     * 「取消」ボタンを押下します。
     *
     * @param div ShokanBaraiKa1GoDiv
     * @return ResponseData<ShokanBaraiKa1GoDiv>
     */
    public ResponseData<ShokanBaraiKa1GoDiv> onClick_BtnTorikeshi(ShokanBaraiKa1GoDiv div) {
        IDialogResponse dialogResponse = ResponseData.of(div);
        if (!ResponseHolder.isReRequest() && getHandler(div).onClick_BtnTorikeshi()) {
            return dialogResponse.addMessage(UrWarningMessages.未保存情報の破棄確認.getMessage().replace("処理中のデータ")).respond();
        }
        if (ResponseHolder.getButtonType() == MessageDialogSelectedResult.No) {
            return dialogResponse.respond();
        }
        return dialogResponse.dialogNGClose();
    }

    /**
     * 「確定」ボタンを押下します。
     *
     * @param div ShokanBaraiKa1GoDiv
     * @return ResponseData<ShokanBaraiKa1GoDiv>
     */
    public ResponseData<ShokanBaraiKa1GoDiv> onClick_BtnKakutei(ShokanBaraiKa1GoDiv div) {
        ValidationMessageControlPairs pairs = getHandler(div).onClick_BtnKakutei();
        if (pairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(pairs).respond();
        }
        return ResponseData.of(div).dialogOKClose();
    }

    /**
     * 滞納状況ダイアログを開く前に実行されるイベントを設定します。
     *
     * @param div ShokanBaraiKa1GoDiv
     * @return ResponseData<ShokanBaraiKa1GoDiv>
     */
    public ResponseData<ShokanBaraiKa1GoDiv> onBeforeOpenDialog_BtnTainoJokyo(ShokanBaraiKa1GoDiv div) {
        getHandler(div).onBeforeOpenDialog_BtnTainoJokyo();
        return ResponseData.of(div).respond();
    }

    /**
     * 滞納状況ダイアログが確定クローズイベントで閉じられたときにダイアログが完全に閉じた後に実行されるイベントを設定します。
     *
     * @param div ShokanBaraiKa1GoDiv
     * @return ResponseData<ShokanBaraiKa1GoDiv>
     */
    public ResponseData<ShokanBaraiKa1GoDiv> onOkClose_BtnTainoJokyo(ShokanBaraiKa1GoDiv div) {
        getHandler(div).onOkClose_BtnTainoJokyo();
        return ResponseData.of(div).respond();
    }

    private ShokanBaraiKa1GoHandler getHandler(ShokanBaraiKa1GoDiv div) {
        return new ShokanBaraiKa1GoHandler(div);
    }
}
