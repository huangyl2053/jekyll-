/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.config;

import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.configkeys.ConfigKeysShuruiShikyuGendoGet;
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
 * {@link ShuruiShikyuGendoGetConfig}のテストです。
 *
 * @author N8187 久保田 英男
 */
@RunWith(Enclosed.class)
public class ShuruiShikyuGendoGetConfigTest extends DbzTestBase {

    public static class get extends DbzTestBase {

        private ShuruiShikyuGendoGetConfig sut;

        @Before
        public void setUp() {
            sut = new ShuruiShikyuGendoGetConfig(createBusinessConfigMock());
        }

        @Test
        public void 種類支給限度額_取得方法を指定したとき_業務コンフィグ設定値が返る() {
            RString result = sut.get種類支給限度額_取得方法();
            assertThat(result, is(取得方法));
        }
    }

    private static final RString 取得方法;

    static {
        取得方法 = new RString("1");
    }

    private static IUrBusinessConfig createBusinessConfigMock() {
        IUrBusinessConfig mock = mock(IUrBusinessConfig.class);
        when(mock.get(
                eq(ConfigKeysShuruiShikyuGendoGet.種類支給限度額_取得方法),
                any(RDate.class),
                eq(SubGyomuCode.DBD介護受給)
        )).thenReturn(取得方法);
        return mock;
    }
}
