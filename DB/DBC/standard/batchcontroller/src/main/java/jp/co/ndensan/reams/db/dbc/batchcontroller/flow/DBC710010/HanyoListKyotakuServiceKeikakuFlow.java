/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.flow.DBC710010;

import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC710010.HanyoListKyotakuServiceKeikakuProcess;
import jp.co.ndensan.reams.db.dbc.definition.batchprm.hanyolistkyotakuservicekeikaku.HanyoListKyotakuServiceKeikakuBatchParameter;
import jp.co.ndensan.reams.uz.uza.batch.Step;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;
import jp.co.ndensan.reams.uz.uza.batch.flow.IBatchFlowCommand;

/**
 * 汎用リスト 居宅サービス計画クラスです。
 *
 * @reamsid_L DBC-3091-020 surun
 */
public class HanyoListKyotakuServiceKeikakuFlow
        extends BatchFlowBase<HanyoListKyotakuServiceKeikakuBatchParameter> {

    private static final String CSV_EUC_PROCESS = "csvEucProcess";

    @Override
    protected void defineFlow() {
        executeStep(CSV_EUC_PROCESS);
    }

    @Step(CSV_EUC_PROCESS)
    IBatchFlowCommand csvEucProcess() {
        return loopBatch(HanyoListKyotakuServiceKeikakuProcess.class).define();
    }

}
