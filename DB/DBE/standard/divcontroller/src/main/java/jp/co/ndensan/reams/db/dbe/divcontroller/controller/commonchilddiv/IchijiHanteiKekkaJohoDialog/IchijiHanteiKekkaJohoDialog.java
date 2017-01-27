/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.controller.commonchilddiv.IchijiHanteiKekkaJohoDialog;

import jp.co.ndensan.reams.db.dbe.definition.message.DbeErrorMessages;
import jp.co.ndensan.reams.db.dbe.business.core.ninteishinseijoho.ichijihanteikekkajoho.IchijiHanteiKekkaJoho;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.commonchilddiv.IchijiHanteiKekkaJoho.IchijiHanteiKekkaJoho.IchijiHanteiKekkaJohoDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.commonchilddiv.IchijiHanteiKekkaJoho.IchijiHanteiKekkaJoho.IchijiHanteiKekkaJohoHandler;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.commonchilddiv.IchijiHanteiKekkaJohoDialog.IchijiHanteiKekkaJohoDialog.IchijiHanteiKekkaJohoDialogDiv;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.ModeType;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.message.QuestionMessage;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;
import jp.co.ndensan.reams.uz.uza.util.serialization.DataPassingConverter;

/**
 * 一次判定結果情報ダイアログの処理を定義します。
 *
 * @author n8178
 */
public class IchijiHanteiKekkaJohoDialog {

    /**
     * 共通子DIVを初期化します。
     *
     * @param div IchijiHanteiKekkaJohoDiv
     * @return ResponseData<IchijiHanteiKekkaJohoDiv>
     */
    public ResponseData<IchijiHanteiKekkaJohoDialogDiv> onLoad(IchijiHanteiKekkaJohoDialogDiv div) {

        if (ResponseHolder.isReRequest()) {
            return ResponseData.of(div).respond();
        }

        IchijiHanteiKekkaJohoHandler handler = getHandler(div.get一次判定結果情報Div());
        ShinseishoKanriNo shinseishoKanriNo = handler.get申請書管理番号();
        ModeType modeType = handler.getモード();

        if (shinseishoKanriNo == null || shinseishoKanriNo.isEmpty()) {
            handler.setStateOfIchijiHanteiKekka(ModeType.SHOKAI_MODE);
            div.getBtnKakutei().setDisplayNone(true);
            throw new ApplicationException(UrErrorMessages.設定不可.getMessage().replace("申請書管理番号が受け取れなかった"));
        }

        handler.initializeDdl();

        if (!RString.isNullOrEmpty(div.get一次判定結果情報Div().getIchijiHanteiKekka())) {
            IchijiHanteiKekkaJoho hanteiKekka
                    = DataPassingConverter.deserialize(div.get一次判定結果情報Div().getIchijiHanteiKekka(), IchijiHanteiKekkaJoho.class);
            handler.initialize(hanteiKekka, modeType);
        } else {
            handler.initialize(shinseishoKanriNo, modeType);
        }

        if (ModeType.ADD_MODE.equals(modeType)) {
            div.getBtnKakutei().setDisplayNone(false);
            if (RString.isNullOrEmpty(div.get一次判定結果情報Div().getHanteiArgument()) && !handler.create一次判定引数(shinseishoKanriNo)) {
                handler.setStateOfIchijiHanteiKekka(ModeType.SHOKAI_MODE);

                div.getBtnKakutei().setDisplayNone(true);
                return ResponseData.of(div).addMessage(DbeErrorMessages.一次判定実行不可_申請日.getMessage()).respond();
            }
        }

        return ResponseData.of(div).respond();
    }

    private IchijiHanteiKekkaJohoHandler getHandler(IchijiHanteiKekkaJohoDiv div) {
        return new IchijiHanteiKekkaJohoHandler(div);
    }

    private void setKakuteiButtonDisplayNone(IchijiHanteiKekkaJohoDialogDiv div, boolean isDisplayNone) {
        div.getBtnKakutei().setDisplayNone(isDisplayNone);
    }

    /**
     * 戻る　ボタン押下します。
     *
     * @param div IchijiHanteiKekkaJohoDiv
     * @return ResponseData<IchijiHanteiKekkaJohoDiv>
     */
    public ResponseData<IchijiHanteiKekkaJohoDialogDiv> onClick_btnBack(IchijiHanteiKekkaJohoDialogDiv div) {
        return ResponseData.of(div).respond();
    }

    /**
     * 確定　ボタン押下します。
     *
     * @param div IchijiHanteiKekkaJohoDiv
     * @return ResponseData<IchijiHanteiKekkaJohoDiv>
     */
    public ResponseData<IchijiHanteiKekkaJohoDialogDiv> onClick_btnKakutei(IchijiHanteiKekkaJohoDialogDiv div) {

        if (!ResponseHolder.isReRequest()) {
            if (RString.isNullOrEmpty(div.get一次判定結果情報Div().getIchijiHanteiKekka())) {
                return ResponseData.of(div).addMessage(DbeErrorMessages.一次判定未処理.getMessage()).respond();
            }

            QuestionMessage message = new QuestionMessage(UrQuestionMessages.確定の確認.getMessage().getCode(),
                    UrQuestionMessages.確定の確認.getMessage().evaluate());
            return ResponseData.of(div).addMessage(message).respond();
        }

        if (new RString(UrQuestionMessages.確定の確認.getMessage().getCode()).equals(ResponseHolder.getMessageCode())
                && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {

            jp.co.ndensan.reams.db.dbe.business.core.ninteishinseijoho.ichijihanteikekkajoho.IchijiHanteiKekkaJoho hanteiKekka
                    = DataPassingConverter.deserialize(div.get一次判定結果情報Div().getIchijiHanteiKekka(), IchijiHanteiKekkaJoho.class);

            ModeType modeType = getHandler(div.get一次判定結果情報Div()).getモード();

            if (ModeType.SHOKAI_MODE.equals(modeType)) {
                RString 一次判定結果 = div.get一次判定結果情報Div().getDdlIchijiHanteiKekka().getSelectedValue();
                ViewStateHolder.put(ViewStateKeys.一次判定結果, 一次判定結果);
            } else if (ModeType.ADD_MODE.equals(modeType)) {
                set一次判定結果情報(hanteiKekka, div.get一次判定結果情報Div());
            }

            return ResponseData.of(div).dialogOKClose();
        }
        return ResponseData.of(div).respond();
    }

    private void set一次判定結果情報(IchijiHanteiKekkaJoho hanteiKekka,
            IchijiHanteiKekkaJohoDiv div) {
        IchijiHanteiKekkaJoho result = getHandler(div).呼び出し元画面への戻り値(hanteiKekka);
        if (result != null) {
            div.setIchijiHanteiKekka(DataPassingConverter.serialize(result));
            ViewStateHolder.put(ViewStateKeys.一次判定結果情報, result);
        }

    }
}
