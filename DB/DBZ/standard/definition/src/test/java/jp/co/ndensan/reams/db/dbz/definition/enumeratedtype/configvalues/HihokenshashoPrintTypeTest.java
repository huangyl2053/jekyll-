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
 * {@link jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.configvalues.HihokenshashoPrintType}のテストです。
 *
 * @author n8178 城間篤人
 */
@RunWith(Enclosed.class)
public class HihokenshashoPrintTypeTest {

    public static class toValue extends DbzTestBase {

        private RString target;

        @Test
        public void 引数に_01_が渡された場合_A4横が返る() {
            target = new RString("01");
            assertThat(HihokenshashoPrintType.toValue(target), is(HihokenshashoPrintType.A4横));
        }

        @Test
        public void 引数に_21_が渡された場合_B4横が返る() {
            target = new RString("21");
            assertThat(HihokenshashoPrintType.toValue(target), is(HihokenshashoPrintType.B4横));
        }

        @Test(expected = IllegalArgumentException.class)
        public void 引数に_上記以外が渡された場合_IllegalArgumentExceptionが投げられる() {
            target = new RString("99");
            HihokenshashoPrintType.toValue(target);
            fail();
        }

    }
}
