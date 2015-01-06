/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.config;

import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.configkeys.ConfigKeysHihokenshashoItakudaikoHyoji;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.configvalues.ConfigValuesHihokenshashoItakudaikoHyoji;
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
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * {@link HihokenshashoItakudaikoHyojiConfig}のテストです。
 *
 * @author N8187 久保田 英男
 */
@RunWith(Enclosed.class)
public class HihokenshashoItakudaikoHyojiConfigTest extends DbzTestBase {

    public static class get {

        private HihokenshashoItakudaikoHyojiConfig sut;

        @Before
        public void setUp() {
            sut = new HihokenshashoItakudaikoHyojiConfig(createBusinessConfigMock());
        }

        @Test
        public void 被保険者証表示方法_委託代行業者_表示有無を指定したとき_業務コンフィグ設定値が返る() {
            ConfigValuesHihokenshashoItakudaikoHyoji result = sut.get被保険者証表示方法_委託代行業者_表示有無();
            assertThat(result, is(ConfigValuesHihokenshashoItakudaikoHyoji.toValue(new RString("0"))));
        }

        @Test
        public void 被保険者証表示方法_委託代行業者_表示開始文言を指定したとき_業務コンフィグ設定値が返る() {
            RString result = sut.get被保険者証表示方法_委託代行業者_表示開始文言();
            assertThat(result, is(new RString("（委託先：")));
        }

        @Test
        public void 被保険者証表示方法_委託代行業者_表示終了文言を指定したとき_業務コンフィグ設定値が返る() {
            RString result = sut.get被保険者証表示方法_委託代行業者_表示終了文言();
            assertThat(result, is(new RString("）")));
        }
    }

    private static IUrBusinessConfig createBusinessConfigMock() {
        IUrBusinessConfig mock = mock(IUrBusinessConfig.class);
        RDate nowDate = RDate.getNowDate();

        when(mock.get(
                ConfigKeysHihokenshashoItakudaikoHyoji.被保険者証表示方法_委託代行業者_表示有無,
                nowDate,
                SubGyomuCode.DBA介護資格
        )).thenReturn(new RString("0"));
        when(mock.get(
                ConfigKeysHihokenshashoItakudaikoHyoji.被保険者証表示方法_委託代行業者_表示開始文言,
                nowDate,
                SubGyomuCode.DBA介護資格
        )).thenReturn(new RString("（委託先："));
        when(mock.get(
                ConfigKeysHihokenshashoItakudaikoHyoji.被保険者証表示方法_委託代行業者_表示終了文言,
                nowDate,
                SubGyomuCode.DBA介護資格
        )).thenReturn(new RString("）"));
        return mock;
    }
}
