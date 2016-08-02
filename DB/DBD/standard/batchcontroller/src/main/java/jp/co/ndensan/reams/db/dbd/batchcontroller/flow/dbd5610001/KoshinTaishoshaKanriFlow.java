/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.batchcontroller.flow.dbd5610001;

import jp.co.ndensan.reams.db.dbd.batchcontroller.step.dbd5610001.KoshinTaishoshaKanriSelectTableProcess;
import jp.co.ndensan.reams.db.dbd.definition.batchprm.dbd5610001.KoshinTaishoshaKanriParameter;
import jp.co.ndensan.reams.uz.uza.batch.Step;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;
import jp.co.ndensan.reams.uz.uza.batch.flow.IBatchFlowCommand;

/**
 * 更新対象者抽出のバッチフロークラスです。
 *
 * @reamsid_L DBD-1460-020 liuyl
 */
public class KoshinTaishoshaKanriFlow extends BatchFlowBase<KoshinTaishoshaKanriParameter> {

    @Override
    protected void defineFlow() {
        executeStep(SELECT_TABLE);

    }
    private static final String SELECT_TABLE = "slect_table";

    /**
     * 'バッチパラメータの取得を行います。
     *
     * @return バッチコマンド
     */
    @Step(SELECT_TABLE)
    protected IBatchFlowCommand selectTable() {
        return loopBatch(KoshinTaishoshaKanriSelectTableProcess.class)
                .arguments(getParameter().toKoshinTaishoshaKanriProcessParameter()).define();
    }
}
