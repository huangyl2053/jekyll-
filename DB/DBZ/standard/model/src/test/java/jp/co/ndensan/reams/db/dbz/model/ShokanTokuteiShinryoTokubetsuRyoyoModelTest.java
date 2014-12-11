/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.model;

import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT3042ShokanTokuteiShinryoTokubetsuRyoyoEntityGenerator;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link ShokanTokuteiShinryoTokubetsuRyoyoModel}のテストクラスです。
 *
 * @author LDNS 周杏月
 */
@RunWith(Enclosed.class)
public class ShokanTokuteiShinryoTokubetsuRyoyoModelTest extends DbzTestBase {

    public static class getterSetterTest extends DbzTestBase {

        private static ShokanTokuteiShinryoTokubetsuRyoyoModel sut;

        @BeforeClass
        public static void test() {
            sut = new ShokanTokuteiShinryoTokubetsuRyoyoModel();
        }

        @Test
        public void 戻り値の被保険者番号は_設定した値と同じ被保険者番号を返す() {
            sut.set被保険者番号(DbT3042ShokanTokuteiShinryoTokubetsuRyoyoEntityGenerator.DEFAULT_被保険者番号);
            assertThat(sut.get被保険者番号(), is(DbT3042ShokanTokuteiShinryoTokubetsuRyoyoEntityGenerator.DEFAULT_被保険者番号));
        }

        @Test
        public void 戻り値のサービス提供年月は_設定した値と同じサービス提供年月を返す() {
            sut.setサービス提供年月(DbT3042ShokanTokuteiShinryoTokubetsuRyoyoEntityGenerator.DEFAULT_サービス提供年月);
            assertThat(sut.getサービス提供年月(), is(DbT3042ShokanTokuteiShinryoTokubetsuRyoyoEntityGenerator.DEFAULT_サービス提供年月));
        }

        @Test
        public void 戻り値の整理番号は_設定した値と同じ整理番号を返す() {
            sut.set整理番号(DbT3042ShokanTokuteiShinryoTokubetsuRyoyoEntityGenerator.DEFAULT_整理番号);
            assertThat(sut.get整理番号(), is(DbT3042ShokanTokuteiShinryoTokubetsuRyoyoEntityGenerator.DEFAULT_整理番号));
        }

        @Test
        public void 戻り値の事業者番号は_設定した値と同じ事業者番号を返す() {
            sut.set事業者番号(DbT3042ShokanTokuteiShinryoTokubetsuRyoyoEntityGenerator.DEFAULT_事業者番号);
            assertThat(sut.get事業者番号(), is(DbT3042ShokanTokuteiShinryoTokubetsuRyoyoEntityGenerator.DEFAULT_事業者番号));
        }

        @Test
        public void 戻り値の様式番号は_設定した値と同じ様式番号を返す() {
            sut.set様式番号(DbT3042ShokanTokuteiShinryoTokubetsuRyoyoEntityGenerator.DEFAULT_様式番号);
            assertThat(sut.get様式番号(), is(DbT3042ShokanTokuteiShinryoTokubetsuRyoyoEntityGenerator.DEFAULT_様式番号));
        }

        @Test
        public void 戻り値の順次番号は_設定した値と同じ順次番号を返す() {
            sut.set順次番号(DbT3042ShokanTokuteiShinryoTokubetsuRyoyoEntityGenerator.DEFAULT_順次番号);
            assertThat(sut.get順次番号(), is(DbT3042ShokanTokuteiShinryoTokubetsuRyoyoEntityGenerator.DEFAULT_順次番号));
        }

        @Test
        public void 戻り値の処理日時は_設定した値と同じ処理日時を返す() {
            sut.set処理日時(DbT3042ShokanTokuteiShinryoTokubetsuRyoyoEntityGenerator.DEFAULT_処理日時);
            assertThat(sut.get処理日時(), is(DbT3042ShokanTokuteiShinryoTokubetsuRyoyoEntityGenerator.DEFAULT_処理日時));
        }

        @Test
        public void 戻り値の傷病名は_設定した値と同じ傷病名を返す() {
            sut.set傷病名(DbT3042ShokanTokuteiShinryoTokubetsuRyoyoEntityGenerator.DEFAULT_傷病名);
            assertThat(sut.get傷病名(), is(DbT3042ShokanTokuteiShinryoTokubetsuRyoyoEntityGenerator.DEFAULT_傷病名));
        }

        @Test
        public void 戻り値の識別番号は_設定した値と同じ識別番号を返す() {
            sut.set識別番号(DbT3042ShokanTokuteiShinryoTokubetsuRyoyoEntityGenerator.DEFAULT_識別番号);
            assertThat(sut.get識別番号(), is(DbT3042ShokanTokuteiShinryoTokubetsuRyoyoEntityGenerator.DEFAULT_識別番号));
        }

        @Test
        public void 戻り値の単位数は_設定した値と同じ単位数を返す() {
            sut.set単位数(DbT3042ShokanTokuteiShinryoTokubetsuRyoyoEntityGenerator.DEFAULT_単位数);
            assertThat(sut.get単位数(), is(DbT3042ShokanTokuteiShinryoTokubetsuRyoyoEntityGenerator.DEFAULT_単位数));
        }

        @Test
        public void 戻り値の回数は_設定した値と同じ回数を返す() {
            sut.set回数(DbT3042ShokanTokuteiShinryoTokubetsuRyoyoEntityGenerator.DEFAULT_回数);
            assertThat(sut.get回数(), is(DbT3042ShokanTokuteiShinryoTokubetsuRyoyoEntityGenerator.DEFAULT_回数));
        }

        @Test
        public void 戻り値のサービス単位数は_設定した値と同じサービス単位数を返す() {
            sut.setサービス単位数(DbT3042ShokanTokuteiShinryoTokubetsuRyoyoEntityGenerator.DEFAULT_サービス単位数);
            assertThat(sut.getサービス単位数(), is(DbT3042ShokanTokuteiShinryoTokubetsuRyoyoEntityGenerator.DEFAULT_サービス単位数));
        }

        @Test
        public void 戻り値の合計単位数は_設定した値と同じ合計単位数を返す() {
            sut.set合計単位数(DbT3042ShokanTokuteiShinryoTokubetsuRyoyoEntityGenerator.DEFAULT_合計単位数);
            assertThat(sut.get合計単位数(), is(DbT3042ShokanTokuteiShinryoTokubetsuRyoyoEntityGenerator.DEFAULT_合計単位数));
        }

        @Test
        public void 戻り値の摘要は_設定した値と同じ摘要を返す() {
            sut.set摘要(DbT3042ShokanTokuteiShinryoTokubetsuRyoyoEntityGenerator.DEFAULT_摘要);
            assertThat(sut.get摘要(), is(DbT3042ShokanTokuteiShinryoTokubetsuRyoyoEntityGenerator.DEFAULT_摘要));
        }
    }

    public static class getStateTest extends DbzTestBase {

        @Test
        public void 状態Addedの取得確認() {
            ShokanTokuteiShinryoTokubetsuRyoyoModel sut = new ShokanTokuteiShinryoTokubetsuRyoyoModel();

            assertThat(sut.getState(), is(EntityDataState.Added));
        }

       // @Test
        // public void 状態Modifinedの取得確認() {
        // ShokanTokuteiShinryoTokubetsuRyoyoModel sut = new ShokanTokuteiShinryoTokubetsuRyoyoModel();
        //sut.setEntity(DbT3042ShokanTokuteiShinryoTokubetsuRyoyoEntityGenerator.createDbT3042ShokanTokuteiShinryoTokubetsuRyoyoEntity());
           // sut.getEntity().initializeMd5();
            // TODO主キー以外の項目を変更してください
        //sut.getEntity().setXXX(new XXX());
            //assertThat(sut.getState(), is(EntityDataState.Modified));
        //}
        @Test
        public void 状態Unchangedの取得確認() {
            ShokanTokuteiShinryoTokubetsuRyoyoModel sut = new ShokanTokuteiShinryoTokubetsuRyoyoModel();
            sut.setEntity(DbT3042ShokanTokuteiShinryoTokubetsuRyoyoEntityGenerator.createDbT3042ShokanTokuteiShinryoTokubetsuRyoyoEntity());

            sut.getEntity().initializeMd5();

            assertThat(sut.getState(), is(EntityDataState.Unchanged));
        }

        @Test
        public void 状態Deletedの取得確認() {
            ShokanTokuteiShinryoTokubetsuRyoyoModel sut = new ShokanTokuteiShinryoTokubetsuRyoyoModel();
            sut.setEntity(DbT3042ShokanTokuteiShinryoTokubetsuRyoyoEntityGenerator.createDbT3042ShokanTokuteiShinryoTokubetsuRyoyoEntity());

            sut.getEntity().initializeMd5();

            sut.setDeletedState(true);

            assertThat(sut.getState(), is(EntityDataState.Deleted));
        }
    }
}
