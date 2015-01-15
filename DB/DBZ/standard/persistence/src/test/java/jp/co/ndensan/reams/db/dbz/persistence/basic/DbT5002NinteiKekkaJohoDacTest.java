/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.basic;

import java.util.Collections;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT5002NinteiKekkaJohoEntity;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT5002NinteiKekkaJohoEntityGenerator;
import static jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT5002NinteiKekkaJohoEntityGenerator.*;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestDacBase;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.CoreMatchers.nullValue;
import org.junit.Test;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link DbT5002NinteiKekkaJohoDac}のテストです。
 *
 * @author n8187 久保田 英男
 */
@RunWith(Enclosed.class)
public class DbT5002NinteiKekkaJohoDacTest extends DbzTestDacBase {

    private static DbT5002NinteiKekkaJohoDac sut;

    @BeforeClass
    public static void setUpClass() {
        sut = InstanceProvider.create(DbT5002NinteiKekkaJohoDac.class);
    }

    public static class selectByKeyのテスト extends DbzTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    DEFAULT_申請書管理番号,
                    DEFAULT_処理日時);
        }

        @Test(expected = NullPointerException.class)
        public void 申請書管理番号がnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    null,
                    DEFAULT_処理日時);
        }

        @Test(expected = NullPointerException.class)
        public void 処理日時がnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    DEFAULT_申請書管理番号,
                    null);
        }

        @Test
        public void 存在する主キーを渡すと_selectByKeyは_該当のエンティティを返す() {
            DbT5002NinteiKekkaJohoEntity insertedRecord = sut.selectByKey(
                    DEFAULT_申請書管理番号,
                    DEFAULT_処理日時);
            assertThat(insertedRecord, is(notNullValue()));
        }

        @Test
        public void 存在しない主キーを渡すと_selectByKeyは_nullを返す() {
            DbT5002NinteiKekkaJohoEntity insertedRecord = sut.selectByKey(
                    new RString("1234567891"),
                    DEFAULT_処理日時);
            assertThat(insertedRecord, is(nullValue()));
        }
    }

    public static class selectAllのテスト extends DbzTestDacBase {

        @Test
        public void 要介護認定結果情報が存在する場合_selectAllは_全件を返す() {
            TestSupport.insert(
                    DEFAULT_申請書管理番号,
                    DEFAULT_処理日時);
            assertThat(sut.selectAll().size(), is(1));
        }

        @Test
        public void 要介護認定結果情報が存在しない場合_selectAllは_空のリストを返す() {
            assertThat(sut.selectAll(), is(Collections.EMPTY_LIST));
        }
    }

    public static class insertのテスト extends DbzTestDacBase {

        @Test
        public void 要介護認定結果情報エンティティを渡すと_insertは_要介護認定結果情報を追加する() {
            TestSupport.insert(
                    DEFAULT_申請書管理番号,
                    DEFAULT_処理日時);

            assertThat(sut.selectByKey(
                    DEFAULT_申請書管理番号,
                    DEFAULT_処理日時), is(notNullValue()));
        }
    }

    public static class updateのテスト extends DbzTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    DEFAULT_申請書管理番号,
                    DEFAULT_処理日時);
        }

        @Test
        public void 要介護認定結果情報エンティティを渡すと_updateは_要介護認定結果情報を更新する() {
            DbT5002NinteiKekkaJohoEntity updateRecord = DbT5002NinteiKekkaJohoEntityGenerator.createDbT5002NinteiKekkaJohoEntity();
            updateRecord.setNinteiYukoKikan(75);

            sut.update(updateRecord);

            DbT5002NinteiKekkaJohoEntity updatedRecord = sut.selectByKey(
                    DEFAULT_申請書管理番号,
                    DEFAULT_処理日時);

            assertThat(updateRecord.getNinteiYukoKikan(), is(updatedRecord.getNinteiYukoKikan()));
        }
    }

    public static class deleteのテスト extends DbzTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    DEFAULT_申請書管理番号,
                    DEFAULT_処理日時);
        }

        @Test
        public void 要介護認定結果情報エンティティを渡すと_deleteは_要介護認定結果情報を削除する() {
            sut.delete(sut.selectByKey(
                    DEFAULT_申請書管理番号,
                    DEFAULT_処理日時));
            assertThat(sut.selectByKey(
                    DEFAULT_申請書管理番号,
                    DEFAULT_処理日時), is(nullValue()));
        }
    }

    private static class TestSupport {

        public static void insert(
                RString 申請書管理番号,
                YMDHMS 処理日時) {
            DbT5002NinteiKekkaJohoEntity entity = DbT5002NinteiKekkaJohoEntityGenerator.createDbT5002NinteiKekkaJohoEntity();
            entity.setShinseishoKanriNo(申請書管理番号);
            entity.setShoriTimestamp(処理日時);
            sut.insert(entity);
        }
    }
}
