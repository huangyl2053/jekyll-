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
import jp.co.ndensan.reams.uz.uza.lang.SystemException;
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

    private static final RString 調定年度 = new RString("20110101");
    private static final RString 所得年度 = new RString("20120202");
    private static final RString 当初年度 = new RString("20130303");
    private static final RString 遡及年度 = new RString("20140404");

    public static class get extends DbzTestBase {

        private HizukeConfig sut;

        @Before
        public void setUp() {
            sut = new HizukeConfig(createBusinessConfigMock(調定年度, 所得年度, 当初年度, 遡及年度));
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

    public static class get年度 extends DbzTestBase {

        private HizukeConfig sut;

        @Before
        public void setUp() {
            sut = new HizukeConfig(createBusinessConfigMock(null, null, null, null));
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

    private static IUrBusinessConfig createBusinessConfigMock(RString 調定年度, RString 所得年度, RString 当初年度, RString 遡及年度) {
        IUrBusinessConfig mock = mock(IUrBusinessConfig.class);
        RDate nowDate = RDate.getNowDate();
        when(mock.get(ConfigKeysHizuke.日付関連_調定年度, nowDate)).thenReturn(調定年度);
        when(mock.get(ConfigKeysHizuke.日付関連_所得年度, nowDate)).thenReturn(所得年度);
        when(mock.get(ConfigKeysHizuke.日付関連_当初年度, nowDate)).thenReturn(当初年度);
        when(mock.get(ConfigKeysHizuke.日付関連_遡及年度, nowDate)).thenReturn(遡及年度);
        return mock;
    }
}
