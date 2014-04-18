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
 * 一次判定警告有無のテストです。
 *
 * @author n8178 城間篤人
 */
@RunWith(Enclosed.class)
public class IchijiHanteiKeikokuUmuTest {

    public static class is警告有りのテスト extends DbeTestBase {

        @Test
        public void 警告有りの場合_trueが返る() {
            assertThat(IchijiHanteiKeikokuUmu.警告有り.is警告有り(), is(true));
        }

        @Test
        public void 警告無しの場合_falseが返る() {
            assertThat(IchijiHanteiKeikokuUmu.警告無し.is警告有り(), is(false));
        }
    }

    public static class toValueのテスト extends DbeTestBase {

        @Test
        public void 引数に1を渡した場合_警告有りが返る() {
            assertThat(IchijiHanteiKeikokuUmu.toValue(new RString("1")), is(IchijiHanteiKeikokuUmu.警告有り));
        }

        @Test
        public void 引数に0を渡した場合_警告無しが返る() {
            assertThat(IchijiHanteiKeikokuUmu.toValue(new RString("0")), is(IchijiHanteiKeikokuUmu.警告無し));
        }

        @Test(expected = IllegalArgumentException.class)
        public void 上記以外を引数に渡した場合_IllegalArgumentExceptionが発生する() {
            IchijiHanteiKeikokuUmu.toValue(new RString("2"));
        }
    }
}
