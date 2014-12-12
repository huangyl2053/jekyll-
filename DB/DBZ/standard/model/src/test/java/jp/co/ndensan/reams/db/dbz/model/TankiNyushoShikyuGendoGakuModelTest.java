/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.model;

import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT7110TankiNyushoShikyuGendoGakuEntityGenerator;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link TankiNyushoShikyuGendoGakuModel}のテストクラスです。
 *
 * @author LDNS 宋文娟
 */
@RunWith(Enclosed.class)
public class TankiNyushoShikyuGendoGakuModelTest extends DbzTestBase {

    public static class getterSetterTest extends DbzTestBase {

        private static TankiNyushoShikyuGendoGakuModel sut;

        @BeforeClass
        public static void test() {
            sut = new TankiNyushoShikyuGendoGakuModel();
        }

        @Test
        public void 戻り値の要介護状態区分は_設定した値と同じ要介護状態区分を返す() {
            sut.set要介護状態区分(DbT7110TankiNyushoShikyuGendoGakuEntityGenerator.DEFAULT_要介護状態区分);
            assertThat(sut.get要介護状態区分(), is(DbT7110TankiNyushoShikyuGendoGakuEntityGenerator.DEFAULT_要介護状態区分));
        }

        @Test
        public void 戻り値の適用開始年月は_設定した値と同じ適用開始年月を返す() {
            sut.set適用開始年月(DbT7110TankiNyushoShikyuGendoGakuEntityGenerator.DEFAULT_適用開始年月);
            assertThat(sut.get適用開始年月(), is(DbT7110TankiNyushoShikyuGendoGakuEntityGenerator.DEFAULT_適用開始年月));
        }

        @Test
        public void 戻り値の処理日時は_設定した値と同じ処理日時を返す() {
            sut.set処理日時(DbT7110TankiNyushoShikyuGendoGakuEntityGenerator.DEFAULT_処理日時);
            assertThat(sut.get処理日時(), is(DbT7110TankiNyushoShikyuGendoGakuEntityGenerator.DEFAULT_処理日時));
        }

        @Test
        public void 戻り値の適用終了年月は_設定した値と同じ適用終了年月を返す() {
            sut.set適用終了年月(DbT7110TankiNyushoShikyuGendoGakuEntityGenerator.DEFAULT_適用終了年月);
            assertThat(sut.get適用終了年月(), is(DbT7110TankiNyushoShikyuGendoGakuEntityGenerator.DEFAULT_適用終了年月));
        }

        @Test
        public void 戻り値の支給限度日数は_設定した値と同じ支給限度日数を返す() {
            sut.set支給限度日数(DbT7110TankiNyushoShikyuGendoGakuEntityGenerator.DEFAULT_支給限度日数);
            assertThat(sut.get支給限度日数(), is(DbT7110TankiNyushoShikyuGendoGakuEntityGenerator.DEFAULT_支給限度日数));
        }
    }

    public static class getStateTest extends DbzTestBase {

        @Test
        public void 状態Addedの取得確認() {
            TankiNyushoShikyuGendoGakuModel sut = new TankiNyushoShikyuGendoGakuModel();

            assertThat(sut.getState(), is(EntityDataState.Added));
        }

       // @Test
        // public void 状態Modifinedの取得確認() {
        // TankiNyushoShikyuGendoGakuModel sut = new TankiNyushoShikyuGendoGakuModel();
        //sut.setEntity(DbT7110TankiNyushoShikyuGendoGakuEntityGenerator.createDbT7110TankiNyushoShikyuGendoGakuEntity());
        // sut.getEntity().initializeMd5();
        // TODO主キー以外の項目を変更してください
        //sut.getEntity().setXXX(new XXX());
        //assertThat(sut.getState(), is(EntityDataState.Modified));
        //}
        @Test
        public void 状態Unchangedの取得確認() {
            TankiNyushoShikyuGendoGakuModel sut = new TankiNyushoShikyuGendoGakuModel();
            sut.setEntity(DbT7110TankiNyushoShikyuGendoGakuEntityGenerator.createDbT7110TankiNyushoShikyuGendoGakuEntity());

            sut.getEntity().initializeMd5();

            assertThat(sut.getState(), is(EntityDataState.Unchanged));
        }

        @Test
        public void 状態Deletedの取得確認() {
            TankiNyushoShikyuGendoGakuModel sut = new TankiNyushoShikyuGendoGakuModel();
            sut.setEntity(DbT7110TankiNyushoShikyuGendoGakuEntityGenerator.createDbT7110TankiNyushoShikyuGendoGakuEntity());

            sut.getEntity().initializeMd5();

            sut.setDeletedState(true);

            assertThat(sut.getState(), is(EntityDataState.Deleted));
        }
    }
}
