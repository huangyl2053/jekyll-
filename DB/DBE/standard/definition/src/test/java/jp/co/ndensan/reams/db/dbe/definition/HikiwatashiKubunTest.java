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
 * 引渡し区分の列挙型を表すクラスのテストクラスです。
 *
 * @author n8107
 */
@RunWith(Enclosed.class)
public class HikiwatashiKubunTest extends TestBase {

    public static class toValueTest extends TestBase {

        @Test
        public void 引数が設定内の引渡し区分である1の場合_toValueは_enum引渡し済みを返す() {
            HikiwatashiKubun sut = HikiwatashiKubun.toValue(new RString("1"));
            assertThat(sut, is(HikiwatashiKubun.引渡し済み));
        }

        @Test
        public void 引数が設定内の引渡し区分である0の場合_toValueは_enum引き渡し未済を返す() {
            HikiwatashiKubun sut = HikiwatashiKubun.toValue(new RString("0"));
            assertThat(sut, is(HikiwatashiKubun.引き渡し未済));
        }

        @Test(expected = IllegalArgumentException.class)
        public void 引数が設定外の引渡し区分である4の場合_toValueは_IllegalArgumentExceptionエラーを投げる() {
            HikiwatashiKubun.toValue(new RString("4"));
        }

        @Test(expected = NullPointerException.class)
        public void 引数である引渡し区分がnullの場合_toValueは_NullPointerExceptionエラーを投げる() {
            HikiwatashiKubun.toValue(null);
        }
    }

    public static class getCode {

        @Test
        public void 引渡し区分が引渡し済みの場合_getCodeは_1を返す() {
            assertThat(HikiwatashiKubun.引渡し済み.getCode(), is(new RString("1")));
        }

        @Test
        public void 引渡し区分が引き渡し未済の場合_getCodeは_0を返す() {
            assertThat(HikiwatashiKubun.引き渡し未済.getCode(), is(new RString("0")));
        }
    }

    public static class toRString {

        @Test
        public void 引渡し区分が再送信の場合_toRStringは_引渡し済みを返す() {
            assertThat(HikiwatashiKubun.引渡し済み.toRString(), is(new RString("引渡し済み")));
        }

        @Test
        public void 引渡し区分が引き渡し未済の場合_toRStringは_再調査を返す() {
            assertThat(HikiwatashiKubun.引き渡し未済.toRString(), is(new RString("引き渡し未済")));
        }
    }
}
