/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.controller.parentdiv.DBE5710002;

import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5710002.ImagePanelDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE5710002.ImagePanelValidationHandler;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 要介護認定イメージ情報出力のクラスです。
 *
 * @reamsid_L DBE-1670-011 wangxiaodong
 */
public class ImagePanel {

    /**
     * 要介護認定イメージ情報出力画面をloadします。
     *
     * @param div 要介護認定イメージ情報出力画面
     * @return ResponseData
     */
    public ResponseData<ImagePanelDiv> onLoad(ImagePanelDiv div) {
        ResponseData<ImagePanelDiv> response = new ResponseData<>();
        response.data = div;
        return response;
    }

    /**
     * イメージファイルをdownLoadします。
     *
     * @param div 要介護認定イメージ情報出力画面
     * @return ResponseData
     */
    public ResponseData<ImagePanelDiv> downLoad(ImagePanelDiv div) {
        ValidationMessageControlPairs controlPairs = new ImagePanelValidationHandler(div).do事前チェック();
        if (controlPairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(controlPairs).respond();
        }
        if (!ResponseHolder.isReRequest()) {
            return ResponseData.of(div).addMessage(UrQuestionMessages.確認_汎用.getMessage().replace("イメージをダウンロードします。")).respond();
        }
        if (new RString(UrQuestionMessages.確認_汎用.getMessage().getCode()).equals(ResponseHolder.getMessageCode())
                && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            // TODO  ファイルdownLoad処理

            //            ReadOnlySharedFileEntryDescriptor.fromDescriptor(null)
            return ResponseData.of(div).respond();
        }
        return ResponseData.of(div).respond();
    }

}
