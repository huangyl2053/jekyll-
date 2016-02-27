/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.batchcontroller.flow.hihokenshasho;

import jp.co.ndensan.reams.db.dbu.batchcontroller.step.hihokenshasho.IchijiTableCreateProcess;
import jp.co.ndensan.reams.db.dbu.batchcontroller.step.hihokenshasho.IchijiTableUpdateProcess;
import jp.co.ndensan.reams.db.dbu.batchcontroller.step.hihokenshasho.IkkatsuHakkoDBInsertProcess;
import jp.co.ndensan.reams.db.dbu.batchcontroller.step.hihokenshasho.IkkatsuHakkoReportProcess;
import jp.co.ndensan.reams.db.dbu.batchcontroller.step.hihokenshasho.TaishoShutokuProcess;
import jp.co.ndensan.reams.db.dbu.definition.batchprm.hihokenshasho.IkkatsuHakkoBatchParameter;
import jp.co.ndensan.reams.uz.uza.batch.Step;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;
import jp.co.ndensan.reams.uz.uza.batch.flow.IBatchFlowCommand;

/**
 * 被保険者証一括発行_バッチフロークラスです
 */
public class IkkatsuHakkoFlow extends BatchFlowBase<IkkatsuHakkoBatchParameter> {

    @Override
    protected void defineFlow() {
        executeStep(CREATEICHIJITABLE_PROCESS);
        executeStep(TAISHOSHUTOKU_PROCESS);
        executeStep(ICHIJITABLEUPDATE_PROCESS);
        executeStep(IKKATSUHAKKOREPORT_PROCESS);
        executeStep(IKKATSUHAKKODBINSERT_PROCESS);
    }

    private static final String CREATEICHIJITABLE_PROCESS = "createIchijiTableProcess";
    private static final String TAISHOSHUTOKU_PROCESS = "taishoShutokuProcess";
    private static final String ICHIJITABLEUPDATE_PROCESS = "ichijiTableUpdateProcess";
    private static final String IKKATSUHAKKOREPORT_PROCESS = "ikkatsuHakkoReportProcess";
    private static final String IKKATSUHAKKODBINSERT_PROCESS = "ikkatsuHakkoDBInsertProcess"; //@Stepの定数はメソッドの近くに置くと見やすくていい。

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
     * 帳票出力パラメータの取得です。
     *
     * @return 帳票出力パラメータ
     */
    @Step(IKKATSUHAKKOREPORT_PROCESS)
    protected IBatchFlowCommand ikkatsuHakkoReportProcess() {
        return simpleBatch(IkkatsuHakkoReportProcess.class).arguments(getParameter().toIkkatsuHakkoProcessParameter()).define();
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
