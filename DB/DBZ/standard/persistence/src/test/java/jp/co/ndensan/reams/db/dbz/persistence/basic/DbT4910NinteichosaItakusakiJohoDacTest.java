/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.basic;

import java.util.Collections;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ninteishinsei.ChosaItakusakiCode;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT4910NinteichosaItakusakiJohoEntity;
import static jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT1010TennyushutsuHoryuTaishoshaEntityGenerator.DEFAULT_市町村コード;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT4910NinteichosaItakusakiJohoEntityGenerator;
import static jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT4910NinteichosaItakusakiJohoEntityGenerator.DEFAULT_認定調査委託先コード;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestDacBase;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
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
 * {@link DbT4910NinteichosaItakusakiJohoDac}のテストです。
 */
@RunWith(Enclosed.class)
public class DbT4910NinteichosaItakusakiJohoDacTest extends DbzTestDacBase {

    private static final RString キー_01 = new RString("01");
    private static final RString キー_02 = new RString("02");
    private static final RString キー_03 = new RString("03");
    private static DbT4910NinteichosaItakusakiJohoDac sut;

    @BeforeClass
    public static void setUpClass() {
        sut = InstanceProvider.create(DbT4910NinteichosaItakusakiJohoDac.class);
    }

    public static class selectByKeyのテスト extends DbzTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    DEFAULT_市町村コード,
                    DEFAULT_認定調査委託先コード);
            TestSupport.insert(
                    DEFAULT_市町村コード,
                    DEFAULT_認定調査委託先コード);
        }

        @Test(expected = NullPointerException.class)
        public void 市町村コードがnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    DEFAULT_市町村コード,
                    DEFAULT_認定調査委託先コード);
        }

        @Test(expected = NullPointerException.class)
        public void 認定調査委託先コードがnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    DEFAULT_市町村コード,
                    DEFAULT_認定調査委託先コード);
        }

        @Test
        public void 存在する主キーを渡すと_selectByKeyは_該当のエンティティを返す() {
            DbT4910NinteichosaItakusakiJohoEntity insertedRecord = sut.selectByKey(
                    DEFAULT_市町村コード,
                    DEFAULT_認定調査委託先コード);
            assertThat(insertedRecord, is(notNullValue()));
        }

        @Test
        public void 存在しない主キーを渡すと_selectByKeyは_nullを返す() {
            DbT4910NinteichosaItakusakiJohoEntity insertedRecord = sut.selectByKey(
                    DEFAULT_市町村コード,
                    DEFAULT_認定調査委託先コード);
            assertThat(insertedRecord, is(nullValue()));
        }
    }

    public static class selectAllのテスト extends DbzTestDacBase {

        @Test
        public void 認定調査委託先情報が存在する場合_selectAllは_全件を返す() {
            TestSupport.insert(
                    DEFAULT_市町村コード,
                    DEFAULT_認定調査委託先コード);
            TestSupport.insert(
                    DEFAULT_市町村コード,
                    DEFAULT_認定調査委託先コード);
            assertThat(sut.selectAll().size(), is(2));
        }

        @Test
        public void 認定調査委託先情報が存在しない場合_selectAllは_空のリストを返す() {
            assertThat(sut.selectAll(), is(Collections.EMPTY_LIST));
        }
    }

    public static class insertのテスト extends DbzTestDacBase {

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

    public static class updateのテスト extends DbzTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    DEFAULT_市町村コード,
                    DEFAULT_認定調査委託先コード);
        }

        @Test
        public void 認定調査委託先情報エンティティを渡すと_updateは_認定調査委託先情報を更新する() {
            DbT4910NinteichosaItakusakiJohoEntity updateRecord = sut.selectByKey(
                    DEFAULT_市町村コード,
                    DEFAULT_認定調査委託先コード);
            // TODO  主キー以外の項目を変更してください
            // updateRecord.set変更したい項目(75);

            sut.save(updateRecord);

            DbT4910NinteichosaItakusakiJohoEntity updatedRecord = sut.selectByKey(
                    DEFAULT_市町村コード,
                    DEFAULT_認定調査委託先コード);

            // TODO  主キー以外の項目を変更してください
            // assertThat(updateRecord.get変更したい項目(), is(updatedRecord.get変更したい項目()));
        }
    }

    public static class deleteのテスト extends DbzTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    DEFAULT_市町村コード,
                    DEFAULT_認定調査委託先コード);
        }

        @Test
        public void 認定調査委託先情報エンティティを渡すと_deleteは_認定調査委託先情報を削除する() {
            DbT4910NinteichosaItakusakiJohoEntity deletedEntity = sut.selectByKey(
                    DEFAULT_市町村コード,
                    DEFAULT_認定調査委託先コード);
            deletedEntity.setState(EntityDataState.Deleted);

            sut.save(deletedEntity);

            assertThat(sut.selectByKey(
                    DEFAULT_市町村コード,
                    DEFAULT_認定調査委託先コード), is(nullValue()));
        }
    }

    private static class TestSupport {

        public static void insert(
                LasdecCode 市町村コード,
                ChosaItakusakiCode 認定調査委託先コード) {
            DbT4910NinteichosaItakusakiJohoEntity entity = DbT4910NinteichosaItakusakiJohoEntityGenerator.createDbT4910NinteichosaItakusakiJohoEntity();
            entity.setShichosonCode(市町村コード);
            entity.setNinteichosaItakusakiCode(認定調査委託先コード);
            sut.save(entity);
        }
    }
}
