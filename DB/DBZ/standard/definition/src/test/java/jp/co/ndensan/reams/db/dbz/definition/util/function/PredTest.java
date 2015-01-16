/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.util.function;

import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.*;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;

/**
 * {@link Pred}のテストです。
 *
 * @author N3327 三浦 凌
 */
@RunWith(Enclosed.class)
public class PredTest extends DbzTestBase {

    public PredTest() {
    }

    public static class of extends DbzTestBase {

        private Pred<RString> sut;

        @Test(expected = NullPointerException.class)
        public void ofは_引数がnullの時_NullPointerExceptionをスローする() {
            sut.of(null);
        }

        @Test
        public void ofは_引数のIPredicateがevaluateでtrueを返す時_evaluateでtrueを返すPredicateを生成する() {
            IPredicate<String> predicate = mock(IPredicate.class);
            when(predicate.evaluate(any(String.class))).thenReturn(Boolean.TRUE);
            assertThat(sut.of(predicate).evaluate("test"), is(true));
        }

        @Test
        public void ofは_引数のIPredicateがevaluateでfalseを返す時_evaluateでfalseを返すPredicateを生成する() {
            IPredicate<String> predicate = mock(IPredicate.class);
            when(predicate.evaluate(any(String.class))).thenReturn(Boolean.FALSE);
            assertThat(sut.of(predicate).evaluate("test"), is(false));
        }
    }

    private static <T> IPredicate<T> newIPredicate(final boolean returnValue) {
        return new IPredicate<T>() {
            @Override
            public boolean evaluate(T t) {
                return returnValue;
            }
        };
    }

    public static class isEquals extends DbzTestBase {

        private Pred<RString> sut;

        @Test
        public void isEqualsの引数がnullの時_生成されるPredicateは_evalueteにnullを受け取ると_trueを返す() {
            IPredicate<String> created = sut.isEqual(null);
            assertThat(created.evaluate(null), is(true));
        }

        @Test
        public void isEqualsの引数がnullの時_生成されるPredicateは_evalueteにnullでない値を受け取ると_falseを返す() {
            IPredicate<String> created = sut.isEqual(null);
            assertThat(created.evaluate("test"), is(false));
        }

        @Test
        public void isEqualsの引数がnullでない時_生成されるPredicateは_evalueteにnullを受け取ると_falseを返す() {
            IPredicate<String> created = sut.isEqual("test");
            assertThat(created.evaluate(null), is(false));
        }

        @Test
        public void isEqualsの引数がnullでない時_生成されるPredicateは_evalueteにisEqualsの引数とequalsでfalseを返す値を受け取ると_falseを返す() {
            String value1 = "test";
            String value2 = "test2";
            IPredicate<String> created = sut.isEqual(value1);
            assertThat(value1.equals(value2), is(false));
            assertThat(created.evaluate(value2), is(false));
        }

        @Test
        public void isEqualsの引数がnullでない時_生成されるPredicateは_evalueteにisEqualsの引数とequalsでtrueを返す値を受け取ると_trueを返す() {
            RString value1 = new RString("100");
            RString value2 = new RString("100");
            IPredicate<RString> created = sut.isEqual(value1);
            assertThat(value1.equals(value2), is(true));
            assertThat(created.evaluate(value2), is(true));
        }
    }

    public static class not extends DbzTestBase {

        private Pred<RString> sut;

        @Test(expected = NullPointerException.class)
        public void notは_引数のIPredicateがnullの時_NullPointerExceptionをスローする() {
            sut.not(null);
        }

        @Test
        public void notは_引数のIPredicateがevaluateでtrueを返す時_evaluateでfalseを返すPredicateを生成する() {
            IPredicate<String> predicate = mock(IPredicate.class);
            when(predicate.evaluate(any(String.class))).thenReturn(Boolean.TRUE);
            assertThat(sut.not(predicate).evaluate("test"), is(false));
        }

        @Test
        public void notは_引数のIPredicateがevaluateでfalseを返す時_evaluateでtrueを返すPredicateを生成する() {
            IPredicate<String> predicate = mock(IPredicate.class);
            when(predicate.evaluate(any(String.class))).thenReturn(Boolean.FALSE);
            assertThat(sut.not(predicate).evaluate("test"), is(true));
        }
    }

    public static class negate extends DbzTestBase {

        private IPredicate<String> predicate;
        private Pred<String> sut;

        @Before
        public void setUp() {
            predicate = mock(IPredicate.class);
            sut = Pred.of(predicate);
        }

        @Test
        public void evaluateでtrueを返すインスタンスは_negateにより_evaluateでfalseを返すPredicateを生成する() {
            when(predicate.evaluate(any(String.class))).thenReturn(Boolean.TRUE);
            assertThat(sut.evaluate("test"), is(true));
            assertThat(sut.negate().evaluate("test"), is(false));
        }

        @Test
        public void evaluateでfalseを返すインスタンスは_negateにより_evaluateでtrueを返すPredicateを生成する() {
            when(predicate.evaluate(any(String.class))).thenReturn(Boolean.FALSE);
            assertThat(sut.evaluate("test"), is(false));
            assertThat(sut.negate().evaluate("test"), is(true));
        }
    }

    public static class or extends DbzTestBase {

        private Pred<String> truePredicate;
        private Pred<String> falsePredicate;

        @Before
        public void setUp() {
            truePredicate = Pred.of(newIPredicate(true));
            falsePredicate = Pred.of(newIPredicate(false));
        }

        @Test
        public void evaluateでtrueを返すPredicateの_orに_trueを返すPredicateを渡した時_生成されるインスタンスは_evaluateでtrueを返す() {
            Pred<String> sut = truePredicate.or(truePredicate);
            assertThat(sut.evaluate(""), is(true));
        }

        @Test
        public void evaluateでtrueを返すPredicateの_orに_flaseを返すPredicateを渡した時_生成されるインスタンスは_evaluateでtrueを返す() {
            Pred<String> sut = truePredicate.or(falsePredicate);
            assertThat(sut.evaluate(""), is(true));
        }

        @Test
        public void evaluateでfalseを返すPredicateの_orに_trueを返すPredicateを渡した時_生成されるインスタンスは_evaluateでtrueを返す() {
            Pred<String> sut = falsePredicate.or(truePredicate);
            assertThat(sut.evaluate(""), is(true));
        }

        @Test
        public void evaluateでfalseを返すPredicateの_orに_flaseを返すPredicateを渡した時_生成されるインスタンスは_evaluateでfalseを返す() {
            Pred<String> sut = falsePredicate.or(falsePredicate);
            assertThat(sut.evaluate(""), is(false));
        }
    }

    public static class and extends DbzTestBase {

        private Pred<String> truePredicate;
        private Pred<String> falsePredicate;

        @Before
        public void setUp() {
            truePredicate = Pred.of(newIPredicate(true));
            falsePredicate = Pred.of(newIPredicate(false));
        }

        @Test
        public void evaluateでtrueを返すPredicateの_andに_trueを返すPredicateを渡した時_生成されるインスタンスは_evaluateでtrueを返す() {
            Pred<String> sut = truePredicate.and(truePredicate);
            assertThat(sut.evaluate(""), is(true));
        }

        @Test
        public void evaluateでtrueを返すPredicateの_andに_flaseを返すPredicateを渡した時_生成されるインスタンスは_evaluateでfalseを返す() {
            Pred<String> sut = truePredicate.and(falsePredicate);
            assertThat(sut.evaluate(""), is(false));
        }

        @Test
        public void evaluateでfalseを返すPredicateの_andに_trueを返すPredicateを渡した時_生成されるインスタンスは_evaluateでfalseを返す() {
            Pred<String> sut = falsePredicate.and(truePredicate);
            assertThat(sut.evaluate(""), is(false));
        }

        @Test
        public void evaluateでfalseを返すPredicateの_andに_flaseを返すPredicateを渡した時_生成されるインスタンスは_evaluateでfalseを返す() {
            Pred<String> sut = falsePredicate.and(falsePredicate);
            assertThat(sut.evaluate(""), is(false));
        }
    }
}
