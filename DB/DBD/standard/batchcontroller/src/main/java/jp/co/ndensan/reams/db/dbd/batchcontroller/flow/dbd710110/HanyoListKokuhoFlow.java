/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.batchcontroller.flow.dbd710110;

import jp.co.ndensan.reams.db.dbd.batchcontroller.step.dbd710110.HanyoListKokuhoProcess;
import jp.co.ndensan.reams.db.dbd.definition.batchprm.dbd710110.DBD710110_HanyoListKokuhoParameter;
import jp.co.ndensan.reams.uz.uza.batch.Step;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;
import jp.co.ndensan.reams.uz.uza.batch.flow.IBatchFlowCommand;

/**
 * 汎用リスト出力(国保)のバッチフロークラスです。
 *
 * @reamsid_L DBD-5510-030 mawy
 */
public class HanyoListKokuhoFlow extends BatchFlowBase<DBD710110_HanyoListKokuhoParameter> {

    @Override
    protected void defineFlow() {
        executeStep(CSV_PROCESS);
    }

    private static final String CSV_PROCESS = "csvProcess";

    /**
     * batchProcessです。
     *
     * @return IBatchFlowCommand
     */
    @Step(CSV_PROCESS)
    protected IBatchFlowCommand reportProcess() {
        return loopBatch(HanyoListKokuhoProcess.class)
                .arguments(getParameter().toHanyoRisutoKokuhoProcessParameter())
                .define();
    }
}
