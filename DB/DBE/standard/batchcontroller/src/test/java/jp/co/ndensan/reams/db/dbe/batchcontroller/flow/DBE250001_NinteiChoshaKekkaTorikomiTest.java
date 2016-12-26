/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.batchcontroller.flow;

import jp.co.ndensan.reams.db.dbe.definition.batchprm.DBE250001.DBE250001_NinteiChoshaKekkaTorikomiParameter;
import jp.co.ndensan.reams.db.dbz.testhelper.DbeTestDacBase;
import jp.co.ndensan.reams.uz.uza.batch.BatchExitStatus;
import jp.co.ndensan.reams.uz.uza.biz.ReamsDonyuDantaiCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.core._ControlData;
import jp.co.ndensan.reams.uz.uza.core._ControlDataHolder;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.testhelper.BatchFlowTestHelper;
import jp.co.ndensan.reams.uz.uza.workflow.context.FlowContext;
import jp.co.ndensan.reams.uz.uza.workflow.flow.valueobject.FlowId;
import jp.co.ndensan.reams.uz.uza.workflow.flow.valueobject.FlowInstanceId;
import static org.hamcrest.CoreMatchers.is;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;
import org.mockito.Mockito;
import static org.mockito.Mockito.when;

/**
 *
 * @author n8429
 */
//@Ignore
public class DBE250001_NinteiChoshaKekkaTorikomiTest {

    private static BatchFlowTestHelper flowHelper;

    public DBE250001_NinteiChoshaKekkaTorikomiTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
        DbeTestDacBase.afterTearDownClass();
    }

    @Before
    public void setUp() {
        flowHelper = new BatchFlowTestHelper();
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of defineFlow method, of class DBE310100_OcrDataFile.
     */
    @Test
    public void testDefineFlow() {

        setExecutionSubGyomuCodeToControlData(SubGyomuCode.DBE認定支援);
        BatchExitStatus result = flowHelper.executeFlow(new RString("DBE250001_NinteiChoshaKekkaTorikomi"),
                new RString("認定支援"),
                DBE250001_NinteiChoshaKekkaTorikomi.class,
                createParameter());
        assertThat(result.getStatus(), is(BatchExitStatus.Status.SUCCESS));
    }

    private static DBE250001_NinteiChoshaKekkaTorikomiParameter createParameter() {
        DBE250001_NinteiChoshaKekkaTorikomiParameter batchFlowParameter = new DBE250001_NinteiChoshaKekkaTorikomiParameter();
        RString path = new RString("db|EucOther_DBA701002_186|2016-12-12 16:47:59.649232");
        batchFlowParameter.set共有ファイルエントリ情報文字列(path);

        return batchFlowParameter;
    }

    private static void setExecutionSubGyomuCodeToControlData(SubGyomuCode executionSubGyomuCode) {
        _ControlData controlData = new _ControlData(executionSubGyomuCode.toString(), "KanriUser1", new ReamsDonyuDantaiCode("209007"));
        FlowContext flowContext = createFlowContext("flowInstanceId", "DBE250001");
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
