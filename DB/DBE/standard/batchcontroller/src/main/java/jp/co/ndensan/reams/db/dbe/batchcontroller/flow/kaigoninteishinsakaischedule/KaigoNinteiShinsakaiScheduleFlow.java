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
//      TODO バッチ「介護認定審査会スケジュール表かがみ」を未実装するので、TODO事項は記述です。
//        if (!getParameter().getShinsakaiIinCodeList().isEmpty()) {
//            // executeStep(SHINSAKAISCHEDULEKAGAMI);
//        }
    }

    /**
     * 帳票「介護認定審査会スケジュール表」のProcessです。
     *
     * @return 帳票_介護認定審査会スケジュール表
     */
    @Step(SHINSAKAISCHEDULEHYO)
    protected IBatchFlowCommand shinsakaiSchedule() {
        return loopBatch(KaigoNinteiShinsakaiScheduleProcess.class)
                .arguments(getParameter().toKaigoNinteiShinsakaiScheduleProcessParamter()).define();
    }

//    TODO　仕様変更1.02～1.0.3が未対応
    /**
     * 帳票「護認定審査会スケジュール表(年間)」のProcessです。
     *
     * @return 帳票_介護認定審査会スケジュール表(年間)
     */
//    @Step(SHINSAKAISCHEDULEHYO)
//    protected IBatchFlowCommand shinsakaiSchedule() {
//        return loopBatch(KaigoNinteiShinsakaiScheduleProcess.class)
//                .arguments(getParameter().toKaigoNinteiShinsakaiScheduleProcessParamter()).define();
//    }
}
