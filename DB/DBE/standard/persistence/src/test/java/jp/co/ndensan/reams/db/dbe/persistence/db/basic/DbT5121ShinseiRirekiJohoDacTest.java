/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.persistence.db.basic;

import java.util.Collections;
import jp.co.ndensan.reams.db.dbe.entity.db.basic.DbT5121ShinseiRirekiJohoEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.basic.helper.DbT5121ShinseiRirekiJohoEntityGenerator;
import static jp.co.ndensan.reams.db.dbe.entity.db.basic.helper.DbT5121ShinseiRirekiJohoEntityGenerator.DEFAULT_申請管理番号;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.testhelper.DbeTestDacBase;
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
 * {@link DbT5121ShinseiRirekiJohoDac}のテストです。
 */
@Ignore
@RunWith(Enclosed.class)

public class DbT5121ShinseiRirekiJohoDacTest extends DbeTestDacBase {

    private static final ShinseishoKanriNo キー_01 = new ShinseishoKanriNo("01");
    private static final ShinseishoKanriNo キー_02 = new ShinseishoKanriNo("02");
    private static final ShinseishoKanriNo キー_03 = new ShinseishoKanriNo("03");
    private static DbT5121ShinseiRirekiJohoDac sut;

    @BeforeClass
    public static void setUpClass() {
        sut = InstanceProvider.create(DbT5121ShinseiRirekiJohoDac.class);
    }

    public static class selectByKeyのテスト extends DbeTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    DEFAULT_申請管理番号);
            TestSupport.insert(
                    キー_02);
        }

        @Test(expected = NullPointerException.class)
        public void 申請管理番号がnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    null);
        }

        @Test
        public void 存在する主キーを渡すと_selectByKeyは_該当のエンティティを返す() {
            DbT5121ShinseiRirekiJohoEntity insertedRecord = sut.selectByKey(
                    DEFAULT_申請管理番号);
            assertThat(insertedRecord, is(notNullValue()));
        }

        @Test
        public void 存在しない主キーを渡すと_selectByKeyは_nullを返す() {
            DbT5121ShinseiRirekiJohoEntity insertedRecord = sut.selectByKey(
                    キー_01);
            assertThat(insertedRecord, is(nullValue()));
        }
    }

    public static class selectAllのテスト extends DbeTestDacBase {

        @Test
        public void 申請履歴情報が存在する場合_selectAllは_全件を返す() {
            TestSupport.insert(
                    キー_02);
            TestSupport.insert(
                    キー_03);
            assertThat(sut.selectAll().size(), is(2));
        }

        @Test
        public void 申請履歴情報が存在しない場合_selectAllは_空のリストを返す() {
            assertThat(sut.selectAll(), is(Collections.EMPTY_LIST));
        }
    }

    public static class insertのテスト extends DbeTestDacBase {

        @Test
        public void 申請履歴情報エンティティを渡すと_insertは_申請履歴情報を追加する() {
            TestSupport.insert(
                    DEFAULT_申請管理番号);

            assertThat(sut.selectByKey(
                    DEFAULT_申請管理番号), is(notNullValue()));
        }
    }

    public static class updateのテスト extends DbeTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    DEFAULT_申請管理番号);
        }

        @Test
        public void 申請履歴情報エンティティを渡すと_updateは_申請履歴情報を更新する() {
            DbT5121ShinseiRirekiJohoEntity updateRecord = sut.selectByKey(
                    DEFAULT_申請管理番号);
            updateRecord.setZenkaiShinseishoKanriNo(new ShinseishoKanriNo("00001"));

            sut.save(updateRecord);

            DbT5121ShinseiRirekiJohoEntity updatedRecord = sut.selectByKey(
                    DEFAULT_申請管理番号);

            assertThat(updateRecord.getZenkaiShinseishoKanriNo(), is(updatedRecord.getZenkaiShinseishoKanriNo()));
        }
    }

    public static class deleteのテスト extends DbeTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    DEFAULT_申請管理番号);
        }

        @Test
        public void 申請履歴情報エンティティを渡すと_deleteは_申請履歴情報を削除する() {
            DbT5121ShinseiRirekiJohoEntity deletedEntity = sut.selectByKey(
                    DEFAULT_申請管理番号);
            deletedEntity.setState(EntityDataState.Deleted);

            sut.save(deletedEntity);

            assertThat(sut.selectByKey(
                    DEFAULT_申請管理番号), is(nullValue()));
        }
    }

    private static class TestSupport {

        public static void insert(
                ShinseishoKanriNo 申請管理番号) {
            DbT5121ShinseiRirekiJohoEntity entity = DbT5121ShinseiRirekiJohoEntityGenerator.createDbT5121ShinseiRirekiJohoEntity();
            entity.setShinseishoKanriNo(申請管理番号);
            sut.save(entity);
        }
    }
}
