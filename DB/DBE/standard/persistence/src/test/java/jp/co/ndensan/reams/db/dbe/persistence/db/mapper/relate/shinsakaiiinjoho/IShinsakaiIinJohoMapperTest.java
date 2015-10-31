/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.shinsakaiiinjoho;

import jp.co.ndensan.reams.db.dbe.definition.mybatis.param.shinsakaiiinjoho.ShinsakaiIinJohoMapperParameter;
import jp.co.ndensan.reams.db.dbe.entity.db.basic.DbT5594ShinsakaiIinJohoEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.basic.DbT5595KaigoNinteiShinsakaiIinShozokuKikanJohoEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.basic.helper.DbT5594ShinsakaiIinJohoEntityGenerator;
import jp.co.ndensan.reams.db.dbe.entity.db.basic.helper.DbT5595KaigoNinteiShinsakaiIinShozokuKikanJohoEntityGenerator;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.shinsakaiiinjoho.shinsakaiiinjoho.ShinsakaiIinJohoEntity;
import jp.co.ndensan.reams.db.dbe.persistence.db.basic.DbT5594ShinsakaiIinJohoDac;
import jp.co.ndensan.reams.db.dbe.persistence.db.basic.DbT5595KaigoNinteiShinsakaiIinShozokuKikanJohoDac;
import jp.co.ndensan.reams.db.dbz.testhelper.DbeTestDacBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.testhelper.DbTestHelper;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import org.junit.AfterClass;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link IShinsakaiIinJohoMapper}のテストクラスです。
 */
@RunWith(Enclosed.class)
@Ignore
public class IShinsakaiIinJohoMapperTest {

    private static IShinsakaiIinJohoMapper sut;
    private static DbT5594ShinsakaiIinJohoDac 介護認定審査会委員情報Dac;
    private static DbT5595KaigoNinteiShinsakaiIinShozokuKikanJohoDac 介護認定審査会委員所属機関情報Dac;
    // TODO 主キー型と変数名と主キー値を適切な値に置換してください
    // TODO 主キーの数が足りない場合、追加してください。
    private static RString shinsakaiIinCode;
    private static DbT5594ShinsakaiIinJohoEntity dbT5594ShinsakaiIinJohoEntity;
    private static DbT5595KaigoNinteiShinsakaiIinShozokuKikanJohoEntity dbT5595KaigoNinteiShinsakaiIinShozokuKikanJohoEntity;
    private static DbTestHelper dbTestHelper;
    private static ShinsakaiIinJohoMapperParameter param;
    private static ShinsakaiIinJohoEntity result;

    @BeforeClass
    public static void setUpClass() {
        dbTestHelper = new DbTestHelper();
        shinsakaiIinCode = new RString("123456");
        DbeTestDacBase.setUpClassInternal();
    }

    @AfterClass
    public static void tearDownClass() {
        DbeTestDacBase.afterTearDownClass();
    }

// TODO 検索条件に合わせてのテストケースを追記して下さい。
    public static class get介護_DbT5594介護認定審査会委員情報Test extends DbeTestDacBase {

        @Before
        public void setUp() {
            dbTestHelper.truncateTable(sqlSession, DbT5594ShinsakaiIinJohoEntity.TABLE_NAME);
            sut = sqlSession.getMapper(IShinsakaiIinJohoMapper.class);

        }

        // TODO 見つかる場合、介護認定審査会委員情報Entityを構成している全てのEntityクラスについて特定項目を選択し、一致していることを確認するテストケースを記述して下さい。
        // TODO 個別のMapperのテストクラスで項目単位の転記処理を確認しているため、全項目について確認する必要はありません。
        @Test
        public void データが見つかる検索条件を渡すと_DbT5594介護認定審査会委員情報Entity返す() {
            TestSupport.insertDbT5594(shinsakaiIinCode);
            param = ShinsakaiIinJohoMapperParameter.createSelectByKeyParam(shinsakaiIinCode);
            result = sut.getShinsakaiIinJohoEntity(param);
            assertThat(result.get介護認定審査会委員情報Entity().getShinsakaiIinCode(), is(shinsakaiIinCode));
        }

        // データが見つからない値を指定するように修正してください。
        @Test
        public void データが見つかない検索条件を渡すと_DbT5594介護認定審査会委員情報nullを返す() {

            TestSupport.insertDbT5594(shinsakaiIinCode);
            param = ShinsakaiIinJohoMapperParameter.createSelectByKeyParam(shinsakaiIinCode);
            result = sut.getShinsakaiIinJohoEntity(param);
            assertThat(result, is(nullValue()));
        }
    }

    public static class get介護_DbT5595介護認定審査会委員所属機関情報Test extends DbeTestDacBase {

        @Before
        public void setUp() {
            dbTestHelper.truncateTable(sqlSession, DbT5594ShinsakaiIinJohoEntity.TABLE_NAME);
            dbTestHelper.truncateTable(sqlSession, DbT5595KaigoNinteiShinsakaiIinShozokuKikanJohoEntity.TABLE_NAME);
            sut = sqlSession.getMapper(IShinsakaiIinJohoMapper.class);

        }

        // TODO 見つかる場合、介護認定審査会委員情報Entityを構成している全てのEntityクラスについて特定項目を選択し、一致していることを確認するテストケースを記述して下さい。
        // TODO 個別のMapperのテストクラスで項目単位の転記処理を確認しているため、全項目について確認する必要はありません。
        @Test
        public void データが見つかる検索条件を渡すと_DbT5595介護認定審査会委員所属機関情報Entity返す() {
            TestSupport.insertDbT5594(shinsakaiIinCode);
            TestSupport.insertDbT5595(shinsakaiIinCode);
            param = ShinsakaiIinJohoMapperParameter.createSelectByKeyParam(shinsakaiIinCode);
            result = sut.getShinsakaiIinJohoEntity(param);
            assertThat(result.get介護認定審査会委員所属機関情報Entity().get(0).getShinsakaiIinCode(), is(shinsakaiIinCode));
        }

        // データが見つからない値を指定するように修正してください。
        @Test
        public void データが見つかない検索条件を渡すと_DbT5595介護認定審査会委員所属機関情報nullを返す() {

            TestSupport.insertDbT5594(shinsakaiIinCode);
            param = ShinsakaiIinJohoMapperParameter.createSelectByKeyParam(shinsakaiIinCode);
            result = sut.getShinsakaiIinJohoEntity(param);
            assertThat(result, is(nullValue()));
        }
    }

    // TODO 主キー型と変数名を適切な値に置換してください
    // TODO 主キーの数が足りない場合、追加してください。
    private static class TestSupport {

        public static void insertDbT5594(RString shinsakaiIinCode) {
            dbT5594ShinsakaiIinJohoEntity = DbT5594ShinsakaiIinJohoEntityGenerator.createDbT5594ShinsakaiIinJohoEntity();
            dbT5594ShinsakaiIinJohoEntity.setShinsakaiIinCode(shinsakaiIinCode);
            dbT5594ShinsakaiIinJohoEntity.setState(EntityDataState.Added);
            介護認定審査会委員情報Dac.save(dbT5594ShinsakaiIinJohoEntity);
        }

        public static void insertDbT5595(RString shinsakaiIinCode) {
            dbT5595KaigoNinteiShinsakaiIinShozokuKikanJohoEntity = DbT5595KaigoNinteiShinsakaiIinShozokuKikanJohoEntityGenerator.createDbT5595KaigoNinteiShinsakaiIinShozokuKikanJohoEntity();
            dbT5595KaigoNinteiShinsakaiIinShozokuKikanJohoEntity.setShinsakaiIinCode(shinsakaiIinCode);
            dbT5595KaigoNinteiShinsakaiIinShozokuKikanJohoEntity.setState(EntityDataState.Added);
            介護認定審査会委員所属機関情報Dac.save(dbT5595KaigoNinteiShinsakaiIinShozokuKikanJohoEntity);
        }
    }

}
