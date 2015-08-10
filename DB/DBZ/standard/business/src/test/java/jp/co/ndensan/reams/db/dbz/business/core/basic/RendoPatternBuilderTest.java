/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.basic;

import jp.co.ndensan.reams.db.dbz.entity.basic.DbT7035RendoPatternEntity;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT7035RendoPatternEntityGenerator;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link RendoPatternBuilder}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class RendoPatternBuilderTest extends DbzTestBase {

    private static DbT7035RendoPatternEntity RendoPatternEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static 主キー型1 主キー名1;
    private static 主キー型2 主キー名2;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        主キー名1 = DbT7035RendoPatternEntityGenerator.DEFAULT_主キー名1;
        主キー名2 = DbT7035RendoPatternEntityGenerator.DEFAULT_主キー名2;
    }

    public static class getterSetterTest extends FdaTestBase {

        private static RendoPatternBuilder sut;
        private static RendoPattern business;

        @Before
        public void setUp() {
            RendoPatternEntity = new DbT7035RendoPatternEntity();

            business = new RendoPattern(RendoPatternEntity);

            sut = business.createBuilderForEdit();
        }
//TODO Key項目のテストメソッドは削除して下さい。

        @Test
        public void 戻り値の送信元市町村コードは_設定した値と同じ送信元市町村コードを返す() {
            business = sut.set送信元市町村コード(DbT7035RendoPatternEntityGenerator.DEFAULT_送信元市町村コード).build();
            assertThat(business.get送信元市町村コード(), is(DbT7035RendoPatternEntityGenerator.DEFAULT_送信元市町村コード));
        }

        @Test
        public void 戻り値の送信先市町村コードは_設定した値と同じ送信先市町村コードを返す() {
            business = sut.set送信先市町村コード(DbT7035RendoPatternEntityGenerator.DEFAULT_送信先市町村コード).build();
            assertThat(business.get送信先市町村コード(), is(DbT7035RendoPatternEntityGenerator.DEFAULT_送信先市町村コード));
        }

        @Test
        public void 戻り値の種別は_設定した値と同じ種別を返す() {
            business = sut.set種別(DbT7035RendoPatternEntityGenerator.DEFAULT_種別).build();
            assertThat(business.get種別(), is(DbT7035RendoPatternEntityGenerator.DEFAULT_種別));
        }

        @Test
        public void 戻り値の有効開始年月日は_設定した値と同じ有効開始年月日を返す() {
            business = sut.set有効開始年月日(DbT7035RendoPatternEntityGenerator.DEFAULT_有効開始年月日).build();
            assertThat(business.get有効開始年月日(), is(DbT7035RendoPatternEntityGenerator.DEFAULT_有効開始年月日));
        }

        @Test
        public void 戻り値の有効終了年月日は_設定した値と同じ有効終了年月日を返す() {
            business = sut.set有効終了年月日(DbT7035RendoPatternEntityGenerator.DEFAULT_有効終了年月日).build();
            assertThat(business.get有効終了年月日(), is(DbT7035RendoPatternEntityGenerator.DEFAULT_有効終了年月日));
        }

        @Test
        public void 戻り値の連動形態コードは_設定した値と同じ連動形態コードを返す() {
            business = sut.set連動形態コード(DbT7035RendoPatternEntityGenerator.DEFAULT_連動形態コード).build();
            assertThat(business.get連動形態コード(), is(DbT7035RendoPatternEntityGenerator.DEFAULT_連動形態コード));
        }

        @Test
        public void 戻り値の送信元フォーマットバージョンは_設定した値と同じ送信元フォーマットバージョンを返す() {
            business = sut.set送信元フォーマットバージョン(DbT7035RendoPatternEntityGenerator.DEFAULT_送信元フォーマットバージョン).build();
            assertThat(business.get送信元フォーマットバージョン(), is(DbT7035RendoPatternEntityGenerator.DEFAULT_送信元フォーマットバージョン));
        }

        @Test
        public void 戻り値の送信元エンコーディングは_設定した値と同じ送信元エンコーディングを返す() {
            business = sut.set送信元エンコーディング(DbT7035RendoPatternEntityGenerator.DEFAULT_送信元エンコーディング).build();
            assertThat(business.get送信元エンコーディング(), is(DbT7035RendoPatternEntityGenerator.DEFAULT_送信元エンコーディング));
        }

        @Test
        public void 戻り値の送信先フォーマットバージョンは_設定した値と同じ送信先フォーマットバージョンを返す() {
            business = sut.set送信先フォーマットバージョン(DbT7035RendoPatternEntityGenerator.DEFAULT_送信先フォーマットバージョン).build();
            assertThat(business.get送信先フォーマットバージョン(), is(DbT7035RendoPatternEntityGenerator.DEFAULT_送信先フォーマットバージョン));
        }

        @Test
        public void 戻り値の送信先エンコーディングは_設定した値と同じ送信先エンコーディングを返す() {
            business = sut.set送信先エンコーディング(DbT7035RendoPatternEntityGenerator.DEFAULT_送信先エンコーディング).build();
            assertThat(business.get送信先エンコーディング(), is(DbT7035RendoPatternEntityGenerator.DEFAULT_送信先エンコーディング));
        }

        @Test
        public void 戻り値のコード変換区分は_設定した値と同じコード変換区分を返す() {
            business = sut.setコード変換区分(DbT7035RendoPatternEntityGenerator.DEFAULT_コード変換区分).build();
            assertThat(business.getコード変換区分(), is(DbT7035RendoPatternEntityGenerator.DEFAULT_コード変換区分));
        }

        @Test
        public void 戻り値の外字変換区分は_設定した値と同じ外字変換区分を返す() {
            business = sut.set外字変換区分(DbT7035RendoPatternEntityGenerator.DEFAULT_外字変換区分).build();
            assertThat(business.get外字変換区分(), is(DbT7035RendoPatternEntityGenerator.DEFAULT_外字変換区分));
        }

        @Test
        public void 戻り値の全件連動区分は_設定した値と同じ全件連動区分を返す() {
            business = sut.set全件連動区分(DbT7035RendoPatternEntityGenerator.DEFAULT_全件連動区分).build();
            assertThat(business.get全件連動区分(), is(DbT7035RendoPatternEntityGenerator.DEFAULT_全件連動区分));
        }

        @Test
        public void 戻り値の連携区分は_設定した値と同じ連携区分を返す() {
            business = sut.set連携区分(DbT7035RendoPatternEntityGenerator.DEFAULT_連携区分).build();
            assertThat(business.get連携区分(), is(DbT7035RendoPatternEntityGenerator.DEFAULT_連携区分));
        }

    }
}
