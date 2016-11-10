///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
package jp.co.ndensan.reams.db.dbu.batchcontroller.flow;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbu.definition.batchprm.DBU010020.DBU010020_JigyoHokokuGeppo_IppanParameter;
import jp.co.ndensan.reams.db.dbu.definition.core.jigyohokoku.PrintControlKubun;
import jp.co.ndensan.reams.db.dbz.testhelper.DbuTestDacBase;
import jp.co.ndensan.reams.uz.uza.batch.BatchExitStatus;
import jp.co.ndensan.reams.uz.uza.batch.batchexecutor.util._BatchInformation;
import jp.co.ndensan.reams.uz.uza.batch.batchexecutor.util._JobContext;
import jp.co.ndensan.reams.uz.uza.batch.batchexecutor.util._JobContextHolder;
import jp.co.ndensan.reams.uz.uza.batch.config._BatchSettingKey;
import jp.co.ndensan.reams.uz.uza.batch.config._BatchSettings;
import jp.co.ndensan.reams.uz.uza.biz.ReamsDonyuDantaiCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.core._ControlData;
import jp.co.ndensan.reams.uz.uza.core._ControlDataHolder;
import jp.co.ndensan.reams.uz.uza.io.Path;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.testhelper.BatchFlowTestHelper;
import jp.co.ndensan.reams.uz.uza.workflow.context.FlowContext;
import jp.co.ndensan.reams.uz.uza.workflow.flow.valueobject.FlowId;
import jp.co.ndensan.reams.uz.uza.workflow.flow.valueobject.FlowInstanceId;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
//
///**
// *
// * @author soft863
// */

@RunWith(Enclosed.class)
public class DBU010020_JigyoHokokuGeppo_IppanTest extends DbuTestDacBase {

    private static BatchFlowTestHelper batchFlowTestHelper;
    private static DBU010020_JigyoHokokuGeppo_IppanParameter parameter;

    @BeforeClass
    public static void setUp() {
        batchFlowTestHelper = new BatchFlowTestHelper();
    }

    public static class テスト {

        @Test
        public void testSinsakaiHanteiJyokyoProcess() {
            setExecutionSubGyomuCodeToControlData(SubGyomuCode.DBU介護統計報告);
            parameter = new DBU010020_JigyoHokokuGeppo_IppanParameter();
            //プリントコントロール区分
            parameter.setPrintControlKbn(PrintControlKubun.集計のみ.getコード());
//            parameter.setPrintControlKbn(PrintControlKubun.集計後印刷.getコード());
//            parameter.setPrintControlKbn(PrintControlKubun.過去分の印刷.getコード());
            //報告年月
            parameter.setHokokuYM(new FlexibleYearMonth("201607"));
            //集計年月
            parameter.setSyukeiYM(new FlexibleYearMonth("201606"));
            //年度
            parameter.setNendo(new FlexibleYear("2016"));
            //作成日付
            parameter.setSakuseiYMD(new RString("20160801100000"));
            //処理日時
            parameter.setSyoriYMDHMS(new YMDHMS("20160801100000"));
            //旧市町村区分
            parameter.setKyuShichosonKbn(new RString("1"));
            //旧市町村コードリスト
            List<RString> 旧市町村コードリスト = new ArrayList<>();
            旧市町村コードリスト.add(new RString("209008"));
            旧市町村コードリスト.add(new RString("154644"));
            parameter.setKyuShichosonList(旧市町村コードリスト);

            //作成CSVファイルID
//            parameter.setSakuseiCSVFileID(new RString("DBU010301"));
            //市町村コード
            parameter.setShichosonCode(new RString("209007"));
            //構成市町村区分
            parameter.setKoseiShichosonKbn(new RString("0"));
            //構成市町村コードリスト
            List<RString> 構成市町村コードリスト = new ArrayList<>();
//            構成市町村コードリスト.add(new RString("209007"));
//            構成市町村コードリスト.add(new RString("000004"));
//            構成市町村コードリスト.add(new RString("000005"));
            parameter.setKoseiShichosonList(構成市町村コードリスト);

            //過去集計分旧市町村区分
            parameter.setKakoShukeiKyuShichosonKbn(new RString("1"));
            //過去集計分市町村コードリスト
            List<RString> 過去集計分市町村コードリスト = new ArrayList<>();
            過去集計分市町村コードリスト.add(new RString("209008"));
            過去集計分市町村コードリスト.add(new RString("154644"));
            parameter.setKakoShukeiShichosonList(過去集計分市町村コードリスト);
            //出力CSVファイルPath
            parameter.setCsvFilePath(new RString("C:\\Users\\soft863\\tmp"));
            parameter.setBatchID(new RString("DBU010020_JigyoHokokuGeppo_Ippan"));
            BatchExitStatus a = batchFlowTestHelper.executeFlow(new RString("DBU010020_JigyoHokokuGeppo_Ippan"),
                    new RString("事業報告月報_一般状況"), DBU010020_JigyoHokokuGeppo_Ippan.class, parameter);
            assertThat(a.getStatus(), is(BatchExitStatus.Status.SUCCESS));
        }
    }

    private static void setExecutionSubGyomuCodeToControlData(SubGyomuCode executionSubGyomuCode) {
        _ControlData controlData = new _ControlData(SubGyomuCode.DBU介護統計報告.toString(), "test",
                new ReamsDonyuDantaiCode("209007"));
        FlowContext flowContext = createFlowContext("test", "test");
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

    private static FlowContext createFlowContext(String flowInstanceId, String flowId) {
        FlowContext flowContext = Mockito.mock(FlowContext.class);
        Mockito.when(flowContext.getFlowInstanceId()).thenReturn(new FlowInstanceId(flowInstanceId));
        Mockito.when(flowContext.getFlowId()).thenReturn(new FlowId(flowId));
        return flowContext;
    }
}
