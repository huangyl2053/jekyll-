/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.model;

import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT2011RankJohoEntityGenerator;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import org.junit.BeforeClass;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

/**
 * {@link RankJohoModel}のテストクラスです。
 *
 * @author N8156 宮本 康
 */
@RunWith(Enclosed.class)
public class RankJohoModelTest extends DbzTestBase {

    public static class getterSetterTest extends DbzTestBase {

        private static RankJohoModel sut;

        @BeforeClass
        public static void test() {
            sut = new RankJohoModel();
        }

        @Test
        public void 戻り値の賦課年度は_設定した値と同じ賦課年度を返す() {
            sut.set賦課年度(DbT2011RankJohoEntityGenerator.DEFAULT_賦課年度);
            assertThat(sut.get賦課年度(), is(DbT2011RankJohoEntityGenerator.DEFAULT_賦課年度));
        }

        @Test
        public void 戻り値のランク区分は_設定した値と同じランク区分を返す() {
            sut.setランク区分(DbT2011RankJohoEntityGenerator.DEFAULT_ランク区分);
            assertThat(sut.getランク区分(), is(DbT2011RankJohoEntityGenerator.DEFAULT_ランク区分));
        }

        @Test
        public void 戻り値のランク名称は_設定した値と同じランク名称を返す() {
            sut.setランク名称(DbT2011RankJohoEntityGenerator.DEFAULT_ランク名称);
            assertThat(sut.getランク名称(), is(DbT2011RankJohoEntityGenerator.DEFAULT_ランク名称));
        }
    }

    public static class getStateTest extends DbzTestBase {

        @Test
        public void 状態Addedの取得確認() {
            RankJohoModel sut = new RankJohoModel();

            assertThat(sut.getState(), is(EntityDataState.Added));
        }

        @Test
        public void 状態Modifinedの取得確認() {
            RankJohoModel sut = new RankJohoModel();
            sut.setEntity(DbT2011RankJohoEntityGenerator.createDbT2011RankJohoEntity());

            sut.getEntity().initializeMd5();

            sut.getEntity().setRankName(RString.EMPTY);

            assertThat(sut.getState(), is(EntityDataState.Modified));
        }

        @Test
        public void 状態Unchangedの取得確認() {
            RankJohoModel sut = new RankJohoModel();
            sut.setEntity(DbT2011RankJohoEntityGenerator.createDbT2011RankJohoEntity());

            sut.getEntity().initializeMd5();

            assertThat(sut.getState(), is(EntityDataState.Unchanged));
        }

        @Test
        public void 状態Deletedの取得確認() {
            RankJohoModel sut = new RankJohoModel();
            sut.setEntity(DbT2011RankJohoEntityGenerator.createDbT2011RankJohoEntity());

            sut.getEntity().initializeMd5();

            sut.setDeletedState(true);

            assertThat(sut.getState(), is(EntityDataState.Deleted));
        }
    }
}
