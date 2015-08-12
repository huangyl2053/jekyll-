/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import jp.co.ndensan.reams.fd.fdz.testhelper.FdaTestBase;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link JukyushaIdoRenrakuhyoBuilder}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class JukyushaIdoRenrakuhyoBuilderTest extends DbcTestBase {

    private static DbT3001JukyushaIdoRenrakuhyoEntity JukyushaIdoRenrakuhyoEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static 主キー型1 主キー名1;
    private static 主キー型2 主キー名2;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        主キー名1 = DbT3001JukyushaIdoRenrakuhyoEntityGenerator.DEFAULT_主キー名1;
        主キー名2 = DbT3001JukyushaIdoRenrakuhyoEntityGenerator.DEFAULT_主キー名2;
    }

    public static class getterSetterTest extends FdaTestBase {

        private static JukyushaIdoRenrakuhyoBuilder sut;
        private static JukyushaIdoRenrakuhyo business;

        @Before
        public void setUp() {
            JukyushaIdoRenrakuhyoEntity = new DbT3001JukyushaIdoRenrakuhyoEntity();
            JukyushaIdoRenrakuhyoEntity.setXXX(主キー名1);
            JukyushaIdoRenrakuhyoEntity.setXXX(主キー名2);

            business = new JukyushaIdoRenrakuhyo(JukyushaIdoRenrakuhyoEntity);

            sut = business.createBuilderForEdit();
        }
//TODO Key項目のテストメソッドは削除して下さい。
        @Test
        public void 戻り値の異動年月日は_設定した値と同じ異動年月日を返す() {
            business = sut.set異動年月日(DbT3001JukyushaIdoRenrakuhyoEntityGenerator.DEFAULT_異動年月日).build();
            assertThat(business.get異動年月日(), is(DbT3001JukyushaIdoRenrakuhyoEntityGenerator.DEFAULT_異動年月日));
        }

        @Test
        public void 戻り値の異動区分コードは_設定した値と同じ異動区分コードを返す() {
            business = sut.set異動区分コード(DbT3001JukyushaIdoRenrakuhyoEntityGenerator.DEFAULT_異動区分コード).build();
            assertThat(business.get異動区分コード(), is(DbT3001JukyushaIdoRenrakuhyoEntityGenerator.DEFAULT_異動区分コード));
        }

        @Test
        public void 戻り値の受給者異動事由は_設定した値と同じ受給者異動事由を返す() {
            business = sut.set受給者異動事由(DbT3001JukyushaIdoRenrakuhyoEntityGenerator.DEFAULT_受給者異動事由).build();
            assertThat(business.get受給者異動事由(), is(DbT3001JukyushaIdoRenrakuhyoEntityGenerator.DEFAULT_受給者異動事由));
        }

        @Test
        public void 戻り値の証記載保険者番号は_設定した値と同じ証記載保険者番号を返す() {
            business = sut.set証記載保険者番号(DbT3001JukyushaIdoRenrakuhyoEntityGenerator.DEFAULT_証記載保険者番号).build();
            assertThat(business.get証記載保険者番号(), is(DbT3001JukyushaIdoRenrakuhyoEntityGenerator.DEFAULT_証記載保険者番号));
        }

        @Test
        public void 戻り値の被保険者番号は_設定した値と同じ被保険者番号を返す() {
            business = sut.set被保険者番号(DbT3001JukyushaIdoRenrakuhyoEntityGenerator.DEFAULT_被保険者番号).build();
            assertThat(business.get被保険者番号(), is(DbT3001JukyushaIdoRenrakuhyoEntityGenerator.DEFAULT_被保険者番号));
        }

        @Test
        public void 戻り値の履歴番号は_設定した値と同じ履歴番号を返す() {
            business = sut.set履歴番号(DbT3001JukyushaIdoRenrakuhyoEntityGenerator.DEFAULT_履歴番号).build();
            assertThat(business.get履歴番号(), is(DbT3001JukyushaIdoRenrakuhyoEntityGenerator.DEFAULT_履歴番号));
        }

        @Test
        public void 戻り値の被保険者氏名カナは_設定した値と同じ被保険者氏名カナを返す() {
            business = sut.set被保険者氏名カナ(DbT3001JukyushaIdoRenrakuhyoEntityGenerator.DEFAULT_被保険者氏名カナ).build();
            assertThat(business.get被保険者氏名カナ(), is(DbT3001JukyushaIdoRenrakuhyoEntityGenerator.DEFAULT_被保険者氏名カナ));
        }

        @Test
        public void 戻り値の生年月日は_設定した値と同じ生年月日を返す() {
            business = sut.set生年月日(DbT3001JukyushaIdoRenrakuhyoEntityGenerator.DEFAULT_生年月日).build();
            assertThat(business.get生年月日(), is(DbT3001JukyushaIdoRenrakuhyoEntityGenerator.DEFAULT_生年月日));
        }

        @Test
        public void 戻り値の性別コードは_設定した値と同じ性別コードを返す() {
            business = sut.set性別コード(DbT3001JukyushaIdoRenrakuhyoEntityGenerator.DEFAULT_性別コード).build();
            assertThat(business.get性別コード(), is(DbT3001JukyushaIdoRenrakuhyoEntityGenerator.DEFAULT_性別コード));
        }

        @Test
        public void 戻り値の資格取得年月日は_設定した値と同じ資格取得年月日を返す() {
            business = sut.set資格取得年月日(DbT3001JukyushaIdoRenrakuhyoEntityGenerator.DEFAULT_資格取得年月日).build();
            assertThat(business.get資格取得年月日(), is(DbT3001JukyushaIdoRenrakuhyoEntityGenerator.DEFAULT_資格取得年月日));
        }

        @Test
        public void 戻り値の資格喪失年月日は_設定した値と同じ資格喪失年月日を返す() {
            business = sut.set資格喪失年月日(DbT3001JukyushaIdoRenrakuhyoEntityGenerator.DEFAULT_資格喪失年月日).build();
            assertThat(business.get資格喪失年月日(), is(DbT3001JukyushaIdoRenrakuhyoEntityGenerator.DEFAULT_資格喪失年月日));
        }

        @Test
        public void 戻り値の老人保健市町村番号は_設定した値と同じ老人保健市町村番号を返す() {
            business = sut.set老人保健市町村番号(DbT3001JukyushaIdoRenrakuhyoEntityGenerator.DEFAULT_老人保健市町村番号).build();
            assertThat(business.get老人保健市町村番号(), is(DbT3001JukyushaIdoRenrakuhyoEntityGenerator.DEFAULT_老人保健市町村番号));
        }

        @Test
        public void 戻り値の老人保健受給者番号は_設定した値と同じ老人保健受給者番号を返す() {
            business = sut.set老人保健受給者番号(DbT3001JukyushaIdoRenrakuhyoEntityGenerator.DEFAULT_老人保健受給者番号).build();
            assertThat(business.get老人保健受給者番号(), is(DbT3001JukyushaIdoRenrakuhyoEntityGenerator.DEFAULT_老人保健受給者番号));
        }

        @Test
        public void 戻り値の公費負担者番号は_設定した値と同じ公費負担者番号を返す() {
            business = sut.set公費負担者番号(DbT3001JukyushaIdoRenrakuhyoEntityGenerator.DEFAULT_公費負担者番号).build();
            assertThat(business.get公費負担者番号(), is(DbT3001JukyushaIdoRenrakuhyoEntityGenerator.DEFAULT_公費負担者番号));
        }

        @Test
        public void 戻り値の広域連合（政令市）保険者番号は_設定した値と同じ広域連合（政令市）保険者番号を返す() {
            business = sut.set広域連合（政令市）保険者番号(DbT3001JukyushaIdoRenrakuhyoEntityGenerator.DEFAULT_広域連合（政令市）保険者番号).build();
            assertThat(business.get広域連合（政令市）保険者番号(), is(DbT3001JukyushaIdoRenrakuhyoEntityGenerator.DEFAULT_広域連合（政令市）保険者番号));
        }

        @Test
        public void 戻り値の申請種別コードは_設定した値と同じ申請種別コードを返す() {
            business = sut.set申請種別コード(DbT3001JukyushaIdoRenrakuhyoEntityGenerator.DEFAULT_申請種別コード).build();
            assertThat(business.get申請種別コード(), is(DbT3001JukyushaIdoRenrakuhyoEntityGenerator.DEFAULT_申請種別コード));
        }

        @Test
        public void 戻り値の変更申請中区分コードは_設定した値と同じ変更申請中区分コードを返す() {
            business = sut.set変更申請中区分コード(DbT3001JukyushaIdoRenrakuhyoEntityGenerator.DEFAULT_変更申請中区分コード).build();
            assertThat(business.get変更申請中区分コード(), is(DbT3001JukyushaIdoRenrakuhyoEntityGenerator.DEFAULT_変更申請中区分コード));
        }

        @Test
        public void 戻り値の申請年月日は_設定した値と同じ申請年月日を返す() {
            business = sut.set申請年月日(DbT3001JukyushaIdoRenrakuhyoEntityGenerator.DEFAULT_申請年月日).build();
            assertThat(business.get申請年月日(), is(DbT3001JukyushaIdoRenrakuhyoEntityGenerator.DEFAULT_申請年月日));
        }

        @Test
        public void 戻り値のみなし要介護状態区分コードは_設定した値と同じみなし要介護状態区分コードを返す() {
            business = sut.setみなし要介護状態区分コード(DbT3001JukyushaIdoRenrakuhyoEntityGenerator.DEFAULT_みなし要介護状態区分コード).build();
            assertThat(business.getみなし要介護状態区分コード(), is(DbT3001JukyushaIdoRenrakuhyoEntityGenerator.DEFAULT_みなし要介護状態区分コード));
        }

        @Test
        public void 戻り値の要介護状態区分コードは_設定した値と同じ要介護状態区分コードを返す() {
            business = sut.set要介護状態区分コード(DbT3001JukyushaIdoRenrakuhyoEntityGenerator.DEFAULT_要介護状態区分コード).build();
            assertThat(business.get要介護状態区分コード(), is(DbT3001JukyushaIdoRenrakuhyoEntityGenerator.DEFAULT_要介護状態区分コード));
        }

        @Test
        public void 戻り値の認定有効期間開始年月日は_設定した値と同じ認定有効期間開始年月日を返す() {
            business = sut.set認定有効期間開始年月日(DbT3001JukyushaIdoRenrakuhyoEntityGenerator.DEFAULT_認定有効期間開始年月日).build();
            assertThat(business.get認定有効期間開始年月日(), is(DbT3001JukyushaIdoRenrakuhyoEntityGenerator.DEFAULT_認定有効期間開始年月日));
        }

        @Test
        public void 戻り値の認定有効期間終了年月日は_設定した値と同じ認定有効期間終了年月日を返す() {
            business = sut.set認定有効期間終了年月日(DbT3001JukyushaIdoRenrakuhyoEntityGenerator.DEFAULT_認定有効期間終了年月日).build();
            assertThat(business.get認定有効期間終了年月日(), is(DbT3001JukyushaIdoRenrakuhyoEntityGenerator.DEFAULT_認定有効期間終了年月日));
        }

        @Test
        public void 戻り値の居宅サービス計画作成区分コードは_設定した値と同じ居宅サービス計画作成区分コードを返す() {
            business = sut.set居宅サービス計画作成区分コード(DbT3001JukyushaIdoRenrakuhyoEntityGenerator.DEFAULT_居宅サービス計画作成区分コード).build();
            assertThat(business.get居宅サービス計画作成区分コード(), is(DbT3001JukyushaIdoRenrakuhyoEntityGenerator.DEFAULT_居宅サービス計画作成区分コード));
        }

        @Test
        public void 戻り値の居宅介護支援事業所番号は_設定した値と同じ居宅介護支援事業所番号を返す() {
            business = sut.set居宅介護支援事業所番号(DbT3001JukyushaIdoRenrakuhyoEntityGenerator.DEFAULT_居宅介護支援事業所番号).build();
            assertThat(business.get居宅介護支援事業所番号(), is(DbT3001JukyushaIdoRenrakuhyoEntityGenerator.DEFAULT_居宅介護支援事業所番号));
        }

        @Test
        public void 戻り値の居宅サービス計画適用開始年月日は_設定した値と同じ居宅サービス計画適用開始年月日を返す() {
            business = sut.set居宅サービス計画適用開始年月日(DbT3001JukyushaIdoRenrakuhyoEntityGenerator.DEFAULT_居宅サービス計画適用開始年月日).build();
            assertThat(business.get居宅サービス計画適用開始年月日(), is(DbT3001JukyushaIdoRenrakuhyoEntityGenerator.DEFAULT_居宅サービス計画適用開始年月日));
        }

        @Test
        public void 戻り値の居宅サービス計画適用終了年月日は_設定した値と同じ居宅サービス計画適用終了年月日を返す() {
            business = sut.set居宅サービス計画適用終了年月日(DbT3001JukyushaIdoRenrakuhyoEntityGenerator.DEFAULT_居宅サービス計画適用終了年月日).build();
            assertThat(business.get居宅サービス計画適用終了年月日(), is(DbT3001JukyushaIdoRenrakuhyoEntityGenerator.DEFAULT_居宅サービス計画適用終了年月日));
        }

        @Test
        public void 戻り値の訪問通所サービス支給限度基準額は_設定した値と同じ訪問通所サービス支給限度基準額を返す() {
            business = sut.set訪問通所サービス支給限度基準額(DbT3001JukyushaIdoRenrakuhyoEntityGenerator.DEFAULT_訪問通所サービス支給限度基準額).build();
            assertThat(business.get訪問通所サービス支給限度基準額(), is(DbT3001JukyushaIdoRenrakuhyoEntityGenerator.DEFAULT_訪問通所サービス支給限度基準額));
        }

        @Test
        public void 戻り値の訪問通所サービス上限管理適用期間開始年月日は_設定した値と同じ訪問通所サービス上限管理適用期間開始年月日を返す() {
            business = sut.set訪問通所サービス上限管理適用期間開始年月日(DbT3001JukyushaIdoRenrakuhyoEntityGenerator.DEFAULT_訪問通所サービス上限管理適用期間開始年月日).build();
            assertThat(business.get訪問通所サービス上限管理適用期間開始年月日(), is(DbT3001JukyushaIdoRenrakuhyoEntityGenerator.DEFAULT_訪問通所サービス上限管理適用期間開始年月日));
        }

        @Test
        public void 戻り値の訪問通所サービス上限管理適用期間終了年月日は_設定した値と同じ訪問通所サービス上限管理適用期間終了年月日を返す() {
            business = sut.set訪問通所サービス上限管理適用期間終了年月日(DbT3001JukyushaIdoRenrakuhyoEntityGenerator.DEFAULT_訪問通所サービス上限管理適用期間終了年月日).build();
            assertThat(business.get訪問通所サービス上限管理適用期間終了年月日(), is(DbT3001JukyushaIdoRenrakuhyoEntityGenerator.DEFAULT_訪問通所サービス上限管理適用期間終了年月日));
        }

        @Test
        public void 戻り値の短期入所サービス支給限度基準額は_設定した値と同じ短期入所サービス支給限度基準額を返す() {
            business = sut.set短期入所サービス支給限度基準額(DbT3001JukyushaIdoRenrakuhyoEntityGenerator.DEFAULT_短期入所サービス支給限度基準額).build();
            assertThat(business.get短期入所サービス支給限度基準額(), is(DbT3001JukyushaIdoRenrakuhyoEntityGenerator.DEFAULT_短期入所サービス支給限度基準額));
        }

        @Test
        public void 戻り値の短期入所サービス上限管理適用期間開始年月日は_設定した値と同じ短期入所サービス上限管理適用期間開始年月日を返す() {
            business = sut.set短期入所サービス上限管理適用期間開始年月日(DbT3001JukyushaIdoRenrakuhyoEntityGenerator.DEFAULT_短期入所サービス上限管理適用期間開始年月日).build();
            assertThat(business.get短期入所サービス上限管理適用期間開始年月日(), is(DbT3001JukyushaIdoRenrakuhyoEntityGenerator.DEFAULT_短期入所サービス上限管理適用期間開始年月日));
        }

        @Test
        public void 戻り値の短期入所サービス上限管理適用期間終了年月日は_設定した値と同じ短期入所サービス上限管理適用期間終了年月日を返す() {
            business = sut.set短期入所サービス上限管理適用期間終了年月日(DbT3001JukyushaIdoRenrakuhyoEntityGenerator.DEFAULT_短期入所サービス上限管理適用期間終了年月日).build();
            assertThat(business.get短期入所サービス上限管理適用期間終了年月日(), is(DbT3001JukyushaIdoRenrakuhyoEntityGenerator.DEFAULT_短期入所サービス上限管理適用期間終了年月日));
        }

        @Test
        public void 戻り値の公費負担上限額減額有フラグは_設定した値と同じ公費負担上限額減額有フラグを返す() {
            business = sut.set公費負担上限額減額有フラグ(DbT3001JukyushaIdoRenrakuhyoEntityGenerator.DEFAULT_公費負担上限額減額有フラグ).build();
            assertThat(business.get公費負担上限額減額有フラグ(), is(DbT3001JukyushaIdoRenrakuhyoEntityGenerator.DEFAULT_公費負担上限額減額有フラグ));
        }

        @Test
        public void 戻り値の償還払化開始年月日は_設定した値と同じ償還払化開始年月日を返す() {
            business = sut.set償還払化開始年月日(DbT3001JukyushaIdoRenrakuhyoEntityGenerator.DEFAULT_償還払化開始年月日).build();
            assertThat(business.get償還払化開始年月日(), is(DbT3001JukyushaIdoRenrakuhyoEntityGenerator.DEFAULT_償還払化開始年月日));
        }

        @Test
        public void 戻り値の償還払化終了年月日は_設定した値と同じ償還払化終了年月日を返す() {
            business = sut.set償還払化終了年月日(DbT3001JukyushaIdoRenrakuhyoEntityGenerator.DEFAULT_償還払化終了年月日).build();
            assertThat(business.get償還払化終了年月日(), is(DbT3001JukyushaIdoRenrakuhyoEntityGenerator.DEFAULT_償還払化終了年月日));
        }

        @Test
        public void 戻り値の給付率引下げ開始年月日は_設定した値と同じ給付率引下げ開始年月日を返す() {
            business = sut.set給付率引下げ開始年月日(DbT3001JukyushaIdoRenrakuhyoEntityGenerator.DEFAULT_給付率引下げ開始年月日).build();
            assertThat(business.get給付率引下げ開始年月日(), is(DbT3001JukyushaIdoRenrakuhyoEntityGenerator.DEFAULT_給付率引下げ開始年月日));
        }

        @Test
        public void 戻り値の給付率引下げ終了年月日は_設定した値と同じ給付率引下げ終了年月日を返す() {
            business = sut.set給付率引下げ終了年月日(DbT3001JukyushaIdoRenrakuhyoEntityGenerator.DEFAULT_給付率引下げ終了年月日).build();
            assertThat(business.get給付率引下げ終了年月日(), is(DbT3001JukyushaIdoRenrakuhyoEntityGenerator.DEFAULT_給付率引下げ終了年月日));
        }

        @Test
        public void 戻り値の減免申請中区分コードは_設定した値と同じ減免申請中区分コードを返す() {
            business = sut.set減免申請中区分コード(DbT3001JukyushaIdoRenrakuhyoEntityGenerator.DEFAULT_減免申請中区分コード).build();
            assertThat(business.get減免申請中区分コード(), is(DbT3001JukyushaIdoRenrakuhyoEntityGenerator.DEFAULT_減免申請中区分コード));
        }

        @Test
        public void 戻り値の利用者負担区分コードは_設定した値と同じ利用者負担区分コードを返す() {
            business = sut.set利用者負担区分コード(DbT3001JukyushaIdoRenrakuhyoEntityGenerator.DEFAULT_利用者負担区分コード).build();
            assertThat(business.get利用者負担区分コード(), is(DbT3001JukyushaIdoRenrakuhyoEntityGenerator.DEFAULT_利用者負担区分コード));
        }

        @Test
        public void 戻り値の給付率は_設定した値と同じ給付率を返す() {
            business = sut.set給付率(DbT3001JukyushaIdoRenrakuhyoEntityGenerator.DEFAULT_給付率).build();
            assertThat(business.get給付率(), is(DbT3001JukyushaIdoRenrakuhyoEntityGenerator.DEFAULT_給付率));
        }

        @Test
        public void 戻り値の適用開始年月日は_設定した値と同じ適用開始年月日を返す() {
            business = sut.set適用開始年月日(DbT3001JukyushaIdoRenrakuhyoEntityGenerator.DEFAULT_適用開始年月日).build();
            assertThat(business.get適用開始年月日(), is(DbT3001JukyushaIdoRenrakuhyoEntityGenerator.DEFAULT_適用開始年月日));
        }

        @Test
        public void 戻り値の適用終了年月日は_設定した値と同じ適用終了年月日を返す() {
            business = sut.set適用終了年月日(DbT3001JukyushaIdoRenrakuhyoEntityGenerator.DEFAULT_適用終了年月日).build();
            assertThat(business.get適用終了年月日(), is(DbT3001JukyushaIdoRenrakuhyoEntityGenerator.DEFAULT_適用終了年月日));
        }

        @Test
        public void 戻り値の標準負担区分コードは_設定した値と同じ標準負担区分コードを返す() {
            business = sut.set標準負担区分コード(DbT3001JukyushaIdoRenrakuhyoEntityGenerator.DEFAULT_標準負担区分コード).build();
            assertThat(business.get標準負担区分コード(), is(DbT3001JukyushaIdoRenrakuhyoEntityGenerator.DEFAULT_標準負担区分コード));
        }

        @Test
        public void 戻り値の負担額は_設定した値と同じ負担額を返す() {
            business = sut.set負担額(DbT3001JukyushaIdoRenrakuhyoEntityGenerator.DEFAULT_負担額).build();
            assertThat(business.get負担額(), is(DbT3001JukyushaIdoRenrakuhyoEntityGenerator.DEFAULT_負担額));
        }

        @Test
        public void 戻り値の負担額適用開始年月日は_設定した値と同じ負担額適用開始年月日を返す() {
            business = sut.set負担額適用開始年月日(DbT3001JukyushaIdoRenrakuhyoEntityGenerator.DEFAULT_負担額適用開始年月日).build();
            assertThat(business.get負担額適用開始年月日(), is(DbT3001JukyushaIdoRenrakuhyoEntityGenerator.DEFAULT_負担額適用開始年月日));
        }

        @Test
        public void 戻り値の負担額適用終了年月日は_設定した値と同じ負担額適用終了年月日を返す() {
            business = sut.set負担額適用終了年月日(DbT3001JukyushaIdoRenrakuhyoEntityGenerator.DEFAULT_負担額適用終了年月日).build();
            assertThat(business.get負担額適用終了年月日(), is(DbT3001JukyushaIdoRenrakuhyoEntityGenerator.DEFAULT_負担額適用終了年月日));
        }

        @Test
        public void 戻り値の特定入所者認定申請中区分コードは_設定した値と同じ特定入所者認定申請中区分コードを返す() {
            business = sut.set特定入所者認定申請中区分コード(DbT3001JukyushaIdoRenrakuhyoEntityGenerator.DEFAULT_特定入所者認定申請中区分コード).build();
            assertThat(business.get特定入所者認定申請中区分コード(), is(DbT3001JukyushaIdoRenrakuhyoEntityGenerator.DEFAULT_特定入所者認定申請中区分コード));
        }

        @Test
        public void 戻り値の特定入所者介護サービス区分コードは_設定した値と同じ特定入所者介護サービス区分コードを返す() {
            business = sut.set特定入所者介護サービス区分コード(DbT3001JukyushaIdoRenrakuhyoEntityGenerator.DEFAULT_特定入所者介護サービス区分コード).build();
            assertThat(business.get特定入所者介護サービス区分コード(), is(DbT3001JukyushaIdoRenrakuhyoEntityGenerator.DEFAULT_特定入所者介護サービス区分コード));
        }

        @Test
        public void 戻り値の課税層の特例減額措置対象フラグは_設定した値と同じ課税層の特例減額措置対象フラグを返す() {
            business = sut.set課税層の特例減額措置対象フラグ(DbT3001JukyushaIdoRenrakuhyoEntityGenerator.DEFAULT_課税層の特例減額措置対象フラグ).build();
            assertThat(business.get課税層の特例減額措置対象フラグ(), is(DbT3001JukyushaIdoRenrakuhyoEntityGenerator.DEFAULT_課税層の特例減額措置対象フラグ));
        }

        @Test
        public void 戻り値の食費負担限度額は_設定した値と同じ食費負担限度額を返す() {
            business = sut.set食費負担限度額(DbT3001JukyushaIdoRenrakuhyoEntityGenerator.DEFAULT_食費負担限度額).build();
            assertThat(business.get食費負担限度額(), is(DbT3001JukyushaIdoRenrakuhyoEntityGenerator.DEFAULT_食費負担限度額));
        }

        @Test
        public void 戻り値の居住費ユニット型個室負担限度額は_設定した値と同じ居住費ユニット型個室負担限度額を返す() {
            business = sut.set居住費ユニット型個室負担限度額(DbT3001JukyushaIdoRenrakuhyoEntityGenerator.DEFAULT_居住費ユニット型個室負担限度額).build();
            assertThat(business.get居住費ユニット型個室負担限度額(), is(DbT3001JukyushaIdoRenrakuhyoEntityGenerator.DEFAULT_居住費ユニット型個室負担限度額));
        }

        @Test
        public void 戻り値の居住費ユニット型準個室負担限度額は_設定した値と同じ居住費ユニット型準個室負担限度額を返す() {
            business = sut.set居住費ユニット型準個室負担限度額(DbT3001JukyushaIdoRenrakuhyoEntityGenerator.DEFAULT_居住費ユニット型準個室負担限度額).build();
            assertThat(business.get居住費ユニット型準個室負担限度額(), is(DbT3001JukyushaIdoRenrakuhyoEntityGenerator.DEFAULT_居住費ユニット型準個室負担限度額));
        }

        @Test
        public void 戻り値の居住費従来型個室特養等負担限度額は_設定した値と同じ居住費従来型個室特養等負担限度額を返す() {
            business = sut.set居住費従来型個室特養等負担限度額(DbT3001JukyushaIdoRenrakuhyoEntityGenerator.DEFAULT_居住費従来型個室特養等負担限度額).build();
            assertThat(business.get居住費従来型個室特養等負担限度額(), is(DbT3001JukyushaIdoRenrakuhyoEntityGenerator.DEFAULT_居住費従来型個室特養等負担限度額));
        }

        @Test
        public void 戻り値の居住費従来型個室老健療養等負担限度額は_設定した値と同じ居住費従来型個室老健療養等負担限度額を返す() {
            business = sut.set居住費従来型個室老健療養等負担限度額(DbT3001JukyushaIdoRenrakuhyoEntityGenerator.DEFAULT_居住費従来型個室老健療養等負担限度額).build();
            assertThat(business.get居住費従来型個室老健療養等負担限度額(), is(DbT3001JukyushaIdoRenrakuhyoEntityGenerator.DEFAULT_居住費従来型個室老健療養等負担限度額));
        }

        @Test
        public void 戻り値の居住費多床室負担限度額は_設定した値と同じ居住費多床室負担限度額を返す() {
            business = sut.set居住費多床室負担限度額(DbT3001JukyushaIdoRenrakuhyoEntityGenerator.DEFAULT_居住費多床室負担限度額).build();
            assertThat(business.get居住費多床室負担限度額(), is(DbT3001JukyushaIdoRenrakuhyoEntityGenerator.DEFAULT_居住費多床室負担限度額));
        }

        @Test
        public void 戻り値の負担限度額適用開始年月日は_設定した値と同じ負担限度額適用開始年月日を返す() {
            business = sut.set負担限度額適用開始年月日(DbT3001JukyushaIdoRenrakuhyoEntityGenerator.DEFAULT_負担限度額適用開始年月日).build();
            assertThat(business.get負担限度額適用開始年月日(), is(DbT3001JukyushaIdoRenrakuhyoEntityGenerator.DEFAULT_負担限度額適用開始年月日));
        }

        @Test
        public void 戻り値の負担限度額適用終了年月日は_設定した値と同じ負担限度額適用終了年月日を返す() {
            business = sut.set負担限度額適用終了年月日(DbT3001JukyushaIdoRenrakuhyoEntityGenerator.DEFAULT_負担限度額適用終了年月日).build();
            assertThat(business.get負担限度額適用終了年月日(), is(DbT3001JukyushaIdoRenrakuhyoEntityGenerator.DEFAULT_負担限度額適用終了年月日));
        }

        @Test
        public void 戻り値の軽減率は_設定した値と同じ軽減率を返す() {
            business = sut.set軽減率(DbT3001JukyushaIdoRenrakuhyoEntityGenerator.DEFAULT_軽減率).build();
            assertThat(business.get軽減率(), is(DbT3001JukyushaIdoRenrakuhyoEntityGenerator.DEFAULT_軽減率));
        }

        @Test
        public void 戻り値の軽減率適用開始年月日は_設定した値と同じ軽減率適用開始年月日を返す() {
            business = sut.set軽減率適用開始年月日(DbT3001JukyushaIdoRenrakuhyoEntityGenerator.DEFAULT_軽減率適用開始年月日).build();
            assertThat(business.get軽減率適用開始年月日(), is(DbT3001JukyushaIdoRenrakuhyoEntityGenerator.DEFAULT_軽減率適用開始年月日));
        }

        @Test
        public void 戻り値の軽減率適用終了年月日は_設定した値と同じ軽減率適用終了年月日を返す() {
            business = sut.set軽減率適用終了年月日(DbT3001JukyushaIdoRenrakuhyoEntityGenerator.DEFAULT_軽減率適用終了年月日).build();
            assertThat(business.get軽減率適用終了年月日(), is(DbT3001JukyushaIdoRenrakuhyoEntityGenerator.DEFAULT_軽減率適用終了年月日));
        }

        @Test
        public void 戻り値の小多機能居宅介護利用開始月利用有フラグは_設定した値と同じ小多機能居宅介護利用開始月利用有フラグを返す() {
            business = sut.set小多機能居宅介護利用開始月利用有フラグ(DbT3001JukyushaIdoRenrakuhyoEntityGenerator.DEFAULT_小多機能居宅介護利用開始月利用有フラグ).build();
            assertThat(business.get小多機能居宅介護利用開始月利用有フラグ(), is(DbT3001JukyushaIdoRenrakuhyoEntityGenerator.DEFAULT_小多機能居宅介護利用開始月利用有フラグ));
        }

        @Test
        public void 戻り値の後期高齢者医療保険者番号は_設定した値と同じ後期高齢者医療保険者番号を返す() {
            business = sut.set後期高齢者医療保険者番号(DbT3001JukyushaIdoRenrakuhyoEntityGenerator.DEFAULT_後期高齢者医療保険者番号).build();
            assertThat(business.get後期高齢者医療保険者番号(), is(DbT3001JukyushaIdoRenrakuhyoEntityGenerator.DEFAULT_後期高齢者医療保険者番号));
        }

        @Test
        public void 戻り値の後期高齢者医療被保険者番号は_設定した値と同じ後期高齢者医療被保険者番号を返す() {
            business = sut.set後期高齢者医療被保険者番号(DbT3001JukyushaIdoRenrakuhyoEntityGenerator.DEFAULT_後期高齢者医療被保険者番号).build();
            assertThat(business.get後期高齢者医療被保険者番号(), is(DbT3001JukyushaIdoRenrakuhyoEntityGenerator.DEFAULT_後期高齢者医療被保険者番号));
        }

        @Test
        public void 戻り値の国民健康保険保険者番号は_設定した値と同じ国民健康保険保険者番号を返す() {
            business = sut.set国民健康保険保険者番号(DbT3001JukyushaIdoRenrakuhyoEntityGenerator.DEFAULT_国民健康保険保険者番号).build();
            assertThat(business.get国民健康保険保険者番号(), is(DbT3001JukyushaIdoRenrakuhyoEntityGenerator.DEFAULT_国民健康保険保険者番号));
        }

        @Test
        public void 戻り値の国民健康保険被保険者証番号は_設定した値と同じ国民健康保険被保険者証番号を返す() {
            business = sut.set国民健康保険被保険者証番号(DbT3001JukyushaIdoRenrakuhyoEntityGenerator.DEFAULT_国民健康保険被保険者証番号).build();
            assertThat(business.get国民健康保険被保険者証番号(), is(DbT3001JukyushaIdoRenrakuhyoEntityGenerator.DEFAULT_国民健康保険被保険者証番号));
        }

        @Test
        public void 戻り値の国民健康保険個人番号は_設定した値と同じ国民健康保険個人番号を返す() {
            business = sut.set国民健康保険個人番号(DbT3001JukyushaIdoRenrakuhyoEntityGenerator.DEFAULT_国民健康保険個人番号).build();
            assertThat(business.get国民健康保険個人番号(), is(DbT3001JukyushaIdoRenrakuhyoEntityGenerator.DEFAULT_国民健康保険個人番号));
        }

        @Test
        public void 戻り値の二次予防事業区分コードは_設定した値と同じ二次予防事業区分コードを返す() {
            business = sut.set二次予防事業区分コード(DbT3001JukyushaIdoRenrakuhyoEntityGenerator.DEFAULT_二次予防事業区分コード).build();
            assertThat(business.get二次予防事業区分コード(), is(DbT3001JukyushaIdoRenrakuhyoEntityGenerator.DEFAULT_二次予防事業区分コード));
        }

        @Test
        public void 戻り値の二次予防事業有効期間開始年月日は_設定した値と同じ二次予防事業有効期間開始年月日を返す() {
            business = sut.set二次予防事業有効期間開始年月日(DbT3001JukyushaIdoRenrakuhyoEntityGenerator.DEFAULT_二次予防事業有効期間開始年月日).build();
            assertThat(business.get二次予防事業有効期間開始年月日(), is(DbT3001JukyushaIdoRenrakuhyoEntityGenerator.DEFAULT_二次予防事業有効期間開始年月日));
        }

        @Test
        public void 戻り値の二次予防事業有効期間終了年月日は_設定した値と同じ二次予防事業有効期間終了年月日を返す() {
            business = sut.set二次予防事業有効期間終了年月日(DbT3001JukyushaIdoRenrakuhyoEntityGenerator.DEFAULT_二次予防事業有効期間終了年月日).build();
            assertThat(business.get二次予防事業有効期間終了年月日(), is(DbT3001JukyushaIdoRenrakuhyoEntityGenerator.DEFAULT_二次予防事業有効期間終了年月日));
        }

        @Test
        public void 戻り値の訂正連絡票フラグは_設定した値と同じ訂正連絡票フラグを返す() {
            business = sut.set訂正連絡票フラグ(DbT3001JukyushaIdoRenrakuhyoEntityGenerator.DEFAULT_訂正連絡票フラグ).build();
            assertThat(business.get訂正連絡票フラグ(), is(DbT3001JukyushaIdoRenrakuhyoEntityGenerator.DEFAULT_訂正連絡票フラグ));
        }

        @Test
        public void 戻り値の送付年月は_設定した値と同じ送付年月を返す() {
            business = sut.set送付年月(DbT3001JukyushaIdoRenrakuhyoEntityGenerator.DEFAULT_送付年月).build();
            assertThat(business.get送付年月(), is(DbT3001JukyushaIdoRenrakuhyoEntityGenerator.DEFAULT_送付年月));
        }

        @Test
        public void 戻り値の住所地特例対象者区分コードは_設定した値と同じ住所地特例対象者区分コードを返す() {
            business = sut.set住所地特例対象者区分コード(DbT3001JukyushaIdoRenrakuhyoEntityGenerator.DEFAULT_住所地特例対象者区分コード).build();
            assertThat(business.get住所地特例対象者区分コード(), is(DbT3001JukyushaIdoRenrakuhyoEntityGenerator.DEFAULT_住所地特例対象者区分コード));
        }

        @Test
        public void 戻り値の施設所在保険者番号は_設定した値と同じ施設所在保険者番号を返す() {
            business = sut.set施設所在保険者番号(DbT3001JukyushaIdoRenrakuhyoEntityGenerator.DEFAULT_施設所在保険者番号).build();
            assertThat(business.get施設所在保険者番号(), is(DbT3001JukyushaIdoRenrakuhyoEntityGenerator.DEFAULT_施設所在保険者番号));
        }

        @Test
        public void 戻り値の住所地特例適用開始日は_設定した値と同じ住所地特例適用開始日を返す() {
            business = sut.set住所地特例適用開始日(DbT3001JukyushaIdoRenrakuhyoEntityGenerator.DEFAULT_住所地特例適用開始日).build();
            assertThat(business.get住所地特例適用開始日(), is(DbT3001JukyushaIdoRenrakuhyoEntityGenerator.DEFAULT_住所地特例適用開始日));
        }

        @Test
        public void 戻り値の住所地特例適用終了日は_設定した値と同じ住所地特例適用終了日を返す() {
            business = sut.set住所地特例適用終了日(DbT3001JukyushaIdoRenrakuhyoEntityGenerator.DEFAULT_住所地特例適用終了日).build();
            assertThat(business.get住所地特例適用終了日(), is(DbT3001JukyushaIdoRenrakuhyoEntityGenerator.DEFAULT_住所地特例適用終了日));
        }

        @Test
        public void 戻り値の居宅費（新１）負担限度額は_設定した値と同じ居宅費（新１）負担限度額を返す() {
            business = sut.set居宅費（新１）負担限度額(DbT3001JukyushaIdoRenrakuhyoEntityGenerator.DEFAULT_居宅費（新１）負担限度額).build();
            assertThat(business.get居宅費（新１）負担限度額(), is(DbT3001JukyushaIdoRenrakuhyoEntityGenerator.DEFAULT_居宅費（新１）負担限度額));
        }

        @Test
        public void 戻り値の居宅費（新２）負担限度額は_設定した値と同じ居宅費（新２）負担限度額を返す() {
            business = sut.set居宅費（新２）負担限度額(DbT3001JukyushaIdoRenrakuhyoEntityGenerator.DEFAULT_居宅費（新２）負担限度額).build();
            assertThat(business.get居宅費（新２）負担限度額(), is(DbT3001JukyushaIdoRenrakuhyoEntityGenerator.DEFAULT_居宅費（新２）負担限度額));
        }

        @Test
        public void 戻り値の居宅費（新３）負担限度額は_設定した値と同じ居宅費（新３）負担限度額を返す() {
            business = sut.set居宅費（新３）負担限度額(DbT3001JukyushaIdoRenrakuhyoEntityGenerator.DEFAULT_居宅費（新３）負担限度額).build();
            assertThat(business.get居宅費（新３）負担限度額(), is(DbT3001JukyushaIdoRenrakuhyoEntityGenerator.DEFAULT_居宅費（新３）負担限度額));
        }

        @Test
        public void 戻り値の利用者負担割合有効開始日は_設定した値と同じ利用者負担割合有効開始日を返す() {
            business = sut.set利用者負担割合有効開始日(DbT3001JukyushaIdoRenrakuhyoEntityGenerator.DEFAULT_利用者負担割合有効開始日).build();
            assertThat(business.get利用者負担割合有効開始日(), is(DbT3001JukyushaIdoRenrakuhyoEntityGenerator.DEFAULT_利用者負担割合有効開始日));
        }

        @Test
        public void 戻り値の利用者負担割合有効終了日は_設定した値と同じ利用者負担割合有効終了日を返す() {
            business = sut.set利用者負担割合有効終了日(DbT3001JukyushaIdoRenrakuhyoEntityGenerator.DEFAULT_利用者負担割合有効終了日).build();
            assertThat(business.get利用者負担割合有効終了日(), is(DbT3001JukyushaIdoRenrakuhyoEntityGenerator.DEFAULT_利用者負担割合有効終了日));
        }

    }
}
