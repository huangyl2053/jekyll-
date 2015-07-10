/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.model;

import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT7119ServiceCodeEntityGenerator;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link ServiceCodeModel}のテストクラスです。
 *
 * @author LDNS 宋文娟
 */
@RunWith(Enclosed.class)
public class ServiceCodeModelTest extends DbzTestBase {

    public static class getterSetterTest extends DbzTestBase {

        private static ServiceCodeModel sut;

        @BeforeClass
        public static void test() {
            sut = new ServiceCodeModel();
        }

        @Test
        public void 戻り値のサービス種類コードは_設定した値と同じサービス種類コードを返す() {
            sut.setサービス種類コード(DbT7119ServiceCodeEntityGenerator.DEFAULT_サービス種類コード);
            assertThat(sut.getサービス種類コード(), is(DbT7119ServiceCodeEntityGenerator.DEFAULT_サービス種類コード));
        }

        @Test
        public void 戻り値のサービス項目コードは_設定した値と同じサービス項目コードを返す() {
            sut.setサービス項目コード(DbT7119ServiceCodeEntityGenerator.DEFAULT_サービス項目コード);
            assertThat(sut.getサービス項目コード(), is(DbT7119ServiceCodeEntityGenerator.DEFAULT_サービス項目コード));
        }

        @Test
        public void 戻り値の適用開始年月は_設定した値と同じ適用開始年月を返す() {
            sut.set適用開始年月(DbT7119ServiceCodeEntityGenerator.DEFAULT_適用開始年月);
            assertThat(sut.get適用開始年月(), is(DbT7119ServiceCodeEntityGenerator.DEFAULT_適用開始年月));
        }

        @Test
        public void 戻り値の処理日時は_設定した値と同じ処理日時を返す() {
            sut.set処理日時(DbT7119ServiceCodeEntityGenerator.DEFAULT_処理日時);
            assertThat(sut.get処理日時(), is(DbT7119ServiceCodeEntityGenerator.DEFAULT_処理日時));
        }

        @Test
        public void 戻り値の適用終了年月は_設定した値と同じ適用終了年月を返す() {
            sut.set適用終了年月(DbT7119ServiceCodeEntityGenerator.DEFAULT_適用終了年月);
            assertThat(sut.get適用終了年月(), is(DbT7119ServiceCodeEntityGenerator.DEFAULT_適用終了年月));
        }

        @Test
        public void 戻り値のサービス名称は_設定した値と同じサービス名称を返す() {
            sut.setサービス名称(DbT7119ServiceCodeEntityGenerator.DEFAULT_サービス名称);
            assertThat(sut.getサービス名称(), is(DbT7119ServiceCodeEntityGenerator.DEFAULT_サービス名称));
        }

        @Test
        public void 戻り値の単位数は_設定した値と同じ単位数を返す() {
            sut.set単位数(DbT7119ServiceCodeEntityGenerator.DEFAULT_単位数);
            assertThat(sut.get単位数(), is(DbT7119ServiceCodeEntityGenerator.DEFAULT_単位数));
        }

        @Test
        public void 戻り値の限度額対象外フラグは_設定した値と同じ限度額対象外フラグを返す() {
            sut.set限度額対象外フラグ(DbT7119ServiceCodeEntityGenerator.DEFAULT_限度額対象外フラグ);
            assertThat(sut.get限度額対象外フラグ(), is(DbT7119ServiceCodeEntityGenerator.DEFAULT_限度額対象外フラグ));
        }

        @Test
        public void 戻り値の単位数識別コードは_設定した値と同じ単位数識別コードを返す() {
            sut.set単位数識別コード(DbT7119ServiceCodeEntityGenerator.DEFAULT_単位数識別コード);
            assertThat(sut.get単位数識別コード(), is(DbT7119ServiceCodeEntityGenerator.DEFAULT_単位数識別コード));
        }

        @Test
        public void 戻り値の外部サービス利用型区分は_設定した値と同じ外部サービス利用型区分を返す() {
            sut.set外部サービス利用型区分(DbT7119ServiceCodeEntityGenerator.DEFAULT_外部サービス利用型区分);
            assertThat(sut.get外部サービス利用型区分(), is(DbT7119ServiceCodeEntityGenerator.DEFAULT_外部サービス利用型区分));
        }

        @Test
        public void 戻り値の特別地域加算フラグは_設定した値と同じ特別地域加算フラグを返す() {
            sut.set特別地域加算フラグ(DbT7119ServiceCodeEntityGenerator.DEFAULT_特別地域加算フラグ);
            assertThat(sut.get特別地域加算フラグ(), is(DbT7119ServiceCodeEntityGenerator.DEFAULT_特別地域加算フラグ));
        }

        @Test
        public void 戻り値の利用者負担定率_定額区分は_設定した値と同じ利用者負担定率_定額区分を返す() {
            sut.set利用者負担定率_定額区分(DbT7119ServiceCodeEntityGenerator.DEFAULT_利用者負担定率_定額区分);
            assertThat(sut.get利用者負担定率_定額区分(), is(DbT7119ServiceCodeEntityGenerator.DEFAULT_利用者負担定率_定額区分));
        }

        @Test
        public void 戻り値の利用者負担額は_設定した値と同じ利用者負担額を返す() {
            sut.set利用者負担額(DbT7119ServiceCodeEntityGenerator.DEFAULT_利用者負担額);
            assertThat(sut.get利用者負担額(), is(DbT7119ServiceCodeEntityGenerator.DEFAULT_利用者負担額));
        }

        @Test
        public void 戻り値の給付率は_設定した値と同じ給付率を返す() {
            sut.set給付率(DbT7119ServiceCodeEntityGenerator.DEFAULT_給付率);
            assertThat(sut.get給付率(), is(DbT7119ServiceCodeEntityGenerator.DEFAULT_給付率));
        }
    }

    public static class getStateTest extends DbzTestBase {

        @Test
        public void 状態Addedの取得確認() {
            ServiceCodeModel sut = new ServiceCodeModel();

            assertThat(sut.getState(), is(EntityDataState.Added));
        }

       // @Test
        // public void 状態Modifinedの取得確認() {
        // ServiceCodeModel sut = new ServiceCodeModel();
        //sut.setEntity(DbT7119ServiceCodeEntityGenerator.createDbT7119ServiceCodeEntity());
        // sut.getEntity().initializeMd5();
        // TODO主キー以外の項目を変更してください
        //sut.getEntity().setXXX(new XXX());
        //assertThat(sut.getState(), is(EntityDataState.Modified));
        //}
        @Test
        public void 状態Unchangedの取得確認() {
            ServiceCodeModel sut = new ServiceCodeModel();
            sut.setEntity(DbT7119ServiceCodeEntityGenerator.createDbT7119ServiceCodeEntity());

            sut.getEntity().initializeMd5();

            assertThat(sut.getState(), is(EntityDataState.Unchanged));
        }

        @Test
        public void 状態Deletedの取得確認() {
            ServiceCodeModel sut = new ServiceCodeModel();
            sut.setEntity(DbT7119ServiceCodeEntityGenerator.createDbT7119ServiceCodeEntity());

            sut.getEntity().initializeMd5();

            sut.setDeletedState(true);

            assertThat(sut.getState(), is(EntityDataState.Deleted));
        }
    }
}
