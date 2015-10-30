/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.db.basic;

import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT5222NinteiChosaScheduleMemoDac;
import java.util.Collections;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5222NinteiChosaScheduleMemoEntity;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT5222NinteiChosaScheduleMemoEntityGenerator;
import static jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT5222NinteiChosaScheduleMemoEntityGenerator.DEFAULT_メモ区分;
import static jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT5222NinteiChosaScheduleMemoEntityGenerator.DEFAULT_メモ年月日;
import static jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT5222NinteiChosaScheduleMemoEntityGenerator.DEFAULT_連番;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestDacBase;
import jp.co.ndensan.reams.uz.uza.biz.Code;
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
import org.junit.Ignore;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link DbT5222NinteiChosaScheduleMemoDac}のテストです。
 */
@Ignore
@RunWith(Enclosed.class)
public class DbT5222NinteiChosaScheduleMemoDacTest extends DbzTestDacBase {

    private static final RString キー_01 = new RString("01");
    private static final RString キー_02 = new RString("02");
    private static final RString キー_03 = new RString("03");
    private static DbT5222NinteiChosaScheduleMemoDac sut;

    @BeforeClass
    public static void setUpClass() {
        sut = InstanceProvider.create(DbT5222NinteiChosaScheduleMemoDac.class);
    }

    public static class selectByKeyのテスト extends DbzTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    DEFAULT_メモ年月日,
                    DEFAULT_メモ区分,
                    DEFAULT_連番);
            TestSupport.insert(
                    DEFAULT_メモ年月日,
                    DEFAULT_メモ区分,
                    DEFAULT_連番);
        }

        @Test(expected = NullPointerException.class)
        public void メモ年月日がnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    DEFAULT_メモ年月日,
                    DEFAULT_メモ区分,
                    DEFAULT_連番);
        }

        @Test(expected = NullPointerException.class)
        public void メモ区分がnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    DEFAULT_メモ年月日,
                    DEFAULT_メモ区分,
                    DEFAULT_連番);
        }

        @Test(expected = NullPointerException.class)
        public void 連番がnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    DEFAULT_メモ年月日,
                    DEFAULT_メモ区分,
                    DEFAULT_連番);
        }

        @Test
        public void 存在する主キーを渡すと_selectByKeyは_該当のエンティティを返す() {
            DbT5222NinteiChosaScheduleMemoEntity insertedRecord = sut.selectByKey(
                    DEFAULT_メモ年月日,
                    DEFAULT_メモ区分,
                    DEFAULT_連番);
            assertThat(insertedRecord, is(notNullValue()));
        }

        @Test
        public void 存在しない主キーを渡すと_selectByKeyは_nullを返す() {
            DbT5222NinteiChosaScheduleMemoEntity insertedRecord = sut.selectByKey(
                    DEFAULT_メモ年月日,
                    DEFAULT_メモ区分,
                    DEFAULT_連番);
            assertThat(insertedRecord, is(nullValue()));
        }
    }

    public static class selectAllのテスト extends DbzTestDacBase {

        @Test
        public void 認定調査スケジュールメモ情報が存在する場合_selectAllは_全件を返す() {
            TestSupport.insert(
                    DEFAULT_メモ年月日,
                    DEFAULT_メモ区分,
                    DEFAULT_連番);
            TestSupport.insert(
                    DEFAULT_メモ年月日,
                    DEFAULT_メモ区分,
                    DEFAULT_連番);
            assertThat(sut.selectAll().size(), is(2));
        }

        @Test
        public void 認定調査スケジュールメモ情報が存在しない場合_selectAllは_空のリストを返す() {
            assertThat(sut.selectAll(), is(Collections.EMPTY_LIST));
        }
    }

    public static class insertのテスト extends DbzTestDacBase {

        @Test
        public void 認定調査スケジュールメモ情報エンティティを渡すと_insertは_認定調査スケジュールメモ情報を追加する() {
            TestSupport.insert(
                    DEFAULT_メモ年月日,
                    DEFAULT_メモ区分,
                    DEFAULT_連番);

            assertThat(sut.selectByKey(
                    DEFAULT_メモ年月日,
                    DEFAULT_メモ区分,
                    DEFAULT_連番), is(notNullValue()));
        }
    }

    public static class updateのテスト extends DbzTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    DEFAULT_メモ年月日,
                    DEFAULT_メモ区分,
                    DEFAULT_連番);
        }

        @Test
        public void 認定調査スケジュールメモ情報エンティティを渡すと_updateは_認定調査スケジュールメモ情報を更新する() {
            DbT5222NinteiChosaScheduleMemoEntity updateRecord = sut.selectByKey(
                    DEFAULT_メモ年月日,
                    DEFAULT_メモ区分,
                    DEFAULT_連番);
            //TODO
//            updateRecord.set変更したい項目(75);

            sut.save(updateRecord);

            DbT5222NinteiChosaScheduleMemoEntity updatedRecord = sut.selectByKey(
                    DEFAULT_メモ年月日,
                    DEFAULT_メモ区分,
                    DEFAULT_連番);

            //TODO
//            assertThat(updateRecord.get変更したい項目(), is(updatedRecord.get変更したい項目()));
        }
    }

    public static class deleteのテスト extends DbzTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    DEFAULT_メモ年月日,
                    DEFAULT_メモ区分,
                    DEFAULT_連番);
        }

        @Test
        public void 認定調査スケジュールメモ情報エンティティを渡すと_deleteは_認定調査スケジュールメモ情報を削除する() {
            DbT5222NinteiChosaScheduleMemoEntity deletedEntity = sut.selectByKey(
                    DEFAULT_メモ年月日,
                    DEFAULT_メモ区分,
                    DEFAULT_連番);
            deletedEntity.setState(EntityDataState.Deleted);

            sut.save(deletedEntity);

            assertThat(sut.selectByKey(
                    DEFAULT_メモ年月日,
                    DEFAULT_メモ区分,
                    DEFAULT_連番), is(nullValue()));
        }
    }

    private static class TestSupport {

        public static void insert(
                FlexibleDate メモ年月日,
                Code メモ区分,
                int 連番) {
            DbT5222NinteiChosaScheduleMemoEntity entity = DbT5222NinteiChosaScheduleMemoEntityGenerator.createDbT5222NinteiChosaScheduleMemoEntity();
            entity.setMemoYMD(メモ年月日);
            entity.setMemoKubun(メモ区分);
            entity.setRemban(連番);
            sut.save(entity);
        }
    }
}
