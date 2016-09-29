/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.batchcontroller.flow;

import jp.co.ndensan.reams.db.dbb.batchcontroller.step.dbb233001.CreateRenkeiFileProcess;
import jp.co.ndensan.reams.db.dbb.definition.batchprm.dbb233001.TokuchouSeidoKanIFRenkeiBatchParameter;
import jp.co.ndensan.reams.uz.uza.batch.Step;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;
import jp.co.ndensan.reams.uz.uza.batch.flow.IBatchFlowCommand;

/**
 * バッチ設計_DBB233001_特徴制度間Ｉ／Ｆ連携　の作成です。
 *
 * @reamsid_L DBB-1810-040 dengjiajia
 */
public class DBB233001_TokuchouSeidoKanIFRenkeiFlow extends BatchFlowBase<TokuchouSeidoKanIFRenkeiBatchParameter> {

    private static final String TOKUCHOUSEIDOKANIFRENKEI_PROCESS = "tokuchouSeidoKanIFRenkeiProcess";

    @Override
    protected void defineFlow() {
        executeStep(TOKUCHOUSEIDOKANIFRENKEI_PROCESS);
    }

    @Step(TOKUCHOUSEIDOKANIFRENKEI_PROCESS)
    IBatchFlowCommand tokuchouSeidoKanIFRenkeiProcess() {
        return loopBatch(CreateRenkeiFileProcess.class).define();
    }

}
