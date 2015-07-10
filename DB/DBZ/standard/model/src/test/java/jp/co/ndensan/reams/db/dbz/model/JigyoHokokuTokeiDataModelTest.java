/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.model;

import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT7021JigyoHokokuTokeiDataEntityGenerator;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link JigyoHokokuTokeiDataModel}のテストクラスです。
 *
 * @author LDNS 宋昕沢
 */
@RunWith(Enclosed.class)
public class JigyoHokokuTokeiDataModelTest extends DbzTestBase {

    public static class getterSetterTest extends DbzTestBase {

        private static JigyoHokokuTokeiDataModel sut;

        @BeforeClass
        public static void test() {
            sut = new JigyoHokokuTokeiDataModel();
        }

        @Test
        public void 戻り値の報告年は_設定した値と同じ報告年を返す() {
            sut.set報告年(DbT7021JigyoHokokuTokeiDataEntityGenerator.DEFAULT_報告年);
            assertThat(sut.get報告年(), is(DbT7021JigyoHokokuTokeiDataEntityGenerator.DEFAULT_報告年));
        }

        @Test
        public void 戻り値の報告月は_設定した値と同じ報告月を返す() {
            sut.set報告月(DbT7021JigyoHokokuTokeiDataEntityGenerator.DEFAULT_報告月);
            assertThat(sut.get報告月(), is(DbT7021JigyoHokokuTokeiDataEntityGenerator.DEFAULT_報告月));
        }

        @Test
        public void 戻り値の集計対象年は_設定した値と同じ集計対象年を返す() {
            sut.set集計対象年(DbT7021JigyoHokokuTokeiDataEntityGenerator.DEFAULT_集計対象年);
            assertThat(sut.get集計対象年(), is(DbT7021JigyoHokokuTokeiDataEntityGenerator.DEFAULT_集計対象年));
        }

        @Test
        public void 戻り値の集計対象月は_設定した値と同じ集計対象月を返す() {
            sut.set集計対象月(DbT7021JigyoHokokuTokeiDataEntityGenerator.DEFAULT_集計対象月);
            assertThat(sut.get集計対象月(), is(DbT7021JigyoHokokuTokeiDataEntityGenerator.DEFAULT_集計対象月));
        }

        @Test
        public void 戻り値の統計対象区分は_設定した値と同じ統計対象区分を返す() {
            sut.set統計対象区分(DbT7021JigyoHokokuTokeiDataEntityGenerator.DEFAULT_統計対象区分);
            assertThat(sut.get統計対象区分(), is(DbT7021JigyoHokokuTokeiDataEntityGenerator.DEFAULT_統計対象区分));
        }

        @Test
        public void 戻り値の市町村コードは_設定した値と同じ市町村コードを返す() {
            sut.set市町村コード(DbT7021JigyoHokokuTokeiDataEntityGenerator.DEFAULT_市町村コード);
            assertThat(sut.get市町村コード(), is(DbT7021JigyoHokokuTokeiDataEntityGenerator.DEFAULT_市町村コード));
        }

        @Test
        public void 戻り値の表番号は_設定した値と同じ表番号を返す() {
            sut.set表番号(DbT7021JigyoHokokuTokeiDataEntityGenerator.DEFAULT_表番号);
            assertThat(sut.get表番号(), is(DbT7021JigyoHokokuTokeiDataEntityGenerator.DEFAULT_表番号));
        }

        @Test
        public void 戻り値の集計番号は_設定した値と同じ集計番号を返す() {
            sut.set集計番号(DbT7021JigyoHokokuTokeiDataEntityGenerator.DEFAULT_集計番号);
            assertThat(sut.get集計番号(), is(DbT7021JigyoHokokuTokeiDataEntityGenerator.DEFAULT_集計番号));
        }

        @Test
        public void 戻り値の集計単位は_設定した値と同じ集計単位を返す() {
            sut.set集計単位(DbT7021JigyoHokokuTokeiDataEntityGenerator.DEFAULT_集計単位);
            assertThat(sut.get集計単位(), is(DbT7021JigyoHokokuTokeiDataEntityGenerator.DEFAULT_集計単位));
        }

        @Test
        public void 戻り値の縦番号は_設定した値と同じ縦番号を返す() {
            sut.set縦番号(DbT7021JigyoHokokuTokeiDataEntityGenerator.DEFAULT_縦番号);
            assertThat(sut.get縦番号(), is(DbT7021JigyoHokokuTokeiDataEntityGenerator.DEFAULT_縦番号));
        }

        @Test
        public void 戻り値の横番号は_設定した値と同じ横番号を返す() {
            sut.set横番号(DbT7021JigyoHokokuTokeiDataEntityGenerator.DEFAULT_横番号);
            assertThat(sut.get横番号(), is(DbT7021JigyoHokokuTokeiDataEntityGenerator.DEFAULT_横番号));
        }

        @Test
        public void 戻り値の処理日時は_設定した値と同じ処理日時を返す() {
            sut.set処理日時(DbT7021JigyoHokokuTokeiDataEntityGenerator.DEFAULT_処理日時);
            assertThat(sut.get処理日時(), is(DbT7021JigyoHokokuTokeiDataEntityGenerator.DEFAULT_処理日時));
        }

        @Test
        public void 戻り値の集計結果値は_設定した値と同じ集計結果値を返す() {
            sut.set集計結果値(DbT7021JigyoHokokuTokeiDataEntityGenerator.DEFAULT_集計結果値);
            assertThat(sut.get集計結果値(), is(DbT7021JigyoHokokuTokeiDataEntityGenerator.DEFAULT_集計結果値));
        }

        @Test
        public void 戻り値の縦項目コードは_設定した値と同じ縦項目コードを返す() {
            sut.set縦項目コード(DbT7021JigyoHokokuTokeiDataEntityGenerator.DEFAULT_縦項目コード);
            assertThat(sut.get縦項目コード(), is(DbT7021JigyoHokokuTokeiDataEntityGenerator.DEFAULT_縦項目コード));
        }

        @Test
        public void 戻り値の横項目コードは_設定した値と同じ横項目コードを返す() {
            sut.set横項目コード(DbT7021JigyoHokokuTokeiDataEntityGenerator.DEFAULT_横項目コード);
            assertThat(sut.get横項目コード(), is(DbT7021JigyoHokokuTokeiDataEntityGenerator.DEFAULT_横項目コード));
        }
    }

    public static class getStateTest extends DbzTestBase {

        @Test
        public void 状態Addedの取得確認() {
            JigyoHokokuTokeiDataModel sut = new JigyoHokokuTokeiDataModel();

            assertThat(sut.getState(), is(EntityDataState.Added));
        }

        @Test
        public void 状態Modifinedの取得確認() {
            JigyoHokokuTokeiDataModel sut = new JigyoHokokuTokeiDataModel();
            sut.setEntity(DbT7021JigyoHokokuTokeiDataEntityGenerator.createDbT7021JigyoHokokuTokeiDataEntity());

            sut.getEntity().initializeMd5();

            //TODO  主キー以外の項目を変更してください
//            sut.getEntity().setXXX(new XXX());
//            assertThat(sut.getState(), is(EntityDataState.Modified));
        }

        @Test
        public void 状態Unchangedの取得確認() {
            JigyoHokokuTokeiDataModel sut = new JigyoHokokuTokeiDataModel();
            sut.setEntity(DbT7021JigyoHokokuTokeiDataEntityGenerator.createDbT7021JigyoHokokuTokeiDataEntity());

            sut.getEntity().initializeMd5();

            assertThat(sut.getState(), is(EntityDataState.Unchanged));
        }

        @Test
        public void 状態Deletedの取得確認() {
            JigyoHokokuTokeiDataModel sut = new JigyoHokokuTokeiDataModel();
            sut.setEntity(DbT7021JigyoHokokuTokeiDataEntityGenerator.createDbT7021JigyoHokokuTokeiDataEntity());

            sut.getEntity().initializeMd5();

            sut.setDeletedState(true);

            assertThat(sut.getState(), is(EntityDataState.Deleted));
        }
    }
}
