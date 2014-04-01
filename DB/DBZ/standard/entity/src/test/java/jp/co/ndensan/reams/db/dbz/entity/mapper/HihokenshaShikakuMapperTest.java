/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.entity.mapper;

import jp.co.ndensan.reams.db.dbz.business.HihokenshashoSaikofu;
import jp.co.ndensan.reams.db.dbz.business.IHihokenshaShikaku;
import jp.co.ndensan.reams.db.dbz.business.JushochitokureiKaijo;
import jp.co.ndensan.reams.db.dbz.business.JushochitokureiTekiyo;
import jp.co.ndensan.reams.db.dbz.business.ShikakuHenko;
import jp.co.ndensan.reams.db.dbz.business.ShikakuShutoku;
import jp.co.ndensan.reams.db.dbz.business.ShikakuSoshitsu;
import jp.co.ndensan.reams.db.dbz.business.helper.HihokenshaShikakuMock;
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
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT1001HihokenshaDaichoEntity;
import jp.co.ndensan.reams.db.dbz.entity.helper.DbT1001HihokenshaDaichoEntityMock;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
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
import static org.hamcrest.CoreMatchers.nullValue;
import org.junit.Before;
import org.junit.BeforeClass;
import static org.mockito.Mockito.*;

/**
 * HihokenshaShikakuMapperのテストです。
 *
 * @author N3327 三浦 凌
 */
@RunWith(Enclosed.class)
public class HihokenshaShikakuMapperTest extends DbzTestBase {

    private static HihokenshaShikakuMapper sut;

    @RunWith(Enclosed.class)
    public static class toHihokenshaDaichoEntity extends DbzTestBase {

        private static IHihokenshaShikaku shikaku;
        private static DbT1001HihokenshaDaichoEntity result;

        @BeforeClass
        public static void setUp() {
            shikaku = HihokenshaShikakuMock.getSpiedInstance();
        }

        public static class Other extends DbzTestBase {

            @Test
            public void toHihokenshaDaichoEntityは_引数がnullのとき_nullを返す() {
                result = sut.toHihokenshaDaichoEntity((IHihokenshaShikaku) null);
                assertThat(result, is(nullValue()));
            }

            @Test
            public void toHihokenshaDaichoEntityで変換したとき_結果のgetShichosonCodeは_引数のget地方公共団体コードと一致する() {
                LasdecCode lasdecCode = new LasdecCode("123456");
                when(shikaku.get地方公共団体コード()).thenReturn(lasdecCode);
                result = sut.toHihokenshaDaichoEntity(shikaku);
                assertThat(result.getShichosonCode(), is(shikaku.get地方公共団体コード()));
            }

            @Test
            public void toHihokenshaDaichoEntityで変換したとき_結果のgetHihokenshaNoは_引数のget被保険者番号と一致する() {
                KaigoHihokenshaNo hihokenshaNo = new KaigoHihokenshaNo(new RString("1234567890"));
                when(shikaku.get被保険者番号()).thenReturn(hihokenshaNo);
                result = sut.toHihokenshaDaichoEntity(shikaku);
                assertThat(result.getHihokenshaNo(), is(shikaku.get被保険者番号()));
            }

            @Test
            public void toHihokenshaDaichoEntityで変換したとき_結果のgetShikibetsuCodeは_引数のget識別コードと一致する() {
                ShikibetsuCode shikibetsuCode = new ShikibetsuCode("1020304050");
                when(shikaku.get識別コード()).thenReturn(shikibetsuCode);
                result = sut.toHihokenshaDaichoEntity(shikaku);

                assertThat(result.getShikibetsuCode(), is(shikaku.get識別コード()));
            }

            @Test
            public void toHihokenshaDaichoEntityで変換したとき_結果のgetHihokennshaKubunCodeは_引数のget被保険者区分$getコードと一致する() {
                when(shikaku.get被保険者区分()).thenReturn(ShikakuHihokenshaKubun.第１号被保険者);
                result = sut.toHihokenshaDaichoEntity(shikaku);
                assertThat(result.getHihokennshaKubunCode(), is(shikaku.get被保険者区分().getコード()));
            }

            @Test
            public void toHihokenshaDaichoEntityで変換したとき_結果のgetIchigoHihokenshaNenreiTotatsuYMDは_引数のget第一号年齢到達日と一致する() {
                FlexibleDate date = new FlexibleDate("20100325");
                when(shikaku.get第一号年齢到達日()).thenReturn(date);
                result = sut.toHihokenshaDaichoEntity(shikaku);
                assertThat(result.getIchigoHihokenshaNenreiTotatsuYMD(), is(shikaku.get第一号年齢到達日()));
            }

            @Test
            public void toHihokenshaDaichoEntityで変換したとき_結果のgetShikakuIdouKubunCodeは_引数のget資格異動区分$getCodeと一致する() {
                when(shikaku.get資格異動区分()).thenReturn(ShikakuIdoKubun.資格取得);
                result = sut.toHihokenshaDaichoEntity(shikaku);
                assertThat(result.getShikakuIdouKubunCode(), is(shikaku.get資格異動区分().getCode()));
            }

            @Test
            public void toHihokenshaDaichoEntityで変換したとき_結果のgetJushochiTokureiFlagは_引数のget住所地特例者区分$getコードと一致する() {
                when(shikaku.get住所地特例者区分()).thenReturn(JushochiTokureishaKubun.通常資格者);
                result = sut.toHihokenshaDaichoEntity(shikaku);
                assertThat(result.getJushochiTokureiFlag(), is(shikaku.get住所地特例者区分().getコード()));
            }

            @Test
            public void toHihokenshaDaichoEntityで変換したとき_結果のgetKoikinaiJushochiTokureiFlagは_引数のgett広域内住所地特例者区分$getコードと一致する() {
                when(shikaku.get広域内住所地特例者区分()).thenReturn(KoikinaiJushochitokureishaKubun.通常資格者);
                result = sut.toHihokenshaDaichoEntity(shikaku);
                assertThat(result.getKoikinaiJushochiTokureiFlag(), is(shikaku.get広域内住所地特例者区分().getCode()));
            }

            @Test
            public void toHihokenshaDaichoEntityで変換したとき_結果のgetKoikinaiTokureiSochimotoShichosonCodeは_引数のget広域内住所地特例措置元市町村コードと一致する() {
                LasdecCode tokureiSochimotoCode = new LasdecCode("234567");
                when(shikaku.get広域内住所地特例措置元市町村コード()).thenReturn(tokureiSochimotoCode);
                result = sut.toHihokenshaDaichoEntity(shikaku);
                assertThat(result.getKoikinaiTokureiSochimotoShichosonCode(), is(shikaku.get広域内住所地特例措置元市町村コード()));
            }

            @Test
            public void toHihokenshaDaichoEntityで変換したとき_結果のgetKyuShichosonCodeは_引数のget旧市町村コードと一致する() {
                LasdecCode oloShichosonCode = new LasdecCode("345678");
                when(shikaku.get旧市町村コード()).thenReturn(oloShichosonCode);
                result = sut.toHihokenshaDaichoEntity(shikaku);
                assertThat(result.getKyuShichosonCode(), is(shikaku.get旧市町村コード()));
            }
        }

        public static class _ShikakuShutoku extends DbzTestBase {

            private ShikakuShutoku shikakuShutoku;
            private ShikakuShutokuJiyu reason;
            private FlexibleDate noticeDate;
            private FlexibleDate actionDate;

            @Before
            public void setUp() {
                reason = ShikakuShutokuJiyu.年齢到達;
                noticeDate = new FlexibleDate("20130331");
                actionDate = new FlexibleDate("20130331");
                shikakuShutoku = new ShikakuShutoku(reason, noticeDate, actionDate);
                shikaku = HihokenshaShikakuMock.getSpiedInstance();
                when(shikaku.get資格取得()).thenReturn(shikakuShutoku);
                result = sut.toHihokenshaDaichoEntity(shikaku);
            }

            @Test
            public void toHihokenshaDaichoEntityで変換したとき_結果のgetShikakuShutokuJiyuCodeは_引数のget資格取得$getReason$getCodeと一致する() {
                assertThat(result.getShikakuShutokuJiyuCode(), is(shikaku.get資格取得().getReason().getCode()));
            }

            @Test
            public void toHihokenshaDaichoEntityで変換したとき_結果のgetShikakuShutokuTodokedeYMDは_引数のget資格取得$getNoticeDateと一致する() {
                assertThat(result.getShikakuShutokuTodokedeYMD(), is(shikaku.get資格取得().getNoticeDate()));
            }

            @Test
            public void toHihokenshaDaichoEntityで変換したとき_結果のgetShikakuShutokuYMDは_引数のget資格取得$getActionDateと一致する() {
                assertThat(result.getShikakuShutokuYMD(), is(shikaku.get資格取得().getActionDate()));
            }
        }

        public static class _ShikakuSoshitsu extends DbzTestBase {

            private ShikakuSoshitsu shikakuSoshitsu;
            private ShikakuSoshitsuJiyu reason;
            private FlexibleDate noticeDate;
            private FlexibleDate actionDate;

            @Before
            public void setUp() {
                reason = ShikakuSoshitsuJiyu.転出;
                noticeDate = new FlexibleDate("20130331");
                actionDate = new FlexibleDate("20130331");
                shikakuSoshitsu = new ShikakuSoshitsu(reason, noticeDate, actionDate);
                shikaku = HihokenshaShikakuMock.getSpiedInstance();
                when(shikaku.get資格喪失()).thenReturn(shikakuSoshitsu);
                result = sut.toHihokenshaDaichoEntity(shikaku);
            }

            @Test
            public void toHihokenshaDaichoEntityで変換したとき_結果のgetShikakuSoshitsuJiyuCodeは_引数のget資格喪失$getReason$getCodeと一致する() {
                assertThat(result.getShikakuSoshitsuJiyuCode(), is(shikaku.get資格喪失().getReason().getCode()));
            }

            @Test
            public void toHihokenshaDaichoEntityで変換したとき_結果のgetShikakuSoshitsuTodokedeYMDは_引数のget資格喪失$getNoticeDateと一致する() {
                assertThat(result.getShikakuSoshitsuTodokedeYMD(), is(shikaku.get資格喪失().getNoticeDate()));
            }

            @Test
            public void toHihokenshaDaichoEntityで変換したとき_結果のgetShikakuSoshitsuYMDは_引数のget資格喪失$getActionDateと一致する() {
                assertThat(result.getShikakuSoshitsuYMD(), is(shikaku.get資格喪失().getActionDate()));
            }
        }

        public static class _ShikakuHenko extends DbzTestBase {

            private ShikakuHenko shikakuHenko;
            private ShikakuHenkoJiyu reason;
            private FlexibleDate noticeDate;
            private FlexibleDate actionDate;

            @Before
            public void setUp() {
                reason = ShikakuHenkoJiyu.その他;
                noticeDate = new FlexibleDate("20130331");
                actionDate = new FlexibleDate("20130331");
                shikakuHenko = new ShikakuHenko(reason, noticeDate, actionDate);
                shikaku = HihokenshaShikakuMock.getSpiedInstance();
                when(shikaku.get資格変更()).thenReturn(shikakuHenko);
                result = sut.toHihokenshaDaichoEntity(shikaku);
            }

            @Test
            public void toHihokenshaDaichoEntityで変換したとき_結果のgetShikakuHenkoJiyuCodeは_引数のget資格変更$getReason$getCodeと一致する() {
                assertThat(result.getShikakuHenkoJiyuCode(), is(shikaku.get資格変更().getReason().getCode()));
            }

            @Test
            public void toHihokenshaDaichoEntityで変換したとき_結果のgetShikakuHenkoTodokedeYMDは_引数のget資格変更$getNoticeDateと一致する() {
                assertThat(result.getShikakuHenkoTodokedeYMD(), is(shikaku.get資格変更().getNoticeDate()));
            }

            @Test
            public void toHihokenshaDaichoEntityで変換したとき_結果のgetShikakuHenkoYMDは_引数のget資格変更$getActionDateと一致する() {
                assertThat(result.getShikakuHenkoYMD(), is(shikaku.get資格変更().getActionDate()));
            }
        }

        public static class _JushochitokureiTekiyo extends DbzTestBase {

            private JushochitokureiTekiyo jutokuTekiyo;
            private JushochitokureiTekiyoJiyu reason;
            private FlexibleDate noticeDate;
            private FlexibleDate actionDate;

            @Before
            public void setUp() {
                reason = JushochitokureiTekiyoJiyu.自特例転入;
                noticeDate = new FlexibleDate("20130331");
                actionDate = new FlexibleDate("20130331");
                jutokuTekiyo = new JushochitokureiTekiyo(reason, noticeDate, actionDate);
                shikaku = HihokenshaShikakuMock.getSpiedInstance();
                when(shikaku.get住所地特例適用()).thenReturn(jutokuTekiyo);
                result = sut.toHihokenshaDaichoEntity(shikaku);
            }

            @Test
            public void toHihokenshaDaichoEntityで変換したとき_結果のgetJushochitokureiTekiyoJiyuCodeは_引数のget住所地特例適用$getReason$getCodeと一致する() {
                assertThat(result.getJushochitokureiTekiyoJiyuCode(), is(shikaku.get住所地特例適用().getReason().getCode()));
            }

            @Test
            public void toHihokenshaDaichoEntityで変換したとき_結果のgetJushochitokureiTekiyoTodokedeYMDは_引数のget住所地特例適用$getNoticeDateと一致する() {
                assertThat(result.getJushochitokureiTekiyoTodokedeYMD(), is(shikaku.get住所地特例適用().getNoticeDate()));
            }

            @Test
            public void toHihokenshaDaichoEntityで変換したとき_結果のgetJushochitokureiTekiyoYMDは_引数のget住所地特例適用$getActionDateと一致する() {
                assertThat(result.getJushochitokureiTekiyoYMD(), is(shikaku.get住所地特例適用().getActionDate()));
            }
        }

        public static class _JushochitokureiKaijo extends DbzTestBase {

            private JushochitokureiKaijo jutokuKaijo;
            private JushochitokureiKaijoJiyu reason;
            private FlexibleDate noticeDate;
            private FlexibleDate actionDate;

            @Before
            public void setUp() {
                reason = JushochitokureiKaijoJiyu.自特例転入;
                noticeDate = new FlexibleDate("20130331");
                actionDate = new FlexibleDate("20130331");
                jutokuKaijo = new JushochitokureiKaijo(reason, noticeDate, actionDate);
                shikaku = HihokenshaShikakuMock.getSpiedInstance();
                when(shikaku.get住所地特例解除()).thenReturn(jutokuKaijo);
                result = sut.toHihokenshaDaichoEntity(shikaku);
            }

            @Test
            public void toHihokenshaDaichoEntityで変換したとき_結果のgetJushochitokureiKaijoJiyuCodeは_引数のget住所地特例解除$getReason$getCodeと一致する() {
                assertThat(result.getJushochitokureiKaijoJiyuCode(), is(shikaku.get住所地特例解除().getReason().getCode()));
            }

            @Test
            public void toHihokenshaDaichoEntityで変換したとき_結果のgetJushochitokureiKaijoTodokedeYMDは_引数のget住所地特例解除$getNoticeDateと一致する() {
                assertThat(result.getJushochitokureiKaijoTodokedeYMD(), is(shikaku.get住所地特例解除().getNoticeDate()));
            }

            @Test
            public void toHihokenshaDaichoEntityで変換したとき_結果のgetJushochitokureiKaijoYMDは_引数のget住所地特例解除$getActionDateと一致する() {
                assertThat(result.getJushochitokureiKaijoYMD(), is(shikaku.get住所地特例解除().getActionDate()));
            }
        }

        public static class _HihokenshashoSaikofu extends DbzTestBase {

            private HihokenshashoSaikofu saikofu;
            private HihokenshashoSaikofuKubun kubun;
            private HihokenshashoSaikofuJiyu reason;
            private ChohyoKofuRirekiID chohyoID;

            @Before
            public void setUp() {
                kubun = HihokenshashoSaikofuKubun.あり;
                reason = HihokenshashoSaikofuJiyu.その他;
                chohyoID = new ChohyoKofuRirekiID(new RString("10001000"));
                saikofu = new HihokenshashoSaikofu(kubun, reason, chohyoID);
                shikaku = HihokenshaShikakuMock.getSpiedInstance();
                when(shikaku.get被保険者証再交付()).thenReturn(saikofu);
                result = sut.toHihokenshaDaichoEntity(shikaku);
            }

            @Test
            public void toHihokenshaDaichoEntityで変換したとき_結果のgetSaikofuKubunは_引数のget被保険者証再交付$get有無区分$getCodeと一致する() {
                assertThat(result.getSaikofuKubun(), is(shikaku.get被保険者証再交付().get有無区分().getCode()));
            }

            @Test
            public void toHihokenshaDaichoEntityで変換したとき_結果のgetSaikofuJiyuCodeは_引数のget被保険者証再交付$getReason$getCodeと一致する() {
                assertThat(result.getSaikofuJiyuCode(), is(shikaku.get被保険者証再交付().getReason().getCode()));
            }

            @Test
            public void toHihokenshaDaichoEntityで変換したとき_結果のgetChohyoKofuRirekiIDは_引数のget被保険者証再交付$getChohyoKofuRirekiIDと一致する() {
                assertThat(result.getChohyoKofuRirekiID(), is(shikaku.get被保険者証再交付().getChohyoKofuRirekiID().value()));
            }
        }
    }

    @RunWith(Enclosed.class)
    public static class ToHihokenshaShikaku extends DbzTestBase {

        private static DbT1001HihokenshaDaichoEntity entity;

        @BeforeClass
        public static void setUp() {
            entity = DbT1001HihokenshaDaichoEntityMock.getSpiedInstance();
        }

        public static class Other extends DbzTestBase {

            private IHihokenshaShikaku result;

            @Test
            public void toHihokenshaShikakuは_引数がnullのとき_nullを返す() {
                result = sut.toHihokenshaShikaku((DbT1001HihokenshaDaichoEntity) null);
                assertThat(result, is(nullValue()));
            }
        }

        /**
         * 資格取得
         */
        public static class _ShikakuShutoku extends DbzTestBase {

            private ShikakuShutokuJiyu reason = ShikakuShutokuJiyu.その他;
            private FlexibleDate noticeDate = new FlexibleDate("20100328");
            private FlexibleDate actionDate = new FlexibleDate("20100329");
            private IHihokenshaShikaku result;

            @Before
            public void setUp() {
                entity.setShikakuShutokuJiyuCode(reason.getCode());
                entity.setShikakuShutokuTodokedeYMD(noticeDate);
                entity.setShikakuShutokuYMD(actionDate);
                result = sut.toHihokenshaShikaku(entity);
            }

            @Test
            public void toHihokenshaShikakuによる_結果の資格取得事由は_引数EntityのshikakuShutokuJiyuCodeをShikakuShutokuJiyuへ変換したものと一致する() {
                assertThat(result.get資格取得().getReason(), is(reason));
            }

            @Test
            public void toHihokenshaShikakuによる_結果の資格取得届出年月日は_暦上日のとき_引数EntityのshikakuShutokuTodokedeYMDと一致する() {
                assertThat(result.get資格取得().getNoticeDate(), is(noticeDate));
            }

            @Test
            public void toHihokenshaShikakuによる_結果の資格取得年月日は_暦上日のとき__引数EntityのshikakuShutokuYMDと一致する() {
                assertThat(result.get資格取得().getActionDate(), is(actionDate));
            }

            @Test
            public void toHihokenshaShikakuによる_結果の資格取得届出年月日は_暦上日ではないとき_RDate_MINと一致する() {
                entity.setShikakuShutokuTodokedeYMD(new FlexibleDate("00000001"));
                result = sut.toHihokenshaShikaku(entity);
                assertThat(result.get資格取得().getNoticeDate(), is(new FlexibleDate(RDate.MIN.toString())));
            }

            @Test
            public void toHihokenshaShikakuによる_結果の資格取得年月日は_暦上日ではないとき_RDate_MINと一致する() {
                entity.setShikakuShutokuYMD(new FlexibleDate("00000001"));
                result = sut.toHihokenshaShikaku(entity);
                assertThat(result.get資格取得().getActionDate(), is(new FlexibleDate(RDate.MIN.toString())));
            }
        }

        /**
         * 資格喪失
         */
        public static class _ShikakuSoshitsu extends DbzTestBase {

            private ShikakuSoshitsuJiyu reason = ShikakuSoshitsuJiyu.その他;
            private FlexibleDate noticeDate = new FlexibleDate("20100328");
            private FlexibleDate actionDate = new FlexibleDate("20100329");
            private IHihokenshaShikaku converted;

            @Before
            public void setUp() {
                entity.setShikakuSoshitsuJiyuCode(reason.getCode());
                entity.setShikakuSoshitsuTodokedeYMD(noticeDate);
                entity.setShikakuSoshitsuYMD(actionDate);
                converted = sut.toHihokenshaShikaku(entity);
            }

            @Test
            public void toHihokenshaShikakuによる_結果の資格喪失事由は_引数EntityのshikakuSoshitsuJiyuCodeをShikakuSoshitsuJiyuへ変換したものと一致する() {
                assertThat(converted.get資格喪失().getReason(), is(reason));
            }

            @Test
            public void toHihokenshaShikakuによる_結果の資格喪失届出年月日は_暦上日のとき_引数EntityのshikakuSoshitsuTodokedeYMDと一致する() {
                assertThat(converted.get資格喪失().getNoticeDate(), is(noticeDate));
            }

            @Test
            public void toHihokenshaShikakuによる_結果の資格喪失年月日は_暦上日のとき_引数EntityのshikakuSoshitsuYMDと一致する() {
                assertThat(converted.get資格喪失().getActionDate(), is(actionDate));
            }

            @Test
            public void toHihokenshaShikakuによる_結果の資格喪失届出年月日は_暦上日ではないとき_RDate_MAXと一致する() {
                entity.setShikakuSoshitsuTodokedeYMD(new FlexibleDate("00000001"));
                converted = sut.toHihokenshaShikaku(entity);
                assertThat(converted.get資格喪失().getNoticeDate(), is(new FlexibleDate(RDate.MAX.toString())));
            }

            @Test
            public void toHihokenshaShikakuによる_結果の資格喪失年月日は_暦上日ではないとき_RDate_MAXと一致する() {
                entity.setShikakuSoshitsuYMD(new FlexibleDate("00000001"));
                converted = sut.toHihokenshaShikaku(entity);
                assertThat(converted.get資格喪失().getActionDate(), is(new FlexibleDate(RDate.MAX.toString())));
            }
        }

        /**
         * 資格変更
         */
        public static class _ShikakuHenko extends DbzTestBase {

            private ShikakuHenkoJiyu reason = ShikakuHenkoJiyu.その他;
            private FlexibleDate noticeDate = new FlexibleDate("00000001");
            private FlexibleDate actionDate = new FlexibleDate("00000002");
            private IHihokenshaShikaku converted;

            @Before
            public void setUp() {
                entity.setShikakuHenkoJiyuCode(reason.getCode());
                entity.setShikakuHenkoTodokedeYMD(noticeDate);
                entity.setShikakuHenkoYMD(actionDate);
                converted = sut.toHihokenshaShikaku(entity);
            }

            @Test
            public void toHihokenshaShikakuによる_結果の資格変更事由は_引数EntityのshikakuHenkoJiyuCodeをShikakuHenkoJiyuへ変換したものと_一致する() {
                assertThat(converted.get資格変更().getReason(), is(reason));
            }

            @Test
            public void toHihokenshaShikakuによる_結果の資格変更届出年月日は_引数EntityのshikakuHenkoTodokedeYMDと_一致する() {
                assertThat(converted.get資格変更().getNoticeDate(), is(noticeDate));
            }

            @Test
            public void toHihokenshaShikakuによる_結果の資格変更年月日は_引数EntityのshikakuHenkoYMDと_一致する() {
                assertThat(converted.get資格変更().getActionDate(), is(actionDate));
            }
        }

        /**
         * 住所地特例適用
         */
        public static class _JushochitokureiTekiyo extends DbzTestBase {

            private JushochitokureiTekiyoJiyu reason = JushochitokureiTekiyoJiyu.その他;
            private FlexibleDate noticeDate = new FlexibleDate("00000001");
            private FlexibleDate actionDate = new FlexibleDate("00000002");
            private IHihokenshaShikaku converted;

            @Before
            public void setUp() {
                entity.setJushochitokureiTekiyoJiyuCode(reason.getCode());
                entity.setJushochitokureiTekiyoTodokedeYMD(noticeDate);
                entity.setJushochitokureiTekiyoYMD(actionDate);
                converted = sut.toHihokenshaShikaku(entity);
            }

            @Test
            public void toHihokenshaShikakuによる_結果の住所地特例適用事由は_引数EntityのjushochitokureiTekiyoJiyuCodeをJushochitokureiTekiyoJiyuへ変換したものと_一致する() {
                assertThat(converted.get住所地特例適用().getReason(), is(reason));
            }

            @Test
            public void toHihokenshaShikakuによる_結果の住所地特例適用届出年月日は_引数EntityのjushochitokureiTekiyoTodokedeYMDと_一致する() {
                assertThat(converted.get住所地特例適用().getNoticeDate(), is(noticeDate));
            }

            @Test
            public void toHihokenshaShikakuによる_結果の住所地特例適用年月日は_引数EntityのjushochitokureiTekiyoYMDと_一致する() {
                assertThat(converted.get住所地特例適用().getActionDate(), is(actionDate));
            }
        }

        /**
         * 住所地特例解除
         */
        public static class _JushochitokureiKaijo extends DbzTestBase {

            private JushochitokureiKaijoJiyu reason = JushochitokureiKaijoJiyu.その他;
            private FlexibleDate noticeDate = new FlexibleDate("00000001");
            private FlexibleDate actionDate = new FlexibleDate("00000002");
            private IHihokenshaShikaku converted;

            @Before
            public void setUp() {
                entity.setJushochitokureiKaijoJiyuCode(reason.getCode());
                entity.setJushochitokureiKaijoTodokedeYMD(noticeDate);
                entity.setJushochitokureiKaijoYMD(actionDate);
                converted = sut.toHihokenshaShikaku(entity);
            }

            @Test
            public void toHihokenshaShikakuによる_結果の住所地特例解除事由は_引数EntityのjushochitokureiKaijoJiyuCodeをJushochitokureiKaijoJiyuへ変換したものと_一致する() {
                assertThat(converted.get住所地特例解除().getReason(), is(reason));
            }

            @Test
            public void toHihokenshaShikakuによる_結果の住所地特例解除届出年月日は_引数EntityのjushochitokureiKaijoTodokedeYMDと_一致する() {
                assertThat(converted.get住所地特例解除().getNoticeDate(), is(noticeDate));
            }

            @Test
            public void toHihokenshaShikakuによる_結果の住所地特例解除年月日は_引数EntityのjushochitokureiKaijoYMDと_一致する() {
                assertThat(converted.get住所地特例解除().getActionDate(), is(actionDate));
            }
        }

        /**
         * 被保険者証再交付
         */
        public static class _HihokenshashoSaikofu extends DbzTestBase {

            private HihokenshashoSaikofuKubun kubun = HihokenshashoSaikofuKubun.あり;
            private HihokenshashoSaikofuJiyu reason = HihokenshashoSaikofuJiyu.その他;
            private ChohyoKofuRirekiID chohyoID = new ChohyoKofuRirekiID((new RString("100")));
            private IHihokenshaShikaku converted;

            @Before
            public void setUp() {
                entity.setSaikofuKubun(kubun.getCode());
                entity.setSaikofuJiyuCode(reason.getCode());
                entity.setChohyoKofuRirekiID(chohyoID.value());
                converted = sut.toHihokenshaShikaku(entity);
            }

            @Test
            public void toHihokenshaShikakuによる_結果の被保険者証再交付区分は_引数EntityのsaikofuKubunCodeをHihokenshashoSaikofuKubunへ変換したものと_一致する() {
                assertThat(converted.get被保険者証再交付().get有無区分(), is(kubun));
            }

            @Test
            public void toHihokenshaShikakuによる_結果の被保険者証再交付事由は_引数EntityのsaikofuJiyuCodeをHihokenshashoSaikofuJiyuへ変換したものと_一致する() {
                assertThat(converted.get被保険者証再交付().getReason(), is(reason));
            }

            @Test
            public void toHihokenshaShikakuによる_結果の帳票交付履歴IDは_引数EntityのchohyoKofuRirekiIDと_一致する() {
                assertThat(converted.get被保険者証再交付().getChohyoKofuRirekiID(), is(chohyoID));
            }
        }
    }
}
