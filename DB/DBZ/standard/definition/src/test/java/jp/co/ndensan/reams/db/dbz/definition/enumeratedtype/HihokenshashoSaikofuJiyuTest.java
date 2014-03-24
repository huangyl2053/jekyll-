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
 * HihokenshashoSaikofuJiyuのテストです。
 *
 * @author N3327 三浦 凌
 */
@RunWith(Enclosed.class)
public class HihokenshashoSaikofuJiyuTest extends DbzTestBase {

    public static class ToValue extends DbzTestBase {

        @Test
        public void toValueは_指定のコードに対応する列挙子があれば_それを返す() {
            HihokenshashoSaikofuJiyu sut = HihokenshashoSaikofuJiyu.その他;
            assertThat(HihokenshashoSaikofuJiyu.toValue(sut.getCode()), is(sut));
        }

        @Test(expected = IllegalArgumentException.class)
        public void toValueは_指定のコードに対応する列挙子がなければ_IllegalArgumentExceptionを返す() {
            HihokenshashoSaikofuJiyu sut = HihokenshashoSaikofuJiyu.toValue(new RString("1000"));
        }
    }
}
