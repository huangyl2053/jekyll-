/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.batchcontroller.flow.nenreitotatsutorokushalist;

import jp.co.ndensan.reams.db.dba.batchcontroller.step.nenreitotatsutorokushalist.NenreiTotatsuTorokushaProcess;
import jp.co.ndensan.reams.db.dba.definition.batchprm.nenreitotatsutorokushalistbatch.NenreiTotatsuTorokushaListBatchParameter;
import jp.co.ndensan.reams.uz.uza.batch.Step;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;
import jp.co.ndensan.reams.uz.uza.batch.flow.IBatchFlowCommand;

/**
 * 年齢到達登録者_バッチ処理クラスです。
 */
public class NenreiTotatsuTorokushaListBatchFlow extends BatchFlowBase<NenreiTotatsuTorokushaListBatchParameter> {

    private static final String DATA_CREATE_PROCESS = "dataCreateProcess";

    @Override
    protected void defineFlow() {
        executeStep(DATA_CREATE_PROCESS);
    }

    /**
     * データを作成します。
     *
     * @return IBatchFlowCommand
     */
    @Step(DATA_CREATE_PROCESS)
    protected IBatchFlowCommand createData() {
        return loopBatch(NenreiTotatsuTorokushaProcess.class).arguments(
                getParameter().toNenreiTotatsushaTorokuListProcessParameter()).define();
    }
}
