/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.batchcontroller.flow;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbd.definition.batchprm.DBD205010.DBD205010_FutanGendoGakuNinteishaListParameter;
import jp.co.ndensan.reams.db.dbd.definition.batchprm.common.KyusochishaJukyushaKubun;
import jp.co.ndensan.reams.db.dbd.definition.batchprm.gemmen.niteishalist.SetaiHyoji;
import jp.co.ndensan.reams.db.dbd.definition.batchprm.gemmen.niteishalist.TaishoKikan;
import jp.co.ndensan.reams.db.dbd.definition.batchprm.gemmen.niteishalist.TargetList;
import jp.co.ndensan.reams.db.dbz.definition.batchprm.gemmen.niteishalist.CSVSettings;
import jp.co.ndensan.reams.uz.uza.batch.BatchExitStatus;
import jp.co.ndensan.reams.uz.uza.batch.batchexecutor.util.ExecuteType;
import jp.co.ndensan.reams.uz.uza.batch.batchexecutor.util._BatchInformation;
import jp.co.ndensan.reams.uz.uza.batch.batchexecutor.util._JobContext;
import jp.co.ndensan.reams.uz.uza.batch.batchexecutor.util._JobContextHolder;
import jp.co.ndensan.reams.uz.uza.batch.config.BatchSettings;
import jp.co.ndensan.reams.uz.uza.biz.ReamsDonyuDantaiCode;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.core._ControlData;
import jp.co.ndensan.reams.uz.uza.core._ControlDataHolder;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.testhelper.BatchFlowTestHelper;
import jp.co.ndensan.reams.uz.uza.workflow.context.FlowContext;
import jp.co.ndensan.reams.uz.uza.workflow.flow.valueobject.FlowId;
import jp.co.ndensan.reams.uz.uza.workflow.flow.valueobject.FlowInstanceId;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mockito;
import static org.mockito.Mockito.when;

/**
 *
 * @author x_liuwei
 */
public class DBD205010_FutanGendoGakuNinteishaListTest {

    private static BatchFlowTestHelper flowHelper;

    @BeforeClass
    public static void setUp() {
        flowHelper = new BatchFlowTestHelper();
        BatchSettings settings = new BatchSettings();
        _JobContextHolder.setJobContext(new _JobContext(1, settings.getBatchSettings(), ExecuteType.TEST));
        _JobContextHolder.getJobContext().addExecutedBatchInformation(new _BatchInformation(new RString("TEST"), new RString("TEST"), null));
    }

    /**
     * Test of defineFlow method, of class DBD205010_FutanGendoGakuNinteishaList.
     */
    @Test
    public void testDefineFlow() {
        DBD205010_FutanGendoGakuNinteishaListParameter parameter = new DBD205010_FutanGendoGakuNinteishaListParameter();
        setparameter2(parameter);

        setExecutionSubGyomuCodeToControlData(SubGyomuCode.DBD介護受給);
        BatchExitStatus a = flowHelper.executeFlow(
                new RString("DBD205010_FutanGendoGakuNinteishaList"),
                new RString("負担限度額認定者リスト"),
                DBD205010_FutanGendoGakuNinteishaList.class, parameter);
        assertThat(a.getStatus(), is(BatchExitStatus.Status.SUCCESS));

    }

    private static void setExecutionSubGyomuCodeToControlData(SubGyomuCode executionSubGyomuCode) {
        _ControlData controlData = new _ControlData(SubGyomuCode.DBD介護受給.toString(), "test", new ReamsDonyuDantaiCode("209007"));
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

    private void setparameter1(DBD205010_FutanGendoGakuNinteishaListParameter parameter) {
        parameter.set世帯表示(SetaiHyoji.表示する);
        parameter.set基準日(new FlexibleDate("20161018"));
        parameter.set課税判定等基準日(new FlexibleDate("20161018"));
        parameter.set対象リスト(TargetList.認定者リスト);
        parameter.set帳票ID(new ReportId("DBD200016_FutanGendogakuNinteishaIchiran"));
        parameter.set所得年度(new FlexibleYear("2016"));
//        parameter.set対象年度の開始年月日(new FlexibleDate("20160801"));
//        parameter.set対象年度の終了年月日(new FlexibleDate("20170731"));
        parameter.set対象期間指定(TaishoKikan.基準日);
        parameter.set改頁出力順ID(new Long(1));
        parameter.set旧措置区分(KyusochishaJukyushaKubun.両方);
        List<CSVSettings> list = new ArrayList<>();
        list.add(CSVSettings.連番付加);
        parameter.setCsv出力設定(list);
    }

    private void setparameter2(DBD205010_FutanGendoGakuNinteishaListParameter parameter) {
        parameter.set世帯表示(SetaiHyoji.表示する);
        parameter.set基準日(new FlexibleDate("20161018"));
        parameter.set課税判定等基準日(new FlexibleDate("20161018"));
        parameter.set対象リスト(TargetList.認定者リスト);
        parameter.set帳票ID(new ReportId("DBD200016_FutanGendogakuNinteishaIchiran"));
        parameter.set所得年度(new FlexibleYear("2016"));
        parameter.set対象年度の開始年月日(new FlexibleDate("20160801"));
        parameter.set対象年度の終了年月日(new FlexibleDate("20170731"));
        parameter.set対象期間指定(TaishoKikan.対象年度);
        parameter.set改頁出力順ID(new Long(1));
        parameter.set旧措置区分(KyusochishaJukyushaKubun.両方);
        List<CSVSettings> list = new ArrayList<>();
        list.add(CSVSettings.連番付加);
        parameter.setCsv出力設定(list);
    }
}
