/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.batchcontroller.flow;

import jp.co.ndensan.reams.db.dbb.batchcontroller.step.DBB022001.HanyoListFukaDaichoNoRenbanProcess;
import jp.co.ndensan.reams.db.dbb.batchcontroller.step.DBB022001.HanyoListFukaDaichoProcess;
import jp.co.ndensan.reams.db.dbb.definition.batchprm.DBB022001.DBB022001_FukaDaichoHanyoListSakuseiParameter;
import jp.co.ndensan.reams.uz.uza.batch.Step;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;
import jp.co.ndensan.reams.uz.uza.batch.flow.IBatchFlowCommand;

/**
 * バッチ設計_DBBBT22001_汎用リスト 賦課台帳クラスです。
 *
 * @reamsid_L DBB-1900-030 zhaowei
 */
public class DBB022001_FukaDaichoHanyoListSakusei extends BatchFlowBase<DBB022001_FukaDaichoHanyoListSakuseiParameter> {

    private static final String CSV_EUC_PROCESS = "csvEucProcess";

    @Override
    protected void defineFlow() {
        executeStep(CSV_EUC_PROCESS);
    }

    @Step(CSV_EUC_PROCESS)
    IBatchFlowCommand csvEucProcess() {
        if (getParameter().is連番付加()) {
            return loopBatch(HanyoListFukaDaichoProcess.class)
                    .arguments(getParameter().toProcessParameter()).define();
        }
        return loopBatch(HanyoListFukaDaichoNoRenbanProcess.class)
                .arguments(getParameter().toProcessParameter()).define();
    }

}
