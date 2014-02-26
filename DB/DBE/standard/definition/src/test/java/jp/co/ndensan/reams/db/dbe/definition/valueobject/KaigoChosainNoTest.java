/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.valueobject;

import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.testhelper.TestBase;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import static org.junit.Assert.assertThat;

/**
 * 介護独自の認定調査員番号を表すクラスのテストです。
 *
 * @author N8187 久保田 英男
 */
@RunWith(Enclosed.class)
public class KaigoChosainNoTest extends TestBase {

    private static KaigoChosainNo sut;

    public static class コンストラクタ extends TestBase {

        @Test(expected = NullPointerException.class)
        public void 引数がNULLの時_コンストラクタは_NullPointerExceptionを投げる() {
            sut = new KaigoChosainNo(null);
        }
    }

    public static class equals extends TestBase {

        @Override
        public void setUp() {
            sut = createKaigoChosainNo("1234");
        }

        @Test
        public void 引数と値が一致する時_equalsは_TRUEを返す() {
            assertThat(sut.equals(createKaigoChosainNo("1234")), is(true));
        }

        @Test
        public void 引数と値が一致しない時_equalsは_FALSEを返す() {
            assertThat(sut.equals(createKaigoChosainNo("5678")), is(false));
        }

        @Test
        public void 引数がNULLの時_equalsは_FALSEを返す() {
            assertThat(sut.equals(null), is(false));
        }

        @Test
        public void 引数が異なる型の時_equalsは_FALSEを返す() {
            assertThat(sut.equals(FlexibleDate.MIN), is(false));
        }
    }

    public static class hashCode extends TestBase {

        @Override
        public void setUp() {
            sut = createKaigoChosainNo("1234");
        }

        @Test
        public void 引数と値が一致する時_hashCodeは_同一の値を返す() {
            assertThat(sut.hashCode(), is(createKaigoChosainNo("1234").hashCode()));
        }

        @Test
        public void 引数と値が一致しない時_hashCodeは_異なる値を返す() {
            assertThat(sut.hashCode(), not(createKaigoChosainNo("5678").hashCode()));
        }
    }

    public static class compareTo extends TestBase {

        @Override
        public void setUp() {
            sut = createKaigoChosainNo("1234");
        }

        @Test
        public void 引数と値が一致する時_compareToは_0を返す() {
            assertThat(sut.compareTo(createKaigoChosainNo("1234")) == 0, is(true));
        }

        @Test
        public void 引数より小さい時_compareToは_0より小さい値を返す() {
            assertThat(sut.compareTo(createKaigoChosainNo("2222")) < 0, is(true));
        }

        @Test
        public void 引数より大きい時_compareToは_0より大きい値を返す() {
            assertThat(0 < sut.compareTo(createKaigoChosainNo("1111")), is(true));
        }
    }

    private static KaigoChosainNo createKaigoChosainNo(String code) {
        return new KaigoChosainNo(new RString(code));
    }
}
