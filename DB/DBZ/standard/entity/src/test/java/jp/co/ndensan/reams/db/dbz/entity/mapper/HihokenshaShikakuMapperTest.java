/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.entity.mapper;

import jp.co.ndensan.reams.db.dbz.business.IHihokenshaShikaku;
import jp.co.ndensan.reams.db.dbz.business.helper.HihokenshaShikakuMock;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.HihokenshashoSaikofuJiyu;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.HihokenshashoSaikofuKubun;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.JushochitokureiKaijoJiyu;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.JushochitokureiTekiyoJiyu;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.ShikakuHenkoJiyu;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.ShikakuIdoKubun;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.ShikakuShutokuJiyu;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.ShikakuSoshitsuJiyu;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ChohyoKofuRirekiID;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.KaigoHihokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT1001HihokenshaDaichoEntity;
import jp.co.ndensan.reams.db.dbz.entity.helper.DbT1001HihokenshaDaichoEntityMock;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
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
        }
//        @Test
//        public void toHihokenshaDaichoEntityで変換したとき_結果のgetShikakuShutokuJiyuCodeは_引数のget資格取得$getReason$getCodeと一致する() {
//            FlexibleDate date = new FlexibleDate("20100325");
//            when(shikaku.get資格取得()).thenReturn(date);
//            result = sut.toHihokenshaDaichoEntity(shikaku);
//            assertThat(result.getShikakuShutokuJiyuCode(), is(shikaku.get資格取得().getReason().getCode()));
//        }
    }

    @RunWith(Enclosed.class)
    public static class ToHihokenshaShikaku extends DbzTestBase {

        private static DbT1001HihokenshaDaichoEntity entity;

        @BeforeClass
        public static void setUp() {
            entity = DbT1001HihokenshaDaichoEntityMock.getSpiedInstance();
        }

        /**
         * 資格取得
         */
        public static class _ShikakuShutoku extends DbzTestBase {

            private ShikakuShutokuJiyu reason = ShikakuShutokuJiyu.その他;
            private FlexibleDate noticeDate = new FlexibleDate("20100328");
            private FlexibleDate actionDate = new FlexibleDate("20100329");
            private IHihokenshaShikaku converted;

            @Before
            public void setUp() {
                entity.setShikakuShutokuJiyuCode(reason.getCode());
                entity.setShikakuShutokuTodokedeYMD(noticeDate);
                entity.setShikakuShutokuYMD(actionDate);
                converted = sut.toHihokenshaShikaku(entity);
            }

            @Test
            public void 変換後クラスの資格取得事由は_引数EntityのshikakuShutokuJiyuCodeをShikakuShutokuJiyuへ変換したものと一致する() {
                assertThat(converted.get資格取得().getReason(), is(reason));
            }

            @Test
            public void 変換後クラスの資格取得届出年月日は_暦上日のとき_引数EntityのshikakuShutokuTodokedeYMDと一致する() {
                assertThat(converted.get資格取得().getNoticeDate(), is(noticeDate));
            }

            @Test
            public void 変換後クラスの資格取得年月日は_暦上日のとき__引数EntityのshikakuShutokuYMDと一致する() {
                assertThat(converted.get資格取得().getActionDate(), is(actionDate));
            }

            @Test
            public void 変換後クラスの資格取得届出年月日は_暦上日ではないとき_RDate_MINと一致する() {
                entity.setShikakuShutokuTodokedeYMD(new FlexibleDate("00000001"));
                converted = sut.toHihokenshaShikaku(entity);
                assertThat(converted.get資格取得().getNoticeDate(), is(new FlexibleDate(RDate.MIN.toString())));
            }

            @Test
            public void 変換後クラスの資格取得年月日は_暦上日ではないとき_RDate_MINと一致する() {
                entity.setShikakuShutokuYMD(new FlexibleDate("00000001"));
                converted = sut.toHihokenshaShikaku(entity);
                assertThat(converted.get資格取得().getActionDate(), is(new FlexibleDate(RDate.MIN.toString())));
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
            public void 変換後クラスの資格喪失事由は_引数EntityのshikakuSoshitsuJiyuCodeをShikakuSoshitsuJiyuへ変換したものと一致する() {
                assertThat(converted.get資格喪失().getReason(), is(reason));
            }

            @Test
            public void 変換後クラスの資格喪失届出年月日は_暦上日のとき_引数EntityのshikakuSoshitsuTodokedeYMDと一致する() {
                assertThat(converted.get資格喪失().getNoticeDate(), is(noticeDate));
            }

            @Test
            public void 変換後クラスの資格喪失年月日は_暦上日のとき_引数EntityのshikakuSoshitsuYMDと一致する() {
                assertThat(converted.get資格喪失().getActionDate(), is(actionDate));
            }

            @Test
            public void 変換後クラスの資格喪失届出年月日は_暦上日ではないとき_RDate_MAXと一致する() {
                entity.setShikakuSoshitsuTodokedeYMD(new FlexibleDate("00000001"));
                converted = sut.toHihokenshaShikaku(entity);
                assertThat(converted.get資格喪失().getNoticeDate(), is(new FlexibleDate(RDate.MAX.toString())));
            }

            @Test
            public void 変換後クラスの資格喪失年月日は_暦上日ではないとき_RDate_MAXと一致する() {
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
            public void 変換後クラスの資格変更事由は_引数EntityのshikakuHenkoJiyuCodeをShikakuHenkoJiyuへ変換したものと_一致する() {
                assertThat(converted.get資格変更().getReason(), is(reason));
            }

            @Test
            public void 変換後クラスの資格変更届出年月日は_引数EntityのshikakuHenkoTodokedeYMDと_一致する() {
                assertThat(converted.get資格変更().getNoticeDate(), is(noticeDate));
            }

            @Test
            public void 変換後クラスの資格変更年月日は_引数EntityのshikakuHenkoYMDと_一致する() {
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
            public void 変換後クラスの住所地特例適用事由は_引数EntityのjushochitokureiTekiyoJiyuCodeをJushochitokureiTekiyoJiyuへ変換したものと_一致する() {
                assertThat(converted.get住所地特例適用().getReason(), is(reason));
            }

            @Test
            public void 変換後クラスの住所地特例適用届出年月日は_引数EntityのjushochitokureiTekiyoTodokedeYMDと_一致する() {
                assertThat(converted.get住所地特例適用().getNoticeDate(), is(noticeDate));
            }

            @Test
            public void 変換後クラスの住所地特例適用年月日は_引数EntityのjushochitokureiTekiyoYMDと_一致する() {
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
            public void 変換後クラスの住所地特例解除事由は_引数EntityのjushochitokureiKaijoJiyuCodeをJushochitokureiKaijoJiyuへ変換したものと_一致する() {
                assertThat(converted.get住所地特例解除().getReason(), is(reason));
            }

            @Test
            public void 変換後クラスの住所地特例解除届出年月日は_引数EntityのjushochitokureiKaijoTodokedeYMDと_一致する() {
                assertThat(converted.get住所地特例解除().getNoticeDate(), is(noticeDate));
            }

            @Test
            public void 変換後クラスの住所地特例解除年月日は_引数EntityのjushochitokureiKaijoYMDと_一致する() {
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
            public void 変換後クラスの被保険者証再交付区分は_引数EntityのsaikofuKubunCodeをHihokenshashoSaikofuKubunへ変換したものと_一致する() {
                assertThat(converted.get被保険者証再交付().get有無区分(), is(kubun));
            }

            @Test
            public void 変換後クラスの被保険者証再交付事由は_引数EntityのsaikofuJiyuCodeをHihokenshashoSaikofuJiyuへ変換したものと_一致する() {
                assertThat(converted.get被保険者証再交付().getReason(), is(reason));
            }

            @Test
            public void 変換後クラスの帳票交付履歴IDは_引数EntityのchohyoKofuRirekiIDと_一致する() {
                assertThat(converted.get被保険者証再交付().getChohyoKofuRirekiID(), is(chohyoID));
            }
        }
    }
}
