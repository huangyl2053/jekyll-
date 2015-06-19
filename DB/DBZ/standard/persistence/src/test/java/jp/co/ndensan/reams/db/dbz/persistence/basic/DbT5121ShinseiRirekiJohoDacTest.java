/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.basic;

import java.util.Collections;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT5121ShinseiRirekiJohoEntity;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT5121ShinseiRirekiJohoEntityGenerator;
import static jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT5121ShinseiRirekiJohoEntityGenerator.*;
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
import org.junit.Ignore;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link DbT5121ShinseiRirekiJohoDac}のテストです。
 *
 * @author n8223 朴義一
 */
@RunWith(Enclosed.class)
public class DbT5121ShinseiRirekiJohoDacTest extends DbdTestDacBase {

    private static final ShinseishoKanriNo 申請管理番号 = new ShinseishoKanriNo("00000000001");
    private static final ShinseishoKanriNo 申請管理番号00000000001 = new ShinseishoKanriNo("00000000002");
    private static final RString キー_02 = new RString("02");
    private static final RString キー_03 = new RString("03");
    private static DbT5121ShinseiRirekiJohoDac sut;

    @BeforeClass
    public static void setUpClass() {
        sut = InstanceProvider.create(DbT5121ShinseiRirekiJohoDac.class);
    }

    public static class selectByKeyのテスト extends DbdTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    申請管理番号);
            TestSupport.insert(
                    DEFAULT_申請管理番号);
        }

        @Test(expected = NullPointerException.class)
        public void 申請管理番号がnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    null);
        }

        @Test
        public void 存在する主キーを渡すと_selectByKeyは_該当のエンティティを返す() {
            Optional<DbT5121ShinseiRirekiJohoEntity> insertedRecord = sut.selectByKey(
                    DEFAULT_申請管理番号);
            assertThat(insertedRecord, is(notNullValue()));
        }

        @Test
        public void 存在しない主キーを渡すと_selectByKeyは_nullを返す() {
            Optional<DbT5121ShinseiRirekiJohoEntity> insertedRecord = sut.selectByKey(
                    申請管理番号00000000001);
            assertThat(insertedRecord.isPresent(), is(false));
        }
    }

    @Ignore("テストデータの件数は可変なので、エラーとしない")
    public static class selectAllのテスト extends DbdTestDacBase {

        @Test
        public void 申請履歴情報が存在する場合_selectAllは_全件を返す() {
            TestSupport.insert(
                    DEFAULT_申請管理番号);
            assertThat(sut.selectAll().size(), is(1));
        }

        @Test
        public void 申請履歴情報が存在しない場合_selectAllは_空のリストを返す() {
            assertThat(sut.selectAll(), is(Collections.EMPTY_LIST));
        }
    }

    public static class insertのテスト extends DbdTestDacBase {

        @Test
        public void 申請履歴情報エンティティを渡すと_insertは_申請履歴情報を追加する() {
            TestSupport.insert(
                    DEFAULT_申請管理番号);

            assertThat(sut.selectByKey(
                    DEFAULT_申請管理番号), is(notNullValue()));
        }
    }

    public static class updateのテスト extends DbdTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    申請管理番号00000000001);
        }

        @Test
        public void 申請履歴情報エンティティを渡すと_updateは_申請履歴情報を更新する() {
            DbT5121ShinseiRirekiJohoEntity updateRecord = DbT5121ShinseiRirekiJohoEntityGenerator.createDbT5121ShinseiRirekiJohoEntity();
            updateRecord.setShinseishoKanriNo(申請管理番号00000000001);

            sut.update(updateRecord);

            Optional<DbT5121ShinseiRirekiJohoEntity> updatedRecord = sut.selectByKey(
                    申請管理番号00000000001);

            assertThat(updateRecord.getShinseishoKanriNo(), is(updatedRecord.get().getShinseishoKanriNo()));
        }
    }

    public static class deleteのテスト extends DbdTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    DEFAULT_申請管理番号);
        }

        @Test
        public void 申請履歴情報エンティティを渡すと_deleteは_申請履歴情報を削除する() {
            sut.delete(sut.selectByKey(
                    DEFAULT_申請管理番号).get());
            assertThat(sut.selectByKey(
                    DEFAULT_申請管理番号).isPresent(), is(false));
        }
    }

    private static class TestSupport {

        public static void insert(
                ShinseishoKanriNo 申請管理番号) {
            DbT5121ShinseiRirekiJohoEntity entity = DbT5121ShinseiRirekiJohoEntityGenerator.createDbT5121ShinseiRirekiJohoEntity();
            entity.setShinseishoKanriNo(申請管理番号);
            sut.insert(entity);
        }
    }
}
