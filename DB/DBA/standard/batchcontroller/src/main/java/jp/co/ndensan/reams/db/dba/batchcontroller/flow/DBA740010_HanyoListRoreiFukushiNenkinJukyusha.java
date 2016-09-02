/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.batchcontroller.flow;

import jp.co.ndensan.reams.db.dba.batchcontroller.step.DBA740010.HanyoListRoreiFukushiNenkinJukyushaProcess;
import jp.co.ndensan.reams.db.dba.batchcontroller.step.DBA740010.HanyoListRoreiFukushiNenkinJukyushaRenbanProcess;
import jp.co.ndensan.reams.db.dba.definition.batchprm.DBA740010.DBA740010_HanyoListRoreiFukushiNenkinJukyushaParameter;
import jp.co.ndensan.reams.uz.uza.batch.Step;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;
import jp.co.ndensan.reams.uz.uza.batch.flow.IBatchFlowCommand;

/**
 * 汎用リスト_老齢福祉年金受給者バッチ処理クラスです。
 *
 * @reamsid_L DBA-1620-030 yaodongsheng
 */
public class DBA740010_HanyoListRoreiFukushiNenkinJukyusha extends BatchFlowBase<DBA740010_HanyoListRoreiFukushiNenkinJukyushaParameter> {

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
        return loopBatch(HanyoListRoreiFukushiNenkinJukyushaProcess.class)
                .arguments(getParameter().toHanyoListRoreiFukushiNenkinJukyushaProcessParameter()).define();
    }

    /**
     * 連番ありbatchProcessです。
     *
     * @return IBatchFlowCommand
     */
    @Step(RENBAN_CSV_PROCESS)
    protected IBatchFlowCommand reportRenbanProcess() {
        return loopBatch(HanyoListRoreiFukushiNenkinJukyushaRenbanProcess.class)
                .arguments(getParameter().toHanyoListRoreiFukushiNenkinJukyushaProcessParameter()).define();
    }
}
