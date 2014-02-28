/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.enumeratedtype;

import jp.co.ndensan.reams.db.dbz.testhelper.DbeTestBase;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * 審査会委員状況のテストです。
 *
 * @author n8178 城間篤人
 */
@RunWith(Enclosed.class)
public class ShinsakaiIinJokyoTest {

    public static class toValueのテスト extends DbeTestBase {

        @Test
        public void 引数にtrueを指定したとき_有効を返す() {
            ShinsakaiIinJokyo sut = ShinsakaiIinJokyo.toValue(true);
            assertThat(sut, is(ShinsakaiIinJokyo.有効));
        }

        @Test
        public void 引数にfalseを指定したとき_無効を返す() {
            ShinsakaiIinJokyo sut = ShinsakaiIinJokyo.toValue(false);
            assertThat(sut, is(ShinsakaiIinJokyo.無効));
        }
    }
}
