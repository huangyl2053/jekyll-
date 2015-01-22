/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
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
 *
 * @author N8187 久保田 英男
 */
@RunWith(Enclosed.class)
public class DbT7055GappeiJohoDacTest extends DbzTestDacBase {

    private static final FlexibleDate 合併年月日 = new FlexibleDate("20150101");
    private static final FlexibleDate 合併年月日2 = new FlexibleDate("20150102");
    private static DbT7055GappeiJohoDac sut;

    @BeforeClass
    public static void setUpClass() {
        sut = InstanceProvider.create(DbT7055GappeiJohoDac.class);
    }

    public static class selectByKeyのテスト extends DbzTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    合併年月日,
                    DEFAULT_地域番号);
            TestSupport.insert(
                    DEFAULT_合併年月日,
                    DEFAULT_地域番号);
        }

        @Test(expected = NullPointerException.class)
        public void 合併年月日がnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    null,
                    DEFAULT_地域番号);
        }

        @Test(expected = NullPointerException.class)
        public void 地域番号がnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    DEFAULT_合併年月日,
                    null);
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
                    合併年月日2,
                    DEFAULT_地域番号);
            assertThat(insertedRecord, is(nullValue()));
        }
    }

    public static class selectAllのテスト extends DbzTestDacBase {

        @Test
        public void 合併情報が存在する場合_selectAllは_全件を返す() {
            TestSupport.insert(
                    合併年月日,
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
            DbT7055GappeiJohoEntity updateRecord = DbT7055GappeiJohoEntityGenerator.createDbT7055GappeiJohoEntity();
            // TODO 主キー以外の項目を変更してください
            updateRecord.setGappeiShurui(new RString("2"));

            sut.update(updateRecord);

            DbT7055GappeiJohoEntity updatedRecord = sut.selectByKey(
                    DEFAULT_合併年月日,
                    DEFAULT_地域番号);

            assertThat(updateRecord.getGappeiShurui(), is(updatedRecord.getGappeiShurui()));
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
            sut.delete(sut.selectByKey(
                    DEFAULT_合併年月日,
                    DEFAULT_地域番号));
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
            sut.insert(entity);
        }
    }
}
