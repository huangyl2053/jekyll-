/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.model;

import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT3082DaisanshaKoiKyushoEntityGenerator;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link DaisanshaKoiKyushoModel}のテストクラスです。
 *
 * @author LDNS 宋昕沢
 */
@RunWith(Enclosed.class)
public class DaisanshaKoiKyushoModelTest extends DbzTestBase {

    public static class getterSetterTest extends DbzTestBase {

        private static DaisanshaKoiKyushoModel sut;

        @BeforeClass
        public static void test() {
            sut = new DaisanshaKoiKyushoModel();
        }

        @Test
        public void 戻り値の被保険者番号は_設定した値と同じ被保険者番号を返す() {
            sut.set被保険者番号(DbT3082DaisanshaKoiKyushoEntityGenerator.DEFAULT_被保険者番号);
            assertThat(sut.get被保険者番号(), is(DbT3082DaisanshaKoiKyushoEntityGenerator.DEFAULT_被保険者番号));
        }

        @Test
        public void 戻り値の第三者行為届出管理番号は_設定した値と同じ第三者行為届出管理番号を返す() {
            sut.set第三者行為届出管理番号(DbT3082DaisanshaKoiKyushoEntityGenerator.DEFAULT_第三者行為届出管理番号);
            assertThat(sut.get第三者行為届出管理番号(), is(DbT3082DaisanshaKoiKyushoEntityGenerator.DEFAULT_第三者行為届出管理番号));
        }

        @Test
        public void 戻り値の第三者行為求償請求番号は_設定した値と同じ第三者行為求償請求番号を返す() {
            sut.set第三者行為求償請求番号(DbT3082DaisanshaKoiKyushoEntityGenerator.DEFAULT_第三者行為求償請求番号);
            assertThat(sut.get第三者行為求償請求番号(), is(DbT3082DaisanshaKoiKyushoEntityGenerator.DEFAULT_第三者行為求償請求番号));
        }

        @Test
        public void 戻り値の処理日時は_設定した値と同じ処理日時を返す() {
            sut.set処理日時(DbT3082DaisanshaKoiKyushoEntityGenerator.DEFAULT_処理日時);
            assertThat(sut.get処理日時(), is(DbT3082DaisanshaKoiKyushoEntityGenerator.DEFAULT_処理日時));
        }

        @Test
        public void 戻り値の給付額合計は_設定した値と同じ給付額合計を返す() {
            sut.set給付額合計(DbT3082DaisanshaKoiKyushoEntityGenerator.DEFAULT_給付額合計);
            assertThat(sut.get給付額合計(), is(DbT3082DaisanshaKoiKyushoEntityGenerator.DEFAULT_給付額合計));
        }

        @Test
        public void 戻り値の過失相殺額は_設定した値と同じ過失相殺額を返す() {
            sut.set過失相殺額(DbT3082DaisanshaKoiKyushoEntityGenerator.DEFAULT_過失相殺額);
            assertThat(sut.get過失相殺額(), is(DbT3082DaisanshaKoiKyushoEntityGenerator.DEFAULT_過失相殺額));
        }

        @Test
        public void 戻り値の保険給付請求額は_設定した値と同じ保険給付請求額を返す() {
            sut.set保険給付請求額(DbT3082DaisanshaKoiKyushoEntityGenerator.DEFAULT_保険給付請求額);
            assertThat(sut.get保険給付請求額(), is(DbT3082DaisanshaKoiKyushoEntityGenerator.DEFAULT_保険給付請求額));
        }

        @Test
        public void 戻り値の損害賠償金納入期限は_設定した値と同じ損害賠償金納入期限を返す() {
            sut.set損害賠償金納入期限(DbT3082DaisanshaKoiKyushoEntityGenerator.DEFAULT_損害賠償金納入期限);
            assertThat(sut.get損害賠償金納入期限(), is(DbT3082DaisanshaKoiKyushoEntityGenerator.DEFAULT_損害賠償金納入期限));
        }

        @Test
        public void 戻り値の請求先郵便番号は_設定した値と同じ請求先郵便番号を返す() {
            sut.set請求先郵便番号(DbT3082DaisanshaKoiKyushoEntityGenerator.DEFAULT_請求先郵便番号);
            assertThat(sut.get請求先郵便番号(), is(DbT3082DaisanshaKoiKyushoEntityGenerator.DEFAULT_請求先郵便番号));
        }

        @Test
        public void 戻り値の請求先住所は_設定した値と同じ請求先住所を返す() {
            sut.set請求先住所(DbT3082DaisanshaKoiKyushoEntityGenerator.DEFAULT_請求先住所);
            assertThat(sut.get請求先住所(), is(DbT3082DaisanshaKoiKyushoEntityGenerator.DEFAULT_請求先住所));
        }

        @Test
        public void 戻り値の請求先名称は_設定した値と同じ請求先名称を返す() {
            sut.set請求先名称(DbT3082DaisanshaKoiKyushoEntityGenerator.DEFAULT_請求先名称);
            assertThat(sut.get請求先名称(), is(DbT3082DaisanshaKoiKyushoEntityGenerator.DEFAULT_請求先名称));
        }

        @Test
        public void 戻り値の請求先部署は_設定した値と同じ請求先部署を返す() {
            sut.set請求先部署(DbT3082DaisanshaKoiKyushoEntityGenerator.DEFAULT_請求先部署);
            assertThat(sut.get請求先部署(), is(DbT3082DaisanshaKoiKyushoEntityGenerator.DEFAULT_請求先部署));
        }

        @Test
        public void 戻り値の請求先担当者は_設定した値と同じ請求先担当者を返す() {
            sut.set請求先担当者(DbT3082DaisanshaKoiKyushoEntityGenerator.DEFAULT_請求先担当者);
            assertThat(sut.get請求先担当者(), is(DbT3082DaisanshaKoiKyushoEntityGenerator.DEFAULT_請求先担当者));
        }

        @Test
        public void 戻り値の請求先電話番号は_設定した値と同じ請求先電話番号を返す() {
            sut.set請求先電話番号(DbT3082DaisanshaKoiKyushoEntityGenerator.DEFAULT_請求先電話番号);
            assertThat(sut.get請求先電話番号(), is(DbT3082DaisanshaKoiKyushoEntityGenerator.DEFAULT_請求先電話番号));
        }
    }

    public static class getStateTest extends DbzTestBase {

        @Test
        public void 状態Addedの取得確認() {
            DaisanshaKoiKyushoModel sut = new DaisanshaKoiKyushoModel();

            assertThat(sut.getState(), is(EntityDataState.Added));
        }

        @Test
        public void 状態Modifinedの取得確認() {
            DaisanshaKoiKyushoModel sut = new DaisanshaKoiKyushoModel();
            sut.setEntity(DbT3082DaisanshaKoiKyushoEntityGenerator.createDbT3082DaisanshaKoiKyushoEntity());

            sut.getEntity().initializeMd5();

            //TODO  主キー以外の項目を変更してください
//            sut.getEntity().setXXX(new XXX());
//            assertThat(sut.getState(), is(EntityDataState.Modified));
        }

        @Test
        public void 状態Unchangedの取得確認() {
            DaisanshaKoiKyushoModel sut = new DaisanshaKoiKyushoModel();
            sut.setEntity(DbT3082DaisanshaKoiKyushoEntityGenerator.createDbT3082DaisanshaKoiKyushoEntity());

            sut.getEntity().initializeMd5();

            assertThat(sut.getState(), is(EntityDataState.Unchanged));
        }

        @Test
        public void 状態Deletedの取得確認() {
            DaisanshaKoiKyushoModel sut = new DaisanshaKoiKyushoModel();
            sut.setEntity(DbT3082DaisanshaKoiKyushoEntityGenerator.createDbT3082DaisanshaKoiKyushoEntity());

            sut.getEntity().initializeMd5();

            sut.setDeletedState(true);

            assertThat(sut.getState(), is(EntityDataState.Deleted));
        }
    }
}
