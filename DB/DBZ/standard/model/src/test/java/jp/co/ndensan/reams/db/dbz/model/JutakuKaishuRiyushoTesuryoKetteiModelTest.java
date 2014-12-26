/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.model;

import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT3094JutakuKaishuRiyushoTesuryoKetteiEntityGenerator;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link JutakuKaishuRiyushoTesuryoKetteiModel}のテストクラスです。
 *
 * @author LDNS 宋昕沢
 */
@RunWith(Enclosed.class)
public class JutakuKaishuRiyushoTesuryoKetteiModelTest extends DbzTestBase {

    public static class getterSetterTest extends DbzTestBase {

        private static JutakuKaishuRiyushoTesuryoKetteiModel sut;

        @BeforeClass
        public static void test() {
            sut = new JutakuKaishuRiyushoTesuryoKetteiModel();
        }

        @Test
        public void 戻り値の介護住宅改修理由書作成事業者番号は_設定した値と同じ介護住宅改修理由書作成事業者番号を返す() {
            sut.set介護住宅改修理由書作成事業者番号(DbT3094JutakuKaishuRiyushoTesuryoKetteiEntityGenerator.DEFAULT_介護住宅改修理由書作成事業者番号);
            assertThat(sut.get介護住宅改修理由書作成事業者番号(), is(DbT3094JutakuKaishuRiyushoTesuryoKetteiEntityGenerator.DEFAULT_介護住宅改修理由書作成事業者番号));
        }

        @Test
        public void 戻り値の決定年月日は_設定した値と同じ決定年月日を返す() {
            sut.set決定年月日(DbT3094JutakuKaishuRiyushoTesuryoKetteiEntityGenerator.DEFAULT_決定年月日);
            assertThat(sut.get決定年月日(), is(DbT3094JutakuKaishuRiyushoTesuryoKetteiEntityGenerator.DEFAULT_決定年月日));
        }

        @Test
        public void 戻り値の処理日時は_設定した値と同じ処理日時を返す() {
            sut.set処理日時(DbT3094JutakuKaishuRiyushoTesuryoKetteiEntityGenerator.DEFAULT_処理日時);
            assertThat(sut.get処理日時(), is(DbT3094JutakuKaishuRiyushoTesuryoKetteiEntityGenerator.DEFAULT_処理日時));
        }

        @Test
        public void 戻り値の支給_不支給決定年月日は_設定した値と同じ支給_不支給決定年月日を返す() {
            sut.set支給_不支給決定年月日(DbT3094JutakuKaishuRiyushoTesuryoKetteiEntityGenerator.DEFAULT_支給_不支給決定年月日);
            assertThat(sut.get支給_不支給決定年月日(), is(DbT3094JutakuKaishuRiyushoTesuryoKetteiEntityGenerator.DEFAULT_支給_不支給決定年月日));
        }

        @Test
        public void 戻り値の支給_不支給区分は_設定した値と同じ支給_不支給区分を返す() {
            sut.set支給_不支給区分(DbT3094JutakuKaishuRiyushoTesuryoKetteiEntityGenerator.DEFAULT_支給_不支給区分);
            assertThat(sut.get支給_不支給区分(), is(DbT3094JutakuKaishuRiyushoTesuryoKetteiEntityGenerator.DEFAULT_支給_不支給区分));
        }

        @Test
        public void 戻り値の償還不支給理由等は_設定した値と同じ償還不支給理由等を返す() {
            sut.set償還不支給理由等(DbT3094JutakuKaishuRiyushoTesuryoKetteiEntityGenerator.DEFAULT_償還不支給理由等);
            assertThat(sut.get償還不支給理由等(), is(DbT3094JutakuKaishuRiyushoTesuryoKetteiEntityGenerator.DEFAULT_償還不支給理由等));
        }

        @Test
        public void 戻り値の住宅改修理由書作成手数料支払予定日は_設定した値と同じ住宅改修理由書作成手数料支払予定日を返す() {
            sut.set住宅改修理由書作成手数料支払予定日(DbT3094JutakuKaishuRiyushoTesuryoKetteiEntityGenerator.DEFAULT_住宅改修理由書作成手数料支払予定日);
            assertThat(sut.get住宅改修理由書作成手数料支払予定日(), is(DbT3094JutakuKaishuRiyushoTesuryoKetteiEntityGenerator.DEFAULT_住宅改修理由書作成手数料支払予定日));
        }
    }

    public static class getStateTest extends DbzTestBase {

        @Test
        public void 状態Addedの取得確認() {
            JutakuKaishuRiyushoTesuryoKetteiModel sut = new JutakuKaishuRiyushoTesuryoKetteiModel();

            assertThat(sut.getState(), is(EntityDataState.Added));
        }

        @Test
        public void 状態Modifinedの取得確認() {
            JutakuKaishuRiyushoTesuryoKetteiModel sut = new JutakuKaishuRiyushoTesuryoKetteiModel();
            sut.setEntity(DbT3094JutakuKaishuRiyushoTesuryoKetteiEntityGenerator.createDbT3094JutakuKaishuRiyushoTesuryoKetteiEntity());

            sut.getEntity().initializeMd5();

            //TODO  主キー以外の項目を変更してください
//            sut.getEntity().setXXX(new XXX());
//            assertThat(sut.getState(), is(EntityDataState.Modified));
        }

        @Test
        public void 状態Unchangedの取得確認() {
            JutakuKaishuRiyushoTesuryoKetteiModel sut = new JutakuKaishuRiyushoTesuryoKetteiModel();
            sut.setEntity(DbT3094JutakuKaishuRiyushoTesuryoKetteiEntityGenerator.createDbT3094JutakuKaishuRiyushoTesuryoKetteiEntity());

            sut.getEntity().initializeMd5();

            assertThat(sut.getState(), is(EntityDataState.Unchanged));
        }

        @Test
        public void 状態Deletedの取得確認() {
            JutakuKaishuRiyushoTesuryoKetteiModel sut = new JutakuKaishuRiyushoTesuryoKetteiModel();
            sut.setEntity(DbT3094JutakuKaishuRiyushoTesuryoKetteiEntityGenerator.createDbT3094JutakuKaishuRiyushoTesuryoKetteiEntity());

            sut.getEntity().initializeMd5();

            sut.setDeletedState(true);

            assertThat(sut.getState(), is(EntityDataState.Deleted));
        }
    }
}
