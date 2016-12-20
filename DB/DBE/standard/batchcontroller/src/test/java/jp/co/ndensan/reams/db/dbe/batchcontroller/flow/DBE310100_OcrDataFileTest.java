/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.batchcontroller.flow;

//import jp.co.ndensan.reams.db.dbe.definition.batchprm.DBE250001.OcrDataFileParameter;
import jp.co.ndensan.reams.db.dbz.testhelper.DbeTestDacBase;
import jp.co.ndensan.reams.uz.uza.biz.ReamsDonyuDantaiCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.core._ControlData;
import jp.co.ndensan.reams.uz.uza.core._ControlDataHolder;
import jp.co.ndensan.reams.uz.uza.testhelper.BatchFlowTestHelper;
import jp.co.ndensan.reams.uz.uza.workflow.context.FlowContext;
import jp.co.ndensan.reams.uz.uza.workflow.flow.valueobject.FlowId;
import jp.co.ndensan.reams.uz.uza.workflow.flow.valueobject.FlowInstanceId;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mockito;
import static org.mockito.Mockito.when;

/**
 *
 * @author n8429
 */
public class DBE310100_OcrDataFileTest extends DbeTestDacBase {

    private static BatchFlowTestHelper flowHelper;

    public DBE310100_OcrDataFileTest() {
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

//        setExecutionSubGyomuCodeToControlData(SubGyomuCode.DBE認定支援);
//        BatchExitStatus result = flowHelper.executeFlow(new RString("DBE310100_OcrDataFile"),
//                new RString("認定支援"),
//                DBE250001_NinteiChoshaKekkaTorikomi.class,
//                createParameter());
//        assertThat(result.getStatus(), is(BatchExitStatus.Status.SUCCESS));
    }

//    private static OcrDataFileParameter createParameter() {
//        OcrDataFileParameter batchFlowParameter = new OcrDataFileParameter();
//        RString path = new RString("db|EucOther_DBA701002_186|2016-12-12 16:47:59.649232");
//        batchFlowParameter.set共有ファイルエントリ情報文字列(path);
//
//        return batchFlowParameter;
//    }

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
