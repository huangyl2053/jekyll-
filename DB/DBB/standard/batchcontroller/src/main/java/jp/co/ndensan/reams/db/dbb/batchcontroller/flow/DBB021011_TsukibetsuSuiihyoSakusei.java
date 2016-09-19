/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.batchcontroller.flow;

import jp.co.ndensan.reams.db.dbb.batchcontroller.step.dbb021011.CreateTsukibetsuSuiihyoProcess;
import jp.co.ndensan.reams.db.dbb.batchcontroller.step.dbb021011.FutuChoushuProcess;
import jp.co.ndensan.reams.db.dbb.batchcontroller.step.dbb021011.GemmenReportProcess;
import jp.co.ndensan.reams.db.dbb.batchcontroller.step.dbb021011.GokeyBubunKoumokuProcess;
import jp.co.ndensan.reams.db.dbb.batchcontroller.step.dbb021011.GoukeyiReportProcess;
import jp.co.ndensan.reams.db.dbb.batchcontroller.step.dbb021011.KoumokuGoukeyProcess;
import jp.co.ndensan.reams.db.dbb.batchcontroller.step.dbb021011.KoumokuSyoukeyiProcess;
import jp.co.ndensan.reams.db.dbb.batchcontroller.step.dbb021011.TokubetuProcess;
import jp.co.ndensan.reams.db.dbb.definition.batchprm.DBB021011.DBB021011_TsukibetsuSuiihyoSakuseiParameter;
import jp.co.ndensan.reams.uz.uza.batch.Step;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;
import jp.co.ndensan.reams.uz.uza.batch.flow.IBatchFlowCommand;

/**
 * 月別推移表作成Flowクラスです。
 *
 * @reamsid_L DBB-0760-030 lishengli
 */
public class DBB021011_TsukibetsuSuiihyoSakusei extends BatchFlowBase<DBB021011_TsukibetsuSuiihyoSakuseiParameter> {

    @Override
    protected void defineFlow() {
        executeStep(REPORT1_PROCESS);
        executeStep(KOUMOKUSYOUKEYI_PROCESS);
        executeStep(KOUMOKUGOUKEY_PROCESS);
        executeStep(GOKEYBUBUNKOUMOKU_PROCESS);
        executeStep(FUTUCHOUSHU_PROCESS);
        executeStep(TOKUBETU_PROCESS);
        executeStep(GOUKEYIREPORT_PROCESS);
        executeStep(GEMMENREPORT_PROCESS);
    }
    private static final String REPORT1_PROCESS = "report1Process";
    private static final String KOUMOKUSYOUKEYI_PROCESS = "koumokuSyoukeyiProcess";
    private static final String KOUMOKUGOUKEY_PROCESS = "koumokuGoukeyProcess";
    private static final String GOKEYBUBUNKOUMOKU_PROCESS = "gokeyBubunKoumokuProcess";
    private static final String FUTUCHOUSHU_PROCESS = "futuChoushuProcess";
    private static final String TOKUBETU_PROCESS = "tokubetuProcess";
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
     * koumokuSyoukeyiProcessです。
     *
     * @return IBatchFlowCommand
     */
    @Step(KOUMOKUSYOUKEYI_PROCESS)
    protected IBatchFlowCommand koumokuSyoukeyiProcess() {
        return loopBatch(KoumokuSyoukeyiProcess.class)
                .arguments(getParameter().toCreateTsukibetsuSuiihyoProcessParameter()).define();
    }

    /**
     * koumokuGoukeyProcessです。
     *
     * @return IBatchFlowCommand
     */
    @Step(KOUMOKUGOUKEY_PROCESS)
    protected IBatchFlowCommand koumokuGoukeyProcess() {
        return loopBatch(KoumokuGoukeyProcess.class)
                .arguments(getParameter().toCreateTsukibetsuSuiihyoProcessParameter()).define();
    }

    /**
     * gokeyBubunKoumokuProcessです。
     *
     * @return IBatchFlowCommand
     */
    @Step(GOKEYBUBUNKOUMOKU_PROCESS)
    protected IBatchFlowCommand gokeyBubunKoumokuProcess() {
        return loopBatch(GokeyBubunKoumokuProcess.class)
                .arguments(getParameter().toCreateTsukibetsuSuiihyoProcessParameter()).define();
    }

    /**
     * futuChoushuProcessです。
     *
     * @return IBatchFlowCommand
     */
    @Step(FUTUCHOUSHU_PROCESS)
    protected IBatchFlowCommand futuChoushuProcess() {
        return loopBatch(FutuChoushuProcess.class)
                .arguments(getParameter().toCreateTsukibetsuSuiihyoProcessParameter()).define();
    }

    /**
     * tokubetuProcessです。
     *
     * @return IBatchFlowCommand
     */
    @Step(TOKUBETU_PROCESS)
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
