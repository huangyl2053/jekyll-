/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.batchcontroller.flow;

//import jp.co.ndensan.reams.uz.uza.auth.manage.mappers._AuthAuthorityDeputyManageMapperTest.テスト.*;
import jp.co.ndensan.reams.db.dbd.definition.batchprm.DBD532001.DBD532001_NinteiKekkaTsuchiParameter;
import jp.co.ndensan.reams.db.dbz.testhelper.DbdTestDacBase;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoPSMSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.KensakuYusenKubun;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.IShikibetsuTaishoPSMSearchKey;
import jp.co.ndensan.reams.uz.uza.batch.BatchExitStatus;
import jp.co.ndensan.reams.uz.uza.batch.config.BatchSettings;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RTime;
import jp.co.ndensan.reams.uz.uza.testhelper.BatchFlowTestHelper;
import jp.co.ndensan.reams.uz.uza.testhelper.DbTestHelper;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 *
 * @author n8343
 */
@RunWith(Enclosed.class)
public class DBD532001_NinteiTsuchishoHakkoTest extends DbdTestDacBase {

    private static DbTestHelper dbHelper;
    private static DBD532001_NinteiKekkaTsuchiParameter parameter;
    private static BatchExitStatus result;
    private static final RString batchID = new RString("DBD532001_NinteiKekkaTsuchiParameter");
    private static final RString batchName = new RString("一括発行Test");
    private static IShikibetsuTaishoPSMSearchKey searchKey;

    @BeforeClass
    public static void setUpClass() {
        dbHelper = new DbTestHelper();

    }

    public static class 一括発行Test extends DbdTestDacBase {

        @Test
        public void 認定結果通知書testes() {
            BatchFlowTestHelper testhelper = new BatchFlowTestHelper();
            BatchSettings bs = new BatchSettings();
            result = testhelper.executeFlow(batchID, batchName, DBD532001_NinteiKekkaTsuchi.class, 認定結果通知書発行(), bs);

        }

        @Test
        public void サービス通知書発行testes() {
            BatchFlowTestHelper testhelper = new BatchFlowTestHelper();
            BatchSettings bs = new BatchSettings();
            result = testhelper.executeFlow(batchID, batchName, DBD532001_NinteiKekkaTsuchi.class, サービス通知書発行(), bs);
            //assertThat(result);
        }

        @Test
        public void 要介護区分通知書発行testes() {
            BatchFlowTestHelper testhelper = new BatchFlowTestHelper();
            BatchSettings bs = new BatchSettings();
            result = testhelper.executeFlow(batchID, batchName, DBD532001_NinteiKekkaTsuchi.class, 要介護区分通知書発行(), bs);
            //assertThat(result);
        }
    }

    @AfterClass
    public static void afterTearDownClass() {

        DbdTestDacBase.tearDownClass();
    }

    private static DBD532001_NinteiKekkaTsuchiParameter 認定結果通知書発行() {
        DBD532001_NinteiKekkaTsuchiParameter pa = new DBD532001_NinteiKekkaTsuchiParameter();
        searchKey = new ShikibetsuTaishoPSMSearchKeyBuilder(GyomuCode.DB介護保険, KensakuYusenKubun.未定義).build();
        pa.set発行日(new FlexibleDate("20161121"));
        pa.set単票発行済み(false);
        pa.set出力順(new RString("order by \"DbT4001JukyushaDaicho\".\"hihokenshaNo\" asc"));
        pa.set認定結果通知書文書番号(new RString("第号"));
        pa.set認定結果通知書今回開始日付(new FlexibleDate("20161028"));
        pa.set認定結果通知書今回終了日付(new FlexibleDate("20161121"));
        pa.set認定結果通知書今回開始日時(new RTime(new RString("12:51:01.000")));
        pa.set認定結果通知書今回終了日時(RTime.now());
        pa.toNinteiKekkaTsutishoProcessParameter(searchKey);
        return pa;
    }

    private static DBD532001_NinteiKekkaTsuchiParameter サービス通知書発行() {
        DBD532001_NinteiKekkaTsuchiParameter pa = new DBD532001_NinteiKekkaTsuchiParameter();
        searchKey = new ShikibetsuTaishoPSMSearchKeyBuilder(GyomuCode.DB介護保険, KensakuYusenKubun.未定義).build();
        pa.set発行日(new FlexibleDate("20161121"));
        pa.set単票発行済み(false);
        pa.set出力順(new RString("order by \"DbT4001JukyushaDaicho\".\"hihokenshaNo\" asc"));
        pa.setサービス変更通知書文書番号(new RString("第号"));
        pa.setサービス変更通知書今回開始日付(new FlexibleDate("20161028"));
        pa.setサービス変更通知書今回終了日付(new FlexibleDate("20161121"));
        pa.setサービス変更通知書今回開始日時(new RTime(new RString("12:51:01.000")));
        pa.setサービス変更通知書今回終了日時(RTime.now());
        pa.toServiceHenkoTsutishoProcessParameter(searchKey);
        return pa;
    }

    private static DBD532001_NinteiKekkaTsuchiParameter 要介護区分通知書発行() {
        DBD532001_NinteiKekkaTsuchiParameter pa = new DBD532001_NinteiKekkaTsuchiParameter();
        searchKey = new ShikibetsuTaishoPSMSearchKeyBuilder(GyomuCode.DB介護保険, KensakuYusenKubun.未定義).build();
        pa.set発行日(new FlexibleDate("20161121"));
        pa.set単票発行済み(false);
        pa.set出力順(new RString("order by \"DbT4001JukyushaDaicho\".\"hihokenshaNo\" asc"));
        pa.set要介護区分変更通知書文書番号(new RString("第号"));
        pa.set要介護区分変更通知書今回開始日付(new FlexibleDate("20161028"));
        pa.set要介護区分変更通知書今回終了日付(new FlexibleDate("20161121"));
        pa.set要介護区分変更通知書今回開始日時(new RTime(new RString("12:51:01.000")));
        pa.set要介護区分変更通知書今回終了日時(RTime.now());
        pa.toYokaigoHenkoTsutishoProcessParameter(searchKey);
        return pa;
    }

}
