/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.enumeratedtype;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.testhelper.TestBase;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.is;

/**
 * ShikakuIdoKubunのテストです。
 *
 * @author N3327 三浦 凌
 */
@RunWith(Enclosed.class)
public class ShikakuIdoKubunTest extends TestBase {

    public static class ToValue extends TestBase {

        @Test
        public void toValueは_資格取得に対応するコードで_資格取得を返す() {
            RString code = ShikakuIdoKubun.資格取得.getCode();
            assertThat(ShikakuIdoKubun.toValue(code), is(ShikakuIdoKubun.資格取得));
        }

        @Test
        public void toValueは_資格喪失に対応するコードで_資格喪失を返す() {
            RString code = ShikakuIdoKubun.資格喪失.getCode();
            assertThat(ShikakuIdoKubun.toValue(code), is(ShikakuIdoKubun.資格喪失));
        }

        @Test
        public void toValueは_資格変更に対応するコードで_資格変更を返す() {
            RString code = ShikakuIdoKubun.資格変更.getCode();
            assertThat(ShikakuIdoKubun.toValue(code), is(ShikakuIdoKubun.資格変更));
        }

        @Test(expected = IllegalArgumentException.class)
        public void 対応するコードがないとき_IllegalArgumentExceptionを投げる() {
            RString code = new RString("存在しないコード");
            ShikakuIdoKubun.toValue(code);
        }
    }
}
