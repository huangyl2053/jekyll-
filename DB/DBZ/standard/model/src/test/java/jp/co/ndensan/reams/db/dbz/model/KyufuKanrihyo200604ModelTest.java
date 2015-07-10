/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.model;

import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT3015KyufuKanrihyo200604EntityGenerator;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link KyufuKanrihyo200604Model}のテストクラスです。
 *
 * @author LDNS 鄭雪双
 */
@RunWith(Enclosed.class)
public class KyufuKanrihyo200604ModelTest extends DbzTestBase {

    public static class getterSetterTest extends DbzTestBase {

        private static KyufuKanrihyo200604Model sut;

        @BeforeClass
        public static void test() {
            sut = new KyufuKanrihyo200604Model();
        }

        @Test
        public void 戻り値の審査年月は_設定した値と同じ審査年月を返す() {
            sut.set審査年月(DbT3015KyufuKanrihyo200604EntityGenerator.DEFAULT_審査年月);
            assertThat(sut.get審査年月(), is(DbT3015KyufuKanrihyo200604EntityGenerator.DEFAULT_審査年月));
        }

        @Test
        public void 戻り値のサービス提供年月は_設定した値と同じサービス提供年月を返す() {
            sut.setサービス提供年月(DbT3015KyufuKanrihyo200604EntityGenerator.DEFAULT_サービス提供年月);
            assertThat(sut.getサービス提供年月(), is(DbT3015KyufuKanrihyo200604EntityGenerator.DEFAULT_サービス提供年月));
        }

        @Test
        public void 戻り値の証記載保険者番号は_設定した値と同じ証記載保険者番号を返す() {
            sut.set証記載保険者番号(DbT3015KyufuKanrihyo200604EntityGenerator.DEFAULT_証記載保険者番号);
            assertThat(sut.get証記載保険者番号(), is(DbT3015KyufuKanrihyo200604EntityGenerator.DEFAULT_証記載保険者番号));
        }

        @Test
        public void 戻り値の居宅支援事業所番号は_設定した値と同じ居宅支援事業所番号を返す() {
            sut.set居宅支援事業所番号(DbT3015KyufuKanrihyo200604EntityGenerator.DEFAULT_居宅支援事業所番号);
            assertThat(sut.get居宅支援事業所番号(), is(DbT3015KyufuKanrihyo200604EntityGenerator.DEFAULT_居宅支援事業所番号));
        }

        @Test
        public void 戻り値の給付管理票情報作成区分コードは_設定した値と同じ給付管理票情報作成区分コードを返す() {
            sut.set給付管理票情報作成区分コード(DbT3015KyufuKanrihyo200604EntityGenerator.DEFAULT_給付管理票情報作成区分コード);
            assertThat(sut.get給付管理票情報作成区分コード(), is(DbT3015KyufuKanrihyo200604EntityGenerator.DEFAULT_給付管理票情報作成区分コード));
        }

        @Test
        public void 戻り値の給付管理票作成年月日は_設定した値と同じ給付管理票作成年月日を返す() {
            sut.set給付管理票作成年月日(DbT3015KyufuKanrihyo200604EntityGenerator.DEFAULT_給付管理票作成年月日);
            assertThat(sut.get給付管理票作成年月日(), is(DbT3015KyufuKanrihyo200604EntityGenerator.DEFAULT_給付管理票作成年月日));
        }

        @Test
        public void 戻り値の給付管理票種別区分コードは_設定した値と同じ給付管理票種別区分コードを返す() {
            sut.set給付管理票種別区分コード(DbT3015KyufuKanrihyo200604EntityGenerator.DEFAULT_給付管理票種別区分コード);
            assertThat(sut.get給付管理票種別区分コード(), is(DbT3015KyufuKanrihyo200604EntityGenerator.DEFAULT_給付管理票種別区分コード));
        }

        @Test
        public void 戻り値の給付管理票明細行番号は_設定した値と同じ給付管理票明細行番号を返す() {
            sut.set給付管理票明細行番号(DbT3015KyufuKanrihyo200604EntityGenerator.DEFAULT_給付管理票明細行番号);
            assertThat(sut.get給付管理票明細行番号(), is(DbT3015KyufuKanrihyo200604EntityGenerator.DEFAULT_給付管理票明細行番号));
        }

        @Test
        public void 戻り値の保険者番号は_設定した値と同じ保険者番号を返す() {
            sut.set保険者番号(DbT3015KyufuKanrihyo200604EntityGenerator.DEFAULT_保険者番号);
            assertThat(sut.get保険者番号(), is(DbT3015KyufuKanrihyo200604EntityGenerator.DEFAULT_保険者番号));
        }

        @Test
        public void 戻り値の被保険者番号は_設定した値と同じ被保険者番号を返す() {
            sut.set被保険者番号(DbT3015KyufuKanrihyo200604EntityGenerator.DEFAULT_被保険者番号);
            assertThat(sut.get被保険者番号(), is(DbT3015KyufuKanrihyo200604EntityGenerator.DEFAULT_被保険者番号));
        }

        @Test
        public void 戻り値の被保険者生年月日は_設定した値と同じ被保険者生年月日を返す() {
            sut.set被保険者生年月日(DbT3015KyufuKanrihyo200604EntityGenerator.DEFAULT_被保険者生年月日);
            assertThat(sut.get被保険者生年月日(), is(DbT3015KyufuKanrihyo200604EntityGenerator.DEFAULT_被保険者生年月日));
        }

        @Test
        public void 戻り値の性別コードは_設定した値と同じ性別コードを返す() {
            sut.set性別コード(DbT3015KyufuKanrihyo200604EntityGenerator.DEFAULT_性別コード);
            assertThat(sut.get性別コード(), is(DbT3015KyufuKanrihyo200604EntityGenerator.DEFAULT_性別コード));
        }

        @Test
        public void 戻り値の要介護状態区分コードは_設定した値と同じ要介護状態区分コードを返す() {
            sut.set要介護状態区分コード(DbT3015KyufuKanrihyo200604EntityGenerator.DEFAULT_要介護状態区分コード);
            assertThat(sut.get要介護状態区分コード(), is(DbT3015KyufuKanrihyo200604EntityGenerator.DEFAULT_要介護状態区分コード));
        }

        @Test
        public void 戻り値の限度額適用開始年月は_設定した値と同じ限度額適用開始年月を返す() {
            sut.set限度額適用開始年月(DbT3015KyufuKanrihyo200604EntityGenerator.DEFAULT_限度額適用開始年月);
            assertThat(sut.get限度額適用開始年月(), is(DbT3015KyufuKanrihyo200604EntityGenerator.DEFAULT_限度額適用開始年月));
        }

        @Test
        public void 戻り値の限度額適用終了年月は_設定した値と同じ限度額適用終了年月を返す() {
            sut.set限度額適用終了年月(DbT3015KyufuKanrihyo200604EntityGenerator.DEFAULT_限度額適用終了年月);
            assertThat(sut.get限度額適用終了年月(), is(DbT3015KyufuKanrihyo200604EntityGenerator.DEFAULT_限度額適用終了年月));
        }

        @Test
        public void 戻り値の居宅_介護予防支給限度額は_設定した値と同じ居宅_介護予防支給限度額を返す() {
            sut.set居宅_介護予防支給限度額(DbT3015KyufuKanrihyo200604EntityGenerator.DEFAULT_居宅_介護予防支給限度額);
            assertThat(sut.get居宅_介護予防支給限度額(), is(DbT3015KyufuKanrihyo200604EntityGenerator.DEFAULT_居宅_介護予防支給限度額));
        }

        @Test
        public void 戻り値の居宅サービス計画作成区分コードは_設定した値と同じ居宅サービス計画作成区分コードを返す() {
            sut.set居宅サービス計画作成区分コード(DbT3015KyufuKanrihyo200604EntityGenerator.DEFAULT_居宅サービス計画作成区分コード);
            assertThat(sut.get居宅サービス計画作成区分コード(), is(DbT3015KyufuKanrihyo200604EntityGenerator.DEFAULT_居宅サービス計画作成区分コード));
        }

        @Test
        public void 戻り値のサービス事業所番号は_設定した値と同じサービス事業所番号を返す() {
            sut.setサービス事業所番号(DbT3015KyufuKanrihyo200604EntityGenerator.DEFAULT_サービス事業所番号);
            assertThat(sut.getサービス事業所番号(), is(DbT3015KyufuKanrihyo200604EntityGenerator.DEFAULT_サービス事業所番号));
        }

        @Test
        public void 戻り値の指定_基準該当_地域密着型サービス識別コードは_設定した値と同じ指定_基準該当_地域密着型サービス識別コードを返す() {
            sut.set指定_基準該当_地域密着型サービス識別コード(DbT3015KyufuKanrihyo200604EntityGenerator.DEFAULT_指定_基準該当_地域密着型サービス識別コード);
            assertThat(sut.get指定_基準該当_地域密着型サービス識別コード(), is(DbT3015KyufuKanrihyo200604EntityGenerator.DEFAULT_指定_基準該当_地域密着型サービス識別コード));
        }

        @Test
        public void 戻り値のサービス種類コードは_設定した値と同じサービス種類コードを返す() {
            sut.setサービス種類コード(DbT3015KyufuKanrihyo200604EntityGenerator.DEFAULT_サービス種類コード);
            assertThat(sut.getサービス種類コード(), is(DbT3015KyufuKanrihyo200604EntityGenerator.DEFAULT_サービス種類コード));
        }

        @Test
        public void 戻り値の給付計画単位数は_設定した値と同じ給付計画単位数を返す() {
            sut.set給付計画単位数(DbT3015KyufuKanrihyo200604EntityGenerator.DEFAULT_給付計画単位数);
            assertThat(sut.get給付計画単位数(), is(DbT3015KyufuKanrihyo200604EntityGenerator.DEFAULT_給付計画単位数));
        }

        @Test
        public void 戻り値の限度額管理期間における前月までの給付計画日数は_設定した値と同じ限度額管理期間における前月までの給付計画日数を返す() {
            sut.set限度額管理期間における前月までの給付計画日数(DbT3015KyufuKanrihyo200604EntityGenerator.DEFAULT_限度額管理期間における前月までの給付計画日数);
            assertThat(sut.get限度額管理期間における前月までの給付計画日数(), is(DbT3015KyufuKanrihyo200604EntityGenerator.DEFAULT_限度額管理期間における前月までの給付計画日数));
        }

        @Test
        public void 戻り値の指定サービス分小計は_設定した値と同じ指定サービス分小計を返す() {
            sut.set指定サービス分小計(DbT3015KyufuKanrihyo200604EntityGenerator.DEFAULT_指定サービス分小計);
            assertThat(sut.get指定サービス分小計(), is(DbT3015KyufuKanrihyo200604EntityGenerator.DEFAULT_指定サービス分小計));
        }

        @Test
        public void 戻り値の基準該当サービス分小計は_設定した値と同じ基準該当サービス分小計を返す() {
            sut.set基準該当サービス分小計(DbT3015KyufuKanrihyo200604EntityGenerator.DEFAULT_基準該当サービス分小計);
            assertThat(sut.get基準該当サービス分小計(), is(DbT3015KyufuKanrihyo200604EntityGenerator.DEFAULT_基準該当サービス分小計));
        }

        @Test
        public void 戻り値の給付計画合計単位数_日数は_設定した値と同じ給付計画合計単位数_日数を返す() {
            sut.set給付計画合計単位数_日数(DbT3015KyufuKanrihyo200604EntityGenerator.DEFAULT_給付計画合計単位数_日数);
            assertThat(sut.get給付計画合計単位数_日数(), is(DbT3015KyufuKanrihyo200604EntityGenerator.DEFAULT_給付計画合計単位数_日数));
        }

        @Test
        public void 戻り値の担当介護支援専門員番号は_設定した値と同じ担当介護支援専門員番号を返す() {
            sut.set担当介護支援専門員番号(DbT3015KyufuKanrihyo200604EntityGenerator.DEFAULT_担当介護支援専門員番号);
            assertThat(sut.get担当介護支援専門員番号(), is(DbT3015KyufuKanrihyo200604EntityGenerator.DEFAULT_担当介護支援専門員番号));
        }

        @Test
        public void 戻り値の委託先の居宅介護支援事業所番号は_設定した値と同じ委託先の居宅介護支援事業所番号を返す() {
            sut.set委託先の居宅介護支援事業所番号(DbT3015KyufuKanrihyo200604EntityGenerator.DEFAULT_委託先の居宅介護支援事業所番号);
            assertThat(sut.get委託先の居宅介護支援事業所番号(), is(DbT3015KyufuKanrihyo200604EntityGenerator.DEFAULT_委託先の居宅介護支援事業所番号));
        }

        @Test
        public void 戻り値の委託先の担当介護支援専門員番号は_設定した値と同じ委託先の担当介護支援専門員番号を返す() {
            sut.set委託先の担当介護支援専門員番号(DbT3015KyufuKanrihyo200604EntityGenerator.DEFAULT_委託先の担当介護支援専門員番号);
            assertThat(sut.get委託先の担当介護支援専門員番号(), is(DbT3015KyufuKanrihyo200604EntityGenerator.DEFAULT_委託先の担当介護支援専門員番号));
        }

        @Test
        public void 戻り値の当初登録年月日は_設定した値と同じ当初登録年月日を返す() {
            sut.set当初登録年月日(DbT3015KyufuKanrihyo200604EntityGenerator.DEFAULT_当初登録年月日);
            assertThat(sut.get当初登録年月日(), is(DbT3015KyufuKanrihyo200604EntityGenerator.DEFAULT_当初登録年月日));
        }

        @Test
        public void 戻り値の取込年月は_設定した値と同じ取込年月を返す() {
            sut.set取込年月(DbT3015KyufuKanrihyo200604EntityGenerator.DEFAULT_取込年月);
            assertThat(sut.get取込年月(), is(DbT3015KyufuKanrihyo200604EntityGenerator.DEFAULT_取込年月));
        }
    }

    public static class getStateTest extends DbzTestBase {

        @Test
        public void 状態Addedの取得確認() {
            KyufuKanrihyo200604Model sut = new KyufuKanrihyo200604Model();

            assertThat(sut.getState(), is(EntityDataState.Added));
        }

        @Test
        public void 状態Modifinedの取得確認() {
            KyufuKanrihyo200604Model sut = new KyufuKanrihyo200604Model();
            sut.setEntity(DbT3015KyufuKanrihyo200604EntityGenerator.createDbT3015KyufuKanrihyo200604Entity());

            sut.getEntity().initializeMd5();

            // 主キー以外の項目を変更してください
//            sut.getEntity().setXXX(new XXX());
//            assertThat(sut.getState(), is(EntityDataState.Modified));
        }

        @Test
        public void 状態Unchangedの取得確認() {
            KyufuKanrihyo200604Model sut = new KyufuKanrihyo200604Model();
            sut.setEntity(DbT3015KyufuKanrihyo200604EntityGenerator.createDbT3015KyufuKanrihyo200604Entity());

            sut.getEntity().initializeMd5();

            assertThat(sut.getState(), is(EntityDataState.Unchanged));
        }

        @Test
        public void 状態Deletedの取得確認() {
            KyufuKanrihyo200604Model sut = new KyufuKanrihyo200604Model();
            sut.setEntity(DbT3015KyufuKanrihyo200604EntityGenerator.createDbT3015KyufuKanrihyo200604Entity());

            sut.getEntity().initializeMd5();

            sut.setDeletedState(true);

            assertThat(sut.getState(), is(EntityDataState.Deleted));
        }
    }
}
