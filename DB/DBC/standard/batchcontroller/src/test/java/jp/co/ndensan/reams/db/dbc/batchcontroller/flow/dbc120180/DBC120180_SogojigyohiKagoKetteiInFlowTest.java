/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jp.co.ndensan.reams.db.dbc.batchcontroller.flow.dbc120180;

import jp.co.ndensan.reams.db.dbc.batchcontroller.flow.dbc120070.DBC120070_KogakuKyufuTaishoshaInFlow;
import jp.co.ndensan.reams.db.dbc.definition.batchprm.kogakukyufutaishoshain.KogakuKyufuTaishoshaInBatchParameter;
import jp.co.ndensan.reams.db.dbc.definition.batchprm.sogojigyohikagoketteiin.DBC120180_SogojigyohiKagoKetteiInParameter;
import jp.co.ndensan.reams.db.dbc.definition.core.saishori.SaiShoriKubun;
import jp.co.ndensan.reams.ux.uxx.persistence.db.mapper.util.MapperProvider;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.ReamsDonyuDantaiCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.cooperation.FilesystemName;
import jp.co.ndensan.reams.uz.uza.cooperation.FilesystemPath;
import jp.co.ndensan.reams.uz.uza.cooperation.SharedFile;
import jp.co.ndensan.reams.uz.uza.cooperation.descriptor.CopyToSharedFileOpts;
import jp.co.ndensan.reams.uz.uza.cooperation.descriptor.SharedFileDescriptor;
import jp.co.ndensan.reams.uz.uza.cooperation.descriptor.SharedFileEntryDescriptor;
import jp.co.ndensan.reams.uz.uza.core._ControlData;
import jp.co.ndensan.reams.uz.uza.core._ControlDataHolder;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.testhelper.BatchFlowTestHelper;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.workflow.context.FlowContext;
import jp.co.ndensan.reams.uz.uza.workflow.flow.valueobject.FlowId;
import jp.co.ndensan.reams.uz.uza.workflow.flow.valueobject.FlowInstanceId;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import static org.mockito.Mockito.when;

/**
 *
 * @author fzou
 */
public class DBC120180_SogojigyohiKagoKetteiInFlowTest {
    private static final RString SRC = new RString("E:\\331");
    private static final RString DST = new RString("dst");
    private static final RString PREFIX = new RString("1_");
    private static final RString LOGIC_NAME = new RString("175");

    private static final RString ファイル格納フォルダ名 = new RString("DBC120180");
    private static final RString 帳票ID = new RString("DBC200075_SogojigyohiKagoKetteiTsuchishoTorikomiIchiran");
    private static final RString 実行不可MESSAGE = new RString("帳票出力順の取得");
    private static final RString キー_出力順 = new RString("出力順");

    private MapperProvider mapperProvider;

    @Before
    public void setUp() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
        setExecutionSubGyomuCodeToControlData(SubGyomuCode.DBC介護給付);
    }

    @Test
    public void testBatch() {
        System.out.println("Test of  DBC120180");
        testFileGetPrepare();//准备第一步的csv文件，把它登录进数据库
        DBC120180_SogojigyohiKagoKetteiInParameter parameter = setParameter();//设置batch实行的参数
        BatchFlowTestHelper batchFlowTest = new BatchFlowTestHelper();
        batchFlowTest.executeFlow(RString.EMPTY, RString.EMPTY, DBC120180_SogojigyohiKagoKetteiInFlow.class, parameter);//实行batch
    }

    private DBC120180_SogojigyohiKagoKetteiInParameter setParameter() {
        DBC120180_SogojigyohiKagoKetteiInParameter parameter = new DBC120180_SogojigyohiKagoKetteiInParameter();
        parameter.set再処理区分(SaiShoriKubun.再処理.getコード());
        parameter.set処理年月(new FlexibleYearMonth("201606"));
        parameter.set出力順ID(1L);
        return parameter;
    }

//    @Test
    public void testFileGetPrepare() {
        setExecutionSubGyomuCodeToControlData(SubGyomuCode.DBC介護給付);
        //共有ファイルを定義
        SharedFileDescriptor sfd = new SharedFileDescriptor(GyomuCode.DB介護保険, FilesystemName.fromString(PREFIX.concat(LOGIC_NAME)));
        sfd = SharedFile.defineSharedFile(sfd); //世代管理無し、権限グループによるアクセス制限なし
        //localフォルダ ⇛ 共有ファイル
        CopyToSharedFileOpts opts = new CopyToSharedFileOpts().dateToDelete(RDate.getNowDate().plusMonth(1)); //保存期限1ヶ月
        SharedFileEntryDescriptor entry = SharedFile.copyToSharedFile(sfd, FilesystemPath.fromString(SRC), opts);
        System.out.println(entry.toString());
    }

    private static void setExecutionSubGyomuCodeToControlData(SubGyomuCode executionSubGyomuCode) {
        _ControlData controlData = new _ControlData(SubGyomuCode.DBC介護給付.toString(), "tianjiexin", new ReamsDonyuDantaiCode("209007"));
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
