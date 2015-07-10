/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.model;

import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT3010KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuEntityGenerator;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuModel}のテストクラスです。
 *
 * @author LDNS 鄭雪双
 */
@RunWith(Enclosed.class)
public class KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuModelTest extends DbzTestBase {

    public static class getterSetterTest extends DbzTestBase {

        private static KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuModel sut;

        @BeforeClass
        public static void test() {
            sut = new KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuModel();
        }

        @Test
        public void 戻り値の被保険者番号は_設定した値と同じ被保険者番号を返す() {
            sut.set被保険者番号(DbT3010KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuEntityGenerator.DEFAULT_被保険者番号);
            assertThat(sut.get被保険者番号(), is(DbT3010KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuEntityGenerator.DEFAULT_被保険者番号));
        }

        @Test
        public void 戻り値の証記載保険者番号は_設定した値と同じ証記載保険者番号を返す() {
            sut.set証記載保険者番号(DbT3010KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuEntityGenerator.DEFAULT_証記載保険者番号);
            assertThat(sut.get証記載保険者番号(), is(DbT3010KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuEntityGenerator.DEFAULT_証記載保険者番号));
        }

        @Test
        public void 戻り値の識別コードは_設定した値と同じ識別コードを返す() {
            sut.set識別コード(DbT3010KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuEntityGenerator.DEFAULT_識別コード);
            assertThat(sut.get識別コード(), is(DbT3010KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuEntityGenerator.DEFAULT_識別コード));
        }

        @Test
        public void 戻り値の対象年月は_設定した値と同じ対象年月を返す() {
            sut.set対象年月(DbT3010KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuEntityGenerator.DEFAULT_対象年月);
            assertThat(sut.get対象年月(), is(DbT3010KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuEntityGenerator.DEFAULT_対象年月));
        }

        @Test
        public void 戻り値の処理日時は_設定した値と同じ処理日時を返す() {
            sut.set処理日時(DbT3010KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuEntityGenerator.DEFAULT_処理日時);
            assertThat(sut.get処理日時(), is(DbT3010KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuEntityGenerator.DEFAULT_処理日時));
        }

        @Test
        public void 戻り値の前回迄利用日数は_設定した値と同じ前回迄利用日数を返す() {
            sut.set前回迄利用日数(DbT3010KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuEntityGenerator.DEFAULT_前回迄利用日数);
            assertThat(sut.get前回迄利用日数(), is(DbT3010KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuEntityGenerator.DEFAULT_前回迄利用日数));
        }

        @Test
        public void 戻り値の今回計画利用日数は_設定した値と同じ今回計画利用日数を返す() {
            sut.set今回計画利用日数(DbT3010KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuEntityGenerator.DEFAULT_今回計画利用日数);
            assertThat(sut.get今回計画利用日数(), is(DbT3010KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuEntityGenerator.DEFAULT_今回計画利用日数));
        }
    }

    public static class getStateTest extends DbzTestBase {

        @Test
        public void 状態Addedの取得確認() {
            KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuModel sut = new KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuModel();

            assertThat(sut.getState(), is(EntityDataState.Added));
        }

        @Test
        public void 状態Modifinedの取得確認() {
            KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuModel sut = new KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuModel();
            sut.setEntity(DbT3010KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuEntityGenerator.createDbT3010KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuEntity());

            sut.getEntity().initializeMd5();

            // 主キー以外の項目を変更してください
//            sut.getEntity().setXXX(new XXX());
//            assertThat(sut.getState(), is(EntityDataState.Modified));
        }

        @Test
        public void 状態Unchangedの取得確認() {
            KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuModel sut = new KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuModel();
            sut.setEntity(DbT3010KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuEntityGenerator.createDbT3010KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuEntity());

            sut.getEntity().initializeMd5();

            assertThat(sut.getState(), is(EntityDataState.Unchanged));
        }

        @Test
        public void 状態Deletedの取得確認() {
            KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuModel sut = new KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuModel();
            sut.setEntity(DbT3010KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuEntityGenerator.createDbT3010KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuEntity());

            sut.getEntity().initializeMd5();

            sut.setDeletedState(true);

            assertThat(sut.getState(), is(EntityDataState.Deleted));
        }
    }
}
