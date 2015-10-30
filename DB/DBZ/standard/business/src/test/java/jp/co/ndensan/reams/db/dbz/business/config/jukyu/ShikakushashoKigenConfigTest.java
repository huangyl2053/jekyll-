/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.config.jukyu;

import jp.co.ndensan.reams.db.dbz.definition.core.enumeratedtype.configkeys.ConfigKeysShikakushashoKigen;
import jp.co.ndensan.reams.db.dbz.definition.core.enumeratedtype.configvalues.YukoKigenShokiHyoji;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.config.BusinessConfig;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * {@link ShikakushashoKigenConfig}のテストです。
 *
 * @author N8187 久保田 英男
 */
@Ignore
@RunWith(Enclosed.class)
public class ShikakushashoKigenConfigTest extends DbzTestBase {

    private static final RString 有効期限加算値;
    private static final YukoKigenShokiHyoji 有効期限初期表示;

    static {
        有効期限加算値 = new RString("30");
        有効期限初期表示 = YukoKigenShokiHyoji.更新区分申請時_従前認定終値比較;
    }

    public static BusinessConfig config() {
        BusinessConfig config = mock(BusinessConfig.class);
        when(config.get(
                eq(ConfigKeysShikakushashoKigen.資格者証期限_有効期限加算値),
                any(RDate.class),
                eq(SubGyomuCode.DBD介護受給)
        )).thenReturn(有効期限加算値);
        when(config.get(
                eq(ConfigKeysShikakushashoKigen.資格者証期限_有効期限初期表示),
                any(RDate.class),
                eq(SubGyomuCode.DBD介護受給)
        )).thenReturn(有効期限初期表示.code());
        return config;
    }

    public static class get extends DbzTestBase {

        static ShikakushashoKigenConfig sut;

        @Before
        public void setUp() {
            config();
            sut = new ShikakushashoKigenConfig();
        }

        @Test
        public void get資格者証期限_有効期限加算値は_業務コンフィグ設定値を返す() {
            int result = sut.get資格者証期限_有効期限加算値();
            assertThat(result, is(Integer.parseInt(有効期限加算値.toString())));
        }

        @Test
        public void get資格者証期限_有効期限初期表示は_業務コンフィグ設定値を返す() {
            YukoKigenShokiHyoji result = sut.get資格者証期限_有効期限初期表示();
            assertThat(result, is(有効期限初期表示));
        }
    }
}
