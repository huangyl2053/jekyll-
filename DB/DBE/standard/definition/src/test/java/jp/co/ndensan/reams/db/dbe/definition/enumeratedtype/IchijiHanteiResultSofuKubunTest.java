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
 * 一次判定送付区分のテストです。
 *
 * @author n8178 城間篤人
 */
@RunWith(Enclosed.class)
public class IchijiHanteiResultSofuKubunTest {

    public static class toValueのテスト extends DbeTestBase {

        @Test
        public void 引数に1を渡した場合_送付済みが返る() {
            assertThat(IchijiHanteiResultSofuKubun.toValue(new RString("1")), is(IchijiHanteiResultSofuKubun.送付済み));
        }

        @Test
        public void 引数に0を渡した場合_未送付が返る() {
            assertThat(IchijiHanteiResultSofuKubun.toValue(new RString("0")), is(IchijiHanteiResultSofuKubun.未送付));
        }

        @Test(expected = IllegalArgumentException.class)
        public void 対応しない値を渡した場合_IllegalArgumentExceptionが返る() {
            IchijiHanteiResultSofuKubun.toValue(new RString("2"));
        }
    }
}
