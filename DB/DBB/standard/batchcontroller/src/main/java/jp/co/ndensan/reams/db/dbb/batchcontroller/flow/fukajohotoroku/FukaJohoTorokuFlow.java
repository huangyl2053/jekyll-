package jp.co.ndensan.reams.db.dbb.batchcontroller.flow.fukajohotoroku;

import jp.co.ndensan.reams.ca.cax.definition.batchprm.ChoteiTorokuParameter;
import jp.co.ndensan.reams.db.dbb.batchcontroller.step.fukajohotoroku.FukaJohoHenshuProcess;
import jp.co.ndensan.reams.db.dbb.batchcontroller.step.fukajohotoroku.FukaJohoInsertProcess;
import jp.co.ndensan.reams.db.dbb.definition.batchprm.fukajohotoroku.FukaJohoTorokuBatchParameter;
import jp.co.ndensan.reams.uz.uza.batch.Step;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;
import jp.co.ndensan.reams.uz.uza.batch.flow.IBatchFlowCommand;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 賦課の情報を一括登録するバッチフロークラスです。
 *
 * @reamsid_L DBB-9040-060 wangxiaodong
 */
public class FukaJohoTorokuFlow extends BatchFlowBase<FukaJohoTorokuBatchParameter> {

    @Override
    protected void defineFlow() {
        executeStep(HENSHU_PROCESS);
        //TODO 内部QA1119　DBでrgdb.UrT0772KamokubetsuKoyuJohoがない
        //executeStep(CALL_CHOTEITOROKU_FLOW);
        //TODO　QA1123　DB登録する場合、エラーが発生
        executeStep(FUKAJOHOINSERTPROCESS);
    }

    private static final String HENSHU_PROCESS = "fukaJohoHenshuProcess";
    private static final String FUKAJOHOINSERTPROCESS = "fukaJohoInsertProcess";

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
    private static final String CALL_CHOTEITOROKU_FLOW = "ChoteiTorokuFlow";
    private static final RString BATCH_ID = new RString("ChoteiTorokuFlow");

    /**
     * 賦課情報一時テーブルのすべての要素を取得します。
     *
     * @return IBatchFlowCommand
     */
    @Step(CALL_CHOTEITOROKU_FLOW)
    protected IBatchFlowCommand callChoteiTorokuFlow() {
        ChoteiTorokuParameter choteiTorokuParameter = new ChoteiTorokuParameter();
        choteiTorokuParameter.setSchema(new RString("rgdb"));
        return otherBatchFlow(BATCH_ID, SubGyomuCode.DBB介護賦課, choteiTorokuParameter).define();
    }

    /**
     * 賦課の情報を一括登録します。
     *
     * @return FukaJohoInsertProcess
     */
    @Step(FUKAJOHOINSERTPROCESS)
    protected IBatchFlowCommand callFukaJohoInsertProcess() {
        return loopBatch(FukaJohoInsertProcess.class).arguments(getParameter()
                .toFukaJohoHenshuProcessParameter()).define();
    }
}
