/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.gogitaijoho;

import jp.co.ndensan.reams.db.dbe.definition.mybatis.param.gogitaijoho.GogitaiJohoMapperParameter;
import jp.co.ndensan.reams.db.dbe.entity.db.basic.DbT5591GogitaiJohoEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.basic.DbT5592ShinsakaiKaisaiBashoJohoEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.basic.DbT5593GogitaiWariateIinJohoEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.basic.DbT5594ShinsakaiIinJohoEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.basic.helper.DbT5591GogitaiJohoEntityGenerator;
import jp.co.ndensan.reams.db.dbe.entity.db.basic.helper.DbT5592ShinsakaiKaisaiBashoJohoEntityGenerator;
import jp.co.ndensan.reams.db.dbe.entity.db.basic.helper.DbT5593GogitaiWariateIinJohoEntityGenerator;
import jp.co.ndensan.reams.db.dbe.entity.db.basic.helper.DbT5594ShinsakaiIinJohoEntityGenerator;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.gogitaijoho.gogitaijoho.GogitaiJohoRelateEntity;
import jp.co.ndensan.reams.db.dbe.persistence.db.basic.DbT5591GogitaiJohoDac;
import jp.co.ndensan.reams.db.dbe.persistence.db.basic.DbT5592ShinsakaiKaisaiBashoJohoDac;
import jp.co.ndensan.reams.db.dbe.persistence.db.basic.DbT5593GogitaiWariateIinJohoDac;
import jp.co.ndensan.reams.db.dbe.persistence.db.basic.DbT5594ShinsakaiIinJohoDac;
import jp.co.ndensan.reams.db.dbz.testhelper.DbeTestDacBase;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.testhelper.DbTestHelper;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import org.junit.AfterClass;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link IGogitaiJohoMapper}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class IGogitaiJohoMapperTest {

    private static IGogitaiJohoMapper sut;
    private static DbT5591GogitaiJohoDac 合議体情報Dac;
    private static DbT5592ShinsakaiKaisaiBashoJohoDac 介護認定審査会開催場所情報Dac;
    private static DbT5593GogitaiWariateIinJohoDac 合議体割当委員情報Dac;
    private static DbT5594ShinsakaiIinJohoDac 介護認定審査会委員情報Dac;
    private static DbT5591GogitaiJohoEntity dbT5591GogitaiJohoEntity;
    private static DbT5592ShinsakaiKaisaiBashoJohoEntity dbT5592ShinsakaiKaisaiBashoJohoEntity;
    private static DbT5593GogitaiWariateIinJohoEntity dbT5593GogitaiWariateIinJohoEntity;
    private static DbT5594ShinsakaiIinJohoEntity dbT5594ShinsakaiIinJohoEntity;
    private static int gogitaiNo;
    private static FlexibleDate gogitaiYukoKikanKaishiYMD;
    private static RString shinsakaiKaisaiBashoCode;
    private static DbTestHelper dbTestHelper;
    private static GogitaiJohoMapperParameter param;
    private static GogitaiJohoRelateEntity result;

    @BeforeClass
    public static void setUpClass() {
        dbTestHelper = new DbTestHelper();
        gogitaiNo = 1;
        gogitaiYukoKikanKaishiYMD = new FlexibleDate("2015");
        shinsakaiKaisaiBashoCode = new RString("123");
        DbeTestDacBase.setUpClassInternal();

    }

    @AfterClass
    public static void tearDownClass() {

        DbeTestDacBase.afterTearDownClass();
    }

// TODO 検索条件に合わせてのテストケースを追記して下さい。
    public static class get合議体情報_DbT5591合議体情報Test extends DbeTestDacBase {

        @Before
        public void setUp() {
            dbTestHelper.truncateTable(sqlSession, DbT5591GogitaiJohoEntity.TABLE_NAME);
            sut = sqlSession.getMapper(IGogitaiJohoMapper.class);
        }

        // TODO 見つかる場合、合議体情報Entityを構成している全てのEntityクラスについて特定項目を選択し、一致していることを確認するテストケースを記述して下さい。
        // TODO 個別のMapperのテストクラスで項目単位の転記処理を確認しているため、全項目について確認する必要はありません。
        @Test
        public void データが見つかる検索条件を渡すと_DbT5591合議体情報Entity返す() {
            TestSupport.insertDbT5591(gogitaiNo, gogitaiYukoKikanKaishiYMD, shinsakaiKaisaiBashoCode);
            param = GogitaiJohoMapperParameter.createSelectByKeyParam(gogitaiNo, gogitaiYukoKikanKaishiYMD, shinsakaiKaisaiBashoCode);
            result = sut.getGogitaiJohoRelateEntity(param);
            assertThat(result.get合議体情報Entity().getGogitaiNo(), is(gogitaiNo));
            assertThat(result.get合議体情報Entity().getGogitaiYukoKikanKaishiYMD(), is(gogitaiYukoKikanKaishiYMD));
            assertThat(result.get合議体情報Entity().getShinsakaiKaisaiBashoCode(), is(shinsakaiKaisaiBashoCode));

        }

        // データが見つからない値を指定するように修正してください。
        @Test
        public void データが見つかない検索条件を渡すと_DbT5591合議体情報nullを返す() {
            TestSupport.insertDbT5591(gogitaiNo, gogitaiYukoKikanKaishiYMD, shinsakaiKaisaiBashoCode);
            param = GogitaiJohoMapperParameter.createSelectByKeyParam(gogitaiNo, gogitaiYukoKikanKaishiYMD, shinsakaiKaisaiBashoCode);
            result = sut.getGogitaiJohoRelateEntity(param);
            assertThat(result, is(nullValue()));

        }
    }

    public static class get合議体情報_DbT5592合議体割当委員情報Test extends DbeTestDacBase {

        @Before
        public void setUp() {
            dbTestHelper.truncateTable(sqlSession, DbT5591GogitaiJohoEntity.TABLE_NAME);
            dbTestHelper.truncateTable(sqlSession, DbT5593GogitaiWariateIinJohoEntity.TABLE_NAME);
            sut = sqlSession.getMapper(IGogitaiJohoMapper.class);
        }

        // TODO 見つかる場合、合議体情報Entityを構成している全てのEntityクラスについて特定項目を選択し、一致していることを確認するテストケースを記述して下さい。
        // TODO 個別のMapperのテストクラスで項目単位の転記処理を確認しているため、全項目について確認する必要はありません。
        @Test
        public void データが見つかる検索条件を渡すと_DbT5592合議体割当委員情報Entity返す() {
            TestSupport.insertDbT5591(gogitaiNo, gogitaiYukoKikanKaishiYMD, shinsakaiKaisaiBashoCode);
            TestSupport.insertDbT5593(gogitaiNo, gogitaiYukoKikanKaishiYMD);
            param = GogitaiJohoMapperParameter.createSelectByKeyParam(gogitaiNo, gogitaiYukoKikanKaishiYMD, shinsakaiKaisaiBashoCode);
            result = sut.getGogitaiJohoRelateEntity(param);
            assertThat(result.get介護認定審査会開催場所情報Entity().get(0).getShinsakaiKaisaiBashoCode(), is(shinsakaiKaisaiBashoCode));

        }

        // データが見つからない値を指定するように修正してください。
        @Test
        public void データが見つかない検索条件を渡すと_DbT5592合議体割当委員情報nullを返す() {
            TestSupport.insertDbT5591(gogitaiNo, gogitaiYukoKikanKaishiYMD, shinsakaiKaisaiBashoCode);
            param = GogitaiJohoMapperParameter.createSelectByKeyParam(gogitaiNo, gogitaiYukoKikanKaishiYMD, shinsakaiKaisaiBashoCode);
            result = sut.getGogitaiJohoRelateEntity(param);
            assertThat(result, is(nullValue()));

        }
    }

    public static class get合議体情報_DbT5593介護認定審査会開催場所情報Test extends DbeTestDacBase {

        @Before
        public void setUp() {
            dbTestHelper.truncateTable(sqlSession, DbT5591GogitaiJohoEntity.TABLE_NAME);
            dbTestHelper.truncateTable(sqlSession, DbT5592ShinsakaiKaisaiBashoJohoEntity.TABLE_NAME);
            sut = sqlSession.getMapper(IGogitaiJohoMapper.class);
        }

        // TODO 見つかる場合、合議体情報Entityを構成している全てのEntityクラスについて特定項目を選択し、一致していることを確認するテストケースを記述して下さい。
        // TODO 個別のMapperのテストクラスで項目単位の転記処理を確認しているため、全項目について確認する必要はありません。
        @Test
        public void データが見つかる検索条件を渡すと_DbT5593介護認定審査会開催場所情報Entity返す() {
            TestSupport.insertDbT5591(gogitaiNo, gogitaiYukoKikanKaishiYMD, shinsakaiKaisaiBashoCode);
            TestSupport.insertDbT5592(shinsakaiKaisaiBashoCode);
            param = GogitaiJohoMapperParameter.createSelectByKeyParam(gogitaiNo, gogitaiYukoKikanKaishiYMD, shinsakaiKaisaiBashoCode);
            result = sut.getGogitaiJohoRelateEntity(param);
            assertThat(result.get介護認定審査会開催場所情報Entity().get(0).getShinsakaiKaisaiBashoCode(), is(shinsakaiKaisaiBashoCode));

        }

        // データが見つからない値を指定するように修正してください。
        @Test
        public void データが見つかない検索条件を渡すと_DbT5593介護認定審査会開催場所情報nullを返す() {
            TestSupport.insertDbT5591(gogitaiNo, gogitaiYukoKikanKaishiYMD, shinsakaiKaisaiBashoCode);
            param = GogitaiJohoMapperParameter.createSelectByKeyParam(gogitaiNo, gogitaiYukoKikanKaishiYMD, shinsakaiKaisaiBashoCode);
            result = sut.getGogitaiJohoRelateEntity(param);
            assertThat(result, is(nullValue()));

        }
    }

    public static class get合議体情報_DbT5594介護認定審査会委員情報Test extends DbeTestDacBase {

        @Before
        public void setUp() {
            dbTestHelper.truncateTable(sqlSession, DbT5593GogitaiWariateIinJohoEntity.TABLE_NAME);
            dbTestHelper.truncateTable(sqlSession, DbT5594ShinsakaiIinJohoEntity.TABLE_NAME);
            sut = sqlSession.getMapper(IGogitaiJohoMapper.class);
        }

        // TODO 見つかる場合、合議体情報Entityを構成している全てのEntityクラスについて特定項目を選択し、一致していることを確認するテストケースを記述して下さい。
        // TODO 個別のMapperのテストクラスで項目単位の転記処理を確認しているため、全項目について確認する必要はありません。
        @Test
        public void データが見つかる検索条件を渡すと_DbT5594介護認定審査会委員情報Entity返す() {
            TestSupport.insertDbT5593(gogitaiNo, gogitaiYukoKikanKaishiYMD);
            TestSupport.insertDbT5594(shinsakaiKaisaiBashoCode);
            param = GogitaiJohoMapperParameter.createSelectByKeyParam(gogitaiNo, gogitaiYukoKikanKaishiYMD, shinsakaiKaisaiBashoCode);
            result = sut.getGogitaiJohoRelateEntity(param);
            assertThat(result.get介護認定審査会開催場所情報Entity().get(0).getShinsakaiKaisaiBashoCode(), is(shinsakaiKaisaiBashoCode));

        }

        // データが見つからない値を指定するように修正してください。
        @Test
        public void データが見つかない検索条件を渡すと_DbT5594介護認定審査会委員情報nullを返す() {
            TestSupport.insertDbT5593(gogitaiNo, gogitaiYukoKikanKaishiYMD);
            param = GogitaiJohoMapperParameter.createSelectByKeyParam(gogitaiNo, gogitaiYukoKikanKaishiYMD, shinsakaiKaisaiBashoCode);
            result = sut.getGogitaiJohoRelateEntity(param);
            assertThat(result, is(nullValue()));

        }
    }

    // TODO 主キー型と変数名を適切な値に置換してください
    // TODO 主キーの数が足りない場合、追加してください。
    private static class TestSupport {

        public static void insertDbT5591(
                int gogitaiNo,
                FlexibleDate gogitaiYukoKikanKaishiYMD,
                RString shinsakaiKaisaiBashoCode) {
            dbT5591GogitaiJohoEntity = DbT5591GogitaiJohoEntityGenerator.createDbT5591GogitaiJohoEntity();
            dbT5591GogitaiJohoEntity.setGogitaiNo(gogitaiNo);
            dbT5591GogitaiJohoEntity.setGogitaiYukoKikanKaishiYMD(gogitaiYukoKikanKaishiYMD);
            dbT5591GogitaiJohoEntity.setShinsakaiKaisaiBashoCode(shinsakaiKaisaiBashoCode);
            dbT5591GogitaiJohoEntity.setState(EntityDataState.Added);
            合議体情報Dac.save(dbT5591GogitaiJohoEntity);
        }

        public static void insertDbT5592(RString shinsakaiKaisaiBashoCode) {
            dbT5592ShinsakaiKaisaiBashoJohoEntity = DbT5592ShinsakaiKaisaiBashoJohoEntityGenerator.createDbT5592ShinsakaiKaisaiBashoJohoEntity();
            dbT5592ShinsakaiKaisaiBashoJohoEntity.setShinsakaiKaisaiBashoCode(shinsakaiKaisaiBashoCode);
            dbT5592ShinsakaiKaisaiBashoJohoEntity.setState(EntityDataState.Added);
            介護認定審査会開催場所情報Dac.save(dbT5592ShinsakaiKaisaiBashoJohoEntity);
        }

        public static void insertDbT5593(
                int gogitaiNo,
                FlexibleDate gogitaiYukoKikanKaishiYMD) {
            dbT5593GogitaiWariateIinJohoEntity = DbT5593GogitaiWariateIinJohoEntityGenerator.createDbT5593GogitaiWariateIinJohoEntity();
            dbT5593GogitaiWariateIinJohoEntity.setGogitaiNo(gogitaiNo);
            dbT5593GogitaiWariateIinJohoEntity.setGogitaiYukoKikanKaishiYMD(gogitaiYukoKikanKaishiYMD);
            dbT5593GogitaiWariateIinJohoEntity.setState(EntityDataState.Added);
            合議体割当委員情報Dac.save(dbT5593GogitaiWariateIinJohoEntity);
        }

        public static void insertDbT5594(RString shinsakaiIinCode) {
            dbT5594ShinsakaiIinJohoEntity = DbT5594ShinsakaiIinJohoEntityGenerator.createDbT5594ShinsakaiIinJohoEntity();
            dbT5594ShinsakaiIinJohoEntity.setShinsakaiIinCode(shinsakaiIinCode);
            dbT5594ShinsakaiIinJohoEntity.setState(EntityDataState.Added);
            介護認定審査会委員情報Dac.save(dbT5594ShinsakaiIinJohoEntity);
        }
    }

}
