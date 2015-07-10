/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.model;

import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT3079DaisanshaKoiSongaiBaishoKinJuryoEntityGenerator;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link DaisanshaKoiSongaiBaishoKinJuryoModel}のテストクラスです。
 *
 * @author LDNS 宋昕沢
 */
@RunWith(Enclosed.class)
public class DaisanshaKoiSongaiBaishoKinJuryoModelTest extends DbzTestBase {

    public static class getterSetterTest extends DbzTestBase {

        private static DaisanshaKoiSongaiBaishoKinJuryoModel sut;

        @BeforeClass
        public static void test() {
            sut = new DaisanshaKoiSongaiBaishoKinJuryoModel();
        }

        @Test
        public void 戻り値の被保険者番号は_設定した値と同じ被保険者番号を返す() {
            sut.set被保険者番号(DbT3079DaisanshaKoiSongaiBaishoKinJuryoEntityGenerator.DEFAULT_被保険者番号);
            assertThat(sut.get被保険者番号(), is(DbT3079DaisanshaKoiSongaiBaishoKinJuryoEntityGenerator.DEFAULT_被保険者番号));
        }

        @Test
        public void 戻り値の第三者行為届出管理番号は_設定した値と同じ第三者行為届出管理番号を返す() {
            sut.set第三者行為届出管理番号(DbT3079DaisanshaKoiSongaiBaishoKinJuryoEntityGenerator.DEFAULT_第三者行為届出管理番号);
            assertThat(sut.get第三者行為届出管理番号(), is(DbT3079DaisanshaKoiSongaiBaishoKinJuryoEntityGenerator.DEFAULT_第三者行為届出管理番号));
        }

        @Test
        public void 戻り値の第三者行為求償請求番号は_設定した値と同じ第三者行為求償請求番号を返す() {
            sut.set第三者行為求償請求番号(DbT3079DaisanshaKoiSongaiBaishoKinJuryoEntityGenerator.DEFAULT_第三者行為求償請求番号);
            assertThat(sut.get第三者行為求償請求番号(), is(DbT3079DaisanshaKoiSongaiBaishoKinJuryoEntityGenerator.DEFAULT_第三者行為求償請求番号));
        }

        @Test
        public void 戻り値の処理日時は_設定した値と同じ処理日時を返す() {
            sut.set処理日時(DbT3079DaisanshaKoiSongaiBaishoKinJuryoEntityGenerator.DEFAULT_処理日時);
            assertThat(sut.get処理日時(), is(DbT3079DaisanshaKoiSongaiBaishoKinJuryoEntityGenerator.DEFAULT_処理日時));
        }

        @Test
        public void 戻り値の入金確認年月日は_設定した値と同じ入金確認年月日を返す() {
            sut.set入金確認年月日(DbT3079DaisanshaKoiSongaiBaishoKinJuryoEntityGenerator.DEFAULT_入金確認年月日);
            assertThat(sut.get入金確認年月日(), is(DbT3079DaisanshaKoiSongaiBaishoKinJuryoEntityGenerator.DEFAULT_入金確認年月日));
        }

        @Test
        public void 戻り値の領収年月日は_設定した値と同じ領収年月日を返す() {
            sut.set領収年月日(DbT3079DaisanshaKoiSongaiBaishoKinJuryoEntityGenerator.DEFAULT_領収年月日);
            assertThat(sut.get領収年月日(), is(DbT3079DaisanshaKoiSongaiBaishoKinJuryoEntityGenerator.DEFAULT_領収年月日));
        }

        @Test
        public void 戻り値の領収金額は_設定した値と同じ領収金額を返す() {
            sut.set領収金額(DbT3079DaisanshaKoiSongaiBaishoKinJuryoEntityGenerator.DEFAULT_領収金額);
            assertThat(sut.get領収金額(), is(DbT3079DaisanshaKoiSongaiBaishoKinJuryoEntityGenerator.DEFAULT_領収金額));
        }

        @Test
        public void 戻り値の過不足金有無は_設定した値と同じ過不足金有無を返す() {
            sut.set過不足金有無(DbT3079DaisanshaKoiSongaiBaishoKinJuryoEntityGenerator.DEFAULT_過不足金有無);
            assertThat(sut.get過不足金有無(), is(DbT3079DaisanshaKoiSongaiBaishoKinJuryoEntityGenerator.DEFAULT_過不足金有無));
        }

        @Test
        public void 戻り値の過不足額は_設定した値と同じ過不足額を返す() {
            sut.set過不足額(DbT3079DaisanshaKoiSongaiBaishoKinJuryoEntityGenerator.DEFAULT_過不足額);
            assertThat(sut.get過不足額(), is(DbT3079DaisanshaKoiSongaiBaishoKinJuryoEntityGenerator.DEFAULT_過不足額));
        }
    }

    public static class getStateTest extends DbzTestBase {

        @Test
        public void 状態Addedの取得確認() {
            DaisanshaKoiSongaiBaishoKinJuryoModel sut = new DaisanshaKoiSongaiBaishoKinJuryoModel();

            assertThat(sut.getState(), is(EntityDataState.Added));
        }

        @Test
        public void 状態Modifinedの取得確認() {
            DaisanshaKoiSongaiBaishoKinJuryoModel sut = new DaisanshaKoiSongaiBaishoKinJuryoModel();
            sut.setEntity(DbT3079DaisanshaKoiSongaiBaishoKinJuryoEntityGenerator.createDbT3079DaisanshaKoiSongaiBaishoKinJuryoEntity());

            sut.getEntity().initializeMd5();

            //TODO  主キー以外の項目を変更してください
//            sut.getEntity().setXXX(new XXX());
//            assertThat(sut.getState(), is(EntityDataState.Modified));
        }

        @Test
        public void 状態Unchangedの取得確認() {
            DaisanshaKoiSongaiBaishoKinJuryoModel sut = new DaisanshaKoiSongaiBaishoKinJuryoModel();
            sut.setEntity(DbT3079DaisanshaKoiSongaiBaishoKinJuryoEntityGenerator.createDbT3079DaisanshaKoiSongaiBaishoKinJuryoEntity());

            sut.getEntity().initializeMd5();

            assertThat(sut.getState(), is(EntityDataState.Unchanged));
        }

        @Test
        public void 状態Deletedの取得確認() {
            DaisanshaKoiSongaiBaishoKinJuryoModel sut = new DaisanshaKoiSongaiBaishoKinJuryoModel();
            sut.setEntity(DbT3079DaisanshaKoiSongaiBaishoKinJuryoEntityGenerator.createDbT3079DaisanshaKoiSongaiBaishoKinJuryoEntity());

            sut.getEntity().initializeMd5();

            sut.setDeletedState(true);

            assertThat(sut.getState(), is(EntityDataState.Deleted));
        }
    }
}
