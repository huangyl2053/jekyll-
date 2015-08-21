/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.definition.enumeratedtype;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.db.dbx.testhelper.DbxTestBase;
import static org.hamcrest.CoreMatchers.is;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 *
 * @author N2806 太田 智之
 */
@RunWith(Enclosed.class)
public class YoKaigoJotaiKubunTest extends DbxTestBase {

    public static class toValueTest extends DbxTestBase {

        @Test
        public void 引数に01を指定した場合_toValueは_非該当を返す() {
            assertThat(YoKaigoJotaiKubun.toValue(new RString("01")), is(YoKaigoJotaiKubun.非該当));
        }

        @Test
        public void 引数に11を指定した場合_toValueは_要支援_経過的要介護を返す() {
            assertThat(YoKaigoJotaiKubun.toValue(new RString("11")), is(YoKaigoJotaiKubun.要支援_経過的要介護));
        }

        @Test
        public void 引数に12を指定した場合_toValueは_要支援1を返す() {
            assertThat(YoKaigoJotaiKubun.toValue(new RString("12")), is(YoKaigoJotaiKubun.要支援1));
        }

        @Test
        public void 引数に13を指定した場合_toValueは_要支援2を返す() {
            assertThat(YoKaigoJotaiKubun.toValue(new RString("13")), is(YoKaigoJotaiKubun.要支援2));
        }

        @Test
        public void 引数に21を指定した場合_toValueは_要介護1を返す() {
            assertThat(YoKaigoJotaiKubun.toValue(new RString("21")), is(YoKaigoJotaiKubun.要介護1));
        }

        @Test
        public void 引数に22を指定した場合_toValueは_要介護2を返す() {
            assertThat(YoKaigoJotaiKubun.toValue(new RString("22")), is(YoKaigoJotaiKubun.要介護2));
        }

        @Test
        public void 引数に23を指定した場合_toValueは_要介護3を返す() {
            assertThat(YoKaigoJotaiKubun.toValue(new RString("23")), is(YoKaigoJotaiKubun.要介護3));
        }

        @Test
        public void 引数に24を指定した場合_toValueは_要介護4を返す() {
            assertThat(YoKaigoJotaiKubun.toValue(new RString("24")), is(YoKaigoJotaiKubun.要介護4));
        }

        @Test
        public void 引数に25を指定した場合_toValueは_要介護5を返す() {
            assertThat(YoKaigoJotaiKubun.toValue(new RString("25")), is(YoKaigoJotaiKubun.要介護5));
        }

        @Test(expected = IllegalArgumentException.class)
        public void 引数に26を指定した場合_toValueは_IllegalArgumentExceptionを発生させる() {
            YoKaigoJotaiKubun.toValue(new RString("26"));
        }
        
        @Test
        public void LDNS_引数に要介護5を設定した場合_valueOfは_要介護5を返す() {
            YoKaigoJotaiKubun result = YoKaigoJotaiKubun.valueOf("要介護5");
            assertThat(result, is(YoKaigoJotaiKubun.要介護5));
        }
        
        @Test
        public void LDNS_引数に要介護5を設定した場合_getCodeは_25を返す() {
            RString result = YoKaigoJotaiKubun.要介護5.getCode();
            assertThat(result, is(new RString("25")));
        }
    }
}
