/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.divcontroller.util;

import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link jp.co.ndensan.reams.db.dbz.divcontroller.util.KaigoRowState}のテストです。
 *
 * @author n8178 城間篤人
 */
@RunWith(Enclosed.class)
public class KaigoRowStateTest {

    private static KaigoRowState sut;

    public static class toValue extends DbzTestBase {

        @Test
        public void 引数に_追加_が渡された場合_返却される値は_追加_となる() {
            sut = KaigoRowState.toValue(new RString("追加"));
            assertThat(sut, is(KaigoRowState.追加));
        }

        @Test
        public void 引数に_修正_が渡された場合_返却される値は_修正_となる() {
            sut = KaigoRowState.toValue(new RString("修正"));
            assertThat(sut, is(KaigoRowState.修正));
        }

        @Test
        public void 引数に_削除_が渡された場合_返却される値は_削除_となる() {
            sut = KaigoRowState.toValue(new RString("削除"));
            assertThat(sut, is(KaigoRowState.削除));
        }

        @Test
        public void 引数に空の文字列が渡された場合_返却される値は_空白_となる() {
            sut = KaigoRowState.toValue(new RString(""));
            assertThat(sut, is(KaigoRowState.空白));
        }

        @Test(expected = IllegalArgumentException.class)
        public void 対応する状態の存在しない文字列が渡された場合_IllegalArgumentExceptionが発生する() {
            sut = KaigoRowState.toValue(new RString("ヤシガニ"));
            fail();
        }
    }

}
