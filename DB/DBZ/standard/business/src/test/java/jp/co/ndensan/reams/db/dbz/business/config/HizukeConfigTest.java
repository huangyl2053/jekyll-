/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.config;

import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.ConfigKeysHizuke;
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
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * {@link HizukeConfigTest}のテストです。
 *
 * @author N8156 宮本 康
 */
@RunWith(Enclosed.class)
public class HizukeConfigTest {

    public static class get extends DbzTestBase {

        private HizukeConfig sut;

        @Before
        public void setUp() {
            sut = new HizukeConfig(createBusinessConfigMock());
        }

        @Test
        public void 日付関連_調定年度を指定したとき_20110101が返る() {
            RString result = sut.get(ConfigKeysHizuke.日付関連_調定年度);
            assertThat(result, is(new RString("20110101")));
        }

        @Test
        public void 日付関連_所得年度を指定したとき_20120202が返る() {
            RString result = sut.get(ConfigKeysHizuke.日付関連_所得年度);
            assertThat(result, is(new RString("20120202")));
        }

        @Test
        public void 日付関連_当初年度を指定したとき_20130303が返る() {
            RString result = sut.get(ConfigKeysHizuke.日付関連_当初年度);
            assertThat(result, is(new RString("20130303")));
        }

        @Test
        public void 日付関連_遡及年度を指定したとき_20140404が返る() {
            RString result = sut.get(ConfigKeysHizuke.日付関連_遡及年度);
            assertThat(result, is(new RString("20140404")));
        }
    }

    private static IUrBusinessConfig createBusinessConfigMock() {
        IUrBusinessConfig mock = mock(IUrBusinessConfig.class);
        RDate nowDate = RDate.getNowDate();
        when(mock.get(ConfigKeysHizuke.日付関連_調定年度, nowDate)).thenReturn(new RString("20110101"));
        when(mock.get(ConfigKeysHizuke.日付関連_所得年度, nowDate)).thenReturn(new RString("20120202"));
        when(mock.get(ConfigKeysHizuke.日付関連_当初年度, nowDate)).thenReturn(new RString("20130303"));
        when(mock.get(ConfigKeysHizuke.日付関連_遡及年度, nowDate)).thenReturn(new RString("20140404"));
        return mock;
    }
}
