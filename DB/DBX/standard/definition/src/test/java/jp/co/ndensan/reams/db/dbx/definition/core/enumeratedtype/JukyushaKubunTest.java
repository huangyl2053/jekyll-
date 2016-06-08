/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.definition.core.enumeratedtype;

import jp.co.ndensan.reams.db.dbx.definition.core.enumeratedtype.JukyushaKubun;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.db.dbx.testhelper.DbxTestBase;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * 受給者区分のテストクラスです。
 *
 * @author N2218 村松 優
 */
@RunWith(Enclosed.class)
public class JukyushaKubunTest {

    public static class ToValueTest extends DbxTestBase {

        @Test
        public void 引数が設定内の受給者区分コードである1の場合_toValueは_enum受給者を返す() {
            JukyushaKubun sut = JukyushaKubun.toValue(new RString("1"));
            assertThat(sut, is(JukyushaKubun.受給者));
        }

        @Test
        public void 引数が設定内の受給者区分コードである空白の場合_toValueは_enum非受給者を返す() {
            JukyushaKubun sut = JukyushaKubun.toValue(new RString(""));
            assertThat(sut, is(JukyushaKubun.非受給者));
        }

        @Test(expected = IllegalArgumentException.class)
        public void 引数が設定外の受給者区分コードである3の場合_toValueは_IllegalArgumentExceptionエラーを投げる() {
            JukyushaKubun.toValue(new RString("3"));
        }

        @Test(expected = NullPointerException.class)
        public void 引数である受給者区分コードがnullの場合_toValueは_NullPointerExceptionエラーを投げる() {
            JukyushaKubun.toValue(null);
        }

        @Test
        public void LDNS_引数が設定内の受給者区分コードである1の場合_toRStringは_受給者を返す() {
            assertThat(new RString("受給者"), is(JukyushaKubun.受給者.toRString()));
        }

        @Test
        public void LDNS_引数が設定内の受給者区分コードであるの場合_valueOfは_受給者を返す() {
            assertThat(JukyushaKubun.受給者, is(JukyushaKubun.valueOf("受給者")));
        }
    }

    public static class getコード {

        @Test
        public void 受給者区分が受給者の場合_getコードは_1を返す() {
            assertThat(JukyushaKubun.受給者.getコード(), is(new RString("1")));
        }
    }
}
