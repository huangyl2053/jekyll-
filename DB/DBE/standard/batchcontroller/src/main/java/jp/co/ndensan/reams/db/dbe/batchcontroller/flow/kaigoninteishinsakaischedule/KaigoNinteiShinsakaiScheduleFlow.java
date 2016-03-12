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

    private static final String SHINSAKAISCHEDULEHYO = "shinsakaischedulehyo";

    @Override
    protected void defineFlow() {
        executeStep(SHINSAKAISCHEDULEHYO);
//      TODO 帳票「介護認定審査会スケジュール表かがみ」の呼び出す方式
//        if (!getParameter().getShinsakaiIinCodeList().isEmpty()) {
//            // executeStep(SHINSAKAISCHEDULEKAGAMI);
//        }
    }

    /**
     * 帳票「介護認定審査会スケジュール表」のProcessです。
     *
     * @return 帳票介護認定審査会スケジュール表
     */
    @Step(SHINSAKAISCHEDULEHYO)
    protected IBatchFlowCommand shinsakaiSchedule() {
        return loopBatch(KaigoNinteiShinsakaiScheduleProcess.class)
                .arguments(getParameter().toKaigoNinteiShinsakaiScheduleProcessParamter()).define();
    }

}
