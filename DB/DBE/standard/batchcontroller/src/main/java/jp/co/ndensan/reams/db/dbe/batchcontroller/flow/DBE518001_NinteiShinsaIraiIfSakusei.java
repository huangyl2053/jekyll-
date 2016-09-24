/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.batchcontroller.flow;

import jp.co.ndensan.reams.db.dbe.batchcontroller.step.shinsataishodataoutput.DbT5501UpdateProcess;
import jp.co.ndensan.reams.db.dbe.batchcontroller.step.shinsataishodataoutput.NijihanteiKekkaTorokuMobileOutPutProcess;
import jp.co.ndensan.reams.db.dbe.batchcontroller.step.shinsataishodataoutput.ShinsaTaishoDataOutPutProcess;
import jp.co.ndensan.reams.db.dbe.definition.batchprm.shinsataishodataoutput.ShinsaTaishoDataOutPutBatchParammeter;
import jp.co.ndensan.reams.uz.uza.batch.Step;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;
import jp.co.ndensan.reams.uz.uza.batch.flow.IBatchFlowCommand;
import jp.co.ndensan.reams.uz.uza.io.Path;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 認定審査会割当委員情報出力（モバイル）のバッチフロークラスです。
 *
 * @reamsid_L DBE-1840-011 yaoyahui
 */
public class DBE518001_NinteiShinsaIraiIfSakusei extends BatchFlowBase<ShinsaTaishoDataOutPutBatchParammeter> {

    private static final String SHINSATAISHODATAOUTPUT = "shinsataishodataoutput";
    private static final String NIJIHANTEIKEKKATOROK = "nijihanteikekkatorokumobileoutput";
    private static final String DBT5501UPDATEPROCESS = "dbt5501updateprocess";

    @Override
    protected void defineFlow() {
        RString spoolWorkPath = Path.getTmpDirectoryPath();
        getParameter().setSpoolWorkPath(spoolWorkPath);
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
     * 二次判定結果登録用データ（モバイル）のCSV出力Processです。
     *
     * @return 二次判定結果登録用データ（モバイル）
     */
    @Step(NIJIHANTEIKEKKATOROK)
    protected IBatchFlowCommand callNijihanteiKekkaTorokuMobileOutPut() {
        return loopBatch(NijihanteiKekkaTorokuMobileOutPutProcess.class)
                .arguments(getParameter().toShinsaTaishoDataOutProcessParammeter()).define();
    }

    /**
     * DB出力(介護認定審査会開催予定情報)Processです。
     *
     * @return DB出力(介護認定審査会開催予定情報)
     */
    @Step(DBT5501UPDATEPROCESS)
    protected IBatchFlowCommand callDbT5501Update() {
        return loopBatch(DbT5501UpdateProcess.class)
                .arguments(getParameter().toShinsaTaishoDataOutProcessParammeter()).define();
    }
}
