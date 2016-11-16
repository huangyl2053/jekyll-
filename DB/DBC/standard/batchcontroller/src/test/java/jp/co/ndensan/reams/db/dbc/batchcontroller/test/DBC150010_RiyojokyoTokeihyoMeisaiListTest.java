package jp.co.ndensan.reams.db.dbc.batchcontroller.test;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.HashMap;
import java.util.Map;
import jp.co.ndensan.reams.db.dbc.batchcontroller.flow.DBC150010_RiyojokyoTokeihyoMeisaiList;
import jp.co.ndensan.reams.db.dbc.definition.batchprm.DBC150010.DBC150010_RiyojokyoTokeihyoMeisaiListParameter;
import jp.co.ndensan.reams.db.dbz.testhelper.DbcTestBase;
import jp.co.ndensan.reams.uz.uza.batch.BatchExitStatus;
import jp.co.ndensan.reams.uz.uza.batch.batchexecutor.util._BatchInformation;
import jp.co.ndensan.reams.uz.uza.batch.batchexecutor.util._JobContext;
import jp.co.ndensan.reams.uz.uza.batch.batchexecutor.util._JobContextHolder;
import jp.co.ndensan.reams.uz.uza.batch.config._BatchSettingKey;
import jp.co.ndensan.reams.uz.uza.batch.config._BatchSettings;
import jp.co.ndensan.reams.uz.uza.biz.ReamsDonyuDantaiCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.core._ControlData;
import jp.co.ndensan.reams.uz.uza.core._ControlDataHolder;
import jp.co.ndensan.reams.uz.uza.io.Path;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RTime;
import jp.co.ndensan.reams.uz.uza.lang.RYearMonth;
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
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * 償還払い支給（不支給）決定通知書一括作成のテストクラスです。
 */
@RunWith(Enclosed.class)
public class DBC150010_RiyojokyoTokeihyoMeisaiListTest extends DbcTestBase {

    private static BatchFlowTestHelper flowHelper;
    private static final RString 抽出モード = new RString("1");
    private static final RDate 決定日付From = new RDate("20120101");
    private static final RDate 決定日付To = new RDate("20170101");
    private static final RDate 受付日付From = new RDate("20110101");
    private static final RDate 受付日付To = new RDate("20180101");
    private static final RYearMonth 決定者受付年月 = new RYearMonth("201502");
    private static final RString 印書 = new RString("1");
    private static final RDate 発行日 = null;//RDate.getNowDate();
    private static final RString 文書番号 = new RString("1201201");
    private static final RString テスト出力フラグ = new RString("1");
    private static final RString 決定日一括更新区分 = new RString("0");
    private static final RDate 決定日 = RDate.getNowDate();
    private static final RString 利用者向け決定通知書フラグ = new RString("0");
    private static final RString 受領委任者向け決定通知書フラグ = new RString("0");
    private static final RDate 振込予定日 = RDate.getNowDate();
    private static final RString 支払場所 = new RString("支払場所");
    private static final RDate 支払期間From = new RDate("20140101");
    private static final RDate 支払期間To = new RDate("20160101");
    private static final RTime 開始時間 = RTime.of(0, 0, 0);
    private static final RTime 終了時間 = RTime.of(23, 59, 0);
    private static final RString 出力順ID = new RString("2");

    @BeforeClass
    public static void setUpClass() {
    }

    public static class バッチフローテスト extends DbcTestBase {

        @Before
        public void setUp() {
            flowHelper = new BatchFlowTestHelper();
        }

        @Test
        public void バッチデータPrint() throws Exception {
            setExecutionSubGyomuCodeToControlData(SubGyomuCode.DBC介護給付);
            BatchExitStatus result = flowHelper.executeFlow(new RString("DBC150010_RiyojokyoTokeihyoMeisaiList"),
                    new RString("利用状況統計表（明細リスト）作成"),
                    DBC150010_RiyojokyoTokeihyoMeisaiList.class, createParamter());
            assertThat(result.getStatus(), is(BatchExitStatus.Status.SUCCESS));
        }
    }

    private static final DBC150010_RiyojokyoTokeihyoMeisaiListParameter createParamter() {

        DBC150010_RiyojokyoTokeihyoMeisaiListParameter pram = new DBC150010_RiyojokyoTokeihyoMeisaiListParameter();
        pram.set事業者番号(new RString("1270100181"));
        // pram.set出力順ID(2L);//20160812
        pram.set出力順ID(1L);
        pram.set利用実績区分(new RString("1"));
        pram.set地区指定(new RString("1"));
        pram.set対象年月(new RString("1"));
        pram.set導入形態コード(new RString("111"));
        pram.set居宅利用率指定(new RString("2"));
        pram.set市町村コード(new RString("209007"));
        pram.set市町村名称(new RString("xxx"));
        pram.set日付スラッシュ編集(new RString("1"));
        pram.set旧市町村コード(new RString("209006"));
        pram.set旧市町村名称(new RString("yyy"));
        pram.set明細CSV出力区分(new RString("1"));
        pram.set明細リスト出力区分(new RString("1"));
        pram.set明細合計出力区分(new RString("1"));
        pram.set終了居宅利用率(new RString("1"));
        pram.set終了年月(new RString("201612"));
        pram.set終了訪問居宅利用率(new RString("1"));
        pram.set統計表出力区分(new RString("1"));

        pram.set被保険者番号(new RString("0000001"));
        pram.set訪問利用率指定(new RString("1"));
        pram.set連番付加(new RString("1"));
        Map<RString, RString> list = new HashMap<>();
        list.put(new RString("1"), new RString("地区1"));
        list.put(new RString("2"), new RString("地区2"));
        pram.set選択地区リスト(list);
        pram.set開始居宅利用率(new RString("1"));

        pram.set開始年月(new RString("201202"));
        pram.set開始訪問居宅利用率(new RString("1"));
        pram.set項目名付加(new RString("1"));
        return pram;
    }

    private static final void setExecutionSubGyomuCodeToControlData(SubGyomuCode executionSubGyomuCode) {
        _ControlData controlData = new _ControlData(SubGyomuCode.DBC介護給付.toString(), "test",
                new ReamsDonyuDantaiCode("209007"));
        FlowContext flowContext = createFlowContext("testFlowInstanceId", "testFlowId");
        when(flowContext.getExecutionSubGyomuCode()).thenReturn(executionSubGyomuCode);
        controlData.setFlowContext(flowContext);
        _JobContext context = mock(_JobContext.class);
        when(context.getExecutedBatchInformation()).thenReturn(mock(_BatchInformation.class));
        _BatchSettings batchSettings = new _BatchSettings();
        batchSettings.set(_BatchSettingKey.バッチ_ジャーナル出力ディレクトリ, Path.getTmpDirectoryPath());
        when(context.getSettings()).thenReturn(batchSettings);
        _JobContextHolder.setJobContext(context);
        _ControlDataHolder.setControlData(controlData);
    }

    private static final FlowContext createFlowContext(String flowInstanceId, String flowId) {
        FlowContext flowContext = Mockito.mock(FlowContext.class);
        Mockito.when(flowContext.getFlowInstanceId()).thenReturn(new FlowInstanceId(flowInstanceId));
        Mockito.when(flowContext.getFlowId()).thenReturn(new FlowId(flowId));
        return flowContext;

    }
}
