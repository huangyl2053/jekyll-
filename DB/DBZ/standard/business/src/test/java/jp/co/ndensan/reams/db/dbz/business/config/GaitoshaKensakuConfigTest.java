/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.config;

import jp.co.ndensan.reams.db.dbz.definition.core.enumeratedtype.configkeys.ConfigKeysGaitoshaKensaku;
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
 * {@link GaitoshaKensakuConfigTest}のテストです。
 *
 * @author N8156 宮本 康
 */
@RunWith(Enclosed.class)
public class GaitoshaKensakuConfigTest {

    private static final RString 検索制御_最大取得件数 = new RString("100");

    public static class get extends DbzTestBase {

        static GaitoshaKensakuConfig sut;

        @Before
        public void setUp() {
            createBusinessConfigMock();
            sut = new GaitoshaKensakuConfig();
        }

        @Test
        public void 検索制御_最大取得件数を指定したとき_100が返る() {
            RString result = sut.get(ConfigKeysGaitoshaKensaku.検索制御_最大取得件数);
            assertThat(result, is(検索制御_最大取得件数));
        }
    }

    private static BusinessConfig createBusinessConfigMock() {
        BusinessConfig mock = mock(BusinessConfig.class);
        when(mock.get(eq(ConfigKeysGaitoshaKensaku.検索制御_最大取得件数), any(RDate.class), eq(SubGyomuCode.DBU介護統計報告))).thenReturn(検索制御_最大取得件数);
        return mock;
    }
}
