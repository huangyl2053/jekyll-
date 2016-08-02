/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.batchcontroller.flow.dbdbt13015;

import jp.co.ndensan.reams.db.dbd.batchcontroller.step.dbdbt13015.HanyoRisutoRiyoshaFutanWariaiProcess;
import jp.co.ndensan.reams.db.dbd.definition.batchprm.hanyorisutoriyoshafutanwariai.HanyoRisutoRiyoshaFutanWariaiBatchParameter;
import jp.co.ndensan.reams.uz.uza.batch.Step;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;
import jp.co.ndensan.reams.uz.uza.batch.flow.IBatchFlowCommand;

/**
 * 汎用リスト出力(利用者負担割合)のバッチフロークラスです。
 *
 * @reamsid_L DBD-5810-030 mawy
 */
public class HanyoRisutoRiyoshaFutanWariaiFlow extends BatchFlowBase<HanyoRisutoRiyoshaFutanWariaiBatchParameter> {

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
        return loopBatch(HanyoRisutoRiyoshaFutanWariaiProcess.class)
                .arguments(getParameter().toHanyoRisutoRiyoshaFutanWariaiProcessParameter())
                .define();
    }
}
