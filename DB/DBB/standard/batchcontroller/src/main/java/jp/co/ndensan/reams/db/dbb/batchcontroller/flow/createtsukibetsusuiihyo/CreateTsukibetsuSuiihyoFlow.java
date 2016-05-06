/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.batchcontroller.flow.createtsukibetsusuiihyo;

import jp.co.ndensan.reams.db.dbb.batchcontroller.step.createtsukibetsusuiihyo.CreateTsukibetsuSuiihyoProcess;
import jp.co.ndensan.reams.db.dbb.batchcontroller.step.createtsukibetsusuiihyo.GemmenReportProcess;
import jp.co.ndensan.reams.db.dbb.batchcontroller.step.createtsukibetsusuiihyo.GoukeyiReportProcess;
import jp.co.ndensan.reams.db.dbb.batchcontroller.step.createtsukibetsusuiihyo.TokubetuProcess;
import jp.co.ndensan.reams.db.dbb.definition.batchprm.createtsukibetsusuiihyo.CreateTsukibetsuSuiihyoBatchParameter;
import jp.co.ndensan.reams.uz.uza.batch.Step;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;
import jp.co.ndensan.reams.uz.uza.batch.flow.IBatchFlowCommand;

/**
 * 月別推移表作成Flowクラスです。
 *
 * @reamsid_L DBB-0760-030 lishengli
 */
public class CreateTsukibetsuSuiihyoFlow extends BatchFlowBase<CreateTsukibetsuSuiihyoBatchParameter> {

    @Override
    protected void defineFlow() {
        executeStep(REPORT1_PROCESS);
        executeStep(REPORT2_PROCESS);
        executeStep(GOUKEYIREPORT_PROCESS);
        executeStep(GEMMENREPORT_PROCESS);
    }
    private static final String REPORT1_PROCESS = "report1Process";
    private static final String REPORT2_PROCESS = "report2Process";
    private static final String GOUKEYIREPORT_PROCESS = "goukeyiReportProcess";
    private static final String GEMMENREPORT_PROCESS = "gemmenReportProcess";

    /**
     * batchProcessです。
     *
     * @return IBatchFlowCommand
     */
    @Step(REPORT1_PROCESS)
    protected IBatchFlowCommand reportProcess() {
        return loopBatch(CreateTsukibetsuSuiihyoProcess.class)
                .arguments(getParameter().toCreateTsukibetsuSuiihyoProcessParameter()).define();
    }

    /**
     * tokubetuProcessです。
     *
     * @return IBatchFlowCommand
     */
    @Step(REPORT2_PROCESS)
    protected IBatchFlowCommand tokubetuProcess() {
        return loopBatch(TokubetuProcess.class)
                .arguments(getParameter().toCreateTsukibetsuSuiihyoProcessParameter()).define();
    }

    /**
     * goukeyiReportProcessです。
     *
     * @return IBatchFlowCommand
     */
    @Step(GOUKEYIREPORT_PROCESS)
    protected IBatchFlowCommand goukeyiReportProcess() {
        return loopBatch(GoukeyiReportProcess.class)
                .arguments(getParameter().toCreateTsukibetsuSuiihyoProcessParameter()).define();
    }

    /**
     * gemmenReportProcessです。
     *
     * @return IBatchFlowCommand
     */
    @Step(GEMMENREPORT_PROCESS)
    protected IBatchFlowCommand gemmenReportProcess() {
        return loopBatch(GemmenReportProcess.class)
                .arguments(getParameter().toCreateTsukibetsuSuiihyoProcessParameter()).define();
    }
}
