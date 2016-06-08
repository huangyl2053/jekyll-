/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.config;

import javax.persistence.Id;
import jp.co.ndensan.reams.db.dbz.definition.core.enumeratedtype.configkeys.ConfigKeysShuruiShikyuGendoGet;
import jp.co.ndensan.reams.db.dbz.definition.core.enumeratedtype.configvalues.ShuruiShikyuGendoGet;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
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
 * {@link ShuruiShikyuGendoGetConfig}のテストです。
 *
 * @author N8187 久保田 英男
 */
@Ignore
@RunWith(Enclosed.class)
public class ShuruiShikyuGendoGetConfigTest extends DbzTestBase {

    public static class get extends DbzTestBase {

        static ShuruiShikyuGendoGetConfig sut;

        @Before
        public void setUp() {
            createBusinessConfigMock();
            sut = new ShuruiShikyuGendoGetConfig();
        }

        @Test
        public void 種類支給限度額_取得方法を指定したとき_業務コンフィグ設定値が返る() {
            ShuruiShikyuGendoGet result = sut.get種類支給限度額_取得方法();
            assertThat(result, is(ShuruiShikyuGendoGet.要介護度を検索キーにする));
        }
    }

    private static final ShuruiShikyuGendoGet 取得方法;

    static {
        取得方法 = ShuruiShikyuGendoGet.要介護度を検索キーにする;
    }

    private static BusinessConfig createBusinessConfigMock() {
        BusinessConfig mock = mock(BusinessConfig.class);
        when(mock.get(
                eq(ConfigKeysShuruiShikyuGendoGet.種類支給限度額_取得方法),
                any(RDate.class),
                eq(SubGyomuCode.DBD介護受給)
        )).thenReturn(取得方法.code());
        return mock;
    }
}
