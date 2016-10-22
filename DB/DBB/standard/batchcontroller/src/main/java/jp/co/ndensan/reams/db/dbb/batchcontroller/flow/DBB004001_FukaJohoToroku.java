package jp.co.ndensan.reams.db.dbb.batchcontroller.flow;

import jp.co.ndensan.reams.ca.cax.definition.batchprm.ChoteiTorokuParameter;
import jp.co.ndensan.reams.db.dbb.batchcontroller.step.DBB004001.FukaJohoHenshuProcess;
import jp.co.ndensan.reams.db.dbb.batchcontroller.step.DBB004001.FukaJohoInsertProcess;
import jp.co.ndensan.reams.db.dbb.definition.batchprm.DBB004001.DBB004001_FukaJohoTorokuParameter;
import jp.co.ndensan.reams.uz.uza.batch.Step;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;
import jp.co.ndensan.reams.uz.uza.batch.flow.IBatchFlowCommand;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 賦課の情報を一括登録するバッチフロークラスです。
 *
 * @reamsid_L DBB-9040-060 wangxiaodong
 */
public class DBB004001_FukaJohoToroku extends BatchFlowBase<DBB004001_FukaJohoTorokuParameter> {

    private static final String HENSHU_PROCESS = "fukaJohoHenshuProcess";
    private static final String FUKAJOHOINSERTPROCESS = "fukaJohoInsertProcess";
    private static final String CALL_CHOTEITOROKU_FLOW = "ChoteiTorokuFlow";
    private static final RString CHOTEITOROKU_FLOWID = new RString("CAX000001_ChoteiToroku");

    @Override
    protected void defineFlow() {
        executeStep(HENSHU_PROCESS);
        executeStep(CALL_CHOTEITOROKU_FLOW);
        executeStep(FUKAJOHOINSERTPROCESS);
    }

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

    /**
     * 賦課情報一時テーブルのすべての要素を取得します。
     *
     * @return IBatchFlowCommand
     */
    @Step(CALL_CHOTEITOROKU_FLOW)
    protected IBatchFlowCommand callChoteiTorokuFlow() {
        ChoteiTorokuParameter parameter = new ChoteiTorokuParameter();
        parameter.setSchema(new RString("rgdb"));
        parameter.setChoteiIdAutoNumbering(true);
        parameter.setShunoIdAutoNumbering(true);
        return otherBatchFlow(CHOTEITOROKU_FLOWID, SubGyomuCode.CAX収滞公開, parameter).define();
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
