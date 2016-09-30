/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.batchcontroller.flow;

import jp.co.ndensan.reams.db.dbe.batchcontroller.step.DBE526001.ShinsakaiJizenshinsakekkaIchiranProcess;
import jp.co.ndensan.reams.db.dbe.definition.batchprm.DBE526001.DBE526001_ShinsakaiJIzenShinsakekkaIchiranParameter;
import jp.co.ndensan.reams.uz.uza.batch.Step;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;
import jp.co.ndensan.reams.uz.uza.batch.flow.IBatchFlowCommand;

/**
 * 事前審査結果一覧表の帳票のバッチフロークラスです。
 *
 * @reamsid_L DBE-1640-020 zhaoyao
 */
public class DBE526001_ShinsakaiJIzenShinsakekkaIchiran extends BatchFlowBase<DBE526001_ShinsakaiJIzenShinsakekkaIchiranParameter> {

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
