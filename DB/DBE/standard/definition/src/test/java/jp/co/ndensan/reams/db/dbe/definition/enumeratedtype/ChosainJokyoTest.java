/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.enumeratedtype;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.testhelper.TestBase;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.is;

/**
 * 調査員の状況を表す列挙型のテストクラスです。
 *
 * @author N8187 久保田 英男
 */
@RunWith(Enclosed.class)
public class ChosainJokyoTest extends TestBase {

    public static class toValue extends TestBase {

        @Test
        public void toValueは_指定のコードに対応する列挙子があれば_それを返す() {
            ChosainJokyo sut = ChosainJokyo.有効;
            assertThat(ChosainJokyo.toValue(sut.getCode()), is(sut));
        }

        @Test(expected = IllegalArgumentException.class)
        public void toValueは_指定のコードに対応する列挙子がなければ_IllegalArgumentExceptionを返す() {
            ChosainJokyo sut = ChosainJokyo.toValue(new RString("2"));
        }
    }

    public static class toRString extends TestBase {

        @Test
        public void toRStringは_Enumクラスのnameと同じ値を返す() {
            assertThat(ChosainJokyo.無効.toRString().toString(), is(ChosainJokyo.無効.name()));
        }
    }
}
