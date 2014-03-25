/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.valueobject;

import jp.co.ndensan.reams.db.dbz.testhelper.DbeTestBase;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.junit.Before;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * 合議体有効期間開始年月日のテストです。
 *
 * @author n8178 城間篤人
 */
@RunWith(Enclosed.class)
public class GogitaiYukoKikanKaishiYMDTest {

    private static GogitaiYukoKikanKaishiYMD sut;
    private static GogitaiYukoKikanKaishiYMD sut2;

    public static class コンストラクタ_引数にFlexibleDateが渡されたときのテスト extends DbeTestBase {

        @Test(expected = NullPointerException.class)
        public void 引数にnullが渡されたとき_NullPointerExceptionが発生する() {
            FlexibleDate date = null;
            sut = new GogitaiYukoKikanKaishiYMD(date);
        }
    }

    public static class コンストラクタ_引数にRStringが渡されたときのテスト extends DbeTestBase {

        @Test(expected = NullPointerException.class)
        public void 引数にnullが渡されたとき_NullPointerExceptionが発生する() {
            RString date = null;
            sut = new GogitaiYukoKikanKaishiYMD(date);
        }

        @Test(expected = IllegalArgumentException.class)
        public void 引数にyyyyMMddの形式に合っていない文字列が渡されたとき_IllegalArgumentExceptionが発生する() {
            RString date = new RString("123456789");
            sut = new GogitaiYukoKikanKaishiYMD(date);
        }

        @Test
        public void 引数にyyyyMMddの形式に会う文字列が渡されたとき_インスタンスが生成される() {
            RString date = new RString("12345678");
            sut = new GogitaiYukoKikanKaishiYMD(date);
            assertThat(sut, is(instanceOf(GogitaiYukoKikanKaishiYMD.class)));
        }
    }

    public static class コンストラクタ_引数にStringが渡されたときのテスト extends DbeTestBase {

        @Test(expected = NullPointerException.class)
        public void 引数にnullが渡されたとき_NullPointerExceptionが発生する() {
            String date = null;
            sut = new GogitaiYukoKikanKaishiYMD(date);
        }

        @Test(expected = IllegalArgumentException.class)
        public void 引数にyyyyMMddの形式に合っていない文字列が渡されたとき_IllegalArgumentExceptionが発生する() {
            String date = "123456789";
            sut = new GogitaiYukoKikanKaishiYMD(date);
        }

        @Test
        public void 引数にyyyyMMddの形式に会う文字列が渡されたとき_インスタンスが生成される() {
            String date = "12345678";
            sut = new GogitaiYukoKikanKaishiYMD(date);
            assertThat(sut, is(instanceOf(GogitaiYukoKikanKaishiYMD.class)));
        }
    }

    public static class コンストラクタ_引数に年月日を表す数値が渡されたときのテスト extends DbeTestBase {

        @Test(expected = IllegalArgumentException.class)
        public void 年を表す数字に4桁以上の値が渡されたとき_IllegalArgumentExceptionが発生する() {
            sut = new GogitaiYukoKikanKaishiYMD(12345, 67, 89);
        }

        @Test(expected = IllegalArgumentException.class)
        public void 月を表す数字に2桁以上の値が渡されたとき_IllegalArgumentExceptionが発生する() {
            sut = new GogitaiYukoKikanKaishiYMD(1234, 567, 89);
        }

        @Test(expected = IllegalArgumentException.class)
        public void 日付を表す数字に2桁以上の値が渡されたとき_IllegalArgumentExceptionが発生する() {
            sut = new GogitaiYukoKikanKaishiYMD(1234, 56, 789);
        }

        @Test(expected = IllegalArgumentException.class)
        public void 年を表す数字にマイナスの値が渡されたとき_IllegalArgumentExceptionが発生する() {
            sut = new GogitaiYukoKikanKaishiYMD(-2345, 67, 89);
        }

        @Test(expected = IllegalArgumentException.class)
        public void 月を表す数字にマイナスの値が渡されたとき_IllegalArgumentExceptionが発生する() {
            sut = new GogitaiYukoKikanKaishiYMD(1234, -67, 89);
        }

        @Test(expected = IllegalArgumentException.class)
        public void 日付を表す数字にマイナスの値が渡されたとき_IllegalArgumentExceptionが発生する() {
            sut = new GogitaiYukoKikanKaishiYMD(1234, 56, -89);
        }

        @Test
        public void 引数から渡された数値が日付と判断できたとき_インスタンスが生成される() {
            sut = new GogitaiYukoKikanKaishiYMD(1234, 56, 78);
            assertThat(sut, is(instanceOf(GogitaiYukoKikanKaishiYMD.class)));
        }
    }

    public static class equalsのテスト extends DbeTestBase {

        @Before
        public void setUp() {
            sut = new GogitaiYukoKikanKaishiYMD(new FlexibleDate("19990101"));
        }

        @Test
        public void 引数にnullが渡されたとき_falseを返す() {
            assertThat(sut.equals(null), is(false));
        }

        @Test
        public void 引数に型の違うクラスが渡されたとき_falseを返す() {
            assertThat(sut.equals(new RDate("19990101")), is(false));
        }

        @Test
        public void 引数に違う値の日付が渡されたとき_falseを返す() {
            sut2 = new GogitaiYukoKikanKaishiYMD(new FlexibleDate("19990102"));
            assertThat(sut.equals(sut2), is(false));
        }

        @Test
        public void 引数に同じ値の日付が渡されたとき_trueを返す() {
            sut2 = new GogitaiYukoKikanKaishiYMD(new FlexibleDate("19990101"));
            assertThat(sut.equals(sut2), is(true));
        }
    }

    public static class hashCodeのテスト extends DbeTestBase {

        @Before
        public void setUp() {
            sut = new GogitaiYukoKikanKaishiYMD(new FlexibleDate("19990101"));
            sut2 = new GogitaiYukoKikanKaishiYMD(new FlexibleDate("19990101"));
        }

        @Test
        public void 同じ日付を持つ開始年月日のhashCodeは_同値になる() {
            assertThat(sut.hashCode(), is(sut2.hashCode()));
        }
    }

    public static class compareToのテスト extends DbeTestBase {

        @Before
        public void setUp() {
            sut = new GogitaiYukoKikanKaishiYMD(new FlexibleDate("19990101"));
        }

        @Test
        public void 日付19990101を持つ開始年月日を_日付20010101と比較すると_0より小さい値が返る() {
            sut2 = new GogitaiYukoKikanKaishiYMD(new FlexibleDate("20010101"));
            assertThat(sut.compareTo(sut2) < 0, is(true));
        }

        @Test
        public void 日付19990101を持つ開始年月日を_日付19880101と比較すると_0より大きい値が返る() {
            sut2 = new GogitaiYukoKikanKaishiYMD(new FlexibleDate("19880101"));
            assertThat(0 < sut.compareTo(sut2), is(true));
        }

        @Test
        public void 日付19990101を持つ開始年月日を_同値の日付19990101と比較すると_0が返る() {
            sut2 = new GogitaiYukoKikanKaishiYMD(new FlexibleDate("19990101"));
            assertThat(sut.compareTo(sut2) == 0, is(true));
        }
    }
}
