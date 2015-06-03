/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.persistence.basic;

import java.util.Collections;
import jp.co.ndensan.reams.db.dbd.entity.basic.DbT5120ShinseitodokedeJohoEntity;
import jp.co.ndensan.reams.db.dbd.entity.basic.helper.DbT5120ShinseitodokedeJohoEntityGenerator;
import static jp.co.ndensan.reams.db.dbd.entity.basic.helper.DbT5120ShinseitodokedeJohoEntityGenerator.*;
import jp.co.ndensan.reams.db.dbz.definition.util.optional.Optional;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.testhelper.DbdTestDacBase;
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
 * {@link DbT5120ShinsakaiShinseitodokedeJohoDac}のテストです。
 *
 * @author n8223 朴義一
 */
@RunWith(Enclosed.class)
public class DbT5120ShinsakaiShinseitodokedeJohoDacTest extends DbdTestDacBase {

    private static final ShinseishoKanriNo OTHER_DEFAULT_申請書管理番号 = new ShinseishoKanriNo("9000000001");
    private static final ShinseishoKanriNo NOTFOUND_申請書管理番号 = new ShinseishoKanriNo("9000000003");
    private static final RString キー_03 = new RString("03");
    private static DbT5120ShinsakaiShinseitodokedeJohoDac sut;

    @BeforeClass
    public static void setUpClass() {
        sut = InstanceProvider.create(DbT5120ShinsakaiShinseitodokedeJohoDac.class);
    }

    public static class selectByKeyのテスト extends DbdTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    DEFAULT_申請書管理番号);
            TestSupport.insert(
                    OTHER_DEFAULT_申請書管理番号);
        }

        @Test(expected = NullPointerException.class)
        public void 申請書管理番号がnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    null);
        }

        @Test
        public void 存在する主キーを渡すと_selectByKeyは_該当のエンティティを返す() {
            Optional<DbT5120ShinseitodokedeJohoEntity> insertedRecord = sut.selectByKey(
                    DEFAULT_申請書管理番号);
            assertThat(insertedRecord, is(notNullValue()));
        }

        @Test
        public void 存在しない主キーを渡すと_selectByKeyは_nullを返す() {
            Optional<DbT5120ShinseitodokedeJohoEntity> insertedRecord = sut.selectByKey(
                    NOTFOUND_申請書管理番号);
            assertThat(insertedRecord, is(nullValue()));
        }
    }

    public static class selectAllのテスト extends DbdTestDacBase {

        @Test
        public void 申請届出情報が存在する場合_selectAllは_全件を返す() {
            TestSupport.insert(
                    DEFAULT_申請書管理番号);
            TestSupport.insert(
                    OTHER_DEFAULT_申請書管理番号);
            assertThat(sut.selectAll().size(), is(2));
        }

        @Test
        public void 申請届出情報が存在しない場合_selectAllは_空のリストを返す() {
            assertThat(sut.selectAll().toList(), is(Collections.EMPTY_LIST));
        }
    }

    public static class insertのテスト extends DbdTestDacBase {

        @Test
        public void 申請届出情報エンティティを渡すと_insertは_申請届出情報を追加する() {
            TestSupport.insert(
                    DEFAULT_申請書管理番号);

            assertThat(sut.selectByKey(
                    DEFAULT_申請書管理番号), is(notNullValue()));
        }
    }

    public static class updateのテスト extends DbdTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    OTHER_DEFAULT_申請書管理番号);
        }

        @Test
        public void 申請届出情報エンティティを渡すと_updateは_申請届出情報を更新する() {
            DbT5120ShinseitodokedeJohoEntity updateRecord = DbT5120ShinseitodokedeJohoEntityGenerator.createDbT5120ShinseitodokedeJohoEntity();
            updateRecord.setShinseishoKanriNo(OTHER_DEFAULT_申請書管理番号);

            sut.update(updateRecord);

            Optional<DbT5120ShinseitodokedeJohoEntity> updatedRecord = sut.selectByKey(
                    OTHER_DEFAULT_申請書管理番号);

            assertThat(updateRecord.getShinseishoKanriNo(), is(updatedRecord.get().getShinseishoKanriNo()));
        }
    }

    public static class deleteのテスト extends DbdTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    DEFAULT_申請書管理番号);
        }

        @Test
        public void 申請届出情報エンティティを渡すと_deleteは_申請届出情報を削除する() {
            Optional<DbT5120ShinseitodokedeJohoEntity>   deleteRecord = sut.selectByKey(
                    DEFAULT_申請書管理番号);
           DbT5120ShinseitodokedeJohoEntity entity = new DbT5120ShinseitodokedeJohoEntity();
           entity.setShinseishoKanriNo(DEFAULT_申請書管理番号);
        
           sut.delete(entity);
           assertThat(sut.selectByKey(
                    DEFAULT_申請書管理番号), is(nullValue()));
        }
    }

    private static class TestSupport {

        public static void insert(
                ShinseishoKanriNo 申請書管理番号) {
            DbT5120ShinseitodokedeJohoEntity entity = DbT5120ShinseitodokedeJohoEntityGenerator.createDbT5120ShinseitodokedeJohoEntity();
            entity.setShinseishoKanriNo(申請書管理番号);
            sut.insert(entity);
        }
    }
}
