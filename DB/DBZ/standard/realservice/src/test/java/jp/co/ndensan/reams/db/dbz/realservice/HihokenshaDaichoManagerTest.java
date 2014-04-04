/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.realservice;

import jp.co.ndensan.reams.db.dbz.business.HihokenshaShikaku;
import jp.co.ndensan.reams.db.dbz.business.IHihokenshaShikaku;
import jp.co.ndensan.reams.db.dbz.business.ShikakuShutoku;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT1001HihokenshaDaichoEntity;
import jp.co.ndensan.reams.db.dbz.entity.helper.DbT1001HihokenshaDaichoEntityMock;
import jp.co.ndensan.reams.db.dbz.persistence.basic.HihokenshaDaichoDac;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.ShikakuHihokenshaKubun;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.*;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import org.junit.Test;
import org.junit.Before;

/**
 * HihokenshaDaichoManagerのテストです。
 *
 * @author N3327 三浦 凌
 */
@RunWith(Enclosed.class)
public class HihokenshaDaichoManagerTest extends DbzTestBase {

    public static class save extends DbzTestBase {

        private HihokenshaDaichoManager sut;
        private HihokenshaDaichoDac dac;
        private IHihokenshaShikaku shikaku;

        @Before
        public void setUp() {
            dac = mock(HihokenshaDaichoDac.class);
            sut = new HihokenshaDaichoManager(dac);
            shikaku = new HihokenshaShikaku.Builder(new LasdecCode("123456"), new ShikibetsuCode("1234567890"),
                    RDateTime.of(2014, 3, 14, 15, 0),
                    ShikakuHihokenshaKubun.第１号被保険者, FlexibleDate.MAX, ShikakuShutoku.NOTHING)
                    .build();
        }

        @Test
        public void saveは_dacによる更新結果が1件以上のとき_trueを返す() {
            when(dac.insert(any(DbT1001HihokenshaDaichoEntity.class))).thenReturn(1);
            assertThat(sut.save(shikaku), is(true));
        }

        @Test
        public void saveは_dacによる更新結果が0件のとき_falseを返す() {
            when(dac.insert(any(DbT1001HihokenshaDaichoEntity.class))).thenReturn(0);
            assertThat(sut.save(shikaku), is(false));
        }
    }

    public static class remove extends DbzTestBase {

        private HihokenshaDaichoManager sut;
        private HihokenshaDaichoDac dac;
        private IHihokenshaShikaku shikaku;

        @Before
        public void setUp() {
            dac = mock(HihokenshaDaichoDac.class);
            sut = new HihokenshaDaichoManager(dac);
            shikaku = new HihokenshaShikaku.Builder(new LasdecCode("123456"), new ShikibetsuCode("1234567890"),
                    RDateTime.of(2014, 3, 14, 15, 0),
                    ShikakuHihokenshaKubun.第１号被保険者, FlexibleDate.MAX, ShikakuShutoku.NOTHING)
                    .build();
        }

        @Test
        public void removeは_dacによる更新結果が1件以上のとき_trueを返す() {
            when(dac.delete(any(DbT1001HihokenshaDaichoEntity.class))).thenReturn(1);
            assertThat(sut.remove(shikaku), is(true));
        }

        @Test
        public void removeは_dacによる更新結果が0件のとき_falseを返す() {
            when(dac.delete(any(DbT1001HihokenshaDaichoEntity.class))).thenReturn(0);
            assertThat(sut.save(shikaku), is(false));
        }
    }

    public static class TestClass1 extends DbzTestBase {

        @Before
        public void setUp() {
        }

        @Test
        public void testClass1は_のとき_する返す() {
//            IHihokenshaShikaku shikaku = mock(IHihokenshaShikaku.class);
//            when(shikaku.get被保険者番号()).thenReturn(new KaigoHihokenshaNo(a));
//            assertThat(a, is(shikaku.get被保険者番号().value()));
        }
    }

    @RunWith(Enclosed.class)
    public static class TestClass2 extends DbzTestBase {

        @Before
        public void setUp() {
        }

        public static class instanceOf extends DbzTestBase {

            @Test
            public void ShoKisaiHokenshaNoは_IKaigoValueObjectのインスタンスである() {
//                ShoKisaiHokenshaNo sut = new ShoKisaiHokenshaNo(n00000);
//                assertThat(sut, is(instanceOf(IKaigoValueObject.class)));
            }
        }

        public static class Value extends DbzTestBase {

            @Test
            public void valueは_コンストラクタの引数に指定したRStringと_同じ値を返す() {
//                RString sameValue = n00000;
//                ShoKisaiHokenshaNo sut = new ShoKisaiHokenshaNo(sameValue);
//                assertThat(sut.value(), is(sameValue));
            }
        }
    }
}
