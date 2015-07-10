/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.model;

import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT3088KyufuhiKashitsukekinShakuyoshoJuriEntityGenerator;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link KyufuhiKashitsukekinShakuyoshoJuriModel}のテストクラスです。
 *
 * @author LDNS 宋昕沢
 */
@RunWith(Enclosed.class)
public class KyufuhiKashitsukekinShakuyoshoJuriModelTest extends DbzTestBase {

    public static class getterSetterTest extends DbzTestBase {

        private static KyufuhiKashitsukekinShakuyoshoJuriModel sut;

        @BeforeClass
        public static void test() {
            sut = new KyufuhiKashitsukekinShakuyoshoJuriModel();
        }

        @Test
        public void 戻り値の被保険者番号は_設定した値と同じ被保険者番号を返す() {
            sut.set被保険者番号(DbT3088KyufuhiKashitsukekinShakuyoshoJuriEntityGenerator.DEFAULT_被保険者番号);
            assertThat(sut.get被保険者番号(), is(DbT3088KyufuhiKashitsukekinShakuyoshoJuriEntityGenerator.DEFAULT_被保険者番号));
        }

        @Test
        public void 戻り値の借入申請年月日は_設定した値と同じ借入申請年月日を返す() {
            sut.set借入申請年月日(DbT3088KyufuhiKashitsukekinShakuyoshoJuriEntityGenerator.DEFAULT_借入申請年月日);
            assertThat(sut.get借入申請年月日(), is(DbT3088KyufuhiKashitsukekinShakuyoshoJuriEntityGenerator.DEFAULT_借入申請年月日));
        }

        @Test
        public void 戻り値の処理日時は_設定した値と同じ処理日時を返す() {
            sut.set処理日時(DbT3088KyufuhiKashitsukekinShakuyoshoJuriEntityGenerator.DEFAULT_処理日時);
            assertThat(sut.get処理日時(), is(DbT3088KyufuhiKashitsukekinShakuyoshoJuriEntityGenerator.DEFAULT_処理日時));
        }

        @Test
        public void 戻り値の借受年月日は_設定した値と同じ借受年月日を返す() {
            sut.set借受年月日(DbT3088KyufuhiKashitsukekinShakuyoshoJuriEntityGenerator.DEFAULT_借受年月日);
            assertThat(sut.get借受年月日(), is(DbT3088KyufuhiKashitsukekinShakuyoshoJuriEntityGenerator.DEFAULT_借受年月日));
        }

        @Test
        public void 戻り値の借受人郵便番号は_設定した値と同じ借受人郵便番号を返す() {
            sut.set借受人郵便番号(DbT3088KyufuhiKashitsukekinShakuyoshoJuriEntityGenerator.DEFAULT_借受人郵便番号);
            assertThat(sut.get借受人郵便番号(), is(DbT3088KyufuhiKashitsukekinShakuyoshoJuriEntityGenerator.DEFAULT_借受人郵便番号));
        }

        @Test
        public void 戻り値の借受人住所は_設定した値と同じ借受人住所を返す() {
            sut.set借受人住所(DbT3088KyufuhiKashitsukekinShakuyoshoJuriEntityGenerator.DEFAULT_借受人住所);
            assertThat(sut.get借受人住所(), is(DbT3088KyufuhiKashitsukekinShakuyoshoJuriEntityGenerator.DEFAULT_借受人住所));
        }

        @Test
        public void 戻り値の借受人氏名カナは_設定した値と同じ借受人氏名カナを返す() {
            sut.set借受人氏名カナ(DbT3088KyufuhiKashitsukekinShakuyoshoJuriEntityGenerator.DEFAULT_借受人氏名カナ);
            assertThat(sut.get借受人氏名カナ(), is(DbT3088KyufuhiKashitsukekinShakuyoshoJuriEntityGenerator.DEFAULT_借受人氏名カナ));
        }

        @Test
        public void 戻り値の借受人氏名は_設定した値と同じ借受人氏名を返す() {
            sut.set借受人氏名(DbT3088KyufuhiKashitsukekinShakuyoshoJuriEntityGenerator.DEFAULT_借受人氏名);
            assertThat(sut.get借受人氏名(), is(DbT3088KyufuhiKashitsukekinShakuyoshoJuriEntityGenerator.DEFAULT_借受人氏名));
        }

        @Test
        public void 戻り値の借受人電話番号は_設定した値と同じ借受人電話番号を返す() {
            sut.set借受人電話番号(DbT3088KyufuhiKashitsukekinShakuyoshoJuriEntityGenerator.DEFAULT_借受人電話番号);
            assertThat(sut.get借受人電話番号(), is(DbT3088KyufuhiKashitsukekinShakuyoshoJuriEntityGenerator.DEFAULT_借受人電話番号));
        }

        @Test
        public void 戻り値の保証人氏名カナは_設定した値と同じ保証人氏名カナを返す() {
            sut.set保証人氏名カナ(DbT3088KyufuhiKashitsukekinShakuyoshoJuriEntityGenerator.DEFAULT_保証人氏名カナ);
            assertThat(sut.get保証人氏名カナ(), is(DbT3088KyufuhiKashitsukekinShakuyoshoJuriEntityGenerator.DEFAULT_保証人氏名カナ));
        }

        @Test
        public void 戻り値の保証人氏名は_設定した値と同じ保証人氏名を返す() {
            sut.set保証人氏名(DbT3088KyufuhiKashitsukekinShakuyoshoJuriEntityGenerator.DEFAULT_保証人氏名);
            assertThat(sut.get保証人氏名(), is(DbT3088KyufuhiKashitsukekinShakuyoshoJuriEntityGenerator.DEFAULT_保証人氏名));
        }

        @Test
        public void 戻り値の保証人郵便番号は_設定した値と同じ保証人郵便番号を返す() {
            sut.set保証人郵便番号(DbT3088KyufuhiKashitsukekinShakuyoshoJuriEntityGenerator.DEFAULT_保証人郵便番号);
            assertThat(sut.get保証人郵便番号(), is(DbT3088KyufuhiKashitsukekinShakuyoshoJuriEntityGenerator.DEFAULT_保証人郵便番号));
        }

        @Test
        public void 戻り値の保証人住所は_設定した値と同じ保証人住所を返す() {
            sut.set保証人住所(DbT3088KyufuhiKashitsukekinShakuyoshoJuriEntityGenerator.DEFAULT_保証人住所);
            assertThat(sut.get保証人住所(), is(DbT3088KyufuhiKashitsukekinShakuyoshoJuriEntityGenerator.DEFAULT_保証人住所));
        }

        @Test
        public void 戻り値の保証人電話番号は_設定した値と同じ保証人電話番号を返す() {
            sut.set保証人電話番号(DbT3088KyufuhiKashitsukekinShakuyoshoJuriEntityGenerator.DEFAULT_保証人電話番号);
            assertThat(sut.get保証人電話番号(), is(DbT3088KyufuhiKashitsukekinShakuyoshoJuriEntityGenerator.DEFAULT_保証人電話番号));
        }
    }

    public static class getStateTest extends DbzTestBase {

        @Test
        public void 状態Addedの取得確認() {
            KyufuhiKashitsukekinShakuyoshoJuriModel sut = new KyufuhiKashitsukekinShakuyoshoJuriModel();

            assertThat(sut.getState(), is(EntityDataState.Added));
        }

        @Test
        public void 状態Modifinedの取得確認() {
            KyufuhiKashitsukekinShakuyoshoJuriModel sut = new KyufuhiKashitsukekinShakuyoshoJuriModel();
            sut.setEntity(DbT3088KyufuhiKashitsukekinShakuyoshoJuriEntityGenerator.createDbT3088KyufuhiKashitsukekinShakuyoshoJuriEntity());

            sut.getEntity().initializeMd5();

            // TODO 主キー以外の項目を変更してください
//            sut.getEntity().setXXX(new XXX());
//            assertThat(sut.getState(), is(EntityDataState.Modified));
        }

        @Test
        public void 状態Unchangedの取得確認() {
            KyufuhiKashitsukekinShakuyoshoJuriModel sut = new KyufuhiKashitsukekinShakuyoshoJuriModel();
            sut.setEntity(DbT3088KyufuhiKashitsukekinShakuyoshoJuriEntityGenerator.createDbT3088KyufuhiKashitsukekinShakuyoshoJuriEntity());

            sut.getEntity().initializeMd5();

            assertThat(sut.getState(), is(EntityDataState.Unchanged));
        }

        @Test
        public void 状態Deletedの取得確認() {
            KyufuhiKashitsukekinShakuyoshoJuriModel sut = new KyufuhiKashitsukekinShakuyoshoJuriModel();
            sut.setEntity(DbT3088KyufuhiKashitsukekinShakuyoshoJuriEntityGenerator.createDbT3088KyufuhiKashitsukekinShakuyoshoJuriEntity());

            sut.getEntity().initializeMd5();

            sut.setDeletedState(true);

            assertThat(sut.getState(), is(EntityDataState.Deleted));
        }
    }
}
