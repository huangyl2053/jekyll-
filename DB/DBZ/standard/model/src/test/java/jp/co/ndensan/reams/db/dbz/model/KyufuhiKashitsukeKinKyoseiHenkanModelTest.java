/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.model;

import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT3093KyufuhiKashitsukeKinKyoseiHenkanEntityGenerator;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link KyufuhiKashitsukeKinKyoseiHenkanModel}のテストクラスです。
 *
 * @author LDNS 宋昕沢
 */
@RunWith(Enclosed.class)
public class KyufuhiKashitsukeKinKyoseiHenkanModelTest extends DbzTestBase {

    public static class getterSetterTest extends DbzTestBase {

        private static KyufuhiKashitsukeKinKyoseiHenkanModel sut;

        @BeforeClass
        public static void test() {
            sut = new KyufuhiKashitsukeKinKyoseiHenkanModel();
        }

        @Test
        public void 戻り値の被保険者番号は_設定した値と同じ被保険者番号を返す() {
            sut.set被保険者番号(DbT3093KyufuhiKashitsukeKinKyoseiHenkanEntityGenerator.DEFAULT_被保険者番号);
            assertThat(sut.get被保険者番号(), is(DbT3093KyufuhiKashitsukeKinKyoseiHenkanEntityGenerator.DEFAULT_被保険者番号));
        }

        @Test
        public void 戻り値の貸付管理番号は_設定した値と同じ貸付管理番号を返す() {
            sut.set貸付管理番号(DbT3093KyufuhiKashitsukeKinKyoseiHenkanEntityGenerator.DEFAULT_貸付管理番号);
            assertThat(sut.get貸付管理番号(), is(DbT3093KyufuhiKashitsukeKinKyoseiHenkanEntityGenerator.DEFAULT_貸付管理番号));
        }

        @Test
        public void 戻り値の処理日時は_設定した値と同じ処理日時を返す() {
            sut.set処理日時(DbT3093KyufuhiKashitsukeKinKyoseiHenkanEntityGenerator.DEFAULT_処理日時);
            assertThat(sut.get処理日時(), is(DbT3093KyufuhiKashitsukeKinKyoseiHenkanEntityGenerator.DEFAULT_処理日時));
        }

        @Test
        public void 戻り値の返還金区分は_設定した値と同じ返還金区分を返す() {
            sut.set返還金区分(DbT3093KyufuhiKashitsukeKinKyoseiHenkanEntityGenerator.DEFAULT_返還金区分);
            assertThat(sut.get返還金区分(), is(DbT3093KyufuhiKashitsukeKinKyoseiHenkanEntityGenerator.DEFAULT_返還金区分));
        }

        @Test
        public void 戻り値の返還金額は_設定した値と同じ返還金額を返す() {
            sut.set返還金額(DbT3093KyufuhiKashitsukeKinKyoseiHenkanEntityGenerator.DEFAULT_返還金額);
            assertThat(sut.get返還金額(), is(DbT3093KyufuhiKashitsukeKinKyoseiHenkanEntityGenerator.DEFAULT_返還金額));
        }

        @Test
        public void 戻り値の返還期限は_設定した値と同じ返還期限を返す() {
            sut.set返還期限(DbT3093KyufuhiKashitsukeKinKyoseiHenkanEntityGenerator.DEFAULT_返還期限);
            assertThat(sut.get返還期限(), is(DbT3093KyufuhiKashitsukeKinKyoseiHenkanEntityGenerator.DEFAULT_返還期限));
        }

        @Test
        public void 戻り値の返還理由は_設定した値と同じ返還理由を返す() {
            sut.set返還理由(DbT3093KyufuhiKashitsukeKinKyoseiHenkanEntityGenerator.DEFAULT_返還理由);
            assertThat(sut.get返還理由(), is(DbT3093KyufuhiKashitsukeKinKyoseiHenkanEntityGenerator.DEFAULT_返還理由));
        }
    }

    public static class getStateTest extends DbzTestBase {

        @Test
        public void 状態Addedの取得確認() {
            KyufuhiKashitsukeKinKyoseiHenkanModel sut = new KyufuhiKashitsukeKinKyoseiHenkanModel();

            assertThat(sut.getState(), is(EntityDataState.Added));
        }

        @Test
        public void 状態Modifinedの取得確認() {
            KyufuhiKashitsukeKinKyoseiHenkanModel sut = new KyufuhiKashitsukeKinKyoseiHenkanModel();
            sut.setEntity(DbT3093KyufuhiKashitsukeKinKyoseiHenkanEntityGenerator.createDbT3093KyufuhiKashitsukeKinKyoseiHenkanEntity());

            sut.getEntity().initializeMd5();

            // TODO 主キー以外の項目を変更してください
//            sut.getEntity().setXXX(new XXX());
//            assertThat(sut.getState(), is(EntityDataState.Modified));
        }

        @Test
        public void 状態Unchangedの取得確認() {
            KyufuhiKashitsukeKinKyoseiHenkanModel sut = new KyufuhiKashitsukeKinKyoseiHenkanModel();
            sut.setEntity(DbT3093KyufuhiKashitsukeKinKyoseiHenkanEntityGenerator.createDbT3093KyufuhiKashitsukeKinKyoseiHenkanEntity());

            sut.getEntity().initializeMd5();

            assertThat(sut.getState(), is(EntityDataState.Unchanged));
        }

        @Test
        public void 状態Deletedの取得確認() {
            KyufuhiKashitsukeKinKyoseiHenkanModel sut = new KyufuhiKashitsukeKinKyoseiHenkanModel();
            sut.setEntity(DbT3093KyufuhiKashitsukeKinKyoseiHenkanEntityGenerator.createDbT3093KyufuhiKashitsukeKinKyoseiHenkanEntity());

            sut.getEntity().initializeMd5();

            sut.setDeletedState(true);

            assertThat(sut.getState(), is(EntityDataState.Deleted));
        }
    }
}
