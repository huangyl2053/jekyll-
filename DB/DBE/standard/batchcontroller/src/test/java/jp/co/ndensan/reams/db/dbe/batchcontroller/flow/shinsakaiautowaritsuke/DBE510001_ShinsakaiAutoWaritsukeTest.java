/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.batchcontroller.flow.shinsakaiautowaritsuke;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.batchcontroller.flow.DBE510001_ShinsakaiAutoWaritsuke;
import jp.co.ndensan.reams.db.dbe.definition.batchprm.DBE510001.DBE510001_ShinsakaiAutoWaritsukeParameter;
import jp.co.ndensan.reams.db.dbz.testhelper.DbeTestDacBase;
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
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.mockito.Mockito;
import static org.mockito.Mockito.when;

/**
 *
 */
@Ignore //テストデータに依存するため
public class DBE510001_ShinsakaiAutoWaritsukeTest extends DbeTestDacBase {

    private static BatchFlowTestHelper flowHelper;

    @BeforeClass
    public static void setUp() {
        DbeTestDacBase.beforeSetUpClass();
        setExecutionSubGyomuCodeToControlData(SubGyomuCode.DBE認定支援);
        flowHelper = new BatchFlowTestHelper();
    }

    @Test
    public void Test() {
        setExecutionSubGyomuCodeToControlData(SubGyomuCode.DBE認定支援);
        BatchExitStatus result = flowHelper.executeFlow(new RString("DBE510001_ShinsakaiAutoWaritsuke"),
                new RString("対象者自動割付"),
                DBE510001_ShinsakaiAutoWaritsuke.class, createBatchParameter());
        assertThat(result.getStatus(), is(BatchExitStatus.Status.SUCCESS));

    }

    private static DBE510001_ShinsakaiAutoWaritsukeParameter createBatchParameter() {
        List<Integer> shinsakaiJidoWariateTeiin = new ArrayList<>();
        List<RString> shinsakaiKaisaiNo = new ArrayList<>();
        List<FlexibleDate> kaisaiYMD = new ArrayList<>();
        List<Integer> shinsakaiWaritsukeNinsu = new ArrayList<>();
        shinsakaiJidoWariateTeiin.add(10);
        shinsakaiKaisaiNo.add(new RString("20160082"));
        kaisaiYMD.add(new FlexibleDate("20161201"));
        shinsakaiWaritsukeNinsu.add(10);

        DBE510001_ShinsakaiAutoWaritsukeParameter param = new DBE510001_ShinsakaiAutoWaritsukeParameter();
        param.setShinsakaiJidoWariateTeiin(shinsakaiJidoWariateTeiin);
        param.setShinsakaiKaisaiNo(shinsakaiKaisaiNo);
        param.setShinsakaiKaisaiYMD(kaisaiYMD);
        param.setShinsakaiWaritsukeNinsu(shinsakaiWaritsukeNinsu);
        return param;
    }

    private static void setExecutionSubGyomuCodeToControlData(SubGyomuCode executionSubGyomuCode) {
        _ControlData controlData = new _ControlData(executionSubGyomuCode.toString(), "test", new ReamsDonyuDantaiCode("654321"));
        FlowContext flowContext = createFlowContext("testFlowInstanceId", "testFlowId");
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
