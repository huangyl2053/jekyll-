/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.model;

import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT3098TandokuJoseikinKyufuShinseiEntityGenerator;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link TandokuJoseikinKyufuShinseiModel}のテストクラスです。
 *
 * @author LDNS 宋昕沢
 */
@RunWith(Enclosed.class)
public class TandokuJoseikinKyufuShinseiModelTest extends DbzTestBase {

    public static class getterSetterTest extends DbzTestBase {

        private static TandokuJoseikinKyufuShinseiModel sut;

        @BeforeClass
        public static void test() {
            sut = new TandokuJoseikinKyufuShinseiModel();
        }

        @Test
        public void 戻り値の被保険者番号は_設定した値と同じ被保険者番号を返す() {
            sut.set被保険者番号(DbT3098TandokuJoseikinKyufuShinseiEntityGenerator.DEFAULT_被保険者番号);
            assertThat(sut.get被保険者番号(), is(DbT3098TandokuJoseikinKyufuShinseiEntityGenerator.DEFAULT_被保険者番号));
        }

        @Test
        public void 戻り値の受付年月日は_設定した値と同じ受付年月日を返す() {
            sut.set受付年月日(DbT3098TandokuJoseikinKyufuShinseiEntityGenerator.DEFAULT_受付年月日);
            assertThat(sut.get受付年月日(), is(DbT3098TandokuJoseikinKyufuShinseiEntityGenerator.DEFAULT_受付年月日));
        }

        @Test
        public void 戻り値の処理日時は_設定した値と同じ処理日時を返す() {
            sut.set処理日時(DbT3098TandokuJoseikinKyufuShinseiEntityGenerator.DEFAULT_処理日時);
            assertThat(sut.get処理日時(), is(DbT3098TandokuJoseikinKyufuShinseiEntityGenerator.DEFAULT_処理日時));
        }

        @Test
        public void 戻り値の申請年月日は_設定した値と同じ申請年月日を返す() {
            sut.set申請年月日(DbT3098TandokuJoseikinKyufuShinseiEntityGenerator.DEFAULT_申請年月日);
            assertThat(sut.get申請年月日(), is(DbT3098TandokuJoseikinKyufuShinseiEntityGenerator.DEFAULT_申請年月日));
        }

        @Test
        public void 戻り値の申請者区分は_設定した値と同じ申請者区分を返す() {
            sut.set申請者区分(DbT3098TandokuJoseikinKyufuShinseiEntityGenerator.DEFAULT_申請者区分);
            assertThat(sut.get申請者区分(), is(DbT3098TandokuJoseikinKyufuShinseiEntityGenerator.DEFAULT_申請者区分));
        }

        @Test
        public void 戻り値の申請代行事業者番号は_設定した値と同じ申請代行事業者番号を返す() {
            sut.set申請代行事業者番号(DbT3098TandokuJoseikinKyufuShinseiEntityGenerator.DEFAULT_申請代行事業者番号);
            assertThat(sut.get申請代行事業者番号(), is(DbT3098TandokuJoseikinKyufuShinseiEntityGenerator.DEFAULT_申請代行事業者番号));
        }

        @Test
        public void 戻り値の事業者区分は_設定した値と同じ事業者区分を返す() {
            sut.set事業者区分(DbT3098TandokuJoseikinKyufuShinseiEntityGenerator.DEFAULT_事業者区分);
            assertThat(sut.get事業者区分(), is(DbT3098TandokuJoseikinKyufuShinseiEntityGenerator.DEFAULT_事業者区分));
        }

        @Test
        public void 戻り値の申請者郵便番号は_設定した値と同じ申請者郵便番号を返す() {
            sut.set申請者郵便番号(DbT3098TandokuJoseikinKyufuShinseiEntityGenerator.DEFAULT_申請者郵便番号);
            assertThat(sut.get申請者郵便番号(), is(DbT3098TandokuJoseikinKyufuShinseiEntityGenerator.DEFAULT_申請者郵便番号));
        }

        @Test
        public void 戻り値の申請者住所は_設定した値と同じ申請者住所を返す() {
            sut.set申請者住所(DbT3098TandokuJoseikinKyufuShinseiEntityGenerator.DEFAULT_申請者住所);
            assertThat(sut.get申請者住所(), is(DbT3098TandokuJoseikinKyufuShinseiEntityGenerator.DEFAULT_申請者住所));
        }

        @Test
        public void 戻り値の申請者電話番号は_設定した値と同じ申請者電話番号を返す() {
            sut.set申請者電話番号(DbT3098TandokuJoseikinKyufuShinseiEntityGenerator.DEFAULT_申請者電話番号);
            assertThat(sut.get申請者電話番号(), is(DbT3098TandokuJoseikinKyufuShinseiEntityGenerator.DEFAULT_申請者電話番号));
        }

        @Test
        public void 戻り値の申請理由は_設定した値と同じ申請理由を返す() {
            sut.set申請理由(DbT3098TandokuJoseikinKyufuShinseiEntityGenerator.DEFAULT_申請理由);
            assertThat(sut.get申請理由(), is(DbT3098TandokuJoseikinKyufuShinseiEntityGenerator.DEFAULT_申請理由));
        }

        @Test
        public void 戻り値の市町村単独助成種類は_設定した値と同じ市町村単独助成種類を返す() {
            sut.set市町村単独助成種類(DbT3098TandokuJoseikinKyufuShinseiEntityGenerator.DEFAULT_市町村単独助成種類);
            assertThat(sut.get市町村単独助成種類(), is(DbT3098TandokuJoseikinKyufuShinseiEntityGenerator.DEFAULT_市町村単独助成種類));
        }
    }

    public static class getStateTest extends DbzTestBase {

        @Test
        public void 状態Addedの取得確認() {
            TandokuJoseikinKyufuShinseiModel sut = new TandokuJoseikinKyufuShinseiModel();

            assertThat(sut.getState(), is(EntityDataState.Added));
        }

        @Test
        public void 状態Modifinedの取得確認() {
            TandokuJoseikinKyufuShinseiModel sut = new TandokuJoseikinKyufuShinseiModel();
            sut.setEntity(DbT3098TandokuJoseikinKyufuShinseiEntityGenerator.createDbT3098TandokuJoseikinKyufuShinseiEntity());

            sut.getEntity().initializeMd5();

            // TODO 主キー以外の項目を変更してください
//            sut.getEntity().setXXX(new XXX());
//            assertThat(sut.getState(), is(EntityDataState.Modified));
        }

        @Test
        public void 状態Unchangedの取得確認() {
            TandokuJoseikinKyufuShinseiModel sut = new TandokuJoseikinKyufuShinseiModel();
            sut.setEntity(DbT3098TandokuJoseikinKyufuShinseiEntityGenerator.createDbT3098TandokuJoseikinKyufuShinseiEntity());

            sut.getEntity().initializeMd5();

            assertThat(sut.getState(), is(EntityDataState.Unchanged));
        }

        @Test
        public void 状態Deletedの取得確認() {
            TandokuJoseikinKyufuShinseiModel sut = new TandokuJoseikinKyufuShinseiModel();
            sut.setEntity(DbT3098TandokuJoseikinKyufuShinseiEntityGenerator.createDbT3098TandokuJoseikinKyufuShinseiEntity());

            sut.getEntity().initializeMd5();

            sut.setDeletedState(true);

            assertThat(sut.getState(), is(EntityDataState.Deleted));
        }
    }
}
