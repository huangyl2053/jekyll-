package jp.co.ndensan.reams.db.dbe.batchcontroller.flow.ikenshojissekiichiran;

import jp.co.ndensan.reams.db.dbe.batchcontroller.step.ikenshojissekiichiran.IkenshoJissekiIchiranProcess;
import jp.co.ndensan.reams.db.dbe.definition.batchprm.ikenshojissekiichiran.IkenshoJissekiIchiranBatchParameter;
import jp.co.ndensan.reams.uz.uza.batch.Step;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;
import jp.co.ndensan.reams.uz.uza.batch.flow.IBatchFlowCommand;

/**
 * 主治医意見書作成実績集計表のバッチフロークラスです。
 *
 * @reamsid_L DBE-1690-020 dongyabin
 */
public class IkenshoJissekiIchiranFlow extends BatchFlowBase<IkenshoJissekiIchiranBatchParameter> {

    private static final String 事業状況データ作成 = "IkenshoJissekiIchiran";

    @Override
    protected void defineFlow() {
        executeStep(事業状況データ作成);
    }

    /**
     * 要介護認定事業状況データの作成を行います。
     *
     * @return バッチコマンド
     */
    @Step(事業状況データ作成)
    protected IBatchFlowCommand createJigyoJyokyoHokokuData() {
        return loopBatch(IkenshoJissekiIchiranProcess.class)
                .arguments(getParameter().toProcessParamter()).define();
    }
}
