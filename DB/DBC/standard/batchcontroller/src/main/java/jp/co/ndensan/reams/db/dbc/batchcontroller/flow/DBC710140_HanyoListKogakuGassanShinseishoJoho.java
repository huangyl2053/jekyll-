/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.flow;

import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC710140.HanyoListKogakuGassanShinseishoNoRenbanProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC710140.HanyoListKogakuGassanShinseishoProcess;
import jp.co.ndensan.reams.db.dbc.definition.batchprm.DBC710140.DBC710140_HanyoListKogakuGassanShinseishoJohoParameter;
import jp.co.ndensan.reams.uz.uza.batch.Step;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;
import jp.co.ndensan.reams.uz.uza.batch.flow.IBatchFlowCommand;

/**
 * バッチ設計_DBCBT23014_汎用リスト出力(高額合算申請書情報)Flow
 *
 * @reamsid_L DBC-3103-020 fuyanling
 */
public class DBC710140_HanyoListKogakuGassanShinseishoJoho
        extends BatchFlowBase<DBC710140_HanyoListKogakuGassanShinseishoJohoParameter> {

    private static final String CSV_EUC_PROCESS = "csvEucProcess";

    @Override
    protected void defineFlow() {
        executeStep(CSV_EUC_PROCESS);
    }

    @Step(CSV_EUC_PROCESS)
    IBatchFlowCommand csvEucProcess() {

        if (getParameter().isRebanFuka()) {
            return loopBatch(HanyoListKogakuGassanShinseishoProcess.class)
                    .arguments(getParameter().toProcessParam()).define();
        }
        return loopBatch(HanyoListKogakuGassanShinseishoNoRenbanProcess.class)
                .arguments(getParameter().toProcessParam()).define();

    }
}
