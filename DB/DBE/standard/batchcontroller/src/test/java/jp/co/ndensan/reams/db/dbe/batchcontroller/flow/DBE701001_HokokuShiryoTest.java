/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.batchcontroller.flow;

import java.util.Arrays;
import jp.co.ndensan.reams.db.dbe.definition.batchprm.DBE701001.DBE701001_HokokuShiryoParameter;
import jp.co.ndensan.reams.db.dbz.testhelper.DbeTestDacBase;
import jp.co.ndensan.reams.uz.uza.batch.BatchExitStatus;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ReamsDonyuDantaiCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.core._ControlData;
import jp.co.ndensan.reams.uz.uza.core._ControlDataHolder;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
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
 * 報告資料作成のバッチフローのテストクラスです。
 */
@RunWith(Enclosed.class)
public class DBE701001_HokokuShiryoTest extends DbeTestDacBase {

    private static BatchFlowTestHelper flowHelper;

    public static class バッチフローテスト extends DbeTestDacBase {

        @Before
        public void setUp() {
            flowHelper = new BatchFlowTestHelper();
        }

        @Test
        public void パラメーターが正しく設定されている場合_バッチフロー実施結果は_Successで返すこと() throws Exception {
            setExecutionSubGyomuCodeToControlData(SubGyomuCode.DBE認定支援);
            BatchExitStatus result = flowHelper.executeFlow(
                    new RString("DBE701001_HokokuShiryo"),
                    new RString("報告資料作成"),
                    DBE701001_HokokuShiryo.class,
                    createBatchParameter());
            assertThat(result.getStatus(), is(BatchExitStatus.Status.SUCCESS));
        }
    }

    private static DBE701001_HokokuShiryoParameter createBatchParameter() {
        DBE701001_HokokuShiryoParameter parameter = new DBE701001_HokokuShiryoParameter();
        parameter.setJigyoJyokyoHokoku(true);
        parameter.setJissiJyokyoTokei(true);
        parameter.setSinsaHanteiJyokyo(true);
        parameter.setSinsaHanteiNoHenkouJokyo(true);
        parameter.setKaigoNinteiSinsakaiShukeihyoHanteibetsu(true);
        parameter.setKaigoNinteiSinsakaiShukeihyoSinseikubunbetsu(true);
        parameter.setKaigoNinteiSinsakaiShukeihyoGenzainojokyobetsu(true);
        parameter.setGogitaiName(new RString("全て"));
        parameter.setGogitaiNo(-1);
        parameter.setGogitaiNoList(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 9, 10, 20, 33, 34, 36, 37, 39, 40, 43, 44, 50, 51, 52, 55, 63, 70, 82, 91, 94));
        parameter.setKijyunYMD(new RDate("20170304"));
        parameter.setTaishoNendoYM(RString.EMPTY);
        parameter.setTaishoGeppiFrom(new RString("20170201"));
        parameter.setTaishoGeppiTo(new RString("20170331"));
        parameter.setTaishoGeppiKubun(true);
        parameter.setShichosonCode(LasdecCode.EMPTY);
        parameter.setShichosonName(RString.EMPTY);
        parameter.setSinseiKubunSinseitoki(true);
        parameter.setSinseiKubunHorei(false);
        parameter.setHiHokensyaKubun(new RString("7"));
        return parameter;
    }

    private static void setExecutionSubGyomuCodeToControlData(SubGyomuCode executionSubGyomuCode) {
        _ControlData controlData = new _ControlData(SubGyomuCode.DBE認定支援.toString(), "test",
                new ReamsDonyuDantaiCode("209007"));
        FlowContext flowContext = createFlowContext("testFlowInstanceId", "DBEWF25001");
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
