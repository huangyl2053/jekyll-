/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.batchcontroller.flow;

import jp.co.ndensan.reams.db.dba.batchcontroller.step.DBA110010.HihokenshashoHakkoKanriboNoRenbanProcess;
import jp.co.ndensan.reams.db.dba.batchcontroller.step.DBA110010.HihokenshashoHakkoKanriboNoRenbanSaisinProcess;
import jp.co.ndensan.reams.db.dba.batchcontroller.step.DBA110010.HihokenshashoHakkoKanriboProcess;
import jp.co.ndensan.reams.db.dba.batchcontroller.step.DBA110010.HihokenshashoHakkoKanriboSaisinProcess;
import jp.co.ndensan.reams.db.dba.definition.batchprm.DBA110010.DBA110010_HihokenshashoHakkoKanriboParameter;
import jp.co.ndensan.reams.db.dba.definition.processprm.dba110010.HihokenshashoHakkoKanriboProcessParameter;
import jp.co.ndensan.reams.uz.uza.batch.Step;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;
import jp.co.ndensan.reams.uz.uza.batch.flow.IBatchFlowCommand;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * 被保険者証発行管理簿_バッチフロークラスです。
 *
 * @reamsid_L DBA-0600-020 zhangguopeng
 */
public class DBA110010_HihokenshashoHakkoKanribo extends BatchFlowBase<DBA110010_HihokenshashoHakkoKanriboParameter> {

    @Override
    protected void defineFlow() {
        executeStep(REPORT_PROCESS);
    }
    private static final String REPORT_PROCESS = "reportProcess";
    private static final RString 発行管理リスト = new RString("1");

    /**
     * batchProcessです。
     *
     * @return IBatchFlowCommand
     */
    @Step(REPORT_PROCESS)
    protected IBatchFlowCommand reportProcess() {
        HihokenshashoHakkoKanriboProcessParameter processParameter = getParameter().toAkasiHakouKanriProcessParameter();
        if (processParameter.isRenbanfukaflg()) {
            if (発行管理リスト.equals(processParameter.getSiyuturiyokudaysyou())
                    && processParameter.isSaisinjyohoflg()) {
                return loopBatch(HihokenshashoHakkoKanriboSaisinProcess.class)
                        .arguments(getParameter().toAkasiHakouKanriProcessParameter()).define();
            } else {
                return loopBatch(HihokenshashoHakkoKanriboProcess.class)
                        .arguments(getParameter().toAkasiHakouKanriProcessParameter()).define();
            }
        } else {
            if (発行管理リスト.equals(processParameter.getSiyuturiyokudaysyou())
                    && processParameter.isSaisinjyohoflg()) {
                return loopBatch(HihokenshashoHakkoKanriboNoRenbanSaisinProcess.class)
                        .arguments(getParameter().toAkasiHakouKanriProcessParameter()).define();
            } else {
                return loopBatch(HihokenshashoHakkoKanriboNoRenbanProcess.class)
                        .arguments(getParameter().toAkasiHakouKanriProcessParameter()).define();
            }
        }
    }
}
