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
 * {@link jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.configvalues.MojigireControlType}のテストです。
 *
 * @author n8178 城間篤人
 */
@RunWith(Enclosed.class)
public class MojigireControlTypeTest {

    public static class toValue extends DbzTestBase {

        private RString target;

        @Test
        public void 引数に_0_が渡された場合_印字しないが返る() {
            target = new RString("0");
            assertThat(MojigireControlType.toValue(target), is(MojigireControlType.印字しない));
        }

        @Test
        public void 引数に_1_が渡された場合_印字可能範囲まで印字するが返る() {
            target = new RString("1");
            assertThat(MojigireControlType.toValue(target), is(MojigireControlType.印字可能範囲まで印字する));
        }

        @Test
        public void 引数に_2_が渡された場合_オーバーフロー文字を印字するが返る() {
            target = new RString("2");
            assertThat(MojigireControlType.toValue(target), is(MojigireControlType.オーバーフロー文字を印字する));
        }

        @Test(expected = IllegalArgumentException.class)
        public void 引数に_上記以外が渡された場合_IllegalArgumentExceptionが投げられる() {
            target = new RString("9");
            YukoKigenPrintType.toValue(target);
            fail();
        }

    }
}
