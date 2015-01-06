/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.model;

import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT3006KyotakuKeikakuJigyoshaSakuseiEntityGenerator;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link KyotakuKeikakuJigyoshaSakuseiModel}のテストクラスです。
 *
 * @author LDNS 鄭雪双
 */
@RunWith(Enclosed.class)
public class KyotakuKeikakuJigyoshaSakuseiModelTest extends DbzTestBase {

    public static class getterSetterTest extends DbzTestBase {

        private static KyotakuKeikakuJigyoshaSakuseiModel sut;

        @BeforeClass
        public static void test() {
            sut = new KyotakuKeikakuJigyoshaSakuseiModel();
        }

        @Test
        public void 戻り値の被保険者番号は_設定した値と同じ被保険者番号を返す() {
            sut.set被保険者番号(DbT3006KyotakuKeikakuJigyoshaSakuseiEntityGenerator.DEFAULT_被保険者番号);
            assertThat(sut.get被保険者番号(), is(DbT3006KyotakuKeikakuJigyoshaSakuseiEntityGenerator.DEFAULT_被保険者番号));
        }

        @Test
        public void 戻り値の証記載保険者番号は_設定した値と同じ証記載保険者番号を返す() {
            sut.set証記載保険者番号(DbT3006KyotakuKeikakuJigyoshaSakuseiEntityGenerator.DEFAULT_証記載保険者番号);
            assertThat(sut.get証記載保険者番号(), is(DbT3006KyotakuKeikakuJigyoshaSakuseiEntityGenerator.DEFAULT_証記載保険者番号));
        }

        @Test
        public void 戻り値の識別コードは_設定した値と同じ識別コードを返す() {
            sut.set識別コード(DbT3006KyotakuKeikakuJigyoshaSakuseiEntityGenerator.DEFAULT_識別コード);
            assertThat(sut.get識別コード(), is(DbT3006KyotakuKeikakuJigyoshaSakuseiEntityGenerator.DEFAULT_識別コード));
        }

        @Test
        public void 戻り値の対象年月は_設定した値と同じ対象年月を返す() {
            sut.set対象年月(DbT3006KyotakuKeikakuJigyoshaSakuseiEntityGenerator.DEFAULT_対象年月);
            assertThat(sut.get対象年月(), is(DbT3006KyotakuKeikakuJigyoshaSakuseiEntityGenerator.DEFAULT_対象年月));
        }

        @Test
        public void 戻り値の処理日時は_設定した値と同じ処理日時を返す() {
            sut.set処理日時(DbT3006KyotakuKeikakuJigyoshaSakuseiEntityGenerator.DEFAULT_処理日時);
            assertThat(sut.get処理日時(), is(DbT3006KyotakuKeikakuJigyoshaSakuseiEntityGenerator.DEFAULT_処理日時));
        }

        @Test
        public void 戻り値の適用開始年月日は_設定した値と同じ適用開始年月日を返す() {
            sut.set適用開始年月日(DbT3006KyotakuKeikakuJigyoshaSakuseiEntityGenerator.DEFAULT_適用開始年月日);
            assertThat(sut.get適用開始年月日(), is(DbT3006KyotakuKeikakuJigyoshaSakuseiEntityGenerator.DEFAULT_適用開始年月日));
        }

        @Test
        public void 戻り値の適用終了年月日は_設定した値と同じ適用終了年月日を返す() {
            sut.set適用終了年月日(DbT3006KyotakuKeikakuJigyoshaSakuseiEntityGenerator.DEFAULT_適用終了年月日);
            assertThat(sut.get適用終了年月日(), is(DbT3006KyotakuKeikakuJigyoshaSakuseiEntityGenerator.DEFAULT_適用終了年月日));
        }

        @Test
        public void 戻り値の計画事業者番号は_設定した値と同じ計画事業者番号を返す() {
            sut.set計画事業者番号(DbT3006KyotakuKeikakuJigyoshaSakuseiEntityGenerator.DEFAULT_計画事業者番号);
            assertThat(sut.get計画事業者番号(), is(DbT3006KyotakuKeikakuJigyoshaSakuseiEntityGenerator.DEFAULT_計画事業者番号));
        }

        @Test
        public void 戻り値の委託先事業者番号は_設定した値と同じ委託先事業者番号を返す() {
            sut.set委託先事業者番号(DbT3006KyotakuKeikakuJigyoshaSakuseiEntityGenerator.DEFAULT_委託先事業者番号);
            assertThat(sut.get委託先事業者番号(), is(DbT3006KyotakuKeikakuJigyoshaSakuseiEntityGenerator.DEFAULT_委託先事業者番号));
        }

        @Test
        public void 戻り値の事業者変更年月日は_設定した値と同じ事業者変更年月日を返す() {
            sut.set事業者変更年月日(DbT3006KyotakuKeikakuJigyoshaSakuseiEntityGenerator.DEFAULT_事業者変更年月日);
            assertThat(sut.get事業者変更年月日(), is(DbT3006KyotakuKeikakuJigyoshaSakuseiEntityGenerator.DEFAULT_事業者変更年月日));
        }

        @Test
        public void 戻り値の事業者変更事由は_設定した値と同じ事業者変更事由を返す() {
            sut.set事業者変更事由(DbT3006KyotakuKeikakuJigyoshaSakuseiEntityGenerator.DEFAULT_事業者変更事由);
            assertThat(sut.get事業者変更事由(), is(DbT3006KyotakuKeikakuJigyoshaSakuseiEntityGenerator.DEFAULT_事業者変更事由));
        }
    }

    public static class getStateTest extends DbzTestBase {

        @Test
        public void 状態Addedの取得確認() {
            KyotakuKeikakuJigyoshaSakuseiModel sut = new KyotakuKeikakuJigyoshaSakuseiModel();

            assertThat(sut.getState(), is(EntityDataState.Added));
        }

        @Test
        public void 状態Modifinedの取得確認() {
            KyotakuKeikakuJigyoshaSakuseiModel sut = new KyotakuKeikakuJigyoshaSakuseiModel();
            sut.setEntity(DbT3006KyotakuKeikakuJigyoshaSakuseiEntityGenerator.createDbT3006KyotakuKeikakuJigyoshaSakuseiEntity());

            sut.getEntity().initializeMd5();

            // 主キー以外の項目を変更してください
//            sut.getEntity().setXXX(new XXX());
//            assertThat(sut.getState(), is(EntityDataState.Modified));
        }

        @Test
        public void 状態Unchangedの取得確認() {
            KyotakuKeikakuJigyoshaSakuseiModel sut = new KyotakuKeikakuJigyoshaSakuseiModel();
            sut.setEntity(DbT3006KyotakuKeikakuJigyoshaSakuseiEntityGenerator.createDbT3006KyotakuKeikakuJigyoshaSakuseiEntity());

            sut.getEntity().initializeMd5();

            assertThat(sut.getState(), is(EntityDataState.Unchanged));
        }

        @Test
        public void 状態Deletedの取得確認() {
            KyotakuKeikakuJigyoshaSakuseiModel sut = new KyotakuKeikakuJigyoshaSakuseiModel();
            sut.setEntity(DbT3006KyotakuKeikakuJigyoshaSakuseiEntityGenerator.createDbT3006KyotakuKeikakuJigyoshaSakuseiEntity());

            sut.getEntity().initializeMd5();

            sut.setDeletedState(true);

            assertThat(sut.getState(), is(EntityDataState.Deleted));
        }
    }
}
