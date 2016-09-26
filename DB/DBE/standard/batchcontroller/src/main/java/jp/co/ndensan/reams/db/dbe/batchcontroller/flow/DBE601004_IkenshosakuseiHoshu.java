package jp.co.ndensan.reams.db.dbe.batchcontroller.flow;

import jp.co.ndensan.reams.db.dbe.batchcontroller.step.DBE601004.IkenshosakuseiHoshuProcess;
import jp.co.ndensan.reams.db.dbe.definition.batchprm.DBE601004.DBE601004_IkenshosakuseiHoshuParameter;
import jp.co.ndensan.reams.uz.uza.batch.Step;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;
import jp.co.ndensan.reams.uz.uza.batch.flow.IBatchFlowCommand;

/**
 * 意見書作成報酬実績集計表のバッチフロークラスです。
 *
 * @reamsid_L DBE-1930-020 chenxiangyu
 */
public class DBE601004_IkenshosakuseiHoshu extends BatchFlowBase<DBE601004_IkenshosakuseiHoshuParameter> {

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
        return loopBatch(IkenshosakuseiHoshuProcess.class)
                .arguments(getParameter().toProcessParamter()).define();
    }
}
