/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.flow.dbc710020;

import jp.co.ndensan.reams.db.dbc.batchcontroller.step.dbc710020.HanyoListShokanbaraiJokyoNoRenbanProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.dbc710020.HanyoListShokanbaraiJokyoProcess;
import jp.co.ndensan.reams.db.dbc.definition.batchprm.hanyolistshokanbaraijokyo.HanyoListShokanbaraiJokyoBatchParameter;
import jp.co.ndensan.reams.uz.uza.batch.Step;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;
import jp.co.ndensan.reams.uz.uza.batch.flow.IBatchFlowCommand;

/**
 * 汎用リスト出力(償還払い状況)Flow
 *
 * @reamsid_L DBC-3093-020 chenaoqi
 */
public class DBC710020_HanyoListShokanbaraiJokyoFlow
        extends BatchFlowBase<HanyoListShokanbaraiJokyoBatchParameter> {

    private static final String CSV_EUC_PROCESS = "csvEucProcess";

    @Override
    protected void defineFlow() {
        executeStep(CSV_EUC_PROCESS);
    }

    @Step(CSV_EUC_PROCESS)
    IBatchFlowCommand csvEucProcess() {
        if (getParameter().is連番付加()) {
            return loopBatch(HanyoListShokanbaraiJokyoProcess.class)
                    .arguments(getParameter().toProcessParam()).define();
        }
        return loopBatch(HanyoListShokanbaraiJokyoNoRenbanProcess.class)
                .arguments(getParameter().toProcessParam()).define();
    }
}
