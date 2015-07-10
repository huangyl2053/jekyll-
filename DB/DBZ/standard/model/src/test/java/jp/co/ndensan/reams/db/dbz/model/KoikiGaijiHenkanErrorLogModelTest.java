/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.model;

import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT7034KoikiGaijiHenkanErrorLogEntityGenerator;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link KoikiGaijiHenkanErrorLogModel}のテストクラスです。
 *
 * @author LDNS 宋文娟
 */
@RunWith(Enclosed.class)
public class KoikiGaijiHenkanErrorLogModelTest extends DbzTestBase {

    public static class getterSetterTest extends DbzTestBase {

        private static KoikiGaijiHenkanErrorLogModel sut;

        @BeforeClass
        public static void test() {
            sut = new KoikiGaijiHenkanErrorLogModel();
        }

        @Test
        public void 戻り値の処理番号は_設定した値と同じ処理番号を返す() {
            sut.set処理番号(DbT7034KoikiGaijiHenkanErrorLogEntityGenerator.DEFAULT_処理番号);
            assertThat(sut.get処理番号(), is(DbT7034KoikiGaijiHenkanErrorLogEntityGenerator.DEFAULT_処理番号));
        }

        @Test
        public void 戻り値の連番は_設定した値と同じ連番を返す() {
            sut.set連番(DbT7034KoikiGaijiHenkanErrorLogEntityGenerator.DEFAULT_連番);
            assertThat(sut.get連番(), is(DbT7034KoikiGaijiHenkanErrorLogEntityGenerator.DEFAULT_連番));
        }

        @Test
        public void 戻り値の市町村番号は_設定した値と同じ市町村番号を返す() {
            sut.set市町村番号(DbT7034KoikiGaijiHenkanErrorLogEntityGenerator.DEFAULT_市町村番号);
            assertThat(sut.get市町村番号(), is(DbT7034KoikiGaijiHenkanErrorLogEntityGenerator.DEFAULT_市町村番号));
        }

        @Test
        public void 戻り値の種別は_設定した値と同じ種別を返す() {
            sut.set種別(DbT7034KoikiGaijiHenkanErrorLogEntityGenerator.DEFAULT_種別);
            assertThat(sut.get種別(), is(DbT7034KoikiGaijiHenkanErrorLogEntityGenerator.DEFAULT_種別));
        }

        @Test
        public void 戻り値の処理日時は_設定した値と同じ処理日時を返す() {
            sut.set処理日時(DbT7034KoikiGaijiHenkanErrorLogEntityGenerator.DEFAULT_処理日時);
            assertThat(sut.get処理日時(), is(DbT7034KoikiGaijiHenkanErrorLogEntityGenerator.DEFAULT_処理日時));
        }

        @Test
        public void 戻り値の送信元市町村コードは_設定した値と同じ送信元市町村コードを返す() {
            sut.set送信元市町村コード(DbT7034KoikiGaijiHenkanErrorLogEntityGenerator.DEFAULT_送信元市町村コード);
            assertThat(sut.get送信元市町村コード(), is(DbT7034KoikiGaijiHenkanErrorLogEntityGenerator.DEFAULT_送信元市町村コード));
        }

        @Test
        public void 戻り値の送信元市町村名称は_設定した値と同じ送信元市町村名称を返す() {
            sut.set送信元市町村名称(DbT7034KoikiGaijiHenkanErrorLogEntityGenerator.DEFAULT_送信元市町村名称);
            assertThat(sut.get送信元市町村名称(), is(DbT7034KoikiGaijiHenkanErrorLogEntityGenerator.DEFAULT_送信元市町村名称));
        }

        @Test
        public void 戻り値の送信先市町村コードは_設定した値と同じ送信先市町村コードを返す() {
            sut.set送信先市町村コード(DbT7034KoikiGaijiHenkanErrorLogEntityGenerator.DEFAULT_送信先市町村コード);
            assertThat(sut.get送信先市町村コード(), is(DbT7034KoikiGaijiHenkanErrorLogEntityGenerator.DEFAULT_送信先市町村コード));
        }

        @Test
        public void 戻り値の送信先市町村名称は_設定した値と同じ送信先市町村名称を返す() {
            sut.set送信先市町村名称(DbT7034KoikiGaijiHenkanErrorLogEntityGenerator.DEFAULT_送信先市町村名称);
            assertThat(sut.get送信先市町村名称(), is(DbT7034KoikiGaijiHenkanErrorLogEntityGenerator.DEFAULT_送信先市町村名称));
        }

        @Test
        public void 戻り値の住基識別コードは_設定した値と同じ住基識別コードを返す() {
            sut.set住基識別コード(DbT7034KoikiGaijiHenkanErrorLogEntityGenerator.DEFAULT_住基識別コード);
            assertThat(sut.get住基識別コード(), is(DbT7034KoikiGaijiHenkanErrorLogEntityGenerator.DEFAULT_住基識別コード));
        }

        @Test
        public void 戻り値の確認区分は_設定した値と同じ確認区分を返す() {
            sut.set確認区分(DbT7034KoikiGaijiHenkanErrorLogEntityGenerator.DEFAULT_確認区分);
            assertThat(sut.get確認区分(), is(DbT7034KoikiGaijiHenkanErrorLogEntityGenerator.DEFAULT_確認区分));
        }

        @Test
        public void 戻り値の識別コードは_設定した値と同じ識別コードを返す() {
            sut.set識別コード(DbT7034KoikiGaijiHenkanErrorLogEntityGenerator.DEFAULT_識別コード);
            assertThat(sut.get識別コード(), is(DbT7034KoikiGaijiHenkanErrorLogEntityGenerator.DEFAULT_識別コード));
        }

        @Test
        public void 戻り値の被保険者番号は_設定した値と同じ被保険者番号を返す() {
            sut.set被保険者番号(DbT7034KoikiGaijiHenkanErrorLogEntityGenerator.DEFAULT_被保険者番号);
            assertThat(sut.get被保険者番号(), is(DbT7034KoikiGaijiHenkanErrorLogEntityGenerator.DEFAULT_被保険者番号));
        }

        @Test
        public void 戻り値のレコードＮｏは_設定した値と同じレコードＮｏを返す() {
            sut.setレコードＮｏ(DbT7034KoikiGaijiHenkanErrorLogEntityGenerator.DEFAULT_レコードＮｏ);
            assertThat(sut.getレコードＮｏ(), is(DbT7034KoikiGaijiHenkanErrorLogEntityGenerator.DEFAULT_レコードＮｏ));
        }

        @Test
        public void 戻り値の変換エラーフィールド名称は_設定した値と同じ変換エラーフィールド名称を返す() {
            sut.set変換エラーフィールド名称(DbT7034KoikiGaijiHenkanErrorLogEntityGenerator.DEFAULT_変換エラーフィールド名称);
            assertThat(sut.get変換エラーフィールド名称(), is(DbT7034KoikiGaijiHenkanErrorLogEntityGenerator.DEFAULT_変換エラーフィールド名称));
        }

        @Test
        public void 戻り値の変換エラーフィールドＮｏは_設定した値と同じ変換エラーフィールドＮｏを返す() {
            sut.set変換エラーフィールドＮｏ(DbT7034KoikiGaijiHenkanErrorLogEntityGenerator.DEFAULT_変換エラーフィールドＮｏ);
            assertThat(sut.get変換エラーフィールドＮｏ(), is(DbT7034KoikiGaijiHenkanErrorLogEntityGenerator.DEFAULT_変換エラーフィールドＮｏ));
        }

        @Test
        public void 戻り値の変換エラーコードは_設定した値と同じ変換エラーコードを返す() {
            sut.set変換エラーコード(DbT7034KoikiGaijiHenkanErrorLogEntityGenerator.DEFAULT_変換エラーコード);
            assertThat(sut.get変換エラーコード(), is(DbT7034KoikiGaijiHenkanErrorLogEntityGenerator.DEFAULT_変換エラーコード));
        }

        @Test
        public void 戻り値のエラー表示連番は_設定した値と同じエラー表示連番を返す() {
            sut.setエラー表示連番(DbT7034KoikiGaijiHenkanErrorLogEntityGenerator.DEFAULT_エラー表示連番);
            assertThat(sut.getエラー表示連番(), is(DbT7034KoikiGaijiHenkanErrorLogEntityGenerator.DEFAULT_エラー表示連番));
        }

        @Test
        public void 戻り値のエラー表示フィールド名称は_設定した値と同じエラー表示フィールド名称を返す() {
            sut.setエラー表示フィールド名称(DbT7034KoikiGaijiHenkanErrorLogEntityGenerator.DEFAULT_エラー表示フィールド名称);
            assertThat(sut.getエラー表示フィールド名称(), is(DbT7034KoikiGaijiHenkanErrorLogEntityGenerator.DEFAULT_エラー表示フィールド名称));
        }

        @Test
        public void 戻り値のエラー表示フィールドは_設定した値と同じエラー表示フィールドを返す() {
            sut.setエラー表示フィールド(DbT7034KoikiGaijiHenkanErrorLogEntityGenerator.DEFAULT_エラー表示フィールド);
            assertThat(sut.getエラー表示フィールド(), is(DbT7034KoikiGaijiHenkanErrorLogEntityGenerator.DEFAULT_エラー表示フィールド));
        }
    }

    public static class getStateTest extends DbzTestBase {

        @Test
        public void 状態Addedの取得確認() {
            KoikiGaijiHenkanErrorLogModel sut = new KoikiGaijiHenkanErrorLogModel();

            assertThat(sut.getState(), is(EntityDataState.Added));
        }

       // @Test
        // public void 状態Modifinedの取得確認() {
        // KoikiGaijiHenkanErrorLogModel sut = new KoikiGaijiHenkanErrorLogModel();
        //sut.setEntity(DbT7034KoikiGaijiHenkanErrorLogEntityGenerator.createDbT7034KoikiGaijiHenkanErrorLogEntity());
        // sut.getEntity().initializeMd5();
        // TODO主キー以外の項目を変更してください
        //sut.getEntity().setXXX(new XXX());
        //assertThat(sut.getState(), is(EntityDataState.Modified));
        //}
        @Test
        public void 状態Unchangedの取得確認() {
            KoikiGaijiHenkanErrorLogModel sut = new KoikiGaijiHenkanErrorLogModel();
            sut.setEntity(DbT7034KoikiGaijiHenkanErrorLogEntityGenerator.createDbT7034KoikiGaijiHenkanErrorLogEntity());

            sut.getEntity().initializeMd5();

            assertThat(sut.getState(), is(EntityDataState.Unchanged));
        }

        @Test
        public void 状態Deletedの取得確認() {
            KoikiGaijiHenkanErrorLogModel sut = new KoikiGaijiHenkanErrorLogModel();
            sut.setEntity(DbT7034KoikiGaijiHenkanErrorLogEntityGenerator.createDbT7034KoikiGaijiHenkanErrorLogEntity());

            sut.getEntity().initializeMd5();

            sut.setDeletedState(true);

            assertThat(sut.getState(), is(EntityDataState.Deleted));
        }
    }
}
