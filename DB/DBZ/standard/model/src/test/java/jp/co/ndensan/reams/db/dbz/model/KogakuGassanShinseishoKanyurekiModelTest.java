/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.model;

import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT3069KogakuGassanShinseishoKanyurekiEntityGenerator;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link KogakuGassanShinseishoKanyurekiModel}のテストクラスです。
 *
 * @author LDNS 周杏月
 */
@RunWith(Enclosed.class)
public class KogakuGassanShinseishoKanyurekiModelTest extends DbzTestBase {

    public static class getterSetterTest extends DbzTestBase {

        private static KogakuGassanShinseishoKanyurekiModel sut;

        @BeforeClass
        public static void test() {
            sut = new KogakuGassanShinseishoKanyurekiModel();
        }

        @Test
        public void 戻り値の被保険者番号は_設定した値と同じ被保険者番号を返す() {
            sut.set被保険者番号(DbT3069KogakuGassanShinseishoKanyurekiEntityGenerator.DEFAULT_被保険者番号);
            assertThat(sut.get被保険者番号(), is(DbT3069KogakuGassanShinseishoKanyurekiEntityGenerator.DEFAULT_被保険者番号));
        }

        @Test
        public void 戻り値の対象年度は_設定した値と同じ対象年度を返す() {
            sut.set対象年度(DbT3069KogakuGassanShinseishoKanyurekiEntityGenerator.DEFAULT_対象年度);
            assertThat(sut.get対象年度(), is(DbT3069KogakuGassanShinseishoKanyurekiEntityGenerator.DEFAULT_対象年度));
        }

        @Test
        public void 戻り値の保険者番号は_設定した値と同じ保険者番号を返す() {
            sut.set保険者番号(DbT3069KogakuGassanShinseishoKanyurekiEntityGenerator.DEFAULT_保険者番号);
            assertThat(sut.get保険者番号(), is(DbT3069KogakuGassanShinseishoKanyurekiEntityGenerator.DEFAULT_保険者番号));
        }

        @Test
        public void 戻り値の整理番号は_設定した値と同じ整理番号を返す() {
            sut.set整理番号(DbT3069KogakuGassanShinseishoKanyurekiEntityGenerator.DEFAULT_整理番号);
            assertThat(sut.get整理番号(), is(DbT3069KogakuGassanShinseishoKanyurekiEntityGenerator.DEFAULT_整理番号));
        }

        @Test
        public void 戻り値の加入歴番号は_設定した値と同じ加入歴番号を返す() {
            sut.set加入歴番号(DbT3069KogakuGassanShinseishoKanyurekiEntityGenerator.DEFAULT_加入歴番号);
            assertThat(sut.get加入歴番号(), is(DbT3069KogakuGassanShinseishoKanyurekiEntityGenerator.DEFAULT_加入歴番号));
        }

        @Test
        public void 戻り値の処理日時は_設定した値と同じ処理日時を返す() {
            sut.set処理日時(DbT3069KogakuGassanShinseishoKanyurekiEntityGenerator.DEFAULT_処理日時);
            assertThat(sut.get処理日時(), is(DbT3069KogakuGassanShinseishoKanyurekiEntityGenerator.DEFAULT_処理日時));
        }

        @Test
        public void 戻り値の保険者名は_設定した値と同じ保険者名を返す() {
            sut.set保険者名(DbT3069KogakuGassanShinseishoKanyurekiEntityGenerator.DEFAULT_保険者名);
            assertThat(sut.get保険者名(), is(DbT3069KogakuGassanShinseishoKanyurekiEntityGenerator.DEFAULT_保険者名));
        }

        @Test
        public void 戻り値の加入期間開始年月日は_設定した値と同じ加入期間開始年月日を返す() {
            sut.set加入期間開始年月日(DbT3069KogakuGassanShinseishoKanyurekiEntityGenerator.DEFAULT_加入期間開始年月日);
            assertThat(sut.get加入期間開始年月日(), is(DbT3069KogakuGassanShinseishoKanyurekiEntityGenerator.DEFAULT_加入期間開始年月日));
        }

        @Test
        public void 戻り値の加入期間終了年月日は_設定した値と同じ加入期間終了年月日を返す() {
            sut.set加入期間終了年月日(DbT3069KogakuGassanShinseishoKanyurekiEntityGenerator.DEFAULT_加入期間終了年月日);
            assertThat(sut.get加入期間終了年月日(), is(DbT3069KogakuGassanShinseishoKanyurekiEntityGenerator.DEFAULT_加入期間終了年月日));
        }

        @Test
        public void 戻り値の自己負担額証明書整理番号は_設定した値と同じ自己負担額証明書整理番号を返す() {
            sut.set自己負担額証明書整理番号(DbT3069KogakuGassanShinseishoKanyurekiEntityGenerator.DEFAULT_自己負担額証明書整理番号);
            assertThat(sut.get自己負担額証明書整理番号(), is(DbT3069KogakuGassanShinseishoKanyurekiEntityGenerator.DEFAULT_自己負担額証明書整理番号));
        }
    }

    public static class getStateTest extends DbzTestBase {

        @Test
        public void 状態Addedの取得確認() {
            KogakuGassanShinseishoKanyurekiModel sut = new KogakuGassanShinseishoKanyurekiModel();

            assertThat(sut.getState(), is(EntityDataState.Added));
        }

       // @Test
        // public void 状態Modifinedの取得確認() {
        // KogakuGassanShinseishoKanyurekiModel sut = new KogakuGassanShinseishoKanyurekiModel();
        //sut.setEntity(DbT3069KogakuGassanShinseishoKanyurekiEntityGenerator.createDbT3069KogakuGassanShinseishoKanyurekiEntity());
           // sut.getEntity().initializeMd5();
            // TODO主キー以外の項目を変更してください
        //sut.getEntity().setXXX(new XXX());
            //assertThat(sut.getState(), is(EntityDataState.Modified));
        //}
        @Test
        public void 状態Unchangedの取得確認() {
            KogakuGassanShinseishoKanyurekiModel sut = new KogakuGassanShinseishoKanyurekiModel();
            sut.setEntity(DbT3069KogakuGassanShinseishoKanyurekiEntityGenerator.createDbT3069KogakuGassanShinseishoKanyurekiEntity());

            sut.getEntity().initializeMd5();

            assertThat(sut.getState(), is(EntityDataState.Unchanged));
        }

        @Test
        public void 状態Deletedの取得確認() {
            KogakuGassanShinseishoKanyurekiModel sut = new KogakuGassanShinseishoKanyurekiModel();
            sut.setEntity(DbT3069KogakuGassanShinseishoKanyurekiEntityGenerator.createDbT3069KogakuGassanShinseishoKanyurekiEntity());

            sut.getEntity().initializeMd5();

            sut.setDeletedState(true);

            assertThat(sut.getState(), is(EntityDataState.Deleted));
        }
    }
}
