/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.model;

import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT3050ShokanTokuteiNyushoshaKaigoServiceHiyoEntityGenerator;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link ShokanTokuteiNyushoshaKaigoServiceHiyoModel}のテストクラスです。
 *
 * @author LDNS 周杏月
 */
@RunWith(Enclosed.class)
public class ShokanTokuteiNyushoshaKaigoServiceHiyoModelTest extends DbzTestBase {

    public static class getterSetterTest extends DbzTestBase {

        private static ShokanTokuteiNyushoshaKaigoServiceHiyoModel sut;

        @BeforeClass
        public static void test() {
            sut = new ShokanTokuteiNyushoshaKaigoServiceHiyoModel();
        }

        @Test
        public void 戻り値の被保険者番号は_設定した値と同じ被保険者番号を返す() {
            sut.set被保険者番号(DbT3050ShokanTokuteiNyushoshaKaigoServiceHiyoEntityGenerator.DEFAULT_被保険者番号);
            assertThat(sut.get被保険者番号(), is(DbT3050ShokanTokuteiNyushoshaKaigoServiceHiyoEntityGenerator.DEFAULT_被保険者番号));
        }

        @Test
        public void 戻り値のサービス提供年月は_設定した値と同じサービス提供年月を返す() {
            sut.setサービス提供年月(DbT3050ShokanTokuteiNyushoshaKaigoServiceHiyoEntityGenerator.DEFAULT_サービス提供年月);
            assertThat(sut.getサービス提供年月(), is(DbT3050ShokanTokuteiNyushoshaKaigoServiceHiyoEntityGenerator.DEFAULT_サービス提供年月));
        }

        @Test
        public void 戻り値の整理番号は_設定した値と同じ整理番号を返す() {
            sut.set整理番号(DbT3050ShokanTokuteiNyushoshaKaigoServiceHiyoEntityGenerator.DEFAULT_整理番号);
            assertThat(sut.get整理番号(), is(DbT3050ShokanTokuteiNyushoshaKaigoServiceHiyoEntityGenerator.DEFAULT_整理番号));
        }

        @Test
        public void 戻り値の事業者番号は_設定した値と同じ事業者番号を返す() {
            sut.set事業者番号(DbT3050ShokanTokuteiNyushoshaKaigoServiceHiyoEntityGenerator.DEFAULT_事業者番号);
            assertThat(sut.get事業者番号(), is(DbT3050ShokanTokuteiNyushoshaKaigoServiceHiyoEntityGenerator.DEFAULT_事業者番号));
        }

        @Test
        public void 戻り値の様式番号は_設定した値と同じ様式番号を返す() {
            sut.set様式番号(DbT3050ShokanTokuteiNyushoshaKaigoServiceHiyoEntityGenerator.DEFAULT_様式番号);
            assertThat(sut.get様式番号(), is(DbT3050ShokanTokuteiNyushoshaKaigoServiceHiyoEntityGenerator.DEFAULT_様式番号));
        }

        @Test
        public void 戻り値の順次番号は_設定した値と同じ順次番号を返す() {
            sut.set順次番号(DbT3050ShokanTokuteiNyushoshaKaigoServiceHiyoEntityGenerator.DEFAULT_順次番号);
            assertThat(sut.get順次番号(), is(DbT3050ShokanTokuteiNyushoshaKaigoServiceHiyoEntityGenerator.DEFAULT_順次番号));
        }

        @Test
        public void 戻り値の処理日時は_設定した値と同じ処理日時を返す() {
            sut.set処理日時(DbT3050ShokanTokuteiNyushoshaKaigoServiceHiyoEntityGenerator.DEFAULT_処理日時);
            assertThat(sut.get処理日時(), is(DbT3050ShokanTokuteiNyushoshaKaigoServiceHiyoEntityGenerator.DEFAULT_処理日時));
        }

        @Test
        public void 戻り値のサービス種類コードは_設定した値と同じサービス種類コードを返す() {
            sut.setサービス種類コード(DbT3050ShokanTokuteiNyushoshaKaigoServiceHiyoEntityGenerator.DEFAULT_サービス種類コード);
            assertThat(sut.getサービス種類コード(), is(DbT3050ShokanTokuteiNyushoshaKaigoServiceHiyoEntityGenerator.DEFAULT_サービス種類コード));
        }

        @Test
        public void 戻り値のサービス項目コードは_設定した値と同じサービス項目コードを返す() {
            sut.setサービス項目コード(DbT3050ShokanTokuteiNyushoshaKaigoServiceHiyoEntityGenerator.DEFAULT_サービス項目コード);
            assertThat(sut.getサービス項目コード(), is(DbT3050ShokanTokuteiNyushoshaKaigoServiceHiyoEntityGenerator.DEFAULT_サービス項目コード));
        }

        @Test
        public void 戻り値の費用単価は_設定した値と同じ費用単価を返す() {
            sut.set費用単価(DbT3050ShokanTokuteiNyushoshaKaigoServiceHiyoEntityGenerator.DEFAULT_費用単価);
            assertThat(sut.get費用単価(), is(DbT3050ShokanTokuteiNyushoshaKaigoServiceHiyoEntityGenerator.DEFAULT_費用単価));
        }

        @Test
        public void 戻り値の負担限度額は_設定した値と同じ負担限度額を返す() {
            sut.set負担限度額(DbT3050ShokanTokuteiNyushoshaKaigoServiceHiyoEntityGenerator.DEFAULT_負担限度額);
            assertThat(sut.get負担限度額(), is(DbT3050ShokanTokuteiNyushoshaKaigoServiceHiyoEntityGenerator.DEFAULT_負担限度額));
        }

        @Test
        public void 戻り値の日数は_設定した値と同じ日数を返す() {
            sut.set日数(DbT3050ShokanTokuteiNyushoshaKaigoServiceHiyoEntityGenerator.DEFAULT_日数);
            assertThat(sut.get日数(), is(DbT3050ShokanTokuteiNyushoshaKaigoServiceHiyoEntityGenerator.DEFAULT_日数));
        }

        @Test
        public void 戻り値の費用額は_設定した値と同じ費用額を返す() {
            sut.set費用額(DbT3050ShokanTokuteiNyushoshaKaigoServiceHiyoEntityGenerator.DEFAULT_費用額);
            assertThat(sut.get費用額(), is(DbT3050ShokanTokuteiNyushoshaKaigoServiceHiyoEntityGenerator.DEFAULT_費用額));
        }

        @Test
        public void 戻り値の保険分請求額は_設定した値と同じ保険分請求額を返す() {
            sut.set保険分請求額(DbT3050ShokanTokuteiNyushoshaKaigoServiceHiyoEntityGenerator.DEFAULT_保険分請求額);
            assertThat(sut.get保険分請求額(), is(DbT3050ShokanTokuteiNyushoshaKaigoServiceHiyoEntityGenerator.DEFAULT_保険分請求額));
        }

        @Test
        public void 戻り値の利用者負担額は_設定した値と同じ利用者負担額を返す() {
            sut.set利用者負担額(DbT3050ShokanTokuteiNyushoshaKaigoServiceHiyoEntityGenerator.DEFAULT_利用者負担額);
            assertThat(sut.get利用者負担額(), is(DbT3050ShokanTokuteiNyushoshaKaigoServiceHiyoEntityGenerator.DEFAULT_利用者負担額));
        }

        @Test
        public void 戻り値の費用額合計は_設定した値と同じ費用額合計を返す() {
            sut.set費用額合計(DbT3050ShokanTokuteiNyushoshaKaigoServiceHiyoEntityGenerator.DEFAULT_費用額合計);
            assertThat(sut.get費用額合計(), is(DbT3050ShokanTokuteiNyushoshaKaigoServiceHiyoEntityGenerator.DEFAULT_費用額合計));
        }

        @Test
        public void 戻り値の保険分請求額合計は_設定した値と同じ保険分請求額合計を返す() {
            sut.set保険分請求額合計(DbT3050ShokanTokuteiNyushoshaKaigoServiceHiyoEntityGenerator.DEFAULT_保険分請求額合計);
            assertThat(sut.get保険分請求額合計(), is(DbT3050ShokanTokuteiNyushoshaKaigoServiceHiyoEntityGenerator.DEFAULT_保険分請求額合計));
        }

        @Test
        public void 戻り値の利用者負担額合計は_設定した値と同じ利用者負担額合計を返す() {
            sut.set利用者負担額合計(DbT3050ShokanTokuteiNyushoshaKaigoServiceHiyoEntityGenerator.DEFAULT_利用者負担額合計);
            assertThat(sut.get利用者負担額合計(), is(DbT3050ShokanTokuteiNyushoshaKaigoServiceHiyoEntityGenerator.DEFAULT_利用者負担額合計));
        }

        @Test
        public void 戻り値の支給区分コードは_設定した値と同じ支給区分コードを返す() {
            sut.set支給区分コード(DbT3050ShokanTokuteiNyushoshaKaigoServiceHiyoEntityGenerator.DEFAULT_支給区分コード);
            assertThat(sut.get支給区分コード(), is(DbT3050ShokanTokuteiNyushoshaKaigoServiceHiyoEntityGenerator.DEFAULT_支給区分コード));
        }

        @Test
        public void 戻り値の点数金額は_設定した値と同じ点数金額を返す() {
            sut.set点数金額(DbT3050ShokanTokuteiNyushoshaKaigoServiceHiyoEntityGenerator.DEFAULT_点数金額);
            assertThat(sut.get点数金額(), is(DbT3050ShokanTokuteiNyushoshaKaigoServiceHiyoEntityGenerator.DEFAULT_点数金額
            ));
        }

        @Test
        public void 戻り値の支給金額は_設定した値と同じ支給金額を返す() {
            sut.set支給金額(DbT3050ShokanTokuteiNyushoshaKaigoServiceHiyoEntityGenerator.DEFAULT_支給金額);
            assertThat(sut.get支給金額(), is(DbT3050ShokanTokuteiNyushoshaKaigoServiceHiyoEntityGenerator.DEFAULT_支給金額));
        }

        @Test
        public void 戻り値の増減点は_設定した値と同じ増減点を返す() {
            sut.set増減点(DbT3050ShokanTokuteiNyushoshaKaigoServiceHiyoEntityGenerator.DEFAULT_増減点);
            assertThat(sut.get増減点(), is(DbT3050ShokanTokuteiNyushoshaKaigoServiceHiyoEntityGenerator.DEFAULT_増減点));
        }

        @Test
        public void 戻り値の差額金額は_設定した値と同じ差額金額を返す() {
            sut.set差額金額(DbT3050ShokanTokuteiNyushoshaKaigoServiceHiyoEntityGenerator.DEFAULT_差額金額);
            assertThat(sut.get差額金額(), is(DbT3050ShokanTokuteiNyushoshaKaigoServiceHiyoEntityGenerator.DEFAULT_差額金額));
        }
    }

    public static class getStateTest extends DbzTestBase {

        @Test
        public void 状態Addedの取得確認() {
            ShokanTokuteiNyushoshaKaigoServiceHiyoModel sut = new ShokanTokuteiNyushoshaKaigoServiceHiyoModel();

            assertThat(sut.getState(), is(EntityDataState.Added));
        }

       // @Test
        // public void 状態Modifinedの取得確認() {
        // ShokanTokuteiNyushoshaKaigoServiceHiyoModel sut = new ShokanTokuteiNyushoshaKaigoServiceHiyoModel();
        //sut.setEntity(DbT3050ShokanTokuteiNyushoshaKaigoServiceHiyoEntityGenerator.createDbT3050ShokanTokuteiNyushoshaKaigoServiceHiyoEntity());
        // sut.getEntity().initializeMd5();
        // TODO主キー以外の項目を変更してください
        //sut.getEntity().setXXX(new XXX());
        //assertThat(sut.getState(), is(EntityDataState.Modified));
        //}
        @Test
        public void 状態Unchangedの取得確認() {
            ShokanTokuteiNyushoshaKaigoServiceHiyoModel sut = new ShokanTokuteiNyushoshaKaigoServiceHiyoModel();
            sut.setEntity(DbT3050ShokanTokuteiNyushoshaKaigoServiceHiyoEntityGenerator.createDbT3050ShokanTokuteiNyushoshaKaigoServiceHiyoEntity());

            sut.getEntity().initializeMd5();

            assertThat(sut.getState(), is(EntityDataState.Unchanged));
        }

        @Test
        public void 状態Deletedの取得確認() {
            ShokanTokuteiNyushoshaKaigoServiceHiyoModel sut = new ShokanTokuteiNyushoshaKaigoServiceHiyoModel();
            sut.setEntity(DbT3050ShokanTokuteiNyushoshaKaigoServiceHiyoEntityGenerator.createDbT3050ShokanTokuteiNyushoshaKaigoServiceHiyoEntity());

            sut.getEntity().initializeMd5();

            sut.setDeletedState(true);

            assertThat(sut.getState(), is(EntityDataState.Deleted));
        }
    }
}
