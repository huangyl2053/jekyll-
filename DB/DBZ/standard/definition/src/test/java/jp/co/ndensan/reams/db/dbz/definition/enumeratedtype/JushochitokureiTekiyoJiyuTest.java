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
 * JushochitokureiTekiyoJiyuのテストです。
 *
 * @author N3327 三浦 凌
 */
@RunWith(Enclosed.class)
public class JushochitokureiTekiyoJiyuTest extends DbzTestBase {

    public static class ToValue extends DbzTestBase {

        @Test
        public void toValueは_指定のコードに対応する列挙子があれば_それを返す() {
            JushochitokureiTekiyoJiyu sut = JushochitokureiTekiyoJiyu.自特例適用;
            assertThat(JushochitokureiTekiyoJiyu.toValue(sut.getCode()), is(sut));
        }

        @Test
        public void toValueは_nullを受け取った場合_EMPTYを返す() {
            JushochitokureiTekiyoJiyu sut = JushochitokureiTekiyoJiyu.EMPTY;
            assertThat(JushochitokureiTekiyoJiyu.toValue(null), is(sut));
        }

        @Test
        public void toValueは_空の文字列を受け取った場合_EMPTYを返す() {
            JushochitokureiTekiyoJiyu sut = JushochitokureiTekiyoJiyu.EMPTY;
            assertThat(JushochitokureiTekiyoJiyu.toValue(RString.EMPTY), is(sut));
        }

        @Test(expected = IllegalArgumentException.class)
        public void toValueは_指定のコードに対応する列挙子がなければ_IllegalArgumentExceptionを返す() {
            JushochitokureiTekiyoJiyu sut = JushochitokureiTekiyoJiyu.toValue(new RString("1000"));
        }
    }

    public static class GetName extends DbzTestBase {

        @Test
        public void getNameは_Enumクラスのnameと同じ値を返す() {
            assertThat(JushochitokureiTekiyoJiyu.自特例適用.getName().toString(), is(JushochitokureiTekiyoJiyu.自特例適用.name()));
        }
    }

    public static class GetShortName extends DbzTestBase {

        @Test
        public void getShortNameは_Enumクラスのnameと同じ値を返す() {
            assertThat(JushochitokureiTekiyoJiyu.自特例適用.getShortName().toString(), is(JushochitokureiTekiyoJiyu.自特例適用.name()));
        }
    }
}
