/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.config.shikaku;

import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.configkeys.shikaku.ConfigKeysHihokenshashoJushoEdit;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.hokensha.GunNamePrint;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.hokensha.HowToEditJusho;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.hokensha.KatagakiPrint;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.hokensha.ShichosonNamePrint;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.hokensha.TodofukenNamePrint;
import jp.co.ndensan.reams.db.dbz.testhelper.DbaTestBase;
import jp.co.ndensan.reams.ur.urz.business.config.IUrBusinessConfig;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.junit.Before;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * {@link jp.co.ndensan.reams.db.dba.business.config.HihokenshashoJushoEditConfig}のテストです。
 *
 * @author n8178 城間篤人
 */
@RunWith(Enclosed.class)
public class HihokenshashoJushoEditConfigTest {

    public static class get extends DbaTestBase {

        private HihokenshashoJushoEditConfig sut;

        @Before
        public void setUp() {
            sut = new HihokenshashoJushoEditConfig(createBusinessConfigMock());
        }

        @Test
        public void uese帳票独自区分を指定したとき_trueが返る() {
            boolean result = sut.uses帳票独自区分();
            assertThat(result, is(true));
        }

        @Test
        public void get都道府県名付与有無を指定したとき_印字しないが返る() {
            TodofukenNamePrint result = sut.get都道府県名付与有無();
            assertThat(result, is(TodofukenNamePrint.印字しない));
        }

        @Test
        public void get郡名付与有無を指定したとき_印字しないが返る() {
            GunNamePrint result = sut.get郡名付与有無();
            assertThat(result, is(GunNamePrint.印字しない));
        }

        @Test
        public void get市町村名付与有無を指定したとき_印字するが返る() {
            ShichosonNamePrint result = sut.get市町村名付与有無();
            assertThat(result, is(ShichosonNamePrint.印字する));
        }

        @Test
        public void get住所編集方法を指定したとき_住所と番地_行政区が返る() {
            HowToEditJusho result = sut.get住所編集方法();
            assertThat(result, is(HowToEditJusho.住所と番地_行政区));
        }

        @Test
        public void get方書表示有無を指定したとき_印字しないが返る() {
            KatagakiPrint result = sut.get方書表示有無();
            assertThat(result, is(KatagakiPrint.印字しない));
        }
    }

    private static IUrBusinessConfig createBusinessConfigMock() {
        IUrBusinessConfig mock = mock(IUrBusinessConfig.class);
        RDate nowDate = RDate.getNowDate();
        SubGyomuCode subGyomu = SubGyomuCode.DBA介護資格;

        when(mock.get(
                ConfigKeysHihokenshashoJushoEdit.被保険者証表示方法_管内住所編集_帳票独自区分,
                nowDate,
                subGyomu
        )).thenReturn(new RString("1"));
        when(mock.get(
                ConfigKeysHihokenshashoJushoEdit.被保険者証表示方法_管内住所編集_都道府県名付与有無,
                nowDate,
                subGyomu
        )).thenReturn(new RString("0"));
        when(mock.get(
                ConfigKeysHihokenshashoJushoEdit.被保険者証表示方法_管内住所編集_郡名付与有無,
                nowDate,
                subGyomu
        )).thenReturn(new RString("0"));
        when(mock.get(
                ConfigKeysHihokenshashoJushoEdit.被保険者証表示方法_管内住所編集_市町村名付与有無,
                nowDate,
                subGyomu
        )).thenReturn(new RString("1"));
        when(mock.get(
                ConfigKeysHihokenshashoJushoEdit.被保険者証表示方法_管内住所編集_編集方法,
                nowDate,
                subGyomu
        )).thenReturn(new RString("3"));
        when(mock.get(
                ConfigKeysHihokenshashoJushoEdit.被保険者証表示方法_住所編集_方書表示有無,
                nowDate,
                subGyomu
        )).thenReturn(new RString("0"));
        return mock;
    }
}
