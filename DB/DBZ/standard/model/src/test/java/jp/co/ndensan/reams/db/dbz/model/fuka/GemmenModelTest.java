/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.model.fuka;

import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.fuka.GemmenChoshuYuyoSakuseiKubun;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.fuka.GemmenChoshuYuyoStateKubun;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ChoteiNendo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.FukaNendo;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT2004GemmenEntityGenerator;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link GemmenModel}のテストクラスです。
 *
 * @author LDNS 鄭雪双
 */
@RunWith(Enclosed.class)
public class GemmenModelTest extends DbzTestBase {

    public static class getterSetterTest extends DbzTestBase {

        private static GemmenModel sut;

        @BeforeClass
        public static void test() {
            sut = new GemmenModel();
        }

        @Test
        public void 戻り値の調定年度は_設定した値と同じ調定年度を返す() {
            sut.set調定年度(new ChoteiNendo(DbT2004GemmenEntityGenerator.DEFAULT_調定年度));
            assertThat(sut.get調定年度().value(), is(DbT2004GemmenEntityGenerator.DEFAULT_調定年度));
        }

        @Test
        public void 戻り値の賦課年度は_設定した値と同じ賦課年度を返す() {
            sut.set賦課年度(new FukaNendo(DbT2004GemmenEntityGenerator.DEFAULT_賦課年度));
            assertThat(sut.get賦課年度().value(), is(DbT2004GemmenEntityGenerator.DEFAULT_賦課年度));
        }

        @Test
        public void 戻り値の通知書番号は_設定した値と同じ通知書番号を返す() {
            sut.set通知書番号(DbT2004GemmenEntityGenerator.DEFAULT_通知書番号);
            assertThat(sut.get通知書番号(), is(DbT2004GemmenEntityGenerator.DEFAULT_通知書番号));
        }

        @Test
        public void 戻り値の処理日時は_設定した値と同じ処理日時を返す() {
            sut.set処理日時(DbT2004GemmenEntityGenerator.DEFAULT_処理日時);
            assertThat(sut.get処理日時(), is(DbT2004GemmenEntityGenerator.DEFAULT_処理日時));
        }

        @Test
        public void 戻り値の減免申請年月日は_設定した値と同じ減免申請年月日を返す() {
            sut.set減免申請年月日(DbT2004GemmenEntityGenerator.DEFAULT_減免申請年月日);
            assertThat(sut.get減免申請年月日(), is(DbT2004GemmenEntityGenerator.DEFAULT_減免申請年月日));
        }

        @Test
        public void 戻り値の減免決定年月日は_設定した値と同じ減免決定年月日を返す() {
            sut.set減免決定年月日(DbT2004GemmenEntityGenerator.DEFAULT_減免決定年月日);
            assertThat(sut.get減免決定年月日(), is(DbT2004GemmenEntityGenerator.DEFAULT_減免決定年月日));
        }

        @Test
        public void 戻り値の減免取消年月日は_設定した値と同じ減免取消年月日を返す() {
            sut.set減免取消年月日(DbT2004GemmenEntityGenerator.DEFAULT_減免取消年月日);
            assertThat(sut.get減免取消年月日(), is(DbT2004GemmenEntityGenerator.DEFAULT_減免取消年月日));
        }

        @Test
        public void 戻り値の減免状態区分は_設定した値と同じ減免状態区分を返す() {
            sut.set減免状態区分(GemmenChoshuYuyoStateKubun.toValue(DbT2004GemmenEntityGenerator.DEFAULT_減免状態区分));
            assertThat(sut.get減免状態区分().code(), is(DbT2004GemmenEntityGenerator.DEFAULT_減免状態区分));
        }

        @Test
        public void 戻り値の減免作成区分は_設定した値と同じ減免作成区分を返す() {
            sut.set減免作成区分(GemmenChoshuYuyoSakuseiKubun.toValue(DbT2004GemmenEntityGenerator.DEFAULT_減免作成区分));
            assertThat(sut.get減免作成区分().code(), is(DbT2004GemmenEntityGenerator.DEFAULT_減免作成区分));
        }

        @Test
        public void 戻り値の申請事由は_設定した値と同じ申請事由を返す() {
            sut.set申請事由(DbT2004GemmenEntityGenerator.DEFAULT_申請事由);
            assertThat(sut.get申請事由(), is(DbT2004GemmenEntityGenerator.DEFAULT_申請事由));
        }

        @Test
        public void 戻り値の減免種類は_設定した値と同じ減免種類を返す() {
            sut.set減免種類(DbT2004GemmenEntityGenerator.DEFAULT_減免種類);
            assertThat(sut.get減免種類(), is(DbT2004GemmenEntityGenerator.DEFAULT_減免種類));
        }

        @Test
        public void 戻り値の減免事由は_設定した値と同じ減免事由を返す() {
            sut.set減免事由(DbT2004GemmenEntityGenerator.DEFAULT_減免事由);
            assertThat(sut.get減免事由(), is(DbT2004GemmenEntityGenerator.DEFAULT_減免事由));
        }

        @Test
        public void 戻り値の減免取消種類は_設定した値と同じ減免取消種類を返す() {
            sut.set減免取消種類(DbT2004GemmenEntityGenerator.DEFAULT_減免取消種類);
            assertThat(sut.get減免取消種類(), is(DbT2004GemmenEntityGenerator.DEFAULT_減免取消種類));
        }

        @Test
        public void 戻り値の減免取消事由は_設定した値と同じ減免取消事由を返す() {
            sut.set減免取消事由(DbT2004GemmenEntityGenerator.DEFAULT_減免取消事由);
            assertThat(sut.get減免取消事由(), is(DbT2004GemmenEntityGenerator.DEFAULT_減免取消事由));
        }

        @Test
        public void 戻り値の申請減免額は_設定した値と同じ申請減免額を返す() {
            sut.set申請減免額(DbT2004GemmenEntityGenerator.DEFAULT_申請減免額);
            assertThat(sut.get申請減免額(), is(DbT2004GemmenEntityGenerator.DEFAULT_申請減免額));
        }

        @Test
        public void 戻り値の決定減免額は_設定した値と同じ決定減免額を返す() {
            sut.set決定減免額(DbT2004GemmenEntityGenerator.DEFAULT_決定減免額);
            assertThat(sut.get決定減免額(), is(DbT2004GemmenEntityGenerator.DEFAULT_決定減免額));
        }

        @Test
        public void 戻り値の取消減免額は_設定した値と同じ取消減免額を返す() {
            sut.set取消減免額(DbT2004GemmenEntityGenerator.DEFAULT_取消減免額);
            assertThat(sut.get取消減免額(), is(DbT2004GemmenEntityGenerator.DEFAULT_取消減免額));
        }
    }

    public static class getStateTest extends DbzTestBase {

        @Test
        public void 状態Addedの取得確認() {
            GemmenModel sut = new GemmenModel();

            assertThat(sut.getState(), is(EntityDataState.Added));
        }

        @Test
        public void 状態Modifinedの取得確認() {
            GemmenModel sut = new GemmenModel();
            sut.setEntity(DbT2004GemmenEntityGenerator.createDbT2004GemmenEntity());

            sut.getEntity().initializeMd5();

            sut.getEntity().setShinseiGemmenGaku(new Decimal(999));
            assertThat(sut.getState(), is(EntityDataState.Modified));
        }

        @Test
        public void 状態Unchangedの取得確認() {
            GemmenModel sut = new GemmenModel();
            sut.setEntity(DbT2004GemmenEntityGenerator.createDbT2004GemmenEntity());

            sut.getEntity().initializeMd5();

            assertThat(sut.getState(), is(EntityDataState.Unchanged));
        }

        @Test
        public void 状態Deletedの取得確認() {
            GemmenModel sut = new GemmenModel();
            sut.setEntity(DbT2004GemmenEntityGenerator.createDbT2004GemmenEntity());

            sut.getEntity().initializeMd5();

            sut.setDeletedState(true);

            assertThat(sut.getState(), is(EntityDataState.Deleted));
        }
    }
}
