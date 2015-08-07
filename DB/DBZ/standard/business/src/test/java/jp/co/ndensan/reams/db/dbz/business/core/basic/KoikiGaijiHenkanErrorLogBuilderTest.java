/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.basic;

import jp.co.ndensan.reams.db.dbz.entity.basic.DbT7034KoikiGaijiHenkanErrorLogEntity;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT7034KoikiGaijiHenkanErrorLogEntityGenerator;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.fd.fdz.testhelper.FdaTestBase;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link KoikiGaijiHenkanErrorLogBuilder}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class KoikiGaijiHenkanErrorLogBuilderTest extends DbzTestBase {

    private static DbT7034KoikiGaijiHenkanErrorLogEntity KoikiGaijiHenkanErrorLogEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static 主キー型1 主キー名1;
    private static 主キー型2 主キー名2;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        主キー名1 = DbT7034KoikiGaijiHenkanErrorLogEntityGenerator.DEFAULT_主キー名1;
        主キー名2 = DbT7034KoikiGaijiHenkanErrorLogEntityGenerator.DEFAULT_主キー名2;
    }

    public static class getterSetterTest extends FdaTestBase {

        private static KoikiGaijiHenkanErrorLogBuilder sut;
        private static KoikiGaijiHenkanErrorLog business;

        @Before
        public void setUp() {
            KoikiGaijiHenkanErrorLogEntity = new DbT7034KoikiGaijiHenkanErrorLogEntity();
            KoikiGaijiHenkanErrorLogEntity.setXXX(主キー名1);
            KoikiGaijiHenkanErrorLogEntity.setXXX(主キー名2);

            business = new KoikiGaijiHenkanErrorLog(KoikiGaijiHenkanErrorLogEntity);

            sut = business.createBuilderForEdit();
        }
//TODO Key項目のテストメソッドは削除して下さい。

        @Test
        public void 戻り値の処理番号は_設定した値と同じ処理番号を返す() {
            business = sut.set処理番号(DbT7034KoikiGaijiHenkanErrorLogEntityGenerator.DEFAULT_処理番号).build();
            assertThat(business.get処理番号(), is(DbT7034KoikiGaijiHenkanErrorLogEntityGenerator.DEFAULT_処理番号));
        }

        @Test
        public void 戻り値の連番は_設定した値と同じ連番を返す() {
            business = sut.set連番(DbT7034KoikiGaijiHenkanErrorLogEntityGenerator.DEFAULT_連番).build();
            assertThat(business.get連番(), is(DbT7034KoikiGaijiHenkanErrorLogEntityGenerator.DEFAULT_連番));
        }

        @Test
        public void 戻り値の市町村番号は_設定した値と同じ市町村番号を返す() {
            business = sut.set市町村番号(DbT7034KoikiGaijiHenkanErrorLogEntityGenerator.DEFAULT_市町村番号).build();
            assertThat(business.get市町村番号(), is(DbT7034KoikiGaijiHenkanErrorLogEntityGenerator.DEFAULT_市町村番号));
        }

        @Test
        public void 戻り値の種別は_設定した値と同じ種別を返す() {
            business = sut.set種別(DbT7034KoikiGaijiHenkanErrorLogEntityGenerator.DEFAULT_種別).build();
            assertThat(business.get種別(), is(DbT7034KoikiGaijiHenkanErrorLogEntityGenerator.DEFAULT_種別));
        }

        @Test
        public void 戻り値の履歴番号は_設定した値と同じ履歴番号を返す() {
            business = sut.set履歴番号(DbT7034KoikiGaijiHenkanErrorLogEntityGenerator.DEFAULT_履歴番号).build();
            assertThat(business.get履歴番号(), is(DbT7034KoikiGaijiHenkanErrorLogEntityGenerator.DEFAULT_履歴番号));
        }

        @Test
        public void 戻り値の送信元市町村コードは_設定した値と同じ送信元市町村コードを返す() {
            business = sut.set送信元市町村コード(DbT7034KoikiGaijiHenkanErrorLogEntityGenerator.DEFAULT_送信元市町村コード).build();
            assertThat(business.get送信元市町村コード(), is(DbT7034KoikiGaijiHenkanErrorLogEntityGenerator.DEFAULT_送信元市町村コード));
        }

        @Test
        public void 戻り値の送信元市町村名称は_設定した値と同じ送信元市町村名称を返す() {
            business = sut.set送信元市町村名称(DbT7034KoikiGaijiHenkanErrorLogEntityGenerator.DEFAULT_送信元市町村名称).build();
            assertThat(business.get送信元市町村名称(), is(DbT7034KoikiGaijiHenkanErrorLogEntityGenerator.DEFAULT_送信元市町村名称));
        }

        @Test
        public void 戻り値の送信先市町村コードは_設定した値と同じ送信先市町村コードを返す() {
            business = sut.set送信先市町村コード(DbT7034KoikiGaijiHenkanErrorLogEntityGenerator.DEFAULT_送信先市町村コード).build();
            assertThat(business.get送信先市町村コード(), is(DbT7034KoikiGaijiHenkanErrorLogEntityGenerator.DEFAULT_送信先市町村コード));
        }

        @Test
        public void 戻り値の送信先市町村名称は_設定した値と同じ送信先市町村名称を返す() {
            business = sut.set送信先市町村名称(DbT7034KoikiGaijiHenkanErrorLogEntityGenerator.DEFAULT_送信先市町村名称).build();
            assertThat(business.get送信先市町村名称(), is(DbT7034KoikiGaijiHenkanErrorLogEntityGenerator.DEFAULT_送信先市町村名称));
        }

        @Test
        public void 戻り値の住基識別コードは_設定した値と同じ住基識別コードを返す() {
            business = sut.set住基識別コード(DbT7034KoikiGaijiHenkanErrorLogEntityGenerator.DEFAULT_住基識別コード).build();
            assertThat(business.get住基識別コード(), is(DbT7034KoikiGaijiHenkanErrorLogEntityGenerator.DEFAULT_住基識別コード));
        }

        @Test
        public void 戻り値の確認区分は_設定した値と同じ確認区分を返す() {
            business = sut.set確認区分(DbT7034KoikiGaijiHenkanErrorLogEntityGenerator.DEFAULT_確認区分).build();
            assertThat(business.get確認区分(), is(DbT7034KoikiGaijiHenkanErrorLogEntityGenerator.DEFAULT_確認区分));
        }

        @Test
        public void 戻り値の識別コードは_設定した値と同じ識別コードを返す() {
            business = sut.set識別コード(DbT7034KoikiGaijiHenkanErrorLogEntityGenerator.DEFAULT_識別コード).build();
            assertThat(business.get識別コード(), is(DbT7034KoikiGaijiHenkanErrorLogEntityGenerator.DEFAULT_識別コード));
        }

        @Test
        public void 戻り値の被保険者番号は_設定した値と同じ被保険者番号を返す() {
            business = sut.set被保険者番号(DbT7034KoikiGaijiHenkanErrorLogEntityGenerator.DEFAULT_被保険者番号).build();
            assertThat(business.get被保険者番号(), is(DbT7034KoikiGaijiHenkanErrorLogEntityGenerator.DEFAULT_被保険者番号));
        }

        @Test
        public void 戻り値のレコードＮｏは_設定した値と同じレコードＮｏを返す() {
            business = sut.setレコードＮｏ(DbT7034KoikiGaijiHenkanErrorLogEntityGenerator.DEFAULT_レコードＮｏ).build();
            assertThat(business.getレコードＮｏ(), is(DbT7034KoikiGaijiHenkanErrorLogEntityGenerator.DEFAULT_レコードＮｏ));
        }

        @Test
        public void 戻り値の変換エラーフィールド名称は_設定した値と同じ変換エラーフィールド名称を返す() {
            business = sut.set変換エラーフィールド名称(DbT7034KoikiGaijiHenkanErrorLogEntityGenerator.DEFAULT_変換エラーフィールド名称).build();
            assertThat(business.get変換エラーフィールド名称(), is(DbT7034KoikiGaijiHenkanErrorLogEntityGenerator.DEFAULT_変換エラーフィールド名称));
        }

        @Test
        public void 戻り値の変換エラーフィールドＮｏは_設定した値と同じ変換エラーフィールドＮｏを返す() {
            business = sut.set変換エラーフィールドＮｏ(DbT7034KoikiGaijiHenkanErrorLogEntityGenerator.DEFAULT_変換エラーフィールドＮｏ).build();
            assertThat(business.get変換エラーフィールドＮｏ(), is(DbT7034KoikiGaijiHenkanErrorLogEntityGenerator.DEFAULT_変換エラーフィールドＮｏ));
        }

        @Test
        public void 戻り値の変換エラーコードは_設定した値と同じ変換エラーコードを返す() {
            business = sut.set変換エラーコード(DbT7034KoikiGaijiHenkanErrorLogEntityGenerator.DEFAULT_変換エラーコード).build();
            assertThat(business.get変換エラーコード(), is(DbT7034KoikiGaijiHenkanErrorLogEntityGenerator.DEFAULT_変換エラーコード));
        }

        @Test
        public void 戻り値のエラー表示連番は_設定した値と同じエラー表示連番を返す() {
            business = sut.setエラー表示連番(DbT7034KoikiGaijiHenkanErrorLogEntityGenerator.DEFAULT_エラー表示連番).build();
            assertThat(business.getエラー表示連番(), is(DbT7034KoikiGaijiHenkanErrorLogEntityGenerator.DEFAULT_エラー表示連番));
        }

        @Test
        public void 戻り値のエラー表示フィールド名称は_設定した値と同じエラー表示フィールド名称を返す() {
            business = sut.setエラー表示フィールド名称(DbT7034KoikiGaijiHenkanErrorLogEntityGenerator.DEFAULT_エラー表示フィールド名称).build();
            assertThat(business.getエラー表示フィールド名称(), is(DbT7034KoikiGaijiHenkanErrorLogEntityGenerator.DEFAULT_エラー表示フィールド名称));
        }

        @Test
        public void 戻り値のエラー表示フィールドは_設定した値と同じエラー表示フィールドを返す() {
            business = sut.setエラー表示フィールド(DbT7034KoikiGaijiHenkanErrorLogEntityGenerator.DEFAULT_エラー表示フィールド).build();
            assertThat(business.getエラー表示フィールド(), is(DbT7034KoikiGaijiHenkanErrorLogEntityGenerator.DEFAULT_エラー表示フィールド));
        }

    }
}
