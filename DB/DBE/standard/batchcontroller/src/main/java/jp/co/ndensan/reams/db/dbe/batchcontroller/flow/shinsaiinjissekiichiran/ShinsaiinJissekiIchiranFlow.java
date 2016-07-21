/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.batchcontroller.flow.shinsaiinjissekiichiran;

import jp.co.ndensan.reams.db.dbe.batchcontroller.step.shinsaiinjissekiichiran.ShinsaiinJissekiIchiranProcess;
import jp.co.ndensan.reams.db.dbe.definition.batchprm.shinsaiinjissekiichiran.ShinsaiinJissekiIchiranBatchParameter;
import jp.co.ndensan.reams.uz.uza.batch.Step;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;
import jp.co.ndensan.reams.uz.uza.batch.flow.IBatchFlowCommand;

/**
 * 介護認定審査会委員報酬実績集計表のバッチフロークラスです。
 *
 * @reamsid_L DBE-1700-020 wanghuafeng
 */
public class ShinsaiinJissekiIchiranFlow extends BatchFlowBase<ShinsaiinJissekiIchiranBatchParameter> {

    private static final String SHINSAIIN_JISSEKI_ICHIRAN = "shinsaiinjissekiichiran";

    @Override
    protected void defineFlow() {
        if (!getParameter().getKeyJoho().isEmpty()) {
            executeStep(SHINSAIIN_JISSEKI_ICHIRAN);
        }
    }

    /**
     * 要介護認定事業状況データの作成を行います。
     *
     * @return バッチコマンド
     */
    @Step(SHINSAIIN_JISSEKI_ICHIRAN)
    IBatchFlowCommand shinsaiinjissekiichiran() {
        return loopBatch(ShinsaiinJissekiIchiranProcess.class)
                .arguments(getParameter().toProcessParamter())
                .define();
    }
}
