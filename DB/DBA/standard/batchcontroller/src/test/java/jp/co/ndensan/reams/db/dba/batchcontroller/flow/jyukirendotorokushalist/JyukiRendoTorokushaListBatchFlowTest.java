/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.batchcontroller.flow.jyukirendotorokushalist;

import java.util.Arrays;
import jp.co.ndensan.reams.db.dba.definition.batchprm.jyukirendotorokushalistbatch.JyukiRendoTorokushaListBatchParameter;
import jp.co.ndensan.reams.db.dbz.testhelper.DbaTestDacBase;
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
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import static org.mockito.Mockito.when;

/**
 * 住基連動登録者リストクラステスト
 */
@RunWith(Enclosed.class)
public class JyukiRendoTorokushaListBatchFlowTest extends DbaTestDacBase {

    private static BatchFlowTestHelper flowHelper;
    private static final String[] CODE_SHUBETSU_0008 = {"01", "08", "99"};

    @BeforeClass
    public static void setUpClass() {
    }

    public static class バッチフローテスト extends DbaTestDacBase {

        @Before
        public void setUp() {
            flowHelper = new BatchFlowTestHelper();
        }

        @Test
        public void バッチデータPrint() throws Exception {

            setExecutionSubGyomuCodeToControlData(SubGyomuCode.DBA介護資格);
            if (Arrays.asList(CODE_SHUBETSU_0008).contains("01")) {
                BatchExitStatus result = flowHelper.executeFlow(new RString("JyukiRendoTorokushaListBatchFlow"),
                        new RString("住基連動登録者リスト"),
                        JyukiRendoTorokushaListBatchFlow.class, createParamter());
                assertThat(result.getStatus(), is(BatchExitStatus.Status.SUCCESS));
            }

        }
    }

    private static JyukiRendoTorokushaListBatchParameter createParamter() {
        JyukiRendoTorokushaListBatchParameter param = new JyukiRendoTorokushaListBatchParameter();
        param.setZenkaikaishiYMDHMS(new RString("2014-01-31 10:55:55.123"));
        param.setZenkaishuryoYMDHMS(new RString("2014-12-31 10:55:55.123"));
        param.setKonkaikaishiYMDHMS(new RString("2015-01-31 10:55:55.123"));
        param.setKonkaishuryoYMDHMS(new RString("2016-12-31 10:55:55.123"));
        param.setHihokenshadaichoFLG(true);
        param.setTajushochitokureishakanriFLG(true);
        param.setTekiyojogaishadaichoFLG(true);
        param.setShuturyokujunID(RString.EMPTY);
        return param;
    }

    private static void setExecutionSubGyomuCodeToControlData(SubGyomuCode executionSubGyomuCode) {
        _ControlData controlData = new _ControlData(SubGyomuCode.DBA介護資格.toString(), "test_xuyannan",
                new ReamsDonyuDantaiCode("209007"));
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
