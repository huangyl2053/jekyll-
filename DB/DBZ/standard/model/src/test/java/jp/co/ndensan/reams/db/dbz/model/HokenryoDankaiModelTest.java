/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.model;

import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT2013HokenryoDankaiEntityGenerator;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import org.junit.BeforeClass;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

/**
 * {@link HokenryoDankaiModel}のテストクラスです。
 *
 * @author N8156 宮本 康
 */
@RunWith(Enclosed.class)
public class HokenryoDankaiModelTest extends DbzTestBase {

    public static class getterSetterTest extends DbzTestBase {

        private static HokenryoDankaiModel sut;

        @BeforeClass
        public static void test() {
            sut = new HokenryoDankaiModel();
        }

        @Test
        public void 戻り値の賦課年度は_設定した値と同じ賦課年度を返す() {
            sut.set賦課年度(DbT2013HokenryoDankaiEntityGenerator.DEFAULT_賦課年度);
            assertThat(sut.get賦課年度(), is(DbT2013HokenryoDankaiEntityGenerator.DEFAULT_賦課年度));
        }

        @Test
        public void 戻り値の段階インデックスは_設定した値と同じ段階インデックスを返す() {
            sut.set段階インデックス(DbT2013HokenryoDankaiEntityGenerator.DEFAULT_段階インデックス);
            assertThat(sut.get段階インデックス(), is(DbT2013HokenryoDankaiEntityGenerator.DEFAULT_段階インデックス));
        }

        @Test
        public void 戻り値のランク区分は_設定した値と同じランク区分を返す() {
            sut.setランク区分(DbT2013HokenryoDankaiEntityGenerator.DEFAULT_ランク区分);
            assertThat(sut.getランク区分(), is(DbT2013HokenryoDankaiEntityGenerator.DEFAULT_ランク区分));
        }

        @Test
        public void 戻り値の段階区分は_設定した値と同じ段階区分を返す() {
            sut.set段階区分(DbT2013HokenryoDankaiEntityGenerator.DEFAULT_段階区分);
            assertThat(sut.get段階区分(), is(DbT2013HokenryoDankaiEntityGenerator.DEFAULT_段階区分));
        }

        @Test
        public void 戻り値の保険料率は_設定した値と同じ保険料率を返す() {
            sut.set保険料率(DbT2013HokenryoDankaiEntityGenerator.DEFAULT_保険料率);
            assertThat(sut.get保険料率(), is(DbT2013HokenryoDankaiEntityGenerator.DEFAULT_保険料率));
        }

        @Test
        public void 戻り値の特例表記は_設定した値と同じ特例表記を返す() {
            sut.set特例表記(DbT2013HokenryoDankaiEntityGenerator.DEFAULT_特例表記);
            assertThat(sut.get特例表記(), is(DbT2013HokenryoDankaiEntityGenerator.DEFAULT_特例表記));
        }
    }

    public static class getStateTest extends DbzTestBase {

        @Test
        public void 状態Addedの取得確認() {
            HokenryoDankaiModel sut = new HokenryoDankaiModel();

            assertThat(sut.getState(), is(EntityDataState.Added));
        }

        @Test
        public void 状態Modifinedの取得確認() {
            HokenryoDankaiModel sut = new HokenryoDankaiModel();
            sut.setEntity(DbT2013HokenryoDankaiEntityGenerator.createDbT2013HokenryoDankaiEntity());

            sut.getEntity().initializeMd5();

            sut.getEntity().setHokenryoRitsu(Decimal.ZERO);

            assertThat(sut.getState(), is(EntityDataState.Modified));
        }

        @Test
        public void 状態Unchangedの取得確認() {
            HokenryoDankaiModel sut = new HokenryoDankaiModel();
            sut.setEntity(DbT2013HokenryoDankaiEntityGenerator.createDbT2013HokenryoDankaiEntity());

            sut.getEntity().initializeMd5();

            assertThat(sut.getState(), is(EntityDataState.Unchanged));
        }

        @Test
        public void 状態Deletedの取得確認() {
            HokenryoDankaiModel sut = new HokenryoDankaiModel();
            sut.setEntity(DbT2013HokenryoDankaiEntityGenerator.createDbT2013HokenryoDankaiEntity());

            sut.getEntity().initializeMd5();

            sut.setDeletedState(true);

            assertThat(sut.getState(), is(EntityDataState.Deleted));
        }
    }
}
