/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.enumeratedtype;

import jp.co.ndensan.reams.uz.uza.testhelper.TestBase;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.is;

/**
 * 調査員の状況を表す列挙型のテストクラスです。
 *
 * @author N8187 久保田 英男
 */
@RunWith(Enclosed.class)
public class ChosainJokyoTest extends TestBase {

    public static class toValue extends TestBase {

        @Test
        public void 引数がTRUEの時_toValueは_有効を返す() {
            assertThat(ChosainJokyo.toValue(true), is(ChosainJokyo.有効));
        }

        @Test
        public void 引数がFALSEの時_toValueは_無効を返す() {
            assertThat(ChosainJokyo.toValue(false), is(ChosainJokyo.無効));
        }
    }
}
