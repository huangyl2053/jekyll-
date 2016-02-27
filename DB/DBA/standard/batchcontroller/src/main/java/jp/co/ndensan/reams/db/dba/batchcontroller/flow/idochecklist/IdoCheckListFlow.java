/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.batchcontroller.flow.idochecklist;

import jp.co.ndensan.reams.db.dba.batchcontroller.step.idochecklist.IdoCheckListReportProcess;
import jp.co.ndensan.reams.db.dba.batchcontroller.step.idochecklist.UpdShoriDateKanriProcess;
import jp.co.ndensan.reams.db.dba.definition.batchprm.idochecklist.IdoCheckListBatchParameter;
import jp.co.ndensan.reams.uz.uza.batch.Step;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;
import jp.co.ndensan.reams.uz.uza.batch.flow.IBatchFlowCommand;

/**
 * 異動チェックリストのバッチフロークラスです
 */
public class IdoCheckListFlow extends BatchFlowBase<IdoCheckListBatchParameter> {

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
