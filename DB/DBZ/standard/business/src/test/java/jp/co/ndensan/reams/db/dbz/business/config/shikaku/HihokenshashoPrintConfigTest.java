///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package jp.co.ndensan.reams.db.dbz.business.config.shikaku;
//
//import jp.co.ndensan.reams.db.dbz.business.config.ConfigValueBoolean;
//import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.configkeys.shikaku.ConfigKeysHihokenshashoPrint;
//import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.configvalues.HihokenshaNoPrintType;
//import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.configvalues.HihokenshashoPrintType;
//import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.configvalues.KyotakuJigyoshaRirekiPrintType;
//import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.configvalues.YukoKigenPrintType;
//import jp.co.ndensan.reams.db.dbz.testhelper.DbaTestBase;
//import jp.co.ndensan.reams.ur.urz.business.config.IUrBusinessConfig;
//import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
//import jp.co.ndensan.reams.uz.uza.lang.RDate;
//import jp.co.ndensan.reams.uz.uza.lang.RString;
//import org.junit.Test;
//import static org.junit.Assert.*;
//import static org.hamcrest.CoreMatchers.*;
//import org.junit.Before;
//import org.junit.experimental.runners.Enclosed;
//import org.junit.runner.RunWith;
//import static org.mockito.Mockito.mock;
//import static org.mockito.Mockito.when;
//import static org.mockito.Mockito.any;
//import static org.mockito.Mockito.eq;
//
///**
// * {@link HihokenshashoIndicationMethodConfig}のテストです。
// *
// * @author n8178 城間篤人
// */
//@RunWith(Enclosed.class)
//public class HihokenshashoPrintConfigTest {
//
//    public static class get extends DbaTestBase {
//
//        private HihokenshashoPrintConfig sut;
//
//        @Before
//        public void setUp() {
//            sut = new HihokenshashoPrintConfig(createBusinessConfigMock());
//        }
//
//        @Test
//        public void is氏名カナ表示有りで_trueが返る() {
//            boolean result = sut.is氏名カナ表示有り();
//            assertThat(result, is(ConfigValueBoolean.parseBoolean(氏名カナ表示有無)));
//        }
//
//        @Test
//        public void get証表示タイプで_B4横が返る() {
//            HihokenshashoPrintType result = sut.get証表示タイプ();
//            assertThat(result, is(HihokenshashoPrintType.B4横));
//        }
//
//        @Test
//        public void get被保険者番号表示書式で_そのままが返る() {
//            HihokenshaNoPrintType result = sut.get被保険者番号表示書式();
//            assertThat(result, is(HihokenshaNoPrintType.そのまま));
//        }
//
//        @Test
//        public void is郵便番号表示有りで_trueが返る() {
//            boolean result = sut.is郵便番号表示有り();
//            assertThat(result, is(ConfigValueBoolean.parseBoolean(郵便番号表示有無)));
//        }
//
//        @Test
//        public void is要介護認定期限切れ表示有りで_trueが返る() {
//            boolean result = sut.is要介護認定期限切れ表示有り();
//            assertThat(result, is(ConfigValueBoolean.parseBoolean(要介護認定期限切れ_表示有無)));
//        }
//
//        @Test
//        public void is居宅支援事業者適用切れ表示有りで_trueが返る() {
//            boolean result = sut.is居宅支援事業者適用切れ表示有り();
//            assertThat(result, is(ConfigValueBoolean.parseBoolean(居宅支援事業者適用切れ_表示有無)));
//        }
//
//        @Test
//        public void get居宅支援事業者履歴表示方法で_表示が返る() {
//            KyotakuJigyoshaRirekiPrintType result = sut.get居宅支援事業者履歴表示方法();
//            assertThat(result, is(KyotakuJigyoshaRirekiPrintType.表示));
//        }
//
//        @Test
//        public void get合併前印刷時_有効期限表示方法で_有効期限のみが返る() {
//            YukoKigenPrintType result = sut.get合併前印刷時_有効期限表示方法();
//            assertThat(result, is(YukoKigenPrintType.有効期限のみ));
//        }
//
//        @Test
//        public void is委託代行業者表示有り() {
//            boolean result = sut.is委託代行業者表示有り();
//            assertThat(result, is(ConfigValueBoolean.parseBoolean(委託代行業者_表示有無)));
//        }
//
//        @Test
//        public void get委託代行業者表示開始文言で_設定した開始文言が返る() {
//            RString result = sut.get委託代行業者表示開始文言();
//            assertThat(result, is(委託代行業者_表示開始文言));
//        }
//
//        @Test
//        public void get委託代行業者_表示終了文言で_設定した終了文言が返る() {
//            RString result = sut.get委託代行業者_表示終了文言();
//            assertThat(result, is(委託代行業者_表示終了文言));
//        }
//
//        @Test
//        public void is届出日の代わりに適用開始日を表示で_falseが返る() {
//            boolean result = sut.is届出日の代わりに適用開始日を表示();
//            assertThat(result, is(ConfigValueBoolean.parseBoolean(届出日の代わりに適用開始日を表示)));
//        }
//    }
//    private static final RString 氏名カナ表示有無;
//    private static final RString 郵便番号表示有無;
//    private static final RString 要介護認定期限切れ_表示有無;
//    private static final RString 居宅支援事業者適用切れ_表示有無;
//    private static final RString 委託代行業者_表示有無;
//    private static final RString 委託代行業者_表示開始文言;
//    private static final RString 委託代行業者_表示終了文言;
//    private static final RString 届出日の代わりに適用開始日を表示;
//
//    static {
//        氏名カナ表示有無 = new RString("1");
//        郵便番号表示有無 = new RString("1");
//        要介護認定期限切れ_表示有無 = new RString("1");
//        居宅支援事業者適用切れ_表示有無 = new RString("0");
//        委託代行業者_表示有無 = new RString("0");
//        委託代行業者_表示開始文言 = new RString("(委託先:");
//        委託代行業者_表示終了文言 = new RString(")");
//        届出日の代わりに適用開始日を表示 = new RString("0");
//    }
//
//    private static IUrBusinessConfig createBusinessConfigMock() {
//        IUrBusinessConfig mock = mock(IUrBusinessConfig.class);
//        when(mock.get(
//                eq(ConfigKeysHihokenshashoPrint.被保険者証表示方法_氏名カナ表示有無),
//                any(RDate.class),
//                eq(SubGyomuCode.DBA介護資格)
//        )).thenReturn(氏名カナ表示有無);
//        when(mock.get(
//                eq(ConfigKeysHihokenshashoPrint.被保険者証表示方法_証表示タイプ),
//                any(RDate.class),
//                eq(SubGyomuCode.DBA介護資格)
//        )).thenReturn(HihokenshashoPrintType.B4横.getValue());
//        when(mock.get(
//                eq(ConfigKeysHihokenshashoPrint.被保険者証表示方法_被保険者番号表示書式),
//                any(RDate.class),
//                eq(SubGyomuCode.DBA介護資格)
//        )).thenReturn(HihokenshaNoPrintType.そのまま.getValue());
//        when(mock.get(
//                eq(ConfigKeysHihokenshashoPrint.被保険者証表示方法_郵便番号表示有無),
//                any(RDate.class),
//                eq(SubGyomuCode.DBA介護資格)
//        )).thenReturn(郵便番号表示有無);
//        when(mock.get(
//                eq(ConfigKeysHihokenshashoPrint.被保険者証表示方法_要介護認定期限切れ_表示有無),
//                any(RDate.class),
//                eq(SubGyomuCode.DBA介護資格)
//        )).thenReturn(要介護認定期限切れ_表示有無);
//        when(mock.get(
//                eq(ConfigKeysHihokenshashoPrint.被保険者証表示方法_居宅支援事業者適用切れ_表示有無),
//                any(RDate.class),
//                eq(SubGyomuCode.DBA介護資格)
//        )).thenReturn(KyotakuJigyoshaRirekiPrintType.表示.getValue());
//        when(mock.get(
//                eq(ConfigKeysHihokenshashoPrint.被保険者証表示方法_居宅支援事業者履歴_表示方法),
//                any(RDate.class),
//                eq(SubGyomuCode.DBA介護資格)
//        )).thenReturn(居宅支援事業者適用切れ_表示有無);
//        when(mock.get(
//                eq(ConfigKeysHihokenshashoPrint.被保険者証表示方法_合併前印刷時_有効期限),
//                any(RDate.class),
//                eq(SubGyomuCode.DBA介護資格)
//        )).thenReturn(YukoKigenPrintType.有効期限のみ.getValue());
//        when(mock.get(
//                eq(ConfigKeysHihokenshashoPrint.被保険者証表示方法_委託代行業者_表示有無),
//                any(RDate.class),
//                eq(SubGyomuCode.DBA介護資格)
//        )).thenReturn(委託代行業者_表示有無);
//        when(mock.get(
//                eq(ConfigKeysHihokenshashoPrint.被保険者証表示方法_委託代行業者_表示開始文言),
//                any(RDate.class),
//                eq(SubGyomuCode.DBA介護資格)
//        )).thenReturn(委託代行業者_表示開始文言);
//        when(mock.get(
//                eq(ConfigKeysHihokenshashoPrint.被保険者証表示方法_委託代行業者_表示終了文言),
//                any(RDate.class),
//                eq(SubGyomuCode.DBA介護資格)
//        )).thenReturn(委託代行業者_表示終了文言);
//        when(mock.get(
//                eq(ConfigKeysHihokenshashoPrint.被保険者証表示方法_居宅支援事業者届出日_適用開始日切替表示区分),
//                any(RDate.class),
//                eq(SubGyomuCode.DBA介護資格)
//        )).thenReturn(届出日の代わりに適用開始日を表示);
//        return mock;
//    }
//}
