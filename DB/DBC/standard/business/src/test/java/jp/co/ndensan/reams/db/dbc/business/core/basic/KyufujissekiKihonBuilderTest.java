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
import jp.co.ndensan.reams.db.dbz.testhelper.DbcTestBase;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link KyufujissekiKihonBuilder}のテストクラスです。
 */
@RunWith(Enclosed.class)
@Ignore
public class KyufujissekiKihonBuilderTest extends DbcTestBase {

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

    public static class getterSetterTest extends DbcTestBase {

        private static KyufujissekiKihonBuilder sut;
        private static KyufujissekiKihon business;

        @Before
        public void setUp() {
            KyufujissekiKihonEntity = new DbT3017KyufujissekiKihonEntity();
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

            business = new KyufujissekiKihon(KyufujissekiKihonEntity);

            sut = business.createBuilderForEdit();
        }
//TODO Key項目のテストメソッドは削除して下さい。

        @Test
        public void 戻り値の交換情報識別番号は_設定した値と同じ交換情報識別番号を返す() {
            business = sut.set交換情報識別番号(DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_交換情報識別番号).build();
            assertThat(business.get交換情報識別番号(), is(DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_交換情報識別番号));
        }

        @Test
        public void 戻り値の入力識別番号は_設定した値と同じ入力識別番号を返す() {
            business = sut.set入力識別番号(DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_入力識別番号).build();
            assertThat(business.get入力識別番号(), is(DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_入力識別番号));
        }

        @Test
        public void 戻り値のレコード種別コードは_設定した値と同じレコード種別コードを返す() {
            business = sut.setレコード種別コード(DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_レコード種別コード).build();
            assertThat(business.getレコード種別コード(), is(DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_レコード種別コード));
        }

        @Test
        public void 戻り値の給付実績情報作成区分コードは_設定した値と同じ給付実績情報作成区分コードを返す() {
            business = sut.set給付実績情報作成区分コード(DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_給付実績情報作成区分コード).build();
            assertThat(business.get給付実績情報作成区分コード(), is(DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_給付実績情報作成区分コード));
        }

        @Test
        public void 戻り値の証記載保険者番号は_設定した値と同じ証記載保険者番号を返す() {
            business = sut.set証記載保険者番号(DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_証記載保険者番号).build();
            assertThat(business.get証記載保険者番号(), is(DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_証記載保険者番号));
        }

        @Test
        public void 戻り値の被保険者番号は_設定した値と同じ被保険者番号を返す() {
            business = sut.set被保険者番号(DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_被保険者番号).build();
            assertThat(business.get被保険者番号(), is(DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_被保険者番号));
        }

        @Test
        public void 戻り値のサービス提供年月は_設定した値と同じサービス提供年月を返す() {
            business = sut.setサービス提供年月(DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_サービス提供年月).build();
            assertThat(business.getサービス提供年月(), is(DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_サービス提供年月));
        }

        @Test
        public void 戻り値の給付実績区分コードは_設定した値と同じ給付実績区分コードを返す() {
            business = sut.set給付実績区分コード(DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_給付実績区分コード).build();
            assertThat(business.get給付実績区分コード(), is(DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_給付実績区分コード));
        }

        @Test
        public void 戻り値の事業所番号は_設定した値と同じ事業所番号を返す() {
            business = sut.set事業所番号(DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_事業所番号).build();
            assertThat(business.get居宅介護支援事業所番号(), is(DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_事業所番号));
        }

        @Test
        public void 戻り値の通し番号は_設定した値と同じ通し番号を返す() {
            business = sut.set通し番号(DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_通し番号).build();
            assertThat(business.get通し番号(), is(DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_通し番号));
        }

        @Test
        public void 戻り値の公費１_負担者番号は_設定した値と同じ公費１_負担者番号を返す() {
            business = sut.set公費１負担者番号(DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_公費１_負担者番号).build();
            assertThat(business.get公費１_負担者番号(), is(DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_公費１_負担者番号));
        }

        @Test
        public void 戻り値の公費１_受給者番号は_設定した値と同じ公費１_受給者番号を返す() {
            business = sut.set公費１_受給者番号(DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_公費１_受給者番号).build();
            assertThat(business.get公費１_受給者番号(), is(DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_公費１_受給者番号));
        }

        @Test
        public void 戻り値の公費２_負担者番号は_設定した値と同じ公費２_負担者番号を返す() {
            business = sut.set公費２_負担者番号(DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_公費２_負担者番号).build();
            assertThat(business.get公費２_負担者番号(), is(DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_公費２_負担者番号));
        }

        @Test
        public void 戻り値の公費２_受給者番号は_設定した値と同じ公費２_受給者番号を返す() {
            business = sut.set公費２_受給者番号(DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_公費２_受給者番号).build();
            assertThat(business.get公費２_受給者番号(), is(DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_公費２_受給者番号));
        }

        @Test
        public void 戻り値の公費３_負担者番号は_設定した値と同じ公費３_負担者番号を返す() {
            business = sut.set公費３_負担者番号(DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_公費３_負担者番号).build();
            assertThat(business.get公費３_負担者番号(), is(DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_公費３_負担者番号));
        }

        @Test
        public void 戻り値の公費３_受給者番号は_設定した値と同じ公費３_受給者番号を返す() {
            business = sut.set公費３_受給者番号(DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_公費３_受給者番号).build();
            assertThat(business.get公費３_受給者番号(), is(DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_公費３_受給者番号));
        }

        @Test
        public void 戻り値の生年月日は_設定した値と同じ生年月日を返す() {
            business = sut.set生年月日(DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_生年月日).build();
            assertThat(business.get生年月日(), is(DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_生年月日));
        }

        @Test
        public void 戻り値の性別コードは_設定した値と同じ性別コードを返す() {
            business = sut.set性別コード(DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_性別コード).build();
            assertThat(business.get性別コード(), is(DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_性別コード));
        }

        @Test
        public void 戻り値の要介護状態区分コードは_設定した値と同じ要介護状態区分コードを返す() {
            business = sut.set要介護状態区分コード(DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_要介護状態区分コード).build();
            assertThat(business.get要介護状態区分コード(), is(DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_要介護状態区分コード));
        }

        @Test
        public void 戻り値の旧措置入所者特例コードは_設定した値と同じ旧措置入所者特例コードを返す() {
            business = sut.set旧措置入所者特例コード(DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_旧措置入所者特例コード).build();
            assertThat(business.get旧措置入所者特例コード(), is(DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_旧措置入所者特例コード));
        }

        @Test
        public void 戻り値の認定有効期間_開始年月日は_設定した値と同じ認定有効期間_開始年月日を返す() {
            business = sut.set認定有効期間_開始年月日(DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_認定有効期間_開始年月日).build();
            assertThat(business.get認定有効期間_開始年月日(), is(DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_認定有効期間_開始年月日));
        }

        @Test
        public void 戻り値の認定有功期間_終了年月日は_設定した値と同じ認定有功期間_終了年月日を返す() {
            business = sut.set認定有功期間_終了年月日(DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_認定有功期間_終了年月日).build();
            assertThat(business.get認定有功期間_終了年月日(), is(DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_認定有功期間_終了年月日));
        }

        @Test
        public void 戻り値の老人保健市町村番号は_設定した値と同じ老人保健市町村番号を返す() {
            business = sut.set老人保健市町村番号(DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_老人保健市町村番号).build();
            assertThat(business.get老人保健市町村番号(), is(DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_老人保健市町村番号));
        }

        @Test
        public void 戻り値の老人保健受給者番号は_設定した値と同じ老人保健受給者番号を返す() {
            business = sut.set老人保健受給者番号(DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_老人保健受給者番号).build();
            assertThat(business.get老人保健受給者番号(), is(DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_老人保健受給者番号));
        }

        @Test
        public void 戻り値の保険者番号_後期は_設定した値と同じ保険者番号_後期を返す() {
            business = sut.set保険者番号_後期(DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_保険者番号_後期).build();
            assertThat(business.get保険者番号_後期(), is(DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_保険者番号_後期));
        }

        @Test
        public void 戻り値の被保険者番号_後期は_設定した値と同じ被保険者番号_後期を返す() {
            business = sut.set被保険者番号_後期(DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_被保険者番号_後期).build();
            assertThat(business.get被保険者番号_後期(), is(DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_被保険者番号_後期));
        }

        @Test
        public void 戻り値の保険者番号_国保は_設定した値と同じ保険者番号_国保を返す() {
            business = sut.set保険者番号_国保(DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_保険者番号_国保).build();
            assertThat(business.get保険者番号_国保(), is(DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_保険者番号_国保));
        }

        @Test
        public void 戻り値の被保険者証番号_国保は_設定した値と同じ被保険者証番号_国保を返す() {
            business = sut.set被保険者証番号_国保(DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_被保険者証番号_国保).build();
            assertThat(business.get被保険者証番号_国保(), is(DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_被保険者証番号_国保));
        }

        @Test
        public void 戻り値の個人番号_国保は_設定した値と同じ個人番号_国保を返す() {
            business = sut.set個人番号_国保(DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_個人番号_国保).build();
            assertThat(business.get個人番号_国保(), is(DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_個人番号_国保));
        }

        @Test
        public void 戻り値の居宅サービス計画作成区分コードは_設定した値と同じ居宅サービス計画作成区分コードを返す() {
            business = sut.set居宅サービス計画作成区分コード(DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_居宅サービス計画作成区分コード).build();
            assertThat(business.get居宅サービス計画作成区分コード(), is(DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_居宅サービス計画作成区分コード));
        }

        @Test
        public void 戻り値の開始年月日は_設定した値と同じ開始年月日を返す() {
            business = sut.set開始年月日(DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_開始年月日).build();
            assertThat(business.get開始年月日(), is(DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_開始年月日));
        }

        @Test
        public void 戻り値の中止年月日は_設定した値と同じ中止年月日を返す() {
            business = sut.set中止年月日(DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_中止年月日).build();
            assertThat(business.get中止年月日(), is(DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_中止年月日));
        }

        @Test
        public void 戻り値の中止理由_入所_院_前の状況コードは_設定した値と同じ中止理由_入所_院_前の状況コードを返す() {
            business = sut.set中止理由_入所_院_前の状況コード(DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_中止理由_入所_院_前の状況コード).build();
            assertThat(business.get中止理由_入所_院_前の状況コード(), is(DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_中止理由_入所_院_前の状況コード));
        }

        @Test
        public void 戻り値の入所_院_年月日は_設定した値と同じ入所_院_年月日を返す() {
            business = sut.set入所_院_年月日(DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_入所_院_年月日).build();
            assertThat(business.get入所_院_年月日(), is(DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_入所_院_年月日)
            );
        }

        @Test
        public void 戻り値の退所_院_年月日は_設定した値と同じ退所_院_年月日を返す() {
            business = sut.set退所_院_年月日(DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_退所_院_年月日).build();
            assertThat(business.get退所_院_年月日(), is(DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_退所_院_年月日));
        }

        @Test
        public void 戻り値の入所_院_実日数は_設定した値と同じ入所_院_実日数を返す() {
            business = sut.set入所_院_実日数(DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_入所_院_実日数).build();
            assertThat(business.get入所_院_実日数(), is(DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_入所_院_実日数));
        }

        @Test
        public void 戻り値の外泊日数は_設定した値と同じ外泊日数を返す() {
            business = sut.set外泊日数(DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_外泊日数).build();
            assertThat(business.get外泊日数(), is(DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_外泊日数));
        }

        @Test
        public void 戻り値の退所_院_後の状態コードは_設定した値と同じ退所_院_後の状態コードを返す() {
            business = sut.set退所_院_後の状態コード(DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_退所_院_後の状態コード).build();
            assertThat(business.get退所_院_後の状態コード(), is(DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_退所_院_後の状態コード));
        }

        @Test
        public void 戻り値の保険給付率は_設定した値と同じ保険給付率を返す() {
            business = sut.set保険給付率(DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_保険給付率).build();
            assertThat(business.get保険給付率(), is(DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_保険給付率));
        }

        @Test
        public void 戻り値の公費１給付率は_設定した値と同じ公費１給付率を返す() {
            business = sut.set公費１給付率(DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_公費１給付率).build();
            assertThat(business.get公費１給付率(), is(DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_公費１給付率));
        }

        @Test
        public void 戻り値の公費２給付率は_設定した値と同じ公費２給付率を返す() {
            business = sut.set公費２給付率(DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_公費２給付率).build();
            assertThat(business.get公費２給付率(), is(DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_公費２給付率));
        }

        @Test
        public void 戻り値の公費３給付率は_設定した値と同じ公費３給付率を返す() {
            business = sut.set公費３給付率(DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_公費３給付率).build();
            assertThat(business.get公費３給付率(), is(DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_公費３給付率));
        }

        @Test
        public void 戻り値の前_保険_サービス単位数は_設定した値と同じ前_保険_サービス単位数を返す() {
            business = sut.set前_保険_サービス単位数(DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_前_保険_サービス単位数).build();
            assertThat(business.get前_保険_サービス単位数(), is(DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_前_保険_サービス単位数));
        }

        @Test
        public void 戻り値の前_保険_請求額は_設定した値と同じ前_保険_請求額を返す() {
            business = sut.set前_保険_請求額(DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_前_保険_請求額).build();
            assertThat(business.get前_保険_請求額(), is(DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_前_保険_請求額));
        }

        @Test
        public void 戻り値の前_保険_利用者負担額は_設定した値と同じ前_保険_利用者負担額を返す() {
            business = sut.set前_保険_利用者負担額(DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_前_保険_利用者負担額).build();
            assertThat(business.get前_保険_利用者負担額(), is(DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_前_保険_利用者負担額));
        }

        @Test
        public void 戻り値の前_保険_緊急時施設療養費請求額は_設定した値と同じ前_保険_緊急時施設療養費請求額を返す() {
            business = sut.set前_保険_緊急時施設療養費請求額(DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_前_保険_緊急時施設療養費請求額).build();
            assertThat(business.get前_保険_緊急時施設療養費請求額(), is(DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_前_保険_緊急時施設療養費請求額));
        }

        @Test
        public void 戻り値の前_保険_特定診療費請求額は_設定した値と同じ前_保険_特定診療費請求額を返す() {
            business = sut.set前_保険_特定診療費請求額(DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_前_保険_特定診療費請求額).build();
            assertThat(business.get前_保険_特定診療費請求額(), is(DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_前_保険_特定診療費請求額));
        }

        @Test
        public void 戻り値の前_保険_特定入所者介護サービス費等請求額は_設定した値と同じ前_保険_特定入所者介護サービス費等請求額を返す() {
            business = sut.set前_保険_特定入所者介護サービス費等請求額(DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_前_保険_特定入所者介護サービス費等請求額).build();
            assertThat(business.get前_保険_特定入所者介護サービス費等請求額(), is(DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_前_保険_特定入所者介護サービス費等請求額));
        }

        @Test
        public void 戻り値の前_公費１_サービス単位数は_設定した値と同じ前_公費１_サービス単位数を返す() {
            business = sut.set前_公費１_サービス単位数(DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_前_公費１_サービス単位数).build();
            assertThat(business.get前_公費１_サービス単位数(), is(DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_前_公費１_サービス単位数));
        }

        @Test
        public void 戻り値の前_公費１_請求額は_設定した値と同じ前_公費１_請求額を返す() {
            business = sut.set前_公費１_請求額(DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_前_公費１_請求額).build();
            assertThat(business.get前_公費１_請求額(), is(DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_前_公費１_請求額));
        }

        @Test
        public void 戻り値の前_公費１_本人負担額は_設定した値と同じ前_公費１_本人負担額を返す() {
            business = sut.set前_公費１_本人負担額(DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_前_公費１_本人負担額).build();
            assertThat(business.get前_公費１_本人負担額(), is(DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_前_公費１_本人負担額));
        }

        @Test
        public void 戻り値の前_公費１_緊急時施設療養費請求額は_設定した値と同じ前_公費１_緊急時施設療養費請求額を返す() {
            business = sut.set前_公費１_緊急時施設療養費請求額(DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_前_公費１_緊急時施設療養費請求額).build();
            assertThat(business.get前_公費１_緊急時施設療養費請求額(), is(DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_前_公費１_緊急時施設療養費請求額));
        }

        @Test
        public void 戻り値の前_公費１_特定診療費請求額は_設定した値と同じ前_公費１_特定診療費請求額を返す() {
            business = sut.set前_公費１_特定診療費請求額(DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_前_公費１_特定診療費請求額).build();
            assertThat(business.get前_公費１_特定診療費請求額(), is(DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_前_公費１_特定診療費請求額));
        }

        @Test
        public void 戻り値の前_公費１_特定入所者介護サービス費等請求額は_設定した値と同じ前_公費１_特定入所者介護サービス費等請求額を返す() {
            business = sut.set前_公費１_特定入所者介護サービス費等請求額(DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_前_公費１_特定入所者介護サービス費等請求額).build();
            assertThat(business.get前_公費１_特定入所者介護サービス費等請求額(), is(DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_前_公費１_特定入所者介護サービス費等請求額));
        }

        @Test
        public void 戻り値の前_公費２_サービス単位数は_設定した値と同じ前_公費２_サービス単位数を返す() {
            business = sut.set前_公費２_サービス単位数(DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_前_公費２_サービス単位数).build();
            assertThat(business.get前_公費２_サービス単位数(), is(DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_前_公費２_サービス単位数));
        }

        @Test
        public void 戻り値の前_公費２_請求額は_設定した値と同じ前_公費２_請求額を返す() {
            business = sut.set前_公費２_請求額(DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_前_公費２_請求額).build();
            assertThat(business.get前_公費２_請求額(), is(DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_前_公費２_請求額));
        }

        @Test
        public void 戻り値の前_公費２_本人負担額は_設定した値と同じ前_公費２_本人負担額を返す() {
            business = sut.set前_公費２_本人負担額(DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_前_公費２_本人負担額).build();
            assertThat(business.get前_公費２_本人負担額(), is(DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_前_公費２_本人負担額));
        }

        @Test
        public void 戻り値の前_公費２_緊急時施設療養費請求額は_設定した値と同じ前_公費２_緊急時施設療養費請求額を返す() {
            business = sut.set前_公費２_緊急時施設療養費請求額(DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_前_公費２_緊急時施設療養費請求額).build();
            assertThat(business.get前_公費２_緊急時施設療養費請求額(), is(DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_前_公費２_緊急時施設療養費請求額));
        }

        @Test
        public void 戻り値の前_公費２_特定診療費請求額は_設定した値と同じ前_公費２_特定診療費請求額を返す() {
            business = sut.set前_公費２_特定診療費請求額(DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_前_公費２_特定診療費請求額).build();
            assertThat(business.get前_公費２_特定診療費請求額(), is(DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_前_公費２_特定診療費請求額));
        }

        @Test
        public void 戻り値の前_公費２_特定入所者介護サービス費等請求額は_設定した値と同じ前_公費２_特定入所者介護サービス費等請求額を返す() {
            business = sut.set前_公費２特定入所者介護サービス費等請求額(DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_前_公費２_特定入所者介護サービス費等請求額).build();
            assertThat(business.get前_公費２_特定入所者介護サービス費等請求額(), is(DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_前_公費２_特定入所者介護サービス費等請求額));
        }

        @Test
        public void 戻り値の前_公費３_サービス単位数は_設定した値と同じ前_公費３_サービス単位数を返す() {
            business = sut.set前_公費３_サービス単位数(DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_前_公費３_サービス単位数).build();
            assertThat(business.get前_公費３_サービス単位数(), is(DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_前_公費３_サービス単位数));
        }

        @Test
        public void 戻り値の前_公費３_請求額は_設定した値と同じ前_公費３_請求額を返す() {
            business = sut.set前_公費３_請求額(DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_前_公費３_請求額).build();
            assertThat(business.get前_公費３_請求額(), is(DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_前_公費３_請求額));
        }

        @Test
        public void 戻り値の前_公費３_本人負担額は_設定した値と同じ前_公費３_本人負担額を返す() {
            business = sut.set前_公費３_本人負担額(DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_前_公費３_本人負担額).build();
            assertThat(business.get前_公費３_本人負担額(), is(DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_前_公費３_本人負担額));
        }

        @Test
        public void 戻り値の前_公費３_緊急時施設療養費請求額は_設定した値と同じ前_公費３_緊急時施設療養費請求額を返す() {
            business = sut.set前_公費３_緊急時施設療養費請求額(DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_前_公費３_緊急時施設療養費請求額).build();
            assertThat(business.get前_公費３_緊急時施設療養費請求額(), is(DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_前_公費３_緊急時施設療養費請求額));
        }

        @Test
        public void 戻り値の前_公費３_特定診療費請求額は_設定した値と同じ前_公費３_特定診療費請求額を返す() {
            business = sut.set前_公費３_特定診療費請求額(DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_前_公費３_特定診療費請求額).build();
            assertThat(business.get前_公費３_特定診療費請求額(), is(DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_前_公費３_特定診療費請求額));
        }

        @Test
        public void 戻り値の前_公費３_特定入所者介護サービス費等請求額は_設定した値と同じ前_公費３_特定入所者介護サービス費等請求額を返す() {
            business = sut.set前_公費３_特定入所者介護サービス費等請求額(DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_前_公費３_特定入所者介護サービス費等請求額).build();
            assertThat(business.get前_公費３_特定入所者介護サービス費等請求額(), is(DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_前_公費３_特定入所者介護サービス費等請求額));
        }

        @Test
        public void 戻り値の後_保険_サービス単位数は_設定した値と同じ後_保険_サービス単位数を返す() {
            business = sut.set後_保険_サービス単位数(DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_後_保険_サービス単位数).build();
            assertThat(business.get後_保険_サービス単位数(), is(DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_後_保険_サービス単位数));
        }

        @Test
        public void 戻り値の後_保険_請求額は_設定した値と同じ後_保険_請求額を返す() {
            business = sut.set後_保険_請求額(DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_後_保険_請求額).build();
            assertThat(business.get後_保険_請求額(), is(DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_後_保険_請求額));
        }

        @Test
        public void 戻り値の後_保険_利用者負担額は_設定した値と同じ後_保険_利用者負担額を返す() {
            business = sut.set後_保険_利用者負担額(DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_後_保険_利用者負担額).build();
            assertThat(business.get後_保険_利用者負担額(), is(DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_後_保険_利用者負担額));
        }

        @Test
        public void 戻り値の後_緊急時施設療養費請求額は_設定した値と同じ後_緊急時施設療養費請求額を返す() {
            business = sut.set後_緊急時施設療養費請求額(DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_後_緊急時施設療養費請求額).build();
            assertThat(business.get後_緊急時施設療養費請求額(), is(DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_後_緊急時施設療養費請求額));
        }

        @Test
        public void 戻り値の後_保険_特定診療費請求額は_設定した値と同じ後_保険_特定診療費請求額を返す() {
            business = sut.set後_保険_特定診療費請求額(DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_後_保険_特定診療費請求額).build();
            assertThat(business.get後_保険_特定診療費請求額(), is(DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_後_保険_特定診療費請求額));
        }

        @Test
        public void 戻り値の後_保険_特定入所者介護サービス費等請求額は_設定した値と同じ後_保険_特定入所者介護サービス費等請求額を返す() {
            business = sut.set後_保険_特定入所者介護サービス費等請求額(DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_後_保険_特定入所者介護サービス費等請求額).build();
            assertThat(business.get後_保険_特定入所者介護サービス費等請求額(), is(DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_後_保険_特定入所者介護サービス費等請求額));
        }

        @Test
        public void 戻り値の後_公費１_サービス単位数は_設定した値と同じ後_公費１_サービス単位数を返す() {
            business = sut.set後_公費１_サービス単位数(DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_後_公費１_サービス単位数).build();
            assertThat(business.get後_公費１_サービス単位数(), is(DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_後_公費１_サービス単位数));
        }

        @Test
        public void 戻り値の後_公費１_請求額は_設定した値と同じ後_公費１_請求額を返す() {
            business = sut.set後_公費１_請求額(DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_後_公費１_請求額).build();
            assertThat(business.get後_公費１_請求額(), is(DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_後_公費１_請求額));
        }

        @Test
        public void 戻り値の後_公費１_本人負担額は_設定した値と同じ後_公費１_本人負担額を返す() {
            business = sut.set後_公費１_本人負担額(DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_後_公費１_本人負担額).build();
            assertThat(business.get後_公費１_本人負担額(), is(DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_後_公費１_本人負担額));
        }

        @Test
        public void 戻り値の後_公費１_緊急時施設療養費請求額は_設定した値と同じ後_公費１_緊急時施設療養費請求額を返す() {
            business = sut.set後_公費１_緊急時施設療養費請求額(DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_後_公費１_緊急時施設療養費請求額).build();
            assertThat(business.get後_公費１_緊急時施設療養費請求額(), is(DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_後_公費１_緊急時施設療養費請求額));
        }

        @Test
        public void 戻り値の後_公費１_特定診療費請求額は_設定した値と同じ後_公費１_特定診療費請求額を返す() {
            business = sut.set後_公費１_特定診療費請求額(DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_後_公費１_特定診療費請求額).build();
            assertThat(business.get後_公費１_特定診療費請求額(), is(DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_後_公費１_特定診療費請求額));
        }

        @Test
        public void 戻り値の後_公費１_特定入所者介護サービス費等請求額は_設定した値と同じ後_公費１_特定入所者介護サービス費等請求額を返す() {
            business = sut.set後_公費１_特定入所者介護サービス費等請求額(DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_後_公費１_特定入所者介護サービス費等請求額).build();
            assertThat(business.get後_公費１_特定入所者介護サービス費等請求額(), is(DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_後_公費１_特定入所者介護サービス費等請求額));
        }

        @Test
        public void 戻り値の後_公費２_サービス単位数は_設定した値と同じ後_公費２_サービス単位数を返す() {
            business = sut.set後_公費２_サービス単位数(DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_後_公費２_サービス単位数).build();
            assertThat(business.get後_公費２_サービス単位数(), is(DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_後_公費２_サービス単位数));
        }

        @Test
        public void 戻り値の後_公費２_請求額は_設定した値と同じ後_公費２_請求額を返す() {
            business = sut.set後_公費２_請求額(DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_後_公費２_請求額).build();
            assertThat(business.get後_公費２_請求額(), is(DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_後_公費２_請求額));
        }

        @Test
        public void 戻り値の後_公費２_利用者負担額は_設定した値と同じ後_公費２_利用者負担額を返す() {
            business = sut.set後_公費２_利用者負担額(DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_後_公費２_利用者負担額).build();
            assertThat(business.get後_公費２_利用者負担額(), is(DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_後_公費２_利用者負担額));
        }

        @Test
        public void 戻り値の後_公費２_緊急時施設療養費請求額は_設定した値と同じ後_公費２_緊急時施設療養費請求額を返す() {
            business = sut.set後_公費２_緊急時施設療養費請求額(DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_後_公費２_緊急時施設療養費請求額).build();
            assertThat(business.get後_公費２_緊急時施設療養費請求額(), is(DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_後_公費２_緊急時施設療養費請求額));
        }

        @Test
        public void 戻り値の後_公費２_特定診療費請求額は_設定した値と同じ後_公費２_特定診療費請求額を返す() {
            business = sut.set後_公費２_特定診療費請求額(DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_後_公費２_特定診療費請求額).build();
            assertThat(business.get後_公費２_特定診療費請求額(), is(DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_後_公費２_特定診療費請求額));
        }

        @Test
        public void 戻り値の後_公費２_特定入所者介護サービス費等請求額は_設定した値と同じ後_公費２_特定入所者介護サービス費等請求額を返す() {
            business = sut.set後_公費２_特定入所者介護サービス費等請求額(DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_後_公費２特定入所者介護サービス費等請求額).build();
            assertThat(business.get後_公費２_特定入所者介護サービス費等請求額(), is(DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_後_公費２特定入所者介護サービス費等請求額));
        }

        @Test
        public void 戻り値の後_公費３_サービス単位数は_設定した値と同じ後_公費３_サービス単位数を返す() {
            business = sut.set後_公費３_サービス単位数(DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_後_公費３_サービス単位数).build();
            assertThat(business.get後_公費３_サービス単位数(), is(DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_後_公費３_サービス単位数));
        }

        @Test
        public void 戻り値の後_公費３_請求額は_設定した値と同じ後_公費３_請求額を返す() {
            business = sut.set後_公費３_請求額(DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_後_公費３_請求額).build();
            assertThat(business.get後_公費３_請求額(), is(DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_後_公費３_請求額));
        }

        @Test
        public void 戻り値の後_公費３_利用者負担額は_設定した値と同じ後_公費３_利用者負担額を返す() {
            business = sut.set後_公費３_利用者負担額(DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_後_公費３_利用者負担額).build();
            assertThat(business.get後_公費３_利用者負担額(), is(DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_後_公費３_利用者負担額));
        }

        @Test
        public void 戻り値の後_公費３_緊急時施設療養費請求額は_設定した値と同じ後_公費３_緊急時施設療養費請求額を返す() {
            business = sut.set後_公費３_緊急時施設療養費請求額(DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_後_公費３_緊急時施設療養費請求額).build();
            assertThat(business.get後_公費３_緊急時施設療養費請求額(), is(DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_後_公費３_緊急時施設療養費請求額));
        }

        @Test
        public void 戻り値の後_公費３_特定診療費請求額は_設定した値と同じ後_公費３_特定診療費請求額を返す() {
            business = sut.set後_公費３_特定診療費請求額(DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_後_公費３_特定診療費請求額).build();
            assertThat(business.get後_公費３_特定診療費請求額(), is(DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_後_公費３_特定診療費請求額));
        }

        @Test
        public void 戻り値の後_公費３_特定入所者介護サービス費等請求額は_設定した値と同じ後_公費３_特定入所者介護サービス費等請求額を返す() {
            business = sut.set後_公費３_特定入所者介護サービス費等請求額(DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_後_公費３_特定入所者介護サービス費等請求額).build();
            assertThat(business.get後_公費３_特定入所者介護サービス費等請求額(), is(DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_後_公費３_特定入所者介護サービス費等請求額));
        }

        @Test
        public void 戻り値の警告区分コードは_設定した値と同じ警告区分コードを返す() {
            business = sut.set警告区分コード(DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_警告区分コード).build();
            assertThat(business.get警告区分コード(), is(DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_警告区分コード));
        }

        @Test
        public void 戻り値の審査年月は_設定した値と同じ審査年月を返す() {
            business = sut.set審査年月(DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_審査年月).build();
            assertThat(business.get審査年月(), is(DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_審査年月));
        }

        @Test
        public void 戻り値の整理番号は_設定した値と同じ整理番号を返す() {
            business = sut.set整理番号(DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_整理番号).build();
            assertThat(business.get整理番号(), is(DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_整理番号));
        }

        @Test
        public void 戻り値の送付年月は_設定した値と同じ送付年月を返す() {
            business = sut.set送付年月(DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_送付年月).build();
            assertThat(business.get送付年月(), is(DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_送付年月));
        }

        @Test
        public void 戻り値の取込年月は_設定した値と同じ取込年月を返す() {
            business = sut.set取込年月(DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_取込年月).build();
            assertThat(business.get取込年月(), is(DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_取込年月));
        }

        @Test
        public void 戻り値の独自作成区分は_設定した値と同じ独自作成区分を返す() {
            business = sut.set独自作成区分(DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_独自作成区分).build();
            assertThat(business.get独自作成区分(), is(DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_独自作成区分));
        }

        @Test
        public void 戻り値の保険者保有給付実績情報削除済フラグは_設定した値と同じ保険者保有給付実績情報削除済フラグを返す() {
            business = sut.set保険者保有給付実績情報削除済フラグ(DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_保険者保有給付実績情報削除済フラグ).build();
            assertThat(business.is保険者保有給付実績情報削除済フラグ(), is(DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_保険者保有給付実績情報削除済フラグ));
        }

    }
}
