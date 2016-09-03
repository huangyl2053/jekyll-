/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.flow;

import jp.co.ndensan.reams.db.dbc.batchcontroller.step.dbc710160.HanyoListKogakuGassanKeisanKekkaRenrakuHyoNoProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.dbc710160.HanyoListKogakuGassanKeisanKekkaRenrakuHyoProcess;
import jp.co.ndensan.reams.db.dbc.definition.batchprm.DBC710160.DBC710160_HanyoListKogakuGassanKeisanKekkaRenrakuHyoParameter;
import jp.co.ndensan.reams.uz.uza.batch.Step;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;
import jp.co.ndensan.reams.uz.uza.batch.flow.IBatchFlowCommand;

/**
 * 汎用リスト出力(高額合算計算結果連絡票情報)Flowクラスです。
 *
 * @reamsid_L DBC-3100-020 jiangxiaolong
 */
public class DBC710160_HanyoListKogakuGassanKeisanKekkaRenrakuHyo
        extends BatchFlowBase<DBC710160_HanyoListKogakuGassanKeisanKekkaRenrakuHyoParameter> {

    private static final String CSV_EUC_PROCESS = "csvEucProcess";

    @Override
    protected void defineFlow() {
        executeStep(CSV_EUC_PROCESS);
    }

    @Step(CSV_EUC_PROCESS)
    IBatchFlowCommand csvEucProcess() {
        if (getParameter().is連番付加()) {
            return loopBatch(HanyoListKogakuGassanKeisanKekkaRenrakuHyoProcess.class)
                    .arguments(getParameter().toProcessParam()).define();
        }
        return loopBatch(HanyoListKogakuGassanKeisanKekkaRenrakuHyoNoProcess.class)
                .arguments(getParameter().toProcessParam()).define();
    }
}
