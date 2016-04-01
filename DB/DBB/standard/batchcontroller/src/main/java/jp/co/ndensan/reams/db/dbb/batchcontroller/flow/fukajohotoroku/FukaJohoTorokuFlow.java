package jp.co.ndensan.reams.db.dbb.batchcontroller.flow.fukajohotoroku;

import jp.co.ndensan.reams.db.dbb.batchcontroller.step.fukajohotoroku.FukaJohoHenshuProcess;
import jp.co.ndensan.reams.db.dbb.definition.batchprm.fukajohotoroku.FukaJohoTorokuBatchParameter;
import jp.co.ndensan.reams.uz.uza.batch.Step;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;
import jp.co.ndensan.reams.uz.uza.batch.flow.IBatchFlowCommand;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 賦課の情報を一括登録するバッチフロークラスです。
 */
public class FukaJohoTorokuFlow extends BatchFlowBase<FukaJohoTorokuBatchParameter> {

    @Override
    protected void defineFlow() {
        executeStep(HENSHU_PROCESS);
        executeStep(CALL_CHOTEITOROKU_FLOW);
    }
    private static final String HENSHU_PROCESS = "fukaJohoHenshuProcess";

    /**
     * 賦課の情報を一括登録事前データを編集します。
     *
     * @return IBatchFlowCommand
     */
    @Step(HENSHU_PROCESS)
    protected IBatchFlowCommand henshuProcess() {
        return loopBatch(FukaJohoHenshuProcess.class).arguments(getParameter()
                .toFukaJohoHenshuProcessParameter()).define();
    }
//  TODO QA954-#79926 URで提供される調定登録(バッチ)不明 王暁冬 2013/03/24
    private static final String CALL_CHOTEITOROKU_FLOW = "ChoteiTorokuFlow";
    private static final RString BATCH_ID = new RString("ChoteiTorokuFlow");

    /**
     * 賦課情報一時テーブルのすべての要素を取得します。
     *
     * @return IBatchFlowCommand
     */
    @Step(CALL_CHOTEITOROKU_FLOW)
    protected IBatchFlowCommand callChoteiTorokuFlow() {
        return otherBatchFlow(BATCH_ID, SubGyomuCode.DBB介護賦課, null).define();
    }
}
