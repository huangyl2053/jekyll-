/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.valueobject;

import jp.co.ndensan.reams.db.dbz.testhelper.DbeTestBase;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.junit.Before;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * 審査会開催年月日のテストです。
 *
 * @author n8178 城間篤人
 */
@RunWith(Enclosed.class)
public class ShinsakaiKaisaiDateTest {

    private static ShinsakaiKaisaiDate sut;
    private static ShinsakaiKaisaiDate sut2;

    public static class コンストラクタのテスト extends DbeTestBase {

        @Test(expected = NullPointerException.class)
        public void 引数にnullが渡されたとき_NullPointerExceptionが発生する() {
            sut = new ShinsakaiKaisaiDate(null);
        }
    }

    public static class equalsのテスト extends DbeTestBase {

        @Before
        public void setUp() {
            sut = new ShinsakaiKaisaiDate(new FlexibleDate("19990101"));
        }

        @Test
        public void nullを渡した場合_falseが返る() {
            assertThat(sut.equals(null), is(false));
        }

        @Test
        public void 型の違うインスタンスを渡した場合_falseが返る() {
            assertThat(sut.equals(new RString("12")), is(false));
        }

        @Test
        public void 同値でない審査会開催番号を渡した場合_falseが返る() {
            sut2 = new ShinsakaiKaisaiDate(new FlexibleDate("20121231"));
            assertThat(sut.equals(sut2), is(false));
        }

        @Test
        public void 同値の審査会開催番号を渡した場合_trueが返る() {
            sut2 = new ShinsakaiKaisaiDate(new FlexibleDate("19990101"));
            assertThat(sut.equals(sut2), is(true));
        }
    }

    public static class hashCodeのテスト extends DbeTestBase {

        @Before
        public void setUp() {
            sut = new ShinsakaiKaisaiDate(new FlexibleDate("19990101"));
        }

        @Test
        public void 同値の審査会開催番号は_hashCodeも同値になる() {
            sut2 = new ShinsakaiKaisaiDate(new FlexibleDate("19990101"));
            assertThat(sut.hashCode(), is(sut2.hashCode()));
        }
    }

    public static class compareToのテスト extends DbeTestBase {

        @Before
        public void setUp() {
            sut = new ShinsakaiKaisaiDate(new FlexibleDate("19990101"));
        }

        @Test
        public void 比較対象と比べて小さい場合_0より小さい値が返る() {
            sut2 = new ShinsakaiKaisaiDate(new FlexibleDate("20121231"));
            assertThat(sut.compareTo(sut2) < 0, is(true));
        }

        @Test
        public void 比較対象と同値である場合_0より小さい値が返る() {
            sut2 = new ShinsakaiKaisaiDate(new FlexibleDate("19990101"));
            assertThat(sut.compareTo(sut2) == 0, is(true));
        }

        @Test
        public void 比較対象と比べて大きい場合_0より大きな値が返る() {
            sut2 = new ShinsakaiKaisaiDate(new FlexibleDate("19800623"));
            assertThat(0 < sut.compareTo(sut2), is(true));
        }
    }
}
