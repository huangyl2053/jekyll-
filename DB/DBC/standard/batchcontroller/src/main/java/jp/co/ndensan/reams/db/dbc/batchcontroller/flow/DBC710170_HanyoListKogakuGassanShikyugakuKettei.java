/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.flow;

import jp.co.ndensan.reams.db.dbc.batchcontroller.step.dbc710170.HanyoListKogakuGassanShikyugakuKetteiProcess;
import jp.co.ndensan.reams.db.dbc.definition.batchprm.DBC710170.DBC710170_HanyoListKogakuGassanShikyugakuKetteiParameter;
import jp.co.ndensan.reams.uz.uza.batch.Step;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;
import jp.co.ndensan.reams.uz.uza.batch.flow.IBatchFlowCommand;

/**
 * 汎用リスト出力(高額合算支給額決定情報)Flowクラスです。
 *
 * @reamsid_L DBC-3101-020 jiangxiaolong
 */
public class DBC710170_HanyoListKogakuGassanShikyugakuKettei
        extends BatchFlowBase<DBC710170_HanyoListKogakuGassanShikyugakuKetteiParameter> {

    private static final String CSV_EUC_PROCESS = "csvEucProcess";

    @Override
    protected void defineFlow() {
        executeStep(CSV_EUC_PROCESS);
    }

    @Step(CSV_EUC_PROCESS)
    IBatchFlowCommand csvEucProcess() {
        return loopBatch(HanyoListKogakuGassanShikyugakuKetteiProcess.class)
                .arguments(getParameter().toProcessParam()).define();
    }

}
