/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.model;

import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT1003TashichosonJushochiTokureiEntityGenerator;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import static org.hamcrest.CoreMatchers.is;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.BeforeClass;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link TashichosonJushochiTokureiModel}のテストクラスです。
 *
 * @author n8178 城間篤人
 */
@RunWith(Enclosed.class)
public class TashichosonJushochiTokureiModelTest extends DbzTestBase {

    public static class getterSetterTest extends DbzTestBase {

        private static TashichosonJushochiTokureiModel sut;

        @BeforeClass
        public static void test() {
            sut = new TashichosonJushochiTokureiModel();
        }

        @Test
        public void 戻り値の市町村コードは_設定した値と同じ市町村コードを返す() {
            sut.set市町村コード(DbT1003TashichosonJushochiTokureiEntityGenerator.DEFAULT_市町村コード);
            assertThat(sut.get市町村コード(), is(DbT1003TashichosonJushochiTokureiEntityGenerator.DEFAULT_市町村コード));
        }

        @Test
        public void 戻り値の識別コードコードは_設定した値と同じ識別コードコードを返す() {
            sut.set識別コード(DbT1003TashichosonJushochiTokureiEntityGenerator.DEFAULT_識別コード);
            assertThat(sut.get識別コード(), is(DbT1003TashichosonJushochiTokureiEntityGenerator.DEFAULT_識別コード));
        }

        @Test
        public void 戻り値の処理日時は_設定した値と同じ処理日時を返す() {
            sut.set処理日時(DbT1003TashichosonJushochiTokureiEntityGenerator.DEFAULT_処理日時);
            assertThat(sut.get処理日時(), is(DbT1003TashichosonJushochiTokureiEntityGenerator.DEFAULT_処理日時));
        }

        @Test
        public void 戻り値の他市町村住所地特例適用事由コードは_設定した値と同じ他市町村住所地特例適用事由コードを返す() {
            sut.set他市町村住所地特例適用事由コード(DbT1003TashichosonJushochiTokureiEntityGenerator.DEFAULT_他市町村住所地特例適用事由コード);
            assertThat(sut.get他市町村住所地特例適用事由コード(), is(DbT1003TashichosonJushochiTokureiEntityGenerator.DEFAULT_他市町村住所地特例適用事由コード));
        }

        @Test
        public void 戻り値の適用年月日は_設定した値と同じ適用年月日を返す() {
            sut.set適用年月日(DbT1003TashichosonJushochiTokureiEntityGenerator.DEFAULT_適用年月日);
            assertThat(sut.get適用年月日(), is(DbT1003TashichosonJushochiTokureiEntityGenerator.DEFAULT_適用年月日));
        }

        @Test
        public void 戻り値の適用届出年月日は_設定した値と同じ適用届出年月日を返す() {
            sut.set適用届出年月日(DbT1003TashichosonJushochiTokureiEntityGenerator.DEFAULT_適用届出年月日);
            assertThat(sut.get適用届出年月日(), is(DbT1003TashichosonJushochiTokureiEntityGenerator.DEFAULT_適用届出年月日));
        }

        @Test
        public void 戻り値の適用受付年月日は_設定した値と同じ適用受付年月日を返す() {
            sut.set適用受付年月日(DbT1003TashichosonJushochiTokureiEntityGenerator.DEFAULT_適用受付年月日);
            assertThat(sut.get適用受付年月日(), is(DbT1003TashichosonJushochiTokureiEntityGenerator.DEFAULT_適用受付年月日));
        }

        @Test
        public void 戻り値の他市町村住所地特例解除事由コードは_設定した値と同じ他市町村住所地特例解除事由コードを返す() {
            sut.set他市町村住所地特例解除事由コード(DbT1003TashichosonJushochiTokureiEntityGenerator.DEFAULT_他市町村住所地特例解除事由コード);
            assertThat(sut.get他市町村住所地特例解除事由コード(), is(DbT1003TashichosonJushochiTokureiEntityGenerator.DEFAULT_他市町村住所地特例解除事由コード));
        }

        @Test
        public void 戻り値の解除年月日は_設定した値と同じ解除年月日を返す() {
            sut.set解除年月日(DbT1003TashichosonJushochiTokureiEntityGenerator.DEFAULT_解除年月日);
            assertThat(sut.get解除年月日(), is(DbT1003TashichosonJushochiTokureiEntityGenerator.DEFAULT_解除年月日));
        }

        @Test
        public void 戻り値の解除届出年月日は_設定した値と同じ解除届出年月日を返す() {
            sut.set解除届出年月日(DbT1003TashichosonJushochiTokureiEntityGenerator.DEFAULT_解除届出年月日);
            assertThat(sut.get解除届出年月日(), is(DbT1003TashichosonJushochiTokureiEntityGenerator.DEFAULT_解除届出年月日));
        }

        @Test
        public void 戻り値の解除受付年月日は_設定した値と同じ解除受付年月日を返す() {
            sut.set解除受付年月日(DbT1003TashichosonJushochiTokureiEntityGenerator.DEFAULT_解除受付年月日);
            assertThat(sut.get解除受付年月日(), is(DbT1003TashichosonJushochiTokureiEntityGenerator.DEFAULT_解除受付年月日));
        }

        @Test
        public void 戻り値の措置保険者番号は_設定した値と同じ措置保険者番号を返す() {
            sut.set措置保険者番号(DbT1003TashichosonJushochiTokureiEntityGenerator.DEFAULT_措置保険者番号);
            assertThat(sut.get措置保険者番号(), is(DbT1003TashichosonJushochiTokureiEntityGenerator.DEFAULT_措置保険者番号));
        }

        @Test
        public void 戻り値の措置被保険者番号は_設定した値と同じ措置被保険者番号を返す() {
            sut.set措置被保険者番号(DbT1003TashichosonJushochiTokureiEntityGenerator.DEFAULT_措置被保険者番号);
            assertThat(sut.get措置被保険者番号(), is(DbT1003TashichosonJushochiTokureiEntityGenerator.DEFAULT_措置被保険者番号));
        }

        @Test
        public void 戻り値の他特例連絡票発行年月日は_設定した値と同じ他特例連絡票発行年月日を返す() {
            sut.set他特例連絡票発行年月日(DbT1003TashichosonJushochiTokureiEntityGenerator.DEFAULT_他特例連絡票発行年月日);
            assertThat(sut.get他特例連絡票発行年月日(), is(DbT1003TashichosonJushochiTokureiEntityGenerator.DEFAULT_他特例連絡票発行年月日));
        }

        @Test
        public void 戻り値の施設退所通知発行年月日は_設定した値と同じ施設退所通知発行年月日を返す() {
            sut.set施設退所通知発行年月日(DbT1003TashichosonJushochiTokureiEntityGenerator.DEFAULT_施設退所通知発行年月日);
            assertThat(sut.get施設退所通知発行年月日(), is(DbT1003TashichosonJushochiTokureiEntityGenerator.DEFAULT_施設退所通知発行年月日));
        }

        @Test
        public void 戻り値の施設変更通知発行年月日は_設定した値と同じ施設変更通知発行年月日を返す() {
            sut.set施設変更通知発行年月日(DbT1003TashichosonJushochiTokureiEntityGenerator.DEFAULT_施設変更通知発行年月日);
            assertThat(sut.get施設変更通知発行年月日(), is(DbT1003TashichosonJushochiTokureiEntityGenerator.DEFAULT_施設変更通知発行年月日));
        }
    }

    public static class getStateTest extends DbzTestBase {

        @Test
        public void 状態Addedの取得確認() {
            TashichosonJushochiTokureiModel sut = new TashichosonJushochiTokureiModel();

            assertThat(sut.getState(), is(EntityDataState.Added));
        }

        @Test
        public void 状態Modifinedの取得確認() {
            TashichosonJushochiTokureiModel sut = new TashichosonJushochiTokureiModel();
            sut.setEntity(DbT1003TashichosonJushochiTokureiEntityGenerator.createDbT1003TashichosonJushochiTokureiEntity());

            sut.getEntity().initializeMd5();
            sut.getEntity().setTekiyoYMD(new FlexibleDate("20151212"));

            assertThat(sut.getState(), is(EntityDataState.Modified));
        }

        @Test
        public void 状態Unchangedの取得確認() {
            TashichosonJushochiTokureiModel sut = new TashichosonJushochiTokureiModel();
            sut.setEntity(DbT1003TashichosonJushochiTokureiEntityGenerator.createDbT1003TashichosonJushochiTokureiEntity());

            sut.getEntity().initializeMd5();

            assertThat(sut.getState(), is(EntityDataState.Unchanged));
        }

        @Test
        public void 状態Deletedの取得確認() {
            TashichosonJushochiTokureiModel sut = new TashichosonJushochiTokureiModel();
            sut.setEntity(DbT1003TashichosonJushochiTokureiEntityGenerator.createDbT1003TashichosonJushochiTokureiEntity());

            sut.getEntity().initializeMd5();

            sut.setDeletedState(true);

            assertThat(sut.getState(), is(EntityDataState.Deleted));
        }
    }
}
