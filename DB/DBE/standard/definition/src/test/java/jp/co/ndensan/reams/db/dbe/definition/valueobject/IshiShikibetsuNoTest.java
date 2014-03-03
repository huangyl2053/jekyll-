/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.valueobject;

import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertThat;

/**
 * 医師識別番号を表すクラスのテストクラスです。
 *
 * @author N8156 宮本 康
 */
@RunWith(Enclosed.class)
public class IshiShikibetsuNoTest {

    public static class コンストラクタ {

        @Test(expected = NullPointerException.class)
        public void 引数がNULLの時_コンストラクタは_NullPointerExceptionを投げる() {
            new IshiShikibetsuNo(null);
        }
    }

    public static class equals {

        @Test
        public void 引数と値が一致する時_equalsは_TRUEを返す() {
            assertThat(createIshiShikibetsuNo("1234").equals(createIshiShikibetsuNo("1234")), is(true));
        }

        @Test
        public void 引数と値が一致しない時_equalsは_FALSEを返す() {
            assertThat(createIshiShikibetsuNo("1234").equals(createIshiShikibetsuNo("5678")), is(false));
        }

        @Test
        public void 引数がNULLの時_equalsは_FALSEを返す() {
            assertThat(createIshiShikibetsuNo("1234").equals(null), is(false));
        }

        @Test
        public void 引数が異なる型の時_equalsは_FALSEを返す() {
            assertThat(createIshiShikibetsuNo("1234").equals(FlexibleDate.MIN), is(false));
        }
    }

    public static class hashCode {

        @Test
        public void 引数と値が一致する時_hashCodeは_同一の値を返す() {
            assertThat(createIshiShikibetsuNo("1234").hashCode(), is(createIshiShikibetsuNo("1234").hashCode()));
        }

        @Test
        public void 引数と値が一致しない時_hashCodeは_異なる値を返す() {
            assertThat(createIshiShikibetsuNo("1234").hashCode(), not(createIshiShikibetsuNo("5678").hashCode()));
        }
    }

    public static class compareTo {

        @Test
        public void 引数と値が一致する時_compareToは_0を返す() {
            assertThat(createIshiShikibetsuNo("1234").compareTo(createIshiShikibetsuNo("1234")) == 0, is(true));
        }

        @Test
        public void 引数より小さい時_compareToは_0より小さい値を返す() {
            assertThat(createIshiShikibetsuNo("1234").compareTo(createIshiShikibetsuNo("2222")) < 0, is(true));
        }

        @Test
        public void 引数より大きい時_compareToは_0より大きい値を返す() {
            assertThat(0 < createIshiShikibetsuNo("1234").compareTo(createIshiShikibetsuNo("1111")), is(true));
        }
    }

    private static IshiShikibetsuNo createIshiShikibetsuNo(String no) {
        return new IshiShikibetsuNo(new RString(no));
    }
}
