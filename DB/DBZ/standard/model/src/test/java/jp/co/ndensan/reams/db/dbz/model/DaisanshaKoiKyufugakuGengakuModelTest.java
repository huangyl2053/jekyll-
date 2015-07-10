/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.model;

import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT3081DaisanshaKoiKyufugakuGengakuEntityGenerator;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link DaisanshaKoiKyufugakuGengakuModel}のテストクラスです。
 *
 * @author LDNS 宋昕沢
 */
@RunWith(Enclosed.class)
public class DaisanshaKoiKyufugakuGengakuModelTest extends DbzTestBase {

    public static class getterSetterTest extends DbzTestBase {

        private static DaisanshaKoiKyufugakuGengakuModel sut;

        @BeforeClass
        public static void test() {
            sut = new DaisanshaKoiKyufugakuGengakuModel();
        }

        @Test
        public void 戻り値の被保険者番号は_設定した値と同じ被保険者番号を返す() {
            sut.set被保険者番号(DbT3081DaisanshaKoiKyufugakuGengakuEntityGenerator.DEFAULT_被保険者番号);
            assertThat(sut.get被保険者番号(), is(DbT3081DaisanshaKoiKyufugakuGengakuEntityGenerator.DEFAULT_被保険者番号));
        }

        @Test
        public void 戻り値の第三者行為届出管理番号は_設定した値と同じ第三者行為届出管理番号を返す() {
            sut.set第三者行為届出管理番号(DbT3081DaisanshaKoiKyufugakuGengakuEntityGenerator.DEFAULT_第三者行為届出管理番号);
            assertThat(sut.get第三者行為届出管理番号(), is(DbT3081DaisanshaKoiKyufugakuGengakuEntityGenerator.DEFAULT_第三者行為届出管理番号));
        }

        @Test
        public void 戻り値の処理日時は_設定した値と同じ処理日時を返す() {
            sut.set処理日時(DbT3081DaisanshaKoiKyufugakuGengakuEntityGenerator.DEFAULT_処理日時);
            assertThat(sut.get処理日時(), is(DbT3081DaisanshaKoiKyufugakuGengakuEntityGenerator.DEFAULT_処理日時));
        }

        @Test
        public void 戻り値の減額対象金額は_設定した値と同じ減額対象金額を返す() {
            sut.set減額対象金額(DbT3081DaisanshaKoiKyufugakuGengakuEntityGenerator.DEFAULT_減額対象金額);
            assertThat(sut.get減額対象金額(), is(DbT3081DaisanshaKoiKyufugakuGengakuEntityGenerator.DEFAULT_減額対象金額));
        }

        @Test
        public void 戻り値の給付額減額期間開始年月日は_設定した値と同じ給付額減額期間開始年月日を返す() {
            sut.set給付額減額期間開始年月日(DbT3081DaisanshaKoiKyufugakuGengakuEntityGenerator.DEFAULT_給付額減額期間開始年月日);
            assertThat(sut.get給付額減額期間開始年月日(), is(DbT3081DaisanshaKoiKyufugakuGengakuEntityGenerator.DEFAULT_給付額減額期間開始年月日));
        }

        @Test
        public void 戻り値の給付額減額期間終了年月日は_設定した値と同じ給付額減額期間終了年月日を返す() {
            sut.set給付額減額期間終了年月日(DbT3081DaisanshaKoiKyufugakuGengakuEntityGenerator.DEFAULT_給付額減額期間終了年月日);
            assertThat(sut.get給付額減額期間終了年月日(), is(DbT3081DaisanshaKoiKyufugakuGengakuEntityGenerator.DEFAULT_給付額減額期間終了年月日));
        }
    }

    public static class getStateTest extends DbzTestBase {

        @Test
        public void 状態Addedの取得確認() {
            DaisanshaKoiKyufugakuGengakuModel sut = new DaisanshaKoiKyufugakuGengakuModel();

            assertThat(sut.getState(), is(EntityDataState.Added));
        }

        @Test
        public void 状態Modifinedの取得確認() {
            DaisanshaKoiKyufugakuGengakuModel sut = new DaisanshaKoiKyufugakuGengakuModel();
            sut.setEntity(DbT3081DaisanshaKoiKyufugakuGengakuEntityGenerator.createDbT3081DaisanshaKoiKyufugakuGengakuEntity());

            sut.getEntity().initializeMd5();

            //TODO  主キー以外の項目を変更してください
//            sut.getEntity().setXXX(new XXX());
//            assertThat(sut.getState(), is(EntityDataState.Modified));
        }

        @Test
        public void 状態Unchangedの取得確認() {
            DaisanshaKoiKyufugakuGengakuModel sut = new DaisanshaKoiKyufugakuGengakuModel();
            sut.setEntity(DbT3081DaisanshaKoiKyufugakuGengakuEntityGenerator.createDbT3081DaisanshaKoiKyufugakuGengakuEntity());

            sut.getEntity().initializeMd5();

            assertThat(sut.getState(), is(EntityDataState.Unchanged));
        }

        @Test
        public void 状態Deletedの取得確認() {
            DaisanshaKoiKyufugakuGengakuModel sut = new DaisanshaKoiKyufugakuGengakuModel();
            sut.setEntity(DbT3081DaisanshaKoiKyufugakuGengakuEntityGenerator.createDbT3081DaisanshaKoiKyufugakuGengakuEntity());

            sut.getEntity().initializeMd5();

            sut.setDeletedState(true);

            assertThat(sut.getState(), is(EntityDataState.Deleted));
        }
    }
}
