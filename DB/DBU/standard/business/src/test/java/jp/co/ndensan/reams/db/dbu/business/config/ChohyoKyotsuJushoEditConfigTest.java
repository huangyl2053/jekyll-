/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.business.config;

import jp.co.ndensan.reams.db.dbu.definition.enumeratedtype.config.ConfigKeysChohyoKyotsuJushoEdit;
import jp.co.ndensan.reams.db.dbz.testhelper.DbuTestBase;
import jp.co.ndensan.reams.ur.urz.business.config.IUrBusinessConfig;
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
 * {@link jp.co.ndensan.reams.db.dbu.business.config.ChohyoKyotsuJushoEditConfig}のテストです。
 *
 * @author n8178 城間篤人
 */
@RunWith(Enclosed.class)
public class ChohyoKyotsuJushoEditConfigTest {

    public static class get extends DbuTestBase {

        private ChohyoKyotsuJushoEditConfig sut;

        @Before
        public void setUp() {
            sut = new ChohyoKyotsuJushoEditConfig(createBusinessConfigMock());
        }

        @Test
        public void get都道府県名付与有無で_1が返る() {
            RString result = sut.get都道府県名付与有無();
            assertThat(result, is(new RString("1")));
        }

        @Test
        public void get郡名付与有無で_1が返る() {
            RString result = sut.get郡名付与有無();
            assertThat(result, is(new RString("1")));
        }

        @Test
        public void get市町村名付与有無で_1が返る() {
            RString result = sut.get市町村名付与有無();
            assertThat(result, is(new RString("1")));
        }

        @Test
        public void get住所編集方法で_3が返る() {
            RString result = sut.get住所編集方法();
            assertThat(result, is(new RString("3")));
        }

        @Test
        public void get方書表示有無で_1が返る() {
            RString result = sut.get方書表示有無();
            assertThat(result, is(new RString("1")));
        }
    }

    private static IUrBusinessConfig createBusinessConfigMock() {
        IUrBusinessConfig mock = mock(IUrBusinessConfig.class);
        RDate nowDate = RDate.getNowDate();

        when(mock.get(
                ConfigKeysChohyoKyotsuJushoEdit.帳票共通住所編集方法_管内住所編集_都道府県名付与有無,
                nowDate
        )).thenReturn(new RString("1"));
        when(mock.get(
                ConfigKeysChohyoKyotsuJushoEdit.帳票共通住所編集方法_管内住所編集_郡名付与有無,
                nowDate
        )).thenReturn(new RString("1"));
        when(mock.get(
                ConfigKeysChohyoKyotsuJushoEdit.帳票共通住所編集方法_管内住所編集_市町村名付与有無,
                nowDate
        )).thenReturn(new RString("1"));
        when(mock.get(
                ConfigKeysChohyoKyotsuJushoEdit.帳票共通住所編集方法_管内住所編集_編集方法,
                nowDate
        )).thenReturn(new RString("3"));
        when(mock.get(
                ConfigKeysChohyoKyotsuJushoEdit.帳票共通住所編集方法_住所編集_方書表示有無,
                nowDate
        )).thenReturn(new RString("1"));
        return mock;
    }
}
