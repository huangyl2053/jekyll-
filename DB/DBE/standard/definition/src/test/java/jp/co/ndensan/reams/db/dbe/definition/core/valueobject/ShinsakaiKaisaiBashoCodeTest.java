/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.core.valueobject;

import jp.co.ndensan.reams.db.dbe.definition.core.valueobject.ShinsakaiKaisaiBashoCode;
import jp.co.ndensan.reams.db.dbz.testhelper.DbeTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.junit.Before;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * 審査会開催場所コードのテストクラスです。
 *
 * @author n8178 城間篤人
 */
@RunWith(Enclosed.class)
public class ShinsakaiKaisaiBashoCodeTest {

    private static ShinsakaiKaisaiBashoCode sut1;
    private static ShinsakaiKaisaiBashoCode sut2;

    public static class hashCodeのテスト extends DbeTestBase {

        @Test
        public void 同一の合議体名称を持つとき_ハッシュコードが同値になる() {
            sut1 = createShinsakaiKaisaiBashoCode("A001");
            sut2 = createShinsakaiKaisaiBashoCode("A001");
            assertThat(sut1.hashCode(), is(sut2.hashCode()));
        }
    }

    public static class equalsのテスト extends DbeTestBase {

        @Before
        public void setUp() {
            sut1 = createShinsakaiKaisaiBashoCode("A001");
        }

        @Test
        public void 引数にnullを渡したとき_falseが返る() {
            assertThat(sut1.equals(null), is(false));
        }

        @Test
        public void 引数に_ShinsakaiKaisaiBashoCode型以外のものを渡したとき_falseが返る() {
            assertThat(sut1.equals(new RString("A001")), is(false));
        }

        @Test
        public void 引数に_同値でない値を持っている合議体名称を渡したとき_falseが返る() {
            sut2 = createShinsakaiKaisaiBashoCode("B001");
            assertThat(sut1.equals(sut2), is(false));
        }

        @Test
        public void 引数に_同値を持つ合議体名称を渡したとき_trueが返る() {
            sut2 = createShinsakaiKaisaiBashoCode("A001");
            assertThat(sut1.equals(sut2), is(true));
        }
    }

    private static ShinsakaiKaisaiBashoCode createShinsakaiKaisaiBashoCode(String str) {
        return new ShinsakaiKaisaiBashoCode(new RString(str));
    }
}
