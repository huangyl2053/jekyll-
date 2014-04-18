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
 * 認知能力項目に関するテストです。
 *
 * @author n8178 城間篤人
 */
@RunWith(Enclosed.class)
public class NinchiNoryokuKomokuTest {

    public static class toValueのテスト extends DbeTestBase {

        @Test
        public void 引数に1を渡したとき_自立が返る() {
            assertThat(NinchiNoryokuKomoku.toValue(new RString("1")), is(NinchiNoryokuKomoku.自立));
        }

        @Test
        public void 引数に2を渡したとき_いくらか困難が返る() {
            assertThat(NinchiNoryokuKomoku.toValue(new RString("2")), is(NinchiNoryokuKomoku.いくらか困難));
        }

        @Test
        public void 引数に3を渡したとき_見守りが必要が返る() {
            assertThat(NinchiNoryokuKomoku.toValue(new RString("3")), is(NinchiNoryokuKomoku.見守りが必要));
        }

        @Test
        public void 引数に4を渡したとき_判断できないが返る() {
            assertThat(NinchiNoryokuKomoku.toValue(new RString("4")), is(NinchiNoryokuKomoku.判断できない));
        }

        @Test
        public void 引数に9を渡したとき_記載無しが返る() {
            assertThat(NinchiNoryokuKomoku.toValue(new RString("9")), is(NinchiNoryokuKomoku.記載無し));
        }

        @Test(expected = IllegalArgumentException.class)
        public void 引数に対応する項目の無い値を渡したとき_IllegalArgumentExceptionが発生する() {
            NinchiNoryokuKomoku.toValue(new RString("5"));
        }
    }
}
