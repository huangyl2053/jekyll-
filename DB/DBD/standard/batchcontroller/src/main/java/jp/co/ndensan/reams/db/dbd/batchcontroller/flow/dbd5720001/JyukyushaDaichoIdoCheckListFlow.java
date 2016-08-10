/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.batchcontroller.flow.dbd5720001;

import jp.co.ndensan.reams.db.dbd.batchcontroller.step.dbd5720001.JyukyushaDaichoIdoCheckListProcess;
import jp.co.ndensan.reams.db.dbd.definition.batchprm.dbd5720001.JyukyushaDaichoIdoCheckListParameter;
import jp.co.ndensan.reams.uz.uza.batch.Step;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;
import jp.co.ndensan.reams.uz.uza.batch.flow.IBatchFlowCommand;

/**
 * 受給者台帳異動チェックリストのバッチフロークラスです。
 *
 * @reamsid_L DBD-1770-020 donghj
 */
public class JyukyushaDaichoIdoCheckListFlow extends BatchFlowBase<JyukyushaDaichoIdoCheckListParameter> {

    private static final String 受給者台帳異動チェックリスト = "get受給者台帳異動チェックリスト";

    @Override
    protected void defineFlow() {
        executeStep(受給者台帳異動チェックリスト);
    }

    /**
     * batchProcessです。
     *
     * @return IBatchFlowCommand
     */
    @Step(受給者台帳異動チェックリスト)
    protected IBatchFlowCommand get受給者台帳異動チェックリスト() {
        return loopBatch(JyukyushaDaichoIdoCheckListProcess.class).
                arguments(getParameter().toJyukyushaDaichoIdoCheckListProcessParameter()).define();
    }

}
