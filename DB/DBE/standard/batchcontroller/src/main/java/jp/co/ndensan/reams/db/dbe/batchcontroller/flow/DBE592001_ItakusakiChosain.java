/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.batchcontroller.flow;

import jp.co.ndensan.reams.db.dbe.batchcontroller.step.DBE592001.ItakusakiChosainIchiranQueryProcess;
import jp.co.ndensan.reams.db.dbe.definition.batchprm.DBE592001.DBE592001_ItakusakiChosainParameter;
import jp.co.ndensan.reams.uz.uza.batch.Step;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;
import jp.co.ndensan.reams.uz.uza.batch.flow.IBatchFlowCommand;

/**
 *
 * 調査委託先・調査員一覧表のバッチ処理クラスです。
 * @reamsid_L DBE-0290-030 dongyabin
 */
public class DBE592001_ItakusakiChosain extends BatchFlowBase<DBE592001_ItakusakiChosainParameter> {

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
