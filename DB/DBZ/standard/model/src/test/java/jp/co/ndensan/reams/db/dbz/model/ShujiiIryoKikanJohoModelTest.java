/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.model;

import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT7011ShujiiIryoKikanJohoEntityGenerator;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link ShujiiIryoKikanJohoModel}のテストクラスです。
 *
 * @author LDNS 宋昕沢
 */
@RunWith(Enclosed.class)
public class ShujiiIryoKikanJohoModelTest extends DbzTestBase {

    public static class getterSetterTest extends DbzTestBase {

        private static ShujiiIryoKikanJohoModel sut;

        @BeforeClass
        public static void test() {
            sut = new ShujiiIryoKikanJohoModel();
        }

        @Test
        public void 戻り値の市町村コードは_設定した値と同じ市町村コードを返す() {
            sut.set市町村コード(DbT7011ShujiiIryoKikanJohoEntityGenerator.DEFAULT_市町村コード);
            assertThat(sut.get市町村コード(), is(DbT7011ShujiiIryoKikanJohoEntityGenerator.DEFAULT_市町村コード));
        }

        @Test
        public void 戻り値の介護医療機関コードは_設定した値と同じ介護医療機関コードを返す() {
            sut.set介護医療機関コード(DbT7011ShujiiIryoKikanJohoEntityGenerator.DEFAULT_介護医療機関コード);
            assertThat(sut.get介護医療機関コード(), is(DbT7011ShujiiIryoKikanJohoEntityGenerator.DEFAULT_介護医療機関コード));
        }

        @Test
        public void 戻り値の医療機関コードは_設定した値と同じ医療機関コードを返す() {
            sut.set医療機関コード(DbT7011ShujiiIryoKikanJohoEntityGenerator.DEFAULT_医療機関コード);
            assertThat(sut.get医療機関コード(), is(DbT7011ShujiiIryoKikanJohoEntityGenerator.DEFAULT_医療機関コード));
        }

        @Test
        public void 戻り値の医療機関の状況は_設定した値と同じ医療機関の状況を返す() {
            sut.set医療機関の状況(DbT7011ShujiiIryoKikanJohoEntityGenerator.DEFAULT_医療機関の状況);
            assertThat(sut.get医療機関の状況(), is(DbT7011ShujiiIryoKikanJohoEntityGenerator.DEFAULT_医療機関の状況));
        }

        @Test
        public void 戻り値の機関の区分コードは_設定した値と同じ機関の区分コードを返す() {
            sut.set機関の区分コード(DbT7011ShujiiIryoKikanJohoEntityGenerator.DEFAULT_機関の区分コード);
            assertThat(sut.get機関の区分コード(), is(DbT7011ShujiiIryoKikanJohoEntityGenerator.DEFAULT_機関の区分コード));
        }
    }

    public static class getStateTest extends DbzTestBase {

        @Test
        public void 状態Addedの取得確認() {
            ShujiiIryoKikanJohoModel sut = new ShujiiIryoKikanJohoModel();

            assertThat(sut.getState(), is(EntityDataState.Added));
        }

        @Test
        public void 状態Modifinedの取得確認() {
            ShujiiIryoKikanJohoModel sut = new ShujiiIryoKikanJohoModel();
            sut.setEntity(DbT7011ShujiiIryoKikanJohoEntityGenerator.createDbT7011ShujiiIryoKikanJohoEntity());

            sut.getEntity().initializeMd5();

            // TODO 主キー以外の項目を変更してください
//            sut.getEntity().setXXX(new XXX());
//            assertThat(sut.getState(), is(EntityDataState.Modified));
        }

        @Test
        public void 状態Unchangedの取得確認() {
            ShujiiIryoKikanJohoModel sut = new ShujiiIryoKikanJohoModel();
            sut.setEntity(DbT7011ShujiiIryoKikanJohoEntityGenerator.createDbT7011ShujiiIryoKikanJohoEntity());

            sut.getEntity().initializeMd5();

            assertThat(sut.getState(), is(EntityDataState.Unchanged));
        }

        @Test
        public void 状態Deletedの取得確認() {
            ShujiiIryoKikanJohoModel sut = new ShujiiIryoKikanJohoModel();
            sut.setEntity(DbT7011ShujiiIryoKikanJohoEntityGenerator.createDbT7011ShujiiIryoKikanJohoEntity());

            sut.getEntity().initializeMd5();

            sut.setDeletedState(true);

            assertThat(sut.getState(), is(EntityDataState.Deleted));
        }
    }
}
