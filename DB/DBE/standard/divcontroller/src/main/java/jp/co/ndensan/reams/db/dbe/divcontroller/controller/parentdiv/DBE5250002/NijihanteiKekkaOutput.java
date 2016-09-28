/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.controller.parentdiv.DBE5250002;

import jp.co.ndensan.reams.db.dbe.definition.batchprm.DBE525002.DBE525002_HanteiKekkaHokenshaParameter;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5250002.NijihanteiKekkaOutputDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE5250002.NijihanteiKekkaOutputHandler;
import jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE5250002.ValidationHandler;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 判定結果情報出力(保険者)取得処理。
 *
 * @reamsid_L DBE-0190-010 lizhuoxuan
 */
public class NijihanteiKekkaOutput {

    /**
     * 判定結果情報出力(保険者)。<br/>
     *
     * @param nijiDiv NijihanteiKekkaOutputDiv
     * @return ResponseData<NijihanteiKekkaOutputDiv>
     */
    public ResponseData<NijihanteiKekkaOutputDiv> onLoad(NijihanteiKekkaOutputDiv nijiDiv) {
        nijiDiv.getKensakuJoken().getCcdShinseishaFinder().initialize();
        createHandlerOf(nijiDiv).initialize();
        return createResponseData(nijiDiv);
    }

    /**
     * 検索ボタン。<br/>
     *
     * @param nijiDiv NijihanteiKekkaOutputDiv
     * @return ResponseData<NijihanteiKekkaOutputDiv>
     */
    public ResponseData<NijihanteiKekkaOutputDiv> onClick_Btnkennsaku(NijihanteiKekkaOutputDiv nijiDiv) {
        createHandlerOf(nijiDiv).kennsaku();
        return createResponseData(nijiDiv);
    }

    /**
     * 「判定結果一覧を発行する」ボタンを押下時、バッチパラメータを引き渡し、バッチを起動する。<br/>
     *
     * @param nijiDiv NijihanteiKekkaOutputDiv
     * @return ResponseData<NijihanteiKekkaOutputDiv>
     */
    public ResponseData<DBE525002_HanteiKekkaHokenshaParameter> onClick_btnHanteikekkaOutput(NijihanteiKekkaOutputDiv nijiDiv) {
        return ResponseData.of(getHandler(nijiDiv).setBatchParameter()).respond();
    }

    /**
     * 「連携データを出力する」ボタンを押下時、CSV出力バッチパラメータを引き渡し、CSV出力バッチを起動する。<br/>
     *
     * @param nijiDiv NijihanteiKekkaOutputDiv
     * @return ResponseData<NijihanteiKekkaOutputDiv>
     */
    public ResponseData<DBE525002_HanteiKekkaHokenshaParameter> onClick_btnRenkeiDataOutput(NijihanteiKekkaOutputDiv nijiDiv) {
        return ResponseData.of(getHandler(nijiDiv).setCSVBatchParameter()).respond();
    }

    /**
     * 入力チェック。<br/>
     *
     * @param nijiDiv NijihanteiKekkaOutputDiv
     * @return ResponseData<NijihanteiKekkaOutputDiv>
     */
    public ResponseData<NijihanteiKekkaOutputDiv> onClick_btnCheck(NijihanteiKekkaOutputDiv nijiDiv) {
        ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();
        ValidationMessageControlPairs validPairs = getValidationHandler(nijiDiv).データ空チェック(validationMessages);
        if (validPairs.iterator().hasNext()) {
            return ResponseData.of(nijiDiv).addValidationMessages(validPairs).respond();
        }
        validPairs = getValidationHandler(nijiDiv).未選択チェック(validationMessages);
        if (validPairs.iterator().hasNext()) {
            return ResponseData.of(nijiDiv).addValidationMessages(validPairs).respond();
        }
        return ResponseData.of(nijiDiv).respond();
    }

    private NijihanteiKekkaOutputHandler createHandlerOf(NijihanteiKekkaOutputDiv nijiDiv) {
        return new NijihanteiKekkaOutputHandler(nijiDiv);
    }

    private ResponseData<NijihanteiKekkaOutputDiv> createResponseData(NijihanteiKekkaOutputDiv nijiDiv) {
        ResponseData<NijihanteiKekkaOutputDiv> response = new ResponseData();
        response.data = nijiDiv;
        return response;
    }

    private ValidationHandler getValidationHandler(NijihanteiKekkaOutputDiv nijiDiv) {
        return new ValidationHandler(nijiDiv);
    }

    private NijihanteiKekkaOutputHandler getHandler(NijihanteiKekkaOutputDiv nijiDiv) {
        return new NijihanteiKekkaOutputHandler(nijiDiv);
    }

}
