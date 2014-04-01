/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business;

import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.HihokenshashoSaikofuJiyu;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.HihokenshashoSaikofuKubun;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.JushochitokureiKaijoJiyu;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.JushochitokureiTekiyoJiyu;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.KoikinaiJushochitokureishaKubun;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.ShikakuHenkoJiyu;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.ShikakuIdoKubun;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.ShikakuShutokuJiyu;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.ShikakuSoshitsuJiyu;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ChohyoKofuRirekiID;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.KaigoHihokenshaNo;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.ur.urz.business.IKaigoShikaku;
import jp.co.ndensan.reams.ur.urz.business.IShikakuShutokuJiyu;
import jp.co.ndensan.reams.ur.urz.business.IShikakuSoshitsuJiyu;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.JushochiTokureishaKubun;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.ShikakuHihokenshaKubun;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.is;
import org.junit.Before;
import static org.mockito.Mockito.*;

/**
 * HihokenshaShikakuのテストです。
 *
 * @author N3327 三浦 凌
 */
@RunWith(Enclosed.class)
public class HihokenshaShikakuTest extends DbzTestBase {

    private static LasdecCode lasdecCode = new LasdecCode("123456");
    private static ShikibetsuCode shikibetsuCode = new ShikibetsuCode("3327");
    private static KaigoHihokenshaNo hihokenshaNo = new KaigoHihokenshaNo(new RString("1234567890"));
    private static ShikakuIdoKubun shikakuIdoKubun = ShikakuIdoKubun.資格取得;
    private static ShikakuHihokenshaKubun hihokenshaKubun = ShikakuHihokenshaKubun.第１号被保険者;
    private static ShikakuHenkoJiyu shikakuHenkoJiyu = ShikakuHenkoJiyu.なし;
    private static FlexibleDate shikakuHenkoTodokedeDate = new FlexibleDate("00000001");
    private static FlexibleDate shikakuHenkoDate = new FlexibleDate("00000002");
    private static JushochitokureiTekiyoJiyu jutokuTekiyoJiyu = JushochitokureiTekiyoJiyu.なし;
    private static FlexibleDate jutokuTekiyoTodokedeDate = new FlexibleDate("00000003");
    private static FlexibleDate jutokuTekiyoDate = new FlexibleDate("00000004");
    private static JushochitokureiKaijoJiyu jutokuKaijoJiyu = JushochitokureiKaijoJiyu.なし;
    private static FlexibleDate jutokuKaijoTodokedeDate = new FlexibleDate("00000005");
    private static FlexibleDate jutokuKaijoDate = new FlexibleDate("00000006");
    private static JushochiTokureishaKubun jutokushaKubun = JushochiTokureishaKubun.通常資格者;
    private static KoikinaiJushochitokureishaKubun koikinaiJutokushaKubun = KoikinaiJushochitokureishaKubun.通常資格者;
    private static LasdecCode koikiJutokuOriginLasdecCode = new LasdecCode("234567");
    private static LasdecCode oldLasdecCode = new LasdecCode("345678");
    private static HihokenshashoSaikofuKubun saikofuKubun = HihokenshashoSaikofuKubun.なし;
    private static HihokenshashoSaikofuJiyu saikofuJiyu = HihokenshashoSaikofuJiyu.なし;
    private static ChohyoKofuRirekiID chohyoKofuRirekiID = new ChohyoKofuRirekiID(new RString(""));
    private static final int IKaigoShikaku_is_Null = 1;
    private static final int ShikakuHenko_is_Null = 2;
    private static final int JushochitokureiTekiyo_is_Null = 3;
    private static final int JushochitokureiKaijo_is_Null = 4;
    private static final int HihokenshashoSaikofu_is_Null = 5;
    private static final int LasdecCode_is_Null = 6;
    private static final int ShikibetsuCode_is_Null = 7;
    private static final int ShikakuIdoKubun_is_Null = 8;
    private static final int HihokenshaKubun_is_Null = 9;
    private static final int JushochitokureishaKubun_is_Null = 10;
    private static final int KoikinaiJushochitokureishaKubun_is_Null = 11;

    public static class Constructor extends DbzTestBase {

        @Test(expected = NullPointerException.class)
        public void コンストラクタは_引数のIKaigoShikakuがnullのとき_NullPointerExceptionをスローする() {
            callConstructorAS(IKaigoShikaku_is_Null);
        }

        @Test(expected = NullPointerException.class)
        public void コンストラクタは_引数のLasdecCodeがnullのとき_NullPointerExceptionをスローする() {
            callConstructorAS(LasdecCode_is_Null);
        }

        @Test(expected = NullPointerException.class)
        public void コンストラクタは_引数のShikibetsuCodeがnullのとき_NullPointerExceptionをスローする() {
            callConstructorAS(ShikibetsuCode_is_Null);
        }

        @Test(expected = NullPointerException.class)
        public void コンストラクタは_引数のShikakuIdoKubunがnullのとき_NullPointerExceptionをスローする() {
            callConstructorAS(ShikakuIdoKubun_is_Null);
        }

        @Test(expected = NullPointerException.class)
        public void コンストラクタは_引数のHihokenshaKubunがnullのとき_NullPointerExceptionをスローする() {
            callConstructorAS(HihokenshaKubun_is_Null);
        }

        @Test(expected = NullPointerException.class)
        public void コンストラクタは_引数のShikakuHenkoがnullのとき_NullPointerExceptionをスローする() {
            callConstructorAS(ShikakuHenko_is_Null);
        }

        @Test(expected = NullPointerException.class)
        public void コンストラクタは_引数のJushochitokureiTekiyoがnullのとき_NullPointerExceptionをスローする() {
            callConstructorAS(JushochitokureiTekiyo_is_Null);
        }

        @Test(expected = NullPointerException.class)
        public void コンストラクタは_引数のJushochitokureiKaijoがnullのとき_NullPointerExceptionをスローする() {
            callConstructorAS(JushochitokureiKaijo_is_Null);
        }

        @Test(expected = NullPointerException.class)
        public void コンストラクタは_引数のJushochitokureishaKubunがnullのとき_NullPointerExceptionをスローする() {
            callConstructorAS(JushochitokureishaKubun_is_Null);
        }

        @Test(expected = NullPointerException.class)
        public void コンストラクタは_引数のKoikinaiJushochitokureishaKubunがnullのとき_NullPointerExceptionをスローする() {
            callConstructorAS(KoikinaiJushochitokureishaKubun_is_Null);
        }

        @Test(expected = NullPointerException.class)
        public void コンストラクタは_引数のHihokenshashoSaikofuがnullのとき_NullPointerExceptionをスローする() {
            callConstructorAS(HihokenshashoSaikofu_is_Null);
        }
    }

    @RunWith(Enclosed.class)
    public static class KaigoShikaku extends DbzTestBase {

        public static class ShikakuShutoku {

            private IKaigoShikaku kaigoShikaku;
            private IShikakuShutokuJiyu 資格取得事由;
            private HihokenshaShikaku sut;

            @Before
            public void setUp() {
                this.kaigoShikaku = mock(IKaigoShikaku.class);

                this.資格取得事由 = mock(IShikakuShutokuJiyu.class);
                RString 資格取得事由コード = ShikakuShutokuJiyu.年齢到達.getCode();
                when(資格取得事由.getCode()).thenReturn(資格取得事由コード);

                when(this.kaigoShikaku.get資格取得事由()).thenReturn(資格取得事由);
                when(this.kaigoShikaku.get資格取得届出年月日()).thenReturn(new RDate("20010101"));
                when(this.kaigoShikaku.get資格取得年月日()).thenReturn(new RDate("20010101"));

                sut = callConstructorToCreateWith(this.kaigoShikaku);
            }

            @Test
            public void get資格取得$getNoticeDateは_IKaigoShikakuのget資格取得届出年月日の返り値を_FlexibleDateへ変換して返す() {
                assertThat(sut.get資格取得().getNoticeDate().toString(), is(this.kaigoShikaku.get資格取得届出年月日().toString()));
            }

            @Test
            public void get資格取得$getActionDateは_IKaigoShikakuのget資格取得年月日の返り値を_FlexibleDateへ変換して返す() {
                assertThat(sut.get資格取得().getActionDate().toString(), is(this.kaigoShikaku.get資格取得年月日().toString()));
            }

            @Test
            public void get資格取得$getReasonは_IKaigoShikakuのget資格取得事由の返り値のgetCodeから得られるコードを_ShikakuShutokuJiyuへ変換して返す() {
                assertThat(sut.get資格取得().getReason(), is(ShikakuShutokuJiyu.toValue(this.kaigoShikaku.get資格取得事由().getCode())));
            }
        }

        public static class ShikakuSoshitsu {

            private IKaigoShikaku kaigoShikaku;
            private HihokenshaShikaku sut;

            @Before
            public void setUp() {
                this.kaigoShikaku = mock(IKaigoShikaku.class);

                IShikakuSoshitsuJiyu 資格喪失事由 = mock(IShikakuSoshitsuJiyu.class);
                RString 資格喪失事由コード = ShikakuSoshitsuJiyu.転出.getCode();
                when(資格喪失事由.getCode()).thenReturn(資格喪失事由コード);

                when(this.kaigoShikaku.get資格喪失事由()).thenReturn(資格喪失事由);
                when(this.kaigoShikaku.get資格喪失届出年月日()).thenReturn(new RDate("20010101"));
                when(this.kaigoShikaku.get資格喪失年月日()).thenReturn(new RDate("20010101"));

                sut = callConstructorToCreateWith(this.kaigoShikaku);
            }

            @Test
            public void get資格喪失$getNoticeDateは_IKaigoShikakuのget資格喪失届出年月日の返り値を_FlexibleDateへ変換して返す() {
                assertThat(sut.get資格喪失().getNoticeDate().toString(), is(this.kaigoShikaku.get資格喪失届出年月日().toString()));
            }

            @Test
            public void get資格喪失$getActionDateは_IKaigoShikakuのget資格喪失年月日の返り値を_FlexibleDateへ変換して返す() {
                assertThat(sut.get資格喪失().getActionDate().toString(), is(this.kaigoShikaku.get資格喪失年月日().toString()));
            }

            @Test
            public void get資格喪失$getReasonは_IKaigoShikakuのget資格喪失事由の返り値のgetCodeから得られるコードを_ShikakuSoshitsuJiyuへ変換して返す() {
                assertThat(sut.get資格喪失().getReason(), is(ShikakuSoshitsuJiyu.toValue(this.kaigoShikaku.get資格喪失事由().getCode())));
            }
        }

        public static class Other {

            private IKaigoShikaku kaigoShikaku;

            @Before
            public void setUp() {
                this.kaigoShikaku = mock(IKaigoShikaku.class);
            }

            @Test
            public void get第一号年齢到達日は_IKaigoShikakuのget一号該当日の返り値を_FlexibleDateへ変換して返す() {
                RDate date = new RDate("20010101");
                when(this.kaigoShikaku.get一号該当日()).thenReturn(date);

                HihokenshaShikaku sut = callConstructorToCreateWith(this.kaigoShikaku);
                assertThat(sut.get第一号年齢到達日().toString(), is(this.kaigoShikaku.get一号該当日().toString()));
            }

            @Test
            public void has被保険者資格Atは_IKaigoShikakuのis資格ありがtrueのとき_trueを返す() {
                when(this.kaigoShikaku.is資格あり(any(RDate.class))).thenReturn(true);

                HihokenshaShikaku sut = callConstructorToCreateWith(this.kaigoShikaku);
                assertThat(sut.has被保険者資格At(new RDate("20140318")), is(true));
            }

            @Test
            public void has被保険者資格Atは_IKaigoShikakuのis資格ありがfalseのとき_falseを返す() {
                when(this.kaigoShikaku.is資格あり(any(RDate.class))).thenReturn(false);

                HihokenshaShikaku sut = callConstructorToCreateWith(this.kaigoShikaku);
                assertThat(sut.has被保険者資格At(new RDate("20140318")), is(false));
            }

            @Test
            public void toKaigoShikakuは_コンストラクタ引数と同じ値を返す() {
                HihokenshaShikaku sut = callConstructorToCreateWith(this.kaigoShikaku);
                assertThat(sut.toKaigoShikaku(), is(this.kaigoShikaku));
            }
        }
    }

    public static class Getter extends DbzTestBase {

        private IKaigoShikaku kaigoShikaku;
        private HihokenshaShikaku sut;

        @Before
        public void setUp() {
            this.kaigoShikaku = mock(IKaigoShikaku.class);
            sut = callConstructorToCreateWith(kaigoShikaku);
        }

        @Test
        public void get地方公共団体コードは_コンストラクタに渡されたものと_同じ値を返す() {
            assertThat(sut.get地方公共団体コード(), is(lasdecCode));
        }

        @Test
        public void get識別コードは_コンストラクタに渡されたものと_同じ値を返す() {
            assertThat(sut.get識別コード(), is(shikibetsuCode));
        }

        @Test
        public void get被保険者番号は_コンストラクタに渡されたものと_同じ値を返す() {
            assertThat(sut.get被保険者番号(), is(hihokenshaNo));
        }

        @Test
        public void get資格異動区分は_コンストラクタに渡されたものと_同じ値を返す() {
            assertThat(sut.get資格異動区分(), is(shikakuIdoKubun));
        }

        @Test
        public void get被保険者区分は_コンストラクタに渡されたものと_同じ値を返す() {
            assertThat(sut.get被保険者区分(), is(hihokenshaKubun));
        }

        @Test
        public void get資格変更$getReasonは_コンストラクタに渡された資格変更事由と_同じ値を返す() {
            assertThat(sut.get資格変更().getReason(), is(shikakuHenkoJiyu));
        }

        @Test
        public void get資格変更$getNoticeDateは_コンストラクタに渡された資格変更届出年月日と_同じ値を返す() {
            assertThat(sut.get資格変更().getNoticeDate(), is(shikakuHenkoTodokedeDate));
        }

        @Test
        public void get資格変更$getActionDateは_コンストラクタに渡された資格変更年月日と_同じ値を返す() {
            assertThat(sut.get資格変更().getActionDate(), is(shikakuHenkoDate));
        }

        @Test
        public void get住所地特例適用$getReasonは_コンストラクタに渡された住所地特例適用事由と_同じ値を返す() {
            assertThat(sut.get住所地特例適用().getReason(), is(jutokuTekiyoJiyu));
        }

        @Test
        public void get住所地特例適用$getNoticeDateは_コンストラクタに渡された住所地特例適用届出年月日と_同じ値を返す() {
            assertThat(sut.get住所地特例適用().getNoticeDate(), is(jutokuTekiyoTodokedeDate));
        }

        @Test
        public void get住所地特例適用$getActionDateは_コンストラクタに渡された住所地特例適用年月日と_同じ値を返す() {
            assertThat(sut.get住所地特例適用().getActionDate(), is(jutokuTekiyoDate));
        }

        @Test
        public void get住所地特例解除事由は_コンストラクタに渡された住所地特例解除事由と_同じ値を返す() {
            assertThat(sut.get住所地特例解除().getReason(), is(jutokuKaijoJiyu));
        }

        @Test
        public void get住所地特例解除届出年月日は_コンストラクタに渡された住所地特例解除届出年月日と_同じ値を返す() {
            assertThat(sut.get住所地特例解除().getNoticeDate(), is(jutokuKaijoTodokedeDate));
        }

        @Test
        public void get住所地特例解除年月日は_コンストラクタに渡された住所地特例解除年月日と_同じ値を返す() {
            assertThat(sut.get住所地特例解除().getActionDate(), is(jutokuKaijoDate));
        }

        @Test
        public void get住所地特例者区分は_コンストラクタに渡されたものと_同じ値を返す() {
            assertThat(sut.get住所地特例者区分(), is(jutokushaKubun));
        }

        @Test
        public void get広域内住所地特例者区分は_コンストラクタに渡されたものと_同じ値を返す() {
            assertThat(sut.get広域内住所地特例者区分(), is(koikinaiJutokushaKubun));
        }

        @Test
        public void get広域内住所地特例措置元市町村コードは_コンストラクタに渡されたものと_同じ値を返す() {
            assertThat(sut.get広域内住所地特例措置元市町村コード(), is(koikiJutokuOriginLasdecCode));
        }

        @Test
        public void get旧市町村コードは_コンストラクタに渡されたものと_同じ値を返す() {
            assertThat(sut.get旧市町村コード(), is(oldLasdecCode));
        }

        @Test
        public void get被保険者証再交付$get有無区分は_コンストラクタに渡されたものと_同じ値を返す() {
            assertThat(sut.get被保険者証再交付().get有無区分(), is(saikofuKubun));
        }

        @Test
        public void get被保険者証再交付$getReasonは_コンストラクタに渡されたものと_同じ値を返す() {
            assertThat(sut.get被保険者証再交付().getReason(), is(saikofuJiyu));
        }

        @Test
        public void get被保険者証再交付$getChohyoKofuRirekiIDは_コンストラクタに渡されたものと_同じ値を返す() {
            assertThat(sut.get被保険者証再交付().getChohyoKofuRirekiID(), is(chohyoKofuRirekiID));
        }
    }

    private static HihokenshaShikaku callConstructorToCreateWith(IKaigoShikaku kaigoShikaku) {
        return new HihokenshaShikaku(kaigoShikaku,
                lasdecCode, shikibetsuCode, hihokenshaNo, shikakuIdoKubun, hihokenshaKubun,
                new ShikakuHenko(shikakuHenkoJiyu, shikakuHenkoTodokedeDate, shikakuHenkoDate),
                new JushochitokureiTekiyo(jutokuTekiyoJiyu, jutokuTekiyoTodokedeDate, jutokuTekiyoDate),
                new JushochitokureiKaijo(jutokuKaijoJiyu, jutokuKaijoTodokedeDate, jutokuKaijoDate),
                jutokushaKubun, koikinaiJutokushaKubun, koikiJutokuOriginLasdecCode, oldLasdecCode,
                new HihokenshashoSaikofu(saikofuKubun, saikofuJiyu, chohyoKofuRirekiID));
    }

    private static HihokenshaShikaku callConstructorAS(int flag) {
        return new HihokenshaShikaku(
                flag == IKaigoShikaku_is_Null ? null : mock(IKaigoShikaku.class),
                flag == LasdecCode_is_Null ? null : lasdecCode,
                flag == ShikibetsuCode_is_Null ? null : shikibetsuCode,
                hihokenshaNo,
                flag == ShikakuIdoKubun_is_Null ? null : shikakuIdoKubun,
                flag == HihokenshaKubun_is_Null ? null : hihokenshaKubun,
                flag == ShikakuHenko_is_Null ? null : new ShikakuHenko(shikakuHenkoJiyu, shikakuHenkoTodokedeDate, shikakuHenkoDate),
                flag == JushochitokureiTekiyo_is_Null ? null : new JushochitokureiTekiyo(jutokuTekiyoJiyu, jutokuTekiyoTodokedeDate, jutokuTekiyoDate),
                flag == JushochitokureiKaijo_is_Null ? null : new JushochitokureiKaijo(jutokuKaijoJiyu, jutokuKaijoTodokedeDate, jutokuKaijoDate),
                flag == JushochitokureishaKubun_is_Null ? null : jutokushaKubun,
                flag == KoikinaiJushochitokureishaKubun_is_Null ? null : koikinaiJutokushaKubun,
                koikiJutokuOriginLasdecCode,
                oldLasdecCode,
                flag == HihokenshashoSaikofu_is_Null ? null : new HihokenshashoSaikofu(saikofuKubun, saikofuJiyu, chohyoKofuRirekiID));
    }
}
