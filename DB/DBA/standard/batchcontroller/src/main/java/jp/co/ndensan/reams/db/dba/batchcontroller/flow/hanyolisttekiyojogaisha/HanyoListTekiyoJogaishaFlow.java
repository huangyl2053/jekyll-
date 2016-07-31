/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.batchcontroller.flow.hanyolisttekiyojogaisha;

import jp.co.ndensan.reams.db.dba.batchcontroller.step.hanyolisttekiyojogaisha.HanyoListTekiyoJogaishaProcess;
import jp.co.ndensan.reams.db.dba.batchcontroller.step.hanyolisttekiyojogaisha.HanyoListTekiyoJogaishaRenbanProcess;
import jp.co.ndensan.reams.db.dba.definition.batchprm.hanyolisttekiyojogaisha.HanyoListTekiyoJogaishaBatchParameter;
import jp.co.ndensan.reams.uz.uza.batch.Step;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;
import jp.co.ndensan.reams.uz.uza.batch.flow.IBatchFlowCommand;

/**
 * 汎用リスト_適用除外者バッチ処理クラスです。
 *
 * @reamsid_L DBA-1600-030 yaodongsheng
 */
public class HanyoListTekiyoJogaishaFlow extends BatchFlowBase<HanyoListTekiyoJogaishaBatchParameter> {

    private static final String CSV_PROCESS = "csvProcess";
    private static final String RENBAN_CSV_PROCESS = "renbanCsvProcess";

    @Override
    protected void defineFlow() {
        if (getParameter().isRenbanFuka()) {
            executeStep(RENBAN_CSV_PROCESS);
        } else {
            executeStep(CSV_PROCESS);
        }
    }

    /**
     * 連番なしbatchProcessです。
     *
     * @return IBatchFlowCommand
     */
    @Step(CSV_PROCESS)
    protected IBatchFlowCommand reportProcess() {
        return loopBatch(HanyoListTekiyoJogaishaProcess.class)
                .arguments(getParameter().toHanyoListTekiyoKaishaProcessParameter()).define();
    }

    /**
     * 連番ありbatchProcessです。
     *
     * @return IBatchFlowCommand
     */
    @Step(RENBAN_CSV_PROCESS)
    protected IBatchFlowCommand reportRenbanProcess() {
        return loopBatch(HanyoListTekiyoJogaishaRenbanProcess.class)
                .arguments(getParameter().toHanyoListTekiyoKaishaProcessParameter()).define();
    }
}
