/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.model;

import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT7054KanrenHihokenshaNoEntityGenerator;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link KanrenHihokenshaNoModel}のテストクラスです。
 *
 * @author LDNS 宋文娟
 */
@RunWith(Enclosed.class)
public class KanrenHihokenshaNoModelTest extends DbzTestBase {

    public static class getterSetterTest extends DbzTestBase {

        private static KanrenHihokenshaNoModel sut;

        @BeforeClass
        public static void test() {
            sut = new KanrenHihokenshaNoModel();
        }

        @Test
        public void 戻り値の証記載保険者番号は_設定した値と同じ証記載保険者番号を返す() {
            sut.set証記載保険者番号(DbT7054KanrenHihokenshaNoEntityGenerator.DEFAULT_証記載保険者番号);
            assertThat(sut.get証記載保険者番号(), is(DbT7054KanrenHihokenshaNoEntityGenerator.DEFAULT_証記載保険者番号));
        }

        @Test
        public void 戻り値の最新被保険者番号は_設定した値と同じ最新被保険者番号を返す() {
            sut.set最新被保険者番号(DbT7054KanrenHihokenshaNoEntityGenerator.DEFAULT_最新被保険者番号);
            assertThat(sut.get最新被保険者番号(), is(DbT7054KanrenHihokenshaNoEntityGenerator.DEFAULT_最新被保険者番号));
        }

        @Test
        public void 戻り値の旧被保険者番号は_設定した値と同じ旧被保険者番号を返す() {
            sut.set旧被保険者番号(DbT7054KanrenHihokenshaNoEntityGenerator.DEFAULT_旧被保険者番号);
            assertThat(sut.get旧被保険者番号(), is(DbT7054KanrenHihokenshaNoEntityGenerator.DEFAULT_旧被保険者番号));
        }

        @Test
        public void 戻り値の識別コードは_設定した値と同じ識別コードを返す() {
            sut.set識別コード(DbT7054KanrenHihokenshaNoEntityGenerator.DEFAULT_識別コード);
            assertThat(sut.get識別コード(), is(DbT7054KanrenHihokenshaNoEntityGenerator.DEFAULT_識別コード));
        }
    }

    public static class getStateTest extends DbzTestBase {

        @Test
        public void 状態Addedの取得確認() {
            KanrenHihokenshaNoModel sut = new KanrenHihokenshaNoModel();

            assertThat(sut.getState(), is(EntityDataState.Added));
        }

       // @Test
        // public void 状態Modifinedの取得確認() {
        // KanrenHihokenshaNoModel sut = new KanrenHihokenshaNoModel();
        //sut.setEntity(DbT7054KanrenHihokenshaNoEntityGenerator.createDbT7054KanrenHihokenshaNoEntity());
        // sut.getEntity().initializeMd5();
        // TODO主キー以外の項目を変更してください
        //sut.getEntity().setXXX(new XXX());
        //assertThat(sut.getState(), is(EntityDataState.Modified));
        //}
        @Test
        public void 状態Unchangedの取得確認() {
            KanrenHihokenshaNoModel sut = new KanrenHihokenshaNoModel();
            sut.setEntity(DbT7054KanrenHihokenshaNoEntityGenerator.createDbT7054KanrenHihokenshaNoEntity());

            sut.getEntity().initializeMd5();

            assertThat(sut.getState(), is(EntityDataState.Unchanged));
        }

        @Test
        public void 状態Deletedの取得確認() {
            KanrenHihokenshaNoModel sut = new KanrenHihokenshaNoModel();
            sut.setEntity(DbT7054KanrenHihokenshaNoEntityGenerator.createDbT7054KanrenHihokenshaNoEntity());

            sut.getEntity().initializeMd5();

            sut.setDeletedState(true);

            assertThat(sut.getState(), is(EntityDataState.Deleted));
        }
    }
}
