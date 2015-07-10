/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.model;

import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT1004ShisetsuNyutaishoEntityGenerator;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link ShisetsuNyutaishoModel}のテストクラスです。
 *
 * @author LDNS 鄭雪双
 */
@RunWith(Enclosed.class)
public class ShisetsuNyutaishoModelTest extends DbzTestBase {

    public static class getterSetterTest extends DbzTestBase {

        private static ShisetsuNyutaishoModel sut;

        @BeforeClass
        public static void test() {
            sut = new ShisetsuNyutaishoModel();
        }

        @Test
        public void 戻り値の市町村コードは_設定した値と同じ市町村コードを返す() {
            sut.set市町村コード(DbT1004ShisetsuNyutaishoEntityGenerator.DEFAULT_市町村コード);
            assertThat(sut.get市町村コード(), is(DbT1004ShisetsuNyutaishoEntityGenerator.DEFAULT_市町村コード));
        }

        @Test
        public void 戻り値の識別コードは_設定した値と同じ識別コードを返す() {
            sut.set識別コード(DbT1004ShisetsuNyutaishoEntityGenerator.DEFAULT_識別コード);
            assertThat(sut.get識別コード(), is(DbT1004ShisetsuNyutaishoEntityGenerator.DEFAULT_識別コード));
        }

        @Test
        public void 戻り値の処理日時は_設定した値と同じ処理日時を返す() {
            sut.set処理日時(DbT1004ShisetsuNyutaishoEntityGenerator.DEFAULT_処理日時);
            assertThat(sut.get処理日時(), is(DbT1004ShisetsuNyutaishoEntityGenerator.DEFAULT_処理日時));
        }

        @Test
        public void 戻り値の台帳種別は_設定した値と同じ台帳種別を返す() {
            sut.set台帳種別(DbT1004ShisetsuNyutaishoEntityGenerator.DEFAULT_台帳種別);
            assertThat(sut.get台帳種別(), is(DbT1004ShisetsuNyutaishoEntityGenerator.DEFAULT_台帳種別));
        }

        @Test
        public void 戻り値の入所施設種類は_設定した値と同じ入所施設種類を返す() {
            sut.set入所施設種類(DbT1004ShisetsuNyutaishoEntityGenerator.DEFAULT_入所施設種類);
            assertThat(sut.get入所施設種類(), is(DbT1004ShisetsuNyutaishoEntityGenerator.DEFAULT_入所施設種類));
        }

        @Test
        public void 戻り値の入所施設コードは_設定した値と同じ入所施設コードを返す() {
            sut.set入所施設コード(DbT1004ShisetsuNyutaishoEntityGenerator.DEFAULT_入所施設コード);
            assertThat(sut.get入所施設コード(), is(DbT1004ShisetsuNyutaishoEntityGenerator.DEFAULT_入所施設コード));
        }

        @Test
        public void 戻り値の入所年月日は_設定した値と同じ入所年月日を返す() {
            sut.set入所年月日(DbT1004ShisetsuNyutaishoEntityGenerator.DEFAULT_入所年月日);
            assertThat(sut.get入所年月日(), is(DbT1004ShisetsuNyutaishoEntityGenerator.DEFAULT_入所年月日));
        }

        @Test
        public void 戻り値の退所年月日は_設定した値と同じ退所年月日を返す() {
            sut.set退所年月日(DbT1004ShisetsuNyutaishoEntityGenerator.DEFAULT_退所年月日);
            assertThat(sut.get退所年月日(), is(DbT1004ShisetsuNyutaishoEntityGenerator.DEFAULT_退所年月日));
        }

        @Test
        public void 戻り値の入所処理年月日は_設定した値と同じ入所処理年月日を返す() {
            sut.set入所処理年月日(DbT1004ShisetsuNyutaishoEntityGenerator.DEFAULT_入所処理年月日);
            assertThat(sut.get入所処理年月日(), is(DbT1004ShisetsuNyutaishoEntityGenerator.DEFAULT_入所処理年月日));
        }

        @Test
        public void 戻り値の退所処理年月日は_設定した値と同じ退所処理年月日を返す() {
            sut.set退所処理年月日(DbT1004ShisetsuNyutaishoEntityGenerator.DEFAULT_退所処理年月日);
            assertThat(sut.get退所処理年月日(), is(DbT1004ShisetsuNyutaishoEntityGenerator.DEFAULT_退所処理年月日));
        }
    }

    public static class getStateTest extends DbzTestBase {

        @Test
        public void 状態Addedの取得確認() {
            ShisetsuNyutaishoModel sut = new ShisetsuNyutaishoModel();

            assertThat(sut.getState(), is(EntityDataState.Added));
        }

        @Test
        public void 状態Modifinedの取得確認() {
            ShisetsuNyutaishoModel sut = new ShisetsuNyutaishoModel();
            sut.setEntity(DbT1004ShisetsuNyutaishoEntityGenerator.createDbT1004ShisetsuNyutaishoEntity());

            sut.getEntity().initializeMd5();

            // 主キー以外の項目を変更してください
//            sut.getEntity().setXXX(new XXX());
//            assertThat(sut.getState(), is(EntityDataState.Modified));
        }

        @Test
        public void 状態Unchangedの取得確認() {
            ShisetsuNyutaishoModel sut = new ShisetsuNyutaishoModel();
            sut.setEntity(DbT1004ShisetsuNyutaishoEntityGenerator.createDbT1004ShisetsuNyutaishoEntity());

            sut.getEntity().initializeMd5();

            assertThat(sut.getState(), is(EntityDataState.Unchanged));
        }

        @Test
        public void 状態Deletedの取得確認() {
            ShisetsuNyutaishoModel sut = new ShisetsuNyutaishoModel();
            sut.setEntity(DbT1004ShisetsuNyutaishoEntityGenerator.createDbT1004ShisetsuNyutaishoEntity());

            sut.getEntity().initializeMd5();

            sut.setDeletedState(true);

            assertThat(sut.getState(), is(EntityDataState.Deleted));
        }
    }
}
