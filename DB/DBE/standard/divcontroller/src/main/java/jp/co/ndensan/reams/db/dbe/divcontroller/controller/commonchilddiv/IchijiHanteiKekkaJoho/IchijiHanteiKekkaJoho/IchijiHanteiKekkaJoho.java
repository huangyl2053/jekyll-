/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.controller.commonchilddiv.IchijiHanteiKekkaJoho.IchijiHanteiKekkaJoho;

import jp.co.ndensan.reams.db.dbe.divcontroller.entity.commonchilddiv.IchijiHanteiKekkaJoho.IchijiHanteiKekkaJoho.IchijiHanteiKekkaJohoDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.commonchilddiv.IchijiHanteiKekkaJoho.IchijiHanteiKekkaJoho.IchijiHanteiKekkaJohoHandler;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.message.QuestionMessage;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;

/**
 *
 * 共有子Div　一次判定結果情報　のイベントを定義したDivControllerです。
 */
public class IchijiHanteiKekkaJoho {

    /**
     * 共通子DIVを初期化します。
     *
     * @param div IchijiHanteiKekkaJohoDiv
     * @return ResponseData<IchijiHanteiKekkaJohoDiv>
     */
    public ResponseData<IchijiHanteiKekkaJohoDiv> onLoad(IchijiHanteiKekkaJohoDiv div) {
        getHandler(div).onLoad();
        return ResponseData.of(div).respond();
    }

    /**
     * 戻る　ボタン押下します。
     *
     * @param div IchijiHanteiKekkaJohoDiv
     * @return ResponseData<IchijiHanteiKekkaJohoDiv>
     */
    public ResponseData<IchijiHanteiKekkaJohoDiv> onClick_btnBack(IchijiHanteiKekkaJohoDiv div) {
        return ResponseData.of(div).dialogOKClose();
    }

    /**
     * 確定　ボタン押下します。
     *
     * @param div IchijiHanteiKekkaJohoDiv
     * @return ResponseData<IchijiHanteiKekkaJohoDiv>
     */
    public ResponseData<IchijiHanteiKekkaJohoDiv> onClick_btnKakutei(IchijiHanteiKekkaJohoDiv div) {

        if (!ResponseHolder.isReRequest()) {
            QuestionMessage message = new QuestionMessage(UrQuestionMessages.確定の確認.getMessage().getCode(),
                    UrQuestionMessages.確定の確認.getMessage().evaluate());
            return ResponseData.of(div).addMessage(message).respond();
        }
        if (new RString(UrQuestionMessages.確定の確認.getMessage().getCode()).equals(ResponseHolder.getMessageCode())
                && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            getHandler(div).呼び出し元画面への戻り値();
            return ResponseData.of(div).dialogOKClose();
        }
        return ResponseData.of(div).respond();
    }

    private IchijiHanteiKekkaJohoHandler getHandler(IchijiHanteiKekkaJohoDiv div) {
        return new IchijiHanteiKekkaJohoHandler(div);
    }
}
