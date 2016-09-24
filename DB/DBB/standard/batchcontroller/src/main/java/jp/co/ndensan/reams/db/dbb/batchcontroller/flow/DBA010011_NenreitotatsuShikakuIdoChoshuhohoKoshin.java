/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.batchcontroller.flow;

import jp.co.ndensan.reams.db.dbb.batchcontroller.step.DBA010011.ShikakuIdoChoshuhohoKoshinHihokenjaShutokuProcess;
import jp.co.ndensan.reams.uz.uza.batch.Step;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;
import jp.co.ndensan.reams.uz.uza.batch.flow.IBatchFlowCommand;

/**
 * ６５歳年齢到達資格異動徴収方法更新のバッチ処理フロー
 *
 *
 * @reamsid_L DBB-9210-010 xuhao
 */
public class DBA010011_NenreitotatsuShikakuIdoChoshuhohoKoshin extends BatchFlowBase {

    private static final String HIHOKENJA_SHUTOKU = "hihokenjaShutokuProcess";

    @Override
    protected void defineFlow() {
        executeStep(HIHOKENJA_SHUTOKU);
    }

    @Step(HIHOKENJA_SHUTOKU)
    IBatchFlowCommand hihokenjaShutokuProcess() {
        return loopBatch(ShikakuIdoChoshuhohoKoshinHihokenjaShutokuProcess.class).define();
    }
}
