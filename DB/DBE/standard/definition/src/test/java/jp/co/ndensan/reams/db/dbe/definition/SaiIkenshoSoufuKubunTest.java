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
 * 再意見書送付区分の列挙型を表すクラスのテストクラスです。
 *
 * @author n8107
 */
@RunWith(Enclosed.class)
public class SaiIkenshoSoufuKubunTest extends TestBase {

    public static class toValueTest extends TestBase {

        @Test
        public void 引数が設定内の再意見書送付区分である0の場合_toValueは_enum未使用を返す() {
            SaiChousaSoufuKubun sut = SaiChousaSoufuKubun.toValue(new RString("0"));
            assertThat(sut, is(SaiChousaSoufuKubun.未使用));
        }

        @Test
        public void 引数が設定内の再意見書送付区分である1の場合_toValueは_enum再送信を返す() {
            SaiIkenshoSoufuKubun sut = SaiIkenshoSoufuKubun.toValue(new RString("1"));
            assertThat(sut, is(SaiIkenshoSoufuKubun.再送信));
        }

        @Test
        public void 引数が設定内の再意見書送付区分である2の場合_toValueは_enum再意見書を返す() {
            SaiIkenshoSoufuKubun sut = SaiIkenshoSoufuKubun.toValue(new RString("2"));
            assertThat(sut, is(SaiIkenshoSoufuKubun.再意見書));
        }

        @Test
        public void 引数が設定内の再意見書送付区分である3の場合_toValueは_enum再意見書送付済を返す() {
            SaiIkenshoSoufuKubun sut = SaiIkenshoSoufuKubun.toValue(new RString("3"));
            assertThat(sut, is(SaiIkenshoSoufuKubun.再意見書送付済));
        }

        @Test(expected = IllegalArgumentException.class)
        public void 引数が設定外の再意見書送付区分である4の場合_toValueは_IllegalArgumentExceptionエラーを投げる() {
            SaiIkenshoSoufuKubun.toValue(new RString("4"));
        }

        @Test(expected = NullPointerException.class)
        public void 引数である再意見書送付区分がnullの場合_toValueは_NullPointerExceptionエラーを投げる() {
            SaiIkenshoSoufuKubun.toValue(null);
        }
    }

    public static class getCode {

        @Test
        public void 再意見書送付区分が未使用の場合_getCodeは_0を返す() {
            assertThat(SaiChousaSoufuKubun.未使用.getCode(), is(new RString("0")));
        }

        @Test
        public void 再意見書送付区分が再送信の場合_getCodeは_1を返す() {
            assertThat(SaiIkenshoSoufuKubun.再送信.getCode(), is(new RString("1")));
        }

        @Test
        public void 再意見書送付区分が再調査の場合_getCodeは_2を返す() {
            assertThat(SaiIkenshoSoufuKubun.再意見書.getCode(), is(new RString("2")));
        }

        @Test
        public void 再意見書送付区分が再意見書送付済の場合_getコードは_3を返す() {
            assertThat(SaiIkenshoSoufuKubun.再意見書送付済.getCode(), is(new RString("3")));
        }
    }

    public static class toRString {

        @Test
        public void 再調査送付区分が未使用の場合_toRStringは_未使用を返す() {
            assertThat(SaiChousaSoufuKubun.未使用.toRString(), is(new RString("未使用")));
        }

        @Test
        public void 再意見書送付区分が再送信の場合_toRStringは_再送信を返す() {
            assertThat(SaiIkenshoSoufuKubun.再送信.toRString(), is(new RString("再送信")));
        }

        @Test
        public void 再意見書送付区分が再意見書の場合_toRStringは_再意見書を返す() {
            assertThat(SaiIkenshoSoufuKubun.再意見書.toRString(), is(new RString("再意見書")));
        }

        @Test
        public void 再意見書送付区分が再意見書送付済の場合_toRStringは_再意見書送付済を返す() {
            assertThat(SaiIkenshoSoufuKubun.再意見書送付済.toRString(), is(new RString("再意見書送付済")));
        }
    }
}
