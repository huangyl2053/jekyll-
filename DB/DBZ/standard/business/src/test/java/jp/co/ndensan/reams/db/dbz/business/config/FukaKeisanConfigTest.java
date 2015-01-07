/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.config;

import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.ConfigKeysFukaKeisan;
import jp.co.ndensan.reams.db.dbz.testhelper.DbaTestBase;
import jp.co.ndensan.reams.ur.urz.business.config.IUrBusinessConfig;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import org.junit.Before;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
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

        private FukaKeisanConfig sut;

        @Before
        public void setUp() {
            sut = new FukaKeisanConfig(createBusinessConfigMock());
        }

        @Test
        public void ランク管理情報_納期統一年度を指定したとき_2000が返る() {
            RString result = sut.get(ConfigKeysFukaKeisan.ランク管理情報_納期統一年度);
            assertThat(result, is(new RString("2000")));
        }
    }

    private static IUrBusinessConfig createBusinessConfigMock() {
        IUrBusinessConfig mock = mock(IUrBusinessConfig.class);
        RDate nowDate = RDate.getNowDate();

        when(mock.get(ConfigKeysFukaKeisan.ランク管理情報_納期統一年度, nowDate)).thenReturn(new RString("2000"));

        return mock;
    }
}
