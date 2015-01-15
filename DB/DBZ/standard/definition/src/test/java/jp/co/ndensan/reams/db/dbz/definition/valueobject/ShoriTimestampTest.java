/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.valueobject;

import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import static org.hamcrest.CoreMatchers.is;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@code ShoriTimestamp}のテストです。
 *
 * @author N3327 三浦 凌
 */
@RunWith(Enclosed.class)
public class ShoriTimestampTest {

    public ShoriTimestampTest() {
    }

    private static final YMDHMS VALUE1;

    static {
        VALUE1 = new YMDHMS("20121101021012");
    }

    public static class Constructor_RDateTime extends DbzTestBase {

        private RDateTime rDateTime;
        private ShoriTimestamp sut;

        @Before
        public void setUp() {
            rDateTime = RDateTime.now();
            sut = new ShoriTimestamp(rDateTime);
        }

        @Test
        public void RDateTimeを引数にしたコンストラクタは_指定のRDateTimeをYMDHMSへ変換して保持する_getDateが一致() {
            assertThat(sut.value().getRDateTime().getDate(), is(rDateTime.getDate()));
        }

        @Test
        public void RDateTimeを引数にしたコンストラクタは_指定のRDateTimeをYMDHMSへ変換して保持する_getHourが一致() {
            assertThat(sut.value().getRDateTime().getHour(), is(rDateTime.getHour()));
        }

        @Test
        public void RDateTimeを引数にしたコンストラクタは_指定のRDateTimeをYMDHMSへ変換して保持する_getMinuteが一致() {
            assertThat(sut.value().getRDateTime().getMinute(), is(rDateTime.getMinute()));
        }

        @Test
        public void RDateTimeを引数にしたコンストラクタは_指定のRDateTimeをYMDHMSへ変換して保持する_getSecondが一致() {
            assertThat(sut.value().getRDateTime().getSecond(), is(rDateTime.getSecond()));
        }
    }

    public static class compareTo extends DbzTestBase {

        private YMDHMS value;
        private ShoriTimestamp sut;

        @Before
        public void setUp() {
            value = VALUE1;
            sut = new ShoriTimestamp(value);
        }

        @Test
        public void compareToは_引数のShoriTimestampが保持する値の方が前の時_0より大きい値を返す() {
            ShoriTimestamp other = new ShoriTimestamp(value.minusDay(1));
            assertThat(0 < sut.compareTo(other), is(true));
        }

        @Test
        public void compareToは_引数のShoriTimestampが同じ値を保持する時_0を返す() {
            ShoriTimestamp other = new ShoriTimestamp(value);
            assertThat(sut.compareTo(other) == 0, is(true));
        }

        @Test
        public void compareToは_引数のShoriTimestampが保持する値の方が後の時_0より小さい値を返す() {
            ShoriTimestamp other = new ShoriTimestamp(value.plusDay(1));
            assertThat(sut.compareTo(other) < 0, is(true));
        }
    }

    public static class equals extends DbzTestBase {

        private YMDHMS value;
        private ShoriTimestamp sut;

        @Before
        public void setUp() {
            value = VALUE1;
            sut = new ShoriTimestamp(value);
        }

        @Test
        public void equalsは_nullを受け取った時_falseを返す() {
            assertThat(sut.equals(null), is(false));
        }

        @Test
        public void equalsは_異なる型のインスタンスを受け取った時_falseを返す() {
            assertThat(sut.equals(new YMDHMS("20121101021012")), is(false));
        }

        @Test
        public void equalsは_同じ値を保持するインスタンスを受け取った時_trueを返す() {
            ShoriTimestamp other = new ShoriTimestamp(value);
            assertThat(sut.equals(other), is(true));
        }
    }

    public static class hashCode extends DbzTestBase {

        private YMDHMS value;
        private ShoriTimestamp sut;

        @Before
        public void setUp() {
            value = VALUE1;
            sut = new ShoriTimestamp(value);
        }

        @Test
        public void hashCodeは_同じ値を保持するインスタンス同士では_同じ値を返す() {
            ShoriTimestamp other = new ShoriTimestamp(value);
            assertThat(sut.hashCode(), is(other.hashCode()));
        }
    }

    public static class columnValueAndValue extends DbzTestBase {

        private YMDHMS value;
        private ShoriTimestamp sut;

        @Before
        public void setUp() {
            value = VALUE1;
            sut = new ShoriTimestamp(value);
        }

        @Test
        public void valueは_保持するYMDHMSを返す() {
            assertThat(sut.value(), is(value));
        }

        @Test
        public void getColumnValueは_保持するYMDHMSを返す() {
            assertThat(sut.getColumnValue(), is(value));
        }
    }

    public static class IDayDealable関係 extends DbzTestBase {

        private YMDHMS value;
        private ShoriTimestamp sut;

        @Before
        public void setUp() {
            value = VALUE1;
            sut = new ShoriTimestamp(value);
        }

        @Test
        public void getDayValueは_保持するYMDHMSと同じ値を返す() {
            assertThat(sut.getDayValue(), is(value.getDayValue()));
        }

        @Test
        public void getDayOfWeekは_保持するYMDHMSと同じ値を返す() {
            assertThat(sut.getDayOfWeek(), is(value.getDayOfWeek()));
        }

        @Test
        public void getBetweenDaysは_minusDayにより生成したインスタンスが渡されたとき_minusDayの引数と同じ値を返す() {
            int day = 1;
            ShoriTimestamp other = new ShoriTimestamp(value.minusDay(day));
            assertThat(sut.getBetweenDays(other), is(day));
        }

        @Test
        public void plusDayで生成されるインスタンスと_保持するYMDHMSのplusDayに同じ値を渡して生成されたYMDHMSを保持するインスタンス同士は_equalsでtrueを返す() {
            int day = 1;
            ShoriTimestamp other = new ShoriTimestamp(value.plusDay(day));
            assertThat(sut.plusDay(day).equals(other), is(true));
        }

        @Test
        public void minusDayで生成されるインスタンスと_保持するYMDHMSのminusDayに同じ値を渡して生成されたYMDHMSを保持するインスタンス同士は_equalsでtrueを返す() {
            int day = 1;
            ShoriTimestamp other = new ShoriTimestamp(value.minusDay(day));
            assertThat(sut.minusDay(day), is(other));
        }
    }

    public static class IMonthDealable関係 extends DbzTestBase {

        private YMDHMS value;
        private ShoriTimestamp sut;

        @Before
        public void setUp() {
            value = VALUE1;
            sut = new ShoriTimestamp(value);
        }

        @Test
        public void getMonthValueは_保持するYMDHMSと同じ値を返す() {
            assertThat(sut.getMonthValue(), is(value.getMonthValue()));
        }

        @Test
        public void getLastDayは_保持するYMDHMSと同じ値を返す() {
            assertThat(sut.getLastDay(), is(value.getLastDay()));
        }

        @Test
        public void getBetweenMonthsは_minusMonthにより生成したインスタンスが渡されたとき_minusMonthの引数と同じ値を返す() {
            int month = 1;
            ShoriTimestamp other = new ShoriTimestamp(value.minusMonth(month));
            assertThat(sut.getBetweenMonths(other), is(month));
        }

        @Test
        public void plusMonthで生成されるインスタンスと_保持するYMDHMSのplusMonthに同じ値を渡して生成されたYMDHMSを保持するインスタンス同士は_equalsでtrueを返す() {
            int month = 1;
            ShoriTimestamp other = new ShoriTimestamp(value.plusMonth(month));
            assertThat(sut.plusMonth(month).equals(other), is(true));
        }

        @Test
        public void minusMonthで生成されるインスタンスと_保持するYMDHMSのminusMonthに同じ値を渡して生成されたYMDHMSを保持するインスタンス同士は_equalsでtrueを返す() {
            int month = 1;
            ShoriTimestamp other = new ShoriTimestamp(value.minusMonth(month));
            assertThat(sut.minusMonth(month).equals(other), is(true));
        }
    }

    public static class IYearDealable関係 extends DbzTestBase {

        private YMDHMS value;
        private ShoriTimestamp sut;

        @Before
        public void setUp() {
            value = VALUE1;
            sut = new ShoriTimestamp(value);
        }

        @Test
        public void getYearValueは_保持するYMDHMSと同じ値を返す() {
            assertThat(sut.getYearValue(), is(value.getYearValue()));
        }

        @Test
        public void isLeapYearは_保持するYMDHMSと同じ値を返す() {
            assertThat(sut.isLeapYear(), is(value.isLeapYear()));
        }

        @Test
        public void getBetweenYearsは_minusYearにより生成したインスタンスが渡されたとき_minusYearの引数と同じ値を返す() {
            int year = 1;
            ShoriTimestamp other = new ShoriTimestamp(value.minusYear(year));
            assertThat(sut.getBetweenYears(other), is(year));
        }

        @Test
        public void plusYearで生成されるインスタンスと_保持するYMDHMSのplusYearに同じ値を渡して生成されたYMDHMSを保持するインスタンス同士は_equalsでtrueを返す() {
            int year = 1;
            ShoriTimestamp other = new ShoriTimestamp(value.plusYear(year));
            assertThat(sut.plusYear(year).equals(other), is(true));
        }

        @Test
        public void minusYearで生成されるインスタンスと_保持するYMDHMSのminusYearに同じ値を渡して生成されたYMDHMSを保持するインスタンス同士は_equalsでtrueを返す() {
            int year = 1;
            ShoriTimestamp other = new ShoriTimestamp(value.minusYear(year));
            assertThat(sut.minusYear(year).equals(other), is(true));
        }
    }

    public static class IDateDurationGettable関係 extends DbzTestBase {

        private YMDHMS value;
        private ShoriTimestamp sut;

        @Before
        public void setUp() {
            value = VALUE1;
            sut = new ShoriTimestamp(value);
        }

        @Test
        public void getBetweenDuration_getYearは_保持するYMDHMSのplusYearから生成したYMDHMSを保持するインスタンスを渡した時_plusYearの引数と同じ値を返す() {
            int year = 1;
            ShoriTimestamp other = new ShoriTimestamp(value.plusYear(year));
            assertThat(sut.getBetweenDuration(other).getYear(), is(year));
        }

        @Test
        public void getBetweenDuration_getYearは_保持するYMDHMSのminusYearから生成したYMDHMSを保持するインスタンスを渡した時_minusYearの引数と同じ値を返す() {
            int year = 1;
            ShoriTimestamp other = new ShoriTimestamp(value.minusYear(year));
            assertThat(sut.getBetweenDuration(other).getYear(), is(year));
        }

        @Test
        public void getBetweenDuration_getMonthは_保持するYMDHMSのplusMonthから生成したYMDHMSを保持するインスタンスを渡した時_plusMonthの引数と同じ値を返す() {
            int month = 1;
            ShoriTimestamp other = new ShoriTimestamp(value.plusMonth(month));
            assertThat(sut.getBetweenDuration(other).getMonth(), is(month));
        }

        @Test
        public void getBetweenDuration_getMonthは_保持するYMDHMSのminusMonthから生成したYMDHMSを保持するインスタンスを渡した時_minusMonthの引数と同じ値を返す() {
            int month = 1;
            ShoriTimestamp other = new ShoriTimestamp(value.minusMonth(month));
            assertThat(sut.getBetweenDuration(other).getMonth(), is(month));
        }

        @Test
        public void getBetweenDuration_getDayは_保持するYMDHMSのplusDayから生成したYMDHMSを保持するインスタンスを渡した時_plusDayの引数と同じ値を返す() {
            int day = 1;
            ShoriTimestamp other = new ShoriTimestamp(value.plusDay(day));
            assertThat(sut.getBetweenDuration(other).getDay(), is(day));
        }

        @Test
        public void getBetweenDuration_getDayは_保持するYMDHMSのminusDayから生成したYMDHMSを保持するインスタンスを渡した時_minusDayの引数と同じ値を返す() {
            int day = 1;
            ShoriTimestamp other = new ShoriTimestamp(value.minusDay(day));
            assertThat(sut.getBetweenDuration(other).getDay(), is(day));
        }
    }

    public static class Hour extends DbzTestBase {

        private YMDHMS value;
        private ShoriTimestamp sut;

        @Before
        public void setUp() {
            value = new YMDHMS("20150115230000");
            sut = new ShoriTimestamp(value);
        }

        @Test
        public void _23時00分00秒を持つShoriTimestampの_getBetwwenDaysは_そのplusHoursへ1を渡して生成されたインスタンスが渡された時_minus1を返す() {
            ShoriTimestamp other = sut.plusHours(1);
            assertThat(sut.getBetweenDays(other), is(-1));
        }

        @Test
        public void _23時00分00秒を持つShoriTimestampの_getBetwwenDaysは_そのminusHoursに23を渡して生成されたインスタンスが渡されたとき_0を返す() {
            ShoriTimestamp other = sut.minusHours(23);
            assertThat(sut.getBetweenDays(other), is(0));
        }

        @Test
        public void _23時00分00秒を持つShoriTimestampの_getBetwwenDaysは_そのminusHoursに24を渡して生成されたインスタンスが渡されたとき_1を返す() {
            ShoriTimestamp other = sut.minusHours(24);
            assertThat(sut.getBetweenDays(other), is(1));
        }

        @Test
        public void _23時の値を持つShoriTimestampのplusHoursに1を渡して生成されたインスタンスは_getHourで0を返す() {
            assertThat(sut.plusHours(1).getHour(), is(0));
        }

        @Test
        public void _23時の値を持つShoriTimestampのplusHoursに2を渡して生成されたインスタンスは_getHourで1を返す() {
            assertThat(sut.plusHours(2).getHour(), is(1));
        }

        @Test
        public void _23時の値を持つShoriTimestampのminusHoursに23を渡して生成されたインスタンスは_getHourで0を返す() {
            assertThat(sut.minusHours(23).getHour(), is(0));
        }

        @Test
        public void _23時の値を持つShoriTimestampのminusHoursに24を渡して生成されたインスタンスは_getHourで23を返す() {
            assertThat(sut.minusHours(24).getHour(), is(23));
        }
    }

    public static class Minute extends DbzTestBase {

        private YMDHMS value;
        private ShoriTimestamp sut;

        @Before
        public void setUp() {
            value = new YMDHMS("20150115230000");
            sut = new ShoriTimestamp(value);
        }

        @Test
        public void _23時00分00秒を持つShoriTimestampの_getBetwwenDaysは_そのplusMinutesへ59を渡して生成されたインスタンスが渡された時_0を返す() {
            ShoriTimestamp other = sut.plusMinutes(59);
            assertThat(sut.getBetweenDays(other), is(0));
        }

        @Test
        public void _23時00分00秒を持つShoriTimestampの_getBetwwenDaysは_そのplusMinutesへ60を渡して生成されたインスタンスが渡された時_minus1を返す() {
            ShoriTimestamp other = sut.plusMinutes(60);
            assertThat(sut.getBetweenDays(other), is(-1));
        }

        @Test
        public void _23時00分00秒を持つShoriTimestampの_getBetwwenDaysは_そのminusMinutesへ23時間相当の値を渡して生成されたインスタンスが渡された時_0を返す() {
            ShoriTimestamp other = sut.minusMinutes(60 * 23);
            assertThat(sut.getBetweenDays(other), is(0));
        }

        @Test
        public void _23時00分00秒を持つShoriTimestampの_getBetwwenDaysは_そのminusMinutesへ23時間1分相当の値を渡して生成されたインスタンスが渡された時_1を返す() {
            ShoriTimestamp other = sut.minusMinutes(60 * 23 + 1);
            assertThat(sut.getBetweenDays(other), is(1));
        }

        @Test
        public void _00分の値を持つShoriTimestampのplusMinutesに60を渡して生成されたインスタンスは_getMinuteで0を返す() {
            assertThat(sut.plusMinutes(60).getMinute(), is(0));
        }

        @Test
        public void _00分の値を持つShoriTimestampのminusMinutesに60を渡して生成されたインスタンスは_getMinuteで0を返す() {
            assertThat(sut.minusMinutes(60).getMinute(), is(0));
        }
    }

    public static class Seconds extends DbzTestBase {

        private YMDHMS value;
        private ShoriTimestamp sut;

        @Before
        public void setUp() {
            value = new YMDHMS("20150115230000");
            sut = new ShoriTimestamp(value);
        }

        @Test
        public void _23時00分00秒を持つShoriTimestampの_getBetweenDaysは_そのplusSecondsへ3599を渡して生成されたインスタンスが渡された時_0を返す() {
            ShoriTimestamp other = sut.plusSeconds(60 * 60 - 1);
            assertThat(sut.getBetweenDays(other), is(0));
        }

        @Test
        public void _23時00分00秒を持つShoriTimestampの_getBetweenDaysは_そのplusSecondsへ3600を渡して生成されたインスタンスが渡された時_minus1を返す() {
            ShoriTimestamp other = sut.plusSeconds(60 * 60);
            assertThat(sut.getBetweenDays(other), is(-1));
        }

        @Test
        public void _23時00分00秒を持つShoriTimestampの_getBetweenDaysは_そのminusSecondsへ23時間相当の値を渡して生成されたインスタンスが渡された時_0を返す() {
            ShoriTimestamp other = sut.minusSeconds(60 * 60 * 23);
            assertThat(sut.getBetweenDays(other), is(0));
        }

        @Test
        public void _23時00分00秒を持つShoriTimestampの_getBetweenDaysは_そのminusSecondsへ23時間1秒相当の値を渡して生成されたインスタンスが渡された時_1を返す() {
            ShoriTimestamp other = sut.minusSeconds(60 * 60 * 23 + 1);
            assertThat(sut.getBetweenDays(other), is(1));
        }

        @Test
        public void _00秒の値を持つShoriTimestampの_plusSecondsに60を渡して生成されたインスタンスは_getScondsで_0を返す() {
            assertThat(sut.plusSeconds(60).getSecond(), is(0));
        }

        @Test
        public void _00秒の値を持つShoriTimestampの_minusSecondsに60を渡して生成されたインスタンスは_getScondsで_0を返す() {
            assertThat(sut.minusSeconds(60).getSecond(), is(0));
        }

        @Test
        public void _00秒の値を持つShoriTimestampの_plusSecondsに1を渡して生成されたインスタンスは_getScondsで_0を返す() {
            assertThat(sut.plusMinutes(1).getSecond(), is(0));
        }

        @Test
        public void _00秒の値を持つShoriTimestampの_plusHoursに1を渡して生成されたインスタンスは_getScondsで_0を返す() {
            assertThat(sut.plusHours(1).getSecond(), is(0));
        }

        @Test
        public void _00秒の値を持つShoriTimestampの_plusDayに1を渡して生成されたインスタンスは_getScondsで_0を返す() {
            assertThat(sut.plusDay(1).getSecond(), is(0));
        }

        @Test
        public void _00秒の値を持つShoriTimestampの_plusMonthに1を渡して生成されたインスタンスは_getScondsで_0を返す() {
            assertThat(sut.plusMonth(1).getSecond(), is(0));
        }

        @Test
        public void _00秒の値を持つShoriTimestampの_plusYearに1を渡して生成されたインスタンスは_getScondsで_0を返す() {
            assertThat(sut.plusYear(1).getSecond(), is(0));
        }
    }
}
