/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.batchcontroller.flow.kaigoninteishinsakaischedulekagami;

import jp.co.ndensan.reams.db.dbe.batchcontroller.step.kaigoninteishinsakaischedulekagami.KaigoNinteiShinsakaiScheduleKagamiProcess;
import jp.co.ndensan.reams.db.dbe.definition.batchprm.kaigoninteishinsakaischedule.KaigoNinteiShinsakaiScheduleBatchParamter;
import jp.co.ndensan.reams.uz.uza.batch.Step;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;
import jp.co.ndensan.reams.uz.uza.batch.flow.IBatchFlowCommand;

/**
 *
 * 介護認定審査会スケジュール表かがみ_バッチフロークラスです。
 */
public class KaigoNinteiShinsakaiScheduleKagamiFlow extends BatchFlowBase<KaigoNinteiShinsakaiScheduleBatchParamter> {

    private static final String SHINSAKAISCHEDULEKAGAMIHYO = "shinsakaischedulekagamihyo";

    @Override
    protected void defineFlow() {
        executeStep(SHINSAKAISCHEDULEKAGAMIHYO);
    }

    /**
     * 帳票「介護認定審査会スケジュール表」のProcessです。
     *
     * @return 帳票_介護認定審査会スケジュール表
     */
    @Step(SHINSAKAISCHEDULEKAGAMIHYO)
    protected IBatchFlowCommand shinsakaiSchedulekagami() {
        return loopBatch(KaigoNinteiShinsakaiScheduleKagamiProcess.class)
                .arguments(getParameter().toKaigoNinteiShinsakaiScheduleKagamiProcessParamter()).define();
    }
}
