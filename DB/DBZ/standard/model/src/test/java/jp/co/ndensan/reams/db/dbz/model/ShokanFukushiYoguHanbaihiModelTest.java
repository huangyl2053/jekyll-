/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.model;

import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT3048ShokanFukushiYoguHanbaihiEntityGenerator;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link ShokanFukushiYoguHanbaihiModel}のテストクラスです。
 *
 * @author LDNS 周杏月
 */
@RunWith(Enclosed.class)
public class ShokanFukushiYoguHanbaihiModelTest extends DbzTestBase {

    public static class getterSetterTest extends DbzTestBase {

        private static ShokanFukushiYoguHanbaihiModel sut;

        @BeforeClass
        public static void test() {
            sut = new ShokanFukushiYoguHanbaihiModel();
        }

        @Test
        public void 戻り値の被保険者番号は_設定した値と同じ被保険者番号を返す() {
            sut.set被保険者番号(DbT3048ShokanFukushiYoguHanbaihiEntityGenerator.DEFAULT_被保険者番号);
            assertThat(sut.get被保険者番号(), is(DbT3048ShokanFukushiYoguHanbaihiEntityGenerator.DEFAULT_被保険者番号));
        }

        @Test
        public void 戻り値のサービス提供年月は_設定した値と同じサービス提供年月を返す() {
            sut.setサービス提供年月(DbT3048ShokanFukushiYoguHanbaihiEntityGenerator.DEFAULT_サービス提供年月);
            assertThat(sut.getサービス提供年月(), is(DbT3048ShokanFukushiYoguHanbaihiEntityGenerator.DEFAULT_サービス提供年月));
        }

        @Test
        public void 戻り値の整理番号は_設定した値と同じ整理番号を返す() {
            sut.set整理番号(DbT3048ShokanFukushiYoguHanbaihiEntityGenerator.DEFAULT_整理番号);
            assertThat(sut.get整理番号(), is(DbT3048ShokanFukushiYoguHanbaihiEntityGenerator.DEFAULT_整理番号));
        }

        @Test
        public void 戻り値の事業者番号は_設定した値と同じ事業者番号を返す() {
            sut.set事業者番号(DbT3048ShokanFukushiYoguHanbaihiEntityGenerator.DEFAULT_事業者番号);
            assertThat(sut.get事業者番号(), is(DbT3048ShokanFukushiYoguHanbaihiEntityGenerator.DEFAULT_事業者番号));
        }

        @Test
        public void 戻り値の様式番号は_設定した値と同じ様式番号を返す() {
            sut.set様式番号(DbT3048ShokanFukushiYoguHanbaihiEntityGenerator.DEFAULT_様式番号);
            assertThat(sut.get様式番号(), is(DbT3048ShokanFukushiYoguHanbaihiEntityGenerator.DEFAULT_様式番号));
        }

        @Test
        public void 戻り値の順次番号は_設定した値と同じ順次番号を返す() {
            sut.set順次番号(DbT3048ShokanFukushiYoguHanbaihiEntityGenerator.DEFAULT_順次番号);
            assertThat(sut.get順次番号(), is(DbT3048ShokanFukushiYoguHanbaihiEntityGenerator.DEFAULT_順次番号));
        }

        @Test
        public void 戻り値の処理日時は_設定した値と同じ処理日時を返す() {
            sut.set処理日時(DbT3048ShokanFukushiYoguHanbaihiEntityGenerator.DEFAULT_処理日時);
            assertThat(sut.get処理日時(), is(DbT3048ShokanFukushiYoguHanbaihiEntityGenerator.DEFAULT_処理日時));
        }

        @Test
        public void 戻り値のサービスコードは_設定した値と同じサービスコードを返す() {
            sut.setサービスコード(DbT3048ShokanFukushiYoguHanbaihiEntityGenerator.DEFAULT_サービスコード);
            assertThat(sut.getサービスコード(), is(DbT3048ShokanFukushiYoguHanbaihiEntityGenerator.DEFAULT_サービスコード));
        }

        @Test
        public void 戻り値の福祉用具販売年月日は_設定した値と同じ福祉用具販売年月日を返す() {
            sut.set福祉用具販売年月日(DbT3048ShokanFukushiYoguHanbaihiEntityGenerator.DEFAULT_福祉用具販売年月日);
            assertThat(sut.get福祉用具販売年月日(), is(DbT3048ShokanFukushiYoguHanbaihiEntityGenerator.DEFAULT_福祉用具販売年月日));
        }

        @Test
        public void 戻り値の福祉用具商品名は_設定した値と同じ福祉用具商品名を返す() {
            sut.set福祉用具商品名(DbT3048ShokanFukushiYoguHanbaihiEntityGenerator.DEFAULT_福祉用具商品名);
            assertThat(sut.get福祉用具商品名(), is(DbT3048ShokanFukushiYoguHanbaihiEntityGenerator.DEFAULT_福祉用具商品名));
        }

        @Test
        public void 戻り値の福祉用具種目コードは_設定した値と同じ福祉用具種目コードを返す() {
            sut.set福祉用具種目コード(DbT3048ShokanFukushiYoguHanbaihiEntityGenerator.DEFAULT_福祉用具種目コード);
            assertThat(sut.get福祉用具種目コード(), is(DbT3048ShokanFukushiYoguHanbaihiEntityGenerator.DEFAULT_福祉用具種目コード));
        }

        @Test
        public void 戻り値の福祉用具製造事業者名は_設定した値と同じ福祉用具製造事業者名を返す() {
            sut.set福祉用具製造事業者名(DbT3048ShokanFukushiYoguHanbaihiEntityGenerator.DEFAULT_福祉用具製造事業者名);
            assertThat(sut.get福祉用具製造事業者名(), is(DbT3048ShokanFukushiYoguHanbaihiEntityGenerator.DEFAULT_福祉用具製造事業者名));
        }

        @Test
        public void 戻り値の福祉用具販売事業者名は_設定した値と同じ福祉用具販売事業者名を返す() {
            sut.set福祉用具販売事業者名(DbT3048ShokanFukushiYoguHanbaihiEntityGenerator.DEFAULT_福祉用具販売事業者名);
            assertThat(sut.get福祉用具販売事業者名(), is(DbT3048ShokanFukushiYoguHanbaihiEntityGenerator.DEFAULT_福祉用具販売事業者名));
        }

        @Test
        public void 戻り値の購入金額は_設定した値と同じ購入金額を返す() {
            sut.set購入金額(DbT3048ShokanFukushiYoguHanbaihiEntityGenerator.DEFAULT_購入金額);
            assertThat(sut.get購入金額(), is(DbT3048ShokanFukushiYoguHanbaihiEntityGenerator.DEFAULT_購入金額));
        }

        @Test
        public void 戻り値の品目コードは_設定した値と同じ品目コードを返す() {
            sut.set品目コード(DbT3048ShokanFukushiYoguHanbaihiEntityGenerator.DEFAULT_品目コード);
            assertThat(sut.get品目コード(), is(DbT3048ShokanFukushiYoguHanbaihiEntityGenerator.DEFAULT_品目コード));
        }

        @Test
        public void 戻り値の審査方法区分コードは_設定した値と同じ審査方法区分コードを返す() {
            sut.set審査方法区分コード(DbT3048ShokanFukushiYoguHanbaihiEntityGenerator.DEFAULT_審査方法区分コード);
            assertThat(sut.get審査方法区分コード(), is(DbT3048ShokanFukushiYoguHanbaihiEntityGenerator.DEFAULT_審査方法区分コード));
        }

        @Test
        public void 戻り値の差額金額は_設定した値と同じ差額金額を返す() {
            sut.set差額金額(DbT3048ShokanFukushiYoguHanbaihiEntityGenerator.DEFAULT_差額金額);
            assertThat(sut.get差額金額(), is(DbT3048ShokanFukushiYoguHanbaihiEntityGenerator.DEFAULT_差額金額));
        }
    }

    public static class getStateTest extends DbzTestBase {

        @Test
        public void 状態Addedの取得確認() {
            ShokanFukushiYoguHanbaihiModel sut = new ShokanFukushiYoguHanbaihiModel();

            assertThat(sut.getState(), is(EntityDataState.Added));
        }

       // @Test
        // public void 状態Modifinedの取得確認() {
        // ShokanFukushiYoguHanbaihiModel sut = new ShokanFukushiYoguHanbaihiModel();
        //sut.setEntity(DbT3048ShokanFukushiYoguHanbaihiEntityGenerator.createDbT3048ShokanFukushiYoguHanbaihiEntity());
           // sut.getEntity().initializeMd5();
            // TODO主キー以外の項目を変更してください
        //sut.getEntity().setXXX(new XXX());
            //assertThat(sut.getState(), is(EntityDataState.Modified));
        //}
        @Test
        public void 状態Unchangedの取得確認() {
            ShokanFukushiYoguHanbaihiModel sut = new ShokanFukushiYoguHanbaihiModel();
            sut.setEntity(DbT3048ShokanFukushiYoguHanbaihiEntityGenerator.createDbT3048ShokanFukushiYoguHanbaihiEntity());

            sut.getEntity().initializeMd5();

            assertThat(sut.getState(), is(EntityDataState.Unchanged));
        }

        @Test
        public void 状態Deletedの取得確認() {
            ShokanFukushiYoguHanbaihiModel sut = new ShokanFukushiYoguHanbaihiModel();
            sut.setEntity(DbT3048ShokanFukushiYoguHanbaihiEntityGenerator.createDbT3048ShokanFukushiYoguHanbaihiEntity());

            sut.getEntity().initializeMd5();

            sut.setDeletedState(true);

            assertThat(sut.getState(), is(EntityDataState.Deleted));
        }
    }
}
