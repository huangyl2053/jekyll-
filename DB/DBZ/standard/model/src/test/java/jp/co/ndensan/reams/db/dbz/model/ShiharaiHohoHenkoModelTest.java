/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.model;

import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT4021ShiharaiHohoHenkoEntityGenerator;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import static org.hamcrest.CoreMatchers.is;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.BeforeClass;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link ShiharaiHohoHenkoModel}のテストクラスです。
 *
 * @author n8187 久保田 英男
 */
@RunWith(Enclosed.class)
public class ShiharaiHohoHenkoModelTest extends DbzTestBase {

    public static class getterSetterTest extends DbzTestBase {

        private static ShiharaiHohoHenkoModel sut;

        @BeforeClass
        public static void test() {
            sut = new ShiharaiHohoHenkoModel();
        }

        @Test
        public void 戻り値の証記載保険者番号は_設定した値と同じ証記載保険者番号を返す() {
            sut.set証記載保険者番号(DbT4021ShiharaiHohoHenkoEntityGenerator.DEFAULT_証記載保険者番号);
            assertThat(sut.get証記載保険者番号(), is(DbT4021ShiharaiHohoHenkoEntityGenerator.DEFAULT_証記載保険者番号));
        }

        @Test
        public void 戻り値の被保険者番号は_設定した値と同じ被保険者番号を返す() {
            sut.set被保険者番号(DbT4021ShiharaiHohoHenkoEntityGenerator.DEFAULT_被保険者番号);
            assertThat(sut.get被保険者番号(), is(DbT4021ShiharaiHohoHenkoEntityGenerator.DEFAULT_被保険者番号));
        }

        @Test
        public void 戻り値の管理区分は_設定した値と同じ管理区分を返す() {
            sut.set管理区分(DbT4021ShiharaiHohoHenkoEntityGenerator.DEFAULT_管理区分);
            assertThat(sut.get管理区分(), is(DbT4021ShiharaiHohoHenkoEntityGenerator.DEFAULT_管理区分));
        }

        @Test
        public void 戻り値の処理日時は_設定した値と同じ処理日時を返す() {
            sut.set処理日時(DbT4021ShiharaiHohoHenkoEntityGenerator.DEFAULT_処理日時);
            assertThat(sut.get処理日時(), is(DbT4021ShiharaiHohoHenkoEntityGenerator.DEFAULT_処理日時));
        }

        @Test
        public void 戻り値の登録区分は_設定した値と同じ登録区分を返す() {
            sut.set登録区分(DbT4021ShiharaiHohoHenkoEntityGenerator.DEFAULT_登録区分);
            assertThat(sut.get登録区分(), is(DbT4021ShiharaiHohoHenkoEntityGenerator.DEFAULT_登録区分));
        }

        @Test
        public void 戻り値の適用開始年月日は_設定した値と同じ適用開始年月日を返す() {
            sut.set適用開始年月日(DbT4021ShiharaiHohoHenkoEntityGenerator.DEFAULT_適用開始年月日);
            assertThat(sut.get適用開始年月日(), is(DbT4021ShiharaiHohoHenkoEntityGenerator.DEFAULT_適用開始年月日));
        }

        @Test
        public void 戻り値の適用終了年月日は_設定した値と同じ適用終了年月日を返す() {
            sut.set適用終了年月日(DbT4021ShiharaiHohoHenkoEntityGenerator.DEFAULT_適用終了年月日);
            assertThat(sut.get適用終了年月日(), is(DbT4021ShiharaiHohoHenkoEntityGenerator.DEFAULT_適用終了年月日));
        }

        @Test
        public void 戻り値の終了区分は_設定した値と同じ終了区分を返す() {
            sut.set終了区分(DbT4021ShiharaiHohoHenkoEntityGenerator.DEFAULT_終了区分);
            assertThat(sut.get終了区分(), is(DbT4021ShiharaiHohoHenkoEntityGenerator.DEFAULT_終了区分));
        }

        @Test
        public void 戻り値の予告登録年月日は_設定した値と同じ予告登録年月日を返す() {
            sut.set予告登録年月日(DbT4021ShiharaiHohoHenkoEntityGenerator.DEFAULT_予告登録年月日);
            assertThat(sut.get予告登録年月日(), is(DbT4021ShiharaiHohoHenkoEntityGenerator.DEFAULT_予告登録年月日));
        }

        @Test
        public void 戻り値の差止依頼書受理年月日は_設定した値と同じ差止依頼書受理年月日を返す() {
            sut.set差止依頼書受理年月日(DbT4021ShiharaiHohoHenkoEntityGenerator.DEFAULT_差止依頼書受理年月日);
            assertThat(sut.get差止依頼書受理年月日(), is(DbT4021ShiharaiHohoHenkoEntityGenerator.DEFAULT_差止依頼書受理年月日));
        }

        @Test
        public void 戻り値の予告通知書発行年月日は_設定した値と同じ予告通知書発行年月日を返す() {
            sut.set予告通知書発行年月日(DbT4021ShiharaiHohoHenkoEntityGenerator.DEFAULT_予告通知書発行年月日);
            assertThat(sut.get予告通知書発行年月日(), is(DbT4021ShiharaiHohoHenkoEntityGenerator.DEFAULT_予告通知書発行年月日));
        }

        @Test
        public void 戻り値の予告通知書再発行フラグは_設定した値と同じ予告通知書再発行フラグを返す() {
            sut.set予告通知書再発行フラグ(DbT4021ShiharaiHohoHenkoEntityGenerator.DEFAULT_予告通知書再発行フラグ);
            assertThat(sut.get予告通知書再発行フラグ(), is(DbT4021ShiharaiHohoHenkoEntityGenerator.DEFAULT_予告通知書再発行フラグ));
        }

        @Test
        public void 戻り値の弁明書提出期限は_設定した値と同じ弁明書提出期限を返す() {
            sut.set弁明書提出期限(DbT4021ShiharaiHohoHenkoEntityGenerator.DEFAULT_弁明書提出期限);
            assertThat(sut.get弁明書提出期限(), is(DbT4021ShiharaiHohoHenkoEntityGenerator.DEFAULT_弁明書提出期限));
        }

        @Test
        public void 戻り値の弁明書受付年月日は_設定した値と同じ弁明書受付年月日を返す() {
            sut.set弁明書受付年月日(DbT4021ShiharaiHohoHenkoEntityGenerator.DEFAULT_弁明書受付年月日);
            assertThat(sut.get弁明書受付年月日(), is(DbT4021ShiharaiHohoHenkoEntityGenerator.DEFAULT_弁明書受付年月日));
        }

        @Test
        public void 戻り値の弁明理由コードは_設定した値と同じ弁明理由コードを返す() {
            sut.set弁明理由コード(DbT4021ShiharaiHohoHenkoEntityGenerator.DEFAULT_弁明理由コード);
            assertThat(sut.get弁明理由コード(), is(DbT4021ShiharaiHohoHenkoEntityGenerator.DEFAULT_弁明理由コード));
        }

        @Test
        public void 戻り値の弁明審査決定年月日は_設定した値と同じ弁明審査決定年月日を返す() {
            sut.set弁明審査決定年月日(DbT4021ShiharaiHohoHenkoEntityGenerator.DEFAULT_弁明審査決定年月日);
            assertThat(sut.get弁明審査決定年月日(), is(DbT4021ShiharaiHohoHenkoEntityGenerator.DEFAULT_弁明審査決定年月日));
        }

        @Test
        public void 戻り値の弁明審査結果区分は_設定した値と同じ弁明審査結果区分を返す() {
            sut.set弁明審査結果区分(DbT4021ShiharaiHohoHenkoEntityGenerator.DEFAULT_弁明審査結果区分);
            assertThat(sut.get弁明審査結果区分(), is(DbT4021ShiharaiHohoHenkoEntityGenerator.DEFAULT_弁明審査結果区分));
        }

        @Test
        public void 戻り値の償還払化決定年月日は_設定した値と同じ償還払化決定年月日を返す() {
            sut.set償還払化決定年月日(DbT4021ShiharaiHohoHenkoEntityGenerator.DEFAULT_償還払化決定年月日);
            assertThat(sut.get償還払化決定年月日(), is(DbT4021ShiharaiHohoHenkoEntityGenerator.DEFAULT_償還払化決定年月日));
        }

        @Test
        public void 戻り値の償還払化通知書発行年月日は_設定した値と同じ償還払化通知書発行年月日を返す() {
            sut.set償還払化通知書発行年月日(DbT4021ShiharaiHohoHenkoEntityGenerator.DEFAULT_償還払化通知書発行年月日);
            assertThat(sut.get償還払化通知書発行年月日(), is(DbT4021ShiharaiHohoHenkoEntityGenerator.DEFAULT_償還払化通知書発行年月日));
        }

        @Test
        public void 戻り値の償還払化通知書再発行フラグは_設定した値と同じ償還払化通知書再発行フラグを返す() {
            sut.set償還払化通知書再発行フラグ(DbT4021ShiharaiHohoHenkoEntityGenerator.DEFAULT_償還払化通知書再発行フラグ);
            assertThat(sut.get償還払化通知書再発行フラグ(), is(DbT4021ShiharaiHohoHenkoEntityGenerator.DEFAULT_償還払化通知書再発行フラグ));
        }

        @Test
        public void 戻り値の被保険者証提出期限は_設定した値と同じ被保険者証提出期限を返す() {
            sut.set被保険者証提出期限(DbT4021ShiharaiHohoHenkoEntityGenerator.DEFAULT_被保険者証提出期限);
            assertThat(sut.get被保険者証提出期限(), is(DbT4021ShiharaiHohoHenkoEntityGenerator.DEFAULT_被保険者証提出期限));
        }

        @Test
        public void 戻り値の差止対象フラグは_設定した値と同じ差止対象フラグを返す() {
            sut.set差止対象フラグ(DbT4021ShiharaiHohoHenkoEntityGenerator.DEFAULT_差止対象フラグ);
            assertThat(sut.get差止対象フラグ(), is(DbT4021ShiharaiHohoHenkoEntityGenerator.DEFAULT_差止対象フラグ));
        }

        @Test
        public void 戻り値の差止対象決定年月日は_設定した値と同じ差止対象決定年月日を返す() {
            sut.set差止対象決定年月日(DbT4021ShiharaiHohoHenkoEntityGenerator.DEFAULT_差止対象決定年月日);
            assertThat(sut.get差止対象決定年月日(), is(DbT4021ShiharaiHohoHenkoEntityGenerator.DEFAULT_差止対象決定年月日));
        }

        @Test
        public void 戻り値の差止対象解除年月日は_設定した値と同じ差止対象解除年月日を返す() {
            sut.set差止対象解除年月日(DbT4021ShiharaiHohoHenkoEntityGenerator.DEFAULT_差止対象解除年月日);
            assertThat(sut.get差止対象解除年月日(), is(DbT4021ShiharaiHohoHenkoEntityGenerator.DEFAULT_差止対象解除年月日));
        }

        @Test
        public void 戻り値の減額決定年月日は_設定した値と同じ減額決定年月日を返す() {
            sut.set減額決定年月日(DbT4021ShiharaiHohoHenkoEntityGenerator.DEFAULT_減額決定年月日);
            assertThat(sut.get減額決定年月日(), is(DbT4021ShiharaiHohoHenkoEntityGenerator.DEFAULT_減額決定年月日));
        }

        @Test
        public void 戻り値の減額通知書発行年月日は_設定した値と同じ減額通知書発行年月日を返す() {
            sut.set減額通知書発行年月日(DbT4021ShiharaiHohoHenkoEntityGenerator.DEFAULT_減額通知書発行年月日);
            assertThat(sut.get減額通知書発行年月日(), is(DbT4021ShiharaiHohoHenkoEntityGenerator.DEFAULT_減額通知書発行年月日));
        }

        @Test
        public void 戻り値の減額通知書再発行フラグは_設定した値と同じ減額通知書再発行フラグを返す() {
            sut.set減額通知書再発行フラグ(DbT4021ShiharaiHohoHenkoEntityGenerator.DEFAULT_減額通知書再発行フラグ);
            assertThat(sut.get減額通知書再発行フラグ(), is(DbT4021ShiharaiHohoHenkoEntityGenerator.DEFAULT_減額通知書再発行フラグ));
        }

        @Test
        public void 戻り値の給付率は_設定した値と同じ給付率を返す() {
            sut.set給付率(DbT4021ShiharaiHohoHenkoEntityGenerator.DEFAULT_給付率);
            assertThat(sut.get給付率(), is(DbT4021ShiharaiHohoHenkoEntityGenerator.DEFAULT_給付率));
        }

        @Test
        public void 戻り値の終了申請書受付年月日は_設定した値と同じ終了申請書受付年月日を返す() {
            sut.set終了申請書受付年月日(DbT4021ShiharaiHohoHenkoEntityGenerator.DEFAULT_終了申請書受付年月日);
            assertThat(sut.get終了申請書受付年月日(), is(DbT4021ShiharaiHohoHenkoEntityGenerator.DEFAULT_終了申請書受付年月日));
        }

        @Test
        public void 戻り値の終了申請年月日は_設定した値と同じ終了申請年月日を返す() {
            sut.set終了申請年月日(DbT4021ShiharaiHohoHenkoEntityGenerator.DEFAULT_終了申請年月日);
            assertThat(sut.get終了申請年月日(), is(DbT4021ShiharaiHohoHenkoEntityGenerator.DEFAULT_終了申請年月日));
        }

        @Test
        public void 戻り値の終了申請理由コードは_設定した値と同じ終了申請理由コードを返す() {
            sut.set終了申請理由コード(DbT4021ShiharaiHohoHenkoEntityGenerator.DEFAULT_終了申請理由コード);
            assertThat(sut.get終了申請理由コード(), is(DbT4021ShiharaiHohoHenkoEntityGenerator.DEFAULT_終了申請理由コード));
        }

        @Test
        public void 戻り値の終了申請審査決定年月日は_設定した値と同じ終了申請審査決定年月日を返す() {
            sut.set終了申請審査決定年月日(DbT4021ShiharaiHohoHenkoEntityGenerator.DEFAULT_終了申請審査決定年月日);
            assertThat(sut.get終了申請審査決定年月日(), is(DbT4021ShiharaiHohoHenkoEntityGenerator.DEFAULT_終了申請審査決定年月日));
        }

        @Test
        public void 戻り値の終了申請審査結果区分は_設定した値と同じ終了申請審査結果区分を返す() {
            sut.set終了申請審査結果区分(DbT4021ShiharaiHohoHenkoEntityGenerator.DEFAULT_終了申請審査結果区分);
            assertThat(sut.get終了申請審査結果区分(), is(DbT4021ShiharaiHohoHenkoEntityGenerator.DEFAULT_終了申請審査結果区分));
        }

        @Test
        public void 戻り値の無効区分は_設定した値と同じ無効区分を返す() {
            sut.set無効区分(DbT4021ShiharaiHohoHenkoEntityGenerator.DEFAULT_無効区分);
            assertThat(sut.get無効区分(), is(DbT4021ShiharaiHohoHenkoEntityGenerator.DEFAULT_無効区分));
        }
    }

    public static class getStateTest extends DbzTestBase {

        @Test
        public void 状態Addedの取得確認() {
            ShiharaiHohoHenkoModel sut = new ShiharaiHohoHenkoModel();

            assertThat(sut.getState(), is(EntityDataState.Added));
        }

        @Test
        public void 状態Modifinedの取得確認() {
            ShiharaiHohoHenkoModel sut = new ShiharaiHohoHenkoModel();
            sut.setEntity(DbT4021ShiharaiHohoHenkoEntityGenerator.createDbT4021ShiharaiHohoHenkoEntity());

            sut.getEntity().initializeMd5();

            // 主キー以外の項目を変更してください
            sut.getEntity().setGemmen_TsuchiSaiHakkoFlag(false);

            assertThat(sut.getState(), is(EntityDataState.Modified));
        }

        @Test
        public void 状態Unchangedの取得確認() {
            ShiharaiHohoHenkoModel sut = new ShiharaiHohoHenkoModel();
            sut.setEntity(DbT4021ShiharaiHohoHenkoEntityGenerator.createDbT4021ShiharaiHohoHenkoEntity());

            sut.getEntity().initializeMd5();

            assertThat(sut.getState(), is(EntityDataState.Unchanged));
        }

        @Test
        public void 状態Deletedの取得確認() {
            ShiharaiHohoHenkoModel sut = new ShiharaiHohoHenkoModel();
            sut.setEntity(DbT4021ShiharaiHohoHenkoEntityGenerator.createDbT4021ShiharaiHohoHenkoEntity());

            sut.getEntity().initializeMd5();

            sut.setDeletedState(true);

            assertThat(sut.getState(), is(EntityDataState.Deleted));
        }
    }
}
