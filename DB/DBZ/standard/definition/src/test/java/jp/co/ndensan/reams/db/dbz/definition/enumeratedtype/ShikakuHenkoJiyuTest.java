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
 * ShikakuHenkoJiyuのテストです。
 *
 * @author N3327 三浦 凌
 */
@RunWith(Enclosed.class)
public class ShikakuHenkoJiyuTest extends DbzTestBase {

    public static class ToValue extends DbzTestBase {

        @Test
        public void toValueは_指定のコードに対応する列挙子があれば_それを返す() {
            ShikakuHenkoJiyu sut = ShikakuHenkoJiyu.その他;
            assertThat(ShikakuHenkoJiyu.toValue(sut.getCode()), is(sut));
        }

        @Test(expected = IllegalArgumentException.class)
        public void toValueは_指定のコードに対応する列挙子がなければ_IllegalArgumentExceptionを返す() {
            ShikakuHenkoJiyu sut = ShikakuHenkoJiyu.toValue(new RString("1000"));
        }
    }

    public static class GetName extends DbzTestBase {

        @Test
        public void getNameは_Enumクラスのnameと同じ値を返す() {
            assertThat(ShikakuHenkoJiyu.その他.getName().toString(), is(ShikakuHenkoJiyu.その他.name()));
        }
    }

    public static class GetShortName extends DbzTestBase {

        @Test
        public void getShortNameは_Enumクラスのnameと同じ値を返す() {
            assertThat(ShikakuHenkoJiyu.その他.getShortName().toString(), is(ShikakuHenkoJiyu.その他.name()));
        }
    }
}
