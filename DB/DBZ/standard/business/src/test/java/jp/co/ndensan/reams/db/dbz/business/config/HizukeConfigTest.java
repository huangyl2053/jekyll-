/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.config;

import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.ConfigKeysHizuke;
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
 * {@link HizukeConfigTest}のテストです。
 *
 * @author N8156 宮本 康
 */
@RunWith(Enclosed.class)
public class HizukeConfigTest {

    public static class get extends DbaTestBase {

        private HizukeConfig sut;

        @Before
        public void setUp() {
            sut = new HizukeConfig(createBusinessConfigMock());
        }

        @Test
        public void 日付関連_月別テーブル1を指定したとき_01が返る() {
            RString result = sut.get(ConfigKeysHizuke.日付関連_月別テーブル1);
            assertThat(result, is(new RString("01")));
        }

        @Test
        public void 日付関連_月別テーブル2を指定したとき_02が返る() {
            RString result = sut.get(ConfigKeysHizuke.日付関連_月別テーブル2);
            assertThat(result, is(new RString("02")));
        }

        @Test
        public void 日付関連_月別テーブル3を指定したとき_03が返る() {
            RString result = sut.get(ConfigKeysHizuke.日付関連_月別テーブル3);
            assertThat(result, is(new RString("03")));
        }

        @Test
        public void 日付関連_月別テーブル4を指定したとき_04が返る() {
            RString result = sut.get(ConfigKeysHizuke.日付関連_月別テーブル4);
            assertThat(result, is(new RString("04")));
        }

        @Test
        public void 日付関連_月別テーブル5を指定したとき_05が返る() {
            RString result = sut.get(ConfigKeysHizuke.日付関連_月別テーブル5);
            assertThat(result, is(new RString("05")));
        }

        @Test
        public void 日付関連_月別テーブル6を指定したとき_06が返る() {
            RString result = sut.get(ConfigKeysHizuke.日付関連_月別テーブル6);
            assertThat(result, is(new RString("06")));
        }

        @Test
        public void 日付関連_月別テーブル7を指定したとき_07が返る() {
            RString result = sut.get(ConfigKeysHizuke.日付関連_月別テーブル7);
            assertThat(result, is(new RString("07")));
        }

        @Test
        public void 日付関連_月別テーブル8を指定したとき_08が返る() {
            RString result = sut.get(ConfigKeysHizuke.日付関連_月別テーブル8);
            assertThat(result, is(new RString("08")));
        }

        @Test
        public void 日付関連_月別テーブル9を指定したとき_09が返る() {
            RString result = sut.get(ConfigKeysHizuke.日付関連_月別テーブル9);
            assertThat(result, is(new RString("09")));
        }

        @Test
        public void 日付関連_月別テーブル10を指定したとき_10が返る() {
            RString result = sut.get(ConfigKeysHizuke.日付関連_月別テーブル10);
            assertThat(result, is(new RString("10")));
        }

        @Test
        public void 日付関連_月別テーブル11を指定したとき_11が返る() {
            RString result = sut.get(ConfigKeysHizuke.日付関連_月別テーブル11);
            assertThat(result, is(new RString("11")));
        }

        @Test
        public void 日付関連_月別テーブル12を指定したとき_12が返る() {
            RString result = sut.get(ConfigKeysHizuke.日付関連_月別テーブル12);
            assertThat(result, is(new RString("12")));
        }

        @Test
        public void 日付関連_月別テーブル13を指定したとき_13が返る() {
            RString result = sut.get(ConfigKeysHizuke.日付関連_月別テーブル13);
            assertThat(result, is(new RString("13")));
        }

        @Test
        public void 日付関連_月別テーブル14を指定したとき_14が返る() {
            RString result = sut.get(ConfigKeysHizuke.日付関連_月別テーブル14);
            assertThat(result, is(new RString("14")));
        }
    }

    private static IUrBusinessConfig createBusinessConfigMock() {
        IUrBusinessConfig mock = mock(IUrBusinessConfig.class);
        RDate nowDate = RDate.getNowDate();

        when(mock.get(ConfigKeysHizuke.日付関連_月別テーブル1, nowDate)).thenReturn(new RString("01"));
        when(mock.get(ConfigKeysHizuke.日付関連_月別テーブル2, nowDate)).thenReturn(new RString("02"));
        when(mock.get(ConfigKeysHizuke.日付関連_月別テーブル3, nowDate)).thenReturn(new RString("03"));
        when(mock.get(ConfigKeysHizuke.日付関連_月別テーブル4, nowDate)).thenReturn(new RString("04"));
        when(mock.get(ConfigKeysHizuke.日付関連_月別テーブル5, nowDate)).thenReturn(new RString("05"));
        when(mock.get(ConfigKeysHizuke.日付関連_月別テーブル6, nowDate)).thenReturn(new RString("06"));
        when(mock.get(ConfigKeysHizuke.日付関連_月別テーブル7, nowDate)).thenReturn(new RString("07"));
        when(mock.get(ConfigKeysHizuke.日付関連_月別テーブル8, nowDate)).thenReturn(new RString("08"));
        when(mock.get(ConfigKeysHizuke.日付関連_月別テーブル9, nowDate)).thenReturn(new RString("09"));
        when(mock.get(ConfigKeysHizuke.日付関連_月別テーブル10, nowDate)).thenReturn(new RString("10"));
        when(mock.get(ConfigKeysHizuke.日付関連_月別テーブル11, nowDate)).thenReturn(new RString("11"));
        when(mock.get(ConfigKeysHizuke.日付関連_月別テーブル12, nowDate)).thenReturn(new RString("12"));
        when(mock.get(ConfigKeysHizuke.日付関連_月別テーブル13, nowDate)).thenReturn(new RString("13"));
        when(mock.get(ConfigKeysHizuke.日付関連_月別テーブル14, nowDate)).thenReturn(new RString("14"));

        return mock;
    }
}
