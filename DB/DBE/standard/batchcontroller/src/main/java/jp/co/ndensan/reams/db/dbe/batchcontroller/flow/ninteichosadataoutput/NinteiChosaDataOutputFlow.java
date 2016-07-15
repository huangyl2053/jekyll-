/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.batchcontroller.flow.ninteichosadataoutput;

import jp.co.ndensan.reams.db.dbe.batchcontroller.step.ninteichosadataoutput.DbT5301UpdateProcess;
import jp.co.ndensan.reams.db.dbe.batchcontroller.step.ninteichosadataoutput.NinteiChosaDataOutputProcess;
import jp.co.ndensan.reams.db.dbe.definition.batchprm.ninteichosadataoutput.NinteiChosaDataOutputBatchParamter;
import jp.co.ndensan.reams.uz.uza.batch.Step;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;
import jp.co.ndensan.reams.uz.uza.batch.flow.IBatchFlowCommand;

/**
 * 認定調査データ出力（モバイル）バッチフロークラスです。
 *
 * @reamsid_L DBE-1860-011 duanzhanli
 */
public class NinteiChosaDataOutputFlow extends BatchFlowBase<NinteiChosaDataOutputBatchParamter> {

    private static final String NINTEICHOSADATAOUTPUT = "ninteichosadataoutput";
    private static final String DBUPDATEPROCESS = "dbT5301UpdateProcess";

    @Override
    protected void defineFlow() {
        executeStep(NINTEICHOSADATAOUTPUT);
        executeStep(DBUPDATEPROCESS);
    }

    /**
     * 認定調査データ出力（モバイル）のCSV出力Processです。
     *
     * @return 認定調査データ出力（モバイル）
     */
    @Step(NINTEICHOSADATAOUTPUT)
    protected IBatchFlowCommand callNinteiChosaDataOutput() {
        return loopBatch(NinteiChosaDataOutputProcess.class)
                .arguments(getParameter().toNinteiChosaDataOutputProcessParamter()).define();
    }

    /**
     * 認定調査データ出力（モバイル）のDB更新Processです。
     *
     * @return 認定調査データ出力（モバイル）
     */
    @Step(DBUPDATEPROCESS)
    protected IBatchFlowCommand callDbT5301UpdateProcess() {
        return loopBatch(DbT5301UpdateProcess.class)
                .arguments(getParameter().toNinteiChosaDataOutputProcessParamter()).define();
    }
}
