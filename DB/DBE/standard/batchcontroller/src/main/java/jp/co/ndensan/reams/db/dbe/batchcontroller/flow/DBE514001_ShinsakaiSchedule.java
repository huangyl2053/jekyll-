/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.batchcontroller.flow;

import jp.co.ndensan.reams.db.dbe.batchcontroller.step.DBE514001.KaigoNinteiShinsakaiScheduleProcess;
import jp.co.ndensan.reams.db.dbe.batchcontroller.step.DBE514001.NenkanReportProcess;
import jp.co.ndensan.reams.db.dbe.definition.batchprm.DBE514001.DBE514001_ShinsakaiScheduleParameter;
import jp.co.ndensan.reams.uz.uza.batch.Step;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;
import jp.co.ndensan.reams.uz.uza.batch.flow.IBatchFlowCommand;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * 介護認定審査会スケジュール表_バッチフロークラスです。
 *
 * @reamsid_L DBE-0130-090 duanzhanli
 */
public class DBE514001_ShinsakaiSchedule extends BatchFlowBase<DBE514001_ShinsakaiScheduleParameter> {

    private static final String SHINSAKAISCHEDULEHYO = "shinsakaischedulehyo";
    private static final String NENKAN = "nenkanReport";
    private static final String CALL_KAGAMIFLOW = "DBE514002_ShinsakaiScheduleKagami";
    private static final RString SCHEDULEKAGAMIFLOW_FLOWID = new RString("DBE514002_ShinsakaiScheduleKagami");
    private final RString 帳票出力区分1 = new RString("1");
    private final RString 帳票出力区分2 = new RString("2");

    @Override
    protected void defineFlow() {
        if (getParameter().getShinsakaiIinCodeList() != null
                && !getParameter().getShinsakaiIinCodeList().isEmpty()) {

            if (getParameter().getChohyoShutsuryokuKubun().equals(帳票出力区分1)) {
                executeStep(SHINSAKAISCHEDULEHYO);
                executeStep(CALL_KAGAMIFLOW);
            }
            if (getParameter().getChohyoShutsuryokuKubun().equals(帳票出力区分2)) {
                executeStep(SHINSAKAISCHEDULEHYO);
                executeStep(CALL_KAGAMIFLOW);
                executeStep(NENKAN);
            }
        } else {
            if (getParameter().getChohyoShutsuryokuKubun().equals(帳票出力区分1)) {
                executeStep(SHINSAKAISCHEDULEHYO);
            }
            if (getParameter().getChohyoShutsuryokuKubun().equals(帳票出力区分2)) {
                executeStep(SHINSAKAISCHEDULEHYO);
                executeStep(NENKAN);
            }
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

    /**
     * 介護認定審査会スケジュール表かがみバッチのです。
     *
     * @return KaigoNinteiShinsakaiScheduleKagamiFlow
     */
    @Step(CALL_KAGAMIFLOW)
    protected IBatchFlowCommand callScheduleKagamiFlow() {
        return otherBatchFlow(SCHEDULEKAGAMIFLOW_FLOWID, SubGyomuCode.DBE認定支援, getParameter()).define();
    }
}
