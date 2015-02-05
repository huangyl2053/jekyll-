/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.enumeratedtype;

import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.is;

/**
 * JushochitokureiKaijoJiyuのテストです。
 *
 * @author N3327 三浦 凌
 */
@RunWith(Enclosed.class)
public class JushochitokureiKaijoJiyuTest extends DbzTestBase {

    public static class ToValue extends DbzTestBase {

        @Test
        public void toValueは_指定のコードに対応する列挙子があれば_それを返す() {
            JushochitokureiKaijoJiyu sut = JushochitokureiKaijoJiyu.自特例転入;
            assertThat(JushochitokureiKaijoJiyu.toValue(sut.getCode()), is(sut));
        }

        @Test
        public void toValueは_nullを受け取った場合_EMPTYを返す() {
            JushochitokureiKaijoJiyu sut = JushochitokureiKaijoJiyu.EMPTY;
            assertThat(JushochitokureiKaijoJiyu.toValue(null), is(sut));
        }

        @Test
        public void toValueは_空の文字列を受け取った場合_EMPTYを返す() {
            JushochitokureiKaijoJiyu sut = JushochitokureiKaijoJiyu.EMPTY;
            assertThat(JushochitokureiKaijoJiyu.toValue(RString.EMPTY), is(sut));
        }

        @Test(expected = IllegalArgumentException.class)
        public void toValueは_指定のコードに対応する列挙子がなければ_IllegalArgumentExceptionを返す() {
            JushochitokureiKaijoJiyu sut = JushochitokureiKaijoJiyu.toValue(new RString("1000"));
        }
    }

    public static class GetName extends DbzTestBase {

        @Test
        public void getNameは_Enumクラスのnameと同じ値を返す() {
            assertThat(JushochitokureiKaijoJiyu.自特例解除.getName().toString(), is(JushochitokureiKaijoJiyu.自特例解除.name()));
        }
    }

    public static class GetShortName extends DbzTestBase {

        @Test
        public void getShortNameは_Enumクラスのnameと同じ値を返す() {
            assertThat(JushochitokureiKaijoJiyu.自特例転入.getShortName().toString(), is(JushochitokureiKaijoJiyu.自特例転入.name()));
        }
    }
}
