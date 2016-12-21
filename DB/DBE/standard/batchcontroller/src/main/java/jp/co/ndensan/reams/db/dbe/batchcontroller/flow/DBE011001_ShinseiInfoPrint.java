package jp.co.ndensan.reams.db.dbe.batchcontroller.flow;

import jp.co.ndensan.reams.db.dbe.batchcontroller.step.DBE011001.ShinseiJouhouInsatuProcess;
import jp.co.ndensan.reams.db.dbe.batchcontroller.step.yokaigoyoshienchiran.YokaigoyoShienchiranProcess;
import jp.co.ndensan.reams.db.dbe.definition.batchprm.DBE011001.DBE011001_ShinseiInfoPrintParameter;
import jp.co.ndensan.reams.uz.uza.batch.Step;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;
import jp.co.ndensan.reams.uz.uza.batch.flow.IBatchFlowCommand;

/**
 * 申請情報印刷のバッチフロークラスです。
 *
 * @reamsid_L DBE-1390-020 suguangjun
 */
public class DBE011001_ShinseiInfoPrint extends BatchFlowBase<DBE011001_ShinseiInfoPrintParameter> {

    private static final String SHINSEIJOUHOUINSATU_PROCESS = "ShinseiJouhouInsatuProcess";
    private static final String YOKAIGOYOSHIENCHIRAN_PROCESS = "YokaigoyoShienchiranProcess";

    @Override
    protected void defineFlow() {
        if (getParameter().isShinseimonitorflag()) {
            executeStep(SHINSEIJOUHOUINSATU_PROCESS);
        }
        if (getParameter().isYokaigoyoshienseiichiranflag()) {
            executeStep(YOKAIGOYOSHIENCHIRAN_PROCESS);
        }
    }

    /**
     * 要介護認定申請モニタリストのデータを作成します。
     *
     * @return IBatchFlowCommand
     */
    @Step(SHINSEIJOUHOUINSATU_PROCESS)
    protected IBatchFlowCommand createShinseiJouhouInsatuData() {
        return loopBatch(ShinseiJouhouInsatuProcess.class).arguments(
                getParameter().toMonitorPrintParameter()).define();
    }

    /**
     * 要支援認定等申請者一覧表のデータを作成します。
     *
     * @return IBatchFlowCommand
     */
    @Step(YOKAIGOYOSHIENCHIRAN_PROCESS)
    protected IBatchFlowCommand createYokaigoyoShienchiranData() {
        return loopBatch(YokaigoyoShienchiranProcess.class).arguments(
                getParameter().toShinseishaIchiranPrintParameter()).define();
    }
}
