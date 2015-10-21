/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.config;

import jp.co.ndensan.reams.db.dbz.definition.core.enumeratedtype.ConfigKeysNenreiTotatsuKijunJoho;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
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
 * {@link NenreiTotatsuKijunConfigTest}のテストです。
 *
 * @author n8178 城間篤人
 */
@RunWith(Enclosed.class)
public class NenreiTotatsuKijunConfigTest extends DbzTestBase {

    public static class get extends DbzTestBase {

        static NenreiTotatsuKijunConfig sut;

        @Before
        public void setUp() {
            createBusinessConfigMock();
            sut = new NenreiTotatsuKijunConfig();
        }

        @Test
        public void 年齢到達基準_第１号被保険者到達基準年齢を指定したとき_65が返る() {
            int result = sut.get(ConfigKeysNenreiTotatsuKijunJoho.年齢到達基準_第１号被保険者到達基準年齢);
            assertThat(result, is(Integer.parseInt(第１号被保険者到達基準年齢.toString())));
        }

        @Test
        public void 年齢到達基準_第２号被保険者到達基準年齢を指定したとき_40が返る() {
            int result = sut.get(ConfigKeysNenreiTotatsuKijunJoho.年齢到達基準_第２号被保険者到達基準年齢);
            assertThat(result, is(Integer.parseInt(第２号被保険者到達基準年齢.toString())));
        }
    }

    private static final RString 第１号被保険者到達基準年齢;
    private static final RString 第２号被保険者到達基準年齢;

    static {
        第１号被保険者到達基準年齢 = new RString("65");
        第２号被保険者到達基準年齢 = new RString("40");
    }

    private static BusinessConfig createBusinessConfigMock() {
        BusinessConfig mock = mock(BusinessConfig.class);
        when(mock.get(
                eq(ConfigKeysNenreiTotatsuKijunJoho.年齢到達基準_第１号被保険者到達基準年齢),
                any(RDate.class)
        )).thenReturn(第１号被保険者到達基準年齢);
        when(mock.get(
                eq(ConfigKeysNenreiTotatsuKijunJoho.年齢到達基準_第２号被保険者到達基準年齢),
                any(RDate.class)
        )).thenReturn(第２号被保険者到達基準年齢);
        return mock;
    }
}
