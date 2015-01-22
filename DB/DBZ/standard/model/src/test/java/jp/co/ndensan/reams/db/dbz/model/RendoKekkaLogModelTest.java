/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.model;

import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT7036RendoKekkaLogEntityGenerator;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link RendoKekkaLogModel}のテストクラスです。
 *
 * @author LDNS 宋文娟
 */
@RunWith(Enclosed.class)
public class RendoKekkaLogModelTest extends DbzTestBase {

    public static class getterSetterTest extends DbzTestBase {

        private static RendoKekkaLogModel sut;

        @BeforeClass
        public static void test() {
            sut = new RendoKekkaLogModel();
        }

        @Test
        public void 戻り値の処理番号は_設定した値と同じ処理番号を返す() {
            sut.set処理番号(DbT7036RendoKekkaLogEntityGenerator.DEFAULT_処理番号);
            assertThat(sut.get処理番号(), is(DbT7036RendoKekkaLogEntityGenerator.DEFAULT_処理番号));
        }

        @Test
        public void 戻り値の種別は_設定した値と同じ種別を返す() {
            sut.set種別(DbT7036RendoKekkaLogEntityGenerator.DEFAULT_種別);
            assertThat(sut.get種別(), is(DbT7036RendoKekkaLogEntityGenerator.DEFAULT_種別));
        }

        @Test
        public void 戻り値の処理ＩＤは_設定した値と同じ処理ＩＤを返す() {
            sut.set処理ＩＤ(DbT7036RendoKekkaLogEntityGenerator.DEFAULT_処理ＩＤ);
            assertThat(sut.get処理ＩＤ(), is(DbT7036RendoKekkaLogEntityGenerator.DEFAULT_処理ＩＤ));
        }

        @Test
        public void 戻り値の送信元市町村コードは_設定した値と同じ送信元市町村コードを返す() {
            sut.set送信元市町村コード(DbT7036RendoKekkaLogEntityGenerator.DEFAULT_送信元市町村コード);
            assertThat(sut.get送信元市町村コード(), is(DbT7036RendoKekkaLogEntityGenerator.DEFAULT_送信元市町村コード));
        }

        @Test
        public void 戻り値の送信先市町村コードは_設定した値と同じ送信先市町村コードを返す() {
            sut.set送信先市町村コード(DbT7036RendoKekkaLogEntityGenerator.DEFAULT_送信先市町村コード);
            assertThat(sut.get送信先市町村コード(), is(DbT7036RendoKekkaLogEntityGenerator.DEFAULT_送信先市町村コード));
        }

        @Test
        public void 戻り値の結果区分は_設定した値と同じ結果区分を返す() {
            sut.set結果区分(DbT7036RendoKekkaLogEntityGenerator.DEFAULT_結果区分);
            assertThat(sut.get結果区分(), is(DbT7036RendoKekkaLogEntityGenerator.DEFAULT_結果区分));
        }

        @Test
        public void 戻り値の確認区分は_設定した値と同じ確認区分を返す() {
            sut.set確認区分(DbT7036RendoKekkaLogEntityGenerator.DEFAULT_確認区分);
            assertThat(sut.get確認区分(), is(DbT7036RendoKekkaLogEntityGenerator.DEFAULT_確認区分));
        }

        @Test
        public void 戻り値の処理開始時刻は_設定した値と同じ処理開始時刻を返す() {
            sut.set処理開始時刻(DbT7036RendoKekkaLogEntityGenerator.DEFAULT_処理開始時刻);
            assertThat(sut.get処理開始時刻(), is(DbT7036RendoKekkaLogEntityGenerator.DEFAULT_処理開始時刻));
        }

        @Test
        public void 戻り値の処理終了時刻は_設定した値と同じ処理終了時刻を返す() {
            sut.set処理終了時刻(DbT7036RendoKekkaLogEntityGenerator.DEFAULT_処理終了時刻);
            assertThat(sut.get処理終了時刻(), is(DbT7036RendoKekkaLogEntityGenerator.DEFAULT_処理終了時刻));
        }

        @Test
        public void 戻り値のログファイル名は_設定した値と同じログファイル名を返す() {
            sut.setログファイル名(DbT7036RendoKekkaLogEntityGenerator.DEFAULT_ログファイル名);
            assertThat(sut.getログファイル名(), is(DbT7036RendoKekkaLogEntityGenerator.DEFAULT_ログファイル名));
        }

        @Test
        public void 戻り値の表示用条件は_設定した値と同じ表示用条件を返す() {
            sut.set表示用条件(DbT7036RendoKekkaLogEntityGenerator.DEFAULT_表示用条件);
            assertThat(sut.get表示用条件(), is(DbT7036RendoKekkaLogEntityGenerator.DEFAULT_表示用条件));
        }

        @Test
        public void 戻り値のメッセージは_設定した値と同じメッセージを返す() {
            sut.setメッセージ(DbT7036RendoKekkaLogEntityGenerator.DEFAULT_メッセージ);
            assertThat(sut.getメッセージ(), is(DbT7036RendoKekkaLogEntityGenerator.DEFAULT_メッセージ));
        }

        @Test
        public void 戻り値の連動形態は_設定した値と同じ連動形態を返す() {
            sut.set連動形態(DbT7036RendoKekkaLogEntityGenerator.DEFAULT_連動形態);
            assertThat(sut.get連動形態(), is(DbT7036RendoKekkaLogEntityGenerator.DEFAULT_連動形態));
        }

        @Test
        public void 戻り値のUL_受信結果区分は_設定した値と同じUL_受信結果区分を返す() {
            sut.setUL_受信結果区分(DbT7036RendoKekkaLogEntityGenerator.DEFAULT_UL_受信結果区分);
            assertThat(sut.getUL_受信結果区分(), is(DbT7036RendoKekkaLogEntityGenerator.DEFAULT_UL_受信結果区分));
        }

        @Test
        public void 戻り値のUL_文字コード変換結果区分は_設定した値と同じUL_文字コード変換結果区分を返す() {
            sut.setUL_文字コード変換結果区分(DbT7036RendoKekkaLogEntityGenerator.DEFAULT_UL_文字コード変換結果区分);
            assertThat(sut.getUL_文字コード変換結果区分(), is(DbT7036RendoKekkaLogEntityGenerator.DEFAULT_UL_文字コード変換結果区分));
        }

        @Test
        public void 戻り値のUL_処理１結果区分は_設定した値と同じUL_処理１結果区分を返す() {
            sut.setUL_処理１結果区分(DbT7036RendoKekkaLogEntityGenerator.DEFAULT_UL_処理１結果区分);
            assertThat(sut.getUL_処理１結果区分(), is(DbT7036RendoKekkaLogEntityGenerator.DEFAULT_UL_処理１結果区分));
        }

        @Test
        public void 戻り値のUL_処理２結果区分は_設定した値と同じUL_処理２結果区分を返す() {
            sut.setUL_処理２結果区分(DbT7036RendoKekkaLogEntityGenerator.DEFAULT_UL_処理２結果区分);
            assertThat(sut.getUL_処理２結果区分(), is(DbT7036RendoKekkaLogEntityGenerator.DEFAULT_UL_処理２結果区分));
        }

        @Test
        public void 戻り値のUL_処理３結果区分は_設定した値と同じUL_処理３結果区分を返す() {
            sut.setUL_処理３結果区分(DbT7036RendoKekkaLogEntityGenerator.DEFAULT_UL_処理３結果区分);
            assertThat(sut.getUL_処理３結果区分(), is(DbT7036RendoKekkaLogEntityGenerator.DEFAULT_UL_処理３結果区分));
        }

        @Test
        public void 戻り値のDL_処理１結果区分は_設定した値と同じDL_処理１結果区分を返す() {
            sut.setDL_処理１結果区分(DbT7036RendoKekkaLogEntityGenerator.DEFAULT_DL_処理１結果区分);
            assertThat(sut.getDL_処理１結果区分(), is(DbT7036RendoKekkaLogEntityGenerator.DEFAULT_DL_処理１結果区分));
        }

        @Test
        public void 戻り値のDL_コード変換結果区分は_設定した値と同じDL_コード変換結果区分を返す() {
            sut.setDL_コード変換結果区分(DbT7036RendoKekkaLogEntityGenerator.DEFAULT_DL_コード変換結果区分);
            assertThat(sut.getDL_コード変換結果区分(), is(DbT7036RendoKekkaLogEntityGenerator.DEFAULT_DL_コード変換結果区分));
        }

        @Test
        public void 戻り値のDL_文字コード変換結果区分は_設定した値と同じDL_文字コード変換結果区分を返す() {
            sut.setDL_文字コード変換結果区分(DbT7036RendoKekkaLogEntityGenerator.DEFAULT_DL_文字コード変換結果区分);
            assertThat(sut.getDL_文字コード変換結果区分(), is(DbT7036RendoKekkaLogEntityGenerator.DEFAULT_DL_文字コード変換結果区分));
        }

        @Test
        public void 戻り値のDL_送信１結果区分は_設定した値と同じDL_送信１結果区分を返す() {
            sut.setDL_送信１結果区分(DbT7036RendoKekkaLogEntityGenerator.DEFAULT_DL_送信１結果区分);
            assertThat(sut.getDL_送信１結果区分(), is(DbT7036RendoKekkaLogEntityGenerator.DEFAULT_DL_送信１結果区分));
        }

        @Test
        public void 戻り値のDL_処理２結果区分は_設定した値と同じDL_処理２結果区分を返す() {
            sut.setDL_処理２結果区分(DbT7036RendoKekkaLogEntityGenerator.DEFAULT_DL_処理２結果区分);
            assertThat(sut.getDL_処理２結果区分(), is(DbT7036RendoKekkaLogEntityGenerator.DEFAULT_DL_処理２結果区分));
        }

        @Test
        public void 戻り値のDL_受信１結果区分は_設定した値と同じDL_受信１結果区分を返す() {
            sut.setDL_受信１結果区分(DbT7036RendoKekkaLogEntityGenerator.DEFAULT_DL_受信１結果区分);
            assertThat(sut.getDL_受信１結果区分(), is(DbT7036RendoKekkaLogEntityGenerator.DEFAULT_DL_受信１結果区分));
        }

        @Test
        public void 戻り値の処理メッセージ１は_設定した値と同じ処理メッセージ１を返す() {
            sut.set処理メッセージ１(DbT7036RendoKekkaLogEntityGenerator.DEFAULT_処理メッセージ１);
            assertThat(sut.get処理メッセージ１(), is(DbT7036RendoKekkaLogEntityGenerator.DEFAULT_処理メッセージ１));
        }

        @Test
        public void 戻り値の処理メッセージ２は_設定した値と同じ処理メッセージ２を返す() {
            sut.set処理メッセージ２(DbT7036RendoKekkaLogEntityGenerator.DEFAULT_処理メッセージ２);
            assertThat(sut.get処理メッセージ２(), is(DbT7036RendoKekkaLogEntityGenerator.DEFAULT_処理メッセージ２));
        }
    }

    public static class getStateTest extends DbzTestBase {

        @Test
        public void 状態Addedの取得確認() {
            RendoKekkaLogModel sut = new RendoKekkaLogModel();

            assertThat(sut.getState(), is(EntityDataState.Added));
        }

       // @Test
        // public void 状態Modifinedの取得確認() {
        // RendoKekkaLogModel sut = new RendoKekkaLogModel();
        //sut.setEntity(DbT7036RendoKekkaLogEntityGenerator.createDbT7036RendoKekkaLogEntity());
        // sut.getEntity().initializeMd5();
        // TODO主キー以外の項目を変更してください
        //sut.getEntity().setXXX(new XXX());
        //assertThat(sut.getState(), is(EntityDataState.Modified));
        //}
        @Test
        public void 状態Unchangedの取得確認() {
            RendoKekkaLogModel sut = new RendoKekkaLogModel();
            sut.setEntity(DbT7036RendoKekkaLogEntityGenerator.createDbT7036RendoKekkaLogEntity());

            sut.getEntity().initializeMd5();

            assertThat(sut.getState(), is(EntityDataState.Unchanged));
        }

        @Test
        public void 状態Deletedの取得確認() {
            RendoKekkaLogModel sut = new RendoKekkaLogModel();
            sut.setEntity(DbT7036RendoKekkaLogEntityGenerator.createDbT7036RendoKekkaLogEntity());

            sut.getEntity().initializeMd5();

            sut.setDeletedState(true);

            assertThat(sut.getState(), is(EntityDataState.Deleted));
        }
    }
}
