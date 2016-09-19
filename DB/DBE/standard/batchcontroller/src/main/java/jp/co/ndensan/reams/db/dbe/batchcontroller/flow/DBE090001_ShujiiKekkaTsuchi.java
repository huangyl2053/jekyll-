/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.batchcontroller.flow;

import jp.co.ndensan.reams.db.dbe.batchcontroller.step.DBE090001.YouKaiGoNinTeiKekTesuChiProcess;
import jp.co.ndensan.reams.db.dbe.definition.batchprm.DBE090001.DBE090001_ShujiiKekkaTsuchiParameter;
import jp.co.ndensan.reams.uz.uza.batch.Step;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;
import jp.co.ndensan.reams.uz.uza.batch.flow.IBatchFlowCommand;

/**
 * 主治医への結果通知書発行のバッチフロークラスです。
 *
 * @reamsid_L DBE-0220-030 wangkun
 */
public class DBE090001_ShujiiKekkaTsuchi extends BatchFlowBase<DBE090001_ShujiiKekkaTsuchiParameter> {

    private static final String 主治医への結果通知書発行 = "youKaiGoNinTeiKekTesuChiReport";

    @Override
    protected void defineFlow() {
        executeStep(主治医への結果通知書発行);
    }

    /**
     * 主治医への結果通知書発行を行います。
     *
     * @return バッチコマンド
     */
    @Step(主治医への結果通知書発行)
    protected IBatchFlowCommand youKaiGoNinTeiKekTesuChiReport() {
        return loopBatch(YouKaiGoNinTeiKekTesuChiProcess.class)
                .arguments(getParameter().toProcessParameter())
                .define();
    }
}
