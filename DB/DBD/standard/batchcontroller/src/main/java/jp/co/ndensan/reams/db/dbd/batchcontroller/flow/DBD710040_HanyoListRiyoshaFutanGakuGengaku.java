/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.batchcontroller.flow;

import jp.co.ndensan.reams.db.dbd.batchcontroller.step.DBD710040.HanyoListRiyoshaFutanGakuGengakuProcess;
import jp.co.ndensan.reams.db.dbd.definition.batchprm.DBD710040.DBD710040_HanyoListRiyoshaFutanGakuGengakuParameter;
import jp.co.ndensan.reams.uz.uza.batch.Step;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;
import jp.co.ndensan.reams.uz.uza.batch.flow.IBatchFlowCommand;

/**
 *
 * 汎用リスト出力(利用者負担額減免)のバッチフロークラスです。
 *
 * @reamsid_L DBD-3950-030 panxiaobo
 */
public class DBD710040_HanyoListRiyoshaFutanGakuGengaku extends BatchFlowBase<DBD710040_HanyoListRiyoshaFutanGakuGengakuParameter> {

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
        return loopBatch(HanyoListRiyoshaFutanGakuGengakuProcess.class)
                .arguments(getParameter().toHanyoListRiyoshaFutanGakuGengakuProcessParameter())
                .define();
    }
}
