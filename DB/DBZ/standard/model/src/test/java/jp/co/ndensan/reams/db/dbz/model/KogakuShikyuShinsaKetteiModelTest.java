/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.model;

import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT3058KogakuShikyuShinsaKetteiEntityGenerator;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link KogakuShikyuShinsaKetteiModel}のテストクラスです。
 *
 * @author LDNS 周杏月
 */
@RunWith(Enclosed.class)
public class KogakuShikyuShinsaKetteiModelTest extends DbzTestBase {

    public static class getterSetterTest extends DbzTestBase {

        private static KogakuShikyuShinsaKetteiModel sut;

        @BeforeClass
        public static void test() {
            sut = new KogakuShikyuShinsaKetteiModel();
        }

        @Test
        public void 戻り値の決定者受取年月は_設定した値と同じ決定者受取年月を返す() {
            sut.set決定者受取年月(DbT3058KogakuShikyuShinsaKetteiEntityGenerator.DEFAULT_決定者受取年月);
            assertThat(sut.get決定者受取年月(), is(DbT3058KogakuShikyuShinsaKetteiEntityGenerator.DEFAULT_決定者受取年月));
        }

        @Test
        public void 戻り値の証記載保険者番号は_設定した値と同じ証記載保険者番号を返す() {
            sut.set証記載保険者番号(DbT3058KogakuShikyuShinsaKetteiEntityGenerator.DEFAULT_証記載保険者番号);
            assertThat(sut.get証記載保険者番号(), is(DbT3058KogakuShikyuShinsaKetteiEntityGenerator.DEFAULT_証記載保険者番号));
        }

        @Test
        public void 戻り値の被保険者番号は_設定した値と同じ被保険者番号を返す() {
            sut.set被保険者番号(DbT3058KogakuShikyuShinsaKetteiEntityGenerator.DEFAULT_被保険者番号);
            assertThat(sut.get被保険者番号(), is(DbT3058KogakuShikyuShinsaKetteiEntityGenerator.DEFAULT_被保険者番号));
        }

        @Test
        public void 戻り値のサービス提供年月は_設定した値と同じサービス提供年月を返す() {
            sut.setサービス提供年月(DbT3058KogakuShikyuShinsaKetteiEntityGenerator.DEFAULT_サービス提供年月);
            assertThat(sut.getサービス提供年月(), is(DbT3058KogakuShikyuShinsaKetteiEntityGenerator.DEFAULT_サービス提供年月));
        }

        @Test
        public void 戻り値の通知書番号は_設定した値と同じ通知書番号を返す() {
            sut.set通知書番号(DbT3058KogakuShikyuShinsaKetteiEntityGenerator.DEFAULT_通知書番号);
            assertThat(sut.get通知書番号(), is(DbT3058KogakuShikyuShinsaKetteiEntityGenerator.DEFAULT_通知書番号));
        }

        @Test
        public void 戻り値の利用者負担額は_設定した値と同じ利用者負担額を返す() {
            sut.set利用者負担額(DbT3058KogakuShikyuShinsaKetteiEntityGenerator.DEFAULT_利用者負担額);
            assertThat(sut.get利用者負担額(), is(DbT3058KogakuShikyuShinsaKetteiEntityGenerator.DEFAULT_利用者負担額));
        }

        @Test
        public void 戻り値の支給区分コードは_設定した値と同じ支給区分コードを返す() {
            sut.set支給区分コード(DbT3058KogakuShikyuShinsaKetteiEntityGenerator.DEFAULT_支給区分コード);
            assertThat(sut.get支給区分コード(), is(DbT3058KogakuShikyuShinsaKetteiEntityGenerator.DEFAULT_支給区分コード));
        }

        @Test
        public void 戻り値の決定年月は_設定した値と同じ決定年月を返す() {
            sut.set決定年月(DbT3058KogakuShikyuShinsaKetteiEntityGenerator.DEFAULT_決定年月);
            assertThat(sut.get決定年月(), is(DbT3058KogakuShikyuShinsaKetteiEntityGenerator.DEFAULT_決定年月));
        }

        @Test
        public void 戻り値の高額支給額は_設定した値と同じ高額支給額を返す() {
            sut.set高額支給額(DbT3058KogakuShikyuShinsaKetteiEntityGenerator.DEFAULT_高額支給額);
            assertThat(sut.get高額支給額(), is(DbT3058KogakuShikyuShinsaKetteiEntityGenerator.DEFAULT_高額支給額));
        }
    }

    public static class getStateTest extends DbzTestBase {

        @Test
        public void 状態Addedの取得確認() {
            KogakuShikyuShinsaKetteiModel sut = new KogakuShikyuShinsaKetteiModel();

            assertThat(sut.getState(), is(EntityDataState.Added));
        }

       // @Test
        // public void 状態Modifinedの取得確認() {
        // KogakuShikyuShinsaKetteiModel sut = new KogakuShikyuShinsaKetteiModel();
        //sut.setEntity(DbT3058KogakuShikyuShinsaKetteiEntityGenerator.createDbT3058KogakuShikyuShinsaKetteiEntity());
           // sut.getEntity().initializeMd5();
            // TODO主キー以外の項目を変更してください
        //sut.getEntity().setXXX(new XXX());
            //assertThat(sut.getState(), is(EntityDataState.Modified));
        //}
        @Test
        public void 状態Unchangedの取得確認() {
            KogakuShikyuShinsaKetteiModel sut = new KogakuShikyuShinsaKetteiModel();
            sut.setEntity(DbT3058KogakuShikyuShinsaKetteiEntityGenerator.createDbT3058KogakuShikyuShinsaKetteiEntity());

            sut.getEntity().initializeMd5();

            assertThat(sut.getState(), is(EntityDataState.Unchanged));
        }

        @Test
        public void 状態Deletedの取得確認() {
            KogakuShikyuShinsaKetteiModel sut = new KogakuShikyuShinsaKetteiModel();
            sut.setEntity(DbT3058KogakuShikyuShinsaKetteiEntityGenerator.createDbT3058KogakuShikyuShinsaKetteiEntity());

            sut.getEntity().initializeMd5();

            sut.setDeletedState(true);

            assertThat(sut.getState(), is(EntityDataState.Deleted));
        }
    }
}
