/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.batchcontroller.flow.hanyolisthihokenshadaicho;

import jp.co.ndensan.reams.db.dba.batchcontroller.step.hanyolisthihokenshadaicho.HanyoListHihokenshadaichoProcess;
import jp.co.ndensan.reams.db.dba.definition.batchprm.hanyolisthihokenshadaicho.HanyoListHihokenshadaichoBatchParameter;
import jp.co.ndensan.reams.uz.uza.batch.Step;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;
import jp.co.ndensan.reams.uz.uza.batch.flow.IBatchFlowCommand;

/**
 * 汎用リスト_被保険者台帳_バッチフロークラスです。
 *
 * @reamsid_L DBA-1610-030 lishengli
 */
public class HanyoListHihokenshadaichoFlow extends BatchFlowBase<HanyoListHihokenshadaichoBatchParameter> {

    @Override
    protected void defineFlow() {
        executeStep(REPORT_PROCESS);
    }
    private static final String REPORT_PROCESS = "reportProcess";

    /**
     * batchProcessです。
     *
     * @return IBatchFlowCommand
     */
    @Step(REPORT_PROCESS)
    protected IBatchFlowCommand reportProcess() {
        return loopBatch(HanyoListHihokenshadaichoProcess.class)
                .arguments(getParameter().toHanyoListHihokenshadaichoProcessParameter(getJobId())).define();
    }
}
