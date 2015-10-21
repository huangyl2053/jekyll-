/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.config;

import jp.co.ndensan.reams.db.dbz.definition.core.enumeratedtype.configkeys.ConfigKeysHihokenshashoItakudaikoHyoji;
import jp.co.ndensan.reams.db.dbz.definition.core.enumeratedtype.configvalues.HihokenshashoItakudaikoHyoji;
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
 * {@link HihokenshashoItakudaikoHyojiConfig}のテストです。
 *
 * @author N8187 久保田 英男
 */
@RunWith(Enclosed.class)
public class HihokenshashoItakudaikoHyojiConfigTest extends DbzTestBase {

    public static class get extends DbzTestBase {

        static HihokenshashoItakudaikoHyojiConfig sut;

        @Before
        public void setUp() {
            createBusinessConfigMock();
            sut = new HihokenshashoItakudaikoHyojiConfig();
        }

        @Test
        public void 被保険者証表示方法_委託代行業者_表示有無を指定したとき_業務コンフィグ設定値が返る() {
            HihokenshashoItakudaikoHyoji result = sut.get被保険者証表示方法_委託代行業者_表示有無();
            assertThat(result, is(HihokenshashoItakudaikoHyoji.非表示));
        }

        @Test
        public void 被保険者証表示方法_委託代行業者_表示開始文言を指定したとき_業務コンフィグ設定値が返る() {
            RString result = sut.get被保険者証表示方法_委託代行業者_表示開始文言();
            assertThat(result, is(委託代行業者_表示開始文言));
        }

        @Test
        public void 被保険者証表示方法_委託代行業者_表示終了文言を指定したとき_業務コンフィグ設定値が返る() {
            RString result = sut.get被保険者証表示方法_委託代行業者_表示終了文言();
            assertThat(result, is(委託代行業者_表示終了文言));
        }
    }

    private static final HihokenshashoItakudaikoHyoji 委託代行業者_表示有無;
    private static final RString 委託代行業者_表示開始文言;
    private static final RString 委託代行業者_表示終了文言;

    static {
        委託代行業者_表示有無 = HihokenshashoItakudaikoHyoji.非表示;
        委託代行業者_表示開始文言 = new RString("（委託先：");
        委託代行業者_表示終了文言 = new RString("）");
    }

    private static BusinessConfig createBusinessConfigMock() {
        BusinessConfig mock = mock(BusinessConfig.class);
        when(mock.get(
                eq(ConfigKeysHihokenshashoItakudaikoHyoji.被保険者証表示方法_委託代行業者_表示有無),
                any(RDate.class),
                eq(SubGyomuCode.DBA介護資格)
        )).thenReturn(委託代行業者_表示有無.code());
        when(mock.get(
                eq(ConfigKeysHihokenshashoItakudaikoHyoji.被保険者証表示方法_委託代行業者_表示開始文言),
                any(RDate.class),
                eq(SubGyomuCode.DBA介護資格)
        )).thenReturn(委託代行業者_表示開始文言);
        when(mock.get(
                eq(ConfigKeysHihokenshashoItakudaikoHyoji.被保険者証表示方法_委託代行業者_表示終了文言),
                any(RDate.class),
                eq(SubGyomuCode.DBA介護資格)
        )).thenReturn(委託代行業者_表示終了文言);
        return mock;
    }
}
