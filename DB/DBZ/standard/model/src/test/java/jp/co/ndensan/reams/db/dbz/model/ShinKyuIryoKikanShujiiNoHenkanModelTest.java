/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.model;

import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT7030ShinKyuIryoKikanShujiiNoHenkanEntityGenerator;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link ShinKyuIryoKikanShujiiNoHenkanModel}のテストクラスです。
 *
 * @author LDNS 宋昕沢
 */
@RunWith(Enclosed.class)
public class ShinKyuIryoKikanShujiiNoHenkanModelTest extends DbzTestBase {

    public static class getterSetterTest extends DbzTestBase {

        private static ShinKyuIryoKikanShujiiNoHenkanModel sut;

        @BeforeClass
        public static void test() {
            sut = new ShinKyuIryoKikanShujiiNoHenkanModel();
        }

        @Test
        public void 戻り値の市町村コードは_設定した値と同じ市町村コードを返す() {
            sut.set市町村コード(DbT7030ShinKyuIryoKikanShujiiNoHenkanEntityGenerator.DEFAULT_市町村コード);
            assertThat(sut.get市町村コード(), is(DbT7030ShinKyuIryoKikanShujiiNoHenkanEntityGenerator.DEFAULT_市町村コード));
        }

        @Test
        public void 戻り値の新医療機関番号は_設定した値と同じ新医療機関番号を返す() {
            sut.set新医療機関番号(DbT7030ShinKyuIryoKikanShujiiNoHenkanEntityGenerator.DEFAULT_新医療機関番号);
            assertThat(sut.get新医療機関番号(), is(DbT7030ShinKyuIryoKikanShujiiNoHenkanEntityGenerator.DEFAULT_新医療機関番号));
        }

        @Test
        public void 戻り値の新主治医番号は_設定した値と同じ新主治医番号を返す() {
            sut.set新主治医番号(DbT7030ShinKyuIryoKikanShujiiNoHenkanEntityGenerator.DEFAULT_新主治医番号);
            assertThat(sut.get新主治医番号(), is(DbT7030ShinKyuIryoKikanShujiiNoHenkanEntityGenerator.DEFAULT_新主治医番号));
        }

        @Test
        public void 戻り値の旧医療機関番号は_設定した値と同じ旧医療機関番号を返す() {
            sut.set旧医療機関番号(DbT7030ShinKyuIryoKikanShujiiNoHenkanEntityGenerator.DEFAULT_旧医療機関番号);
            assertThat(sut.get旧医療機関番号(), is(DbT7030ShinKyuIryoKikanShujiiNoHenkanEntityGenerator.DEFAULT_旧医療機関番号));
        }

        @Test
        public void 戻り値の旧主治医番号は_設定した値と同じ旧主治医番号を返す() {
            sut.set旧主治医番号(DbT7030ShinKyuIryoKikanShujiiNoHenkanEntityGenerator.DEFAULT_旧主治医番号);
            assertThat(sut.get旧主治医番号(), is(DbT7030ShinKyuIryoKikanShujiiNoHenkanEntityGenerator.DEFAULT_旧主治医番号));
        }

        @Test
        public void 戻り値の市町村コード２は_設定した値と同じ市町村コード２を返す() {
            sut.set市町村コード２(DbT7030ShinKyuIryoKikanShujiiNoHenkanEntityGenerator.DEFAULT_市町村コード２);
            assertThat(sut.get市町村コード２(), is(DbT7030ShinKyuIryoKikanShujiiNoHenkanEntityGenerator.DEFAULT_市町村コード２));
        }

        @Test
        public void 戻り値の旧医療機関番号２は_設定した値と同じ旧医療機関番号２を返す() {
            sut.set旧医療機関番号２(DbT7030ShinKyuIryoKikanShujiiNoHenkanEntityGenerator.DEFAULT_旧医療機関番号２);
            assertThat(sut.get旧医療機関番号２(), is(DbT7030ShinKyuIryoKikanShujiiNoHenkanEntityGenerator.DEFAULT_旧医療機関番号２));
        }

        @Test
        public void 戻り値の旧主治医番号２は_設定した値と同じ旧主治医番号２を返す() {
            sut.set旧主治医番号２(DbT7030ShinKyuIryoKikanShujiiNoHenkanEntityGenerator.DEFAULT_旧主治医番号２);
            assertThat(sut.get旧主治医番号２(), is(DbT7030ShinKyuIryoKikanShujiiNoHenkanEntityGenerator.DEFAULT_旧主治医番号２));
        }
    }

    public static class getStateTest extends DbzTestBase {

        @Test
        public void 状態Addedの取得確認() {
            ShinKyuIryoKikanShujiiNoHenkanModel sut = new ShinKyuIryoKikanShujiiNoHenkanModel();

            assertThat(sut.getState(), is(EntityDataState.Added));
        }

        @Test
        public void 状態Modifinedの取得確認() {
            ShinKyuIryoKikanShujiiNoHenkanModel sut = new ShinKyuIryoKikanShujiiNoHenkanModel();
            sut.setEntity(DbT7030ShinKyuIryoKikanShujiiNoHenkanEntityGenerator.createDbT7030ShinKyuIryoKikanShujiiNoHenkanEntity());

            sut.getEntity().initializeMd5();

            // TODO 主キー以外の項目を変更してください
//            sut.getEntity().setXXX(new XXX());
//            assertThat(sut.getState(), is(EntityDataState.Modified));
        }

        @Test
        public void 状態Unchangedの取得確認() {
            ShinKyuIryoKikanShujiiNoHenkanModel sut = new ShinKyuIryoKikanShujiiNoHenkanModel();
            sut.setEntity(DbT7030ShinKyuIryoKikanShujiiNoHenkanEntityGenerator.createDbT7030ShinKyuIryoKikanShujiiNoHenkanEntity());

            sut.getEntity().initializeMd5();

            assertThat(sut.getState(), is(EntityDataState.Unchanged));
        }

        @Test
        public void 状態Deletedの取得確認() {
            ShinKyuIryoKikanShujiiNoHenkanModel sut = new ShinKyuIryoKikanShujiiNoHenkanModel();
            sut.setEntity(DbT7030ShinKyuIryoKikanShujiiNoHenkanEntityGenerator.createDbT7030ShinKyuIryoKikanShujiiNoHenkanEntity());

            sut.getEntity().initializeMd5();

            sut.setDeletedState(true);

            assertThat(sut.getState(), is(EntityDataState.Deleted));
        }
    }
}
