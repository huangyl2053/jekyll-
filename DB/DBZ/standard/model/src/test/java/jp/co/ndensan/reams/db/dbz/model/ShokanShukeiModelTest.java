/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.model;

import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT3053ShokanShukeiEntityGenerator;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link ShokanShukeiModel}のテストクラスです。
 *
 * @author LDNS 周杏月
 */
@RunWith(Enclosed.class)
public class ShokanShukeiModelTest extends DbzTestBase {

    public static class getterSetterTest extends DbzTestBase {

        private static ShokanShukeiModel sut;

        @BeforeClass
        public static void test() {
            sut = new ShokanShukeiModel();
        }

        @Test
        public void 戻り値の被保険者番号は_設定した値と同じ被保険者番号を返す() {
            sut.set被保険者番号(DbT3053ShokanShukeiEntityGenerator.DEFAULT_被保険者番号);
            assertThat(sut.get被保険者番号(), is(DbT3053ShokanShukeiEntityGenerator.DEFAULT_被保険者番号));
        }

        @Test
        public void 戻り値のサービス提供年月は_設定した値と同じサービス提供年月を返す() {
            sut.setサービス提供年月(DbT3053ShokanShukeiEntityGenerator.DEFAULT_サービス提供年月);
            assertThat(sut.getサービス提供年月(), is(DbT3053ShokanShukeiEntityGenerator.DEFAULT_サービス提供年月));
        }

        @Test
        public void 戻り値の整理番号は_設定した値と同じ整理番号を返す() {
            sut.set整理番号(DbT3053ShokanShukeiEntityGenerator.DEFAULT_整理番号);
            assertThat(sut.get整理番号(), is(DbT3053ShokanShukeiEntityGenerator.DEFAULT_整理番号));
        }

        @Test
        public void 戻り値の事業者番号は_設定した値と同じ事業者番号を返す() {
            sut.set事業者番号(DbT3053ShokanShukeiEntityGenerator.DEFAULT_事業者番号);
            assertThat(sut.get事業者番号(), is(DbT3053ShokanShukeiEntityGenerator.DEFAULT_事業者番号));
        }

        @Test
        public void 戻り値の様式番号は_設定した値と同じ様式番号を返す() {
            sut.set様式番号(DbT3053ShokanShukeiEntityGenerator.DEFAULT_様式番号);
            assertThat(sut.get様式番号(), is(DbT3053ShokanShukeiEntityGenerator.DEFAULT_様式番号));
        }

        @Test
        public void 戻り値の順次番号は_設定した値と同じ順次番号を返す() {
            sut.set順次番号(DbT3053ShokanShukeiEntityGenerator.DEFAULT_順次番号);
            assertThat(sut.get順次番号(), is(DbT3053ShokanShukeiEntityGenerator.DEFAULT_順次番号));
        }

        @Test
        public void 戻り値の処理日時は_設定した値と同じ処理日時を返す() {
            sut.set処理日時(DbT3053ShokanShukeiEntityGenerator.DEFAULT_処理日時);
            assertThat(sut.get処理日時(), is(DbT3053ShokanShukeiEntityGenerator.DEFAULT_処理日時));
        }

        @Test
        public void 戻り値のサービス種類コードは_設定した値と同じサービス種類コードを返す() {
            sut.setサービス種類コード(DbT3053ShokanShukeiEntityGenerator.DEFAULT_サービス種類コード);
            assertThat(sut.getサービス種類コード(), is(DbT3053ShokanShukeiEntityGenerator.DEFAULT_サービス種類コード));
        }

        @Test
        public void 戻り値のサービス実日数は_設定した値と同じサービス実日数を返す() {
            sut.setサービス実日数(DbT3053ShokanShukeiEntityGenerator.DEFAULT_サービス実日数);
            assertThat(sut.getサービス実日数(), is(DbT3053ShokanShukeiEntityGenerator.DEFAULT_サービス実日数));
        }

        @Test
        public void 戻り値の計画単位数は_設定した値と同じ計画単位数を返す() {
            sut.set計画単位数(DbT3053ShokanShukeiEntityGenerator.DEFAULT_計画単位数);
            assertThat(sut.get計画単位数(), is(DbT3053ShokanShukeiEntityGenerator.DEFAULT_計画単位数));
        }

        @Test
        public void 戻り値の限度額管理対象単位数は_設定した値と同じ限度額管理対象単位数を返す() {
            sut.set限度額管理対象単位数(DbT3053ShokanShukeiEntityGenerator.DEFAULT_限度額管理対象単位数);
            assertThat(sut.get限度額管理対象単位数(), is(DbT3053ShokanShukeiEntityGenerator.DEFAULT_限度額管理対象単位数));
        }

        @Test
        public void 戻り値の限度額管理対象外単位数は_設定した値と同じ限度額管理対象外単位数を返す() {
            sut.set限度額管理対象外単位数(DbT3053ShokanShukeiEntityGenerator.DEFAULT_限度額管理対象外単位数);
            assertThat(sut.get限度額管理対象外単位数(), is(DbT3053ShokanShukeiEntityGenerator.DEFAULT_限度額管理対象外単位数));
        }

        @Test
        public void 戻り値の短期入所計画日数は_設定した値と同じ短期入所計画日数を返す() {
            sut.set短期入所計画日数(DbT3053ShokanShukeiEntityGenerator.DEFAULT_短期入所計画日数);
            assertThat(sut.get短期入所計画日数(), is(DbT3053ShokanShukeiEntityGenerator.DEFAULT_短期入所計画日数));
        }

        @Test
        public void 戻り値の短期入所実日数は_設定した値と同じ短期入所実日数を返す() {
            sut.set短期入所実日数(DbT3053ShokanShukeiEntityGenerator.DEFAULT_短期入所実日数);
            assertThat(sut.get短期入所実日数(), is(DbT3053ShokanShukeiEntityGenerator.DEFAULT_短期入所実日数));
        }

        @Test
        public void 戻り値の単位数合計は_設定した値と同じ単位数合計を返す() {
            sut.set単位数合計(DbT3053ShokanShukeiEntityGenerator.DEFAULT_単位数合計);
            assertThat(sut.get単位数合計(), is(DbT3053ShokanShukeiEntityGenerator.DEFAULT_単位数合計));
        }

        @Test
        public void 戻り値の単位数単価は_設定した値と同じ単位数単価を返す() {
            sut.set単位数単価(DbT3053ShokanShukeiEntityGenerator.DEFAULT_単位数単価);
            assertThat(sut.get単位数単価(), is(DbT3053ShokanShukeiEntityGenerator.DEFAULT_単位数単価));
        }

        @Test
        public void 戻り値の請求額は_設定した値と同じ請求額を返す() {
            sut.set請求額(DbT3053ShokanShukeiEntityGenerator.DEFAULT_請求額);
            assertThat(sut.get請求額(), is(DbT3053ShokanShukeiEntityGenerator.DEFAULT_請求額));
        }

        @Test
        public void 戻り値の利用者負担額は_設定した値と同じ利用者負担額を返す() {
            sut.set利用者負担額(DbT3053ShokanShukeiEntityGenerator.DEFAULT_利用者負担額);
            assertThat(sut.get利用者負担額(), is(DbT3053ShokanShukeiEntityGenerator.DEFAULT_利用者負担額));
        }

        @Test
        public void 戻り値の出来高医療費単位数合計は_設定した値と同じ出来高医療費単位数合計を返す() {
            sut.set出来高医療費単位数合計(DbT3053ShokanShukeiEntityGenerator.DEFAULT_出来高医療費単位数合計);
            assertThat(sut.get出来高医療費単位数合計(), is(DbT3053ShokanShukeiEntityGenerator.DEFAULT_出来高医療費単位数合計));
        }

        @Test
        public void 戻り値の出来高医療費請求額は_設定した値と同じ出来高医療費請求額を返す() {
            sut.set出来高医療費請求額(DbT3053ShokanShukeiEntityGenerator.DEFAULT_出来高医療費請求額);
            assertThat(sut.get出来高医療費請求額(), is(DbT3053ShokanShukeiEntityGenerator.DEFAULT_出来高医療費請求額));
        }

        @Test
        public void 戻り値の出来高医療費利用者負担額は_設定した値と同じ出来高医療費利用者負担額を返す() {
            sut.set出来高医療費利用者負担額(DbT3053ShokanShukeiEntityGenerator.DEFAULT_出来高医療費利用者負担額);
            assertThat(sut.get出来高医療費利用者負担額(), is(DbT3053ShokanShukeiEntityGenerator.DEFAULT_出来高医療費利用者負担額));
        }

        @Test
        public void 戻り値の審査方法区分コードは_設定した値と同じ審査方法区分コードを返す() {
            sut.set審査方法区分コード(DbT3053ShokanShukeiEntityGenerator.DEFAULT_審査方法区分コード);
            assertThat(sut.get審査方法区分コード(), is(DbT3053ShokanShukeiEntityGenerator.DEFAULT_審査方法区分コード));
        }

        @Test
        public void 戻り値の審査年月は_設定した値と同じ審査年月を返す() {
            sut.set審査年月(DbT3053ShokanShukeiEntityGenerator.DEFAULT_審査年月);
            assertThat(sut.get審査年月(), is(DbT3053ShokanShukeiEntityGenerator.DEFAULT_審査年月));
        }

        @Test
        public void 戻り値の支給区分コードは_設定した値と同じ支給区分コードを返す() {
            sut.set支給区分コード(DbT3053ShokanShukeiEntityGenerator.DEFAULT_支給区分コード);
            assertThat(sut.get支給区分コード(), is(DbT3053ShokanShukeiEntityGenerator.DEFAULT_支給区分コード));
        }

        @Test
        public void 戻り値の点数金額は_設定した値と同じ点数金額を返す() {
            sut.set点数金額(DbT3053ShokanShukeiEntityGenerator.DEFAULT_点数金額);
            assertThat(sut.get点数金額(), is(DbT3053ShokanShukeiEntityGenerator.DEFAULT_点数金額));
        }

        @Test
        public void 戻り値の支払金額は_設定した値と同じ支払金額を返す() {
            sut.set支払金額(DbT3053ShokanShukeiEntityGenerator.DEFAULT_支払金額);
            assertThat(sut.get支払金額(), is(DbT3053ShokanShukeiEntityGenerator.DEFAULT_支払金額));
        }

        @Test
        public void 戻り値の増減点は_設定した値と同じ増減点を返す() {
            sut.set増減点(DbT3053ShokanShukeiEntityGenerator.DEFAULT_増減点);
            assertThat(sut.get増減点(), is(DbT3053ShokanShukeiEntityGenerator.DEFAULT_増減点));
        }

        @Test
        public void 戻り値の請求額差額金額は_設定した値と同じ請求額差額金額を返す() {
            sut.set請求額差額金額(DbT3053ShokanShukeiEntityGenerator.DEFAULT_請求額差額金額);
            assertThat(sut.get請求額差額金額(), is(DbT3053ShokanShukeiEntityGenerator.DEFAULT_請求額差額金額));
        }

        @Test
        public void 戻り値の出来高請求額差額金額は_設定した値と同じ出来高請求額差額金額を返す() {
            sut.set出来高請求額差額金額(DbT3053ShokanShukeiEntityGenerator.DEFAULT_出来高請求額差額金額);
            assertThat(sut.get出来高請求額差額金額(), is(DbT3053ShokanShukeiEntityGenerator.DEFAULT_出来高請求額差額金額));
        }

        @Test
        public void 戻り値の増減理由等は_設定した値と同じ増減理由等を返す() {
            sut.set増減理由等(DbT3053ShokanShukeiEntityGenerator.DEFAULT_増減理由等);
            assertThat(sut.get増減理由等(), is(DbT3053ShokanShukeiEntityGenerator.DEFAULT_増減理由等));
        }

        @Test
        public void 戻り値の不支給理由等は_設定した値と同じ不支給理由等を返す() {
            sut.set不支給理由等(DbT3053ShokanShukeiEntityGenerator.DEFAULT_不支給理由等);
            assertThat(sut.get不支給理由等(), is(DbT3053ShokanShukeiEntityGenerator.DEFAULT_不支給理由等));
        }

        @Test
        public void 戻り値の購入_改修履歴等は_設定した値と同じ購入_改修履歴等を返す() {
            sut.set購入_改修履歴等(DbT3053ShokanShukeiEntityGenerator.DEFAULT_購入_改修履歴等);
            assertThat(sut.get購入_改修履歴等(), is(DbT3053ShokanShukeiEntityGenerator.DEFAULT_購入_改修履歴等));
        }
    }

    public static class getStateTest extends DbzTestBase {

        @Test
        public void 状態Addedの取得確認() {
            ShokanShukeiModel sut = new ShokanShukeiModel();

            assertThat(sut.getState(), is(EntityDataState.Added));
        }

       // @Test
        // public void 状態Modifinedの取得確認() {
        // ShokanShukeiModel sut = new ShokanShukeiModel();
        //sut.setEntity(DbT3053ShokanShukeiEntityGenerator.createDbT3053ShokanShukeiEntity());
           // sut.getEntity().initializeMd5();
            // TODO主キー以外の項目を変更してください
        //sut.getEntity().setXXX(new XXX());
            //assertThat(sut.getState(), is(EntityDataState.Modified));
        //}
        @Test
        public void 状態Unchangedの取得確認() {
            ShokanShukeiModel sut = new ShokanShukeiModel();
            sut.setEntity(DbT3053ShokanShukeiEntityGenerator.createDbT3053ShokanShukeiEntity());

            sut.getEntity().initializeMd5();

            assertThat(sut.getState(), is(EntityDataState.Unchanged));
        }

        @Test
        public void 状態Deletedの取得確認() {
            ShokanShukeiModel sut = new ShokanShukeiModel();
            sut.setEntity(DbT3053ShokanShukeiEntityGenerator.createDbT3053ShokanShukeiEntity());

            sut.getEntity().initializeMd5();

            sut.setDeletedState(true);

            assertThat(sut.getState(), is(EntityDataState.Deleted));
        }
    }
}
