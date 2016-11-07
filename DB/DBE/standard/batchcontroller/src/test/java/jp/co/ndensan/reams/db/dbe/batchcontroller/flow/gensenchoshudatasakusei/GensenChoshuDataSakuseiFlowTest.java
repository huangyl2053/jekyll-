/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.batchcontroller.flow.gensenchoshudatasakusei;

import jp.co.ndensan.reams.db.dbe.definition.batchprm.gensenchoshudatasakusei.GensenChoshuDataSakuseiFlowParameter;
import jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.gensenchoshudatasakusei.IGensenChoshuDataSakuseiRelateMapper;
import jp.co.ndensan.reams.db.dbz.testhelper.DbeTestDacBase;
import jp.co.ndensan.reams.uz.uza.batch.BatchExitStatus;
import jp.co.ndensan.reams.uz.uza.biz.ReamsDonyuDantaiCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.core._ControlData;
import jp.co.ndensan.reams.uz.uza.core._ControlDataHolder;
import jp.co.ndensan.reams.uz.uza.euc.definition.UzUDE0831EucAccesslogFileType;
import jp.co.ndensan.reams.uz.uza.euc.io.EucEntityId;
import jp.co.ndensan.reams.uz.uza.io.Directory;
import jp.co.ndensan.reams.uz.uza.io.Path;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RYear;
import jp.co.ndensan.reams.uz.uza.spool.FileSpoolManager;
import jp.co.ndensan.reams.uz.uza.spool.entities.UzUDE0835SpoolOutputType;
import jp.co.ndensan.reams.uz.uza.testhelper.BatchFlowTestHelper;
import jp.co.ndensan.reams.uz.uza.testhelper.DbTestHelper;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import jp.co.ndensan.reams.uz.uza.workflow.context.FlowContext;
import jp.co.ndensan.reams.uz.uza.workflow.flow.valueobject.FlowId;
import jp.co.ndensan.reams.uz.uza.workflow.flow.valueobject.FlowInstanceId;
import static org.hamcrest.CoreMatchers.is;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.mockito.Mockito;
import static org.mockito.Mockito.when;

/**
 *
 * @author n8397
 */
public class GensenChoshuDataSakuseiFlowTest extends DbeTestDacBase {

    private static DbAccessorNormalType accessor;
    private static FileSpoolManager manager;
    private static DbTestHelper dbHelper;
    private static BatchFlowTestHelper flowHelper;

    @BeforeClass
    public static void setUp() {
        sqlSession.getConfiguration().addMapper(IGensenChoshuDataSakuseiRelateMapper.class);
        Directory.deleteIfExists(createTestTmpDirectory());
        DbeTestDacBase.beforeSetUpClass();
        accessor = new DbAccessorNormalType(sqlSession);
        setExecutionSubGyomuCodeToControlData(SubGyomuCode.DBE認定支援);
        flowHelper = new BatchFlowTestHelper();
    }

    @Test
    public void Test() {
        //setExecutionSubGyomuCodeToControlData(SubGyomuCode.DBE認定支援);
        //BatchExitStatus result = flowHelper.executeFlow(new RString("GensenChoshuDataSakuseiFlow"), new RString("源泉徴収データ作成"), GensenChoshuDataSakuseiFlow.class, createBatchParameter());
        //assertThat(result.getStatus(), is(BatchExitStatus.Status.SUCCESS));

    }

    private static GensenChoshuDataSakuseiFlowParameter createBatchParameter() {
        GensenChoshuDataSakuseiFlowParameter prm = new GensenChoshuDataSakuseiFlowParameter();
        prm.set指定年(RYear.MAX);
        return prm;
    }

    private static RString createTestTmpDirectory() {
        EucEntityId EUC_ENTITY_ID = new EucEntityId(new RString("GensenChoshuDataSakusei"));
        manager = new FileSpoolManager(UzUDE0835SpoolOutputType.Euc, EUC_ENTITY_ID,
                UzUDE0831EucAccesslogFileType.Csv);
        RString testPath = Path.combinePath(manager.getEucOutputDirectry());
        Directory.createDirectories(testPath);

        return testPath;
    }

    private static void setExecutionSubGyomuCodeToControlData(SubGyomuCode executionSubGyomuCode) {
        _ControlData controlData = new _ControlData(SubGyomuCode.DBE認定支援.toString(), "test", new ReamsDonyuDantaiCode("654321"));
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
