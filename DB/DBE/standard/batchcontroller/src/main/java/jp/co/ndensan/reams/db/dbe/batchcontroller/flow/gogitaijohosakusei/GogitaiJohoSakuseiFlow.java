/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.batchcontroller.flow.gogitaijohosakusei;

import jp.co.ndensan.reams.db.dbe.batchcontroller.step.gogitaijohosakusei.GogitaiJohoIkkatuSakuseiProcess;
import jp.co.ndensan.reams.db.dbe.definition.batchprm.gogitaijohosakusei.GogitaiJohoSakuseiBatchParamter;
import jp.co.ndensan.reams.uz.uza.batch.Step;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;
import jp.co.ndensan.reams.uz.uza.batch.flow.IBatchFlowCommand;

/**
 * 合議体情報一括作成_バッチフロークラスです
 */
public class GogitaiJohoSakuseiFlow extends BatchFlowBase<GogitaiJohoSakuseiBatchParamter> {

    @Override
    protected void defineFlow() {
        executeStep(IKKATU_SAKUSEI_PROCESS);
    }

    private static final String IKKATU_SAKUSEI_PROCESS = "ikkatuSakuseiProcess";

    @Step(IKKATU_SAKUSEI_PROCESS)
    IBatchFlowCommand ikkatuSakuseiProcess() {
        return loopBatch(GogitaiJohoIkkatuSakuseiProcess.class)
                .arguments(getParameter().toGogitaiJohoSakuseiProcessParamter())
                .define();
    }
}
