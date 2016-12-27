/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.batchcontroller.flow;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.batchprm.DBE601001.DBE601001_IkenshoSakuseiJIssekiParameter;
import jp.co.ndensan.reams.db.dbe.definition.core.ikenshojissekiichiran.IkenshoJissekiIchiranKey;
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
public class DBE601001_IkenshoSakuseiJIssekiTest extends DbeTestDacBase {

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
    @PrepareForTest({DBE601001_IkenshoSakuseiJIsseki.class})
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
                    new RString("DBE601001_IkenshoSakuseiJIsseki"),
                    new RString("chosahyojissekiichiran"),
                    DBE601001_IkenshoSakuseiJIsseki.class,
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

        private static DBE601001_IkenshoSakuseiJIssekiParameter createParameter() {
            DBE601001_IkenshoSakuseiJIssekiParameter parameter = new DBE601001_IkenshoSakuseiJIssekiParameter();
            List<IkenshoJissekiIchiranKey> keyJoho = new ArrayList<>();
            IkenshoJissekiIchiranKey key = new IkenshoJissekiIchiranKey();
            key.setIkenshoIraiRirekiNo(1);
            key.setShinseishoKanriNo(new RString("20602920110100044"));
            key.setShujiiCode(new RString("00000002"));
            key.setShujiiIryoKikanCode(new RString("0000000008"));
            keyJoho.add(key);

            parameter.setIkenshoKijunbiFrom(RString.EMPTY);
            parameter.setIkenshoKijunbiTo(RString.EMPTY);
            parameter.setIkenshoKijunbiKubun(new RString("3"));
            parameter.setHokensya(new RString("206024"));
            parameter.setKeyJoho(keyJoho);
            parameter.setShokisaiHokensya(new RString("206029"));
            parameter.setSyohyoSyuturyoku(new RString("2"));

            return parameter;
        }

        private static void setExecutionSubGyomuCodeToControlData(SubGyomuCode executionSubGyomuCode) {
            _ControlData controlData = new _ControlData(executionSubGyomuCode.toString(), "test", new ReamsDonyuDantaiCode("209007"));
            FlowContext flowContext = createFlowContext("testFlowInstanceId", "DBE518002");
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
