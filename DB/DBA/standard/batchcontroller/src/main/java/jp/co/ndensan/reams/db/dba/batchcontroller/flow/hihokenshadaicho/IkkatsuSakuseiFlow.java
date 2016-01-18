/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.batchcontroller.flow.hihokenshadaicho;

import jp.co.ndensan.reams.db.dba.batchcontroller.step.hihokenshadaicho.IkkatsuSakuseiProcess;
import jp.co.ndensan.reams.db.dba.definition.batchprm.hihokenshadaicho.IkkatsuSakuseiBatchParameter;
import jp.co.ndensan.reams.uz.uza.batch.Step;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;
import jp.co.ndensan.reams.uz.uza.batch.flow.IBatchFlowCommand;

/**
 *
 * 被保険者台帳一括作成_バッチフロークラスです。
 */
public class IkkatsuSakuseiFlow extends BatchFlowBase<IkkatsuSakuseiBatchParameter> {

    @Override
    protected void defineFlow() {
        executeStep(REPORT_PROCESS);
    }

    private static final String REPORT_PROCESS = "reportProcess";

    /**
     * 帳票データ作成のProcessです。
     *
     * @return IkkatsuSakuseiProcess
     */
    @Step(REPORT_PROCESS)
    protected IBatchFlowCommand reportProcess() {
        return loopBatch(IkkatsuSakuseiProcess.class)
                .arguments(getParameter().toIkkatsuHakkoProcessParameter()).define();
    }
}
