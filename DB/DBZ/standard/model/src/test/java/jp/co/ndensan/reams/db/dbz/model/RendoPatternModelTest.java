/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.model;

import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT7035RendoPatternEntityGenerator;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link RendoPatternModel}のテストクラスです。
 *
 * @author LDNS 宋文娟
 */
@RunWith(Enclosed.class)
public class RendoPatternModelTest extends DbzTestBase {

    public static class getterSetterTest extends DbzTestBase {

        private static RendoPatternModel sut;

        @BeforeClass
        public static void test() {
            sut = new RendoPatternModel();
        }

        @Test
        public void 戻り値の送信元市町村コードは_設定した値と同じ送信元市町村コードを返す() {
            sut.set送信元市町村コード(DbT7035RendoPatternEntityGenerator.DEFAULT_送信元市町村コード);
            assertThat(sut.get送信元市町村コード(), is(DbT7035RendoPatternEntityGenerator.DEFAULT_送信元市町村コード));
        }

        @Test
        public void 戻り値の送信先市町村コードは_設定した値と同じ送信先市町村コードを返す() {
            sut.set送信先市町村コード(DbT7035RendoPatternEntityGenerator.DEFAULT_送信先市町村コード);
            assertThat(sut.get送信先市町村コード(), is(DbT7035RendoPatternEntityGenerator.DEFAULT_送信先市町村コード));
        }

        @Test
        public void 戻り値の種別は_設定した値と同じ種別を返す() {
            sut.set種別(DbT7035RendoPatternEntityGenerator.DEFAULT_種別);
            assertThat(sut.get種別(), is(DbT7035RendoPatternEntityGenerator.DEFAULT_種別));
        }

        @Test
        public void 戻り値の有効開始年月日は_設定した値と同じ有効開始年月日を返す() {
            sut.set有効開始年月日(DbT7035RendoPatternEntityGenerator.DEFAULT_有効開始年月日);
            assertThat(sut.get有効開始年月日(), is(DbT7035RendoPatternEntityGenerator.DEFAULT_有効開始年月日));
        }

        @Test
        public void 戻り値の有効終了年月日は_設定した値と同じ有効終了年月日を返す() {
            sut.set有効終了年月日(DbT7035RendoPatternEntityGenerator.DEFAULT_有効終了年月日);
            assertThat(sut.get有効終了年月日(), is(DbT7035RendoPatternEntityGenerator.DEFAULT_有効終了年月日));
        }

        @Test
        public void 戻り値の連動形態コードは_設定した値と同じ連動形態コードを返す() {
            sut.set連動形態コード(DbT7035RendoPatternEntityGenerator.DEFAULT_連動形態コード);
            assertThat(sut.get連動形態コード(), is(DbT7035RendoPatternEntityGenerator.DEFAULT_連動形態コード));
        }

        @Test
        public void 戻り値の送信元フォーマットバージョンは_設定した値と同じ送信元フォーマットバージョンを返す() {
            sut.set送信元フォーマットバージョン(DbT7035RendoPatternEntityGenerator.DEFAULT_送信元フォーマットバージョン);
            assertThat(sut.get送信元フォーマットバージョン(), is(DbT7035RendoPatternEntityGenerator.DEFAULT_送信元フォーマットバージョン));
        }

        @Test
        public void 戻り値の送信元エンコーディングは_設定した値と同じ送信元エンコーディングを返す() {
            sut.set送信元エンコーディング(DbT7035RendoPatternEntityGenerator.DEFAULT_送信元エンコーディング);
            assertThat(sut.get送信元エンコーディング(), is(DbT7035RendoPatternEntityGenerator.DEFAULT_送信元エンコーディング));
        }

        @Test
        public void 戻り値の送信先フォーマットバージョンは_設定した値と同じ送信先フォーマットバージョンを返す() {
            sut.set送信先フォーマットバージョン(DbT7035RendoPatternEntityGenerator.DEFAULT_送信先フォーマットバージョン);
            assertThat(sut.get送信先フォーマットバージョン(), is(DbT7035RendoPatternEntityGenerator.DEFAULT_送信先フォーマットバージョン));
        }

        @Test
        public void 戻り値の送信先エンコーディングは_設定した値と同じ送信先エンコーディングを返す() {
            sut.set送信先エンコーディング(DbT7035RendoPatternEntityGenerator.DEFAULT_送信先エンコーディング);
            assertThat(sut.get送信先エンコーディング(), is(DbT7035RendoPatternEntityGenerator.DEFAULT_送信先エンコーディング));
        }

        @Test
        public void 戻り値のコード変換区分は_設定した値と同じコード変換区分を返す() {
            sut.setコード変換区分(DbT7035RendoPatternEntityGenerator.DEFAULT_コード変換区分);
            assertThat(sut.getコード変換区分(), is(DbT7035RendoPatternEntityGenerator.DEFAULT_コード変換区分));
        }

        @Test
        public void 戻り値の外字変換区分は_設定した値と同じ外字変換区分を返す() {
            sut.set外字変換区分(DbT7035RendoPatternEntityGenerator.DEFAULT_外字変換区分);
            assertThat(sut.get外字変換区分(), is(DbT7035RendoPatternEntityGenerator.DEFAULT_外字変換区分));
        }

        @Test
        public void 戻り値の全件連動区分は_設定した値と同じ全件連動区分を返す() {
            sut.set全件連動区分(DbT7035RendoPatternEntityGenerator.DEFAULT_全件連動区分);
            assertThat(sut.get全件連動区分(), is(DbT7035RendoPatternEntityGenerator.DEFAULT_全件連動区分));
        }

        @Test
        public void 戻り値の連携区分は_設定した値と同じ連携区分を返す() {
            sut.set連携区分(DbT7035RendoPatternEntityGenerator.DEFAULT_連携区分);
            assertThat(sut.get連携区分(), is(DbT7035RendoPatternEntityGenerator.DEFAULT_連携区分));
        }
    }

    public static class getStateTest extends DbzTestBase {

        @Test
        public void 状態Addedの取得確認() {
            RendoPatternModel sut = new RendoPatternModel();

            assertThat(sut.getState(), is(EntityDataState.Added));
        }

       // @Test
        // public void 状態Modifinedの取得確認() {
        // RendoPatternModel sut = new RendoPatternModel();
        //sut.setEntity(DbT7035RendoPatternEntityGenerator.createDbT7035RendoPatternEntity());
        // sut.getEntity().initializeMd5();
        // TODO主キー以外の項目を変更してください
        //sut.getEntity().setXXX(new XXX());
        //assertThat(sut.getState(), is(EntityDataState.Modified));
        //}
        @Test
        public void 状態Unchangedの取得確認() {
            RendoPatternModel sut = new RendoPatternModel();
            sut.setEntity(DbT7035RendoPatternEntityGenerator.createDbT7035RendoPatternEntity());

            sut.getEntity().initializeMd5();

            assertThat(sut.getState(), is(EntityDataState.Unchanged));
        }

        @Test
        public void 状態Deletedの取得確認() {
            RendoPatternModel sut = new RendoPatternModel();
            sut.setEntity(DbT7035RendoPatternEntityGenerator.createDbT7035RendoPatternEntity());

            sut.getEntity().initializeMd5();

            sut.setDeletedState(true);

            assertThat(sut.getState(), is(EntityDataState.Deleted));
        }
    }
}
