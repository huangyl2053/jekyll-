/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.batchcontroller.flow;

import jp.co.ndensan.reams.db.dbe.batchcontroller.step.DBE514002.ShinsakaiScheduleKagamiProcess;
import jp.co.ndensan.reams.db.dbe.definition.batchprm.DBE514001.DBE514001_ShinsakaiScheduleParameter;
import jp.co.ndensan.reams.uz.uza.batch.Step;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;
import jp.co.ndensan.reams.uz.uza.batch.flow.IBatchFlowCommand;

/**
 *
 * 介護認定審査会スケジュール表かがみ_バッチフロークラスです。
 *
 * @reamsid_L DBE-0130-100 yaodongsheng
 */
public class DBE514002_ShinsakaiScheduleKagami extends BatchFlowBase<DBE514001_ShinsakaiScheduleParameter> {

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
        return loopBatch(ShinsakaiScheduleKagamiProcess.class)
                .arguments(getParameter().toKaigoNinteiShinsakaiScheduleKagamiProcessParamter()).define();
    }
}
