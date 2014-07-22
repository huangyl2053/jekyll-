/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.realservice;

import jp.co.ndensan.reams.db.dbz.business.JogaiJushochitokureiTaishoShisetsu;
import jp.co.ndensan.reams.db.dbz.business.NyushoShisetsu;
import jp.co.ndensan.reams.db.dbz.business.helper.ShisetsuNyutaishoMock;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.ShisetsuType;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ShisetsuCode;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.ur.urf.business.IKaigoJigyosha;
import jp.co.ndensan.reams.ur.urf.definition.enumeratedtype.KaigoHokenNyushoShisetsuBunrui;
import jp.co.ndensan.reams.ur.urf.realservice.IKaigoJigyoshaFinder;
import jp.co.ndensan.reams.ur.urz.business.shikibetsutaisho.IHojin;
import jp.co.ndensan.reams.ur.urz.realservice.IHojinFinder;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.assertThat;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * 入所施設を作成するクラスのテストクラスです。
 *
 * @author N3317 塚田 萌
 */
@RunWith(Enclosed.class)
public class NyushoShisetsuBuilderTest extends DbzTestBase {

    public static class build入所施設 extends DbzTestBase {

        private static NyushoShisetsuBuilder sut;

        private final ShisetsuCode 施設コード = new ShisetsuCode(new RString("1234567890"));
        private final FlexibleDate 入所日 = new FlexibleDate("20140403");

        @Test(expected = NullPointerException.class)
        public void 施設種類がnullの場合_build入所施設は_NullPointerExceptionを投げる() {
            sut = createBuilder();
            sut.build入所施設(null, 施設コード, 入所日);
        }

        @Test
        public void 施設種類が正しい値の場合_build入所施設は_入所施設を返す() {
            ShisetsuType 施設種類 = ShisetsuType.介護保険施設;
            sut = createBuilder();
            NyushoShisetsu result = sut.build入所施設(施設種類, 施設コード, 入所日);
            assertThat(result, instanceOf(NyushoShisetsu.class));
        }
    }

    private static NyushoShisetsuBuilder createBuilder() {
        return new NyushoShisetsuBuilder(createHojinFinderMock(),
                createJigyoshaFinderMock(), createjogaiJushochitokureiTaishoShisetsuFinderMock());
    }

    private static IHojinFinder createHojinFinderMock() {
        IHojinFinder HojinFinderMock = mock(IHojinFinder.class);
        IHojin hojinMock = ShisetsuNyutaishoMock.createHojinMock();

        //TODO n3317塚田萌　RDateからFlexibleDateに変更されたらRDateを修正。
        when(HojinFinderMock.get法人(any(ShikibetsuCode.class), any(RDate.class)))
                .thenReturn(hojinMock);

        return HojinFinderMock;
    }

    private static IKaigoJigyoshaFinder createJigyoshaFinderMock() {
        IKaigoJigyoshaFinder JigyoshaFinderMock = mock(IKaigoJigyoshaFinder.class);
        //TODO n3317塚田萌　get特定の事業者種別かつ事業者番号の介護事業者の修正が完了したらKaigoJigyoshaShubetsuを消す
        when(JigyoshaFinderMock.get特定の事業者番号の介護事業者(any(RString.class))).
                thenReturn(mock(IKaigoJigyosha.class));

        return JigyoshaFinderMock;
    }

    private static JogaiJushochitokureiTaishoShisetsuManager createjogaiJushochitokureiTaishoShisetsuFinderMock() {
        JogaiJushochitokureiTaishoShisetsuManager jogaiJushochitokureiTaishoShisetsuFinderMock
                = mock(JogaiJushochitokureiTaishoShisetsuManager.class);
        //TODO n3317塚田萌　RDateからFlexibleDateに変更されたらRDateを修正。
        when(jogaiJushochitokureiTaishoShisetsuFinderMock.get対象施設(any(ShisetsuType.class), any(ShisetsuCode.class)))
                .thenReturn(mock(JogaiJushochitokureiTaishoShisetsu.class));

        return jogaiJushochitokureiTaishoShisetsuFinderMock;
    }
}
