/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.config;

import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.configkeys.ConfigKeysShikakushashoKigen;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.ur.urz.business.config.IUrBusinessConfig;
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
 * {@link ShikakushashoKigenConfig}のテストです。
 *
 * @author N8187 久保田 英男
 */
@RunWith(Enclosed.class)
public class ShikakushashoKigenConfigTest extends DbzTestBase {

    public static class get {

        private ShikakushashoKigenConfig sut;

        @Before
        public void setUp() {
//            sut = new ShikakushashoKigenConfig(createBusinessConfigMock());
            sut = new ShikakushashoKigenConfig();
        }

        @Test
        public void 資格者証期限_有効期限加算値を指定したとき_業務コンフィグ設定値が返る() {
            RString result = sut.get資格者証期限_有効期限加算値();
            assertThat(result, is(new RString("30")));
        }

        @Test
        public void 資格者証期限_有効期限初期表示を指定したとき_業務コンフィグ設定値が返る() {
            RString result = sut.get資格者証期限_有効期限初期表示();
            assertThat(result, is(new RString("3")));
        }

    }

    private static IUrBusinessConfig createBusinessConfigMock() {
        IUrBusinessConfig mock = mock(IUrBusinessConfig.class);
        RDate nowDate = RDate.getNowDate();

        when(mock.get(
                ConfigKeysShikakushashoKigen.資格者証期限_有効期限加算値,
                nowDate
        )).thenReturn(new RString("30"));
        when(mock.get(
                ConfigKeysShikakushashoKigen.資格者証期限_有効期限初期表示,
                nowDate
        )).thenReturn(new RString("3"));
        return mock;
    }
}
