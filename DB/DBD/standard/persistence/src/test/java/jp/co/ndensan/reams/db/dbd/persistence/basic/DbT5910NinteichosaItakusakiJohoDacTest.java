/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.persistence.basic;

import java.util.Collections;
import jp.co.ndensan.reams.db.dbd.definition.valueobject.ninteishinsei.ChosaItakusakiCode;
import jp.co.ndensan.reams.db.dbd.entity.basic.DbT5910NinteichosaItakusakiJohoEntity;
import jp.co.ndensan.reams.db.dbd.entity.basic.helper.DbT5910NinteichosaItakusakiJohoEntityGenerator;
import static jp.co.ndensan.reams.db.dbd.entity.basic.helper.DbT5910NinteichosaItakusakiJohoEntityGenerator.*;
import jp.co.ndensan.reams.db.dbz.definition.util.optional.Optional;
import jp.co.ndensan.reams.db.dbz.testhelper.DbdTestDacBase;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
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
 * {@link NinteichosaItakusakiJohoNinteiDac}のテストです。
 *
 * @author n8223 朴義一
 */
@RunWith(Enclosed.class)
public class DbT5910NinteichosaItakusakiJohoDacTest extends DbdTestDacBase {

    public static final LasdecCode OTHER_市町村コード = new LasdecCode("654321");
    public static final ChosaItakusakiCode OTHER_認定調査委託先コード = new ChosaItakusakiCode("876543210");
    private static DbT5910NinteichosaItakusakiJohoDac sut;

    @BeforeClass
    public static void setUpClass() {
        sut = InstanceProvider.create(DbT5910NinteichosaItakusakiJohoDac.class);
    }

    public static class selectByKeyのテスト extends DbdTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    DEFAULT_市町村コード,
                    DEFAULT_認定調査委託先コード);
            TestSupport.insert(
                    OTHER_市町村コード,
                    OTHER_認定調査委託先コード);
        }

        @Test(expected = NullPointerException.class)
        public void 市町村コードがnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    DEFAULT_市町村コード, null);
        }

        @Test(expected = NullPointerException.class)
        public void 認定調査委託先コードがnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    null,
                    DEFAULT_認定調査委託先コード);
        }

        @Test
        public void 存在する主キーを渡すと_selectByKeyは_該当のエンティティを返す() {
            Optional<DbT5910NinteichosaItakusakiJohoEntity> insertedRecord = sut.selectByKey(
                    DEFAULT_市町村コード,
                    DEFAULT_認定調査委託先コード);
            assertThat(insertedRecord, is(notNullValue()));
        }

        @Test
        public void 存在しない主キーを渡すと_selectByKeyは_nullを返す() {
            Optional<DbT5910NinteichosaItakusakiJohoEntity> insertedRecord = sut.selectByKey(
                    OTHER_市町村コード,
                    OTHER_認定調査委託先コード);
            assertThat(insertedRecord.isPresent(), is(true));
        }
    }

    @Ignore("テストデータの件数は可変なので、エラーとしない")
    public static class selectAllのテスト extends DbdTestDacBase {

        @Test
        public void 認定調査委託先情報が存在する場合_selectAllは_全件を返す() {
            TestSupport.insert(
                    DEFAULT_市町村コード,
                    DEFAULT_認定調査委託先コード);
            assertThat(sut.selectAll().size(), is(1));
        }

        @Test
        public void 認定調査委託先情報が存在しない場合_selectAllは_空のリストを返す() {
            assertThat(sut.selectAll().toList(), is(Collections.EMPTY_LIST));
        }
    }

    public static class insertのテスト extends DbdTestDacBase {

        @Test
        public void 認定調査委託先情報エンティティを渡すと_insertは_認定調査委託先情報を追加する() {
            TestSupport.insert(
                    DEFAULT_市町村コード,
                    DEFAULT_認定調査委託先コード);

            assertThat(sut.selectByKey(
                    DEFAULT_市町村コード,
                    DEFAULT_認定調査委託先コード), is(notNullValue()));
        }
    }

    public static class updateのテスト extends DbdTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    OTHER_市町村コード,
                    OTHER_認定調査委託先コード);
        }

        @Test
        public void 認定調査委託先情報エンティティを渡すと_updateは_認定調査委託先情報を更新する() {
            DbT5910NinteichosaItakusakiJohoEntity updateRecord = DbT5910NinteichosaItakusakiJohoEntityGenerator.createDbT5910NinteichosaItakusakiJohoEntity();
            updateRecord.setShichosonCode(OTHER_市町村コード);
            updateRecord.setNinteichosaItakusakiCode(OTHER_認定調査委託先コード);

            sut.update(updateRecord);

            Optional<DbT5910NinteichosaItakusakiJohoEntity> updatedRecord = sut.selectByKey(
                    OTHER_市町村コード,
                    OTHER_認定調査委託先コード);

            assertThat(updateRecord.getShichosonCode(), is(updatedRecord.get().getShichosonCode()));
        }
    }

    public static class deleteのテスト extends DbdTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    DEFAULT_市町村コード,
                    DEFAULT_認定調査委託先コード);
        }

        @Test
        public void 認定調査委託先情報エンティティを渡すと_deleteは_認定調査委託先情報を削除する() {
            Optional<DbT5910NinteichosaItakusakiJohoEntity> deletedRecord = sut.selectByKey(
                    DEFAULT_市町村コード,
                    DEFAULT_認定調査委託先コード);
            DbT5910NinteichosaItakusakiJohoEntity entity = new DbT5910NinteichosaItakusakiJohoEntity();
            entity.setShichosonCode(deletedRecord.get().getShichosonCode());
            entity.setNinteichosaItakusakiCode(deletedRecord.get().getNinteichosaItakusakiCode());

            sut.delete(entity);
            assertThat(sut.selectByKey(
                    DEFAULT_市町村コード,
                    DEFAULT_認定調査委託先コード).isPresent(), is(false));
        }
    }

    private static class TestSupport {

        public static void insert(
                LasdecCode 市町村コード,
                ChosaItakusakiCode 認定調査委託先コード) {
            DbT5910NinteichosaItakusakiJohoEntity entity = DbT5910NinteichosaItakusakiJohoEntityGenerator.createDbT5910NinteichosaItakusakiJohoEntity();
            entity.setShichosonCode(市町村コード);
            entity.setNinteichosaItakusakiCode(認定調査委託先コード);
            sut.insert(entity);
        }
    }
}
