/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.batchcontroller.flow;

import jp.co.ndensan.reams.db.dbe.definition.batchprm.DBE011001.DBE011001_ShinseiInfoPrintParameter;
import jp.co.ndensan.reams.db.dbz.testhelper.DbeTestBase;
import jp.co.ndensan.reams.uz.uza.batch.BatchExitStatus;
import jp.co.ndensan.reams.uz.uza.biz.ReamsDonyuDantaiCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.core._ControlData;
import jp.co.ndensan.reams.uz.uza.core._ControlDataHolder;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.testhelper.BatchFlowTestHelper;
import jp.co.ndensan.reams.uz.uza.workflow.context.FlowContext;
import jp.co.ndensan.reams.uz.uza.workflow.flow.valueobject.FlowId;
import jp.co.ndensan.reams.uz.uza.workflow.flow.valueobject.FlowInstanceId;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import static org.mockito.Mockito.when;

/**
 * {@link DBE011001_ShinseiInfoPrint}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class DBE011001_ShinseiInfoPrintTest extends DbeTestBase {

    private static BatchFlowTestHelper flowHelper;

    public static class バッチフローテスト extends DbeTestBase {

        @Before
        public void setUp() {
            flowHelper = new BatchFlowTestHelper();
        }

        @Test
        public void パラメーターが正しく設定されている場合_バッチフロー実施結果は_Successで返すこと() throws Exception {
            setExecutionSubGyomuCodeToControlData(SubGyomuCode.DBE認定支援);
            BatchExitStatus result = flowHelper.executeFlow(
                    new RString("DBE011001_ShinseiInfoPrint"),
                    new RString("申請情報印刷"),
                    DBE011001_ShinseiInfoPrint.class,
                    createBatchParameter());
            assertThat(result.getStatus(), is(BatchExitStatus.Status.SUCCESS));
        }

    }

    private static DBE011001_ShinseiInfoPrintParameter createBatchParameter() {
        RDateTime 処理日開始 = RDateTime.of(2015, 1, 1, 00, 00);
        RDateTime 処理日終了 = RDateTime.of(2017, 12, 31, 00, 00);
        DBE011001_ShinseiInfoPrintParameter parameter = new DBE011001_ShinseiInfoPrintParameter();

        parameter.setShinseimonitorflag(true);
        parameter.setMonitorsakuseijyouken(new RString("1"));
        parameter.setYokaigoyoshienseiichiranflag(true);
        parameter.setShinseishaichiransakuseijyouken(new RString("1"));
        parameter.setShinseishasakuseijyoukenuser(false);
        parameter.setShinseishashorikaFrom(処理日開始);
        parameter.setShinseishashorikaTo(処理日終了);

        return parameter;
    }

    private static void setExecutionSubGyomuCodeToControlData(SubGyomuCode executionSubGyomuCode) {
        _ControlData controlData = new _ControlData(SubGyomuCode.DBE認定支援.toString(), "test",
                new ReamsDonyuDantaiCode("209007"));
        FlowContext flowContext = createFlowContext("testFlowInstanceId", "DBEWF21005");
        when(flowContext.getExecutionSubGyomuCode()).thenReturn(executionSubGyomuCode);
        controlData.setFlowContext(flowContext);
        _ControlDataHolder.setControlData(controlData);
    }

    private static FlowContext createFlowContext(String flowInstanceId, String flowId) {
        FlowContext flowContext = Mockito.mock(FlowContext.class);
        Mockito.when(flowContext.getFlowInstanceId()).thenReturn(new FlowInstanceId(flowInstanceId));
        Mockito.when(flowContext.getFlowId()).thenReturn(new FlowId(flowId));
        return flowContext;
    }

}
