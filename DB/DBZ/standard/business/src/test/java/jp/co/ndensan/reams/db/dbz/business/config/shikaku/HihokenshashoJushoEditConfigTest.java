/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.config.shikaku;

import jp.co.ndensan.reams.db.dbz.business.config.ConfigValueBoolean;
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
import static org.hamcrest.CoreMatchers.is;
import org.junit.Before;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import static org.mockito.Mockito.*;

/**
 * {@link HihokenshashoJushoEditConfig}のテストです。
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
        public void uese帳票独自区分を指定したとき_Configの設定値を_ConfigValueBoolean$perseBooleanに渡した結果が返る() {
            boolean result = sut.uses帳票独自区分();
            assertThat(result, is(ConfigValueBoolean.parseBoolean(帳票独自区分)));
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
    private static final RString 帳票独自区分;

    static {
        帳票独自区分 = new RString("1");
    }

    private static IUrBusinessConfig createBusinessConfigMock() {
        IUrBusinessConfig mock = mock(IUrBusinessConfig.class);
        when(mock.get(
                eq(ConfigKeysHihokenshashoJushoEdit.被保険者証表示方法_管内住所編集_帳票独自区分),
                any(RDate.class),
                eq(SubGyomuCode.DBA介護資格)
        )).thenReturn(帳票独自区分);
        when(mock.get(
                eq(ConfigKeysHihokenshashoJushoEdit.被保険者証表示方法_管内住所編集_都道府県名付与有無),
                any(RDate.class),
                eq(SubGyomuCode.DBA介護資格)
        )).thenReturn(TodofukenNamePrint.印字しない.code());
        when(mock.get(
                eq(ConfigKeysHihokenshashoJushoEdit.被保険者証表示方法_管内住所編集_郡名付与有無),
                any(RDate.class),
                eq(SubGyomuCode.DBA介護資格)
        )).thenReturn(GunNamePrint.印字しない.code());
        when(mock.get(
                eq(ConfigKeysHihokenshashoJushoEdit.被保険者証表示方法_管内住所編集_市町村名付与有無),
                any(RDate.class),
                eq(SubGyomuCode.DBA介護資格)
        )).thenReturn(ShichosonNamePrint.印字する.code());
        when(mock.get(
                eq(ConfigKeysHihokenshashoJushoEdit.被保険者証表示方法_管内住所編集_編集方法),
                any(RDate.class),
                eq(SubGyomuCode.DBA介護資格)
        )).thenReturn(HowToEditJusho.住所と番地_行政区.code());
        when(mock.get(
                eq(ConfigKeysHihokenshashoJushoEdit.被保険者証表示方法_住所編集_方書表示有無),
                any(RDate.class),
                eq(SubGyomuCode.DBA介護資格)
        )).thenReturn(KatagakiPrint.印字しない.code());
        return mock;
    }
}
