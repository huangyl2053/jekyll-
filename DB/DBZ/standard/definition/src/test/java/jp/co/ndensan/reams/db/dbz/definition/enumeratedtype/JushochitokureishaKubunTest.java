/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.enumeratedtype;

import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.JushochitokureishaKubun}のテストです。
 *
 * @author n8178 城間篤人
 */
@RunWith(Enclosed.class)
public class JushochitokureishaKubunTest {

    public static class toValue extends DbzTestBase {

        @Test
        public void toValueは_指定のコードに対応する列挙子があれば_それを返す() {
            JushochitokureishaKubun sut = JushochitokureishaKubun.住所地特例者;
            assertThat(JushochitokureishaKubun.toValue(sut.code()), is(sut));
        }

        @Test
        public void toValueは_nullが渡された場合_EMPTYを返す() {
            JushochitokureishaKubun sut = JushochitokureishaKubun.EMPTY;
            assertThat(JushochitokureishaKubun.toValue(null), is(sut));
        }

        @Test
        public void toValueは_空の文字列が渡された場合_EMPTYを返す() {
            JushochitokureishaKubun sut = JushochitokureishaKubun.EMPTY;
            assertThat(JushochitokureishaKubun.toValue(RString.EMPTY), is(sut));
        }

        @Test(expected = IllegalArgumentException.class)
        public void toValueは_指定のコードに対応する列挙子がなければ_IllegalArgumentExceptionを返す() {
            ShikakuSoshitsuJiyu sut = ShikakuSoshitsuJiyu.toValue(new RString("1000"));
        }
    }

}
