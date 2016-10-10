/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.batchcontroller.flow;

import jp.co.ndensan.reams.db.dbd.batchcontroller.step.DBD710070.HanyoListTokubetsuChiikiKasanGemmenProcess;
import jp.co.ndensan.reams.db.dbd.definition.batchprm.DBD710070.DBD710070_HanyoListTokubetsuChiikiKasanGemmenParameter;
import jp.co.ndensan.reams.uz.uza.batch.Step;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;
import jp.co.ndensan.reams.uz.uza.batch.flow.IBatchFlowCommand;

/**
 * 汎用リスト出力(特別地域加算減免)のバッチフロークラスです。
 *
 * @reamsid_L DBD-3910-030 panxiaobo
 */
public class DBD710070_HanyoListTokubetsuChiikiKasanGemmen extends BatchFlowBase<DBD710070_HanyoListTokubetsuChiikiKasanGemmenParameter> {

    @Override
    protected void defineFlow() {
        executeStep(CSV_PROCESS);
    }

    private static final String CSV_PROCESS = "csvProcess";

    /**
     * batchProcessです。
     *
     * @return IBatchFlowCommand
     */
    @Step(CSV_PROCESS)
    protected IBatchFlowCommand reportCsvProcess() {
        return loopBatch(HanyoListTokubetsuChiikiKasanGemmenProcess.class)
                .arguments(getParameter().toHanyoListTokubetsuChiikiKasanGemmenProcessParameter())
                .define();
    }

}
