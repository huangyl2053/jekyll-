/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.model;

import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT1012Minashi2GoshaDaichoEntityGenerator;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link Minashi2GoshaDaichoModel}のテストクラスです。
 *
 * @author LDNS 鄭雪双
 */
@RunWith(Enclosed.class)
public class Minashi2GoshaDaichoModelTest extends DbzTestBase {

    public static class getterSetterTest extends DbzTestBase {

        private static Minashi2GoshaDaichoModel sut;

        @BeforeClass
        public static void test() {
            sut = new Minashi2GoshaDaichoModel();
        }

        @Test
        public void 戻り値の市町村コードは_設定した値と同じ市町村コードを返す() {
            sut.set市町村コード(DbT1012Minashi2GoshaDaichoEntityGenerator.DEFAULT_市町村コード);
            assertThat(sut.get市町村コード(), is(DbT1012Minashi2GoshaDaichoEntityGenerator.DEFAULT_市町村コード));
        }

        @Test
        public void 戻り値の被保険者番号は_設定した値と同じ被保険者番号を返す() {
            sut.set被保険者番号(DbT1012Minashi2GoshaDaichoEntityGenerator.DEFAULT_被保険者番号);
            assertThat(sut.get被保険者番号(), is(DbT1012Minashi2GoshaDaichoEntityGenerator.DEFAULT_被保険者番号));
        }

        @Test
        public void 戻り値の処理日時は_設定した値と同じ処理日時を返す() {
            sut.set処理日時(DbT1012Minashi2GoshaDaichoEntityGenerator.DEFAULT_処理日時);
            assertThat(sut.get処理日時(), is(DbT1012Minashi2GoshaDaichoEntityGenerator.DEFAULT_処理日時));
        }

        @Test
        public void 戻り値の識別コードは_設定した値と同じ識別コードを返す() {
            sut.set識別コード(DbT1012Minashi2GoshaDaichoEntityGenerator.DEFAULT_識別コード);
            assertThat(sut.get識別コード(), is(DbT1012Minashi2GoshaDaichoEntityGenerator.DEFAULT_識別コード));
        }

        @Test
        public void 戻り値の被保険者区分コードは_設定した値と同じ被保険者区分コードを返す() {
            sut.set被保険者区分コード(DbT1012Minashi2GoshaDaichoEntityGenerator.DEFAULT_被保険者区分コード);
            assertThat(sut.get被保険者区分コード(), is(DbT1012Minashi2GoshaDaichoEntityGenerator.DEFAULT_被保険者区分コード));
        }

        @Test
        public void 戻り値の登録年月日は_設定した値と同じ登録年月日を返す() {
            sut.set登録年月日(DbT1012Minashi2GoshaDaichoEntityGenerator.DEFAULT_登録年月日);
            assertThat(sut.get登録年月日(), is(DbT1012Minashi2GoshaDaichoEntityGenerator.DEFAULT_登録年月日));
        }

        @Test
        public void 戻り値の解除年月日は_設定した値と同じ解除年月日を返す() {
            sut.set解除年月日(DbT1012Minashi2GoshaDaichoEntityGenerator.DEFAULT_解除年月日);
            assertThat(sut.get解除年月日(), is(DbT1012Minashi2GoshaDaichoEntityGenerator.DEFAULT_解除年月日));
        }

        @Test
        public void 戻り値の福祉被保険者番号は_設定した値と同じ福祉被保険者番号を返す() {
            sut.set福祉被保険者番号(DbT1012Minashi2GoshaDaichoEntityGenerator.DEFAULT_福祉被保険者番号);
            assertThat(sut.get福祉被保険者番号(), is(DbT1012Minashi2GoshaDaichoEntityGenerator.DEFAULT_福祉被保険者番号));
        }
    }

    public static class getStateTest extends DbzTestBase {

        @Test
        public void 状態Addedの取得確認() {
            Minashi2GoshaDaichoModel sut = new Minashi2GoshaDaichoModel();

            assertThat(sut.getState(), is(EntityDataState.Added));
        }

        @Test
        public void 状態Modifinedの取得確認() {
            Minashi2GoshaDaichoModel sut = new Minashi2GoshaDaichoModel();
            sut.setEntity(DbT1012Minashi2GoshaDaichoEntityGenerator.createDbT1012Minashi2GoshaDaichoEntity());

            sut.getEntity().initializeMd5();

            // 主キー以外の項目を変更してください
//            sut.getEntity().setXXX(new XXX());
//            assertThat(sut.getState(), is(EntityDataState.Modified));
        }

        @Test
        public void 状態Unchangedの取得確認() {
            Minashi2GoshaDaichoModel sut = new Minashi2GoshaDaichoModel();
            sut.setEntity(DbT1012Minashi2GoshaDaichoEntityGenerator.createDbT1012Minashi2GoshaDaichoEntity());

            sut.getEntity().initializeMd5();

            assertThat(sut.getState(), is(EntityDataState.Unchanged));
        }

        @Test
        public void 状態Deletedの取得確認() {
            Minashi2GoshaDaichoModel sut = new Minashi2GoshaDaichoModel();
            sut.setEntity(DbT1012Minashi2GoshaDaichoEntityGenerator.createDbT1012Minashi2GoshaDaichoEntity());

            sut.getEntity().initializeMd5();

            sut.setDeletedState(true);

            assertThat(sut.getState(), is(EntityDataState.Deleted));
        }
    }
}
