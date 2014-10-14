/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.enumeratedtype;

import jp.co.ndensan.reams.db.dbz.testhelper.DbeTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * 医師の状況を表す列挙型のテストクラスです。
 *
 * @author N8156 宮本 康
 */
@RunWith(Enclosed.class)
public class IshiJokyoTest extends DbeTestBase {

    public static class toValue extends DbeTestBase {

        @Test
        public void toValueは_指定のコードに対応する列挙子があれば_それを返す() {
            IshiJokyo sut = IshiJokyo.有効;
            assertThat(IshiJokyo.toValue(sut.getCode()), is(sut));
        }

        @Test(expected = IllegalArgumentException.class)
        public void toValueは_指定のコードに対応する列挙子がなければ_IllegalArgumentExceptionを返す() {
            IshiJokyo sut = IshiJokyo.toValue(new RString("2"));
        }
    }

    public static class toRString extends DbeTestBase {

        @Test
        public void toRStringは_Enumクラスのnameと同じ値を返す() {
            assertThat(IshiJokyo.無効.toRString().toString(), is(IshiJokyo.無効.name()));
        }
    }
}
