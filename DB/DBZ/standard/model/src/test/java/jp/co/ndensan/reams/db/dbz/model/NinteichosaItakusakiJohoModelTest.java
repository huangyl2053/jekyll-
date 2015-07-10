/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.model;

import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT7010NinteichosaItakusakiJohoEntityGenerator;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link NinteichosaItakusakiJohoModel}のテストクラスです。
 *
 * @author LDNS 宋昕沢
 */
@RunWith(Enclosed.class)
public class NinteichosaItakusakiJohoModelTest extends DbzTestBase {

    public static class getterSetterTest extends DbzTestBase {

        private static NinteichosaItakusakiJohoModel sut;

        @BeforeClass
        public static void test() {
            sut = new NinteichosaItakusakiJohoModel();
        }

        @Test
        public void 戻り値の市町村コードは_設定した値と同じ市町村コードを返す() {
            sut.set市町村コード(DbT7010NinteichosaItakusakiJohoEntityGenerator.DEFAULT_市町村コード);
            assertThat(sut.get市町村コード(), is(DbT7010NinteichosaItakusakiJohoEntityGenerator.DEFAULT_市町村コード));
        }

        @Test
        public void 戻り値の介護事業者番号は_設定した値と同じ介護事業者番号を返す() {
            sut.set介護事業者番号(DbT7010NinteichosaItakusakiJohoEntityGenerator.DEFAULT_介護事業者番号);
            assertThat(sut.get介護事業者番号(), is(DbT7010NinteichosaItakusakiJohoEntityGenerator.DEFAULT_介護事業者番号));
        }

        @Test
        public void 戻り値の事業者番号は_設定した値と同じ事業者番号を返す() {
            sut.set事業者番号(DbT7010NinteichosaItakusakiJohoEntityGenerator.DEFAULT_事業者番号);
            assertThat(sut.get事業者番号(), is(DbT7010NinteichosaItakusakiJohoEntityGenerator.DEFAULT_事業者番号));
        }

        @Test
        public void 戻り値の介護事業者状況は_設定した値と同じ介護事業者状況を返す() {
            sut.set介護事業者状況(DbT7010NinteichosaItakusakiJohoEntityGenerator.DEFAULT_介護事業者状況);
            assertThat(sut.get介護事業者状況(), is(DbT7010NinteichosaItakusakiJohoEntityGenerator.DEFAULT_介護事業者状況));
        }

        @Test
        public void 戻り値の調査委託区分コードは_設定した値と同じ調査委託区分コードを返す() {
            sut.set調査委託区分コード(DbT7010NinteichosaItakusakiJohoEntityGenerator.DEFAULT_調査委託区分コード);
            assertThat(sut.get調査委託区分コード(), is(DbT7010NinteichosaItakusakiJohoEntityGenerator.DEFAULT_調査委託区分コード));
        }

        @Test
        public void 戻り値の割付定員は_設定した値と同じ割付定員を返す() {
            sut.set割付定員(DbT7010NinteichosaItakusakiJohoEntityGenerator.DEFAULT_割付定員);
            assertThat(sut.get割付定員(), is(DbT7010NinteichosaItakusakiJohoEntityGenerator.DEFAULT_割付定員));
        }

        @Test
        public void 戻り値の割付地区は_設定した値と同じ割付地区を返す() {
            sut.set割付地区(DbT7010NinteichosaItakusakiJohoEntityGenerator.DEFAULT_割付地区);
            assertThat(sut.get割付地区(), is(DbT7010NinteichosaItakusakiJohoEntityGenerator.DEFAULT_割付地区));
        }

        @Test
        public void 戻り値の機関の区分コードは_設定した値と同じ機関の区分コードを返す() {
            sut.set機関の区分コード(DbT7010NinteichosaItakusakiJohoEntityGenerator.DEFAULT_機関の区分コード);
            assertThat(sut.get機関の区分コード(), is(DbT7010NinteichosaItakusakiJohoEntityGenerator.DEFAULT_機関の区分コード));
        }
    }

    public static class getStateTest extends DbzTestBase {

        @Test
        public void 状態Addedの取得確認() {
            NinteichosaItakusakiJohoModel sut = new NinteichosaItakusakiJohoModel();

            assertThat(sut.getState(), is(EntityDataState.Added));
        }

        @Test
        public void 状態Modifinedの取得確認() {
            NinteichosaItakusakiJohoModel sut = new NinteichosaItakusakiJohoModel();
            sut.setEntity(DbT7010NinteichosaItakusakiJohoEntityGenerator.createDbT7010NinteichosaItakusakiJohoEntity());

            sut.getEntity().initializeMd5();

            // TODO 主キー以外の項目を変更してください
//            sut.getEntity().setXXX(new XXX());
//            assertThat(sut.getState(), is(EntityDataState.Modified));
        }

        @Test
        public void 状態Unchangedの取得確認() {
            NinteichosaItakusakiJohoModel sut = new NinteichosaItakusakiJohoModel();
            sut.setEntity(DbT7010NinteichosaItakusakiJohoEntityGenerator.createDbT7010NinteichosaItakusakiJohoEntity());

            sut.getEntity().initializeMd5();

            assertThat(sut.getState(), is(EntityDataState.Unchanged));
        }

        @Test
        public void 状態Deletedの取得確認() {
            NinteichosaItakusakiJohoModel sut = new NinteichosaItakusakiJohoModel();
            sut.setEntity(DbT7010NinteichosaItakusakiJohoEntityGenerator.createDbT7010NinteichosaItakusakiJohoEntity());

            sut.getEntity().initializeMd5();

            sut.setDeletedState(true);

            assertThat(sut.getState(), is(EntityDataState.Deleted));
        }
    }
}
