/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.batchcontroller.flow;

import jp.co.ndensan.reams.db.dbb.batchcontroller.step.DBB022002.HanyoListShotokuJohoNoRenbanProcess;
import jp.co.ndensan.reams.db.dbb.batchcontroller.step.DBB022002.HanyoListShotokuJohoProcess;
import jp.co.ndensan.reams.db.dbb.definition.batchprm.DBB022002.DBB022002_ShotokuJohoHanyoListSakuseiParameter;
import jp.co.ndensan.reams.uz.uza.batch.Step;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;
import jp.co.ndensan.reams.uz.uza.batch.flow.IBatchFlowCommand;

/**
 * バッチ設計_DBBBT22002_汎用リスト 所得情報クラスです。
 *
 * @reamsid_L DBB-1901-030 surun
 */
public class DBB022002_ShotokuJohoHanyoListSakusei extends BatchFlowBase<DBB022002_ShotokuJohoHanyoListSakuseiParameter> {

    private static final String CSV_EUC_PROCESS = "csvEucProcess";

    @Override
    protected void defineFlow() {
        executeStep(CSV_EUC_PROCESS);
    }

    @Step(CSV_EUC_PROCESS)
    IBatchFlowCommand csvEucProcess() {
        if (getParameter().is連番付加()) {
            return loopBatch(HanyoListShotokuJohoProcess.class)
                    .arguments(getParameter().toProcessParameter()).define();
        }
        return loopBatch(HanyoListShotokuJohoNoRenbanProcess.class)
                .arguments(getParameter().toProcessParameter()).define();
    }

}
