/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.persistence.basic;

import java.util.Collections;
import jp.co.ndensan.reams.db.dbd.entity.basic.DbT5910NinteichosaItakusakiJohoEntity;
import jp.co.ndensan.reams.db.dbd.entity.basic.helper.DbT5910NinteichosaItakusakiJohoEntityGenerator;
import static jp.co.ndensan.reams.db.dbd.entity.basic.helper.DbT5910NinteichosaItakusakiJohoEntityGenerator.*;
import jp.co.ndensan.reams.db.dbz.testhelper.DbdTestDacBase;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ShichosonCode;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RYear;
import jp.co.ndensan.reams.uz.uza.lang.RYearMonth;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
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
 * {@link NinteichosaItakusakiJohoNinteiDac}のテストです。
 *
 * @author n8223 朴義一
 */
@RunWith(Enclosed.class)
public class DbT5910NinteichosaItakusakiJohoDacTest extends DbdTestDacBase {

    private static final RString キー_01 = new RString("01");
    private static final RString キー_02 = new RString("02");
    private static final RString キー_03 = new RString("03");
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
            DbT5910NinteichosaItakusakiJohoEntity insertedRecord = sut.selectByKey(
                    DEFAULT_市町村コード,
                    DEFAULT_認定調査委託先コード);
            assertThat(insertedRecord, is(notNullValue()));
        }

        @Test
        public void 存在しない主キーを渡すと_selectByKeyは_nullを返す() {
            DbT5910NinteichosaItakusakiJohoEntity insertedRecord = sut.selectByKey(
                    DEFAULT_市町村コード,
                    DEFAULT_認定調査委託先コード);
            assertThat(insertedRecord, is(nullValue()));
        }
    }

    public static class selectAllのテスト extends DbdTestDacBase {

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
                    DEFAULT_市町村コード,
                    DEFAULT_認定調査委託先コード);
        }

        @Test
        public void 認定調査委託先情報エンティティを渡すと_updateは_認定調査委託先情報を更新する() {
            DbT5910NinteichosaItakusakiJohoEntity updateRecord = DbT5910NinteichosaItakusakiJohoEntityGenerator.createDbT5910NinteichosaItakusakiJohoEntity();
//            updateRecord.set変更したい項目(75);

            sut.update(updateRecord);

            DbT5910NinteichosaItakusakiJohoEntity updatedRecord = sut.selectByKey(
                    DEFAULT_市町村コード,
                    DEFAULT_認定調査委託先コード);

//            assertThat(updateRecord.get変更したい項目(), is(updatedRecord.get変更したい項目()));
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
            sut.delete(sut.selectByKey(
                    DEFAULT_市町村コード,
                    DEFAULT_認定調査委託先コード));
            assertThat(sut.selectByKey(
                    DEFAULT_市町村コード,
                    DEFAULT_認定調査委託先コード), is(nullValue()));
        }
    }

    private static class TestSupport {

        public static void insert(
                ShichosonCode 市町村コード,
                RString 認定調査委託先コード) {
            DbT5910NinteichosaItakusakiJohoEntity entity = DbT5910NinteichosaItakusakiJohoEntityGenerator.createDbT5910NinteichosaItakusakiJohoEntity();
            entity.setShichosonCode(市町村コード);
            entity.setNinteichosaItakusakiCode(認定調査委託先コード);
            sut.insert(entity);
        }
    }
}
