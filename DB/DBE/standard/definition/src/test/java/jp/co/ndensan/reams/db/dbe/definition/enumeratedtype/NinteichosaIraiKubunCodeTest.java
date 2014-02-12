/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.enumeratedtype;

import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.testhelper.TestBase;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * 認定調査依頼区分コードを表す列挙型のテストです。
 *
 * @author n8178 城間篤人
 */
@RunWith(Enclosed.class)
public class NinteichosaIraiKubunCodeTest extends TestBase {

    public static class toValueのテスト {

        private Code 区分コード;

        @Test
        public void 引数に0が渡されたとき_初回が返る() {
            区分コード = new Code(new RString("0"));
            assertThat(NinteichosaIraiKubunCode.toValue(区分コード), is(NinteichosaIraiKubunCode.初回));
        }

        @Test
        public void 引数に1が渡されたとき_再依頼が返る() {
            区分コード = new Code(new RString("1"));
            assertThat(NinteichosaIraiKubunCode.toValue(区分コード), is(NinteichosaIraiKubunCode.再依頼));
        }

        @Test
        public void 引数に2が渡されたとき_再調査が返る() {
            区分コード = new Code(new RString("2"));
            assertThat(NinteichosaIraiKubunCode.toValue(区分コード), is(NinteichosaIraiKubunCode.再調査));
        }

        @Test(expected = IllegalArgumentException.class)
        public void 引数に対応しない値が渡されたとき_例外が発生する() {
            区分コード = new Code(new RString("4"));
            assertThat(NinteichosaIraiKubunCode.toValue(区分コード), is(NinteichosaIraiKubunCode.初回));
        }
    }
}
