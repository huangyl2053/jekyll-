/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.batchcontroller.flow.itakusakichosainichiran;

import jp.co.ndensan.reams.db.dbe.batchcontroller.step.itakusakichosainichiran.ItakusakiChosainIchiranQueryProcess;
import jp.co.ndensan.reams.db.dbe.definition.batchprm.itakusakichosainichiran.ItakusakiChosainIchiranBatchParamter;
import jp.co.ndensan.reams.uz.uza.batch.Step;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;
import jp.co.ndensan.reams.uz.uza.batch.flow.IBatchFlowCommand;

/**
 *
 * 調査委託先・調査員一覧表のバッチ処理クラスです。
 */
public class ItakusakiChosainIchiranFlow extends BatchFlowBase<ItakusakiChosainIchiranBatchParamter> {

    @Override
    protected void defineFlow() {
        executeStep(CHOSAIN_ITIRAN);
    }

    private static final String CHOSAIN_ITIRAN = "chosainItiran";

    @Step(CHOSAIN_ITIRAN)
    IBatchFlowCommand chosainItiran() {
        return loopBatch(ItakusakiChosainIchiranQueryProcess.class)
                .arguments(getParameter().toProcessParameter())
                .define();
    }
}
