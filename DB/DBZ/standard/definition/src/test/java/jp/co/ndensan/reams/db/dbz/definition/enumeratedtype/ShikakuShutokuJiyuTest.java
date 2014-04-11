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
import org.junit.Before;
import static org.mockito.Mockito.*;

/**
 * ShikakuShutokuJiyuのテストです。
 *
 * @author N3327 三浦 凌
 */
@RunWith(Enclosed.class)
public class ShikakuShutokuJiyuTest extends DbzTestBase {

    public static class ToValue extends DbzTestBase {

        @Test
        public void toValueは_指定のコードに対応する列挙子があれば_それを返す() {
            ShikakuShutokuJiyu sut = ShikakuShutokuJiyu.年齢到達;
            assertThat(ShikakuShutokuJiyu.toValue(sut.getCode()), is(sut));
        }

        @Test(expected = IllegalArgumentException.class)
        public void toValueは_指定のコードに対応する列挙子がなければ_IllegalArgumentExceptionを返す() {
            ShikakuShutokuJiyu sut = ShikakuShutokuJiyu.toValue(new RString("1000"));
        }
    }

    public static class GetName extends DbzTestBase {

        @Test
        public void getNameは_Enumクラスのnameと同じ値を返す() {
            assertThat(ShikakuShutokuJiyu.職権取得.getName().toString(), is(ShikakuShutokuJiyu.職権取得.name()));
        }
    }

    public static class GetShortName extends DbzTestBase {

        @Test
        public void getShortNameは_Enumクラスのnameと同じ値を返す() {
            assertThat(ShikakuShutokuJiyu.転入.getShortName().toString(), is(ShikakuShutokuJiyu.転入.name()));
        }
    }
}
