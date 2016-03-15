/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.db.basic;

import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT5592ShinsakaiKaisaiBashoJohoDac;
import java.util.Collections;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5592ShinsakaiKaisaiBashoJohoEntity;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT5592ShinsakaiKaisaiBashoJohoEntityGenerator;
import static jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT5592ShinsakaiKaisaiBashoJohoEntityGenerator.DEFAULT_介護認定審査会開催場所コード;
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
import org.junit.Ignore;

/**
 * {@link DbT5592ShinsakaiKaisaiBashoJohoDac}のテストです。
 */
@Ignore
@RunWith(Enclosed.class)
public class DbT5592ShinsakaiKaisaiBashoJohoDacTest extends DbeTestDacBase {

    private static final RString キー_01 = new RString("01");
    private static final RString キー_02 = new RString("02");
    private static final RString キー_03 = new RString("03");
    private static DbT5592ShinsakaiKaisaiBashoJohoDac sut;

    @BeforeClass
    public static void setUpClass() {
        sut = InstanceProvider.create(DbT5592ShinsakaiKaisaiBashoJohoDac.class);
    }

    public static class selectByKeyのテスト extends DbeTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    キー_01);
            TestSupport.insert(
                    キー_02);
        }

        @Test(expected = NullPointerException.class)
        public void 介護認定審査会開催場所コードがnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(null);
        }

        @Test
        public void 存在する主キーを渡すと_selectByKeyは_該当のエンティティを返す() {
            DbT5592ShinsakaiKaisaiBashoJohoEntity insertedRecord = sut.selectByKey(
                    DEFAULT_介護認定審査会開催場所コード);
            assertThat(insertedRecord, is(notNullValue()));
        }

        @Test
        public void 存在しない主キーを渡すと_selectByKeyは_nullを返す() {
            DbT5592ShinsakaiKaisaiBashoJohoEntity insertedRecord = sut.selectByKey(
                    キー_02);
            assertThat(insertedRecord, is(nullValue()));
        }
    }

    public static class selectAllのテスト extends DbeTestDacBase {

        @Test
        public void 介護認定審査会開催場所情報が存在する場合_selectAllは_全件を返す() {
            TestSupport.insert(
                    キー_01);
            TestSupport.insert(
                    キー_03);
            assertThat(sut.selectAll().size(), is(2));
        }

        @Test
        public void 介護認定審査会開催場所情報が存在しない場合_selectAllは_空のリストを返す() {
            assertThat(sut.selectAll(), is(Collections.EMPTY_LIST));
        }
    }

    public static class insertのテスト extends DbeTestDacBase {

        @Test
        public void 介護認定審査会開催場所情報エンティティを渡すと_insertは_介護認定審査会開催場所情報を追加する() {
            TestSupport.insert(
                    DEFAULT_介護認定審査会開催場所コード);

            assertThat(sut.selectByKey(
                    DEFAULT_介護認定審査会開催場所コード), is(notNullValue()));
        }
    }

    public static class updateのテスト extends DbeTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    DEFAULT_介護認定審査会開催場所コード);
        }

        @Test
        public void 介護認定審査会開催場所情報エンティティを渡すと_updateは_介護認定審査会開催場所情報を更新する() {
            DbT5592ShinsakaiKaisaiBashoJohoEntity updateRecord = sut.selectByKey(
                    DEFAULT_介護認定審査会開催場所コード);
            updateRecord.setShinsakaiKaisaiBashoCode(new RString("000i"));

            sut.save(updateRecord);

            DbT5592ShinsakaiKaisaiBashoJohoEntity updatedRecord = sut.selectByKey(
                    DEFAULT_介護認定審査会開催場所コード);

            assertThat(updateRecord.getShinsakaiKaisaiBashoCode(), is(updatedRecord.getShinsakaiKaisaiBashoCode()));
        }
    }

    public static class deleteのテスト extends DbeTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    DEFAULT_介護認定審査会開催場所コード);
        }

        @Test
        public void 介護認定審査会開催場所情報エンティティを渡すと_deleteは_介護認定審査会開催場所情報を削除する() {
            DbT5592ShinsakaiKaisaiBashoJohoEntity deletedEntity = sut.selectByKey(
                    DEFAULT_介護認定審査会開催場所コード);
            deletedEntity.setState(EntityDataState.Deleted);

            sut.save(deletedEntity);

            assertThat(sut.selectByKey(
                    DEFAULT_介護認定審査会開催場所コード), is(nullValue()));
        }
    }

    private static class TestSupport {

        public static void insert(
                RString 介護認定審査会開催場所コード) {
            DbT5592ShinsakaiKaisaiBashoJohoEntity entity = DbT5592ShinsakaiKaisaiBashoJohoEntityGenerator.createDbT5592ShinsakaiKaisaiBashoJohoEntity();
            entity.setShinsakaiKaisaiBashoCode(介護認定審査会開催場所コード);
            sut.save(entity);
        }
    }
}
