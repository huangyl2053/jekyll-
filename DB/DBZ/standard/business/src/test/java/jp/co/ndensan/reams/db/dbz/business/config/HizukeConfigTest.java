/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.config;

import jp.co.ndensan.reams.db.dbx.definition.core.config.ConfigKeysHizuke;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.SystemException;
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
 * {@link HizukeConfigTest}のテストです。
 *
 * @author N8156 宮本 康
 */
@Ignore
@RunWith(Enclosed.class)
public class HizukeConfigTest {

    private static final RString 月別テーブル1;
    private static final RString 月別テーブル2;
    private static final RString 月別テーブル3;
    private static final RString 月別テーブル4;
    private static final RString 月別テーブル5;
    private static final RString 月別テーブル6;
    private static final RString 月別テーブル7;
    private static final RString 月別テーブル8;
    private static final RString 月別テーブル9;
    private static final RString 月別テーブル10;
    private static final RString 月別テーブル11;
    private static final RString 月別テーブル12;
    private static final RString 月別テーブル13;
    private static final RString 月別テーブル14;
    private static RString 調定年度;
    private static RString 所得年度;
    private static RString 当初年度;
    private static RString 遡及年度;

    static {
        月別テーブル1 = new RString("01");
        月別テーブル2 = new RString("02");
        月別テーブル3 = new RString("03");
        月別テーブル4 = new RString("04");
        月別テーブル5 = new RString("05");
        月別テーブル6 = new RString("06");
        月別テーブル7 = new RString("07");
        月別テーブル8 = new RString("08");
        月別テーブル9 = new RString("09");
        月別テーブル10 = new RString("10");
        月別テーブル11 = new RString("11");
        月別テーブル12 = new RString("12");
        月別テーブル13 = new RString("13");
        月別テーブル14 = new RString("14");
    }

    public static class get extends DbzTestBase {

        static HizukeConfig sut;

        @Before
        public void setUp() {
            createBusinessConfigMock();
            sut = new HizukeConfig();
        }

        @Test
        public void 日付関連_月別テーブル1を指定したとき_01が返る() {
            RString result = sut.get(ConfigKeysHizuke.日付関連_月別テーブル1);
            assertThat(result, is(月別テーブル1));
        }

        @Test
        public void 日付関連_月別テーブル2を指定したとき_02が返る() {
            RString result = sut.get(ConfigKeysHizuke.日付関連_月別テーブル2);
            assertThat(result, is(月別テーブル2));
        }

        @Test
        public void 日付関連_月別テーブル3を指定したとき_03が返る() {
            RString result = sut.get(ConfigKeysHizuke.日付関連_月別テーブル3);
            assertThat(result, is(月別テーブル3));
        }

        @Test
        public void 日付関連_月別テーブル4を指定したとき_04が返る() {
            RString result = sut.get(ConfigKeysHizuke.日付関連_月別テーブル4);
            assertThat(result, is(月別テーブル4));
        }

        @Test
        public void 日付関連_月別テーブル5を指定したとき_05が返る() {
            RString result = sut.get(ConfigKeysHizuke.日付関連_月別テーブル5);
            assertThat(result, is(月別テーブル5));
        }

        @Test
        public void 日付関連_月別テーブル6を指定したとき_06が返る() {
            RString result = sut.get(ConfigKeysHizuke.日付関連_月別テーブル6);
            assertThat(result, is(月別テーブル6));
        }

        @Test
        public void 日付関連_月別テーブル7を指定したとき_07が返る() {
            RString result = sut.get(ConfigKeysHizuke.日付関連_月別テーブル7);
            assertThat(result, is(月別テーブル7));
        }

        @Test
        public void 日付関連_月別テーブル8を指定したとき_08が返る() {
            RString result = sut.get(ConfigKeysHizuke.日付関連_月別テーブル8);
            assertThat(result, is(月別テーブル8));
        }

        @Test
        public void 日付関連_月別テーブル9を指定したとき_09が返る() {
            RString result = sut.get(ConfigKeysHizuke.日付関連_月別テーブル9);
            assertThat(result, is(月別テーブル9));
        }

        @Test
        public void 日付関連_月別テーブル10を指定したとき_10が返る() {
            RString result = sut.get(ConfigKeysHizuke.日付関連_月別テーブル10);
            assertThat(result, is(月別テーブル10));
        }

        @Test
        public void 日付関連_月別テーブル11を指定したとき_11が返る() {
            RString result = sut.get(ConfigKeysHizuke.日付関連_月別テーブル11);
            assertThat(result, is(月別テーブル11));
        }

        @Test
        public void 日付関連_月別テーブル12を指定したとき_12が返る() {
            RString result = sut.get(ConfigKeysHizuke.日付関連_月別テーブル12);
            assertThat(result, is(月別テーブル12));
        }

        @Test
        public void 日付関連_月別テーブル13を指定したとき_13が返る() {
            RString result = sut.get(ConfigKeysHizuke.日付関連_月別テーブル13);
            assertThat(result, is(月別テーブル13));
        }

        @Test
        public void 日付関連_月別テーブル14を指定したとき_14が返る() {
            RString result = sut.get(ConfigKeysHizuke.日付関連_月別テーブル14);
            assertThat(result, is(月別テーブル14));
        }
    }

    @RunWith(Enclosed.class)
    public static class get年度 extends DbzTestBase {

        public static class NotNull extends DbzTestBase {

            private HizukeConfig sut;

            @Before
            public void setUp() {
                調定年度 = new RString("20110101");
                所得年度 = new RString("20120202");
                当初年度 = new RString("20130303");
                遡及年度 = new RString("20140404");
                createBusinessConfigMock();
                sut = new HizukeConfig();
            }

            @Test
            public void 日付関連_調定年度を指定したとき_20110101が返る() {
                RString result = sut.get(ConfigKeysHizuke.日付関連_調定年度);
                assertThat(result, is(調定年度));
            }

            @Test
            public void 日付関連_所得年度を指定したとき_20120202が返る() {
                RString result = sut.get(ConfigKeysHizuke.日付関連_所得年度);
                assertThat(result, is(所得年度));
            }

            @Test
            public void 日付関連_当初年度を指定したとき_20130303が返る() {
                RString result = sut.get(ConfigKeysHizuke.日付関連_当初年度);
                assertThat(result, is(当初年度));
            }

            @Test
            public void 日付関連_遡及年度を指定したとき_20140404が返る() {
                RString result = sut.get(ConfigKeysHizuke.日付関連_遡及年度);
                assertThat(result, is(遡及年度));
            }
        }

        public static class Null extends DbzTestBase {

            private HizukeConfig sut;

            @Before
            public void setUp() {
                調定年度 = null;
                所得年度 = null;
                当初年度 = null;
                遡及年度 = null;
                createBusinessConfigMock();
                sut = new HizukeConfig();
            }

            @Test(expected = SystemException.class)
            public void 日付関連_調定年度がnullのとき_get調定年度は_SystemExceptionを投げる() {
                sut.get調定年度();
            }

            @Test(expected = SystemException.class)
            public void 日付関連_所得年度がnullのとき_get所得年度は_SystemExceptionを投げる() {
                sut.get所得年度();
            }

            @Test(expected = SystemException.class)
            public void 日付関連_当初年度がnullのとき_get当初年度は_SystemExceptionを投げる() {
                sut.get当初年度();
            }

            @Test(expected = SystemException.class)
            public void 日付関連_遡及年度がnullのとき_get遡及年度は_SystemExceptionを投げる() {
                sut.get遡及年度();
            }
        }
    }

    private static BusinessConfig createBusinessConfigMock() {
        BusinessConfig mock = mock(BusinessConfig.class);
        when(mock.get(eq(ConfigKeysHizuke.日付関連_月別テーブル1), any(RDate.class))).thenReturn(月別テーブル1);
        when(mock.get(eq(ConfigKeysHizuke.日付関連_月別テーブル2), any(RDate.class))).thenReturn(月別テーブル2);
        when(mock.get(eq(ConfigKeysHizuke.日付関連_月別テーブル3), any(RDate.class))).thenReturn(月別テーブル3);
        when(mock.get(eq(ConfigKeysHizuke.日付関連_月別テーブル4), any(RDate.class))).thenReturn(月別テーブル4);
        when(mock.get(eq(ConfigKeysHizuke.日付関連_月別テーブル5), any(RDate.class))).thenReturn(月別テーブル5);
        when(mock.get(eq(ConfigKeysHizuke.日付関連_月別テーブル6), any(RDate.class))).thenReturn(月別テーブル6);
        when(mock.get(eq(ConfigKeysHizuke.日付関連_月別テーブル7), any(RDate.class))).thenReturn(月別テーブル7);
        when(mock.get(eq(ConfigKeysHizuke.日付関連_月別テーブル8), any(RDate.class))).thenReturn(月別テーブル8);
        when(mock.get(eq(ConfigKeysHizuke.日付関連_月別テーブル9), any(RDate.class))).thenReturn(月別テーブル9);
        when(mock.get(eq(ConfigKeysHizuke.日付関連_月別テーブル10), any(RDate.class))).thenReturn(月別テーブル10);
        when(mock.get(eq(ConfigKeysHizuke.日付関連_月別テーブル11), any(RDate.class))).thenReturn(月別テーブル11);
        when(mock.get(eq(ConfigKeysHizuke.日付関連_月別テーブル12), any(RDate.class))).thenReturn(月別テーブル12);
        when(mock.get(eq(ConfigKeysHizuke.日付関連_月別テーブル13), any(RDate.class))).thenReturn(月別テーブル13);
        when(mock.get(eq(ConfigKeysHizuke.日付関連_月別テーブル14), any(RDate.class))).thenReturn(月別テーブル14);
        when(mock.get(eq(ConfigKeysHizuke.日付関連_調定年度), any(RDate.class))).thenReturn(調定年度);
        when(mock.get(eq(ConfigKeysHizuke.日付関連_所得年度), any(RDate.class))).thenReturn(所得年度);
        when(mock.get(eq(ConfigKeysHizuke.日付関連_当初年度), any(RDate.class))).thenReturn(当初年度);
        when(mock.get(eq(ConfigKeysHizuke.日付関連_遡及年度), any(RDate.class))).thenReturn(遡及年度);
        return mock;
    }
}
