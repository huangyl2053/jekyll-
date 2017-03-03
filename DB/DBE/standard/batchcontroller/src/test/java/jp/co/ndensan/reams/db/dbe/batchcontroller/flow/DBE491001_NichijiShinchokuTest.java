/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.batchcontroller.flow;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.batchprm.DBE491001.DBE491001_NichijiShinchokuParameter;
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
import org.junit.AfterClass;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import static org.mockito.Mockito.when;
import org.powermock.core.classloader.annotations.PrepareForTest;

/**
 *
 * @author
 */
@RunWith(Enclosed.class)
public class DBE491001_NichijiShinchokuTest extends DbeTestDacBase {

    private static BatchFlowTestHelper flowHelper;

    /**
     * BeforeClass
     */
    @BeforeClass
    public static void beforeSetUpClass() {
        DbeTestDacBase.beforeSetUpClass();
    }

    /**
     * PrepareForTest
     */
    @PrepareForTest({DBE518002_NinteiShinsaIraiIfTorikomi.class})
    public static class バッチフローテスト extends DbeTestDacBase {

        /**
         * flowHelperを作成
         */
        @Before
        public void setUp() {
            flowHelper = new BatchFlowTestHelper();
        }

        /**
         * パラメーターが正しく設定されている場合_バッチフロー実施結果は_Successで返すこと
         *
         * @throws Exception Exception
         */
        @Test
        public void パラメーターが正しく設定されている場合_バッチフロー実施結果は_Successで返すこと() throws Exception {
            setExecutionSubGyomuCodeToControlData(SubGyomuCode.DBE認定支援);
            BatchExitStatus result = flowHelper.executeFlow(
                    new RString("DBE491001_NichijiShinchoku"),
                    new RString("対象者自動割付"),
                    DBE491001_NichijiShinchoku.class,
                    createParameter());
            assertThat(result.getStatus(), is(BatchExitStatus.Status.SUCCESS));
        }

        /**
         * AfterClass
         */
        @AfterClass
        public static void aterTearDownClass() {
            DbeTestDacBase.afterTearDownClass();
        }

        private static DBE491001_NichijiShinchokuParameter createParameter() {
            DBE491001_NichijiShinchokuParameter parameter = new DBE491001_NichijiShinchokuParameter();
            parameter.setFayirukuben(new RString("0"));
            parameter.setChushutsuFromDate(new RString("20161001"));
            parameter.setChushutsuToDate(new RString("20170303"));
            parameter.setDataShutsuryokuUmu(new RString("1"));

            List<RString> 申請書管理番号リスト = new ArrayList<>();
            申請書管理番号リスト.add(new RString("20602420170100055"));
            申請書管理番号リスト.add(new RString("20602420161200000"));
            申請書管理番号リスト.add(new RString("20211920160800229"));

            parameter.setShinseishoKanriNoList(申請書管理番号リスト);
            return parameter;
        }

        private static void setExecutionSubGyomuCodeToControlData(SubGyomuCode executionSubGyomuCode) {
            _ControlData controlData = new _ControlData(executionSubGyomuCode.toString(), "test", new ReamsDonyuDantaiCode("209007"));
            FlowContext flowContext = createFlowContext("testFlowInstanceId", "DBEWF71003");
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
}
