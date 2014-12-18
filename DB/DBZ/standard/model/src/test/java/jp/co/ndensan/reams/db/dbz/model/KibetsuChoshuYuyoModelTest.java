/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.model;

import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT2007KibetsuChoshuYuyoEntityGenerator;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link KibetsuChoshuYuyoModel}のテストクラスです。
 *
 * @author LDNS 鄭雪双
 */
@RunWith(Enclosed.class)
public class KibetsuChoshuYuyoModelTest extends DbzTestBase {

    public static class getterSetterTest extends DbzTestBase {

        private static KibetsuChoshuYuyoModel sut;

        @BeforeClass
        public static void test() {
            sut = new KibetsuChoshuYuyoModel();
        }

        @Test
        public void 戻り値の調定年度は_設定した値と同じ調定年度を返す() {
            sut.set調定年度(DbT2007KibetsuChoshuYuyoEntityGenerator.DEFAULT_調定年度);
            assertThat(sut.get調定年度(), is(DbT2007KibetsuChoshuYuyoEntityGenerator.DEFAULT_調定年度));
        }

        @Test
        public void 戻り値の賦課年度は_設定した値と同じ賦課年度を返す() {
            sut.set賦課年度(DbT2007KibetsuChoshuYuyoEntityGenerator.DEFAULT_賦課年度);
            assertThat(sut.get賦課年度(), is(DbT2007KibetsuChoshuYuyoEntityGenerator.DEFAULT_賦課年度));
        }

        @Test
        public void 戻り値の通知書番号は_設定した値と同じ通知書番号を返す() {
            sut.set通知書番号(DbT2007KibetsuChoshuYuyoEntityGenerator.DEFAULT_通知書番号);
            assertThat(sut.get通知書番号(), is(DbT2007KibetsuChoshuYuyoEntityGenerator.DEFAULT_通知書番号));
        }

        @Test
        public void 戻り値の処理日時は_設定した値と同じ処理日時を返す() {
            sut.set処理日時(DbT2007KibetsuChoshuYuyoEntityGenerator.DEFAULT_処理日時);
            assertThat(sut.get処理日時(), is(DbT2007KibetsuChoshuYuyoEntityGenerator.DEFAULT_処理日時));
        }

        @Test
        public void 戻り値の徴収方法は_設定した値と同じ徴収方法を返す() {
            sut.set徴収方法(DbT2007KibetsuChoshuYuyoEntityGenerator.DEFAULT_徴収方法);
            assertThat(sut.get徴収方法(), is(DbT2007KibetsuChoshuYuyoEntityGenerator.DEFAULT_徴収方法));
        }

        @Test
        public void 戻り値の期は_設定した値と同じ期を返す() {
            sut.set期(DbT2007KibetsuChoshuYuyoEntityGenerator.DEFAULT_期);
            assertThat(sut.get期(), is(DbT2007KibetsuChoshuYuyoEntityGenerator.DEFAULT_期));
        }

        @Test
        public void 戻り値の徴収猶予開始年月日は_設定した値と同じ徴収猶予開始年月日を返す() {
            sut.set徴収猶予開始年月日(DbT2007KibetsuChoshuYuyoEntityGenerator.DEFAULT_徴収猶予開始年月日);
            assertThat(sut.get徴収猶予開始年月日(), is(DbT2007KibetsuChoshuYuyoEntityGenerator.DEFAULT_徴収猶予開始年月日));
        }

        @Test
        public void 戻り値の徴収猶予終了年月日は_設定した値と同じ徴収猶予終了年月日を返す() {
            sut.set徴収猶予終了年月日(DbT2007KibetsuChoshuYuyoEntityGenerator.DEFAULT_徴収猶予終了年月日);
            assertThat(sut.get徴収猶予終了年月日(), is(DbT2007KibetsuChoshuYuyoEntityGenerator.DEFAULT_徴収猶予終了年月日));
        }
    }

    public static class getStateTest extends DbzTestBase {

        @Test
        public void 状態Addedの取得確認() {
            KibetsuChoshuYuyoModel sut = new KibetsuChoshuYuyoModel();

            assertThat(sut.getState(), is(EntityDataState.Added));
        }

        @Test
        public void 状態Modifinedの取得確認() {
            KibetsuChoshuYuyoModel sut = new KibetsuChoshuYuyoModel();
            sut.setEntity(DbT2007KibetsuChoshuYuyoEntityGenerator.createDbT2007KibetsuChoshuYuyoEntity());

            sut.getEntity().initializeMd5();

            // 主キー以外の項目を変更してください
//            sut.getEntity().setXXX(new XXX());
//            assertThat(sut.getState(), is(EntityDataState.Modified));
        }

        @Test
        public void 状態Unchangedの取得確認() {
            KibetsuChoshuYuyoModel sut = new KibetsuChoshuYuyoModel();
            sut.setEntity(DbT2007KibetsuChoshuYuyoEntityGenerator.createDbT2007KibetsuChoshuYuyoEntity());

            sut.getEntity().initializeMd5();

            assertThat(sut.getState(), is(EntityDataState.Unchanged));
        }

        @Test
        public void 状態Deletedの取得確認() {
            KibetsuChoshuYuyoModel sut = new KibetsuChoshuYuyoModel();
            sut.setEntity(DbT2007KibetsuChoshuYuyoEntityGenerator.createDbT2007KibetsuChoshuYuyoEntity());

            sut.getEntity().initializeMd5();

            sut.setDeletedState(true);

            assertThat(sut.getState(), is(EntityDataState.Deleted));
        }
    }
}
