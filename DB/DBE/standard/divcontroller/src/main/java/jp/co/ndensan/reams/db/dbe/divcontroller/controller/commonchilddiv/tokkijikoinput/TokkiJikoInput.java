/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.controller.commonchilddiv.tokkijikoinput;

import jp.co.ndensan.reams.db.dbe.divcontroller.entity.commonchilddiv.TokkiJikoInput.TokkiJikoInput.TokkiJikoInputDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.commonchilddiv.TokkiJikoInput.TokkiJikoInput.TokkiJikoInputHandler;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.commonchilddiv.TokkiJikoInput.TokkiJikoInput.TokkiJikoInputValidationHandler;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrWarningMessages;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.message.QuestionMessage;
import jp.co.ndensan.reams.uz.uza.message.WarningMessage;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 *
 * @author n3423
 */
public class TokkiJikoInput {

    private boolean is特記事項変更;

    private enum DBE2210003Keys {

        入力内容を取り消す用データ
    }

    /**
     * 初期化の処理を表します。
     *
     * @param div 主治医意見書照会Div
     * @return ResponseData
     */
    public ResponseData<TokkiJikoInputDiv> onLoad(TokkiJikoInputDiv div) {
        getHandler(div).onLoad();
        is特記事項変更 = false;
        return ResponseData.of(div).respond();
    }

    /**
     * 「入力する」ボタン押下時の処理を表します。
     *
     * @param div TokkiJikoInputDiv
     * @return ResponseData
     */
    public ResponseData<TokkiJikoInputDiv> onClick_btnInput(TokkiJikoInputDiv div) {
        getHandler(div).onInput();
        getHandler(div).setBtnControlPropertyByInput(true);
        return ResponseData.of(div).focusId(div.getTokkiJikoNyuryoku().getTxtTokkiJiko().getSelectControlID()).respond();
    }

    /**
     * 特記事項群のラジオボタン切り替え処理です。
     *
     * @param div TokkiJikoInputDiv
     * @return ResponseData
     */
    public ResponseData<TokkiJikoInputDiv> onChange_radTokkiJikoGroup(TokkiJikoInputDiv div) {
        div.setHdnRadSelectedKey(div.getTokkiJikoNyuryoku().getRadTokkiJikoGroup().getSelectedKey());
        getHandler(div).setDdlTokkiJikoNo();
        return ResponseData.of(div).respond();
    }

    /**
     * 特記事項番号ドロップダウンリストの切り替え処理です。
     *
     * @param div TokkiJikoInputDiv
     * @return ResponseData
     */
    public ResponseData<TokkiJikoInputDiv> onChange_ddlTokkiJikoNo(TokkiJikoInputDiv div) {
        div.setHdnDdlSelectedKey(div.getTokkiJikoNyuryoku().getDdlTokkiJikoNo().getSelectedKey());
        return ResponseData.of(div).respond();
    }
    
//    /**
//     * 特記事項群のラジオボタン切り替え処理です。
//     *
//     * @param div TokkiJikoInputDiv
//     * @return ResponseData
//     */
//    public ResponseData<TokkiJikoInputDiv> onChange_radTokkiJikoGroup(TokkiJikoInputDiv div) {
//        if (!ResponseHolder.isReRequest()) {
//            if (is特記事項変更) {
//                WarningMessage message = new WarningMessage(UrWarningMessages.未保存情報の破棄確認.getMessage().getCode(),
//                        UrWarningMessages.未保存情報の破棄確認.getMessage().evaluate());
//                return ResponseData.of(div).addMessage(message).respond();
//            }
//        }
//        if (new RString(UrWarningMessages.未保存情報の破棄確認.getMessage().getCode())
//                .equals(ResponseHolder.getMessageCode()) && ResponseHolder.getButtonType() == MessageDialogSelectedResult.No) {
//            RString selecedKey = div.getHdnRadSelectedKey();
//            div.getTokkiJikoNyuryoku().getRadTokkiJikoGroup().setSelectedKey(selecedKey);
//            return ResponseData.of(div).respond();
//        }
//        div.setHdnRadSelectedKey(div.getTokkiJikoNyuryoku().getRadTokkiJikoGroup().getSelectedKey());
//        getHandler(div).resetControl();
//        getHandler(div).setDdlTokkiJikoNo();
//        return ResponseData.of(div).respond();
//    }
//
//    /**
//     * 特記事項番号ドロップダウンリストの切り替え処理です。
//     *
//     * @param div TokkiJikoInputDiv
//     * @return ResponseData
//     */
//    public ResponseData<TokkiJikoInputDiv> onChange_ddlTokkiJikoNo(TokkiJikoInputDiv div) {
//        if (!ResponseHolder.isReRequest()) {
//            if (is特記事項変更) {
//                WarningMessage message = new WarningMessage(UrWarningMessages.未保存情報の破棄確認.getMessage().getCode(),
//                        UrWarningMessages.未保存情報の破棄確認.getMessage().evaluate());
//                return ResponseData.of(div).addMessage(message).respond();
//            }
//        }
//        if (new RString(UrWarningMessages.未保存情報の破棄確認.getMessage().getCode())
//                .equals(ResponseHolder.getMessageCode()) && ResponseHolder.getButtonType() == MessageDialogSelectedResult.No) {
//            RString selecedKey = div.getHdnDdlSelectedKey();
//            div.getTokkiJikoNyuryoku().getDdlTokkiJikoNo().setSelectedKey(selecedKey);
//            return ResponseData.of(div).respond();
//        }
//        div.setHdnDdlSelectedKey(div.getTokkiJikoNyuryoku().getDdlTokkiJikoNo().getSelectedKey());
//        getHandler(div).resetControl();
//        return ResponseData.of(div).respond();
//    }

    /**
     * 特記事項の変更処理を表します。
     *
     * @param div TokkiJikoInputDiv
     * @return ResponseData
     */
    public ResponseData<TokkiJikoInputDiv> onChange_txtTokkiJiko(TokkiJikoInputDiv div) {
        is特記事項変更 = true;
        return ResponseData.of(div).respond();
    }

    /**
     * 「確定する」ボタン押下時の処理を表します。
     *
     * @param div TokkiJikoInputDiv
     * @return ResponseData
     */
    public ResponseData<TokkiJikoInputDiv> onClick_btnSave(TokkiJikoInputDiv div) {
        if (div.getTokkiJikoNyuryoku().getBtnDeleteCancel().isDisplayNone()) {
            ValidationMessageControlPairs pairs = new ValidationMessageControlPairs();
            getValidationHandler().validateFor特記事項の必須入力(pairs, div);
            if (pairs.iterator().hasNext()) {
                return ResponseData.of(div).addValidationMessages(pairs).respond();
            }
            getHandler(div).onSave();
        } else {
            getHandler(div).onSaveDelete();
        }
        getHandler(div).resetControl();
        getHandler(div).setBtnControlPropertyByInput(false);
        return ResponseData.of(div).focusId(div.getTokkiJikoNyuryoku().getDgTokkiJikoJoho().getSelectControlID()).respond();
    }

    /**
     * 「取消する」ボタン押下時の処理を表します。
     *
     * @param div TokkiJikoInputDiv
     * @return ResponseData
     */
    public ResponseData<TokkiJikoInputDiv> onClick_btnCancel(TokkiJikoInputDiv div) {
        if (!ResponseHolder.isReRequest()) {
            if (is特記事項変更) {
                WarningMessage message = new WarningMessage(UrWarningMessages.未保存情報の破棄確認.getMessage().getCode(),
                        UrWarningMessages.未保存情報の破棄確認.getMessage().evaluate());
                return ResponseData.of(div).addMessage(message).respond();
            }
        }
        if (new RString(UrWarningMessages.未保存情報の破棄確認.getMessage().getCode())
                .equals(ResponseHolder.getMessageCode()) && ResponseHolder.getButtonType() == MessageDialogSelectedResult.No) {
            return ResponseData.of(div).respond();
        }
        getHandler(div).resetControl();
        getHandler(div).setBtnControlPropertyByInput(false);
        return ResponseData.of(div).focusId(div.getTokkiJikoNyuryoku().getDdlTokkiJikoNo().getSelectControlID()).respond();
    }

    /**
     * 「削除する」ボタン押下時の処理を表します。
     *
     * @param div TokkiJikoInputDiv
     * @return ResponseData
     */
    public ResponseData<TokkiJikoInputDiv> onClick_btnDelete(TokkiJikoInputDiv div) {
        getHandler(div).setBtnControlPropertyByDelete(true);
        return ResponseData.of(div).focusId(div.getTokkiJikoNyuryoku().getBtnSave().getSelectControlID()).respond();
    }

    /**
     * 「削除を取り消す」ボタン押下時の処理を表します。
     *
     * @param div TokkiJikoInputDiv
     * @return ResponseData
     */
    public ResponseData<TokkiJikoInputDiv> onClick_btnDeleteCancel(TokkiJikoInputDiv div) {
        getHandler(div).setBtnControlPropertyByDelete(false);
        return ResponseData.of(div).focusId(div.getTokkiJikoNyuryoku().getBtnSave().getSelectControlID()).respond();
    }

    /**
     * 「戻る」ボタン押下時の処理を表します。
     *
     * @param div TokkiJikoInputDiv
     * @return ResponseData
     */
    public ResponseData<TokkiJikoInputDiv> onClick_btnReturn(TokkiJikoInputDiv div) {
        getHandler(div).saveDgTokkiJikoInfo();
        return ResponseData.of(div).respond();
    }

    /**
     * 「変更内容を取り消す」ボタン押下時の処理を表します。
     *
     * @param div TokkiJikoInputDiv
     * @return ResponseData
     */
    public ResponseData<TokkiJikoInputDiv> onClick_btnUpdateCancel(TokkiJikoInputDiv div) {
        if (!ResponseHolder.isReRequest()) {
            QuestionMessage message = new QuestionMessage(UrQuestionMessages.入力内容の破棄.getMessage().getCode(),
                    UrQuestionMessages.入力内容の破棄.getMessage().evaluate());
            return ResponseData.of(div).addMessage(message).respond();
        }
        if (new RString(UrQuestionMessages.入力内容の破棄.getMessage().getCode())
                .equals(ResponseHolder.getMessageCode()) && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            getHandler(div).onClear();
        }
        return ResponseData.of(div).respond();
    }

    private TokkiJikoInputHandler getHandler(TokkiJikoInputDiv requestDiv) {
        return new TokkiJikoInputHandler(requestDiv);
    }

    private TokkiJikoInputValidationHandler getValidationHandler() {
        return new TokkiJikoInputValidationHandler();
    }
}
