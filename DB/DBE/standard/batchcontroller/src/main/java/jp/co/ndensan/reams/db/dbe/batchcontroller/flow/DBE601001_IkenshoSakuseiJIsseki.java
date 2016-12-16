package jp.co.ndensan.reams.db.dbe.batchcontroller.flow;

import jp.co.ndensan.reams.db.dbe.batchcontroller.step.DBE601001.IkenshoJissekiIchiranProcess;
import jp.co.ndensan.reams.db.dbe.definition.batchprm.DBE601001.DBE601001_IkenshoSakuseiJIssekiParameter;
import jp.co.ndensan.reams.uz.uza.batch.Step;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;
import jp.co.ndensan.reams.uz.uza.batch.flow.IBatchFlowCommand;

/**
 * 主治医意見書作成実績集計表のバッチフロークラスです。
 *
 * @reamsid_L DBE-1690-020 dongyabin
 */
public class DBE601001_IkenshoSakuseiJIsseki extends BatchFlowBase<DBE601001_IkenshoSakuseiJIssekiParameter> {

    private static final String IKENSHO_JISSEKI_ICHIRAN = "ikenshoJissekiIchiran";

    @Override
    protected void defineFlow() {
        if (!getParameter().getKeyJoho().isEmpty()) {
            executeStep(IKENSHO_JISSEKI_ICHIRAN);
        }
    }

    /**
     * 要介護認定事業状況データの作成を行います。
     *
     * @return バッチコマンド
     */
    @Step(IKENSHO_JISSEKI_ICHIRAN)
    IBatchFlowCommand ikenshoJissekiIchiran() {
        return loopBatch(IkenshoJissekiIchiranProcess.class)
                .arguments(getParameter().toProcessParamter()).define();
    }
}
