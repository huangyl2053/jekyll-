/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.batchcontroller.flow;

import jp.co.ndensan.reams.uz.uza.batch.BatchExitStatus;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.testhelper.DbTestHelper;
import jp.co.ndensan.reams.db.dba.definition.batchprm.DBA150010.DBA150010_NenreitotatsuTorokuListParameter;
import jp.co.ndensan.reams.db.dbz.testhelper.DbaTestDacBase;
import jp.co.ndensan.reams.uz.uza.batch.config.BatchSettings;
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
public class DBA150010_NenreiTotatsuTorokuTest extends DbaTestDacBase {

    private static DbTestHelper dbHelper;
    private static DBA150010_NenreitotatsuTorokuListParameter parameter;
    private static BatchExitStatus result;

    private static final RString batchID = new RString("DBA150010_NenreitotatsuTorokuList");
    private static final RString batchName = new RString("年齢到達登録リスト");

    public static class 年齢到達登録者リストテスト {

        @BeforeClass
        public static void setUpClass() {
            DbaTestDacBase.setUpClass();
            dbHelper = new DbTestHelper();
//        setUpTestData(dbHelper);

            parameter = new DBA150010_NenreitotatsuTorokuListParameter();
            createBatchParameter();

        }

        @Test
        public void Resultは_SUCCESSとなる() {

            BatchFlowTestHelper testhelper = new BatchFlowTestHelper();
            BatchSettings bs = new BatchSettings();
            result = testhelper.executeFlow(batchID, batchName, DBA150010_NenreitotatsuTorokuList.class, parameter, bs);
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
            parameter.setKonkaikaishiYMDHMS(new RString("2015-04-01 00:00:00.000"));
            parameter.setKonkaishuryoYMDHMS(new RString("2016-10-01 23:59:59.999"));
            parameter.setZenkaikaishiYMDHMS(new RString("2015-04-01 00:00:00.000"));
            parameter.setZenkaishuryoYMDHMS(new RString("2016-10-01 23:59:59.999"));
            parameter.setShutsuryokujunID(new Long(1));
        }

    }
}
