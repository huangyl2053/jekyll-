/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.model;

import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT3017KyufujissekiKihonEntityGenerator;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link KyufujissekiKihonModel}のテストクラスです。
 *
 * @author LDNS 鄭雪双
 */
@RunWith(Enclosed.class)
public class KyufujissekiKihonModelTest extends DbzTestBase {

    public static class getterSetterTest extends DbzTestBase {

        private static KyufujissekiKihonModel sut;

        @BeforeClass
        public static void test() {
            sut = new KyufujissekiKihonModel();
        }

        @Test
        public void 戻り値の交換情報識別番号は_設定した値と同じ交換情報識別番号を返す() {
            sut.set交換情報識別番号(DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_交換情報識別番号);
            assertThat(sut.get交換情報識別番号(), is(DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_交換情報識別番号));
        }

        @Test
        public void 戻り値の入力識別番号は_設定した値と同じ入力識別番号を返す() {
            sut.set入力識別番号(DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_入力識別番号);
            assertThat(sut.get入力識別番号(), is(DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_入力識別番号));
        }

        @Test
        public void 戻り値のレコード種別コードは_設定した値と同じレコード種別コードを返す() {
            sut.setレコード種別コード(DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_レコード種別コード);
            assertThat(sut.getレコード種別コード(), is(DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_レコード種別コード));
        }

        @Test
        public void 戻り値の給付実績情報作成区分コードは_設定した値と同じ給付実績情報作成区分コードを返す() {
            sut.set給付実績情報作成区分コード(DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_給付実績情報作成区分コード);
            assertThat(sut.get給付実績情報作成区分コード(), is(DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_給付実績情報作成区分コード));
        }

        @Test
        public void 戻り値の証記載保険者番号は_設定した値と同じ証記載保険者番号を返す() {
            sut.set証記載保険者番号(DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_証記載保険者番号);
            assertThat(sut.get証記載保険者番号(), is(DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_証記載保険者番号));
        }

        @Test
        public void 戻り値の被保険者番号は_設定した値と同じ被保険者番号を返す() {
            sut.set被保険者番号(DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_被保険者番号);
            assertThat(sut.get被保険者番号(), is(DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_被保険者番号));
        }

        @Test
        public void 戻り値のサービス提供年月は_設定した値と同じサービス提供年月を返す() {
            sut.setサービス提供年月(DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_サービス提供年月);
            assertThat(sut.getサービス提供年月(), is(DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_サービス提供年月));
        }

        @Test
        public void 戻り値の給付実績区分コードは_設定した値と同じ給付実績区分コードを返す() {
            sut.set給付実績区分コード(DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_給付実績区分コード);
            assertThat(sut.get給付実績区分コード(), is(DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_給付実績区分コード));
        }

        @Test
        public void 戻り値の事業所番号は_設定した値と同じ事業所番号を返す() {
            sut.set事業所番号(DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_事業所番号);
            assertThat(sut.get事業所番号(), is(DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_事業所番号));
        }

        @Test
        public void 戻り値の通し番号は_設定した値と同じ通し番号を返す() {
            sut.set通し番号(DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_通し番号);
            assertThat(sut.get通し番号(), is(DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_通し番号));
        }

        @Test
        public void 戻り値の公費１_負担者番号は_設定した値と同じ公費１_負担者番号を返す() {
            sut.set公費１_負担者番号(DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_公費１_負担者番号);
            assertThat(sut.get公費１_負担者番号(), is(DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_公費１_負担者番号));
        }

        @Test
        public void 戻り値の公費１_受給者番号は_設定した値と同じ公費１_受給者番号を返す() {
            sut.set公費１_受給者番号(DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_公費１_受給者番号);
            assertThat(sut.get公費１_受給者番号(), is(DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_公費１_受給者番号));
        }

        @Test
        public void 戻り値の公費２_負担者番号は_設定した値と同じ公費２_負担者番号を返す() {
            sut.set公費２_負担者番号(DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_公費２_負担者番号);
            assertThat(sut.get公費２_負担者番号(), is(DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_公費２_負担者番号));
        }

        @Test
        public void 戻り値の公費２_受給者番号は_設定した値と同じ公費２_受給者番号を返す() {
            sut.set公費２_受給者番号(DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_公費２_受給者番号);
            assertThat(sut.get公費２_受給者番号(), is(DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_公費２_受給者番号));
        }

        @Test
        public void 戻り値の公費３_負担者番号は_設定した値と同じ公費３_負担者番号を返す() {
            sut.set公費３_負担者番号(DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_公費３_負担者番号);
            assertThat(sut.get公費３_負担者番号(), is(DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_公費３_負担者番号));
        }

        @Test
        public void 戻り値の公費３_受給者番号は_設定した値と同じ公費３_受給者番号を返す() {
            sut.set公費３_受給者番号(DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_公費３_受給者番号);
            assertThat(sut.get公費３_受給者番号(), is(DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_公費３_受給者番号));
        }

        @Test
        public void 戻り値の生年月日は_設定した値と同じ生年月日を返す() {
            sut.set生年月日(DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_生年月日);
            assertThat(sut.get生年月日(), is(DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_生年月日));
        }

        @Test
        public void 戻り値の性別コードは_設定した値と同じ性別コードを返す() {
            sut.set性別コード(DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_性別コード);
            assertThat(sut.get性別コード(), is(DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_性別コード));
        }

        @Test
        public void 戻り値の要介護状態区分コードは_設定した値と同じ要介護状態区分コードを返す() {
            sut.set要介護状態区分コード(DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_要介護状態区分コード);
            assertThat(sut.get要介護状態区分コード(), is(DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_要介護状態区分コード));
        }

        @Test
        public void 戻り値の旧措置入所者特例コードは_設定した値と同じ旧措置入所者特例コードを返す() {
            sut.set旧措置入所者特例コード(DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_旧措置入所者特例コード);
            assertThat(sut.get旧措置入所者特例コード(), is(DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_旧措置入所者特例コード));
        }

        @Test
        public void 戻り値の認定有効期間_開始年月日は_設定した値と同じ認定有効期間_開始年月日を返す() {
            sut.set認定有効期間_開始年月日(DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_認定有効期間_開始年月日);
            assertThat(sut.get認定有効期間_開始年月日(), is(DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_認定有効期間_開始年月日));
        }

        @Test
        public void 戻り値の認定有功期間_終了年月日は_設定した値と同じ認定有功期間_終了年月日を返す() {
            sut.set認定有功期間_終了年月日(DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_認定有功期間_終了年月日);
            assertThat(sut.get認定有功期間_終了年月日(), is(DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_認定有功期間_終了年月日));
        }

        @Test
        public void 戻り値の老人保健市町村番号は_設定した値と同じ老人保健市町村番号を返す() {
            sut.set老人保健市町村番号(DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_老人保健市町村番号);
            assertThat(sut.get老人保健市町村番号(), is(DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_老人保健市町村番号));
        }

        @Test
        public void 戻り値の老人保健受給者番号は_設定した値と同じ老人保健受給者番号を返す() {
            sut.set老人保健受給者番号(DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_老人保健受給者番号);
            assertThat(sut.get老人保健受給者番号(), is(DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_老人保健受給者番号));
        }

        @Test
        public void 戻り値の保険者番号_後期は_設定した値と同じ保険者番号_後期を返す() {
            sut.set保険者番号_後期(DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_保険者番号_後期);
            assertThat(sut.get保険者番号_後期(), is(DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_保険者番号_後期));
        }

        @Test
        public void 戻り値の被保険者番号_後期は_設定した値と同じ被保険者番号_後期を返す() {
            sut.set被保険者番号_後期(DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_被保険者番号_後期);
            assertThat(sut.get被保険者番号_後期(), is(DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_被保険者番号_後期));
        }

        @Test
        public void 戻り値の保険者番号_国保は_設定した値と同じ保険者番号_国保を返す() {
            sut.set保険者番号_国保(DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_保険者番号_国保);
            assertThat(sut.get保険者番号_国保(), is(DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_保険者番号_国保));
        }

        @Test
        public void 戻り値の被保険者証番号_国保は_設定した値と同じ被保険者証番号_国保を返す() {
            sut.set被保険者証番号_国保(DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_被保険者証番号_国保);
            assertThat(sut.get被保険者証番号_国保(), is(DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_被保険者証番号_国保));
        }

        @Test
        public void 戻り値の個人番号_国保は_設定した値と同じ個人番号_国保を返す() {
            sut.set個人番号_国保(DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_個人番号_国保);
            assertThat(sut.get個人番号_国保(), is(DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_個人番号_国保));
        }

        @Test
        public void 戻り値の居宅サービス計画作成区分コードは_設定した値と同じ居宅サービス計画作成区分コードを返す() {
            sut.set居宅サービス計画作成区分コード(DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_居宅サービス計画作成区分コード);
            assertThat(sut.get居宅サービス計画作成区分コード(), is(DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_居宅サービス計画作成区分コード));
        }

        @Test
        public void 戻り値の事業所番号_居宅介護支援事業所等は_設定した値と同じ事業所番号_居宅介護支援事業所等を返す() {
            sut.set事業所番号_居宅介護支援事業所等(DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_事業所番号_居宅介護支援事業所等);
            assertThat(sut.get事業所番号_居宅介護支援事業所等(), is(DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_事業所番号_居宅介護支援事業所等));
        }

        @Test
        public void 戻り値の開始年月日は_設定した値と同じ開始年月日を返す() {
            sut.set開始年月日(DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_開始年月日);
            assertThat(sut.get開始年月日(), is(DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_開始年月日));
        }

        @Test
        public void 戻り値の中止年月日は_設定した値と同じ中止年月日を返す() {
            sut.set中止年月日(DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_中止年月日);
            assertThat(sut.get中止年月日(), is(DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_中止年月日));
        }

        @Test
        public void 戻り値の中止理由_入所_院前の状況コードは_設定した値と同じ中止理由_入所_院前の状況コードを返す() {
            sut.set中止理由_入所_院前の状況コード(DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_中止理由_入所_院前の状況コード);
            assertThat(sut.get中止理由_入所_院前の状況コード(), is(DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_中止理由_入所_院前の状況コード));
        }

        @Test
        public void 戻り値の入所_院年月日は_設定した値と同じ入所_院年月日を返す() {
            sut.set入所_院年月日(DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_入所_院年月日);
            assertThat(sut.get入所_院年月日(), is(DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_入所_院年月日));
        }

        @Test
        public void 戻り値の退所_院年月日は_設定した値と同じ退所_院年月日を返す() {
            sut.set退所_院年月日(DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_退所_院年月日);
            assertThat(sut.get退所_院年月日(), is(DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_退所_院年月日));
        }

        @Test
        public void 戻り値の入所_院実日数は_設定した値と同じ入所_院実日数を返す() {
            sut.set入所_院実日数(DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_入所_院実日数);
            assertThat(sut.get入所_院実日数(), is(DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_入所_院実日数));
        }

        @Test
        public void 戻り値の外泊日数は_設定した値と同じ外泊日数を返す() {
            sut.set外泊日数(DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_外泊日数);
            assertThat(sut.get外泊日数(), is(DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_外泊日数));
        }

        @Test
        public void 戻り値の退所_院後の状態コードは_設定した値と同じ退所_院後の状態コードを返す() {
            sut.set退所_院後の状態コード(DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_退所_院後の状態コード);
            assertThat(sut.get退所_院後の状態コード(), is(DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_退所_院後の状態コード));
        }

        @Test
        public void 戻り値の保険給付率は_設定した値と同じ保険給付率を返す() {
            sut.set保険給付率(DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_保険給付率);
            assertThat(sut.get保険給付率(), is(DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_保険給付率));
        }

        @Test
        public void 戻り値の公費１給付率は_設定した値と同じ公費１給付率を返す() {
            sut.set公費１給付率(DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_公費１給付率);
            assertThat(sut.get公費１給付率(), is(DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_公費１給付率));
        }

        @Test
        public void 戻り値の公費２給付率は_設定した値と同じ公費２給付率を返す() {
            sut.set公費２給付率(DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_公費２給付率);
            assertThat(sut.get公費２給付率(), is(DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_公費２給付率));
        }

        @Test
        public void 戻り値の公費３給付率は_設定した値と同じ公費３給付率を返す() {
            sut.set公費３給付率(DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_公費３給付率);
            assertThat(sut.get公費３給付率(), is(DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_公費３給付率));
        }

        @Test
        public void 戻り値の前_保険_サービス単位数は_設定した値と同じ前_保険_サービス単位数を返す() {
            sut.set前_保険_サービス単位数(DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_前_保険_サービス単位数);
            assertThat(sut.get前_保険_サービス単位数(), is(DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_前_保険_サービス単位数));
        }

        @Test
        public void 戻り値の前_保険_請求額は_設定した値と同じ前_保険_請求額を返す() {
            sut.set前_保険_請求額(DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_前_保険_請求額);
            assertThat(sut.get前_保険_請求額(), is(DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_前_保険_請求額));
        }

        @Test
        public void 戻り値の前_保険_利用者負担額は_設定した値と同じ前_保険_利用者負担額を返す() {
            sut.set前_保険_利用者負担額(DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_前_保険_利用者負担額);
            assertThat(sut.get前_保険_利用者負担額(), is(DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_前_保険_利用者負担額));
        }

        @Test
        public void 戻り値の前_保険_緊急時施設療養費請求額は_設定した値と同じ前_保険_緊急時施設療養費請求額を返す() {
            sut.set前_保険_緊急時施設療養費請求額(DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_前_保険_緊急時施設療養費請求額);
            assertThat(sut.get前_保険_緊急時施設療養費請求額(), is(DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_前_保険_緊急時施設療養費請求額));
        }

        @Test
        public void 戻り値の前_保険_特定診療費請求額は_設定した値と同じ前_保険_特定診療費請求額を返す() {
            sut.set前_保険_特定診療費請求額(DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_前_保険_特定診療費請求額);
            assertThat(sut.get前_保険_特定診療費請求額(), is(DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_前_保険_特定診療費請求額));
        }

        @Test
        public void 戻り値の前_保険_特定入所者介護サービス費等請求額は_設定した値と同じ前_保険_特定入所者介護サービス費等請求額を返す() {
            sut.set前_保険_特定入所者介護サービス費等請求額(DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_前_保険_特定入所者介護サービス費等請求額);
            assertThat(sut.get前_保険_特定入所者介護サービス費等請求額(), is(DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_前_保険_特定入所者介護サービス費等請求額));
        }

        @Test
        public void 戻り値の前_公費１_サービス単位数は_設定した値と同じ前_公費１_サービス単位数を返す() {
            sut.set前_公費１_サービス単位数(DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_前_公費１_サービス単位数);
            assertThat(sut.get前_公費１_サービス単位数(), is(DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_前_公費１_サービス単位数));
        }

        @Test
        public void 戻り値の前_公費１_請求額は_設定した値と同じ前_公費１_請求額を返す() {
            sut.set前_公費１_請求額(DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_前_公費１_請求額);
            assertThat(sut.get前_公費１_請求額(), is(DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_前_公費１_請求額));
        }

        @Test
        public void 戻り値の前_公費１_本人負担額は_設定した値と同じ前_公費１_本人負担額を返す() {
            sut.set前_公費１_本人負担額(DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_前_公費１_本人負担額);
            assertThat(sut.get前_公費１_本人負担額(), is(DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_前_公費１_本人負担額));
        }

        @Test
        public void 戻り値の前_公費１_緊急時施設療養費請求額は_設定した値と同じ前_公費１_緊急時施設療養費請求額を返す() {
            sut.set前_公費１_緊急時施設療養費請求額(DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_前_公費１_緊急時施設療養費請求額);
            assertThat(sut.get前_公費１_緊急時施設療養費請求額(), is(DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_前_公費１_緊急時施設療養費請求額));
        }

        @Test
        public void 戻り値の前_公費１_特定診療費請求額は_設定した値と同じ前_公費１_特定診療費請求額を返す() {
            sut.set前_公費１_特定診療費請求額(DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_前_公費１_特定診療費請求額);
            assertThat(sut.get前_公費１_特定診療費請求額(), is(DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_前_公費１_特定診療費請求額));
        }

        @Test
        public void 戻り値の前_公費１_特定入所者介護サービス費等請求額は_設定した値と同じ前_公費１_特定入所者介護サービス費等請求額を返す() {
            sut.set前_公費１_特定入所者介護サービス費等請求額(DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_前_公費１_特定入所者介護サービス費等請求額);
            assertThat(sut.get前_公費１_特定入所者介護サービス費等請求額(), is(DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_前_公費１_特定入所者介護サービス費等請求額));
        }

        @Test
        public void 戻り値の前_公費２_サービス単位数は_設定した値と同じ前_公費２_サービス単位数を返す() {
            sut.set前_公費２_サービス単位数(DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_前_公費２_サービス単位数);
            assertThat(sut.get前_公費２_サービス単位数(), is(DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_前_公費２_サービス単位数));
        }

        @Test
        public void 戻り値の前_公費２_請求額は_設定した値と同じ前_公費２_請求額を返す() {
            sut.set前_公費２_請求額(DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_前_公費２_請求額);
            assertThat(sut.get前_公費２_請求額(), is(DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_前_公費２_請求額));
        }

        @Test
        public void 戻り値の前_公費２_本人負担額は_設定した値と同じ前_公費２_本人負担額を返す() {
            sut.set前_公費２_本人負担額(DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_前_公費２_本人負担額);
            assertThat(sut.get前_公費２_本人負担額(), is(DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_前_公費２_本人負担額));
        }

        @Test
        public void 戻り値の前_公費２_緊急時施設療養費請求額は_設定した値と同じ前_公費２_緊急時施設療養費請求額を返す() {
            sut.set前_公費２_緊急時施設療養費請求額(DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_前_公費２_緊急時施設療養費請求額);
            assertThat(sut.get前_公費２_緊急時施設療養費請求額(), is(DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_前_公費２_緊急時施設療養費請求額));
        }

        @Test
        public void 戻り値の前_公費２_特定診療費請求額は_設定した値と同じ前_公費２_特定診療費請求額を返す() {
            sut.set前_公費２_特定診療費請求額(DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_前_公費２_特定診療費請求額);
            assertThat(sut.get前_公費２_特定診療費請求額(), is(DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_前_公費２_特定診療費請求額));
        }

        @Test
        public void 戻り値の前_公費２_特定入所者介護サービス費等請求額は_設定した値と同じ前_公費２_特定入所者介護サービス費等請求額を返す() {
            sut.set前_公費２_特定入所者介護サービス費等請求額(DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_前_公費２_特定入所者介護サービス費等請求額);
            assertThat(sut.get前_公費２_特定入所者介護サービス費等請求額(), is(DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_前_公費２_特定入所者介護サービス費等請求額));
        }

        @Test
        public void 戻り値の前_公費３_サービス単位数は_設定した値と同じ前_公費３_サービス単位数を返す() {
            sut.set前_公費３_サービス単位数(DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_前_公費３_サービス単位数);
            assertThat(sut.get前_公費３_サービス単位数(), is(DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_前_公費３_サービス単位数));
        }

        @Test
        public void 戻り値の前_公費３_請求額は_設定した値と同じ前_公費３_請求額を返す() {
            sut.set前_公費３_請求額(DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_前_公費３_請求額);
            assertThat(sut.get前_公費３_請求額(), is(DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_前_公費３_請求額));
        }

        @Test
        public void 戻り値の前_公費３_本人負担額は_設定した値と同じ前_公費３_本人負担額を返す() {
            sut.set前_公費３_本人負担額(DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_前_公費３_本人負担額);
            assertThat(sut.get前_公費３_本人負担額(), is(DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_前_公費３_本人負担額));
        }

        @Test
        public void 戻り値の前_公費３_緊急時施設療養費請求額は_設定した値と同じ前_公費３_緊急時施設療養費請求額を返す() {
            sut.set前_公費３_緊急時施設療養費請求額(DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_前_公費３_緊急時施設療養費請求額);
            assertThat(sut.get前_公費３_緊急時施設療養費請求額(), is(DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_前_公費３_緊急時施設療養費請求額));
        }

        @Test
        public void 戻り値の前_公費３_特定診療費請求額は_設定した値と同じ前_公費３_特定診療費請求額を返す() {
            sut.set前_公費３_特定診療費請求額(DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_前_公費３_特定診療費請求額);
            assertThat(sut.get前_公費３_特定診療費請求額(), is(DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_前_公費３_特定診療費請求額));
        }

        @Test
        public void 戻り値の前_公費３_特定入所者介護サービス費等請求額は_設定した値と同じ前_公費３_特定入所者介護サービス費等請求額を返す() {
            sut.set前_公費３_特定入所者介護サービス費等請求額(DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_前_公費３_特定入所者介護サービス費等請求額);
            assertThat(sut.get前_公費３_特定入所者介護サービス費等請求額(), is(DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_前_公費３_特定入所者介護サービス費等請求額));
        }

        @Test
        public void 戻り値の後_保険_サービス単位数は_設定した値と同じ後_保険_サービス単位数を返す() {
            sut.set後_保険_サービス単位数(DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_後_保険_サービス単位数);
            assertThat(sut.get後_保険_サービス単位数(), is(DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_後_保険_サービス単位数));
        }

        @Test
        public void 戻り値の後_保険_請求額は_設定した値と同じ後_保険_請求額を返す() {
            sut.set後_保険_請求額(DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_後_保険_請求額);
            assertThat(sut.get後_保険_請求額(), is(DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_後_保険_請求額));
        }

        @Test
        public void 戻り値の後_保険_利用者負担額は_設定した値と同じ後_保険_利用者負担額を返す() {
            sut.set後_保険_利用者負担額(DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_後_保険_利用者負担額);
            assertThat(sut.get後_保険_利用者負担額(), is(DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_後_保険_利用者負担額));
        }

        @Test
        public void 戻り値の後_緊急時施設療養費請求額は_設定した値と同じ後_緊急時施設療養費請求額を返す() {
            sut.set後_緊急時施設療養費請求額(DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_後_緊急時施設療養費請求額);
            assertThat(sut.get後_緊急時施設療養費請求額(), is(DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_後_緊急時施設療養費請求額));
        }

        @Test
        public void 戻り値の後_保険_特定診療費請求額は_設定した値と同じ後_保険_特定診療費請求額を返す() {
            sut.set後_保険_特定診療費請求額(DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_後_保険_特定診療費請求額);
            assertThat(sut.get後_保険_特定診療費請求額(), is(DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_後_保険_特定診療費請求額));
        }

        @Test
        public void 戻り値の後_保険_特定入所者介護サービス費等請求額は_設定した値と同じ後_保険_特定入所者介護サービス費等請求額を返す() {
            sut.set後_保険_特定入所者介護サービス費等請求額(DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_後_保険_特定入所者介護サービス費等請求額);
            assertThat(sut.get後_保険_特定入所者介護サービス費等請求額(), is(DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_後_保険_特定入所者介護サービス費等請求額));
        }

        @Test
        public void 戻り値の後_公費１_サービス単位数は_設定した値と同じ後_公費１_サービス単位数を返す() {
            sut.set後_公費１_サービス単位数(DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_後_公費１_サービス単位数);
            assertThat(sut.get後_公費１_サービス単位数(), is(DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_後_公費１_サービス単位数));
        }

        @Test
        public void 戻り値の後_公費１_請求額は_設定した値と同じ後_公費１_請求額を返す() {
            sut.set後_公費１_請求額(DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_後_公費１_請求額);
            assertThat(sut.get後_公費１_請求額(), is(DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_後_公費１_請求額));
        }

        @Test
        public void 戻り値の後_公費１_本人負担額は_設定した値と同じ後_公費１_本人負担額を返す() {
            sut.set後_公費１_本人負担額(DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_後_公費１_本人負担額);
            assertThat(sut.get後_公費１_本人負担額(), is(DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_後_公費１_本人負担額));
        }

        @Test
        public void 戻り値の後_公費１_緊急時施設療養費請求額は_設定した値と同じ後_公費１_緊急時施設療養費請求額を返す() {
            sut.set後_公費１_緊急時施設療養費請求額(DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_後_公費１_緊急時施設療養費請求額);
            assertThat(sut.get後_公費１_緊急時施設療養費請求額(), is(DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_後_公費１_緊急時施設療養費請求額));
        }

        @Test
        public void 戻り値の後_公費１_特定診療費請求額は_設定した値と同じ後_公費１_特定診療費請求額を返す() {
            sut.set後_公費１_特定診療費請求額(DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_後_公費１_特定診療費請求額);
            assertThat(sut.get後_公費１_特定診療費請求額(), is(DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_後_公費１_特定診療費請求額));
        }

        @Test
        public void 戻り値の後_公費１_特定入所者介護サービス費等請求額は_設定した値と同じ後_公費１_特定入所者介護サービス費等請求額を返す() {
            sut.set後_公費１_特定入所者介護サービス費等請求額(DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_後_公費１_特定入所者介護サービス費等請求額);
            assertThat(sut.get後_公費１_特定入所者介護サービス費等請求額(), is(DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_後_公費１_特定入所者介護サービス費等請求額));
        }

        @Test
        public void 戻り値の後_公費２_サービス単位数は_設定した値と同じ後_公費２_サービス単位数を返す() {
            sut.set後_公費２_サービス単位数(DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_後_公費２_サービス単位数);
            assertThat(sut.get後_公費２_サービス単位数(), is(DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_後_公費２_サービス単位数));
        }

        @Test
        public void 戻り値の後_公費２_請求額は_設定した値と同じ後_公費２_請求額を返す() {
            sut.set後_公費２_請求額(DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_後_公費２_請求額);
            assertThat(sut.get後_公費２_請求額(), is(DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_後_公費２_請求額));
        }

        @Test
        public void 戻り値の後_公費２_利用者負担額は_設定した値と同じ後_公費２_利用者負担額を返す() {
            sut.set後_公費２_利用者負担額(DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_後_公費２_利用者負担額);
            assertThat(sut.get後_公費２_利用者負担額(), is(DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_後_公費２_利用者負担額));
        }

        @Test
        public void 戻り値の後_公費２_緊急時施設療養費請求額は_設定した値と同じ後_公費２_緊急時施設療養費請求額を返す() {
            sut.set後_公費２_緊急時施設療養費請求額(DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_後_公費２_緊急時施設療養費請求額);
            assertThat(sut.get後_公費２_緊急時施設療養費請求額(), is(DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_後_公費２_緊急時施設療養費請求額));
        }

        @Test
        public void 戻り値の後_公費２_特定診療費請求額は_設定した値と同じ後_公費２_特定診療費請求額を返す() {
            sut.set後_公費２_特定診療費請求額(DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_後_公費２_特定診療費請求額);
            assertThat(sut.get後_公費２_特定診療費請求額(), is(DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_後_公費２_特定診療費請求額));
        }

        @Test
        public void 戻り値の後_公費２_特定入所者介護サービス費等請求額は_設定した値と同じ後_公費２_特定入所者介護サービス費等請求額を返す() {
            sut.set後_公費２_特定入所者介護サービス費等請求額(DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_後_公費２_特定入所者介護サービス費等請求額);
            assertThat(sut.get後_公費２_特定入所者介護サービス費等請求額(), is(DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_後_公費２_特定入所者介護サービス費等請求額));
        }

        @Test
        public void 戻り値の後_公費３_サービス単位数は_設定した値と同じ後_公費３_サービス単位数を返す() {
            sut.set後_公費３_サービス単位数(DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_後_公費３_サービス単位数);
            assertThat(sut.get後_公費３_サービス単位数(), is(DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_後_公費３_サービス単位数));
        }

        @Test
        public void 戻り値の後_公費３_請求額は_設定した値と同じ後_公費３_請求額を返す() {
            sut.set後_公費３_請求額(DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_後_公費３_請求額);
            assertThat(sut.get後_公費３_請求額(), is(DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_後_公費３_請求額));
        }

        @Test
        public void 戻り値の後_公費３_利用者負担額は_設定した値と同じ後_公費３_利用者負担額を返す() {
            sut.set後_公費３_利用者負担額(DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_後_公費３_利用者負担額);
            assertThat(sut.get後_公費３_利用者負担額(), is(DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_後_公費３_利用者負担額));
        }

        @Test
        public void 戻り値の後_公費３_緊急時施設療養費請求額は_設定した値と同じ後_公費３_緊急時施設療養費請求額を返す() {
            sut.set後_公費３_緊急時施設療養費請求額(DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_後_公費３_緊急時施設療養費請求額);
            assertThat(sut.get後_公費３_緊急時施設療養費請求額(), is(DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_後_公費３_緊急時施設療養費請求額));
        }

        @Test
        public void 戻り値の後_公費３_特定診療費請求額は_設定した値と同じ後_公費３_特定診療費請求額を返す() {
            sut.set後_公費３_特定診療費請求額(DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_後_公費３_特定診療費請求額);
            assertThat(sut.get後_公費３_特定診療費請求額(), is(DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_後_公費３_特定診療費請求額));
        }

        @Test
        public void 戻り値の後_公費３_特定入所者介護サービス費等請求額は_設定した値と同じ後_公費３_特定入所者介護サービス費等請求額を返す() {
            sut.set後_公費３_特定入所者介護サービス費等請求額(DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_後_公費３_特定入所者介護サービス費等請求額);
            assertThat(sut.get後_公費３_特定入所者介護サービス費等請求額(), is(DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_後_公費３_特定入所者介護サービス費等請求額));
        }

        @Test
        public void 戻り値の警告区分コードは_設定した値と同じ警告区分コードを返す() {
            sut.set警告区分コード(DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_警告区分コード);
            assertThat(sut.get警告区分コード(), is(DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_警告区分コード));
        }

        @Test
        public void 戻り値の審査年月は_設定した値と同じ審査年月を返す() {
            sut.set審査年月(DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_審査年月);
            assertThat(sut.get審査年月(), is(DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_審査年月));
        }

        @Test
        public void 戻り値の整理番号は_設定した値と同じ整理番号を返す() {
            sut.set整理番号(DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_整理番号);
            assertThat(sut.get整理番号(), is(DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_整理番号));
        }

        @Test
        public void 戻り値の送付年月は_設定した値と同じ送付年月を返す() {
            sut.set送付年月(DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_送付年月);
            assertThat(sut.get送付年月(), is(DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_送付年月));
        }

        @Test
        public void 戻り値の取込年月は_設定した値と同じ取込年月を返す() {
            sut.set取込年月(DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_取込年月);
            assertThat(sut.get取込年月(), is(DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_取込年月));
        }

        @Test
        public void 戻り値の独自作成区分は_設定した値と同じ独自作成区分を返す() {
            sut.set独自作成区分(DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_独自作成区分);
            assertThat(sut.get独自作成区分(), is(DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_独自作成区分));
        }

        @Test
        public void 戻り値の保険者保有給付実績情報削除済フラグは_設定した値と同じ保険者保有給付実績情報削除済フラグを返す() {
            sut.set保険者保有給付実績情報削除済フラグ(DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_保険者保有給付実績情報削除済フラグ);
            assertThat(sut.get保険者保有給付実績情報削除済フラグ(), is(DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_保険者保有給付実績情報削除済フラグ));
        }
    }

    public static class getStateTest extends DbzTestBase {

        @Test
        public void 状態Addedの取得確認() {
            KyufujissekiKihonModel sut = new KyufujissekiKihonModel();

            assertThat(sut.getState(), is(EntityDataState.Added));
        }

        @Test
        public void 状態Modifinedの取得確認() {
            KyufujissekiKihonModel sut = new KyufujissekiKihonModel();
            sut.setEntity(DbT3017KyufujissekiKihonEntityGenerator.createDbT3017KyufujissekiKihonEntity());

            sut.getEntity().initializeMd5();

            // 主キー以外の項目を変更してください
//            sut.getEntity().setXXX(new XXX());
//            assertThat(sut.getState(), is(EntityDataState.Modified));
        }

        @Test
        public void 状態Unchangedの取得確認() {
            KyufujissekiKihonModel sut = new KyufujissekiKihonModel();
            sut.setEntity(DbT3017KyufujissekiKihonEntityGenerator.createDbT3017KyufujissekiKihonEntity());

            sut.getEntity().initializeMd5();

            assertThat(sut.getState(), is(EntityDataState.Unchanged));
        }

        @Test
        public void 状態Deletedの取得確認() {
            KyufujissekiKihonModel sut = new KyufujissekiKihonModel();
            sut.setEntity(DbT3017KyufujissekiKihonEntityGenerator.createDbT3017KyufujissekiKihonEntity());

            sut.getEntity().initializeMd5();

            sut.setDeletedState(true);

            assertThat(sut.getState(), is(EntityDataState.Deleted));
        }
    }
}
