/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.flow.dbc120250;

import jp.co.ndensan.reams.db.dbc.definition.batchprm.kokuhorenkyoutsu.KokuhorenKyoutsuBatchParameter;
import jp.co.ndensan.reams.db.dbc.service.core.MapperProvider;
import jp.co.ndensan.reams.db.dbz.testhelper.DbcTestDacBase;
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
 * @author jiangxiaolong
 */
public class DBC120250BatchFlowTest extends DbcTestDacBase {

    private static final RString SRC = new RString("E:\\csv");
    private static final RString DST = new RString("dst");
    private static final RString PREFIX = new RString("1_");
    private static final RString LOGIC_NAME = new RString("152");

    private MapperProvider mapperProvider;

    @Before
    public void setUp() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
        setExecutionSubGyomuCodeToControlData(SubGyomuCode.DBC介護給付);
    }

    @Test
    public void testBatch() {
        System.out.println("Test of  DBC120250");
        System.out.println("Test of  DBC120250");
        testFileGetPrepare();
        KokuhorenKyoutsuBatchParameter parameter = setParameter();
        BatchFlowTestHelper batchFlowTest = new BatchFlowTestHelper();
        batchFlowTest.executeFlow(RString.EMPTY, RString.EMPTY, DBC120250_SogojigyohiSeikyugakuTsuchishoKeikaSochiInFlow.class, parameter);
    }

    private KokuhorenKyoutsuBatchParameter setParameter() {
        KokuhorenKyoutsuBatchParameter parameter = new KokuhorenKyoutsuBatchParameter();
        parameter.setShoriYM(new FlexibleYearMonth("201606"));
        return parameter;
    }

    public void testFileGetPrepare() {
        setExecutionSubGyomuCodeToControlData(SubGyomuCode.DBC介護給付);
        SharedFileDescriptor sfd = new SharedFileDescriptor(GyomuCode.DB介護保険, FilesystemName.fromString(PREFIX.concat(LOGIC_NAME)));
        sfd = SharedFile.defineSharedFile(sfd);
        CopyToSharedFileOpts opts = new CopyToSharedFileOpts().dateToDelete(RDate.getNowDate().plusMonth(1));
        SharedFileEntryDescriptor entry = SharedFile.copyToSharedFile(sfd, FilesystemPath.fromString(SRC), opts);
        System.out.println(entry.toString());
    }

    private static void setExecutionSubGyomuCodeToControlData(SubGyomuCode executionSubGyomuCode) {
        _ControlData controlData = new _ControlData(SubGyomuCode.DBC介護給付.toString(), "hanxinyuan", new ReamsDonyuDantaiCode("209007"));
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
