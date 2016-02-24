/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.batchcontroller.flow.keisangojoho;

import jp.co.ndensan.reams.db.dbb.batchcontroller.step.keisangojoho.KeisangoJohoSakuseiProcess;
import jp.co.ndensan.reams.db.dbb.definition.batchprm.keisangojoho.KeisangoJohoSakuseiBatchParamter;
import jp.co.ndensan.reams.uz.uza.batch.Step;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;
import jp.co.ndensan.reams.uz.uza.batch.flow.IBatchFlowCommand;

/**
 *
 * 計算後情報作成_バッチフロークラスです。
 */
public class KeisangoJohoSakuseiFlow extends BatchFlowBase<KeisangoJohoSakuseiBatchParamter> {

    @Override
    protected void defineFlow() {
        executeStep(REPORT_PROCESS);
    }

    private static final String REPORT_PROCESS = "reportProcess";

    /**
     * 帳票データ作成のProcessです。
     *
     * @return NinteiChosaIraiProcess
     */
    @Step(REPORT_PROCESS)
    protected IBatchFlowCommand reportProcess() {
        return loopBatch(KeisangoJohoSakuseiProcess.class)
                .arguments(getParameter().toKeisangoJohoSakuseiProcessParamter()).define();
    }
}
