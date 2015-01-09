/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.config;

import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.configkeys.ConfigKeysShiharaiHohoHenko;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.configvalues.ShiharaiHohoHenkoShuryobunKisaiKubun;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.ur.urz.business.config.IUrBusinessConfig;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import static org.mockito.Mockito.*;

/**
 * {@link ShiharaiHohoHenkoConfig}のテストです。
 *
 * @author N8187 久保田 英男
 */
@RunWith(Enclosed.class)
public class ShiharaiHohoHenkoConfigTest extends DbzTestBase {

    public static class get extends DbzTestBase {

        private ShiharaiHohoHenkoConfig sut;

        @Before
        public void setUp() {
            sut = new ShiharaiHohoHenkoConfig(createBusinessConfigMock());
        }

        @Test
        public void 支払方法変更_証表示支払方法_終了分記載区分を指定したとき_業務コンフィグ設定値が返る() {
            ShiharaiHohoHenkoShuryobunKisaiKubun result = sut.get支払方法変更_証表示支払方法_終了分記載区分();
            assertThat(result, is(ShiharaiHohoHenkoShuryobunKisaiKubun.終了後も記載する));
        }

        @Test
        public void 支払方法変更_証表示支払方法_記載文言を指定したとき_業務コンフィグ設定値が返る() {
            RString result = sut.get支払方法変更_証表示支払方法_記載文言();
            assertThat(result, is(証表示支払方法_記載文言));
        }

        @Test
        public void 支払方法変更_証表示差止_終了分記載区分を指定したとき_業務コンフィグ設定値が返る() {
            ShiharaiHohoHenkoShuryobunKisaiKubun result = sut.get支払方法変更_証表示差止_終了分記載区分();
            assertThat(result, is(ShiharaiHohoHenkoShuryobunKisaiKubun.終了後も記載する));
        }

        @Test
        public void 支払方法変更_証表示差止_記載文言を指定したとき_業務コンフィグ設定値が返る() {
            RString result = sut.get支払方法変更_証表示差止_記載文言();
            assertThat(result, is(証表示差止_記載文言));
        }

        @Test
        public void 支払方法変更_証表示減額_終了分記載区分を指定したとき_業務コンフィグ設定値が返る() {
            ShiharaiHohoHenkoShuryobunKisaiKubun result = sut.get支払方法変更_証表示減額_終了分記載区分();
            assertThat(result, is(ShiharaiHohoHenkoShuryobunKisaiKubun.終了後は記載しない));
        }

        @Test
        public void 支払方法変更_証表示減額_記載文言を指定したとき_業務コンフィグ設定値が返る() {
            RString result = sut.get支払方法変更_証表示減額_記載文言();
            assertThat(result, is(証表示減額_記載文言));
        }

        @Test
        public void 支払方法変更_資格者証表示支払方法_終了分記載区分を指定したとき_業務コンフィグ設定値が返る() {
            ShiharaiHohoHenkoShuryobunKisaiKubun result = sut.get支払方法変更_資格者証表示支払方法_終了分記載区分();
            assertThat(result, is(ShiharaiHohoHenkoShuryobunKisaiKubun.終了後も記載する));
        }

        @Test
        public void 支払方法変更_資格者証表示支払方法_記載文言を指定したとき_業務コンフィグ設定値が返る() {
            RString result = sut.get支払方法変更_資格者証表示支払方法_記載文言();
            assertThat(result, is(資格者証表示支払方法_記載文言));
        }

        @Test
        public void 支払方法変更_資格者証表示差止_終了分記載区分を指定したとき_業務コンフィグ設定値が返る() {
            ShiharaiHohoHenkoShuryobunKisaiKubun result = sut.get支払方法変更_資格者証表示差止_終了分記載区分();
            assertThat(result, is(ShiharaiHohoHenkoShuryobunKisaiKubun.終了後も記載する));
        }

        @Test
        public void 支払方法変更_資格者証表示差止_記載文言を指定したとき_業務コンフィグ設定値が返る() {
            RString result = sut.get支払方法変更_資格者証表示差止_記載文言();
            assertThat(result, is(資格者証表示差止_記載文言));
        }

        @Test
        public void 支払方法変更_資格者証表示減額_終了分記載区分を指定したとき_業務コンフィグ設定値が返る() {
            ShiharaiHohoHenkoShuryobunKisaiKubun result = sut.get支払方法変更_資格者証表示減額_終了分記載区分();
            assertThat(result, is(ShiharaiHohoHenkoShuryobunKisaiKubun.終了後も記載する));
        }

        @Test
        public void 支払方法変更_資格者証表示減額_記載文言を指定したとき_業務コンフィグ設定値が返る() {
            RString result = sut.get支払方法変更_資格者証表示減額_記載文言();
            assertThat(result, is(資格者証表示減額_記載文言));
        }

    }

    private static final ShiharaiHohoHenkoShuryobunKisaiKubun 証表示支払方法_終了分記載区分;
    private static final RString 証表示支払方法_記載文言;
    private static final ShiharaiHohoHenkoShuryobunKisaiKubun 証表示差止_終了分記載区分;
    private static final RString 証表示差止_記載文言;
    private static final ShiharaiHohoHenkoShuryobunKisaiKubun 証表示減額_終了分記載区分;
    private static final RString 証表示減額_記載文言;
    private static final ShiharaiHohoHenkoShuryobunKisaiKubun 資格者証表示支払方法_終了分記載区分;
    private static final RString 資格者証表示支払方法_記載文言;
    private static final ShiharaiHohoHenkoShuryobunKisaiKubun 資格者証表示差止_終了分記載区分;
    private static final RString 資格者証表示差止_記載文言;
    private static final ShiharaiHohoHenkoShuryobunKisaiKubun 資格者証表示減額_終了分記載区分;
    private static final RString 資格者証表示減額_記載文言;

    static {
        証表示支払方法_終了分記載区分 = ShiharaiHohoHenkoShuryobunKisaiKubun.終了後も記載する;
        証表示支払方法_記載文言 = new RString("支払方法変更ＭＡＸ１２３");
        証表示差止_終了分記載区分 = ShiharaiHohoHenkoShuryobunKisaiKubun.終了後も記載する;
        証表示差止_記載文言 = new RString("保険給付の差止Ｍ１Ａ２Ｘ");
        証表示減額_終了分記載区分 = ShiharaiHohoHenkoShuryobunKisaiKubun.終了後は記載しない;
        証表示減額_記載文言 = new RString("給付額　減額Ｍ１Ａ２Ｘ３");
        資格者証表示支払方法_終了分記載区分 = ShiharaiHohoHenkoShuryobunKisaiKubun.終了後も記載する;
        資格者証表示支払方法_記載文言 = new RString("支払方法変更");
        資格者証表示差止_終了分記載区分 = ShiharaiHohoHenkoShuryobunKisaiKubun.終了後も記載する;
        資格者証表示差止_記載文言 = new RString("保険給付の差止");
        資格者証表示減額_終了分記載区分 = ShiharaiHohoHenkoShuryobunKisaiKubun.終了後も記載する;
        資格者証表示減額_記載文言 = new RString("給付額減額・高額費不支給");
    }

    private static IUrBusinessConfig createBusinessConfigMock() {
        IUrBusinessConfig mock = mock(IUrBusinessConfig.class);
        when(mock.get(
                eq(ConfigKeysShiharaiHohoHenko.支払方法変更_証表示支払方法_終了分記載区分),
                any(RDate.class),
                eq(SubGyomuCode.DBD介護受給)
        )).thenReturn(証表示支払方法_終了分記載区分.code());
        when(mock.get(
                eq(ConfigKeysShiharaiHohoHenko.支払方法変更_証表示支払方法_記載文言),
                any(RDate.class),
                eq(SubGyomuCode.DBD介護受給)
        )).thenReturn(証表示支払方法_記載文言);
        when(mock.get(
                eq(ConfigKeysShiharaiHohoHenko.支払方法変更_証表示差止_終了分記載区分),
                any(RDate.class),
                eq(SubGyomuCode.DBD介護受給)
        )).thenReturn(証表示差止_終了分記載区分.code());
        when(mock.get(
                eq(ConfigKeysShiharaiHohoHenko.支払方法変更_証表示差止_記載文言),
                any(RDate.class),
                eq(SubGyomuCode.DBD介護受給)
        )).thenReturn(証表示差止_記載文言);
        when(mock.get(
                eq(ConfigKeysShiharaiHohoHenko.支払方法変更_証表示減額_終了分記載区分),
                any(RDate.class),
                eq(SubGyomuCode.DBD介護受給)
        )).thenReturn(証表示減額_終了分記載区分.code());
        when(mock.get(
                eq(ConfigKeysShiharaiHohoHenko.支払方法変更_証表示減額_記載文言),
                any(RDate.class),
                eq(SubGyomuCode.DBD介護受給)
        )).thenReturn(証表示減額_記載文言);
        when(mock.get(
                eq(ConfigKeysShiharaiHohoHenko.支払方法変更_資格者証表示支払方法_終了分記載区分),
                any(RDate.class),
                eq(SubGyomuCode.DBD介護受給)
        )).thenReturn(資格者証表示支払方法_終了分記載区分.code());
        when(mock.get(
                eq(ConfigKeysShiharaiHohoHenko.支払方法変更_資格者証表示支払方法_記載文言),
                any(RDate.class),
                eq(SubGyomuCode.DBD介護受給)
        )).thenReturn(資格者証表示支払方法_記載文言);
        when(mock.get(
                eq(ConfigKeysShiharaiHohoHenko.支払方法変更_資格者証表示差止_終了分記載区分),
                any(RDate.class),
                eq(SubGyomuCode.DBD介護受給)
        )).thenReturn(資格者証表示差止_終了分記載区分.code());
        when(mock.get(
                eq(ConfigKeysShiharaiHohoHenko.支払方法変更_資格者証表示差止_記載文言),
                any(RDate.class),
                eq(SubGyomuCode.DBD介護受給)
        )).thenReturn(資格者証表示差止_記載文言);
        when(mock.get(
                eq(ConfigKeysShiharaiHohoHenko.支払方法変更_資格者証表示減額_終了分記載区分),
                any(RDate.class),
                eq(SubGyomuCode.DBD介護受給)
        )).thenReturn(資格者証表示減額_終了分記載区分.code());
        when(mock.get(
                eq(ConfigKeysShiharaiHohoHenko.支払方法変更_資格者証表示減額_記載文言),
                any(RDate.class),
                eq(SubGyomuCode.DBD介護受給)
        )).thenReturn(資格者証表示減額_記載文言);
        return mock;
    }
}
