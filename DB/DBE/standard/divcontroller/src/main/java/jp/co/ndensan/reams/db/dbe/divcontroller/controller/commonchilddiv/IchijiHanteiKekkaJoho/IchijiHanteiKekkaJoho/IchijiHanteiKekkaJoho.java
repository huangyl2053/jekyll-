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
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.util.serialization.DataPassingConverter;

/**
 *
 * 共有子Div　一次判定結果情報　のイベントを定義したDivControllerです。
 *
 * @reamsid_L DBE-3000-220 huangh
 */
public class IchijiHanteiKekkaJoho {

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
