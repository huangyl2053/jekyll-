/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.batchcontroller.flow.shinsakaijizenshinsakekkaichiran;

import jp.co.ndensan.reams.db.dbe.batchcontroller.step.shinsakaijizenshinsakekkaichiran.ShinsakaiJizenshinsakekkaIchiranProcess;
import jp.co.ndensan.reams.db.dbe.definition.batchprm.shinsakaijizenshinsakekkaichiran.ShinsakaiJizenshinsakekkaIchiranBatchParameter;
import jp.co.ndensan.reams.uz.uza.batch.Step;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;
import jp.co.ndensan.reams.uz.uza.batch.flow.IBatchFlowCommand;

/**
 * 事前審査結果一覧表の帳票のバッチフロークラスです。
 *
 * @reamsid_L DBE-1640-020 zhaoyao
 */
public class ShinsakaiJizenshinsakekkaIchiranFlow extends BatchFlowBase<ShinsakaiJizenshinsakekkaIchiranBatchParameter> {

    private static final String JIZEN_SHINSAKEKKA_ICHIRAN = "shinsakaiJizenshinsakekkaIchiran";

    @Override
    protected void defineFlow() {
        executeStep(JIZEN_SHINSAKEKKA_ICHIRAN);
    }

    /**
     * 事前審査結果一覧表データの作成を行います。
     *
     * @return バッチコマンド
     */
    @Step(JIZEN_SHINSAKEKKA_ICHIRAN)
    IBatchFlowCommand shinsakaiJizenshinsakekkaIchiran() {
        return loopBatch(ShinsakaiJizenshinsakekkaIchiranProcess.class)
                .arguments(getParameter().toProcessParamter()).define();
    }

}
