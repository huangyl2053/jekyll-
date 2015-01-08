/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.config;

import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.configkeys.ConfigKeysShikakushashoItakudaikoHyoji;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.configvalues.ShikakushashoItakudaikoHyoji;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.ur.urz.business.config.IUrBusinessConfig;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.mock;

/**
 * {@link ShikakushashoItakudaikoHyojiConfig}のテストです。
 *
 * @author N8187 久保田 英男
 */
@RunWith(Enclosed.class)
public class ShikakushashoItakudaikoHyojiConfigTest extends DbzTestBase {

    public static class get {

        private ShikakushashoItakudaikoHyojiConfig sut;

        @Before
        public void setUp() {
            sut = new ShikakushashoItakudaikoHyojiConfig(createBusinessConfigMock());
        }

        @Test
        public void 資格者証表示方法_委託代行業者の表示有無を指定したとき_業務コンフィグ設定値が返る() {
            ShikakushashoItakudaikoHyoji result = sut.get資格者証表示方法_委託代行業者の表示有無();
            assertThat(result, is(ShikakushashoItakudaikoHyoji.非表示));
        }

        @Test
        public void 資格者証表示方法_委託代行業者表示開始文言を指定したとき_業務コンフィグ設定値が返る() {
            RString result = sut.get資格者証表示方法_委託代行業者表示開始文言();
            assertThat(result, is(new RString("（委託先：")));
        }

        @Test
        public void 資格者証表示方法_委託代行業者表示終了文言を指定したとき_業務コンフィグ設定値が返る() {
            RString result = sut.get資格者証表示方法_委託代行業者表示終了文言();
            assertThat(result, is(new RString("）")));
        }

    }

    private static IUrBusinessConfig createBusinessConfigMock() {
        IUrBusinessConfig mock = mock(IUrBusinessConfig.class);
        RDate nowDate = RDate.getNowDate();

        when(mock.get(
                ConfigKeysShikakushashoItakudaikoHyoji.資格者証表示方法_委託代行業者の表示有無,
                nowDate,
                SubGyomuCode.DBD介護受給
        )).thenReturn(ShikakushashoItakudaikoHyoji.非表示.code());
        when(mock.get(
                ConfigKeysShikakushashoItakudaikoHyoji.資格者証表示方法_委託代行業者表示開始文言,
                nowDate,
                SubGyomuCode.DBD介護受給
        )).thenReturn(new RString("（委託先："));
        when(mock.get(
                ConfigKeysShikakushashoItakudaikoHyoji.資格者証表示方法_委託代行業者表示終了文言,
                nowDate,
                SubGyomuCode.DBD介護受給
        )).thenReturn(new RString("）"));
        return mock;
    }
}
