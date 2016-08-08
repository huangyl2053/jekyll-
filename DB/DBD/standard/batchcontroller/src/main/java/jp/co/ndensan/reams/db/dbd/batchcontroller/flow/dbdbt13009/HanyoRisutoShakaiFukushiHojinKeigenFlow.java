/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.batchcontroller.flow.dbdbt13009;

import jp.co.ndensan.reams.db.dbd.batchcontroller.step.dbdbt13009.HanyoRisutoShakaiFukushiHojinKeigenProcess;
import jp.co.ndensan.reams.db.dbd.definition.batchprm.hanyorisutoshakaifukushihojinkeigen.ShakaiFukushiHojinKeigenBatchParameter;
import jp.co.ndensan.reams.uz.uza.batch.Step;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;
import jp.co.ndensan.reams.uz.uza.batch.flow.IBatchFlowCommand;

/**
 * 汎用リスト出力(社会福祉法人軽減)のバッチフロークラスです。
 *
 * @reamsid_L DBD-3900-030 mawy
 */
public class HanyoRisutoShakaiFukushiHojinKeigenFlow extends BatchFlowBase<ShakaiFukushiHojinKeigenBatchParameter> {

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
        return loopBatch(HanyoRisutoShakaiFukushiHojinKeigenProcess.class)
                .arguments(getParameter().toHanyoRisutoShakaiFukushiHoujinKeigenProcessParameter())
                .define();
    }

}
