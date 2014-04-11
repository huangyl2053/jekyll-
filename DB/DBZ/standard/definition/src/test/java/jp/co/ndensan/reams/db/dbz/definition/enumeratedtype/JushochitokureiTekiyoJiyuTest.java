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
            JushochitokureiTekiyoJiyu sut = JushochitokureiTekiyoJiyu.特例転入;
            assertThat(JushochitokureiTekiyoJiyu.toValue(sut.getCode()), is(sut));
        }

        @Test(expected = IllegalArgumentException.class)
        public void toValueは_指定のコードに対応する列挙子がなければ_IllegalArgumentExceptionを返す() {
            JushochitokureiTekiyoJiyu sut = JushochitokureiTekiyoJiyu.toValue(new RString("1000"));
        }
    }

    public static class GetName extends DbzTestBase {

        @Test
        public void getNameは_Enumクラスのnameと同じ値を返す() {
            assertThat(JushochitokureiTekiyoJiyu.特例適用.getName().toString(), is(JushochitokureiTekiyoJiyu.特例適用.name()));
        }
    }

    public static class GetShortName extends DbzTestBase {

        @Test
        public void getShortNameは_Enumクラスのnameと同じ値を返す() {
            assertThat(JushochitokureiTekiyoJiyu.特例転入.getShortName().toString(), is(JushochitokureiTekiyoJiyu.特例転入.name()));
        }
    }
}
