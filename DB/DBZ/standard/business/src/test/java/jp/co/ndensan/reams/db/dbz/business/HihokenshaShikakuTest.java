/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business;

import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.JushochitokureiKaijoJiyu;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.KoikinaiJushochitokureishaKubun;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.JushochitokureiTekiyoJiyu;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.ShikakuHenkoJiyu;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.ShikakuShutokuJiyu;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.ShikakuSoshitsuJiyu;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.db.dbx.business.IKaigoShikaku;
//クラスが削除されてしまっているため、このクラスをどうするか決める必要がある。
//import jp.co.ndensan.reams.ur.urz.business.IShikakuShutokuJiyu;
//import jp.co.ndensan.reams.ur.urz.business.IShikakuSoshitsuJiyu;
import jp.co.ndensan.reams.db.dbx.business.KaigoShikakuFactory;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.HokenShubetsu;
import jp.co.ndensan.reams.db.dbx.definition.enumeratedtype.JushochiTokureishaKubun;
import jp.co.ndensan.reams.db.dbx.definition.enumeratedtype.ShikakuHihokenshaKubun;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
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

    private static final LasdecCode lasdecCode = new LasdecCode("123456");
    private static final ShikibetsuCode shikibetsuCode = new ShikibetsuCode("3327");
    private static final YMDHMS shoriTimestamp = new YMDHMS("20140802153700");
    private static final ShoKisaiHokenshaNo shoKisaiHokenshaNo = new ShoKisaiHokenshaNo(new RString("123456"));
    private static final HihokenshaNo hihokenshaNo = new HihokenshaNo(new RString("1234567890"));
    private static final HihokenshaKubun hihokenshaKubun = new HihokenshaKubun(new Code("1"), new RString("第1号"));
    private static final RDate ichigoGaitoDate = new RDate("20140403");
    private static final FlexibleDate ichigoDate = new FlexibleDate(ichigoGaitoDate.toString());

    @RunWith(Enclosed.class)
    public static class Builder extends DbzTestBase {

        @RunWith(Enclosed.class)
        public static class IKaigoShikakuを用いないConstructor {

            public static class NullCheck {

                @Test(expected = NullPointerException.class)
                public void Builderのコンストラクタは_引数の_市町村コード_がnullのとき_NullPointerExceptionをスローする() {
                    HihokenshaShikaku.Builder sut = new HihokenshaShikaku.Builder(
                            null, shikibetsuCode, shoriTimestamp, hihokenshaKubun,
                            ichigoDate, ShikakuShutoku.NOTHING
                    );
                }

                @Test(expected = NullPointerException.class)
                public void Builderのコンストラクタは_引数の_識別コード_がnullのとき_NullPointerExceptionをスローする() {
                    HihokenshaShikaku.Builder sut = new HihokenshaShikaku.Builder(
                            lasdecCode, null, shoriTimestamp, hihokenshaKubun,
                            ichigoDate, ShikakuShutoku.NOTHING);
                }

                @Test(expected = NullPointerException.class)
                public void Builderのコンストラクタは_引数の_処理日時_がnullのとき_NullPointerExceptionをスローする() {
                    HihokenshaShikaku.Builder sut = new HihokenshaShikaku.Builder(
                            lasdecCode, shikibetsuCode, null, hihokenshaKubun,
                            ichigoDate, ShikakuShutoku.NOTHING
                    );
                }

                @Test(expected = NullPointerException.class)
                public void Builderのコンストラクタは_引数の_被保険者台区分_がnullのとき_NullPointerExceptionをスローする() {
                    HihokenshaShikaku.Builder sut = new HihokenshaShikaku.Builder(
                            lasdecCode, shikibetsuCode, shoriTimestamp, null,
                            ichigoDate, ShikakuShutoku.NOTHING
                    );
                }

                @Test(expected = NullPointerException.class)
                public void Builderのコンストラクタは_引数の_第1号年齢到達日_がnullのとき_NullPointerExceptionをスローする() {
                    HihokenshaShikaku.Builder sut = new HihokenshaShikaku.Builder(
                            lasdecCode, shikibetsuCode, shoriTimestamp, hihokenshaKubun,
                            null, ShikakuShutoku.NOTHING
                    );
                }

                @Test(expected = NullPointerException.class)
                public void Builderのコンストラクタは_引数の_資格取得_がnullのとき_NullPointerExceptionをスローする() {
                    HihokenshaShikaku.Builder sut = new HihokenshaShikaku.Builder(
                            lasdecCode, shikibetsuCode, shoriTimestamp, hihokenshaKubun,
                            ichigoDate, null);
                }
            }

            @RunWith(Enclosed.class)
            public static class publicMethods extends DbzTestBase {

                private static final ShikakuShutoku shikakuShutokuFirst;

                static {
                    shikakuShutokuFirst = new ShikakuShutoku(ShikakuShutokuJiyu.年齢到達, ichigoDate, ichigoDate);
                }

                public static class hihokenshaNo extends DbzTestBase {

                    private HihokenshaShikaku shikaku;
                    private HihokenshaShikaku.Builder sut;

                    @Before
                    public void setUp() {
                        sut = new HihokenshaShikaku.Builder(lasdecCode,
                                shikibetsuCode, shoriTimestamp, hihokenshaKubun, ichigoDate, shikakuShutokuFirst);
                        shikaku = sut.hihokenshaNo(hihokenshaNo).build();
                    }

                    @Test
                    public void hihokenshaNoに渡したKaigoHihokenshaNoは_生成されたHihokenshaShikakuの_get被保険者番号と一致する() {
                        assertThat(shikaku.get被保険者番号(), is(hihokenshaNo));
                    }

                    public void hihokenshaNoに渡したKaigoHihokenshaNoは_生成されたHihokenshaShikakuの_toKaigoShikaku$get被保険者番号と一致する() {
                        assertThat(shikaku.toKaigoShikaku().get被保険者番号(), is(hihokenshaNo.value()));
                    }
                }

                public static class shikakuShutoku extends DbzTestBase {

                    private HihokenshaShikaku shikaku;
                    private HihokenshaShikaku.Builder sut;
                    private final FlexibleDate 資格取得届出年月日 = new FlexibleDate("20140404");
                    private final FlexibleDate 資格取得年月日 = new FlexibleDate("20140404");
                    private final ShikakuShutokuJiyu 資格取得事由 = ShikakuShutokuJiyu.転入;
                    private final ShikakuShutoku 資格取得 = new ShikakuShutoku(資格取得事由, 資格取得届出年月日, 資格取得年月日);

                    @Before
                    public void setUp() {
                        sut = new HihokenshaShikaku.Builder(lasdecCode,
                                shikibetsuCode, shoriTimestamp, hihokenshaKubun, ichigoDate, shikakuShutokuFirst);
                        shikaku = sut.shikakuShutoku(資格取得).build();
                    }

                    @Test
                    public void shikakuShutokuに渡したShikakuShutoku$getReasonは_生成されたHihokenshaShikakuの_get資格取得$getReasonと一致する() {
                        assertThat(shikaku.get資格取得().getReason(), is(資格取得.getReason()));
                    }

//                  shikaku.toKaigoShikaku().get資格取得事由()がなくなっているため、テストをコメントアウト
//                    @Test
//                    public void shikakuShutokuに渡したShikakuShutoku$getReasonは_生成されたHihokenshaShikakuの_toKaigoShikaku$get資格取得事由$getCodeから導かれる値と一致する() {
//                        ShikakuShutokuJiyu reason = ShikakuShutokuJiyu.toValue(shikaku.toKaigoShikaku().get資格取得事由().getCode().value());
//                        assertThat(reason, is(資格取得事由));
//                    }
                    @Test
                    public void shikakuShutokuに渡したShikakuShutoku$getActionDateは_生成されたHihokenshaShikakuの_get資格取得$getActionDateと一致する() {
                        assertThat(shikaku.get資格取得().getActionDate(), is(資格取得.getActionDate()));
                    }

//                  shikaku.toKaigoShikaku().get資格取得年月日()がなくなっているため、テストをコメントアウト
//                    @Test
//                    public void shikakuShutokuに渡したShikakuShutoku$getActionDateは_生成されたHihokenshaShikakuの_toKaigoShikaku$get資格取得年月日と日付が一致する() {
//                        FlexibleDate shikakuShutokuDate = new FlexibleDate(shikaku.toKaigoShikaku().get資格取得年月日().toString());
//                        assertThat(shikakuShutokuDate, is(資格取得年月日));
//                    }
                    @Test
                    public void shikakuShutokuに渡したShikakuShutoku$getNoticeDateは_生成されたHihokenshaShikakuの_get資格取得$getNoticeDateと一致する() {
                        assertThat(shikaku.get資格取得().getNoticeDate(), is(資格取得.getNoticeDate()));
                    }

//                  shikaku.toKaigoShikaku()..get資格取得届出年月日()がなくなっているため、テストをコメントアウト
//                    @Test
//                    public void shikakuShutokuに渡したShikakuShutoku$getNoticeDateは_生成されたHihokenshaShikakuの_toKaigoShikaku$get資格取得届出年月日と日付が一致する() {
//                        FlexibleDate shikakuShutokuTodokedeDate = new FlexibleDate(shikaku.toKaigoShikaku().get資格取得届出年月日().toString());
//                        assertThat(shikakuShutokuTodokedeDate, is(資格取得届出年月日));
//                    }
                }

                public static class shikakuSoshitsu extends DbzTestBase {

                    private HihokenshaShikaku shikaku;
                    private HihokenshaShikaku.Builder sut;
                    private final FlexibleDate 資格喪失届出年月日 = new FlexibleDate("20140404");
                    private final FlexibleDate 資格喪失年月日 = new FlexibleDate("20140404");
                    private final ShikakuSoshitsuJiyu 資格喪失事由 = ShikakuSoshitsuJiyu.転出;
                    private final ShikakuSoshitsu 資格喪失 = new ShikakuSoshitsu(資格喪失事由, 資格喪失届出年月日, 資格喪失年月日);

                    @Before
                    public void setUp() {
                        sut = new HihokenshaShikaku.Builder(lasdecCode,
                                shikibetsuCode, shoriTimestamp, hihokenshaKubun, ichigoDate, shikakuShutokuFirst);
                        shikaku = sut.shikakuSoshitsu(資格喪失).build();
                    }

                    @Test
                    public void shikakuSoshitsuに渡したShikakuSoshitsu$getReasonは_生成されたHihokenshaShikakuの_get資格喪失$getReasonと一致する() {
                        assertThat(shikaku.get資格喪失().getReason(), is(資格喪失.getReason()));
                    }

//                  shikaku.toKaigoShikaku().get資格喪失事由()がなくなっているため、テストをコメントアウト
//                    @Test
//                    public void shikakuSoshitsuに渡したShikakuSoshitsu$getReasonは_生成されたHihokenshaShikakuの_toKaigoShikaku$get資格喪失事由$getCodeから導かれる値と一致する() {
//                        ShikakuSoshitsuJiyu reason = ShikakuSoshitsuJiyu.toValue(shikaku.toKaigoShikaku().get資格喪失事由().getCode().value());
//                        assertThat(reason, is(資格喪失事由));
//                    }
                    @Test
                    public void shikakuSoshitsuに渡したShikakuSoshitsu$getActionDateは_生成されたHihokenshaShikakuの_get資格喪失$getActionDateと一致する() {
                        assertThat(shikaku.get資格喪失().getActionDate(), is(資格喪失.getActionDate()));
                    }

//                  shikaku.toKaigoShikaku().get資格喪失年月日()がなくなっているため、テストをコメントアウト
//                    @Test
//                    public void shikakuSoshitsuに渡したshikakuSoshitsu$getActionDateは_生成されたHihokenshaShikakuの_toKaigoShikaku$get資格喪失年月日と日付が一致する() {
//                        FlexibleDate shikakuSoshitsuDate = new FlexibleDate(shikaku.toKaigoShikaku().get資格喪失年月日().toString());
//                        assertThat(shikakuSoshitsuDate, is(資格喪失年月日));
//                    }
                    @Test
                    public void shikakuSoshitsuに渡したShikakuSoshitsu$getNoticeDateは_生成されたHihokenshaShikakuの_get資格喪失$getNoticeDateと一致する() {
                        assertThat(shikaku.get資格喪失().getNoticeDate(), is(資格喪失.getNoticeDate()));
                    }

//                  shikaku.toKaigoShikaku().get資格喪失届出年月日()がなくなっているため、テストをコメントアウト
//                    @Test
//                    public void shikakuSoshitsuに渡したshikakuSoshitsu$getNoticeDateは_生成されたHihokenshaShikakuの_toKaigoShikaku$get資格喪失届出年月日と日付が一致する() {
//                        FlexibleDate shikakuSoshitsuTodokedeDate = new FlexibleDate(shikaku.toKaigoShikaku().get資格喪失届出年月日().toString());
//                        assertThat(shikakuSoshitsuTodokedeDate, is(資格喪失届出年月日));
//                    }
                }

                public static class shikakuHenko extends DbzTestBase {

                    private HihokenshaShikaku shikaku;
                    private HihokenshaShikaku.Builder sut;
                    private final FlexibleDate 資格変更届出年月日 = new FlexibleDate("20140404");
                    private final FlexibleDate 資格変更年月日 = new FlexibleDate("20140404");
                    private final ShikakuHenkoJiyu 資格変更事由 = ShikakuHenkoJiyu.その他;
                    private final ShikakuHenko 資格変更 = new ShikakuHenko(資格変更事由, 資格変更届出年月日, 資格変更年月日);

                    @Before
                    public void setUp() {
                        sut = new HihokenshaShikaku.Builder(lasdecCode,
                                shikibetsuCode, shoriTimestamp, hihokenshaKubun, ichigoDate, shikakuShutokuFirst);
                        shikaku = sut.shikakuHenko(資格変更).build();
                    }

                    @Test
                    public void shikakuHenkoに渡したShikakuHenkoJiyu$getReasonは_生成されたHihokenshaShikakuの_get資格変更$getReasonと一致する() {
                        assertThat(shikaku.get資格変更().getReason(), is(資格変更.getReason()));
                    }

                    @Test
                    public void shikakuHenkoに渡したShikakuHenkoJiyu$getActionDateは_生成されたHihokenshaShikakuの_get資格変更$getActionDateと一致する() {
                        assertThat(shikaku.get資格変更().getActionDate(), is(資格変更.getActionDate()));
                    }

                    @Test
                    public void shikakuHenkoに渡したShikakuHenkoJiyu$getNoticeDateは_生成されたHihokenshaShikakuの_get資格変更$getNoticeDateと一致する() {
                        assertThat(shikaku.get資格変更().getNoticeDate(), is(資格変更.getNoticeDate()));
                    }
                }

                public static class jushochitokureiTekiyo extends DbzTestBase {

                    private HihokenshaShikaku shikaku;
                    private HihokenshaShikaku.Builder sut;
                    private final FlexibleDate 住所地特例適用届出年月日 = new FlexibleDate("20140404");
                    private final FlexibleDate 住所地特例適用年月日 = new FlexibleDate("20140404");
                    private final JushochitokureiTekiyoJiyu 住所地特例適用事由 = JushochitokureiTekiyoJiyu.その他;
                    private final JushochitokureiTekiyo 住所地特例適用 = new JushochitokureiTekiyo(住所地特例適用事由, 住所地特例適用届出年月日, 住所地特例適用年月日);

                    @Before
                    public void setUp() {
                        sut = new HihokenshaShikaku.Builder(lasdecCode,
                                shikibetsuCode, shoriTimestamp, hihokenshaKubun, ichigoDate, shikakuShutokuFirst);
                        shikaku = sut.jushochitokureiTekiyo(住所地特例適用).build();
                    }

                    @Test
                    public void jushochitokureiTekiyoに渡したJushochitokureiTekiyo$getReasonは_生成されたHihokenshaShikakuの_get住所地特例適用$getReasonと一致する() {
                        assertThat(shikaku.get住所地特例適用().getReason(), is(住所地特例適用.getReason()));
                    }

                    @Test
                    public void jushochitokureiTekiyoに渡したJushochitokureiTekiyo$getActionDateは_生成されたHihokenshaShikakuの_get住所地特例適用$getActionDateと一致する() {
                        assertThat(shikaku.get住所地特例適用().getActionDate(), is(住所地特例適用.getActionDate()));
                    }

                    @Test
                    public void jushochitokureiTekiyoに渡したJushochitokureiTekiyo$getNoticeDateは_生成されたHihokenshaShikakuの_get住所地特例適用$getNoticeDateと一致する() {
                        assertThat(shikaku.get住所地特例適用().getNoticeDate(), is(住所地特例適用.getNoticeDate()));
                    }
                }

                public static class jushochitokureiKaijo extends DbzTestBase {

                    private HihokenshaShikaku shikaku;
                    private HihokenshaShikaku.Builder sut;
                    private final FlexibleDate 住所地特例解除届出年月日 = new FlexibleDate("20140404");
                    private final FlexibleDate 住所地特例解除年月日 = new FlexibleDate("20140404");
                    private final JushochitokureiKaijoJiyu 住所地特例解除事由 = JushochitokureiKaijoJiyu.自特例転入;
                    private final JushochitokureiKaijo 住所地特例解除 = new JushochitokureiKaijo(住所地特例解除事由, 住所地特例解除届出年月日, 住所地特例解除年月日);

                    @Before
                    public void setUp() {
                        sut = new HihokenshaShikaku.Builder(lasdecCode,
                                shikibetsuCode, shoriTimestamp, hihokenshaKubun, ichigoDate, shikakuShutokuFirst);
                        shikaku = sut.jushochitokureiKaijo(住所地特例解除).build();
                    }

                    @Test
                    public void jushochitokureiKaijoに渡したJushochitokureiKaijo$getReasonは_生成されたHihokenshaShikakuの_get住所地特例解除$getReasonと一致する() {
                        assertThat(shikaku.get住所地特例解除().getReason(), is(住所地特例解除.getReason()));
                    }

                    @Test
                    public void jushochitokureiKaijoに渡したJushochitokureiKaijo$getActionDateは_生成されたHihokenshaShikakuの_get住所地特例解除$getActionDateと一致する() {
                        assertThat(shikaku.get住所地特例解除().getActionDate(), is(住所地特例解除.getActionDate()));
                    }

                    @Test
                    public void jushochitokureiKaijoに渡したJushochitokureiKaijo$getNoticeDateは_生成されたHihokenshaShikakuの_get住所地特例解除$getNoticeDateと一致する() {
                        assertThat(shikaku.get住所地特例解除().getNoticeDate(), is(住所地特例解除.getNoticeDate()));
                    }
                }

                public static class jushochiTokureishaKubun extends DbzTestBase {

                    private HihokenshaShikaku shikaku;
                    private HihokenshaShikaku.Builder sut;
                    private JushochiTokureishaKubun jutokuKubun;

                    @Before
                    public void setUp() {
                        sut = new HihokenshaShikaku.Builder(lasdecCode,
                                shikibetsuCode, shoriTimestamp, hihokenshaKubun, ichigoDate, shikakuShutokuFirst);
                        jutokuKubun = JushochiTokureishaKubun.住所地特例者;
                        shikaku = sut.jushochiTokureishaKubun(jutokuKubun).build();
                    }

                    @Test
                    public void jushochiTokureishaKubunに渡したJushochiTokureishaKubunは_生成されたHihokenshaShikakuの_get住所地特例者区分と一致する() {
                        assertThat(shikaku.get住所地特例者区分(), is(jutokuKubun));
                    }
                }

                public static class koikinaiJutokushaKubun extends DbzTestBase {

                    private HihokenshaShikaku shikaku;
                    private HihokenshaShikaku.Builder sut;
                    private KoikinaiJushochitokureishaKubun koikiJutokuKubun;

                    @Before
                    public void setUp() {
                        sut = new HihokenshaShikaku.Builder(lasdecCode,
                                shikibetsuCode, shoriTimestamp, hihokenshaKubun, ichigoDate, shikakuShutokuFirst);
                        koikiJutokuKubun = KoikinaiJushochitokureishaKubun.広域内住所地特例者;
                        shikaku = sut.koikinaiJushochiTokureishaKubun(koikiJutokuKubun).build();
                    }

                    @Test
                    public void koikinaiJutokushaKubunに渡したKoikinaiJushochitokureishaKubunは_生成されたHihokenshaShikakuの_get広域内住所地特例者区分と一致する() {
                        assertThat(shikaku.get広域内住所地特例者区分(), is(koikiJutokuKubun));
                    }
                }

                public static class koikiJutokuSochimotoLasdecCode extends DbzTestBase {

                    private HihokenshaShikaku shikaku;
                    private HihokenshaShikaku.Builder sut;
                    private ShoKisaiHokenshaNo code;

                    @Before
                    public void setUp() {
                        sut = new HihokenshaShikaku.Builder(lasdecCode,
                                shikibetsuCode, shoriTimestamp, hihokenshaKubun, ichigoDate, shikakuShutokuFirst);
                        code = new ShoKisaiHokenshaNo(new RString("666666"));
                        shikaku = sut.koikinaiJutokuSochimotoLasdecCode(code).build();
                    }

                    @Test
                    public void koikiJutokuSochimotoLasdecCodeに渡したLasdecCodeは_生成されたHihokenshaShikakuの_get広域内住所地特例措置元市町村コードと一致する() {
                        assertThat(shikaku.get広域内住所地特例措置元保険者番号(), is(code));
                    }
                }

                public static class oldLasdecCode extends DbzTestBase {

                    private HihokenshaShikaku shikaku;
                    private HihokenshaShikaku.Builder sut;
                    private LasdecCode code;

                    @Before
                    public void setUp() {
                        sut = new HihokenshaShikaku.Builder(lasdecCode,
                                shikibetsuCode, shoriTimestamp, hihokenshaKubun, ichigoDate, shikakuShutokuFirst);
                        code = new LasdecCode("666666");
                        shikaku = sut.oldLasdecCode(code).build();
                    }

                    @Test
                    public void oldLasdecCodeに渡したLasdecCodeは_生成されたHihokenshaShikakuの_get旧市町村コードと一致する() {
                        assertThat(shikaku.get旧市町村コード(), is(code));
                    }
                }
            }
        }

        @RunWith(Enclosed.class)
        public static class IKaigoShikakuを用いるConstructor {

            public static class NullCheck {

                private IKaigoShikaku kaigoShikaku;

                @Before
                public void setUp() {
                    kaigoShikaku = mock(IKaigoShikaku.class);
                    when(kaigoShikaku.get一号該当日()).thenReturn(ichigoGaitoDate);
                }

                @Test(expected = NullPointerException.class)
                public void BuilderのIKaigoShikakuを用いるコンストラクタは_引数の_介護資格_がnullのとき_NullPointerExceptionをスローする() {
                    HihokenshaShikaku.Builder sut = new HihokenshaShikaku.Builder(
                            null, lasdecCode, shikibetsuCode, shoriTimestamp, hihokenshaKubun
                    );
                }

                @Test(expected = NullPointerException.class)
                public void BuilderのIKaigoShikakuを用いるコンストラクタは_引数の_市町村コード_がnullのとき_NullPointerExceptionをスローする() {
                    HihokenshaShikaku.Builder sut = new HihokenshaShikaku.Builder(
                            kaigoShikaku, null, shikibetsuCode, shoriTimestamp, hihokenshaKubun);
                }

                @Test(expected = NullPointerException.class)
                public void BuilderのIKaigoShikakuを用いるコンストラクタは_引数の_識別コード_がnullのとき_NullPointerExceptionをスローする() {
                    HihokenshaShikaku.Builder sut = new HihokenshaShikaku.Builder(
                            kaigoShikaku, lasdecCode, null, shoriTimestamp, hihokenshaKubun);
                }

                @Test(expected = NullPointerException.class)
                public void BuilderのIKaigoShikakuを用いるコンストラクタは_引数の_処理日時_がnullのとき_NullPointerExceptionをスローする() {
                    HihokenshaShikaku.Builder sut = new HihokenshaShikaku.Builder(
                            kaigoShikaku, lasdecCode, shikibetsuCode, null, hihokenshaKubun);
                }

                @Test(expected = NullPointerException.class)
                public void BuilderのIKaigoShikakuを用いるコンストラクタは_引数の_被保険者区分_がnullのとき_NullPointerExceptionをスローする() {
                    HihokenshaShikaku.Builder sut = new HihokenshaShikaku.Builder(
                            kaigoShikaku, lasdecCode, shikibetsuCode, shoriTimestamp, null);
                }
            }

            @RunWith(Enclosed.class)
            public static class publicMethods extends DbzTestBase {

                private static final IKaigoShikaku kaigoShikaku;
                private static final RDate 資格取得届出Date = new RDate("20140402");
                private static final RDate 資格取得Date = new RDate("20140403");
//                private static final IShikakuShutokuJiyu 資格取得事由 = createShikakuShutokuJiyu(ShikakuShutokuJiyu.転入);
                private static final RDate 資格喪失届出Date = new RDate("20140404");
                private static final RDate 資格喪失Date = new RDate("20140405");
//                private static final IShikakuSoshitsuJiyu 資格喪失事由 = createShikakuSoshitsuJiyu(ShikakuSoshitsuJiyu.転出);

                static {
                    kaigoShikaku = KaigoShikakuFactory.createInstance(
                            shikibetsuCode, HokenShubetsu.介護保険,
                            //                            資格取得届出Date, 資格取得Date, 資格取得事由,
                            //                            資格喪失届出Date, 資格喪失Date, 資格喪失事由,
                            資格取得届出Date, 資格取得Date, null,
                            資格喪失届出Date, 資格喪失Date, null,
                            hihokenshaNo.value(), shoKisaiHokenshaNo.getColumnValue(),
                            ichigoGaitoDate, ShikakuHihokenshaKubun.toValue(hihokenshaKubun.getCode().getColumnValue()),
                            JushochiTokureishaKubun.通常資格者);
                }

                public static class KaigoShikaku extends DbzTestBase {

                    private HihokenshaShikaku.Builder sut;

                    @Before
                    public void setUp() {
                        sut = new HihokenshaShikaku.Builder(kaigoShikaku, lasdecCode, shikibetsuCode,
                                shoriTimestamp, hihokenshaKubun);
                    }

                    @Test
                    public void IKaigoShikakuの持つ被保険者番号と_Builderによって生成されたHihokenshaShikakuの_get被保険者番号は一致する() {
                        HihokenshaShikaku shikaku = sut.build();
                        assertThat(shikaku.get被保険者番号(), is(hihokenshaNo));
                    }

                    @Test
                    public void IKaigoShikakuの持つ被保険者区分と_Builderによって生成されたHihokenshaShikakuの_get被保険者区分は一致する() {
                        HihokenshaShikaku shikaku = sut.build();
                        assertThat(shikaku.get被保険者区分(), is(hihokenshaKubun));
                    }

                    @Test
                    public void IKaigoShikakuの持つ第一号年齢到達日と_Builderによって生成されたHihokenshaShikakuの_get第一号年齢到達日は一致する() {
                        HihokenshaShikaku shikaku = sut.build();
                        assertThat(shikaku.get第一号年齢到達日(), is(new FlexibleDate(ichigoGaitoDate.toString())));
                    }

                    @Test
                    public void IKaigoShikakuのもつ資格取得年月日は_Builderによって生成されたHihokenshaShikakuの_get資格取得$getActionDateと一致する() {
                        HihokenshaShikaku shikaku = sut.build();
                        assertThat(shikaku.get資格取得().getActionDate(), is(new FlexibleDate(資格取得Date.toString())));
                    }

                    @Test
                    public void IKaigoShikakuのもつ資格取得届出年月日は_Builderによって生成されたHihokenshaShikakuの_get資格取得$getNoticeDateと一致する() {
                        HihokenshaShikaku shikaku = sut.build();
                        assertThat(shikaku.get資格取得().getNoticeDate(), is(new FlexibleDate(資格取得届出Date.toString())));
                    }

//                  kaigoShikaku.get資格取得事由()がなくなっているため、テストをコメントアウト
//                    @Test
//                    public void IKaigoShikakuのもつ資格取得事由は_Builderによって生成されたHihokenshaShikakuの_get資格取得$getReasonと一致する() {
//                        HihokenshaShikaku shikaku = sut.build();
//                        ShikakuShutokuJiyu shikakuShutokuJiyu = ShikakuShutokuJiyu.toValue(kaigoShikaku.get資格取得事由().getCode().value());
//                        assertThat(shikaku.get資格取得().getReason(), is(shikakuShutokuJiyu));
//                    }
                    @Test
                    public void IKaigoShikakuのもつ資格喪失年月日は_Builderによって生成されたHihokenshaShikakuの_get資格喪失$getActionDateと一致する() {
                        HihokenshaShikaku shikaku = sut.build();
                        assertThat(shikaku.get資格喪失().getActionDate(), is(new FlexibleDate(資格喪失Date.toDateString())));
                    }

                    @Test
                    public void IKaigoShikakuのもつ資格喪失届出年月日は_Builderによって生成されたHihokenshaShikakuの_get資格喪失$getNoticeDateと一致する() {
                        HihokenshaShikaku shikaku = sut.build();
                        assertThat(shikaku.get資格喪失().getNoticeDate(), is(new FlexibleDate(資格喪失届出Date.toDateString())));
                    }

//                  kaigoShikaku.get資格喪失事由()がなくなっているため、テストをコメントアウト
//                    @Test
//                    public void IKaigoShikakuのもつ資格喪失事由は_Builderによって生成されたHihokenshaShikakuの_get資格喪失$getReasonと一致する() {
//                        HihokenshaShikaku shikaku = sut.build();
//                        ShikakuSoshitsuJiyu shikakuHenkoJiyu = ShikakuSoshitsuJiyu.toValue(kaigoShikaku.get資格喪失事由().getCode().value());
//                        assertThat(shikaku.get資格喪失().getReason(), is(shikakuHenkoJiyu));
//                    }
                }
            }
        }

        @RunWith(Enclosed.class)
        public static class IHihokenshaShikakuを用いるConstructor {

            public static class NullCheck {

                @Test(expected = NullPointerException.class)
                public void Builderのコンストラクタは_引数の_被保険者資格_がnullのとき_NullPointerExceptionをスローする() {
                    HihokenshaShikaku.Builder sut = new HihokenshaShikaku.Builder(null);
                }
            }

            public static class PublicMethods {

                private HihokenshaShikaku shikaku;
                private HihokenshaShikaku.Builder sut;
                private HihokenshaShikaku created;

                @Before
                public void setUp() {
                    shikaku = new HihokenshaShikaku.Builder(lasdecCode, shikibetsuCode,
                            shoriTimestamp, hihokenshaKubun, ichigoDate, ShikakuShutoku.NOTHING).build();
                    sut = new HihokenshaShikaku.Builder(shikaku);
                    created = sut.build();
                }

                @Test
                public void 引数のHihokenshaShikakuのget識別コードと_生成後のHihokenshaShikakuのget識別コードは一致する() {
                    assertThat(created.get識別コード(), is(shikaku.get識別コード()));
                }

                @Test
                public void 引数のHihokenshaShikakuのget被保険者台帳登録日時と_生成後のHihokenshaShikakuのget被保険者台帳登録日時は一致する() {
                    assertThat(created.get処理日時(), is(shikaku.get処理日時()));
                }

                @Test
                public void 引数のHihokenshaShikakuのget被保険者番号と_生成後のHihokenshaShikakuのget被保険者番号は一致する() {
                    assertThat(created.get被保険者番号(), is(shikaku.get被保険者番号()));
                }

                @Test
                public void 引数のHihokenshaShikakuのget第一号年齢到達日と_生成後のHihokenshaShikakuのget第一号年齢到達日は一致する() {
                    assertThat(created.get第一号年齢到達日(), is(shikaku.get第一号年齢到達日()));
                }

                @Test
                public void 引数のHihokenshaShikakuのget被保険者区分と_生成後のHihokenshaShikakuのget被保険者区分は一致する() {
                    assertThat(created.get被保険者区分(), is(shikaku.get被保険者区分()));
                }

                @Test
                public void 引数のHihokenshaShikakuのhas被保険者資格Atと_生成後のHihokenshaShikakuのhas被保険者資格Atは一致する() {
                    assertThat(created.has被保険者資格At(ichigoGaitoDate), is(shikaku.has被保険者資格At(ichigoGaitoDate)));
                }

                @Test
                public void 引数のHihokenshaShikakuのget資格取得と_生成後のHihokenshaShikakuのget資格取得は一致する() {
                    assertThat(created.get資格取得(), is(shikaku.get資格取得()));
                }

                @Test
                public void 引数のHihokenshaShikakuのget資格喪失と_生成後のHihokenshaShikakuのget資格喪失は一致する() {
                    assertThat(created.get資格喪失(), is(shikaku.get資格喪失()));
                }

                @Test
                public void 引数のHihokenshaShikakuのget資格変更と_生成後のHihokenshaShikakuのget資格変更は一致する() {
                    assertThat(created.get資格変更(), is(shikaku.get資格変更()));
                }

                public void 引数のHihokenshaShikakuのget住所地特例適用と_生成後のHihokenshaShikakuのget住所地特例適用は一致する() {
                    assertThat(created.get住所地特例適用(), is(shikaku.get住所地特例適用()));
                }

                @Test
                public void 引数のHihokenshaShikakuのget住所地特例解除と_生成後のHihokenshaShikakuのget住所地特例解除は一致する() {
                    assertThat(created.get住所地特例解除(), is(shikaku.get住所地特例解除()));
                }

                @Test
                public void 引数のHihokenshaShikakuのget住所地特例者区分と_生成後のHihokenshaShikakuのget住所地特例者区分は一致する() {
                    assertThat(created.get住所地特例者区分(), is(shikaku.get住所地特例者区分()));
                }

                @Test
                public void 引数のHihokenshaShikakuのget広域内住所地特例者区分と_生成後のHihokenshaShikakuのget広域内住所地特例者区分は一致する() {
                    assertThat(created.get広域内住所地特例者区分(), is(shikaku.get広域内住所地特例者区分()));
                }

                @Test
                public void 引数のHihokenshaShikakuのget広域内住所地特例措置元市町村コードと_生成後のHihokenshaShikakuのget広域内住所地特例措置元市町村コードは一致する() {
                    assertThat(created.get広域内住所地特例措置元保険者番号(), is(shikaku.get広域内住所地特例措置元保険者番号()));
                }

                @Test
                public void 引数のHihokenshaShikakuのget旧市町村コードと_生成後のHihokenshaShikakuのget旧市町村コードは一致する() {
                    assertThat(created.get旧市町村コード(), is(shikaku.get旧市町村コード()));
                }

                @Test
                public void 引数のHihokenshaShikakuのget被保険者証再交付と_生成後のHihokenshaShikakuのget被保険者証再交付は一致する() {
                    assertThat(created.get被保険者証再交付(), is(shikaku.get被保険者証再交付()));
                }
            }
        }
    }
//クラスが削除されてしまっているため、このクラスをどうするか決める必要がある。
//    private static IShikakuShutokuJiyu createShikakuShutokuJiyu(final ShikakuShutokuJiyu reason) {
//        return new IShikakuShutokuJiyu() {
//            @Override
//            public RString getCode() {
//                return reason.getCode();
//            }
//
//            @Override
//            public RString getName() {
//                return reason.getName();
//            }
//
//            @Override
//            public RString getShortName() {
//                return reason.getShortName();
//            }
//        };
//    }
//    private static IShikakuSoshitsuJiyu createShikakuSoshitsuJiyu(final ShikakuSoshitsuJiyu reason) {
//        return new IShikakuSoshitsuJiyu() {
//            @Override
//            public RString getCode() {
//                return reason.getCode();
//            }
//
//            @Override
//            public RString getName() {
//                return reason.getName();
//            }
//
//            @Override
//            public RString getShortName() {
//                return reason.getShortName();
//            }
//        };
//    }
}
