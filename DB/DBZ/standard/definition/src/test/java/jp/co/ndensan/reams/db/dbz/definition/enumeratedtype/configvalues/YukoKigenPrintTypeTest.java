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
 * {@link jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.configvalues.YukoKigenPrintType}のテストです。
 *
 * @author n8178 城間篤人
 */
@RunWith(Enclosed.class)
public class YukoKigenPrintTypeTest {

    public static class toValue extends DbzTestBase {

        private RString target;

        @Test
        public void 引数に_1_が渡された場合_合併日から有効期限が返る() {
            target = new RString("1");
            assertThat(YukoKigenPrintType.toValue(target), is(YukoKigenPrintType.合併日から有効期限));
        }

        @Test
        public void 引数に_2_が渡された場合_有効期限のみが返る() {
            target = new RString("2");
            assertThat(YukoKigenPrintType.toValue(target), is(YukoKigenPrintType.有効期限のみ));
        }

        @Test(expected = IllegalArgumentException.class)
        public void 引数に_上記以外が渡された場合_IllegalArgumentExceptionが投げられる() {
            target = new RString("9");
            YukoKigenPrintType.toValue(target);
            fail();
        }

    }
}
