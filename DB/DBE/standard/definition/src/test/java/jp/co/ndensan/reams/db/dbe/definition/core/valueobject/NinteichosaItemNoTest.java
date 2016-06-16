/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.core.valueobject;

import jp.co.ndensan.reams.db.dbe.definition.core.ninteichosaitemno.NinteichosaItemNo;
import jp.co.ndensan.reams.db.dbz.testhelper.DbeTestBase;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertThat;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * 要介護認定調査の調査項目番号を表すクラスのテストクラスです。
 *
 * @author N8156 宮本 康
 */
@RunWith(Enclosed.class)
public class NinteichosaItemNoTest extends DbeTestBase {

    public static class コンストラクタ extends DbeTestBase {

        @Test(expected = NullPointerException.class)
        public void 引数がNULLの時_コンストラクタは_NullPointerExceptionを投げる() {
            new NinteichosaItemNo(null);
        }
    }

    public static class equals extends DbeTestBase {

        @Test
        public void 引数と値が一致する時_equalsは_TRUEを返す() {
            assertThat(createNinteichosaItemNo("1234").equals(createNinteichosaItemNo("1234")), is(true));
        }

        @Test
        public void 引数と値が一致しない時_equalsは_FALSEを返す() {
            assertThat(createNinteichosaItemNo("1234").equals(createNinteichosaItemNo("5678")), is(false));
        }

        @Test
        public void 引数がNULLの時_equalsは_FALSEを返す() {
            assertThat(createNinteichosaItemNo("1234").equals(null), is(false));
        }

        @Test
        public void 引数が異なる型の時_equalsは_FALSEを返す() {
            assertThat(createNinteichosaItemNo("1234").equals(FlexibleDate.MIN), is(false));
        }
    }

    public static class hashCode extends DbeTestBase {

        @Test
        public void 引数と値が一致する時_hashCodeは_同一の値を返す() {
            assertThat(createNinteichosaItemNo("1234").hashCode(), is(createNinteichosaItemNo("1234").hashCode()));
        }

        @Test
        public void 引数と値が一致しない時_hashCodeは_異なる値を返す() {
            assertThat(createNinteichosaItemNo("1234").hashCode(), not(createNinteichosaItemNo("5678").hashCode()));
        }
    }

    public static class compareTo extends DbeTestBase {

        @Test
        public void 引数と値が一致する時_compareToは_0を返す() {
            assertThat(createNinteichosaItemNo("1234").compareTo(createNinteichosaItemNo("1234")) == 0, is(true));
        }

        @Test
        public void 引数より小さい時_compareToは_0より小さい値を返す() {
            assertThat(createNinteichosaItemNo("1234").compareTo(createNinteichosaItemNo("2222")) < 0, is(true));
        }

        @Test
        public void 引数より大きい時_compareToは_0より大きい値を返す() {
            assertThat(0 < createNinteichosaItemNo("1234").compareTo(createNinteichosaItemNo("1111")), is(true));
        }
    }

    private static NinteichosaItemNo createNinteichosaItemNo(String no) {
        return new NinteichosaItemNo(new RString(no));
    }
}
