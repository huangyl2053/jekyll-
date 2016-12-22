/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.batchcontroller.flow;

import jp.co.ndensan.reams.db.dbe.batchcontroller.step.shinsataishodataoutput.CodeMasterOutputProcess;
import jp.co.ndensan.reams.db.dbe.batchcontroller.step.shinsataishodataoutput.DbT5501UpdateProcess;
import jp.co.ndensan.reams.db.dbe.batchcontroller.step.shinsataishodataoutput.GaikyoChosaDataOutputProcess;
import jp.co.ndensan.reams.db.dbe.batchcontroller.step.shinsataishodataoutput.KihonChosaKomokuDataOutputProcess;
import jp.co.ndensan.reams.db.dbe.batchcontroller.step.shinsataishodataoutput.ShinsakaiIinJohoOutputProcess;
import jp.co.ndensan.reams.db.dbe.batchcontroller.step.shinsataishodataoutput.ShinsakaiJohoOutputProcess;
import jp.co.ndensan.reams.db.dbe.definition.batchprm.shinsataishodataoutput.ShinsaTaishoDataOutPutBatchParammeter;
import jp.co.ndensan.reams.uz.uza.batch.Step;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;
import jp.co.ndensan.reams.uz.uza.batch.flow.IBatchFlowCommand;

/**
 * 認定審査会割当委員情報出力（モバイル）のバッチフロークラスです。
 *
 * @reamsid_L DBE-1840-011 yaoyahui
 */
public class DBE518001_NinteiShinsaIraiIfSakusei extends BatchFlowBase<ShinsaTaishoDataOutPutBatchParammeter> {

    private static final String 介護認定審査会情報出力 = "介護認定審査会情報出力";
    private static final String 介護認定審査会委員情報出力 = "介護認定審査会委員情報出力";
    private static final String 基本調査項目データ出力 = "基本調査項目データ出力";
    private static final String 概況調査データ出力 = "概況調査データ出力";
    private static final String コードマスタ出力 = "コードマスタ出力";
    private static final String DbT5501更新 = "DbT5501更新";

    @Override
    protected void defineFlow() {
        executeStep(介護認定審査会情報出力);
        executeStep(介護認定審査会委員情報出力);
        executeStep(概況調査データ出力);
        executeStep(基本調査項目データ出力);
        executeStep(コードマスタ出力);
        executeStep(DbT5501更新);

    }

    /**
     * 介護認定審査会情報のCSV出力プロセス呼び出しです。
     *
     * @return 介護認定審査会情報のCSV出力プロセス
     */
    @Step(介護認定審査会情報出力)
    protected IBatchFlowCommand call介護認定審査会情報出力() {
        return loopBatch(ShinsakaiJohoOutputProcess.class)
                .arguments(getParameter().toShinsaTaishoDataOutProcessParammeter()).define();
    }

    /**
     * 介護認定審査会委員情報のCSV出力プロセス呼び出しです。
     *
     * @return 介護認定審査会委員情報のCSV出力プロセス
     */
    @Step(介護認定審査会委員情報出力)
    protected IBatchFlowCommand call介護認定審査会委員情報出力() {
        return loopBatch(ShinsakaiIinJohoOutputProcess.class)
                .arguments(getParameter().toShinsaTaishoDataOutProcessParammeter()).define();
    }

    /**
     * 概況調査データのCSV出力プロセス呼び出しです。
     *
     * @return 介護認定審査会委員情報のCSV出力プロセス
     */
    @Step(概況調査データ出力)
    protected IBatchFlowCommand call概況調査データ出力() {
        return loopBatch(GaikyoChosaDataOutputProcess.class)
                .arguments(getParameter().toShinsaTaishoDataOutProcessParammeter()).define();
    }

    /**
     * 基本調査項目データのCSV出力プロセス呼び出しです。
     *
     * @return 介護認定審査会委員情報のCSV出力プロセス
     */
    @Step(基本調査項目データ出力)
    protected IBatchFlowCommand call基本調査項目データ出力() {
        return loopBatch(KihonChosaKomokuDataOutputProcess.class)
                .arguments(getParameter().toShinsaTaishoDataOutProcessParammeter()).define();
    }

    /**
     * コードマスタCSV出力Processです。
     *
     * @return コードマスタCSV出力
     */
    @Step(コードマスタ出力)
    protected IBatchFlowCommand callコードマスタ出力() {
        return simpleBatch(CodeMasterOutputProcess.class)
                .arguments(getParameter().toShinsaTaishoDataOutProcessParammeter()).define();
    }

    /**
     * DB出力(介護認定審査会開催予定情報)Processです。
     *
     * @return DB出力(介護認定審査会開催予定情報)
     */
    @Step(DbT5501更新)
    protected IBatchFlowCommand callDbT5501Update() {
        return loopBatch(DbT5501UpdateProcess.class)
                .arguments(getParameter().toShinsaTaishoDataOutProcessParammeter()).define();
    }
}
