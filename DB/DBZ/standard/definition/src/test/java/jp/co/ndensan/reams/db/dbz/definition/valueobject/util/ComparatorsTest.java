/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.valueobject.util;

import java.util.Comparator;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.util.Comparators.NaturalOrderComparator;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.util.Comparators.NullComparator;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import static org.hamcrest.CoreMatchers.is;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * Comparatorsのテストです。
 *
 * @author N3327 三浦 凌
 */
@RunWith(Enclosed.class)
public class ComparatorsTest {

    public ComparatorsTest() {
    }

    public static class NaturalOrderComparatorTest extends DbzTestBase {

        private NaturalOrderComparator sut;
        private Comparator<ComparableValue> created;
        private ComparableValue value1;
        private ComparableValue value2;

        @Before
        public void setUp() {
            value1 = new ComparableValue(1);
            value2 = new ComparableValue(2);
        }

        @Test
        public void ASCにより生成したインスタンスのcompareは_第1引数のcompareToに_第2引数を渡した結果と_同じ値を返す() {
            created = sut.ASC.getInstance();
            assertThat(created.compare(value1, value2), is(value1.compareTo(value2)));
        }

        @Test(expected = NullPointerException.class)
        public void ASCにより生成したインスタンスのcompareは_第1引数にnullを受け取った時_NullPointerExceptionをスローする() {
            created = sut.ASC.getInstance();
            created.compare(null, value2);
        }

        @Test(expected = NullPointerException.class)
        public void ASCにより生成したインスタンスのcompareは_第2引数にnullを受け取った時_NullPointerExceptionをスローする() {
            created = sut.ASC.getInstance();
            created.compare(value1, null);
        }

        @Test
        public void DESCにより生成したインスタンスのcompareは_第2引数のcompareToに_第1引数を渡した結果と_同じ値を返す() {
            created = sut.DESC.getInstance();
            assertThat(created.compare(value1, value2), is(value2.compareTo(value1)));
        }

        @Test(expected = NullPointerException.class)
        public void DESCにより生成したインスタンスのcompareは_第1引数にnullを受け取った時_NullPointerExceptionをスローする() {
            created = sut.DESC.getInstance();
            created.compare(null, value2);
        }

        @Test(expected = NullPointerException.class)
        public void DESCにより生成したインスタンスのcompareは_第2引数にnullを受け取った時_NullPointerExceptionをスローする() {
            created = sut.DESC.getInstance();
            created.compare(value1, null);
        }

    }

    @RunWith(Enclosed.class)
    public static class NullComparatorTest extends DbzTestBase {

        private final static ComparableValue VALUE1;
        private final static ComparableValue VALUE2;

        static {
            VALUE1 = new ComparableValue(1);
            VALUE2 = new ComparableValue(2);
        }

        public static class of extends DbzTestBase {

            private NullComparator sut;

            @Test(expected = NullPointerException.class)
            public void NullsFirst$ofは_引数がnullの時_NullPointerExceptionをスローする() {
                sut.NullsFirst.of(null);
            }

            @Test(expected = NullPointerException.class)
            public void NullsLast$ofは_引数がnullの時_NullPointerExceptionをスローする() {
                sut.NullsLast.of(null);
            }
        }

        public static class NullsaFirst extends DbzTestBase {

            private NullComparator sut;
            private static Comparator<ComparableValue> base;
            private static Comparator<ComparableValue> created;

            @Before
            public void setUp() {
                base = NaturalOrderComparator.ASC.getInstance();
                created = sut.NullsFirst.of(base);
            }

            @Test
            public void NullsFirst$ofで生成したインスタンスのcompareは_第1引数がnullの時_minus1を返す() {
                assertThat(created.compare(null, VALUE2), is(-1));
            }

            @Test
            public void NullsFirst$ofで生成したインスタンスのcompareは_第2引数がnullの時_1を返す() {
                assertThat(created.compare(VALUE1, null), is(1));
            }

            @Test
            public void NullsFirst$ofで生成したインスタンスのcompareは_どちらの引数もnullの時_0を返す() {
                assertThat(created.compare(null, null), is(0));
            }

            @Test
            public void NullsFirst$ofで生成したインスタンスのcompareは_どちらの引数もnullでないとき_ofの引数のcomparator$compareと同じ値を返す() {
                assertThat(created.compare(VALUE1, VALUE2), is(base.compare(VALUE1, VALUE2)));
            }
        }

        public static class NullsLast extends DbzTestBase {

            private NullComparator sut;
            private static Comparator<ComparableValue> base;
            private static Comparator<ComparableValue> created;

            @Before
            public void setUp() {
                base = NaturalOrderComparator.ASC.getInstance();
                created = sut.NullsLast.of(base);
            }

            @Test
            public void NullsLast$ofで生成したインスタンスのcompareは_第1引数がnullの時_minus1を返す() {
                assertThat(created.compare(null, VALUE2), is(1));
            }

            @Test
            public void NullsLast$ofで生成したインスタンスのcompareは_第2引数がnullの時_1を返す() {
                assertThat(created.compare(VALUE1, null), is(-1));
            }

            @Test
            public void NullsLast$ofで生成したインスタンスのcompareは_どちらの引数もnullの時_0を返す() {
                assertThat(created.compare(null, null), is(0));
            }

            @Test
            public void NullsLast$ofで生成したインスタンスのcompareは_どちらの引数もnullでないとき_ofの引数のcomparator$compareと同じ値を返す() {
                assertThat(created.compare(VALUE1, VALUE2), is(base.compare(VALUE1, VALUE2)));
            }
        }
    }

    private static class ComparableValue implements Comparable<ComparableValue> {

        private final int theValue;

        public ComparableValue(int value) {
            this.theValue = value;
        }

        @Override
        public int compareTo(ComparableValue o) {
            return theValue - o.theValue;
        }
    }
}
