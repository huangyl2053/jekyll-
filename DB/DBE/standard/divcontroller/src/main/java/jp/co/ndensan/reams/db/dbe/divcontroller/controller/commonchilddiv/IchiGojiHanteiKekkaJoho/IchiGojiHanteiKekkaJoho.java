/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.controller.commonchilddiv.IchiGojiHanteiKekkaJoho;

import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.ichigojihanteikekkajoho.IchiGojiHanteiKekkaJohoMapperParameter;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.commonchilddiv.IchiGojiHanteiKekkaJoho.IchiGojiHanteiKekkaJohoDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.commonchilddiv.IchiGojiHanteiKekkaJoho.IchiGojiHanteiKekkaJohoHandler;
import jp.co.ndensan.reams.db.dbe.service.core.ichigojihanteikekkajoho.IchiGojiHanteiKekkaJohoFinder;
import jp.co.ndensan.reams.db.dbe.service.core.ichigojihanteikekkajoho.IchiGojiHanteiKekkaJohoSearch;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.message.QuestionMessage;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;

/**
 * 共有子Div 一五次判定結果情報のイベントを定義したDivControllerです。
 *
 * @reamsid_L DBE-3000-290 chenxiangyu
 */
public class IchiGojiHanteiKekkaJoho {

    private static final RString モード_登録 = new RString("登録");

    /**
     * 共通子DIVを初期化します。
     *
     * @param div 画面の情報
     * @return ResponseData<IchiGojiHanteiKekkaJohoDiv>
     */
    public ResponseData<IchiGojiHanteiKekkaJohoDiv> onLoad(IchiGojiHanteiKekkaJohoDiv div) {
        RString 申請書管理番号 = div.getHdnShinseishoKanriNo();
        RString モード = div.getHdnMode();
        IchiGojiHanteiKekkaJohoMapperParameter parameter = IchiGojiHanteiKekkaJohoMapperParameter.createParamter(申請書管理番号);
        getHandler(div).onLoad(IchiGojiHanteiKekkaJohoFinder.createInstance().select一五次判定結果情報(parameter, モード));
        return ResponseData.of(div).respond();
    }

    /**
     * 戻る　ボタン押下します。
     *
     * @param div 画面の情報
     * @return ResponseData<IchiGojiHanteiKekkaJohoDiv>
     */
    public ResponseData<IchiGojiHanteiKekkaJohoDiv> onClick_btnBack(IchiGojiHanteiKekkaJohoDiv div) {
        return ResponseData.of(div).respond();
    }

    /**
     * 確定　ボタン押下します。
     *
     * @param div 画面の情報
     * @return ResponseData<IchiGojiHanteiKekkaJohoDiv>
     */
    public ResponseData<IchiGojiHanteiKekkaJohoDiv> onClick_btnKakutei(IchiGojiHanteiKekkaJohoDiv div) {
        if (!ResponseHolder.isReRequest()) {
            QuestionMessage message = new QuestionMessage(UrQuestionMessages.確定の確認.getMessage().getCode(),
                    UrQuestionMessages.確定の確認.getMessage().evaluate());
            return ResponseData.of(div).addMessage(message).respond();
        }
        if (new RString(UrQuestionMessages.確定の確認.getMessage().getCode()).equals(ResponseHolder.getMessageCode())
                && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            RString モード = div.getHdnMode();
            if (モード_登録.equals(モード)) {
                getHandler(div).呼び出し元画面への戻り値(IchiGojiHanteiKekkaJohoSearch.createInstance().
                        getIchiGojiHanteiKekkaJoho(div.getHdnShinseishoKanriNo()));
            }
            return ResponseData.of(div).dialogOKClose();
        }
        return ResponseData.of(div).respond();
    }

    private IchiGojiHanteiKekkaJohoHandler getHandler(IchiGojiHanteiKekkaJohoDiv div) {
        return new IchiGojiHanteiKekkaJohoHandler(div);
    }
}
