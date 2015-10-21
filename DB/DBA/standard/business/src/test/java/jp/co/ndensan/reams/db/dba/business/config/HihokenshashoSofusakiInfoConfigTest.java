/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.config;

import jp.co.ndensan.reams.db.dbz.definition.core.enumeratedtype.configkeys.shikaku.ConfigKeysHihokenshashoSofusakiInfo;
import jp.co.ndensan.reams.db.dbz.testhelper.DbaTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.config.BusinessConfig;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * {@link jp.co.ndensan.reams.db.dba.business.config.HihokenshashoSofusakiInfoConfig}のテストです。
 *
 * @author n8178 城間篤人
 */
@RunWith(Enclosed.class)
public class HihokenshashoSofusakiInfoConfigTest {

    public static class get extends DbaTestBase {

        static HihokenshashoSofusakiInfoConfig sut;

        @Before
        public void setUp() {
            createBusinessConfigMock();
            sut = new HihokenshashoSofusakiInfoConfig();
        }

        @Test
        public void get世帯主表示有無で_0が返る() {
            RString result = sut.get世帯主表示有無();
            assertThat(result, is(new RString("0")));
        }

        @Test
        public void get敬称表示方法で_1が返る() {
            RString result = sut.get敬称表示方法();
            assertThat(result, is(new RString("1")));
        }

        @Test
        public void get外部帳票文字切れ制御方法で_1が返る() {
            RString result = sut.get外部帳票文字切れ制御方法();
            assertThat(result, is(new RString("1")));
        }

    }

    private static BusinessConfig createBusinessConfigMock() {
        BusinessConfig mock = mock(BusinessConfig.class);
        RDate nowDate = RDate.getNowDate();

        when(mock.get(
                ConfigKeysHihokenshashoSofusakiInfo.被保険者証_送付先情報_世帯主表示有無,
                nowDate
        )).thenReturn(new RString("0"));
        when(mock.get(
                ConfigKeysHihokenshashoSofusakiInfo.被保険者証_送付先情報_敬称表示方法,
                nowDate
        )).thenReturn(new RString("1"));
        when(mock.get(
                ConfigKeysHihokenshashoSofusakiInfo.被保険者証_外部帳票文字切れ制御方法,
                nowDate
        )).thenReturn(new RString("1"));
        return mock;
    }
}
