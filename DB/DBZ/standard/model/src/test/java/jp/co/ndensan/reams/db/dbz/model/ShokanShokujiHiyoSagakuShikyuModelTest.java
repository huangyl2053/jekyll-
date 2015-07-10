/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.model;

import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT3044ShokanShokujiHiyoSagakuShikyuEntityGenerator;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link ShokanShokujiHiyoSagakuShikyuModel}のテストクラスです。
 *
 * @author LDNS 周杏月
 */
@RunWith(Enclosed.class)
public class ShokanShokujiHiyoSagakuShikyuModelTest extends DbzTestBase {

    public static class getterSetterTest extends DbzTestBase {

        private static ShokanShokujiHiyoSagakuShikyuModel sut;

        @BeforeClass
        public static void test() {
            sut = new ShokanShokujiHiyoSagakuShikyuModel();
        }

        @Test
        public void 戻り値の被保険者番号は_設定した値と同じ被保険者番号を返す() {
            sut.set被保険者番号(DbT3044ShokanShokujiHiyoSagakuShikyuEntityGenerator.DEFAULT_被保険者番号);
            assertThat(sut.get被保険者番号(), is(DbT3044ShokanShokujiHiyoSagakuShikyuEntityGenerator.DEFAULT_被保険者番号));
        }

        @Test
        public void 戻り値のサービス提供年月は_設定した値と同じサービス提供年月を返す() {
            sut.setサービス提供年月(DbT3044ShokanShokujiHiyoSagakuShikyuEntityGenerator.DEFAULT_サービス提供年月);
            assertThat(sut.getサービス提供年月(), is(DbT3044ShokanShokujiHiyoSagakuShikyuEntityGenerator.DEFAULT_サービス提供年月));
        }

        @Test
        public void 戻り値の整理番号は_設定した値と同じ整理番号を返す() {
            sut.set整理番号(DbT3044ShokanShokujiHiyoSagakuShikyuEntityGenerator.DEFAULT_整理番号);
            assertThat(sut.get整理番号(), is(DbT3044ShokanShokujiHiyoSagakuShikyuEntityGenerator.DEFAULT_整理番号));
        }

        @Test
        public void 戻り値の事業者番号は_設定した値と同じ事業者番号を返す() {
            sut.set事業者番号(DbT3044ShokanShokujiHiyoSagakuShikyuEntityGenerator.DEFAULT_事業者番号);
            assertThat(sut.get事業者番号(), is(DbT3044ShokanShokujiHiyoSagakuShikyuEntityGenerator.DEFAULT_事業者番号));
        }

        @Test
        public void 戻り値の様式番号は_設定した値と同じ様式番号を返す() {
            sut.set様式番号(DbT3044ShokanShokujiHiyoSagakuShikyuEntityGenerator.DEFAULT_様式番号);
            assertThat(sut.get様式番号(), is(DbT3044ShokanShokujiHiyoSagakuShikyuEntityGenerator.DEFAULT_様式番号));
        }

        @Test
        public void 戻り値の処理日時は_設定した値と同じ処理日時を返す() {
            sut.set処理日時(DbT3044ShokanShokujiHiyoSagakuShikyuEntityGenerator.DEFAULT_処理日時);
            assertThat(sut.get処理日時(), is(DbT3044ShokanShokujiHiyoSagakuShikyuEntityGenerator.DEFAULT_処理日時));
        }

        @Test
        public void 戻り値の差額金額は_設定した値と同じ差額金額を返す() {
            sut.set差額金額(DbT3044ShokanShokujiHiyoSagakuShikyuEntityGenerator.DEFAULT_差額金額);
            assertThat(sut.get差額金額(), is(DbT3044ShokanShokujiHiyoSagakuShikyuEntityGenerator.DEFAULT_差額金額));
        }

        @Test
        public void 戻り値の支給区分コードは_設定した値と同じ支給区分コードを返す() {
            sut.set支給区分コード(DbT3044ShokanShokujiHiyoSagakuShikyuEntityGenerator.DEFAULT_支給区分コード);
            assertThat(sut.get支給区分コード(), is(DbT3044ShokanShokujiHiyoSagakuShikyuEntityGenerator.DEFAULT_支給区分コード));
        }

        @Test
        public void 戻り値の点数金額は_設定した値と同じ点数金額を返す() {
            sut.set点数金額(DbT3044ShokanShokujiHiyoSagakuShikyuEntityGenerator.DEFAULT_点数金額);
            assertThat(sut.get点数金額(), is(DbT3044ShokanShokujiHiyoSagakuShikyuEntityGenerator.DEFAULT_点数金額));
        }

        @Test
        public void 戻り値の支給金額は_設定した値と同じ支給金額を返す() {
            sut.set支給金額(DbT3044ShokanShokujiHiyoSagakuShikyuEntityGenerator.DEFAULT_支給金額);
            assertThat(sut.get支給金額(), is(DbT3044ShokanShokujiHiyoSagakuShikyuEntityGenerator.DEFAULT_支給金額));
        }

        @Test
        public void 戻り値の支給_不支給理由は_設定した値と同じ支給_不支給理由を返す() {
            sut.set支給_不支給理由(DbT3044ShokanShokujiHiyoSagakuShikyuEntityGenerator.DEFAULT_支給_不支給理由);
            assertThat(sut.get支給_不支給理由(), is(DbT3044ShokanShokujiHiyoSagakuShikyuEntityGenerator.DEFAULT_支給_不支給理由));
        }
    }

    public static class getStateTest extends DbzTestBase {

        @Test
        public void 状態Addedの取得確認() {
            ShokanShokujiHiyoSagakuShikyuModel sut = new ShokanShokujiHiyoSagakuShikyuModel();

            assertThat(sut.getState(), is(EntityDataState.Added));
        }

       // @Test
        // public void 状態Modifinedの取得確認() {
        // ShokanShokujiHiyoSagakuShikyuModel sut = new ShokanShokujiHiyoSagakuShikyuModel();
        //sut.setEntity(DbT3044ShokanShokujiHiyoSagakuShikyuEntityGenerator.createDbT3044ShokanShokujiHiyoSagakuShikyuEntity());
        // sut.getEntity().initializeMd5();
        // TODO主キー以外の項目を変更してください
        //sut.getEntity().setXXX(new XXX());
        //assertThat(sut.getState(), is(EntityDataState.Modified));
        //}
        @Test
        public void 状態Unchangedの取得確認() {
            ShokanShokujiHiyoSagakuShikyuModel sut = new ShokanShokujiHiyoSagakuShikyuModel();
            sut.setEntity(DbT3044ShokanShokujiHiyoSagakuShikyuEntityGenerator.createDbT3044ShokanShokujiHiyoSagakuShikyuEntity());

            sut.getEntity().initializeMd5();

            assertThat(sut.getState(), is(EntityDataState.Unchanged));
        }

        @Test
        public void 状態Deletedの取得確認() {
            ShokanShokujiHiyoSagakuShikyuModel sut = new ShokanShokujiHiyoSagakuShikyuModel();
            sut.setEntity(DbT3044ShokanShokujiHiyoSagakuShikyuEntityGenerator.createDbT3044ShokanShokujiHiyoSagakuShikyuEntity());

            sut.getEntity().initializeMd5();

            sut.setDeletedState(true);

            assertThat(sut.getState(), is(EntityDataState.Deleted));
        }
    }
}
