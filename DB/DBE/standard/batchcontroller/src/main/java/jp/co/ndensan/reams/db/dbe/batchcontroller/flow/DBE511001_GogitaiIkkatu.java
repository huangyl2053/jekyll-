/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.batchcontroller.flow;

import jp.co.ndensan.reams.db.dbe.batchcontroller.step.DBE511001.GogitaiJohoIkkatuSakuseiProcess;
import jp.co.ndensan.reams.db.dbe.definition.batchprm.DBE511001.DBE511001_GogitaiIkkatuParameter;
import jp.co.ndensan.reams.uz.uza.batch.Step;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;
import jp.co.ndensan.reams.uz.uza.batch.flow.IBatchFlowCommand;

/**
 * 合議体情報一括作成_バッチフロークラスです
 *
 * @reamsid_L DBE-0090-020 chengsanyuan
 */
public class DBE511001_GogitaiIkkatu extends BatchFlowBase<DBE511001_GogitaiIkkatuParameter> {

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
