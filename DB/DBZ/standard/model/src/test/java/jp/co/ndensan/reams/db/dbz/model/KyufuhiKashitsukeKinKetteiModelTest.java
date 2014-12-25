/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.model;

import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT3087KyufuhiKashitsukeKinKetteiEntityGenerator;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link KyufuhiKashitsukeKinKetteiModel}のテストクラスです。
 *
 * @author LDNS 宋昕沢
 */
@RunWith(Enclosed.class)
public class KyufuhiKashitsukeKinKetteiModelTest extends DbzTestBase {

    public static class getterSetterTest extends DbzTestBase {

        private static KyufuhiKashitsukeKinKetteiModel sut;

        @BeforeClass
        public static void test() {
            sut = new KyufuhiKashitsukeKinKetteiModel();
        }

        @Test
        public void 戻り値の被保険者番号は_設定した値と同じ被保険者番号を返す() {
            sut.set被保険者番号(DbT3087KyufuhiKashitsukeKinKetteiEntityGenerator.DEFAULT_被保険者番号);
            assertThat(sut.get被保険者番号(), is(DbT3087KyufuhiKashitsukeKinKetteiEntityGenerator.DEFAULT_被保険者番号));
        }

        @Test
        public void 戻り値の借入申請年月日は_設定した値と同じ借入申請年月日を返す() {
            sut.set借入申請年月日(DbT3087KyufuhiKashitsukeKinKetteiEntityGenerator.DEFAULT_借入申請年月日);
            assertThat(sut.get借入申請年月日(), is(DbT3087KyufuhiKashitsukeKinKetteiEntityGenerator.DEFAULT_借入申請年月日));
        }

        @Test
        public void 戻り値の処理日時は_設定した値と同じ処理日時を返す() {
            sut.set処理日時(DbT3087KyufuhiKashitsukeKinKetteiEntityGenerator.DEFAULT_処理日時);
            assertThat(sut.get処理日時(), is(DbT3087KyufuhiKashitsukeKinKetteiEntityGenerator.DEFAULT_処理日時));
        }

        @Test
        public void 戻り値の貸付審査決定年月日は_設定した値と同じ貸付審査決定年月日を返す() {
            sut.set貸付審査決定年月日(DbT3087KyufuhiKashitsukeKinKetteiEntityGenerator.DEFAULT_貸付審査決定年月日);
            assertThat(sut.get貸付審査決定年月日(), is(DbT3087KyufuhiKashitsukeKinKetteiEntityGenerator.DEFAULT_貸付審査決定年月日));
        }

        @Test
        public void 戻り値の貸付承認_不承認区分は_設定した値と同じ貸付承認_不承認区分を返す() {
            sut.set貸付承認_不承認区分(DbT3087KyufuhiKashitsukeKinKetteiEntityGenerator.DEFAULT_貸付承認_不承認区分);
            assertThat(sut.get貸付承認_不承認区分(), is(DbT3087KyufuhiKashitsukeKinKetteiEntityGenerator.DEFAULT_貸付承認_不承認区分));
        }

        @Test
        public void 戻り値の貸付管理番号は_設定した値と同じ貸付管理番号を返す() {
            sut.set貸付管理番号(DbT3087KyufuhiKashitsukeKinKetteiEntityGenerator.DEFAULT_貸付管理番号);
            assertThat(sut.get貸付管理番号(), is(DbT3087KyufuhiKashitsukeKinKetteiEntityGenerator.DEFAULT_貸付管理番号));
        }

        @Test
        public void 戻り値の貸付金額は_設定した値と同じ貸付金額を返す() {
            sut.set貸付金額(DbT3087KyufuhiKashitsukeKinKetteiEntityGenerator.DEFAULT_貸付金額);
            assertThat(sut.get貸付金額(), is(DbT3087KyufuhiKashitsukeKinKetteiEntityGenerator.DEFAULT_貸付金額));
        }

        @Test
        public void 戻り値の償還方法は_設定した値と同じ償還方法を返す() {
            sut.set償還方法(DbT3087KyufuhiKashitsukeKinKetteiEntityGenerator.DEFAULT_償還方法);
            assertThat(sut.get償還方法(), is(DbT3087KyufuhiKashitsukeKinKetteiEntityGenerator.DEFAULT_償還方法));
        }

        @Test
        public void 戻り値の償還期限は_設定した値と同じ償還期限を返す() {
            sut.set償還期限(DbT3087KyufuhiKashitsukeKinKetteiEntityGenerator.DEFAULT_償還期限);
            assertThat(sut.get償還期限(), is(DbT3087KyufuhiKashitsukeKinKetteiEntityGenerator.DEFAULT_償還期限));
        }

        @Test
        public void 戻り値の貸付年月日は_設定した値と同じ貸付年月日を返す() {
            sut.set貸付年月日(DbT3087KyufuhiKashitsukeKinKetteiEntityGenerator.DEFAULT_貸付年月日);
            assertThat(sut.get貸付年月日(), is(DbT3087KyufuhiKashitsukeKinKetteiEntityGenerator.DEFAULT_貸付年月日));
        }

        @Test
        public void 戻り値の貸付支払方法は_設定した値と同じ貸付支払方法を返す() {
            sut.set貸付支払方法(DbT3087KyufuhiKashitsukeKinKetteiEntityGenerator.DEFAULT_貸付支払方法);
            assertThat(sut.get貸付支払方法(), is(DbT3087KyufuhiKashitsukeKinKetteiEntityGenerator.DEFAULT_貸付支払方法));
        }

        @Test
        public void 戻り値の貸付窓口支払場所は_設定した値と同じ貸付窓口支払場所を返す() {
            sut.set貸付窓口支払場所(DbT3087KyufuhiKashitsukeKinKetteiEntityGenerator.DEFAULT_貸付窓口支払場所);
            assertThat(sut.get貸付窓口支払場所(), is(DbT3087KyufuhiKashitsukeKinKetteiEntityGenerator.DEFAULT_貸付窓口支払場所));
        }

        @Test
        public void 戻り値の貸付窓口開始年月日は_設定した値と同じ貸付窓口開始年月日を返す() {
            sut.set貸付窓口開始年月日(DbT3087KyufuhiKashitsukeKinKetteiEntityGenerator.DEFAULT_貸付窓口開始年月日);
            assertThat(sut.get貸付窓口開始年月日(), is(DbT3087KyufuhiKashitsukeKinKetteiEntityGenerator.DEFAULT_貸付窓口開始年月日));
        }

        @Test
        public void 戻り値の貸付窓口終了年月日は_設定した値と同じ貸付窓口終了年月日を返す() {
            sut.set貸付窓口終了年月日(DbT3087KyufuhiKashitsukeKinKetteiEntityGenerator.DEFAULT_貸付窓口終了年月日);
            assertThat(sut.get貸付窓口終了年月日(), is(DbT3087KyufuhiKashitsukeKinKetteiEntityGenerator.DEFAULT_貸付窓口終了年月日));
        }

        @Test
        public void 戻り値の貸付窓口閉庁内容は_設定した値と同じ貸付窓口閉庁内容を返す() {
            sut.set貸付窓口閉庁内容(DbT3087KyufuhiKashitsukeKinKetteiEntityGenerator.DEFAULT_貸付窓口閉庁内容);
            assertThat(sut.get貸付窓口閉庁内容(), is(DbT3087KyufuhiKashitsukeKinKetteiEntityGenerator.DEFAULT_貸付窓口閉庁内容));
        }

        @Test
        public void 戻り値の貸付窓口開始時間は_設定した値と同じ貸付窓口開始時間を返す() {
            sut.set貸付窓口開始時間(DbT3087KyufuhiKashitsukeKinKetteiEntityGenerator.DEFAULT_貸付窓口開始時間);
            assertThat(sut.get貸付窓口開始時間(), is(DbT3087KyufuhiKashitsukeKinKetteiEntityGenerator.DEFAULT_貸付窓口開始時間));
        }

        @Test
        public void 戻り値の貸付窓口終了時間は_設定した値と同じ貸付窓口終了時間を返す() {
            sut.set貸付窓口終了時間(DbT3087KyufuhiKashitsukeKinKetteiEntityGenerator.DEFAULT_貸付窓口終了時間);
            assertThat(sut.get貸付窓口終了時間(), is(DbT3087KyufuhiKashitsukeKinKetteiEntityGenerator.DEFAULT_貸付窓口終了時間));
        }

        @Test
        public void 戻り値の貸付不承認理由は_設定した値と同じ貸付不承認理由を返す() {
            sut.set貸付不承認理由(DbT3087KyufuhiKashitsukeKinKetteiEntityGenerator.DEFAULT_貸付不承認理由);
            assertThat(sut.get貸付不承認理由(), is(DbT3087KyufuhiKashitsukeKinKetteiEntityGenerator.DEFAULT_貸付不承認理由));
        }

        @Test
        public void 戻り値の識別コードは_設定した値と同じ識別コードを返す() {
            sut.set識別コード(DbT3087KyufuhiKashitsukeKinKetteiEntityGenerator.DEFAULT_識別コード);
            assertThat(sut.get識別コード(), is(DbT3087KyufuhiKashitsukeKinKetteiEntityGenerator.DEFAULT_識別コード));
        }
    }

    public static class getStateTest extends DbzTestBase {

        @Test
        public void 状態Addedの取得確認() {
            KyufuhiKashitsukeKinKetteiModel sut = new KyufuhiKashitsukeKinKetteiModel();

            assertThat(sut.getState(), is(EntityDataState.Added));
        }

        @Test
        public void 状態Modifinedの取得確認() {
            KyufuhiKashitsukeKinKetteiModel sut = new KyufuhiKashitsukeKinKetteiModel();
            sut.setEntity(DbT3087KyufuhiKashitsukeKinKetteiEntityGenerator.createDbT3087KyufuhiKashitsukeKinKetteiEntity());

            sut.getEntity().initializeMd5();

            // TODO 主キー以外の項目を変更してください
//            sut.getEntity().setXXX(new XXX());
//            assertThat(sut.getState(), is(EntityDataState.Modified));
        }

        @Test
        public void 状態Unchangedの取得確認() {
            KyufuhiKashitsukeKinKetteiModel sut = new KyufuhiKashitsukeKinKetteiModel();
            sut.setEntity(DbT3087KyufuhiKashitsukeKinKetteiEntityGenerator.createDbT3087KyufuhiKashitsukeKinKetteiEntity());

            sut.getEntity().initializeMd5();

            assertThat(sut.getState(), is(EntityDataState.Unchanged));
        }

        @Test
        public void 状態Deletedの取得確認() {
            KyufuhiKashitsukeKinKetteiModel sut = new KyufuhiKashitsukeKinKetteiModel();
            sut.setEntity(DbT3087KyufuhiKashitsukeKinKetteiEntityGenerator.createDbT3087KyufuhiKashitsukeKinKetteiEntity());

            sut.getEntity().initializeMd5();

            sut.setDeletedState(true);

            assertThat(sut.getState(), is(EntityDataState.Deleted));
        }
    }
}
