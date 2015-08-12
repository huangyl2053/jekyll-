/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.basic;

import java.util.Collections;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT7055GappeiJohoEntity;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT7055GappeiJohoEntityGenerator;
import static jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT7055GappeiJohoEntityGenerator.DEFAULT_合併年月日;
import static jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT7055GappeiJohoEntityGenerator.DEFAULT_地域番号;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestDacBase;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link DbT7055GappeiJohoDac}のテストです。
 */
@RunWith(Enclosed.class)
public class DbT7055GappeiJohoDacTest extends DbzTestDacBase {

    private static final RString キー_01 = new RString("01");
    private static final RString キー_02 = new RString("02");
    private static final RString キー_03 = new RString("03");
    private static DbT7055GappeiJohoDac sut;

    @BeforeClass
    public static void setUpClass() {
        sut = InstanceProvider.create(DbT7055GappeiJohoDac.class);
    }

    public static class selectByKeyのテスト extends DbzTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    DEFAULT_合併年月日,
                    DEFAULT_地域番号);
            TestSupport.insert(
                    DEFAULT_合併年月日,
                    DEFAULT_地域番号);
        }

        @Test(expected = NullPointerException.class)
        public void 合併年月日がnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    DEFAULT_合併年月日,
                    DEFAULT_地域番号);
        }

        @Test(expected = NullPointerException.class)
        public void 地域番号がnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    DEFAULT_合併年月日,
                    DEFAULT_地域番号);
        }

        @Test
        public void 存在する主キーを渡すと_selectByKeyは_該当のエンティティを返す() {
            DbT7055GappeiJohoEntity insertedRecord = sut.selectByKey(
                    DEFAULT_合併年月日,
                    DEFAULT_地域番号);
            assertThat(insertedRecord, is(notNullValue()));
        }

        @Test
        public void 存在しない主キーを渡すと_selectByKeyは_nullを返す() {
            DbT7055GappeiJohoEntity insertedRecord = sut.selectByKey(
                    DEFAULT_合併年月日,
                    DEFAULT_地域番号);
            assertThat(insertedRecord, is(nullValue()));
        }
    }

    public static class selectAllのテスト extends DbzTestDacBase {

        @Test
        public void 合併情報が存在する場合_selectAllは_全件を返す() {
            TestSupport.insert(
                    DEFAULT_合併年月日,
                    DEFAULT_地域番号);
            TestSupport.insert(
                    DEFAULT_合併年月日,
                    DEFAULT_地域番号);
            assertThat(sut.selectAll().size(), is(2));
        }

        @Test
        public void 合併情報が存在しない場合_selectAllは_空のリストを返す() {
            assertThat(sut.selectAll(), is(Collections.EMPTY_LIST));
        }
    }

    public static class insertのテスト extends DbzTestDacBase {

        @Test
        public void 合併情報エンティティを渡すと_insertは_合併情報を追加する() {
            TestSupport.insert(
                    DEFAULT_合併年月日,
                    DEFAULT_地域番号);

            assertThat(sut.selectByKey(
                    DEFAULT_合併年月日,
                    DEFAULT_地域番号), is(notNullValue()));
        }
    }

    public static class updateのテスト extends DbzTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    DEFAULT_合併年月日,
                    DEFAULT_地域番号);
        }

        @Test
        public void 合併情報エンティティを渡すと_updateは_合併情報を更新する() {
            DbT7055GappeiJohoEntity updateRecord = sut.selectByKey(
                    DEFAULT_合併年月日,
                    DEFAULT_地域番号);
            // TODO  主キー以外の項目を変更してください
            // updateRecord.set変更したい項目(75);

            sut.save(updateRecord);

            DbT7055GappeiJohoEntity updatedRecord = sut.selectByKey(
                    DEFAULT_合併年月日,
                    DEFAULT_地域番号);

            // TODO  主キー以外の項目を変更してください
            // assertThat(updateRecord.get変更したい項目(), is(updatedRecord.get変更したい項目()));
        }
    }

    public static class deleteのテスト extends DbzTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    DEFAULT_合併年月日,
                    DEFAULT_地域番号);
        }

        @Test
        public void 合併情報エンティティを渡すと_deleteは_合併情報を削除する() {
            DbT7055GappeiJohoEntity deletedEntity = sut.selectByKey(
                    DEFAULT_合併年月日,
                    DEFAULT_地域番号);
            deletedEntity.setState(EntityDataState.Deleted);

            sut.save(deletedEntity);

            assertThat(sut.selectByKey(
                    DEFAULT_合併年月日,
                    DEFAULT_地域番号), is(nullValue()));
        }
    }

    private static class TestSupport {

        public static void insert(
                FlexibleDate 合併年月日,
                RString 地域番号) {
            DbT7055GappeiJohoEntity entity = DbT7055GappeiJohoEntityGenerator.createDbT7055GappeiJohoEntity();
            entity.setGappeiYMD(合併年月日);
            entity.setChiikiNo(地域番号);
            sut.save(entity);
        }
    }
}
