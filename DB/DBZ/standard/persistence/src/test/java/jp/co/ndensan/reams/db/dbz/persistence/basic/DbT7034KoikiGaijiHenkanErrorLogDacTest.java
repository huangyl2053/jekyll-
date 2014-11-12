/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.basic;

import java.util.Collections;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT7034KoikiGaijiHenkanErrorLogEntity;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT7034KoikiGaijiHenkanErrorLogEntityGenerator;
import static jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT7034KoikiGaijiHenkanErrorLogEntityGenerator.DEFAULT_エラー表示連番;
import static jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT7034KoikiGaijiHenkanErrorLogEntityGenerator.DEFAULT_処理番号;
import static jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT7034KoikiGaijiHenkanErrorLogEntityGenerator.DEFAULT_連番;
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
 * {@link DbT7034KoikiGaijiHenkanErrorLogDac}のテストです。
 *
 * @author LDNS 宋文娟
 */
@RunWith(Enclosed.class)
public class DbT7034KoikiGaijiHenkanErrorLogDacTest extends DbzTestDacBase {

    private static final RString キー_01 = new RString("01");
    private static final RString キー_02 = new RString("02");
    private static final RString キー_03 = new RString("03");
    private static final RString 処理番号 = new RString("2");
    private static final RString 処理番号3 = new RString("3");
    private static DbT7034KoikiGaijiHenkanErrorLogDac sut;

    @BeforeClass
    public static void setUpClass() {
        sut = InstanceProvider.create(DbT7034KoikiGaijiHenkanErrorLogDac.class);
    }

    public static class selectByKeyのテスト extends DbzTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    処理番号,
                    DEFAULT_連番,
                    DEFAULT_エラー表示連番);
            TestSupport.insert(
                    DEFAULT_処理番号,
                    DEFAULT_連番,
                    DEFAULT_エラー表示連番);
        }

        @Test(expected = NullPointerException.class)
        public void 処理番号がnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    null,
                    DEFAULT_連番,
                    DEFAULT_エラー表示連番);
        }

        @Test(expected = NullPointerException.class)
        public void 連番がnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    DEFAULT_処理番号,
                    null,
                    DEFAULT_エラー表示連番);
        }

        @Test(expected = NullPointerException.class)
        public void エラー表示連番がnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    DEFAULT_処理番号,
                    DEFAULT_連番,
                    null);
        }

        @Test
        public void 存在する主キーを渡すと_selectByKeyは_該当のエンティティを返す() {
            DbT7034KoikiGaijiHenkanErrorLogEntity insertedRecord = sut.selectByKey(
                    DEFAULT_処理番号,
                    DEFAULT_連番,
                    DEFAULT_エラー表示連番);
            assertThat(insertedRecord, is(notNullValue()));
        }

        @Test
        public void 存在しない主キーを渡すと_selectByKeyは_nullを返す() {
            DbT7034KoikiGaijiHenkanErrorLogEntity insertedRecord = sut.selectByKey(
                    処理番号3,
                    DEFAULT_連番,
                    DEFAULT_エラー表示連番);
            assertThat(insertedRecord, is(nullValue()));
        }
    }

    public static class selectAllのテスト extends DbzTestDacBase {

        @Test
        public void 広域外字変換エラーログが存在する場合_selectAllは_全件を返す() {
            TestSupport.insert(
                    処理番号,
                    DEFAULT_連番,
                    DEFAULT_エラー表示連番);
            TestSupport.insert(
                    DEFAULT_処理番号,
                    DEFAULT_連番,
                    DEFAULT_エラー表示連番);
            assertThat(sut.selectAll().size(), is(2));
        }

        @Test
        public void 広域外字変換エラーログが存在しない場合_selectAllは_空のリストを返す() {
            assertThat(sut.selectAll(), is(Collections.EMPTY_LIST));
        }
    }

    public static class insertのテスト extends DbzTestDacBase {

        @Test
        public void 広域外字変換エラーログエンティティを渡すと_insertは_広域外字変換エラーログを追加する() {
            TestSupport.insert(
                    DEFAULT_処理番号,
                    DEFAULT_連番,
                    DEFAULT_エラー表示連番);

            assertThat(sut.selectByKey(
                    DEFAULT_処理番号,
                    DEFAULT_連番,
                    DEFAULT_エラー表示連番), is(notNullValue()));
        }
    }

    public static class updateのテスト extends DbzTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    DEFAULT_処理番号,
                    DEFAULT_連番,
                    DEFAULT_エラー表示連番);
        }

        @Test
        public void 広域外字変換エラーログエンティティを渡すと_updateは_広域外字変換エラーログを更新する() {
            DbT7034KoikiGaijiHenkanErrorLogEntity updateRecord = DbT7034KoikiGaijiHenkanErrorLogEntityGenerator.createDbT7034KoikiGaijiHenkanErrorLogEntity();
            // TODO 主キー以外の項目を変更してください
            //updateRecord.set変更したい項目(75);

            sut.update(updateRecord);

            DbT7034KoikiGaijiHenkanErrorLogEntity updatedRecord = sut.selectByKey(
                    DEFAULT_処理番号,
                    DEFAULT_連番,
                    DEFAULT_エラー表示連番);

            //assertThat(updateRecord.get変更したい項目(), is(updatedRecord.get変更したい項目()));
        }
    }

    public static class deleteのテスト extends DbzTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    DEFAULT_処理番号,
                    DEFAULT_連番,
                    DEFAULT_エラー表示連番);
        }

        @Test
        public void 広域外字変換エラーログエンティティを渡すと_deleteは_広域外字変換エラーログを削除する() {
            sut.delete(sut.selectByKey(
                    DEFAULT_処理番号,
                    DEFAULT_連番,
                    DEFAULT_エラー表示連番));
            assertThat(sut.selectByKey(
                    DEFAULT_処理番号,
                    DEFAULT_連番,
                    DEFAULT_エラー表示連番), is(nullValue()));
        }
    }

    private static class TestSupport {

        public static void insert(
                RString 処理番号,
                RString 連番,
                RString エラー表示連番) {
            DbT7034KoikiGaijiHenkanErrorLogEntity entity = DbT7034KoikiGaijiHenkanErrorLogEntityGenerator.createDbT7034KoikiGaijiHenkanErrorLogEntity();
            entity.setShoriNo(処理番号);
            entity.setRenNo(連番);
            entity.setErrorHyojiRenban(エラー表示連番);
            sut.insert(entity);
        }
    }
}
