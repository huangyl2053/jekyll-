/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.model;

import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT7025KoikiNoHatsubanEntityGenerator;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link KoikiNoHatsubanModel}のテストクラスです。
 *
 * @author LDNS 宋昕沢
 */
@RunWith(Enclosed.class)
public class KoikiNoHatsubanModelTest extends DbzTestBase {

    public static class getterSetterTest extends DbzTestBase {

        private static KoikiNoHatsubanModel sut;

        @BeforeClass
        public static void test() {
            sut = new KoikiNoHatsubanModel();
        }

        @Test
        public void 戻り値の市町村コードは_設定した値と同じ市町村コードを返す() {
            sut.set市町村コード(DbT7025KoikiNoHatsubanEntityGenerator.DEFAULT_市町村コード);
            assertThat(sut.get市町村コード(), is(DbT7025KoikiNoHatsubanEntityGenerator.DEFAULT_市町村コード));
        }

        @Test
        public void 戻り値のコード区分は_設定した値と同じコード区分を返す() {
            sut.setコード区分(DbT7025KoikiNoHatsubanEntityGenerator.DEFAULT_コード区分);
            assertThat(sut.getコード区分(), is(DbT7025KoikiNoHatsubanEntityGenerator.DEFAULT_コード区分));
        }

        @Test
        public void 戻り値の番号は_設定した値と同じ番号を返す() {
            sut.set番号(DbT7025KoikiNoHatsubanEntityGenerator.DEFAULT_番号);
            assertThat(sut.get番号(), is(DbT7025KoikiNoHatsubanEntityGenerator.DEFAULT_番号));
        }
    }

    public static class getStateTest extends DbzTestBase {

        @Test
        public void 状態Addedの取得確認() {
            KoikiNoHatsubanModel sut = new KoikiNoHatsubanModel();

            assertThat(sut.getState(), is(EntityDataState.Added));
        }

        @Test
        public void 状態Modifinedの取得確認() {
            KoikiNoHatsubanModel sut = new KoikiNoHatsubanModel();
            sut.setEntity(DbT7025KoikiNoHatsubanEntityGenerator.createDbT7025KoikiNoHatsubanEntity());

            sut.getEntity().initializeMd5();

//            // 主キー以外の項目を変更してください
//            sut.getEntity().setXXX(new XXX());
//            assertThat(sut.getState(), is(EntityDataState.Modified));
        }

        @Test
        public void 状態Unchangedの取得確認() {
            KoikiNoHatsubanModel sut = new KoikiNoHatsubanModel();
            sut.setEntity(DbT7025KoikiNoHatsubanEntityGenerator.createDbT7025KoikiNoHatsubanEntity());

            sut.getEntity().initializeMd5();

            assertThat(sut.getState(), is(EntityDataState.Unchanged));
        }

        @Test
        public void 状態Deletedの取得確認() {
            KoikiNoHatsubanModel sut = new KoikiNoHatsubanModel();
            sut.setEntity(DbT7025KoikiNoHatsubanEntityGenerator.createDbT7025KoikiNoHatsubanEntity());

            sut.getEntity().initializeMd5();

            sut.setDeletedState(true);

            assertThat(sut.getState(), is(EntityDataState.Deleted));
        }
    }
}
