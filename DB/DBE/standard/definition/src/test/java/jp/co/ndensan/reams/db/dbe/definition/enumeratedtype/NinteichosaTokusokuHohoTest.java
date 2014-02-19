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
 * 認定調査督促方法を表すクラスのテストです。
 *
 * @author n8178 城間篤人
 */
@RunWith(Enclosed.class)
public class NinteichosaTokusokuHohoTest extends TestBase {

    public static class toValueのテスト {

        private RString 督促方法コード;

        @Test
        public void 引数に0が渡されたとき_督促状郵送が返る() {
            督促方法コード = new RString("0");
            assertThat(NinteichosaTokusokuHoho.toValue(督促方法コード), is(NinteichosaTokusokuHoho.督促状郵送));
        }

        @Test
        public void 引数に1が渡されたとき_督促状ＦＡＸが返る() {
            督促方法コード = new RString("1");
            assertThat(NinteichosaTokusokuHoho.toValue(督促方法コード), is(NinteichosaTokusokuHoho.督促状ＦＡＸ));
        }

        @Test
        public void 引数に2が渡されたとき_電話が返る() {
            督促方法コード = new RString("2");
            assertThat(NinteichosaTokusokuHoho.toValue(督促方法コード), is(NinteichosaTokusokuHoho.電話));
        }

        @Test
        public void 引数に3が渡されたとき_その他が返る() {
            督促方法コード = new RString("3");
            assertThat(NinteichosaTokusokuHoho.toValue(督促方法コード), is(NinteichosaTokusokuHoho.その他));
        }

        @Test(expected = IllegalArgumentException.class)
        public void 引数に対応しない値が渡されたとき_例外が発生する() {
            督促方法コード = new RString("4");
            NinteichosaTokusokuHoho.toValue(督促方法コード);
        }
    }
}
