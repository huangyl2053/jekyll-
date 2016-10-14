/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.batchcontroller.flow.hanyolisthihokenshadaicho;

import java.util.ArrayList;
import jp.co.ndensan.reams.db.dba.definition.batchprm.hanyolisthihokenshadaicho.HanyoListHihokenshadaichoBatchParameter;
import jp.co.ndensan.reams.uz.uza.batch.BatchExitStatus;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.testhelper.DbTestHelper;
import jp.co.ndensan.reams.db.dbz.testhelper.DbaTestDacBase;
import jp.co.ndensan.reams.uz.uza.batch.config.BatchSettings;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.testhelper.BatchFlowTestHelper;
import static org.hamcrest.CoreMatchers.is;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 *
 * @author n3601
 */
@RunWith(Enclosed.class)
public class HanyoListHihokenshadaichoFlowTest extends DbaTestDacBase {

    private static DbTestHelper dbHelper;
    private static HanyoListHihokenshadaichoBatchParameter parameter;
    private static BatchExitStatus result;

    private static final RString batchID = new RString("HanyoListHihokenshadaichoFlow");
    private static final RString batchName = new RString("汎用リスト_被保険者台帳");

    public static class 汎用リスト_被保険者台帳 {

        @BeforeClass
        public static void setUpClass() {
            DbaTestDacBase.setUpClass();
            dbHelper = new DbTestHelper();
//        setUpTestData(dbHelper);

            parameter = new HanyoListHihokenshadaichoBatchParameter();
            createBatchParameter();

        }

        @Test
        public void Resultは_SUCCESSとなる() {

            BatchFlowTestHelper testhelper = new BatchFlowTestHelper();
            BatchSettings bs = new BatchSettings();
            result = testhelper.executeFlow(batchID, batchName, HanyoListHihokenshadaichoFlow.class, parameter, bs);
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
            parameter.setKomukuFukaMeyi(true);
            parameter.setRembanfuka(false);
            parameter.setHidukeHensyu(true);
            parameter.setHidukeTyuushutuKubun(new RString("1"));
            parameter.setKijunniKubun(new RString("1"));
            parameter.setKijunni(FlexibleDate.EMPTY);
            parameter.setKijunNichijiJukyusha(false);
            parameter.setRangeChushutsuhiKubun(new RString("1"));
            parameter.setRangeChushutsuhiFrom(FlexibleDate.EMPTY);
            parameter.setRangeChushutsuhiTo(FlexibleDate.EMPTY);
            parameter.setHiHokenshaJyoho(new ArrayList<RString>());
            parameter.setShikakuChushutsuKubun(new RString("0"));
            parameter.setShutokujiyu(new ArrayList<RString>());
            parameter.setSoshitsujiyu(new ArrayList<RString>());
            parameter.setPageShuturyokujun_Id(RString.EMPTY);
            parameter.setShutsuryokuKomuku_Id(RString.EMPTY);
            parameter.setChohyoId(new RString("DBA701001_HanyoListHihokenshaDaicho"));
            parameter.setPsmChushutsu_Kubun(new RString("1"));
            parameter.setPsmChushutsuAge_Start(new RString("70"));
            parameter.setPsmChushutsuAge_End(new RString("80"));
            parameter.setPsmSeinengappiYMD_Start(RString.EMPTY);
            parameter.setPsmSeinengappiYMD_End(RString.EMPTY);
            parameter.setPsmAgeKijunni(new FlexibleDate("20161013"));
            parameter.setShichoson_Code(RString.EMPTY);
            parameter.setShichoson_Name(RString.EMPTY);
            parameter.setPsmChiku_Kubun(new RString("0"));
            parameter.setPsmJusho_From(RString.EMPTY);
            parameter.setPsmJusho_From_Name(RString.EMPTY);
            parameter.setPsmJusho_To(RString.EMPTY);
            parameter.setPsmJusho_To_Name(RString.EMPTY);
            parameter.setPsmGyoseiku_From(RString.EMPTY);
            parameter.setPsmGyoseiku_From_Name(RString.EMPTY);
            parameter.setPsmGyoseiku_To(RString.EMPTY);
            parameter.setPsmGyoseiku_To_Name(RString.EMPTY);
            parameter.setPsmChiku1_From(RString.EMPTY);
            parameter.setPsmChiku1_From_Name(RString.EMPTY);
            parameter.setPsmChiku1_To(RString.EMPTY);
            parameter.setPsmChiku1_To_Name(RString.EMPTY);
            parameter.setPsmChiku2_From(RString.EMPTY);
            parameter.setPsmChiku2_From_Name(RString.EMPTY);
            parameter.setPsmChiku2_To(RString.EMPTY);
            parameter.setPsmChiku2_To_Name(RString.EMPTY);
            parameter.setPsmChiku3_From(RString.EMPTY);
            parameter.setPsmChiku3_From_Name(RString.EMPTY);
            parameter.setPsmChiku3_To(RString.EMPTY);
            parameter.setPsmChiku3_To_Name(RString.EMPTY);
        
        }
    }
}
