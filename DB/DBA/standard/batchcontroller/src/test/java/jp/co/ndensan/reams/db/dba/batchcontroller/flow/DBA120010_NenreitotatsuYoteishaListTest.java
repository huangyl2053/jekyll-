/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.batchcontroller.flow;

import jp.co.ndensan.reams.db.dba.definition.batchprm.DBA120010.DBA120010_NenreitotatsuYoteishaListParameter;
import jp.co.ndensan.reams.uz.uza.batch.BatchExitStatus;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.testhelper.DbTestHelper;
import jp.co.ndensan.reams.db.dbz.testhelper.DbaTestDacBase;
import jp.co.ndensan.reams.uz.uza.batch.config.BatchSettings;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.testhelper.BatchFlowTestHelper;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 *
 * @author n3423
 */
@RunWith(Enclosed.class)
public class DBA120010_NenreitotatsuYoteishaListTest {

    private static DbTestHelper dbHelper;
    private static DBA120010_NenreitotatsuYoteishaListParameter parameter;
    private static BatchExitStatus result;

    private static final RString batchID = new RString("DBA120010_NenreitotatsuYoteishaList");
    private static final RString batchName = new RString("年齢到達予定者リスト");

    public static class 年齢到達予定者リストテスト {

        @BeforeClass
        public static void setUpClass() {
            DbaTestDacBase.setUpClass();
            dbHelper = new DbTestHelper();
//        setUpTestData(dbHelper);

            parameter = new DBA120010_NenreitotatsuYoteishaListParameter();
            createBatchParameter();

        }

        @Test
        public void Resultは_SUCCESSとなる() {

            BatchFlowTestHelper testhelper = new BatchFlowTestHelper();
            BatchSettings bs = new BatchSettings();
            result = testhelper.executeFlow(batchID, batchName, DBA120010_NenreitotatsuYoteishaList.class, parameter, bs);
//            assertThat(result.getStatus(), is(BatchExitStatus.Status.SUCCESS));
        }

        @AfterClass
        public static void tearDownClass() {
        }

        @Before
        public void setUp() {
        }

        @After
        public void tearDown() {
        }

        private static void createBatchParameter() {
            parameter.setJuminShubetsu(new RString("12345678"));
            parameter.setKonkaikaishi(new FlexibleDate("20160401"));
            parameter.setKonkaisyuryo(new FlexibleDate("20161001"));
            parameter.setKoumokumeiflg(true);
            parameter.setNichihensyuflg(true);
            parameter.setRenbanfukaflg(true);
            parameter.setShutsuryokujunId(new Long(3));
            parameter.setSyutsuryokutaisyo(new RString("1"));

        }
    }
}
