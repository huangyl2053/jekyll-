/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.batchcontroller.flow.DBB013001;

import jp.co.ndensan.reams.db.dbb.batchcontroller.flow.DBB013001_TokuchoHeinjunka8Gatsu;
import jp.co.ndensan.reams.db.dbb.definition.batchprm.DBB013001.DBB013001_TokuchoHeinjunka8GatsuParameter;
import jp.co.ndensan.reams.db.dbz.testhelper.DbbTestDacBase;
import jp.co.ndensan.reams.uz.uza.batch.BatchExitStatus;
import jp.co.ndensan.reams.uz.uza.batch.batchexecutor.util.ExecuteType;
import jp.co.ndensan.reams.uz.uza.batch.batchexecutor.util._JobContext;
import jp.co.ndensan.reams.uz.uza.batch.batchexecutor.util._JobContextHolder;
import jp.co.ndensan.reams.uz.uza.batch.config._BatchSettings;
import jp.co.ndensan.reams.uz.uza.biz.ReamsDonyuDantaiCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.core._ControlData;
import jp.co.ndensan.reams.uz.uza.core._ControlDataHolder;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.testhelper.BatchFlowTestHelper;
import jp.co.ndensan.reams.uz.uza.workflow.context.FlowContext;
import jp.co.ndensan.reams.uz.uza.workflow.flow.valueobject.FlowId;
import jp.co.ndensan.reams.uz.uza.workflow.flow.valueobject.FlowInstanceId;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import static org.mockito.Mockito.when;

/**
 *
 */
public class DBB012001_TokuchoHeinjunka6GatsuTest extends DbbTestDacBase {

    @Before
    public void testBefore() {
//        sqlSession.getConfiguration().addMapper(ITokuchoHeinjunka6GatsuBatchMapper.class);
//        sqlSession.getConfiguration().addMapper(IDbT2001ChoshuHohoMapper.class);
//        sqlSession.getConfiguration().addMapper(IKeisangoJohoSakuseiMapper.class);//////
        setExecutionSubGyomuCodeToControlData(SubGyomuCode.DBB介護賦課);
    }

    @Test
    public void test() {
        DBB013001_TokuchoHeinjunka8GatsuParameter parameter = createParameter();
        BatchFlowTestHelper testHelper = new BatchFlowTestHelper();
        BatchExitStatus status = testHelper.executeFlow(RString.EMPTY, RString.EMPTY, DBB013001_TokuchoHeinjunka8Gatsu.class, parameter);
        assertThat(status.getStatus(), is(BatchExitStatus.Status.SUCCESS));
    }

    private DBB013001_TokuchoHeinjunka8GatsuParameter createParameter() {
        DBB013001_TokuchoHeinjunka8GatsuParameter param = new DBB013001_TokuchoHeinjunka8GatsuParameter();
        param.set調定年度(new FlexibleYear("2014"));
        param.set賦課年度(new FlexibleYear("2014"));
        param.set増額平準化方法(new RString("1"));
        param.set減額平準化方法(new RString("2"));
//        ArrayList<OutputChohyoIchiran> 出力帳票一覧 = new ArrayList<>();////
//        OutputChohyoIchiran 出力帳票 = new OutputChohyoIchiran();
//        出力帳票.set出力順ID(new RString("1"));
        param.set出力順ID(new RString("1"));
//        出力帳票一覧.add(出力帳票);
//        param.set出力帳票entity(出力帳票一覧);////
        return param;
    }

    private static void setExecutionSubGyomuCodeToControlData(SubGyomuCode executionSubGyomuCode) {
        _ControlData controlData = new _ControlData(SubGyomuCode.DBB介護賦課.toString(), "test", new ReamsDonyuDantaiCode("209007"));
        long jobId = 2;
        _BatchSettings settings = new _BatchSettings();
        ExecuteType type = ExecuteType.TEST;
        _JobContext jobContext = new _JobContext(jobId, settings, type);
        _JobContextHolder.setJobContext(jobContext);

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
