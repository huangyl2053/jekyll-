/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.controller.commonchilddiv.ichijisashitome2go;

import jp.co.ndensan.reams.db.dbd.divcontroller.entity.commonchilddiv.ichijisashitome2go.IchijiSashitome2Go.IchijiSashitome2GoDiv;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.commonchilddiv.ichijisashitome2go.IchijiSashitome2Go.IchijiSashitome2GoHandler;
import jp.co.ndensan.reams.ur.urz.definition.message.UrWarningMessages;
import jp.co.ndensan.reams.uz.uza.core.ui.response.IDialogResponse;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 *
 * 【共有子Div】2号一時差止ダイアログのcontrolクラスです。
 *
 * @reamsid_L DBD-3620-045 panxiaobo
 */
public class IchijiSashitome2Go {

    /**
     * 画面初期化です。
     *
     * @param div IchijiSashitome2GoDiv
     * @return ResponseData<IchijiSashitome2GoDiv>
     */
    public ResponseData<IchijiSashitome2GoDiv> onLoad(IchijiSashitome2GoDiv div) {
        getHandler(div).onLoad();
        return ResponseData.of(div).respond();
    }

    /**
     * 「取消」ボタンを押下します。
     *
     * @param div IchijiSashitome2GoDiv
     * @return ResponseData<IchijiSashitome2GoDiv>
     */
    public ResponseData<IchijiSashitome2GoDiv> onClick_BtnTorikeshi(IchijiSashitome2GoDiv div) {
        IDialogResponse dialogResponse = ResponseData.of(div);
        if (!ResponseHolder.isReRequest() && getHandler(div).onClick_BtnTorikeshi()) {
            return dialogResponse.addMessage(UrWarningMessages.未保存情報の破棄確認.getMessage().replace("処理中のデータ")).respond();
        }
        return dialogResponse.dialogNGClose();
    }

    /**
     * 「確定」ボタンを押下します。
     *
     * @param div IchijiSashitome2GoDiv
     * @return ResponseData<IchijiSashitome2GoDiv>
     */
    public ResponseData<IchijiSashitome2GoDiv> onClick_BtnKakutei(IchijiSashitome2GoDiv div) {
        IDialogResponse dialogResponse = ResponseData.of(div);
        ValidationMessageControlPairs pairs = getHandler(div).onClick_BtnKakutei();
        if (pairs.iterator().hasNext()) {
            return dialogResponse.addValidationMessages(pairs).respond();
        }
        return dialogResponse.dialogOKClose();
    }

    private IchijiSashitome2GoHandler getHandler(IchijiSashitome2GoDiv div) {
        return new IchijiSashitome2GoHandler(div);
    }
}
