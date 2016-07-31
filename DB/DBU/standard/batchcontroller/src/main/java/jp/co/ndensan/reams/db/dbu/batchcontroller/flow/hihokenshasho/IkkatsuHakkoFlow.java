/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.batchcontroller.flow.hihokenshasho;

import jp.co.ndensan.reams.db.dbu.batchcontroller.step.hihokenshasho.HihokenshashoA4ReportProcess;
import jp.co.ndensan.reams.db.dbu.batchcontroller.step.hihokenshasho.HihokenshashoB4ReportProcess;
import jp.co.ndensan.reams.db.dbu.batchcontroller.step.hihokenshasho.IchijiTableCreateProcess;
import jp.co.ndensan.reams.db.dbu.batchcontroller.step.hihokenshasho.IchijiTableUpdateProcess;
import jp.co.ndensan.reams.db.dbu.batchcontroller.step.hihokenshasho.IchiranHyoReportProcess;
import jp.co.ndensan.reams.db.dbu.batchcontroller.step.hihokenshasho.IkkatsuHakkoDBInsertProcess;
import jp.co.ndensan.reams.db.dbu.batchcontroller.step.hihokenshasho.TaishoShutokuProcess;
import jp.co.ndensan.reams.db.dbu.definition.batchprm.hihokenshasho.IkkatsuHakkoBatchParameter;
import jp.co.ndensan.reams.uz.uza.batch.Step;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;
import jp.co.ndensan.reams.uz.uza.batch.flow.IBatchFlowCommand;

/**
 * 被保険者証一括発行_バッチフロークラスです
 *
 * @reamsid_L DBU-0420-020 duanzhanli
 *
 */
public class IkkatsuHakkoFlow extends BatchFlowBase<IkkatsuHakkoBatchParameter> {

    @Override
    protected void defineFlow() {
        executeStep(CREATEICHIJITABLE_PROCESS);
        executeStep(TAISHOSHUTOKU_PROCESS);
        executeStep(ICHIJITABLEUPDATE_PROCESS);
        executeStep(ICHIRANHYOREPORTPROCESS);
        executeStep(HIHOKENSHASHOB4);
        executeStep(HIHOKENSHASHOA4);
        if (!getParameter().isTestShutsuryokuFlag()) {
            executeStep(IKKATSUHAKKODBINSERT_PROCESS);
        }
    }

    private static final String CREATEICHIJITABLE_PROCESS = "createIchijiTableProcess";
    private static final String TAISHOSHUTOKU_PROCESS = "taishoShutokuProcess";
    private static final String ICHIJITABLEUPDATE_PROCESS = "ichijiTableUpdateProcess";
    private static final String ICHIRANHYOREPORTPROCESS = "IchiranHyoReportProcess";
    private static final String IKKATSUHAKKODBINSERT_PROCESS = "ikkatsuHakkoDBInsertProcess";
    private static final String HIHOKENSHASHOB4 = "hihokenshashoB4";
    private static final String HIHOKENSHASHOA4 = "hihokenshashoA4";

    /**
     * 一時テーブルの作成とデータの登録です。
     *
     * @return 登録件数
     */
    @Step(CREATEICHIJITABLE_PROCESS)
    protected IBatchFlowCommand createIchijiTableProcess() {
        return simpleBatch(IchijiTableCreateProcess.class).arguments(getParameter().toIkkatsuHakkoProcessParameter()).define();
    }

    /**
     * 対象チェックです。
     *
     * @return 登録件数
     */
    @Step(TAISHOSHUTOKU_PROCESS)
    protected IBatchFlowCommand taishoShutokuProcess() {
        return simpleBatch(TaishoShutokuProcess.class).arguments(getParameter().toIkkatsuHakkoProcessParameter()).define();
    }

    /**
     * 一時テーブルの更新処理です。
     *
     * @return 登録件数
     */
    @Step(ICHIJITABLEUPDATE_PROCESS)
    protected IBatchFlowCommand ichijiTableUpdateProcess() {
        return simpleBatch(IchijiTableUpdateProcess.class).arguments(getParameter().toIkkatsuHakkoProcessParameter()).define();
    }

    /**
     * 帳票「被保険者証発行一覧表」の出力処理クラスです。
     *
     * @return IchiranHyoReportProcess
     */
    @Step(ICHIRANHYOREPORTPROCESS)
    protected IBatchFlowCommand callIchiranHyoReportProcess() {
        return loopBatch(IchiranHyoReportProcess.class).arguments(getParameter().toIkkatsuHakkoProcessParameter()).define();
    }

    /**
     * 帳票「介護保険被保険者証（B4版）」の出力処理クラスです。
     *
     * @return IchiranHyoReportProcess
     */
    @Step(HIHOKENSHASHOB4)
    protected IBatchFlowCommand callHihokenshashoB4ReportProcess() {
        return loopBatch(HihokenshashoB4ReportProcess.class).arguments(getParameter().toIkkatsuHakkoProcessParameter()).define();
    }

    /**
     * 帳票「介護保険被保険者証（A4版）」の出力処理クラスです。
     *
     * @return IchiranHyoReportProcess
     */
    @Step(HIHOKENSHASHOA4)
    protected IBatchFlowCommand callHihokenshashoA4ReportProcess() {
        return loopBatch(HihokenshashoA4ReportProcess.class).arguments(getParameter().toIkkatsuHakkoProcessParameter()).define();
    }

    /**
     * DB登録です。
     *
     * @return 登録件数
     */
    @Step(IKKATSUHAKKODBINSERT_PROCESS)
    protected IBatchFlowCommand ikkatsuHakkoDBInsertProcess() {
        return simpleBatch(IkkatsuHakkoDBInsertProcess.class).arguments(getParameter().toIkkatsuHakkoProcessParameter()).define();
    }
}
