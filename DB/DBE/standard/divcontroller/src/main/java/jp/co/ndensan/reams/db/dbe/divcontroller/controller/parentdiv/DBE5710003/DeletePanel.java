/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.controller.parentdiv.DBE5710003;

import jp.co.ndensan.reams.db.dbe.business.core.yokaigoninteiimagekanri.ImagekanriJoho;
import jp.co.ndensan.reams.db.dbe.definition.core.yokaigoninteiimagekanri.OperationTargets;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5710003.DeletePanelDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE5710003.DeletePanelHandler;
import jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE5710003.ImageDeletor;
import jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE5710003.DeletePanelPresentationHandler;
import jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE5710003.DeletePanelValidationHandler;
import jp.co.ndensan.reams.db.dbe.service.core.yokaigoninteiimagesakujo.YokaigoninteiimagesakujoManager;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.ur.urz.definition.message.UrInformationMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.message.QuestionMessage;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * 要介護認定イメージ情報削除のクラスです。
 *
 * @reamsid_L DBE-1670-012 dingyi
 */
public class DeletePanel {

    /**
     * 要介護認定イメージ情報削除に初期化を設定します。
     *
     * @param div 要介護認定イメージ情報削除Div
     * @return ResponseData
     */
    public ResponseData<DeletePanelDiv> onLoad(DeletePanelDiv div) {
        new DeletePanelPresentationHandler(div).initialize(ViewStateHolder.get(ViewStateKeys.イメージ情報, ImagekanriJoho.class));
        return ResponseData.of(div).respond();
    }

    /**
     * 「削除」ボタンを押下する場合、イメージを削除します。
     *
     * @param div 要介護認定イメージ情報削除Div
     * @return ResponseData
     */
    public ResponseData<DeletePanelDiv> onClick_btnDelete(DeletePanelDiv div) {
        if (!ResponseHolder.isReRequest()) {
            QuestionMessage message = new QuestionMessage(UrQuestionMessages.削除の確認.getMessage().getCode(),
                    UrQuestionMessages.削除の確認.getMessage().evaluate());
            return ResponseData.of(div).addMessage(message).respond();
        }
        if (new RString(UrInformationMessages.削除終了.getMessage().getCode()).equals(ResponseHolder.getMessageCode())
                && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            return ResponseData.of(div).respond();
        }

        ValidationMessageControlPairs controlPairs = getValidationHandler(div).validateInput();
        if (controlPairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(controlPairs).respond();
        }
        ImagekanriJoho imageKanriJoho = ViewStateHolder.get(ViewStateKeys.イメージ情報, ImagekanriJoho.class);
        OperationTargets targets = getHandler(div).toOperationTargets();
        ValidationMessageControlPairs イメージ削除チェック = getValidationHandler(div).validateDeletable(targets, imageKanriJoho);
        if (イメージ削除チェック.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(イメージ削除チェック).respond();
        }
        if (new RString(UrQuestionMessages.削除の確認.getMessage().getCode())
                .equals(ResponseHolder.getMessageCode())
                && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            ImageDeletor.deleteImageFiles(imageKanriJoho, targets);
            YokaigoninteiimagesakujoManager.createInstance().updateOrDelete(imageKanriJoho, targets);
            return ResponseData.of(div).addMessage(UrInformationMessages.削除終了.getMessage()).respond();
        }
        return ResponseData.of(div).respond();
    }

    private static DeletePanelHandler getHandler(DeletePanelDiv div) {
        return new DeletePanelHandler(div);
    }

    private static DeletePanelValidationHandler getValidationHandler(DeletePanelDiv div) {
        return new DeletePanelValidationHandler(div);
    }
}
