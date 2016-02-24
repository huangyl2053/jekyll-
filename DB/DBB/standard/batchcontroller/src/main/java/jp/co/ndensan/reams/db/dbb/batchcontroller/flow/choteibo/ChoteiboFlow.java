/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.batchcontroller.flow.choteibo;

import jp.co.ndensan.reams.db.dbb.batchcontroller.step.choteibo.ChoteiboReportProcess;
import jp.co.ndensan.reams.db.dbb.definition.batchprm.choteibo.ChoteiboBatchParameter;
import jp.co.ndensan.reams.uz.uza.batch.Step;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;
import jp.co.ndensan.reams.uz.uza.batch.flow.IBatchFlowCommand;

/**
 * 調定簿作成Flowクラスです。
 */
public class ChoteiboFlow extends BatchFlowBase<ChoteiboBatchParameter> {

    @Override
    protected void defineFlow() {
        executeStep(CHOTEIBO_REPORT_PROCESS);
    }

    private static final String CHOTEIBO_REPORT_PROCESS = "ChoteiboReaportProcess";

    @Step(CHOTEIBO_REPORT_PROCESS)
    protected IBatchFlowCommand createReport() {
        return simpleBatch(ChoteiboReportProcess.class).
                arguments(getParameter().toChoteiboBatchParameter()).define();
    }

}
