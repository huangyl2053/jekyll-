/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.batchcontroller.flow;

import jp.co.ndensan.reams.db.dba.batchcontroller.step.DBA800010_.JuminIdoRendoShikakuTorokuProcess;
import jp.co.ndensan.reams.db.dba.definition.batchprm.DBA800010.DBA800010_JuminIdoRendoShikakuTorokuParameter;
import jp.co.ndensan.reams.uz.uza.batch.Step;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;
import jp.co.ndensan.reams.uz.uza.batch.flow.IBatchFlowCommand;

/**
 * 住民異動連動資格登録のバッチ処理クラスです。
 *
 * @reamsid_L DBA-1410-010 yaodongsheng
 */
public class DBA800010_JuminIdoRendoShikakuToroku extends BatchFlowBase<DBA800010_JuminIdoRendoShikakuTorokuParameter> {

    private static final String 住民異動連動資格登録 = "juminidorendoshikakutoroku";

    @Override
    protected void defineFlow() {
        executeStep(住民異動連動資格登録);
    }

    /**
     * 住民異動連動資格登録batchProcessです。
     *
     * @return IBatchFlowCommand
     */
    @Step(住民異動連動資格登録)
    protected IBatchFlowCommand reportProcess() {
        return loopBatch(JuminIdoRendoShikakuTorokuProcess.class).define();
    }
}
