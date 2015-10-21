/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.config;

import jp.co.ndensan.reams.db.dbz.definition.core.enumeratedtype.ConfigKeysFukaKeisan;
import jp.co.ndensan.reams.db.dbz.testhelper.DbaTestBase;
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
 * {@link FukaKeisanConfigTest}のテストです。
 *
 * @author N8156 宮本 康
 */
@RunWith(Enclosed.class)
public class FukaKeisanConfigTest {

    public static class get extends DbaTestBase {

        static FukaKeisanConfig sut;

        @Before
        public void setUp() {
            createBusinessConfigMock();
            sut = new FukaKeisanConfig();
        }

        @Test
        public void ランク管理情報_納期統一年度を指定したとき_2000が返る() {
            RString result = sut.get(ConfigKeysFukaKeisan.ランク管理情報_納期統一年度);
            assertThat(result, is(納期統一年度));
        }
    }

    private static final RString 納期統一年度;

    static {
        納期統一年度 = new RString("2000");
    }

    private static BusinessConfig createBusinessConfigMock() {
        BusinessConfig mock = mock(BusinessConfig.class);
        when(mock.get(eq(ConfigKeysFukaKeisan.ランク管理情報_納期統一年度), any(RDate.class))).thenReturn(納期統一年度);
        return mock;
    }
}
