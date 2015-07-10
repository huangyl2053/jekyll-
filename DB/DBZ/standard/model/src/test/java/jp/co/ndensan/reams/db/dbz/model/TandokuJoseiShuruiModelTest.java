/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.model;

import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT3099TandokuJoseiShuruiEntityGenerator;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link TandokuJoseiShuruiModel}のテストクラスです。
 *
 * @author LDNS 宋昕沢
 */
@RunWith(Enclosed.class)
public class TandokuJoseiShuruiModelTest extends DbzTestBase {

    public static class getterSetterTest extends DbzTestBase {

        private static TandokuJoseiShuruiModel sut;

        @BeforeClass
        public static void test() {
            sut = new TandokuJoseiShuruiModel();
        }

        @Test
        public void 戻り値の市町村単独助成種類は_設定した値と同じ市町村単独助成種類を返す() {
            sut.set市町村単独助成種類(DbT3099TandokuJoseiShuruiEntityGenerator.DEFAULT_市町村単独助成種類);
            assertThat(sut.get市町村単独助成種類(), is(DbT3099TandokuJoseiShuruiEntityGenerator.DEFAULT_市町村単独助成種類));
        }

        @Test
        public void 戻り値の助成サービス種類コードは_設定した値と同じ助成サービス種類コードを返す() {
            sut.set助成サービス種類コード(DbT3099TandokuJoseiShuruiEntityGenerator.DEFAULT_助成サービス種類コード);
            assertThat(sut.get助成サービス種類コード(), is(DbT3099TandokuJoseiShuruiEntityGenerator.DEFAULT_助成サービス種類コード));
        }

        @Test
        public void 戻り値の適用開始年月は_設定した値と同じ適用開始年月を返す() {
            sut.set適用開始年月(DbT3099TandokuJoseiShuruiEntityGenerator.DEFAULT_適用開始年月);
            assertThat(sut.get適用開始年月(), is(DbT3099TandokuJoseiShuruiEntityGenerator.DEFAULT_適用開始年月));
        }

        @Test
        public void 戻り値の処理日時は_設定した値と同じ処理日時を返す() {
            sut.set処理日時(DbT3099TandokuJoseiShuruiEntityGenerator.DEFAULT_処理日時);
            assertThat(sut.get処理日時(), is(DbT3099TandokuJoseiShuruiEntityGenerator.DEFAULT_処理日時));
        }

        @Test
        public void 戻り値の適用終了年月は_設定した値と同じ適用終了年月を返す() {
            sut.set適用終了年月(DbT3099TandokuJoseiShuruiEntityGenerator.DEFAULT_適用終了年月);
            assertThat(sut.get適用終了年月(), is(DbT3099TandokuJoseiShuruiEntityGenerator.DEFAULT_適用終了年月));
        }

        @Test
        public void 戻り値の助成サービス種類名称は_設定した値と同じ助成サービス種類名称を返す() {
            sut.set助成サービス種類名称(DbT3099TandokuJoseiShuruiEntityGenerator.DEFAULT_助成サービス種類名称);
            assertThat(sut.get助成サービス種類名称(), is(DbT3099TandokuJoseiShuruiEntityGenerator.DEFAULT_助成サービス種類名称));
        }

        @Test
        public void 戻り値の市町村単独助成単位は_設定した値と同じ市町村単独助成単位を返す() {
            sut.set市町村単独助成単位(DbT3099TandokuJoseiShuruiEntityGenerator.DEFAULT_市町村単独助成単位);
            assertThat(sut.get市町村単独助成単位(), is(DbT3099TandokuJoseiShuruiEntityGenerator.DEFAULT_市町村単独助成単位));
        }

        @Test
        public void 戻り値の市町村単独助成内容は_設定した値と同じ市町村単独助成内容を返す() {
            sut.set市町村単独助成内容(DbT3099TandokuJoseiShuruiEntityGenerator.DEFAULT_市町村単独助成内容);
            assertThat(sut.get市町村単独助成内容(), is(DbT3099TandokuJoseiShuruiEntityGenerator.DEFAULT_市町村単独助成内容));
        }
    }

    public static class getStateTest extends DbzTestBase {

        @Test
        public void 状態Addedの取得確認() {
            TandokuJoseiShuruiModel sut = new TandokuJoseiShuruiModel();

            assertThat(sut.getState(), is(EntityDataState.Added));
        }

        @Test
        public void 状態Modifinedの取得確認() {
            TandokuJoseiShuruiModel sut = new TandokuJoseiShuruiModel();
            sut.setEntity(DbT3099TandokuJoseiShuruiEntityGenerator.createDbT3099TandokuJoseiShuruiEntity());

            sut.getEntity().initializeMd5();

            // TODO 主キー以外の項目を変更してください
//            sut.getEntity().setXXX(new XXX());
//            assertThat(sut.getState(), is(EntityDataState.Modified));
        }

        @Test
        public void 状態Unchangedの取得確認() {
            TandokuJoseiShuruiModel sut = new TandokuJoseiShuruiModel();
            sut.setEntity(DbT3099TandokuJoseiShuruiEntityGenerator.createDbT3099TandokuJoseiShuruiEntity());

            sut.getEntity().initializeMd5();

            assertThat(sut.getState(), is(EntityDataState.Unchanged));
        }

        @Test
        public void 状態Deletedの取得確認() {
            TandokuJoseiShuruiModel sut = new TandokuJoseiShuruiModel();
            sut.setEntity(DbT3099TandokuJoseiShuruiEntityGenerator.createDbT3099TandokuJoseiShuruiEntity());

            sut.getEntity().initializeMd5();

            sut.setDeletedState(true);

            assertThat(sut.getState(), is(EntityDataState.Deleted));
        }
    }
}
