/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.model.relate;

import jp.co.ndensan.reams.db.dbb.model.helper.KibetsuChoteiKyotsuModelTestHelper;
import jp.co.ndensan.reams.db.dbz.testhelper.DbbTestBase;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * {link KibetsuChoteiKyotsuModel}のテストクラスです。
 *
 * @author N8156 宮本 康
 */
@RunWith(Enclosed.class)
public class KibetsuChoteiKyotsuModelTest {

    public static class getStateTest extends DbbTestBase {

        @Test
        public void 親テーブルの状態がModifiedの時_Modifiedが返る() {
            KibetsuChoteiKyotsuModel model = KibetsuChoteiKyotsuModelTestHelper.createModel();

            model.get介護期別モデル().getEntity().initializeMd5();
            model.get調定共通モデル().getEntity().initializeMd5();
            model.get介護期別モデル().set調定ID(9999L);
            assertThat(model.getState(), is(EntityDataState.Modified));

        }

        @Test
        public void 親テーブルの状態がUnchanged_子テーブルの状態のいずれかがAddedの時_Modifiedが返る() {
            KibetsuChoteiKyotsuModel model = KibetsuChoteiKyotsuModelTestHelper.createModel();

            model.get介護期別モデル().getEntity().initializeMd5();

            assertThat(model.getState(), is(EntityDataState.Modified));
        }

        @Test
        public void 親テーブルの状態がUnchanged_子テーブルの状態のいずれかがModifiedの時_Modifiedが返る() {
            KibetsuChoteiKyotsuModel model = KibetsuChoteiKyotsuModelTestHelper.createModel();

            model.get介護期別モデル().getEntity().initializeMd5();
            model.get調定共通モデル().getEntity().initializeMd5();
            model.get調定共通モデル().set調定額(new Decimal(9999));

            assertThat(model.getState(), is(EntityDataState.Modified));
        }

        @Test
        public void 親テーブルの状態がUnchanged_子テーブルの状態のいずれかがDeletedの時_Modifiedが返る() {
            KibetsuChoteiKyotsuModel model = KibetsuChoteiKyotsuModelTestHelper.createModel();

            model.get介護期別モデル().getEntity().initializeMd5();
            model.get調定共通モデル().getEntity().initializeMd5();
            model.get調定共通モデル().setDeletedState(true);

            assertThat(model.getState(), is(EntityDataState.Modified));
        }

        @Test
        public void 親テーブルの状態がUnchanged_子テーブルの状態のいずれもUnchangedの時_Unchangedが返る() {
            KibetsuChoteiKyotsuModel model = KibetsuChoteiKyotsuModelTestHelper.createModel();

            model.get介護期別モデル().getEntity().initializeMd5();
            model.get調定共通モデル().getEntity().initializeMd5();

            assertThat(model.getState(), is(EntityDataState.Unchanged));
        }

        @Test
        public void 親テーブルの状態がAddedの時_Addedが返る() {
            KibetsuChoteiKyotsuModel model = KibetsuChoteiKyotsuModelTestHelper.createModel();

            assertThat(model.getState(), is(EntityDataState.Added));
        }

        @Test
        public void 親テーブルの状態がDeletedの時_Deletedが返る() {
            KibetsuChoteiKyotsuModel model = KibetsuChoteiKyotsuModelTestHelper.createModel();

            model.get介護期別モデル().getEntity().initializeMd5();
            model.get介護期別モデル().setDeletedState(true);

            assertThat(model.getState(), is(EntityDataState.Deleted));
        }

    }

}
