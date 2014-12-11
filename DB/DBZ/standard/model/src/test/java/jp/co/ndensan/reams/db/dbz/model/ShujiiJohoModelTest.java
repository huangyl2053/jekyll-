/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.model;

import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT7012ShujiiJohoEntityGenerator;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link ShujiiJohoModel}のテストクラスです。
 *
 * @author LDNS 宋昕沢
 */
@RunWith(Enclosed.class)
public class ShujiiJohoModelTest extends DbzTestBase {

    public static class getterSetterTest extends DbzTestBase {

        private static ShujiiJohoModel sut;

        @BeforeClass
        public static void test() {
            sut = new ShujiiJohoModel();
        }

        @Test
        public void 戻り値の市町村コードは_設定した値と同じ市町村コードを返す() {
            sut.set市町村コード(DbT7012ShujiiJohoEntityGenerator.DEFAULT_市町村コード);
            assertThat(sut.get市町村コード(), is(DbT7012ShujiiJohoEntityGenerator.DEFAULT_市町村コード));
        }

        @Test
        public void 戻り値の介護医療機関コードは_設定した値と同じ介護医療機関コードを返す() {
            sut.set介護医療機関コード(DbT7012ShujiiJohoEntityGenerator.DEFAULT_介護医療機関コード);
            assertThat(sut.get介護医療機関コード(), is(DbT7012ShujiiJohoEntityGenerator.DEFAULT_介護医療機関コード));
        }

        @Test
        public void 戻り値の介護医師コードは_設定した値と同じ介護医師コードを返す() {
            sut.set介護医師コード(DbT7012ShujiiJohoEntityGenerator.DEFAULT_介護医師コード);
            assertThat(sut.get介護医師コード(), is(DbT7012ShujiiJohoEntityGenerator.DEFAULT_介護医師コード));
        }

        @Test
        public void 戻り値の医療機関コードは_設定した値と同じ医療機関コードを返す() {
            sut.set医療機関コード(DbT7012ShujiiJohoEntityGenerator.DEFAULT_医療機関コード);
            assertThat(sut.get医療機関コード(), is(DbT7012ShujiiJohoEntityGenerator.DEFAULT_医療機関コード));
        }

        @Test
        public void 戻り値の医師コードは_設定した値と同じ医師コードを返す() {
            sut.set医師コード(DbT7012ShujiiJohoEntityGenerator.DEFAULT_医師コード);
            assertThat(sut.get医師コード(), is(DbT7012ShujiiJohoEntityGenerator.DEFAULT_医師コード));
        }

        @Test
        public void 戻り値の医師の状況は_設定した値と同じ医師の状況を返す() {
            sut.set医師の状況(DbT7012ShujiiJohoEntityGenerator.DEFAULT_医師の状況);
            assertThat(sut.get医師の状況(), is(DbT7012ShujiiJohoEntityGenerator.DEFAULT_医師の状況));
        }

        @Test
        public void 戻り値の郵便番号は_設定した値と同じ郵便番号を返す() {
            sut.set郵便番号(DbT7012ShujiiJohoEntityGenerator.DEFAULT_郵便番号);
            assertThat(sut.get郵便番号(), is(DbT7012ShujiiJohoEntityGenerator.DEFAULT_郵便番号));
        }

        @Test
        public void 戻り値の住所は_設定した値と同じ住所を返す() {
            sut.set住所(DbT7012ShujiiJohoEntityGenerator.DEFAULT_住所);
            assertThat(sut.get住所(), is(DbT7012ShujiiJohoEntityGenerator.DEFAULT_住所));
        }

        @Test
        public void 戻り値の電話番号は_設定した値と同じ電話番号を返す() {
            sut.set電話番号(DbT7012ShujiiJohoEntityGenerator.DEFAULT_電話番号);
            assertThat(sut.get電話番号(), is(DbT7012ShujiiJohoEntityGenerator.DEFAULT_電話番号));
        }

        @Test
        public void 戻り値のFAX番号は_設定した値と同じFAX番号を返す() {
            sut.setFAX番号(DbT7012ShujiiJohoEntityGenerator.DEFAULT_FAX番号);
            assertThat(sut.getFAX番号(), is(DbT7012ShujiiJohoEntityGenerator.DEFAULT_FAX番号));
        }
    }

    public static class getStateTest extends DbzTestBase {

        @Test
        public void 状態Addedの取得確認() {
            ShujiiJohoModel sut = new ShujiiJohoModel();

            assertThat(sut.getState(), is(EntityDataState.Added));
        }

        @Test
        public void 状態Modifinedの取得確認() {
            ShujiiJohoModel sut = new ShujiiJohoModel();
            sut.setEntity(DbT7012ShujiiJohoEntityGenerator.createDbT7012ShujiiJohoEntity());

            sut.getEntity().initializeMd5();

            // TODO 主キー以外の項目を変更してください
//            sut.getEntity().setXXX(new XXX());
//            assertThat(sut.getState(), is(EntityDataState.Modified));
        }

        @Test
        public void 状態Unchangedの取得確認() {
            ShujiiJohoModel sut = new ShujiiJohoModel();
            sut.setEntity(DbT7012ShujiiJohoEntityGenerator.createDbT7012ShujiiJohoEntity());

            sut.getEntity().initializeMd5();

            assertThat(sut.getState(), is(EntityDataState.Unchanged));
        }

        @Test
        public void 状態Deletedの取得確認() {
            ShujiiJohoModel sut = new ShujiiJohoModel();
            sut.setEntity(DbT7012ShujiiJohoEntityGenerator.createDbT7012ShujiiJohoEntity());

            sut.getEntity().initializeMd5();

            sut.setDeletedState(true);

            assertThat(sut.getState(), is(EntityDataState.Deleted));
        }
    }
}
