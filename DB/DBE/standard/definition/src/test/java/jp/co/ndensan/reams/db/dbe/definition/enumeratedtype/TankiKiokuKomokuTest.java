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
 * 短期記憶項目に関するテストです。
 *
 * @author n8178 城間篤人
 */
@RunWith(Enclosed.class)
public class TankiKiokuKomokuTest {

    public static class toValueのテスト extends DbeTestBase {

        @Test
        public void 引数に1を渡したとき_問題無しが返る() {
            assertThat(TankiKiokuKomoku.toValue(new RString("1")), is(TankiKiokuKomoku.問題無し));
        }

        @Test
        public void 引数に2を渡したとき_問題ありが返る() {
            assertThat(TankiKiokuKomoku.toValue(new RString("2")), is(TankiKiokuKomoku.問題あり));
        }

        @Test
        public void 引数に9を渡したとき_記載無しが返る() {
            assertThat(TankiKiokuKomoku.toValue(new RString("9")), is(TankiKiokuKomoku.記載無し));
        }

        @Test(expected = IllegalArgumentException.class)
        public void 引数に対応する項目の無い値を渡したとき_IllegalArgumentExceptionが発生する() {
            TankiKiokuKomoku.toValue(new RString("3"));
        }
    }
}
