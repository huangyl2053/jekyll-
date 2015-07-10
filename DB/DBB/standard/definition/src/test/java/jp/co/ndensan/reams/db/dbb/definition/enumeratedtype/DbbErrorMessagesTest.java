/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.definition.enumeratedtype;

import jp.co.ndensan.reams.db.dbz.testhelper.DbbTestBase;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import static org.hamcrest.CoreMatchers.*;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * 介護賦課業務のエラーメッセージのテストです。
 *
 * @author n8178 城間篤人
 */
@RunWith(Enclosed.class)
public class DbbErrorMessagesTest extends DbbTestBase {

    public static class toValue extends DbbTestBase {

        @Test
        public void 引数に01を渡した場合_賦課更正が返る() {
            assertThat(DbbErrorMessages.toValue(new Code("01")), is(DbbErrorMessages.賦課更正));
        }

        @Test
        public void 引数に02を渡した場合_資格不整合が返る() {
            assertThat(DbbErrorMessages.toValue(new Code("02")), is(DbbErrorMessages.資格不整合));

        }

        @Test(expected = IllegalArgumentException.class)
        public void 上記以外のコードを渡した場合_例外が発生する() {
            DbbErrorMessages.toValue(new Code(""));
            fail();
        }
    }

}
