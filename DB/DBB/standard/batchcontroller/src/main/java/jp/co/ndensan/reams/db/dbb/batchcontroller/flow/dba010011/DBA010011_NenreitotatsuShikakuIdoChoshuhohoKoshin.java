/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jp.co.ndensan.reams.db.dbb.batchcontroller.flow.dba010011;

import jp.co.ndensan.reams.db.dbb.batchcontroller.step.dba010011.ShikakuIdoChoshuhohoKoshinDbUpdateProcess;
import jp.co.ndensan.reams.db.dbb.batchcontroller.step.dba010011.ShikakuIdoChoshuhohoKoshinHihokenjaShutokuProcess;
import jp.co.ndensan.reams.db.dbb.batchcontroller.step.dba010011.ShikakuIdoChoshuhohoKoshinHohoJohoShutokuProcess;
import jp.co.ndensan.reams.db.dbb.batchcontroller.step.dba010011.ShikakuIdoChoshuhohoKoshinMethodUpdateProcess;
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
    private static final String HOHO_JOHO_SHUTOKU = "hohoJohoShutokuProcess";
    private static final String METHOD_UPDATE = "methodUpdateProcess";
    private static final String DB_UPDATE = "dbUpdateProcess";
    
    @Override
    protected void defineFlow() {
        executeStep(HIHOKENJA_SHUTOKU);
        executeStep(HOHO_JOHO_SHUTOKU);
        executeStep(METHOD_UPDATE);
        executeStep(DB_UPDATE);
    }
    
    @Step(HIHOKENJA_SHUTOKU)
    IBatchFlowCommand hihokenjaShutokuProcess() {
        return loopBatch(ShikakuIdoChoshuhohoKoshinHihokenjaShutokuProcess.class).define();
    }
    
    @Step(HOHO_JOHO_SHUTOKU)
    IBatchFlowCommand hohoJohoShutokuProcess() {
        return loopBatch(ShikakuIdoChoshuhohoKoshinHohoJohoShutokuProcess.class).define();
    }

    @Step(METHOD_UPDATE)
    IBatchFlowCommand methodUpdateProcess() {
        return loopBatch(ShikakuIdoChoshuhohoKoshinMethodUpdateProcess.class).define();
    }

    @Step(DB_UPDATE)
    IBatchFlowCommand dbUpdateProcess() {
        return loopBatch(ShikakuIdoChoshuhohoKoshinDbUpdateProcess.class).define();
    }
}
