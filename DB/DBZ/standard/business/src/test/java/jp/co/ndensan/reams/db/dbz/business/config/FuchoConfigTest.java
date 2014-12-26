/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.config;

import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.ConfigKeysFucho;
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
 * {@link FuchoConfigTest}のテストです。
 *
 * @author N8156 宮本 康
 */
@RunWith(Enclosed.class)
public class FuchoConfigTest {

    public static class get extends DbaTestBase {

        private FuchoConfig sut;

        @Before
        public void setUp() {
            sut = new FuchoConfig(createBusinessConfigMock());
        }

        @Test
        public void 普徴期情報_月の期1を指定したとき_01が返る() {
            RString result = sut.get(ConfigKeysFucho.普徴期情報_月の期1);
            assertThat(result, is(new RString("01")));
        }

        @Test
        public void 普徴期情報_月の期2を指定したとき_02が返る() {
            RString result = sut.get(ConfigKeysFucho.普徴期情報_月の期2);
            assertThat(result, is(new RString("02")));
        }

        @Test
        public void 普徴期情報_月の期3を指定したとき_03が返る() {
            RString result = sut.get(ConfigKeysFucho.普徴期情報_月の期3);
            assertThat(result, is(new RString("03")));
        }

        @Test
        public void 普徴期情報_月の期4を指定したとき_04が返る() {
            RString result = sut.get(ConfigKeysFucho.普徴期情報_月の期4);
            assertThat(result, is(new RString("04")));
        }

        @Test
        public void 普徴期情報_月の期5を指定したとき_05が返る() {
            RString result = sut.get(ConfigKeysFucho.普徴期情報_月の期5);
            assertThat(result, is(new RString("05")));
        }

        @Test
        public void 普徴期情報_月の期6を指定したとき_06が返る() {
            RString result = sut.get(ConfigKeysFucho.普徴期情報_月の期6);
            assertThat(result, is(new RString("06")));
        }

        @Test
        public void 普徴期情報_月の期7を指定したとき_07が返る() {
            RString result = sut.get(ConfigKeysFucho.普徴期情報_月の期7);
            assertThat(result, is(new RString("07")));
        }

        @Test
        public void 普徴期情報_月の期8を指定したとき_08が返る() {
            RString result = sut.get(ConfigKeysFucho.普徴期情報_月の期8);
            assertThat(result, is(new RString("08")));
        }

        @Test
        public void 普徴期情報_月の期9を指定したとき_09が返る() {
            RString result = sut.get(ConfigKeysFucho.普徴期情報_月の期9);
            assertThat(result, is(new RString("09")));
        }

        @Test
        public void 普徴期情報_月の期10を指定したとき_10が返る() {
            RString result = sut.get(ConfigKeysFucho.普徴期情報_月の期10);
            assertThat(result, is(new RString("10")));
        }

        @Test
        public void 普徴期情報_月の期11を指定したとき_11が返る() {
            RString result = sut.get(ConfigKeysFucho.普徴期情報_月の期11);
            assertThat(result, is(new RString("11")));
        }

        @Test
        public void 普徴期情報_月の期12を指定したとき_12が返る() {
            RString result = sut.get(ConfigKeysFucho.普徴期情報_月の期12);
            assertThat(result, is(new RString("12")));
        }

        @Test
        public void 普徴期情報_月の期13を指定したとき_13が返る() {
            RString result = sut.get(ConfigKeysFucho.普徴期情報_月の期13);
            assertThat(result, is(new RString("13")));
        }

        @Test
        public void 普徴期情報_月の期14を指定したとき_14が返る() {
            RString result = sut.get(ConfigKeysFucho.普徴期情報_月の期14);
            assertThat(result, is(new RString("14")));
        }
    }

    private static IUrBusinessConfig createBusinessConfigMock() {
        IUrBusinessConfig mock = mock(IUrBusinessConfig.class);
        RDate nowDate = RDate.getNowDate();

        when(mock.get(ConfigKeysFucho.普徴期情報_月の期1, nowDate)).thenReturn(new RString("01"));
        when(mock.get(ConfigKeysFucho.普徴期情報_月の期2, nowDate)).thenReturn(new RString("02"));
        when(mock.get(ConfigKeysFucho.普徴期情報_月の期3, nowDate)).thenReturn(new RString("03"));
        when(mock.get(ConfigKeysFucho.普徴期情報_月の期4, nowDate)).thenReturn(new RString("04"));
        when(mock.get(ConfigKeysFucho.普徴期情報_月の期5, nowDate)).thenReturn(new RString("05"));
        when(mock.get(ConfigKeysFucho.普徴期情報_月の期6, nowDate)).thenReturn(new RString("06"));
        when(mock.get(ConfigKeysFucho.普徴期情報_月の期7, nowDate)).thenReturn(new RString("07"));
        when(mock.get(ConfigKeysFucho.普徴期情報_月の期8, nowDate)).thenReturn(new RString("08"));
        when(mock.get(ConfigKeysFucho.普徴期情報_月の期9, nowDate)).thenReturn(new RString("09"));
        when(mock.get(ConfigKeysFucho.普徴期情報_月の期10, nowDate)).thenReturn(new RString("10"));
        when(mock.get(ConfigKeysFucho.普徴期情報_月の期11, nowDate)).thenReturn(new RString("11"));
        when(mock.get(ConfigKeysFucho.普徴期情報_月の期12, nowDate)).thenReturn(new RString("12"));
        when(mock.get(ConfigKeysFucho.普徴期情報_月の期13, nowDate)).thenReturn(new RString("13"));
        when(mock.get(ConfigKeysFucho.普徴期情報_月の期14, nowDate)).thenReturn(new RString("14"));

        return mock;
    }
}
