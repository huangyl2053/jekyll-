/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.basic;

import java.util.Collections;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT7102ZeiritsuJohoEntity;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT7102ZeiritsuJohoEntityGenerator;
import static jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT7102ZeiritsuJohoEntityGenerator.DEFAULT_終了年月;
import static jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT7102ZeiritsuJohoEntityGenerator.DEFAULT_開始年月;
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
 * {@link DbT7102ZeiritsuJohoDac}のテストです。
 *
 * @author LDNS 宋文娟
 */
@RunWith(Enclosed.class)
public class DbT7102ZeiritsuJohoDacTest extends DbzTestDacBase {

    private static final RString キー_01 = new RString("01");
    private static final RString キー_02 = new RString("02");
    private static final RString キー_03 = new RString("03");
    private static final FlexibleDate 開始年月 = new FlexibleDate("20140401");
    private static final FlexibleDate 開始年月20140403 = new FlexibleDate("20140403");
    private static DbT7102ZeiritsuJohoDac sut;

    @BeforeClass
    public static void setUpClass() {
        sut = InstanceProvider.create(DbT7102ZeiritsuJohoDac.class);
    }

    public static class selectByKeyのテスト extends DbzTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    開始年月,
                    DEFAULT_終了年月);
            TestSupport.insert(
                    DEFAULT_開始年月,
                    DEFAULT_終了年月);
        }

        @Test(expected = NullPointerException.class)
        public void 開始年月がnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    null,
                    DEFAULT_終了年月);
        }

        @Test(expected = NullPointerException.class)
        public void 終了年月がnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    DEFAULT_開始年月,
                    null);
        }

        @Test
        public void 存在する主キーを渡すと_selectByKeyは_該当のエンティティを返す() {
            DbT7102ZeiritsuJohoEntity insertedRecord = sut.selectByKey(
                    DEFAULT_開始年月,
                    DEFAULT_終了年月);
            assertThat(insertedRecord, is(notNullValue()));
        }

        @Test
        public void 存在しない主キーを渡すと_selectByKeyは_nullを返す() {
            DbT7102ZeiritsuJohoEntity insertedRecord = sut.selectByKey(
                    開始年月20140403,
                    DEFAULT_終了年月);
            assertThat(insertedRecord, is(nullValue()));
        }
    }

    public static class selectAllのテスト extends DbzTestDacBase {

        @Test
        public void 税率情報が存在する場合_selectAllは_全件を返す() {
            TestSupport.insert(
                    開始年月,
                    DEFAULT_終了年月);
            TestSupport.insert(
                    DEFAULT_開始年月,
                    DEFAULT_終了年月);
            assertThat(sut.selectAll().size(), is(2));
        }

        @Test
        public void 税率情報が存在しない場合_selectAllは_空のリストを返す() {
            assertThat(sut.selectAll(), is(Collections.EMPTY_LIST));
        }
    }

    public static class insertのテスト extends DbzTestDacBase {

        @Test
        public void 税率情報エンティティを渡すと_insertは_税率情報を追加する() {
            TestSupport.insert(
                    DEFAULT_開始年月,
                    DEFAULT_終了年月);

            assertThat(sut.selectByKey(
                    DEFAULT_開始年月,
                    DEFAULT_終了年月), is(notNullValue()));
        }
    }

    public static class updateのテスト extends DbzTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    DEFAULT_開始年月,
                    DEFAULT_終了年月);
        }

        @Test
        public void 税率情報エンティティを渡すと_updateは_税率情報を更新する() {
            DbT7102ZeiritsuJohoEntity updateRecord = DbT7102ZeiritsuJohoEntityGenerator.createDbT7102ZeiritsuJohoEntity();
            // TODO 主キー以外の項目を変更してください
            //updateRecord.set変更したい項目(75);

            sut.update(updateRecord);

            DbT7102ZeiritsuJohoEntity updatedRecord = sut.selectByKey(
                    DEFAULT_開始年月,
                    DEFAULT_終了年月);

            //assertThat(updateRecord.get変更したい項目(), is(updatedRecord.get変更したい項目()));
        }
    }

    public static class deleteのテスト extends DbzTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    DEFAULT_開始年月,
                    DEFAULT_終了年月);
        }

        @Test
        public void 税率情報エンティティを渡すと_deleteは_税率情報を削除する() {
            sut.delete(sut.selectByKey(
                    DEFAULT_開始年月,
                    DEFAULT_終了年月));
            assertThat(sut.selectByKey(
                    DEFAULT_開始年月,
                    DEFAULT_終了年月), is(nullValue()));
        }
    }

    private static class TestSupport {

        public static void insert(
                FlexibleDate 開始年月,
                FlexibleDate 終了年月) {
            DbT7102ZeiritsuJohoEntity entity = DbT7102ZeiritsuJohoEntityGenerator.createDbT7102ZeiritsuJohoEntity();
            entity.setZeiritsuKaishiYMD(開始年月);
            entity.setZeiritsuShuryoYMD(終了年月);
            sut.insert(entity);
        }
    }
}
