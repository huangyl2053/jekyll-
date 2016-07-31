/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.batchcontroller.flow.dbdbt13013;

import jp.co.ndensan.reams.db.dbd.batchcontroller.step.dbdbt13013.HanyoRisutoKokiKoreishaProcess;
import jp.co.ndensan.reams.db.dbd.definition.batchprm.hanyorisutokokikoreisha.HanyoRisutoKokiKoreishaBatchParameter;
import jp.co.ndensan.reams.uz.uza.batch.Step;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;
import jp.co.ndensan.reams.uz.uza.batch.flow.IBatchFlowCommand;

/**
 * 汎用リスト出力(後期高齢者)のバッチフロークラスです。
 *
 * @reamsid_L DBD-5520-030 mawy
 */
public class HanyoRisutoKokiKoreishaFlow extends BatchFlowBase<HanyoRisutoKokiKoreishaBatchParameter> {

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
        return loopBatch(HanyoRisutoKokiKoreishaProcess.class)
                .arguments(getParameter().toHanyoRisutoKokiKoreishaProcessParameter())
                .define();
    }
}
