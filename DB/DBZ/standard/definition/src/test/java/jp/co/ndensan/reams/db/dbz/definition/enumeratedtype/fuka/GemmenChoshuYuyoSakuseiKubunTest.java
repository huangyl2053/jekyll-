/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.fuka;

import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.is;

/**
 * GemmenChoshuYuyoSakuseiKubunのTestです。
 *
 * @author N3317 塚田 萌
 */
@RunWith(Enclosed.class)
public class GemmenChoshuYuyoSakuseiKubunTest extends DbzTestBase {

    public static class ToValue extends DbzTestBase {

        @Test
        public void toValueは_指定のコードに対応する列挙子があれば_それを返す() {
            GemmenChoshuYuyoSakuseiKubun sut = GemmenChoshuYuyoSakuseiKubun.決定_承認;
            assertThat(GemmenChoshuYuyoSakuseiKubun.toValue(sut.code()), is(sut));
        }

        @Test(expected = IllegalArgumentException.class)
        public void toValueは_指定のコードに対応する列挙子がなければ_IllegalArgumentExceptionを返す() {
            GemmenChoshuYuyoSakuseiKubun sut = GemmenChoshuYuyoSakuseiKubun.toValue(new RString("7"));
        }
    }
}
