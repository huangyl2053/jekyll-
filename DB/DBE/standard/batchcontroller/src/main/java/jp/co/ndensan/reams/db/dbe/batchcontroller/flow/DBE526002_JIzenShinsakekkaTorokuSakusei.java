/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.batchcontroller.flow;

import jp.co.ndensan.reams.db.dbe.batchcontroller.step.DBE526002.JizenShinsaKekkaProcess;
import jp.co.ndensan.reams.db.dbe.definition.batchprm.DBE526002.DBE526002_JIzenShinsakekkaTorokuSakuseiParameter;
import jp.co.ndensan.reams.uz.uza.batch.Step;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;
import jp.co.ndensan.reams.uz.uza.batch.flow.IBatchFlowCommand;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * 事前審査結果登録データ作成flowクラスです。
 *
 * @reamsid_L DBE-1630-020 xuyongchao
 */
public class DBE526002_JIzenShinsakekkaTorokuSakusei extends BatchFlowBase<DBE526002_JIzenShinsakekkaTorokuSakuseiParameter> {

    private static final String JIZENSHINSAKEKKA_PROCESS = "JizenShinsaKekka";
    private static final String CALL_SHINSAKAI_FLOW = "callShinsakaiFlow";
    private static final RString BATCH_ID = new RString("DBE517002_ShinsakaiShiryoIin");

    @Override
    protected void defineFlow() {
        executeStep(CALL_SHINSAKAI_FLOW);
        executeStep(JIZENSHINSAKEKKA_PROCESS);
    }

    /**
     * 認定調査報酬請求書のデータを作成します。
     *
     * @return IBatchFlowCommand
     */
    @Step(JIZENSHINSAKEKKA_PROCESS)
    protected IBatchFlowCommand createShinseiJouhouInsatuData() {
        return loopBatch(JizenShinsaKekkaProcess.class).arguments(
                getParameter().toJizenShinsakekkaProcessParameter()).define();
    }

    /**
     * 審査会資料一括作成（委員）バッチ(DBE517001)を呼びします。
     *
     * @return IBatchFlowCommand
     */
    @Step(CALL_SHINSAKAI_FLOW)
    protected IBatchFlowCommand callShinsakaiFlow() {
        return otherBatchFlow(BATCH_ID, SubGyomuCode.DBE認定支援, getParameter().toShiryoShinsakaiBatchParameter()).define();
    }

}
