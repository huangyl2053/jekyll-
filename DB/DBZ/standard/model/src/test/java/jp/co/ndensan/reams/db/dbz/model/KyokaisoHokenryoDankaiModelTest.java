/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.model;

import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT1007KyokaisoHokenryoDankaiEntityGenerator;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link KyokaisoHokenryoDankaiModel}のテストクラスです。
 *
 * @author LDNS 鄭雪双
 */
@RunWith(Enclosed.class)
public class KyokaisoHokenryoDankaiModelTest extends DbzTestBase {

    public static class getterSetterTest extends DbzTestBase {

        private static KyokaisoHokenryoDankaiModel sut;

        @BeforeClass
        public static void test() {
            sut = new KyokaisoHokenryoDankaiModel();
        }

        @Test
        public void 戻り値の証記載保険者番号は_設定した値と同じ証記載保険者番号を返す() {
            sut.set証記載保険者番号(DbT1007KyokaisoHokenryoDankaiEntityGenerator.DEFAULT_証記載保険者番号);
            assertThat(sut.get証記載保険者番号(), is(DbT1007KyokaisoHokenryoDankaiEntityGenerator.DEFAULT_証記載保険者番号));
        }

        @Test
        public void 戻り値の被保険者番号は_設定した値と同じ被保険者番号を返す() {
            sut.set被保険者番号(DbT1007KyokaisoHokenryoDankaiEntityGenerator.DEFAULT_被保険者番号);
            assertThat(sut.get被保険者番号(), is(DbT1007KyokaisoHokenryoDankaiEntityGenerator.DEFAULT_被保険者番号));
        }

        @Test
        public void 戻り値の処理日時は_設定した値と同じ処理日時を返す() {
            sut.set処理日時(DbT1007KyokaisoHokenryoDankaiEntityGenerator.DEFAULT_処理日時);
            assertThat(sut.get処理日時(), is(DbT1007KyokaisoHokenryoDankaiEntityGenerator.DEFAULT_処理日時));
        }

        @Test
        public void 戻り値の適用開始年月は_設定した値と同じ適用開始年月を返す() {
            sut.set適用開始年月(DbT1007KyokaisoHokenryoDankaiEntityGenerator.DEFAULT_適用開始年月);
            assertThat(sut.get適用開始年月(), is(DbT1007KyokaisoHokenryoDankaiEntityGenerator.DEFAULT_適用開始年月));
        }

        @Test
        public void 戻り値の適用終了年月は_設定した値と同じ適用終了年月を返す() {
            sut.set適用終了年月(DbT1007KyokaisoHokenryoDankaiEntityGenerator.DEFAULT_適用終了年月);
            assertThat(sut.get適用終了年月(), is(DbT1007KyokaisoHokenryoDankaiEntityGenerator.DEFAULT_適用終了年月));
        }

        @Test
        public void 戻り値の保険料納付減額後保険料段階は_設定した値と同じ保険料納付減額後保険料段階を返す() {
            sut.set保険料納付減額後保険料段階(DbT1007KyokaisoHokenryoDankaiEntityGenerator.DEFAULT_保険料納付減額後保険料段階);
            assertThat(sut.get保険料納付減額後保険料段階(), is(DbT1007KyokaisoHokenryoDankaiEntityGenerator.DEFAULT_保険料納付減額後保険料段階));
        }
    }

    public static class getStateTest extends DbzTestBase {

        @Test
        public void 状態Addedの取得確認() {
            KyokaisoHokenryoDankaiModel sut = new KyokaisoHokenryoDankaiModel();

            assertThat(sut.getState(), is(EntityDataState.Added));
        }

        @Test
        public void 状態Modifinedの取得確認() {
            KyokaisoHokenryoDankaiModel sut = new KyokaisoHokenryoDankaiModel();
            sut.setEntity(DbT1007KyokaisoHokenryoDankaiEntityGenerator.createDbT1007KyokaisoHokenryoDankaiEntity());

            sut.getEntity().initializeMd5();

            // 主キー以外の項目を変更してください
//            sut.getEntity().setXXX(new XXX());
//            assertThat(sut.getState(), is(EntityDataState.Modified));
        }

        @Test
        public void 状態Unchangedの取得確認() {
            KyokaisoHokenryoDankaiModel sut = new KyokaisoHokenryoDankaiModel();
            sut.setEntity(DbT1007KyokaisoHokenryoDankaiEntityGenerator.createDbT1007KyokaisoHokenryoDankaiEntity());

            sut.getEntity().initializeMd5();

            assertThat(sut.getState(), is(EntityDataState.Unchanged));
        }

        @Test
        public void 状態Deletedの取得確認() {
            KyokaisoHokenryoDankaiModel sut = new KyokaisoHokenryoDankaiModel();
            sut.setEntity(DbT1007KyokaisoHokenryoDankaiEntityGenerator.createDbT1007KyokaisoHokenryoDankaiEntity());

            sut.getEntity().initializeMd5();

            sut.setDeletedState(true);

            assertThat(sut.getState(), is(EntityDataState.Deleted));
        }
    }
}
