/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.model;

import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT7028KakushuShinKyuNoHenkanEntityGenerator;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link KakushuShinKyuNoHenkanModel}のテストクラスです。
 *
 * @author LDNS 宋昕沢
 */
@RunWith(Enclosed.class)
public class KakushuShinKyuNoHenkanModelTest extends DbzTestBase {

    public static class getterSetterTest extends DbzTestBase {

        private static KakushuShinKyuNoHenkanModel sut;

        @BeforeClass
        public static void test() {
            sut = new KakushuShinKyuNoHenkanModel();
        }

        @Test
        public void 戻り値の被保険者番号は_設定した値と同じ被保険者番号を返す() {
            sut.set被保険者番号(DbT7028KakushuShinKyuNoHenkanEntityGenerator.DEFAULT_被保険者番号);
            assertThat(sut.get被保険者番号(), is(DbT7028KakushuShinKyuNoHenkanEntityGenerator.DEFAULT_被保険者番号));
        }

        @Test
        public void 戻り値の番号区分は_設定した値と同じ番号区分を返す() {
            sut.set番号区分(DbT7028KakushuShinKyuNoHenkanEntityGenerator.DEFAULT_番号区分);
            assertThat(sut.get番号区分(), is(DbT7028KakushuShinKyuNoHenkanEntityGenerator.DEFAULT_番号区分));
        }

        @Test
        public void 戻り値の新番号は_設定した値と同じ新番号を返す() {
            sut.set新番号(DbT7028KakushuShinKyuNoHenkanEntityGenerator.DEFAULT_新番号);
            assertThat(sut.get新番号(), is(DbT7028KakushuShinKyuNoHenkanEntityGenerator.DEFAULT_新番号));
        }

        @Test
        public void 戻り値の旧番号は_設定した値と同じ旧番号を返す() {
            sut.set旧番号(DbT7028KakushuShinKyuNoHenkanEntityGenerator.DEFAULT_旧番号);
            assertThat(sut.get旧番号(), is(DbT7028KakushuShinKyuNoHenkanEntityGenerator.DEFAULT_旧番号));
        }
    }

    public static class getStateTest extends DbzTestBase {

        @Test
        public void 状態Addedの取得確認() {
            KakushuShinKyuNoHenkanModel sut = new KakushuShinKyuNoHenkanModel();

            assertThat(sut.getState(), is(EntityDataState.Added));
        }

        @Test
        public void 状態Modifinedの取得確認() {
            KakushuShinKyuNoHenkanModel sut = new KakushuShinKyuNoHenkanModel();
            sut.setEntity(DbT7028KakushuShinKyuNoHenkanEntityGenerator.createDbT7028KakushuShinKyuNoHenkanEntity());

            sut.getEntity().initializeMd5();

            // TODO 主キー以外の項目を変更してください
//            sut.getEntity().setXXX(new XXX());
//            assertThat(sut.getState(), is(EntityDataState.Modified));
        }

        @Test
        public void 状態Unchangedの取得確認() {
            KakushuShinKyuNoHenkanModel sut = new KakushuShinKyuNoHenkanModel();
            sut.setEntity(DbT7028KakushuShinKyuNoHenkanEntityGenerator.createDbT7028KakushuShinKyuNoHenkanEntity());

            sut.getEntity().initializeMd5();

            assertThat(sut.getState(), is(EntityDataState.Unchanged));
        }

        @Test
        public void 状態Deletedの取得確認() {
            KakushuShinKyuNoHenkanModel sut = new KakushuShinKyuNoHenkanModel();
            sut.setEntity(DbT7028KakushuShinKyuNoHenkanEntityGenerator.createDbT7028KakushuShinKyuNoHenkanEntity());

            sut.getEntity().initializeMd5();

            sut.setDeletedState(true);

            assertThat(sut.getState(), is(EntityDataState.Deleted));
        }
    }
}
