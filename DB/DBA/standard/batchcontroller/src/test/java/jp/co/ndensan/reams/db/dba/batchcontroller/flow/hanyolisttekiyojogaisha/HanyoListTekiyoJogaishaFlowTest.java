/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.batchcontroller.flow.hanyolisttekiyojogaisha;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dba.definition.batchprm.hanyolist.hihokenshadaicho.HizukeChushutsuKubun;
import jp.co.ndensan.reams.db.dba.definition.batchprm.hanyolist.tekiyojogaisha.HaniChushutsubiKubun;
import jp.co.ndensan.reams.db.dba.definition.batchprm.hanyolist.tekiyojogaisha.JiyuChushutsuKubun;
import jp.co.ndensan.reams.db.dba.definition.batchprm.hanyolist.tekiyojogaisha.KijunbiKubun;
import jp.co.ndensan.reams.db.dba.definition.batchprm.hanyolistseikatsuhogojukyusha.HanyoListBatchParameter;
import jp.co.ndensan.reams.db.dbz.definition.batchprm.hanyolist.atena.NenreiSoChushutsuHoho;
import jp.co.ndensan.reams.db.dbz.definition.core.jogaiidojiyu.JogaiTekiyoJiyu;
import jp.co.ndensan.reams.db.dbz.testhelper.DbaTestDacBase;
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
import jp.co.ndensan.reams.uz.uza.math.Decimal;
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
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 *
 * @author HELIYING
 */
@RunWith(Enclosed.class)
public class HanyoListTekiyoJogaishaFlowTest extends DbaTestDacBase {

    private static BatchFlowTestHelper flowHelper;

    public static class バッチフローテスト extends DbaTestDacBase {

        @Before
        public void setUp() {
            flowHelper = new BatchFlowTestHelper();
        }

        @Test
        public void バッチデータPrint() throws Exception {
            setExecutionSubGyomuCodeToControlData(SubGyomuCode.DBA介護資格);

            HanyoListBatchParameter parameter = new HanyoListBatchParameter();
            parameter.setChohyoId(new RString(""));
            parameter.setShutsuryokujunId(new Long(1));
            parameter.setShutsuryokuKomokuId(new RString(""));
            parameter.setKomokumeiFuka(true);
            parameter.setRenbanFuka(true);
            parameter.setHitsukeHenshu(true);
            parameter.setHitsukeChushutsuKubun(HizukeChushutsuKubun.直近.getコード());
            parameter.setKijunYMD(new RString("20160101"));
            parameter.setChushutsunichiKubun(HaniChushutsubiKubun.適用日.getコード());
            parameter.setChushutsunichiFrom(new RString("20160202"));
            parameter.setChushutsunichiTo(new RString("20160303"));
            parameter.setJukyushaJoho_Nihonjin(true);
            parameter.setJukyushaJoho_Gaikokujin(false);
//            List<RString> list = new ArrayList<>();
//            list.add(new RString("01"));
//            list.add(new RString("02"));
//            list.add(new RString("03"));
//            parameter.setFujoShurui(list);
            parameter.setKijunYMDkubun(KijunbiKubun.適用開始日.getコード());
            parameter.setJyuChusyutsuKubun(JiyuChushutsuKubun.適用除外者のみ.getコード());
            List<RString> 適用事由 = new ArrayList<>();
            適用事由.add(JogaiTekiyoJiyu.除外者適用.getコード());
            適用事由.add(JogaiTekiyoJiyu.職権適用.getコード());
            parameter.setDekyujyu(適用事由);
            List<RString> 解除事由 = new ArrayList<>();
//            解除事由.add(JogaiKaijoJiyu.除外者転出.getコード());
//            解除事由.add(JogaiKaijoJiyu.除外者解除.getコード());
//            解除事由.add(JogaiKaijoJiyu.除外者死亡.getコード());
//            解除事由.add(JogaiKaijoJiyu.職権解除.getコード());
            parameter.setKaijyojyu(解除事由);
            parameter.setShisetsuHenkoari(true);
            parameter.setShisetsuHenkonashi(true);
            // 年齢層抽出方法
            parameter.setPsmChushutsu_Kubun(NenreiSoChushutsuHoho.生年月日範囲.getコード());
            parameter.setPsmChushutsuAge_Start(new Decimal("19"));
            parameter.setPsmChushutsuAge_End(new Decimal("21"));
            parameter.setPsmSeinengappiYMD_Start(new RDate("15000101"));
            parameter.setPsmSeinengappiYMD_End(new RDate("20251230"));
            parameter.setPsmAgeKijunni(new RDate("20160617"));
            parameter.setShichoson_Code(new RString("209007"));
            parameter.setShichoson_Name(new RString("千葉県"));
            parameter.setPsmChiku_Kubun(new RString("1"));
            parameter.setPsmJusho_From(new RString(""));
            parameter.setPsmJusho_From_Name(new RString(""));
            parameter.setPsmJusho_To(new RString(""));
            parameter.setPsmJusho_To_Name(new RString(""));
            parameter.setPsmGyoseiku_From(new RString(""));
            parameter.setPsmGyoseiku_From_Name(new RString(""));
            parameter.setPsmGyoseiku_To(new RString(""));
            parameter.setPsmGyoseiku_To_Name(new RString(""));
            parameter.setPsmChiku1_From(new RString(""));
            parameter.setPsmChiku1_To(new RString(""));
            parameter.setPsmChiku2_From(new RString(""));
            parameter.setPsmChiku2_To(new RString(""));
            parameter.setPsmChiku3_From(new RString(""));
            parameter.setPsmChiku3_To(new RString(""));
            parameter.setPsmChiku1_From_Name(new RString(""));
            parameter.setPsmChiku1_To_Name(new RString(""));
            parameter.setPsmChiku2_From_Name(new RString(""));
            parameter.setPsmChiku2_To_Name(new RString(""));
            parameter.setPsmChiku3_From_Name(new RString(""));
            parameter.setPsmChiku3_To_Name(new RString(""));
            BatchExitStatus result = flowHelper.executeFlow(new RString("HanyoListTekiyoJogaishaFlow"),
                    new RString("汎用リスト 適用除外者"),
                    HanyoListTekiyoJogaishaFlow.class, parameter);
            assertThat(result.getStatus(), is(BatchExitStatus.Status.SUCCESS));
        }
    }

    private static void setExecutionSubGyomuCodeToControlData(SubGyomuCode executionSubGyomuCode) {
        _ControlData controlData = new _ControlData(SubGyomuCode.DBA介護資格.toString(), "test",
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

    private static FlowContext createFlowContext(String flowInstanceId, String flowId) {
        FlowContext flowContext = Mockito.mock(FlowContext.class);
        Mockito.when(flowContext.getFlowInstanceId()).thenReturn(new FlowInstanceId(flowInstanceId));
        Mockito.when(flowContext.getFlowId()).thenReturn(new FlowId(flowId));
        return flowContext;

    }
}
