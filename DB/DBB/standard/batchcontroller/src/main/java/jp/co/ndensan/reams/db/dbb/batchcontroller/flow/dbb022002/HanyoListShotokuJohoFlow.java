/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.batchcontroller.flow.dbb022002;

import jp.co.ndensan.reams.db.dbb.batchcontroller.step.dbb022002.HanyoListShotokuJohoProcess;
import jp.co.ndensan.reams.db.dbb.definition.batchprm.hanyolistshotokujoho.HanyoListShotokuJohoBatchParameter;
import jp.co.ndensan.reams.uz.uza.batch.Step;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;
import jp.co.ndensan.reams.uz.uza.batch.flow.IBatchFlowCommand;

/**
 * バッチ設計_DBBBT22002_汎用リスト 所得情報クラスです。
 *
 * @reamsid_L DBB-1901-030 surun
 */
public class HanyoListShotokuJohoFlow extends BatchFlowBase<HanyoListShotokuJohoBatchParameter> {

    private static final String CSV_EUC_PROCESS = "csvEucProcess";

    @Override
    protected void defineFlow() {
        executeStep(CSV_EUC_PROCESS);
    }

    @Step(CSV_EUC_PROCESS)
    IBatchFlowCommand csvEucProcess() {
        return loopBatch(HanyoListShotokuJohoProcess.class)
                .arguments(getParameter().toProcessParameter()).define();
    }

}
