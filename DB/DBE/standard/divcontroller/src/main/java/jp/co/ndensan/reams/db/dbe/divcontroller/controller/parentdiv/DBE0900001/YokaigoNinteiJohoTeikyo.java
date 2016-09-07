/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.controller.parentdiv.DBE0900001;

import jp.co.ndensan.reams.db.dbe.definition.batchprm.yokaigoninteijohoteikyo.YokaigoBatchParameter;
import jp.co.ndensan.reams.db.dbe.definition.message.DbeQuestionMessages;
import jp.co.ndensan.reams.db.dbe.definition.message.DbeWarningMessages;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE0900001.DBE0900001StateName;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE0900001.YokaigoNinteiJohoTeikyoDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE0900001.dgNinteiKekkaIchiran_Row;
import jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE0900001.YokaigoNinteiJohoTeikyoHandler;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.message.QuestionMessage;
import jp.co.ndensan.reams.uz.uza.message.WarningMessage;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * 要介護認定情報提供Divを制御クラスです。
 *
 * @reamsid_L DBE-0230-010 zhangzhiming
 */
public class YokaigoNinteiJohoTeikyo {

    private final RString キー = new RString("key0");
    private final RString する = new RString("1");
    private final RString ない = new RString("0");

    /**
     * 要介護認定情報提供の初期処理を表示します。
     *
     * @param div YokaigoNinteiJohoTeikyoDiv
     * @return ResponseData
     */
    public ResponseData<YokaigoNinteiJohoTeikyoDiv> onLoad(YokaigoNinteiJohoTeikyoDiv div) {
        RString 被保険者番号 = ViewStateHolder.get(ViewStateKeys.被保険者番号, RString.class);
        getHandler(div).onLoad(被保険者番号);
        return ResponseData.of(div).setState(DBE0900001StateName.初期表示);
    }

    /**
     * 「選択」ボタン押下します。
     *
     * @param div YokaigoNinteiJohoTeikyoDiv
     * @return ResponseData
     */
    public ResponseData<YokaigoNinteiJohoTeikyoDiv> btn_Select(YokaigoNinteiJohoTeikyoDiv div) {
        getHandler(div).btn_Select();
        return ResponseData.of(div).setState(DBE0900001StateName.一覧選択);
    }

    /**
     * 特記事項チェックボックス変更します。
     *
     * @param div YokaigoNinteiJohoTeikyoDiv
     * @return ResponseData
     */
    public ResponseData<YokaigoNinteiJohoTeikyoDiv> chkTokkiJiko(YokaigoNinteiJohoTeikyoDiv div) {
        getHandler(div).chkTokkiJiko();
        return ResponseData.of(div).respond();
    }

    /**
     * 主治医意見書チェックボックス変更します。
     *
     * @param div YokaigoNinteiJohoTeikyoDiv
     * @return ResponseData
     */
    public ResponseData<YokaigoNinteiJohoTeikyoDiv> chkShujiiIkensho(YokaigoNinteiJohoTeikyoDiv div) {
        getHandler(div).chkShujiiIkensho();
        return ResponseData.of(div).respond();
    }

    /**
     * その他資料チェックボックス変更します。
     *
     * @param div YokaigoNinteiJohoTeikyoDiv
     * @return ResponseData
     */
    public ResponseData<YokaigoNinteiJohoTeikyoDiv> chkSonotaShiryo(YokaigoNinteiJohoTeikyoDiv div) {
        getHandler(div).chkSonotaShiryo();
        return ResponseData.of(div).respond();
    }

    /**
     * 「一覧へ戻る」ボタン押下します。
     *
     * @param div YokaigoNinteiJohoTeikyoDiv
     * @return ResponseData
     */
    public ResponseData<YokaigoNinteiJohoTeikyoDiv> btn_BackSearchResult(YokaigoNinteiJohoTeikyoDiv div) {
        onLoad(div);
        getHandler(div).btn_BackSearchResult();
        return ResponseData.of(div).setState(DBE0900001StateName.初期表示);
    }

    /**
     * 帳票発行処理を実行します。
     *
     * @param div YokaigoNinteiJohoTeikyoDiv
     * @return ResponseData
     */
    public ResponseData<YokaigoNinteiJohoTeikyoDiv> btnBatch_ReportPublish(YokaigoNinteiJohoTeikyoDiv div) {
        ValidationMessageControlPairs validationMessageControlPairs = getHandler(div).validateCheck();
        if (validationMessageControlPairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(validationMessageControlPairs).respond();
        }
        dgNinteiKekkaIchiran_Row row = div.getNInteiRirekiInfo().getDgNinteiKekkaIchiran().getSelectedItems().get(0);
        if (!ResponseHolder.isReRequest()) {
            if (row.getNinteiShinsakaiKanryoYMD().getValue() == null) {
                QuestionMessage message = new QuestionMessage(DbeQuestionMessages.二次判定結果が決定していませんが印刷.getMessage().getCode(),
                        DbeQuestionMessages.二次判定結果が決定していませんが印刷.getMessage().evaluate());
                return ResponseData.of(div).addMessage(message).respond();
            }
            if (new RString(DbeQuestionMessages.二次判定結果が決定していませんが印刷.getMessage().getCode()).equals(ResponseHolder.getMessageCode())
                    && ResponseHolder.getButtonType() == MessageDialogSelectedResult.No) {
                return ResponseData.of(div).respond();
            }
            if (row.getJohoTeikyoShiryoShutsuryokuDay().getValue() != null) {
                WarningMessage message = new WarningMessage(DbeWarningMessages.既に印刷済.getMessage().getCode(),
                        DbeWarningMessages.既に印刷済.getMessage().evaluate());
                return ResponseData.of(div).addMessage(message).respond();
            }
            if (new RString(DbeWarningMessages.既に印刷済.getMessage().getCode()).equals(ResponseHolder.getMessageCode())
                    && ResponseHolder.getButtonType() == MessageDialogSelectedResult.No) {
                return ResponseData.of(div).respond();
            }

        }
        return ResponseData.of(div).respond();
    }

    /**
     * バッチパラメータの設定します。
     *
     * @param div YokaigoNinteiJohoTeikyoDiv
     * @return ResponseData<YokaigoNinteiJohoTeikyoDiv>
     */
    public ResponseData<YokaigoBatchParameter> getParameter(YokaigoNinteiJohoTeikyoDiv div) {
        YokaigoBatchParameter parm = new YokaigoBatchParameter();
        parm.setShinseishoKanriNo(div.getNInteiRirekiInfo().getDgNinteiKekkaIchiran().getSelectedItems().get(0).getShinseishoKanriNo());
        if (div.getHakkoChohyo().getChkNinteiChosahyo().isAllSelected()) {
            parm.setChkNinteiChosahyo(する);
        } else {
            parm.setChkNinteiChosahyo(ない);
        }
        if (div.getHakkoChohyo().getChkTokkiJiko().isAllSelected()) {
            parm.setChkTokkiJiko(する);
        } else {
            parm.setChkTokkiJiko(ない);
        }
        if (div.getHakkoChohyo().getChkShujiiIkensho().isAllSelected()) {
            parm.setChkShujiiIkensho(する);
        } else {
            parm.setChkShujiiIkensho(ない);
        }
        if (div.getHakkoChohyo().getChkSonotaShiryo().isAllSelected()) {
            parm.setChkSonotaShiryo(する);
        } else {
            parm.setChkSonotaShiryo(ない);
        }
        if (div.getHakkoChohyo().getChkIchijiHanteiKekka().isAllSelected()) {
            parm.setChkIchijiHanteiKekka(する);
        } else {
            parm.setChkIchijiHanteiKekka(ない);
        }
        if (キー.equals(div.getHakkoChohyo().getRadTokkiJikoMasking().getSelectedKey())) {
            parm.setRadTokkiJikoMasking(する);
        } else {
            parm.setRadTokkiJikoMasking(ない);
        }
        if (キー.equals(div.getHakkoChohyo().getRadShujii().getSelectedKey())) {
            parm.setRadShujii(する);
        } else {
            parm.setRadShujii(ない);
        }
        if (キー.equals(div.getHakkoChohyo().getRadSohotaShiryoMasking().getSelectedKey())) {
            parm.setRadSohotaShiryoMasking(する);
        } else {
            parm.setRadSohotaShiryoMasking(ない);
        }
        return ResponseData.of(parm).respond();
    }

    private YokaigoNinteiJohoTeikyoHandler getHandler(YokaigoNinteiJohoTeikyoDiv div) {
        return new YokaigoNinteiJohoTeikyoHandler(div);
    }
}
