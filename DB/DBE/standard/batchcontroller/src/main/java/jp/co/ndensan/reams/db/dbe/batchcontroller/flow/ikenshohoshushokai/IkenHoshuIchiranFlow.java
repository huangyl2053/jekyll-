package jp.co.ndensan.reams.db.dbe.batchcontroller.flow.ikenshohoshushokai;

import jp.co.ndensan.reams.db.dbe.batchcontroller.step.ikenshohoshushokai.IkenHoshuIchiranProcess;
import jp.co.ndensan.reams.db.dbe.definition.batchprm.ikenshohoshushokai.IkenHoshuIchiranBatchParameter;
import jp.co.ndensan.reams.uz.uza.batch.Step;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;
import jp.co.ndensan.reams.uz.uza.batch.flow.IBatchFlowCommand;

/**
 * 意見書作成報酬実績集計表のバッチフロークラスです。
 *
 * @reamsid_L DBE-1930-010 chenxiangyu
 */
public class IkenHoshuIchiranFlow extends BatchFlowBase<IkenHoshuIchiranBatchParameter> {

    private static final String IKEN_HOSHU_ICHIRAN = "ikenHoshuIchiran";

    @Override
    protected void defineFlow() {
        if (!getParameter().getKeyJoho().isEmpty()) {
            executeStep(IKEN_HOSHU_ICHIRAN);
        }
    }

    /**
     * 要介護認定事業状況データの作成を行います。
     *
     * @return バッチコマンド
     */
    @Step(IKEN_HOSHU_ICHIRAN)
    IBatchFlowCommand ikenHoshuIchiran() {
        return loopBatch(IkenHoshuIchiranProcess.class)
                .arguments(getParameter().toProcessParamter()).define();
    }
}
