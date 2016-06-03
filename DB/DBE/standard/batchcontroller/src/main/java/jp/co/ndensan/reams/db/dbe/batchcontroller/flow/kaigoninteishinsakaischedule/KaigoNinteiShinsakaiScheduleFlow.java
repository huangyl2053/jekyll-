/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.batchcontroller.flow.kaigoninteishinsakaischedule;

import jp.co.ndensan.reams.db.dbe.batchcontroller.step.kaigoninteishinsakaischedule.KaigoNinteiShinsakaiScheduleProcess;
import jp.co.ndensan.reams.db.dbe.batchcontroller.step.kaigoninteishinsakaischedule.NenkanReportProcess;
import jp.co.ndensan.reams.db.dbe.definition.batchprm.kaigoninteishinsakaischedule.KaigoNinteiShinsakaiScheduleBatchParamter;
import jp.co.ndensan.reams.uz.uza.batch.Step;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;
import jp.co.ndensan.reams.uz.uza.batch.flow.IBatchFlowCommand;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * 介護認定審査会スケジュール表_バッチフロークラスです。
 *
 * @reamsid_L DBE-0130-090 duanzhanli
 */
public class KaigoNinteiShinsakaiScheduleFlow extends BatchFlowBase<KaigoNinteiShinsakaiScheduleBatchParamter> {

    private static final String SHINSAKAISCHEDULEHYO = "shinsakaischedulehyo";
    private static final String NENKAN = "nenkanReport";
    private final RString 帳票出力区分1 = new RString("1");
    private final RString 帳票出力区分2 = new RString("2");

    @Override
    protected void defineFlow() {
        if (!RString.isNullOrEmpty(getParameter().getChohyoShutsuryokuKubun())
                && getParameter().getChohyoShutsuryokuKubun().equals(帳票出力区分1)) {
            executeStep(SHINSAKAISCHEDULEHYO);
        }
        if (!RString.isNullOrEmpty(getParameter().getChohyoShutsuryokuKubun())
                && getParameter().getChohyoShutsuryokuKubun().equals(帳票出力区分2)) {
            executeStep(SHINSAKAISCHEDULEHYO);
            executeStep(NENKAN);
        }
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

    /**
     * 帳票「護認定審査会スケジュール表(年間)」のProcessです。
     *
     * @return 帳票_介護認定審査会スケジュール表(年間)
     */
    @Step(NENKAN)
    protected IBatchFlowCommand nenkanReportProcess() {
        return loopBatch(NenkanReportProcess.class)
                .arguments(getParameter().toKaigoNinteiShinsakaiScheduleProcessParamter()).define();
    }
}
