/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.model;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT1002TekiyoJogaishaEntity;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT1002TekiyoJogaishaEntityGenerator;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import static org.hamcrest.CoreMatchers.is;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.BeforeClass;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link TekiyoJogaishaModel}のテストクラスです。
 *
 * @author n8178 城間篤人
 */
@RunWith(Enclosed.class)
public class TekiyoJogaishaModelTest extends DbzTestBase {

    public static class getterSetterTest extends DbzTestBase {

        private static TekiyoJogaishaModel sut;

        @BeforeClass
        public static void test() {
            sut = new TekiyoJogaishaModel();
        }

        @Test
        public void 戻り値の市町村コードは_設定した値と同じ市町村コードを返す() {
            sut.set市町村コード(DbT1002TekiyoJogaishaEntityGenerator.DEFAULT_市町村コード);
            assertThat(sut.get市町村コード(), is(DbT1002TekiyoJogaishaEntityGenerator.DEFAULT_市町村コード));
        }

        @Test
        public void 戻り値の識別コードは_設定した値と同じ識別コードを返す() {
            sut.set識別コード(DbT1002TekiyoJogaishaEntityGenerator.DEFAULT_識別コード);
            assertThat(sut.get識別コード(), is(DbT1002TekiyoJogaishaEntityGenerator.DEFAULT_識別コード));
        }

        @Test
        public void 戻り値の処理日時は_設定した値と同じ処理日時を返す() {
            sut.set処理日時(DbT1002TekiyoJogaishaEntityGenerator.DEFAULT_処理日時);
            assertThat(sut.get処理日時(), is(DbT1002TekiyoJogaishaEntityGenerator.DEFAULT_処理日時));
        }

        @Test
        public void 戻り値の適用除外適用事由コードは_設定した値と同じ適用除外適用事由コードを返す() {
            sut.set適用除外適用事由コード(DbT1002TekiyoJogaishaEntityGenerator.DEFAULT_適用除外適用事由コード);
            assertThat(sut.get適用除外適用事由コード(), is(DbT1002TekiyoJogaishaEntityGenerator.DEFAULT_適用除外適用事由コード));
        }

        @Test
        public void 戻り値の適用年月日は_設定した値と同じ適用年月日を返す() {
            sut.set適用年月日(DbT1002TekiyoJogaishaEntityGenerator.DEFAULT_適用年月日);
            assertThat(sut.get適用年月日(), is(DbT1002TekiyoJogaishaEntityGenerator.DEFAULT_適用年月日));
        }

        @Test
        public void 戻り値の適用届出年月日は_設定した値と同じ適用届出年月日を返す() {
            sut.set適用届出年月日(DbT1002TekiyoJogaishaEntityGenerator.DEFAULT_適用届出年月日);
            assertThat(sut.get適用届出年月日(), is(DbT1002TekiyoJogaishaEntityGenerator.DEFAULT_適用届出年月日));
        }

        @Test
        public void 戻り値の適用受付年月日は_設定した値と同じ適用受付年月日を返す() {
            sut.set適用受付年月日(DbT1002TekiyoJogaishaEntityGenerator.DEFAULT_適用受付年月日);
            assertThat(sut.get適用受付年月日(), is(DbT1002TekiyoJogaishaEntityGenerator.DEFAULT_適用受付年月日));
        }

        @Test
        public void 戻り値の適用除外解除事由コードは_設定した値と同じ適用除外解除事由コードを返す() {
            sut.set適用除外解除事由コード(DbT1002TekiyoJogaishaEntityGenerator.DEFAULT_適用除外解除事由コード);
            assertThat(sut.get適用除外解除事由コード(), is(DbT1002TekiyoJogaishaEntityGenerator.DEFAULT_適用除外解除事由コード));
        }

        @Test
        public void 戻り値の解除年月日は_設定した値と同じ解除年月日を返す() {
            sut.set解除年月日(DbT1002TekiyoJogaishaEntityGenerator.DEFAULT_解除年月日);
            assertThat(sut.get解除年月日(), is(DbT1002TekiyoJogaishaEntityGenerator.DEFAULT_解除年月日));
        }

        @Test
        public void 戻り値の解除届出年月日は_設定した値と同じ解除届出年月日を返す() {
            sut.set解除届出年月日(DbT1002TekiyoJogaishaEntityGenerator.DEFAULT_解除届出年月日);
            assertThat(sut.get解除届出年月日(), is(DbT1002TekiyoJogaishaEntityGenerator.DEFAULT_解除届出年月日));
        }

        @Test
        public void 戻り値の解除受付年月日は_設定した値と同じ解除受付年月日を返す() {
            sut.set解除受付年月日(DbT1002TekiyoJogaishaEntityGenerator.DEFAULT_解除受付年月日);
            assertThat(sut.get解除受付年月日(), is(DbT1002TekiyoJogaishaEntityGenerator.DEFAULT_解除受付年月日));
        }

        @Test
        public void 戻り値の入所通知発行日は_設定した値と同じ入所通知発行日を返す() {
            sut.set入所通知発行日(DbT1002TekiyoJogaishaEntityGenerator.DEFAULT_入所通知発行日);
            assertThat(sut.get入所通知発行日(), is(DbT1002TekiyoJogaishaEntityGenerator.DEFAULT_入所通知発行日));
        }

        @Test
        public void 戻り値の退所通知発行日は_設定した値と同じ退所通知発行日を返す() {
            sut.set退所通知発行日(DbT1002TekiyoJogaishaEntityGenerator.DEFAULT_退所通知発行日);
            assertThat(sut.get退所通知発行日(), is(DbT1002TekiyoJogaishaEntityGenerator.DEFAULT_退所通知発行日));
        }

        @Test
        public void 戻り値の変更通知発行日は_設定した値と同じ変更通知発行日を返す() {
            sut.set変更通知発行日(DbT1002TekiyoJogaishaEntityGenerator.DEFAULT_変更通知発行日);
            assertThat(sut.get変更通知発行日(), is(DbT1002TekiyoJogaishaEntityGenerator.DEFAULT_変更通知発行日));
        }
    }

    public static class getStateTest extends DbzTestBase {

        @Test
        public void 状態Addedの取得確認() {
            TekiyoJogaishaModel sut = new TekiyoJogaishaModel();

            assertThat(sut.getState(), is(EntityDataState.Added));
        }

        @Test
        public void 状態Modifinedの取得確認() {
            TekiyoJogaishaModel sut = new TekiyoJogaishaModel();
            sut.setEntity(DbT1002TekiyoJogaishaEntityGenerator.createDbT1002TekiyoJogaishaEntity());

            sut.getEntity().initializeMd5();
            sut.getEntity().setTekiyoYMD(new FlexibleDate("20190303"));

            assertThat(sut.getState(), is(EntityDataState.Modified));
        }

        @Test
        public void 状態Unchangedの取得確認() {
            TekiyoJogaishaModel sut = new TekiyoJogaishaModel();
            sut.setEntity(DbT1002TekiyoJogaishaEntityGenerator.createDbT1002TekiyoJogaishaEntity());

            sut.getEntity().initializeMd5();

            assertThat(sut.getState(), is(EntityDataState.Unchanged));
        }

        @Test
        public void 状態Deletedの取得確認() {
            TekiyoJogaishaModel sut = new TekiyoJogaishaModel();
            sut.setEntity(DbT1002TekiyoJogaishaEntityGenerator.createDbT1002TekiyoJogaishaEntity());

            sut.getEntity().initializeMd5();

            sut.setDeletedState(true);

            assertThat(sut.getState(), is(EntityDataState.Deleted));
        }
    }
}
