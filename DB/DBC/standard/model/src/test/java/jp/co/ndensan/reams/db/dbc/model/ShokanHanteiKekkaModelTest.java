/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.model;

import jp.co.ndensan.reams.db.dbc.model.ShokanHanteiKekkaModel;
import jp.co.ndensan.reams.db.dbc.entity.basic.helper.DbT3036ShokanHanteiKekkaEntityGenerator;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link ShokanHanteiKekkaModel}のテストクラスです。
 *
 * @author LDNS 周杏月
 */
@RunWith(Enclosed.class)
public class ShokanHanteiKekkaModelTest extends DbzTestBase {

    public static class getterSetterTest extends DbzTestBase {

        private static ShokanHanteiKekkaModel sut;

        @BeforeClass
        public static void test() {
            sut = new ShokanHanteiKekkaModel();
        }

        @Test
        public void 戻り値の被保険者番号は_設定した値と同じ被保険者番号を返す() {
            sut.set被保険者番号(DbT3036ShokanHanteiKekkaEntityGenerator.DEFAULT_被保険者番号);
            assertThat(sut.get被保険者番号(), is(DbT3036ShokanHanteiKekkaEntityGenerator.DEFAULT_被保険者番号));
        }

        @Test
        public void 戻り値のサービス提供年月は_設定した値と同じサービス提供年月を返す() {
            sut.setサービス提供年月(DbT3036ShokanHanteiKekkaEntityGenerator.DEFAULT_サービス提供年月);
            assertThat(sut.getサービス提供年月(), is(DbT3036ShokanHanteiKekkaEntityGenerator.DEFAULT_サービス提供年月));
        }

        @Test
        public void 戻り値の整理番号は_設定した値と同じ整理番号を返す() {
            sut.set整理番号(DbT3036ShokanHanteiKekkaEntityGenerator.DEFAULT_整理番号);
            assertThat(sut.get整理番号(), is(DbT3036ShokanHanteiKekkaEntityGenerator.DEFAULT_整理番号));
        }

        @Test
        public void 戻り値の証記載保険者番号は_設定した値と同じ証記載保険者番号を返す() {
            sut.set証記載保険者番号(DbT3036ShokanHanteiKekkaEntityGenerator.DEFAULT_証記載保険者番号);
            assertThat(sut.get証記載保険者番号(), is(DbT3036ShokanHanteiKekkaEntityGenerator.DEFAULT_証記載保険者番号));
        }

        @Test
        public void 戻り値の決定年月日は_設定した値と同じ決定年月日を返す() {
            sut.set決定年月日(DbT3036ShokanHanteiKekkaEntityGenerator.DEFAULT_決定年月日);
            assertThat(sut.get決定年月日(), is(DbT3036ShokanHanteiKekkaEntityGenerator.DEFAULT_決定年月日));
        }

        @Test
        public void 戻り値の支給_不支給決定区分は_設定した値と同じ支給_不支給決定区分を返す() {
            sut.set支給_不支給決定区分(DbT3036ShokanHanteiKekkaEntityGenerator.DEFAULT_支給_不支給決定区分);
            assertThat(sut.get支給_不支給決定区分(), is(DbT3036ShokanHanteiKekkaEntityGenerator.DEFAULT_支給_不支給決定区分));
        }

        @Test
        public void 戻り値の支払金額は_設定した値と同じ支払金額を返す() {
            sut.set支払金額(DbT3036ShokanHanteiKekkaEntityGenerator.DEFAULT_支払金額);
            assertThat(sut.get支払金額(), is(DbT3036ShokanHanteiKekkaEntityGenerator.DEFAULT_支払金額));
        }

        @Test
        public void 戻り値の支払金額内訳_利用者分は_設定した値と同じ支払金額内訳_利用者分を返す() {
            sut.set支払金額内訳_利用者分(DbT3036ShokanHanteiKekkaEntityGenerator.DEFAULT_支払金額内訳_利用者分);
            assertThat(sut.get支払金額内訳_利用者分(), is(DbT3036ShokanHanteiKekkaEntityGenerator.DEFAULT_支払金額内訳_利用者分));
        }

        @Test
        public void 戻り値の決定一覧取込年月は_設定した値と同じ決定一覧取込年月を返す() {
            sut.set決定一覧取込年月(DbT3036ShokanHanteiKekkaEntityGenerator.DEFAULT_決定一覧取込年月);
            assertThat(sut.get決定一覧取込年月(), is(DbT3036ShokanHanteiKekkaEntityGenerator.DEFAULT_決定一覧取込年月));
        }
    }

    public static class getStateTest extends DbzTestBase {

        @Test
        public void 状態Addedの取得確認() {
            ShokanHanteiKekkaModel sut = new ShokanHanteiKekkaModel();

            assertThat(sut.getState(), is(EntityDataState.Added));
        }

       // @Test
        // public void 状態Modifinedの取得確認() {
        // ShokanHanteiKekkaModel sut = new ShokanHanteiKekkaModel();
        //sut.setEntity(DbT3036ShokanHanteiKekkaEntityGenerator.createDbT3036ShokanHanteiKekkaEntity());
        // sut.getEntity().initializeMd5();
        // TODO主キー以外の項目を変更してください
        //sut.getEntity().setXXX(new XXX());
        //assertThat(sut.getState(), is(EntityDataState.Modified));
        //}
        @Test
        public void 状態Unchangedの取得確認() {
            ShokanHanteiKekkaModel sut = new ShokanHanteiKekkaModel();
            sut.setEntity(DbT3036ShokanHanteiKekkaEntityGenerator.createDbT3036ShokanHanteiKekkaEntity());

            sut.getEntity().initializeMd5();

            assertThat(sut.getState(), is(EntityDataState.Unchanged));
        }

        @Test
        public void 状態Deletedの取得確認() {
            ShokanHanteiKekkaModel sut = new ShokanHanteiKekkaModel();
            sut.setEntity(DbT3036ShokanHanteiKekkaEntityGenerator.createDbT3036ShokanHanteiKekkaEntity());

            sut.getEntity().initializeMd5();

            sut.setDeletedState(true);

            assertThat(sut.getState(), is(EntityDataState.Deleted));
        }
    }
}
