/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.config.kyotsutokei;

import jp.co.ndensan.reams.db.dbx.business.config.kyotsu.jushohenshu.ChohyoKyotsuJushoEditConfig;
import jp.co.ndensan.reams.db.dbx.business.config.kyotsu.jushohenshu.ConfigKeysChohyoKyotsuJushoEdit;
import jp.co.ndensan.reams.db.dbx.definition.core.hokensha.GunNamePrint;
import jp.co.ndensan.reams.db.dbx.definition.core.hokensha.HowToEditJusho;
import jp.co.ndensan.reams.db.dbx.definition.core.hokensha.KatagakiPrint;
import jp.co.ndensan.reams.db.dbx.definition.core.hokensha.ShichosonNamePrint;
import jp.co.ndensan.reams.db.dbx.definition.core.hokensha.TodofukenNamePrint;
import jp.co.ndensan.reams.db.dbz.testhelper.DbuTestBase;
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
 * {@link ChohyoKyotsuJushoEditConfig}のテストです。
 *
 * @author n8178 城間篤人
 */
@Ignore
@RunWith(Enclosed.class)
public class ChohyoKyotsuJushoEditConfigTest {

    public static class get extends DbuTestBase {

        static ChohyoKyotsuJushoEditConfig sut;

        @Before
        public void setUp() {
            createBusinessConfigMock();
            sut = new ChohyoKyotsuJushoEditConfig();
        }

        @Test
        public void get都道府県名付与有無で_印字するが返る() {
            TodofukenNamePrint result = sut.get都道府県名付与有無();
            assertThat(result, is(TodofukenNamePrint.印字する));
        }

        @Test
        public void get郡名付与有無で_印字するが返る() {
            GunNamePrint result = sut.get郡名付与有無();
            assertThat(result, is(GunNamePrint.印字する));
        }

        @Test
        public void get市町村名付与有無で_印字するが返る() {
            ShichosonNamePrint result = sut.get市町村名付与有無();
            assertThat(result, is(ShichosonNamePrint.印字する));
        }

        @Test
        public void get住所編集方法で_住所と番地_行政区が返る() {
            HowToEditJusho result = sut.get住所編集方法();
            assertThat(result, is(HowToEditJusho.住所と番地_行政区));
        }

        @Test
        public void get方書表示有無で_印字するが返る() {
            KatagakiPrint result = sut.get方書表示有無();
            assertThat(result, is(KatagakiPrint.印字する));
        }
    }

    private static BusinessConfig createBusinessConfigMock() {
        BusinessConfig mock = mock(BusinessConfig.class);
        SubGyomuCode subGyomu = SubGyomuCode.DBU介護統計報告;
        when(mock.get(
                eq(ConfigKeysChohyoKyotsuJushoEdit.帳票共通住所編集方法_管内住所編集_都道府県名付与有無),
                any(RDate.class),
                eq(subGyomu)
        )).thenReturn(TodofukenNamePrint.印字する.code());
        when(mock.get(
                eq(ConfigKeysChohyoKyotsuJushoEdit.帳票共通住所編集方法_管内住所編集_郡名付与有無),
                any(RDate.class),
                eq(subGyomu)
        )).thenReturn(GunNamePrint.印字する.code());
        when(mock.get(
                eq(ConfigKeysChohyoKyotsuJushoEdit.帳票共通住所編集方法_管内住所編集_市町村名付与有無),
                any(RDate.class),
                eq(subGyomu)
        )).thenReturn(ShichosonNamePrint.印字する.code());
        when(mock.get(
                eq(ConfigKeysChohyoKyotsuJushoEdit.帳票共通住所編集方法_管内住所編集_編集方法),
                any(RDate.class),
                eq(subGyomu)
        )).thenReturn(HowToEditJusho.住所と番地_行政区.code());
        when(mock.get(
                eq(ConfigKeysChohyoKyotsuJushoEdit.帳票共通住所編集方法_住所編集_方書表示有無),
                any(RDate.class),
                eq(subGyomu)
        )).thenReturn(KatagakiPrint.印字する.code());
        return mock;
    }
}
