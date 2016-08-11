/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.batchcontroller.flow.dbdbt13012;

import jp.co.ndensan.reams.db.dbd.batchcontroller.step.dbdbt13012.HanyoRisutoKokuhoProcess;
import jp.co.ndensan.reams.db.dbd.definition.batchprm.hanyorisutokokuho.HanyoRisutoKokuhoBatchParameter;
import jp.co.ndensan.reams.uz.uza.batch.Step;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;
import jp.co.ndensan.reams.uz.uza.batch.flow.IBatchFlowCommand;

/**
 * 汎用リスト出力(国保)のバッチフロークラスです。
 *
 * @reamsid_L DBD-5510-030 mawy
 */
public class HanyoRisutoKokuhoFlow extends BatchFlowBase<HanyoRisutoKokuhoBatchParameter> {

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
        return loopBatch(HanyoRisutoKokuhoProcess.class)
                .arguments(getParameter().toHanyoRisutoKokuhoProcessParameter())
                .define();
    }
}
