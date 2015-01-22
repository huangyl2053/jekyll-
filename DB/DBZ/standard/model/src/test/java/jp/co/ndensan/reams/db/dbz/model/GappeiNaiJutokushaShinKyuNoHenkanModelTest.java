/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.model;

import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT7033GappeiNaiJutokushaShinKyuNoHenkanEntityGenerator;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link GappeiNaiJutokushaShinKyuNoHenkanModel}のテストクラスです。
 *
 * @author LDNS 宋文娟
 */
@RunWith(Enclosed.class)
public class GappeiNaiJutokushaShinKyuNoHenkanModelTest extends DbzTestBase {

    public static class getterSetterTest extends DbzTestBase {

        private static GappeiNaiJutokushaShinKyuNoHenkanModel sut;

        @BeforeClass
        public static void test() {
            sut = new GappeiNaiJutokushaShinKyuNoHenkanModel();
        }

        @Test
        public void 戻り値の識別コードは_設定した値と同じ識別コードを返す() {
            sut.set識別コード(DbT7033GappeiNaiJutokushaShinKyuNoHenkanEntityGenerator.DEFAULT_識別コード);
            assertThat(sut.get識別コード(), is(DbT7033GappeiNaiJutokushaShinKyuNoHenkanEntityGenerator.DEFAULT_識別コード));
        }

        @Test
        public void 戻り値の履歴番号は_設定した値と同じ履歴番号を返す() {
            sut.set履歴番号(DbT7033GappeiNaiJutokushaShinKyuNoHenkanEntityGenerator.DEFAULT_履歴番号);
            assertThat(sut.get履歴番号(), is(DbT7033GappeiNaiJutokushaShinKyuNoHenkanEntityGenerator.DEFAULT_履歴番号));
        }

        @Test
        public void 戻り値の識別コード_措置元は_設定した値と同じ識別コード_措置元を返す() {
            sut.set識別コード_措置元(DbT7033GappeiNaiJutokushaShinKyuNoHenkanEntityGenerator.DEFAULT_識別コード_措置元);
            assertThat(sut.get識別コード_措置元(), is(DbT7033GappeiNaiJutokushaShinKyuNoHenkanEntityGenerator.DEFAULT_識別コード_措置元));
        }

        @Test
        public void 戻り値の市町村コードは_設定した値と同じ市町村コードを返す() {
            sut.set市町村コード(DbT7033GappeiNaiJutokushaShinKyuNoHenkanEntityGenerator.DEFAULT_市町村コード);
            assertThat(sut.get市町村コード(), is(DbT7033GappeiNaiJutokushaShinKyuNoHenkanEntityGenerator.DEFAULT_市町村コード));
        }

        @Test
        public void 戻り値の市町村コード_措置元は_設定した値と同じ市町村コード_措置元を返す() {
            sut.set市町村コード_措置元(DbT7033GappeiNaiJutokushaShinKyuNoHenkanEntityGenerator.DEFAULT_市町村コード_措置元);
            assertThat(sut.get市町村コード_措置元(), is(DbT7033GappeiNaiJutokushaShinKyuNoHenkanEntityGenerator.DEFAULT_市町村コード_措置元));
        }

        @Test
        public void 戻り値の被保険者番号は_設定した値と同じ被保険者番号を返す() {
            sut.set被保険者番号(DbT7033GappeiNaiJutokushaShinKyuNoHenkanEntityGenerator.DEFAULT_被保険者番号);
            assertThat(sut.get被保険者番号(), is(DbT7033GappeiNaiJutokushaShinKyuNoHenkanEntityGenerator.DEFAULT_被保険者番号));
        }

        @Test
        public void 戻り値の被保険者番号_措置元は_設定した値と同じ被保険者番号_措置元を返す() {
            sut.set被保険者番号_措置元(DbT7033GappeiNaiJutokushaShinKyuNoHenkanEntityGenerator.DEFAULT_被保険者番号_措置元);
            assertThat(sut.get被保険者番号_措置元(), is(DbT7033GappeiNaiJutokushaShinKyuNoHenkanEntityGenerator.DEFAULT_被保険者番号_措置元));
        }

        @Test
        public void 戻り値の開始年月日は_設定した値と同じ開始年月日を返す() {
            sut.set開始年月日(DbT7033GappeiNaiJutokushaShinKyuNoHenkanEntityGenerator.DEFAULT_開始年月日);
            assertThat(sut.get開始年月日(), is(DbT7033GappeiNaiJutokushaShinKyuNoHenkanEntityGenerator.DEFAULT_開始年月日));
        }

        @Test
        public void 戻り値の終了年月日は_設定した値と同じ終了年月日を返す() {
            sut.set終了年月日(DbT7033GappeiNaiJutokushaShinKyuNoHenkanEntityGenerator.DEFAULT_終了年月日);
            assertThat(sut.get終了年月日(), is(DbT7033GappeiNaiJutokushaShinKyuNoHenkanEntityGenerator.DEFAULT_終了年月日));
        }
    }

    public static class getStateTest extends DbzTestBase {

        @Test
        public void 状態Addedの取得確認() {
            GappeiNaiJutokushaShinKyuNoHenkanModel sut = new GappeiNaiJutokushaShinKyuNoHenkanModel();

            assertThat(sut.getState(), is(EntityDataState.Added));
        }

       // @Test
        // public void 状態Modifinedの取得確認() {
        // GappeiNaiJutokushaShinKyuNoHenkanModel sut = new GappeiNaiJutokushaShinKyuNoHenkanModel();
        //sut.setEntity(DbT7033GappeiNaiJutokushaShinKyuNoHenkanEntityGenerator.createDbT7033GappeiNaiJutokushaShinKyuNoHenkanEntity());
        // sut.getEntity().initializeMd5();
        // TODO主キー以外の項目を変更してください
        //sut.getEntity().setXXX(new XXX());
        //assertThat(sut.getState(), is(EntityDataState.Modified));
        //}
        @Test
        public void 状態Unchangedの取得確認() {
            GappeiNaiJutokushaShinKyuNoHenkanModel sut = new GappeiNaiJutokushaShinKyuNoHenkanModel();
            sut.setEntity(DbT7033GappeiNaiJutokushaShinKyuNoHenkanEntityGenerator.createDbT7033GappeiNaiJutokushaShinKyuNoHenkanEntity());

            sut.getEntity().initializeMd5();

            assertThat(sut.getState(), is(EntityDataState.Unchanged));
        }

        @Test
        public void 状態Deletedの取得確認() {
            GappeiNaiJutokushaShinKyuNoHenkanModel sut = new GappeiNaiJutokushaShinKyuNoHenkanModel();
            sut.setEntity(DbT7033GappeiNaiJutokushaShinKyuNoHenkanEntityGenerator.createDbT7033GappeiNaiJutokushaShinKyuNoHenkanEntity());

            sut.getEntity().initializeMd5();

            sut.setDeletedState(true);

            assertThat(sut.getState(), is(EntityDataState.Deleted));
        }
    }
}
