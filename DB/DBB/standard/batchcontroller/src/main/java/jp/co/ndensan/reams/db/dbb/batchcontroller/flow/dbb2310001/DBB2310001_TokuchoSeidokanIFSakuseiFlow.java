/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.batchcontroller.flow.dbb2310001;

import jp.co.ndensan.reams.db.dbb.batchcontroller.step.dbb2310001.TokuchoSeidokanIFSakuseiDBUpdateProcess;
import jp.co.ndensan.reams.db.dbb.definition.batchprm.tokuchoseidokanifsakusei.TokuchoSeidokanIFSakuseiBatchParameter;
import jp.co.ndensan.reams.uz.uza.batch.Step;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;
import jp.co.ndensan.reams.uz.uza.batch.flow.IBatchFlowCommand;

/**
 * DBB2310001_TokuchoSeidokanIFSakuseiFlowのクラスです。
 *
 * @reamsid_L DBB-1830-040 liuyang
 */
public class DBB2310001_TokuchoSeidokanIFSakuseiFlow extends BatchFlowBase<TokuchoSeidokanIFSakuseiBatchParameter> {

    @Override
    protected void defineFlow() {
        executeStep(UPDATE_PROCESS);
    }
    private static final String UPDATE_PROCESS = "updateProcess";

    /**
     * updateProcessです。
     *
     * @return DB更新パラメータ
     */
    @Step(UPDATE_PROCESS)
    protected IBatchFlowCommand updateProcess() {
        return loopBatch(TokuchoSeidokanIFSakuseiDBUpdateProcess.class).arguments(getParameter().
                toTokuchoSeidokanIFSakuseiDBUpdateProcessParameter()).define();
    }
}
