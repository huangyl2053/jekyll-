/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.model;

import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT3101NijiYoboKihonCheckListEntityGenerator;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link NijiYoboKihonCheckListModel}のテストクラスです。
 *
 * @author LDNS 宋昕沢
 */
@RunWith(Enclosed.class)
public class NijiYoboKihonCheckListModelTest extends DbzTestBase {

    public static class getterSetterTest extends DbzTestBase {

        private static NijiYoboKihonCheckListModel sut;

        @BeforeClass
        public static void test() {
            sut = new NijiYoboKihonCheckListModel();
        }

        @Test
        public void 戻り値の識別コードは_設定した値と同じ識別コードを返す() {
            sut.set識別コード(DbT3101NijiYoboKihonCheckListEntityGenerator.DEFAULT_識別コード);
            assertThat(sut.get識別コード(), is(DbT3101NijiYoboKihonCheckListEntityGenerator.DEFAULT_識別コード));
        }

        @Test
        public void 戻り値の被保険者番号は_設定した値と同じ被保険者番号を返す() {
            sut.set被保険者番号(DbT3101NijiYoboKihonCheckListEntityGenerator.DEFAULT_被保険者番号);
            assertThat(sut.get被保険者番号(), is(DbT3101NijiYoboKihonCheckListEntityGenerator.DEFAULT_被保険者番号));
        }

        @Test
        public void 戻り値の受付年月日は_設定した値と同じ受付年月日を返す() {
            sut.set受付年月日(DbT3101NijiYoboKihonCheckListEntityGenerator.DEFAULT_受付年月日);
            assertThat(sut.get受付年月日(), is(DbT3101NijiYoboKihonCheckListEntityGenerator.DEFAULT_受付年月日));
        }

        @Test
        public void 戻り値の処理日時は_設定した値と同じ処理日時を返す() {
            sut.set処理日時(DbT3101NijiYoboKihonCheckListEntityGenerator.DEFAULT_処理日時);
            assertThat(sut.get処理日時(), is(DbT3101NijiYoboKihonCheckListEntityGenerator.DEFAULT_処理日時));
        }

        @Test
        public void 戻り値の記入年月日は_設定した値と同じ記入年月日を返す() {
            sut.set記入年月日(DbT3101NijiYoboKihonCheckListEntityGenerator.DEFAULT_記入年月日);
            assertThat(sut.get記入年月日(), is(DbT3101NijiYoboKihonCheckListEntityGenerator.DEFAULT_記入年月日));
        }

        @Test
        public void 戻り値の質問事項１は_設定した値と同じ質問事項１を返す() {
            sut.set質問事項１(DbT3101NijiYoboKihonCheckListEntityGenerator.DEFAULT_質問事項１);
            assertThat(sut.get質問事項１(), is(DbT3101NijiYoboKihonCheckListEntityGenerator.DEFAULT_質問事項１));
        }

        @Test
        public void 戻り値の質問事項２は_設定した値と同じ質問事項２を返す() {
            sut.set質問事項２(DbT3101NijiYoboKihonCheckListEntityGenerator.DEFAULT_質問事項２);
            assertThat(sut.get質問事項２(), is(DbT3101NijiYoboKihonCheckListEntityGenerator.DEFAULT_質問事項２));
        }

        @Test
        public void 戻り値の質問事項３は_設定した値と同じ質問事項３を返す() {
            sut.set質問事項３(DbT3101NijiYoboKihonCheckListEntityGenerator.DEFAULT_質問事項３);
            assertThat(sut.get質問事項３(), is(DbT3101NijiYoboKihonCheckListEntityGenerator.DEFAULT_質問事項３));
        }

        @Test
        public void 戻り値の質問事項４は_設定した値と同じ質問事項４を返す() {
            sut.set質問事項４(DbT3101NijiYoboKihonCheckListEntityGenerator.DEFAULT_質問事項４);
            assertThat(sut.get質問事項４(), is(DbT3101NijiYoboKihonCheckListEntityGenerator.DEFAULT_質問事項４));
        }

        @Test
        public void 戻り値の質問事項５は_設定した値と同じ質問事項５を返す() {
            sut.set質問事項５(DbT3101NijiYoboKihonCheckListEntityGenerator.DEFAULT_質問事項５);
            assertThat(sut.get質問事項５(), is(DbT3101NijiYoboKihonCheckListEntityGenerator.DEFAULT_質問事項５));
        }

        @Test
        public void 戻り値の質問事項６は_設定した値と同じ質問事項６を返す() {
            sut.set質問事項６(DbT3101NijiYoboKihonCheckListEntityGenerator.DEFAULT_質問事項６);
            assertThat(sut.get質問事項６(), is(DbT3101NijiYoboKihonCheckListEntityGenerator.DEFAULT_質問事項６));
        }

        @Test
        public void 戻り値の質問事項７は_設定した値と同じ質問事項７を返す() {
            sut.set質問事項７(DbT3101NijiYoboKihonCheckListEntityGenerator.DEFAULT_質問事項７);
            assertThat(sut.get質問事項７(), is(DbT3101NijiYoboKihonCheckListEntityGenerator.DEFAULT_質問事項７));
        }

        @Test
        public void 戻り値の質問事項８は_設定した値と同じ質問事項８を返す() {
            sut.set質問事項８(DbT3101NijiYoboKihonCheckListEntityGenerator.DEFAULT_質問事項８);
            assertThat(sut.get質問事項８(), is(DbT3101NijiYoboKihonCheckListEntityGenerator.DEFAULT_質問事項８));
        }

        @Test
        public void 戻り値の質問事項９は_設定した値と同じ質問事項９を返す() {
            sut.set質問事項９(DbT3101NijiYoboKihonCheckListEntityGenerator.DEFAULT_質問事項９);
            assertThat(sut.get質問事項９(), is(DbT3101NijiYoboKihonCheckListEntityGenerator.DEFAULT_質問事項９));
        }

        @Test
        public void 戻り値の質問事項１０は_設定した値と同じ質問事項１０を返す() {
            sut.set質問事項１０(DbT3101NijiYoboKihonCheckListEntityGenerator.DEFAULT_質問事項１０);
            assertThat(sut.get質問事項１０(), is(DbT3101NijiYoboKihonCheckListEntityGenerator.DEFAULT_質問事項１０));
        }

        @Test
        public void 戻り値の質問事項１１は_設定した値と同じ質問事項１１を返す() {
            sut.set質問事項１１(DbT3101NijiYoboKihonCheckListEntityGenerator.DEFAULT_質問事項１１);
            assertThat(sut.get質問事項１１(), is(DbT3101NijiYoboKihonCheckListEntityGenerator.DEFAULT_質問事項１１));
        }

        @Test
        public void 戻り値の質問事項１２身長は_設定した値と同じ質問事項１２身長を返す() {
            sut.set質問事項１２身長(DbT3101NijiYoboKihonCheckListEntityGenerator.DEFAULT_質問事項１２身長);
            assertThat(sut.get質問事項１２身長(), is(DbT3101NijiYoboKihonCheckListEntityGenerator.DEFAULT_質問事項１２身長));
        }

        @Test
        public void 戻り値の質問事項１２体重は_設定した値と同じ質問事項１２体重を返す() {
            sut.set質問事項１２体重(DbT3101NijiYoboKihonCheckListEntityGenerator.DEFAULT_質問事項１２体重);
            assertThat(sut.get質問事項１２体重(), is(DbT3101NijiYoboKihonCheckListEntityGenerator.DEFAULT_質問事項１２体重));
        }

        @Test
        public void 戻り値の質問事項１３は_設定した値と同じ質問事項１３を返す() {
            sut.set質問事項１３(DbT3101NijiYoboKihonCheckListEntityGenerator.DEFAULT_質問事項１３);
            assertThat(sut.get質問事項１３(), is(DbT3101NijiYoboKihonCheckListEntityGenerator.DEFAULT_質問事項１３));
        }

        @Test
        public void 戻り値の質問事項１４は_設定した値と同じ質問事項１４を返す() {
            sut.set質問事項１４(DbT3101NijiYoboKihonCheckListEntityGenerator.DEFAULT_質問事項１４);
            assertThat(sut.get質問事項１４(), is(DbT3101NijiYoboKihonCheckListEntityGenerator.DEFAULT_質問事項１４));
        }

        @Test
        public void 戻り値の質問事項１５は_設定した値と同じ質問事項１５を返す() {
            sut.set質問事項１５(DbT3101NijiYoboKihonCheckListEntityGenerator.DEFAULT_質問事項１５);
            assertThat(sut.get質問事項１５(), is(DbT3101NijiYoboKihonCheckListEntityGenerator.DEFAULT_質問事項１５));
        }

        @Test
        public void 戻り値の質問事項１６は_設定した値と同じ質問事項１６を返す() {
            sut.set質問事項１６(DbT3101NijiYoboKihonCheckListEntityGenerator.DEFAULT_質問事項１６);
            assertThat(sut.get質問事項１６(), is(DbT3101NijiYoboKihonCheckListEntityGenerator.DEFAULT_質問事項１６));
        }

        @Test
        public void 戻り値の質問事項１７は_設定した値と同じ質問事項１７を返す() {
            sut.set質問事項１７(DbT3101NijiYoboKihonCheckListEntityGenerator.DEFAULT_質問事項１７);
            assertThat(sut.get質問事項１７(), is(DbT3101NijiYoboKihonCheckListEntityGenerator.DEFAULT_質問事項１７));
        }

        @Test
        public void 戻り値の質問事項１８は_設定した値と同じ質問事項１８を返す() {
            sut.set質問事項１８(DbT3101NijiYoboKihonCheckListEntityGenerator.DEFAULT_質問事項１８);
            assertThat(sut.get質問事項１８(), is(DbT3101NijiYoboKihonCheckListEntityGenerator.DEFAULT_質問事項１８));
        }

        @Test
        public void 戻り値の質問事項１９は_設定した値と同じ質問事項１９を返す() {
            sut.set質問事項１９(DbT3101NijiYoboKihonCheckListEntityGenerator.DEFAULT_質問事項１９);
            assertThat(sut.get質問事項１９(), is(DbT3101NijiYoboKihonCheckListEntityGenerator.DEFAULT_質問事項１９));
        }

        @Test
        public void 戻り値の質問事項２０は_設定した値と同じ質問事項２０を返す() {
            sut.set質問事項２０(DbT3101NijiYoboKihonCheckListEntityGenerator.DEFAULT_質問事項２０);
            assertThat(sut.get質問事項２０(), is(DbT3101NijiYoboKihonCheckListEntityGenerator.DEFAULT_質問事項２０));
        }

        @Test
        public void 戻り値の質問事項２１は_設定した値と同じ質問事項２１を返す() {
            sut.set質問事項２１(DbT3101NijiYoboKihonCheckListEntityGenerator.DEFAULT_質問事項２１);
            assertThat(sut.get質問事項２１(), is(DbT3101NijiYoboKihonCheckListEntityGenerator.DEFAULT_質問事項２１));
        }

        @Test
        public void 戻り値の質問事項２２は_設定した値と同じ質問事項２２を返す() {
            sut.set質問事項２２(DbT3101NijiYoboKihonCheckListEntityGenerator.DEFAULT_質問事項２２);
            assertThat(sut.get質問事項２２(), is(DbT3101NijiYoboKihonCheckListEntityGenerator.DEFAULT_質問事項２２));
        }

        @Test
        public void 戻り値の質問事項２３は_設定した値と同じ質問事項２３を返す() {
            sut.set質問事項２３(DbT3101NijiYoboKihonCheckListEntityGenerator.DEFAULT_質問事項２３);
            assertThat(sut.get質問事項２３(), is(DbT3101NijiYoboKihonCheckListEntityGenerator.DEFAULT_質問事項２３));
        }

        @Test
        public void 戻り値の質問事項２４は_設定した値と同じ質問事項２４を返す() {
            sut.set質問事項２４(DbT3101NijiYoboKihonCheckListEntityGenerator.DEFAULT_質問事項２４);
            assertThat(sut.get質問事項２４(), is(DbT3101NijiYoboKihonCheckListEntityGenerator.DEFAULT_質問事項２４));
        }

        @Test
        public void 戻り値の質問事項２５は_設定した値と同じ質問事項２５を返す() {
            sut.set質問事項２５(DbT3101NijiYoboKihonCheckListEntityGenerator.DEFAULT_質問事項２５);
            assertThat(sut.get質問事項２５(), is(DbT3101NijiYoboKihonCheckListEntityGenerator.DEFAULT_質問事項２５));
        }
    }

    public static class getStateTest extends DbzTestBase {

        @Test
        public void 状態Addedの取得確認() {
            NijiYoboKihonCheckListModel sut = new NijiYoboKihonCheckListModel();

            assertThat(sut.getState(), is(EntityDataState.Added));
        }

        @Test
        public void 状態Modifinedの取得確認() {
            NijiYoboKihonCheckListModel sut = new NijiYoboKihonCheckListModel();
            sut.setEntity(DbT3101NijiYoboKihonCheckListEntityGenerator.createDbT3101NijiYoboKihonCheckListEntity());

            sut.getEntity().initializeMd5();

            // TODO 主キー以外の項目を変更してください
//            sut.getEntity().setXXX(new XXX());
//            assertThat(sut.getState(), is(EntityDataState.Modified));
        }

        @Test
        public void 状態Unchangedの取得確認() {
            NijiYoboKihonCheckListModel sut = new NijiYoboKihonCheckListModel();
            sut.setEntity(DbT3101NijiYoboKihonCheckListEntityGenerator.createDbT3101NijiYoboKihonCheckListEntity());

            sut.getEntity().initializeMd5();

            assertThat(sut.getState(), is(EntityDataState.Unchanged));
        }

        @Test
        public void 状態Deletedの取得確認() {
            NijiYoboKihonCheckListModel sut = new NijiYoboKihonCheckListModel();
            sut.setEntity(DbT3101NijiYoboKihonCheckListEntityGenerator.createDbT3101NijiYoboKihonCheckListEntity());

            sut.getEntity().initializeMd5();

            sut.setDeletedState(true);

            assertThat(sut.getState(), is(EntityDataState.Deleted));
        }
    }
}
