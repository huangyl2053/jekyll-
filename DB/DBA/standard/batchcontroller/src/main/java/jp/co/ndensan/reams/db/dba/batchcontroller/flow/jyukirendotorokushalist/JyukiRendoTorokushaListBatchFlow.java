/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.batchcontroller.flow.jyukirendotorokushalist;

import jp.co.ndensan.reams.db.dba.batchcontroller.step.jyukirendotorokushalist.JyukiRendoJouhouProcess;
import jp.co.ndensan.reams.db.dba.batchcontroller.step.jyukirendotorokushalist.ShoriDateKanriDBUpdateProcess;
import jp.co.ndensan.reams.db.dba.definition.batchprm.jyukirendotorokushalistbatch.JyukiRendoTorokushaListBatchParameter;
import jp.co.ndensan.reams.uz.uza.batch.Step;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;
import jp.co.ndensan.reams.uz.uza.batch.flow.IBatchFlowCommand;

/**
 *
 */
public class JyukiRendoTorokushaListBatchFlow extends BatchFlowBase<JyukiRendoTorokushaListBatchParameter> {

    private static final String DATA_CREATE_PROCESS = "dataCreateProcess";
    private static final String DB_UPDATE_PROCESS = "DBUpdateProcess";

    @Override
    protected void defineFlow() {
        executeStep(DATA_CREATE_PROCESS);
        executeStep(DB_UPDATE_PROCESS);
    }

    @Step(DATA_CREATE_PROCESS)
    private IBatchFlowCommand createData() {
        return simpleBatch(JyukiRendoJouhouProcess.class).arguments(
                getParameter().toJyukiRendoTorokushaListBatchProcessParameter()).define();
    }

    @Step(DB_UPDATE_PROCESS)
    private IBatchFlowCommand updateData() {
        return simpleBatch(ShoriDateKanriDBUpdateProcess.class).arguments(
                getParameter().toJyukiRendoTorokushaListBatchProcessParameter()).define();
    }
}
