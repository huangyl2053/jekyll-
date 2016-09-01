/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.batchcontroller.flow;

import jp.co.ndensan.reams.db.dba.batchcontroller.step.DBA130010.IdoCheckListReportProcess;
import jp.co.ndensan.reams.db.dba.batchcontroller.step.DBA130010.UpdShoriDateKanriProcess;
import jp.co.ndensan.reams.db.dba.definition.batchprm.DBA130010.DBA130010_IdoCheckListParameter;
import jp.co.ndensan.reams.uz.uza.batch.Step;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;
import jp.co.ndensan.reams.uz.uza.batch.flow.IBatchFlowCommand;

/**
 * 異動チェックリストのバッチフロークラスです
 *
 * @reamsid_L DBA-0530-020 chengsanyuan
 */
public class DBA130010_IdoCheckList extends BatchFlowBase<DBA130010_IdoCheckListParameter> {

    private static final String GET_IDO_CHECK_LIST_REPORT = "getIdoCheckListReport";
    private static final String UPD_SHORI_DATE_KANRI = "updShoriDataKanri";

    @Override
    protected void defineFlow() {
        executeStep(GET_IDO_CHECK_LIST_REPORT);
        executeStep(UPD_SHORI_DATE_KANRI);
    }

    @Step(GET_IDO_CHECK_LIST_REPORT)
    IBatchFlowCommand getIdoCheckListReportProcess() {
        return loopBatch(IdoCheckListReportProcess.class).arguments(getParameter().toIdoCheckListGetDataProcessParameter()).define();
    }

    @Step(UPD_SHORI_DATE_KANRI)
    IBatchFlowCommand updShoriDataKanriProcess() {
        return loopBatch(UpdShoriDateKanriProcess.class).arguments(getParameter().toUpdShoriDataKanriProcessParameter()).define();
    }
}
