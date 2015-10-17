/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.definition.enumeratedtype;

import jp.co.ndensan.reams.db.dbx.definition.core.enumeratedtype.JushochiTokureishaKubun;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.db.dbx.testhelper.DbxTestBase;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * 住所地特例者区分のテストクラスです。
 *
 * @author N2218 村松 優
 */
@RunWith(Enclosed.class)
public class JushochiTokureishaKubunTest {

    public static class toValueTest extends DbxTestBase {

        @Test
        public void 引数が設定内の住所地特例者区分コードである1の場合_toValueは_enum住所地特例者を返す() {
            JushochiTokureishaKubun sut = JushochiTokureishaKubun.toValue(new RString("1"));
            assertThat(sut, is(JushochiTokureishaKubun.住所地特例者));
        }

        @Test
        public void 引数が設定内の住所地特例者区分コードである空白の場合_toValueは_enum通常資格者を返す() {
            JushochiTokureishaKubun sut = JushochiTokureishaKubun.toValue(new RString(""));
            assertThat(sut, is(JushochiTokureishaKubun.通常資格者));
        }

        @Test(expected = IllegalArgumentException.class)
        public void 引数が設定外の住所地特例者区分コードである3の場合_toValueは_IllegalArgumentExceptionエラーを投げる() {
            JushochiTokureishaKubun.toValue(new RString("3"));
        }

        @Test(expected = NullPointerException.class)
        public void 引数である住所地特例者区分コードがnullの場合_toValueは_NullPointerExceptionエラーを投げる() {
            JushochiTokureishaKubun.toValue(null);
        }
    }

    public static class getコード {

        @Test
        public void 住所地特例者区分が住所地特例者の場合_getコードは_1を返す() {
            assertThat(JushochiTokureishaKubun.住所地特例者.getコード(), is(new RString("1")));
        }
    }

    public static class get名称 {

        @Test
        public void 住所地特例者区分が通常資格者の場合_get名称は_通常資格者を返す() {
            assertThat(JushochiTokureishaKubun.通常資格者.get名称(), is(new RString("通常資格者")));
        }
    }

    public static class toRString {

        @Test
        public void LDNS_住所地特例者区分が通常資格者の場合_toRStringは_通常資格者を返す() {
            assertThat(JushochiTokureishaKubun.通常資格者.toRString(), is(new RString("通常資格者")));
        }
    }

    public static class valueOf {

        @Test
        public void LDNS_引数が設定外の住所地特例者区分コー通常資格者を設定するの場合_valueOfは_通常資格者の検索種類を返す() {
            assertThat(JushochiTokureishaKubun.valueOf("通常資格者"), is(JushochiTokureishaKubun.通常資格者));
        }
    }
}
