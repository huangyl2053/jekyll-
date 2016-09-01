/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.batchcontroller.flow.dbd511002;

import jp.co.ndensan.reams.db.dbd.batchcontroller.step.dbd511002.NinshiuUpdateProcess;
import jp.co.ndensan.reams.db.dbd.definition.batchprm.dbd511002.NinshiuUpdateParameter;
import jp.co.ndensan.reams.uz.uza.batch.Step;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;
import jp.co.ndensan.reams.uz.uza.batch.flow.IBatchFlowCommand;

/**
 * 認定更新お知らせ通知書発行作成のバッチフロークラスです。
 *
 * @reamsid_L DBD-1420-020 wangjie2
 */
public class NinshiuUpdateFlow extends BatchFlowBase<NinshiuUpdateParameter> {

    private static final String 認定更新お知らせ通知書発行 = "NinshiuUpdate";

    @Override
    protected void defineFlow() {
        executeStep(認定更新お知らせ通知書発行);
    }

    /**
     * batchProcessです。
     *
     * @return IBatchFlowCommand
     */
    @Step(認定更新お知らせ通知書発行)
    protected IBatchFlowCommand shogaishaKoujoTaishoNinteiSho() {
        return loopBatch(NinshiuUpdateProcess.class).
                arguments(getParameter().toNinshiuUpdateProcessParameter()).define();
    }

}
