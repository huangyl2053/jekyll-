/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.model.relate.fuka;

import java.util.Iterator;
import jp.co.ndensan.reams.db.dbz.model.fuka.KibetsuChoshuYuyoModel;
import jp.co.ndensan.reams.db.dbz.model.helper.fuka.ChoshuYuyoRelateModelTestHelper;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {link ChoshuYuyoRelateModel}のテストクラスです。
 *
 * @author n3317 塚田 萌
 */
@RunWith(Enclosed.class)
public class ChoshuYuyoRelateModelTest {

    public static class getStateTest extends DbzTestBase {

        @Test
        public void 親テーブルの状態がModifiedの時_Modifiedが返る() {
            ChoshuYuyoRelateModel model = ChoshuYuyoRelateModelTestHelper.createModel();

            model.get徴収猶予モデル().getEntity().initializeMd5();

            for (Iterator<KibetsuChoshuYuyoModel> iterator = model.get期別徴収猶予モデルリスト().iterator(); iterator.hasNext();) {
                iterator.next().getEntity().initializeMd5();
            }
            model.get徴収猶予モデル().set申請事由(new RString("change"));

            assertThat(model.getState(), is(EntityDataState.Modified));

        }

        @Test
        public void 親テーブルの状態がUnchanged_子テーブルの状態のいずれかがAddedの時_Modifiedが返る() {
            ChoshuYuyoRelateModel model = ChoshuYuyoRelateModelTestHelper.createModel();

            model.get徴収猶予モデル().getEntity().initializeMd5();

            assertThat(model.getState(), is(EntityDataState.Modified));
        }

        @Test
        public void 親テーブルの状態がUnchanged_子テーブルの状態のいずれかがModifiedの時_Modifiedが返る() {
            ChoshuYuyoRelateModel model = ChoshuYuyoRelateModelTestHelper.createModel();

            model.get徴収猶予モデル().getEntity().initializeMd5();
            for (Iterator<KibetsuChoshuYuyoModel> iterator = model.get期別徴収猶予モデルリスト().iterator(); iterator.hasNext();) {
                iterator.next().getEntity().initializeMd5();
            }
            model.get期別徴収猶予モデルリスト().findFirst().get().set徴収猶予開始年月日(new FlexibleDate("20041225"));

            assertThat(model.getState(), is(EntityDataState.Modified));
        }

        @Test
        public void 親テーブルの状態がUnchanged_子テーブルの状態のいずれかがDeletedの時_Modifiedが返る() {
            ChoshuYuyoRelateModel model = ChoshuYuyoRelateModelTestHelper.createModel();

            model.get徴収猶予モデル().getEntity().initializeMd5();
            for (Iterator<KibetsuChoshuYuyoModel> iterator = model.get期別徴収猶予モデルリスト().iterator(); iterator.hasNext();) {
                iterator.next().getEntity().initializeMd5();
            }
            model.get期別徴収猶予モデルリスト().findFirst().get().setDeletedState(true);

            assertThat(model.getState(), is(EntityDataState.Modified));
        }

        @Test
        public void 親テーブルの状態がUnchanged_子テーブルの状態のいずれもUnchangedの時_Unchangedが返る() {
            ChoshuYuyoRelateModel model = ChoshuYuyoRelateModelTestHelper.createModel();

            model.get徴収猶予モデル().getEntity().initializeMd5();
            for (Iterator<KibetsuChoshuYuyoModel> iterator = model.get期別徴収猶予モデルリスト().iterator(); iterator.hasNext();) {
                iterator.next().getEntity().initializeMd5();
            }

            assertThat(model.getState(), is(EntityDataState.Unchanged));
        }

        @Test
        public void 親テーブルの状態がAddedの時_Addedが返る() {
            ChoshuYuyoRelateModel model = ChoshuYuyoRelateModelTestHelper.createModel();

            assertThat(model.getState(), is(EntityDataState.Added));
        }

        @Test
        public void 親テーブルの状態がDeletedの時_Deletedが返る() {
            ChoshuYuyoRelateModel model = ChoshuYuyoRelateModelTestHelper.createModel();

            model.get徴収猶予モデル().getEntity().initializeMd5();
            model.get徴収猶予モデル().setDeletedState(true);

            assertThat(model.getState(), is(EntityDataState.Deleted));
        }
    }
}
