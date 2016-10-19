package jp.co.ndensan.reams.db.dbb.batchcontroller.flow;

import java.util.HashMap;
import java.util.Map;
import jp.co.ndensan.reams.ca.cax.batchcontroller.step.choteitoroku.ChoteiDataCheckProcess;
import jp.co.ndensan.reams.db.dbb.batchcontroller.step.DBB004001.FukaJohoHenshuProcess;
import jp.co.ndensan.reams.db.dbb.batchcontroller.step.DBB004001.FukaJohoInsertProcess;
import jp.co.ndensan.reams.db.dbb.definition.batchprm.DBB004001.DBB004001_FukaJohoTorokuParameter;
import jp.co.ndensan.reams.uz.uza.batch.Step;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;
import jp.co.ndensan.reams.uz.uza.batch.flow.IBatchFlowCommand;
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
        Map param = new HashMap();
        param.put(new RString("schema"), new RString("rgdb"));
        param.put(new RString("choteiIdNumbering"), Boolean.valueOf(true));
        param.put(new RString("shunoIdNumbering"), Boolean.valueOf(true));
        return simpleBatch(ChoteiDataCheckProcess.class).arguments(param).define();
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
