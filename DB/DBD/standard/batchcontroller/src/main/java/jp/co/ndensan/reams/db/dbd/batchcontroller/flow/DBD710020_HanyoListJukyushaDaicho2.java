/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.batchcontroller.flow;

import jp.co.ndensan.reams.db.dbd.batchcontroller.step.hanyorisutojyukyusyadaicho.HanyoRisutoJyukyusyaDaichoProcess;
import jp.co.ndensan.reams.db.dbd.definition.batchprm.DBD710020.DBD710020_HanyoListJukyushaDaicho2Parameter;
import jp.co.ndensan.reams.uz.uza.batch.Step;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;
import jp.co.ndensan.reams.uz.uza.batch.flow.IBatchFlowCommand;

/**
 * 汎用リスト受給者台帳２のバッチフロークラスです。
 *
 * @reamsid_L DBD-1810-020 yaodongsheng
 */
public class DBD710020_HanyoListJukyushaDaicho2 extends BatchFlowBase<DBD710020_HanyoListJukyushaDaicho2Parameter> {

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
        return loopBatch(HanyoRisutoJyukyusyaDaichoProcess.class)
                .arguments(getParameter().toHanyoRisutoJyukyusyaDaichoProcessParameter())
                .define();
    }
}
