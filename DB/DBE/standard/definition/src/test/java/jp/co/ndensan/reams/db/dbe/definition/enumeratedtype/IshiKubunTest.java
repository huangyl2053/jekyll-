/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.enumeratedtype;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * 医師区分を表す列挙型のテストクラスです。
 *
 * @author N8156 宮本 康
 */
@RunWith(Enclosed.class)
public class IshiKubunTest {

    public static class toValue {

        @Test
        public void 引数が1の時_toValueは_主治医を返す() {
            assertThat(IshiKubun.toValue(new RString("1")), is(IshiKubun.主治医));
        }

        @Test
        public void 引数が2の時_toValueは_指定医を返す() {
            assertThat(IshiKubun.toValue(new RString("2")), is(IshiKubun.指定医));
        }

        @Test(expected = IllegalArgumentException.class)
        public void 引数が99の時_toValueは_IllegalArgumentExceptionを投げる() {
            IshiKubun.toValue(new RString("99"));
        }

        @Test(expected = IllegalArgumentException.class)
        public void 引数がNULLの時_toValueは_IllegalArgumentExceptionを投げる() {
            IshiKubun.toValue(null);
        }
    }
}
