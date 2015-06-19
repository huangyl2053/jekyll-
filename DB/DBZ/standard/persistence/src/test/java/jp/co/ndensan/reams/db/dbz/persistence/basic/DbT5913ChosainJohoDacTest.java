/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.basic;

import jp.co.ndensan.reams.db.dbz.persistence.basic.DbT5913ChosainJohoDac;
import java.util.Collections;
import jp.co.ndensan.reams.db.dbd.definition.valueobject.ninteishinsei.ChosaItakusakiCode;
import jp.co.ndensan.reams.db.dbd.definition.valueobject.ninteishinsei.ChosainCode;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT5913ChosainJohoEntity;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT5913ChosainJohoEntityGenerator;
import static jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT5913ChosainJohoEntityGenerator.*;
import jp.co.ndensan.reams.db.dbz.definition.util.optional.Optional;
import jp.co.ndensan.reams.db.dbz.testhelper.DbdTestDacBase;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import org.junit.Test;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link ChosainJohoNinteiDac}のテストです。
 *
 * @author n8223 朴義一
 */
@RunWith(Enclosed.class)
public class DbT5913ChosainJohoDacTest extends DbdTestDacBase {

    public static final LasdecCode OTHER_市町村コード = new LasdecCode("654321");
    public static final ChosaItakusakiCode OTHER_認定調査委託先コード = new ChosaItakusakiCode("9876543210");
    public static final ChosainCode OTHER_認定調査員コード = new ChosainCode("87654321");
    private static DbT5913ChosainJohoDac sut;

    @BeforeClass
    public static void setUpClass() {
        sut = InstanceProvider.create(DbT5913ChosainJohoDac.class);
    }

    public static class selectByKeyのテスト extends DbdTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    DEFAULT_市町村コード,
                    DEFAULT_認定調査委託先コード,
                    DEFAULT_認定調査員コード);
            TestSupport.insert(
                    OTHER_市町村コード,
                    OTHER_認定調査委託先コード,
                    OTHER_認定調査員コード);
        }

        @Test(expected = NullPointerException.class)
        public void 市町村コードがnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    null,
                    DEFAULT_認定調査委託先コード,
                    DEFAULT_認定調査員コード);
        }

        @Test(expected = NullPointerException.class)
        public void 認定調査委託先コードがnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    DEFAULT_市町村コード,
                    null,
                    DEFAULT_認定調査員コード);
        }

        @Test(expected = NullPointerException.class)
        public void 認定調査員コードがnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    DEFAULT_市町村コード,
                    DEFAULT_認定調査委託先コード,
                    null);
        }

        @Test
        public void 存在する主キーを渡すと_selectByKeyは_該当のエンティティを返す() {
            Optional<DbT5913ChosainJohoEntity> insertedRecord = sut.selectByKey(
                    DEFAULT_市町村コード,
                    DEFAULT_認定調査委託先コード,
                    DEFAULT_認定調査員コード);
            assertThat(insertedRecord, is(notNullValue()));
        }

        @Test
        public void 存在しない主キーを渡すと_selectByKeyは_nullを返す() {
            Optional<DbT5913ChosainJohoEntity> insertedRecord = sut.selectByKey(
                    DEFAULT_市町村コード,
                    DEFAULT_認定調査委託先コード,
                    DEFAULT_認定調査員コード);
            assertThat(insertedRecord.isPresent(), is(true));
        }
    }

    @Ignore("テストデータの件数は可変なので、エラーとしない")
    public static class selectAllのテスト extends DbdTestDacBase {

        @Test
        public void 調査員情報が存在する場合_selectAllは_全件を返す() {
            TestSupport.insert(
                    DEFAULT_市町村コード,
                    DEFAULT_認定調査委託先コード,
                    DEFAULT_認定調査員コード);
            assertThat(sut.selectAll().size(), is(1));
        }

        @Test
        public void 調査員情報が存在しない場合_selectAllは_空のリストを返す() {
            assertThat(sut.selectAll().toList(), is(Collections.EMPTY_LIST));
        }
    }

    public static class insertのテスト extends DbdTestDacBase {

        @Test
        public void 調査員情報エンティティを渡すと_insertは_調査員情報を追加する() {
            TestSupport.insert(
                    DEFAULT_市町村コード,
                    DEFAULT_認定調査委託先コード,
                    DEFAULT_認定調査員コード);

            assertThat(sut.selectByKey(
                    DEFAULT_市町村コード,
                    DEFAULT_認定調査委託先コード,
                    DEFAULT_認定調査員コード), is(notNullValue()));
        }
    }

    public static class updateのテスト extends DbdTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    OTHER_市町村コード,
                    OTHER_認定調査委託先コード,
                    OTHER_認定調査員コード);
        }

        @Test
        public void 調査員情報エンティティを渡すと_updateは_調査員情報を更新する() {
            DbT5913ChosainJohoEntity updateRecord = DbT5913ChosainJohoEntityGenerator.createDbT5913ChosainJohoEntity();
            updateRecord.setShichosonCode(OTHER_市町村コード);
            updateRecord.setNinteichosaItakusakiCode(OTHER_認定調査委託先コード);
            updateRecord.setNinteiChosainNo(OTHER_認定調査員コード);

            sut.update(updateRecord);

            Optional<DbT5913ChosainJohoEntity> updatedRecord = sut.selectByKey(
                    OTHER_市町村コード,
                    OTHER_認定調査委託先コード,
                    OTHER_認定調査員コード);
            assertThat(updateRecord.getShichosonCode(), is(updatedRecord.get().getShichosonCode()));
        }
    }

    public static class deleteのテスト extends DbdTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    DEFAULT_市町村コード,
                    DEFAULT_認定調査委託先コード,
                    DEFAULT_認定調査員コード);
        }

        @Test
        public void 調査員情報エンティティを渡すと_deleteは_調査員情報を削除する() {
            Optional<DbT5913ChosainJohoEntity> deleteRecord = sut.selectByKey(
                    DEFAULT_市町村コード,
                    DEFAULT_認定調査委託先コード,
                    DEFAULT_認定調査員コード);
            DbT5913ChosainJohoEntity entity = new DbT5913ChosainJohoEntity();
            entity.setShichosonCode(deleteRecord.get().getShichosonCode());
            entity.setNinteichosaItakusakiCode(deleteRecord.get().getNinteichosaItakusakiCode());
            entity.setNinteiChosainNo(deleteRecord.get().getNinteiChosainNo());

            sut.delete(entity);
            assertThat(sut.selectByKey(
                    DEFAULT_市町村コード,
                    DEFAULT_認定調査委託先コード,
                    DEFAULT_認定調査員コード).isPresent(), is(false));
        }
    }

    private static class TestSupport {

        public static void insert(
                LasdecCode 市町村コード,
                ChosaItakusakiCode 認定調査委託先コード,
                ChosainCode 認定調査員コード) {
            DbT5913ChosainJohoEntity entity = DbT5913ChosainJohoEntityGenerator.createDbT5913ChosainJohoEntity();
            entity.setShichosonCode(市町村コード);
            entity.setNinteichosaItakusakiCode(認定調査委託先コード);
            entity.setNinteiChosainNo(認定調査員コード);
            sut.insert(entity);
        }
    }
}
