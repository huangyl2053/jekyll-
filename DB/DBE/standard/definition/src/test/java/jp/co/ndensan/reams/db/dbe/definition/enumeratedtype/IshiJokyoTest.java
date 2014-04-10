/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.enumeratedtype;

import jp.co.ndensan.reams.db.dbz.testhelper.DbeTestBase;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * 医師の状況を表す列挙型のテストクラスです。
 *
 * @author N8156 宮本 康
 */
@RunWith(Enclosed.class)
public class IshiJokyoTest extends DbeTestBase {

    public static class toValue extends DbeTestBase {

        @Test
        public void 引数がTRUEの時_toValueは_有効を返す() {
            assertThat(IshiJokyo.toValue(true), is(IshiJokyo.有効));
        }

        @Test
        public void 引数がFALSEの時_toValueは_無効を返す() {
            assertThat(IshiJokyo.toValue(false), is(IshiJokyo.無効));
        }
    }
}
