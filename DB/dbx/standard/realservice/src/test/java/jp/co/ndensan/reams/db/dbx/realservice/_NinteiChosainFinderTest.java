/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.realservice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbx.business.IKaigoJigyosha;
import jp.co.ndensan.reams.db.dbx.business.INinteiChosain;
import jp.co.ndensan.reams.db.dbx.business.KaigoJigyosha;
import jp.co.ndensan.reams.db.dbx.entity.basic.ChosainJohoEntity;
import jp.co.ndensan.reams.db.dbx.persistence.basic.IChosainJohoDac;
import jp.co.ndensan.reams.db.dbx.realservice.helper.MockChosainJohoEntity;
import jp.co.ndensan.reams.db.dbx.testhelper.DbxTestBase;
import jp.co.ndensan.reams.uz.uza.biz.KaigoJigyoshaNo;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsNull.nullValue;
import static org.junit.Assert.assertThat;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * {@link _NinteiChosainFinder}のテストクラスです。
 *
 * @author N2204 三井 沙織
 */
//TODO n3317 塚田萌　介護事業者の修正が完了したら見直しをする。
@Ignore
@RunWith(Enclosed.class)
public class _NinteiChosainFinderTest extends DbxTestBase {

    private static _NinteiChosainFinder sut;
    private static IChosainJohoDac dac;
    private static IKaigoJigyoshaFinder finder;

    @BeforeClass
    public static void test() {
        dac = mock(IChosainJohoDac.class);
        finder = mock(IKaigoJigyoshaFinder.class);
        sut = new _NinteiChosainFinder(dac, finder);
    }

    public static class get認定調査員test extends DbxTestBase {

        @Test(expected = NullPointerException.class)
        public void 引数の介護調査員番号にnullを渡すと_get認定調査員は_NullPointerExceptionを発生させる() {
            sut.get認定調査員(null);
        }

        @Test
        public void 実在しない介護調査員番号を渡すと_get認定調査員は_nullを返す() {
            when(dac.selectByNumber(any(RString.class))).thenReturn(null);
            INinteiChosain result = sut.get認定調査員(new RString("実在しない介護調査員番号"));
            assertThat(result, is(nullValue()));
        }

        @Test
        public void 実在する介護調査員番号を渡すと_get認定調査員は_該当の認定調査員番号を返す() {
            ChosainJohoEntity entity = MockChosainJohoEntity.getSpiedInstance();
            when(dac.selectByNumber(new RString("00000001"))).thenReturn(entity);
            when(finder.get特定の事業者番号の介護事業者(new RString("1000000001"))).thenReturn(create介護事業者());
            INinteiChosain result = sut.get認定調査員(new RString("00000001"));
            assertThat(result.get介護調査員番号(), is(new RString("00000001")));
        }

        private static IKaigoJigyosha create介護事業者() {
            return new KaigoJigyosha(new KaigoJigyoshaNo("0000000001"),
                    FlexibleDate.MAX, FlexibleDate.MAX, new ShikibetsuCode(new RString("00000001")),
                    RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, FlexibleDate.MAX,
                    RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY,
                    FlexibleDate.MAX, FlexibleDate.MAX, FlexibleDate.MAX, FlexibleDate.MAX);
        }
    }

    public static class get所属認定調査員test extends DbxTestBase {

        @Test(expected = NullPointerException.class)
        public void 引数の所属事業者にnullを渡すと_get所属認定調査員は_NullPointerExceptionを発生させる() {
            sut.get所属認定調査員(null);
        }

        @Test
        public void 指定した事業者に認定調査員がいないと_get所属認定調査員は_空のリストを返す() {
            when(dac.selectByJigyoshaCode(any(KaigoJigyoshaNo.class))).thenReturn(Collections.EMPTY_LIST);
            IKaigoJigyosha 事業者 = mock(IKaigoJigyosha.class);
            when(事業者.get事業者番号()).thenReturn(new KaigoJigyoshaNo("0000000002"));
            List<INinteiChosain> result = sut.get所属認定調査員(事業者);
            assertThat(result, is(Collections.EMPTY_LIST));
        }

        @Test
        public void 指定した事業者に認定調査員が2名いると_get所属認定調査員は_認定調査員2名を含むリストを返す() {
            ChosainJohoEntity entity = MockChosainJohoEntity.getSpiedInstance();
            List<ChosainJohoEntity> entityList = new ArrayList<>();
            entityList.add(entity);
            entityList.add(entity);
            when(dac.selectByJigyoshaCode(new KaigoJigyoshaNo("1000000001"))).thenReturn(entityList);
            IKaigoJigyosha 事業者 = create介護事業者();
            List<INinteiChosain> result = sut.get所属認定調査員(事業者);
            assertThat(result.size(), is(2));
        }

        private static IKaigoJigyosha create介護事業者() {
            return new KaigoJigyosha(new KaigoJigyoshaNo("1000000001"),
                    FlexibleDate.MAX, FlexibleDate.MAX, new ShikibetsuCode(new RString("00000001")),
                    RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, FlexibleDate.MAX,
                    RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY,
                    FlexibleDate.MAX, FlexibleDate.MAX, FlexibleDate.MAX, FlexibleDate.MAX);
        }
    }
}
