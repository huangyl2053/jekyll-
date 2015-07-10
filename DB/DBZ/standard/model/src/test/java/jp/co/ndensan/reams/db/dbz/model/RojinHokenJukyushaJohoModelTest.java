/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.model;

import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT7005RojinHokenJukyushaJohoEntityGenerator;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link RojinHokenJukyushaJohoModel}のテストクラスです。
 *
 * @author LDNS 宋昕沢
 */
@RunWith(Enclosed.class)
public class RojinHokenJukyushaJohoModelTest extends DbzTestBase {

    public static class getterSetterTest extends DbzTestBase {

        private static RojinHokenJukyushaJohoModel sut;

        @BeforeClass
        public static void test() {
            sut = new RojinHokenJukyushaJohoModel();
        }

        @Test
        public void 戻り値の証記載保険者番号は_設定した値と同じ証記載保険者番号を返す() {
            sut.set証記載保険者番号(DbT7005RojinHokenJukyushaJohoEntityGenerator.DEFAULT_証記載保険者番号);
            assertThat(sut.get証記載保険者番号(), is(DbT7005RojinHokenJukyushaJohoEntityGenerator.DEFAULT_証記載保険者番号));
        }

        @Test
        public void 戻り値の識別コードは_設定した値と同じ識別コードを返す() {
            sut.set識別コード(DbT7005RojinHokenJukyushaJohoEntityGenerator.DEFAULT_識別コード);
            assertThat(sut.get識別コード(), is(DbT7005RojinHokenJukyushaJohoEntityGenerator.DEFAULT_識別コード));
        }

        @Test
        public void 戻り値の被保険者番号は_設定した値と同じ被保険者番号を返す() {
            sut.set被保険者番号(DbT7005RojinHokenJukyushaJohoEntityGenerator.DEFAULT_被保険者番号);
            assertThat(sut.get被保険者番号(), is(DbT7005RojinHokenJukyushaJohoEntityGenerator.DEFAULT_被保険者番号));
        }

        @Test
        public void 戻り値の老人保健市町村コードは_設定した値と同じ老人保健市町村コードを返す() {
            sut.set老人保健市町村コード(DbT7005RojinHokenJukyushaJohoEntityGenerator.DEFAULT_老人保健市町村コード);
            assertThat(sut.get老人保健市町村コード(), is(DbT7005RojinHokenJukyushaJohoEntityGenerator.DEFAULT_老人保健市町村コード));
        }

        @Test
        public void 戻り値の老人保健受給者番号は_設定した値と同じ老人保健受給者番号を返す() {
            sut.set老人保健受給者番号(DbT7005RojinHokenJukyushaJohoEntityGenerator.DEFAULT_老人保健受給者番号);
            assertThat(sut.get老人保健受給者番号(), is(DbT7005RojinHokenJukyushaJohoEntityGenerator.DEFAULT_老人保健受給者番号));
        }
    }

    public static class getStateTest extends DbzTestBase {

        @Test
        public void 状態Addedの取得確認() {
            RojinHokenJukyushaJohoModel sut = new RojinHokenJukyushaJohoModel();

            assertThat(sut.getState(), is(EntityDataState.Added));
        }

        @Test
        public void 状態Modifinedの取得確認() {
            RojinHokenJukyushaJohoModel sut = new RojinHokenJukyushaJohoModel();
            sut.setEntity(DbT7005RojinHokenJukyushaJohoEntityGenerator.createDbT7005RojinHokenJukyushaJohoEntity());

            sut.getEntity().initializeMd5();
            // TODO 主キー以外の項目を変更してください
//            sut.getEntity().setXXX(new XXX());
//            assertThat(sut.getState(), is(EntityDataState.Modified));
        }

        @Test
        public void 状態Unchangedの取得確認() {
            RojinHokenJukyushaJohoModel sut = new RojinHokenJukyushaJohoModel();
            sut.setEntity(DbT7005RojinHokenJukyushaJohoEntityGenerator.createDbT7005RojinHokenJukyushaJohoEntity());

            sut.getEntity().initializeMd5();

            assertThat(sut.getState(), is(EntityDataState.Unchanged));
        }

        @Test
        public void 状態Deletedの取得確認() {
            RojinHokenJukyushaJohoModel sut = new RojinHokenJukyushaJohoModel();
            sut.setEntity(DbT7005RojinHokenJukyushaJohoEntityGenerator.createDbT7005RojinHokenJukyushaJohoEntity());

            sut.getEntity().initializeMd5();

            sut.setDeletedState(true);

            assertThat(sut.getState(), is(EntityDataState.Deleted));
        }
    }
}
