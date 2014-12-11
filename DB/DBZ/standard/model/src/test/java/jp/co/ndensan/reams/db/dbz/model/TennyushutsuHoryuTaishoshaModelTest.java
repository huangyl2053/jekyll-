/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.model;

import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT1010TennyushutsuHoryuTaishoshaEntityGenerator;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link TennyushutsuHoryuTaishoshaModel}のテストクラスです。
 *
 * @author LDNS 鄭雪双
 */
@RunWith(Enclosed.class)
public class TennyushutsuHoryuTaishoshaModelTest extends DbzTestBase {

    public static class getterSetterTest extends DbzTestBase {

        private static TennyushutsuHoryuTaishoshaModel sut;

        @BeforeClass
        public static void test() {
            sut = new TennyushutsuHoryuTaishoshaModel();
        }

        @Test
        public void 戻り値の市町村コードは_設定した値と同じ市町村コードを返す() {
            sut.set市町村コード(DbT1010TennyushutsuHoryuTaishoshaEntityGenerator.DEFAULT_市町村コード);
            assertThat(sut.get市町村コード(), is(DbT1010TennyushutsuHoryuTaishoshaEntityGenerator.DEFAULT_市町村コード));
        }

        @Test
        public void 戻り値の識別コードは_設定した値と同じ識別コードを返す() {
            sut.set識別コード(DbT1010TennyushutsuHoryuTaishoshaEntityGenerator.DEFAULT_識別コード);
            assertThat(sut.get識別コード(), is(DbT1010TennyushutsuHoryuTaishoshaEntityGenerator.DEFAULT_識別コード));
        }

        @Test
        public void 戻り値の処理日時は_設定した値と同じ処理日時を返す() {
            sut.set処理日時(DbT1010TennyushutsuHoryuTaishoshaEntityGenerator.DEFAULT_処理日時);
            assertThat(sut.get処理日時(), is(DbT1010TennyushutsuHoryuTaishoshaEntityGenerator.DEFAULT_処理日時));
        }
    }

    public static class getStateTest extends DbzTestBase {

        @Test
        public void 状態Addedの取得確認() {
            TennyushutsuHoryuTaishoshaModel sut = new TennyushutsuHoryuTaishoshaModel();

            assertThat(sut.getState(), is(EntityDataState.Added));
        }

        @Test
        public void 状態Modifinedの取得確認() {
            TennyushutsuHoryuTaishoshaModel sut = new TennyushutsuHoryuTaishoshaModel();
            sut.setEntity(DbT1010TennyushutsuHoryuTaishoshaEntityGenerator.createDbT1010TennyushutsuHoryuTaishoshaEntity());

            sut.getEntity().initializeMd5();

            // 主キー以外の項目を変更してください
//            sut.getEntity().setXXX(new XXX());
//            assertThat(sut.getState(), is(EntityDataState.Modified));
        }

        @Test
        public void 状態Unchangedの取得確認() {
            TennyushutsuHoryuTaishoshaModel sut = new TennyushutsuHoryuTaishoshaModel();
            sut.setEntity(DbT1010TennyushutsuHoryuTaishoshaEntityGenerator.createDbT1010TennyushutsuHoryuTaishoshaEntity());

            sut.getEntity().initializeMd5();

            assertThat(sut.getState(), is(EntityDataState.Unchanged));
        }

        @Test
        public void 状態Deletedの取得確認() {
            TennyushutsuHoryuTaishoshaModel sut = new TennyushutsuHoryuTaishoshaModel();
            sut.setEntity(DbT1010TennyushutsuHoryuTaishoshaEntityGenerator.createDbT1010TennyushutsuHoryuTaishoshaEntity());

            sut.getEntity().initializeMd5();

            sut.setDeletedState(true);

            assertThat(sut.getState(), is(EntityDataState.Deleted));
        }
    }
}
