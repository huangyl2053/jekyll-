/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.model;

import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT7050KaigoHokenshaEntityGenerator;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link KaigoHokenshaModel}のテストクラスです。
 *
 * @author LDNS 宋文娟
 */
@RunWith(Enclosed.class)
public class KaigoHokenshaModelTest extends DbzTestBase {

    public static class getterSetterTest extends DbzTestBase {

        private static KaigoHokenshaModel sut;

        @BeforeClass
        public static void test() {
            sut = new KaigoHokenshaModel();
        }

        @Test
        public void 戻り値の市町村コードは_設定した値と同じ市町村コードを返す() {
            sut.set市町村コード(DbT7050KaigoHokenshaEntityGenerator.DEFAULT_市町村コード);
            assertThat(sut.get市町村コード(), is(DbT7050KaigoHokenshaEntityGenerator.DEFAULT_市町村コード));
        }

        @Test
        public void 戻り値の証記載保険者番号は_設定した値と同じ証記載保険者番号を返す() {
            sut.set証記載保険者番号(DbT7050KaigoHokenshaEntityGenerator.DEFAULT_証記載保険者番号);
            assertThat(sut.get証記載保険者番号(), is(DbT7050KaigoHokenshaEntityGenerator.DEFAULT_証記載保険者番号));
        }
    }

    public static class getStateTest extends DbzTestBase {

        @Test
        public void 状態Addedの取得確認() {
            KaigoHokenshaModel sut = new KaigoHokenshaModel();

            assertThat(sut.getState(), is(EntityDataState.Added));
        }

       // @Test
        // public void 状態Modifinedの取得確認() {
        // KaigoHokenshaModel sut = new KaigoHokenshaModel();
        //sut.setEntity(DbT7050KaigoHokenshaEntityGenerator.createDbT7050KaigoHokenshaEntity());
        // sut.getEntity().initializeMd5();
        // TODO主キー以外の項目を変更してください
        //sut.getEntity().setXXX(new XXX());
        //assertThat(sut.getState(), is(EntityDataState.Modified));
        //}
        @Test
        public void 状態Unchangedの取得確認() {
            KaigoHokenshaModel sut = new KaigoHokenshaModel();
            sut.setEntity(DbT7050KaigoHokenshaEntityGenerator.createDbT7050KaigoHokenshaEntity());

            sut.getEntity().initializeMd5();

            assertThat(sut.getState(), is(EntityDataState.Unchanged));
        }

        @Test
        public void 状態Deletedの取得確認() {
            KaigoHokenshaModel sut = new KaigoHokenshaModel();
            sut.setEntity(DbT7050KaigoHokenshaEntityGenerator.createDbT7050KaigoHokenshaEntity());

            sut.getEntity().initializeMd5();

            sut.setDeletedState(true);

            assertThat(sut.getState(), is(EntityDataState.Deleted));
        }
    }
}
