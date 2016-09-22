/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.batchcontroller.flow;

import jp.co.ndensan.reams.db.dbd.batchcontroller.step.DBD710050.HanyoListHomonKaigoRiyoshaFutanGakuGengakuProcess;
import jp.co.ndensan.reams.db.dbd.definition.batchprm.DBD710050.DBD710050_HanyoListHomonKaigoRiyoshaFutanGakuGengakuParameter;
import jp.co.ndensan.reams.uz.uza.batch.Step;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;
import jp.co.ndensan.reams.uz.uza.batch.flow.IBatchFlowCommand;

/**
 *
 * 汎用リスト出力(訪問介護利用者負担額減額)のバッチフロークラスです。
 *
 * @reamsid_L DBD-3940-030 panxiaobo
 */
public class DBD710050_HanyoListHomonKaigoRiyoshaFutanGakuGengaku
        extends BatchFlowBase<DBD710050_HanyoListHomonKaigoRiyoshaFutanGakuGengakuParameter> {

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
        return loopBatch(HanyoListHomonKaigoRiyoshaFutanGakuGengakuProcess.class)
                .arguments(getParameter().toHanyoListHomonKaigoRiyoshaFutanGakuGengakuProcessParameter())
                .define();
    }
}
