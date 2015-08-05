/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.model;

import jp.co.ndensan.reams.db.dbc.model.ShokanJutakuKaishuModel;
import jp.co.ndensan.reams.db.dbc.entity.basic.helper.DbT3049ShokanJutakuKaishuEntityGenerator;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link ShokanJutakuKaishuModel}のテストクラスです。
 *
 * @author LDNS 周杏月
 */
@RunWith(Enclosed.class)
public class ShokanJutakuKaishuModelTest extends DbzTestBase {

    public static class getterSetterTest extends DbzTestBase {

        private static ShokanJutakuKaishuModel sut;

        @BeforeClass
        public static void test() {
            sut = new ShokanJutakuKaishuModel();
        }

        @Test
        public void 戻り値の被保険者番号は_設定した値と同じ被保険者番号を返す() {
            sut.set被保険者番号(DbT3049ShokanJutakuKaishuEntityGenerator.DEFAULT_被保険者番号);
            assertThat(sut.get被保険者番号(), is(DbT3049ShokanJutakuKaishuEntityGenerator.DEFAULT_被保険者番号));
        }

        @Test
        public void 戻り値のサービス提供年月は_設定した値と同じサービス提供年月を返す() {
            sut.setサービス提供年月(DbT3049ShokanJutakuKaishuEntityGenerator.DEFAULT_サービス提供年月);
            assertThat(sut.getサービス提供年月(), is(DbT3049ShokanJutakuKaishuEntityGenerator.DEFAULT_サービス提供年月));
        }

        @Test
        public void 戻り値の整理番号は_設定した値と同じ整理番号を返す() {
            sut.set整理番号(DbT3049ShokanJutakuKaishuEntityGenerator.DEFAULT_整理番号);
            assertThat(sut.get整理番号(), is(DbT3049ShokanJutakuKaishuEntityGenerator.DEFAULT_整理番号));
        }

        @Test
        public void 戻り値の事業者番号は_設定した値と同じ事業者番号を返す() {
            sut.set事業者番号(DbT3049ShokanJutakuKaishuEntityGenerator.DEFAULT_事業者番号);
            assertThat(sut.get事業者番号(), is(DbT3049ShokanJutakuKaishuEntityGenerator.DEFAULT_事業者番号));
        }

        @Test
        public void 戻り値の様式番号は_設定した値と同じ様式番号を返す() {
            sut.set様式番号(DbT3049ShokanJutakuKaishuEntityGenerator.DEFAULT_様式番号);
            assertThat(sut.get様式番号(), is(DbT3049ShokanJutakuKaishuEntityGenerator.DEFAULT_様式番号));
        }

        @Test
        public void 戻り値の順次番号は_設定した値と同じ順次番号を返す() {
            sut.set順次番号(DbT3049ShokanJutakuKaishuEntityGenerator.DEFAULT_順次番号);
            assertThat(sut.get順次番号(), is(DbT3049ShokanJutakuKaishuEntityGenerator.DEFAULT_順次番号));
        }

        @Test
        public void 戻り値のサービスコードは_設定した値と同じサービスコードを返す() {
            sut.setサービスコード(DbT3049ShokanJutakuKaishuEntityGenerator.DEFAULT_サービスコード);
            assertThat(sut.getサービスコード(), is(DbT3049ShokanJutakuKaishuEntityGenerator.DEFAULT_サービスコード));
        }

        @Test
        public void 戻り値の住宅改修着工年月日は_設定した値と同じ住宅改修着工年月日を返す() {
            sut.set住宅改修着工年月日(DbT3049ShokanJutakuKaishuEntityGenerator.DEFAULT_住宅改修着工年月日);
            assertThat(sut.get住宅改修着工年月日(), is(DbT3049ShokanJutakuKaishuEntityGenerator.DEFAULT_住宅改修着工年月日));
        }

        @Test
        public void 戻り値の住宅改修事業者名は_設定した値と同じ住宅改修事業者名を返す() {
            sut.set住宅改修事業者名(DbT3049ShokanJutakuKaishuEntityGenerator.DEFAULT_住宅改修事業者名);
            assertThat(sut.get住宅改修事業者名(), is(DbT3049ShokanJutakuKaishuEntityGenerator.DEFAULT_住宅改修事業者名));
        }

        @Test
        public void 戻り値の住宅改修住宅住所は_設定した値と同じ住宅改修住宅住所を返す() {
            sut.set住宅改修住宅住所(DbT3049ShokanJutakuKaishuEntityGenerator.DEFAULT_住宅改修住宅住所);
            assertThat(sut.get住宅改修住宅住所(), is(DbT3049ShokanJutakuKaishuEntityGenerator.DEFAULT_住宅改修住宅住所));
        }

        @Test
        public void 戻り値の改修金額は_設定した値と同じ改修金額を返す() {
            sut.set改修金額(DbT3049ShokanJutakuKaishuEntityGenerator.DEFAULT_改修金額);
            assertThat(sut.get改修金額(), is(DbT3049ShokanJutakuKaishuEntityGenerator.DEFAULT_改修金額));
        }

        @Test
        public void 戻り値の審査方法区分コードは_設定した値と同じ審査方法区分コードを返す() {
            sut.set審査方法区分コード(DbT3049ShokanJutakuKaishuEntityGenerator.DEFAULT_審査方法区分コード);
            assertThat(sut.get審査方法区分コード(), is(DbT3049ShokanJutakuKaishuEntityGenerator.DEFAULT_審査方法区分コード));
        }

        @Test
        public void 戻り値の住宅改修完成年月日は_設定した値と同じ住宅改修完成年月日を返す() {
            sut.set住宅改修完成年月日(DbT3049ShokanJutakuKaishuEntityGenerator.DEFAULT_住宅改修完成年月日);
            assertThat(sut.get住宅改修完成年月日(), is(DbT3049ShokanJutakuKaishuEntityGenerator.DEFAULT_住宅改修完成年月日));
        }

        @Test
        public void 戻り値の差額金額は_設定した値と同じ差額金額を返す() {
            sut.set差額金額(DbT3049ShokanJutakuKaishuEntityGenerator.DEFAULT_差額金額);
            assertThat(sut.get差額金額(), is(DbT3049ShokanJutakuKaishuEntityGenerator.DEFAULT_差額金額));
        }
    }

    public static class getStateTest extends DbzTestBase {

        @Test
        public void 状態Addedの取得確認() {
            ShokanJutakuKaishuModel sut = new ShokanJutakuKaishuModel();

            assertThat(sut.getState(), is(EntityDataState.Added));
        }

       // @Test
        // public void 状態Modifinedの取得確認() {
        // ShokanJutakuKaishuModel sut = new ShokanJutakuKaishuModel();
        //sut.setEntity(DbT3049ShokanJutakuKaishuEntityGenerator.createDbT3049ShokanJutakuKaishuEntity());
        // sut.getEntity().initializeMd5();
        // TODO主キー以外の項目を変更してください
        //sut.getEntity().setXXX(new XXX());
        //assertThat(sut.getState(), is(EntityDataState.Modified));
        //}
        @Test
        public void 状態Unchangedの取得確認() {
            ShokanJutakuKaishuModel sut = new ShokanJutakuKaishuModel();
            sut.setEntity(DbT3049ShokanJutakuKaishuEntityGenerator.createDbT3049ShokanJutakuKaishuEntity());

            sut.getEntity().initializeMd5();

            assertThat(sut.getState(), is(EntityDataState.Unchanged));
        }

        @Test
        public void 状態Deletedの取得確認() {
            ShokanJutakuKaishuModel sut = new ShokanJutakuKaishuModel();
            sut.setEntity(DbT3049ShokanJutakuKaishuEntityGenerator.createDbT3049ShokanJutakuKaishuEntity());

            sut.getEntity().initializeMd5();

            sut.setDeletedState(true);

            assertThat(sut.getState(), is(EntityDataState.Deleted));
        }
    }
}
