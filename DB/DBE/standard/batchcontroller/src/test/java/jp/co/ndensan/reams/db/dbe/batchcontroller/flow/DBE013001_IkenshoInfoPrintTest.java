/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.batchcontroller.flow;

import jp.co.ndensan.reams.db.dbe.definition.batchprm.DBE013001.DBE013001_IkenshoInfoPrintParameter;
import jp.co.ndensan.reams.db.dbz.testhelper.DbeTestBase;
import jp.co.ndensan.reams.uz.uza.batch.BatchExitStatus;
import jp.co.ndensan.reams.uz.uza.biz.ReamsDonyuDantaiCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.core._ControlData;
import jp.co.ndensan.reams.uz.uza.core._ControlDataHolder;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
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
 * {@link DBE013001_IkenshoInfoPrint}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class DBE013001_IkenshoInfoPrintTest extends DbeTestBase {

    private static BatchFlowTestHelper flowHelper;

    public static class バッチフローテスト extends DbeTestBase {

        @Before
        public void setUp() {
            flowHelper = new BatchFlowTestHelper();
//            FdaTestBase.setUpClassInternal();
        }

        @Test
        public void パラメーターが正しく設定されている場合_バッチフロー実施結果は_Successで返すこと() throws Exception {
            setExecutionSubGyomuCodeToControlData(SubGyomuCode.DBE認定支援);
            BatchExitStatus result = flowHelper.executeFlow(
                    new RString("DBE013001_IkenshoInfoPrint"),
                    new RString("意見書情報印刷発行"),
                    DBE013001_IkenshoInfoPrint.class,
                    createBatchParameter());
            assertThat(result.getStatus(), is(BatchExitStatus.Status.SUCCESS));
        }

    }

    private static DBE013001_IkenshoInfoPrintParameter createBatchParameter() {
        DBE013001_IkenshoInfoPrintParameter parameter = new DBE013001_IkenshoInfoPrintParameter();
        parameter.set主治医意見書作成依頼変更者一覧表フラグ(true);
        parameter.set主治医意見書作成依頼変更者一覧表申請日From(new FlexibleDate(2016, 12, 1));
        parameter.set主治医意見書作成依頼変更者一覧表申請日To(new FlexibleDate(2016, 12, 31));
        parameter.set主治医意見書作成料請求一覧表フラグ(true);
        parameter.set主治医意見書作成料請求一覧表作成条件(new RString("1"));
        parameter.set主治医意見書作成料請求一覧表処理日From(new FlexibleDate(2016, 12, 1));
        parameter.set主治医意見書作成料請求一覧表処理日To(new FlexibleDate(2016, 12, 31));
        parameter.set主治医意見書依頼未処理者一覧表フラグ(true);
        parameter.set主治医意見書依頼未処理者一覧表申請日From(new FlexibleDate(2016, 12, 1));
        parameter.set主治医意見書依頼未処理者一覧表申請日To(new FlexibleDate(2016, 12, 31));
        parameter.set主治医意見書依頼済み一覧表フラグ(true);
        parameter.set主治医意見書依頼済み一覧表申請日From(new FlexibleDate(2016, 12, 1));
        parameter.set主治医意見書依頼済み一覧表申請日To(new FlexibleDate(2016, 12, 31));
        parameter.set主治医意見書未提出者一覧フラグ(true);
        parameter.set主治医意見書未提出者一覧申請日From(new FlexibleDate(2016, 12, 1));
        parameter.set主治医意見書未提出者一覧申請日To(new FlexibleDate(2016, 12, 31));
        parameter.set主治医意見書５項目確認一覧表フラグ(true);
        parameter.set主治医意見書５項目確認一覧表作成条件(new RString("2"));
        parameter.set主治医意見書５項目確認一覧表審査会(new RString("111111"));

        return parameter;
    }

    private static void setExecutionSubGyomuCodeToControlData(SubGyomuCode executionSubGyomuCode) {
        _ControlData controlData = new _ControlData(SubGyomuCode.DBE認定支援.toString(), "test",
                new ReamsDonyuDantaiCode("209007"));
        FlowContext flowContext = createFlowContext("testFlowInstanceId", "DBEWF11005");
//        FlowContext flowContext = createFlowContext("testFlowInstanceId", "DBEWF51004");
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
