/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC120160;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import jp.co.ndensan.reams.db.dbz.testhelper.DbcTestDacBase;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.testhelper.BatchProcessTestHelper;
import jp.co.ndensan.reams.uz.uza.testhelper.DbTestHelper;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 */
public class KagoKetteiHokenshaInWriteReportProcessTest extends DbcTestDacBase {

    private static DbTestHelper dbHelper;

    @BeforeClass
    public static void setUpClass() {
        DbcTestDacBase.setUpClass();
        dbHelper = new DbTestHelper();
    }

    @Test
    public void test() {
        BatchProcessTestHelper.execute(KagoKetteiHokenshaInTempSaveProcess.class,
                createBatchParameter(), DbcTestDacBase.sqlSession);
        BatchProcessTestHelper.execute(KagoKetteiHokenshaInUpdataTempTableProcess.class, null, DbcTestDacBase.sqlSession);
        BatchProcessTestHelper.execute(KagoKetteiHokenshaInUpdataDBProcess.class,
                createBatchUpdataDBProcessParameter(), DbcTestDacBase.sqlSession);
        BatchProcessTestHelper.execute(KagoKetteiHokenshaInWriteReportProcess.class,
                createReportProcessParameter(), DbcTestDacBase.sqlSession);
        DbcTestDacBase.sqlSession.commit();
    }

    private HashMap<RString, Object> createBatchParameter() {

        HashMap<RString, Object> processParameter = new HashMap<>();
        processParameter.put(KagoKetteiHokenshaInTempSaveProcess.PARAMETER_FILEPATH,
                new RString("/home/D209007/shared/17110160315123456.csv"));
        return processParameter;
    }

    private HashMap<RString, Object> createBatchUpdataDBProcessParameter() {
        List<RString> csvFileName = new ArrayList<>();
        csvFileName.add(new RString("file1"));
        csvFileName.add(new RString("file2"));
        csvFileName.add(new RString("file3"));
        csvFileName.add(new RString("file4"));
        HashMap<RString, Object> processParameter = new HashMap<>();
        processParameter.put(KagoKetteiHokenshaInUpdataDBProcess.PARAMETER_SHORIYM, new FlexibleYearMonth("201601"));
        processParameter.put(KagoKetteiHokenshaInUpdataDBProcess.PARAMETER_CSVFILENAME, csvFileName);
        return processParameter;
    }

    private HashMap<RString, Object> createReportProcessParameter() {
        HashMap<RString, Object> processParameter = new HashMap<>();
        processParameter.put(KagoKetteiHokenshaInWriteReportProcess.PARAMETER_IN_SHORIYM, new FlexibleYearMonth("201601"));
        processParameter.put(KagoKetteiHokenshaInWriteReportProcess.PARAMETER_IN_SHUTSURYOKUJUNID, 1L);
        return processParameter;
    }
}
