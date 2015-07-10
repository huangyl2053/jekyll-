/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.model;

import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT2008ShotokuEntityGenerator;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link ShotokuModel}のテストクラスです。
 *
 * @author LDNS 鄭雪双
 */
@RunWith(Enclosed.class)
public class ShotokuModelTest extends DbzTestBase {

    public static class getterSetterTest extends DbzTestBase {

        private static ShotokuModel sut;

        @BeforeClass
        public static void test() {
            sut = new ShotokuModel();
        }

        @Test
        public void 戻り値の所得年度は_設定した値と同じ所得年度を返す() {
            sut.set所得年度(DbT2008ShotokuEntityGenerator.DEFAULT_所得年度);
            assertThat(sut.get所得年度(), is(DbT2008ShotokuEntityGenerator.DEFAULT_所得年度));
        }

        @Test
        public void 戻り値の識別コードは_設定した値と同じ識別コードを返す() {
            sut.set識別コード(DbT2008ShotokuEntityGenerator.DEFAULT_識別コード);
            assertThat(sut.get識別コード(), is(DbT2008ShotokuEntityGenerator.DEFAULT_識別コード));
        }

        @Test
        public void 戻り値の履歴番号は_設定した値と同じ履歴番号を返す() {
            sut.set履歴番号(DbT2008ShotokuEntityGenerator.DEFAULT_履歴番号);
            assertThat(sut.get履歴番号(), is(DbT2008ShotokuEntityGenerator.DEFAULT_履歴番号));
        }

        @Test
        public void 戻り値の非課税区分_住民税減免前は_設定した値と同じ非課税区分_住民税減免前を返す() {
            sut.set非課税区分_住民税減免前(DbT2008ShotokuEntityGenerator.DEFAULT_非課税区分_住民税減免前);
            assertThat(sut.get非課税区分_住民税減免前(), is(DbT2008ShotokuEntityGenerator.DEFAULT_非課税区分_住民税減免前));
        }

        @Test
        public void 戻り値の非課税区分_住民税減免後は_設定した値と同じ非課税区分_住民税減免後を返す() {
            sut.set非課税区分_住民税減免後(DbT2008ShotokuEntityGenerator.DEFAULT_非課税区分_住民税減免後);
            assertThat(sut.get非課税区分_住民税減免後(), is(DbT2008ShotokuEntityGenerator.DEFAULT_非課税区分_住民税減免後));
        }

        @Test
        public void 戻り値の合計所得金額は_設定した値と同じ合計所得金額を返す() {
            sut.set合計所得金額(DbT2008ShotokuEntityGenerator.DEFAULT_合計所得金額);
            assertThat(sut.get合計所得金額(), is(DbT2008ShotokuEntityGenerator.DEFAULT_合計所得金額));
        }

        @Test
        public void 戻り値の公的年金収入額は_設定した値と同じ公的年金収入額を返す() {
            sut.set公的年金収入額(DbT2008ShotokuEntityGenerator.DEFAULT_公的年金収入額);
            assertThat(sut.get公的年金収入額(), is(DbT2008ShotokuEntityGenerator.DEFAULT_公的年金収入額));
        }

        @Test
        public void 戻り値の激変緩和措置区分は_設定した値と同じ激変緩和措置区分を返す() {
            sut.set激変緩和措置区分(DbT2008ShotokuEntityGenerator.DEFAULT_激変緩和措置区分);
            assertThat(sut.get激変緩和措置区分(), is(DbT2008ShotokuEntityGenerator.DEFAULT_激変緩和措置区分));
        }
    }

    public static class getStateTest extends DbzTestBase {

        @Test
        public void 状態Addedの取得確認() {
            ShotokuModel sut = new ShotokuModel();

            assertThat(sut.getState(), is(EntityDataState.Added));
        }

        @Test
        public void 状態Modifinedの取得確認() {
            ShotokuModel sut = new ShotokuModel();
            sut.setEntity(DbT2008ShotokuEntityGenerator.createDbT2008ShotokuEntity());

            sut.getEntity().initializeMd5();

            // 主キー以外の項目を変更してください
//            sut.getEntity().setXXX(new XXX());
//            assertThat(sut.getState(), is(EntityDataState.Modified));
        }

        @Test
        public void 状態Unchangedの取得確認() {
            ShotokuModel sut = new ShotokuModel();
            sut.setEntity(DbT2008ShotokuEntityGenerator.createDbT2008ShotokuEntity());

            sut.getEntity().initializeMd5();

            assertThat(sut.getState(), is(EntityDataState.Unchanged));
        }

        @Test
        public void 状態Deletedの取得確認() {
            ShotokuModel sut = new ShotokuModel();
            sut.setEntity(DbT2008ShotokuEntityGenerator.createDbT2008ShotokuEntity());

            sut.getEntity().initializeMd5();

            sut.setDeletedState(true);

            assertThat(sut.getState(), is(EntityDataState.Deleted));
        }
    }
}
