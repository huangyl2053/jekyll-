/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.valueobject;

import jp.co.ndensan.reams.db.dbz.testhelper.DbeTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.junit.Before;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 *
 * @author n8178 城間篤人
 */
@RunWith(Enclosed.class)
public class NinteichosaRirekiNoTest {

    private static NinteichosaRirekiNo sut1;
    private static NinteichosaRirekiNo sut2;

    public static class equalsのテスト extends DbeTestBase {

        @Before
        public void setUp() {
            sut1 = new NinteichosaRirekiNo(12);
        }

        @Test
        public void nullを渡したとき_falseが返る() {
            assertThat(sut1.equals(null), is(false));
        }

        @Test
        public void 型の違うインスタンスが渡されたとき_falseが返る() {
            assertThat(sut1.equals(new RString("12")), is(false));
        }

        @Test
        public void 同じ型で_違う値を持つ場合_falseが返る() {
            sut2 = new NinteichosaRirekiNo(23);
            assertThat(sut1.equals(sut2), is(false));
        }

        @Test
        public void 同じ型で_同じ値を持つ場合_trueが返る() {
            sut2 = new NinteichosaRirekiNo(12);
            assertThat(sut1.equals(sut2), is(true));
        }
    }

    public static class hashCodeのテスト extends DbeTestBase {

        @Test
        public void 同じ値を持つ場合_hashCodeは同じ値になる() {
            sut1 = new NinteichosaRirekiNo(12);
            sut2 = new NinteichosaRirekiNo(12);
            assertThat(sut1.hashCode(), is(sut2.hashCode()));
        }
    }
}
