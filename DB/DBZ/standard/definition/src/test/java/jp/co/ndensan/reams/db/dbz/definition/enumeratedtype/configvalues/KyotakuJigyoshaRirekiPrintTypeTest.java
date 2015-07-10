/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.configvalues;

import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.configvalues.KyotakuJigyoshaRirekiPrintType}のテストです。
 *
 * @author n8178 城間篤人
 */
@RunWith(Enclosed.class)
public class KyotakuJigyoshaRirekiPrintTypeTest {

    public static class toValue extends DbzTestBase {

        private RString target;

        @Test
        public void 引数に_0_が渡された場合_表示が返る() {
            target = new RString("0");
            assertThat(KyotakuJigyoshaRirekiPrintType.toValue(target), is(KyotakuJigyoshaRirekiPrintType.表示));
        }

        @Test
        public void 引数に_1_が渡された場合_非表示が返る() {
            target = new RString("1");
            assertThat(KyotakuJigyoshaRirekiPrintType.toValue(target), is(KyotakuJigyoshaRirekiPrintType.非表示));
        }

        @Test
        public void 引数に_2_が渡された場合_アスタリスクが返る() {
            target = new RString("2");
            assertThat(KyotakuJigyoshaRirekiPrintType.toValue(target), is(KyotakuJigyoshaRirekiPrintType.アスタリスク));
        }

        @Test
        public void 引数に_3_が渡された場合_抹消線が返る() {
            target = new RString("3");
            assertThat(KyotakuJigyoshaRirekiPrintType.toValue(target), is(KyotakuJigyoshaRirekiPrintType.抹消線));
        }

        @Test(expected = IllegalArgumentException.class)
        public void 引数に_上記以外が渡された場合_IllegalArgumentExceptionが投げられる() {
            target = new RString("9");
            KyotakuJigyoshaRirekiPrintType.toValue(target);
            fail();
        }

    }
}
