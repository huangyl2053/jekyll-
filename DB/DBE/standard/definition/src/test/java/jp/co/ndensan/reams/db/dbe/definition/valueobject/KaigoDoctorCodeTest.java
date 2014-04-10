/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.valueobject;

import jp.co.ndensan.reams.db.dbz.definition.valueobject.KaigoDoctorCode;
import jp.co.ndensan.reams.db.dbz.testhelper.DbeTestBase;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertThat;

/**
 * 介護医師コードを表すクラスのテストクラスです。
 *
 * @author N8156 宮本 康
 */
@RunWith(Enclosed.class)
public class KaigoDoctorCodeTest extends DbeTestBase {

    public static class コンストラクタ {

        @Test(expected = NullPointerException.class)
        public void 引数がNULLの時_コンストラクタは_NullPointerExceptionを投げる() {
            new KaigoDoctorCode(null);
        }
    }

    public static class equals extends DbeTestBase {

        @Test
        public void 引数と値が一致する時_equalsは_TRUEを返す() {
            assertThat(createKaigoDoctorCode("1234").equals(createKaigoDoctorCode("1234")), is(true));
        }

        @Test
        public void 引数と値が一致しない時_equalsは_FALSEを返す() {
            assertThat(createKaigoDoctorCode("1234").equals(createKaigoDoctorCode("5678")), is(false));
        }

        @Test
        public void 引数がNULLの時_equalsは_FALSEを返す() {
            assertThat(createKaigoDoctorCode("1234").equals(null), is(false));
        }

        @Test
        public void 引数が異なる型の時_equalsは_FALSEを返す() {
            assertThat(createKaigoDoctorCode("1234").equals(FlexibleDate.MIN), is(false));
        }
    }

    public static class hashCode extends DbeTestBase {

        @Test
        public void 引数と値が一致する時_hashCodeは_同一の値を返す() {
            assertThat(createKaigoDoctorCode("1234").hashCode(), is(createKaigoDoctorCode("1234").hashCode()));
        }

        @Test
        public void 引数と値が一致しない時_hashCodeは_異なる値を返す() {
            assertThat(createKaigoDoctorCode("1234").hashCode(), not(createKaigoDoctorCode("5678").hashCode()));
        }
    }

    public static class compareTo extends DbeTestBase {

        @Test
        public void 引数と値が一致する時_compareToは_0を返す() {
            assertThat(createKaigoDoctorCode("1234").compareTo(createKaigoDoctorCode("1234")) == 0, is(true));
        }

        @Test
        public void 引数より小さい時_compareToは_0より小さい値を返す() {
            assertThat(createKaigoDoctorCode("1234").compareTo(createKaigoDoctorCode("2222")) < 0, is(true));
        }

        @Test
        public void 引数より大きい時_compareToは_0より大きい値を返す() {
            assertThat(0 < createKaigoDoctorCode("1234").compareTo(createKaigoDoctorCode("1111")), is(true));
        }
    }

    private static KaigoDoctorCode createKaigoDoctorCode(String code) {
        return new KaigoDoctorCode(new RString(code));
    }
}
