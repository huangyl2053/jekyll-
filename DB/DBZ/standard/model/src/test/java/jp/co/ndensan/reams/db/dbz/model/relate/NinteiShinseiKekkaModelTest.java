/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.model.relate;

import jp.co.ndensan.reams.db.dbz.model.helper.NinteiShinseiKekkaModelTestHelper;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {link NinteiShinseiKekkaModel}のテストクラスです。
 *
 * @author n8187 久保田 英男
 */
@RunWith(Enclosed.class)
public class NinteiShinseiKekkaModelTest {

    public static class getStateTest extends DbzTestBase {

        @Test
        public void 親テーブルの状態がModifiedの時_Modifiedが返る() {
            NinteiShinseiKekkaModel model = NinteiShinseiKekkaModelTestHelper.createModel();

            model.get受給者台帳モデル().getEntity().initializeMd5();
            model.get要介護認定申請情報モデル().get().getEntity().initializeMd5();
            model.get要介護認定結果情報モデル().get().getEntity().initializeMd5();
            // 親テーブルの状態をModifiedにするために、親テーブルの任意の項目を変更してください。
            model.get受給者台帳モデル().set支給限度単位数(Decimal.ZERO);
            assertThat(model.getState(), is(EntityDataState.Modified));

        }

        @Test
        public void 親テーブルの状態がUnchanged_子テーブルの状態のいずれかがAddedの時_Modifiedが返る() {
            NinteiShinseiKekkaModel model = NinteiShinseiKekkaModelTestHelper.createModel();

            model.get受給者台帳モデル().getEntity().initializeMd5();

            assertThat(model.getState(), is(EntityDataState.Modified));
        }

        @Test
        public void 親テーブルの状態がUnchanged_子テーブルの状態のいずれかがModifiedの時_Modifiedが返る() {
            NinteiShinseiKekkaModel model = NinteiShinseiKekkaModelTestHelper.createModel();

            model.get受給者台帳モデル().getEntity().initializeMd5();
            model.get要介護認定申請情報モデル().get().getEntity().initializeMd5();
            model.get要介護認定結果情報モデル().get().getEntity().initializeMd5();
            // 子テーブルの状態をModifiedにするために、子テーブルの任意の項目を変更してください。
            model.get受給者台帳モデル().set支給限度単位数(Decimal.ZERO);

            assertThat(model.getState(), is(EntityDataState.Modified));
        }

        @Test
        public void 親テーブルの状態がUnchanged_子テーブルの状態のいずれかがDeletedの時_Modifiedが返る() {
            NinteiShinseiKekkaModel model = NinteiShinseiKekkaModelTestHelper.createModel();

            model.get受給者台帳モデル().getEntity().initializeMd5();
            model.get要介護認定申請情報モデル().get().getEntity().initializeMd5();
            model.get要介護認定結果情報モデル().get().getEntity().initializeMd5();

            // 子テーブルの状態をDeletedにするために、任意の子テーブルの削除フラグにtrueを設定してください。
            model.get要介護認定申請情報モデル().get().setDeletedState(true);

            assertThat(model.getState(), is(EntityDataState.Modified));
        }

        @Test
        public void 親テーブルの状態がUnchanged_子テーブルの状態のいずれもUnchangedの時_Unchangedが返る() {
            NinteiShinseiKekkaModel model = NinteiShinseiKekkaModelTestHelper.createModel();

            model.get受給者台帳モデル().getEntity().initializeMd5();
            model.get要介護認定申請情報モデル().get().getEntity().initializeMd5();
            model.get要介護認定結果情報モデル().get().getEntity().initializeMd5();

            assertThat(model.getState(), is(EntityDataState.Unchanged));
        }

        @Test
        public void 親テーブルの状態がAddedの時_Addedが返る() {
            NinteiShinseiKekkaModel model = NinteiShinseiKekkaModelTestHelper.createModel();

            assertThat(model.getState(), is(EntityDataState.Added));
        }

        @Test
        public void 親テーブルの状態がDeletedの時_Deletedが返る() {
            NinteiShinseiKekkaModel model = NinteiShinseiKekkaModelTestHelper.createModel();

            model.get受給者台帳モデル().getEntity().initializeMd5();
            // 親テーブルの状態をDeletedにするために、親テーブルの削除フラグにtrueを設定してください。
            model.get受給者台帳モデル().setDeletedState(true);

            assertThat(model.getState(), is(EntityDataState.Deleted));
        }

    }

}
