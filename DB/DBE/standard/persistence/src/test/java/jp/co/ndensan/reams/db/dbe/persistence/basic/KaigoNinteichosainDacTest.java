/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.persistence.basic;

import java.util.Collections;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.ChosainJokyo;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.KaigoNinteichosainNo;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT7013ChosainJohoEntity;
import jp.co.ndensan.reams.db.dbe.entity.helper.KaigoNinteichosainTestHelper;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.KaigoJigyoshaNo;
import jp.co.ndensan.reams.db.dbz.testhelper.DbeTestDacBase;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.SystemException;
import jp.co.ndensan.reams.uz.uza.util.db._SQLOptimisticLockFaildException;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;

/**
 * 介護認定調査員情報のデータアクセスクラスのテストクラスです。
 *
 * @author N8187 久保田 英男
 */
@RunWith(Enclosed.class)
public class KaigoNinteichosainDacTest extends DbeTestDacBase {

    private static KaigoNinteichosainDac sut;

    @BeforeClass
    public static void setUpClass() {
        sut = InstanceProvider.create(KaigoNinteichosainDac.class);
    }

    public static class select_市町村コード_介護事業者番号_介護調査員番号 extends DbeTestDacBase {

        @Before
        public void setUp() {
            initializeEntityData();
        }

        @Test
        public void select_市町村コード_介護事業者番号_介護調査員番号_介護認定調査員情報が存在しない時_NULLを返す() {
            assertThat(sut.select(createShichosonCode("999999"), createKaigoJigyoshaNo("99999"), createKaigoNinteichosainNo("9999")), nullValue());
        }

        @Test
        public void select_市町村コード_介護事業者番号_介護調査員番号_介護認定調査員情報が存在する時_該当する情報を返す() {
            assertThat(sut.select(
                    createShichosonCode("123456"), createKaigoJigyoshaNo("12345"), createKaigoNinteichosainNo("1234")).getShichosonCode(),
                    is(createShichosonCode("123456")));
        }
    }

    public static class select_市町村コード_介護事業者番号_介護調査員番号_調査員の状況 extends DbeTestDacBase {

        @Before
        public void setUp() {
            initializeEntityData();
        }

        @Test
        public void select_市町村コード_介護事業者番号_介護調査員番号_調査員の状況_介護認定調査員情報が存在しない時_NULLを返す() {
            assertThat(sut.select(createShichosonCode("999999"), createKaigoJigyoshaNo("99999"), createKaigoNinteichosainNo("9999"), ChosainJokyo.無効), nullValue());
        }

        @Test
        public void select_市町村コード_介護事業者番号_介護調査員番号_調査員の状況_介護認定調査員情報が存在する時_該当する情報を返す() {
            assertThat(sut.select(
                    createShichosonCode("123456"), createKaigoJigyoshaNo("12345"), createKaigoNinteichosainNo("1234"), ChosainJokyo.有効).getShichosonCode(),
                    is(createShichosonCode("123456")));
        }
    }

    public static class selectAll_市町村コード_介護事業者番号 extends DbeTestDacBase {

        @Before
        public void setUp() {
            initializeEntityData();
        }

        @Test
        public void selectAll_市町村コード_介護事業者番号_介護認定調査員情報が存在しない時_EMPTYを返す() {
            assertThat(sut.selectAll(createShichosonCode("999999"), createKaigoJigyoshaNo("99999")), is(Collections.EMPTY_LIST));
        }

        @Test
        public void selectAll_市町村コード_介護事業者番号_介護認定調査員情報が1件存在する時_該当する情報を1件返す() {
            assertThat(sut.selectAll(createShichosonCode("123456"), createKaigoJigyoshaNo("12345")).size(), is(1));
        }

        @Test
        public void selectAll_市町村コード_介護事業者番号_介護認定調査員情報が2件存在する時_該当する情報を2件返す() {
            sut.insert(createEntity("123456", "12345", "1240", "123"));
            assertThat(sut.selectAll(createShichosonCode("123456"), createKaigoJigyoshaNo("12345")).size(), is(2));
        }
    }

    public static class selectAll_市町村コード_介護事業者番号_調査員の状況 extends DbeTestDacBase {

        @Before
        public void setUp() {
            initializeEntityData();
        }

        @Test
        public void selectAll_市町村コード_介護事業者番号_調査員の状況_介護認定調査員情報が存在しない時_EMPTYを返す() {
            assertThat(sut.selectAll(createShichosonCode("999999"), createKaigoJigyoshaNo("99999"), ChosainJokyo.無効), is(Collections.EMPTY_LIST));
        }

        @Test
        public void selectAll_市町村コード_介護事業者番号_調査員の状況_介護認定調査員情報が1件存在する時_該当する情報を1件返す() {
            assertThat(sut.selectAll(createShichosonCode("123456"), createKaigoJigyoshaNo("12345"), ChosainJokyo.有効).size(), is(1));
        }

        @Test
        public void selectAll_市町村コード_介護事業者番号_調査員の状況_介護認定調査員情報が2件存在する時_該当する情報を2件返す() {
            sut.insert(createEntity("123456", "12345", "1240", "123"));
            assertThat(sut.selectAll(createShichosonCode("123456"), createKaigoJigyoshaNo("12345"), ChosainJokyo.有効).size(), is(2));
        }
    }

    public static class selectAll_市町村コード_調査員の状況 extends DbeTestDacBase {

        @Before
        public void setUp() {
            initializeEntityData();
        }

        @Test
        public void selectAll_市町村コード_調査員の状況_介護認定調査員情報が存在しない時_EMPTYを返す() {
            assertThat(sut.selectAll(createShichosonCode("999999"), ChosainJokyo.無効), is(Collections.EMPTY_LIST));
        }

        @Test
        public void selectAll_市町村コード_調査員の状況_介護認定調査員情報が1件存在する時_該当する情報を1件返す() {
            assertThat(sut.selectAll(createShichosonCode("123456"), ChosainJokyo.有効).size(), is(1));
        }

        @Test
        public void selectAll_市町村コード_調査員の状況_介護認定調査員情報が2件存在する時_該当する情報を2件返す() {
            sut.insert(createEntity("123456", "12345", "1240", "123"));
            assertThat(sut.selectAll(createShichosonCode("123456"), ChosainJokyo.有効).size(), is(2));
        }
    }

    public static class selectAll_市町村コード extends DbeTestDacBase {

        @Before
        public void setUp() {
            initializeEntityData();
        }

        @Test
        public void selectAll_市町村コード_調査員の状況_介護認定調査員情報が存在しない時_EMPTYを返す() {
            assertThat(sut.selectAll(createShichosonCode("999999")), is(Collections.EMPTY_LIST));
        }

        @Test
        public void selectAll_市町村コード_調査員の状況_介護認定調査員情報が1件存在する時_該当する情報を1件返す() {
            assertThat(sut.selectAll(createShichosonCode("123456")).size(), is(1));
        }

        @Test
        public void selectAll_市町村コード_調査員の状況_介護認定調査員情報が2件存在する時_該当する情報を2件返す() {
            sut.insert(createEntity("123456", "12345", "1240", "123"));
            assertThat(sut.selectAll(createShichosonCode("123456")).size(), is(2));
        }
    }

    public static class insertOrUpdate extends DbeTestDacBase {

        @Before
        public void setUp() {
            initializeEntityData();
        }

        @Test
        public void insertOrUpdate_指定した介護認定調査員情報が存在しない時_指定した情報を追加する() {
            sut.insertOrUpdate(createEntity("123456", "12345", "1235", "123"));
            assertThat(sut.select(
                    createShichosonCode("123456"), createKaigoJigyoshaNo("12345"), createKaigoNinteichosainNo("1235")).getShichosonCode(),
                    is(createShichosonCode("123456")));
        }

        @Test
        public void insertOrUpdate_指定した介護認定調査員情報が存在する時_該当の情報を更新する() {
            sut.insertOrUpdate(createEntity("123456", "12345", "1234", "124"));
            assertThat(sut.select(
                    createShichosonCode("123456"), createKaigoJigyoshaNo("12345"), createKaigoNinteichosainNo("1234")).getShichosonCode(),
                    is(createShichosonCode("123456")));
        }
    }

    public static class insert extends DbeTestDacBase {

        @Before
        public void setUp() {
            initializeEntityData();
        }

        @Test
        public void insert_指定した介護認定調査員情報が存在しない時_成功する() {
            assertThat(sut.insert(createEntity("123456", "12345", "1235", "123")), is(1));
        }

        @Test
        public void insert_指定した介護認定調査員情報が存在しない時_指定した情報を追加する() {
            sut.insert(createEntity("123456", "12345", "1235", "123"));
            assertThat(sut.select(
                    createShichosonCode("123456"), createKaigoJigyoshaNo("12345"), createKaigoNinteichosainNo("1235")).getShichosonCode(),
                    is(createShichosonCode("123456")));
        }

        @Test(expected = SystemException.class)
        public void insert_指定した介護認定調査員情報が存在する時_失敗する() {
            sut.insert(createEntity("123456", "12345", "1234", "123"));
        }
    }

    public static class update extends DbeTestDacBase {

        @Before
        public void setUp() {
            initializeEntityData();
        }

        @Test
        public void update_指定した介護認定調査員情報が存在する時_成功する() {
            assertThat(sut.update(createEntity("123456", "12345", "1234", "124")), is(1));
        }

        @Test
        public void update_指定した介護認定調査員情報が存在する時_該当の情報を更新する() {
            sut.update(createEntity("123456", "12345", "1234", "124"));
            assertThat(sut.select(
                    createShichosonCode("123456"), createKaigoJigyoshaNo("12345"), createKaigoNinteichosainNo("1234")).getShichosonCode(),
                    is(createShichosonCode("123456")));
        }

        @Test(expected = _SQLOptimisticLockFaildException.class)
        public void update_指定した介護認定調査員情報が存在しない時_失敗する() {
            assertThat(sut.update(createEntity("123456", "12345", "1235", "123")), is(0));
        }
    }

    public static class delete extends DbeTestDacBase {

        @Before
        public void setUp() {
            initializeEntityData();
        }

        @Test
        public void delete_指定した介護認定調査員情報が存在する時_成功する() {
            assertThat(sut.delete(createEntity("123456", "12345", "1234", "123")), is(1));
        }

        @Test
        public void delete_指定した介護認定調査員情報が存在する時_deleteは_該当の情報を削除する() {
            sut.delete(createEntity("123456", "12345", "1234", "123"));
            assertThat(sut.select(createShichosonCode("123456"), createKaigoJigyoshaNo("12345"), createKaigoNinteichosainNo("1234")), nullValue());
        }

        @Test(expected = _SQLOptimisticLockFaildException.class)
        public void delete_指定した介護認定調査員情報が存在しない時_deleteは_失敗する() {
            assertThat(sut.delete(createEntity("123456", "12345", "1250", "124")), is(0));
        }
    }

    private static void initializeEntityData() {
        sut.insert(createEntity("123456", "12345", "1234", "123"));
    }

    private static LasdecCode createShichosonCode(String no) {
        return new LasdecCode(new RString(no));
    }

    private static KaigoJigyoshaNo createKaigoJigyoshaNo(String no) {
        return new KaigoJigyoshaNo(new RString(no));
    }

    private static KaigoNinteichosainNo createKaigoNinteichosainNo(String no) {
        return new KaigoNinteichosainNo(new RString(no));
    }

    private static DbT7013ChosainJohoEntity createEntity(String 市町村コード, String 介護事業者番号, String 介護調査員番号, String 事業者番号) {
        DbT7013ChosainJohoEntity entity = KaigoNinteichosainTestHelper.create認定調査員Entity();
        entity.setShichosonCode(createShichosonCode(市町村コード));
        entity.setKaigoJigyoshaNo(new RString(介護事業者番号));
        entity.setKaigoChosainNo(new RString(介護調査員番号));
        entity.setJigyoshaNo(new RString(事業者番号));
        entity.setKaigoChosainJokyo(ChosainJokyo.有効.getCode());
        return entity;
    }
}
