/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.persistence.db.mapper.relate.kaigojigyosha;

import jp.co.ndensan.reams.db.dbx.definition.mybatis.param.KaigoJigyosha.KaigoJigyoshaMapperParameter;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.kaigojigyosha.DbT7060KaigoJigyoshaEntity;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.kaigojigyosha.DbT7062KaigoJigyoshaDaihyoshaEntity;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.kaigojigyosha.DbT7063KaigoJigyoshaShiteiServiceEntity;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.helper.DbT7060KaigoJigyoshaEntityGenerator;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.helper.DbT7062KaigoJigyoshaDaihyoshaEntityGenerator;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.helper.DbT7063KaigoJigyoshaShiteiServiceEntityGenerator;
import jp.co.ndensan.reams.db.dbx.entity.db.relate.kaigojigyosha.kaigojigyosha.KaigoJigyoshaEntity;
import jp.co.ndensan.reams.db.dbx.persistence.db.basic.DbT7060KaigoJigyoshaDac;
import jp.co.ndensan.reams.db.dbx.persistence.db.basic.DbT7062KaigoJigyoshaDaihyoshaDac;
import jp.co.ndensan.reams.db.dbx.persistence.db.basic.DbT7063KaigoJigyoshaShiteiServiceDac;
import jp.co.ndensan.reams.db.dbx.testhelper.DbxTestDacBase;
import jp.co.ndensan.reams.uz.uza.biz.KaigoJigyoshaNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.testhelper.DbTestHelper;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link IKaigoJigyoshaMapper}のテストクラスです。
 */
@Ignore
@RunWith(Enclosed.class)
public class IKaigoJigyoshaMapperTest {

    private static IKaigoJigyoshaMapper sut;
    private static DbT7060KaigoJigyoshaDac 介護事業者Dac;
    private static DbT7062KaigoJigyoshaDaihyoshaDac 介護事業者代表者Dac;
    private static DbT7063KaigoJigyoshaShiteiServiceDac 介護事業者指定サービスDac;
    private static KaigoJigyoshaEntity result;
    private static KaigoJigyoshaNo jigyoshaNo;
    private static FlexibleDate yukoKaishiYMD;
    private static DbTestHelper dbTestHelper;
    private static KaigoJigyoshaMapperParameter param;

    @BeforeClass
    public static void setUpClass() {
        dbTestHelper = new DbTestHelper();
        jigyoshaNo = new KaigoJigyoshaNo("0123400001");
        yukoKaishiYMD = new FlexibleDate("20150220");
        DbxTestDacBase.setUpClassInternal();
    }

    public static class DbT7060Test extends DbxTestDacBase {

        @Before
        public void setUp() {
            dbTestHelper.truncateTable(sqlSession, DbT7060KaigoJigyoshaEntity.TABLE_NAME);
            sut = sqlSession.getMapper(IKaigoJigyoshaMapper.class);

        }

        @Test
        public void データが見つかる検索条件を渡すと_介護事業者Entity返す() {
            TestSupport.insertDbT7060(jigyoshaNo, yukoKaishiYMD);
            param = KaigoJigyoshaMapperParameter.createSelectByKeyParam(jigyoshaNo, yukoKaishiYMD);
            result = sut.getKaigoJigyoshaEntity(param);
            assertThat(result.get介護事業者Entity().getJigyoshaNo(), is(jigyoshaNo));
            assertThat(result.get介護事業者Entity().getYukoKaishiYMD(), is(yukoKaishiYMD));

        }

        @Test
        public void データが見つかない検索条件を渡すと_nullを返す() {
            TestSupport.insertDbT7060(jigyoshaNo, yukoKaishiYMD);
            param = KaigoJigyoshaMapperParameter.createSelectByKeyParam(new KaigoJigyoshaNo("01234001"), yukoKaishiYMD);
            result = sut.getKaigoJigyoshaEntity(param);
            assertThat(result.get介護事業者Entity(), is(nullValue()));
        }
    }

    public static class DbT7062Test extends DbxTestDacBase {

        @Before
        public void setUp() {
            dbTestHelper.truncateTable(sqlSession, DbT7062KaigoJigyoshaDaihyoshaEntity.TABLE_NAME);
            dbTestHelper.truncateTable(sqlSession, DbT7060KaigoJigyoshaEntity.TABLE_NAME);

            sut = sqlSession.getMapper(IKaigoJigyoshaMapper.class);

        }

        @Test
        public void データが見つかる検索条件を渡すと_台帳Entityリストを返す() {
            TestSupport.insertDbT7062(jigyoshaNo, yukoKaishiYMD);
            TestSupport.insertDbT7060(jigyoshaNo, yukoKaishiYMD);

            param = KaigoJigyoshaMapperParameter.createSelectByKeyParam(jigyoshaNo, yukoKaishiYMD);
            result = sut.getKaigoJigyoshaEntity(param);
            assertThat(result.get介護事業者代表者Entity().get(0).getJigyoshaNo(), is(jigyoshaNo));
            assertThat(result.get介護事業者代表者Entity().get(0).getYukoKaishiYMD(), is(yukoKaishiYMD));
        }

        @Test
        public void データが見つかない検索条件を渡すと__空のリストを返す() {
            TestSupport.insertDbT7060(jigyoshaNo, yukoKaishiYMD);

            param = KaigoJigyoshaMapperParameter.createSelectByKeyParam(jigyoshaNo, yukoKaishiYMD);
            result = sut.getKaigoJigyoshaEntity(param);
            assertThat(result.get介護事業者代表者Entity(), is(nullValue()));

        }
    }

    public static class DbT7063Test extends DbxTestDacBase {

        @Before
        public void setUp() {
            dbTestHelper.truncateTable(sqlSession, DbT7063KaigoJigyoshaShiteiServiceEntity.TABLE_NAME);
            dbTestHelper.truncateTable(sqlSession, DbT7060KaigoJigyoshaEntity.TABLE_NAME);

            sut = sqlSession.getMapper(IKaigoJigyoshaMapper.class);

        }

        @Test
        public void データが見つかる検索条件を渡すと_台帳Entityリストを返す() {
            TestSupport.insertDbT7063(jigyoshaNo, yukoKaishiYMD);
            TestSupport.insertDbT7060(jigyoshaNo, yukoKaishiYMD);

            param = KaigoJigyoshaMapperParameter.createSelectByKeyParam(jigyoshaNo, yukoKaishiYMD);
            result = sut.getKaigoJigyoshaEntity(param);
            assertThat(result.get介護事業者指定サービスEntity().get(0).getJigyoshaNo(), is(jigyoshaNo));
            assertThat(result.get介護事業者指定サービスEntity().get(0).getYukoKaishiYMD(), is(yukoKaishiYMD));
        }

        @Test
        public void データが見つかない検索条件を渡すと__空のリストを返す() {
            TestSupport.insertDbT7060(jigyoshaNo, yukoKaishiYMD);

            param = KaigoJigyoshaMapperParameter.createSelectByKeyParam(jigyoshaNo, yukoKaishiYMD);
            result = sut.getKaigoJigyoshaEntity(param);
            assertThat(result.get介護事業者指定サービスEntity(), is(nullValue()));

        }
    }

    private static class TestSupport {

        public static void insertDbT7060(
                KaigoJigyoshaNo 主キー1,
                FlexibleDate 主キー2) {
            DbT7060KaigoJigyoshaEntity entity = DbT7060KaigoJigyoshaEntityGenerator.createDbT7060KaigoJigyoshaEntity();
            entity.setJigyoshaNo(主キー1);
            entity.setYukoKaishiYMD(主キー2);
            entity.setState(EntityDataState.Added);
            介護事業者Dac.save(entity);
        }

        public static void insertDbT7062(
                KaigoJigyoshaNo 主キー1,
                FlexibleDate 主キー2) {
            DbT7062KaigoJigyoshaDaihyoshaEntity entity = DbT7062KaigoJigyoshaDaihyoshaEntityGenerator.createDbT7062KaigoJigyoshaDaihyoshaEntity();
            entity.setJigyoshaNo(主キー1);
            entity.setYukoKaishiYMD(主キー2);
            entity.setState(EntityDataState.Added);
            介護事業者代表者Dac.save(entity);
        }

        public static void insertDbT7063(
                KaigoJigyoshaNo 主キー1,
                FlexibleDate 主キー2) {
            DbT7063KaigoJigyoshaShiteiServiceEntity entity = DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.createDbT7063KaigoJigyoshaShiteiServiceEntity();
            entity.setJigyoshaNo(主キー1);
            entity.setYukoKaishiYMD(主キー2);
            entity.setState(EntityDataState.Added);
            介護事業者指定サービスDac.save(entity);
        }
    }

}
