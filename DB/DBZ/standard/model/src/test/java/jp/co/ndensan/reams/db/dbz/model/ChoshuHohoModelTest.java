/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.model;

import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT2001ChoshuHohoEntityGenerator;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link ChoshuHohoModel}のテストクラスです。
 *
 * @author LDNS 鄭雪双
 */
@RunWith(Enclosed.class)
public class ChoshuHohoModelTest extends DbzTestBase {

    public static class getterSetterTest extends DbzTestBase {

        private static ChoshuHohoModel sut;

        @BeforeClass
        public static void test() {
            sut = new ChoshuHohoModel();
        }

        @Test
        public void 戻り値の賦課年度は_設定した値と同じ賦課年度を返す() {
            sut.set賦課年度(DbT2001ChoshuHohoEntityGenerator.DEFAULT_賦課年度);
            assertThat(sut.get賦課年度(), is(DbT2001ChoshuHohoEntityGenerator.DEFAULT_賦課年度));
        }

        @Test
        public void 戻り値の被保険者番号は_設定した値と同じ被保険者番号を返す() {
            sut.set被保険者番号(DbT2001ChoshuHohoEntityGenerator.DEFAULT_被保険者番号);
            assertThat(sut.get被保険者番号(), is(DbT2001ChoshuHohoEntityGenerator.DEFAULT_被保険者番号));
        }

        @Test
        public void 戻り値の処理日時は_設定した値と同じ処理日時を返す() {
            sut.set処理日時(DbT2001ChoshuHohoEntityGenerator.DEFAULT_処理日時);
            assertThat(sut.get処理日時(), is(DbT2001ChoshuHohoEntityGenerator.DEFAULT_処理日時));
        }

        @Test
        public void 戻り値の徴収方法4月は_設定した値と同じ徴収方法4月を返す() {
            sut.set徴収方法4月(DbT2001ChoshuHohoEntityGenerator.DEFAULT_徴収方法4月);
            assertThat(sut.get徴収方法4月(), is(DbT2001ChoshuHohoEntityGenerator.DEFAULT_徴収方法4月));
        }

        @Test
        public void 戻り値の徴収方法5月は_設定した値と同じ徴収方法5月を返す() {
            sut.set徴収方法5月(DbT2001ChoshuHohoEntityGenerator.DEFAULT_徴収方法5月);
            assertThat(sut.get徴収方法5月(), is(DbT2001ChoshuHohoEntityGenerator.DEFAULT_徴収方法5月));
        }

        @Test
        public void 戻り値の徴収方法6月は_設定した値と同じ徴収方法6月を返す() {
            sut.set徴収方法6月(DbT2001ChoshuHohoEntityGenerator.DEFAULT_徴収方法6月);
            assertThat(sut.get徴収方法6月(), is(DbT2001ChoshuHohoEntityGenerator.DEFAULT_徴収方法6月));
        }

        @Test
        public void 戻り値の徴収方法7月は_設定した値と同じ徴収方法7月を返す() {
            sut.set徴収方法7月(DbT2001ChoshuHohoEntityGenerator.DEFAULT_徴収方法7月);
            assertThat(sut.get徴収方法7月(), is(DbT2001ChoshuHohoEntityGenerator.DEFAULT_徴収方法7月));
        }

        @Test
        public void 戻り値の徴収方法8月は_設定した値と同じ徴収方法8月を返す() {
            sut.set徴収方法8月(DbT2001ChoshuHohoEntityGenerator.DEFAULT_徴収方法8月);
            assertThat(sut.get徴収方法8月(), is(DbT2001ChoshuHohoEntityGenerator.DEFAULT_徴収方法8月));
        }

        @Test
        public void 戻り値の徴収方法9月は_設定した値と同じ徴収方法9月を返す() {
            sut.set徴収方法9月(DbT2001ChoshuHohoEntityGenerator.DEFAULT_徴収方法9月);
            assertThat(sut.get徴収方法9月(), is(DbT2001ChoshuHohoEntityGenerator.DEFAULT_徴収方法9月));
        }

        @Test
        public void 戻り値の徴収方法10月は_設定した値と同じ徴収方法10月を返す() {
            sut.set徴収方法10月(DbT2001ChoshuHohoEntityGenerator.DEFAULT_徴収方法10月);
            assertThat(sut.get徴収方法10月(), is(DbT2001ChoshuHohoEntityGenerator.DEFAULT_徴収方法10月));
        }

        @Test
        public void 戻り値の徴収方法11月は_設定した値と同じ徴収方法11月を返す() {
            sut.set徴収方法11月(DbT2001ChoshuHohoEntityGenerator.DEFAULT_徴収方法11月);
            assertThat(sut.get徴収方法11月(), is(DbT2001ChoshuHohoEntityGenerator.DEFAULT_徴収方法11月));
        }

        @Test
        public void 戻り値の徴収方法12月は_設定した値と同じ徴収方法12月を返す() {
            sut.set徴収方法12月(DbT2001ChoshuHohoEntityGenerator.DEFAULT_徴収方法12月);
            assertThat(sut.get徴収方法12月(), is(DbT2001ChoshuHohoEntityGenerator.DEFAULT_徴収方法12月));
        }

        @Test
        public void 戻り値の徴収方法1月は_設定した値と同じ徴収方法1月を返す() {
            sut.set徴収方法1月(DbT2001ChoshuHohoEntityGenerator.DEFAULT_徴収方法1月);
            assertThat(sut.get徴収方法1月(), is(DbT2001ChoshuHohoEntityGenerator.DEFAULT_徴収方法1月));
        }

        @Test
        public void 戻り値の徴収方法2月は_設定した値と同じ徴収方法2月を返す() {
            sut.set徴収方法2月(DbT2001ChoshuHohoEntityGenerator.DEFAULT_徴収方法2月);
            assertThat(sut.get徴収方法2月(), is(DbT2001ChoshuHohoEntityGenerator.DEFAULT_徴収方法2月));
        }

        @Test
        public void 戻り値の徴収方法3月は_設定した値と同じ徴収方法3月を返す() {
            sut.set徴収方法3月(DbT2001ChoshuHohoEntityGenerator.DEFAULT_徴収方法3月);
            assertThat(sut.get徴収方法3月(), is(DbT2001ChoshuHohoEntityGenerator.DEFAULT_徴収方法3月));
        }

        @Test
        public void 戻り値の徴収方法翌4月は_設定した値と同じ徴収方法翌4月を返す() {
            sut.set徴収方法翌4月(DbT2001ChoshuHohoEntityGenerator.DEFAULT_徴収方法翌4月);
            assertThat(sut.get徴収方法翌4月(), is(DbT2001ChoshuHohoEntityGenerator.DEFAULT_徴収方法翌4月));
        }

        @Test
        public void 戻り値の徴収方法翌5月は_設定した値と同じ徴収方法翌5月を返す() {
            sut.set徴収方法翌5月(DbT2001ChoshuHohoEntityGenerator.DEFAULT_徴収方法翌5月);
            assertThat(sut.get徴収方法翌5月(), is(DbT2001ChoshuHohoEntityGenerator.DEFAULT_徴収方法翌5月));
        }

        @Test
        public void 戻り値の徴収方法翌6月は_設定した値と同じ徴収方法翌6月を返す() {
            sut.set徴収方法翌6月(DbT2001ChoshuHohoEntityGenerator.DEFAULT_徴収方法翌6月);
            assertThat(sut.get徴収方法翌6月(), is(DbT2001ChoshuHohoEntityGenerator.DEFAULT_徴収方法翌6月));
        }

        @Test
        public void 戻り値の徴収方法翌7月は_設定した値と同じ徴収方法翌7月を返す() {
            sut.set徴収方法翌7月(DbT2001ChoshuHohoEntityGenerator.DEFAULT_徴収方法翌7月);
            assertThat(sut.get徴収方法翌7月(), is(DbT2001ChoshuHohoEntityGenerator.DEFAULT_徴収方法翌7月));
        }

        @Test
        public void 戻り値の徴収方法翌8月は_設定した値と同じ徴収方法翌8月を返す() {
            sut.set徴収方法翌8月(DbT2001ChoshuHohoEntityGenerator.DEFAULT_徴収方法翌8月);
            assertThat(sut.get徴収方法翌8月(), is(DbT2001ChoshuHohoEntityGenerator.DEFAULT_徴収方法翌8月));
        }

        @Test
        public void 戻り値の徴収方法翌9月は_設定した値と同じ徴収方法翌9月を返す() {
            sut.set徴収方法翌9月(DbT2001ChoshuHohoEntityGenerator.DEFAULT_徴収方法翌9月);
            assertThat(sut.get徴収方法翌9月(), is(DbT2001ChoshuHohoEntityGenerator.DEFAULT_徴収方法翌9月));
        }

        @Test
        public void 戻り値の仮徴収_基礎年金番号は_設定した値と同じ仮徴収_基礎年金番号を返す() {
            sut.set仮徴収_基礎年金番号(DbT2001ChoshuHohoEntityGenerator.DEFAULT_仮徴収_基礎年金番号);
            assertThat(sut.get仮徴収_基礎年金番号(), is(DbT2001ChoshuHohoEntityGenerator.DEFAULT_仮徴収_基礎年金番号));
        }

        @Test
        public void 戻り値の仮徴収_年金コードは_設定した値と同じ仮徴収_年金コードを返す() {
            sut.set仮徴収_年金コード(DbT2001ChoshuHohoEntityGenerator.DEFAULT_仮徴収_年金コード);
            assertThat(sut.get仮徴収_年金コード(), is(DbT2001ChoshuHohoEntityGenerator.DEFAULT_仮徴収_年金コード));
        }

        @Test
        public void 戻り値の仮徴収_捕捉月は_設定した値と同じ仮徴収_捕捉月を返す() {
            sut.set仮徴収_捕捉月(DbT2001ChoshuHohoEntityGenerator.DEFAULT_仮徴収_捕捉月);
            assertThat(sut.get仮徴収_捕捉月(), is(DbT2001ChoshuHohoEntityGenerator.DEFAULT_仮徴収_捕捉月));
        }

        @Test
        public void 戻り値の本徴収_基礎年金番号は_設定した値と同じ本徴収_基礎年金番号を返す() {
            sut.set本徴収_基礎年金番号(DbT2001ChoshuHohoEntityGenerator.DEFAULT_本徴収_基礎年金番号);
            assertThat(sut.get本徴収_基礎年金番号(), is(DbT2001ChoshuHohoEntityGenerator.DEFAULT_本徴収_基礎年金番号));
        }

        @Test
        public void 戻り値の本徴収_年金コードは_設定した値と同じ本徴収_年金コードを返す() {
            sut.set本徴収_年金コード(DbT2001ChoshuHohoEntityGenerator.DEFAULT_本徴収_年金コード);
            assertThat(sut.get本徴収_年金コード(), is(DbT2001ChoshuHohoEntityGenerator.DEFAULT_本徴収_年金コード));
        }

        @Test
        public void 戻り値の本徴収_捕捉月は_設定した値と同じ本徴収_捕捉月を返す() {
            sut.set本徴収_捕捉月(DbT2001ChoshuHohoEntityGenerator.DEFAULT_本徴収_捕捉月);
            assertThat(sut.get本徴収_捕捉月(), is(DbT2001ChoshuHohoEntityGenerator.DEFAULT_本徴収_捕捉月));
        }

        @Test
        public void 戻り値の翌年度仮徴収_基礎年金番号は_設定した値と同じ翌年度仮徴収_基礎年金番号を返す() {
            sut.set翌年度仮徴収_基礎年金番号(DbT2001ChoshuHohoEntityGenerator.DEFAULT_翌年度仮徴収_基礎年金番号);
            assertThat(sut.get翌年度仮徴収_基礎年金番号(), is(DbT2001ChoshuHohoEntityGenerator.DEFAULT_翌年度仮徴収_基礎年金番号));
        }

        @Test
        public void 戻り値の翌年度仮徴収_年金コードは_設定した値と同じ翌年度仮徴収_年金コードを返す() {
            sut.set翌年度仮徴収_年金コード(DbT2001ChoshuHohoEntityGenerator.DEFAULT_翌年度仮徴収_年金コード);
            assertThat(sut.get翌年度仮徴収_年金コード(), is(DbT2001ChoshuHohoEntityGenerator.DEFAULT_翌年度仮徴収_年金コード));
        }

        @Test
        public void 戻り値の翌年度仮徴収_捕捉月は_設定した値と同じ翌年度仮徴収_捕捉月を返す() {
            sut.set翌年度仮徴収_捕捉月(DbT2001ChoshuHohoEntityGenerator.DEFAULT_翌年度仮徴収_捕捉月);
            assertThat(sut.get翌年度仮徴収_捕捉月(), is(DbT2001ChoshuHohoEntityGenerator.DEFAULT_翌年度仮徴収_捕捉月));
        }

        @Test
        public void 戻り値の依頼情報送付済みフラグは_設定した値と同じ依頼情報送付済みフラグを返す() {
            sut.set依頼情報送付済みフラグ(DbT2001ChoshuHohoEntityGenerator.DEFAULT_依頼情報送付済みフラグ);
            assertThat(sut.get依頼情報送付済みフラグ(), is(DbT2001ChoshuHohoEntityGenerator.DEFAULT_依頼情報送付済みフラグ));
        }

        @Test
        public void 戻り値の追加依頼情報送付済みフラグは_設定した値と同じ追加依頼情報送付済みフラグを返す() {
            sut.set追加依頼情報送付済みフラグ(DbT2001ChoshuHohoEntityGenerator.DEFAULT_追加依頼情報送付済みフラグ);
            assertThat(sut.get追加依頼情報送付済みフラグ(), is(DbT2001ChoshuHohoEntityGenerator.DEFAULT_追加依頼情報送付済みフラグ));
        }

        @Test
        public void 戻り値の特別徴収停止日時は_設定した値と同じ特別徴収停止日時を返す() {
            sut.set特別徴収停止日時(DbT2001ChoshuHohoEntityGenerator.DEFAULT_特別徴収停止日時);
            assertThat(sut.get特別徴収停止日時(), is(DbT2001ChoshuHohoEntityGenerator.DEFAULT_特別徴収停止日時));
        }

        @Test
        public void 戻り値の特別徴収停止事由コードは_設定した値と同じ特別徴収停止事由コードを返す() {
            sut.set特別徴収停止事由コード(DbT2001ChoshuHohoEntityGenerator.DEFAULT_特別徴収停止事由コード);
            assertThat(sut.get特別徴収停止事由コード(), is(DbT2001ChoshuHohoEntityGenerator.DEFAULT_特別徴収停止事由コード));
        }
    }

    public static class getStateTest extends DbzTestBase {

        @Test
        public void 状態Addedの取得確認() {
            ChoshuHohoModel sut = new ChoshuHohoModel();

            assertThat(sut.getState(), is(EntityDataState.Added));
        }

        @Test
        public void 状態Modifinedの取得確認() {
            ChoshuHohoModel sut = new ChoshuHohoModel();
            sut.setEntity(DbT2001ChoshuHohoEntityGenerator.createDbT2001ChoshuHohoEntity());

            sut.getEntity().initializeMd5();

            // 主キー以外の項目を変更してください
//            sut.getEntity().setXXX(new XXX());
//            assertThat(sut.getState(), is(EntityDataState.Modified));
        }

        @Test
        public void 状態Unchangedの取得確認() {
            ChoshuHohoModel sut = new ChoshuHohoModel();
            sut.setEntity(DbT2001ChoshuHohoEntityGenerator.createDbT2001ChoshuHohoEntity());

            sut.getEntity().initializeMd5();

            assertThat(sut.getState(), is(EntityDataState.Unchanged));
        }

        @Test
        public void 状態Deletedの取得確認() {
            ChoshuHohoModel sut = new ChoshuHohoModel();
            sut.setEntity(DbT2001ChoshuHohoEntityGenerator.createDbT2001ChoshuHohoEntity());

            sut.getEntity().initializeMd5();

            sut.setDeletedState(true);

            assertThat(sut.getState(), is(EntityDataState.Deleted));
        }
    }
}
