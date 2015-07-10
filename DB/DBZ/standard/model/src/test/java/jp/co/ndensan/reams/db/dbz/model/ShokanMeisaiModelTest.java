/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.model;

import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT3039ShokanMeisaiEntityGenerator;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link ShokanMeisaiModel}のテストクラスです。
 *
 * @author LDNS 周杏月
 */
@RunWith(Enclosed.class)
public class ShokanMeisaiModelTest extends DbzTestBase {

    public static class getterSetterTest extends DbzTestBase {

        private static ShokanMeisaiModel sut;

        @BeforeClass
        public static void test() {
            sut = new ShokanMeisaiModel();
        }

        @Test
        public void 戻り値の被保険者番号は_設定した値と同じ被保険者番号を返す() {
            sut.set被保険者番号(DbT3039ShokanMeisaiEntityGenerator.DEFAULT_被保険者番号);
            assertThat(sut.get被保険者番号(), is(DbT3039ShokanMeisaiEntityGenerator.DEFAULT_被保険者番号));
        }

        @Test
        public void 戻り値のサービス提供年月は_設定した値と同じサービス提供年月を返す() {
            sut.setサービス提供年月(DbT3039ShokanMeisaiEntityGenerator.DEFAULT_サービス提供年月);
            assertThat(sut.getサービス提供年月(), is(DbT3039ShokanMeisaiEntityGenerator.DEFAULT_サービス提供年月));
        }

        @Test
        public void 戻り値の整理番号は_設定した値と同じ整理番号を返す() {
            sut.set整理番号(DbT3039ShokanMeisaiEntityGenerator.DEFAULT_整理番号);
            assertThat(sut.get整理番号(), is(DbT3039ShokanMeisaiEntityGenerator.DEFAULT_整理番号));
        }

        @Test
        public void 戻り値の事業者番号は_設定した値と同じ事業者番号を返す() {
            sut.set事業者番号(DbT3039ShokanMeisaiEntityGenerator.DEFAULT_事業者番号);
            assertThat(sut.get事業者番号(), is(DbT3039ShokanMeisaiEntityGenerator.DEFAULT_事業者番号));
        }

        @Test
        public void 戻り値の様式番号は_設定した値と同じ様式番号を返す() {
            sut.set様式番号(DbT3039ShokanMeisaiEntityGenerator.DEFAULT_様式番号);
            assertThat(sut.get様式番号(), is(DbT3039ShokanMeisaiEntityGenerator.DEFAULT_様式番号));
        }

        @Test
        public void 戻り値の順次番号は_設定した値と同じ順次番号を返す() {
            sut.set順次番号(DbT3039ShokanMeisaiEntityGenerator.DEFAULT_順次番号);
            assertThat(sut.get順次番号(), is(DbT3039ShokanMeisaiEntityGenerator.DEFAULT_順次番号));
        }

        @Test
        public void 戻り値の処理日時は_設定した値と同じ処理日時を返す() {
            sut.set処理日時(DbT3039ShokanMeisaiEntityGenerator.DEFAULT_処理日時);
            assertThat(sut.get処理日時(), is(DbT3039ShokanMeisaiEntityGenerator.DEFAULT_処理日時));
        }

        @Test
        public void 戻り値のサービス種類コードは_設定した値と同じサービス種類コードを返す() {
            sut.setサービス種類コード(DbT3039ShokanMeisaiEntityGenerator.DEFAULT_サービス種類コード);
            assertThat(sut.getサービス種類コード(), is(DbT3039ShokanMeisaiEntityGenerator.DEFAULT_サービス種類コード));
        }

        @Test
        public void 戻り値のサービス項目コードは_設定した値と同じサービス項目コードを返す() {
            sut.setサービス項目コード(DbT3039ShokanMeisaiEntityGenerator.DEFAULT_サービス項目コード);
            assertThat(sut.getサービス項目コード(), is(DbT3039ShokanMeisaiEntityGenerator.DEFAULT_サービス項目コード));
        }

        @Test
        public void 戻り値の単位数は_設定した値と同じ単位数を返す() {
            sut.set単位数(DbT3039ShokanMeisaiEntityGenerator.DEFAULT_単位数);
            assertThat(sut.get単位数(), is(DbT3039ShokanMeisaiEntityGenerator.DEFAULT_単位数));
        }

        @Test
        public void 戻り値の日数_回数は_設定した値と同じ日数_回数を返す() {
            sut.set日数_回数(DbT3039ShokanMeisaiEntityGenerator.DEFAULT_日数_回数);
            assertThat(sut.get日数_回数(), is(DbT3039ShokanMeisaiEntityGenerator.DEFAULT_日数_回数));
        }

        @Test
        public void 戻り値のサービス単位数は_設定した値と同じサービス単位数を返す() {
            sut.setサービス単位数(DbT3039ShokanMeisaiEntityGenerator.DEFAULT_サービス単位数);
            assertThat(sut.getサービス単位数(), is(DbT3039ShokanMeisaiEntityGenerator.DEFAULT_サービス単位数));
        }

        @Test
        public void 戻り値の摘要は_設定した値と同じ摘要を返す() {
            sut.set摘要(DbT3039ShokanMeisaiEntityGenerator.DEFAULT_摘要);
            assertThat(sut.get摘要(), is(DbT3039ShokanMeisaiEntityGenerator.DEFAULT_摘要));
        }
    }

    public static class getStateTest extends DbzTestBase {

        @Test
        public void 状態Addedの取得確認() {
            ShokanMeisaiModel sut = new ShokanMeisaiModel();

            assertThat(sut.getState(), is(EntityDataState.Added));
        }

       // @Test
        // public void 状態Modifinedの取得確認() {
        // ShokanMeisaiModel sut = new ShokanMeisaiModel();
        //sut.setEntity(DbT3039ShokanMeisaiEntityGenerator.createDbT3039ShokanMeisaiEntity());
           // sut.getEntity().initializeMd5();
            // TODO主キー以外の項目を変更してください
        //sut.getEntity().setXXX(new XXX());
            //assertThat(sut.getState(), is(EntityDataState.Modified));
        //}
        @Test
        public void 状態Unchangedの取得確認() {
            ShokanMeisaiModel sut = new ShokanMeisaiModel();
            sut.setEntity(DbT3039ShokanMeisaiEntityGenerator.createDbT3039ShokanMeisaiEntity());

            sut.getEntity().initializeMd5();

            assertThat(sut.getState(), is(EntityDataState.Unchanged));
        }

        @Test
        public void 状態Deletedの取得確認() {
            ShokanMeisaiModel sut = new ShokanMeisaiModel();
            sut.setEntity(DbT3039ShokanMeisaiEntityGenerator.createDbT3039ShokanMeisaiEntity());

            sut.getEntity().initializeMd5();

            sut.setDeletedState(true);

            assertThat(sut.getState(), is(EntityDataState.Deleted));
        }
    }
}
