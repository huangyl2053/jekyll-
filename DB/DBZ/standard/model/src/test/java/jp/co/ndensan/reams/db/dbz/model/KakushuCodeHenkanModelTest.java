/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.model;

import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT7027KakushuCodeHenkanEntityGenerator;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link KakushuCodeHenkanModel}のテストクラスです。
 *
 * @author LDNS 宋昕沢
 */
@RunWith(Enclosed.class)
public class KakushuCodeHenkanModelTest extends DbzTestBase {

    public static class getterSetterTest extends DbzTestBase {

        private static KakushuCodeHenkanModel sut;

        @BeforeClass
        public static void test() {
            sut = new KakushuCodeHenkanModel();
        }

        @Test
        public void 戻り値の市町村コードは_設定した値と同じ市町村コードを返す() {
            sut.set市町村コード(DbT7027KakushuCodeHenkanEntityGenerator.DEFAULT_市町村コード);
            assertThat(sut.get市町村コード(), is(DbT7027KakushuCodeHenkanEntityGenerator.DEFAULT_市町村コード));
        }

        @Test
        public void 戻り値のコード区分は_設定した値と同じコード区分を返す() {
            sut.setコード区分(DbT7027KakushuCodeHenkanEntityGenerator.DEFAULT_コード区分);
            assertThat(sut.getコード区分(), is(DbT7027KakushuCodeHenkanEntityGenerator.DEFAULT_コード区分));
        }

        @Test
        public void 戻り値の内部コードは_設定した値と同じ内部コードを返す() {
            sut.set内部コード(DbT7027KakushuCodeHenkanEntityGenerator.DEFAULT_内部コード);
            assertThat(sut.get内部コード(), is(DbT7027KakushuCodeHenkanEntityGenerator.DEFAULT_内部コード));
        }

        @Test
        public void 戻り値の内部番号は_設定した値と同じ内部番号を返す() {
            sut.set内部番号(DbT7027KakushuCodeHenkanEntityGenerator.DEFAULT_内部番号);
            assertThat(sut.get内部番号(), is(DbT7027KakushuCodeHenkanEntityGenerator.DEFAULT_内部番号));
        }

        @Test
        public void 戻り値の外部コードは_設定した値と同じ外部コードを返す() {
            sut.set外部コード(DbT7027KakushuCodeHenkanEntityGenerator.DEFAULT_外部コード);
            assertThat(sut.get外部コード(), is(DbT7027KakushuCodeHenkanEntityGenerator.DEFAULT_外部コード));
        }

        @Test
        public void 戻り値の市町村コード２は_設定した値と同じ市町村コード２を返す() {
            sut.set市町村コード２(DbT7027KakushuCodeHenkanEntityGenerator.DEFAULT_市町村コード２);
            assertThat(sut.get市町村コード２(), is(DbT7027KakushuCodeHenkanEntityGenerator.DEFAULT_市町村コード２));
        }

        @Test
        public void 戻り値の外部コード２は_設定した値と同じ外部コード２を返す() {
            sut.set外部コード２(DbT7027KakushuCodeHenkanEntityGenerator.DEFAULT_外部コード２);
            assertThat(sut.get外部コード２(), is(DbT7027KakushuCodeHenkanEntityGenerator.DEFAULT_外部コード２));
        }
    }

    public static class getStateTest extends DbzTestBase {

        @Test
        public void 状態Addedの取得確認() {
            KakushuCodeHenkanModel sut = new KakushuCodeHenkanModel();

            assertThat(sut.getState(), is(EntityDataState.Added));
        }

        @Test
        public void 状態Modifinedの取得確認() {
            KakushuCodeHenkanModel sut = new KakushuCodeHenkanModel();
            sut.setEntity(DbT7027KakushuCodeHenkanEntityGenerator.createDbT7027KakushuCodeHenkanEntity());

            sut.getEntity().initializeMd5();

            // 主キー以外の項目を変更してください
//            sut.getEntity().setXXX(new XXX());
//            assertThat(sut.getState(), is(EntityDataState.Modified));
        }

        @Test
        public void 状態Unchangedの取得確認() {
            KakushuCodeHenkanModel sut = new KakushuCodeHenkanModel();
            sut.setEntity(DbT7027KakushuCodeHenkanEntityGenerator.createDbT7027KakushuCodeHenkanEntity());

            sut.getEntity().initializeMd5();

            assertThat(sut.getState(), is(EntityDataState.Unchanged));
        }

        @Test
        public void 状態Deletedの取得確認() {
            KakushuCodeHenkanModel sut = new KakushuCodeHenkanModel();
            sut.setEntity(DbT7027KakushuCodeHenkanEntityGenerator.createDbT7027KakushuCodeHenkanEntity());

            sut.getEntity().initializeMd5();

            sut.setDeletedState(true);

            assertThat(sut.getState(), is(EntityDataState.Deleted));
        }
    }
}
