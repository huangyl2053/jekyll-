/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.testhelper.TestBase;
import static org.hamcrest.CoreMatchers.is;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * 再送付区分の列挙型を表すクラスのテストクラスです。
 *
 * @author n8107
 */
@RunWith(Enclosed.class)
public class SaiSoufuKubunTest extends TestBase {

    public static class toValueTest extends TestBase {

        @Test
        public void 引数が設定内の再送付区分である00の場合_toValueは_enum再送信無しを返す() {
            SaiSoufuKubun sut = SaiSoufuKubun.toValue(new RString("00"));
            assertThat(sut, is(SaiSoufuKubun.再送信無し));
        }

        @Test
        public void 引数が設定内の再送付区分である01の場合_toValueは_enum再送信を返す() {
            SaiSoufuKubun sut = SaiSoufuKubun.toValue(new RString("01"));
            assertThat(sut, is(SaiSoufuKubun.再送信));
        }

        @Test
        public void 引数が設定内の再送付区分である02の場合_toValueは_enum再送信送付済を返す() {
            SaiSoufuKubun sut = SaiSoufuKubun.toValue(new RString("02"));
            assertThat(sut, is(SaiSoufuKubun.再送信送付済));
        }

        @Test(expected = IllegalArgumentException.class)
        public void 引数が設定外の再送付区分である03の場合_toValueは_IllegalArgumentExceptionエラーを投げる() {
            SaiSoufuKubun.toValue(new RString("03"));
        }

        @Test(expected = NullPointerException.class)
        public void 引数である再送付区分がnullの場合_toValueは_NullPointerExceptionエラーを投げる() {
            SaiSoufuKubun.toValue(null);
        }
    }

    public static class getCode {

        @Test
        public void 再送付区分が再送信無しの場合_getCodeは_00を返す() {
            assertThat(SaiSoufuKubun.再送信無し.getCode(), is(new RString("00")));
        }

        @Test
        public void 再送付区分が再送信の場合_getCodeは_01を返す() {
            assertThat(SaiSoufuKubun.再送信.getCode(), is(new RString("01")));
        }

        @Test
        public void 再送付区分が再送信送付済の場合_getCodeは_02を返す() {
            assertThat(SaiSoufuKubun.再送信送付済.getCode(), is(new RString("02")));
        }
    }

    public static class toRString {

        @Test
        public void 再意見書送付区分が再送信無しの場合_toRStringは_再送信無しを返す() {
            assertThat(SaiSoufuKubun.再送信無し.toRString(), is(new RString("再送信無し")));
        }

        @Test
        public void 再意見書送付区分が再送信の場合_toRStringは_再送信を返す() {
            assertThat(SaiSoufuKubun.再送信.toRString(), is(new RString("再送信")));
        }

        @Test
        public void 再意見書送付区分が再送信送付済の場合_toRStringは_再送信送付済を返す() {
            assertThat(SaiSoufuKubun.再送信送付済.toRString(), is(new RString("再送信送付済")));
        }
    }
}
