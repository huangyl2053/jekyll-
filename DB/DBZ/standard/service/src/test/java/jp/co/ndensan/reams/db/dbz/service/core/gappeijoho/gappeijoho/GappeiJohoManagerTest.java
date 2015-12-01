/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.service.core.gappeijoho.gappeijoho;

import jp.co.ndensan.reams.db.dbx.testhelper.helper.CSVDataUtilForUseSession;
import jp.co.ndensan.reams.db.dbz.business.core.gappeijoho.gappeijoho.GappeiJoho;
import jp.co.ndensan.reams.db.dbz.definition.mybatis.param.gappeijoho.GappeiJohoMapperParameter;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7055GappeiJohoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.helper.DbT7055GappeiJohoEntityGenerator;
import jp.co.ndensan.reams.db.dbz.entity.db.relate.gappeijoho.GappeiJohoRelateEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT7055GappeiJohoDac;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestDacBase;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import org.junit.After;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {link GappeiJohoManager}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class GappeiJohoManagerTest extends DbzTestDacBase {

    private static DbT7055GappeiJohoDac dac;
    private static GappeiJohoManager sut;
    private static final FlexibleDate 主キー11 = DbT7055GappeiJohoEntityGenerator.DEFAULT_合併年月日;
    private static final FlexibleDate 主キー12 = new FlexibleDate("20150101");
    private static final RString 主キー21 = DbT7055GappeiJohoEntityGenerator.DEFAULT_地域番号;
    private static final RString 主キー22 = new RString("02");

    @BeforeClass
    public static void test() {
        dac = InstanceProvider.create(DbT7055GappeiJohoDac.class);
    }

    public static class get合併情報 extends DbzTestDacBase {

        @Before
        public void setUp() {
            sut = GappeiJohoManager.createInstance();
            TestSupport.clearTable();
            TestSupport.insertDbT7055(主キー11, 主キー21);
        }

        @Test(expected = NullPointerException.class)
        public void 引数にnullを指定した場合_NullPointerExceptionが発生する() {
            sut.get合併情報(null);
        }

        @Test
        public void 検索結果がnullの場合() {
            GappeiJoho result = sut.get合併情報(GappeiJohoMapperParameter.createSelectByKeyParam(主キー12, 主キー22));
            assertThat(result, is(nullValue()));
        }

        @Test
        public void 検索結果が存在する場合() {
            GappeiJoho result = sut.get合併情報(GappeiJohoMapperParameter.createSelectByKeyParam(主キー11, 主キー21));
            assertThat(result.get合併年月日().toString(), is(DbT7055GappeiJohoEntityGenerator.DEFAULT_合併年月日.toString()));
        }
    }

    public static class save合併情報 extends DbzTestDacBase {

        @Before
        public void setUp() {
            TestSupport.clearTable();
            sut = new GappeiJohoManager(null, dac, null);
        }

//        @Test
//        public void insertに成功するとtrueが返る() {
//
//            DbT7055GappeiJohoEntity entity = DbT7055GappeiJohoEntityGenerator.createDbT7055GappeiJohoEntity();
//            GappeiJohoRelateEntity relateEntity = new GappeiJohoRelateEntity();
//            relateEntity.set合併情報Entity(entity);
//            GappeiJoho 合併情報 = new GappeiJoho(relateEntity);
//
//            assertThat(sut.save(合併情報), is(true));
//        }
//
//        @Test
//        public void insertに失敗するとfalseが返る() {
//
//            DbT7055GappeiJohoEntity entity = DbT7055GappeiJohoEntityGenerator.createDbT7055GappeiJohoEntity();
//            GappeiJohoRelateEntity relateEntity = new GappeiJohoRelateEntity();
//            relateEntity.set合併情報Entity(entity);
//            GappeiJoho 合併情報 = new GappeiJoho(relateEntity);
//
//            assertThat(sut.save(合併情報), is(false));
//        }
//
//        @Test
//        public void updateに成功するとtrueが返る() {
//
//            DbT7055GappeiJohoEntity entity = DbT7055GappeiJohoEntityGenerator.createDbT7055GappeiJohoEntity();
//            entity.initializeMd5();
//            GappeiJohoRelateEntity relateEntity = new GappeiJohoRelateEntity();
//            relateEntity.set合併情報Entity(entity);
//            GappeiJoho 合併情報 = new GappeiJoho(relateEntity);
//            合併情報 = 合併情報.createBuilderForEdit().set合併種類(new RString("2")).build();
//
//            assertThat(sut.save(合併情報), is(true));
//        }
//
//        @Test
//        public void updateに失敗するとfalseが返る() {
//
//            DbT7055GappeiJohoEntity entity = DbT7055GappeiJohoEntityGenerator.createDbT7055GappeiJohoEntity();
//            entity.initializeMd5();
//            GappeiJohoRelateEntity relateEntity = new GappeiJohoRelateEntity();
//            relateEntity.set合併情報Entity(entity);
//            GappeiJoho 合併情報 = new GappeiJoho(relateEntity);
//            合併情報 = 合併情報.createBuilderForEdit().set合併種類(new RString("3")).build();
//
//            assertThat(sut.save(合併情報), is(false));
//        }
//
        @Test
        public void deleteに成功するとtrueが返る() {

            TestSupport.insertDbT7055(主キー11, 主キー21);
            DbT7055GappeiJohoEntity entity = DbT7055GappeiJohoEntityGenerator.createDbT7055GappeiJohoEntity();
            entity.initializeMd5();
            GappeiJohoRelateEntity relateEntity = new GappeiJohoRelateEntity();
            relateEntity.set合併情報Entity(entity);
            GappeiJoho 合併情報 = new GappeiJoho(relateEntity);
            合併情報 = 合併情報.deleted();

            assertThat(sut.save(合併情報), is(true));
        }
//
//        @Test
//        public void deleteに失敗するとfalseが返る() {
//
//            DbT7055GappeiJohoEntity entity = DbT7055GappeiJohoEntityGenerator.createDbT7055GappeiJohoEntity();
//            entity.initializeMd5();
//            GappeiJohoRelateEntity relateEntity = new GappeiJohoRelateEntity();
//            relateEntity.set合併情報Entity(entity);
//            GappeiJoho 合併情報 = new GappeiJoho(relateEntity);
//            合併情報 = 合併情報.deleted();
//
//            assertThat(sut.save(合併情報), is(false));
//        }

//        @Test
//        public void 何も変更せずにsaveを呼び出すとfalseが返る() {
//            DbT7055GappeiJohoEntity entity = DbT7055GappeiJohoEntityGenerator.createDbT7055GappeiJohoEntity();
//            entity.initializeMd5();
//            GappeiJohoRelateEntity relateEntity = new GappeiJohoRelateEntity();
//            relateEntity.set合併情報Entity(entity);
//            GappeiJoho 合併情報 = new GappeiJoho(relateEntity);
//
//            assertThat(sut.save(合併情報), is(false));
//        }
        @After
        public void after() {
            sqlSession.rollbackWithoutDisconnect();
        }
    }

    private static class TestSupport {

        public static void insertDbT7055(
                FlexibleDate 主キー1,
                RString 主キー2) {
            DbT7055GappeiJohoEntity entity = DbT7055GappeiJohoEntityGenerator.createDbT7055GappeiJohoEntity();
            entity.setGappeiYMD(主キー1);
            entity.setChiikiNo(主キー2);
            entity.setState(EntityDataState.Added);
            dac.save(entity);
        }

        public static void clearTable() {
            CSVDataUtilForUseSession csvDataUtil = new CSVDataUtilForUseSession();
            csvDataUtil.clearTable(sqlSession, DbT7055GappeiJohoEntity.TABLE_NAME.toString());
        }

//        public static void insertDbT7056(
//                FlexibleDate 主キー1,
//                RString 主キー2) {
//            DbT7056GappeiShichosonEntity entity = DbT7056GappeiShichosonEntityGenerator.createDbT7056GappeiShichosonEntity();
//            entity.setGappeiYMD(主キー1);
//            entity.setChiikiNo(主キー2);
//            entity.setState(EntityDataState.Added);
//            合併市町村Dac.save(entity);
//        }
    }
}
