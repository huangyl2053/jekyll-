/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.config;

import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.configkeys.ConfigKeysShuruiShikyuGendoGet;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.configvalues.ShuruiShikyuGendoGet;
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
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.mock;

/**
 * {@link ShuruiShikyuGendoGetConfig}のテストです。
 *
 * @author N8187 久保田 英男
 */
@RunWith(Enclosed.class)
public class ShuruiShikyuGendoGetConfigTest extends DbzTestBase {

    public static class get {

        private ShuruiShikyuGendoGetConfig sut;

        @Before
        public void setUp() {
            sut = new ShuruiShikyuGendoGetConfig(createBusinessConfigMock());
        }

        @Test
        public void 種類支給限度額_取得方法を指定したとき_業務コンフィグ設定値が返る() {
            ShuruiShikyuGendoGet result = sut.get種類支給限度額_取得方法();
            assertThat(result, is(ShuruiShikyuGendoGet.要介護度を検索キーにする));
        }

    }

    private static IUrBusinessConfig createBusinessConfigMock() {
        IUrBusinessConfig mock = mock(IUrBusinessConfig.class);
        RDate nowDate = RDate.getNowDate();

        when(mock.get(
                ConfigKeysShuruiShikyuGendoGet.種類支給限度額_取得方法,
                nowDate,
                SubGyomuCode.DBD介護受給
        )).thenReturn(ShuruiShikyuGendoGet.要介護度を検索キーにする.code());
        return mock;
    }
}
