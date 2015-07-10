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
 * KoikinaiJushochitokureishaKubunのテストです。
 *
 * @author N3327 三浦 凌
 */
@RunWith(Enclosed.class)
public class KoikinaiJushochitokureishaKubunTest extends DbzTestBase {

    public static class ToValue extends DbzTestBase {

        @Test
        public void toValueは_指定のコードに対応する列挙子があれば_それを返す() {
            KoikinaiJushochitokureishaKubun sut = KoikinaiJushochitokureishaKubun.広域内住所地特例者;
            assertThat(KoikinaiJushochitokureishaKubun.toValue(sut.getCode()), is(sut));
        }

        @Test
        public void toValueは_nullを受け取った場合_EMPTYを返す() {
            KoikinaiJushochitokureishaKubun sut = KoikinaiJushochitokureishaKubun.EMPTY;
            assertThat(KoikinaiJushochitokureishaKubun.toValue(null), is(sut));
        }

        @Test
        public void toValueは_空の文字列を受け取った場合_EMPTYを返す() {
            KoikinaiJushochitokureishaKubun sut = KoikinaiJushochitokureishaKubun.EMPTY;
            assertThat(KoikinaiJushochitokureishaKubun.toValue(RString.EMPTY), is(sut));
        }

        @Test(expected = IllegalArgumentException.class)
        public void toValueは_指定のコードに対応する列挙子がなければ_IllegalArgumentExceptionを返す() {
            KoikinaiJushochitokureishaKubun sut = KoikinaiJushochitokureishaKubun.toValue(new RString("1000"));
        }
    }
}
