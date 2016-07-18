/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.batchcontroller.flow.chosahyojissekiichiran;

import jp.co.ndensan.reams.db.dbe.batchcontroller.step.chosahyojissekiichiran.ChosahyoJissekiIchiranProcess;
import jp.co.ndensan.reams.db.dbe.definition.batchprm.chosahyojissekiichiran.ChosahyoJissekiIchiranBatchParameter;
import jp.co.ndensan.reams.uz.uza.batch.Step;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;
import jp.co.ndensan.reams.uz.uza.batch.flow.IBatchFlowCommand;

/**
 * 帳票出力用認定調査実績集計表のReportSourceクラスです。
 *
 * @reamsid_L DBE-1691-020 dangjingjing
 */
public class ChosahyoJissekiIchiranFlow extends BatchFlowBase<ChosahyoJissekiIchiranBatchParameter> {

    private static final String CHOSAHYO_JISSEKI_ICHIRAN = "chosahyojissekiichiran";

    @Override
    protected void defineFlow() {
        if (!getParameter().getKeyJoho().isEmpty()) {
            executeStep(CHOSAHYO_JISSEKI_ICHIRAN);
        }
    }

    /**
     * 要介護認定事業状況データの作成を行います。
     *
     * @return バッチコマンド
     */
    @Step(CHOSAHYO_JISSEKI_ICHIRAN)
    IBatchFlowCommand chosahyojissekiichiran() {
        return loopBatch(ChosahyoJissekiIchiranProcess.class)
                .arguments(getParameter().toProcessParamter()).define();
    }
}
