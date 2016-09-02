/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.batchcontroller.flow;

import jp.co.ndensan.reams.db.dba.batchcontroller.step.DBA140010.JyukiRendoJouhouProcess;
import jp.co.ndensan.reams.db.dba.batchcontroller.step.DBA140010.ShoriDateKanriDBUpdateProcess;
import jp.co.ndensan.reams.db.dba.definition.batchprm.DBA140010.DBA140010_JukiRendoTorokushaListParameter;
import jp.co.ndensan.reams.uz.uza.batch.Step;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;
import jp.co.ndensan.reams.uz.uza.batch.flow.IBatchFlowCommand;

/**
 * 住基連動登録者_バッチ処理クラスです。
 *
 * @reamsid_L DBA-0560-020 xuyannan
 */
public class DBA140010_JukiRendoTorokushaList extends BatchFlowBase<DBA140010_JukiRendoTorokushaListParameter> {

    private static final String DATA_CREATE_PROCESS = "dataCreateProcess";
    private static final String DB_UPDATE_PROCESS = "DBUpdateProcess";

    @Override
    protected void defineFlow() {
        executeStep(DATA_CREATE_PROCESS);
        executeStep(DB_UPDATE_PROCESS);
    }

    /**
     * データを作成します。
     *
     * @return IBatchFlowCommand
     */
    @Step(DATA_CREATE_PROCESS)
    protected IBatchFlowCommand createData() {
        return simpleBatch(JyukiRendoJouhouProcess.class).arguments(
                getParameter().toJyukiRendoTorokushaListBatchProcessParameter()).define();
    }

    /**
     * 処理日付管理マスタを更新します。
     *
     * @return IBatchFlowCommand
     */
    @Step(DB_UPDATE_PROCESS)
    protected IBatchFlowCommand updateData() {
        return simpleBatch(ShoriDateKanriDBUpdateProcess.class).arguments(
                getParameter().toJyukiRendoTorokushaListBatchProcessParameter()).define();
    }
}
