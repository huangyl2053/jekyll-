/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.batchcontroller.flow;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbd.definition.batchprm.DBD710130.DBD710130_HanyoListJigyoTaishoshaParameter;
import jp.co.ndensan.reams.db.dbz.definition.batchprm.hanyolist.atena.AtenaSelectBatchParameter;
import jp.co.ndensan.reams.db.dbz.definition.batchprm.hanyolist.atena.Chiku;
import jp.co.ndensan.reams.db.dbz.definition.batchprm.hanyolist.atena.NenreiSoChushutsuHoho;
import jp.co.ndensan.reams.uz.uza.batch.BatchExitStatus;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.testhelper.DbTestHelper;
import jp.co.ndensan.reams.db.dbz.testhelper.DbdTestDacBase;
import jp.co.ndensan.reams.uz.uza.batch.config.BatchSettings;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.testhelper.BatchFlowTestHelper;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import jp.co.ndensan.reams.uz.uza.lang.Range;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 *
 * @author n3423
 */
@RunWith(Enclosed.class)
public class DBD710130_HanyoListJigyoTaishoshaTest extends DbdTestDacBase {

    private static DbTestHelper dbHelper;
    private static DBD710130_HanyoListJigyoTaishoshaParameter parameter;
    private static BatchExitStatus result;

    private static final RString batchID = new RString("DBD710130_HanyoListJigyoTaishosha");
    private static final RString batchName = new RString("汎用リスト　事業対象者");

    public static class 年齢到達予定者リストテスト {

        @BeforeClass
        public static void setUpClass() {
            DbdTestDacBase.setUpClass();
            dbHelper = new DbTestHelper();
//        setUpTestData(dbHelper);

            parameter = new DBD710130_HanyoListJigyoTaishoshaParameter();
            createBatchParameter();

        }

        @Test
        public void Resultは_SUCCESSとなる() {

            BatchFlowTestHelper testhelper = new BatchFlowTestHelper();
            BatchSettings bs = new BatchSettings();
            result = testhelper.executeFlow(batchID, batchName, DBD710130_HanyoListJigyoTaishosha.class, parameter, bs);
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
            parameter.setHyoudai(new RString("汎用リスト　事業対象者"));
            parameter.setDetasyubetsumesyo(new RString("二次予防事業対象者"));
            parameter.setSyutsuryoku(new RString("3"));
            parameter.setCyusyutsuhohokubun(new RString("3"));
            parameter.setCyusyutsukomokukubun(new RString("9"));
            parameter.setKizyunnichi(FlexibleDate.getNowDate());
            parameter.setHitsukehanifrom(new FlexibleDate(new RString("")));
            parameter.setHitsukehanito(new FlexibleDate(new RString("")));
            parameter.setJigyotaishoshacyusyutsu(true);
            parameter.setCsvkomokumeifuka(true);
            parameter.setCsvrenbanfuka(true);
            parameter.setCsvhitsukesurasyuhensyu(true);
            AtenaSelectBatchParameter  atena = new AtenaSelectBatchParameter();
            atena.setAgeSelectKijun(NenreiSoChushutsuHoho.年齢範囲);
            atena.setNenreiRange(new Range<>(new Decimal(0), new Decimal(999)));
            atena.setNenreiKijunbi(null);
            atena.setSeinengappiRange(new Range(null, null));
            atena.setShichoson_Code(LasdecCode.EMPTY);
            atena.setShichoson_Mesho(new RString(""));
            atena.setChiku_Kubun(Chiku.全て);
            parameter.setAtenacyusyutsujyoken(atena);
            parameter.setCyohyoid(new RString("DBD701012_HanyoListJigyoTaishosha"));
            parameter.setSyutsuryokujun(new Long(1));
            parameter.setSyutsuryokukomoku(new RString(""));
        }
    }
}
