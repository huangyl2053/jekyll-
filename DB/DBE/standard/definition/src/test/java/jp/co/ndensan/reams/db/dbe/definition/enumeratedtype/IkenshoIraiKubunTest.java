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
 * 意見書作成依頼区分を表す列挙型のテストクラスです。
 *
 * @author N8156 宮本 康
 */
@RunWith(Enclosed.class)
public class IkenshoIraiKubunTest {

    public static class toValue {

        @Test
        public void 引数が1の時_toValueは_初回依頼を返す() {
            assertThat(IkenshoIraiKubun.toValue(new RString("1")), is(IkenshoIraiKubun.初回依頼));
        }

        @Test
        public void 引数が2の時_toValueは_再依頼を返す() {
            assertThat(IkenshoIraiKubun.toValue(new RString("2")), is(IkenshoIraiKubun.再依頼));
        }

        @Test
        public void 引数が3の時_toValueは_再意見書を返す() {
            assertThat(IkenshoIraiKubun.toValue(new RString("3")), is(IkenshoIraiKubun.再意見書));
        }

        @Test(expected = IllegalArgumentException.class)
        public void 引数が99の時_toValueは_IllegalArgumentExceptionを投げる() {
            IkenshoIraiKubun.toValue(new RString("99"));
        }

        @Test(expected = IllegalArgumentException.class)
        public void 引数がNULLの時_toValueは_IllegalArgumentExceptionを投げる() {
            IkenshoIraiKubun.toValue(null);
        }
    }
}
