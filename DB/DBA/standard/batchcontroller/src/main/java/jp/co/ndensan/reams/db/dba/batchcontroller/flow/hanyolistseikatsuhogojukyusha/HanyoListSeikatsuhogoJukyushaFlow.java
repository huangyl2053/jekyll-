/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.batchcontroller.flow.hanyolistseikatsuhogojukyusha;

import jp.co.ndensan.reams.db.dba.batchcontroller.step.hanyolistseikatsuhogojukyusha.HanyoListSeikatsuhogoJukyushaProcess;
import jp.co.ndensan.reams.db.dba.batchcontroller.step.hanyolistseikatsuhogojukyusha.HanyoListSeikatsuhogoJukyushaRenbanProcess;
import jp.co.ndensan.reams.db.dba.definition.batchprm.hanyolistseikatsuhogojukyusha.HanyoListBatchParameter;
import jp.co.ndensan.reams.uz.uza.batch.Step;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;
import jp.co.ndensan.reams.uz.uza.batch.flow.IBatchFlowCommand;

/**
 * 汎用リスト_生活保護受給者バッチ処理クラスです。
 *
 * @reamsid_L DBA-1580-030 xuyannan
 */
public class HanyoListSeikatsuhogoJukyushaFlow extends BatchFlowBase<HanyoListBatchParameter> {

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
        return loopBatch(HanyoListSeikatsuhogoJukyushaProcess.class)
                .arguments(getParameter().toSeikatsuhogoJukyushaProcessParameter()).define();
    }

    /**
     * 連番ありbatchProcessです。
     *
     * @return IBatchFlowCommand
     */
    @Step(RENBAN_CSV_PROCESS)
    protected IBatchFlowCommand reportRenbanProcess() {
        return loopBatch(HanyoListSeikatsuhogoJukyushaRenbanProcess.class)
                .arguments(getParameter().toSeikatsuhogoJukyushaProcessParameter()).define();
    }
}
