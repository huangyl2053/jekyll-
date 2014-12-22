/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.model;

import jp.co.ndensan.reams.db.dbb.entity.basic.helper.DbT2003KibetsuEntityGenerator;
import jp.co.ndensan.reams.db.dbz.testhelper.DbbTestBase;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import org.junit.BeforeClass;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

/**
 * {@link KibetsuModel}のテストクラスです。
 *
 * @author N8156 宮本 康
 */
@RunWith(Enclosed.class)
public class KibetsuModelTest extends DbbTestBase {

    public static class getterSetterTest extends DbbTestBase {

        private static KibetsuModel sut;

        @BeforeClass
        public static void test() {
            sut = new KibetsuModel();
        }

        @Test
        public void 戻り値の調定年度は_設定した値と同じ調定年度を返す() {
            sut.set調定年度(DbT2003KibetsuEntityGenerator.DEFAULT_調定年度);
            assertThat(sut.get調定年度(), is(DbT2003KibetsuEntityGenerator.DEFAULT_調定年度));
        }

        @Test
        public void 戻り値の賦課年度は_設定した値と同じ賦課年度を返す() {
            sut.set賦課年度(DbT2003KibetsuEntityGenerator.DEFAULT_賦課年度);
            assertThat(sut.get賦課年度(), is(DbT2003KibetsuEntityGenerator.DEFAULT_賦課年度));
        }

        @Test
        public void 戻り値の通知書番号は_設定した値と同じ通知書番号を返す() {
            sut.set通知書番号(DbT2003KibetsuEntityGenerator.DEFAULT_通知書番号);
            assertThat(sut.get通知書番号(), is(DbT2003KibetsuEntityGenerator.DEFAULT_通知書番号));
        }

        @Test
        public void 戻り値の処理日時は_設定した値と同じ処理日時を返す() {
            sut.set処理日時(DbT2003KibetsuEntityGenerator.DEFAULT_処理日時);
            assertThat(sut.get処理日時(), is(DbT2003KibetsuEntityGenerator.DEFAULT_処理日時));
        }

        @Test
        public void 戻り値の徴収方法は_設定した値と同じ徴収方法を返す() {
            sut.set徴収方法(DbT2003KibetsuEntityGenerator.DEFAULT_徴収方法);
            assertThat(sut.get徴収方法(), is(DbT2003KibetsuEntityGenerator.DEFAULT_徴収方法));
        }

        @Test
        public void 戻り値の期は_設定した値と同じ期を返す() {
            sut.set期(DbT2003KibetsuEntityGenerator.DEFAULT_期);
            assertThat(sut.get期(), is(DbT2003KibetsuEntityGenerator.DEFAULT_期));
        }

        @Test
        public void 戻り値の調定IDは_設定した値と同じ調定IDを返す() {
            sut.set調定ID(DbT2003KibetsuEntityGenerator.DEFAULT_調定ID);
            assertThat(sut.get調定ID(), is(DbT2003KibetsuEntityGenerator.DEFAULT_調定ID));
        }
    }

    public static class getStateTest extends DbbTestBase {

        @Test
        public void 状態Addedの取得確認() {
            KibetsuModel sut = new KibetsuModel();

            assertThat(sut.getState(), is(EntityDataState.Added));
        }

        @Test
        public void 状態Modifinedの取得確認() {
            KibetsuModel sut = new KibetsuModel();
            sut.setEntity(DbT2003KibetsuEntityGenerator.createDbT2003KibetsuEntity());

            sut.getEntity().initializeMd5();
            sut.getEntity().setChoteiId(9999L);

            assertThat(sut.getState(), is(EntityDataState.Modified));
        }

        @Test
        public void 状態Unchangedの取得確認() {
            KibetsuModel sut = new KibetsuModel();
            sut.setEntity(DbT2003KibetsuEntityGenerator.createDbT2003KibetsuEntity());

            sut.getEntity().initializeMd5();

            assertThat(sut.getState(), is(EntityDataState.Unchanged));
        }

        @Test
        public void 状態Deletedの取得確認() {
            KibetsuModel sut = new KibetsuModel();
            sut.setEntity(DbT2003KibetsuEntityGenerator.createDbT2003KibetsuEntity());

            sut.getEntity().initializeMd5();

            sut.setDeletedState(true);

            assertThat(sut.getState(), is(EntityDataState.Deleted));
        }
    }
}
