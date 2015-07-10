/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.model;

import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT7013ChosainJohoEntityGenerator;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link ChosainJohoModel}のテストクラスです。
 *
 * @author LDNS 宋昕沢
 */
@RunWith(Enclosed.class)
public class ChosainJohoModelTest extends DbzTestBase {

    public static class getterSetterTest extends DbzTestBase {

        private static ChosainJohoModel sut;

        @BeforeClass
        public static void test() {
            sut = new ChosainJohoModel();
        }

        @Test
        public void 戻り値の市町村コードは_設定した値と同じ市町村コードを返す() {
            sut.set市町村コード(DbT7013ChosainJohoEntityGenerator.DEFAULT_市町村コード);
            assertThat(sut.get市町村コード(), is(DbT7013ChosainJohoEntityGenerator.DEFAULT_市町村コード));
        }

        @Test
        public void 戻り値の介護事業者番号は_設定した値と同じ介護事業者番号を返す() {
            sut.set介護事業者番号(DbT7013ChosainJohoEntityGenerator.DEFAULT_介護事業者番号);
            assertThat(sut.get介護事業者番号(), is(DbT7013ChosainJohoEntityGenerator.DEFAULT_介護事業者番号));
        }

        @Test
        public void 戻り値の介護調査員番号は_設定した値と同じ介護調査員番号を返す() {
            sut.set介護調査員番号(DbT7013ChosainJohoEntityGenerator.DEFAULT_介護調査員番号);
            assertThat(sut.get介護調査員番号(), is(DbT7013ChosainJohoEntityGenerator.DEFAULT_介護調査員番号));
        }

        @Test
        public void 戻り値の事業者番号は_設定した値と同じ事業者番号を返す() {
            sut.set事業者番号(DbT7013ChosainJohoEntityGenerator.DEFAULT_事業者番号);
            assertThat(sut.get事業者番号(), is(DbT7013ChosainJohoEntityGenerator.DEFAULT_事業者番号));
        }

        @Test
        public void 戻り値の介護調査員状況は_設定した値と同じ介護調査員状況を返す() {
            sut.set介護調査員状況(DbT7013ChosainJohoEntityGenerator.DEFAULT_介護調査員状況);
            assertThat(sut.get介護調査員状況(), is(DbT7013ChosainJohoEntityGenerator.DEFAULT_介護調査員状況));
        }

        @Test
        public void 戻り値の調査員氏名は_設定した値と同じ調査員氏名を返す() {
            sut.set調査員氏名(DbT7013ChosainJohoEntityGenerator.DEFAULT_調査員氏名);
            assertThat(sut.get調査員氏名(), is(DbT7013ChosainJohoEntityGenerator.DEFAULT_調査員氏名));
        }

        @Test
        public void 戻り値の調査員氏名カナは_設定した値と同じ調査員氏名カナを返す() {
            sut.set調査員氏名カナ(DbT7013ChosainJohoEntityGenerator.DEFAULT_調査員氏名カナ);
            assertThat(sut.get調査員氏名カナ(), is(DbT7013ChosainJohoEntityGenerator.DEFAULT_調査員氏名カナ));
        }

        @Test
        public void 戻り値の性別は_設定した値と同じ性別を返す() {
            sut.set性別(DbT7013ChosainJohoEntityGenerator.DEFAULT_性別);
            assertThat(sut.get性別(), is(DbT7013ChosainJohoEntityGenerator.DEFAULT_性別));
        }

        @Test
        public void 戻り値の調査員資格コードは_設定した値と同じ調査員資格コードを返す() {
            sut.set調査員資格コード(DbT7013ChosainJohoEntityGenerator.DEFAULT_調査員資格コード);
            assertThat(sut.get調査員資格コード(), is(DbT7013ChosainJohoEntityGenerator.DEFAULT_調査員資格コード));
        }

        @Test
        public void 戻り値の地区コードは_設定した値と同じ地区コードを返す() {
            sut.set地区コード(DbT7013ChosainJohoEntityGenerator.DEFAULT_地区コード);
            assertThat(sut.get地区コード(), is(DbT7013ChosainJohoEntityGenerator.DEFAULT_地区コード));
        }

        @Test
        public void 戻り値の郵便番号は_設定した値と同じ郵便番号を返す() {
            sut.set郵便番号(DbT7013ChosainJohoEntityGenerator.DEFAULT_郵便番号);
            assertThat(sut.get郵便番号(), is(DbT7013ChosainJohoEntityGenerator.DEFAULT_郵便番号));
        }

        @Test
        public void 戻り値の住所は_設定した値と同じ住所を返す() {
            sut.set住所(DbT7013ChosainJohoEntityGenerator.DEFAULT_住所);
            assertThat(sut.get住所(), is(DbT7013ChosainJohoEntityGenerator.DEFAULT_住所));
        }

        @Test
        public void 戻り値の電話番号は_設定した値と同じ電話番号を返す() {
            sut.set電話番号(DbT7013ChosainJohoEntityGenerator.DEFAULT_電話番号);
            assertThat(sut.get電話番号(), is(DbT7013ChosainJohoEntityGenerator.DEFAULT_電話番号));
        }
    }

    public static class getStateTest extends DbzTestBase {

        @Test
        public void 状態Addedの取得確認() {
            ChosainJohoModel sut = new ChosainJohoModel();

            assertThat(sut.getState(), is(EntityDataState.Added));
        }

        @Test
        public void 状態Modifinedの取得確認() {
            ChosainJohoModel sut = new ChosainJohoModel();
            sut.setEntity(DbT7013ChosainJohoEntityGenerator.createDbT7013ChosainJohoEntity());

            sut.getEntity().initializeMd5();

            //TODO  主キー以外の項目を変更してください
//            sut.getEntity().setXXX(new XXX());
//            assertThat(sut.getState(), is(EntityDataState.Modified));
        }

        @Test
        public void 状態Unchangedの取得確認() {
            ChosainJohoModel sut = new ChosainJohoModel();
            sut.setEntity(DbT7013ChosainJohoEntityGenerator.createDbT7013ChosainJohoEntity());

            sut.getEntity().initializeMd5();

            assertThat(sut.getState(), is(EntityDataState.Unchanged));
        }

        @Test
        public void 状態Deletedの取得確認() {
            ChosainJohoModel sut = new ChosainJohoModel();
            sut.setEntity(DbT7013ChosainJohoEntityGenerator.createDbT7013ChosainJohoEntity());

            sut.getEntity().initializeMd5();

            sut.setDeletedState(true);

            assertThat(sut.getState(), is(EntityDataState.Deleted));
        }
    }
}
