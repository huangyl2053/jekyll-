/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.model;

import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT7032ShinKyuTaTokureiShisetsuNoHenkanEntityGenerator;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link ShinKyuTaTokureiShisetsuNoHenkanModel}のテストクラスです。
 *
 * @author LDNS 宋昕沢
 */
@RunWith(Enclosed.class)
public class ShinKyuTaTokureiShisetsuNoHenkanModelTest extends DbzTestBase {

    public static class getterSetterTest extends DbzTestBase {

        private static ShinKyuTaTokureiShisetsuNoHenkanModel sut;

        @BeforeClass
        public static void test() {
            sut = new ShinKyuTaTokureiShisetsuNoHenkanModel();
        }

        @Test
        public void 戻り値の市町村コードは_設定した値と同じ市町村コードを返す() {
            sut.set市町村コード(DbT7032ShinKyuTaTokureiShisetsuNoHenkanEntityGenerator.DEFAULT_市町村コード);
            assertThat(sut.get市町村コード(), is(DbT7032ShinKyuTaTokureiShisetsuNoHenkanEntityGenerator.DEFAULT_市町村コード));
        }

        @Test
        public void 戻り値の新他特例施設番号は_設定した値と同じ新他特例施設番号を返す() {
            sut.set新他特例施設番号(DbT7032ShinKyuTaTokureiShisetsuNoHenkanEntityGenerator.DEFAULT_新他特例施設番号);
            assertThat(sut.get新他特例施設番号(), is(DbT7032ShinKyuTaTokureiShisetsuNoHenkanEntityGenerator.DEFAULT_新他特例施設番号));
        }

        @Test
        public void 戻り値の旧他特例施設番号は_設定した値と同じ旧他特例施設番号を返す() {
            sut.set旧他特例施設番号(DbT7032ShinKyuTaTokureiShisetsuNoHenkanEntityGenerator.DEFAULT_旧他特例施設番号);
            assertThat(sut.get旧他特例施設番号(), is(DbT7032ShinKyuTaTokureiShisetsuNoHenkanEntityGenerator.DEFAULT_旧他特例施設番号));
        }

        @Test
        public void 戻り値の市町村コード２は_設定した値と同じ市町村コード２を返す() {
            sut.set市町村コード２(DbT7032ShinKyuTaTokureiShisetsuNoHenkanEntityGenerator.DEFAULT_市町村コード２);
            assertThat(sut.get市町村コード２(), is(DbT7032ShinKyuTaTokureiShisetsuNoHenkanEntityGenerator.DEFAULT_市町村コード２));
        }

        @Test
        public void 戻り値の旧他特例施設番号２は_設定した値と同じ旧他特例施設番号２を返す() {
            sut.set旧他特例施設番号２(DbT7032ShinKyuTaTokureiShisetsuNoHenkanEntityGenerator.DEFAULT_旧他特例施設番号２);
            assertThat(sut.get旧他特例施設番号２(), is(DbT7032ShinKyuTaTokureiShisetsuNoHenkanEntityGenerator.DEFAULT_旧他特例施設番号２));
        }
    }

    public static class getStateTest extends DbzTestBase {

        @Test
        public void 状態Addedの取得確認() {
            ShinKyuTaTokureiShisetsuNoHenkanModel sut = new ShinKyuTaTokureiShisetsuNoHenkanModel();

            assertThat(sut.getState(), is(EntityDataState.Added));
        }

        @Test
        public void 状態Modifinedの取得確認() {
            ShinKyuTaTokureiShisetsuNoHenkanModel sut = new ShinKyuTaTokureiShisetsuNoHenkanModel();
            sut.setEntity(DbT7032ShinKyuTaTokureiShisetsuNoHenkanEntityGenerator.createDbT7032ShinKyuTaTokureiShisetsuNoHenkanEntity());

            sut.getEntity().initializeMd5();
            // TODO 主キー以外の項目を変更してください
//            sut.getEntity().setXXX(new XXX());
//            assertThat(sut.getState(), is(EntityDataState.Modified));
        }

        @Test
        public void 状態Unchangedの取得確認() {
            ShinKyuTaTokureiShisetsuNoHenkanModel sut = new ShinKyuTaTokureiShisetsuNoHenkanModel();
            sut.setEntity(DbT7032ShinKyuTaTokureiShisetsuNoHenkanEntityGenerator.createDbT7032ShinKyuTaTokureiShisetsuNoHenkanEntity());

            sut.getEntity().initializeMd5();

            assertThat(sut.getState(), is(EntityDataState.Unchanged));
        }

        @Test
        public void 状態Deletedの取得確認() {
            ShinKyuTaTokureiShisetsuNoHenkanModel sut = new ShinKyuTaTokureiShisetsuNoHenkanModel();
            sut.setEntity(DbT7032ShinKyuTaTokureiShisetsuNoHenkanEntityGenerator.createDbT7032ShinKyuTaTokureiShisetsuNoHenkanEntity());

            sut.getEntity().initializeMd5();

            sut.setDeletedState(true);

            assertThat(sut.getState(), is(EntityDataState.Deleted));
        }
    }
}
