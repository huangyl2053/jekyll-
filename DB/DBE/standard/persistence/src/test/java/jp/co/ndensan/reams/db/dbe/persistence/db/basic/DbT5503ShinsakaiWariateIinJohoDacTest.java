/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.persistence.db.basic;

import java.util.Collections;
import jp.co.ndensan.reams.db.dbe.entity.db.basic.DbT5503ShinsakaiWariateIinJohoEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.basic.helper.DbT5503ShinsakaiWariateIinJohoEntityGenerator;
import static jp.co.ndensan.reams.db.dbe.entity.db.basic.helper.DbT5503ShinsakaiWariateIinJohoEntityGenerator.DEFAULT_介護認定審査会委員コード;
import static jp.co.ndensan.reams.db.dbe.entity.db.basic.helper.DbT5503ShinsakaiWariateIinJohoEntityGenerator.DEFAULT_介護認定審査会開催番号;
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
 * {@link DbT5503ShinsakaiWariateIinJohoDac}のテストです。
 */
@RunWith(Enclosed.class)
public class DbT5503ShinsakaiWariateIinJohoDacTest extends DbeTestDacBase {

    private static final RString キー_01 = DEFAULT_介護認定審査会開催番号;
    private static final RString キー_02 = new RString("02");
    private static final RString キー_03 = new RString("03");
    private static DbT5503ShinsakaiWariateIinJohoDac sut;

    @BeforeClass
    public static void setUpClass() {
        sut = InstanceProvider.create(DbT5503ShinsakaiWariateIinJohoDac.class);
    }

    public static class selectByKeyのテスト extends DbeTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    DEFAULT_介護認定審査会開催番号,
                    DEFAULT_介護認定審査会委員コード);
            TestSupport.insert(
                    キー_02,
                    DEFAULT_介護認定審査会委員コード);
        }

        @Test(expected = NullPointerException.class)
        public void 介護認定審査会開催番号がnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    null,
                    DEFAULT_介護認定審査会委員コード);
        }

        @Test(expected = NullPointerException.class)
        public void 介護認定審査会委員コードがnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    DEFAULT_介護認定審査会開催番号,
                    null);
        }

        @Test
        public void 存在する主キーを渡すと_selectByKeyは_該当のエンティティを返す() {
            DbT5503ShinsakaiWariateIinJohoEntity insertedRecord = sut.selectByKey(
                    DEFAULT_介護認定審査会開催番号,
                    DEFAULT_介護認定審査会委員コード);
            assertThat(insertedRecord, is(notNullValue()));
        }

        @Test
        public void 存在しない主キーを渡すと_selectByKeyは_nullを返す() {
            DbT5503ShinsakaiWariateIinJohoEntity insertedRecord = sut.selectByKey(
                    キー_01,
                    DEFAULT_介護認定審査会委員コード);
            assertThat(insertedRecord, is(nullValue()));
        }
    }

    public static class selectAllのテスト extends DbeTestDacBase {

        @Test
        public void 介護認定審査会割当委員情報が存在する場合_selectAllは_全件を返す() {
            TestSupport.insert(
                    キー_02,
                    DEFAULT_介護認定審査会委員コード);
            TestSupport.insert(
                    キー_03,
                    DEFAULT_介護認定審査会委員コード);
            assertThat(sut.selectAll().size(), is(2));
        }

        @Test
        public void 介護認定審査会割当委員情報が存在しない場合_selectAllは_空のリストを返す() {
            assertThat(sut.selectAll(), is(Collections.EMPTY_LIST));
        }
    }

    public static class insertのテスト extends DbeTestDacBase {

        @Test
        public void 介護認定審査会割当委員情報エンティティを渡すと_insertは_介護認定審査会割当委員情報を追加する() {
            TestSupport.insert(
                    DEFAULT_介護認定審査会開催番号,
                    DEFAULT_介護認定審査会委員コード);

            assertThat(sut.selectByKey(
                    DEFAULT_介護認定審査会開催番号,
                    DEFAULT_介護認定審査会委員コード), is(notNullValue()));
        }
    }

    public static class updateのテスト extends DbeTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    DEFAULT_介護認定審査会開催番号,
                    DEFAULT_介護認定審査会委員コード);
        }

        @Test
        public void 介護認定審査会割当委員情報エンティティを渡すと_updateは_介護認定審査会割当委員情報を更新する() {
            DbT5503ShinsakaiWariateIinJohoEntity updateRecord = sut.selectByKey(
                    DEFAULT_介護認定審査会開催番号,
                    DEFAULT_介護認定審査会委員コード);
            updateRecord.setShussekiTime(new RString("0001"));

            sut.save(updateRecord);

            DbT5503ShinsakaiWariateIinJohoEntity updatedRecord = sut.selectByKey(
                    DEFAULT_介護認定審査会開催番号,
                    DEFAULT_介護認定審査会委員コード);

            assertThat(updateRecord.getShussekiTime(), is(updatedRecord.getShussekiTime()));
        }
    }

    public static class deleteのテスト extends DbeTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    DEFAULT_介護認定審査会開催番号,
                    DEFAULT_介護認定審査会委員コード);
        }

        @Test
        public void 介護認定審査会割当委員情報エンティティを渡すと_deleteは_介護認定審査会割当委員情報を削除する() {
            DbT5503ShinsakaiWariateIinJohoEntity deletedEntity = sut.selectByKey(
                    DEFAULT_介護認定審査会開催番号,
                    DEFAULT_介護認定審査会委員コード);
            deletedEntity.setState(EntityDataState.Deleted);

            sut.save(deletedEntity);

            assertThat(sut.selectByKey(
                    DEFAULT_介護認定審査会開催番号,
                    DEFAULT_介護認定審査会委員コード), is(nullValue()));
        }
    }

    private static class TestSupport {

        public static void insert(
                RString 介護認定審査会開催番号,
                RString 介護認定審査会委員コード) {
            DbT5503ShinsakaiWariateIinJohoEntity entity = DbT5503ShinsakaiWariateIinJohoEntityGenerator.createDbT5503ShinsakaiWariateIinJohoEntity();
            entity.setShinsakaiKaisaiNo(介護認定審査会開催番号);
            entity.setShinsakaiIinCode(介護認定審査会委員コード);
            sut.save(entity);
        }
    }
}
