/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.model.relate;

import jp.co.ndensan.reams.db.dbz.model.helper.KyotakuKeikakuRelateModelTestHelper;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {link KyotakuKeikakuRelateModel}のテストクラスです。
 *
 * @author n8187 久保田 英男
 */
@RunWith(Enclosed.class)
public class KyotakuKeikakuRelateModelTest {

    public static class getStateTest extends DbzTestBase {

        @Test
        public void 親テーブルの状態がModifiedの時_Modifiedが返る() {
            KyotakuKeikakuRelateModel model = KyotakuKeikakuRelateModelTestHelper.createModel();

            model.get居宅給付計画届出モデル().getEntity().initializeMd5();
            model.get居宅給付計画事業者作成モデル().get().getEntity().initializeMd5();
            model.get居宅給付計画自己作成モデル().get().getEntity().initializeMd5();
            // 親テーブルの状態をModifiedにするために、親テーブルの任意の項目を変更してください。
            model.get居宅給付計画届出モデル().set暫定区分(new RString("9"));
            assertThat(model.getState(), is(EntityDataState.Modified));

        }

        @Test
        public void 親テーブルの状態がUnchanged_子テーブルの状態のいずれかがAddedの時_Modifiedが返る() {
            KyotakuKeikakuRelateModel model = KyotakuKeikakuRelateModelTestHelper.createModel();

            model.get居宅給付計画届出モデル().getEntity().initializeMd5();

            assertThat(model.getState(), is(EntityDataState.Modified));
        }

        @Test
        public void 親テーブルの状態がUnchanged_子テーブルの状態のいずれかがModifiedの時_Modifiedが返る() {
            KyotakuKeikakuRelateModel model = KyotakuKeikakuRelateModelTestHelper.createModel();

            model.get居宅給付計画届出モデル().getEntity().initializeMd5();
            model.get居宅給付計画事業者作成モデル().get().getEntity().initializeMd5();
            model.get居宅給付計画自己作成モデル().get().getEntity().initializeMd5();
            // 子テーブルの状態をModifiedにするために、子テーブルの任意の項目を変更してください。
            model.get居宅給付計画事業者作成モデル().get().set委託先事業者番号(new RString("9"));

            assertThat(model.getState(), is(EntityDataState.Modified));
        }

        @Test
        public void 親テーブルの状態がUnchanged_子テーブルの状態のいずれかがDeletedの時_Modifiedが返る() {
            KyotakuKeikakuRelateModel model = KyotakuKeikakuRelateModelTestHelper.createModel();

            model.get居宅給付計画届出モデル().getEntity().initializeMd5();
            model.get居宅給付計画事業者作成モデル().get().getEntity().initializeMd5();
            model.get居宅給付計画自己作成モデル().get().getEntity().initializeMd5();

            // 子テーブルの状態をDeletedにするために、任意の子テーブルの削除フラグにtrueを設定してください。
            model.get居宅給付計画自己作成モデル().get().setDeletedState(true);

            assertThat(model.getState(), is(EntityDataState.Modified));
        }

        @Test
        public void 親テーブルの状態がUnchanged_子テーブルの状態のいずれもUnchangedの時_Unchangedが返る() {
            KyotakuKeikakuRelateModel model = KyotakuKeikakuRelateModelTestHelper.createModel();

            model.get居宅給付計画届出モデル().getEntity().initializeMd5();
            model.get居宅給付計画事業者作成モデル().get().getEntity().initializeMd5();
            model.get居宅給付計画自己作成モデル().get().getEntity().initializeMd5();

            assertThat(model.getState(), is(EntityDataState.Unchanged));
        }

        @Test
        public void 親テーブルの状態がAddedの時_Addedが返る() {
            KyotakuKeikakuRelateModel model = KyotakuKeikakuRelateModelTestHelper.createModel();

            assertThat(model.getState(), is(EntityDataState.Added));
        }

        @Test
        public void 親テーブルの状態がDeletedの時_Deletedが返る() {
            KyotakuKeikakuRelateModel model = KyotakuKeikakuRelateModelTestHelper.createModel();

            model.get居宅給付計画届出モデル().getEntity().initializeMd5();
            // 親テーブルの状態をDeletedにするために、親テーブルの削除フラグにtrueを設定してください。
            model.get居宅給付計画届出モデル().setDeletedState(true);

            assertThat(model.getState(), is(EntityDataState.Deleted));
        }

    }

}
