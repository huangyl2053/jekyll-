/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.model.relate;

import jp.co.ndensan.reams.db.dbz.model.helper.KaigoJogaiTokureiTaishoShisetsuRelateModelTestHelper;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {link KaigoJogaiTokureiTaishoShisetsuRelateModel}のテストクラスです。
 *
 * @author n8223 朴義一
 */
@RunWith(Enclosed.class)
public class KaigoJogaiTokureiTaishoShisetsuRelateModelTest {

    public static class getStateTest extends DbzTestBase {

        @Test
        public void 親テーブルの状態がModifiedの時_Modifiedが返る() {
            KaigoJogaiTokureiTaishoShisetsuRelateModel model = KaigoJogaiTokureiTaishoShisetsuRelateModelTestHelper.createModel();

            model.get介護除外住所地特例対象施設モデル().getEntity().initializeMd5();

            // 親テーブルの状態をModifiedにするために、親テーブルの任意の項目を変更してください。
            model.get介護除外住所地特例対象施設モデル().set事業者種別(RString.EMPTY);
            assertThat(model.getState(), is(EntityDataState.Modified));

        }

        @Test
        public void 親テーブルの状態がUnchanged_子テーブルの状態のいずれかがAddedの時_Modifiedが返る() {
            KaigoJogaiTokureiTaishoShisetsuRelateModel model = KaigoJogaiTokureiTaishoShisetsuRelateModelTestHelper.createModel();

            model.get介護除外住所地特例対象施設モデル().getEntity().initializeMd5();

            // 親テーブルの状態をModifiedにするために、親テーブルの任意の項目を変更してください。
            model.get介護除外住所地特例対象施設モデル().set事業者種別(RString.EMPTY);
            assertThat(model.getState(), is(EntityDataState.Modified));
        }

        @Test
        public void 親テーブルの状態がUnchanged_子テーブルの状態のいずれかがModifiedの時_Modifiedが返る() {
            KaigoJogaiTokureiTaishoShisetsuRelateModel model = KaigoJogaiTokureiTaishoShisetsuRelateModelTestHelper.createModel();

            model.get介護除外住所地特例対象施設モデル().getEntity().initializeMd5();

            // 子テーブルの状態をModifiedにするために、子テーブルの任意の項目を変更してください。
            model.get介護除外住所地特例対象施設モデル().set事業者種別(RString.EMPTY);

            assertThat(model.getState(), is(EntityDataState.Modified));
        }

        @Test
        public void 親テーブルの状態がUnchanged_子テーブルの状態のいずれかがDeletedの時_Modifiedが返る() {
            KaigoJogaiTokureiTaishoShisetsuRelateModel model = KaigoJogaiTokureiTaishoShisetsuRelateModelTestHelper.createModel();

            model.get介護除外住所地特例対象施設モデル().getEntity().initializeMd5();

            // 子テーブルの状態をDeletedにするために、任意の子テーブルの削除フラグにtrueを設定してください。
            model.get介護除外住所地特例対象施設モデル().set事業者種別(RString.EMPTY);

            assertThat(model.getState(), is(EntityDataState.Modified));
        }

        @Test
        public void 親テーブルの状態がUnchanged_子テーブルの状態のいずれもUnchangedの時_Unchangedが返る() {
            KaigoJogaiTokureiTaishoShisetsuRelateModel model = KaigoJogaiTokureiTaishoShisetsuRelateModelTestHelper.createModel();

            model.get介護除外住所地特例対象施設モデル().getEntity().initializeMd5();

            assertThat(model.getState(), is(EntityDataState.Unchanged));
        }

        @Test
        public void 親テーブルの状態がAddedの時_Addedが返る() {
            KaigoJogaiTokureiTaishoShisetsuRelateModel model = KaigoJogaiTokureiTaishoShisetsuRelateModelTestHelper.createModel();

            assertThat(model.getState(), is(EntityDataState.Added));
        }

        @Test
        public void 親テーブルの状態がDeletedの時_Deletedが返る() {
            KaigoJogaiTokureiTaishoShisetsuRelateModel model = KaigoJogaiTokureiTaishoShisetsuRelateModelTestHelper.createModel();

            model.get介護除外住所地特例対象施設モデル().getEntity().initializeMd5();
            // 親テーブルの状態をDeletedにするために、親テーブルの削除フラグにtrueを設定してください。
            model.get介護除外住所地特例対象施設モデル().setDeletedState(true);

            assertThat(model.getState(), is(EntityDataState.Deleted));
        }

    }

}
