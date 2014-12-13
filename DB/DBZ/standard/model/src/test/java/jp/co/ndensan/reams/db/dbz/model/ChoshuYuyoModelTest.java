/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.model;

import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT2006ChoshuYuyoEntityGenerator;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link ChoshuYuyoModel}のテストクラスです。
 *
 * @author LDNS 鄭雪双
 */
@RunWith(Enclosed.class)
public class ChoshuYuyoModelTest extends DbzTestBase {

    public static class getterSetterTest extends DbzTestBase {

        private static ChoshuYuyoModel sut;

        @BeforeClass
        public static void test() {
            sut = new ChoshuYuyoModel();
        }

        @Test
        public void 戻り値の調定年度は_設定した値と同じ調定年度を返す() {
            sut.set調定年度(DbT2006ChoshuYuyoEntityGenerator.DEFAULT_調定年度);
            assertThat(sut.get調定年度(), is(DbT2006ChoshuYuyoEntityGenerator.DEFAULT_調定年度));
        }

        @Test
        public void 戻り値の賦課年度は_設定した値と同じ賦課年度を返す() {
            sut.set賦課年度(DbT2006ChoshuYuyoEntityGenerator.DEFAULT_賦課年度);
            assertThat(sut.get賦課年度(), is(DbT2006ChoshuYuyoEntityGenerator.DEFAULT_賦課年度));
        }

        @Test
        public void 戻り値の通知書番号は_設定した値と同じ通知書番号を返す() {
            sut.set通知書番号(DbT2006ChoshuYuyoEntityGenerator.DEFAULT_通知書番号);
            assertThat(sut.get通知書番号(), is(DbT2006ChoshuYuyoEntityGenerator.DEFAULT_通知書番号));
        }

        @Test
        public void 戻り値の処理日時は_設定した値と同じ処理日時を返す() {
            sut.set処理日時(DbT2006ChoshuYuyoEntityGenerator.DEFAULT_処理日時);
            assertThat(sut.get処理日時(), is(DbT2006ChoshuYuyoEntityGenerator.DEFAULT_処理日時));
        }

        @Test
        public void 戻り値の徴収猶予申請年月日は_設定した値と同じ徴収猶予申請年月日を返す() {
            sut.set徴収猶予申請年月日(DbT2006ChoshuYuyoEntityGenerator.DEFAULT_徴収猶予申請年月日);
            assertThat(sut.get徴収猶予申請年月日(), is(DbT2006ChoshuYuyoEntityGenerator.DEFAULT_徴収猶予申請年月日));
        }

        @Test
        public void 戻り値の徴収猶予決定年月日は_設定した値と同じ徴収猶予決定年月日を返す() {
            sut.set徴収猶予決定年月日(DbT2006ChoshuYuyoEntityGenerator.DEFAULT_徴収猶予決定年月日);
            assertThat(sut.get徴収猶予決定年月日(), is(DbT2006ChoshuYuyoEntityGenerator.DEFAULT_徴収猶予決定年月日));
        }

        @Test
        public void 戻り値の徴収猶予取消年月日は_設定した値と同じ徴収猶予取消年月日を返す() {
            sut.set徴収猶予取消年月日(DbT2006ChoshuYuyoEntityGenerator.DEFAULT_徴収猶予取消年月日);
            assertThat(sut.get徴収猶予取消年月日(), is(DbT2006ChoshuYuyoEntityGenerator.DEFAULT_徴収猶予取消年月日));
        }

        @Test
        public void 戻り値の徴収猶予状態区分は_設定した値と同じ徴収猶予状態区分を返す() {
            sut.set徴収猶予状態区分(DbT2006ChoshuYuyoEntityGenerator.DEFAULT_徴収猶予状態区分);
            assertThat(sut.get徴収猶予状態区分(), is(DbT2006ChoshuYuyoEntityGenerator.DEFAULT_徴収猶予状態区分));
        }

        @Test
        public void 戻り値の徴収猶予作成区分は_設定した値と同じ徴収猶予作成区分を返す() {
            sut.set徴収猶予作成区分(DbT2006ChoshuYuyoEntityGenerator.DEFAULT_徴収猶予作成区分);
            assertThat(sut.get徴収猶予作成区分(), is(DbT2006ChoshuYuyoEntityGenerator.DEFAULT_徴収猶予作成区分));
        }

        @Test
        public void 戻り値の申請事由は_設定した値と同じ申請事由を返す() {
            sut.set申請事由(DbT2006ChoshuYuyoEntityGenerator.DEFAULT_申請事由);
            assertThat(sut.get申請事由(), is(DbT2006ChoshuYuyoEntityGenerator.DEFAULT_申請事由));
        }

        @Test
        public void 戻り値の徴収猶予事由ｺｰﾄﾞは_設定した値と同じ徴収猶予事由ｺｰﾄﾞを返す() {
            sut.set徴収猶予事由ｺｰﾄﾞ(DbT2006ChoshuYuyoEntityGenerator.DEFAULT_徴収猶予事由ｺｰﾄﾞ);
            assertThat(sut.get徴収猶予事由ｺｰﾄﾞ(), is(DbT2006ChoshuYuyoEntityGenerator.DEFAULT_徴収猶予事由ｺｰﾄﾞ));
        }

        @Test
        public void 戻り値の徴収猶予事由は_設定した値と同じ徴収猶予事由を返す() {
            sut.set徴収猶予事由(DbT2006ChoshuYuyoEntityGenerator.DEFAULT_徴収猶予事由);
            assertThat(sut.get徴収猶予事由(), is(DbT2006ChoshuYuyoEntityGenerator.DEFAULT_徴収猶予事由));
        }

        @Test
        public void 戻り値の徴収猶予取消事由ｺｰﾄﾞは_設定した値と同じ徴収猶予取消事由ｺｰﾄﾞを返す() {
            sut.set徴収猶予取消事由ｺｰﾄﾞ(DbT2006ChoshuYuyoEntityGenerator.DEFAULT_徴収猶予取消事由ｺｰﾄﾞ);
            assertThat(sut.get徴収猶予取消事由ｺｰﾄﾞ(), is(DbT2006ChoshuYuyoEntityGenerator.DEFAULT_徴収猶予取消事由ｺｰﾄﾞ));
        }

        @Test
        public void 戻り値の徴収猶予取消事由は_設定した値と同じ徴収猶予取消事由を返す() {
            sut.set徴収猶予取消事由(DbT2006ChoshuYuyoEntityGenerator.DEFAULT_徴収猶予取消事由);
            assertThat(sut.get徴収猶予取消事由(), is(DbT2006ChoshuYuyoEntityGenerator.DEFAULT_徴収猶予取消事由));
        }
    }

    public static class getStateTest extends DbzTestBase {

        @Test
        public void 状態Addedの取得確認() {
            ChoshuYuyoModel sut = new ChoshuYuyoModel();

            assertThat(sut.getState(), is(EntityDataState.Added));
        }

        @Test
        public void 状態Modifinedの取得確認() {
            ChoshuYuyoModel sut = new ChoshuYuyoModel();
            sut.setEntity(DbT2006ChoshuYuyoEntityGenerator.createDbT2006ChoshuYuyoEntity());

            sut.getEntity().initializeMd5();

            // 主キー以外の項目を変更してください
//            sut.getEntity().setXXX(new XXX());
//            assertThat(sut.getState(), is(EntityDataState.Modified));
        }

        @Test
        public void 状態Unchangedの取得確認() {
            ChoshuYuyoModel sut = new ChoshuYuyoModel();
            sut.setEntity(DbT2006ChoshuYuyoEntityGenerator.createDbT2006ChoshuYuyoEntity());

            sut.getEntity().initializeMd5();

            assertThat(sut.getState(), is(EntityDataState.Unchanged));
        }

        @Test
        public void 状態Deletedの取得確認() {
            ChoshuYuyoModel sut = new ChoshuYuyoModel();
            sut.setEntity(DbT2006ChoshuYuyoEntityGenerator.createDbT2006ChoshuYuyoEntity());

            sut.getEntity().initializeMd5();

            sut.setDeletedState(true);

            assertThat(sut.getState(), is(EntityDataState.Deleted));
        }
    }
}
