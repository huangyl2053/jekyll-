/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.model;

import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT3003KyodoShoriyoJukyushaIdoShokanSofuEntityGenerator;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link KyodoShoriyoJukyushaIdoShokanSofuModel}のテストクラスです。
 *
 * @author LDNS 鄭雪双
 */
@RunWith(Enclosed.class)
public class KyodoShoriyoJukyushaIdoShokanSofuModelTest extends DbzTestBase {

    public static class getterSetterTest extends DbzTestBase {

        private static KyodoShoriyoJukyushaIdoShokanSofuModel sut;

        @BeforeClass
        public static void test() {
            sut = new KyodoShoriyoJukyushaIdoShokanSofuModel();
        }

        @Test
        public void 戻り値の異動年月日は_設定した値と同じ異動年月日を返す() {
            sut.set異動年月日(DbT3003KyodoShoriyoJukyushaIdoShokanSofuEntityGenerator.DEFAULT_異動年月日);
            assertThat(sut.get異動年月日(), is(DbT3003KyodoShoriyoJukyushaIdoShokanSofuEntityGenerator.DEFAULT_異動年月日));
        }

        @Test
        public void 戻り値の異動区分コードは_設定した値と同じ異動区分コードを返す() {
            sut.set異動区分コード(DbT3003KyodoShoriyoJukyushaIdoShokanSofuEntityGenerator.DEFAULT_異動区分コード);
            assertThat(sut.get異動区分コード(), is(DbT3003KyodoShoriyoJukyushaIdoShokanSofuEntityGenerator.DEFAULT_異動区分コード));
        }

        @Test
        public void 戻り値の受給者異動事由は_設定した値と同じ受給者異動事由を返す() {
            sut.set受給者異動事由(DbT3003KyodoShoriyoJukyushaIdoShokanSofuEntityGenerator.DEFAULT_受給者異動事由);
            assertThat(sut.get受給者異動事由(), is(DbT3003KyodoShoriyoJukyushaIdoShokanSofuEntityGenerator.DEFAULT_受給者異動事由));
        }

        @Test
        public void 戻り値の証記載保険者番号は_設定した値と同じ証記載保険者番号を返す() {
            sut.set証記載保険者番号(DbT3003KyodoShoriyoJukyushaIdoShokanSofuEntityGenerator.DEFAULT_証記載保険者番号);
            assertThat(sut.get証記載保険者番号(), is(DbT3003KyodoShoriyoJukyushaIdoShokanSofuEntityGenerator.DEFAULT_証記載保険者番号));
        }

        @Test
        public void 戻り値の被保険者番号は_設定した値と同じ被保険者番号を返す() {
            sut.set被保険者番号(DbT3003KyodoShoriyoJukyushaIdoShokanSofuEntityGenerator.DEFAULT_被保険者番号);
            assertThat(sut.get被保険者番号(), is(DbT3003KyodoShoriyoJukyushaIdoShokanSofuEntityGenerator.DEFAULT_被保険者番号));
        }

        @Test
        public void 戻り値の処理日時は_設定した値と同じ処理日時を返す() {
            sut.set処理日時(DbT3003KyodoShoriyoJukyushaIdoShokanSofuEntityGenerator.DEFAULT_処理日時);
            assertThat(sut.get処理日時(), is(DbT3003KyodoShoriyoJukyushaIdoShokanSofuEntityGenerator.DEFAULT_処理日時));
        }

        @Test
        public void 戻り値の保険給付支払一時差止開始年月日は_設定した値と同じ保険給付支払一時差止開始年月日を返す() {
            sut.set保険給付支払一時差止開始年月日(DbT3003KyodoShoriyoJukyushaIdoShokanSofuEntityGenerator.DEFAULT_保険給付支払一時差止開始年月日);
            assertThat(sut.get保険給付支払一時差止開始年月日(), is(DbT3003KyodoShoriyoJukyushaIdoShokanSofuEntityGenerator.DEFAULT_保険給付支払一時差止開始年月日));
        }

        @Test
        public void 戻り値の保険給付支払一時差止終了年月日は_設定した値と同じ保険給付支払一時差止終了年月日を返す() {
            sut.set保険給付支払一時差止終了年月日(DbT3003KyodoShoriyoJukyushaIdoShokanSofuEntityGenerator.DEFAULT_保険給付支払一時差止終了年月日);
            assertThat(sut.get保険給付支払一時差止終了年月日(), is(DbT3003KyodoShoriyoJukyushaIdoShokanSofuEntityGenerator.DEFAULT_保険給付支払一時差止終了年月日));
        }

        @Test
        public void 戻り値の保険給付支払一時差止区分コードは_設定した値と同じ保険給付支払一時差止区分コードを返す() {
            sut.set保険給付支払一時差止区分コード(DbT3003KyodoShoriyoJukyushaIdoShokanSofuEntityGenerator.DEFAULT_保険給付支払一時差止区分コード);
            assertThat(sut.get保険給付支払一時差止区分コード(), is(DbT3003KyodoShoriyoJukyushaIdoShokanSofuEntityGenerator.DEFAULT_保険給付支払一時差止区分コード));
        }

        @Test
        public void 戻り値の保険給付支払一時差止金額は_設定した値と同じ保険給付支払一時差止金額を返す() {
            sut.set保険給付支払一時差止金額(DbT3003KyodoShoriyoJukyushaIdoShokanSofuEntityGenerator.DEFAULT_保険給付支払一時差止金額);
            assertThat(sut.get保険給付支払一時差止金額(), is(DbT3003KyodoShoriyoJukyushaIdoShokanSofuEntityGenerator.DEFAULT_保険給付支払一時差止金額));
        }

        @Test
        public void 戻り値の訂正連絡票フラグは_設定した値と同じ訂正連絡票フラグを返す() {
            sut.set訂正連絡票フラグ(DbT3003KyodoShoriyoJukyushaIdoShokanSofuEntityGenerator.DEFAULT_訂正連絡票フラグ);
            assertThat(sut.get訂正連絡票フラグ(), is(DbT3003KyodoShoriyoJukyushaIdoShokanSofuEntityGenerator.DEFAULT_訂正連絡票フラグ));
        }

        @Test
        public void 戻り値の送付年月は_設定した値と同じ送付年月を返す() {
            sut.set送付年月(DbT3003KyodoShoriyoJukyushaIdoShokanSofuEntityGenerator.DEFAULT_送付年月);
            assertThat(sut.get送付年月(), is(DbT3003KyodoShoriyoJukyushaIdoShokanSofuEntityGenerator.DEFAULT_送付年月));
        }
    }

    public static class getStateTest extends DbzTestBase {

        @Test
        public void 状態Addedの取得確認() {
            KyodoShoriyoJukyushaIdoShokanSofuModel sut = new KyodoShoriyoJukyushaIdoShokanSofuModel();

            assertThat(sut.getState(), is(EntityDataState.Added));
        }

        @Test
        public void 状態Modifinedの取得確認() {
            KyodoShoriyoJukyushaIdoShokanSofuModel sut = new KyodoShoriyoJukyushaIdoShokanSofuModel();
            sut.setEntity(DbT3003KyodoShoriyoJukyushaIdoShokanSofuEntityGenerator.createDbT3003KyodoShoriyoJukyushaIdoShokanSofuEntity());

            sut.getEntity().initializeMd5();

            // 主キー以外の項目を変更してください
//            sut.getEntity().setXXX(new XXX());
//            assertThat(sut.getState(), is(EntityDataState.Modified));
        }

        @Test
        public void 状態Unchangedの取得確認() {
            KyodoShoriyoJukyushaIdoShokanSofuModel sut = new KyodoShoriyoJukyushaIdoShokanSofuModel();
            sut.setEntity(DbT3003KyodoShoriyoJukyushaIdoShokanSofuEntityGenerator.createDbT3003KyodoShoriyoJukyushaIdoShokanSofuEntity());

            sut.getEntity().initializeMd5();

            assertThat(sut.getState(), is(EntityDataState.Unchanged));
        }

        @Test
        public void 状態Deletedの取得確認() {
            KyodoShoriyoJukyushaIdoShokanSofuModel sut = new KyodoShoriyoJukyushaIdoShokanSofuModel();
            sut.setEntity(DbT3003KyodoShoriyoJukyushaIdoShokanSofuEntityGenerator.createDbT3003KyodoShoriyoJukyushaIdoShokanSofuEntity());

            sut.getEntity().initializeMd5();

            sut.setDeletedState(true);

            assertThat(sut.getState(), is(EntityDataState.Deleted));
        }
    }
}
