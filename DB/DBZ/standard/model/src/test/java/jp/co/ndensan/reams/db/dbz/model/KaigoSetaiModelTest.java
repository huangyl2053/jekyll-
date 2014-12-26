/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.model;

import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT7014KaigoSetaiEntityGenerator;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link KaigoSetaiModel}のテストクラスです。
 *
 * @author LDNS 宋昕沢
 */
@RunWith(Enclosed.class)
public class KaigoSetaiModelTest extends DbzTestBase {

    public static class getterSetterTest extends DbzTestBase {

        private static KaigoSetaiModel sut;

        @BeforeClass
        public static void test() {
            sut = new KaigoSetaiModel();
        }

        @Test
        public void 戻り値の被保険者番号は_設定した値と同じ被保険者番号を返す() {
            sut.set被保険者番号(DbT7014KaigoSetaiEntityGenerator.DEFAULT_被保険者番号);
            assertThat(sut.get被保険者番号(), is(DbT7014KaigoSetaiEntityGenerator.DEFAULT_被保険者番号));
        }

        @Test
        public void 戻り値の世帯基準年月日は_設定した値と同じ世帯基準年月日を返す() {
            sut.set世帯基準年月日(DbT7014KaigoSetaiEntityGenerator.DEFAULT_世帯基準年月日);
            assertThat(sut.get世帯基準年月日(), is(DbT7014KaigoSetaiEntityGenerator.DEFAULT_世帯基準年月日));
        }

        @Test
        public void 戻り値の連番は_設定した値と同じ連番を返す() {
            sut.set連番(DbT7014KaigoSetaiEntityGenerator.DEFAULT_連番);
            assertThat(sut.get連番(), is(DbT7014KaigoSetaiEntityGenerator.DEFAULT_連番));
        }

        @Test
        public void 戻り値の処理日時は_設定した値と同じ処理日時を返す() {
            sut.set処理日時(DbT7014KaigoSetaiEntityGenerator.DEFAULT_処理日時);
            assertThat(sut.get処理日時(), is(DbT7014KaigoSetaiEntityGenerator.DEFAULT_処理日時));
        }

        @Test
        public void 戻り値の世帯員識別コードは_設定した値と同じ世帯員識別コードを返す() {
            sut.set世帯員識別コード(DbT7014KaigoSetaiEntityGenerator.DEFAULT_世帯員識別コード);
            assertThat(sut.get世帯員識別コード(), is(DbT7014KaigoSetaiEntityGenerator.DEFAULT_世帯員識別コード));
        }
    }

    public static class getStateTest extends DbzTestBase {

        @Test
        public void 状態Addedの取得確認() {
            KaigoSetaiModel sut = new KaigoSetaiModel();

            assertThat(sut.getState(), is(EntityDataState.Added));
        }

        @Test
        public void 状態Modifinedの取得確認() {
            KaigoSetaiModel sut = new KaigoSetaiModel();
            sut.setEntity(DbT7014KaigoSetaiEntityGenerator.createDbT7014KaigoSetaiEntity());

            sut.getEntity().initializeMd5();

            // TODO 主キー以外の項目を変更してください
//            sut.getEntity().setXXX(new XXX());
//            assertThat(sut.getState(), is(EntityDataState.Modified));
        }

        @Test
        public void 状態Unchangedの取得確認() {
            KaigoSetaiModel sut = new KaigoSetaiModel();
            sut.setEntity(DbT7014KaigoSetaiEntityGenerator.createDbT7014KaigoSetaiEntity());

            sut.getEntity().initializeMd5();

            assertThat(sut.getState(), is(EntityDataState.Unchanged));
        }

        @Test
        public void 状態Deletedの取得確認() {
            KaigoSetaiModel sut = new KaigoSetaiModel();
            sut.setEntity(DbT7014KaigoSetaiEntityGenerator.createDbT7014KaigoSetaiEntity());

            sut.getEntity().initializeMd5();

            sut.setDeletedState(true);

            assertThat(sut.getState(), is(EntityDataState.Deleted));
        }
    }
}
