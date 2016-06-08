/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.config;

import jp.co.ndensan.reams.db.dbz.definition.core.enumeratedtype.configkeys.ConfigKeysKaigoToiawasesaki;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
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
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.mock;

/**
 * {@link KaigoToiawasesakiConfig}のテストです。
 */
@Ignore
@RunWith(Enclosed.class)
public class KaigoToiawasesakiConfigTest {

    private static final RString 問合せ先_管理単位;
    private static final RString EUC共通_文字コード;

    static {
        問合せ先_管理単位 = new RString("0");
        EUC共通_文字コード = new RString("1");
    }

    public static class get extends DbzTestBase {

        static KaigoToiawasesakiConfig sut;

        @Before
        public void setUp() {
            createBusinessConfigMock();
            sut = new KaigoToiawasesakiConfig();
        }

        @Test
        public void 問合せ先_管理単位を指定したとき_0が返る() {
            RString result = sut.get問合せ先_管理単位();
            assertThat(result, is(問合せ先_管理単位));
        }

        @Test
        public void EUC共通_文字コードを指定したとき_1が返る() {
            RString result = sut.getEUC共通_文字コード();
            assertThat(result, is(EUC共通_文字コード));
        }

    }

    private static BusinessConfig createBusinessConfigMock() {
        BusinessConfig mock = mock(BusinessConfig.class);
        when(mock.get(eq(ConfigKeysKaigoToiawasesaki.問合せ先_管理単位), any(RDate.class))).thenReturn(問合せ先_管理単位);
        when(mock.get(eq(ConfigKeysKaigoToiawasesaki.EUC共通_文字コード), any(RDate.class))).thenReturn(EUC共通_文字コード);
        return mock;
    }
}
