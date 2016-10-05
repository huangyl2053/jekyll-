/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.batchcontroller.flow;

import jp.co.ndensan.reams.db.dba.batchcontroller.step.DBA150010.NenreiTotatsuTorokushaProcess;
import jp.co.ndensan.reams.db.dba.definition.batchprm.DBA150010.DBA150010_NenreitotatsuTorokuListParameter;
import jp.co.ndensan.reams.uz.uza.batch.Step;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;
import jp.co.ndensan.reams.uz.uza.batch.flow.IBatchFlowCommand;

/**
 * 年齢到達登録者_バッチ処理クラスです。
 *
 * @reamsid_L DBA-0570-020 xuyannan
 */
public class DBA150010_NenreitotatsuTorokuList extends BatchFlowBase<DBA150010_NenreitotatsuTorokuListParameter> {

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
