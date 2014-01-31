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
 * 取下げ区分のテストクラスです。
 *
 * @author n8178 城間篤人
 */
@RunWith(Enclosed.class)
public class TorisageKubunTest extends TestBase {

    public static class toValueのテスト {

        @Test
        public void 引数にコード_1を渡したとき_認定申請有効が返る() {
            assertThat(TorisageKubun.toValue(new RString("1")), is(TorisageKubun.認定申請有効));
        }

        @Test
        public void 引数にコード_2を渡したとき_認定申請有効が返る() {
            assertThat(TorisageKubun.toValue(new RString("2")), is(TorisageKubun.却下));
        }

        @Test
        public void 引数にコード_3を渡したとき_認定申請有効が返る() {
            assertThat(TorisageKubun.toValue(new RString("3")), is(TorisageKubun.取下げ));
        }

        @Test
        public void 引数にコード_4を渡したとき_認定申請有効が返る() {
            assertThat(TorisageKubun.toValue(new RString("4")), is(TorisageKubun.区分変更却下));
        }

        @Test
        public void 引数にコード_対応しない値を渡したとき_nullが返る() {
            assertThat(TorisageKubun.toValue(new RString("124")), nullValue());
        }
    }
}
