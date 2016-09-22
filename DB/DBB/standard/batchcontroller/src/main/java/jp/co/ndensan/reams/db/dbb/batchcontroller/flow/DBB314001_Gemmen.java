/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.batchcontroller.flow;

import jp.co.ndensan.reams.db.dbb.batchcontroller.step.dbb314001.GemmenProcess;
import jp.co.ndensan.reams.db.dbb.definition.batchprm.DBB004001.DBB004001_FukaJohoTorokuParameter;
import jp.co.ndensan.reams.db.dbb.definition.batchprm.DBB314001.DBB314001_GemmenParameter;
import jp.co.ndensan.reams.uz.uza.batch.Step;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;
import jp.co.ndensan.reams.uz.uza.batch.flow.IBatchFlowCommand;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * バッチ設計_DBBMN61002_介護保険料減免登録(一括)のバッチ処理フロー
 *
 * @reamsid_L DBB-1670-030 surun
 */
public class DBB314001_Gemmen extends BatchFlowBase<DBB314001_GemmenParameter> {

    private static final String CSV_EUC_PROCESS = "csvEucProcess";
    private static final String 賦課の情報登録フロー = "choteiToroku";
    private static final RString 賦課の情報登録フローBATCHID = new RString("DBB004001_FukaJohoToroku");

    @Override
    protected void defineFlow() {
        executeStep(CSV_EUC_PROCESS);
        executeStep(賦課の情報登録フロー);
    }

    /**
     * 介護保険料減免登録(一括)Process
     *
     * @return IBatchFlowCommand
     */
    @Step(CSV_EUC_PROCESS)
    IBatchFlowCommand csvEucProcess() {
        return loopBatch(GemmenProcess.class)
                .arguments(getParameter().toProcessParameter()).define();
    }

    /**
     * 賦課の情報登録フローを呼び出す。
     *
     * @return バッチコマンド
     */
    @Step(賦課の情報登録フロー)
    protected IBatchFlowCommand choteiToroku() {
        return otherBatchFlow(賦課の情報登録フローBATCHID, SubGyomuCode.DBB介護賦課,
                new DBB004001_FukaJohoTorokuParameter(true)).define();
    }
}
