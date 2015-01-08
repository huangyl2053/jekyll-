/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.config.jukyu;

import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.configkeys.ConfigKeysShikakushashoKigen;
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
import static org.mockito.Mockito.*;

/**
 * {@link ShikakushashoKigenConfig}のテストです。
 *
 * @author N8187 久保田 英男
 */
@RunWith(Enclosed.class)
public class ShikakushashoKigenConfigTest extends DbzTestBase {

    private static final RString 有効期限加算値;
    private static final RString 有効期限初期表示;

    static {
        有効期限加算値 = new RString("30");
        有効期限初期表示 = new RString("3");
    }

    public static IUrBusinessConfig config() {
        IUrBusinessConfig config = mock(IUrBusinessConfig.class);
        when(config.get(
                eq(ConfigKeysShikakushashoKigen.資格者証期限_有効期限加算値),
                any(RDate.class),
                eq(SubGyomuCode.DBD介護受給)
        )).thenReturn(有効期限加算値);
        when(config.get(
                eq(ConfigKeysShikakushashoKigen.資格者証期限_有効期限初期表示),
                any(RDate.class),
                eq(SubGyomuCode.DBD介護受給)
        )).thenReturn(有効期限初期表示);
        return config;
    }

    public static class get extends DbzTestBase {

        private ShikakushashoKigenConfig sut;

        @Before
        public void setUp() {
            sut = new ShikakushashoKigenConfig(config());
        }

        @Test
        public void get資格者証期限_有効期限加算値は_業務コンフィグ設定値を返す() {
            int result = sut.get資格者証期限_有効期限加算値();
            assertThat(result, is(Integer.parseInt(有効期限加算値.toString())));
        }

        @Test
        public void get資格者証期限_有効期限初期表示は_業務コンフィグ設定値を返す() {
            RString result = sut.get資格者証期限_有効期限初期表示();
            assertThat(result, is(有効期限初期表示));
        }
    }
}
