/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.model;

import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT3005KyotakuKeikakuTodokedeEntityGenerator;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link KyotakuKeikakuTodokedeModel}のテストクラスです。
 *
 * @author LDNS 鄭雪双
 */
@RunWith(Enclosed.class)
public class KyotakuKeikakuTodokedeModelTest extends DbzTestBase {

    public static class getterSetterTest extends DbzTestBase {

        private static KyotakuKeikakuTodokedeModel sut;

        @BeforeClass
        public static void test() {
            sut = new KyotakuKeikakuTodokedeModel();
        }

        @Test
        public void 戻り値の被保険者番号は_設定した値と同じ被保険者番号を返す() {
            sut.set被保険者番号(DbT3005KyotakuKeikakuTodokedeEntityGenerator.DEFAULT_被保険者番号);
            assertThat(sut.get被保険者番号(), is(DbT3005KyotakuKeikakuTodokedeEntityGenerator.DEFAULT_被保険者番号));
        }

        @Test
        public void 戻り値の証記載保険者番号は_設定した値と同じ証記載保険者番号を返す() {
            sut.set証記載保険者番号(DbT3005KyotakuKeikakuTodokedeEntityGenerator.DEFAULT_証記載保険者番号);
            assertThat(sut.get証記載保険者番号(), is(DbT3005KyotakuKeikakuTodokedeEntityGenerator.DEFAULT_証記載保険者番号));
        }

        @Test
        public void 戻り値の識別コードは_設定した値と同じ識別コードを返す() {
            sut.set識別コード(DbT3005KyotakuKeikakuTodokedeEntityGenerator.DEFAULT_識別コード);
            assertThat(sut.get識別コード(), is(DbT3005KyotakuKeikakuTodokedeEntityGenerator.DEFAULT_識別コード));
        }

        @Test
        public void 戻り値の対象年月は_設定した値と同じ対象年月を返す() {
            sut.set対象年月(DbT3005KyotakuKeikakuTodokedeEntityGenerator.DEFAULT_対象年月);
            assertThat(sut.get対象年月(), is(DbT3005KyotakuKeikakuTodokedeEntityGenerator.DEFAULT_対象年月));
        }

        @Test
        public void 戻り値の処理日時は_設定した値と同じ処理日時を返す() {
            sut.set処理日時(DbT3005KyotakuKeikakuTodokedeEntityGenerator.DEFAULT_処理日時);
            assertThat(sut.get処理日時(), is(DbT3005KyotakuKeikakuTodokedeEntityGenerator.DEFAULT_処理日時));
        }

        @Test
        public void 戻り値の届出区分は_設定した値と同じ届出区分を返す() {
            sut.set届出区分(DbT3005KyotakuKeikakuTodokedeEntityGenerator.DEFAULT_届出区分);
            assertThat(sut.get届出区分(), is(DbT3005KyotakuKeikakuTodokedeEntityGenerator.DEFAULT_届出区分));
        }

        @Test
        public void 戻り値の届出年月日は_設定した値と同じ届出年月日を返す() {
            sut.set届出年月日(DbT3005KyotakuKeikakuTodokedeEntityGenerator.DEFAULT_届出年月日);
            assertThat(sut.get届出年月日(), is(DbT3005KyotakuKeikakuTodokedeEntityGenerator.DEFAULT_届出年月日));
        }

        @Test
        public void 戻り値の届出者氏名は_設定した値と同じ届出者氏名を返す() {
            sut.set届出者氏名(DbT3005KyotakuKeikakuTodokedeEntityGenerator.DEFAULT_届出者氏名);
            assertThat(sut.get届出者氏名(), is(DbT3005KyotakuKeikakuTodokedeEntityGenerator.DEFAULT_届出者氏名));
        }

        @Test
        public void 戻り値の届出者氏名カナは_設定した値と同じ届出者氏名カナを返す() {
            sut.set届出者氏名カナ(DbT3005KyotakuKeikakuTodokedeEntityGenerator.DEFAULT_届出者氏名カナ);
            assertThat(sut.get届出者氏名カナ(), is(DbT3005KyotakuKeikakuTodokedeEntityGenerator.DEFAULT_届出者氏名カナ));
        }

        @Test
        public void 戻り値の届出者郵便番号は_設定した値と同じ届出者郵便番号を返す() {
            sut.set届出者郵便番号(DbT3005KyotakuKeikakuTodokedeEntityGenerator.DEFAULT_届出者郵便番号);
            assertThat(sut.get届出者郵便番号(), is(DbT3005KyotakuKeikakuTodokedeEntityGenerator.DEFAULT_届出者郵便番号));
        }

        @Test
        public void 戻り値の届出者住所は_設定した値と同じ届出者住所を返す() {
            sut.set届出者住所(DbT3005KyotakuKeikakuTodokedeEntityGenerator.DEFAULT_届出者住所);
            assertThat(sut.get届出者住所(), is(DbT3005KyotakuKeikakuTodokedeEntityGenerator.DEFAULT_届出者住所));
        }

        @Test
        public void 戻り値の届出者電話番号は_設定した値と同じ届出者電話番号を返す() {
            sut.set届出者電話番号(DbT3005KyotakuKeikakuTodokedeEntityGenerator.DEFAULT_届出者電話番号);
            assertThat(sut.get届出者電話番号(), is(DbT3005KyotakuKeikakuTodokedeEntityGenerator.DEFAULT_届出者電話番号));
        }

        @Test
        public void 戻り値の届出者関係区分は_設定した値と同じ届出者関係区分を返す() {
            sut.set届出者関係区分(DbT3005KyotakuKeikakuTodokedeEntityGenerator.DEFAULT_届出者関係区分);
            assertThat(sut.get届出者関係区分(), is(DbT3005KyotakuKeikakuTodokedeEntityGenerator.DEFAULT_届出者関係区分));
        }

        @Test
        public void 戻り値の暫定区分は_設定した値と同じ暫定区分を返す() {
            sut.set暫定区分(DbT3005KyotakuKeikakuTodokedeEntityGenerator.DEFAULT_暫定区分);
            assertThat(sut.get暫定区分(), is(DbT3005KyotakuKeikakuTodokedeEntityGenerator.DEFAULT_暫定区分));
        }
    }

    public static class getStateTest extends DbzTestBase {

        @Test
        public void 状態Addedの取得確認() {
            KyotakuKeikakuTodokedeModel sut = new KyotakuKeikakuTodokedeModel();

            assertThat(sut.getState(), is(EntityDataState.Added));
        }

        @Test
        public void 状態Modifinedの取得確認() {
            KyotakuKeikakuTodokedeModel sut = new KyotakuKeikakuTodokedeModel();
            sut.setEntity(DbT3005KyotakuKeikakuTodokedeEntityGenerator.createDbT3005KyotakuKeikakuTodokedeEntity());

            sut.getEntity().initializeMd5();

            // 主キー以外の項目を変更してください
//            sut.getEntity().setXXX(new XXX());
//            assertThat(sut.getState(), is(EntityDataState.Modified));
        }

        @Test
        public void 状態Unchangedの取得確認() {
            KyotakuKeikakuTodokedeModel sut = new KyotakuKeikakuTodokedeModel();
            sut.setEntity(DbT3005KyotakuKeikakuTodokedeEntityGenerator.createDbT3005KyotakuKeikakuTodokedeEntity());

            sut.getEntity().initializeMd5();

            assertThat(sut.getState(), is(EntityDataState.Unchanged));
        }

        @Test
        public void 状態Deletedの取得確認() {
            KyotakuKeikakuTodokedeModel sut = new KyotakuKeikakuTodokedeModel();
            sut.setEntity(DbT3005KyotakuKeikakuTodokedeEntityGenerator.createDbT3005KyotakuKeikakuTodokedeEntity());

            sut.getEntity().initializeMd5();

            sut.setDeletedState(true);

            assertThat(sut.getState(), is(EntityDataState.Deleted));
        }
    }
}
