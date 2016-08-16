/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.controller.commonchilddiv.menjokaijosaitennyu;

import jp.co.ndensan.reams.db.dbd.divcontroller.entity.commonchilddiv.menjokaijosaitennyu.MenjoKaijoSaiTennyu.MenjoKaijoSaiTennyuDiv;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.commonchilddiv.menjokaijosaitennyu.MenjoKaijoSaiTennyu.MenjoKaijoSaiTennyuHandler;
import jp.co.ndensan.reams.ur.urz.definition.message.UrWarningMessages;
import jp.co.ndensan.reams.uz.uza.core.ui.response.IDialogResponse;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 *
 * 【共有子Div】 免除解除・再転入ダイアログのDivControllerです。
 *
 * @reamsid_L DBD-3620-044 panxiaobo
 */
public class MenjoKaijoSaiTennyu {

    /**
     * 画面初期化です。
     *
     * @param div ShokanBaraiKa1GoDiv
     * @return ResponseData<MenjoKaijoSaiTennyuDiv>
     */
    public ResponseData<MenjoKaijoSaiTennyuDiv> onLoad(MenjoKaijoSaiTennyuDiv div) {
        Message message = getHandler(div).onLoad();
        if (message != null) {
            return ResponseData.of(div).addMessage(message).respond();
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 選択選択アイコンです。
     *
     * @param div ShokanBaraiKa1GoDiv
     * @return ResponseData<MenjoKaijoSaiTennyuDiv>
     */
    public ResponseData<MenjoKaijoSaiTennyuDiv> selectedItem(MenjoKaijoSaiTennyuDiv div) {
        getHandler(div).selectedItem();
        return ResponseData.of(div).respond();

    }

    /**
     * 「閉じる」ボタン。
     *
     * @param div ShokanBaraiKa1GoDiv
     * @return ResponseData<MenjoKaijoSaiTennyuDiv>
     */
    public ResponseData<MenjoKaijoSaiTennyuDiv> onClick_btnToJiRu(MenjoKaijoSaiTennyuDiv div) {
        IDialogResponse dialogResponse = ResponseData.of(div);
        getHandler(div).onClick_btnToJiRu();
        return dialogResponse.dialogOKClose();

    }

    /**
     * 「取消」ボタンを押下します。
     *
     * @param div ShokanBaraiKa1GoDiv
     * @return ResponseData<ShokanBaraiKa1GoDiv>
     */
    public ResponseData<MenjoKaijoSaiTennyuDiv> onClick_BtnTorikeshi(MenjoKaijoSaiTennyuDiv div) {
        if (!ResponseHolder.isReRequest() && getHandler(div).onClick_BtnTorikeshi()) {
            return ResponseData.of(div).addMessage(UrWarningMessages.未保存情報の破棄確認.getMessage().replace("処理中のデータ")).respond();
        }
        div.getBtnTorikeshi().setDisabled(true);
        div.getBtnKakutei().setDisabled(true);
        div.getDgMenjoKaijoOrSaitennyu().getClickedItem().setJotai(new RString("修正"));
        return ResponseData.of(div).respond();
    }

    /**
     * 「確定」ボタンを押下します。
     *
     * @param div ShokanBaraiKa1GoDiv
     * @return ResponseData<ShokanBaraiKa1GoDiv>
     */
    public ResponseData<MenjoKaijoSaiTennyuDiv> onClick_BtnKakutei(MenjoKaijoSaiTennyuDiv div) {
        ResponseData<MenjoKaijoSaiTennyuDiv> response = new ResponseData();
        ValidationMessageControlPairs pairs = getHandler(div).onClick_BtnKakutei();
        if (pairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(pairs).respond();
        }
        response.data = div;
        return ResponseData.of(div).dialogOKClose();
    }

    /**
     * 滞納状況ダイアログを開く前に実行されるイベントを設定します。
     *
     * @param div ShokanBaraiKa1GoDiv
     * @return ResponseData<ShokanBaraiKa1GoDiv>
     */
    public ResponseData<MenjoKaijoSaiTennyuDiv> onBeforeOpenDialog_BtnTainoJokyo(MenjoKaijoSaiTennyuDiv div) {
        getHandler(div).onBeforeOpenDialog_BtnTainoJokyo();
        return ResponseData.of(div).respond();
    }

    /**
     * 滞納状況ダイアログのOKボタンを押した後のメソッドです。
     *
     * @param div MenjoKaijoSaiTennyuDiv
     * @return ResponseData
     */
    public ResponseData<MenjoKaijoSaiTennyuDiv> onOkClose_BtnTainoJokyo(MenjoKaijoSaiTennyuDiv div) {
        return ResponseData.of(div).respond();
    }

    private MenjoKaijoSaiTennyuHandler getHandler(MenjoKaijoSaiTennyuDiv div) {
        return new MenjoKaijoSaiTennyuHandler(div);
    }
}
