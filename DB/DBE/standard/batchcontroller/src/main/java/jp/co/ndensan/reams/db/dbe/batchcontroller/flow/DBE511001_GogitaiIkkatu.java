/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.batchcontroller.flow;

import jp.co.ndensan.reams.db.dbe.batchcontroller.step.DBE511001.GogitaiJohoTorikomiProcess;
import jp.co.ndensan.reams.db.dbe.batchcontroller.step.DBE511001.GogitaiJohoSakuseiProcess;
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
        executeStep(合議体情報取込);
        executeStep(合議体情報作成);
    }

    private static final String 合議体情報取込 = "GogitaiJohoTorikomiProcess";

    @Step(合議体情報取込)
    IBatchFlowCommand dbInsert1() {
        return loopBatch(GogitaiJohoTorikomiProcess.class)
                .arguments(getParameter().toGogitaiJohoSakuseiProcessParamter())
                .define();
    }

    private static final String 合議体情報作成 = "GogitaiJohoSakuseiProcess";

    @Step(合議体情報作成)
    IBatchFlowCommand dbInsert2() {
        return loopBatch(GogitaiJohoSakuseiProcess.class)
                .arguments(getParameter().toGogitaiJohoSakuseiProcessParamter())
                .define();
    }

}
