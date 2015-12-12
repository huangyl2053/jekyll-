/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import jp.co.ndensan.reams.db.dbc.entity.basic.helper.DbT3017KyufujissekiKihonEntityGenerator;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.kyufujisseki.DbT3017KyufujissekiKihonEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.KokanShikibetsuNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.NyuryokuShikibetsuNo;
import static jp.co.ndensan.reams.db.dbx.testhelper.matcher.IsSerializable.serializable;
import jp.co.ndensan.reams.db.dbz.testhelper.DbcTestBase;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link KyufujissekiKihon}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class KyufujissekiKihonTest extends DbcTestBase {

    private static DbT3017KyufujissekiKihonEntity KyufujissekiKihonEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static KokanShikibetsuNo 交換情報識別番号;
    private static NyuryokuShikibetsuNo 入力識別番号;
    private static RString レコード種別コード;
    private static RString 給付実績情報作成区分コード;
    private static HokenshaNo 証記載保険者番号;
    private static HihokenshaNo 被保険者番号;
    private static FlexibleYearMonth サービス提供年月;
    private static RString 給付実績区分コード;
    private static JigyoshaNo 事業所番号;
    private static RString 通し番号;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        交換情報識別番号 = DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_交換情報識別番号;
        入力識別番号 = DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_入力識別番号;
        レコード種別コード = DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_レコード種別コード;
        給付実績情報作成区分コード = DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_給付実績情報作成区分コード;
        証記載保険者番号 = DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_証記載保険者番号;
        被保険者番号 = DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_被保険者番号;
        サービス提供年月 = DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_サービス提供年月;
        給付実績区分コード = DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_給付実績区分コード;
        事業所番号 = DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_事業所番号;
        通し番号 = DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_通し番号;
    }

    public static class 主キーコンストラクタテスト extends DbcTestBase {

        private static KyufujissekiKihon sut;

        @Before
        public void setUp() {
            KyufujissekiKihonEntity = DbT3017KyufujissekiKihonEntityGenerator.createDbT3017KyufujissekiKihonEntity();
            KyufujissekiKihonEntity.setKokanShikibetsuNo(交換情報識別番号);
            KyufujissekiKihonEntity.setInputShikibetsuNo(入力識別番号);
            KyufujissekiKihonEntity.setRecodeShubetsuCode(レコード種別コード);
            KyufujissekiKihonEntity.setKyufuSakuseiKubunCode(給付実績情報作成区分コード);
            KyufujissekiKihonEntity.setHokenshaNo(証記載保険者番号);
            KyufujissekiKihonEntity.setHiHokenshaNo(被保険者番号);
            KyufujissekiKihonEntity.setServiceTeikyoYM(サービス提供年月);
            KyufujissekiKihonEntity.setKyufuJissekiKubunCode(給付実績区分コード);
            KyufujissekiKihonEntity.setJigyoshoNo(事業所番号);
            KyufujissekiKihonEntity.setToshiNo(通し番号);
        }

//TODO 主キー名を置換してください
        @Test(expected = NullPointerException.class)
        public void 交換情報識別番号がnullである場合に_NullPointerExceptionが発生する() {
            sut = new KyufujissekiKihon(null, 入力識別番号, レコード種別コード,
                    給付実績情報作成区分コード, 証記載保険者番号, 被保険者番号, サービス提供年月, 給付実績区分コード, 事業所番号, 通し番号);
        }

        @Test(expected = NullPointerException.class)
        public void 入力識別番号がnullである場合に_NullPointerExceptionが発生する() {
            sut = new KyufujissekiKihon(交換情報識別番号, null, レコード種別コード,
                    給付実績情報作成区分コード, 証記載保険者番号, 被保険者番号, サービス提供年月, 給付実績区分コード, 事業所番号, 通し番号);
        }

        @Test
        public void 指定したキーが保持するDbT3017KyufujissekiKihonEntityにセットされている() {
            sut = new KyufujissekiKihon(交換情報識別番号, 入力識別番号, レコード種別コード,
                    給付実績情報作成区分コード, 証記載保険者番号, 被保険者番号, サービス提供年月, 給付実績区分コード, 事業所番号, 通し番号);
            assertThat(sut.get交換情報識別番号(), is(交換情報識別番号));
            assertThat(sut.get入力識別番号(), is(入力識別番号));
            assertThat(sut.getレコード種別コード(), is(レコード種別コード));
            assertThat(sut.get給付実績情報作成区分コード(), is(給付実績情報作成区分コード));
            assertThat(sut.get証記載保険者番号(), is(証記載保険者番号));
            assertThat(sut.get被保険者番号(), is(被保険者番号));
            assertThat(sut.getサービス提供年月(), is(サービス提供年月));
            assertThat(sut.get給付実績区分コード(), is(給付実績区分コード));
            assertThat(sut.get事業者番号(), is(事業所番号));
            assertThat(sut.get通し番号(), is(通し番号));
        }

        @Test
        public void 指定したキーが保持するKyufujissekiKihonIdentifierにセットされている() {
            sut = new KyufujissekiKihon(交換情報識別番号, 入力識別番号, レコード種別コード,
                    給付実績情報作成区分コード, 証記載保険者番号, 被保険者番号, サービス提供年月, 給付実績区分コード, 事業所番号, 通し番号);
            assertThat(sut.identifier().get交換情報識別番号(), is(交換情報識別番号));
            assertThat(sut.identifier().get入力識別番号(), is(入力識別番号));
            assertThat(sut.identifier().getレコード種別コード(), is(レコード種別コード));
            assertThat(sut.identifier().get給付実績情報作成区分コード(), is(給付実績情報作成区分コード));
            assertThat(sut.identifier().get証記載保険者番号(), is(証記載保険者番号));
            assertThat(sut.identifier().get被保険者番号(), is(被保険者番号));
            assertThat(sut.identifier().getサービス提供年月(), is(サービス提供年月));
            assertThat(sut.identifier().get給付実績区分コード(), is(給付実績区分コード));
            assertThat(sut.identifier().get事業所番号(), is(事業所番号));
            assertThat(sut.identifier().get通し番号(), is(通し番号));
        }
    }

    public static class Entityコンストラクタテスト extends DbcTestBase {

        private static KyufujissekiKihon sut;

        @Before
        public void setUp() {
            KyufujissekiKihonEntity = DbT3017KyufujissekiKihonEntityGenerator.createDbT3017KyufujissekiKihonEntity();
            KyufujissekiKihonEntity.setKokanShikibetsuNo(交換情報識別番号);
            KyufujissekiKihonEntity.setInputShikibetsuNo(入力識別番号);
            KyufujissekiKihonEntity.setRecodeShubetsuCode(レコード種別コード);
            KyufujissekiKihonEntity.setKyufuSakuseiKubunCode(給付実績情報作成区分コード);
            KyufujissekiKihonEntity.setHokenshaNo(証記載保険者番号);
            KyufujissekiKihonEntity.setHiHokenshaNo(被保険者番号);
            KyufujissekiKihonEntity.setServiceTeikyoYM(サービス提供年月);
            KyufujissekiKihonEntity.setKyufuJissekiKubunCode(給付実績区分コード);
            KyufujissekiKihonEntity.setJigyoshoNo(事業所番号);
            KyufujissekiKihonEntity.setToshiNo(通し番号);
        }

        @Test(expected = NullPointerException.class)
        public void 指定したEntityがnullである場合_NullPointerExceptionとなる() {
            sut = new KyufujissekiKihon(null);
        }

        @Test
        public void 指定したDbT3017KyufujissekiKihonEntityのキー情報を識別子が持つ() {

            sut = new KyufujissekiKihon(KyufujissekiKihonEntity);

            assertThat(sut.identifier().get交換情報識別番号(), is(交換情報識別番号));
            assertThat(sut.identifier().get入力識別番号(), is(入力識別番号));
            assertThat(sut.identifier().getレコード種別コード(), is(レコード種別コード));
            assertThat(sut.identifier().get給付実績情報作成区分コード(), is(給付実績情報作成区分コード));
            assertThat(sut.identifier().get証記載保険者番号(), is(証記載保険者番号));
            assertThat(sut.identifier().get被保険者番号(), is(被保険者番号));
            assertThat(sut.identifier().getサービス提供年月(), is(サービス提供年月));
            assertThat(sut.identifier().get給付実績区分コード(), is(給付実績区分コード));
            assertThat(sut.identifier().get事業所番号(), is(事業所番号));
            assertThat(sut.identifier().get通し番号(), is(通し番号));
        }
    }

    public static class getterテスト extends DbcTestBase {

        private static KyufujissekiKihon sut;

        @Before
        public void setUp() {
            KyufujissekiKihonEntity = DbT3017KyufujissekiKihonEntityGenerator.createDbT3017KyufujissekiKihonEntity();
            KyufujissekiKihonEntity.setKokanShikibetsuNo(交換情報識別番号);
            KyufujissekiKihonEntity.setInputShikibetsuNo(入力識別番号);
            KyufujissekiKihonEntity.setRecodeShubetsuCode(レコード種別コード);
            KyufujissekiKihonEntity.setKyufuSakuseiKubunCode(給付実績情報作成区分コード);
            KyufujissekiKihonEntity.setHokenshaNo(証記載保険者番号);
            KyufujissekiKihonEntity.setHiHokenshaNo(被保険者番号);
            KyufujissekiKihonEntity.setServiceTeikyoYM(サービス提供年月);
            KyufujissekiKihonEntity.setKyufuJissekiKubunCode(給付実績区分コード);
            KyufujissekiKihonEntity.setJigyoshoNo(事業所番号);
            KyufujissekiKihonEntity.setToshiNo(通し番号);

            sut = new KyufujissekiKihon(KyufujissekiKihonEntity);
        }

        @Test
        public void get交換情報識別番号は_entityが持つ交換情報識別番号を返す() {
            assertThat(sut.get交換情報識別番号(), is(KyufujissekiKihonEntity.getKokanShikibetsuNo()));
        }

        @Test
        public void get入力識別番号は_entityが持つ入力識別番号を返す() {
            assertThat(sut.get入力識別番号(), is(KyufujissekiKihonEntity.getInputShikibetsuNo()));
        }

        @Test
        public void getレコード種別コードは_entityが持つレコード種別コードを返す() {
            assertThat(sut.getレコード種別コード(), is(KyufujissekiKihonEntity.getRecodeShubetsuCode()));
        }

        @Test
        public void get給付実績情報作成区分コードは_entityが持つ給付実績情報作成区分コードを返す() {
            assertThat(sut.get給付実績情報作成区分コード(), is(KyufujissekiKihonEntity.getKyufuSakuseiKubunCode()));
        }

        @Test
        public void get証記載保険者番号は_entityが持つ証記載保険者番号を返す() {
            assertThat(sut.get証記載保険者番号(), is(KyufujissekiKihonEntity.getHokenshaNo()));
        }

        @Test
        public void get被保険者番号は_entityが持つ被保険者番号を返す() {
            assertThat(sut.get被保険者番号(), is(KyufujissekiKihonEntity.getHiHokenshaNo()));
        }

        @Test
        public void getサービス提供年月は_entityが持つサービス提供年月を返す() {
            assertThat(sut.getサービス提供年月(), is(KyufujissekiKihonEntity.getServiceTeikyoYM()));
        }

        @Test
        public void get給付実績区分コードは_entityが持つ給付実績区分コードを返す() {
            assertThat(sut.get給付実績区分コード(), is(KyufujissekiKihonEntity.getKyufuJissekiKubunCode()));
        }

        @Test
        public void get事業所番号は_entityが持つ事業所番号を返す() {
            assertThat(sut.get居宅介護支援事業所番号(), is(KyufujissekiKihonEntity.getJigyoshoNo()));
        }

        @Test
        public void get通し番号は_entityが持つ通し番号を返す() {
            assertThat(sut.get通し番号(), is(KyufujissekiKihonEntity.getToshiNo()));
        }

        @Test
        public void get公費１負担者番号は_entityが持つ公費１負担者番号を返す() {
            assertThat(sut.get公費１_負担者番号(), is(KyufujissekiKihonEntity.getKohi1FutanshaNo()));
        }

        @Test
        public void get公費１受給者番号は_entityが持つ公費１受給者番号を返す() {
            assertThat(sut.get公費１_受給者番号(), is(KyufujissekiKihonEntity.getKohi1JukyushaNo()));
        }

        @Test
        public void get公費２負担者番号は_entityが持つ公費２負担者番号を返す() {
            assertThat(sut.get公費２_負担者番号(), is(KyufujissekiKihonEntity.getKohi2FutanshaNo()));
        }

        @Test
        public void get公費２受給者番号は_entityが持つ公費２受給者番号を返す() {
            assertThat(sut.get公費２_受給者番号(), is(KyufujissekiKihonEntity.getKohi2JukyushaNo()));
        }

        @Test
        public void get公費３負担者番号は_entityが持つ公費３負担者番号を返す() {
            assertThat(sut.get公費３_負担者番号(), is(KyufujissekiKihonEntity.getKohi3FutanshaNo())
            );
        }

        @Test
        public void get公費３受給者番号は_entityが持つ公費３受給者番号を返す() {
            assertThat(sut.get公費３_受給者番号(), is(KyufujissekiKihonEntity.getKohi3JukyushaNo())
            );
        }

        @Test
        public void get生年月日は_entityが持つ生年月日を返す() {
            assertThat(sut.get生年月日(), is(KyufujissekiKihonEntity.getUmareYMD()));
        }

        @Test
        public void get性別コードは_entityが持つ性別コードを返す() {
            assertThat(sut.get性別コード(), is(KyufujissekiKihonEntity.getSeibetsuCode()));
        }

        @Test
        public void get要介護状態区分コードは_entityが持つ要介護状態区分コードを返す() {
            assertThat(sut.get要介護状態区分コード(), is(KyufujissekiKihonEntity.getYoKaigoJotaiKubunCode()));
        }

        @Test
        public void get旧措置入所者特例コードは_entityが持つ旧措置入所者特例コードを返す() {
            assertThat(sut.get旧措置入所者特例コード(), is(KyufujissekiKihonEntity.getKyuSochiNyushoshaTokureiCode()));
        }

        @Test
        public void get認定有効期間開始年月日は_entityが持つ認定有効期間開始年月日を返す() {
            assertThat(sut.get認定有効期間_開始年月日(), is(KyufujissekiKihonEntity.getNinteiYukoKaishiYMD())
            );
        }

        @Test
        public void get認定有功期間終了年月日は_entityが持つ認定有功期間終了年月日を返す() {
            assertThat(sut.get認定有功期間_終了年月日(), is(KyufujissekiKihonEntity.getNinteiYukoShuryoYMD())
            );
        }

        @Test
        public void get老人保健市町村番号は_entityが持つ老人保健市町村番号を返す() {
            assertThat(sut.get老人保健市町村番号(), is(KyufujissekiKihonEntity.getRojinHokenShichosonNo()));
        }

        @Test
        public void get老人保健受給者番号は_entityが持つ老人保健受給者番号を返す() {
            assertThat(sut.get老人保健受給者番号(), is(KyufujissekiKihonEntity.getRojinhokenJukyushaNo()));
        }

        @Test
        public void get保険者番号_後期_は_entityが持つ保険者番号_後期_を返す() {
            assertThat(sut.get保険者番号_後期(), is(KyufujissekiKihonEntity.getKokiHokenshaNo()));
        }

        @Test
        public void get被保険者番号_後期_は_entityが持つ被保険者番号_後期_を返す() {
            assertThat(sut.get被保険者番号_後期(), is(KyufujissekiKihonEntity.getKokiHiHokenshaNo()));
        }

        @Test
        public void get保険者番号_国保_は_entityが持つ保険者番号_国保_を返す() {
            assertThat(sut.get保険者番号_国保(), is(KyufujissekiKihonEntity.getKokuhoHokenshaNo())
            );
        }

        @Test
        public void get被保険者証番号_国保_は_entityが持つ被保険者証番号_国保_を返す() {
            assertThat(sut.get被保険者証番号_国保(), is(KyufujissekiKihonEntity.getKokuhoHiHokenshashoNo()));
        }

        @Test
        public void get個人番号_国保_は_entityが持つ個人番号_国保_を返す() {
            assertThat(sut.get個人番号_国保(), is(KyufujissekiKihonEntity.getKokuhoKojinNo()));
        }

        @Test
        public void get居宅サービス計画作成区分コードは_entityが持つ居宅サービス計画作成区分コードを返す() {
            assertThat(sut.get居宅サービス計画作成区分コード(), is(KyufujissekiKihonEntity.getKyotakuServiceSakuseiKubunCode()));
        }

//        @Test
//        public void get事業所番号は_entityが持つ事業所番号を返す() {
//            assertThat(sut.get居宅介護支援事業所番号(), is(KyufujissekiKihonEntity.getKyotakuKaigoShienJigyoshoNo()));
//        }
        @Test
        public void get開始年月日は_entityが持つ開始年月日を返す() {
            assertThat(sut.get開始年月日(), is(KyufujissekiKihonEntity.getKaishiYMD()));
        }

        @Test
        public void get中止年月日は_entityが持つ中止年月日を返す() {
            assertThat(sut.get中止年月日(), is(KyufujissekiKihonEntity.getChushiYMD()));
        }

        @Test
        public void get中止理由入所_院_前の状況コードは_entityが持つ中止理由入所_院_前の状況コードを返す() {
            assertThat(sut.get中止理由_入所_院_前の状況コード(), is(KyufujissekiKihonEntity.getChushiRiyuNyushomaeJyokyoCode()));
        }

        @Test
        public void get入所_院_年月日は_entityが持つ入所_院_年月日を返す() {
            assertThat(sut.get入所_院_年月日(), is(KyufujissekiKihonEntity.getNyushoYMD()));
        }

        @Test
        public void get退所_院_年月日は_entityが持つ退所_院_年月日を返す() {
            assertThat(sut.get退所_院_年月日(), is(KyufujissekiKihonEntity.getTaishoYMD()));
        }

        @Test
        public void get入所_院_実日数は_entityが持つ入所_院_実日数を返す() {
            assertThat(sut.get入所_院_実日数(), is(KyufujissekiKihonEntity.getNyushoJitsunissu()));
        }

        @Test
        public void get外泊日数は_entityが持つ外泊日数を返す() {
            assertThat(sut.get外泊日数(), is(KyufujissekiKihonEntity.getGaihakuNissu()));
        }

        @Test
        public void get退所_院_後の状態コードは_entityが持つ退所_院_後の状態コードを返す() {
            assertThat(sut.get退所_院_後の状態コード(), is(KyufujissekiKihonEntity.getTaishogoJotaiCode())
            );
        }

        @Test
        public void get保険給付率は_entityが持つ保険給付率を返す() {
            assertThat(sut.get保険給付率(), is(KyufujissekiKihonEntity.getHokenKyufuritsu()));
        }

        @Test
        public void get公費１給付率は_entityが持つ公費１給付率を返す() {
            assertThat(sut.get公費１給付率(), is(KyufujissekiKihonEntity.getKohi1Kyufuritsu()));
        }

        @Test
        public void get公費２給付率は_entityが持つ公費２給付率を返す() {
            assertThat(sut.get公費２給付率(), is(KyufujissekiKihonEntity.getKohi2Kyufuritsu()));
        }

        @Test
        public void get公費３給付率は_entityが持つ公費３給付率を返す() {
            assertThat(sut.get公費３給付率(), is(KyufujissekiKihonEntity.getKohi3Kyufuritsu()));
        }

        @Test
        public void get前保険サービス単位数は_entityが持つ前保険サービス単位数を返す() {
            assertThat(sut.get前_保険_サービス単位数(), is(KyufujissekiKihonEntity.getMaeHokenServiceTanisu())
            );
        }

        @Test
        public void get前保険請求額は_entityが持つ前保険請求額を返す() {
            assertThat(sut.get前_保険_請求額(), is(KyufujissekiKihonEntity.getMaeHokenSeikyugaku())
            );
        }

        @Test
        public void get前保険利用者負担額は_entityが持つ前保険利用者負担額を返す() {
            assertThat(sut.get前_保険_利用者負担額(), is(KyufujissekiKihonEntity.getMaeHokenRiyoshaFutangaku())
            );
        }

        @Test
        public void get前保険緊急時施設療養費請求額は_entityが持つ前保険緊急時施設療養費請求額を返す() {
            assertThat(sut.get前_保険_緊急時施設療養費請求額(), is(KyufujissekiKihonEntity.getMaeHokenKinkyuShisetsuRyoyoSeikyugaku())
            );
        }

        @Test
        public void get前保険特定診療費請求額は_entityが持つ前保険特定診療費請求額を返す() {
            assertThat(sut.get前_保険_特定診療費請求額(), is(KyufujissekiKihonEntity.getMaeHokenTokuteiShinryohiSeikyugaku())
            );
        }

        @Test
        public void get前保険特定入所者介護サービス費等請求額は_entityが持つ前保険特定入所者介護サービス費等請求額を返す() {
            assertThat(sut.get前_保険_特定入所者介護サービス費等請求額(), is(KyufujissekiKihonEntity.getMaeHokenTokuteiNyushoshaKaigoServiceHiSeikyugaku())
            );
        }

        @Test
        public void get前公費１サービス単位数は_entityが持つ前公費１サービス単位数を返す() {
            assertThat(sut.get前_公費１_サービス単位数(), is(KyufujissekiKihonEntity.getMaeKohi1ServiceTanisu())
            );
        }

        @Test
        public void get前公費１請求額は_entityが持つ前公費１請求額を返す() {
            assertThat(sut.get前_公費１_請求額(), is(KyufujissekiKihonEntity.getMaeKohi1Seikyugaku())
            );
        }

        @Test
        public void get前公費１本人負担額は_entityが持つ前公費１本人負担額を返す() {
            assertThat(sut.get前_公費１_本人負担額(), is(KyufujissekiKihonEntity.getMaeKohi1RiyoshaFutangaku())
            );
        }

        @Test
        public void get前公費１緊急時施設療養費請求額は_entityが持つ前公費１緊急時施設療養費請求額を返す() {
            assertThat(sut.get前_公費１_緊急時施設療養費請求額(), is(KyufujissekiKihonEntity.getMaeKohi1KinkyuShisetsuRyoyoSeikyugaku())
            );
        }

        @Test
        public void get前公費１特定診療費請求額は_entityが持つ前公費１特定診療費請求額を返す() {
            assertThat(sut.get前_公費１_特定診療費請求額(), is(KyufujissekiKihonEntity.getMaeKohi1TokuteiShinryohiSeikyugaku()));
        }

        @Test
        public void get前公費１特定入所者介護サービス費等請求額は_entityが持つ前公費１特定入所者介護サービス費等請求額を返す() {
            assertThat(sut.get前_公費１_特定入所者介護サービス費等請求額(), is(KyufujissekiKihonEntity.getMaeKohi1TokuteiNyushoshaKaigoServiceHiSeikyugaku())
            );
        }

        @Test
        public void get前公費２サービス単位数は_entityが持つ前公費２サービス単位数を返す() {
            assertThat(sut.get前_公費２_サービス単位数(), is(KyufujissekiKihonEntity.getMaeKohi2ServiceTanisu())
            );
        }

        @Test
        public void get前公費２請求額は_entityが持つ前公費２請求額を返す() {
            assertThat(sut.get前_公費２_請求額(), is(KyufujissekiKihonEntity.getMaeKohi2Seikyugaku())
            );
        }

        @Test
        public void get前公費２本人負担額は_entityが持つ前公費２本人負担額を返す() {
            assertThat(sut.get前_公費２_本人負担額(), is(KyufujissekiKihonEntity.getMaeKohi2RiyoshaFutangaku())
            );
        }

        @Test
        public void get前公費２緊急時施設療養費請求額は_entityが持つ前公費２緊急時施設療養費請求額を返す() {
            assertThat(sut.get前_公費２_緊急時施設療養費請求額(), is(KyufujissekiKihonEntity.getMaeKohi2KinkyuShisetsuRyoyoSeikyugaku())
            );
        }

        @Test
        public void get前公費２特定診療費請求額は_entityが持つ前公費２特定診療費請求額を返す() {
            assertThat(sut.get前_公費２_特定診療費請求額(), is(KyufujissekiKihonEntity.getMaeKohi2TokuteiShinryohiSeikyugaku())
            );
        }

        @Test
        public void get前公費２特定入所者介護サービス費等請求額は_entityが持つ前公費２特定入所者介護サービス費等請求額を返す() {
            assertThat(sut.get前_公費２_特定入所者介護サービス費等請求額(), is(KyufujissekiKihonEntity.getMaeKohi2TokuteiNyushoshaKaigoServiceHiSeikyugaku())
            );
        }

        @Test
        public void get前公費３サービス単位数は_entityが持つ前公費３サービス単位数を返す() {
            assertThat(sut.get前_公費３_サービス単位数(), is(KyufujissekiKihonEntity.getMaeKohi3ServiceTanisu())
            );
        }

        @Test
        public void get前公費３請求額は_entityが持つ前公費３請求額を返す() {
            assertThat(sut.get前_公費３_請求額(), is(KyufujissekiKihonEntity.getMaeKohi3Seikyugaku())
            );
        }

        @Test
        public void get前公費３本人負担額は_entityが持つ前公費３本人負担額を返す() {
            assertThat(sut.get前_公費３_本人負担額(), is(KyufujissekiKihonEntity.getMaeKohi3RiyoshaFutangaku())
            );
        }

        @Test
        public void get前公費３緊急時施設療養費請求額は_entityが持つ前公費３緊急時施設療養費請求額を返す() {
            assertThat(sut.get前_公費３_緊急時施設療養費請求額(), is(KyufujissekiKihonEntity.getMaeKohi3KinkyuShisetsuRyoyoSeikyugaku())
            );
        }

        @Test
        public void get前公費３特定診療費請求額は_entityが持つ前公費３特定診療費請求額を返す() {
            assertThat(sut.get前_公費３_特定診療費請求額(), is(KyufujissekiKihonEntity.getMaeKohi3TokuteiShinryohiSeikyugaku())
            );
        }

        @Test
        public void get前公費３特定入所者介護サービス費等請求額は_entityが持つ前公費３特定入所者介護サービス費等請求額を返す() {
            assertThat(sut.get前_公費３_特定入所者介護サービス費等請求額(), is(KyufujissekiKihonEntity.getMaeKohi3TokuteiNyushoshaKaigoServiceHiSeikyugaku())
            );
        }

        @Test
        public void get後保険サービス単位数は_entityが持つ後保険サービス単位数を返す() {
            assertThat(sut.get後_保険_サービス単位数(), is(KyufujissekiKihonEntity.getAtoHokenServiceTanisu())
            );
        }

        @Test
        public void get後保険請求額は_entityが持つ後保険請求額を返す() {
            assertThat(sut.get後_保険_請求額(), is(KyufujissekiKihonEntity.getAtoHokenSeikyugaku())
            );
        }

        @Test
        public void get後保険用者負担額は_entityが持つ後保険利用者負担額を返す() {
            assertThat(sut.get後_保険_利用者負担額(), is(KyufujissekiKihonEntity.getAtoHokenRiyoshaFutangaku())
            );
        }

        @Test
        public void get後緊急時施設療養費請求額は_entityが持つ後緊急時施設療養費請求額を返す() {
            assertThat(sut.get後_緊急時施設療養費請求額(), is(KyufujissekiKihonEntity.getAtoHokenKinkyuShisetsuRyoyoSeikyugaku())
            );
        }

        @Test
        public void get後保険特定診療費請求額は_entityが持つ後保険特定診療費請求額を返す() {
            assertThat(sut.get後_保険_特定診療費請求額(), is(KyufujissekiKihonEntity.getAtoHokenTokuteiShinryohiSeikyugaku())
            );
        }

        @Test
        public void get後保険特定入所者介護サービス費等請求額は_entityが持つ後保険特定入所者介護サービス費等請求額を返す() {
            assertThat(sut.get後_保険_特定入所者介護サービス費等請求額(), is(KyufujissekiKihonEntity.getAtoHokenTokuteiNyushoshaKaigoServiceHiSeikyugaku())
            );
        }

        @Test
        public void get後公費１サービス単位数は_entityが持つ後公費１サービス単位数を返す() {
            assertThat(sut.get後_公費１_サービス単位数(), is(KyufujissekiKihonEntity.getAtoKohi1ServiceTanisu())
            );
        }

        @Test
        public void get後公費１請求額は_entityが持つ後公費１請求額を返す() {
            assertThat(sut.get後_公費１_請求額(), is(KyufujissekiKihonEntity.getAtoKohi1Seikyugaku())
            );
        }

        @Test
        public void get後公費１本人負担額は_entityが持つ後公費１本人負担額を返す() {
            assertThat(sut.get後_公費１_本人負担額(), is(KyufujissekiKihonEntity.getAtoKohi1RiyoshaFutangaku())
            );
        }

        @Test
        public void get後公費１緊急時施設療養費請求額は_entityが持つ後公費１緊急時施設療養費請求額を返す() {
            assertThat(sut.get後_公費１_緊急時施設療養費請求額(), is(KyufujissekiKihonEntity.getAtoKohi1KinkyuShisetsuRyoyoSeikyugaku())
            );
        }

        @Test
        public void get後公費１特定診療費請求額は_entityが持つ後公費１特定診療費請求額を返す() {
            assertThat(sut.get後_公費１_特定診療費請求額(), is(KyufujissekiKihonEntity.getAtoKohi1TokuteiShinryohiSeikyugaku())
            );
        }

        @Test
        public void get後公費１特定入所者介護サービス費等請求額は_entityが持つ後公費１特定入所者介護サービス費等請求額を返す() {
            assertThat(sut.get後_公費１_特定入所者介護サービス費等請求額(), is(KyufujissekiKihonEntity.getAtoKohi1TokuteiNyushoshaKaigoServiceHiSeikyugaku())
            );
        }

        @Test
        public void get後公費２サービス単位数は_entityが持つ後公費２サービス単位数を返す() {
            assertThat(sut.get後_公費２_サービス単位数(), is(KyufujissekiKihonEntity.getAtoKohi2ServiceTanisu())
            );
        }

        @Test
        public void get後公費２請求額は_entityが持つ後公費２請求額を返す() {
            assertThat(sut.get後_公費２_請求額(), is(KyufujissekiKihonEntity.getAtoKohi2Seikyugaku())
            );
        }

        @Test
        public void get後公費２利用者負担額は_entityが持つ後公費２利用者負担額を返す() {
            assertThat(sut.get後_公費２_利用者負担額(), is(KyufujissekiKihonEntity.getAtoKohi2RiyoshaFutangaku())
            );
        }

        @Test
        public void get後公費２緊急時施設療養費請求額は_entityが持つ後公費２緊急時施設療養費請求額を返す() {
            assertThat(sut.get後_公費２_緊急時施設療養費請求額(), is(KyufujissekiKihonEntity.getAtoKohi2KinkyuShisetsuRyoyoSeikyugaku())
            );
        }

        @Test
        public void get後公費２特定診療費請求額は_entityが持つ後公費２特定診療費請求額を返す() {
            assertThat(sut.get後_公費２_特定診療費請求額(), is(KyufujissekiKihonEntity.getAtoKohi2TokuteiShinryohiSeikyugaku())
            );
        }

        @Test
        public void get後公費２特定入所者介護サービス費等請求額は_entityが持つ後公費２特定入所者介護サービス費等請求額を返す() {
            assertThat(sut.get後_公費２_特定入所者介護サービス費等請求額(), is(KyufujissekiKihonEntity.getAtoKohi2TokuteiNyushoshaKaigoServiceHiSeikyugaku())
            );
        }

        @Test
        public void get後公費３サービス単位数は_entityが持つ後公費サービス単位数を返す() {
            assertThat(sut.get後_公費３_サービス単位数(), is(KyufujissekiKihonEntity.getAtoKohi3ServiceTanisu())
            );
        }

        @Test
        public void get後公費３請求額は_entityが持つ後公費３請求額を返す() {
            assertThat(sut.get後_公費３_請求額(), is(KyufujissekiKihonEntity.getAtoKohi3Seikyugaku())
            );
        }

        @Test
        public void get後公費３利用者負担額は_entityが持つ後公費３利用者負担額を返す() {
            assertThat(sut.get後_公費３_利用者負担額(), is(KyufujissekiKihonEntity.getAtoKohi3RiyoshaFutangaku())
            );
        }

        @Test
        public void get後公費３緊急時施設療養費請求額は_entityが持つ後公費３緊急時施設療養費請求額を返す() {
            assertThat(sut.get後_公費３_緊急時施設療養費請求額(), is(KyufujissekiKihonEntity.getAtoKohi3KinkyuShisetsuRyoyoSeikyugaku())
            );
        }

        @Test
        public void get後公費３特定診療費請求額は_entityが持つ後公費３特定診療費請求額を返す() {
            assertThat(sut.get後_公費３_特定診療費請求額(), is(KyufujissekiKihonEntity.getAtoKohi3TokuteiShinryohiSeikyugaku())
            );
        }

        @Test
        public void get後公費３特定入所者介護サービス費等請求額は_entityが持つ後公費３特定入所者介護サービス費等請求額を返す() {
            assertThat(sut.get後_公費３_特定入所者介護サービス費等請求額(), is(KyufujissekiKihonEntity.getAtoKohi3TokuteiNyushoshaKaigoServiceHiSeikyugaku())
            );
        }

        @Test
        public void get警告区分コードは_entityが持つ警告区分コードを返す() {
            assertThat(sut.get警告区分コード(), is(KyufujissekiKihonEntity.getKeikaiKubunCode()));
        }

        @Test
        public void get審査年月は_entityが持つ審査年月を返す() {
            assertThat(sut.get審査年月(), is(KyufujissekiKihonEntity.getShinsaYM()));
        }

        @Test
        public void get整理番号は_entityが持つ整理番号を返す() {
            assertThat(sut.get整理番号(), is(KyufujissekiKihonEntity.getSeiriNo()));
        }

        @Test
        public void get送付年月は_entityが持つ送付年月を返す() {
            assertThat(sut.get送付年月(), is(KyufujissekiKihonEntity.getSofuYM()));
        }

        @Test
        public void get取込年月は_entityが持つ取込年月を返す() {
            assertThat(sut.get取込年月(), is(KyufujissekiKihonEntity.getTorikomiYM()));
        }

        @Test
        public void get独自作成区分は_entityが持つ独自作成区分を返す() {
            assertThat(sut.get独自作成区分(), is(KyufujissekiKihonEntity.getDokujiSakuseiKubun()));
        }

        @Test
        public void get保険者保有給付実績情報削除済フラグは_entityが持つ保険者保有給付実績情報削除済フラグを返す() {
            assertThat(sut.is保険者保有給付実績情報削除済フラグ(), is(KyufujissekiKihonEntity.getHokenshaHoyuKyufujissekiJohoSakujoFlag()));
        }
    }

    public static class toEntityテスト extends DbcTestBase {

        private static KyufujissekiKihon sut;

        @Before
        public void setUp() {
            KyufujissekiKihonEntity = DbT3017KyufujissekiKihonEntityGenerator.createDbT3017KyufujissekiKihonEntity();
            KyufujissekiKihonEntity.setKokanShikibetsuNo(交換情報識別番号);
            KyufujissekiKihonEntity.setInputShikibetsuNo(入力識別番号);
            KyufujissekiKihonEntity.setRecodeShubetsuCode(レコード種別コード);
            KyufujissekiKihonEntity.setKyufuSakuseiKubunCode(給付実績情報作成区分コード);
            KyufujissekiKihonEntity.setHokenshaNo(証記載保険者番号);
            KyufujissekiKihonEntity.setHiHokenshaNo(被保険者番号);
            KyufujissekiKihonEntity.setServiceTeikyoYM(サービス提供年月);
            KyufujissekiKihonEntity.setKyufuJissekiKubunCode(給付実績区分コード);
            KyufujissekiKihonEntity.setJigyoshoNo(事業所番号);
            KyufujissekiKihonEntity.setToshiNo(通し番号);

            sut = new KyufujissekiKihon(KyufujissekiKihonEntity);
        }

        @Test
        public void toEntityはコンストラクタで設定したentityと異なるインスタンスを返す() {
            assertThat(sut.toEntity(), not(KyufujissekiKihonEntity));
        }
    }

    @Ignore
    public static class SerializationProxyテスト extends DbcTestBase {

        private static KyufujissekiKihon sut;

        @Before
        public void setUp() {
            KyufujissekiKihonEntity = DbT3017KyufujissekiKihonEntityGenerator.createDbT3017KyufujissekiKihonEntity();
            KyufujissekiKihonEntity.setKokanShikibetsuNo(交換情報識別番号);
            KyufujissekiKihonEntity.setInputShikibetsuNo(入力識別番号);
            KyufujissekiKihonEntity.setRecodeShubetsuCode(レコード種別コード);
            KyufujissekiKihonEntity.setKyufuSakuseiKubunCode(給付実績情報作成区分コード);
            KyufujissekiKihonEntity.setHokenshaNo(証記載保険者番号);
            KyufujissekiKihonEntity.setHiHokenshaNo(被保険者番号);
            KyufujissekiKihonEntity.setServiceTeikyoYM(サービス提供年月);
            KyufujissekiKihonEntity.setKyufuJissekiKubunCode(給付実績区分コード);
            KyufujissekiKihonEntity.setJigyoshoNo(事業所番号);
            KyufujissekiKihonEntity.setToshiNo(通し番号);

            sut = new KyufujissekiKihon(KyufujissekiKihonEntity);
        }

        @Test
        public void シリアライズできる() {
            assertThat(sut, is(serializable()));
        }
    }

    public static class deletedテスト extends DbcTestBase {

        private static KyufujissekiKihon sut;
        private static KyufujissekiKihon result;

        @Before
        public void setUp() {
            KyufujissekiKihonEntity = DbT3017KyufujissekiKihonEntityGenerator.createDbT3017KyufujissekiKihonEntity();
            KyufujissekiKihonEntity.setKokanShikibetsuNo(交換情報識別番号);
            KyufujissekiKihonEntity.setInputShikibetsuNo(入力識別番号);
            KyufujissekiKihonEntity.setRecodeShubetsuCode(レコード種別コード);
            KyufujissekiKihonEntity.setKyufuSakuseiKubunCode(給付実績情報作成区分コード);
            KyufujissekiKihonEntity.setHokenshaNo(証記載保険者番号);
            KyufujissekiKihonEntity.setHiHokenshaNo(被保険者番号);
            KyufujissekiKihonEntity.setServiceTeikyoYM(サービス提供年月);
            KyufujissekiKihonEntity.setKyufuJissekiKubunCode(給付実績区分コード);
            KyufujissekiKihonEntity.setJigyoshoNo(事業所番号);
            KyufujissekiKihonEntity.setToshiNo(通し番号);

        }

        @Test
        public void KyufujissekiKihonが保持するDbT3017KyufujissekiKihonEntityのEntityDataStateがUnchangedである場合_deletedメソッド_によりKyufujissekiKihonが保持するDbT3017KyufujissekiKihonEntityのEntityDataStateがDeletedに指定されたKyufujissekiKihonが返る() {
            sut = TestSupport.setStateKyufujissekiKihon(EntityDataState.Unchanged);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void KyufujissekiKihonが保持するDbT3017KyufujissekiKihonEntityのEntityDataStateがModifiedである場合_deletedメソッド_によりKyufujissekiKihonが保持するDbT3017KyufujissekiKihonEntityのEntityDataStateがDeletedに指定されたKyufujissekiKihonが返る() {
            sut = TestSupport.setStateKyufujissekiKihon(EntityDataState.Modified);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void KyufujissekiKihonが保持するDbT3017KyufujissekiKihonEntityのEntityDataStateがDeletedである場合_deletedメソッド_によりKyufujissekiKihonが保持するDbT3017KyufujissekiKihonEntityのEntityDataStateがDeletedに指定されたKyufujissekiKihonが返る() {
            sut = TestSupport.setStateKyufujissekiKihon(EntityDataState.Deleted);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test(expected = IllegalStateException.class)
        public void KyufujissekiKihonが保持するDbT3017KyufujissekiKihonEntityのEntityDataStateがAddedである場合_deletedメソッド_により_IllegalStateExceptionが発火する() {
            sut = TestSupport.setStateKyufujissekiKihon(EntityDataState.Added);
            result = sut.deleted();
        }
    }

    private static class TestSupport {

        public static KyufujissekiKihon setStateKyufujissekiKihon(EntityDataState parentState) {
            KyufujissekiKihonEntity.setState(parentState);
            return new KyufujissekiKihon(KyufujissekiKihonEntity);
        }
    }
}
