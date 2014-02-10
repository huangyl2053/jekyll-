/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.enumeratedtype;

import jp.co.ndensan.reams.uz.uza.testhelper.TestBase;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * 医療機関状況のテストです。
 *
 * @author n8178 城間篤人
 */
@RunWith(Enclosed.class)
public class IryoKikanJokyoTest extends TestBase {

    public static class toValueのテスト {

        @Test
        public void 引数にtrueを指定したとき_有効が返る() {
            assertThat(IryoKikanJokyo.toValue(true), is(IryoKikanJokyo.有効));
        }

        @Test
        public void 引数にfalseを指定したとき_無効が返る() {
            assertThat(IryoKikanJokyo.toValue(false), is(IryoKikanJokyo.無効));
        }
    }
}
