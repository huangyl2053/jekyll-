/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.basic;

import jp.co.ndensan.reams.db.dbz.persistence.basic.DbT5102ShinsakaiNinteiKekkaJohoDac;
import java.util.Collections;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT5102NinteiKekkaJohoEntity;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT5102NinteiKekkaJohoEntityGenerator;
import static jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT5102NinteiKekkaJohoEntityGenerator.*;
import jp.co.ndensan.reams.db.dbz.definition.util.optional.Optional;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.testhelper.DbdTestDacBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import org.junit.Test;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link DbT5102ShinsakaiNinteiKekkaJohoDac}のテストです。
 *
 * @author n8223 朴義一
 */
@RunWith(Enclosed.class)
public class DbT5102ShinsakaiNinteiKekkaJohoDacTest extends DbdTestDacBase {

    private static final ShinseishoKanriNo OTHER_申請書管理番号 = new ShinseishoKanriNo("90000000000000009");
    private static final ShinseishoKanriNo 申請管理番号80000000000000002 = new ShinseishoKanriNo("80000000000000002");
    private static final RString キー_03 = new RString("03");
    private static DbT5102ShinsakaiNinteiKekkaJohoDac sut;

    @BeforeClass
    public static void setUpClass() {
        sut = InstanceProvider.create(DbT5102ShinsakaiNinteiKekkaJohoDac.class);
    }

    public static class selectByKeyのテスト extends DbdTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    DEFAULT_申請書管理番号);
            TestSupport.insert(
                    OTHER_申請書管理番号);
        }

        @Test(expected = NullPointerException.class)
        public void 申請書管理番号がnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    null);
        }

        @Test
        public void 存在する主キーを渡すと_selectByKeyは_該当のエンティティを返す() {
            Optional<DbT5102NinteiKekkaJohoEntity> insertedRecord = sut.selectByKey(
                    DEFAULT_申請書管理番号);
            assertThat(insertedRecord, is(notNullValue()));
        }

        @Test
        public void 存在しない主キーを渡すと_selectByKeyは_nullを返す() {
            Optional<DbT5102NinteiKekkaJohoEntity> insertedRecord = sut.selectByKey(
                    申請管理番号80000000000000002);
            assertThat(insertedRecord.isPresent(), is(false));
        }
    }

    public static class selectAllのテスト extends DbdTestDacBase {

        @Test
        public void 要介護認定結果情報が存在する場合_selectAllは_全件を返す() {
            TestSupport.insert(
                    DEFAULT_申請書管理番号);
            assertThat(sut.selectAll().size(), is(1));
        }

        @Test
        public void 要介護認定結果情報が存在しない場合_selectAllは_空のリストを返す() {
            assertThat(sut.selectAll(), is(Collections.EMPTY_LIST));
        }
    }

    public static class insertのテスト extends DbdTestDacBase {

        @Test
        public void 要介護認定結果情報エンティティを渡すと_insertは_要介護認定結果情報を追加する() {
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
                    申請管理番号80000000000000002);
        }

        @Test
        public void 要介護認定結果情報エンティティを渡すと_updateは_要介護認定結果情報を更新する() {
            DbT5102NinteiKekkaJohoEntity updateRecord = DbT5102NinteiKekkaJohoEntityGenerator.createDbT5102NinteiKekkaJohoEntity();
            updateRecord.setShinseishoKanriNo(申請管理番号80000000000000002);

            sut.update(updateRecord);

            Optional<DbT5102NinteiKekkaJohoEntity> updatedRecord = sut.selectByKey(
                    申請管理番号80000000000000002);

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
        public void 要介護認定結果情報エンティティを渡すと_deleteは_要介護認定結果情報を削除する() {
            sut.delete(sut.selectByKey(
                    DEFAULT_申請書管理番号).get());
            assertThat(sut.selectByKey(
                    DEFAULT_申請書管理番号).isPresent(), is(false));
        }
    }

    private static class TestSupport {

        public static void insert(
                ShinseishoKanriNo 申請書管理番号) {
            DbT5102NinteiKekkaJohoEntity entity = DbT5102NinteiKekkaJohoEntityGenerator.createDbT5102NinteiKekkaJohoEntity();
            entity.setShinseishoKanriNo(申請書管理番号);
            sut.insert(entity);
        }
    }
}
