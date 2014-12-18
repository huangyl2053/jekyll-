/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.model;

import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT7026ShinKyuHihokenshaNoHenkanEntityGenerator;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link ShinKyuHihokenshaNoHenkanModel}のテストクラスです。
 *
 * @author LDNS 宋昕沢
 */
@RunWith(Enclosed.class)
public class ShinKyuHihokenshaNoHenkanModelTest extends DbzTestBase {

    public static class getterSetterTest extends DbzTestBase {

        private static ShinKyuHihokenshaNoHenkanModel sut;

        @BeforeClass
        public static void test() {
            sut = new ShinKyuHihokenshaNoHenkanModel();
        }

        @Test
        public void 戻り値の市町村コードは_設定した値と同じ市町村コードを返す() {
            sut.set市町村コード(DbT7026ShinKyuHihokenshaNoHenkanEntityGenerator.DEFAULT_市町村コード);
            assertThat(sut.get市町村コード(), is(DbT7026ShinKyuHihokenshaNoHenkanEntityGenerator.DEFAULT_市町村コード));
        }

        @Test
        public void 戻り値の新番号は_設定した値と同じ新番号を返す() {
            sut.set新番号(DbT7026ShinKyuHihokenshaNoHenkanEntityGenerator.DEFAULT_新番号);
            assertThat(sut.get新番号(), is(DbT7026ShinKyuHihokenshaNoHenkanEntityGenerator.DEFAULT_新番号));
        }

        @Test
        public void 戻り値の旧番号は_設定した値と同じ旧番号を返す() {
            sut.set旧番号(DbT7026ShinKyuHihokenshaNoHenkanEntityGenerator.DEFAULT_旧番号);
            assertThat(sut.get旧番号(), is(DbT7026ShinKyuHihokenshaNoHenkanEntityGenerator.DEFAULT_旧番号));
        }

        @Test
        public void 戻り値の旧市町村コード２は_設定した値と同じ旧市町村コード２を返す() {
            sut.set旧市町村コード２(DbT7026ShinKyuHihokenshaNoHenkanEntityGenerator.DEFAULT_旧市町村コード２);
            assertThat(sut.get旧市町村コード２(), is(DbT7026ShinKyuHihokenshaNoHenkanEntityGenerator.DEFAULT_旧市町村コード２));
        }

        @Test
        public void 戻り値の旧番号２は_設定した値と同じ旧番号２を返す() {
            sut.set旧番号２(DbT7026ShinKyuHihokenshaNoHenkanEntityGenerator.DEFAULT_旧番号２);
            assertThat(sut.get旧番号２(), is(DbT7026ShinKyuHihokenshaNoHenkanEntityGenerator.DEFAULT_旧番号２));
        }
    }

    public static class getStateTest extends DbzTestBase {

        @Test
        public void 状態Addedの取得確認() {
            ShinKyuHihokenshaNoHenkanModel sut = new ShinKyuHihokenshaNoHenkanModel();

            assertThat(sut.getState(), is(EntityDataState.Added));
        }

        @Test
        public void 状態Modifinedの取得確認() {
            ShinKyuHihokenshaNoHenkanModel sut = new ShinKyuHihokenshaNoHenkanModel();
            sut.setEntity(DbT7026ShinKyuHihokenshaNoHenkanEntityGenerator.createDbT7026ShinKyuHihokenshaNoHenkanEntity());

            sut.getEntity().initializeMd5();

            // TODO 主キー以外の項目を変更してください
//            sut.getEntity().setXXX(new XXX());
//            assertThat(sut.getState(), is(EntityDataState.Modified));
        }

        @Test
        public void 状態Unchangedの取得確認() {
            ShinKyuHihokenshaNoHenkanModel sut = new ShinKyuHihokenshaNoHenkanModel();
            sut.setEntity(DbT7026ShinKyuHihokenshaNoHenkanEntityGenerator.createDbT7026ShinKyuHihokenshaNoHenkanEntity());

            sut.getEntity().initializeMd5();

            assertThat(sut.getState(), is(EntityDataState.Unchanged));
        }

        @Test
        public void 状態Deletedの取得確認() {
            ShinKyuHihokenshaNoHenkanModel sut = new ShinKyuHihokenshaNoHenkanModel();
            sut.setEntity(DbT7026ShinKyuHihokenshaNoHenkanEntityGenerator.createDbT7026ShinKyuHihokenshaNoHenkanEntity());

            sut.getEntity().initializeMd5();

            sut.setDeletedState(true);

            assertThat(sut.getState(), is(EntityDataState.Deleted));
        }
    }
}
