/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.batchcontroller.flow;

import jp.co.ndensan.reams.db.dba.batchcontroller.step.DBA340010.TennyuTenshutsuMiTorokuIchiranhyoProcess;
import jp.co.ndensan.reams.db.dba.definition.batchprm.DBA340010.DBA340010_TennyuTenshutsuMitorokuIchiranhyoParameter;
import jp.co.ndensan.reams.uz.uza.batch.Step;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;
import jp.co.ndensan.reams.uz.uza.batch.flow.IBatchFlowCommand;

/**
 * 転入転出未登録一覧表の_バッチ処理クラスです。
 *
 * @reamsid_L DBU-4110-030 yaodongsheng
 */
public class DBA340010_TennyuTenshutsuMitorokuIchiranhyo extends BatchFlowBase<DBA340010_TennyuTenshutsuMitorokuIchiranhyoParameter> {

    @Override
    protected void defineFlow() {
        executeStep(REPORT_PROCESS);
    }

    private static final String REPORT_PROCESS = "reportProcess";

    /**
     * batchProcessです。
     *
     * @return IBatchFlowCommand
     */
    @Step(REPORT_PROCESS)
    protected IBatchFlowCommand reportProcess() {
        return loopBatch(TennyuTenshutsuMiTorokuIchiranhyoProcess.class)
                .arguments(getParameter().toTennyuTensyutsuMiTorokuIchiranhyoProcessParameter())
                .define();
    }
}
