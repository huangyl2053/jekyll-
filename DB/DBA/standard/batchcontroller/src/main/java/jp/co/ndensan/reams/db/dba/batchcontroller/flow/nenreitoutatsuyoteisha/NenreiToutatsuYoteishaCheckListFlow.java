/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.batchcontroller.flow.nenreitoutatsuyoteisha;

import jp.co.ndensan.reams.db.dba.batchcontroller.step.nenreitoutatsuyoteisha.NenreiToutatsuYoteishaCheckListProcess;
import jp.co.ndensan.reams.db.dba.definition.batchprm.nenreitoutatsuyoteisha.INenreiToutatsuYoteishaCheckListBatchParameter;
import jp.co.ndensan.reams.uz.uza.batch.Step;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;
import jp.co.ndensan.reams.uz.uza.batch.flow.IBatchFlowCommand;

/**
 *
 * 年齢到達予定者チェックリスト_バッチフロークラスです。
 */
public class NenreiToutatsuYoteishaCheckListFlow extends BatchFlowBase<INenreiToutatsuYoteishaCheckListBatchParameter> {

    @Override
    protected void defineFlow() {
        executeStep(REPORT_PROCESS);
    }

    private static final String REPORT_PROCESS = "reportProcess";

    /**
     * batchProcessです。
     *
     * @return IBatchFlowCommand
     */
    @Step(REPORT_PROCESS)
    protected IBatchFlowCommand reportProcess() {
        return simpleBatch(NenreiToutatsuYoteishaCheckListProcess.class)
                .arguments(getParameter().toNenreiToutatsuYoteishaCheckListProcessParameter())
                .define();
    }

}
