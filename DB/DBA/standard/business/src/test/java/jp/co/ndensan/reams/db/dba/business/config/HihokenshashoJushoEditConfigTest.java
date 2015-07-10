/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.config;

import jp.co.ndensan.reams.db.dba.definition.enumeratedtype.config.ConfigKeysHihokenshashoJushoEdit;
import jp.co.ndensan.reams.db.dbz.testhelper.DbaTestBase;
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
        public void get帳票独自区分を指定したとき_1が返る() {
            RString result = sut.get帳票独自区分();
            assertThat(result, is(new RString("1")));
        }

        @Test
        public void get都道府県名付与有無を指定したとき_0が返る() {
            RString result = sut.get都道府県名付与有無();
            assertThat(result, is(new RString("0")));
        }

        @Test
        public void get郡名付与有無を指定したとき_0が返る() {
            RString result = sut.get郡名付与有無();
            assertThat(result, is(new RString("0")));
        }

        @Test
        public void get市町村名付与有無を指定したとき_1が返る() {
            RString result = sut.get市町村名付与有無();
            assertThat(result, is(new RString("1")));
        }

        @Test
        public void get住所編集方法を指定したとき_3が返る() {
            RString result = sut.get住所編集方法();
            assertThat(result, is(new RString("3")));
        }

        @Test
        public void get方書表示有無を指定したとき_0が返る() {
            RString result = sut.get方書表示有無();
            assertThat(result, is(new RString("0")));
        }
    }

    private static IUrBusinessConfig createBusinessConfigMock() {
        IUrBusinessConfig mock = mock(IUrBusinessConfig.class);
        RDate nowDate = RDate.getNowDate();

        when(mock.get(
                ConfigKeysHihokenshashoJushoEdit.被保険者証表示方法_管内住所編集_帳票独自区分,
                nowDate
        )).thenReturn(new RString("1"));
        when(mock.get(
                ConfigKeysHihokenshashoJushoEdit.被保険者証表示方法_管内住所編集_都道府県名付与有無,
                nowDate
        )).thenReturn(new RString("0"));
        when(mock.get(
                ConfigKeysHihokenshashoJushoEdit.被保険者証表示方法_管内住所編集_郡名付与有無,
                nowDate
        )).thenReturn(new RString("0"));
        when(mock.get(
                ConfigKeysHihokenshashoJushoEdit.被保険者証表示方法_管内住所編集_市町村名付与有無,
                nowDate
        )).thenReturn(new RString("1"));
        when(mock.get(
                ConfigKeysHihokenshashoJushoEdit.被保険者証表示方法_管内住所編集_編集方法,
                nowDate
        )).thenReturn(new RString("3"));
        when(mock.get(
                ConfigKeysHihokenshashoJushoEdit.被保険者証表示方法_住所編集_方書表示有無,
                nowDate
        )).thenReturn(new RString("0"));
        return mock;
    }
}
