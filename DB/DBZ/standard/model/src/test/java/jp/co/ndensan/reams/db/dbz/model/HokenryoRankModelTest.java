/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.model;

import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT2012HokenryoRankEntityGenerator;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import org.junit.BeforeClass;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

/**
 * {@link HokenryoRankModel}のテストクラスです。
 *
 * @author N8156 宮本 康
 */
@RunWith(Enclosed.class)
public class HokenryoRankModelTest extends DbzTestBase {

    public static class getterSetterTest extends DbzTestBase {

        private static HokenryoRankModel sut;

        @BeforeClass
        public static void test() {
            sut = new HokenryoRankModel();
        }

        @Test
        public void 戻り値の賦課年度は_設定した値と同じ賦課年度を返す() {
            sut.set賦課年度(DbT2012HokenryoRankEntityGenerator.DEFAULT_賦課年度);
            assertThat(sut.get賦課年度(), is(DbT2012HokenryoRankEntityGenerator.DEFAULT_賦課年度));
        }

        @Test
        public void 戻り値の市町村コードは_設定した値と同じ市町村コードを返す() {
            sut.set市町村コード(DbT2012HokenryoRankEntityGenerator.DEFAULT_市町村コード);
            assertThat(sut.get市町村コード(), is(DbT2012HokenryoRankEntityGenerator.DEFAULT_市町村コード));
        }

        @Test
        public void 戻り値のランク区分は_設定した値と同じランク区分を返す() {
            sut.setランク区分(DbT2012HokenryoRankEntityGenerator.DEFAULT_ランク区分);
            assertThat(sut.getランク区分(), is(DbT2012HokenryoRankEntityGenerator.DEFAULT_ランク区分));
        }

        @Test
        public void 戻り値の遡及年度は_設定した値と同じ遡及年度を返す() {
            sut.set遡及年度(DbT2012HokenryoRankEntityGenerator.DEFAULT_遡及年度);
            assertThat(sut.get遡及年度(), is(DbT2012HokenryoRankEntityGenerator.DEFAULT_遡及年度));
        }
    }

    public static class getStateTest extends DbzTestBase {

        @Test
        public void 状態Addedの取得確認() {
            HokenryoRankModel sut = new HokenryoRankModel();

            assertThat(sut.getState(), is(EntityDataState.Added));
        }

        @Test
        public void 状態Modifinedの取得確認() {
            HokenryoRankModel sut = new HokenryoRankModel();
            sut.setEntity(DbT2012HokenryoRankEntityGenerator.createDbT2012HokenryoRankEntity());

            sut.getEntity().initializeMd5();

            sut.getEntity().setSokyuNendo(FlexibleYear.MAX);

            assertThat(sut.getState(), is(EntityDataState.Modified));
        }

        @Test
        public void 状態Unchangedの取得確認() {
            HokenryoRankModel sut = new HokenryoRankModel();
            sut.setEntity(DbT2012HokenryoRankEntityGenerator.createDbT2012HokenryoRankEntity());

            sut.getEntity().initializeMd5();

            assertThat(sut.getState(), is(EntityDataState.Unchanged));
        }

        @Test
        public void 状態Deletedの取得確認() {
            HokenryoRankModel sut = new HokenryoRankModel();
            sut.setEntity(DbT2012HokenryoRankEntityGenerator.createDbT2012HokenryoRankEntity());

            sut.getEntity().initializeMd5();

            sut.setDeletedState(true);

            assertThat(sut.getState(), is(EntityDataState.Deleted));
        }
    }
}
