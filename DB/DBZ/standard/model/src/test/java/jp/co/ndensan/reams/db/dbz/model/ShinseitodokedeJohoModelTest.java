/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.model;

import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT7053ShinseitodokedeJohoEntityGenerator;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link ShinseitodokedeJohoModel}のテストクラスです。
 *
 * @author LDNS 宋文娟
 */
@RunWith(Enclosed.class)
public class ShinseitodokedeJohoModelTest extends DbzTestBase {

    public static class getterSetterTest extends DbzTestBase {

        private static ShinseitodokedeJohoModel sut;

        @BeforeClass
        public static void test() {
            sut = new ShinseitodokedeJohoModel();
        }

        @Test
        public void 戻り値の証記載保険者番号は_設定した値と同じ証記載保険者番号を返す() {
            sut.set証記載保険者番号(DbT7053ShinseitodokedeJohoEntityGenerator.DEFAULT_証記載保険者番号);
            assertThat(sut.get証記載保険者番号(), is(DbT7053ShinseitodokedeJohoEntityGenerator.DEFAULT_証記載保険者番号));
        }

        @Test
        public void 戻り値の被保険者番号は_設定した値と同じ被保険者番号を返す() {
            sut.set被保険者番号(DbT7053ShinseitodokedeJohoEntityGenerator.DEFAULT_被保険者番号);
            assertThat(sut.get被保険者番号(), is(DbT7053ShinseitodokedeJohoEntityGenerator.DEFAULT_被保険者番号));
        }

        @Test
        public void 戻り値の申請届出年月日は_設定した値と同じ申請届出年月日を返す() {
            sut.set申請届出年月日(DbT7053ShinseitodokedeJohoEntityGenerator.DEFAULT_申請届出年月日);
            assertThat(sut.get申請届出年月日(), is(DbT7053ShinseitodokedeJohoEntityGenerator.DEFAULT_申請届出年月日));
        }

        @Test
        public void 戻り値の申請書管理番号は_設定した値と同じ申請書管理番号を返す() {
            sut.set申請書管理番号(DbT7053ShinseitodokedeJohoEntityGenerator.DEFAULT_申請書管理番号);
            assertThat(sut.get申請書管理番号(), is(DbT7053ShinseitodokedeJohoEntityGenerator.DEFAULT_申請書管理番号));
        }

        @Test
        public void 戻り値の申請届出種別コードは_設定した値と同じ申請届出種別コードを返す() {
            sut.set申請届出種別コード(DbT7053ShinseitodokedeJohoEntityGenerator.DEFAULT_申請届出種別コード);
            assertThat(sut.get申請届出種別コード(), is(DbT7053ShinseitodokedeJohoEntityGenerator.DEFAULT_申請届出種別コード));
        }

        @Test
        public void 戻り値の申請届出代行区分コードは_設定した値と同じ申請届出代行区分コードを返す() {
            sut.set申請届出代行区分コード(DbT7053ShinseitodokedeJohoEntityGenerator.DEFAULT_申請届出代行区分コード);
            assertThat(sut.get申請届出代行区分コード(), is(DbT7053ShinseitodokedeJohoEntityGenerator.DEFAULT_申請届出代行区分コード));
        }

        @Test
        public void 戻り値の申請届出者氏名は_設定した値と同じ申請届出者氏名を返す() {
            sut.set申請届出者氏名(DbT7053ShinseitodokedeJohoEntityGenerator.DEFAULT_申請届出者氏名);
            assertThat(sut.get申請届出者氏名(), is(DbT7053ShinseitodokedeJohoEntityGenerator.DEFAULT_申請届出者氏名));
        }

        @Test
        public void 戻り値の申請届出者氏名カナは_設定した値と同じ申請届出者氏名カナを返す() {
            sut.set申請届出者氏名カナ(DbT7053ShinseitodokedeJohoEntityGenerator.DEFAULT_申請届出者氏名カナ);
            assertThat(sut.get申請届出者氏名カナ(), is(DbT7053ShinseitodokedeJohoEntityGenerator.DEFAULT_申請届出者氏名カナ));
        }

        @Test
        public void 戻り値の申請届出者続柄コードは_設定した値と同じ申請届出者続柄コードを返す() {
            sut.set申請届出者続柄コード(DbT7053ShinseitodokedeJohoEntityGenerator.DEFAULT_申請届出者続柄コード);
            assertThat(sut.get申請届出者続柄コード(), is(DbT7053ShinseitodokedeJohoEntityGenerator.DEFAULT_申請届出者続柄コード));
        }

        @Test
        public void 戻り値の申請届出代行事業者番号は_設定した値と同じ申請届出代行事業者番号を返す() {
            sut.set申請届出代行事業者番号(DbT7053ShinseitodokedeJohoEntityGenerator.DEFAULT_申請届出代行事業者番号);
            assertThat(sut.get申請届出代行事業者番号(), is(DbT7053ShinseitodokedeJohoEntityGenerator.DEFAULT_申請届出代行事業者番号));
        }

        @Test
        public void 戻り値の事業者区分は_設定した値と同じ事業者区分を返す() {
            sut.set事業者区分(DbT7053ShinseitodokedeJohoEntityGenerator.DEFAULT_事業者区分);
            assertThat(sut.get事業者区分(), is(DbT7053ShinseitodokedeJohoEntityGenerator.DEFAULT_事業者区分));
        }

        @Test
        public void 戻り値の申請届出者郵便番号は_設定した値と同じ申請届出者郵便番号を返す() {
            sut.set申請届出者郵便番号(DbT7053ShinseitodokedeJohoEntityGenerator.DEFAULT_申請届出者郵便番号);
            assertThat(sut.get申請届出者郵便番号(), is(DbT7053ShinseitodokedeJohoEntityGenerator.DEFAULT_申請届出者郵便番号));
        }

        @Test
        public void 戻り値の申請届出者住所は_設定した値と同じ申請届出者住所を返す() {
            sut.set申請届出者住所(DbT7053ShinseitodokedeJohoEntityGenerator.DEFAULT_申請届出者住所);
            assertThat(sut.get申請届出者住所(), is(DbT7053ShinseitodokedeJohoEntityGenerator.DEFAULT_申請届出者住所));
        }

        @Test
        public void 戻り値の申請届出者電話番号は_設定した値と同じ申請届出者電話番号を返す() {
            sut.set申請届出者電話番号(DbT7053ShinseitodokedeJohoEntityGenerator.DEFAULT_申請届出者電話番号);
            assertThat(sut.get申請届出者電話番号(), is(DbT7053ShinseitodokedeJohoEntityGenerator.DEFAULT_申請届出者電話番号));
        }
    }

    public static class getStateTest extends DbzTestBase {

        @Test
        public void 状態Addedの取得確認() {
            ShinseitodokedeJohoModel sut = new ShinseitodokedeJohoModel();

            assertThat(sut.getState(), is(EntityDataState.Added));
        }

       // @Test
        // public void 状態Modifinedの取得確認() {
        // ShinseitodokedeJohoModel sut = new ShinseitodokedeJohoModel();
        //sut.setEntity(DbT7053ShinseitodokedeJohoEntityGenerator.createDbT7053ShinseitodokedeJohoEntity());
        // sut.getEntity().initializeMd5();
        // TODO主キー以外の項目を変更してください
        //sut.getEntity().setXXX(new XXX());
        //assertThat(sut.getState(), is(EntityDataState.Modified));
        //}
        @Test
        public void 状態Unchangedの取得確認() {
            ShinseitodokedeJohoModel sut = new ShinseitodokedeJohoModel();
            sut.setEntity(DbT7053ShinseitodokedeJohoEntityGenerator.createDbT7053ShinseitodokedeJohoEntity());

            sut.getEntity().initializeMd5();

            assertThat(sut.getState(), is(EntityDataState.Unchanged));
        }

        @Test
        public void 状態Deletedの取得確認() {
            ShinseitodokedeJohoModel sut = new ShinseitodokedeJohoModel();
            sut.setEntity(DbT7053ShinseitodokedeJohoEntityGenerator.createDbT7053ShinseitodokedeJohoEntity());

            sut.getEntity().initializeMd5();

            sut.setDeletedState(true);

            assertThat(sut.getState(), is(EntityDataState.Deleted));
        }
    }
}
