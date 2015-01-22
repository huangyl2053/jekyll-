/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.model;

import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT3096JutakuKaishuRiyushoTesuryoShukeiEntityGenerator;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link JutakuKaishuRiyushoTesuryoShukeiModel}のテストクラスです。
 *
 * @author LDNS 宋昕沢
 */
@RunWith(Enclosed.class)
public class JutakuKaishuRiyushoTesuryoShukeiModelTest extends DbzTestBase {

    public static class getterSetterTest extends DbzTestBase {

        private static JutakuKaishuRiyushoTesuryoShukeiModel sut;

        @BeforeClass
        public static void test() {
            sut = new JutakuKaishuRiyushoTesuryoShukeiModel();
        }

        @Test
        public void 戻り値の証記載保険者番号は_設定した値と同じ証記載保険者番号を返す() {
            sut.set証記載保険者番号(DbT3096JutakuKaishuRiyushoTesuryoShukeiEntityGenerator.DEFAULT_証記載保険者番号);
            assertThat(sut.get証記載保険者番号(), is(DbT3096JutakuKaishuRiyushoTesuryoShukeiEntityGenerator.DEFAULT_証記載保険者番号));
        }

        @Test
        public void 戻り値の集計開始年月は_設定した値と同じ集計開始年月を返す() {
            sut.set集計開始年月(DbT3096JutakuKaishuRiyushoTesuryoShukeiEntityGenerator.DEFAULT_集計開始年月);
            assertThat(sut.get集計開始年月(), is(DbT3096JutakuKaishuRiyushoTesuryoShukeiEntityGenerator.DEFAULT_集計開始年月));
        }

        @Test
        public void 戻り値の処理日時は_設定した値と同じ処理日時を返す() {
            sut.set処理日時(DbT3096JutakuKaishuRiyushoTesuryoShukeiEntityGenerator.DEFAULT_処理日時);
            assertThat(sut.get処理日時(), is(DbT3096JutakuKaishuRiyushoTesuryoShukeiEntityGenerator.DEFAULT_処理日時));
        }

        @Test
        public void 戻り値の集計終了年月は_設定した値と同じ集計終了年月を返す() {
            sut.set集計終了年月(DbT3096JutakuKaishuRiyushoTesuryoShukeiEntityGenerator.DEFAULT_集計終了年月);
            assertThat(sut.get集計終了年月(), is(DbT3096JutakuKaishuRiyushoTesuryoShukeiEntityGenerator.DEFAULT_集計終了年月));
        }

        @Test
        public void 戻り値の介護住宅改修理由書作成事業者番号は_設定した値と同じ介護住宅改修理由書作成事業者番号を返す() {
            sut.set介護住宅改修理由書作成事業者番号(DbT3096JutakuKaishuRiyushoTesuryoShukeiEntityGenerator.DEFAULT_介護住宅改修理由書作成事業者番号);
            assertThat(sut.get介護住宅改修理由書作成事業者番号(), is(DbT3096JutakuKaishuRiyushoTesuryoShukeiEntityGenerator.DEFAULT_介護住宅改修理由書作成事業者番号));
        }

        @Test
        public void 戻り値の介護住宅改修理由書作成件数は_設定した値と同じ介護住宅改修理由書作成件数を返す() {
            sut.set介護住宅改修理由書作成件数(DbT3096JutakuKaishuRiyushoTesuryoShukeiEntityGenerator.DEFAULT_介護住宅改修理由書作成件数);
            assertThat(sut.get介護住宅改修理由書作成件数(), is(DbT3096JutakuKaishuRiyushoTesuryoShukeiEntityGenerator.DEFAULT_介護住宅改修理由書作成件数));
        }

        @Test
        public void 戻り値の介護住宅改修理由書作成単価は_設定した値と同じ介護住宅改修理由書作成単価を返す() {
            sut.set介護住宅改修理由書作成単価(DbT3096JutakuKaishuRiyushoTesuryoShukeiEntityGenerator.DEFAULT_介護住宅改修理由書作成単価);
            assertThat(sut.get介護住宅改修理由書作成単価(), is(DbT3096JutakuKaishuRiyushoTesuryoShukeiEntityGenerator.DEFAULT_介護住宅改修理由書作成単価));
        }

        @Test
        public void 戻り値の介護住宅改修理由書作成請求金額は_設定した値と同じ介護住宅改修理由書作成請求金額を返す() {
            sut.set介護住宅改修理由書作成請求金額(DbT3096JutakuKaishuRiyushoTesuryoShukeiEntityGenerator.DEFAULT_介護住宅改修理由書作成請求金額);
            assertThat(sut.get介護住宅改修理由書作成請求金額(), is(DbT3096JutakuKaishuRiyushoTesuryoShukeiEntityGenerator.DEFAULT_介護住宅改修理由書作成請求金額));
        }

        @Test
        public void 戻り値の介護住宅改修理由書作成申請年月日は_設定した値と同じ介護住宅改修理由書作成申請年月日を返す() {
            sut.set介護住宅改修理由書作成申請年月日(DbT3096JutakuKaishuRiyushoTesuryoShukeiEntityGenerator.DEFAULT_介護住宅改修理由書作成申請年月日);
            assertThat(sut.get介護住宅改修理由書作成申請年月日(), is(DbT3096JutakuKaishuRiyushoTesuryoShukeiEntityGenerator.DEFAULT_介護住宅改修理由書作成申請年月日));
        }

        @Test
        public void 戻り値の介護住宅改修理由書作成受付年月日は_設定した値と同じ介護住宅改修理由書作成受付年月日を返す() {
            sut.set介護住宅改修理由書作成受付年月日(DbT3096JutakuKaishuRiyushoTesuryoShukeiEntityGenerator.DEFAULT_介護住宅改修理由書作成受付年月日);
            assertThat(sut.get介護住宅改修理由書作成受付年月日(), is(DbT3096JutakuKaishuRiyushoTesuryoShukeiEntityGenerator.DEFAULT_介護住宅改修理由書作成受付年月日));
        }

        @Test
        public void 戻り値の介護支払方法区分は_設定した値と同じ介護支払方法区分を返す() {
            sut.set介護支払方法区分(DbT3096JutakuKaishuRiyushoTesuryoShukeiEntityGenerator.DEFAULT_介護支払方法区分);
            assertThat(sut.get介護支払方法区分(), is(DbT3096JutakuKaishuRiyushoTesuryoShukeiEntityGenerator.DEFAULT_介護支払方法区分));
        }

        @Test
        public void 戻り値の識別コードは_設定した値と同じ識別コードを返す() {
            sut.set識別コード(DbT3096JutakuKaishuRiyushoTesuryoShukeiEntityGenerator.DEFAULT_識別コード);
            assertThat(sut.get識別コード(), is(DbT3096JutakuKaishuRiyushoTesuryoShukeiEntityGenerator.DEFAULT_識別コード));
        }
    }

    public static class getStateTest extends DbzTestBase {

        @Test
        public void 状態Addedの取得確認() {
            JutakuKaishuRiyushoTesuryoShukeiModel sut = new JutakuKaishuRiyushoTesuryoShukeiModel();

            assertThat(sut.getState(), is(EntityDataState.Added));
        }

        @Test
        public void 状態Modifinedの取得確認() {
            JutakuKaishuRiyushoTesuryoShukeiModel sut = new JutakuKaishuRiyushoTesuryoShukeiModel();
            sut.setEntity(DbT3096JutakuKaishuRiyushoTesuryoShukeiEntityGenerator.createDbT3096JutakuKaishuRiyushoTesuryoShukeiEntity());

            sut.getEntity().initializeMd5();

            //TODO  主キー以外の項目を変更してください
//            sut.getEntity().setXXX(new XXX());
//            assertThat(sut.getState(), is(EntityDataState.Modified));
        }

        @Test
        public void 状態Unchangedの取得確認() {
            JutakuKaishuRiyushoTesuryoShukeiModel sut = new JutakuKaishuRiyushoTesuryoShukeiModel();
            sut.setEntity(DbT3096JutakuKaishuRiyushoTesuryoShukeiEntityGenerator.createDbT3096JutakuKaishuRiyushoTesuryoShukeiEntity());

            sut.getEntity().initializeMd5();

            assertThat(sut.getState(), is(EntityDataState.Unchanged));
        }

        @Test
        public void 状態Deletedの取得確認() {
            JutakuKaishuRiyushoTesuryoShukeiModel sut = new JutakuKaishuRiyushoTesuryoShukeiModel();
            sut.setEntity(DbT3096JutakuKaishuRiyushoTesuryoShukeiEntityGenerator.createDbT3096JutakuKaishuRiyushoTesuryoShukeiEntity());

            sut.getEntity().initializeMd5();

            sut.setDeletedState(true);

            assertThat(sut.getState(), is(EntityDataState.Deleted));
        }
    }
}
