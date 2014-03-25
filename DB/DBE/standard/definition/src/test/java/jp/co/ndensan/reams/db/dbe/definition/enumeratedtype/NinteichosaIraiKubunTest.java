/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.enumeratedtype;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.testhelper.TestBase;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * 認定調査依頼区分を表す列挙型のテストです。
 *
 * @author n8178 城間篤人
 */
@RunWith(Enclosed.class)
public class NinteichosaIraiKubunTest extends TestBase {

    public static class toValueのテスト {

        private RString 区分コード;

        @Test
        public void 引数に0が渡されたとき_初回が返る() {
            区分コード = new RString("0");
            assertThat(NinteichosaIraiKubun.toValue(区分コード), is(NinteichosaIraiKubun.初回));
        }

        @Test
        public void 引数に1が渡されたとき_再依頼が返る() {
            区分コード = new RString("1");
            assertThat(NinteichosaIraiKubun.toValue(区分コード), is(NinteichosaIraiKubun.再依頼));
        }

        @Test
        public void 引数に2が渡されたとき_再調査が返る() {
            区分コード = new RString("2");
            assertThat(NinteichosaIraiKubun.toValue(区分コード), is(NinteichosaIraiKubun.再調査));
        }

        @Test(expected = IllegalArgumentException.class)
        public void 引数に対応しない値が渡されたとき_例外が発生する() {
            区分コード = new RString("4");
            NinteichosaIraiKubun.toValue(区分コード);
        }
    }
}
