/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.model;

import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT2009RentaiGimushaEntityGenerator;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link RentaiGimushaModel}のテストクラスです。
 *
 * @author LDNS 鄭雪双
 */
@RunWith(Enclosed.class)
public class RentaiGimushaModelTest extends DbzTestBase {

    public static class getterSetterTest extends DbzTestBase {

        private static RentaiGimushaModel sut;

        @BeforeClass
        public static void test() {
            sut = new RentaiGimushaModel();
        }

        @Test
        public void 戻り値の被保険者番号は_設定した値と同じ被保険者番号を返す() {
            sut.set被保険者番号(DbT2009RentaiGimushaEntityGenerator.DEFAULT_被保険者番号);
            assertThat(sut.get被保険者番号(), is(DbT2009RentaiGimushaEntityGenerator.DEFAULT_被保険者番号));
        }

        @Test
        public void 戻り値の処理日時は_設定した値と同じ処理日時を返す() {
            sut.set処理日時(DbT2009RentaiGimushaEntityGenerator.DEFAULT_処理日時);
            assertThat(sut.get処理日時(), is(DbT2009RentaiGimushaEntityGenerator.DEFAULT_処理日時));
        }

        @Test
        public void 戻り値の履歴番号は_設定した値と同じ履歴番号を返す() {
            sut.set履歴番号(DbT2009RentaiGimushaEntityGenerator.DEFAULT_履歴番号);
            assertThat(sut.get履歴番号(), is(DbT2009RentaiGimushaEntityGenerator.DEFAULT_履歴番号));
        }

        @Test
        public void 戻り値の識別コードは_設定した値と同じ識別コードを返す() {
            sut.set識別コード(DbT2009RentaiGimushaEntityGenerator.DEFAULT_識別コード);
            assertThat(sut.get識別コード(), is(DbT2009RentaiGimushaEntityGenerator.DEFAULT_識別コード));
        }

        @Test
        public void 戻り値の開始年月日は_設定した値と同じ開始年月日を返す() {
            sut.set開始年月日(DbT2009RentaiGimushaEntityGenerator.DEFAULT_開始年月日);
            assertThat(sut.get開始年月日(), is(DbT2009RentaiGimushaEntityGenerator.DEFAULT_開始年月日));
        }

        @Test
        public void 戻り値の終了年月日は_設定した値と同じ終了年月日を返す() {
            sut.set終了年月日(DbT2009RentaiGimushaEntityGenerator.DEFAULT_終了年月日);
            assertThat(sut.get終了年月日(), is(DbT2009RentaiGimushaEntityGenerator.DEFAULT_終了年月日));
        }
    }

    public static class getStateTest extends DbzTestBase {

        @Test
        public void 状態Addedの取得確認() {
            RentaiGimushaModel sut = new RentaiGimushaModel();

            assertThat(sut.getState(), is(EntityDataState.Added));
        }

        @Test
        public void 状態Modifinedの取得確認() {
            RentaiGimushaModel sut = new RentaiGimushaModel();
            sut.setEntity(DbT2009RentaiGimushaEntityGenerator.createDbT2009RentaiGimushaEntity());

            sut.getEntity().initializeMd5();

            // 主キー以外の項目を変更してください
//            sut.getEntity().setXXX(new XXX());
//            assertThat(sut.getState(), is(EntityDataState.Modified));
        }

        @Test
        public void 状態Unchangedの取得確認() {
            RentaiGimushaModel sut = new RentaiGimushaModel();
            sut.setEntity(DbT2009RentaiGimushaEntityGenerator.createDbT2009RentaiGimushaEntity());

            sut.getEntity().initializeMd5();

            assertThat(sut.getState(), is(EntityDataState.Unchanged));
        }

        @Test
        public void 状態Deletedの取得確認() {
            RentaiGimushaModel sut = new RentaiGimushaModel();
            sut.setEntity(DbT2009RentaiGimushaEntityGenerator.createDbT2009RentaiGimushaEntity());

            sut.getEntity().initializeMd5();

            sut.setDeletedState(true);

            assertThat(sut.getState(), is(EntityDataState.Deleted));
        }
    }
}
