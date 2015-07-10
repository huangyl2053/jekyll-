/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.model;

import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT3001JukyushaIdoRenrakuhyoEntityGenerator;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link JukyushaIdoRenrakuhyoModel}のテストクラスです。
 *
 * @author LDNS 鄭雪双
 */
@RunWith(Enclosed.class)
public class JukyushaIdoRenrakuhyoModelTest extends DbzTestBase {

    public static class getterSetterTest extends DbzTestBase {

        private static JukyushaIdoRenrakuhyoModel sut;

        @BeforeClass
        public static void test() {
            sut = new JukyushaIdoRenrakuhyoModel();
        }

        @Test
        public void 戻り値の異動年月日は_設定した値と同じ異動年月日を返す() {
            sut.set異動年月日(DbT3001JukyushaIdoRenrakuhyoEntityGenerator.DEFAULT_異動年月日);
            assertThat(sut.get異動年月日(), is(DbT3001JukyushaIdoRenrakuhyoEntityGenerator.DEFAULT_異動年月日));
        }

        @Test
        public void 戻り値の異動区分コードは_設定した値と同じ異動区分コードを返す() {
            sut.set異動区分コード(DbT3001JukyushaIdoRenrakuhyoEntityGenerator.DEFAULT_異動区分コード);
            assertThat(sut.get異動区分コード(), is(DbT3001JukyushaIdoRenrakuhyoEntityGenerator.DEFAULT_異動区分コード));
        }

        @Test
        public void 戻り値の受給者異動事由は_設定した値と同じ受給者異動事由を返す() {
            sut.set受給者異動事由(DbT3001JukyushaIdoRenrakuhyoEntityGenerator.DEFAULT_受給者異動事由);
            assertThat(sut.get受給者異動事由(), is(DbT3001JukyushaIdoRenrakuhyoEntityGenerator.DEFAULT_受給者異動事由));
        }

        @Test
        public void 戻り値の証記載保険者番号は_設定した値と同じ証記載保険者番号を返す() {
            sut.set証記載保険者番号(DbT3001JukyushaIdoRenrakuhyoEntityGenerator.DEFAULT_証記載保険者番号);
            assertThat(sut.get証記載保険者番号(), is(DbT3001JukyushaIdoRenrakuhyoEntityGenerator.DEFAULT_証記載保険者番号));
        }

        @Test
        public void 戻り値の被保険者番号は_設定した値と同じ被保険者番号を返す() {
            sut.set被保険者番号(DbT3001JukyushaIdoRenrakuhyoEntityGenerator.DEFAULT_被保険者番号);
            assertThat(sut.get被保険者番号(), is(DbT3001JukyushaIdoRenrakuhyoEntityGenerator.DEFAULT_被保険者番号));
        }

        @Test
        public void 戻り値の処理日時は_設定した値と同じ処理日時を返す() {
            sut.set処理日時(DbT3001JukyushaIdoRenrakuhyoEntityGenerator.DEFAULT_処理日時);
            assertThat(sut.get処理日時(), is(DbT3001JukyushaIdoRenrakuhyoEntityGenerator.DEFAULT_処理日時));
        }

        @Test
        public void 戻り値の被保険者氏名カナは_設定した値と同じ被保険者氏名カナを返す() {
            sut.set被保険者氏名カナ(DbT3001JukyushaIdoRenrakuhyoEntityGenerator.DEFAULT_被保険者氏名カナ);
            assertThat(sut.get被保険者氏名カナ(), is(DbT3001JukyushaIdoRenrakuhyoEntityGenerator.DEFAULT_被保険者氏名カナ));
        }

        @Test
        public void 戻り値の生年月日は_設定した値と同じ生年月日を返す() {
            sut.set生年月日(DbT3001JukyushaIdoRenrakuhyoEntityGenerator.DEFAULT_生年月日);
            assertThat(sut.get生年月日(), is(DbT3001JukyushaIdoRenrakuhyoEntityGenerator.DEFAULT_生年月日));
        }

        @Test
        public void 戻り値の性別コードは_設定した値と同じ性別コードを返す() {
            sut.set性別コード(DbT3001JukyushaIdoRenrakuhyoEntityGenerator.DEFAULT_性別コード);
            assertThat(sut.get性別コード(), is(DbT3001JukyushaIdoRenrakuhyoEntityGenerator.DEFAULT_性別コード));
        }

        @Test
        public void 戻り値の資格取得年月日は_設定した値と同じ資格取得年月日を返す() {
            sut.set資格取得年月日(DbT3001JukyushaIdoRenrakuhyoEntityGenerator.DEFAULT_資格取得年月日);
            assertThat(sut.get資格取得年月日(), is(DbT3001JukyushaIdoRenrakuhyoEntityGenerator.DEFAULT_資格取得年月日));
        }

        @Test
        public void 戻り値の資格喪失年月日は_設定した値と同じ資格喪失年月日を返す() {
            sut.set資格喪失年月日(DbT3001JukyushaIdoRenrakuhyoEntityGenerator.DEFAULT_資格喪失年月日);
            assertThat(sut.get資格喪失年月日(), is(DbT3001JukyushaIdoRenrakuhyoEntityGenerator.DEFAULT_資格喪失年月日));
        }

        @Test
        public void 戻り値の老人保健市町村番号は_設定した値と同じ老人保健市町村番号を返す() {
            sut.set老人保健市町村番号(DbT3001JukyushaIdoRenrakuhyoEntityGenerator.DEFAULT_老人保健市町村番号);
            assertThat(sut.get老人保健市町村番号(), is(DbT3001JukyushaIdoRenrakuhyoEntityGenerator.DEFAULT_老人保健市町村番号));
        }

        @Test
        public void 戻り値の老人保健受給者番号は_設定した値と同じ老人保健受給者番号を返す() {
            sut.set老人保健受給者番号(DbT3001JukyushaIdoRenrakuhyoEntityGenerator.DEFAULT_老人保健受給者番号);
            assertThat(sut.get老人保健受給者番号(), is(DbT3001JukyushaIdoRenrakuhyoEntityGenerator.DEFAULT_老人保健受給者番号));
        }

        @Test
        public void 戻り値の公費負担者番号は_設定した値と同じ公費負担者番号を返す() {
            sut.set公費負担者番号(DbT3001JukyushaIdoRenrakuhyoEntityGenerator.DEFAULT_公費負担者番号);
            assertThat(sut.get公費負担者番号(), is(DbT3001JukyushaIdoRenrakuhyoEntityGenerator.DEFAULT_公費負担者番号));
        }

        @Test
        public void 戻り値の広域連合_政令市保険者番号は_設定した値と同じ広域連合_政令市保険者番号を返す() {
            sut.set広域連合_政令市保険者番号(DbT3001JukyushaIdoRenrakuhyoEntityGenerator.DEFAULT_広域連合_政令市保険者番号);
            assertThat(sut.get広域連合_政令市保険者番号(), is(DbT3001JukyushaIdoRenrakuhyoEntityGenerator.DEFAULT_広域連合_政令市保険者番号));
        }

        @Test
        public void 戻り値の申請種別コードは_設定した値と同じ申請種別コードを返す() {
            sut.set申請種別コード(DbT3001JukyushaIdoRenrakuhyoEntityGenerator.DEFAULT_申請種別コード);
            assertThat(sut.get申請種別コード(), is(DbT3001JukyushaIdoRenrakuhyoEntityGenerator.DEFAULT_申請種別コード));
        }

        @Test
        public void 戻り値の変更申請中区分コードは_設定した値と同じ変更申請中区分コードを返す() {
            sut.set変更申請中区分コード(DbT3001JukyushaIdoRenrakuhyoEntityGenerator.DEFAULT_変更申請中区分コード);
            assertThat(sut.get変更申請中区分コード(), is(DbT3001JukyushaIdoRenrakuhyoEntityGenerator.DEFAULT_変更申請中区分コード));
        }

        @Test
        public void 戻り値の申請年月日は_設定した値と同じ申請年月日を返す() {
            sut.set申請年月日(DbT3001JukyushaIdoRenrakuhyoEntityGenerator.DEFAULT_申請年月日);
            assertThat(sut.get申請年月日(), is(DbT3001JukyushaIdoRenrakuhyoEntityGenerator.DEFAULT_申請年月日));
        }

        @Test
        public void 戻り値のみなし要介護状態区分コードは_設定した値と同じみなし要介護状態区分コードを返す() {
            sut.setみなし要介護状態区分コード(DbT3001JukyushaIdoRenrakuhyoEntityGenerator.DEFAULT_みなし要介護状態区分コード);
            assertThat(sut.getみなし要介護状態区分コード(), is(DbT3001JukyushaIdoRenrakuhyoEntityGenerator.DEFAULT_みなし要介護状態区分コード));
        }

        @Test
        public void 戻り値の要介護状態区分コードは_設定した値と同じ要介護状態区分コードを返す() {
            sut.set要介護状態区分コード(DbT3001JukyushaIdoRenrakuhyoEntityGenerator.DEFAULT_要介護状態区分コード);
            assertThat(sut.get要介護状態区分コード(), is(DbT3001JukyushaIdoRenrakuhyoEntityGenerator.DEFAULT_要介護状態区分コード));
        }

        @Test
        public void 戻り値の認定有効期間開始年月日は_設定した値と同じ認定有効期間開始年月日を返す() {
            sut.set認定有効期間開始年月日(DbT3001JukyushaIdoRenrakuhyoEntityGenerator.DEFAULT_認定有効期間開始年月日);
            assertThat(sut.get認定有効期間開始年月日(), is(DbT3001JukyushaIdoRenrakuhyoEntityGenerator.DEFAULT_認定有効期間開始年月日));
        }

        @Test
        public void 戻り値の認定有効期間終了年月日は_設定した値と同じ認定有効期間終了年月日を返す() {
            sut.set認定有効期間終了年月日(DbT3001JukyushaIdoRenrakuhyoEntityGenerator.DEFAULT_認定有効期間終了年月日);
            assertThat(sut.get認定有効期間終了年月日(), is(DbT3001JukyushaIdoRenrakuhyoEntityGenerator.DEFAULT_認定有効期間終了年月日));
        }

        @Test
        public void 戻り値の居宅サービス計画作成区分コードは_設定した値と同じ居宅サービス計画作成区分コードを返す() {
            sut.set居宅サービス計画作成区分コード(DbT3001JukyushaIdoRenrakuhyoEntityGenerator.DEFAULT_居宅サービス計画作成区分コード);
            assertThat(sut.get居宅サービス計画作成区分コード(), is(DbT3001JukyushaIdoRenrakuhyoEntityGenerator.DEFAULT_居宅サービス計画作成区分コード));
        }

        @Test
        public void 戻り値の居宅介護支援事業所番号は_設定した値と同じ居宅介護支援事業所番号を返す() {
            sut.set居宅介護支援事業所番号(DbT3001JukyushaIdoRenrakuhyoEntityGenerator.DEFAULT_居宅介護支援事業所番号);
            assertThat(sut.get居宅介護支援事業所番号(), is(DbT3001JukyushaIdoRenrakuhyoEntityGenerator.DEFAULT_居宅介護支援事業所番号));
        }

        @Test
        public void 戻り値の居宅サービス計画適用開始年月日は_設定した値と同じ居宅サービス計画適用開始年月日を返す() {
            sut.set居宅サービス計画適用開始年月日(DbT3001JukyushaIdoRenrakuhyoEntityGenerator.DEFAULT_居宅サービス計画適用開始年月日);
            assertThat(sut.get居宅サービス計画適用開始年月日(), is(DbT3001JukyushaIdoRenrakuhyoEntityGenerator.DEFAULT_居宅サービス計画適用開始年月日));
        }

        @Test
        public void 戻り値の居宅サービス計画適用終了年月日は_設定した値と同じ居宅サービス計画適用終了年月日を返す() {
            sut.set居宅サービス計画適用終了年月日(DbT3001JukyushaIdoRenrakuhyoEntityGenerator.DEFAULT_居宅サービス計画適用終了年月日);
            assertThat(sut.get居宅サービス計画適用終了年月日(), is(DbT3001JukyushaIdoRenrakuhyoEntityGenerator.DEFAULT_居宅サービス計画適用終了年月日));
        }

        @Test
        public void 戻り値の訪問通所サービス支給限度基準額は_設定した値と同じ訪問通所サービス支給限度基準額を返す() {
            sut.set訪問通所サービス支給限度基準額(DbT3001JukyushaIdoRenrakuhyoEntityGenerator.DEFAULT_訪問通所サービス支給限度基準額);
            assertThat(sut.get訪問通所サービス支給限度基準額(), is(DbT3001JukyushaIdoRenrakuhyoEntityGenerator.DEFAULT_訪問通所サービス支給限度基準額));
        }

        @Test
        public void 戻り値の訪問通所サービス上限管理適用期間開始年月日は_設定した値と同じ訪問通所サービス上限管理適用期間開始年月日を返す() {
            sut.set訪問通所サービス上限管理適用期間開始年月日(DbT3001JukyushaIdoRenrakuhyoEntityGenerator.DEFAULT_訪問通所サービス上限管理適用期間開始年月日);
            assertThat(sut.get訪問通所サービス上限管理適用期間開始年月日(), is(DbT3001JukyushaIdoRenrakuhyoEntityGenerator.DEFAULT_訪問通所サービス上限管理適用期間開始年月日));
        }

        @Test
        public void 戻り値の訪問通所サービス上限管理適用期間終了年月日は_設定した値と同じ訪問通所サービス上限管理適用期間終了年月日を返す() {
            sut.set訪問通所サービス上限管理適用期間終了年月日(DbT3001JukyushaIdoRenrakuhyoEntityGenerator.DEFAULT_訪問通所サービス上限管理適用期間終了年月日);
            assertThat(sut.get訪問通所サービス上限管理適用期間終了年月日(), is(DbT3001JukyushaIdoRenrakuhyoEntityGenerator.DEFAULT_訪問通所サービス上限管理適用期間終了年月日));
        }

        @Test
        public void 戻り値の短期入所サービス支給限度基準額は_設定した値と同じ短期入所サービス支給限度基準額を返す() {
            sut.set短期入所サービス支給限度基準額(DbT3001JukyushaIdoRenrakuhyoEntityGenerator.DEFAULT_短期入所サービス支給限度基準額);
            assertThat(sut.get短期入所サービス支給限度基準額(), is(DbT3001JukyushaIdoRenrakuhyoEntityGenerator.DEFAULT_短期入所サービス支給限度基準額));
        }

        @Test
        public void 戻り値の短期入所サービス上限管理適用期間開始年月日は_設定した値と同じ短期入所サービス上限管理適用期間開始年月日を返す() {
            sut.set短期入所サービス上限管理適用期間開始年月日(DbT3001JukyushaIdoRenrakuhyoEntityGenerator.DEFAULT_短期入所サービス上限管理適用期間開始年月日);
            assertThat(sut.get短期入所サービス上限管理適用期間開始年月日(), is(DbT3001JukyushaIdoRenrakuhyoEntityGenerator.DEFAULT_短期入所サービス上限管理適用期間開始年月日));
        }

        @Test
        public void 戻り値の短期入所サービス上限管理適用期間終了年月日は_設定した値と同じ短期入所サービス上限管理適用期間終了年月日を返す() {
            sut.set短期入所サービス上限管理適用期間終了年月日(DbT3001JukyushaIdoRenrakuhyoEntityGenerator.DEFAULT_短期入所サービス上限管理適用期間終了年月日);
            assertThat(sut.get短期入所サービス上限管理適用期間終了年月日(), is(DbT3001JukyushaIdoRenrakuhyoEntityGenerator.DEFAULT_短期入所サービス上限管理適用期間終了年月日));
        }

        @Test
        public void 戻り値の公費負担上限額減額有フラグは_設定した値と同じ公費負担上限額減額有フラグを返す() {
            sut.set公費負担上限額減額有フラグ(DbT3001JukyushaIdoRenrakuhyoEntityGenerator.DEFAULT_公費負担上限額減額有フラグ);
            assertThat(sut.get公費負担上限額減額有フラグ(), is(DbT3001JukyushaIdoRenrakuhyoEntityGenerator.DEFAULT_公費負担上限額減額有フラグ));
        }

        @Test
        public void 戻り値の償還払化開始年月日は_設定した値と同じ償還払化開始年月日を返す() {
            sut.set償還払化開始年月日(DbT3001JukyushaIdoRenrakuhyoEntityGenerator.DEFAULT_償還払化開始年月日);
            assertThat(sut.get償還払化開始年月日(), is(DbT3001JukyushaIdoRenrakuhyoEntityGenerator.DEFAULT_償還払化開始年月日));
        }

        @Test
        public void 戻り値の償還払化終了年月日は_設定した値と同じ償還払化終了年月日を返す() {
            sut.set償還払化終了年月日(DbT3001JukyushaIdoRenrakuhyoEntityGenerator.DEFAULT_償還払化終了年月日);
            assertThat(sut.get償還払化終了年月日(), is(DbT3001JukyushaIdoRenrakuhyoEntityGenerator.DEFAULT_償還払化終了年月日));
        }

        @Test
        public void 戻り値の給付率引下げ開始年月日は_設定した値と同じ給付率引下げ開始年月日を返す() {
            sut.set給付率引下げ開始年月日(DbT3001JukyushaIdoRenrakuhyoEntityGenerator.DEFAULT_給付率引下げ開始年月日);
            assertThat(sut.get給付率引下げ開始年月日(), is(DbT3001JukyushaIdoRenrakuhyoEntityGenerator.DEFAULT_給付率引下げ開始年月日));
        }

        @Test
        public void 戻り値の給付率引下げ終了年月日は_設定した値と同じ給付率引下げ終了年月日を返す() {
            sut.set給付率引下げ終了年月日(DbT3001JukyushaIdoRenrakuhyoEntityGenerator.DEFAULT_給付率引下げ終了年月日);
            assertThat(sut.get給付率引下げ終了年月日(), is(DbT3001JukyushaIdoRenrakuhyoEntityGenerator.DEFAULT_給付率引下げ終了年月日));
        }

        @Test
        public void 戻り値の減免申請中区分コードは_設定した値と同じ減免申請中区分コードを返す() {
            sut.set減免申請中区分コード(DbT3001JukyushaIdoRenrakuhyoEntityGenerator.DEFAULT_減免申請中区分コード);
            assertThat(sut.get減免申請中区分コード(), is(DbT3001JukyushaIdoRenrakuhyoEntityGenerator.DEFAULT_減免申請中区分コード));
        }

        @Test
        public void 戻り値の利用者負担区分コードは_設定した値と同じ利用者負担区分コードを返す() {
            sut.set利用者負担区分コード(DbT3001JukyushaIdoRenrakuhyoEntityGenerator.DEFAULT_利用者負担区分コード);
            assertThat(sut.get利用者負担区分コード(), is(DbT3001JukyushaIdoRenrakuhyoEntityGenerator.DEFAULT_利用者負担区分コード));
        }

        @Test
        public void 戻り値の給付率は_設定した値と同じ給付率を返す() {
            sut.set給付率(DbT3001JukyushaIdoRenrakuhyoEntityGenerator.DEFAULT_給付率);
            assertThat(sut.get給付率(), is(DbT3001JukyushaIdoRenrakuhyoEntityGenerator.DEFAULT_給付率));
        }

        @Test
        public void 戻り値の適用開始年月日は_設定した値と同じ適用開始年月日を返す() {
            sut.set適用開始年月日(DbT3001JukyushaIdoRenrakuhyoEntityGenerator.DEFAULT_適用開始年月日);
            assertThat(sut.get適用開始年月日(), is(DbT3001JukyushaIdoRenrakuhyoEntityGenerator.DEFAULT_適用開始年月日));
        }

        @Test
        public void 戻り値の適用終了年月日は_設定した値と同じ適用終了年月日を返す() {
            sut.set適用終了年月日(DbT3001JukyushaIdoRenrakuhyoEntityGenerator.DEFAULT_適用終了年月日);
            assertThat(sut.get適用終了年月日(), is(DbT3001JukyushaIdoRenrakuhyoEntityGenerator.DEFAULT_適用終了年月日));
        }

        @Test
        public void 戻り値の標準負担区分コードは_設定した値と同じ標準負担区分コードを返す() {
            sut.set標準負担区分コード(DbT3001JukyushaIdoRenrakuhyoEntityGenerator.DEFAULT_標準負担区分コード);
            assertThat(sut.get標準負担区分コード(), is(DbT3001JukyushaIdoRenrakuhyoEntityGenerator.DEFAULT_標準負担区分コード));
        }

        @Test
        public void 戻り値の負担額は_設定した値と同じ負担額を返す() {
            sut.set負担額(DbT3001JukyushaIdoRenrakuhyoEntityGenerator.DEFAULT_負担額);
            assertThat(sut.get負担額(), is(DbT3001JukyushaIdoRenrakuhyoEntityGenerator.DEFAULT_負担額));
        }

        @Test
        public void 戻り値の負担額適用開始年月日は_設定した値と同じ負担額適用開始年月日を返す() {
            sut.set負担額適用開始年月日(DbT3001JukyushaIdoRenrakuhyoEntityGenerator.DEFAULT_負担額適用開始年月日);
            assertThat(sut.get負担額適用開始年月日(), is(DbT3001JukyushaIdoRenrakuhyoEntityGenerator.DEFAULT_負担額適用開始年月日));
        }

        @Test
        public void 戻り値の負担額適用終了年月日は_設定した値と同じ負担額適用終了年月日を返す() {
            sut.set負担額適用終了年月日(DbT3001JukyushaIdoRenrakuhyoEntityGenerator.DEFAULT_負担額適用終了年月日);
            assertThat(sut.get負担額適用終了年月日(), is(DbT3001JukyushaIdoRenrakuhyoEntityGenerator.DEFAULT_負担額適用終了年月日));
        }

        @Test
        public void 戻り値の特定入所者認定申請中区分コードは_設定した値と同じ特定入所者認定申請中区分コードを返す() {
            sut.set特定入所者認定申請中区分コード(DbT3001JukyushaIdoRenrakuhyoEntityGenerator.DEFAULT_特定入所者認定申請中区分コード);
            assertThat(sut.get特定入所者認定申請中区分コード(), is(DbT3001JukyushaIdoRenrakuhyoEntityGenerator.DEFAULT_特定入所者認定申請中区分コード));
        }

        @Test
        public void 戻り値の特定入所者介護サービス区分コードは_設定した値と同じ特定入所者介護サービス区分コードを返す() {
            sut.set特定入所者介護サービス区分コード(DbT3001JukyushaIdoRenrakuhyoEntityGenerator.DEFAULT_特定入所者介護サービス区分コード);
            assertThat(sut.get特定入所者介護サービス区分コード(), is(DbT3001JukyushaIdoRenrakuhyoEntityGenerator.DEFAULT_特定入所者介護サービス区分コード));
        }

        @Test
        public void 戻り値の課税層の特例減額措置対象フラグは_設定した値と同じ課税層の特例減額措置対象フラグを返す() {
            sut.set課税層の特例減額措置対象フラグ(DbT3001JukyushaIdoRenrakuhyoEntityGenerator.DEFAULT_課税層の特例減額措置対象フラグ);
            assertThat(sut.get課税層の特例減額措置対象フラグ(), is(DbT3001JukyushaIdoRenrakuhyoEntityGenerator.DEFAULT_課税層の特例減額措置対象フラグ));
        }

        @Test
        public void 戻り値の食費負担限度額は_設定した値と同じ食費負担限度額を返す() {
            sut.set食費負担限度額(DbT3001JukyushaIdoRenrakuhyoEntityGenerator.DEFAULT_食費負担限度額);
            assertThat(sut.get食費負担限度額(), is(DbT3001JukyushaIdoRenrakuhyoEntityGenerator.DEFAULT_食費負担限度額));
        }

        @Test
        public void 戻り値の居住費ユニット型個室負担限度額は_設定した値と同じ居住費ユニット型個室負担限度額を返す() {
            sut.set居住費ユニット型個室負担限度額(DbT3001JukyushaIdoRenrakuhyoEntityGenerator.DEFAULT_居住費ユニット型個室負担限度額);
            assertThat(sut.get居住費ユニット型個室負担限度額(), is(DbT3001JukyushaIdoRenrakuhyoEntityGenerator.DEFAULT_居住費ユニット型個室負担限度額));
        }

        @Test
        public void 戻り値の居住費ユニット型準個室負担限度額は_設定した値と同じ居住費ユニット型準個室負担限度額を返す() {
            sut.set居住費ユニット型準個室負担限度額(DbT3001JukyushaIdoRenrakuhyoEntityGenerator.DEFAULT_居住費ユニット型準個室負担限度額);
            assertThat(sut.get居住費ユニット型準個室負担限度額(), is(DbT3001JukyushaIdoRenrakuhyoEntityGenerator.DEFAULT_居住費ユニット型準個室負担限度額));
        }

        @Test
        public void 戻り値の居住費従来型個室特養等負担限度額は_設定した値と同じ居住費従来型個室特養等負担限度額を返す() {
            sut.set居住費従来型個室特養等負担限度額(DbT3001JukyushaIdoRenrakuhyoEntityGenerator.DEFAULT_居住費従来型個室特養等負担限度額);
            assertThat(sut.get居住費従来型個室特養等負担限度額(), is(DbT3001JukyushaIdoRenrakuhyoEntityGenerator.DEFAULT_居住費従来型個室特養等負担限度額));
        }

        @Test
        public void 戻り値の居住費従来型個室老健療養等負担限度額は_設定した値と同じ居住費従来型個室老健療養等負担限度額を返す() {
            sut.set居住費従来型個室老健療養等負担限度額(DbT3001JukyushaIdoRenrakuhyoEntityGenerator.DEFAULT_居住費従来型個室老健療養等負担限度額);
            assertThat(sut.get居住費従来型個室老健療養等負担限度額(), is(DbT3001JukyushaIdoRenrakuhyoEntityGenerator.DEFAULT_居住費従来型個室老健療養等負担限度額));
        }

        @Test
        public void 戻り値の居住費多床室負担限度額は_設定した値と同じ居住費多床室負担限度額を返す() {
            sut.set居住費多床室負担限度額(DbT3001JukyushaIdoRenrakuhyoEntityGenerator.DEFAULT_居住費多床室負担限度額);
            assertThat(sut.get居住費多床室負担限度額(), is(DbT3001JukyushaIdoRenrakuhyoEntityGenerator.DEFAULT_居住費多床室負担限度額));
        }

        @Test
        public void 戻り値の負担限度額適用開始年月日は_設定した値と同じ負担限度額適用開始年月日を返す() {
            sut.set負担限度額適用開始年月日(DbT3001JukyushaIdoRenrakuhyoEntityGenerator.DEFAULT_負担限度額適用開始年月日);
            assertThat(sut.get負担限度額適用開始年月日(), is(DbT3001JukyushaIdoRenrakuhyoEntityGenerator.DEFAULT_負担限度額適用開始年月日));
        }

        @Test
        public void 戻り値の負担限度額適用終了年月日は_設定した値と同じ負担限度額適用終了年月日を返す() {
            sut.set負担限度額適用終了年月日(DbT3001JukyushaIdoRenrakuhyoEntityGenerator.DEFAULT_負担限度額適用終了年月日);
            assertThat(sut.get負担限度額適用終了年月日(), is(DbT3001JukyushaIdoRenrakuhyoEntityGenerator.DEFAULT_負担限度額適用終了年月日));
        }

        @Test
        public void 戻り値の軽減率は_設定した値と同じ軽減率を返す() {
            sut.set軽減率(DbT3001JukyushaIdoRenrakuhyoEntityGenerator.DEFAULT_軽減率);
            assertThat(sut.get軽減率(), is(DbT3001JukyushaIdoRenrakuhyoEntityGenerator.DEFAULT_軽減率));
        }

        @Test
        public void 戻り値の軽減率適用開始年月日は_設定した値と同じ軽減率適用開始年月日を返す() {
            sut.set軽減率適用開始年月日(DbT3001JukyushaIdoRenrakuhyoEntityGenerator.DEFAULT_軽減率適用開始年月日);
            assertThat(sut.get軽減率適用開始年月日(), is(DbT3001JukyushaIdoRenrakuhyoEntityGenerator.DEFAULT_軽減率適用開始年月日));
        }

        @Test
        public void 戻り値の軽減率適用終了年月日は_設定した値と同じ軽減率適用終了年月日を返す() {
            sut.set軽減率適用終了年月日(DbT3001JukyushaIdoRenrakuhyoEntityGenerator.DEFAULT_軽減率適用終了年月日);
            assertThat(sut.get軽減率適用終了年月日(), is(DbT3001JukyushaIdoRenrakuhyoEntityGenerator.DEFAULT_軽減率適用終了年月日));
        }

        @Test
        public void 戻り値の小規模多機能型居宅介護利用開始月居宅サービス等利用有フラグは_設定した値と同じ小規模多機能型居宅介護利用開始月居宅サービス等利用有フラグを返す() {
            sut.set小規模多機能型居宅介護利用開始月居宅サービス等利用有フラグ(DbT3001JukyushaIdoRenrakuhyoEntityGenerator.DEFAULT_小規模多機能型居宅介護利用開始月居宅サービス等利用有フラグ);
            assertThat(sut.get小規模多機能型居宅介護利用開始月居宅サービス等利用有フラグ(), is(DbT3001JukyushaIdoRenrakuhyoEntityGenerator.DEFAULT_小規模多機能型居宅介護利用開始月居宅サービス等利用有フラグ));
        }

        @Test
        public void 戻り値の後期高齢者医療保険者番号は_設定した値と同じ後期高齢者医療保険者番号を返す() {
            sut.set後期高齢者医療保険者番号(DbT3001JukyushaIdoRenrakuhyoEntityGenerator.DEFAULT_後期高齢者医療保険者番号);
            assertThat(sut.get後期高齢者医療保険者番号(), is(DbT3001JukyushaIdoRenrakuhyoEntityGenerator.DEFAULT_後期高齢者医療保険者番号));
        }

        @Test
        public void 戻り値の後期高齢者医療被保険者番号は_設定した値と同じ後期高齢者医療被保険者番号を返す() {
            sut.set後期高齢者医療被保険者番号(DbT3001JukyushaIdoRenrakuhyoEntityGenerator.DEFAULT_後期高齢者医療被保険者番号);
            assertThat(sut.get後期高齢者医療被保険者番号(), is(DbT3001JukyushaIdoRenrakuhyoEntityGenerator.DEFAULT_後期高齢者医療被保険者番号));
        }

        @Test
        public void 戻り値の国民健康保険保険者番号は_設定した値と同じ国民健康保険保険者番号を返す() {
            sut.set国民健康保険保険者番号(DbT3001JukyushaIdoRenrakuhyoEntityGenerator.DEFAULT_国民健康保険保険者番号);
            assertThat(sut.get国民健康保険保険者番号(), is(DbT3001JukyushaIdoRenrakuhyoEntityGenerator.DEFAULT_国民健康保険保険者番号));
        }

        @Test
        public void 戻り値の国民健康保険被保険者証番号は_設定した値と同じ国民健康保険被保険者証番号を返す() {
            sut.set国民健康保険被保険者証番号(DbT3001JukyushaIdoRenrakuhyoEntityGenerator.DEFAULT_国民健康保険被保険者証番号);
            assertThat(sut.get国民健康保険被保険者証番号(), is(DbT3001JukyushaIdoRenrakuhyoEntityGenerator.DEFAULT_国民健康保険被保険者証番号));
        }

        @Test
        public void 戻り値の国民健康保険個人番号は_設定した値と同じ国民健康保険個人番号を返す() {
            sut.set国民健康保険個人番号(DbT3001JukyushaIdoRenrakuhyoEntityGenerator.DEFAULT_国民健康保険個人番号);
            assertThat(sut.get国民健康保険個人番号(), is(DbT3001JukyushaIdoRenrakuhyoEntityGenerator.DEFAULT_国民健康保険個人番号));
        }

        @Test
        public void 戻り値の二次予防事業区分コードは_設定した値と同じ二次予防事業区分コードを返す() {
            sut.set二次予防事業区分コード(DbT3001JukyushaIdoRenrakuhyoEntityGenerator.DEFAULT_二次予防事業区分コード);
            assertThat(sut.get二次予防事業区分コード(), is(DbT3001JukyushaIdoRenrakuhyoEntityGenerator.DEFAULT_二次予防事業区分コード));
        }

        @Test
        public void 戻り値の二次予防事業有効期間開始年月日は_設定した値と同じ二次予防事業有効期間開始年月日を返す() {
            sut.set二次予防事業有効期間開始年月日(DbT3001JukyushaIdoRenrakuhyoEntityGenerator.DEFAULT_二次予防事業有効期間開始年月日);
            assertThat(sut.get二次予防事業有効期間開始年月日(), is(DbT3001JukyushaIdoRenrakuhyoEntityGenerator.DEFAULT_二次予防事業有効期間開始年月日));
        }

        @Test
        public void 戻り値の二次予防事業有効期間終了年月日は_設定した値と同じ二次予防事業有効期間終了年月日を返す() {
            sut.set二次予防事業有効期間終了年月日(DbT3001JukyushaIdoRenrakuhyoEntityGenerator.DEFAULT_二次予防事業有効期間終了年月日);
            assertThat(sut.get二次予防事業有効期間終了年月日(), is(DbT3001JukyushaIdoRenrakuhyoEntityGenerator.DEFAULT_二次予防事業有効期間終了年月日));
        }

        @Test
        public void 戻り値の訂正連絡票フラグは_設定した値と同じ訂正連絡票フラグを返す() {
            sut.set訂正連絡票フラグ(DbT3001JukyushaIdoRenrakuhyoEntityGenerator.DEFAULT_訂正連絡票フラグ);
            assertThat(sut.get訂正連絡票フラグ(), is(DbT3001JukyushaIdoRenrakuhyoEntityGenerator.DEFAULT_訂正連絡票フラグ));
        }

        @Test
        public void 戻り値の送付年月は_設定した値と同じ送付年月を返す() {
            sut.set送付年月(DbT3001JukyushaIdoRenrakuhyoEntityGenerator.DEFAULT_送付年月);
            assertThat(sut.get送付年月(), is(DbT3001JukyushaIdoRenrakuhyoEntityGenerator.DEFAULT_送付年月));
        }
    }

    public static class getStateTest extends DbzTestBase {

        @Test
        public void 状態Addedの取得確認() {
            JukyushaIdoRenrakuhyoModel sut = new JukyushaIdoRenrakuhyoModel();

            assertThat(sut.getState(), is(EntityDataState.Added));
        }

        @Test
        public void 状態Modifinedの取得確認() {
            JukyushaIdoRenrakuhyoModel sut = new JukyushaIdoRenrakuhyoModel();
            sut.setEntity(DbT3001JukyushaIdoRenrakuhyoEntityGenerator.createDbT3001JukyushaIdoRenrakuhyoEntity());

            sut.getEntity().initializeMd5();

            // 主キー以外の項目を変更してください
//            sut.getEntity().setXXX(new XXX());
//            assertThat(sut.getState(), is(EntityDataState.Modified));
        }

        @Test
        public void 状態Unchangedの取得確認() {
            JukyushaIdoRenrakuhyoModel sut = new JukyushaIdoRenrakuhyoModel();
            sut.setEntity(DbT3001JukyushaIdoRenrakuhyoEntityGenerator.createDbT3001JukyushaIdoRenrakuhyoEntity());

            sut.getEntity().initializeMd5();

            assertThat(sut.getState(), is(EntityDataState.Unchanged));
        }

        @Test
        public void 状態Deletedの取得確認() {
            JukyushaIdoRenrakuhyoModel sut = new JukyushaIdoRenrakuhyoModel();
            sut.setEntity(DbT3001JukyushaIdoRenrakuhyoEntityGenerator.createDbT3001JukyushaIdoRenrakuhyoEntity());

            sut.getEntity().initializeMd5();

            sut.setDeletedState(true);

            assertThat(sut.getState(), is(EntityDataState.Deleted));
        }
    }
}
