/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.batchcontroller.flow.hihohenshashohakkokanribo;

import jp.co.ndensan.reams.db.dba.batchcontroller.step.hihohenshashohakkokanribo.HihokenshashoHakkoKanriboNoRenbanProcess;
import jp.co.ndensan.reams.db.dba.batchcontroller.step.hihohenshashohakkokanribo.HihokenshashoHakkoKanriboProcess;
import jp.co.ndensan.reams.db.dba.definition.batchprm.hihokenshashohakkokanribo.HihokenshashoHakkoKanriboBatchParameter;
import jp.co.ndensan.reams.db.dba.definition.processprm.hihokenshashohakkokanribo.HihokenshashoHakkoKanriboProcessParameter;
import jp.co.ndensan.reams.uz.uza.batch.Step;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;
import jp.co.ndensan.reams.uz.uza.batch.flow.IBatchFlowCommand;

/**
 *
 * 被保険者証発行管理簿_バッチフロークラスです。
 *
 * @reamsid_L DBA-0600-020 zhangguopeng
 */
public class HihokenshashoHakkoKanriboFlow extends BatchFlowBase<HihokenshashoHakkoKanriboBatchParameter> {

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
        HihokenshashoHakkoKanriboProcessParameter processParameter = getParameter().toAkasiHakouKanriProcessParameter();
        if (processParameter.isRenbanfukaflg()) {
            return simpleBatch(HihokenshashoHakkoKanriboProcess.class)
                    .arguments(getParameter().toAkasiHakouKanriProcessParameter()).define();
        } else {
            return simpleBatch(HihokenshashoHakkoKanriboNoRenbanProcess.class)
                    .arguments(getParameter().toAkasiHakouKanriProcessParameter()).define();
        }
    }
}
