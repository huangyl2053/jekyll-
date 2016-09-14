/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.batchcontroller.flow;

import jp.co.ndensan.reams.db.dbd.batchcontroller.step.dbd511002.KoshinOshiraseTsuchiProcess;
import jp.co.ndensan.reams.db.dbd.definition.batchprm.DBD511002.DBD511002_KoshinOshiraseTsuchiParameter;
import jp.co.ndensan.reams.uz.uza.batch.Step;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;
import jp.co.ndensan.reams.uz.uza.batch.flow.IBatchFlowCommand;

/**
 * 認定更新お知らせ通知書発行作成のバッチフロークラスです。
 *
 * @reamsid_L DBD-2030-020 x_miaocl
 */
public class DBD511002_KoshinOshiraseTsuchi extends BatchFlowBase<DBD511002_KoshinOshiraseTsuchiParameter> {

    private static final String 認定更新お知らせ通知書発行 = "koshinOshiraseTsuchi";

    @Override
    protected void defineFlow() {
        executeStep(認定更新お知らせ通知書発行);
    }

    /**
     * 認定更新お知らせ通知書発行を行います。
     *
     * @return IBatchFlowCommand
     */
    @Step(認定更新お知らせ通知書発行)
    protected IBatchFlowCommand koshinOshiraseTsuchi() {
        return loopBatch(KoshinOshiraseTsuchiProcess.class).
                arguments(getParameter().toNinshiuUpdateProcessParameter()).define();
    }

}
