/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.config.shikaku;

import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.configkeys.shikaku.ConfigKeysHihokenshashoSofusakiInfo;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.configvalues.MojigireControlType;
import jp.co.ndensan.reams.db.dbz.testhelper.DbaTestBase;
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

        private HihokenshashoSofusakiInfoConfig sut;

        @Before
        public void setUp() {
            sut = new HihokenshashoSofusakiInfoConfig(createBusinessConfigMock());
        }

        @Test
        public void is世帯主表示有りで_falseが返る() {
            boolean result = sut.is世帯主表示有り();
            assertThat(result, is(false));
        }

        @Test
        public void is敬称表示有りで_trueが返る() {
            boolean result = sut.is敬称表示有り();
            assertThat(result, is(true));
        }

        @Test
        public void get外部帳票文字切れ制御方法で_印字可能範囲まで印字するが返る() {
            MojigireControlType result = sut.get外部帳票文字切れ制御方法();
            assertThat(result, is(MojigireControlType.印字可能範囲まで印字する));
        }

    }

    private static IUrBusinessConfig createBusinessConfigMock() {
        IUrBusinessConfig mock = mock(IUrBusinessConfig.class);
        RDate nowDate = RDate.getNowDate();
        SubGyomuCode subGyomu = SubGyomuCode.DBA介護資格;

        when(mock.get(
                ConfigKeysHihokenshashoSofusakiInfo.被保険者証_送付先情報_世帯主表示有無,
                nowDate,
                subGyomu
        )).thenReturn(new RString("0"));
        when(mock.get(
                ConfigKeysHihokenshashoSofusakiInfo.被保険者証_送付先情報_敬称表示方法,
                nowDate,
                subGyomu
        )).thenReturn(new RString("1"));
        when(mock.get(
                ConfigKeysHihokenshashoSofusakiInfo.被保険者証_外部帳票文字切れ制御方法,
                nowDate,
                subGyomu
        )).thenReturn(new RString("1"));
        return mock;
    }
}
