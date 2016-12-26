/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.controller.commonchilddiv.IchijiHanteiKekkaJoho.IchijiHanteiKekkaJoho;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.ichijihanteiresult.IchijiHanteiKekkaResultConveter;
import jp.co.ndensan.reams.db.dbe.business.core.ninteishinseijoho.ichijihanteikekkajoho.IchijiHanteiShoriKekka;
import jp.co.ndensan.reams.db.dbe.definition.message.DbeErrorMessages;
import jp.co.ndensan.reams.db.dbe.definition.message.DbeInformationMessages;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.commonchilddiv.IchijiHanteiKekkaJoho.IchijiHanteiKekkaJoho.IchijiHanteiKekkaJohoDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.commonchilddiv.IchijiHanteiKekkaJoho.IchijiHanteiKekkaJoho.IchijiHanteiKekkaJohoHandler;
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
 *
 * 共有子Div　一次判定結果情報　のイベントを定義したDivControllerです。
 *
 * @reamsid_L DBE-3000-220 huangh
 */
public class IchijiHanteiKekkaJoho {

    /**
     * 共通子DIVを初期化します。
     *
     * @param div IchijiHanteiKekkaJohoDiv
     * @return ResponseData<IchijiHanteiKekkaJohoDiv>
     */
    public ResponseData<IchijiHanteiKekkaJohoDiv> onLoad(IchijiHanteiKekkaJohoDiv div) {

        IchijiHanteiKekkaJohoHandler handler = getHandler(div);
        ShinseishoKanriNo shinseishoKanriNo = handler.get申請書管理番号();
        ModeType modeType = handler.getモード();

        if (shinseishoKanriNo == null || shinseishoKanriNo.isEmpty()) {
            handler.setStateOfIchijiHanteiKekka(ModeType.SHOKAI_MODE);
            throw new ApplicationException(UrErrorMessages.設定不可.getMessage().replace("申請書管理番号が受け取れなかった"));
        }

        handler.initializeDdl();

        if (!RString.isNullOrEmpty(div.getIchijiHanteiKekka())) {
            jp.co.ndensan.reams.db.dbe.business.core.ninteishinseijoho.ichijihanteikekkajoho.IchijiHanteiKekkaJoho hanteiKekka
                    = DataPassingConverter.deserialize(div.getIchijiHanteiKekka(),
                            jp.co.ndensan.reams.db.dbe.business.core.ninteishinseijoho.ichijihanteikekkajoho.IchijiHanteiKekkaJoho.class);
            handler.initialize(hanteiKekka, modeType);
        } else {
            handler.initialize(shinseishoKanriNo, modeType);
        }

        if (ModeType.ADD_MODE.equals(modeType)) {
            handler.create一次判定引数(shinseishoKanriNo);
        }

        return ResponseData.of(div).respond();
    }

    /**
     * 戻る　ボタン押下します。
     *
     * @param div IchijiHanteiKekkaJohoDiv
     * @return ResponseData<IchijiHanteiKekkaJohoDiv>
     */
    public ResponseData<IchijiHanteiKekkaJohoDiv> onClick_btnBack(IchijiHanteiKekkaJohoDiv div) {
        return ResponseData.of(div).respond();
    }

    /**
     * 確定　ボタン押下します。
     *
     * @param div IchijiHanteiKekkaJohoDiv
     * @return ResponseData<IchijiHanteiKekkaJohoDiv>
     */
    public ResponseData<IchijiHanteiKekkaJohoDiv> onClick_btnKakutei(IchijiHanteiKekkaJohoDiv div) {

        if (!ResponseHolder.isReRequest()) {
            if (RString.isNullOrEmpty(div.getIchijiHanteiKekka())) {
                return ResponseData.of(div).addMessage(DbeErrorMessages.一次判定未処理.getMessage()).respond();
            }

            QuestionMessage message = new QuestionMessage(UrQuestionMessages.確定の確認.getMessage().getCode(),
                    UrQuestionMessages.確定の確認.getMessage().evaluate());
            return ResponseData.of(div).addMessage(message).respond();
        }

        if (new RString(UrQuestionMessages.確定の確認.getMessage().getCode()).equals(ResponseHolder.getMessageCode())
                && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {

            jp.co.ndensan.reams.db.dbe.business.core.ninteishinseijoho.ichijihanteikekkajoho.IchijiHanteiKekkaJoho hanteiKekka
                    = DataPassingConverter.deserialize(div.getIchijiHanteiKekka(),
                            jp.co.ndensan.reams.db.dbe.business.core.ninteishinseijoho.ichijihanteikekkajoho.IchijiHanteiKekkaJoho.class);

            ModeType modeType = getHandler(div).getモード();

            if (ModeType.SHOKAI_MODE.equals(modeType)) {
                RString 一次判定結果 = div.getDdlIchijiHanteiKekka().getSelectedValue();
                ViewStateHolder.put(ViewStateKeys.一次判定結果, 一次判定結果);
            } else if (ModeType.ADD_MODE.equals(modeType)) {
                set一次判定結果情報(hanteiKekka, div);
            }

            return ResponseData.of(div).dialogOKClose();
        }
        return ResponseData.of(div).respond();
    }

    private void set一次判定結果情報(jp.co.ndensan.reams.db.dbe.business.core.ninteishinseijoho.ichijihanteikekkajoho.IchijiHanteiKekkaJoho hanteiKekka,
            IchijiHanteiKekkaJohoDiv div) {
        jp.co.ndensan.reams.db.dbe.business.core.ninteishinseijoho.ichijihanteikekkajoho.IchijiHanteiKekkaJoho result
                = getHandler(div).呼び出し元画面への戻り値(hanteiKekka);
        if (result != null) {
            div.setIchijiHanteiKekka(DataPassingConverter.serialize(result));
            //TODO n8178 城間 もともとのプログラムがViewStateをあてにしていた為、残している。通常はDataPassingから受け取るようにする方が良い。
            ViewStateHolder.put(ViewStateKeys.一次判定結果情報, result);
        }

    }

    private IchijiHanteiKekkaJohoHandler getHandler(IchijiHanteiKekkaJohoDiv div) {
        return new IchijiHanteiKekkaJohoHandler(div);
    }

    /**
     * 一次判定ボタンをクリックした場合の処理を実行します。
     *
     * @param div IchijiHanteiKekkaJohoDiv
     * @return ResponseData<IchijiHanteiKekkaJohoDiv>
     */
    public ResponseData<IchijiHanteiKekkaJohoDiv> btnAfterIchijiHantei(IchijiHanteiKekkaJohoDiv div) {

        if (ResponseHolder.isReRequest()) {
            return ResponseData.of(div).respond();
        }

        RString result = div.getHanteiResult();
        if (RString.isNullOrEmpty(result)) {
            return ResponseData.of(div).addMessage(DbeErrorMessages.一次判定失敗.getMessage()).respond();
        }

        IchijiHanteiKekkaJohoHandler handler = getHandler(div);
        ShinseishoKanriNo shinseishoKanriNo = handler.get申請書管理番号();
        IchijiHanteiKekkaResultConveter converter = new IchijiHanteiKekkaResultConveter(shinseishoKanriNo, result);

        if (converter.isHanteiKekkaError()) {
            return ResponseData.of(div).addMessage(DbeErrorMessages.一次判定失敗.getMessage()).respond();
        }

        List<IchijiHanteiShoriKekka> kekkaList
                = converter.convert();
        if (kekkaList == null || kekkaList.isEmpty()) {
            return ResponseData.of(div).addMessage(DbeErrorMessages.一次判定失敗.getMessage()).respond();
        }

        IchijiHanteiShoriKekka kekkaJoho = kekkaList.get(0);

        div.setIchijiHanteiKekka(DataPassingConverter.serialize(kekkaJoho.getHanteiKekka()));
        handler.setIchijiHanteiKekka(kekkaJoho.getHanteiKekka());
        return ResponseData.of(div).addMessage(DbeInformationMessages.一次判定処理完了.getMessage()).respond();
    }

}
