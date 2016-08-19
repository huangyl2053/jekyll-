/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.batchcontroller.flow.shinsataishodataoutput;

import jp.co.ndensan.reams.db.dbe.batchcontroller.step.shinsataishodataoutput.DbT5501UpdateProcess;
import jp.co.ndensan.reams.db.dbe.batchcontroller.step.shinsataishodataoutput.NijihanteiKekkaTorokuMobileOutPutProcess;
import jp.co.ndensan.reams.db.dbe.batchcontroller.step.shinsataishodataoutput.ShinsaTaishoDataOutPutProcess;
import jp.co.ndensan.reams.db.dbe.definition.batchprm.shinsataishodataoutput.ShinsaTaishoDataOutPutBatchParammeter;
import jp.co.ndensan.reams.uz.uza.batch.Step;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;
import jp.co.ndensan.reams.uz.uza.batch.flow.IBatchFlowCommand;

/**
 * 認定審査会割当委員情報出力（モバイル）のバッチフロークラスです。
 *
 * @reamsid_L DBE-1840-011 yaoyahui
 */
public class ShinsaTaishoDataOutPutFlow extends BatchFlowBase<ShinsaTaishoDataOutPutBatchParammeter> {

    private static final String SHINSATAISHODATAOUTPUT = "shinsataishodataoutput";
    private static final String NIJIHANTEIKEKKATOROK = "nijihanteikekkatorokumobileoutput";
    private static final String DBT5501UPDATEPROCESS = "dbt5501updateprocess";

    @Override
    protected void defineFlow() {
        executeStep(SHINSATAISHODATAOUTPUT);
        executeStep(NIJIHANTEIKEKKATOROK);
        executeStep(DBT5501UPDATEPROCESS);

    }

    /**
     * 認定調査データ出力（モバイル）のCSV出力Processです。
     *
     * @return 認定調査データ出力（モバイル）
     */
    @Step(SHINSATAISHODATAOUTPUT)
    protected IBatchFlowCommand callShinsaTaishoDataOutPut() {
        return loopBatch(ShinsaTaishoDataOutPutProcess.class)
                .arguments(getParameter().toShinsaTaishoDataOutProcessParammeter()).define();
    }

    /**
     * 認定調査データ出力（モバイル）のCSV出力Processです。
     *
     * @return 認定調査データ出力（モバイル）
     */
    @Step(NIJIHANTEIKEKKATOROK)
    protected IBatchFlowCommand callNijihanteiKekkaTorokuMobileOutPut() {
        return loopBatch(NijihanteiKekkaTorokuMobileOutPutProcess.class)
                .arguments(getParameter().toShinsaTaishoDataOutProcessParammeter()).define();
    }

    /**
     * 認定調査データ出力（モバイル）のCSV出力Processです。
     *
     * @return 認定調査データ出力（モバイル）
     */
    @Step(DBT5501UPDATEPROCESS)
    protected IBatchFlowCommand callDbT5501Update() {
        return loopBatch(DbT5501UpdateProcess.class)
                .arguments(getParameter().toShinsaTaishoDataOutProcessParammeter()).define();
    }
}
