/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.business.core;

import java.lang.reflect.Constructor;
import jp.co.ndensan.reams.db.dbx.testhelper.DbxTestBase;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Range;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import static org.mockito.Mockito.mock;

/**
 * 介護サービス種類のファクトリークラスのテストクラスです。
 *
 * @author LDNS 郭旗
 */
@RunWith(Enclosed.class)
public class KaigoServiceNaiyoFactoryTest extends DbxTestBase {

    private static final IKaigoServiceCode サービスコード = mock(IKaigoServiceCode.class);
    private static final Range<FlexibleYearMonth> 適用年月 = new Range(FlexibleYearMonth.MIN, FlexibleYearMonth.MAX);
    private static final RString サービス名称 = new RString("123456");
    private static final RString サービス略称 = new RString("234");
    private static final IKaigoServiceTani 介護サービス単位 = mock(IKaigoServiceTani.class);

    public static class getInstanceのテスト extends DbxTestBase {

        @Test
        public void LDNS_メソッドgetInstanceが呼び出される場合_getInstanceは_123456を返す() {
            _KaigoServiceNaiyo result = KaigoServiceNaiyoFactory.getInstance(サービスコード, 適用年月, 3, サービス名称, サービス略称, 介護サービス単位);
            assertThat(result.getサービス名称(), is(new RString("123456")));
        }

    }

    public static class コンストラクタのテスト extends DbxTestBase {

        @Test
        public void LDNS_メソッドKaigoServiceNaiyoFactoryが呼び出される場合_KaigoServiceNaiyoFactoryは_インスタンス化成功() throws Exception {
            Constructor<KaigoServiceNaiyoFactory> constructor = KaigoServiceNaiyoFactory.class.getDeclaredConstructor();
            constructor.setAccessible(true);
            constructor.newInstance();
        }
    }

}
