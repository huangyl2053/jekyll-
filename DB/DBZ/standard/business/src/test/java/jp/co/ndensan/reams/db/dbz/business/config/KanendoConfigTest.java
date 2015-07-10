/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.config;

import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.ConfigKeysKanendo;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.ur.urz.business.config.IUrBusinessConfig;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import org.junit.Before;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

/**
 * {@link KanendoConfigTest}のテストです。
 *
 * @author N8156 宮本 康
 */
@RunWith(Enclosed.class)
public class KanendoConfigTest extends DbzTestBase {

    public static class get extends DbzTestBase {

        private KanendoConfig sut;

        @Before
        public void setUp() {
            sut = new KanendoConfig(createBusinessConfigMock());
        }

        @Test
        public void 過年度期情報_月の期1を指定したとき_01が返る() {
            RString result = sut.get(ConfigKeysKanendo.過年度期情報_月の期1);
            assertThat(result, is(月の期1));
        }

        @Test
        public void 過年度期情報_月の期2を指定したとき_02が返る() {
            RString result = sut.get(ConfigKeysKanendo.過年度期情報_月の期2);
            assertThat(result, is(月の期2));
        }

        @Test
        public void 過年度期情報_月の期3を指定したとき_03が返る() {
            RString result = sut.get(ConfigKeysKanendo.過年度期情報_月の期3);
            assertThat(result, is(月の期3));
        }

        @Test
        public void 過年度期情報_月の期4を指定したとき_04が返る() {
            RString result = sut.get(ConfigKeysKanendo.過年度期情報_月の期4);
            assertThat(result, is(月の期4));
        }

        @Test
        public void 過年度期情報_月の期5を指定したとき_05が返る() {
            RString result = sut.get(ConfigKeysKanendo.過年度期情報_月の期5);
            assertThat(result, is(月の期5));
        }

        @Test
        public void 過年度期情報_月の期6を指定したとき_06が返る() {
            RString result = sut.get(ConfigKeysKanendo.過年度期情報_月の期6);
            assertThat(result, is(月の期6));
        }

        @Test
        public void 過年度期情報_月の期7を指定したとき_07が返る() {
            RString result = sut.get(ConfigKeysKanendo.過年度期情報_月の期7);
            assertThat(result, is(月の期7));
        }

        @Test
        public void 過年度期情報_月の期8を指定したとき_08が返る() {
            RString result = sut.get(ConfigKeysKanendo.過年度期情報_月の期8);
            assertThat(result, is(月の期8));
        }

        @Test
        public void 過年度期情報_月の期9を指定したとき_09が返る() {
            RString result = sut.get(ConfigKeysKanendo.過年度期情報_月の期9);
            assertThat(result, is(月の期9));
        }

        @Test
        public void 過年度期情報_月の期10を指定したとき_10が返る() {
            RString result = sut.get(ConfigKeysKanendo.過年度期情報_月の期10);
            assertThat(result, is(月の期10));
        }

        @Test
        public void 過年度期情報_月の期11を指定したとき_11が返る() {
            RString result = sut.get(ConfigKeysKanendo.過年度期情報_月の期11);
            assertThat(result, is(月の期11));
        }

        @Test
        public void 過年度期情報_月の期12を指定したとき_12が返る() {
            RString result = sut.get(ConfigKeysKanendo.過年度期情報_月の期12);
            assertThat(result, is(月の期12));
        }
    }

    private static final RString 月の期1;
    private static final RString 月の期2;
    private static final RString 月の期3;
    private static final RString 月の期4;
    private static final RString 月の期5;
    private static final RString 月の期6;
    private static final RString 月の期7;
    private static final RString 月の期8;
    private static final RString 月の期9;
    private static final RString 月の期10;
    private static final RString 月の期11;
    private static final RString 月の期12;

    static {
        月の期1 = new RString("01");
        月の期2 = new RString("02");
        月の期3 = new RString("03");
        月の期4 = new RString("04");
        月の期5 = new RString("05");
        月の期6 = new RString("06");
        月の期7 = new RString("07");
        月の期8 = new RString("08");
        月の期9 = new RString("09");
        月の期10 = new RString("10");
        月の期11 = new RString("11");
        月の期12 = new RString("12");
    }

    private static IUrBusinessConfig createBusinessConfigMock() {
        IUrBusinessConfig mock = mock(IUrBusinessConfig.class);
        when(mock.get(eq(ConfigKeysKanendo.過年度期情報_月の期1), any(RDate.class))).thenReturn(月の期1);
        when(mock.get(eq(ConfigKeysKanendo.過年度期情報_月の期2), any(RDate.class))).thenReturn(月の期2);
        when(mock.get(eq(ConfigKeysKanendo.過年度期情報_月の期3), any(RDate.class))).thenReturn(月の期3);
        when(mock.get(eq(ConfigKeysKanendo.過年度期情報_月の期4), any(RDate.class))).thenReturn(月の期4);
        when(mock.get(eq(ConfigKeysKanendo.過年度期情報_月の期5), any(RDate.class))).thenReturn(月の期5);
        when(mock.get(eq(ConfigKeysKanendo.過年度期情報_月の期6), any(RDate.class))).thenReturn(月の期6);
        when(mock.get(eq(ConfigKeysKanendo.過年度期情報_月の期7), any(RDate.class))).thenReturn(月の期7);
        when(mock.get(eq(ConfigKeysKanendo.過年度期情報_月の期8), any(RDate.class))).thenReturn(月の期8);
        when(mock.get(eq(ConfigKeysKanendo.過年度期情報_月の期9), any(RDate.class))).thenReturn(月の期9);
        when(mock.get(eq(ConfigKeysKanendo.過年度期情報_月の期10), any(RDate.class))).thenReturn(月の期10);
        when(mock.get(eq(ConfigKeysKanendo.過年度期情報_月の期11), any(RDate.class))).thenReturn(月の期11);
        when(mock.get(eq(ConfigKeysKanendo.過年度期情報_月の期12), any(RDate.class))).thenReturn(月の期12);
        return mock;
    }
}
