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
 *
 * @author n8178 城間篤人
 */
@RunWith(Enclosed.class)
public class ShinsainYusoKubunTest {

    public static class toValueのテスト extends DbeTestBase {

        @Test
        public void 引数に1を渡したとき_自宅を示す項目が返る() {
            assertThat(ShinsainYusoKubun.toValue(new RString("1")), is(ShinsainYusoKubun.自宅));
        }

        @Test
        public void 引数に2を渡したとき_所属機関を示す項目が返る() {
            assertThat(ShinsainYusoKubun.toValue(new RString("2")), is(ShinsainYusoKubun.所属機関));
        }

        @Test(expected = IllegalArgumentException.class)
        public void 対応する項目が存在しないとき_例外が発生する() {
            ShinsainYusoKubun.toValue(new RString("3"));

        }
    }
}
