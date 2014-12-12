/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.model;

import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT7031ShinKyuTekiyoJogaiShisetsuNoHenkanEntityGenerator;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link ShinKyuTekiyoJogaiShisetsuNoHenkanModel}のテストクラスです。
 *
 * @author LDNS 宋昕沢
 */
@RunWith(Enclosed.class)
public class ShinKyuTekiyoJogaiShisetsuNoHenkanModelTest extends DbzTestBase {

    public static class getterSetterTest extends DbzTestBase {

        private static ShinKyuTekiyoJogaiShisetsuNoHenkanModel sut;

        @BeforeClass
        public static void test() {
            sut = new ShinKyuTekiyoJogaiShisetsuNoHenkanModel();
        }

        @Test
        public void 戻り値の市町村コードは_設定した値と同じ市町村コードを返す() {
            sut.set市町村コード(DbT7031ShinKyuTekiyoJogaiShisetsuNoHenkanEntityGenerator.DEFAULT_市町村コード);
            assertThat(sut.get市町村コード(), is(DbT7031ShinKyuTekiyoJogaiShisetsuNoHenkanEntityGenerator.DEFAULT_市町村コード));
        }

        @Test
        public void 戻り値の新適用除外施設番号は_設定した値と同じ新適用除外施設番号を返す() {
            sut.set新適用除外施設番号(DbT7031ShinKyuTekiyoJogaiShisetsuNoHenkanEntityGenerator.DEFAULT_新適用除外施設番号);
            assertThat(sut.get新適用除外施設番号(), is(DbT7031ShinKyuTekiyoJogaiShisetsuNoHenkanEntityGenerator.DEFAULT_新適用除外施設番号));
        }

        @Test
        public void 戻り値の旧適用除外施設番号は_設定した値と同じ旧適用除外施設番号を返す() {
            sut.set旧適用除外施設番号(DbT7031ShinKyuTekiyoJogaiShisetsuNoHenkanEntityGenerator.DEFAULT_旧適用除外施設番号);
            assertThat(sut.get旧適用除外施設番号(), is(DbT7031ShinKyuTekiyoJogaiShisetsuNoHenkanEntityGenerator.DEFAULT_旧適用除外施設番号));
        }

        @Test
        public void 戻り値の市町村コード２は_設定した値と同じ市町村コード２を返す() {
            sut.set市町村コード２(DbT7031ShinKyuTekiyoJogaiShisetsuNoHenkanEntityGenerator.DEFAULT_市町村コード２);
            assertThat(sut.get市町村コード２(), is(DbT7031ShinKyuTekiyoJogaiShisetsuNoHenkanEntityGenerator.DEFAULT_市町村コード２));
        }

        @Test
        public void 戻り値の旧適用除外施設番号２は_設定した値と同じ旧適用除外施設番号２を返す() {
            sut.set旧適用除外施設番号２(DbT7031ShinKyuTekiyoJogaiShisetsuNoHenkanEntityGenerator.DEFAULT_旧適用除外施設番号２);
            assertThat(sut.get旧適用除外施設番号２(), is(DbT7031ShinKyuTekiyoJogaiShisetsuNoHenkanEntityGenerator.DEFAULT_旧適用除外施設番号２));
        }
    }

    public static class getStateTest extends DbzTestBase {

        @Test
        public void 状態Addedの取得確認() {
            ShinKyuTekiyoJogaiShisetsuNoHenkanModel sut = new ShinKyuTekiyoJogaiShisetsuNoHenkanModel();

            assertThat(sut.getState(), is(EntityDataState.Added));
        }

        @Test
        public void 状態Modifinedの取得確認() {
            ShinKyuTekiyoJogaiShisetsuNoHenkanModel sut = new ShinKyuTekiyoJogaiShisetsuNoHenkanModel();
            sut.setEntity(DbT7031ShinKyuTekiyoJogaiShisetsuNoHenkanEntityGenerator.createDbT7031ShinKyuTekiyoJogaiShisetsuNoHenkanEntity());

            sut.getEntity().initializeMd5();

            // TODO 主キー以外の項目を変更してください
//            sut.getEntity().setXXX(new XXX());
//            assertThat(sut.getState(), is(EntityDataState.Modified));
        }

        @Test
        public void 状態Unchangedの取得確認() {
            ShinKyuTekiyoJogaiShisetsuNoHenkanModel sut = new ShinKyuTekiyoJogaiShisetsuNoHenkanModel();
            sut.setEntity(DbT7031ShinKyuTekiyoJogaiShisetsuNoHenkanEntityGenerator.createDbT7031ShinKyuTekiyoJogaiShisetsuNoHenkanEntity());

            sut.getEntity().initializeMd5();

            assertThat(sut.getState(), is(EntityDataState.Unchanged));
        }

        @Test
        public void 状態Deletedの取得確認() {
            ShinKyuTekiyoJogaiShisetsuNoHenkanModel sut = new ShinKyuTekiyoJogaiShisetsuNoHenkanModel();
            sut.setEntity(DbT7031ShinKyuTekiyoJogaiShisetsuNoHenkanEntityGenerator.createDbT7031ShinKyuTekiyoJogaiShisetsuNoHenkanEntity());

            sut.getEntity().initializeMd5();

            sut.setDeletedState(true);

            assertThat(sut.getState(), is(EntityDataState.Deleted));
        }
    }
}
