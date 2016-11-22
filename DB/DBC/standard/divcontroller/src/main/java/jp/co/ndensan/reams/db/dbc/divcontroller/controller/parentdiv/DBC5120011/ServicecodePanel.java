/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.DBC5120011;

import jp.co.ndensan.reams.db.dbc.definition.batchprm.DBC150030.DBC150030_ServicecodeRiyojokyoParameter;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC5120011.ServicecodePanelDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC5120011.ServicecodePanelHandler;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC5120011.ServicecodePanelValidationHandler;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.uz.uza.batch.parameter.BatchParameterMap;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.message.QuestionMessage;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * サービスコード別利用状況です
 *
 * @reamsid_L DBC-3340-010 lihang
 */
public class ServicecodePanel {

    /**
     * onLoadです。
     *
     * @param div servicecodePanelDiv
     * @return ResponseData
     */
    public ResponseData<ServicecodePanelDiv> onLoad(ServicecodePanelDiv div) {

        getHandler(div).getサービス種類名称();
        div.getCcdChikuShichosonSelect().isVisible();
        div.getCcdChikuShichosonSelect().initialize();
        return ResponseData.of(div).respond();
    }

    /**
     * onBeforeOpenDialog
     *
     * @param div servicecodePanelDiv
     * @return ResponseData
     */
    public ResponseData<ServicecodePanelDiv> onBeforeOpenDialog(ServicecodePanelDiv div) {

        ValidationMessageControlPairs validPairs = getValidationHandler(div).get入力チェック();
        if (validPairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(validPairs).respond();
        }
        if (!ResponseHolder.isReRequest()) {
            return ResponseData.of(div).addMessage(
                    new QuestionMessage(UrQuestionMessages.処理実行の確認.getMessage().getCode(),
                            UrQuestionMessages.処理実行の確認.getMessage().evaluate())).respond();
        }
        return ResponseData.of(div).respond();
    }

    /**
     * onClick_btnExcute
     *
     * @param div ServicecodePanelDiv
     * @return ResponseData
     */
    public ResponseData<DBC150030_ServicecodeRiyojokyoParameter> onClick_btnExcute(ServicecodePanelDiv div) {
        DBC150030_ServicecodeRiyojokyoParameter parameter = getHandler(div).getBatchParameter();
        return ResponseData.of(parameter).respond();
    }

    /**
     * 条件を保存するボタン
     *
     * @param div ServicecodePanelDiv
     * @return ResponseData
     */
    public ResponseData<BatchParameterMap> onClick_btnBatchParamSave(ServicecodePanelDiv div) {
        BatchParameterMap saveMap = new BatchParameterMap(getHandler(div).getBatchParameter());
        return ResponseData.of(saveMap).respond();
    }

    /**
     * 条件を復元するボタン
     *
     * @param div ServicecodePanelDiv
     * @return ResponseData
     */
    public ResponseData<ServicecodePanelDiv> onClick_btnBatchParamRestore(ServicecodePanelDiv div) {
        getHandler(div).setBatchParameterRestore();
        return ResponseData.of(div).respond();
    }

    private ServicecodePanelValidationHandler getValidationHandler(ServicecodePanelDiv div) {
        return new ServicecodePanelValidationHandler(div);
    }

    private ServicecodePanelHandler getHandler(ServicecodePanelDiv div) {
        return new ServicecodePanelHandler(div);
    }

}
