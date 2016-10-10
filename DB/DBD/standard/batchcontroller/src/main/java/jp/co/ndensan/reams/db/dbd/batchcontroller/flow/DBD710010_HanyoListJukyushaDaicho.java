/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.batchcontroller.flow;

import jp.co.ndensan.reams.db.dbd.batchcontroller.step.DBD710010.HanyoListJukyushaDaichoProcess;
import jp.co.ndensan.reams.db.dbd.definition.batchprm.DBD710010.DBD710010_HanyoListJukyushaDaichoParameter;
import jp.co.ndensan.reams.uz.uza.batch.Step;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;
import jp.co.ndensan.reams.uz.uza.batch.flow.IBatchFlowCommand;

/**
 * 汎用リスト受給者台帳のバッチフロークラスです。
 *
 * @reamsid_L DBD-1800-020 x_youyj
 */
public class DBD710010_HanyoListJukyushaDaicho extends BatchFlowBase<DBD710010_HanyoListJukyushaDaichoParameter> {

    private static final String 受給者台帳CSV = "受給者台帳CSV";

    @Override
    protected void defineFlow() {
        executeStep(受給者台帳CSV);
    }

    /**
     * batchProcessです。
     *
     * @return IBatchFlowCommand
     */
    @Step(受給者台帳CSV)
    protected IBatchFlowCommand reportProcess() {

        return loopBatch(HanyoListJukyushaDaichoProcess.class)
                .arguments(getParameter().toHanyoRisutoJyukyusyaProcessParameter())
                .define();
    }
}
