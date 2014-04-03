/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.valueobject;

import jp.co.ndensan.reams.db.dbz.testhelper.DbeTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RTime;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.junit.Before;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * 時間を表す文字列のテストです。
 *
 * @author n8178 城間篤人
 */
@RunWith(Enclosed.class)
public class TimeStringTest {

    private static TimeString sut;

    public static class コンストラクタ_引数にRStringを渡した場合のテスト extends DbeTestBase {

        @Test(expected = NullPointerException.class)
        public void nullを渡したとき_NullPointerExceptionが発生する() {
            RString str = null;
            sut = new TimeString(str);
        }

        @Test(expected = IllegalArgumentException.class)
        public void 文字列の長さが4未満であるとき_IllegalArgumentExceptionが発生する() {
            sut = new TimeString(new RString("123"));
        }

        @Test(expected = IllegalArgumentException.class)
        public void 文字列の長さが4より大きいとき_IllegalArgumentExceptionが発生する() {
            sut = new TimeString(new RString("12345"));
        }

        @Test(expected = IllegalArgumentException.class)
        public void 文字列に数値以外の文字が渡されたとき_IllegalArgumentExceptionが発生する() {
            sut = new TimeString(new RString("1a50"));
        }

        @Test(expected = IllegalArgumentException.class)
        public void 時間を表す文字列が_00から23の間に収まっていないとき_IllegalArgumentExceptionが発生する() {
            sut = new TimeString(new RString("2445"));
        }

        @Test(expected = IllegalArgumentException.class)
        public void 分を表す文字列が_00から59の間に収まっていないとき_IllegalArgumentExceptionが発生する() {
            sut = new TimeString(new RString("2360"));
        }

        @Test
        public void 時間に変換できる文字列が渡されたとき_インスタンスが生成される() {
            sut = new TimeString(new RString("1230"));
            assertThat(sut, is(instanceOf(TimeString.class)));
        }
    }

    public static class コンストラクタ_引数にStringを渡した場合のテスト extends DbeTestBase {

        @Test(expected = NullPointerException.class)
        public void nullを渡したとき_NullPointerExceptionが発生する() {
            String str = null;
            sut = new TimeString(str);
        }
    }

    public static class equalsのテスト extends DbeTestBase {

        private TimeString sut2;

        @Before
        public void setUp() {
            sut = new TimeString("1230");
        }

        @Test
        public void nullを渡したとき_falseが返る() {
            assertThat(sut.equals(null), is(false));
        }

        @Test
        public void 型の違う値を渡したとき_falseが返る() {
            assertThat(sut.equals(new RString("1230")), is(false));
        }

        @Test
        public void 値の違うインスタンスを渡したとき_falseが返る() {
            sut2 = new TimeString("0930");
            assertThat(sut.equals(sut2), is(false));
        }

        @Test
        public void 値が同値のインスタンスを渡したとき_trueが返る() {
            sut2 = new TimeString("1230");
            assertThat(sut.equals(sut2), is(true));
        }
    }

    public static class hashCodeのテスト extends DbeTestBase {

        @Test
        public void 同じ文字列を持つインスタンスのhashCodeを比較した場合_同値になる() {
            sut = new TimeString("1230");
            TimeString sut2 = new TimeString("1230");
            assertThat(sut.hashCode(), is(sut2.hashCode()));
        }
    }

    public static class compareToのテスト extends DbeTestBase {

        private TimeString sut2;

        @Before
        public void setUp() {
            sut = new TimeString("1230");
        }

        @Test
        public void 時刻を表す文字列1230を持つインスタンスを_0930を持つインスタンスと比較した場合_0より大きい値が返る() {
            sut2 = new TimeString("0930");
            assertThat(0 < sut.compareTo(sut2), is(true));
        }

        @Test
        public void 時刻を表す文字列1230を持つインスタンスを_1750を持つインスタンスと比較した場合_0より小さい値が返る() {
            sut2 = new TimeString("1750");
            assertThat(sut.compareTo(sut2) < 0, is(true));
        }

        @Test
        public void 時刻を表す文字列1230を持つインスタンスを_同値1230を持つインスタンスと比較した場合_0が返る() {
            sut2 = new TimeString("1230");
            assertThat(sut.compareTo(sut2) == 0, is(true));
        }
    }

    public static class toRTimeのテスト extends DbeTestBase {

        @Test
        public void 同じ時間を示す値を持つ場合_RTime型の時間と_TimeStringからtoRTimeで受け取った時間が_同一になる() {
            sut = new TimeString("1234");
            RTime time = RTime.of(12, 34);
            assertThat(sut.toRTime(), is(time));
        }
    }
}
