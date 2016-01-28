/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.gogitaijoho.gogitaijoho;

import jp.co.ndensan.reams.db.dbe.definition.mybatis.param.gogitaijoho.gogitaijoho.GogitaiJohoMapperParameter;
import jp.co.ndensan.reams.db.dbe.entity.db.basic.DbT5591GogitaiJohoEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.basic.DbT5592ShinsakaiKaisaiBashoJohoEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.basic.DbT5593GogitaiWariateIinJohoEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.basic.DbT5594ShinsakaiIinJohoEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.basic.helper.DbT5591GogitaiJohoEntityGenerator;
import jp.co.ndensan.reams.db.dbe.entity.db.basic.helper.DbT5592ShinsakaiKaisaiBashoJohoEntityGenerator;
import jp.co.ndensan.reams.db.dbe.entity.db.basic.helper.DbT5593GogitaiWariateIinJohoEntityGenerator;
import jp.co.ndensan.reams.db.dbe.entity.db.basic.helper.DbT5594ShinsakaiIinJohoEntityGenerator;
import jp.co.ndensan.reams.db.dbe.persistence.db.basic.DbT5591GogitaiJohoDac;
import jp.co.ndensan.reams.db.dbe.persistence.db.basic.DbT5592ShinsakaiKaisaiBashoJohoDac;
import jp.co.ndensan.reams.db.dbe.persistence.db.basic.DbT5593GogitaiWariateIinJohoDac;
import jp.co.ndensan.reams.db.dbe.persistence.db.basic.DbT5594ShinsakaiIinJohoDac;
import jp.co.ndensan.reams.db.dbz.testhelper.DbeTestDacBase;
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
 * {@link IGogitaiJohoMapper}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class IGogitaiJohoMapperTest extends DbeTestDacBase {

    private static IGogitaiJohoMapper sut;
    private static DbT5591GogitaiJohoDac 合議体情報Dac;
    private static DbT5592ShinsakaiKaisaiBashoJohoDac 介護認定審査会開催場所情報Dac;
    private static DbT5593GogitaiWariateIinJohoDac 合議体割当委員情報Dac;
    private static DbT5594ShinsakaiIinJohoDac 介護認定審査会委員情報Dac;
    private static final int gogitaiNo = DbT5593GogitaiWariateIinJohoEntityGenerator.DEFAULT_合議体番号;
    private static final FlexibleDate gogitaiYukoKikanKaishiYMD = DbT5593GogitaiWariateIinJohoEntityGenerator.DEFAULT_合議体有効期間開始年月日;
    private static final RString shinsakaiIinCode = DbT5593GogitaiWariateIinJohoEntityGenerator.DEFAULT_介護認定審査会委員コード;

    @BeforeClass
    public static void setUpClass() {
        合議体情報Dac = InstanceProvider.create(DbT5591GogitaiJohoDac.class);
        介護認定審査会開催場所情報Dac = InstanceProvider.create(DbT5592ShinsakaiKaisaiBashoJohoDac.class);
        合議体割当委員情報Dac = InstanceProvider.create(DbT5593GogitaiWariateIinJohoDac.class);
        介護認定審査会委員情報Dac = InstanceProvider.create(DbT5594ShinsakaiIinJohoDac.class);
    }

    public static class select合議体情報ByKeyTest extends DbeTestDacBase {

        @Before
        public void setUp() {
            sut = sqlSession.getMapper(IGogitaiJohoMapper.class);
            TestSupport.insertDbT5591(gogitaiNo, gogitaiYukoKikanKaishiYMD);

            TestSupport.insertDbT5592(shinsakaiIinCode);

            TestSupport.insertDbT5593(gogitaiNo, gogitaiYukoKikanKaishiYMD, shinsakaiIinCode);
            TestSupport.insertDbT5594(shinsakaiIinCode);
        }

        @Test
        public void データが見つかる検索条件を渡すと_合議体情報Entity返す() {
            GogitaiJohoMapperParameter 合議体情報検索条件 = GogitaiJohoMapperParameter.createSelectByKeyParam(gogitaiNo, gogitaiYukoKikanKaishiYMD);
            assertThat(sut.select合議体情報ByKey(合議体情報検索条件).get合議体情報Entity().getGogitaiNo(), is(gogitaiNo));
        }

        @Test
        public void データが見つかない検索条件を渡すと_nullを返す() {
            GogitaiJohoMapperParameter 合議体情報検索条件 = GogitaiJohoMapperParameter.createSelectByKeyParam(2, gogitaiYukoKikanKaishiYMD);
            assertThat(sut.select合議体情報ByKey(合議体情報検索条件), is(nullValue()));
        }

        @After
        public void after() {
            rollBackAndCloseSession();
        }
    }

//// TODO 検索条件に合わせてのテストケースを追記して下さい。
//    public static class select合議体情報一覧By主キーTest extends DbeTestDacBase {
//
//        @Before
//        public void setUp() {
//            sut = sqlSession.getMapper(IGogitaiJohoMapper.class);
//            TestSupport.insertDbT5591(主キー11, 主キー21);
//            TestSupport.insertDbT5591(主キー11, 主キー22);
//            TestSupport.insertDbT5591(主キー12, 主キー21);
//            TestSupport.insertDbT5591(主キー12, 主キー22);
//
//            TestSupport.insertDbT5592(主キー11, 主キー21);
//            TestSupport.insertDbT5592(主キー11, 主キー22);
//            TestSupport.insertDbT5592(主キー12, 主キー21);
//            TestSupport.insertDbT5592(主キー12, 主キー22);
//
//            TestSupport.insert(主キー11, 主キー21);
//            TestSupport.insert(主キー11, 主キー22);
//            TestSupport.insert(主キー12, 主キー21);
//            TestSupport.insert(主キー12, 主キー22);
//        }
//
//        @Test
//        public void データが見つかる検索条件を渡すと_台帳Entityリストを返す() {
//            GogitaiJohoMapperParameter 合議体情報検索条件 = GogitaiJohoMapperParameter.createXXXParam(主キー11);
//            List<GogitaiJohoEntity> entityList = sut.select合議体情報一覧By主キー(合議体情報検索条件);
//            assertThat(entityList.size(), is(2));
//            // 任意の項目が一致するテストケースを記述してください。
//            assertThat(entityList.get(0).getXXXEntity().get主キー型1(), is(主キー11));
//            assertThat(entityList.get(1).getXXXEntity().get主キー型1(), is(主キー11));
//        }
//
//        @Test
//        public void データが見つかない検索条件を渡すと__空のリストを返す() {
//        GogitaiJohoMapperParameter 合議体情報検索条件 = GogitaiJohoMapperParameter.createXXXParam(new 主キー型1());
//            assertThat(sut.select合議体情報一覧By主キー(合議体情報検索条件).isEmpty(), is(true));
//        }
//    }
    private static class TestSupport {

        public static void insertDbT5591(
                int gogitaiNo,
                FlexibleDate gogitaiYukoKikanKaishiYMD) {
            DbT5591GogitaiJohoEntity entity = DbT5591GogitaiJohoEntityGenerator.createDbT5591GogitaiJohoEntity();
            entity.setGogitaiNo(gogitaiNo);
            entity.setGogitaiYukoKikanKaishiYMD(gogitaiYukoKikanKaishiYMD);
            entity.setState(EntityDataState.Added);
            合議体情報Dac.save(entity);
        }

        public static void insertDbT5592(
                RString shinsakaiKaisaiBashoCode) {
            DbT5592ShinsakaiKaisaiBashoJohoEntity entity = DbT5592ShinsakaiKaisaiBashoJohoEntityGenerator.createDbT5592ShinsakaiKaisaiBashoJohoEntity();
            entity.setShinsakaiKaisaiBashoCode(shinsakaiKaisaiBashoCode);
            entity.setState(EntityDataState.Added);
            介護認定審査会開催場所情報Dac.save(entity);
        }

        public static void insertDbT5593(
                int gogitaiNo,
                FlexibleDate gogitaiYukoKikanKaishiYMD,
                RString shinsakaiIinCode) {
            DbT5593GogitaiWariateIinJohoEntity entity = DbT5593GogitaiWariateIinJohoEntityGenerator.createDbT5593GogitaiWariateIinJohoEntity();
            entity.setGogitaiNo(gogitaiNo);
            entity.setGogitaiYukoKikanKaishiYMD(gogitaiYukoKikanKaishiYMD);
            entity.setShinsakaiIinCode(shinsakaiIinCode);
            entity.setState(EntityDataState.Added);
            合議体割当委員情報Dac.save(entity);
        }

        public static void insertDbT5594(
                RString shinsakaiIinCode) {
            DbT5594ShinsakaiIinJohoEntity entity = DbT5594ShinsakaiIinJohoEntityGenerator.createDbT5594ShinsakaiIinJohoEntity();
            entity.setShinsakaiIinCode(shinsakaiIinCode);
            entity.setState(EntityDataState.Added);
            介護認定審査会委員情報Dac.save(entity);
        }
    }

}
