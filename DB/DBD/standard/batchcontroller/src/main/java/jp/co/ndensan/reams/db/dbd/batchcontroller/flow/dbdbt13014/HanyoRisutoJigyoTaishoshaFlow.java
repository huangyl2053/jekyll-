/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.batchcontroller.flow.dbdbt13014;

import jp.co.ndensan.reams.db.dbd.batchcontroller.step.dbdbt13014.HanyoRisutoJigyoTaishoshaProcess;
import jp.co.ndensan.reams.db.dbd.definition.batchprm.hanyorisutojigyotaishosha.HanyoRisutoJigyoTaishoshaBatchParameter;
import jp.co.ndensan.reams.uz.uza.batch.Step;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;
import jp.co.ndensan.reams.uz.uza.batch.flow.IBatchFlowCommand;

/**
 * 汎用リスト出力(事業対象者)のバッチフロークラスです。
 *
 * @reamsid_L DBD-5080-030 mawy
 */
public class HanyoRisutoJigyoTaishoshaFlow extends BatchFlowBase<HanyoRisutoJigyoTaishoshaBatchParameter> {

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
        return loopBatch(HanyoRisutoJigyoTaishoshaProcess.class)
                .arguments(getParameter().toHanyoRisutoJigyoTaishoshaProcessParameter())
                .define();
    }
}
