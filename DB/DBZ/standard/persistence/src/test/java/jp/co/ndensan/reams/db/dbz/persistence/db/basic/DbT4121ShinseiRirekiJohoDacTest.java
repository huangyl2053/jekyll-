/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.db.basic;

import java.util.Collections;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.definition.core.util.optional.Optional;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT4121ShinseiRirekiJohoEntityGenerator;
import static jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT4121ShinseiRirekiJohoEntityGenerator.DEFAULT_申請管理番号;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT4121ShinseiRirekiJohoEntity;
import jp.co.ndensan.reams.db.dbz.testhelper.DbdTestDacBase;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link DbT4121ShinseiRirekiJohoDac}のテストです。
 *
 * @author n8223 朴義一
 */
@RunWith(Enclosed.class)
public class DbT4121ShinseiRirekiJohoDacTest extends DbdTestDacBase {

    private static final ShinseishoKanriNo OTHER_申請書管理番号 = new ShinseishoKanriNo("00000000001");
    private static final ShinseishoKanriNo NOTFOUND_申請書管理番号 = new ShinseishoKanriNo("90000000002");
    private static DbT4121ShinseiRirekiJohoDac sut;

    @BeforeClass
    public static void setUpClass() {
        sut = InstanceProvider.create(DbT4121ShinseiRirekiJohoDac.class);
    }

    public static class selectByKeyのテスト extends DbdTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    OTHER_申請書管理番号);
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
            Optional<DbT4121ShinseiRirekiJohoEntity> insertedRecord = sut.selectByKey(
                    DEFAULT_申請管理番号);
            assertThat(insertedRecord, is(notNullValue()));
        }

        @Test
        public void 存在しない主キーを渡すと_selectByKeyは_nullを返す() {
            Optional<DbT4121ShinseiRirekiJohoEntity> insertedRecord = sut.selectByKey(
                    NOTFOUND_申請書管理番号);
            assertThat(insertedRecord.isPresent(), is(false));
        }
    }

    @Ignore("テストデータの件数は可変なので、エラーとしない")
    public static class selectAllのテスト extends DbdTestDacBase {

        @Test
        public void 申請履歴情報が存在する場合_selectAllは_全件を返す() {
            TestSupport.insert(
                    OTHER_申請書管理番号);
            assertThat(sut.selectAll().size(), is(1));
        }

        @Test
        public void 申請履歴情報が存在しない場合_selectAllは_空のリストを返す() {
            assertThat(sut.selectAll().toList(), is(Collections.EMPTY_LIST));
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
                    NOTFOUND_申請書管理番号);
        }

        @Test
        public void 申請履歴情報エンティティを渡すと_updateは_申請履歴情報を更新する() {
            DbT4121ShinseiRirekiJohoEntity updateRecord = DbT4121ShinseiRirekiJohoEntityGenerator.createDbT4121ShinseiRirekiJohoEntity();
            updateRecord.setShinseishoKanriNo(NOTFOUND_申請書管理番号);

            sut.save(updateRecord);

            Optional<DbT4121ShinseiRirekiJohoEntity> updatedRecord = sut.selectByKey(
                    NOTFOUND_申請書管理番号);

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
            sut.save(sut.selectByKey(
                    DEFAULT_申請管理番号).get());
            assertThat(sut.selectByKey(
                    DEFAULT_申請管理番号).isPresent(), is(false));
        }
    }

    private static class TestSupport {

        public static void insert(
                ShinseishoKanriNo OTHER_申請書管理番号) {
            DbT4121ShinseiRirekiJohoEntity entity = DbT4121ShinseiRirekiJohoEntityGenerator.createDbT4121ShinseiRirekiJohoEntity();
            entity.setShinseishoKanriNo(OTHER_申請書管理番号);
            sut.save(entity);
        }
    }
}
