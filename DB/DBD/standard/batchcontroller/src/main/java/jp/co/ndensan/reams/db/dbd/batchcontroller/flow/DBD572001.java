/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.batchcontroller.flow;

import jp.co.ndensan.reams.db.dbd.batchcontroller.step.dbd5720001.JyukyushaDaichoIdoCheckListProcess;
import jp.co.ndensan.reams.db.dbd.batchcontroller.step.dbd5720001.ShoriDateKanriProcess;
import jp.co.ndensan.reams.db.dbd.definition.batchprm.DBD572001.DBD572001Parameter;
import jp.co.ndensan.reams.uz.uza.batch.Step;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;
import jp.co.ndensan.reams.uz.uza.batch.flow.IBatchFlowCommand;

/**
 * 受給者台帳異動チェックリストのバッチフロークラスです。
 *
 * @reamsid_L DBD-1770-020 donghj
 */
public class DBD572001 extends BatchFlowBase<DBD572001Parameter> {

    private static final String 受給者台帳異動チェックリスト = "get受給者台帳異動チェックリスト";
    private static final String 処理日付管理マスタ更新 = "update処理日付管理マスタ";

    @Override
    protected void defineFlow() {
        executeStep(受給者台帳異動チェックリスト);
        executeStep(処理日付管理マスタ更新);
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

    /**
     * batchProcessです。
     *
     * @return IBatchFlowCommand
     */
    @Step(処理日付管理マスタ更新)
    protected IBatchFlowCommand update処理日付管理マスタ() {
        return loopBatch(ShoriDateKanriProcess.class).
                arguments(getParameter().toJyukyushaDaichoIdoCheckListProcessParameter()).define();
    }

}
