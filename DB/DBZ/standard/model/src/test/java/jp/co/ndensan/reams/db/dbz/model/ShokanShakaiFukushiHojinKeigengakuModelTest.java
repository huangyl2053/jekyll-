/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.model;

import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT3051ShokanShakaiFukushiHojinKeigengakuEntityGenerator;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link ShokanShakaiFukushiHojinKeigengakuModel}のテストクラスです。
 *
 * @author LDNS 周杏月
 */
@RunWith(Enclosed.class)
public class ShokanShakaiFukushiHojinKeigengakuModelTest extends DbzTestBase {

    public static class getterSetterTest extends DbzTestBase {

        private static ShokanShakaiFukushiHojinKeigengakuModel sut;

        @BeforeClass
        public static void test() {
            sut = new ShokanShakaiFukushiHojinKeigengakuModel();
        }

        @Test
        public void 戻り値の被保険者番号は_設定した値と同じ被保険者番号を返す() {
            sut.set被保険者番号(DbT3051ShokanShakaiFukushiHojinKeigengakuEntityGenerator.DEFAULT_被保険者番号);
            assertThat(sut.get被保険者番号(), is(DbT3051ShokanShakaiFukushiHojinKeigengakuEntityGenerator.DEFAULT_被保険者番号));
        }

        @Test
        public void 戻り値のサービス提供年月は_設定した値と同じサービス提供年月を返す() {
            sut.setサービス提供年月(DbT3051ShokanShakaiFukushiHojinKeigengakuEntityGenerator.DEFAULT_サービス提供年月);
            assertThat(sut.getサービス提供年月(), is(DbT3051ShokanShakaiFukushiHojinKeigengakuEntityGenerator.DEFAULT_サービス提供年月));
        }

        @Test
        public void 戻り値の整理番号は_設定した値と同じ整理番号を返す() {
            sut.set整理番号(DbT3051ShokanShakaiFukushiHojinKeigengakuEntityGenerator.DEFAULT_整理番号);
            assertThat(sut.get整理番号(), is(DbT3051ShokanShakaiFukushiHojinKeigengakuEntityGenerator.DEFAULT_整理番号));
        }

        @Test
        public void 戻り値の事業者番号は_設定した値と同じ事業者番号を返す() {
            sut.set事業者番号(DbT3051ShokanShakaiFukushiHojinKeigengakuEntityGenerator.DEFAULT_事業者番号);
            assertThat(sut.get事業者番号(), is(DbT3051ShokanShakaiFukushiHojinKeigengakuEntityGenerator.DEFAULT_事業者番号));
        }

        @Test
        public void 戻り値の様式番号は_設定した値と同じ様式番号を返す() {
            sut.set様式番号(DbT3051ShokanShakaiFukushiHojinKeigengakuEntityGenerator.DEFAULT_様式番号);
            assertThat(sut.get様式番号(), is(DbT3051ShokanShakaiFukushiHojinKeigengakuEntityGenerator.DEFAULT_様式番号));
        }

        @Test
        public void 戻り値の順次番号は_設定した値と同じ順次番号を返す() {
            sut.set順次番号(DbT3051ShokanShakaiFukushiHojinKeigengakuEntityGenerator.DEFAULT_順次番号);
            assertThat(sut.get順次番号(), is(DbT3051ShokanShakaiFukushiHojinKeigengakuEntityGenerator.DEFAULT_順次番号));
        }

        @Test
        public void 戻り値の処理日時は_設定した値と同じ処理日時を返す() {
            sut.set処理日時(DbT3051ShokanShakaiFukushiHojinKeigengakuEntityGenerator.DEFAULT_処理日時);
            assertThat(sut.get処理日時(), is(DbT3051ShokanShakaiFukushiHojinKeigengakuEntityGenerator.DEFAULT_処理日時));
        }

        @Test
        public void 戻り値の軽減率は_設定した値と同じ軽減率を返す() {
            sut.set軽減率(DbT3051ShokanShakaiFukushiHojinKeigengakuEntityGenerator.DEFAULT_軽減率);
            assertThat(sut.get軽減率(), is(DbT3051ShokanShakaiFukushiHojinKeigengakuEntityGenerator.DEFAULT_軽減率));
        }

        @Test
        public void 戻り値のサービス種類コードは_設定した値と同じサービス種類コードを返す() {
            sut.setサービス種類コード(DbT3051ShokanShakaiFukushiHojinKeigengakuEntityGenerator.DEFAULT_サービス種類コード);
            assertThat(sut.getサービス種類コード(), is(DbT3051ShokanShakaiFukushiHojinKeigengakuEntityGenerator.DEFAULT_サービス種類コード));
        }

        @Test
        public void 戻り値の受領すべき利用者負担の総額は_設定した値と同じ受領すべき利用者負担の総額を返す() {
            sut.set受領すべき利用者負担の総額(DbT3051ShokanShakaiFukushiHojinKeigengakuEntityGenerator.DEFAULT_受領すべき利用者負担の総額);
            assertThat(sut.get受領すべき利用者負担の総額(), is(DbT3051ShokanShakaiFukushiHojinKeigengakuEntityGenerator.DEFAULT_受領すべき利用者負担の総額));
        }

        @Test
        public void 戻り値の軽減額は_設定した値と同じ軽減額を返す() {
            sut.set軽減額(DbT3051ShokanShakaiFukushiHojinKeigengakuEntityGenerator.DEFAULT_軽減額);
            assertThat(sut.get軽減額(), is(DbT3051ShokanShakaiFukushiHojinKeigengakuEntityGenerator.DEFAULT_軽減額));
        }

        @Test
        public void 戻り値の軽減後利用者負担額は_設定した値と同じ軽減後利用者負担額を返す() {
            sut.set軽減後利用者負担額(DbT3051ShokanShakaiFukushiHojinKeigengakuEntityGenerator.DEFAULT_軽減後利用者負担額);
            assertThat(sut.get軽減後利用者負担額(), is(DbT3051ShokanShakaiFukushiHojinKeigengakuEntityGenerator.DEFAULT_軽減後利用者負担額));
        }

        @Test
        public void 戻り値の備考は_設定した値と同じ備考を返す() {
            sut.set備考(DbT3051ShokanShakaiFukushiHojinKeigengakuEntityGenerator.DEFAULT_備考);
            assertThat(sut.get備考(), is(DbT3051ShokanShakaiFukushiHojinKeigengakuEntityGenerator.DEFAULT_備考));
        }
    }

    public static class getStateTest extends DbzTestBase {

        @Test
        public void 状態Addedの取得確認() {
            ShokanShakaiFukushiHojinKeigengakuModel sut = new ShokanShakaiFukushiHojinKeigengakuModel();

            assertThat(sut.getState(), is(EntityDataState.Added));
        }

       // @Test
        // public void 状態Modifinedの取得確認() {
        // ShokanShakaiFukushiHojinKeigengakuModel sut = new ShokanShakaiFukushiHojinKeigengakuModel();
        //sut.setEntity(DbT3051ShokanShakaiFukushiHojinKeigengakuEntityGenerator.createDbT3051ShokanShakaiFukushiHojinKeigengakuEntity());
           // sut.getEntity().initializeMd5();
            // TODO主キー以外の項目を変更してください
        //sut.getEntity().setXXX(new XXX());
            //assertThat(sut.getState(), is(EntityDataState.Modified));
        //}
        @Test
        public void 状態Unchangedの取得確認() {
            ShokanShakaiFukushiHojinKeigengakuModel sut = new ShokanShakaiFukushiHojinKeigengakuModel();
            sut.setEntity(DbT3051ShokanShakaiFukushiHojinKeigengakuEntityGenerator.createDbT3051ShokanShakaiFukushiHojinKeigengakuEntity());

            sut.getEntity().initializeMd5();

            assertThat(sut.getState(), is(EntityDataState.Unchanged));
        }

        @Test
        public void 状態Deletedの取得確認() {
            ShokanShakaiFukushiHojinKeigengakuModel sut = new ShokanShakaiFukushiHojinKeigengakuModel();
            sut.setEntity(DbT3051ShokanShakaiFukushiHojinKeigengakuEntityGenerator.createDbT3051ShokanShakaiFukushiHojinKeigengakuEntity());

            sut.getEntity().initializeMd5();

            sut.setDeletedState(true);

            assertThat(sut.getState(), is(EntityDataState.Deleted));
        }
    }
}
