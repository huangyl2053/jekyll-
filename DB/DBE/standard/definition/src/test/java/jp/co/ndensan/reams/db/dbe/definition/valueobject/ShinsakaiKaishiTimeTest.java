/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.valueobject;

import jp.co.ndensan.reams.db.dbz.testhelper.DbeTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * 審査会開催時間のテストです。
 *
 * @author n8178 城間篤人
 */
@RunWith(Enclosed.class)
public class ShinsakaiKaishiTimeTest {

    private static ShinsakaiKaishiTime sut;
    private static ShinsakaiKaishiTime sut2;

    public static class compareToのテスト extends DbeTestBase {

        @Before
        public void setUp() {
            sut = new ShinsakaiKaishiTime(new TimeString("1234"));
        }

        @Test
        public void 自身より大きい値が渡された場合_0より小さい値が返る() {
            sut2 = new ShinsakaiKaishiTime(new TimeString("1235"));
            assertThat(sut.compareTo(sut2) < 0, is(true));
        }

        @Test
        public void 自身と同じ大きさの値が渡されたとき_0が返る() {
            sut2 = new ShinsakaiKaishiTime(new TimeString("1234"));
            assertThat(sut.compareTo(sut2) == 0, is(true));
        }

        @Test
        public void 自身より小さい値が渡された場合_0より大きい値が返る() {
            sut2 = new ShinsakaiKaishiTime(new TimeString("1233"));
            assertThat(0 < sut.compareTo(sut2), is(true));
        }
    }

    public static class equalsのテスト extends DbeTestBase {

        @Before
        public void setUp() {
            sut = new ShinsakaiKaishiTime(new TimeString("1234"));
        }

        @Test
        public void nullが渡された場合_falseが返る() {
            assertThat(sut.equals(null), is(false));
        }

        @Test
        public void 型の違うインスタンスが渡された場合_falseが返る() {
            assertThat(sut.equals(new RString("1234")), is(false));
        }

        @Test
        public void 値の違うインスタンスが渡されたとき_falseが返る() {
            sut2 = new ShinsakaiKaishiTime(new TimeString("1235"));
            assertThat(sut.equals(sut2), is(false));
        }

        @Test
        public void 同じ値を持つインスタンスが渡されたとき_trueが返る() {
            sut2 = new ShinsakaiKaishiTime(new TimeString("1234"));
            assertThat(sut.equals(sut2), is(true));
        }
    }

    public static class hashCodeのテスト extends DbeTestBase {

        @Before
        public void setUp() {
            sut = new ShinsakaiKaishiTime(new TimeString("1234"));
        }

        @Test
        public void 同じ値を持つ審査会開始時間クラスは_hashCodeも同値になる() {
            sut2 = new ShinsakaiKaishiTime(new TimeString("1234"));
            assertThat(sut.hashCode(), is(sut2.hashCode()));
        }
    }
}
