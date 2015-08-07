/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.db.basic;

import java.util.Collections;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT7035RendoPatternEntity;
import static jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT7014KaigoSetaiEntityGenerator.DEFAULT_連番;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT7035RendoPatternEntityGenerator;
import static jp.co.ndensan.reams.db.dbz.entity.basic.helper.UrT0705ChoteiKyotsuEntityGenerator.DEFAULT_処理番号;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestDacBase;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
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
 * {@link DbT7035RendoPatternDac}のテストです。
 */
@RunWith(Enclosed.class)
public class DbT7035RendoPatternDacTest extends DbzTestDacBase {

    private static final RString キー_01 = DEFAULT_キー;
    private static final RString キー_02 = new RString("02");
    private static final RString キー_03 = new RString("03");
    private static DbT7035RendoPatternDac sut;

    @BeforeClass
    public static void setUpClass() {
        sut = InstanceProvider.create(DbT7035RendoPatternDac.class);
    }

    public static class selectByKeyのテスト extends DbzTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    DEFAULT_処理番号,
                    DEFAULT_連番);
            TestSupport.insert(
                    DEFAULT_処理番号,
                    DEFAULT_連番);
        }

        @Test(expected = NullPointerException.class)
        public void 処理番号がnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    DEFAULT_処理番号,
                    DEFAULT_連番);
        }

        @Test(expected = NullPointerException.class)
        public void 連番がnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    DEFAULT_処理番号,
                    DEFAULT_連番);
        }

        @Test
        public void 存在する主キーを渡すと_selectByKeyは_該当のエンティティを返す() {
            DbT7035RendoPatternEntity insertedRecord = sut.selectByKey(
                    DEFAULT_処理番号,
                    DEFAULT_連番);
            assertThat(insertedRecord, is(notNullValue()));
        }

        @Test
        public void 存在しない主キーを渡すと_selectByKeyは_nullを返す() {
            DbT7035RendoPatternEntity insertedRecord = sut.selectByKey(
                    DEFAULT_処理番号,
                    DEFAULT_連番);
            assertThat(insertedRecord, is(nullValue()));
        }
    }

    public static class selectAllのテスト extends DbzTestDacBase {

        @Test
        public void 連動パターンが存在する場合_selectAllは_全件を返す() {
            TestSupport.insert(
                    DEFAULT_処理番号,
                    DEFAULT_連番);
            TestSupport.insert(
                    DEFAULT_処理番号,
                    DEFAULT_連番);
            assertThat(sut.selectAll().size(), is(2));
        }

        @Test
        public void 連動パターンが存在しない場合_selectAllは_空のリストを返す() {
            assertThat(sut.selectAll(), is(Collections.EMPTY_LIST));
        }
    }

    public static class insertのテスト extends DbzTestDacBase {

        @Test
        public void 連動パターンエンティティを渡すと_insertは_連動パターンを追加する() {
            TestSupport.insert(
                    DEFAULT_処理番号,
                    DEFAULT_連番);

            assertThat(sut.selectByKey(
                    DEFAULT_処理番号,
                    DEFAULT_連番), is(notNullValue()));
        }
    }

    public static class updateのテスト extends DbzTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    DEFAULT_処理番号,
                    DEFAULT_連番);
        }

        @Test
        public void 連動パターンエンティティを渡すと_updateは_連動パターンを更新する() {
            DbT7035RendoPatternEntity updateRecord = sut.selectByKey(
                    DEFAULT_処理番号,
                    DEFAULT_連番);
            updateRecord.set変更したい項目(75);

            sut.save(updateRecord);

            DbT7035RendoPatternEntity updatedRecord = sut.selectByKey(
                    DEFAULT_処理番号,
                    DEFAULT_連番);

            assertThat(updateRecord.get変更したい項目(), is(updatedRecord.get変更したい項目()));
        }
    }

    public static class deleteのテスト extends DbzTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    DEFAULT_処理番号,
                    DEFAULT_連番);
        }

        @Test
        public void 連動パターンエンティティを渡すと_deleteは_連動パターンを削除する() {
            DbT7035RendoPatternEntity deletedEntity = sut.selectByKey(
                    DEFAULT_処理番号,
                    DEFAULT_連番);
            deletedEntity.setState(EntityDataState.Deleted);

            sut.save(deletedEntity);

            assertThat(sut.selectByKey(
                    DEFAULT_処理番号,
                    DEFAULT_連番), is(nullValue()));
        }
    }

    private static class TestSupport {

        public static void insert(
                LasdecCode 処理番号,
                LasdecCode 連番) {
            DbT7035RendoPatternEntity entity = DbT7035RendoPatternEntityGenerator.createDbT7035RendoPatternEntity();
            entity.setShoriNo(処理番号);
            entity.setRenNo(連番);
            sut.save(entity);
        }
    }
}
