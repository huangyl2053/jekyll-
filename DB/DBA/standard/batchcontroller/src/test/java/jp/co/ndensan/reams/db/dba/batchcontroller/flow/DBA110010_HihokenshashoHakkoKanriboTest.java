/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.batchcontroller.flow;

import java.util.ArrayList;
import jp.co.ndensan.reams.db.dba.definition.batchprm.DBA110010.DBA110010_HihokenshashoHakkoKanriboParameter;
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
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 *
 * @author n3423
 */
@RunWith(Enclosed.class)
public class DBA110010_HihokenshashoHakkoKanriboTest {

    private static DbTestHelper dbHelper;
    private static DBA110010_HihokenshashoHakkoKanriboParameter parameter;
    private static BatchExitStatus result;

    private static final RString batchID = new RString("DBA110010_HihokenshashoHakkoKanribo");
    private static final RString batchName = new RString("被保険者証発行管理簿");

    public static class 年齢到達予定者リストテスト {

        @BeforeClass
        public static void setUpClass() {
            DbaTestDacBase.setUpClass();
            dbHelper = new DbTestHelper();
//        setUpTestData(dbHelper);

            parameter = new DBA110010_HihokenshashoHakkoKanriboParameter();
            createBatchParameter();

        }

        @Test
        public void Resultは_SUCCESSとなる() {

            BatchFlowTestHelper testhelper = new BatchFlowTestHelper();
            BatchSettings bs = new BatchSettings();
            result = testhelper.executeFlow(batchID, batchName, DBA110010_HihokenshashoHakkoKanribo.class, parameter, bs);
            assertThat(result.getStatus(), is(BatchExitStatus.Status.SUCCESS));
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
            parameter.setAkasihakoumod(new RString("001"));
            parameter.setHizikehensyuuflg(false);
            parameter.setKasyuujiyuulist(new ArrayList<RString>());
            parameter.setKasyuukayisihi(FlexibleDate.EMPTY);
            parameter.setKasyuusiuryouhi(FlexibleDate.EMPTY);
            parameter.setKayuujiyuulist(new ArrayList<RString>());
            parameter.setKoufukayisihi(new FlexibleDate("20151001"));
            parameter.setKoufusiuryouhi(new FlexibleDate("20160930"));
            parameter.setKoumukumeyifukaflg(true);
            parameter.setRenbanfukaflg(false);
            parameter.setSeyisinjyohoflg(false);
            parameter.setSiyuturiyokudaysyou(new RString("1"));
            parameter.setSyuturyokujunid(1L);

        }
    }
}
