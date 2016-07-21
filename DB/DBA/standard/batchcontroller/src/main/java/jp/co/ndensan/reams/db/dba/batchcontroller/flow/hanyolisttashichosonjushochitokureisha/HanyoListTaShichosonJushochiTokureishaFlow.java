/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.batchcontroller.flow.hanyolisttashichosonjushochitokureisha;

import jp.co.ndensan.reams.db.dba.batchcontroller.step.hanyolisttashichosonjushochitokureisha.HanyoListTaShichosonJushochiTokureishaProcess;
import jp.co.ndensan.reams.db.dba.batchcontroller.step.hanyolisttashichosonjushochitokureisha.HanyoListTaShichosonJushochiTokureishaRenbanProcess;
import jp.co.ndensan.reams.db.dba.definition.batchprm.hanyolistseikatsuhogojukyusha.HanyoListBatchParameter;
import jp.co.ndensan.reams.uz.uza.batch.Step;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;
import jp.co.ndensan.reams.uz.uza.batch.flow.IBatchFlowCommand;

/**
 * 汎用リスト_他市町村住所地特例者バッチ処理クラスです。
 *
 * @reamsid_L DBA-1590-030 yaodongsheng
 */
public class HanyoListTaShichosonJushochiTokureishaFlow extends BatchFlowBase<HanyoListBatchParameter> {

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
        return loopBatch(HanyoListTaShichosonJushochiTokureishaProcess.class)
                .arguments(getParameter().toHanyoListTaShichosonJushochiTokureishaProcessParameter()).define();
    }

    /**
     * 連番ありbatchProcessです。
     *
     * @return IBatchFlowCommand
     */
    @Step(RENBAN_CSV_PROCESS)
    protected IBatchFlowCommand reportRenbanProcess() {
        return loopBatch(HanyoListTaShichosonJushochiTokureishaRenbanProcess.class)
                .arguments(getParameter().toHanyoListTaShichosonJushochiTokureishaProcessParameter()).define();
    }
}
