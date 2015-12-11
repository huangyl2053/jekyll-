/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.service.core.roreifukushinenkinjoho;

import java.util.List;
import jp.co.ndensan.reams.db.dba.business.core.roreifukushinenkinjoho.BRoreiFukushiNenkinJoho;
import jp.co.ndensan.reams.db.dba.definition.core.roreifukushinenkinjoho.RoreiFukushiNenkinJohoMapperParameter;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.testhelper.helper.CSVDataUtilForUseSession;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7006RoreiFukushiNenkinJukyushaEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT7006RoreiFukushiNenkinJukyushaDac;
import jp.co.ndensan.reams.db.dbz.testhelper.DbaTestBase;
import jp.co.ndensan.reams.db.dbz.testhelper.DbaTestDacBase;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import static org.hamcrest.CoreMatchers.is;
import org.junit.After;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link jp.co.ndensan.reams.db.dba.service.ShichosonSentaku}のテストです。
 *
 */
@RunWith(Enclosed.class)
public class RoreiFukushiNenkinJohoManagersTest extends DbaTestBase {

    private static RoreiFukushiNenkinJohoManagers service;
    private static DbT7006RoreiFukushiNenkinJukyushaDac dbT7006dac;
//
//    public static final ShikibetsuCode 識別コード1 = new ShikibetsuCode("000001234567890");
//    public static final ShikibetsuCode 識別コード2 = new ShikibetsuCode("000001234567890");
//    public static final FlexibleDate 受給開始年月日1 = new FlexibleDate("");
//    public static final FlexibleDate 受給開始年月日2 = new FlexibleDate("20140401");
//    public static final FlexibleDate 受給終了年月日1 = new FlexibleDate("");
//    public static final FlexibleDate 受給終了年月日2 = new FlexibleDate("20140401");

    @BeforeClass
    public static void setUpClass() {
        dbT7006dac = InstanceProvider.create(DbT7006RoreiFukushiNenkinJukyushaDac.class);

    }

    public static class GetRoreiFukushiNenkinJohoTest extends DbaTestDacBase {

        private static void clearTable() {
            CSVDataUtilForUseSession csvDataUtil = new CSVDataUtilForUseSession();
            csvDataUtil.clearTable(sqlSession, "DbT7006RoreiFukushiNenkinJukyusha");
        }

        @Before
        public void setUp() {
            clearTable();
            dbT7006dac = InstanceProvider.create(DbT7006RoreiFukushiNenkinJukyushaDac.class);
        }

        @Test(expected = NullPointerException.class)
        public void 検索パラメータがnullの場合_GetRoreiFukushiNenkinJohoTestは_NullPointerExceptionを発生させる() {
            service.getRoreiFukushiNenkinJoho(null);
        }

        @Test
        public void 老齢福祉年金情報しない場合_GetRoreiFukushiNenkinJohoTestは_0件を返すこと() {
            RoreiFukushiNenkinJohoMapperParameter param = RoreiFukushiNenkinJohoMapperParameter.createRoreiFukushiParam(new ShikibetsuCode("000001234567890"),
                    FlexibleDate.EMPTY, HihokenshaNo.EMPTY, FlexibleDate.EMPTY);
            List< BRoreiFukushiNenkinJoho> result = service.getRoreiFukushiNenkinJoho(param);
            assertThat(result.size(), is(0));
        }

        @Test
        public void 老齢福祉年金情報する場合_GetRoreiFukushiNenkinJohoTestは_1件を返すこと() {
            insert1_DbT7006RoreiFukushiNenkinJukyushaEntity(new ShikibetsuCode("000001234567890"), new FlexibleDate("20140403"));
            RoreiFukushiNenkinJohoMapperParameter param = RoreiFukushiNenkinJohoMapperParameter.createRoreiFukushiParam(new ShikibetsuCode("000001234567890"),
                    new FlexibleDate("20140403"), HihokenshaNo.EMPTY, FlexibleDate.EMPTY);
            List<BRoreiFukushiNenkinJoho> result = service.getRoreiFukushiNenkinJoho(param);
            assertThat(result.size(), is(1));
        }

        @Test
        public void 老齢福祉年金情報する場合_GetRoreiFukushiNenkinJohoTestは_一覧情報のリスト2件を返すこと() {
            insert1_DbT7006RoreiFukushiNenkinJukyushaEntity(new ShikibetsuCode("000001234567890"), new FlexibleDate("20140400"));
            insert1_DbT7006RoreiFukushiNenkinJukyushaEntity(new ShikibetsuCode("000001234567890"), new FlexibleDate("20140403"));
            RoreiFukushiNenkinJohoMapperParameter param = RoreiFukushiNenkinJohoMapperParameter.createRoreiFukushiParam(new ShikibetsuCode("000001234567890"),
                    FlexibleDate.EMPTY, HihokenshaNo.EMPTY, FlexibleDate.EMPTY);
            List<BRoreiFukushiNenkinJoho> result = service.getRoreiFukushiNenkinJoho(param);
            assertThat(result.size(), is(2));
        }
    }

    public static class RegRoreiFukushiNenkinJohoTest extends DbaTestDacBase {

        private static void clearTable() {
            CSVDataUtilForUseSession csvDataUtil = new CSVDataUtilForUseSession();
            csvDataUtil.clearTable(sqlSession, DbT7006RoreiFukushiNenkinJukyushaEntity.TABLE_NAME.toString());
        }

        @Before
        public void setUp() {
            clearTable();
            dbT7006dac = InstanceProvider.create(DbT7006RoreiFukushiNenkinJukyushaDac.class);
        }

        @Test(expected = NullPointerException.class)
        public void パラメータがnullの場合_RegRoreiFukushiNenkinJohoTestは_NullPointerExceptionを発生させる() {
            service.regRoreiFukushiNenkinJoho(null);
        }

        @Test
        public void 該当する老齢福祉年金情報の追加の場合_RegRoreiFukushiNenkinJohoTestは_1件を返すこと() {
            RoreiFukushiNenkinJohoMapperParameter param = RoreiFukushiNenkinJohoMapperParameter.createRoreiFukushiParam(new ShikibetsuCode("000001234567890"),
                    new FlexibleDate("20140208"), new HihokenshaNo("19"), new FlexibleDate("20140908"));

            int result = service.regRoreiFukushiNenkinJoho(param);
            assertThat(result, is(1));
        }
    }

    public static class UpdRoreiFukushiNenkinJoho extends DbaTestDacBase {

        private static void clearTable() {
            CSVDataUtilForUseSession csvDataUtil = new CSVDataUtilForUseSession();
            csvDataUtil.clearTable(sqlSession, DbT7006RoreiFukushiNenkinJukyushaEntity.TABLE_NAME.toString());
        }

        @Before
        public void setUp() {
            clearTable();
            dbT7006dac = InstanceProvider.create(DbT7006RoreiFukushiNenkinJukyushaDac.class);
            service = new RoreiFukushiNenkinJohoManagers(dbT7006dac);
        }

        @Test(expected = NullPointerException.class)
        public void パラメータがnullの場合_UpdRoreiFukushiNenkinJohoは_NullPointerExceptionを発生させる() {
            service.updRoreiFukushiNenkinJoho(null);
        }

        @Test
        public void 該当する老齢福祉年金情報の更新の場合_UpdRoreiFukushiNenkinJohoは_1件を返すこと() {
            insert1_DbT7006RoreiFukushiNenkinJukyushaEntity(new ShikibetsuCode("000001234567890"), new FlexibleDate("20151208"));
            RoreiFukushiNenkinJohoMapperParameter param = RoreiFukushiNenkinJohoMapperParameter.createRoreiFukushiParam(new ShikibetsuCode("000001234567890"),
                    new FlexibleDate("20151208"), new HihokenshaNo("19"), new FlexibleDate("20140908"));

            int result = service.updRoreiFukushiNenkinJoho(param);
            assertThat(result, is(1));
        }

        @After
        public void after() {
            sqlSession.rollback();
        }
    }

    public static class DelRoreiFukushiNenkinJoho extends DbaTestDacBase {

        private static void clearTable() {
            CSVDataUtilForUseSession csvDataUtil = new CSVDataUtilForUseSession();
            csvDataUtil.clearTable(sqlSession, DbT7006RoreiFukushiNenkinJukyushaEntity.TABLE_NAME.toString());
        }

        @Before
        public void setUp() {
            clearTable();
            dbT7006dac = InstanceProvider.create(DbT7006RoreiFukushiNenkinJukyushaDac.class);
        }

        @Test(expected = NullPointerException.class)
        public void パラメータがnullの場合_DelRoreiFukushiNenkinJohoは_NullPointerExceptionを発生させる() {
            service.delRoreiFukushiNenkinJoho(null);
        }

        @Test
        public void 該当する老齢福祉年金情報の削除の場合_DelRoreiFukushiNenkinJohoは_1件を返すこと() {
            insert1_DbT7006RoreiFukushiNenkinJukyushaEntity(new ShikibetsuCode("000001234567890"), new FlexibleDate("20151208"));
            RoreiFukushiNenkinJohoMapperParameter param = RoreiFukushiNenkinJohoMapperParameter.createRoreiFukushiParam(new ShikibetsuCode("000001234567890"),
                    new FlexibleDate("20151208"), HihokenshaNo.EMPTY, FlexibleDate.EMPTY);

            int result = service.delRoreiFukushiNenkinJoho(param);
            assertThat(result, is(1));
        }

    }

    public static void insert1_DbT7006RoreiFukushiNenkinJukyushaEntity(ShikibetsuCode 識別コード, FlexibleDate 受給開始年月日) {
        DbT7006RoreiFukushiNenkinJukyushaEntity dbT7006entity = new DbT7006RoreiFukushiNenkinJukyushaEntity();
        dbT7006entity.setShikibetsuCode(識別コード);
        dbT7006entity.setJukyuKaishiYMD(受給開始年月日);
        dbT7006entity.setJukyuShuryoYMD(new FlexibleDate("20140403"));
        dbT7006entity.setHihokenshaNo(new HihokenshaNo("12"));
        dbT7006dac.save(dbT7006entity);
    }
}
