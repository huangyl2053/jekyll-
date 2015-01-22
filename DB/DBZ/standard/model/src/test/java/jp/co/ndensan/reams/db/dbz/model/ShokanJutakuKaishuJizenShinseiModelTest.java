/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.model;

import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT3035ShokanJutakuKaishuJizenShinseiEntityGenerator;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link ShokanJutakuKaishuJizenShinseiModel}のテストクラスです。
 *
 * @author LDNS 周杏月
 */
@RunWith(Enclosed.class)
public class ShokanJutakuKaishuJizenShinseiModelTest extends DbzTestBase {

    public static class getterSetterTest extends DbzTestBase {

        private static ShokanJutakuKaishuJizenShinseiModel sut;

        @BeforeClass
        public static void test() {
            sut = new ShokanJutakuKaishuJizenShinseiModel();
        }

        @Test
        public void 戻り値の被保険者番号は_設定した値と同じ被保険者番号を返す() {
            sut.set被保険者番号(DbT3035ShokanJutakuKaishuJizenShinseiEntityGenerator.DEFAULT_被保険者番号);
            assertThat(sut.get被保険者番号(), is(DbT3035ShokanJutakuKaishuJizenShinseiEntityGenerator.DEFAULT_被保険者番号));
        }

        @Test
        public void 戻り値のサービス提供年月は_設定した値と同じサービス提供年月を返す() {
            sut.setサービス提供年月(DbT3035ShokanJutakuKaishuJizenShinseiEntityGenerator.DEFAULT_サービス提供年月);
            assertThat(sut.getサービス提供年月(), is(DbT3035ShokanJutakuKaishuJizenShinseiEntityGenerator.DEFAULT_サービス提供年月));
        }

        @Test
        public void 戻り値の整理番号は_設定した値と同じ整理番号を返す() {
            sut.set整理番号(DbT3035ShokanJutakuKaishuJizenShinseiEntityGenerator.DEFAULT_整理番号);
            assertThat(sut.get整理番号(), is(DbT3035ShokanJutakuKaishuJizenShinseiEntityGenerator.DEFAULT_整理番号));
        }

        @Test
        public void 戻り値の処理日時は_設定した値と同じ処理日時を返す() {
            sut.set処理日時(DbT3035ShokanJutakuKaishuJizenShinseiEntityGenerator.DEFAULT_処理日時);
            assertThat(sut.get処理日時(), is(DbT3035ShokanJutakuKaishuJizenShinseiEntityGenerator.DEFAULT_処理日時));
        }

        @Test
        public void 戻り値の証記載保険者番号は_設定した値と同じ証記載保険者番号を返す() {
            sut.set証記載保険者番号(DbT3035ShokanJutakuKaishuJizenShinseiEntityGenerator.DEFAULT_証記載保険者番号);
            assertThat(sut.get証記載保険者番号(), is(DbT3035ShokanJutakuKaishuJizenShinseiEntityGenerator.DEFAULT_証記載保険者番号));
        }

        @Test
        public void 戻り値の受付年月日は_設定した値と同じ受付年月日を返す() {
            sut.set受付年月日(DbT3035ShokanJutakuKaishuJizenShinseiEntityGenerator.DEFAULT_受付年月日);
            assertThat(sut.get受付年月日(), is(DbT3035ShokanJutakuKaishuJizenShinseiEntityGenerator.DEFAULT_受付年月日));
        }

        @Test
        public void 戻り値の申請年月日は_設定した値と同じ申請年月日を返す() {
            sut.set申請年月日(DbT3035ShokanJutakuKaishuJizenShinseiEntityGenerator.DEFAULT_申請年月日);
            assertThat(sut.get申請年月日(), is(DbT3035ShokanJutakuKaishuJizenShinseiEntityGenerator.DEFAULT_申請年月日));
        }

        @Test
        public void 戻り値の事業者番号は_設定した値と同じ事業者番号を返す() {
            sut.set事業者番号(DbT3035ShokanJutakuKaishuJizenShinseiEntityGenerator.DEFAULT_事業者番号);
            assertThat(sut.get事業者番号(), is(DbT3035ShokanJutakuKaishuJizenShinseiEntityGenerator.DEFAULT_事業者番号));
        }

        @Test
        public void 戻り値の事業者名称は_設定した値と同じ事業者名称を返す() {
            sut.set事業者名称(DbT3035ShokanJutakuKaishuJizenShinseiEntityGenerator.DEFAULT_事業者名称);
            assertThat(sut.get事業者名称(), is(DbT3035ShokanJutakuKaishuJizenShinseiEntityGenerator.DEFAULT_事業者名称));
        }

        @Test
        public void 戻り値の事業者名称カナは_設定した値と同じ事業者名称カナを返す() {
            sut.set事業者名称カナ(DbT3035ShokanJutakuKaishuJizenShinseiEntityGenerator.DEFAULT_事業者名称カナ);
            assertThat(sut.get事業者名称カナ(), is(DbT3035ShokanJutakuKaishuJizenShinseiEntityGenerator.DEFAULT_事業者名称カナ));
        }

        @Test
        public void 戻り値の事業者郵便番号は_設定した値と同じ事業者郵便番号を返す() {
            sut.set事業者郵便番号(DbT3035ShokanJutakuKaishuJizenShinseiEntityGenerator.DEFAULT_事業者郵便番号);
            assertThat(sut.get事業者郵便番号(), is(DbT3035ShokanJutakuKaishuJizenShinseiEntityGenerator.DEFAULT_事業者郵便番号));
        }

        @Test
        public void 戻り値の事業者住所は_設定した値と同じ事業者住所を返す() {
            sut.set事業者住所(DbT3035ShokanJutakuKaishuJizenShinseiEntityGenerator.DEFAULT_事業者住所);
            assertThat(sut.get事業者住所(), is(DbT3035ShokanJutakuKaishuJizenShinseiEntityGenerator.DEFAULT_事業者住所));
        }

        @Test
        public void 戻り値の事業者電話番号は_設定した値と同じ事業者電話番号を返す() {
            sut.set事業者電話番号(DbT3035ShokanJutakuKaishuJizenShinseiEntityGenerator.DEFAULT_事業者電話番号);
            assertThat(sut.get事業者電話番号(), is(DbT3035ShokanJutakuKaishuJizenShinseiEntityGenerator.DEFAULT_事業者電話番号));
        }

        @Test
        public void 戻り値の事業者ＦＡＸ番号は_設定した値と同じ事業者ＦＡＸ番号を返す() {
            sut.set事業者ＦＡＸ番号(DbT3035ShokanJutakuKaishuJizenShinseiEntityGenerator.DEFAULT_事業者ＦＡＸ番号);
            assertThat(sut.get事業者ＦＡＸ番号(), is(DbT3035ShokanJutakuKaishuJizenShinseiEntityGenerator.DEFAULT_事業者ＦＡＸ番号));
        }

        @Test
        public void 戻り値の理由書作成者は_設定した値と同じ理由書作成者を返す() {
            sut.set理由書作成者(DbT3035ShokanJutakuKaishuJizenShinseiEntityGenerator.DEFAULT_理由書作成者);
            assertThat(sut.get理由書作成者(), is(DbT3035ShokanJutakuKaishuJizenShinseiEntityGenerator.DEFAULT_理由書作成者));
        }

        @Test
        public void 戻り値の理由書作成者カナは_設定した値と同じ理由書作成者カナを返す() {
            sut.set理由書作成者カナ(DbT3035ShokanJutakuKaishuJizenShinseiEntityGenerator.DEFAULT_理由書作成者カナ);
            assertThat(sut.get理由書作成者カナ(), is(DbT3035ShokanJutakuKaishuJizenShinseiEntityGenerator.DEFAULT_理由書作成者カナ));
        }

        @Test
        public void 戻り値のサービス種類コードは_設定した値と同じサービス種類コードを返す() {
            sut.setサービス種類コード(DbT3035ShokanJutakuKaishuJizenShinseiEntityGenerator.DEFAULT_サービス種類コード);
            assertThat(sut.getサービス種類コード(), is(DbT3035ShokanJutakuKaishuJizenShinseiEntityGenerator.DEFAULT_サービス種類コード));
        }

        @Test
        public void 戻り値の契約決定年月日は_設定した値と同じ契約決定年月日を返す() {
            sut.set契約決定年月日(DbT3035ShokanJutakuKaishuJizenShinseiEntityGenerator.DEFAULT_契約決定年月日);
            assertThat(sut.get契約決定年月日(), is(DbT3035ShokanJutakuKaishuJizenShinseiEntityGenerator.DEFAULT_契約決定年月日));
        }

        @Test
        public void 戻り値の承認区分は_設定した値と同じ承認区分を返す() {
            sut.set承認区分(DbT3035ShokanJutakuKaishuJizenShinseiEntityGenerator.DEFAULT_承認区分);
            assertThat(sut.get承認区分(), is(DbT3035ShokanJutakuKaishuJizenShinseiEntityGenerator.DEFAULT_承認区分));
        }

        @Test
        public void 戻り値の不承認の理由は_設定した値と同じ不承認の理由を返す() {
            sut.set不承認の理由(DbT3035ShokanJutakuKaishuJizenShinseiEntityGenerator.DEFAULT_不承認の理由);
            assertThat(sut.get不承認の理由(), is(DbT3035ShokanJutakuKaishuJizenShinseiEntityGenerator.DEFAULT_不承認の理由));
        }

        @Test
        public void 戻り値の給付額等_費用額合計は_設定した値と同じ給付額等_費用額合計を返す() {
            sut.set給付額等_費用額合計(DbT3035ShokanJutakuKaishuJizenShinseiEntityGenerator.DEFAULT_給付額等_費用額合計);
            assertThat(sut.get給付額等_費用額合計(), is(DbT3035ShokanJutakuKaishuJizenShinseiEntityGenerator.DEFAULT_給付額等_費用額合計));
        }

        @Test
        public void 戻り値の給付額等_保険対象費用額は_設定した値と同じ給付額等_保険対象費用額を返す() {
            sut.set給付額等_保険対象費用額(DbT3035ShokanJutakuKaishuJizenShinseiEntityGenerator.DEFAULT_給付額等_保険対象費用額);
            assertThat(sut.get給付額等_保険対象費用額(), is(DbT3035ShokanJutakuKaishuJizenShinseiEntityGenerator.DEFAULT_給付額等_保険対象費用額));
        }

        @Test
        public void 戻り値の給付額等_利用者自己負担額は_設定した値と同じ給付額等_利用者自己負担額を返す() {
            sut.set給付額等_利用者自己負担額(DbT3035ShokanJutakuKaishuJizenShinseiEntityGenerator.DEFAULT_給付額等_利用者自己負担額);
            assertThat(sut.get給付額等_利用者自己負担額(), is(DbT3035ShokanJutakuKaishuJizenShinseiEntityGenerator.DEFAULT_給付額等_利用者自己負担額));
        }

        @Test
        public void 戻り値の給付額等_保険給付費額は_設定した値と同じ給付額等_保険給付費額を返す() {
            sut.set給付額等_保険給付費額(DbT3035ShokanJutakuKaishuJizenShinseiEntityGenerator.DEFAULT_給付額等_保険給付費額);
            assertThat(sut.get給付額等_保険給付費額(), is(DbT3035ShokanJutakuKaishuJizenShinseiEntityGenerator.DEFAULT_給付額等_保険給付費額));
        }

        @Test
        public void 戻り値の施工完了予定年月日は_設定した値と同じ施工完了予定年月日を返す() {
            sut.set施工完了予定年月日(DbT3035ShokanJutakuKaishuJizenShinseiEntityGenerator.DEFAULT_施工完了予定年月日);
            assertThat(sut.get施工完了予定年月日(), is(DbT3035ShokanJutakuKaishuJizenShinseiEntityGenerator.DEFAULT_施工完了予定年月日));
        }

        @Test
        public void 戻り値の申請取消事由コードは_設定した値と同じ申請取消事由コードを返す() {
            sut.set申請取消事由コード(DbT3035ShokanJutakuKaishuJizenShinseiEntityGenerator.DEFAULT_申請取消事由コード);
            assertThat(sut.get申請取消事由コード(), is(DbT3035ShokanJutakuKaishuJizenShinseiEntityGenerator.DEFAULT_申請取消事由コード));
        }

        @Test
        public void 戻り値の備考は_設定した値と同じ備考を返す() {
            sut.set備考(DbT3035ShokanJutakuKaishuJizenShinseiEntityGenerator.DEFAULT_備考);
            assertThat(sut.get備考(), is(DbT3035ShokanJutakuKaishuJizenShinseiEntityGenerator.DEFAULT_備考));
        }
    }

    public static class getStateTest extends DbzTestBase {

        @Test
        public void 状態Addedの取得確認() {
            ShokanJutakuKaishuJizenShinseiModel sut = new ShokanJutakuKaishuJizenShinseiModel();

            assertThat(sut.getState(), is(EntityDataState.Added));
        }

       // @Test
        // public void 状態Modifinedの取得確認() {
        // ShokanJutakuKaishuJizenShinseiModel sut = new ShokanJutakuKaishuJizenShinseiModel();
        //sut.setEntity(DbT3035ShokanJutakuKaishuJizenShinseiEntityGenerator.createDbT3035ShokanJutakuKaishuJizenShinseiEntity());
           // sut.getEntity().initializeMd5();
            // TODO主キー以外の項目を変更してください
        //sut.getEntity().setXXX(new XXX());
            //assertThat(sut.getState(), is(EntityDataState.Modified));
        //}
        @Test
        public void 状態Unchangedの取得確認() {
            ShokanJutakuKaishuJizenShinseiModel sut = new ShokanJutakuKaishuJizenShinseiModel();
            sut.setEntity(DbT3035ShokanJutakuKaishuJizenShinseiEntityGenerator.createDbT3035ShokanJutakuKaishuJizenShinseiEntity());

            sut.getEntity().initializeMd5();

            assertThat(sut.getState(), is(EntityDataState.Unchanged));
        }

        @Test
        public void 状態Deletedの取得確認() {
            ShokanJutakuKaishuJizenShinseiModel sut = new ShokanJutakuKaishuJizenShinseiModel();
            sut.setEntity(DbT3035ShokanJutakuKaishuJizenShinseiEntityGenerator.createDbT3035ShokanJutakuKaishuJizenShinseiEntity());

            sut.getEntity().initializeMd5();

            sut.setDeletedState(true);

            assertThat(sut.getState(), is(EntityDataState.Deleted));
        }
    }
}
