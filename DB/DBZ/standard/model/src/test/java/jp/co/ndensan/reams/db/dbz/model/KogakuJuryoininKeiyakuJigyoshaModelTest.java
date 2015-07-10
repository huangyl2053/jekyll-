/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.model;

import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT3076KogakuJuryoininKeiyakuJigyoshaEntityGenerator;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link KogakuJuryoininKeiyakuJigyoshaModel}のテストクラスです。
 *
 * @author LDNS 周杏月
 */
@RunWith(Enclosed.class)
public class KogakuJuryoininKeiyakuJigyoshaModelTest extends DbzTestBase {

    public static class getterSetterTest extends DbzTestBase {

        private static KogakuJuryoininKeiyakuJigyoshaModel sut;

        @BeforeClass
        public static void test() {
            sut = new KogakuJuryoininKeiyakuJigyoshaModel();
        }

        @Test
        public void 戻り値の被保険者番号は_設定した値と同じ被保険者番号を返す() {
            sut.set被保険者番号(DbT3076KogakuJuryoininKeiyakuJigyoshaEntityGenerator.DEFAULT_被保険者番号);
            assertThat(sut.get被保険者番号(), is(DbT3076KogakuJuryoininKeiyakuJigyoshaEntityGenerator.DEFAULT_被保険者番号));
        }

        @Test
        public void 戻り値の識別コードは_設定した値と同じ識別コードを返す() {
            sut.set識別コード(DbT3076KogakuJuryoininKeiyakuJigyoshaEntityGenerator.DEFAULT_識別コード);
            assertThat(sut.get識別コード(), is(DbT3076KogakuJuryoininKeiyakuJigyoshaEntityGenerator.DEFAULT_識別コード));
        }

        @Test
        public void 戻り値の証記載保険者番号は_設定した値と同じ証記載保険者番号を返す() {
            sut.set証記載保険者番号(DbT3076KogakuJuryoininKeiyakuJigyoshaEntityGenerator.DEFAULT_証記載保険者番号);
            assertThat(sut.get証記載保険者番号(), is(DbT3076KogakuJuryoininKeiyakuJigyoshaEntityGenerator.DEFAULT_証記載保険者番号));
        }

        @Test
        public void 戻り値の受付年月日は_設定した値と同じ受付年月日を返す() {
            sut.set受付年月日(DbT3076KogakuJuryoininKeiyakuJigyoshaEntityGenerator.DEFAULT_受付年月日);
            assertThat(sut.get受付年月日(), is(DbT3076KogakuJuryoininKeiyakuJigyoshaEntityGenerator.DEFAULT_受付年月日));
        }

        @Test
        public void 戻り値の処理日時は_設定した値と同じ処理日時を返す() {
            sut.set処理日時(DbT3076KogakuJuryoininKeiyakuJigyoshaEntityGenerator.DEFAULT_処理日時);
            assertThat(sut.get処理日時(), is(DbT3076KogakuJuryoininKeiyakuJigyoshaEntityGenerator.DEFAULT_処理日時));
        }

        @Test
        public void 戻り値の申請年月日は_設定した値と同じ申請年月日を返す() {
            sut.set申請年月日(DbT3076KogakuJuryoininKeiyakuJigyoshaEntityGenerator.DEFAULT_申請年月日);
            assertThat(sut.get申請年月日(), is(DbT3076KogakuJuryoininKeiyakuJigyoshaEntityGenerator.DEFAULT_申請年月日));
        }

        @Test
        public void 戻り値の事業者番号は_設定した値と同じ事業者番号を返す() {
            sut.set事業者番号(DbT3076KogakuJuryoininKeiyakuJigyoshaEntityGenerator.DEFAULT_事業者番号);
            assertThat(sut.get事業者番号(), is(DbT3076KogakuJuryoininKeiyakuJigyoshaEntityGenerator.DEFAULT_事業者番号));
        }

        @Test
        public void 戻り値の決定年月日は_設定した値と同じ決定年月日を返す() {
            sut.set決定年月日(DbT3076KogakuJuryoininKeiyakuJigyoshaEntityGenerator.DEFAULT_決定年月日);
            assertThat(sut.get決定年月日(), is(DbT3076KogakuJuryoininKeiyakuJigyoshaEntityGenerator.DEFAULT_決定年月日));
        }

        @Test
        public void 戻り値の承認結果区分は_設定した値と同じ承認結果区分を返す() {
            sut.set承認結果区分(DbT3076KogakuJuryoininKeiyakuJigyoshaEntityGenerator.DEFAULT_承認結果区分);
            assertThat(sut.get承認結果区分(), is(DbT3076KogakuJuryoininKeiyakuJigyoshaEntityGenerator.DEFAULT_承認結果区分));
        }

        @Test
        public void 戻り値の受領委任払適用開始年月日は_設定した値と同じ受領委任払適用開始年月日を返す() {
            sut.set受領委任払適用開始年月日(DbT3076KogakuJuryoininKeiyakuJigyoshaEntityGenerator.DEFAULT_受領委任払適用開始年月日);
            assertThat(sut.get受領委任払適用開始年月日(), is(DbT3076KogakuJuryoininKeiyakuJigyoshaEntityGenerator.DEFAULT_受領委任払適用開始年月日));
        }

        @Test
        public void 戻り値の受領委任払適用終了年月日は_設定した値と同じ受領委任払適用終了年月日を返す() {
            sut.set受領委任払適用終了年月日(DbT3076KogakuJuryoininKeiyakuJigyoshaEntityGenerator.DEFAULT_受領委任払適用終了年月日);
            assertThat(sut.get受領委任払適用終了年月日(), is(DbT3076KogakuJuryoininKeiyakuJigyoshaEntityGenerator.DEFAULT_受領委任払適用終了年月日));
        }

        @Test
        public void 戻り値の契約番号は_設定した値と同じ契約番号を返す() {
            sut.set契約番号(DbT3076KogakuJuryoininKeiyakuJigyoshaEntityGenerator.DEFAULT_契約番号);
            assertThat(sut.get契約番号(), is(DbT3076KogakuJuryoininKeiyakuJigyoshaEntityGenerator.DEFAULT_契約番号));
        }

        @Test
        public void 戻り値の不承認理由は_設定した値と同じ不承認理由を返す() {
            sut.set不承認理由(DbT3076KogakuJuryoininKeiyakuJigyoshaEntityGenerator.DEFAULT_不承認理由);
            assertThat(sut.get不承認理由(), is(DbT3076KogakuJuryoininKeiyakuJigyoshaEntityGenerator.DEFAULT_不承認理由));
        }

        @Test
        public void 戻り値の利用者負担上限額は_設定した値と同じ利用者負担上限額を返す() {
            sut.set利用者負担上限額(DbT3076KogakuJuryoininKeiyakuJigyoshaEntityGenerator.DEFAULT_利用者負担上限額);
            assertThat(sut.get利用者負担上限額(), is(DbT3076KogakuJuryoininKeiyakuJigyoshaEntityGenerator.DEFAULT_利用者負担上限額));
        }

        @Test
        public void 戻り値の承認結果通知書作成日は_設定した値と同じ承認結果通知書作成日を返す() {
            sut.set承認結果通知書作成日(DbT3076KogakuJuryoininKeiyakuJigyoshaEntityGenerator.DEFAULT_承認結果通知書作成日);
            assertThat(sut.get承認結果通知書作成日(), is(DbT3076KogakuJuryoininKeiyakuJigyoshaEntityGenerator.DEFAULT_承認結果通知書作成日));
        }

        @Test
        public void 戻り値の承認結果通知書再発行区分は_設定した値と同じ承認結果通知書再発行区分を返す() {
            sut.set承認結果通知書再発行区分(DbT3076KogakuJuryoininKeiyakuJigyoshaEntityGenerator.DEFAULT_承認結果通知書再発行区分);
            assertThat(sut.get承認結果通知書再発行区分(), is(DbT3076KogakuJuryoininKeiyakuJigyoshaEntityGenerator.DEFAULT_承認結果通知書再発行区分));
        }
    }

    public static class getStateTest extends DbzTestBase {

        @Test
        public void 状態Addedの取得確認() {
            KogakuJuryoininKeiyakuJigyoshaModel sut = new KogakuJuryoininKeiyakuJigyoshaModel();

            assertThat(sut.getState(), is(EntityDataState.Added));
        }

       // @Test
        // public void 状態Modifinedの取得確認() {
        // KogakuJuryoininKeiyakuJigyoshaModel sut = new KogakuJuryoininKeiyakuJigyoshaModel();
        //sut.setEntity(DbT3076KogakuJuryoininKeiyakuJigyoshaEntityGenerator.createDbT3076KogakuJuryoininKeiyakuJigyoshaEntity());
           // sut.getEntity().initializeMd5();
            // TODO主キー以外の項目を変更してください
        //sut.getEntity().setXXX(new XXX());
            //assertThat(sut.getState(), is(EntityDataState.Modified));
        //}
        @Test
        public void 状態Unchangedの取得確認() {
            KogakuJuryoininKeiyakuJigyoshaModel sut = new KogakuJuryoininKeiyakuJigyoshaModel();
            sut.setEntity(DbT3076KogakuJuryoininKeiyakuJigyoshaEntityGenerator.createDbT3076KogakuJuryoininKeiyakuJigyoshaEntity());

            sut.getEntity().initializeMd5();

            assertThat(sut.getState(), is(EntityDataState.Unchanged));
        }

        @Test
        public void 状態Deletedの取得確認() {
            KogakuJuryoininKeiyakuJigyoshaModel sut = new KogakuJuryoininKeiyakuJigyoshaModel();
            sut.setEntity(DbT3076KogakuJuryoininKeiyakuJigyoshaEntityGenerator.createDbT3076KogakuJuryoininKeiyakuJigyoshaEntity());

            sut.getEntity().initializeMd5();

            sut.setDeletedState(true);

            assertThat(sut.getState(), is(EntityDataState.Deleted));
        }
    }
}
