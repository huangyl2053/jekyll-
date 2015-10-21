/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.config.jukyu;

import jp.co.ndensan.reams.db.dbz.definition.core.enumeratedtype.configkeys.ConfigKeysShikakushashoItakudaikoHyoji;
import jp.co.ndensan.reams.db.dbz.definition.core.enumeratedtype.configvalues.ShikakushashoItakudaikoHyoji;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.config.BusinessConfig;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * {@link ShikakushashoItakudaikoHyojiConfig}のテストです。
 *
 * @author N8187 久保田 英男
 */
@RunWith(Enclosed.class)
public class ShikakushashoItakudaikoHyojiConfigTest extends DbzTestBase {

    private static final ShikakushashoItakudaikoHyoji 委託代行業者の表示有無;
    private static final RString 委託代行業者表示開始文言;
    private static final RString 委託代行業者表示終了文言;

    static {
        委託代行業者の表示有無 = ShikakushashoItakudaikoHyoji.表示;
        委託代行業者表示開始文言 = new RString("（委託先：");
        委託代行業者表示終了文言 = new RString("）");
    }

    private static BusinessConfig createBusinessConfigMock() {
        BusinessConfig mock = mock(BusinessConfig.class);
        when(mock.get(
                eq(ConfigKeysShikakushashoItakudaikoHyoji.資格者証表示方法_委託代行業者の表示有無),
                any(RDate.class),
                eq(SubGyomuCode.DBD介護受給)
        )).thenReturn(委託代行業者の表示有無.code());
        when(mock.get(
                eq(ConfigKeysShikakushashoItakudaikoHyoji.資格者証表示方法_委託代行業者表示開始文言),
                any(RDate.class),
                eq(SubGyomuCode.DBD介護受給)
        )).thenReturn(委託代行業者表示開始文言);
        when(mock.get(
                eq(ConfigKeysShikakushashoItakudaikoHyoji.資格者証表示方法_委託代行業者表示終了文言),
                any(RDate.class),
                eq(SubGyomuCode.DBD介護受給)
        )).thenReturn(委託代行業者表示終了文言);
        return mock;
    }

    public static class get {

        static ShikakushashoItakudaikoHyojiConfig sut;

        @Before
        public void setUp() {
            createBusinessConfigMock();
            sut = new ShikakushashoItakudaikoHyojiConfig();
        }

        @Test
        public void get資格者証表示方法_委託代行業者の表示有無は_業務コンフィグ設定値を返す() {
            ShikakushashoItakudaikoHyoji result = sut.get資格者証表示方法_委託代行業者の表示有無();
            assertThat(result, is(委託代行業者の表示有無));
        }

        @Test
        public void get資格者証表示方法_委託代行業者表示開始文言は_業務コンフィグ設定値を返す() {
            RString result = sut.get資格者証表示方法_委託代行業者表示開始文言();
            assertThat(result, is(委託代行業者表示開始文言));
        }

        @Test
        public void get資格者証表示方法_委託代行業者表示終了文言は_業務コンフィグ設定値を返す() {
            RString result = sut.get資格者証表示方法_委託代行業者表示終了文言();
            assertThat(result, is(委託代行業者表示終了文言));
        }
    }
}
