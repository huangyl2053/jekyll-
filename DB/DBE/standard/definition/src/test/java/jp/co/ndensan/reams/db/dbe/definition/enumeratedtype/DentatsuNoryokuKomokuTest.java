/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.enumeratedtype;

import jp.co.ndensan.reams.db.dbz.testhelper.DbeTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * 伝達能力項目に関するテストです。
 *
 * @author n8178 城間篤人
 */
@RunWith(Enclosed.class)
public class DentatsuNoryokuKomokuTest {

    public static class toValueのテスト extends DbeTestBase {

        @Test
        public void 引数に1を渡したとき_伝えられるが返る() {
            assertThat(DentatsuNoryokuKomoku.toValue(new RString("1")), is(DentatsuNoryokuKomoku.伝えられる));
        }

        @Test
        public void 引数に2を渡したとき_いくらか困難が返る() {
            assertThat(DentatsuNoryokuKomoku.toValue(new RString("2")), is(DentatsuNoryokuKomoku.いくらか困難));
        }

        @Test
        public void 引数に3を渡したとき_具体的要求に限られるが返る() {
            assertThat(DentatsuNoryokuKomoku.toValue(new RString("3")), is(DentatsuNoryokuKomoku.具体的要求に限られる));
        }

        @Test
        public void 引数に4を渡したとき_伝えられないが返る() {
            assertThat(DentatsuNoryokuKomoku.toValue(new RString("4")), is(DentatsuNoryokuKomoku.伝えられない));
        }

        @Test
        public void 引数に9を渡したとき_記載無しが返る() {
            assertThat(DentatsuNoryokuKomoku.toValue(new RString("9")), is(DentatsuNoryokuKomoku.記載無し));
        }

        @Test(expected = IllegalArgumentException.class)
        public void 引数に対応する項目の無い値を渡したとき_IllegalArgumentExceptionが発生する() {
            DentatsuNoryokuKomoku.toValue(new RString("5"));
        }
    }
}
