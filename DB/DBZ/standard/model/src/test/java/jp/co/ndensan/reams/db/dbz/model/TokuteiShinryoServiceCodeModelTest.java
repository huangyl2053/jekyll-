/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.model;

import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT7120TokuteiShinryoServiceCodeEntityGenerator;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link TokuteiShinryoServiceCodeModel}のテストクラスです。
 *
 * @author LDNS 宋文娟
 */
@RunWith(Enclosed.class)
public class TokuteiShinryoServiceCodeModelTest extends DbzTestBase {

    public static class getterSetterTest extends DbzTestBase {

        private static TokuteiShinryoServiceCodeModel sut;

        @BeforeClass
        public static void test() {
            sut = new TokuteiShinryoServiceCodeModel();
        }

        @Test
        public void 戻り値のサービス種類コードは_設定した値と同じサービス種類コードを返す() {
            sut.setサービス種類コード(DbT7120TokuteiShinryoServiceCodeEntityGenerator.DEFAULT_サービス種類コード);
            assertThat(sut.getサービス種類コード(), is(DbT7120TokuteiShinryoServiceCodeEntityGenerator.DEFAULT_サービス種類コード));
        }

        @Test
        public void 戻り値のサービス項目コードは_設定した値と同じサービス項目コードを返す() {
            sut.setサービス項目コード(DbT7120TokuteiShinryoServiceCodeEntityGenerator.DEFAULT_サービス項目コード);
            assertThat(sut.getサービス項目コード(), is(DbT7120TokuteiShinryoServiceCodeEntityGenerator.DEFAULT_サービス項目コード));
        }

        @Test
        public void 戻り値の適用開始年月は_設定した値と同じ適用開始年月を返す() {
            sut.set適用開始年月(DbT7120TokuteiShinryoServiceCodeEntityGenerator.DEFAULT_適用開始年月);
            assertThat(sut.get適用開始年月(), is(DbT7120TokuteiShinryoServiceCodeEntityGenerator.DEFAULT_適用開始年月));
        }

        @Test
        public void 戻り値の処理日時は_設定した値と同じ処理日時を返す() {
            sut.set処理日時(DbT7120TokuteiShinryoServiceCodeEntityGenerator.DEFAULT_処理日時);
            assertThat(sut.get処理日時(), is(DbT7120TokuteiShinryoServiceCodeEntityGenerator.DEFAULT_処理日時));
        }

        @Test
        public void 戻り値の適用終了年月は_設定した値と同じ適用終了年月を返す() {
            sut.set適用終了年月(DbT7120TokuteiShinryoServiceCodeEntityGenerator.DEFAULT_適用終了年月);
            assertThat(sut.get適用終了年月(), is(DbT7120TokuteiShinryoServiceCodeEntityGenerator.DEFAULT_適用終了年月));
        }

        @Test
        public void 戻り値のサービス名称は_設定した値と同じサービス名称を返す() {
            sut.setサービス名称(DbT7120TokuteiShinryoServiceCodeEntityGenerator.DEFAULT_サービス名称);
            assertThat(sut.getサービス名称(), is(DbT7120TokuteiShinryoServiceCodeEntityGenerator.DEFAULT_サービス名称));
        }

        @Test
        public void 戻り値の単位数は_設定した値と同じ単位数を返す() {
            sut.set単位数(DbT7120TokuteiShinryoServiceCodeEntityGenerator.DEFAULT_単位数);
            assertThat(sut.get単位数(), is(DbT7120TokuteiShinryoServiceCodeEntityGenerator.DEFAULT_単位数));
        }

        @Test
        public void 戻り値の単位数識別は_設定した値と同じ単位数識別を返す() {
            sut.set単位数識別(DbT7120TokuteiShinryoServiceCodeEntityGenerator.DEFAULT_単位数識別);
            assertThat(sut.get単位数識別(), is(DbT7120TokuteiShinryoServiceCodeEntityGenerator.DEFAULT_単位数識別));
        }

        @Test
        public void 戻り値の算定単位は_設定した値と同じ算定単位を返す() {
            sut.set算定単位(DbT7120TokuteiShinryoServiceCodeEntityGenerator.DEFAULT_算定単位);
            assertThat(sut.get算定単位(), is(DbT7120TokuteiShinryoServiceCodeEntityGenerator.DEFAULT_算定単位));
        }

        @Test
        public void 戻り値の合成識別区分は_設定した値と同じ合成識別区分を返す() {
            sut.set合成識別区分(DbT7120TokuteiShinryoServiceCodeEntityGenerator.DEFAULT_合成識別区分);
            assertThat(sut.get合成識別区分(), is(DbT7120TokuteiShinryoServiceCodeEntityGenerator.DEFAULT_合成識別区分));
        }

        @Test
        public void 戻り値の特定診療区分コードは_設定した値と同じ特定診療区分コードを返す() {
            sut.set特定診療区分コード(DbT7120TokuteiShinryoServiceCodeEntityGenerator.DEFAULT_特定診療区分コード);
            assertThat(sut.get特定診療区分コード(), is(DbT7120TokuteiShinryoServiceCodeEntityGenerator.DEFAULT_特定診療区分コード));
        }

        @Test
        public void 戻り値の特定診療項目コードは_設定した値と同じ特定診療項目コードを返す() {
            sut.set特定診療項目コード(DbT7120TokuteiShinryoServiceCodeEntityGenerator.DEFAULT_特定診療項目コード);
            assertThat(sut.get特定診療項目コード(), is(DbT7120TokuteiShinryoServiceCodeEntityGenerator.DEFAULT_特定診療項目コード));
        }

        @Test
        public void 戻り値の算定制約期間は_設定した値と同じ算定制約期間を返す() {
            sut.set算定制約期間(DbT7120TokuteiShinryoServiceCodeEntityGenerator.DEFAULT_算定制約期間);
            assertThat(sut.get算定制約期間(), is(DbT7120TokuteiShinryoServiceCodeEntityGenerator.DEFAULT_算定制約期間));
        }

        @Test
        public void 戻り値の算定制約回数は_設定した値と同じ算定制約回数を返す() {
            sut.set算定制約回数(DbT7120TokuteiShinryoServiceCodeEntityGenerator.DEFAULT_算定制約回数);
            assertThat(sut.get算定制約回数(), is(DbT7120TokuteiShinryoServiceCodeEntityGenerator.DEFAULT_算定制約回数));
        }
    }

    public static class getStateTest extends DbzTestBase {

        @Test
        public void 状態Addedの取得確認() {
            TokuteiShinryoServiceCodeModel sut = new TokuteiShinryoServiceCodeModel();

            assertThat(sut.getState(), is(EntityDataState.Added));
        }

       // @Test
        // public void 状態Modifinedの取得確認() {
        // TokuteiShinryoServiceCodeModel sut = new TokuteiShinryoServiceCodeModel();
        //sut.setEntity(DbT7120TokuteiShinryoServiceCodeEntityGenerator.createDbT7120TokuteiShinryoServiceCodeEntity());
        // sut.getEntity().initializeMd5();
        // TODO主キー以外の項目を変更してください
        //sut.getEntity().setXXX(new XXX());
        //assertThat(sut.getState(), is(EntityDataState.Modified));
        //}
        @Test
        public void 状態Unchangedの取得確認() {
            TokuteiShinryoServiceCodeModel sut = new TokuteiShinryoServiceCodeModel();
            sut.setEntity(DbT7120TokuteiShinryoServiceCodeEntityGenerator.createDbT7120TokuteiShinryoServiceCodeEntity());

            sut.getEntity().initializeMd5();

            assertThat(sut.getState(), is(EntityDataState.Unchanged));
        }

        @Test
        public void 状態Deletedの取得確認() {
            TokuteiShinryoServiceCodeModel sut = new TokuteiShinryoServiceCodeModel();
            sut.setEntity(DbT7120TokuteiShinryoServiceCodeEntityGenerator.createDbT7120TokuteiShinryoServiceCodeEntity());

            sut.getEntity().initializeMd5();

            sut.setDeletedState(true);

            assertThat(sut.getState(), is(EntityDataState.Deleted));
        }
    }
}
