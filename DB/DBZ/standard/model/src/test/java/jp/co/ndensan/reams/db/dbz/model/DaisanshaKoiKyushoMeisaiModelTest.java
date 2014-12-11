/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.model;

import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT3083DaisanshaKoiKyushoMeisaiEntityGenerator;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link DaisanshaKoiKyushoMeisaiModel}のテストクラスです。
 *
 * @author LDNS 宋昕沢
 */
@RunWith(Enclosed.class)
public class DaisanshaKoiKyushoMeisaiModelTest extends DbzTestBase {

    public static class getterSetterTest extends DbzTestBase {

        private static DaisanshaKoiKyushoMeisaiModel sut;

        @BeforeClass
        public static void test() {
            sut = new DaisanshaKoiKyushoMeisaiModel();
        }

        @Test
        public void 戻り値の被保険者番号は_設定した値と同じ被保険者番号を返す() {
            sut.set被保険者番号(DbT3083DaisanshaKoiKyushoMeisaiEntityGenerator.DEFAULT_被保険者番号);
            assertThat(sut.get被保険者番号(), is(DbT3083DaisanshaKoiKyushoMeisaiEntityGenerator.DEFAULT_被保険者番号));
        }

        @Test
        public void 戻り値の第三者行為届出管理番号は_設定した値と同じ第三者行為届出管理番号を返す() {
            sut.set第三者行為届出管理番号(DbT3083DaisanshaKoiKyushoMeisaiEntityGenerator.DEFAULT_第三者行為届出管理番号);
            assertThat(sut.get第三者行為届出管理番号(), is(DbT3083DaisanshaKoiKyushoMeisaiEntityGenerator.DEFAULT_第三者行為届出管理番号));
        }

        @Test
        public void 戻り値の第三者行為求償請求番号は_設定した値と同じ第三者行為求償請求番号を返す() {
            sut.set第三者行為求償請求番号(DbT3083DaisanshaKoiKyushoMeisaiEntityGenerator.DEFAULT_第三者行為求償請求番号);
            assertThat(sut.get第三者行為求償請求番号(), is(DbT3083DaisanshaKoiKyushoMeisaiEntityGenerator.DEFAULT_第三者行為求償請求番号));
        }

        @Test
        public void 戻り値のサービス提供年月は_設定した値と同じサービス提供年月を返す() {
            sut.setサービス提供年月(DbT3083DaisanshaKoiKyushoMeisaiEntityGenerator.DEFAULT_サービス提供年月);
            assertThat(sut.getサービス提供年月(), is(DbT3083DaisanshaKoiKyushoMeisaiEntityGenerator.DEFAULT_サービス提供年月));
        }

        @Test
        public void 戻り値のサービス提供事業者番号は_設定した値と同じサービス提供事業者番号を返す() {
            sut.setサービス提供事業者番号(DbT3083DaisanshaKoiKyushoMeisaiEntityGenerator.DEFAULT_サービス提供事業者番号);
            assertThat(sut.getサービス提供事業者番号(), is(DbT3083DaisanshaKoiKyushoMeisaiEntityGenerator.DEFAULT_サービス提供事業者番号));
        }

        @Test
        public void 戻り値のサービス種類コードは_設定した値と同じサービス種類コードを返す() {
            sut.setサービス種類コード(DbT3083DaisanshaKoiKyushoMeisaiEntityGenerator.DEFAULT_サービス種類コード);
            assertThat(sut.getサービス種類コード(), is(DbT3083DaisanshaKoiKyushoMeisaiEntityGenerator.DEFAULT_サービス種類コード));
        }

        @Test
        public void 戻り値の処理日時は_設定した値と同じ処理日時を返す() {
            sut.set処理日時(DbT3083DaisanshaKoiKyushoMeisaiEntityGenerator.DEFAULT_処理日時);
            assertThat(sut.get処理日時(), is(DbT3083DaisanshaKoiKyushoMeisaiEntityGenerator.DEFAULT_処理日時));
        }

        @Test
        public void 戻り値の給付額は_設定した値と同じ給付額を返す() {
            sut.set給付額(DbT3083DaisanshaKoiKyushoMeisaiEntityGenerator.DEFAULT_給付額);
            assertThat(sut.get給付額(), is(DbT3083DaisanshaKoiKyushoMeisaiEntityGenerator.DEFAULT_給付額));
        }
    }

    public static class getStateTest extends DbzTestBase {

        @Test
        public void 状態Addedの取得確認() {
            DaisanshaKoiKyushoMeisaiModel sut = new DaisanshaKoiKyushoMeisaiModel();

            assertThat(sut.getState(), is(EntityDataState.Added));
        }

        @Test
        public void 状態Modifinedの取得確認() {
            DaisanshaKoiKyushoMeisaiModel sut = new DaisanshaKoiKyushoMeisaiModel();
            sut.setEntity(DbT3083DaisanshaKoiKyushoMeisaiEntityGenerator.createDbT3083DaisanshaKoiKyushoMeisaiEntity());

            sut.getEntity().initializeMd5();

            //TODO  主キー以外の項目を変更してください
//            sut.getEntity().setXXX(new XXX());
//            assertThat(sut.getState(), is(EntityDataState.Modified));
        }

        @Test
        public void 状態Unchangedの取得確認() {
            DaisanshaKoiKyushoMeisaiModel sut = new DaisanshaKoiKyushoMeisaiModel();
            sut.setEntity(DbT3083DaisanshaKoiKyushoMeisaiEntityGenerator.createDbT3083DaisanshaKoiKyushoMeisaiEntity());

            sut.getEntity().initializeMd5();

            assertThat(sut.getState(), is(EntityDataState.Unchanged));
        }

        @Test
        public void 状態Deletedの取得確認() {
            DaisanshaKoiKyushoMeisaiModel sut = new DaisanshaKoiKyushoMeisaiModel();
            sut.setEntity(DbT3083DaisanshaKoiKyushoMeisaiEntityGenerator.createDbT3083DaisanshaKoiKyushoMeisaiEntity());

            sut.getEntity().initializeMd5();

            sut.setDeletedState(true);

            assertThat(sut.getState(), is(EntityDataState.Deleted));
        }
    }
}
