/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.model;

import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT3089KyufuhiKashitsukekinShokanKigenHenkoEntityGenerator;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link KyufuhiKashitsukekinShokanKigenHenkoModel}のテストクラスです。
 *
 * @author LDNS 宋昕沢
 */
@RunWith(Enclosed.class)
public class KyufuhiKashitsukekinShokanKigenHenkoModelTest extends DbzTestBase {

    public static class getterSetterTest extends DbzTestBase {

        private static KyufuhiKashitsukekinShokanKigenHenkoModel sut;

        @BeforeClass
        public static void test() {
            sut = new KyufuhiKashitsukekinShokanKigenHenkoModel();
        }

        @Test
        public void 戻り値の被保険者番号は_設定した値と同じ被保険者番号を返す() {
            sut.set被保険者番号(DbT3089KyufuhiKashitsukekinShokanKigenHenkoEntityGenerator.DEFAULT_被保険者番号);
            assertThat(sut.get被保険者番号(), is(DbT3089KyufuhiKashitsukekinShokanKigenHenkoEntityGenerator.DEFAULT_被保険者番号));
        }

        @Test
        public void 戻り値の貸付管理番号は_設定した値と同じ貸付管理番号を返す() {
            sut.set貸付管理番号(DbT3089KyufuhiKashitsukekinShokanKigenHenkoEntityGenerator.DEFAULT_貸付管理番号);
            assertThat(sut.get貸付管理番号(), is(DbT3089KyufuhiKashitsukekinShokanKigenHenkoEntityGenerator.DEFAULT_貸付管理番号));
        }

        @Test
        public void 戻り値の償還期限延長受付年月日は_設定した値と同じ償還期限延長受付年月日を返す() {
            sut.set償還期限延長受付年月日(DbT3089KyufuhiKashitsukekinShokanKigenHenkoEntityGenerator.DEFAULT_償還期限延長受付年月日);
            assertThat(sut.get償還期限延長受付年月日(), is(DbT3089KyufuhiKashitsukekinShokanKigenHenkoEntityGenerator.DEFAULT_償還期限延長受付年月日));
        }

        @Test
        public void 戻り値の処理日時は_設定した値と同じ処理日時を返す() {
            sut.set処理日時(DbT3089KyufuhiKashitsukekinShokanKigenHenkoEntityGenerator.DEFAULT_処理日時);
            assertThat(sut.get処理日時(), is(DbT3089KyufuhiKashitsukekinShokanKigenHenkoEntityGenerator.DEFAULT_処理日時));
        }

        @Test
        public void 戻り値の償還期限延長申請年月日は_設定した値と同じ償還期限延長申請年月日を返す() {
            sut.set償還期限延長申請年月日(DbT3089KyufuhiKashitsukekinShokanKigenHenkoEntityGenerator.DEFAULT_償還期限延長申請年月日);
            assertThat(sut.get償還期限延長申請年月日(), is(DbT3089KyufuhiKashitsukekinShokanKigenHenkoEntityGenerator.DEFAULT_償還期限延長申請年月日));
        }

        @Test
        public void 戻り値の借受人郵便番号は_設定した値と同じ借受人郵便番号を返す() {
            sut.set借受人郵便番号(DbT3089KyufuhiKashitsukekinShokanKigenHenkoEntityGenerator.DEFAULT_借受人郵便番号);
            assertThat(sut.get借受人郵便番号(), is(DbT3089KyufuhiKashitsukekinShokanKigenHenkoEntityGenerator.DEFAULT_借受人郵便番号));
        }

        @Test
        public void 戻り値の借受人住所は_設定した値と同じ借受人住所を返す() {
            sut.set借受人住所(DbT3089KyufuhiKashitsukekinShokanKigenHenkoEntityGenerator.DEFAULT_借受人住所);
            assertThat(sut.get借受人住所(), is(DbT3089KyufuhiKashitsukekinShokanKigenHenkoEntityGenerator.DEFAULT_借受人住所));
        }

        @Test
        public void 戻り値の借受人氏名カナは_設定した値と同じ借受人氏名カナを返す() {
            sut.set借受人氏名カナ(DbT3089KyufuhiKashitsukekinShokanKigenHenkoEntityGenerator.DEFAULT_借受人氏名カナ);
            assertThat(sut.get借受人氏名カナ(), is(DbT3089KyufuhiKashitsukekinShokanKigenHenkoEntityGenerator.DEFAULT_借受人氏名カナ));
        }

        @Test
        public void 戻り値の借受人氏名は_設定した値と同じ借受人氏名を返す() {
            sut.set借受人氏名(DbT3089KyufuhiKashitsukekinShokanKigenHenkoEntityGenerator.DEFAULT_借受人氏名);
            assertThat(sut.get借受人氏名(), is(DbT3089KyufuhiKashitsukekinShokanKigenHenkoEntityGenerator.DEFAULT_借受人氏名));
        }

        @Test
        public void 戻り値の借受人電話番号は_設定した値と同じ借受人電話番号を返す() {
            sut.set借受人電話番号(DbT3089KyufuhiKashitsukekinShokanKigenHenkoEntityGenerator.DEFAULT_借受人電話番号);
            assertThat(sut.get借受人電話番号(), is(DbT3089KyufuhiKashitsukekinShokanKigenHenkoEntityGenerator.DEFAULT_借受人電話番号));
        }

        @Test
        public void 戻り値の未償還金額は_設定した値と同じ未償還金額を返す() {
            sut.set未償還金額(DbT3089KyufuhiKashitsukekinShokanKigenHenkoEntityGenerator.DEFAULT_未償還金額);
            assertThat(sut.get未償還金額(), is(DbT3089KyufuhiKashitsukekinShokanKigenHenkoEntityGenerator.DEFAULT_未償還金額));
        }

        @Test
        public void 戻り値の償還期限延長希望期間開始年月日は_設定した値と同じ償還期限延長希望期間開始年月日を返す() {
            sut.set償還期限延長希望期間開始年月日(DbT3089KyufuhiKashitsukekinShokanKigenHenkoEntityGenerator.DEFAULT_償還期限延長希望期間開始年月日);
            assertThat(sut.get償還期限延長希望期間開始年月日(), is(DbT3089KyufuhiKashitsukekinShokanKigenHenkoEntityGenerator.DEFAULT_償還期限延長希望期間開始年月日));
        }

        @Test
        public void 戻り値の償還期限延長希望期間終了年月日は_設定した値と同じ償還期限延長希望期間終了年月日を返す() {
            sut.set償還期限延長希望期間終了年月日(DbT3089KyufuhiKashitsukekinShokanKigenHenkoEntityGenerator.DEFAULT_償還期限延長希望期間終了年月日);
            assertThat(sut.get償還期限延長希望期間終了年月日(), is(DbT3089KyufuhiKashitsukekinShokanKigenHenkoEntityGenerator.DEFAULT_償還期限延長希望期間終了年月日));
        }

        @Test
        public void 戻り値の償還期限延長理由等は_設定した値と同じ償還期限延長理由等を返す() {
            sut.set償還期限延長理由等(DbT3089KyufuhiKashitsukekinShokanKigenHenkoEntityGenerator.DEFAULT_償還期限延長理由等);
            assertThat(sut.get償還期限延長理由等(), is(DbT3089KyufuhiKashitsukekinShokanKigenHenkoEntityGenerator.DEFAULT_償還期限延長理由等));
        }

        @Test
        public void 戻り値の償還期限変更決定年月日は_設定した値と同じ償還期限変更決定年月日を返す() {
            sut.set償還期限変更決定年月日(DbT3089KyufuhiKashitsukekinShokanKigenHenkoEntityGenerator.DEFAULT_償還期限変更決定年月日);
            assertThat(sut.get償還期限変更決定年月日(), is(DbT3089KyufuhiKashitsukekinShokanKigenHenkoEntityGenerator.DEFAULT_償還期限変更決定年月日));
        }

        @Test
        public void 戻り値の償還期限変更承認_不承認区分は_設定した値と同じ償還期限変更承認_不承認区分を返す() {
            sut.set償還期限変更承認_不承認区分(DbT3089KyufuhiKashitsukekinShokanKigenHenkoEntityGenerator.DEFAULT_償還期限変更承認_不承認区分);
            assertThat(sut.get償還期限変更承認_不承認区分(), is(DbT3089KyufuhiKashitsukekinShokanKigenHenkoEntityGenerator.DEFAULT_償還期限変更承認_不承認区分));
        }

        @Test
        public void 戻り値の変更後償還期限は_設定した値と同じ変更後償還期限を返す() {
            sut.set変更後償還期限(DbT3089KyufuhiKashitsukekinShokanKigenHenkoEntityGenerator.DEFAULT_変更後償還期限);
            assertThat(sut.get変更後償還期限(), is(DbT3089KyufuhiKashitsukekinShokanKigenHenkoEntityGenerator.DEFAULT_変更後償還期限));
        }

        @Test
        public void 戻り値の償還期限変更不承認理由は_設定した値と同じ償還期限変更不承認理由を返す() {
            sut.set償還期限変更不承認理由(DbT3089KyufuhiKashitsukekinShokanKigenHenkoEntityGenerator.DEFAULT_償還期限変更不承認理由);
            assertThat(sut.get償還期限変更不承認理由(), is(DbT3089KyufuhiKashitsukekinShokanKigenHenkoEntityGenerator.DEFAULT_償還期限変更不承認理由));
        }
    }

    public static class getStateTest extends DbzTestBase {

        @Test
        public void 状態Addedの取得確認() {
            KyufuhiKashitsukekinShokanKigenHenkoModel sut = new KyufuhiKashitsukekinShokanKigenHenkoModel();

            assertThat(sut.getState(), is(EntityDataState.Added));
        }

        @Test
        public void 状態Modifinedの取得確認() {
            KyufuhiKashitsukekinShokanKigenHenkoModel sut = new KyufuhiKashitsukekinShokanKigenHenkoModel();
            sut.setEntity(DbT3089KyufuhiKashitsukekinShokanKigenHenkoEntityGenerator.createDbT3089KyufuhiKashitsukekinShokanKigenHenkoEntity());

            sut.getEntity().initializeMd5();

            // TODO 主キー以外の項目を変更してください
//            sut.getEntity().setXXX(new XXX());
//            assertThat(sut.getState(), is(EntityDataState.Modified));
        }

        @Test
        public void 状態Unchangedの取得確認() {
            KyufuhiKashitsukekinShokanKigenHenkoModel sut = new KyufuhiKashitsukekinShokanKigenHenkoModel();
            sut.setEntity(DbT3089KyufuhiKashitsukekinShokanKigenHenkoEntityGenerator.createDbT3089KyufuhiKashitsukekinShokanKigenHenkoEntity());

            sut.getEntity().initializeMd5();

            assertThat(sut.getState(), is(EntityDataState.Unchanged));
        }

        @Test
        public void 状態Deletedの取得確認() {
            KyufuhiKashitsukekinShokanKigenHenkoModel sut = new KyufuhiKashitsukekinShokanKigenHenkoModel();
            sut.setEntity(DbT3089KyufuhiKashitsukekinShokanKigenHenkoEntityGenerator.createDbT3089KyufuhiKashitsukekinShokanKigenHenkoEntity());

            sut.getEntity().initializeMd5();

            sut.setDeletedState(true);

            assertThat(sut.getState(), is(EntityDataState.Deleted));
        }
    }
}
