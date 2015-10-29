/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.persistence.db.basic;

import java.util.Collections;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5512ShinsakaiOnseiJohoEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.basic.helper.DbT5512ShinsakaiOnseiJohoEntityGenerator;
import static jp.co.ndensan.reams.db.dbe.entity.db.basic.helper.DbT5512ShinsakaiOnseiJohoEntityGenerator.DEFAULT_介護認定審査会開催番号;
import static jp.co.ndensan.reams.db.dbe.entity.db.basic.helper.DbT5512ShinsakaiOnseiJohoEntityGenerator.DEFAULT_連番;
import jp.co.ndensan.reams.db.dbz.testhelper.DbeTestDacBase;
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
 * {@link DbT5512ShinsakaiOnseiJohoDac}のテストです。
 */
@RunWith(Enclosed.class)
public class DbT5512ShinsakaiOnseiJohoDacTest extends DbeTestDacBase {

    private static final RString キー_01 = new RString("01");
    private static final RString キー_02 = new RString("02");
    private static final RString キー_03 = new RString("03");
    private static DbT5512ShinsakaiOnseiJohoDac sut;

    @BeforeClass
    public static void setUpClass() {
        sut = InstanceProvider.create(DbT5512ShinsakaiOnseiJohoDac.class);
    }

    public static class selectByKeyのテスト extends DbeTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    キー_01,
                    DEFAULT_連番);
            TestSupport.insert(
                    キー_02,
                    DEFAULT_連番);
        }

        @Test(expected = NullPointerException.class)
        public void 介護認定審査会開催番号がnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    null,
                    DEFAULT_連番);
        }

        @Test
        public void 存在する主キーを渡すと_selectByKeyは_該当のエンティティを返す() {
            DbT5512ShinsakaiOnseiJohoEntity insertedRecord = sut.selectByKey(
                    DEFAULT_介護認定審査会開催番号,
                    DEFAULT_連番);
            assertThat(insertedRecord, is(notNullValue()));
        }

        @Test
        public void 存在しない主キーを渡すと_selectByKeyは_nullを返す() {
            DbT5512ShinsakaiOnseiJohoEntity insertedRecord = sut.selectByKey(
                    キー_03,
                    DEFAULT_連番);
            assertThat(insertedRecord, is(nullValue()));
        }
    }

    public static class selectAllのテスト extends DbeTestDacBase {

        @Test
        public void 介護認定審査会音声情報が存在する場合_selectAllは_全件を返す() {
            TestSupport.insert(
                    キー_01,
                    DEFAULT_連番);
            TestSupport.insert(
                    キー_02,
                    DEFAULT_連番);
            assertThat(sut.selectAll().size(), is(2));
        }

        @Test
        public void 介護認定審査会音声情報が存在しない場合_selectAllは_空のリストを返す() {
            assertThat(sut.selectAll(), is(Collections.EMPTY_LIST));
        }
    }

    public static class insertのテスト extends DbeTestDacBase {

        @Test
        public void 介護認定審査会音声情報エンティティを渡すと_insertは_介護認定審査会音声情報を追加する() {
            TestSupport.insert(
                    DEFAULT_介護認定審査会開催番号,
                    DEFAULT_連番);

            assertThat(sut.selectByKey(
                    DEFAULT_介護認定審査会開催番号,
                    DEFAULT_連番), is(notNullValue()));
        }
    }

    public static class updateのテスト extends DbeTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    DEFAULT_介護認定審査会開催番号,
                    DEFAULT_連番);
        }

        @Test
        public void 介護認定審査会音声情報エンティティを渡すと_updateは_介護認定審査会音声情報を更新する() {
            DbT5512ShinsakaiOnseiJohoEntity updateRecord = sut.selectByKey(
                    DEFAULT_介護認定審査会開催番号,
                    DEFAULT_連番);
            updateRecord.setShinsakaiOnseiFile(new byte[]{1, 2, 3});

            sut.save(updateRecord);

            DbT5512ShinsakaiOnseiJohoEntity updatedRecord = sut.selectByKey(
                    DEFAULT_介護認定審査会開催番号,
                    DEFAULT_連番);

            assertThat(updateRecord.getShinsakaiOnseiFile(), is(updatedRecord.getShinsakaiOnseiFile()));
        }
    }

    public static class deleteのテスト extends DbeTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    DEFAULT_介護認定審査会開催番号,
                    DEFAULT_連番);
        }

        @Test
        public void 介護認定審査会音声情報エンティティを渡すと_deleteは_介護認定審査会音声情報を削除する() {
            DbT5512ShinsakaiOnseiJohoEntity deletedEntity = sut.selectByKey(
                    DEFAULT_介護認定審査会開催番号,
                    DEFAULT_連番);
            deletedEntity.setState(EntityDataState.Deleted);

            sut.save(deletedEntity);

            assertThat(sut.selectByKey(
                    DEFAULT_介護認定審査会開催番号,
                    DEFAULT_連番), is(nullValue()));
        }
    }

    private static class TestSupport {

        public static void insert(
                RString 介護認定審査会開催番号,
                int 連番) {
            DbT5512ShinsakaiOnseiJohoEntity entity = DbT5512ShinsakaiOnseiJohoEntityGenerator.createDbT5512ShinsakaiOnseiJohoEntity();
            entity.setShinsakaiKaisaiNo(介護認定審査会開催番号);
            entity.setRenban(連番);
            sut.save(entity);
        }
    }
}
