/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.batchcontroller.flow;

import jp.co.ndensan.reams.db.dbd.batchcontroller.step.DBD710080.HanyoListFutanGendoGakuNinteiProcess;
import jp.co.ndensan.reams.db.dbd.definition.batchprm.DBD710080.DBD710080_HanyoListFutanGendoGakuNinteiParameter;
import jp.co.ndensan.reams.uz.uza.batch.Step;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;
import jp.co.ndensan.reams.uz.uza.batch.flow.IBatchFlowCommand;

/**
 *
 * 汎用リスト出力(負担限度額認定)のバッチフロークラスです。
 *
 * @reamsid_L DBD-3930-030 panxiaobo
 */
public class DBD710080_HanyoListFutanGendoGakuNintei extends BatchFlowBase<DBD710080_HanyoListFutanGendoGakuNinteiParameter> {

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
        return loopBatch(HanyoListFutanGendoGakuNinteiProcess.class)
                .arguments(getParameter().toHanyoListFutanGendoGakuNinteiProcessParameter())
                .define();
    }
}
