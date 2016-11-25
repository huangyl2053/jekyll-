/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.controller.parentdiv.DBE5250002;

import jp.co.ndensan.reams.db.dbe.definition.batchprm.DBE491001.DBE491001_NichijiShinchokuParameter;
import jp.co.ndensan.reams.db.dbe.definition.batchprm.DBE525002.DBE525002_HanteiKekkaHokenshaParameter;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5250002.NijihanteiKekkaOutputDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE5250002.NijihanteiKekkaOutputHandler;
import jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE5250002.ValidationHandler;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBU;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.workflow.parameter.FlowParameterAccessor;
import jp.co.ndensan.reams.uz.uza.workflow.parameter.FlowParameters;

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
     * クリアボタン。<br/>
     *
     * @param nijiDiv NijihanteiKekkaOutputDiv
     * @return ResponseData<NijihanteiKekkaOutputDiv>
     */
    public ResponseData<NijihanteiKekkaOutputDiv> onClick_BtnClear(NijihanteiKekkaOutputDiv nijiDiv) {
        nijiDiv.getKensakuJoken().getCcdShinseishaFinder().initialize();
        nijiDiv.getKensakuJoken().getTxtNijihanteDateRange().setFromValue(RDate.getNowDate());
        nijiDiv.getKensakuJoken().getTxtNijihanteDateRange().setToValue(RDate.getNowDate());
        nijiDiv.getKensakuJoken().getRadDataShutsuryokuUmu().setSelectedIndex(0);

        nijiDiv.getKensakuJoken().getTxtHyojiDataLimit().setValue(DbBusinessConfig.
                get(ConfigNameDBU.検索制御_最大取得件数, RDate.getNowDate(), SubGyomuCode.DBU介護統計報告));
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
        FlowParameters fp = FlowParameters.of(new RString("key"), "Batch1");
        FlowParameterAccessor.merge(fp);
        return ResponseData.of(getHandler(nijiDiv).setBatchParameter()).respond();
    }

    /**
     * 「連携データを出力する」ボタンを押下時、CSV出力バッチパラメータを引き渡し、CSV出力バッチを起動する。<br/>
     *
     * @param nijiDiv NijihanteiKekkaOutputDiv
     * @return ResponseData<NijihanteiKekkaOutputDiv>
     */
    public ResponseData<DBE491001_NichijiShinchokuParameter> onClick_btnRenkeiDataOutput(NijihanteiKekkaOutputDiv nijiDiv) {
        FlowParameters fp = FlowParameters.of(new RString("key"), "Batch2");
        FlowParameterAccessor.merge(fp);
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
