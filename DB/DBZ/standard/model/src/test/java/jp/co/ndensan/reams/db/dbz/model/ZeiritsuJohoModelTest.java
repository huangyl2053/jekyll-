/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.model;

import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT7102ZeiritsuJohoEntityGenerator;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link ZeiritsuJohoModel}のテストクラスです。
 *
 * @author LDNS 宋文娟
 */
@RunWith(Enclosed.class)
public class ZeiritsuJohoModelTest extends DbzTestBase {

    public static class getterSetterTest extends DbzTestBase {

        private static ZeiritsuJohoModel sut;

        @BeforeClass
        public static void test() {
            sut = new ZeiritsuJohoModel();
        }

        @Test
        public void 戻り値の税率は_設定した値と同じ税率を返す() {
            sut.set税率(DbT7102ZeiritsuJohoEntityGenerator.DEFAULT_税率);
            assertThat(sut.get税率(), is(DbT7102ZeiritsuJohoEntityGenerator.DEFAULT_税率));
        }

        @Test
        public void 戻り値の開始年月は_設定した値と同じ開始年月を返す() {
            sut.set開始年月(DbT7102ZeiritsuJohoEntityGenerator.DEFAULT_開始年月);
            assertThat(sut.get開始年月(), is(DbT7102ZeiritsuJohoEntityGenerator.DEFAULT_開始年月));
        }

        @Test
        public void 戻り値の終了年月は_設定した値と同じ終了年月を返す() {
            sut.set終了年月(DbT7102ZeiritsuJohoEntityGenerator.DEFAULT_終了年月);
            assertThat(sut.get終了年月(), is(DbT7102ZeiritsuJohoEntityGenerator.DEFAULT_終了年月));
        }
    }

    public static class getStateTest extends DbzTestBase {

        @Test
        public void 状態Addedの取得確認() {
            ZeiritsuJohoModel sut = new ZeiritsuJohoModel();

            assertThat(sut.getState(), is(EntityDataState.Added));
        }

       // @Test
        // public void 状態Modifinedの取得確認() {
        // ZeiritsuJohoModel sut = new ZeiritsuJohoModel();
        //sut.setEntity(DbT7102ZeiritsuJohoEntityGenerator.createDbT7102ZeiritsuJohoEntity());
        // sut.getEntity().initializeMd5();
        // TODO主キー以外の項目を変更してください
        //sut.getEntity().setXXX(new XXX());
        //assertThat(sut.getState(), is(EntityDataState.Modified));
        //}
        @Test
        public void 状態Unchangedの取得確認() {
            ZeiritsuJohoModel sut = new ZeiritsuJohoModel();
            sut.setEntity(DbT7102ZeiritsuJohoEntityGenerator.createDbT7102ZeiritsuJohoEntity());

            sut.getEntity().initializeMd5();

            assertThat(sut.getState(), is(EntityDataState.Unchanged));
        }

        @Test
        public void 状態Deletedの取得確認() {
            ZeiritsuJohoModel sut = new ZeiritsuJohoModel();
            sut.setEntity(DbT7102ZeiritsuJohoEntityGenerator.createDbT7102ZeiritsuJohoEntity());

            sut.getEntity().initializeMd5();

            sut.setDeletedState(true);

            assertThat(sut.getState(), is(EntityDataState.Deleted));
        }
    }
}
