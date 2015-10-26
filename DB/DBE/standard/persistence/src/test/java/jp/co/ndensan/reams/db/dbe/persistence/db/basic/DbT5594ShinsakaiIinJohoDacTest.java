/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.persistence.db.basic;

import java.util.Collections;
import jp.co.ndensan.reams.db.dbe.entity.db.basic.DbT5594ShinsakaiIinJohoEntity;
import static jp.co.ndensan.reams.db.dbe.entity.db.basic.helper.DbT5593GogitaiWariateIinJohoEntityGenerator.DEFAULT_介護認定審査会委員コード;
import jp.co.ndensan.reams.db.dbe.entity.db.basic.helper.DbT5594ShinsakaiIinJohoEntityGenerator;
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
 * {@link DbT5594ShinsakaiIinJohoDac}のテストです。
 */
@RunWith(Enclosed.class)
public class DbT5594ShinsakaiIinJohoDacTest extends DbeTestDacBase {

    private static final RString キー_01 = DEFAULT_介護認定審査会委員コード;
    private static final RString キー_02 = new RString("02");
    private static final RString キー_03 = new RString("03");
    private static DbT5594ShinsakaiIinJohoDac sut;

    @BeforeClass
    public static void setUpClass() {
        sut = InstanceProvider.create(DbT5594ShinsakaiIinJohoDac.class);
    }

    public static class selectByKeyのテスト extends DbeTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    DEFAULT_介護認定審査会委員コード);
            TestSupport.insert(
                    キー_02);
        }

        @Test(expected = NullPointerException.class)
        public void 介護認定審査会委員コードがnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    null);
        }

        @Test
        public void 存在する主キーを渡すと_selectByKeyは_該当のエンティティを返す() {
            DbT5594ShinsakaiIinJohoEntity insertedRecord = sut.selectByKey(
                    DEFAULT_介護認定審査会委員コード);
            assertThat(insertedRecord, is(notNullValue()));
        }

        @Test
        public void 存在しない主キーを渡すと_selectByKeyは_nullを返す() {
            DbT5594ShinsakaiIinJohoEntity insertedRecord = sut.selectByKey(
                    キー_03);
            assertThat(insertedRecord, is(nullValue()));
        }
    }

    public static class selectAllのテスト extends DbeTestDacBase {

        @Test
        public void 介護認定審査会委員情報が存在する場合_selectAllは_全件を返す() {
            TestSupport.insert(
                    キー_01);
            TestSupport.insert(
                    キー_02);
            assertThat(sut.selectAll().size(), is(2));
        }

        @Test
        public void 介護認定審査会委員情報が存在しない場合_selectAllは_空のリストを返す() {
            assertThat(sut.selectAll(), is(Collections.EMPTY_LIST));
        }
    }

    public static class insertのテスト extends DbeTestDacBase {

        @Test
        public void 介護認定審査会委員情報エンティティを渡すと_insertは_介護認定審査会委員情報を追加する() {
            TestSupport.insert(
                    DEFAULT_介護認定審査会委員コード);

            assertThat(sut.selectByKey(
                    DEFAULT_介護認定審査会委員コード), is(notNullValue()));
        }
    }

    public static class updateのテスト extends DbeTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    DEFAULT_介護認定審査会委員コード);
        }

        @Test
        public void 介護認定審査会委員情報エンティティを渡すと_updateは_介護認定審査会委員情報を更新する() {
            DbT5594ShinsakaiIinJohoEntity updateRecord = sut.selectByKey(
                    DEFAULT_介護認定審査会委員コード);
            updateRecord.setBiko(new RString("変更後_備考"));

            sut.save(updateRecord);

            DbT5594ShinsakaiIinJohoEntity updatedRecord = sut.selectByKey(
                    DEFAULT_介護認定審査会委員コード);

            assertThat(updateRecord.getBiko(), is(updatedRecord.getBiko()));
        }
    }

    public static class deleteのテスト extends DbeTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    DEFAULT_介護認定審査会委員コード);
        }

        @Test
        public void 介護認定審査会委員情報エンティティを渡すと_deleteは_介護認定審査会委員情報を削除する() {
            DbT5594ShinsakaiIinJohoEntity deletedEntity = sut.selectByKey(
                    DEFAULT_介護認定審査会委員コード);
            deletedEntity.setState(EntityDataState.Deleted);

            sut.save(deletedEntity);

            assertThat(sut.selectByKey(
                    DEFAULT_介護認定審査会委員コード), is(nullValue()));
        }
    }

    private static class TestSupport {

        public static void insert(
                RString 介護認定審査会委員コード) {
            DbT5594ShinsakaiIinJohoEntity entity = DbT5594ShinsakaiIinJohoEntityGenerator.createDbT5594ShinsakaiIinJohoEntity();
            entity.setShinsakaiIinCode(介護認定審査会委員コード);
            sut.save(entity);
        }
    }
}
