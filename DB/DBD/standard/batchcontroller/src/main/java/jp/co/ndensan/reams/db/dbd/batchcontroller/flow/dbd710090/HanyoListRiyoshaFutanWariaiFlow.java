/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.batchcontroller.flow.dbd710090;

import jp.co.ndensan.reams.db.dbd.batchcontroller.step.DBD710090_HanyoListShiharaiHohoHenko.HanyoListRiyoshaFutanwariaiProcess;
import jp.co.ndensan.reams.db.dbd.definition.batchprm.dbd710140.DBD710140_HanyoListRiyoshaFutanwariaiParameter;
import jp.co.ndensan.reams.uz.uza.batch.Step;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;
import jp.co.ndensan.reams.uz.uza.batch.flow.IBatchFlowCommand;

/**
 * 汎用リスト出力(利用者負担割合)のバッチフロークラスです。
 *
 * @reamsid_L DBD-5810-030 mawy
 */
public class HanyoListRiyoshaFutanWariaiFlow extends BatchFlowBase<DBD710140_HanyoListRiyoshaFutanwariaiParameter> {

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
        return loopBatch(HanyoListRiyoshaFutanwariaiProcess.class)
                .arguments(getParameter().toHanyoRisutoRiyoshaFutanWariaiProcessParameter())
                .define();
    }
}
