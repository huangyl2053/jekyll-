/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.batchcontroller.flow;

import java.util.Collections;
import jp.co.ndensan.reams.db.dbb.definition.batchprm.DBB112001.DBB112001_ToushoShotokuJohoChushutsuRenkeiTanitsuParameter;
import jp.co.ndensan.reams.db.dbb.definition.reportid.ReportIdDBB;
import jp.co.ndensan.reams.db.dbz.testhelper.DbbTestDacBase;
import jp.co.ndensan.reams.uz.uza.batch.batchexecutor.util.ExecuteType;
import jp.co.ndensan.reams.uz.uza.batch.batchexecutor.util._JobContext;
import jp.co.ndensan.reams.uz.uza.batch.batchexecutor.util._JobContextHolder;
import jp.co.ndensan.reams.uz.uza.batch.config._BatchSettings;
import jp.co.ndensan.reams.uz.uza.biz.ReamsDonyuDantaiCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.core._ControlData;
import jp.co.ndensan.reams.uz.uza.core._ControlDataHolder;
import jp.co.ndensan.reams.uz.uza.io.Path;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.testhelper.BatchFlowTestHelper;
import jp.co.ndensan.reams.uz.uza.workflow.context.FlowContext;
import jp.co.ndensan.reams.uz.uza.workflow.flow.valueobject.FlowId;
import jp.co.ndensan.reams.uz.uza.workflow.flow.valueobject.FlowInstanceId;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import static org.mockito.Mockito.when;

/**
 *
 * @author gl
 */
public class DBB112001_ToushoShotokuJohoChushutsuRenkeiTanitsuTest extends DbbTestDacBase {

    private static final RString 当初_広域_1 = new RString("1");
    private static final RString 異動_広域_2 = new RString("2");
    private static final RString 当初_単一_3 = new RString("3");
    private static final RString 異動_単一_4 = new RString("4");
    private static final RString 共有ファイル名 = new RString("BBKAIGO.csv");
    private static final RString 共有ファイルID = Path.getTmpDirectoryPath();

    /**
     * before
     */
    @Before
    public void test() {
        setExecutionSubGyomuCodeToControlData(SubGyomuCode.DBB介護賦課);
    }

    /**
     * test 所得情報抽出・連携
     */
    @Test
    public void 所得情報抽出_連携Test() {
        DBB112001_ToushoShotokuJohoChushutsuRenkeiTanitsuParameter parameter = setParameter();
        BatchFlowTestHelper batchFlowTest = new BatchFlowTestHelper();
        batchFlowTest.executeFlow(RString.EMPTY, RString.EMPTY, DBB112001_ToushoShotokuJohoChushutsuRenkeiTanitsu.class, parameter);
    }

    private DBB112001_ToushoShotokuJohoChushutsuRenkeiTanitsuParameter setParameter() {
        DBB112001_ToushoShotokuJohoChushutsuRenkeiTanitsuParameter param = new DBB112001_ToushoShotokuJohoChushutsuRenkeiTanitsuParameter();
        param.set帳票ID(ReportIdDBB.DBB200008.getReportId());
        param.set処理区分(当初_単一_3);
        param.set処理年度(new FlexibleYear("2016"));
        param.set処理日時(YMDHMS.now());
        param.set出力順ID(new RString("1"));
        param.set市町村情報List(Collections.EMPTY_LIST);
        param.set共有ファイルID(共有ファイルID);
        param.set共有ファイル名(共有ファイル名);
        return param;
    }

    @Test
    public void testTrim() {
        RString trim = new RString(" ddd　０0　");
        System.out.println("----------------" + trim.trim() + "---------");
    }

    private static void setExecutionSubGyomuCodeToControlData(SubGyomuCode executionSubGyomuCode) {
        _ControlData controlData = new _ControlData(SubGyomuCode.DBB介護賦課.toString(), "test", new ReamsDonyuDantaiCode("209007"));
        long jobId = 2;
        _BatchSettings settings = new _BatchSettings();
        ExecuteType type = ExecuteType.TEST;
        _JobContext jobContext = new _JobContext(jobId, settings, type);
        _JobContextHolder.setJobContext(jobContext);

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
