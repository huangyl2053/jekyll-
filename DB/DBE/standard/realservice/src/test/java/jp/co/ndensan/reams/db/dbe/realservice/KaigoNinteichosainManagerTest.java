/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.realservice;

import java.util.ArrayList;
import java.util.List;
import static jp.co.ndensan.reams.db.dbe.business.helper.KaigoNinteichosainTestHelper.create認定調査員;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.ChosainJokyo;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.KaigoNinteichosainNo;
//import jp.co.ndensan.reams.db.dbz.definition.valueobject.KaigoJigyoshaNo;
import jp.co.ndensan.reams.uz.uza.biz.KaigoJigyoshaNo;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT7010NinteichosaItakusakiJohoEntity;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT7013ChosainJohoEntity;
import jp.co.ndensan.reams.db.dbe.persistence.NinteichosaItakusakiDac;
import jp.co.ndensan.reams.db.dbe.persistence.basic.KaigoNinteichosainDac;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.testhelper.TestBase;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import static org.mockito.Mockito.*;
import static jp.co.ndensan.reams.db.dbe.entity.helper.KaigoNinteichosainTestHelper.*;
import jp.co.ndensan.reams.db.dbe.entity.helper.NinteichosaItakusakiTestHelper;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * 介護認定調査員情報を扱うクラスのテストです。
 *
 * @author N8187 久保田 英男
 */
@RunWith(Enclosed.class)
public class KaigoNinteichosainManagerTest extends TestBase {

    private static KaigoNinteichosainManager sut;
    private static LasdecCode 市町村コード;
    private static KaigoJigyoshaNo 介護事業者番号;
    private static KaigoNinteichosainNo 介護調査員番号;
    private static ChosainJokyo 調査員の状況;

    public static class get介護認定調査員_引数が_市町村コード_介護事業者番号_介護調査員番号 extends TestBase {

        @Override
        protected void setUp() {
            市町村コード = new LasdecCode(new RString("000001"));
            介護事業者番号 = new KaigoJigyoshaNo(new RString("002"));
            介護調査員番号 = new KaigoNinteichosainNo(new RString("003"));
        }

        @Test
        public void 引数に該当する介護認定調査員が登録されているとき_市町村コードに000001を持つ認定調査員情報が返る() {
            sut = new KaigoNinteichosainManager(createMockChosainDac(), createMockItakusakiDac());
            assertThat(sut.get介護認定調査員(市町村コード, 介護事業者番号, 介護調査員番号).get市町村コード().value(), is(市町村コード.value()));
        }

        @Test
        public void 引数に該当する介護認定調査員が登録されているとき_介護事業者番号に002を持つ認定調査員情報が返る() {
            sut = new KaigoNinteichosainManager(createMockChosainDac(), createMockItakusakiDac());
            assertThat(sut.get介護認定調査員(市町村コード, 介護事業者番号, 介護調査員番号).get介護事業者番号().value(), is(介護事業者番号.value()));
        }

        @Test
        public void 引数に該当する介護認定調査員が登録されているとき_介護調査員番号に003を持つ認定調査員情報が返る() {
            sut = new KaigoNinteichosainManager(createMockChosainDac(), createMockItakusakiDac());
            assertThat(sut.get介護認定調査員(市町村コード, 介護事業者番号, 介護調査員番号).get介護調査員番号().value(), is(介護調査員番号.value()));
        }
    }

    public static class get介護認定調査員_引数が_市町村コード_介護事業者番号_介護調査員番号_調査員の状況 extends TestBase {

        @Override
        protected void setUp() {
            市町村コード = new LasdecCode(new RString("000001"));
            介護事業者番号 = new KaigoJigyoshaNo(new RString("002"));
            介護調査員番号 = new KaigoNinteichosainNo(new RString("003"));
            調査員の状況 = ChosainJokyo.有効;
        }

        @Test
        public void 引数に該当する介護認定調査員が登録されているとき_市町村コードに000001を持つ認定調査員情報が返る() {
            sut = new KaigoNinteichosainManager(createMockChosainDac(), createMockItakusakiDac());
            assertThat(sut.get介護認定調査員(市町村コード, 介護事業者番号, 介護調査員番号, 調査員の状況).get市町村コード().value(), is(市町村コード.value()));
        }

        @Test
        public void 引数に該当する介護認定調査員が登録されているとき_介護事業者番号に002を持つ認定調査員情報が返る() {
            sut = new KaigoNinteichosainManager(createMockChosainDac(), createMockItakusakiDac());
            assertThat(sut.get介護認定調査員(市町村コード, 介護事業者番号, 介護調査員番号, 調査員の状況).get介護事業者番号().value(), is(介護事業者番号.value()));
        }

        @Test
        public void 引数に該当する介護認定調査員が登録されているとき_介護調査員番号に003を持つ認定調査員情報が返る() {
            sut = new KaigoNinteichosainManager(createMockChosainDac(), createMockItakusakiDac());
            assertThat(sut.get介護認定調査員(市町村コード, 介護事業者番号, 介護調査員番号, 調査員の状況).get介護調査員番号().value(), is(介護調査員番号.value()));
        }

        @Test
        public void 引数に該当する介護認定調査員が登録されているとき_調査員の状況が有効の認定調査員情報が返る() {
            sut = new KaigoNinteichosainManager(createMockChosainDac(), createMockItakusakiDac());
            assertThat(sut.get介護認定調査員(市町村コード, 介護事業者番号, 介護調査員番号, 調査員の状況).get介護調査員番号().value(), is(介護調査員番号.value()));
        }
    }

    public static class get介護認定調査員List_引数が_証記載保険者番号_介護事業者番号 extends TestBase {

        @Override
        protected void setUp() {
            市町村コード = new LasdecCode(new RString("000001"));
            介護事業者番号 = new KaigoJigyoshaNo(new RString("002"));
        }

        @Test
        public void 引数に該当する介護認定調査員が登録されていないとき_0件の認定調査員情報Listが返る() {
            sut = new KaigoNinteichosainManager(createMockChosainDac(0), createMockItakusakiDac());
            assertThat(sut.get介護認定調査員List(市町村コード, 介護事業者番号).isEmpty(), is(true));
        }

        @Test
        public void 引数に該当する介護認定調査員が1件登録されているとき_1件の認定調査員情報Listが返る() {
            sut = new KaigoNinteichosainManager(createMockChosainDac(1), createMockItakusakiDac());
            assertThat(sut.get介護認定調査員List(市町村コード, 介護事業者番号).size(), is(1));
        }

        @Test
        public void 引数に該当する介護認定調査員が3件登録されているとき_3件の認定調査員情報Listが返る() {
            sut = new KaigoNinteichosainManager(createMockChosainDac(3), createMockItakusakiDac());
            assertThat(sut.get介護認定調査員List(市町村コード, 介護事業者番号).size(), is(3));
        }
    }

    public static class get介護認定調査員List_引数が_市町村コード_介護事業者番号_調査員の状況 extends TestBase {

        @Override
        protected void setUp() {
            市町村コード = new LasdecCode(new RString("000001"));
            介護事業者番号 = new KaigoJigyoshaNo(new RString("002"));
            調査員の状況 = ChosainJokyo.有効;
        }

        @Test
        public void 引数に該当する介護認定調査員が登録されていないとき_0件の認定調査員情報Listが返る() {
            sut = new KaigoNinteichosainManager(createMockChosainDac(0), createMockItakusakiDac());
            assertThat(sut.get介護認定調査員List(市町村コード, 介護事業者番号, 調査員の状況).isEmpty(), is(true));
        }

        @Test
        public void 引数に該当する介護認定調査員が1件登録されているとき_1件の認定調査員情報Listが返る() {
            sut = new KaigoNinteichosainManager(createMockChosainDac(1), createMockItakusakiDac());
            assertThat(sut.get介護認定調査員List(市町村コード, 介護事業者番号, 調査員の状況).size(), is(1));
        }

        @Test
        public void 引数に該当する介護認定調査員が3件登録されているとき_3件の認定調査員情報Listが返る() {
            sut = new KaigoNinteichosainManager(createMockChosainDac(3), createMockItakusakiDac());
            assertThat(sut.get介護認定調査員List(市町村コード, 介護事業者番号, 調査員の状況).size(), is(3));
        }
    }

    public static class get介護認定調査員List_引数が_市町村コード_調査員の状況 extends TestBase {

        @Override
        protected void setUp() {
            市町村コード = new LasdecCode(new RString("000001"));
            調査員の状況 = ChosainJokyo.有効;
        }

        @Test
        public void 引数に該当する介護認定調査員が登録されていないとき_0件の認定調査員情報Listが返る() {
            sut = new KaigoNinteichosainManager(createMockChosainDac(0), createMockItakusakiDac());
            assertThat(sut.get介護認定調査員List(市町村コード, 調査員の状況).isEmpty(), is(true));
        }

        @Test
        public void 引数に該当する介護認定調査員が1件登録されているとき_1件の認定調査員情報Listが返る() {
            sut = new KaigoNinteichosainManager(createMockChosainDac(1), createMockItakusakiDac());
            assertThat(sut.get介護認定調査員List(市町村コード, 調査員の状況).size(), is(1));
        }

        @Test
        public void 引数に該当する介護認定調査員が3件登録されているとき_3件の認定調査員情報Listが返る() {
            sut = new KaigoNinteichosainManager(createMockChosainDac(3), createMockItakusakiDac());
            assertThat(sut.get介護認定調査員List(市町村コード, 調査員の状況).size(), is(3));
        }
    }

    public static class get介護認定調査員List_引数が_市町村コード extends TestBase {

        @Override
        protected void setUp() {
            市町村コード = new LasdecCode(new RString("000001"));
        }

        @Test
        public void 引数に該当する介護認定調査員が登録されていないとき_0件の認定調査員情報Listが返る() {
            sut = new KaigoNinteichosainManager(createMockChosainDac(0), createMockItakusakiDac());
            assertThat(sut.get介護認定調査員List(市町村コード).isEmpty(), is(true));
        }

        @Test
        public void 引数に該当する介護認定調査員が1件登録されているとき_1件の認定調査員情報Listが返る() {
            sut = new KaigoNinteichosainManager(createMockChosainDac(1), createMockItakusakiDac());
            assertThat(sut.get介護認定調査員List(市町村コード).size(), is(1));
        }

        @Test
        public void 引数に該当する介護認定調査員が3件登録されているとき_3件の認定調査員情報Listが返る() {
            sut = new KaigoNinteichosainManager(createMockChosainDac(3), createMockItakusakiDac());
            assertThat(sut.get介護認定調査員List(市町村コード).size(), is(3));
        }
    }

    public static class save extends TestBase {

        @Test
        public void saveに成功した場合_trueを返す() {
            sut = new KaigoNinteichosainManager(createMockSaveDac(1), createMockItakusakiDac());
            assertThat(sut.save(create認定調査員()), is(true));
        }

        @Test
        public void saveに失敗した場合_falseを返す() {
            sut = new KaigoNinteichosainManager(createMockSaveDac(0), createMockItakusakiDac());
            assertThat(sut.save(create認定調査員()), is(false));
        }

        private KaigoNinteichosainDac createMockSaveDac(int 件数) {
            KaigoNinteichosainDac dac = mock(KaigoNinteichosainDac.class);
            when(dac.insertOrUpdate(any(DbT7013ChosainJohoEntity.class))).thenReturn(件数);
            return dac;
        }
    }

    public static class remove extends TestBase {

        @Test
        public void removeに成功した場合_trueを返す() {
            sut = new KaigoNinteichosainManager(createMockRemoveDac(1), createMockItakusakiDac());
            assertThat(sut.remove(create認定調査員()), is(true));
        }

        @Test
        public void removeに失敗した場合_falseを返す() {
            sut = new KaigoNinteichosainManager(createMockRemoveDac(0), createMockItakusakiDac());
            assertThat(sut.remove(create認定調査員()), is(false));
        }

        private KaigoNinteichosainDac createMockRemoveDac(int 件数) {
            KaigoNinteichosainDac dac = mock(KaigoNinteichosainDac.class);
            when(dac.delete(any(DbT7013ChosainJohoEntity.class))).thenReturn(件数);
            return dac;
        }
    }

    private static KaigoNinteichosainDac createMockChosainDac() {
        KaigoNinteichosainDac dac = mock(KaigoNinteichosainDac.class);
        when(dac.select(市町村コード, 介護事業者番号, 介護調査員番号)).thenReturn(createChosainEntity(市町村コード, 介護事業者番号, 介護調査員番号));
        when(dac.select(市町村コード, 介護事業者番号, 介護調査員番号, 調査員の状況)).thenReturn(createChosainEntity(市町村コード, 介護事業者番号, 介護調査員番号, 調査員の状況));
        return dac;
    }

    private static DbT7013ChosainJohoEntity createChosainEntity(LasdecCode 市町村コード, KaigoJigyoshaNo 介護事業者番号, KaigoNinteichosainNo 介護調査員番号) {
        DbT7013ChosainJohoEntity entity = create認定調査員Entity();
        entity.setShichosonCode(市町村コード);
        entity.setKaigoJigyoshaNo(介護事業者番号.value());
        entity.setKaigoChosainNo(介護調査員番号.value());
        return entity;
    }

    private static DbT7013ChosainJohoEntity createChosainEntity(LasdecCode 市町村コード, KaigoJigyoshaNo 介護事業者番号, KaigoNinteichosainNo 介護調査員番号, ChosainJokyo 調査員の状況) {
        DbT7013ChosainJohoEntity entity = create認定調査員Entity();
        entity.setShichosonCode(市町村コード);
        entity.setKaigoJigyoshaNo(介護事業者番号.value());
        entity.setKaigoChosainNo(介護調査員番号.value());
        entity.setKaigoChosainJokyo(調査員の状況.有効.getCode());
        return entity;
    }

    private static KaigoNinteichosainDac createMockChosainDac(int 要素数) {
        KaigoNinteichosainDac dac = mock(KaigoNinteichosainDac.class);
        when(dac.selectAll(any(LasdecCode.class), any(KaigoJigyoshaNo.class))).thenReturn(createChosainEntity(要素数));
        when(dac.selectAll(any(LasdecCode.class), any(KaigoJigyoshaNo.class), any(ChosainJokyo.class))).thenReturn(createChosainEntity(要素数));
        when(dac.selectAll(any(LasdecCode.class), any(ChosainJokyo.class))).thenReturn(createChosainEntity(要素数));
        when(dac.selectAll(any(LasdecCode.class))).thenReturn(createChosainEntity(要素数));
        return dac;
    }

    private static List<DbT7013ChosainJohoEntity> createChosainEntity(int 要素数) {
        List<DbT7013ChosainJohoEntity> list = new ArrayList<>();
        for (int i = 0; i < 要素数; i++) {
            list.add(create認定調査員Entity());
        }
        return list;
    }

    private static NinteichosaItakusakiDac createMockItakusakiDac() {
        NinteichosaItakusakiDac dac = mock(NinteichosaItakusakiDac.class);
        when(dac.select(any(LasdecCode.class), any(KaigoJigyoshaNo.class), any(boolean.class))).thenReturn(createItakusakiEntity());
        return dac;
    }

    private static DbT7010NinteichosaItakusakiJohoEntity createItakusakiEntity() {
        DbT7010NinteichosaItakusakiJohoEntity entity = NinteichosaItakusakiTestHelper.create認定調査委託先Entity();
        return entity;
    }
}
