/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.flow.dbc180010;

import jp.co.ndensan.reams.db.dbc.definition.batchprm.nenjiriyoshafutanwariaihantei.NenjiRiyoshaFutanwariaiHanteiParameter;
import jp.co.ndensan.reams.db.dbc.definition.core.saishori.SaiShoriKubun;
import jp.co.ndensan.reams.db.dbz.testhelper.DbcTestDacBase;
import jp.co.ndensan.reams.uz.uza.batch.BatchExitStatus;
import jp.co.ndensan.reams.uz.uza.batch.batchexecutor.util.ExecuteType;
import jp.co.ndensan.reams.uz.uza.batch.batchexecutor.util._JobContext;
import jp.co.ndensan.reams.uz.uza.batch.batchexecutor.util._JobContextHolder;
import jp.co.ndensan.reams.uz.uza.batch.config._BatchSettings;
import jp.co.ndensan.reams.uz.uza.biz.ReamsDonyuDantaiCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.core._ControlData;
import jp.co.ndensan.reams.uz.uza.core._ControlDataHolder;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
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
import org.mockito.Mockito;
import static org.mockito.Mockito.when;

/**
 *
 * @author LDNS 袁震霞
 */
public class DBC180010_NenjiRiyoshaFutanwariaiHanteiTest extends DbcTestDacBase {

    @Before
    public void test() {
        //sqlSession.getConfiguration().addMapper(IKaigoFukaTokuchoHeijunka6BatchMapper.class);
        setExecutionSubGyomuCodeToControlData(SubGyomuCode.DBB介護賦課);
    }

    @Test
    public void 特別徴収平準化計算_バッチ() {
        NenjiRiyoshaFutanwariaiHanteiParameter parameter = setParameter();
        BatchFlowTestHelper batchFlowTest = new BatchFlowTestHelper();
        BatchExitStatus result = batchFlowTest.executeFlow(RString.EMPTY, RString.EMPTY, DBC180010_NenjiRiyoshaFutanwariaiHantei.class, parameter);
        //BatchExitStatus result = batchFlowTest.executeFlow(RString.EMPTY, RString.EMPTY, FutanWariaiIchiranFlow.class, parameter);
        assertThat(result.getStatus(), is(BatchExitStatus.Status.SUCCESS));
    }

    private NenjiRiyoshaFutanwariaiHanteiParameter setParameter() {
        NenjiRiyoshaFutanwariaiHanteiParameter parameter = new NenjiRiyoshaFutanwariaiHanteiParameter();
        parameter.set処理区分(SaiShoriKubun.再処理);
        parameter.set対象年度(new FlexibleYear("2008"));
        parameter.set基準日(new FlexibleDate("20080808"));
        parameter.set処理日時(RDateTime.now());

        return parameter;
    }
//    private FutanWariaiIchiranBatchParameter setParameter() {
//        FutanWariaiIchiranBatchParameter parameter = new FutanWariaiIchiranBatchParameter();
//        parameter.set処理区分(new RString("2"));
//        parameter.set対象年度(new FlexibleYear("2008"));
//        parameter.set基準日(new FlexibleDate("20080808"));
//        parameter.set処理日時(RDateTime.now());
//
//        return parameter;
//    }

    private static void setExecutionSubGyomuCodeToControlData(SubGyomuCode executionSubGyomuCode) {
        _ControlData controlData = new _ControlData(SubGyomuCode.DBC介護給付.toString(), "test", new ReamsDonyuDantaiCode("209007"));
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
