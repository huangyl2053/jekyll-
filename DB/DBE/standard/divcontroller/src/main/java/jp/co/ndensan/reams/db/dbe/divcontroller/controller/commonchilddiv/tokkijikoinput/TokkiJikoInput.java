/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.controller.commonchilddiv.tokkijikoinput;

import jp.co.ndensan.reams.db.dbe.definition.message.DbeErrorMessages;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.commonchilddiv.TokkiJikoInput.TokkiJikoInput.TokkiJikoInputDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.commonchilddiv.TokkiJikoInput.TokkiJikoInput.TokkiJikoInputHandler;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.commonchilddiv.TokkiJikoInput.TokkiJikoInput.TokkiJikoInputValidationHandler;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBE;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.message.QuestionMessage;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 *
 * @author n3423
 */
public class TokkiJikoInput {

    private final RString 全面テキスト = new RString("1");

    /**
     * 初期化の処理を表します。
     *
     * @param div 主治医意見書照会Div
     * @return ResponseData
     */
    public ResponseData<TokkiJikoInputDiv> onLoad(TokkiJikoInputDiv div) {
        getHandler(div).onLoad();
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
     * 「連番追加する」ボタン押下時の処理を表します。
     *
     * @param div TokkiJikoInputDiv
     * @return ResponseData
     */
    public ResponseData<TokkiJikoInputDiv> onClick_btnAddRemban(TokkiJikoInputDiv div) {
        if (new RString(DbeErrorMessages.連番最大値を超過.getMessage().getCode())
                .equals(ResponseHolder.getMessageCode()) && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            return ResponseData.of(div).respond();
        }
        Message message = getHandler(div).checkMaxRemban();
        if (message != null) {
            return ResponseData.of(div).addMessage(message).respond();
        }
        div.getTokkiJikoNyuryoku().getTxtTokkiJiko().setDisabled(false);
        getHandler(div).setBtnControlPropertyByInput(true);
        return ResponseData.of(div).focusId(div.getTokkiJikoNyuryoku().getTxtTokkiJiko().getSelectControlID()).respond();
    }

    /**
     * 「dg修正」ボタン押下時の処理を表します。
     *
     * @param div TokkiJikoInputDiv
     * @return ResponseData
     */
    public ResponseData<TokkiJikoInputDiv> onClick_dgTokkiBtnModify(TokkiJikoInputDiv div) {
        getHandler(div).onModify();
        getHandler(div).setBtnControlPropertyByInput(true);
        div.setHdnSelectedRowId(new RString(div.getTokkiJikoNyuryoku().getDgTokkiJikoJoho().getActiveRow().getId()));
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
//    /**
//     * 特記事項の変更処理を表します。
//     *
//     * @param div TokkiJikoInputDiv
//     * @return ResponseData
//     */
//    public ResponseData<TokkiJikoInputDiv> onChange_txtTokkiJiko(TokkiJikoInputDiv div) {
//        return ResponseData.of(div).respond();
//    }

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
            if (全面テキスト.equals(DbBusinessConfig.get(ConfigNameDBE.審査会資料調査特記パターン, RDate.getNowDate(), SubGyomuCode.DBE認定支援))) {
                getHandler(div).onSave();
            } else {
                if (RString.isNullOrEmpty(div.getHdnSelectedRowId())) {
                    getHandler(div).onSaveAddRemban();
                } else {
                    getHandler(div).onSaveModify();
                }
            }
        } else {
            getHandler(div).onSaveDelete();
        }
        getHandler(div).sortDataGrid();
        getHandler(div).resetControl();
        getHandler(div).setBtnControlPropertyByInput(false);
        return ResponseData.of(div).focusId(div.getTokkiJikoNyuryoku().getDgTokkiJikoJoho().getSelectControlID()).respond();
    }

    /**
     * 「dg削除」ボタン押下時の処理を表します。
     *
     * @param div TokkiJikoInputDiv
     * @return ResponseData
     */
    public ResponseData<TokkiJikoInputDiv> onClick_dgTokkiBtnDelete(TokkiJikoInputDiv div) {
        getHandler(div).onSaveDataGridDelete();
        return ResponseData.of(div).focusId(div.getTokkiJikoNyuryoku().getBtnSave().getSelectControlID()).respond();
    }

    /**
     * 「取消する」ボタン押下時の処理を表します。
     *
     * @param div TokkiJikoInputDiv
     * @return ResponseData
     */
    public ResponseData<TokkiJikoInputDiv> onClick_btnCancel(TokkiJikoInputDiv div) {
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
     * 「確定して戻る」ボタン押下時の処理を表します。
     *
     * @param div TokkiJikoInputDiv
     * @return ResponseData
     */
    public ResponseData<TokkiJikoInputDiv> onClick_btnUpdateReturn(TokkiJikoInputDiv div) {
        getHandler(div).saveDgTokkiJikoInfo();
        return ResponseData.of(div).dialogOKClose();
    }

    /**
     * 「取消して戻る」ボタン押下時の処理を表します。
     *
     * @param div TokkiJikoInputDiv
     * @return ResponseData
     */
    public ResponseData<TokkiJikoInputDiv> onClick_btnCancelReturn(TokkiJikoInputDiv div) {
        if (new RString(UrQuestionMessages.入力内容の破棄.getMessage().getCode())
                .equals(ResponseHolder.getMessageCode()) && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            return ResponseData.of(div).dialogNGClose();
        }
        if (!ResponseHolder.isReRequest()) {
            QuestionMessage message = new QuestionMessage(UrQuestionMessages.入力内容の破棄.getMessage().getCode(),
                    UrQuestionMessages.入力内容の破棄.getMessage().evaluate());
            return ResponseData.of(div).addMessage(message).respond();
        }
        return ResponseData.of(div).respond();
    }

//    /**
//     * 「変更内容を取り消す」ボタン押下時の処理を表します。
//     *
//     * @param div TokkiJikoInputDiv
//     * @return ResponseData
//     */
//    public ResponseData<TokkiJikoInputDiv> onClick_btnUpdateCancel(TokkiJikoInputDiv div) {
//        if (!ResponseHolder.isReRequest()) {
//            QuestionMessage message = new QuestionMessage(UrQuestionMessages.入力内容の破棄.getMessage().getCode(),
//                    UrQuestionMessages.入力内容の破棄.getMessage().evaluate());
//            return ResponseData.of(div).addMessage(message).respond();
//        }
//        if (new RString(UrQuestionMessages.入力内容の破棄.getMessage().getCode())
//                .equals(ResponseHolder.getMessageCode()) && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
//            getHandler(div).onClear();
//        }
//        return ResponseData.of(div).respond();
//    }
    private TokkiJikoInputHandler getHandler(TokkiJikoInputDiv requestDiv) {
        return new TokkiJikoInputHandler(requestDiv);
    }

    private TokkiJikoInputValidationHandler getValidationHandler() {
        return new TokkiJikoInputValidationHandler();
    }
}
