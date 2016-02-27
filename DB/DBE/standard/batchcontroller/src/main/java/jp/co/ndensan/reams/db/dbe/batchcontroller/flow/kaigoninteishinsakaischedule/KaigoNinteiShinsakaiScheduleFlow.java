/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.batchcontroller.flow.kaigoninteishinsakaischedule;

import jp.co.ndensan.reams.db.dbe.batchcontroller.step.kaigoninteishinsakaischedule.KaigoNinteiShinsakaiScheduleProcess;
import jp.co.ndensan.reams.db.dbe.definition.batchprm.kaigoninteishinsakaischedule.KaigoNinteiShinsakaiScheduleBatchParamter;
import jp.co.ndensan.reams.uz.uza.batch.Step;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;
import jp.co.ndensan.reams.uz.uza.batch.flow.IBatchFlowCommand;

/**
 *
 * 介護認定審査会スケジュール表_バッチフロークラスです。
 */
public class KaigoNinteiShinsakaiScheduleFlow extends BatchFlowBase<KaigoNinteiShinsakaiScheduleBatchParamter> {

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
        return loopBatch(KaigoNinteiShinsakaiScheduleProcess.class)
                .arguments(getParameter().toKaigoNinteiShinsakaiScheduleProcessParamter()).define();
    }
}
