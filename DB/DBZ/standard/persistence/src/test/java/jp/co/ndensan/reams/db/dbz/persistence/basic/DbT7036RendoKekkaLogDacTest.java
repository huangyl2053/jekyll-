/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.basic;

import java.util.Collections;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT7036RendoKekkaLogEntity;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT7036RendoKekkaLogEntityGenerator;
import static jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT7036RendoKekkaLogEntityGenerator.DEFAULT_処理番号;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestDacBase;
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
 * {@link DbT7036RendoKekkaLogDac}のテストです。
 *
 * @author LDNS 宋文娟
 */
@RunWith(Enclosed.class)
public class DbT7036RendoKekkaLogDacTest extends DbzTestDacBase {

    private static final RString キー_01 = new RString("01");
    private static final RString キー_02 = new RString("02");
    private static final RString キー_03 = new RString("03");
    private static final RString 処理番号 = new RString("2");
    private static final RString 処理番号3 = new RString("3");
    private static DbT7036RendoKekkaLogDac sut;

    @BeforeClass
    public static void setUpClass() {
        sut = InstanceProvider.create(DbT7036RendoKekkaLogDac.class);
    }

    public static class selectByKeyのテスト extends DbzTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    処理番号);
            TestSupport.insert(
                    DEFAULT_処理番号);
        }

        @Test(expected = NullPointerException.class)
        public void 処理番号がnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    null);
        }

        @Test
        public void 存在する主キーを渡すと_selectByKeyは_該当のエンティティを返す() {
            DbT7036RendoKekkaLogEntity insertedRecord = sut.selectByKey(
                    DEFAULT_処理番号);
            assertThat(insertedRecord, is(notNullValue()));
        }

        @Test
        public void 存在しない主キーを渡すと_selectByKeyは_nullを返す() {
            DbT7036RendoKekkaLogEntity insertedRecord = sut.selectByKey(
                    処理番号3);
            assertThat(insertedRecord, is(nullValue()));
        }
    }

    public static class selectAllのテスト extends DbzTestDacBase {

        @Test
        public void 連動結果ログが存在する場合_selectAllは_全件を返す() {
            TestSupport.insert(
                    処理番号);
            TestSupport.insert(
                    DEFAULT_処理番号);
            assertThat(sut.selectAll().size(), is(2));
        }

        @Test
        public void 連動結果ログが存在しない場合_selectAllは_空のリストを返す() {
            assertThat(sut.selectAll(), is(Collections.EMPTY_LIST));
        }
    }

    public static class insertのテスト extends DbzTestDacBase {

        @Test
        public void 連動結果ログエンティティを渡すと_insertは_連動結果ログを追加する() {
            TestSupport.insert(
                    DEFAULT_処理番号);

            assertThat(sut.selectByKey(
                    DEFAULT_処理番号), is(notNullValue()));
        }
    }

    public static class updateのテスト extends DbzTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    DEFAULT_処理番号);
        }

        @Test
        public void 連動結果ログエンティティを渡すと_updateは_連動結果ログを更新する() {
            DbT7036RendoKekkaLogEntity updateRecord = DbT7036RendoKekkaLogEntityGenerator.createDbT7036RendoKekkaLogEntity();
            // TODO 主キー以外の項目を変更してください
            //updateRecord.set変更したい項目(75);

            sut.update(updateRecord);

            DbT7036RendoKekkaLogEntity updatedRecord = sut.selectByKey(
                    DEFAULT_処理番号);

            //assertThat(updateRecord.get変更したい項目(), is(updatedRecord.get変更したい項目()));
        }
    }

    public static class deleteのテスト extends DbzTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    DEFAULT_処理番号);
        }

        @Test
        public void 連動結果ログエンティティを渡すと_deleteは_連動結果ログを削除する() {
            sut.delete(sut.selectByKey(
                    DEFAULT_処理番号));
            assertThat(sut.selectByKey(
                    DEFAULT_処理番号), is(nullValue()));
        }
    }

    private static class TestSupport {

        public static void insert(
                RString 処理番号) {
            DbT7036RendoKekkaLogEntity entity = DbT7036RendoKekkaLogEntityGenerator.createDbT7036RendoKekkaLogEntity();
            entity.setShoriNo(処理番号);
            sut.insert(entity);
        }
    }
}
