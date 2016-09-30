/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.batchcontroller.flow;

import jp.co.ndensan.reams.db.dbe.batchcontroller.step.DBE220003.NinteiChosaIraiProcess;
import jp.co.ndensan.reams.db.dbe.definition.batchprm.DBE220010.DBE220010_IraishoIkkatuParameter;
import jp.co.ndensan.reams.uz.uza.batch.Step;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;
import jp.co.ndensan.reams.uz.uza.batch.flow.IBatchFlowCommand;

/**
 *
 * 認定調査依頼発行一覧表_バッチフロークラスです。
 *
 * @reamsid_L DBE-0080-160 duanzhanli
 */
public class DBE220003_NinteichosaIraiHakko extends BatchFlowBase<DBE220010_IraishoIkkatuParameter> {

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
        return loopBatch(NinteiChosaIraiProcess.class)
                .arguments(getParameter().toNinteiChosaIraiProcessParamter()).define();
    }
}
