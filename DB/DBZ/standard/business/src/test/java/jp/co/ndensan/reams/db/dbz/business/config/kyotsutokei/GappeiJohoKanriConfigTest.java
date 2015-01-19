/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.config.kyotsutokei;

import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.configkeys.kyotsutokei.ConfigKeysChohyoKyotsuJushoEdit;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.configkeys.kyotsutokei.ConfigKeysGappeiJohoKanri;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.hokensha.GunNamePrint;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.hokensha.HowToEditJusho;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.hokensha.KatagakiPrint;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.hokensha.ShichosonNamePrint;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.hokensha.TodofukenNamePrint;
import jp.co.ndensan.reams.db.dbz.testhelper.DbuTestBase;
import jp.co.ndensan.reams.ur.urz.business.config.IUrBusinessConfig;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * {@link jp.co.ndensan.reams.db.dbz.business.config.kyotsutokei.GappeiJohoKanriConfig}のテストです。
 *
 * @author n8178 城間篤人
 */
@RunWith(Enclosed.class)
public class GappeiJohoKanriConfigTest {

    private static GappeiJohoKanriConfig sut;
    private static final RString 合併情報 = new RString("0");

    public static class get extends DbuTestBase {

        @Before
        public void setUp() {
            sut = new GappeiJohoKanriConfig(createBusinessConfigMock());
        }

        @Test
        public void is合併ありで_falseが返る() {
            assertThat(sut.is合併あり(), is(false));
        }

    }

    private static IUrBusinessConfig createBusinessConfigMock() {
        IUrBusinessConfig mock = mock(IUrBusinessConfig.class);
        SubGyomuCode subGyomu = SubGyomuCode.DBU介護統計報告;
        when(mock.get(
                eq(ConfigKeysGappeiJohoKanri.合併情報管理_合併情報区分),
                any(RDate.class),
                eq(subGyomu)
        )).thenReturn(合併情報);
        return mock;
    }
}
