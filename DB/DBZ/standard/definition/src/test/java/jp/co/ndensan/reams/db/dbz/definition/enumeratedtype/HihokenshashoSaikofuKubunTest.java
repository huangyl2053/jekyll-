/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.enumeratedtype;

import jp.co.ndensan.reams.db.dbz.definition.core.enumeratedtype.HihokenshashoSaikofuKubun;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.is;

/**
 * HihokenshashoSaikofuKubunのテストです。
 *
 * @author N3327 三浦 凌
 */
@RunWith(Enclosed.class)
public class HihokenshashoSaikofuKubunTest extends DbzTestBase {

    public static class ToValue extends DbzTestBase {

        @Test
        public void toValueは_指定のコードに対応する列挙子があれば_それを返す() {
            HihokenshashoSaikofuKubun sut = HihokenshashoSaikofuKubun.あり;
            assertThat(HihokenshashoSaikofuKubun.toValue(sut.getCode()), is(sut));
        }

        @Test
        public void toValueは_nullを渡された場合_EMPTYを返す() {
            HihokenshashoSaikofuKubun sut = HihokenshashoSaikofuKubun.EMPTY;
            assertThat(HihokenshashoSaikofuKubun.toValue(null), is(sut));
        }

        @Test
        public void toValueは_空の文字列を渡された場合_EMPTYを返す() {
            HihokenshashoSaikofuKubun sut = HihokenshashoSaikofuKubun.EMPTY;
            assertThat(HihokenshashoSaikofuKubun.toValue(RString.EMPTY), is(sut));
        }

        @Test(expected = IllegalArgumentException.class)
        public void toValueは_指定のコードに対応する列挙子がなければ_IllegalArgumentExceptionを返す() {
            HihokenshashoSaikofuKubun sut = HihokenshashoSaikofuKubun.toValue(new RString("1000"));
        }
    }
}
