/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.db.basic;

import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT4120HokenshaShinseitodokedeJohoDac;
import java.util.Collections;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT4120ShinseitodokedeJohoEntity;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT4120ShinseitodokedeJohoEntityGenerator;
import static jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT4120ShinseitodokedeJohoEntityGenerator.*;
import jp.co.ndensan.reams.db.dbz.definition.core.util.optional.Optional;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
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
import org.junit.Ignore;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link DbT4120HokenshaShinseitodokedeJohoDac}のテストです。
 *
 * @author n8223 朴義一
 */
@Ignore
@RunWith(Enclosed.class)
public class DbT4120HokenshaShinseitodokedeJohoDacTest extends DbdTestDacBase {

    private static final ShinseishoKanriNo OTHER_DEFAULT_申請書管理番号 = new ShinseishoKanriNo("9000000001");
    private static final ShinseishoKanriNo NOTFOUND_申請書管理番号 = new ShinseishoKanriNo("9000000003");
    private static final RString キー_03 = new RString("03");
    private static DbT4120HokenshaShinseitodokedeJohoDac sut;

    @BeforeClass
    public static void setUpClass() {
        sut = InstanceProvider.create(DbT4120HokenshaShinseitodokedeJohoDac.class);
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
            Optional<DbT4120ShinseitodokedeJohoEntity> insertedRecord = sut.selectByKey(
                    DEFAULT_申請書管理番号);
            assertThat(insertedRecord, is(notNullValue()));
        }

        @Test
        public void 存在しない主キーを渡すと_selectByKeyは_nullを返す() {
            Optional<DbT4120ShinseitodokedeJohoEntity> insertedRecord = sut.selectByKey(
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
            DbT4120ShinseitodokedeJohoEntity updateRecord = DbT4120ShinseitodokedeJohoEntityGenerator.createDbT4120ShinseitodokedeJohoEntity();
            updateRecord.setShinseishoKanriNo(OTHER_DEFAULT_申請書管理番号);

            sut.update(updateRecord);

            Optional<DbT4120ShinseitodokedeJohoEntity> updatedRecord = sut.selectByKey(
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
            Optional<DbT4120ShinseitodokedeJohoEntity>   deleteRecord = sut.selectByKey(
                    DEFAULT_申請書管理番号);
           DbT4120ShinseitodokedeJohoEntity entity = new DbT4120ShinseitodokedeJohoEntity();
           entity.setShinseishoKanriNo(DEFAULT_申請書管理番号);
        
           sut.delete(entity);
           assertThat(sut.selectByKey(
                    DEFAULT_申請書管理番号), is(nullValue()));
        }
    }

    private static class TestSupport {

        public static void insert(
                ShinseishoKanriNo 申請書管理番号) {
            DbT4120ShinseitodokedeJohoEntity entity = DbT4120ShinseitodokedeJohoEntityGenerator.createDbT4120ShinseitodokedeJohoEntity();
            entity.setShinseishoKanriNo(申請書管理番号);
            sut.insert(entity);
        }
    }
}
