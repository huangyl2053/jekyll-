/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.model;

import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT3056KogakuShikyuShinseiEntityGenerator;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link KogakuShikyuShinseiModel}のテストクラスです。
 *
 * @author LDNS 周杏月
 */
@RunWith(Enclosed.class)
public class KogakuShikyuShinseiModelTest extends DbzTestBase {

    public static class getterSetterTest extends DbzTestBase {

        private static KogakuShikyuShinseiModel sut;

        @BeforeClass
        public static void test() {
            sut = new KogakuShikyuShinseiModel();
        }

        @Test
        public void 戻り値の被保険者番号は_設定した値と同じ被保険者番号を返す() {
            sut.set被保険者番号(DbT3056KogakuShikyuShinseiEntityGenerator.DEFAULT_被保険者番号);
            assertThat(sut.get被保険者番号(), is(DbT3056KogakuShikyuShinseiEntityGenerator.DEFAULT_被保険者番号));
        }

        @Test
        public void 戻り値のサービス提供年月は_設定した値と同じサービス提供年月を返す() {
            sut.setサービス提供年月(DbT3056KogakuShikyuShinseiEntityGenerator.DEFAULT_サービス提供年月);
            assertThat(sut.getサービス提供年月(), is(DbT3056KogakuShikyuShinseiEntityGenerator.DEFAULT_サービス提供年月));
        }

        @Test
        public void 戻り値の証記載保険者番号は_設定した値と同じ証記載保険者番号を返す() {
            sut.set証記載保険者番号(DbT3056KogakuShikyuShinseiEntityGenerator.DEFAULT_証記載保険者番号);
            assertThat(sut.get証記載保険者番号(), is(DbT3056KogakuShikyuShinseiEntityGenerator.DEFAULT_証記載保険者番号));
        }

        @Test
        public void 戻り値の処理日時は_設定した値と同じ処理日時を返す() {
            sut.set処理日時(DbT3056KogakuShikyuShinseiEntityGenerator.DEFAULT_処理日時);
            assertThat(sut.get処理日時(), is(DbT3056KogakuShikyuShinseiEntityGenerator.DEFAULT_処理日時));
        }

        @Test
        public void 戻り値の受付年月日は_設定した値と同じ受付年月日を返す() {
            sut.set受付年月日(DbT3056KogakuShikyuShinseiEntityGenerator.DEFAULT_受付年月日);
            assertThat(sut.get受付年月日(), is(DbT3056KogakuShikyuShinseiEntityGenerator.DEFAULT_受付年月日));
        }

        @Test
        public void 戻り値の申請年月日は_設定した値と同じ申請年月日を返す() {
            sut.set申請年月日(DbT3056KogakuShikyuShinseiEntityGenerator.DEFAULT_申請年月日);
            assertThat(sut.get申請年月日(), is(DbT3056KogakuShikyuShinseiEntityGenerator.DEFAULT_申請年月日));
        }

        @Test
        public void 戻り値の申請理由は_設定した値と同じ申請理由を返す() {
            sut.set申請理由(DbT3056KogakuShikyuShinseiEntityGenerator.DEFAULT_申請理由);
            assertThat(sut.get申請理由(), is(DbT3056KogakuShikyuShinseiEntityGenerator.DEFAULT_申請理由));
        }

        @Test
        public void 戻り値の申請者区分は_設定した値と同じ申請者区分を返す() {
            sut.set申請者区分(DbT3056KogakuShikyuShinseiEntityGenerator.DEFAULT_申請者区分);
            assertThat(sut.get申請者区分(), is(DbT3056KogakuShikyuShinseiEntityGenerator.DEFAULT_申請者区分));
        }

        @Test
        public void 戻り値の申請者氏名は_設定した値と同じ申請者氏名を返す() {
            sut.set申請者氏名(DbT3056KogakuShikyuShinseiEntityGenerator.DEFAULT_申請者氏名);
            assertThat(sut.get申請者氏名(), is(DbT3056KogakuShikyuShinseiEntityGenerator.DEFAULT_申請者氏名));
        }

        @Test
        public void 戻り値の申請者氏名カナは_設定した値と同じ申請者氏名カナを返す() {
            sut.set申請者氏名カナ(DbT3056KogakuShikyuShinseiEntityGenerator.DEFAULT_申請者氏名カナ);
            assertThat(sut.get申請者氏名カナ(), is(DbT3056KogakuShikyuShinseiEntityGenerator.DEFAULT_申請者氏名カナ));
        }

        @Test
        public void 戻り値の申請者住所は_設定した値と同じ申請者住所を返す() {
            sut.set申請者住所(DbT3056KogakuShikyuShinseiEntityGenerator.DEFAULT_申請者住所);
            assertThat(sut.get申請者住所(), is(DbT3056KogakuShikyuShinseiEntityGenerator.DEFAULT_申請者住所));
        }

        @Test
        public void 戻り値の申請者電話番号は_設定した値と同じ申請者電話番号を返す() {
            sut.set申請者電話番号(DbT3056KogakuShikyuShinseiEntityGenerator.DEFAULT_申請者電話番号);
            assertThat(sut.get申請者電話番号(), is(DbT3056KogakuShikyuShinseiEntityGenerator.DEFAULT_申請者電話番号));
        }

        @Test
        public void 戻り値の申請事業者番号は_設定した値と同じ申請事業者番号を返す() {
            sut.set申請事業者番号(DbT3056KogakuShikyuShinseiEntityGenerator.DEFAULT_申請事業者番号);
            assertThat(sut.get申請事業者番号(), is(DbT3056KogakuShikyuShinseiEntityGenerator.DEFAULT_申請事業者番号));
        }
    }

    public static class getStateTest extends DbzTestBase {

        @Test
        public void 状態Addedの取得確認() {
            KogakuShikyuShinseiModel sut = new KogakuShikyuShinseiModel();

            assertThat(sut.getState(), is(EntityDataState.Added));
        }

       // @Test
        // public void 状態Modifinedの取得確認() {
        // KogakuShikyuShinseiModel sut = new KogakuShikyuShinseiModel();
        //sut.setEntity(DbT3056KogakuShikyuShinseiEntityGenerator.createDbT3056KogakuShikyuShinseiEntity());
           // sut.getEntity().initializeMd5();
            // TODO主キー以外の項目を変更してください
        //sut.getEntity().setXXX(new XXX());
            //assertThat(sut.getState(), is(EntityDataState.Modified));
        //}
        @Test
        public void 状態Unchangedの取得確認() {
            KogakuShikyuShinseiModel sut = new KogakuShikyuShinseiModel();
            sut.setEntity(DbT3056KogakuShikyuShinseiEntityGenerator.createDbT3056KogakuShikyuShinseiEntity());

            sut.getEntity().initializeMd5();

            assertThat(sut.getState(), is(EntityDataState.Unchanged));
        }

        @Test
        public void 状態Deletedの取得確認() {
            KogakuShikyuShinseiModel sut = new KogakuShikyuShinseiModel();
            sut.setEntity(DbT3056KogakuShikyuShinseiEntityGenerator.createDbT3056KogakuShikyuShinseiEntity());

            sut.getEntity().initializeMd5();

            sut.setDeletedState(true);

            assertThat(sut.getState(), is(EntityDataState.Deleted));
        }
    }
}
