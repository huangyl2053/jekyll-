/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.model;

import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT3043ShokanShokujiHiyoEntityGenerator;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link ShokanShokujiHiyoModel}のテストクラスです。
 *
 * @author LDNS 周杏月
 */
@RunWith(Enclosed.class)
public class ShokanShokujiHiyoModelTest extends DbzTestBase {

    public static class getterSetterTest extends DbzTestBase {

        private static ShokanShokujiHiyoModel sut;

        @BeforeClass
        public static void test() {
            sut = new ShokanShokujiHiyoModel();
        }

        @Test
        public void 戻り値の被保険者番号は_設定した値と同じ被保険者番号を返す() {
            sut.set被保険者番号(DbT3043ShokanShokujiHiyoEntityGenerator.DEFAULT_被保険者番号);
            assertThat(sut.get被保険者番号(), is(DbT3043ShokanShokujiHiyoEntityGenerator.DEFAULT_被保険者番号));
        }

        @Test
        public void 戻り値のサービス提供年月は_設定した値と同じサービス提供年月を返す() {
            sut.setサービス提供年月(DbT3043ShokanShokujiHiyoEntityGenerator.DEFAULT_サービス提供年月);
            assertThat(sut.getサービス提供年月(), is(DbT3043ShokanShokujiHiyoEntityGenerator.DEFAULT_サービス提供年月));
        }

        @Test
        public void 戻り値の整理番号は_設定した値と同じ整理番号を返す() {
            sut.set整理番号(DbT3043ShokanShokujiHiyoEntityGenerator.DEFAULT_整理番号);
            assertThat(sut.get整理番号(), is(DbT3043ShokanShokujiHiyoEntityGenerator.DEFAULT_整理番号));
        }

        @Test
        public void 戻り値の事業者番号は_設定した値と同じ事業者番号を返す() {
            sut.set事業者番号(DbT3043ShokanShokujiHiyoEntityGenerator.DEFAULT_事業者番号);
            assertThat(sut.get事業者番号(), is(DbT3043ShokanShokujiHiyoEntityGenerator.DEFAULT_事業者番号));
        }

        @Test
        public void 戻り値の様式番号は_設定した値と同じ様式番号を返す() {
            sut.set様式番号(DbT3043ShokanShokujiHiyoEntityGenerator.DEFAULT_様式番号);
            assertThat(sut.get様式番号(), is(DbT3043ShokanShokujiHiyoEntityGenerator.DEFAULT_様式番号));
        }

        @Test
        public void 戻り値の処理日時は_設定した値と同じ処理日時を返す() {
            sut.set処理日時(DbT3043ShokanShokujiHiyoEntityGenerator.DEFAULT_処理日時);
            assertThat(sut.get処理日時(), is(DbT3043ShokanShokujiHiyoEntityGenerator.DEFAULT_処理日時));
        }

        @Test
        public void 戻り値の基本提供日数は_設定した値と同じ基本提供日数を返す() {
            sut.set基本提供日数(DbT3043ShokanShokujiHiyoEntityGenerator.DEFAULT_基本提供日数);
            assertThat(sut.get基本提供日数(), is(DbT3043ShokanShokujiHiyoEntityGenerator.DEFAULT_基本提供日数));
        }

        @Test
        public void 戻り値の基本提供単価は_設定した値と同じ基本提供単価を返す() {
            sut.set基本提供単価(DbT3043ShokanShokujiHiyoEntityGenerator.DEFAULT_基本提供単価);
            assertThat(sut.get基本提供単価(), is(DbT3043ShokanShokujiHiyoEntityGenerator.DEFAULT_基本提供単価));
        }

        @Test
        public void 戻り値の基本提供金額は_設定した値と同じ基本提供金額を返す() {
            sut.set基本提供金額(DbT3043ShokanShokujiHiyoEntityGenerator.DEFAULT_基本提供金額);
            assertThat(sut.get基本提供金額(), is(DbT3043ShokanShokujiHiyoEntityGenerator.DEFAULT_基本提供金額));
        }

        @Test
        public void 戻り値の特別提供日数は_設定した値と同じ特別提供日数を返す() {
            sut.set特別提供日数(DbT3043ShokanShokujiHiyoEntityGenerator.DEFAULT_特別提供日数);
            assertThat(sut.get特別提供日数(), is(DbT3043ShokanShokujiHiyoEntityGenerator.DEFAULT_特別提供日数));
        }

        @Test
        public void 戻り値の特別提供単価は_設定した値と同じ特別提供単価を返す() {
            sut.set特別提供単価(DbT3043ShokanShokujiHiyoEntityGenerator.DEFAULT_特別提供単価);
            assertThat(sut.get特別提供単価(), is(DbT3043ShokanShokujiHiyoEntityGenerator.DEFAULT_特別提供単価));
        }

        @Test
        public void 戻り値の特別提供金額は_設定した値と同じ特別提供金額を返す() {
            sut.set特別提供金額(DbT3043ShokanShokujiHiyoEntityGenerator.DEFAULT_特別提供金額);
            assertThat(sut.get特別提供金額(), is(DbT3043ShokanShokujiHiyoEntityGenerator.DEFAULT_特別提供金額));
        }

        @Test
        public void 戻り値の食事提供延べ日数は_設定した値と同じ食事提供延べ日数を返す() {
            sut.set食事提供延べ日数(DbT3043ShokanShokujiHiyoEntityGenerator.DEFAULT_食事提供延べ日数);
            assertThat(sut.get食事提供延べ日数(), is(DbT3043ShokanShokujiHiyoEntityGenerator.DEFAULT_食事提供延べ日数));
        }

        @Test
        public void 戻り値の食事提供費合計は_設定した値と同じ食事提供費合計を返す() {
            sut.set食事提供費合計(DbT3043ShokanShokujiHiyoEntityGenerator.DEFAULT_食事提供費合計);
            assertThat(sut.get食事提供費合計(), is(DbT3043ShokanShokujiHiyoEntityGenerator.DEFAULT_食事提供費合計));
        }

        @Test
        public void 戻り値の標準負担額_月額は_設定した値と同じ標準負担額_月額を返す() {
            sut.set標準負担額_月額(DbT3043ShokanShokujiHiyoEntityGenerator.DEFAULT_標準負担額_月額);
            assertThat(sut.get標準負担額_月額(), is(DbT3043ShokanShokujiHiyoEntityGenerator.DEFAULT_標準負担額_月額));
        }

        @Test
        public void 戻り値の食事提供費請求額は_設定した値と同じ食事提供費請求額を返す() {
            sut.set食事提供費請求額(DbT3043ShokanShokujiHiyoEntityGenerator.DEFAULT_食事提供費請求額);
            assertThat(sut.get食事提供費請求額(), is(DbT3043ShokanShokujiHiyoEntityGenerator.DEFAULT_食事提供費請求額));
        }

        @Test
        public void 戻り値の標準負担額_日額は_設定した値と同じ標準負担額_日額を返す() {
            sut.set標準負担額_日額(DbT3043ShokanShokujiHiyoEntityGenerator.DEFAULT_標準負担額_日額);
            assertThat(sut.get標準負担額_日額(), is(DbT3043ShokanShokujiHiyoEntityGenerator.DEFAULT_標準負担額_日額));
        }

        @Test
        public void 戻り値の支給区分コードは_設定した値と同じ支給区分コードを返す() {
            sut.set支給区分コード(DbT3043ShokanShokujiHiyoEntityGenerator.DEFAULT_支給区分コード);
            assertThat(sut.get支給区分コード(), is(DbT3043ShokanShokujiHiyoEntityGenerator.DEFAULT_支給区分コード));
        }

        @Test
        public void 戻り値の点数金額は_設定した値と同じ点数金額を返す() {
            sut.set点数金額(DbT3043ShokanShokujiHiyoEntityGenerator.DEFAULT_点数金額);
            assertThat(sut.get点数金額(), is(DbT3043ShokanShokujiHiyoEntityGenerator.DEFAULT_点数金額));
        }

        @Test
        public void 戻り値の支給金額は_設定した値と同じ支給金額を返す() {
            sut.set支給金額(DbT3043ShokanShokujiHiyoEntityGenerator.DEFAULT_支給金額);
            assertThat(sut.get支給金額(), is(DbT3043ShokanShokujiHiyoEntityGenerator.DEFAULT_支給金額));
        }

        @Test
        public void 戻り値の増減点は_設定した値と同じ増減点を返す() {
            sut.set増減点(DbT3043ShokanShokujiHiyoEntityGenerator.DEFAULT_増減点);
            assertThat(sut.get増減点(), is(DbT3043ShokanShokujiHiyoEntityGenerator.DEFAULT_増減点));
        }
    }

    public static class getStateTest extends DbzTestBase {

        @Test
        public void 状態Addedの取得確認() {
            ShokanShokujiHiyoModel sut = new ShokanShokujiHiyoModel();

            assertThat(sut.getState(), is(EntityDataState.Added));
        }

       // @Test
        // public void 状態Modifinedの取得確認() {
        // ShokanShokujiHiyoModel sut = new ShokanShokujiHiyoModel();
        //sut.setEntity(DbT3043ShokanShokujiHiyoEntityGenerator.createDbT3043ShokanShokujiHiyoEntity());
           // sut.getEntity().initializeMd5();
            // TODO主キー以外の項目を変更してください
        //sut.getEntity().setXXX(new XXX());
            //assertThat(sut.getState(), is(EntityDataState.Modified));
        //}
        @Test
        public void 状態Unchangedの取得確認() {
            ShokanShokujiHiyoModel sut = new ShokanShokujiHiyoModel();
            sut.setEntity(DbT3043ShokanShokujiHiyoEntityGenerator.createDbT3043ShokanShokujiHiyoEntity());

            sut.getEntity().initializeMd5();

            assertThat(sut.getState(), is(EntityDataState.Unchanged));
        }

        @Test
        public void 状態Deletedの取得確認() {
            ShokanShokujiHiyoModel sut = new ShokanShokujiHiyoModel();
            sut.setEntity(DbT3043ShokanShokujiHiyoEntityGenerator.createDbT3043ShokanShokujiHiyoEntity());

            sut.getEntity().initializeMd5();

            sut.setDeletedState(true);

            assertThat(sut.getState(), is(EntityDataState.Deleted));
        }
    }
}
