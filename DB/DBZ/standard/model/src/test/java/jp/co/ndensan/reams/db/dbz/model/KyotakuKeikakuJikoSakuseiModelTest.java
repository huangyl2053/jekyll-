/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.model;

import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT3007KyotakuKeikakuJikoSakuseiEntityGenerator;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import static org.hamcrest.CoreMatchers.is;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.BeforeClass;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link KyotakuKeikakuJikoSakuseiModel}のテストクラスです。
 *
 * @author LDNS 鄭雪双
 */
@RunWith(Enclosed.class)
public class KyotakuKeikakuJikoSakuseiModelTest extends DbzTestBase {

    public static class getterSetterTest extends DbzTestBase {

        private static KyotakuKeikakuJikoSakuseiModel sut;

        @BeforeClass
        public static void test() {
            sut = new KyotakuKeikakuJikoSakuseiModel();
        }

        @Test
        public void 戻り値の被保険者番号は_設定した値と同じ被保険者番号を返す() {
            sut.set被保険者番号(DbT3007KyotakuKeikakuJikoSakuseiEntityGenerator.DEFAULT_被保険者番号);
            assertThat(sut.get被保険者番号(), is(DbT3007KyotakuKeikakuJikoSakuseiEntityGenerator.DEFAULT_被保険者番号));
        }

        @Test
        public void 戻り値の証記載保険者番号は_設定した値と同じ証記載保険者番号を返す() {
            sut.set証記載保険者番号(DbT3007KyotakuKeikakuJikoSakuseiEntityGenerator.DEFAULT_証記載保険者番号);
            assertThat(sut.get証記載保険者番号(), is(DbT3007KyotakuKeikakuJikoSakuseiEntityGenerator.DEFAULT_証記載保険者番号));
        }

        @Test
        public void 戻り値の識別コードは_設定した値と同じ識別コードを返す() {
            sut.set識別コード(DbT3007KyotakuKeikakuJikoSakuseiEntityGenerator.DEFAULT_識別コード);
            assertThat(sut.get識別コード(), is(DbT3007KyotakuKeikakuJikoSakuseiEntityGenerator.DEFAULT_識別コード));
        }

        @Test
        public void 戻り値の対象年月は_設定した値と同じ対象年月を返す() {
            sut.set対象年月(DbT3007KyotakuKeikakuJikoSakuseiEntityGenerator.DEFAULT_対象年月);
            assertThat(sut.get対象年月(), is(DbT3007KyotakuKeikakuJikoSakuseiEntityGenerator.DEFAULT_対象年月));
        }

        @Test
        public void 戻り値の処理日時は_設定した値と同じ処理日時を返す() {
            sut.set処理日時(DbT3007KyotakuKeikakuJikoSakuseiEntityGenerator.DEFAULT_処理日時);
            assertThat(sut.get処理日時(), is(DbT3007KyotakuKeikakuJikoSakuseiEntityGenerator.DEFAULT_処理日時));
        }

        @Test
        public void 戻り値の居宅_総合事業区分は_設定した値と同じ居宅_総合事業区分を返す() {
            sut.set居宅_総合事業区分(DbT3007KyotakuKeikakuJikoSakuseiEntityGenerator.DEFAULT_居宅_総合事業区分);
            assertThat(sut.get居宅_総合事業区分(), is(DbT3007KyotakuKeikakuJikoSakuseiEntityGenerator.DEFAULT_居宅_総合事業区分));
        }

        @Test
        public void 戻り値の適用開始年月日は_設定した値と同じ適用開始年月日を返す() {
            sut.set適用開始年月日(DbT3007KyotakuKeikakuJikoSakuseiEntityGenerator.DEFAULT_適用開始年月日);
            assertThat(sut.get適用開始年月日(), is(DbT3007KyotakuKeikakuJikoSakuseiEntityGenerator.DEFAULT_適用開始年月日));
        }

        @Test
        public void 戻り値の適用終了年月日は_設定した値と同じ適用終了年月日を返す() {
            sut.set適用終了年月日(DbT3007KyotakuKeikakuJikoSakuseiEntityGenerator.DEFAULT_適用終了年月日);
            assertThat(sut.get適用終了年月日(), is(DbT3007KyotakuKeikakuJikoSakuseiEntityGenerator.DEFAULT_適用終了年月日));
        }

        @Test
        public void 戻り値の計画作成年月日は_設定した値と同じ計画作成年月日を返す() {
            sut.set計画作成年月日(DbT3007KyotakuKeikakuJikoSakuseiEntityGenerator.DEFAULT_計画作成年月日);
            assertThat(sut.get計画作成年月日(), is(DbT3007KyotakuKeikakuJikoSakuseiEntityGenerator.DEFAULT_計画作成年月日));
        }

        @Test
        public void 戻り値の計画変更年月日は_設定した値と同じ計画変更年月日を返す() {
            sut.set計画変更年月日(DbT3007KyotakuKeikakuJikoSakuseiEntityGenerator.DEFAULT_計画変更年月日);
            assertThat(sut.get計画変更年月日(), is(DbT3007KyotakuKeikakuJikoSakuseiEntityGenerator.DEFAULT_計画変更年月日));
        }

        @Test
        public void 戻り値の計画変更事由は_設定した値と同じ計画変更事由を返す() {
            sut.set計画変更事由(DbT3007KyotakuKeikakuJikoSakuseiEntityGenerator.DEFAULT_計画変更事由);
            assertThat(sut.get計画変更事由(), is(DbT3007KyotakuKeikakuJikoSakuseiEntityGenerator.DEFAULT_計画変更事由));
        }
    }

    public static class getStateTest extends DbzTestBase {

        @Test
        public void 状態Addedの取得確認() {
            KyotakuKeikakuJikoSakuseiModel sut = new KyotakuKeikakuJikoSakuseiModel();

            assertThat(sut.getState(), is(EntityDataState.Added));
        }

        @Test
        public void 状態Modifinedの取得確認() {
            KyotakuKeikakuJikoSakuseiModel sut = new KyotakuKeikakuJikoSakuseiModel();
            sut.setEntity(DbT3007KyotakuKeikakuJikoSakuseiEntityGenerator.createDbT3007KyotakuKeikakuJikoSakuseiEntity());

            sut.getEntity().initializeMd5();

            // 主キー以外の項目を変更してください
//            sut.getEntity().setXXX(new XXX());
//            assertThat(sut.getState(), is(EntityDataState.Modified));
        }

        @Test
        public void 状態Unchangedの取得確認() {
            KyotakuKeikakuJikoSakuseiModel sut = new KyotakuKeikakuJikoSakuseiModel();
            sut.setEntity(DbT3007KyotakuKeikakuJikoSakuseiEntityGenerator.createDbT3007KyotakuKeikakuJikoSakuseiEntity());

            sut.getEntity().initializeMd5();

            assertThat(sut.getState(), is(EntityDataState.Unchanged));
        }

        @Test
        public void 状態Deletedの取得確認() {
            KyotakuKeikakuJikoSakuseiModel sut = new KyotakuKeikakuJikoSakuseiModel();
            sut.setEntity(DbT3007KyotakuKeikakuJikoSakuseiEntityGenerator.createDbT3007KyotakuKeikakuJikoSakuseiEntity());

            sut.getEntity().initializeMd5();

            sut.setDeletedState(true);

            assertThat(sut.getState(), is(EntityDataState.Deleted));
        }
    }
}
