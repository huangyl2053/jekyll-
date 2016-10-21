/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.batchcontroller.flow;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.uz.uza.batch.BatchExitStatus;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.testhelper.DbTestHelper;
import jp.co.ndensan.reams.db.dbu.definition.batchprm.DBU010010.DBU010010_JigyoHokokuGeppo_MainParameter;
import jp.co.ndensan.reams.db.dbx.business.core.shichosonsecurityjoho.KoseiShichosonJoho;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.GyomuBunrui;
import jp.co.ndensan.reams.db.dbx.service.core.shichosonsecurityjoho.ShichosonSecurityJoho;
import jp.co.ndensan.reams.db.dbz.business.core.koikizenshichosonjoho.KoikiZenShichosonJoho;
import jp.co.ndensan.reams.db.dbz.service.core.gappeijoho.gappeijoho.GappeiCityJohoBFinder;
import jp.co.ndensan.reams.db.dbz.service.core.koikishichosonjoho.KoikiShichosonJohoFinder;
import jp.co.ndensan.reams.db.dbz.testhelper.DbaTestDacBase;
import jp.co.ndensan.reams.uz.uza.batch.config.BatchSettings;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RTime;
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
public class DBU010010_JigyoHokokuGeppo_MainTest {

    private static DbTestHelper dbHelper;
    private static DBU010010_JigyoHokokuGeppo_MainParameter parameter;
    private static BatchExitStatus result;
    private static List<RString> batchIdリスト;
    private static List<RString> 出力区分リスト;
    private static List<RString> 集計年月リスト;
    private static List<RString> 年度リスト;
    private static List<RDateTime> 作成日時リスト;
    private static List<RString> 給付集計区分リスト;
    private static List<RString> 決定年月リスト;
    private static List<LasdecCode> 旧市町村コードリスト;
    private static List<RString> 集計市町村コードリスト;

    private static final RString batchID = new RString("DBU010010_JigyoHokokuGeppo_Main");
    private static final RString batchName = new RString("事業状況報告資料（月報）作成");

    private static final FlexibleDate 集計年月1 = new FlexibleDate("20160831");
    private static final FlexibleDate 集計年月2 = new FlexibleDate("20160831");
    private static final FlexibleDate 集計年月3 = new FlexibleDate("20160831");
    private static final FlexibleDate 集計年月4 = new FlexibleDate("20160831");
    private static final FlexibleDate 集計年月5 = new FlexibleDate("20160831");
    private static final FlexibleDate 集計年月6 = new FlexibleDate("20160831");
    private static final FlexibleDate 集計年月7 = new FlexibleDate("20160831");

    private static final RDate 作成年月日1 = RDate.MIN;
    private static final RDate 作成年月日2 = RDate.MIN;
    private static final RDate 作成年月日3 = RDate.MIN;
    private static final RDate 作成年月日4 = RDate.MIN;
    private static final RDate 作成年月日5 = RDate.MIN;
    private static final RDate 作成年月日6 = RDate.MIN;
    private static final RDate 作成年月日7 = RDate.MIN;

    private static final RTime 作成時間1 = RTime.now();
    private static final RTime 作成時間2 = RTime.now();
    private static final RTime 作成時間3 = RTime.now();
    private static final RTime 作成時間4 = RTime.now();
    private static final RTime 作成時間5 = RTime.now();
    private static final RTime 作成時間6 = RTime.now();
    private static final RTime 作成時間7 = RTime.now();

    private static final RString 報告年月 = RString.EMPTY;
    private static final RString 報告年度 = RString.EMPTY;

    public static class 年齢到達登録者リストテスト {

        @BeforeClass
        public static void setUpClass() {
            DbaTestDacBase.setUpClass();
            dbHelper = new DbTestHelper();
//        setUpTestData(dbHelper);

            parameter = new DBU010010_JigyoHokokuGeppo_MainParameter();
            batchIdリスト = new ArrayList<>();
            出力区分リスト = new ArrayList<>();
            集計年月リスト = new ArrayList<>();
            年度リスト = new ArrayList<>();
            作成日時リスト = new ArrayList<>();
            決定年月リスト = new ArrayList<>();
            給付集計区分リスト = new ArrayList<>();
            旧市町村コードリスト = new ArrayList<>();
            集計市町村コードリスト = new ArrayList<>();

            createBatchParameter();
        }

        @Test
        public void Resultは_SUCCESSとなる() {

            BatchFlowTestHelper testhelper = new BatchFlowTestHelper();
            BatchSettings bs = new BatchSettings();
            result = testhelper.executeFlow(batchID, batchName, DBU010010_JigyoHokokuGeppo_Main.class, parameter, bs);
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
            batchIdリスト.add(new RString("DBU010020"));
            出力区分リスト.add(new RString("1"));
            給付集計区分リスト.add(RString.EMPTY);
            旧市町村コードリスト.add(LasdecCode.EMPTY);
            集計市町村コードリスト.add(get市町村コード().code市町村RString());
            get集計年月();
            get年度();
            get作成日時();
            get決定年月();
            parameter.setBatchID(batchIdリスト);
            parameter.setCsvID(null);
            parameter.setHokokuKubun(new RString("1"));
            parameter.setHokokuNendo(RString.EMPTY);
            parameter.setHoukokuNengetu(RString.EMPTY);
            parameter.setKaishiYm(new RString("20160831"));
            parameter.setKetteiYm(決定年月リスト);
            parameter.setKouseiShichosonCode(get構成市町村コードList());
            parameter.setKouseiShichosonKubun(new RString("0"));
            parameter.setKyuufuShuukeiKubunn(給付集計区分リスト);
            parameter.setNendo(年度リスト);
            parameter.setOldShichosonCode(旧市町村コードリスト);
            parameter.setOldShichosonKubun(GappeiCityJohoBFinder.createInstance().getGappeijohokubun());
            parameter.setPrintControlKbn(new RString("1"));
            parameter.setSakuseiNitizi(作成日時リスト);
            parameter.setShichosonCode(get市町村コード());
            parameter.setShukeiNendo(batchName);
            parameter.setShusyoYm(batchID);
            parameter.setShuukeiNengetu(集計年月リスト);
            parameter.setShuukeibunShichosonCode(集計市町村コードリスト);
            parameter.setShuukeibunShichosonKubun(GappeiCityJohoBFinder.createInstance().getGappeijohokubun());
            parameter.setSyoriNitizi(RDateTime.now());
            parameter.setSyutyoryokuKubun(出力区分リスト);
        }

        private static void get集計年月() {
            if (集計年月1 != null) {
                集計年月リスト.add(new RString(集計年月1.toString()));
            } else {
                集計年月リスト.add(RString.EMPTY);
            }
            if (集計年月2 != null) {
                集計年月リスト.add(new RString(集計年月2.toString()));
            } else {
                集計年月リスト.add(RString.EMPTY);
            }
            if (集計年月3 != null) {
                集計年月リスト.add(new RString(集計年月3.toString()));
            } else {
                集計年月リスト.add(RString.EMPTY);
            }
            if (集計年月4 != null) {
                集計年月リスト.add(new RString(集計年月4.toString()));
            } else {
                集計年月リスト.add(RString.EMPTY);
            }
            if (集計年月5 != null) {
                集計年月リスト.add(new RString(集計年月5.toString()));
            } else {
                集計年月リスト.add(RString.EMPTY);
            }
            if (集計年月6 != null) {
                集計年月リスト.add(new RString(集計年月6.toString()));
            } else {
                集計年月リスト.add(RString.EMPTY);
            }
            if (集計年月7 != null) {
                集計年月リスト.add(new RString(集計年月7.toString()));
            } else {
                集計年月リスト.add(RString.EMPTY);
            }
        }

        private static void get年度() {
            if (集計年月1 != null) {
                年度リスト.add(集計年月1.getYear().toDateString());
            } else {
                年度リスト.add(RString.EMPTY);
            }
            if (集計年月4 != null) {
                年度リスト.add(集計年月4.getYear().toDateString());
            } else {
                年度リスト.add(RString.EMPTY);
            }
            if (集計年月6 != null) {
                年度リスト.add(集計年月6.getYear().toDateString());
            } else {
                年度リスト.add(RString.EMPTY);
            }
            if (集計年月7 != null) {
                年度リスト.add(集計年月7.getYear().toDateString());
            } else {
                年度リスト.add(RString.EMPTY);
            }
        }

        private static void get作成日時() {
            if (作成年月日1 != null) {
                作成日時リスト.add(set作成日時(作成年月日1, 作成時間1));
            } else {
                作成日時リスト.add(RDateTime.MIN);
            }
            if (作成年月日2 != null) {
                作成日時リスト.add(set作成日時(作成年月日2, 作成時間2));
            } else {
                作成日時リスト.add(RDateTime.MIN);
            }
            if (作成年月日4 != null) {
                作成日時リスト.add(set作成日時(作成年月日4, 作成時間4));
                作成日時リスト.add(set作成日時(作成年月日4, 作成時間4));
            } else {
                作成日時リスト.add(RDateTime.MIN);
                作成日時リスト.add(RDateTime.MIN);
            }
            if (作成年月日3 != null) {
                作成日時リスト.add(set作成日時(作成年月日3, 作成時間3));
                作成日時リスト.add(set作成日時(作成年月日3, 作成時間3));
            } else {
                作成日時リスト.add(RDateTime.MIN);
                作成日時リスト.add(RDateTime.MIN);
            }
            if (作成年月日5 != null) {
                作成日時リスト.add(set作成日時(作成年月日5, 作成時間5));
            } else {
                作成日時リスト.add(RDateTime.MIN);
            }
            if (作成年月日6 != null) {
                作成日時リスト.add(set作成日時(作成年月日6, 作成時間6));
            } else {
                作成日時リスト.add(RDateTime.MIN);
            }
            if (作成年月日7 != null) {
                作成日時リスト.add(set作成日時(作成年月日7, 作成時間7));
            } else {
                作成日時リスト.add(RDateTime.MIN);
            }
        }

        private static RDateTime set作成日時(RDate 作成日, RTime 作成時) {
            return RDateTime.of(作成日.getYearValue(), 作成日.getMonthValue(),
                    作成日.getDayValue(), 作成時.getHour(), 作成時.getSecond());
        }

        private static void get決定年月() {
            if (集計年月4 != null) {
                決定年月リスト.add(new RString(集計年月4.toString()));
            } else {
                決定年月リスト.add(RString.EMPTY);
            }
            if (集計年月7 != null) {
                決定年月リスト.add(new RString(集計年月7.toString()));
            } else {
                決定年月リスト.add(RString.EMPTY);
            }
        }

        private static List<LasdecCode> get構成市町村コードList() {
            List<LasdecCode> 構成市町村コードList = new ArrayList<>();
            KoseiShichosonJoho 市町村情報 = ShichosonSecurityJoho.getShichosonSecurityJoho(GyomuBunrui.介護事務).get市町村情報();
            RString 市町村識別ID = 市町村情報.get市町村識別ID();
            if (new RString("00").equals(市町村識別ID)) {
                List<KoikiZenShichosonJoho> 現市町村情報List = KoikiShichosonJohoFinder.createInstance().getGenShichosonJoho().records();
                for (KoikiZenShichosonJoho 現市町村情報 : 現市町村情報List) {
                    構成市町村コードList.add(現市町村情報.get市町村コード());
                }
            } else {
                構成市町村コードList.add(市町村情報.get市町村コード());
            }
            return 構成市町村コードList;
        }

        private static LasdecCode get市町村コード() {
            return ShichosonSecurityJoho.getShichosonSecurityJoho(GyomuBunrui.介護事務).get市町村情報().get市町村コード();
        }

    }
}
