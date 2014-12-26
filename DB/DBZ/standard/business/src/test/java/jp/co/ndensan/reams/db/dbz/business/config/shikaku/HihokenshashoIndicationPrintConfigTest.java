/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.config.shikaku;

import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.configkeys.shikaku.ConfigKeysHihokenshashoPrint;
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
 * {@link jp.co.ndensan.reams.db.dba.business.config.HihokenshashoIndicationMethodConfig}のテストです。
 *
 * @author n8178 城間篤人
 */
@RunWith(Enclosed.class)
public class HihokenshashoIndicationPrintConfigTest {

    public static class get extends DbaTestBase {

        private HihokenshashoPrintConfig sut;

        @Before
        public void setUp() {
            sut = new HihokenshashoPrintConfig(createBusinessConfigMock());
        }

        @Test
        public void get氏名カナ表示有無で_1が返る() {
            RString result = sut.get氏名カナ表示有無();
            assertThat(result, is(new RString("1")));
        }

        @Test
        public void get証表示タイプで_21が返る() {
            RString result = sut.get証表示タイプ();
            assertThat(result, is(new RString("21")));
        }

        @Test
        public void get被保険者番号表示書式で_2が返る() {
            RString result = sut.get被保険者番号表示書式();
            assertThat(result, is(new RString("2")));
        }

        @Test
        public void get郵便番号表示有無で_1が返る() {
            RString result = sut.get郵便番号表示有無();
            assertThat(result, is(new RString("1")));
        }

        @Test
        public void get要介護認定期限切れ表示有無で_1が返る() {
            RString result = sut.get要介護認定期限切れ表示有無();
            assertThat(result, is(new RString("1")));
        }

        @Test
        public void get居宅支援事業者適用切れ表示有無で_1が返る() {
            RString result = sut.get居宅支援事業者適用切れ表示有無();
            assertThat(result, is(new RString("1")));
        }

        @Test
        public void get居宅支援事業者履歴表示方法で_0が返る() {
            RString result = sut.get居宅支援事業者履歴表示方法();
            assertThat(result, is(new RString("0")));
        }

        @Test
        public void get合併前印刷時_有効期限表示方法で_2が返る() {
            RString result = sut.get合併前印刷時_有効期限表示方法();
            assertThat(result, is(new RString("2")));
        }

        @Test
        public void get委託代行業者表示有無で_0が返る() {
            RString result = sut.get委託代行業者表示有無();
            assertThat(result, is(new RString("0")));
        }

        @Test
        public void get委託代行業者表示開始文言で_設定した開始文言が返る() {
            RString result = sut.get委託代行業者表示開始文言();
            assertThat(result, is(new RString("(委託先:")));
        }

        @Test
        public void get委託代行業者_表示終了文言で_設定した終了文言が返る() {
            RString result = sut.get委託代行業者_表示終了文言();
            assertThat(result, is(new RString(")")));
        }

        @Test
        public void get適用開始日切替表示区分で_0が返る() {
            RString result = sut.get適用開始日切替表示区分();
            assertThat(result, is(new RString("0")));
        }

    }

    private static IUrBusinessConfig createBusinessConfigMock() {
        IUrBusinessConfig mock = mock(IUrBusinessConfig.class);
        RDate nowDate = RDate.getNowDate();
        SubGyomuCode subGyomu = SubGyomuCode.DBA介護資格;

        when(mock.get(
                ConfigKeysHihokenshashoPrint.被保険者証表示方法_氏名カナ表示有無,
                nowDate,
                subGyomu
        )).thenReturn(new RString("1"));
        when(mock.get(
                ConfigKeysHihokenshashoPrint.被保険者証表示方法_証表示タイプ,
                nowDate,
                subGyomu
        )).thenReturn(new RString("21"));
        when(mock.get(
                ConfigKeysHihokenshashoPrint.被保険者証表示方法_被保険者番号表示書式,
                nowDate,
                subGyomu
        )).thenReturn(new RString("2"));
        when(mock.get(
                ConfigKeysHihokenshashoPrint.被保険者証表示方法_郵便番号表示有無,
                nowDate,
                subGyomu
        )).thenReturn(new RString("1"));
        when(mock.get(
                ConfigKeysHihokenshashoPrint.被保険者証表示方法_要介護認定期限切れ_表示有無,
                nowDate,
                subGyomu
        )).thenReturn(new RString("1"));
        when(mock.get(
                ConfigKeysHihokenshashoPrint.被保険者証表示方法_居宅支援事業者適用切れ_表示有無,
                nowDate,
                subGyomu
        )).thenReturn(new RString("1"));
        when(mock.get(
                ConfigKeysHihokenshashoPrint.被保険者証表示方法_居宅支援事業者履歴_表示方法,
                nowDate,
                subGyomu
        )).thenReturn(new RString("0"));
        when(mock.get(
                ConfigKeysHihokenshashoPrint.被保険者証表示方法_合併前印刷時_有効期限,
                nowDate,
                subGyomu
        )).thenReturn(new RString("2"));
        when(mock.get(
                ConfigKeysHihokenshashoPrint.被保険者証表示方法_委託代行業者_表示有無,
                nowDate,
                subGyomu
        )).thenReturn(new RString("0"));
        when(mock.get(
                ConfigKeysHihokenshashoPrint.被保険者証表示方法_委託代行業者_表示開始文言,
                nowDate,
                subGyomu
        )).thenReturn(new RString("(委託先:"));
        when(mock.get(
                ConfigKeysHihokenshashoPrint.被保険者証表示方法_委託代行業者_表示終了文言,
                nowDate,
                subGyomu
        )).thenReturn(new RString(")"));
        when(mock.get(
                ConfigKeysHihokenshashoPrint.被保険者証表示方法_居宅支援事業者届出日_適用開始日切替表示区分,
                nowDate,
                subGyomu
        )).thenReturn(new RString("0"));
        return mock;
    }
}
