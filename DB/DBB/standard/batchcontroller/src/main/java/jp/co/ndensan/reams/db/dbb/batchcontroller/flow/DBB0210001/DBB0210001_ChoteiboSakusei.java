/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.batchcontroller.flow.DBB0210001;

import jp.co.ndensan.reams.db.dbb.batchcontroller.step.DBB0210001.ChoteiboSakuseiDataShoriProcess;
import jp.co.ndensan.reams.db.dbb.batchcontroller.step.DBB0210001.ChoteiboSakuseiReportProcess;
import jp.co.ndensan.reams.db.dbb.definition.batchprm.choteibo.ChoteiboBatchParameter;
import jp.co.ndensan.reams.uz.uza.batch.Step;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;
import jp.co.ndensan.reams.uz.uza.batch.flow.IBatchFlowCommand;

/**
 * 調定簿作成Flowクラスです。
 */
public class DBB0210001_ChoteiboSakusei extends BatchFlowBase<ChoteiboBatchParameter> {

    @Override
    protected void defineFlow() {
        executeStep(CHOTEIBO_DATA_PROCESS);
        executeStep(CHOTEIBO_REPORT_PROCESS);
    }

    private static final String CHOTEIBO_DATA_PROCESS = "ChoteiboSakuseiDataShoriProcess";

    /**
     * 調定簿作成Processを呼び出し
     *
     * @return IBatchFlowCommand
     */
    @Step(CHOTEIBO_DATA_PROCESS)
    protected IBatchFlowCommand createReport() {
        return simpleBatch(ChoteiboSakuseiDataShoriProcess.class).
                arguments(getParameter().toChoteiboBatchParameter()).define();
    }

    private static final String CHOTEIBO_REPORT_PROCESS = "ChoteiboReaportProcess";

    /**
     * 調定簿作成Processを呼び出し
     *
     * @return IBatchFlowCommand
     */
    @Step(CHOTEIBO_REPORT_PROCESS)
    protected IBatchFlowCommand createData() {
        return loopBatch(ChoteiboSakuseiReportProcess.class).
                arguments(getParameter().toChoteiboBatchParameter()).define();
    }
}
