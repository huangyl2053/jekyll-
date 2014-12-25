/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.model;

import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT7023RendoHoryuTokuteiJushoEntityGenerator;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link RendoHoryuTokuteiJushoModel}のテストクラスです。
 *
 * @author LDNS 宋昕沢
 */
@RunWith(Enclosed.class)
public class RendoHoryuTokuteiJushoModelTest extends DbzTestBase {

    public static class getterSetterTest extends DbzTestBase {

        private static RendoHoryuTokuteiJushoModel sut;

        @BeforeClass
        public static void test() {
            sut = new RendoHoryuTokuteiJushoModel();
        }

        @Test
        public void 戻り値の管理番号は_設定した値と同じ管理番号を返す() {
            sut.set管理番号(DbT7023RendoHoryuTokuteiJushoEntityGenerator.DEFAULT_管理番号);
            assertThat(sut.get管理番号(), is(DbT7023RendoHoryuTokuteiJushoEntityGenerator.DEFAULT_管理番号));
        }

        @Test
        public void 戻り値の市町村コードは_設定した値と同じ市町村コードを返す() {
            sut.set市町村コード(DbT7023RendoHoryuTokuteiJushoEntityGenerator.DEFAULT_市町村コード);
            assertThat(sut.get市町村コード(), is(DbT7023RendoHoryuTokuteiJushoEntityGenerator.DEFAULT_市町村コード));
        }

        @Test
        public void 戻り値の住所コードは_設定した値と同じ住所コードを返す() {
            sut.set住所コード(DbT7023RendoHoryuTokuteiJushoEntityGenerator.DEFAULT_住所コード);
            assertThat(sut.get住所コード(), is(DbT7023RendoHoryuTokuteiJushoEntityGenerator.DEFAULT_住所コード));
        }

        @Test
        public void 戻り値の住所は_設定した値と同じ住所を返す() {
            sut.set住所(DbT7023RendoHoryuTokuteiJushoEntityGenerator.DEFAULT_住所);
            assertThat(sut.get住所(), is(DbT7023RendoHoryuTokuteiJushoEntityGenerator.DEFAULT_住所));
        }

        @Test
        public void 戻り値の番地コード１は_設定した値と同じ番地コード１を返す() {
            sut.set番地コード１(DbT7023RendoHoryuTokuteiJushoEntityGenerator.DEFAULT_番地コード１);
            assertThat(sut.get番地コード１(), is(DbT7023RendoHoryuTokuteiJushoEntityGenerator.DEFAULT_番地コード１));
        }

        @Test
        public void 戻り値の番地コード２は_設定した値と同じ番地コード２を返す() {
            sut.set番地コード２(DbT7023RendoHoryuTokuteiJushoEntityGenerator.DEFAULT_番地コード２);
            assertThat(sut.get番地コード２(), is(DbT7023RendoHoryuTokuteiJushoEntityGenerator.DEFAULT_番地コード２));
        }

        @Test
        public void 戻り値の番地コード３は_設定した値と同じ番地コード３を返す() {
            sut.set番地コード３(DbT7023RendoHoryuTokuteiJushoEntityGenerator.DEFAULT_番地コード３);
            assertThat(sut.get番地コード３(), is(DbT7023RendoHoryuTokuteiJushoEntityGenerator.DEFAULT_番地コード３));
        }

        @Test
        public void 戻り値の番地は_設定した値と同じ番地を返す() {
            sut.set番地(DbT7023RendoHoryuTokuteiJushoEntityGenerator.DEFAULT_番地);
            assertThat(sut.get番地(), is(DbT7023RendoHoryuTokuteiJushoEntityGenerator.DEFAULT_番地));
        }

        @Test
        public void 戻り値の方書コードは_設定した値と同じ方書コードを返す() {
            sut.set施設種類(DbT7023RendoHoryuTokuteiJushoEntityGenerator.DEFAULT_施設種類);
            assertThat(sut.get施設種類(), is(DbT7023RendoHoryuTokuteiJushoEntityGenerator.DEFAULT_施設種類));
        }

        @Test
        public void 戻り値の方書は_設定した値と同じ方書を返す() {
            sut.set方書(DbT7023RendoHoryuTokuteiJushoEntityGenerator.DEFAULT_施設コード);
            assertThat(sut.get施設コード(), is(DbT7023RendoHoryuTokuteiJushoEntityGenerator.DEFAULT_施設コード));
        }
    }

    public static class getStateTest extends DbzTestBase {

        @Test
        public void 状態Addedの取得確認() {
            RendoHoryuTokuteiJushoModel sut = new RendoHoryuTokuteiJushoModel();

            assertThat(sut.getState(), is(EntityDataState.Added));
        }

        @Test
        public void 状態Modifinedの取得確認() {
            RendoHoryuTokuteiJushoModel sut = new RendoHoryuTokuteiJushoModel();
            sut.setEntity(DbT7023RendoHoryuTokuteiJushoEntityGenerator.createDbT7023RendoHoryuTokuteiJushoEntity());

            sut.getEntity().initializeMd5();

            // TODO 主キー以外の項目を変更してください
//            sut.getEntity().setXXX(new XXX());
//            assertThat(sut.getState(), is(EntityDataState.Modified));
        }

        @Test
        public void 状態Unchangedの取得確認() {
            RendoHoryuTokuteiJushoModel sut = new RendoHoryuTokuteiJushoModel();
            sut.setEntity(DbT7023RendoHoryuTokuteiJushoEntityGenerator.createDbT7023RendoHoryuTokuteiJushoEntity());

            sut.getEntity().initializeMd5();

            assertThat(sut.getState(), is(EntityDataState.Unchanged));
        }

        @Test
        public void 状態Deletedの取得確認() {
            RendoHoryuTokuteiJushoModel sut = new RendoHoryuTokuteiJushoModel();
            sut.setEntity(DbT7023RendoHoryuTokuteiJushoEntityGenerator.createDbT7023RendoHoryuTokuteiJushoEntity());

            sut.getEntity().initializeMd5();

            sut.setDeletedState(true);

            assertThat(sut.getState(), is(EntityDataState.Deleted));
        }
    }
}
