package jp.co.ndensan.reams.db.dbe.batchcontroller.flow;

import jp.co.ndensan.reams.db.dbe.batchcontroller.step.DBE601004.IkenshosakuseiHoshuCsvProcess;
import jp.co.ndensan.reams.db.dbe.batchcontroller.step.DBE601004.IkenshosakuseiHoshuReportProcess;
import jp.co.ndensan.reams.db.dbe.definition.batchprm.DBE601004.DBE601004_IkenshosakuseiHoshuParameter;
import jp.co.ndensan.reams.uz.uza.batch.Step;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;
import jp.co.ndensan.reams.uz.uza.batch.flow.IBatchFlowCommand;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 意見書作成報酬実績集計表のバッチフロークラスです。
 *
 * @reamsid_L DBE-1930-020 chenxiangyu
 */
public class DBE601004_IkenshosakuseiHoshu extends BatchFlowBase<DBE601004_IkenshosakuseiHoshuParameter> {

    private static final String IKEN_HOSHU_ICHIRAN_CSV = "ikenHoshuIchiranCsv";
    private static final String IKEN_HOSHU_ICHIRAN_REPORT = "ikenHoshuIchiranReport";

    private static final RString CSVを出力する = new RString("1");
    private static final RString 一覧表を発行する = new RString("2");

    @Override
    protected void defineFlow() {
        if (!getParameter().getKeyJoho().isEmpty()) {
            if (CSVを出力する.equals(getParameter().getSyohyoSyuturyoku())) {
                executeStep(IKEN_HOSHU_ICHIRAN_CSV);
            } else if (一覧表を発行する.equals(getParameter().getSyohyoSyuturyoku())) {
                executeStep(IKEN_HOSHU_ICHIRAN_REPORT);
            }
        }
    }

    /**
     * 意見書作成報酬一覧表のCSVファイル作成を行います。
     *
     * @return バッチコマンド
     */
    @Step(IKEN_HOSHU_ICHIRAN_CSV)
    IBatchFlowCommand ikenHoshuIchiranCsv() {
        return loopBatch(IkenshosakuseiHoshuCsvProcess.class)
                .arguments(getParameter().toProcessParamter()).define();
    }

    /**
     * 意見書作成報酬一覧表の帳票作成を行います。
     *
     * @return バッチコマンド
     */
    @Step(IKEN_HOSHU_ICHIRAN_REPORT)
    IBatchFlowCommand ikenHoshuIchiranReport() {
        return loopBatch(IkenshosakuseiHoshuReportProcess.class)
                .arguments(getParameter().toProcessParamter()).define();
    }
}
