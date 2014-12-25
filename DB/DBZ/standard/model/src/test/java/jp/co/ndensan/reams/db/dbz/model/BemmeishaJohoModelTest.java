/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.model;

import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT7003BemmeishaJohoEntityGenerator;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link BemmeishaJohoModel}のテストクラスです。
 *
 * @author LDNS 宋昕沢
 */
@RunWith(Enclosed.class)
public class BemmeishaJohoModelTest extends DbzTestBase {

    public static class getterSetterTest extends DbzTestBase {

        private static BemmeishaJohoModel sut;

        @BeforeClass
        public static void test() {
            sut = new BemmeishaJohoModel();
        }

        @Test
        public void 戻り値の証記載保険者番号は_設定した値と同じ証記載保険者番号を返す() {
            sut.set証記載保険者番号(DbT7003BemmeishaJohoEntityGenerator.DEFAULT_証記載保険者番号);
            assertThat(sut.get証記載保険者番号(), is(DbT7003BemmeishaJohoEntityGenerator.DEFAULT_証記載保険者番号));
        }

        @Test
        public void 戻り値の識別コードは_設定した値と同じ識別コードを返す() {
            sut.set識別コード(DbT7003BemmeishaJohoEntityGenerator.DEFAULT_識別コード);
            assertThat(sut.get識別コード(), is(DbT7003BemmeishaJohoEntityGenerator.DEFAULT_識別コード));
        }

        @Test
        public void 戻り値の原処分被保険者番号は_設定した値と同じ原処分被保険者番号を返す() {
            sut.set原処分被保険者番号(DbT7003BemmeishaJohoEntityGenerator.DEFAULT_原処分被保険者番号);
            assertThat(sut.get原処分被保険者番号(), is(DbT7003BemmeishaJohoEntityGenerator.DEFAULT_原処分被保険者番号));
        }

        @Test
        public void 戻り値の審査請求届出日は_設定した値と同じ審査請求届出日を返す() {
            sut.set審査請求届出日(DbT7003BemmeishaJohoEntityGenerator.DEFAULT_審査請求届出日);
            assertThat(sut.get審査請求届出日(), is(DbT7003BemmeishaJohoEntityGenerator.DEFAULT_審査請求届出日));
        }

        @Test
        public void 戻り値の弁明書作成日は_設定した値と同じ弁明書作成日を返す() {
            sut.set弁明書作成日(DbT7003BemmeishaJohoEntityGenerator.DEFAULT_弁明書作成日);
            assertThat(sut.get弁明書作成日(), is(DbT7003BemmeishaJohoEntityGenerator.DEFAULT_弁明書作成日));
        }

        @Test
        public void 戻り値の弁明者枝番は_設定した値と同じ弁明者枝番を返す() {
            sut.set弁明者枝番(DbT7003BemmeishaJohoEntityGenerator.DEFAULT_弁明者枝番);
            assertThat(sut.get弁明者枝番(), is(DbT7003BemmeishaJohoEntityGenerator.DEFAULT_弁明者枝番));
        }

        @Test
        public void 戻り値の職員コードは_設定した値と同じ職員コードを返す() {
            sut.set職員コード(DbT7003BemmeishaJohoEntityGenerator.DEFAULT_職員コード);
            assertThat(sut.get職員コード(), is(DbT7003BemmeishaJohoEntityGenerator.DEFAULT_職員コード));
        }

        @Test
        public void 戻り値の部署コードは_設定した値と同じ部署コードを返す() {
            sut.set部署コード(DbT7003BemmeishaJohoEntityGenerator.DEFAULT_部署コード);
            assertThat(sut.get部署コード(), is(DbT7003BemmeishaJohoEntityGenerator.DEFAULT_部署コード));
        }

        @Test
        public void 戻り値の役職名は_設定した値と同じ役職名を返す() {
            sut.set役職名(DbT7003BemmeishaJohoEntityGenerator.DEFAULT_役職名);
            assertThat(sut.get役職名(), is(DbT7003BemmeishaJohoEntityGenerator.DEFAULT_役職名));
        }

        @Test
        public void 戻り値の弁明者氏名は_設定した値と同じ弁明者氏名を返す() {
            sut.set弁明者氏名(DbT7003BemmeishaJohoEntityGenerator.DEFAULT_弁明者氏名);
            assertThat(sut.get弁明者氏名(), is(DbT7003BemmeishaJohoEntityGenerator.DEFAULT_弁明者氏名));
        }
    }

    public static class getStateTest extends DbzTestBase {

        @Test
        public void 状態Addedの取得確認() {
            BemmeishaJohoModel sut = new BemmeishaJohoModel();

            assertThat(sut.getState(), is(EntityDataState.Added));
        }

        @Test
        public void 状態Modifinedの取得確認() {
            BemmeishaJohoModel sut = new BemmeishaJohoModel();
            sut.setEntity(DbT7003BemmeishaJohoEntityGenerator.createDbT7003BemmeishaJohoEntity());

            sut.getEntity().initializeMd5();

            //TODO  主キー以外の項目を変更してください
//            sut.getEntity().setXXX(new XXX());
//            assertThat(sut.getState(), is(EntityDataState.Modified));
        }

        @Test
        public void 状態Unchangedの取得確認() {
            BemmeishaJohoModel sut = new BemmeishaJohoModel();
            sut.setEntity(DbT7003BemmeishaJohoEntityGenerator.createDbT7003BemmeishaJohoEntity());

            sut.getEntity().initializeMd5();

            assertThat(sut.getState(), is(EntityDataState.Unchanged));
        }

        @Test
        public void 状態Deletedの取得確認() {
            BemmeishaJohoModel sut = new BemmeishaJohoModel();
            sut.setEntity(DbT7003BemmeishaJohoEntityGenerator.createDbT7003BemmeishaJohoEntity());

            sut.getEntity().initializeMd5();

            sut.setDeletedState(true);

            assertThat(sut.getState(), is(EntityDataState.Deleted));
        }
    }
}
