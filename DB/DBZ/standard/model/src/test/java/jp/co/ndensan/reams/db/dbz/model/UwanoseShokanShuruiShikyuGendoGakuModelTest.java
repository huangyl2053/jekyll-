/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.model;

import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT7115UwanoseShokanShuruiShikyuGendoGakuEntityGenerator;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link UwanoseShokanShuruiShikyuGendoGakuModel}のテストクラスです。
 *
 * @author LDNS 宋文娟
 */
@RunWith(Enclosed.class)
public class UwanoseShokanShuruiShikyuGendoGakuModelTest extends DbzTestBase {

    public static class getterSetterTest extends DbzTestBase {

        private static UwanoseShokanShuruiShikyuGendoGakuModel sut;

        @BeforeClass
        public static void test() {
            sut = new UwanoseShokanShuruiShikyuGendoGakuModel();
        }

        @Test
        public void 戻り値のサービス種類コードは_設定した値と同じサービス種類コードを返す() {
            sut.setサービス種類コード(DbT7115UwanoseShokanShuruiShikyuGendoGakuEntityGenerator.DEFAULT_サービス種類コード);
            assertThat(sut.getサービス種類コード(), is(DbT7115UwanoseShokanShuruiShikyuGendoGakuEntityGenerator.DEFAULT_サービス種類コード));
        }

        @Test
        public void 戻り値の要介護状態区分は_設定した値と同じ要介護状態区分を返す() {
            sut.set要介護状態区分(DbT7115UwanoseShokanShuruiShikyuGendoGakuEntityGenerator.DEFAULT_要介護状態区分);
            assertThat(sut.get要介護状態区分(), is(DbT7115UwanoseShokanShuruiShikyuGendoGakuEntityGenerator.DEFAULT_要介護状態区分));
        }

        @Test
        public void 戻り値の適用開始年月は_設定した値と同じ適用開始年月を返す() {
            sut.set適用開始年月(DbT7115UwanoseShokanShuruiShikyuGendoGakuEntityGenerator.DEFAULT_適用開始年月);
            assertThat(sut.get適用開始年月(), is(DbT7115UwanoseShokanShuruiShikyuGendoGakuEntityGenerator.DEFAULT_適用開始年月));
        }

        @Test
        public void 戻り値の処理日時は_設定した値と同じ処理日時を返す() {
            sut.set処理日時(DbT7115UwanoseShokanShuruiShikyuGendoGakuEntityGenerator.DEFAULT_処理日時);
            assertThat(sut.get処理日時(), is(DbT7115UwanoseShokanShuruiShikyuGendoGakuEntityGenerator.DEFAULT_処理日時));
        }

        @Test
        public void 戻り値の適用終了年月は_設定した値と同じ適用終了年月を返す() {
            sut.set適用終了年月(DbT7115UwanoseShokanShuruiShikyuGendoGakuEntityGenerator.DEFAULT_適用終了年月);
            assertThat(sut.get適用終了年月(), is(DbT7115UwanoseShokanShuruiShikyuGendoGakuEntityGenerator.DEFAULT_適用終了年月));
        }

        @Test
        public void 戻り値の支給限度単位数は_設定した値と同じ支給限度単位数を返す() {
            sut.set支給限度単位数(DbT7115UwanoseShokanShuruiShikyuGendoGakuEntityGenerator.DEFAULT_支給限度単位数);
            assertThat(sut.get支給限度単位数(), is(DbT7115UwanoseShokanShuruiShikyuGendoGakuEntityGenerator.DEFAULT_支給限度単位数));
        }
    }

    public static class getStateTest extends DbzTestBase {

        @Test
        public void 状態Addedの取得確認() {
            UwanoseShokanShuruiShikyuGendoGakuModel sut = new UwanoseShokanShuruiShikyuGendoGakuModel();

            assertThat(sut.getState(), is(EntityDataState.Added));
        }

       // @Test
        // public void 状態Modifinedの取得確認() {
        // UwanoseShokanShuruiShikyuGendoGakuModel sut = new UwanoseShokanShuruiShikyuGendoGakuModel();
        //sut.setEntity(DbT7115UwanoseShokanShuruiShikyuGendoGakuEntityGenerator.createDbT7115UwanoseShokanShuruiShikyuGendoGakuEntity());
        // sut.getEntity().initializeMd5();
        // TODO主キー以外の項目を変更してください
        //sut.getEntity().setXXX(new XXX());
        //assertThat(sut.getState(), is(EntityDataState.Modified));
        //}
        @Test
        public void 状態Unchangedの取得確認() {
            UwanoseShokanShuruiShikyuGendoGakuModel sut = new UwanoseShokanShuruiShikyuGendoGakuModel();
            sut.setEntity(DbT7115UwanoseShokanShuruiShikyuGendoGakuEntityGenerator.createDbT7115UwanoseShokanShuruiShikyuGendoGakuEntity());

            sut.getEntity().initializeMd5();

            assertThat(sut.getState(), is(EntityDataState.Unchanged));
        }

        @Test
        public void 状態Deletedの取得確認() {
            UwanoseShokanShuruiShikyuGendoGakuModel sut = new UwanoseShokanShuruiShikyuGendoGakuModel();
            sut.setEntity(DbT7115UwanoseShokanShuruiShikyuGendoGakuEntityGenerator.createDbT7115UwanoseShokanShuruiShikyuGendoGakuEntity());

            sut.getEntity().initializeMd5();

            sut.setDeletedState(true);

            assertThat(sut.getState(), is(EntityDataState.Deleted));
        }
    }
}
