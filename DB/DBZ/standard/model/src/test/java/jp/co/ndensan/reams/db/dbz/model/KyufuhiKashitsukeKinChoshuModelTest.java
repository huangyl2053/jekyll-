/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.model;

import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT3092KyufuhiKashitsukeKinChoshuEntityGenerator;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link KyufuhiKashitsukeKinChoshuModel}のテストクラスです。
 *
 * @author LDNS 宋昕沢
 */
@RunWith(Enclosed.class)
public class KyufuhiKashitsukeKinChoshuModelTest extends DbzTestBase {

    public static class getterSetterTest extends DbzTestBase {

        private static KyufuhiKashitsukeKinChoshuModel sut;

        @BeforeClass
        public static void test() {
            sut = new KyufuhiKashitsukeKinChoshuModel();
        }

        @Test
        public void 戻り値の被保険者番号は_設定した値と同じ被保険者番号を返す() {
            sut.set被保険者番号(DbT3092KyufuhiKashitsukeKinChoshuEntityGenerator.DEFAULT_被保険者番号);
            assertThat(sut.get被保険者番号(), is(DbT3092KyufuhiKashitsukeKinChoshuEntityGenerator.DEFAULT_被保険者番号));
        }

        @Test
        public void 戻り値の貸付管理番号は_設定した値と同じ貸付管理番号を返す() {
            sut.set貸付管理番号(DbT3092KyufuhiKashitsukeKinChoshuEntityGenerator.DEFAULT_貸付管理番号);
            assertThat(sut.get貸付管理番号(), is(DbT3092KyufuhiKashitsukeKinChoshuEntityGenerator.DEFAULT_貸付管理番号));
        }

        @Test
        public void 戻り値の処理日時は_設定した値と同じ処理日時を返す() {
            sut.set処理日時(DbT3092KyufuhiKashitsukeKinChoshuEntityGenerator.DEFAULT_処理日時);
            assertThat(sut.get処理日時(), is(DbT3092KyufuhiKashitsukeKinChoshuEntityGenerator.DEFAULT_処理日時));
        }

        @Test
        public void 戻り値の貸付金返還徴収方法は_設定した値と同じ貸付金返還徴収方法を返す() {
            sut.set貸付金返還徴収方法(DbT3092KyufuhiKashitsukeKinChoshuEntityGenerator.DEFAULT_貸付金返還徴収方法);
            assertThat(sut.get貸付金返還徴収方法(), is(DbT3092KyufuhiKashitsukeKinChoshuEntityGenerator.DEFAULT_貸付金返還徴収方法));
        }

        @Test
        public void 戻り値の貸付金返還徴収年月日は_設定した値と同じ貸付金返還徴収年月日を返す() {
            sut.set貸付金返還徴収年月日(DbT3092KyufuhiKashitsukeKinChoshuEntityGenerator.DEFAULT_貸付金返還徴収年月日);
            assertThat(sut.get貸付金返還徴収年月日(), is(DbT3092KyufuhiKashitsukeKinChoshuEntityGenerator.DEFAULT_貸付金返還徴収年月日));
        }

        @Test
        public void 戻り値の貸付金返還徴収金額は_設定した値と同じ貸付金返還徴収金額を返す() {
            sut.set貸付金返還徴収金額(DbT3092KyufuhiKashitsukeKinChoshuEntityGenerator.DEFAULT_貸付金返還徴収金額);
            assertThat(sut.get貸付金返還徴収金額(), is(DbT3092KyufuhiKashitsukeKinChoshuEntityGenerator.DEFAULT_貸付金返還徴収金額));
        }

        @Test
        public void 戻り値の過不足判定結果区分は_設定した値と同じ過不足判定結果区分を返す() {
            sut.set過不足判定結果区分(DbT3092KyufuhiKashitsukeKinChoshuEntityGenerator.DEFAULT_過不足判定結果区分);
            assertThat(sut.get過不足判定結果区分(), is(DbT3092KyufuhiKashitsukeKinChoshuEntityGenerator.DEFAULT_過不足判定結果区分));
        }
    }

    public static class getStateTest extends DbzTestBase {

        @Test
        public void 状態Addedの取得確認() {
            KyufuhiKashitsukeKinChoshuModel sut = new KyufuhiKashitsukeKinChoshuModel();

            assertThat(sut.getState(), is(EntityDataState.Added));
        }

        @Test
        public void 状態Modifinedの取得確認() {
            KyufuhiKashitsukeKinChoshuModel sut = new KyufuhiKashitsukeKinChoshuModel();
            sut.setEntity(DbT3092KyufuhiKashitsukeKinChoshuEntityGenerator.createDbT3092KyufuhiKashitsukeKinChoshuEntity());

            sut.getEntity().initializeMd5();

            // TODO 主キー以外の項目を変更してください
//            sut.getEntity().setXXX(new XXX());
//            assertThat(sut.getState(), is(EntityDataState.Modified));
        }

        @Test
        public void 状態Unchangedの取得確認() {
            KyufuhiKashitsukeKinChoshuModel sut = new KyufuhiKashitsukeKinChoshuModel();
            sut.setEntity(DbT3092KyufuhiKashitsukeKinChoshuEntityGenerator.createDbT3092KyufuhiKashitsukeKinChoshuEntity());

            sut.getEntity().initializeMd5();

            assertThat(sut.getState(), is(EntityDataState.Unchanged));
        }

        @Test
        public void 状態Deletedの取得確認() {
            KyufuhiKashitsukeKinChoshuModel sut = new KyufuhiKashitsukeKinChoshuModel();
            sut.setEntity(DbT3092KyufuhiKashitsukeKinChoshuEntityGenerator.createDbT3092KyufuhiKashitsukeKinChoshuEntity());

            sut.getEntity().initializeMd5();

            sut.setDeletedState(true);

            assertThat(sut.getState(), is(EntityDataState.Deleted));
        }
    }
}
