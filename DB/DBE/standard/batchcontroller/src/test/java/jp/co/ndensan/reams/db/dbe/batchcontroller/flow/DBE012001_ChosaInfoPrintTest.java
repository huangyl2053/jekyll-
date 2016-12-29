/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.batchcontroller.flow;

import jp.co.ndensan.reams.db.dbe.definition.batchprm.DBE012001.DBE012001_ChosaInfoPrintParameter;
import jp.co.ndensan.reams.db.dbz.testhelper.DbeTestBase;
import jp.co.ndensan.reams.uz.uza.batch.BatchExitStatus;
import jp.co.ndensan.reams.uz.uza.biz.ReamsDonyuDantaiCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.core._ControlData;
import jp.co.ndensan.reams.uz.uza.core._ControlDataHolder;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.testhelper.BatchFlowTestHelper;
import jp.co.ndensan.reams.uz.uza.workflow.context.FlowContext;
import jp.co.ndensan.reams.uz.uza.workflow.flow.valueobject.FlowId;
import jp.co.ndensan.reams.uz.uza.workflow.flow.valueobject.FlowInstanceId;
import static org.hamcrest.CoreMatchers.is;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import static org.mockito.Mockito.when;

/**
 * {@link DBE012001_ChosaInfoPrint}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class DBE012001_ChosaInfoPrintTest extends DbeTestBase {

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
                    new RString("DBE012001_ChosaInfoPrint"),
                    new RString("調査情報印刷"),
                    DBE012001_ChosaInfoPrint.class,
                    createBatchParameter());
            assertThat(result.getStatus(), is(BatchExitStatus.Status.SUCCESS));
        }

    }

    private static DBE012001_ChosaInfoPrintParameter createBatchParameter() {
        RDate 処理日開始 = new RDate(2016, 12, 1);
        RDate 処理日終了 = new RDate(2016, 12, 31);
        DBE012001_ChosaInfoPrintParameter parameter = new DBE012001_ChosaInfoPrintParameter();

        parameter.setNinteichosayoteimitei(true);
        parameter.setYoteimiteiymdFrom(処理日開始.toDateString());
        parameter.setYoteimiteiymdTo(処理日終了.toDateString());
        parameter.setJoken1(new RString("2"));
        parameter.setNinteichosaijoken(true);
        parameter.setIraisakihenkymdFrom(処理日開始.toDateString());
        parameter.setIraisakihenkymdTo(処理日終了.toDateString());
        parameter.setCheckListJoken(true);
        parameter.setJoken3(new RString("2"));
        parameter.setCheckListShinseiYMDFrom(処理日開始.toDateString());
        parameter.setCheckListShinseiYMDTo(処理日終了.toDateString());

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
