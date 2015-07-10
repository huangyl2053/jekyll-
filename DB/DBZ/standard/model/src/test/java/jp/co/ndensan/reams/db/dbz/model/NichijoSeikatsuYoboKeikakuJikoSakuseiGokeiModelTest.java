/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.model;

import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT3012NichijoSeikatsuYoboKeikakuJikoSakuseiGokeiEntityGenerator;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link NichijoSeikatsuYoboKeikakuJikoSakuseiGokeiModel}のテストクラスです。
 *
 * @author LDNS 鄭雪双
 */
@RunWith(Enclosed.class)
public class NichijoSeikatsuYoboKeikakuJikoSakuseiGokeiModelTest extends DbzTestBase {

    public static class getterSetterTest extends DbzTestBase {

        private static NichijoSeikatsuYoboKeikakuJikoSakuseiGokeiModel sut;

        @BeforeClass
        public static void test() {
            sut = new NichijoSeikatsuYoboKeikakuJikoSakuseiGokeiModel();
        }

        @Test
        public void 戻り値の被保険者番号は_設定した値と同じ被保険者番号を返す() {
            sut.set被保険者番号(DbT3012NichijoSeikatsuYoboKeikakuJikoSakuseiGokeiEntityGenerator.DEFAULT_被保険者番号);
            assertThat(sut.get被保険者番号(), is(DbT3012NichijoSeikatsuYoboKeikakuJikoSakuseiGokeiEntityGenerator.DEFAULT_被保険者番号));
        }

        @Test
        public void 戻り値の証記載保険者番号は_設定した値と同じ証記載保険者番号を返す() {
            sut.set証記載保険者番号(DbT3012NichijoSeikatsuYoboKeikakuJikoSakuseiGokeiEntityGenerator.DEFAULT_証記載保険者番号);
            assertThat(sut.get証記載保険者番号(), is(DbT3012NichijoSeikatsuYoboKeikakuJikoSakuseiGokeiEntityGenerator.DEFAULT_証記載保険者番号));
        }

        @Test
        public void 戻り値の識別コードは_設定した値と同じ識別コードを返す() {
            sut.set識別コード(DbT3012NichijoSeikatsuYoboKeikakuJikoSakuseiGokeiEntityGenerator.DEFAULT_識別コード);
            assertThat(sut.get識別コード(), is(DbT3012NichijoSeikatsuYoboKeikakuJikoSakuseiGokeiEntityGenerator.DEFAULT_識別コード));
        }

        @Test
        public void 戻り値の対象年月は_設定した値と同じ対象年月を返す() {
            sut.set対象年月(DbT3012NichijoSeikatsuYoboKeikakuJikoSakuseiGokeiEntityGenerator.DEFAULT_対象年月);
            assertThat(sut.get対象年月(), is(DbT3012NichijoSeikatsuYoboKeikakuJikoSakuseiGokeiEntityGenerator.DEFAULT_対象年月));
        }

        @Test
        public void 戻り値の処理日時は_設定した値と同じ処理日時を返す() {
            sut.set処理日時(DbT3012NichijoSeikatsuYoboKeikakuJikoSakuseiGokeiEntityGenerator.DEFAULT_処理日時);
            assertThat(sut.get処理日時(), is(DbT3012NichijoSeikatsuYoboKeikakuJikoSakuseiGokeiEntityGenerator.DEFAULT_処理日時));
        }

        @Test
        public void 戻り値の居宅サービス区分は_設定した値と同じ居宅サービス区分を返す() {
            sut.set居宅サービス区分(DbT3012NichijoSeikatsuYoboKeikakuJikoSakuseiGokeiEntityGenerator.DEFAULT_居宅サービス区分);
            assertThat(sut.get居宅サービス区分(), is(DbT3012NichijoSeikatsuYoboKeikakuJikoSakuseiGokeiEntityGenerator.DEFAULT_居宅サービス区分));
        }

        @Test
        public void 戻り値のサービス提供事業者番号は_設定した値と同じサービス提供事業者番号を返す() {
            sut.setサービス提供事業者番号(DbT3012NichijoSeikatsuYoboKeikakuJikoSakuseiGokeiEntityGenerator.DEFAULT_サービス提供事業者番号);
            assertThat(sut.getサービス提供事業者番号(), is(DbT3012NichijoSeikatsuYoboKeikakuJikoSakuseiGokeiEntityGenerator.DEFAULT_サービス提供事業者番号));
        }

        @Test
        public void 戻り値のサービス種類コードは_設定した値と同じサービス種類コードを返す() {
            sut.setサービス種類コード(DbT3012NichijoSeikatsuYoboKeikakuJikoSakuseiGokeiEntityGenerator.DEFAULT_サービス種類コード);
            assertThat(sut.getサービス種類コード(), is(DbT3012NichijoSeikatsuYoboKeikakuJikoSakuseiGokeiEntityGenerator.DEFAULT_サービス種類コード));
        }

        @Test
        public void 戻り値の給付計画単位数は_設定した値と同じ給付計画単位数を返す() {
            sut.set給付計画単位数(DbT3012NichijoSeikatsuYoboKeikakuJikoSakuseiGokeiEntityGenerator.DEFAULT_給付計画単位数);
            assertThat(sut.get給付計画単位数(), is(DbT3012NichijoSeikatsuYoboKeikakuJikoSakuseiGokeiEntityGenerator.DEFAULT_給付計画単位数));
        }
    }

    public static class getStateTest extends DbzTestBase {

        @Test
        public void 状態Addedの取得確認() {
            NichijoSeikatsuYoboKeikakuJikoSakuseiGokeiModel sut = new NichijoSeikatsuYoboKeikakuJikoSakuseiGokeiModel();

            assertThat(sut.getState(), is(EntityDataState.Added));
        }

        @Test
        public void 状態Modifinedの取得確認() {
            NichijoSeikatsuYoboKeikakuJikoSakuseiGokeiModel sut = new NichijoSeikatsuYoboKeikakuJikoSakuseiGokeiModel();
            sut.setEntity(DbT3012NichijoSeikatsuYoboKeikakuJikoSakuseiGokeiEntityGenerator.createDbT3012NichijoSeikatsuYoboKeikakuJikoSakuseiGokeiEntity());

            sut.getEntity().initializeMd5();

            // 主キー以外の項目を変更してください
//            sut.getEntity().setXXX(new XXX());
//            assertThat(sut.getState(), is(EntityDataState.Modified));
        }

        @Test
        public void 状態Unchangedの取得確認() {
            NichijoSeikatsuYoboKeikakuJikoSakuseiGokeiModel sut = new NichijoSeikatsuYoboKeikakuJikoSakuseiGokeiModel();
            sut.setEntity(DbT3012NichijoSeikatsuYoboKeikakuJikoSakuseiGokeiEntityGenerator.createDbT3012NichijoSeikatsuYoboKeikakuJikoSakuseiGokeiEntity());

            sut.getEntity().initializeMd5();

            assertThat(sut.getState(), is(EntityDataState.Unchanged));
        }

        @Test
        public void 状態Deletedの取得確認() {
            NichijoSeikatsuYoboKeikakuJikoSakuseiGokeiModel sut = new NichijoSeikatsuYoboKeikakuJikoSakuseiGokeiModel();
            sut.setEntity(DbT3012NichijoSeikatsuYoboKeikakuJikoSakuseiGokeiEntityGenerator.createDbT3012NichijoSeikatsuYoboKeikakuJikoSakuseiGokeiEntity());

            sut.getEntity().initializeMd5();

            sut.setDeletedState(true);

            assertThat(sut.getState(), is(EntityDataState.Deleted));
        }
    }
}
