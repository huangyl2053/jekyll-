/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core;

import jp.co.ndensan.reams.db.dbx.business.core.IKaigoShikaku;
import jp.co.ndensan.reams.db.dbx.definition.core.enumeratedtype.JushochiTokureishaKubun;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.core.enumeratedtype.HihokenshashoSaikofuJiyu;
import jp.co.ndensan.reams.db.dbz.definition.core.enumeratedtype.HihokenshashoSaikofuKubun;
import jp.co.ndensan.reams.db.dbz.definition.core.JushochitokureiKaijoJiyu;
import jp.co.ndensan.reams.db.dbz.definition.core.JushochitokureiTekiyoJiyu;
import jp.co.ndensan.reams.db.dbz.definition.core.enumeratedtype.ShikakuHenkoJiyu;
import jp.co.ndensan.reams.db.dbz.definition.core.enumeratedtype.ShikakuShutokuJiyu;
import jp.co.ndensan.reams.db.dbz.definition.core.shikakuidojiyu.ShikakuSoshitsuJiyu;
import jp.co.ndensan.reams.db.dbz.definition.core.jushochitokureisha.KoikinaiJushochitokureishaKubun;
import jp.co.ndensan.reams.db.dbz.definition.core.chohyokofurirekiid.ChohyoKofuRirekiID;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.ua.uax.business.core.dateofbirth.IDateOfBirth;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.kojin.IKojin;
import jp.co.ndensan.reams.ur.urz.business.core.jusho.IJusho;
import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.Gender;
import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.IName;
import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.JuminShubetsu;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.KojinNo;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.SetaiCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Hihokenshaのテストです。
 *
 * @author N3327 三浦 凌
 */
@Ignore
@RunWith(Enclosed.class)
public class HihokenshaTest extends DbzTestBase {

    public static class Constructor extends DbzTestBase {

        private IKojin profile;
        private IHihokenshaShikaku shikaku;

        @Before
        public void setUp() {
            profile = mock(IKojin.class);
            shikaku = mock(IHihokenshaShikaku.class);
        }

        @Test(expected = NullPointerException.class)
        public void コンストラクタは_引数のIKojinがnullのとき_NullPointerExceptionをスローする() {
            Hihokensha sut = new Hihokensha(null, shikaku);
        }

        @Test(expected = NullPointerException.class)
        public void コンストラクタは_引数のIHihokenshaShikakuがnullのとき_NullPointerExceptionをスローする() {
            Hihokensha sut = new Hihokensha(profile, null);
        }
    }

    @RunWith(Enclosed.class)
    public static class Getter_IHihokenshaShikaku extends DbzTestBase {

        private static IKojin profile;
        private static IHihokenshaShikaku shikaku;

        @BeforeClass
        public static void setUp() {
            profile = mock(IKojin.class);
            shikaku = mock(IHihokenshaShikaku.class);
        }

        public static class Other extends DbzTestBase {

            private Hihokensha sut;

            @Before
            public void setUp() {
                sut = new Hihokensha(profile, shikaku);
            }

            @Test
            public void get市町村コードは_コンストラクタ引数のIHihokenshaShikakuの_get市町村コードと_同じ値を返す() {
                LasdecCode lasdecCode = new LasdecCode("000001");
                when(shikaku.get市町村コード()).thenReturn(lasdecCode);
                assertThat(sut.get市町村コード(), is(lasdecCode));
            }

            @Test
            public void get識別コードは_コンストラクタ引数のIHihokenshaShikakuの_get識別コードと_同じ値を返す() {
                ShikibetsuCode shikibetsuCode = new ShikibetsuCode("0000000001");
                when(shikaku.get識別コード()).thenReturn(shikibetsuCode);
                assertThat(sut.get識別コード(), is(shikibetsuCode));
            }

            @Test
            public void get被保険者番号は_コンストラクタ引数のIHihokenshaShikakuの_get被保険者番号_同じ値を返す() {
                HihokenshaNo hihokenshaNo = new HihokenshaNo(new RString("0000000000"));
                when(shikaku.get被保険者番号()).thenReturn(hihokenshaNo);
                assertThat(sut.get被保険者番号(), is(hihokenshaNo));
            }

            @Test
            public void get第一号年齢到達日は_コンストラクタ引数のIHihokenshaShikakuの_get第一号年齢到達日と_同じ値を返す() {
                FlexibleDate date = new FlexibleDate("20111111");
                when(shikaku.get第一号年齢到達日()).thenReturn(date);
                assertThat(sut.get第一号年齢到達日(), is(date));
            }

            @Test
            public void get被保険者区分は_コンストラクタ引数のIHihokenshaShikakuの_get被保険者区分と_同じ値を返す() {
                HihokenshaKubun kubun = new HihokenshaKubun(new Code("1"), new RString("第1号"));
                when(shikaku.get被保険者区分()).thenReturn(kubun);
                assertThat(sut.get被保険者区分(), is(kubun));
            }

            @Test
            public void has被保険者資格Atは_コンストラクタ引数のIHihokenshaShikakuの_has被保険者資格Atがtrueなら_trueを返す() {
                RDate date = new RDate("20001010");
                when(shikaku.has被保険者資格At(date)).thenReturn(true);
                assertThat(sut.has被保険者資格At(date), is(true));
            }

            @Test
            public void has被保険者資格Atは_コンストラクタ引数のIHihokenshaShikakuの_has被保険者資格Atがfalseなら_falseを返す() {
                RDate date = new RDate("20001010");
                when(shikaku.has被保険者資格At(date)).thenReturn(false);
                assertThat(sut.has被保険者資格At(date), is(false));
            }

            @Test
            public void get住所地特例者区分は_コンストラクタ引数のIHihokenshaShikakuのものと_同じ値を返す() {
                JushochiTokureishaKubun kubun = JushochiTokureishaKubun.住所地特例者;
                when(shikaku.get住所地特例者区分()).thenReturn(kubun);
                assertThat(sut.get住所地特例者区分(), is(kubun));
            }

            @Test
            public void get広域内住所地特例者区分は_コンストラクタ引数のIHihokenshaShikakuのものと_同じ値を返す() {
                KoikinaiJushochitokureishaKubun kubun = KoikinaiJushochitokureishaKubun.広域内住所地特例者;
                when(shikaku.get広域内住所地特例者区分()).thenReturn(kubun);
                assertThat(sut.get広域内住所地特例者区分(), is(kubun));
            }

            @Test
            public void get広域内住所地特例措置元市町村コードは_コンストラクタ引数のIHihokenshaShikakuのものと_同じ値を返す() {
                ShoKisaiHokenshaNo shoKisaiHokenshaNo = new ShoKisaiHokenshaNo("000001");
                when(shikaku.get広域内住所地特例措置元保険者番号()).thenReturn(shoKisaiHokenshaNo);
                assertThat(sut.get広域内住所地特例措置元保険者番号(), is(shoKisaiHokenshaNo));
            }

            @Test
            public void get旧市町村コードは_コンストラクタ引数のIHihokenshaShikakuのものと_同じ値を返す() {
                LasdecCode lasdecCode = new LasdecCode("000001");
                when(shikaku.get旧市町村コード()).thenReturn(lasdecCode);
                assertThat(sut.get旧市町村コード(), is(lasdecCode));
            }

            @Test
            public void toKaigoShikakuは_コンストラクタ引数のIHihokenshaShikakuのものと_同じ値を返す() {
                IKaigoShikaku kaigoShikaku = mock(IKaigoShikaku.class);
                when(shikaku.toKaigoShikaku()).thenReturn(kaigoShikaku);
                assertThat(sut.toKaigoShikaku(), is(kaigoShikaku));
            }
        }

        public static class Saikofu extends DbzTestBase {

            private Hihokensha sut;
            private HihokenshashoSaikofu saikofu;
            private HihokenshashoSaikofuKubun kubun;
            private HihokenshashoSaikofuJiyu reason;
            private ChohyoKofuRirekiID id;

            @Before
            public void setUp() {
                kubun = HihokenshashoSaikofuKubun.あり;
                reason = HihokenshashoSaikofuJiyu.その他;
                id = new ChohyoKofuRirekiID(new RString("111"));
                saikofu = new HihokenshashoSaikofu(reason, id);

                when(shikaku.get被保険者証再交付()).thenReturn(saikofu);
                sut = new Hihokensha(profile, shikaku);
            }

            @Test
            public void get被保険者証再交付_get有無区分は_コンストラクタ引数のIHihokenshaShikakuの_get被保険者証再交付_get有無区分と_同じ値を返す() {
                assertThat(sut.get被保険者証再交付().get有無区分(), is(kubun));
            }

            @Test
            public void get被保険者証再交付_getReasonは_コンストラクタ引数のIHihokenshaShikakuの_get被保険者証再交付_getReasonと_同じ値を返す() {
                assertThat(sut.get被保険者証再交付().getReason(), is(reason));
            }

            @Test
            public void get被保険者証再交付_getChohyoKofuRirekiIDは_コンストラクタ引数のIHihokenshaShikakuの_get被保険者証再交付_getChohyoKofuRirekiIDと_同じ値を返す() {
                assertThat(sut.get被保険者証再交付().getChohyoKofuRirekiID(), is(id));
            }
        }

        public static class Shutoku extends DbzTestBase {

            private Hihokensha sut;
            private ShikakuShutoku shikakuShutoku;

            @Before
            public void setUp() {
                FlexibleDate noticeDate = new FlexibleDate("20140326");
                FlexibleDate actionDate = new FlexibleDate("20140326");
                shikakuShutoku = new ShikakuShutoku(ShikakuShutokuJiyu.年齢到達, noticeDate, actionDate);

                when(shikaku.get資格取得()).thenReturn(shikakuShutoku);
                sut = new Hihokensha(profile, shikaku);
            }

            @Test
            public void get資格取得_getReasonは_コンストラクタ引数のIHihokenshaShikakuのget資格取得_getReasonと_同じ値を返す() {
                assertThat(sut.get資格取得().getReason(), is(shikakuShutoku.getReason()));
            }

            @Test
            public void get資格取得_getNoticeDateは_コンストラクタ引数のIHihokenshaShikakuのget資格取得_getNoticeDateと_同じ値を返す() {
                assertThat(sut.get資格取得().getNoticeDate(), is(shikakuShutoku.getNoticeDate()));
            }

            @Test
            public void get資格取得_getActionDateは_コンストラクタ引数のIHihokenshaShikakuのget資格取得_getActionDateと_同じ値を返す() {
                assertThat(sut.get資格取得().getActionDate(), is(shikakuShutoku.getActionDate()));
            }
        }

        public static class Shoshitsu extends DbzTestBase {

            private Hihokensha sut;
            private ShikakuSoshitsu shikakuSoshitsu;

            @Before
            public void setUp() {
                FlexibleDate noticeDate = new FlexibleDate("20140326");
                FlexibleDate actionDate = new FlexibleDate("20140326");
                shikakuSoshitsu = new ShikakuSoshitsu(ShikakuSoshitsuJiyu.転出, noticeDate, actionDate);

                when(shikaku.get資格喪失()).thenReturn(shikakuSoshitsu);
                sut = new Hihokensha(profile, shikaku);
            }

            @Test
            public void get資格喪失_getReasonは_コンストラクタ引数のIHihokenshaShikakuのget資格喪失_getReasonと_同じ値を返す() {
                assertThat(sut.get資格喪失().getReason(), is(shikakuSoshitsu.getReason()));
            }

            @Test
            public void get資格喪失_getNoticeDateは_コンストラクタ引数のIHihokenshaShikakuのget資格喪失_getNoticeDateと_同じ値を返す() {
                assertThat(sut.get資格喪失().getNoticeDate(), is(shikakuSoshitsu.getNoticeDate()));
            }

            @Test
            public void get資格喪失_getActionDateは_コンストラクタ引数のIHihokenshaShikakuのget資格喪失_getActionDateと_同じ値を返す() {
                assertThat(sut.get資格喪失().getActionDate(), is(shikakuSoshitsu.getActionDate()));
            }
        }

        public static class Henko extends DbzTestBase {

            private Hihokensha sut;
            private ShikakuHenko shikakuSoshitsu;

            @Before
            public void setUp() {
                FlexibleDate noticeDate = new FlexibleDate("20140326");
                FlexibleDate actionDate = new FlexibleDate("20140326");
                shikakuSoshitsu = new ShikakuHenko(ShikakuHenkoJiyu.その他, noticeDate, actionDate);

                when(shikaku.get資格変更()).thenReturn(shikakuSoshitsu);
                sut = new Hihokensha(profile, shikaku);
            }

            @Test
            public void get資格変更_getReasonは_コンストラクタ引数のIHihokenshaShikakuのget資格変更_getReasonと_同じ値を返す() {
                assertThat(sut.get資格変更().getReason(), is(shikakuSoshitsu.getReason()));
            }

            @Test
            public void get資格変更_getNoticeDateは_コンストラクタ引数のIHihokenshaShikakuのget資格変更_getNoticeDateと_同じ値を返す() {
                assertThat(sut.get資格変更().getNoticeDate(), is(shikakuSoshitsu.getNoticeDate()));
            }

            @Test
            public void get資格変更_getActionDateは_コンストラクタ引数のIHihokenshaShikakuのget資格変更_getActionDateと_同じ値を返す() {
                assertThat(sut.get資格変更().getActionDate(), is(shikakuSoshitsu.getActionDate()));
            }
        }

        public static class JutokuTekiyo extends DbzTestBase {

            private Hihokensha sut;
            private JushochitokureiTekiyo shikakuSoshitsu;

            @Before
            public void setUp() {
                FlexibleDate noticeDate = new FlexibleDate("20140326");
                FlexibleDate actionDate = new FlexibleDate("20140326");
                shikakuSoshitsu = new JushochitokureiTekiyo(JushochitokureiTekiyoJiyu.自特例適用, noticeDate, actionDate);

                when(shikaku.get住所地特例適用()).thenReturn(shikakuSoshitsu);
                sut = new Hihokensha(profile, shikaku);
            }

            @Test
            public void get住所地特例適用_getReasonは_コンストラクタ引数のIHihokenshaShikakuのget住所地特例適用_getReasonと_同じ値を返す() {
                assertThat(sut.get住所地特例適用().getReason(), is(shikakuSoshitsu.getReason()));
            }

            @Test
            public void get住所地特例適用_getNoticeDateは_コンストラクタ引数のIHihokenshaShikakuのget住所地特例適用_getNoticeDateと_同じ値を返す() {
                assertThat(sut.get住所地特例適用().getNoticeDate(), is(shikakuSoshitsu.getNoticeDate()));
            }

            @Test
            public void get住所地特例適用_getActionDateは_コンストラクタ引数のIHihokenshaShikakuのget住所地特例適用_getActionDateと_同じ値を返す() {
                assertThat(sut.get住所地特例適用().getActionDate(), is(shikakuSoshitsu.getActionDate()));
            }
        }

        public static class JutokuKaijo extends DbzTestBase {

            private Hihokensha sut;
            private JushochitokureiKaijo shikakuSoshitsu;

            @Before
            public void setUp() {
                FlexibleDate noticeDate = new FlexibleDate("20140326");
                FlexibleDate actionDate = new FlexibleDate("20140326");
                shikakuSoshitsu = new JushochitokureiKaijo(JushochitokureiKaijoJiyu.自特例転入, noticeDate, actionDate);

                when(shikaku.get住所地特例解除()).thenReturn(shikakuSoshitsu);
                sut = new Hihokensha(profile, shikaku);
            }

            @Test
            public void get住所地特例解除_getReasonは_コンストラクタ引数のIHihokenshaShikakuのget住所地特例解除_getReasonと_同じ値を返す() {
                assertThat(sut.get住所地特例解除().getReason(), is(shikakuSoshitsu.getReason()));
            }

            @Test
            public void get住所地特例解除_getNoticeDateは_コンストラクタ引数のIHihokenshaShikakuのget住所地特例解除_getNoticeDateと_同じ値を返す() {
                assertThat(sut.get住所地特例解除().getNoticeDate(), is(shikakuSoshitsu.getNoticeDate()));
            }

            @Test
            public void get住所地特例解除_getActionDateは_コンストラクタ引数のIHihokenshaShikakuのget住所地特例解除_getActionDateと_同じ値を返す() {
                assertThat(sut.get住所地特例解除().getActionDate(), is(shikakuSoshitsu.getActionDate()));
            }
        }
    }

    public static class Getter_IKojin extends DbzTestBase {

        private IKojin profile;
        private IHihokenshaShikaku shikaku;
        private Hihokensha sut;

        @Before
        public void setUp() {
            profile = mock(IKojin.class);
            shikaku = mock(IHihokenshaShikaku.class);
            sut = new Hihokensha(profile, shikaku);
        }

        @Test
        public void get氏名は_コンストラクタ引数のIKojinのget氏名と_同じ値を返す() {
            IName shimei = mock(IName.class);
            when(this.profile.get名称()).thenReturn(shimei);
            assertThat(sut.get氏名(), is(shimei));
        }

        @Test
        public void get性別は_コンストラクタ引数のIKojinのget性別と_同じ値を返す() {
            Gender gender = Gender.MALE;
            when(this.profile.get性別()).thenReturn(gender);
            assertThat(sut.get性別(), is(gender));
        }

        @Test
        public void get生年月日は_コンストラクタ引数のIKojinのget生年月日と_同じ値を返す() {
            IDateOfBirth birthDay = mock(IDateOfBirth.class);
            when(this.profile.get生年月日()).thenReturn(birthDay);
            assertThat(sut.get生年月日(), is(birthDay));
        }

        @Test
        public void get住所は_コンストラクタ引数のIKojinのget住所と_同じ値を返す() {
            IJusho adress = mock(IJusho.class);
            when(this.profile.get住所()).thenReturn(adress);
            assertThat(sut.get住所(), is(adress));
        }

        @Test
        public void get世帯コードは_コンストラクタ引数のIKojinのget世帯コードと_同じ値を返す() {
            SetaiCode setaiCode = new SetaiCode("11111");
            when(this.profile.get世帯コード()).thenReturn(setaiCode);
            assertThat(sut.get世帯コード(), is(setaiCode));
        }

        @Test
        public void get個人番号は_コンストラクタ引数のIkojinのget個人番号と_同じ値を返す() {
            RString kojinNo = new RString("012345678901");
            when(this.profile.get個人番号()).thenReturn(new KojinNo(kojinNo));
            assertThat(sut.get個人番号(), is(kojinNo));
        }

        @Test
        public void get住民種別は_コンストラクタ引数のIkojinのget住民種別と_同じ値を返す() {
            JuminShubetsu juminShubetsu = JuminShubetsu.住登外個人_外国人;
            when(this.profile.get住民種別()).thenReturn(juminShubetsu);
            assertThat(sut.get住民種別(), is(juminShubetsu));
        }
    }
}
