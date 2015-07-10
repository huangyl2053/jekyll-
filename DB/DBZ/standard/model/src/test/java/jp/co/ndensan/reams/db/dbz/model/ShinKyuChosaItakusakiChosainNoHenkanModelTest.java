/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.model;

import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT7029ShinKyuChosaItakusakiChosainNoHenkanEntityGenerator;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link ShinKyuChosaItakusakiChosainNoHenkanModel}のテストクラスです。
 *
 * @author LDNS 宋昕沢
 */
@RunWith(Enclosed.class)
public class ShinKyuChosaItakusakiChosainNoHenkanModelTest extends DbzTestBase {

    public static class getterSetterTest extends DbzTestBase {

        private static ShinKyuChosaItakusakiChosainNoHenkanModel sut;

        @BeforeClass
        public static void test() {
            sut = new ShinKyuChosaItakusakiChosainNoHenkanModel();
        }

        @Test
        public void 戻り値の市町村コードは_設定した値と同じ市町村コードを返す() {
            sut.set市町村コード(DbT7029ShinKyuChosaItakusakiChosainNoHenkanEntityGenerator.DEFAULT_市町村コード);
            assertThat(sut.get市町村コード(), is(DbT7029ShinKyuChosaItakusakiChosainNoHenkanEntityGenerator.DEFAULT_市町村コード));
        }

        @Test
        public void 戻り値の新調査委託先番号は_設定した値と同じ新調査委託先番号を返す() {
            sut.set新調査委託先番号(DbT7029ShinKyuChosaItakusakiChosainNoHenkanEntityGenerator.DEFAULT_新調査委託先番号);
            assertThat(sut.get新調査委託先番号(), is(DbT7029ShinKyuChosaItakusakiChosainNoHenkanEntityGenerator.DEFAULT_新調査委託先番号));
        }

        @Test
        public void 戻り値の新調査員番号は_設定した値と同じ新調査員番号を返す() {
            sut.set新調査員番号(DbT7029ShinKyuChosaItakusakiChosainNoHenkanEntityGenerator.DEFAULT_新調査員番号);
            assertThat(sut.get新調査員番号(), is(DbT7029ShinKyuChosaItakusakiChosainNoHenkanEntityGenerator.DEFAULT_新調査員番号));
        }

        @Test
        public void 戻り値の旧調査委託先番号は_設定した値と同じ旧調査委託先番号を返す() {
            sut.set旧調査委託先番号(DbT7029ShinKyuChosaItakusakiChosainNoHenkanEntityGenerator.DEFAULT_旧調査委託先番号);
            assertThat(sut.get旧調査委託先番号(), is(DbT7029ShinKyuChosaItakusakiChosainNoHenkanEntityGenerator.DEFAULT_旧調査委託先番号));
        }

        @Test
        public void 戻り値の旧調査員番号は_設定した値と同じ旧調査員番号を返す() {
            sut.set旧調査員番号(DbT7029ShinKyuChosaItakusakiChosainNoHenkanEntityGenerator.DEFAULT_旧調査員番号);
            assertThat(sut.get旧調査員番号(), is(DbT7029ShinKyuChosaItakusakiChosainNoHenkanEntityGenerator.DEFAULT_旧調査員番号));
        }

        @Test
        public void 戻り値の市町村コード２は_設定した値と同じ市町村コード２を返す() {
            sut.set市町村コード２(DbT7029ShinKyuChosaItakusakiChosainNoHenkanEntityGenerator.DEFAULT_市町村コード２);
            assertThat(sut.get市町村コード２(), is(DbT7029ShinKyuChosaItakusakiChosainNoHenkanEntityGenerator.DEFAULT_市町村コード２));
        }

        @Test
        public void 戻り値の旧調査委託先番号２は_設定した値と同じ旧調査委託先番号２を返す() {
            sut.set旧調査委託先番号２(DbT7029ShinKyuChosaItakusakiChosainNoHenkanEntityGenerator.DEFAULT_旧調査委託先番号２);
            assertThat(sut.get旧調査委託先番号２(), is(DbT7029ShinKyuChosaItakusakiChosainNoHenkanEntityGenerator.DEFAULT_旧調査委託先番号２));
        }

        @Test
        public void 戻り値の旧調査員番号２は_設定した値と同じ旧調査員番号２を返す() {
            sut.set旧調査員番号２(DbT7029ShinKyuChosaItakusakiChosainNoHenkanEntityGenerator.DEFAULT_旧調査員番号２);
            assertThat(sut.get旧調査員番号２(), is(DbT7029ShinKyuChosaItakusakiChosainNoHenkanEntityGenerator.DEFAULT_旧調査員番号２));
        }
    }

    public static class getStateTest extends DbzTestBase {

        @Test
        public void 状態Addedの取得確認() {
            ShinKyuChosaItakusakiChosainNoHenkanModel sut = new ShinKyuChosaItakusakiChosainNoHenkanModel();

            assertThat(sut.getState(), is(EntityDataState.Added));
        }

        @Test
        public void 状態Modifinedの取得確認() {
            ShinKyuChosaItakusakiChosainNoHenkanModel sut = new ShinKyuChosaItakusakiChosainNoHenkanModel();
            sut.setEntity(DbT7029ShinKyuChosaItakusakiChosainNoHenkanEntityGenerator.createDbT7029ShinKyuChosaItakusakiChosainNoHenkanEntity());

            sut.getEntity().initializeMd5();

            // TODO 主キー以外の項目を変更してください
//            sut.getEntity().setXXX(new XXX());
//            assertThat(sut.getState(), is(EntityDataState.Modified));
        }

        @Test
        public void 状態Unchangedの取得確認() {
            ShinKyuChosaItakusakiChosainNoHenkanModel sut = new ShinKyuChosaItakusakiChosainNoHenkanModel();
            sut.setEntity(DbT7029ShinKyuChosaItakusakiChosainNoHenkanEntityGenerator.createDbT7029ShinKyuChosaItakusakiChosainNoHenkanEntity());

            sut.getEntity().initializeMd5();

            assertThat(sut.getState(), is(EntityDataState.Unchanged));
        }

        @Test
        public void 状態Deletedの取得確認() {
            ShinKyuChosaItakusakiChosainNoHenkanModel sut = new ShinKyuChosaItakusakiChosainNoHenkanModel();
            sut.setEntity(DbT7029ShinKyuChosaItakusakiChosainNoHenkanEntityGenerator.createDbT7029ShinKyuChosaItakusakiChosainNoHenkanEntity());

            sut.getEntity().initializeMd5();

            sut.setDeletedState(true);

            assertThat(sut.getState(), is(EntityDataState.Deleted));
        }
    }
}
