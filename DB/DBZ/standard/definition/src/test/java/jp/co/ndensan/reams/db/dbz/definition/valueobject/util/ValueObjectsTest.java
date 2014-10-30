/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.valueobject.util;

import jp.co.ndensan.reams.db.dbz.definition.valueobject.util.ValueObjects.ILengthOfValueMatcher;
import static jp.co.ndensan.reams.db.dbz.definition.valueobject.util.ValueObjects.equal;
import static jp.co.ndensan.reams.db.dbz.definition.valueobject.util.ValueObjects.lessOrEqual;
import static jp.co.ndensan.reams.db.dbz.definition.valueobject.util.ValueObjects.lessThan;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.biz.IValueObject;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.*;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * ValueObjectsのテストです。
 *
 * @author N3327 三浦 凌
 */
@RunWith(Enclosed.class)
//TODO 他のメソッド分は今後実装する。
public class ValueObjectsTest extends DbzTestBase {

    private static ValueObjects sut;

    public ValueObjectsTest() {
    }

    public static class requireNonNull extends DbzTestBase {

        @Test(expected = IllegalInitialValueException.class)
        public void requireNonNullは_引数がnullの時_IllegalInitialValueExceptionをスローする() {
            sut.requireNonNull(null);
        }

        @Test
        public void requireNonNullは_引数がnullでないとき_引数を返す() {
            RString value = new RString("not null");
            assertThat(sut.requireNonNull(value), is(sameInstance(value)));
        }
    }

    public static class requireHalfSizeNumberOnly_RString extends DbzTestBase {

        @Test(expected = IllegalInitialValueException.class)
        public void requireHalfSizeNumberOnlyは_引数が全角の文字列を含む時_IllegalInitialValueExceptionをスローする() {
            RString value = new RString("1234あいうえ");
            sut.requireHalfSizeNumberOnly(value);
        }

        @Test(expected = IllegalInitialValueException.class)
        public void requireHalfSizeNumberOnlyは_引数が全角数字のみの時_IllegalInitialValueExceptionをスローする() {
            RString value = new RString("１２３４５");
            sut.requireHalfSizeNumberOnly(value);
        }

        @Test(expected = IllegalInitialValueException.class)
        public void requireHalfSizeNumberOnlyは_引数が半角スペースを含む時_IllegalInitialValueExceptionをスローする() {
            RString value = new RString("1234 56");
            sut.requireHalfSizeNumberOnly(value);
        }

        @Test(expected = IllegalInitialValueException.class)
        public void requireHalfSizeNumberOnlyは_引数が半角のアルファベットを含む時_IllegalInitialValueExceptionをスローする() {
            RString value = new RString("b123456");
            sut.requireHalfSizeNumberOnly(value);
        }

        @Test
        public void requireHalfSizeNumberOnlyは_引数が半角数字のみの時_引数を返す() {
            RString value = new RString("123456");
            assertThat(sut.requireHalfSizeNumberOnly(value), is(sameInstance(value)));
        }
    }

    public static class requireHalfSizeNumberOnly_ValueObject extends DbzTestBase {

        private IValueObject<RString> valueObject;

        @Before
        public void setUp() {
            valueObject = mock(IValueObject.class);
        }

        @Test(expected = IllegalInitialValueException.class)
        public void requireHalfSizeNumberOnlyは_引数のvalueObjectが全角の文字列を含む時_IllegalInitialValueExceptionをスローする() {
            RString value = new RString("1234あいうえ");
            when(valueObject.value()).thenReturn(value);
            sut.requireHalfSizeNumberOnly(valueObject);
        }

        @Test(expected = IllegalInitialValueException.class)
        public void requireHalfSizeNumberOnlyは_引数のvalueObjectが全角数字のみの時_IllegalInitialValueExceptionをスローする() {
            RString value = new RString("１２３４５");
            when(valueObject.value()).thenReturn(value);
            sut.requireHalfSizeNumberOnly(valueObject);
        }

        @Test(expected = IllegalInitialValueException.class)
        public void requireHalfSizeNumberOnlyは_引数のvalueObjectが半角スペースを含む時_IllegalInitialValueExceptionをスローする() {
            RString value = new RString("1234 56");
            when(valueObject.value()).thenReturn(value);
            sut.requireHalfSizeNumberOnly(valueObject);
        }

        @Test(expected = IllegalInitialValueException.class)
        public void requireHalfSizeNumberOnlyは_引数のvalueObjectが半角のアルファベットを含む時_IllegalInitialValueExceptionをスローする() {
            RString value = new RString("b123456");
            when(valueObject.value()).thenReturn(value);
            sut.requireHalfSizeNumberOnly(valueObject);
        }

        @Test
        public void requireHalfSizeNumberOnlyは_引数のvalueObjectが半角数字のみの時_引数を返す() {
            RString value = new RString("123456");
            when(valueObject.value()).thenReturn(value);
            assertThat(sut.requireHalfSizeNumberOnly(valueObject), is(sameInstance(valueObject)));
        }
    }

    public static class requireAlphabetAndHalfsizeNumberOnly_RString extends DbzTestBase {

        @Test(expected = IllegalInitialValueException.class)
        public void requireAlphabetAndHalfsizeNumberOnlyは_引数が全角の文字列を含む時_IllegalInitialValueExceptionをスローする() {
            RString value = new RString("1234あいうえ");
            sut.requireAlphabetAndHalfsizeNumberOnly(value);
        }

        @Test(expected = IllegalInitialValueException.class)
        public void requireAlphabetAndHalfsizeNumberOnlyは_引数が全角英数の時_IllegalInitialValueExceptionをスローする() {
            RString value = new RString("Ａ１２３４５");
            sut.requireAlphabetAndHalfsizeNumberOnly(value);
        }

        @Test(expected = IllegalInitialValueException.class)
        public void requireAlphabetAndHalfsizeNumberOnlyは_引数が半角スペースを含む時_IllegalInitialValueExceptionをスローする() {
            RString value = new RString("a1234 56");
            sut.requireAlphabetAndHalfsizeNumberOnly(value);
        }

        @Test
        public void requireAlphabetAndHalfsizeNumberOnlyは_引数が半角英数字のみの時_引数を返す() {
            RString value = new RString("b123456");
            assertThat(sut.requireAlphabetAndHalfsizeNumberOnly(value), is(sameInstance(value)));
        }

        @Test
        public void requireAlphabetAndHalfsizeNumberOnlyは_引数が半角数字のみの時_引数を返す() {
            RString value = new RString("123456");
            assertThat(sut.requireAlphabetAndHalfsizeNumberOnly(value), is(sameInstance(value)));
        }

        @Test
        public void requireAlphabetAndHalfsizeNumberOnlyは_引数が半角アルファベットのみの時_引数を返す() {
            RString value = new RString("abcdefg");
            assertThat(sut.requireAlphabetAndHalfsizeNumberOnly(value), is(sameInstance(value)));
        }
    }

    public static class requireAlphabetAndHalfsizeNumberOnly_ValueObject extends DbzTestBase {

        private IValueObject<RString> valueObject;

        @Before
        public void setUp() {
            valueObject = mock(IValueObject.class);
        }

        @Test(expected = IllegalInitialValueException.class)
        public void requireAlphabetAndHalfsizeNumberOnlyは_引数のvalueObjectが全角の文字列を含む時_IllegalInitialValueExceptionをスローする() {
            RString value = new RString("1234あいうえ");
            when(valueObject.value()).thenReturn(value);
            sut.requireAlphabetAndHalfsizeNumberOnly(valueObject);
        }

        @Test(expected = IllegalInitialValueException.class)
        public void requireAlphabetAndHalfsizeNumberOnlyは_引数のvalueObjectが全角英数の時_IllegalInitialValueExceptionをスローする() {
            RString value = new RString("Ａ１２３４５");
            when(valueObject.value()).thenReturn(value);
            sut.requireAlphabetAndHalfsizeNumberOnly(valueObject);
        }

        @Test(expected = IllegalInitialValueException.class)
        public void requireAlphabetAndHalfsizeNumberOnlyは_引数のvalueObjectが半角スペースを含む時_IllegalInitialValueExceptionをスローする() {
            RString value = new RString("a1234 56");
            when(valueObject.value()).thenReturn(value);
            sut.requireAlphabetAndHalfsizeNumberOnly(valueObject);
        }

        @Test
        public void requireAlphabetAndHalfsizeNumberOnlyは_引数のvalueObjectが半角英数字のみの時_引数を返す() {
            RString value = new RString("b123456");
            when(valueObject.value()).thenReturn(value);
            assertThat(sut.requireAlphabetAndHalfsizeNumberOnly(valueObject), is(sameInstance(valueObject)));
        }

        @Test
        public void requireAlphabetAndHalfsizeNumberOnlyは_引数のvalueObjectが半角数字のみの時_引数を返す() {
            RString value = new RString("123456");
            when(valueObject.value()).thenReturn(value);
            assertThat(sut.requireAlphabetAndHalfsizeNumberOnly(valueObject), is(sameInstance(valueObject)));
        }

        @Test
        public void requireAlphabetAndHalfsizeNumberOnlyは_引数が半角アルファベットのみの時_引数を返す() {
            RString value = new RString("abcdefg");
            when(valueObject.value()).thenReturn(value);
            assertThat(sut.requireAlphabetAndHalfsizeNumberOnly(valueObject), is(sameInstance(valueObject)));
        }
    }

    @RunWith(Enclosed.class)
    public static class requireLength_valueBase_RString extends DbzTestBase {

        private static final RString VALUE;

        static {
            VALUE = new RString("12345");
        }

        public static class equal extends DbzTestBase {

            @Test
            public void requireLengthは_左にvalue_右にValueObjects$equalを置いた時_valueがnullを受け取ったら_nullを返す() {
                assertThat(sut.requireLength((RString) null, equal(5)), is(nullValue()));
            }

            @Test
            public void requireLengthは_左にvalue_右にValueObjects$equalを置いた時_valueの文字数とequalsの引数の値が一致したら_valueを返す() {
                assertThat(sut.requireLength(VALUE, equal(5)), is(VALUE));
            }

            @Test(expected = IllegalInitialValueException.class)
            public void requireLengthは_左にvalue_右にValueObjects$equalを置いた時_valueの文字数とequalsの引数の値が一致しなかったら_IllegalInitialValueExceptionをスローする() {
                sut.requireLength(VALUE, equal(6));
            }
        }

        public static class lessThan extends DbzTestBase {

            @Test
            public void requireLengthは_左にvalue_右にValueObjects$lessThanを置いた時_valueがnullを受け取ったら_nullを返す() {
                assertThat(sut.requireLength((RString) null, lessThan(5)), is(nullValue()));
            }

            @Test
            public void requireLengthは_左にvalue_右にValueObjects$lessThanを置いた時_valueの文字数がlessThanの引数の値より小さければ_valueを返す() {
                assertThat(sut.requireLength(VALUE, lessThan(6)), is(VALUE));
            }

            @Test(expected = IllegalInitialValueException.class)
            public void requireLengthは_左にvalue_右にValueObjects$lessThanを置いた時_valueの文字数がlessThanの引数の値と一致したら_IllegalInitialValueExceptionをスローする() {
                sut.requireLength(VALUE, lessThan(5));
            }

            @Test(expected = IllegalInitialValueException.class)
            public void requireLengthは_左にvalue_右にValueObjects$lessThanを置いた時_valueの文字数がlessThanの引数の値より大きかったら_IllegalInitialValueExceptionをスローする() {
                sut.requireLength(VALUE, lessThan(4));
            }
        }

        public static class lessOrEqual extends DbzTestBase {

            @Test
            public void requireLengthは_左にvalue_右にValueObjects$lessOrEqualを置いた時_valueがnullを受け取ったら_nullを返す() {
                assertThat(sut.requireLength((RString) null, lessOrEqual(5)), is(nullValue()));
            }

            @Test
            public void requireLengthは_左にvalue_右にValueObjects$lessOrEqualを置いた時_valueの文字数がlessOrEqualの引数の値より小さければ_valueを返す() {
                assertThat(sut.requireLength(VALUE, lessOrEqual(6)), is(VALUE));
            }

            @Test
            public void requireLengthは_左にvalue_右にValueObjects$lessOrEqualを置いた時_valueの文字数がlessOrEqualの引数の値と一致したら_valueを返す() {
                sut.requireLength(VALUE, lessOrEqual(5));
            }

            @Test(expected = IllegalInitialValueException.class)
            public void requireLengthは_左にvalue_右にValueObjects$lessOrEqualを置いた時_valueの文字数がlessOrEqualの引数の値より大きかったら_IllegalInitialValueExceptionをスローする() {
                sut.requireLength(VALUE, lessOrEqual(4));
            }
        }
    }

    @RunWith(Enclosed.class)
    public static class requireLength_valueBase_ValueObject extends DbzTestBase {

        private static final IValueObject<RString> VALUE;

        static {
            VALUE = mock(IValueObject.class);
            when(VALUE.value()).thenReturn(new RString("12345"));
        }

        public static class equal extends DbzTestBase {

            @Test
            public void requireLengthは_左にvalue_右にValueObjects$equalを置いた時_valueがnullを受け取ったら_nullを返す() {
                assertThat(sut.requireLength((IValueObject<RString>) null, equal(5)), is(nullValue()));
            }

            @Test
            public void requireLengthは_左にvalue_右にValueObjects$equalを置いた時_valueの保持する文字列の文字数とequalsの引数の値が一致したら_valueを返す() {
                assertThat(sut.requireLength(VALUE, equal(5)), is(VALUE));
            }

            @Test(expected = IllegalInitialValueException.class)
            public void requireLengthは_左にvalue_右にValueObjects$equalを置いた時_valueの保持する文字列の文字数とequalsの引数の値が一致しなかったら_IllegalInitialValueExceptionをスローする() {
                sut.requireLength(VALUE, equal(6));
            }
        }

        public static class lessThan extends DbzTestBase {

            @Test
            public void requireLengthは_左にvalue_右にValueObjects$lessThanを置いた時_valueがnullを受け取ったら_nullを返す() {
                assertThat(sut.requireLength((IValueObject<RString>) null, lessThan(5)), is(nullValue()));
            }

            @Test
            public void requireLengthは_左にvalue_右にValueObjects$lessThanを置いた時_valueの保持する文字列の文字数がlessThanの引数の値より小さければ_valueを返す() {
                assertThat(sut.requireLength(VALUE, lessThan(6)), is(VALUE));
            }

            @Test(expected = IllegalInitialValueException.class)
            public void requireLengthは_左にvalue_右にValueObjects$lessThanを置いた時_valueの保持する文字列の文字数がlessThanの引数の値と一致したら_IllegalInitialValueExceptionをスローする() {
                sut.requireLength(VALUE, lessThan(5));
            }

            @Test(expected = IllegalInitialValueException.class)
            public void requireLengthは_左にvalue_右にValueObjects$lessThanを置いた時_valueの保持する文字列の文字数がlessThanの引数の値より大きかったら_IllegalInitialValueExceptionをスローする() {
                sut.requireLength(VALUE, lessThan(4));
            }
        }

        public static class lessOrEqual extends DbzTestBase {

            @Test
            public void requireLengthは_左にvalue_右にValueObjects$lessOrEqualを置いた時_valueがnullを受け取ったら_nullを返す() {
                assertThat(sut.requireLength((IValueObject<RString>) null, lessOrEqual(5)), is(nullValue()));
            }

            @Test
            public void requireLengthは_左にvalue_右にValueObjects$lessOrEqualを置いた時_valueの保持する文字列の文字数がlessOrEqualの引数の値より小さければ_valueを返す() {
                assertThat(sut.requireLength(VALUE, lessOrEqual(6)), is(VALUE));
            }

            @Test
            public void requireLengthは_左にvalue_右にValueObjects$lessOrEqualを置いた時_valueの保持する文字列の文字数がlessOrEqualの引数の値と一致したら_valueを返す() {
                sut.requireLength(VALUE, lessOrEqual(5));
            }

            @Test(expected = IllegalInitialValueException.class)
            public void requireLengthは_左にvalue_右にValueObjects$lessOrEqualを置いた時_valueの保持する文字列の文字数がlessOrEqualの引数の値より大きかったら_IllegalInitialValueExceptionをスローする() {
                sut.requireLength(VALUE, lessOrEqual(4));
            }
        }
    }

    @RunWith(Enclosed.class)
    public static class requireLength_lengthBase_RString extends DbzTestBase {

        private static final RString VALUE;

        static {
            VALUE = new RString("12345");
        }

        public static class equal extends DbzTestBase {

            @Test
            public void requireLengthは_左にlength_右にValueObjects$equalを置いた時_equalsがnullを受け取ったら_nullを返す() {
                assertThat(sut.requireLength(5, equal((RString) null)), is(nullValue()));
            }

            @Test(expected = IllegalArgumentException.class)
            public void requireLengthは_左にlength_右にValueObjects$equalを置いた時_lengthに0より小さい数値を受け取ったら_IllegalArgumentExceptionをスローする() {
                assertThat(sut.requireLength(-1, equal(VALUE)), is(VALUE));
            }

            @Test
            public void requireLengthは_左にlength_右にValueObjects$equalを置いた時_lengthとequalの引数の文字数が一致したら_equalの引数を返す() {
                assertThat(sut.requireLength(5, equal(VALUE)), is(VALUE));
            }

            @Test(expected = IllegalInitialValueException.class)
            public void requireLengthは_左にlength_右にValueObjects$equalを置いた時_lengthとequalの引数の文字数が一致しなかったら_IllegalInitialValueExceptionをスローする() {
                sut.requireLength(6, equal(VALUE));
            }
        }

        public static class lessThan extends DbzTestBase {

            @Test
            public void requireLengthは_左にlength_右にValueObjects$lessThanを置いた時_lessThanがnullを受け取ったら_nullを返す() {
                assertThat(sut.requireLength(5, lessThan((RString) null)), is(nullValue()));
            }

            @Test(expected = IllegalArgumentException.class)
            public void requireLengthは_左にlength_右にValueObjects$lessThanを置いた時_lengthに1より小さい数値を受け取ったら_IllegalArgumentExceptionをスローする() {
                assertThat(sut.requireLength(0, lessThan(VALUE)), is(VALUE));
            }

            @Test
            public void requireLengthは_左にlength_右にValueObjects$lessThanを置いた時_lengthがlessThanの引数の文字数より小さければ_lessThanの引数を返す() {
                assertThat(sut.requireLength(1, lessThan(VALUE)), is(VALUE));
            }

            @Test(expected = IllegalInitialValueException.class)
            public void requireLengthは_左にlength_右にValueObjects$lessThanを置いた時_lengthがlessThanの引数の文字数と一致したら_IllegalInitialValueExceptionをスローする() {
                sut.requireLength(5, lessThan(VALUE));
            }

            @Test(expected = IllegalInitialValueException.class)
            public void requireLengthは_左にlength_右にValueObjects$lessThanを置いた時_lengthがlessThanの引数の文字数より大きければ_IllegalInitialValueExceptionをスローする() {
                sut.requireLength(6, lessThan(VALUE));
            }
        }

        public static class lessOrEqual extends DbzTestBase {

            @Test
            public void requireLengthは_左にlength_右にValueObjects$lessOrEqualを置いた時_lessOrEqualがnullを受け取ったら_nullを返す() {
                assertThat(sut.requireLength(5, lessOrEqual((RString) null)), is(nullValue()));
            }

            @Test(expected = IllegalArgumentException.class)
            public void requireLengthは_左にlength_右にValueObjects$lessOrEqualを置いた時_lengthに0より小さい数値を受け取ったら_IllegalArgumentExceptionをスローする() {
                assertThat(sut.requireLength(-1, lessThan(VALUE)), is(VALUE));
            }

            @Test
            public void requireLengthは_左にlength_右にValueObjects$lessOrEqualを置いた時_lengthがlessOrEqualの引数の文字数より小さければ_lessOrEqualの引数を返す() {
                assertThat(sut.requireLength(0, lessOrEqual(VALUE)), is(VALUE));
            }

            @Test
            public void requireLengthは_左にlength_右にValueObjects$lessOrEqualを置いた時_lengthがlessOrEqualの引数の文字数と一致したら_lessOrEqualの引数を返す() {
                assertThat(sut.requireLength(5, lessOrEqual(VALUE)), is(VALUE));
            }

            @Test(expected = IllegalInitialValueException.class)
            public void requireLengthは_左にlength_右にValueObjects$lessOrEqualを置いた時_lengthがlessOrEqualの引数の文字数より大きければ_IllegalInitialValueExceptionをスローする() {
                sut.requireLength(6, lessOrEqual(VALUE));
            }
        }
    }

    @RunWith(Enclosed.class)
    public static class requireLength_lengthBase_ValueObject extends DbzTestBase {

        private static final IValueObject<RString> VALUE;

        static {
            VALUE = mock(IValueObject.class);
            when(VALUE.value()).thenReturn(new RString("12345"));
        }

        public static class equal extends DbzTestBase {

            @Test
            public void requireLengthは_左にlength_右にValueObjects$equalを置いた時_equalがnullを受け取ったら_nullを返す() {
                assertThat(sut.requireLength(5, equal((IValueObject<RString>) null)), is(nullValue()));
            }

            @Test(expected = IllegalArgumentException.class)
            public void requireLengthは_左にlength_右にValueObjects$equalを置いた時_lengthに0より小さい数値を受け取ったら_IllegalArgumentExceptionをスローする() {
                assertThat(sut.requireLength(-1, equal(VALUE)), is(VALUE));
            }

            @Test
            public void requireLengthは_左にlength_右にValueObjects$equalを置いた時_lengthとequalの引数の保持する文字列の文字数が一致したら_equalの引数を返す() {
                assertThat(sut.requireLength(5, equal(VALUE)), is(VALUE));
            }

            @Test(expected = IllegalInitialValueException.class)
            public void requireLengthは_左にlength_右にValueObjects$equalを置いた時_lengthとequalの引数の保持する文字列の文字数が一致しなかったら_IllegalInitialValueExceptionをスローする() {
                sut.requireLength(6, equal(VALUE));
            }
        }

        public static class lessThan extends DbzTestBase {

            @Test
            public void requireLengthは_左にlength_右にValueObjects$lessThanを置いた時_lessThanがnullを受け取ったら_nullを返す() {
                assertThat(sut.requireLength(4, lessThan((IValueObject<RString>) null)), is(nullValue()));
            }

            @Test(expected = IllegalArgumentException.class)
            public void requireLengthは_左にlength_右にValueObjects$lessThanを置いた時_lengthに1より小さい数値を受け取ったら_IllegalArgumentExceptionをスローする() {
                assertThat(sut.requireLength(0, lessThan(VALUE)), is(VALUE));
            }

            @Test
            public void requireLengthは_左にlength_右にValueObjects$lessThanを置いた時_lengthがlessThanの引数保持する文字列の文字数より小さければ_lessThanの引数を返す() {
                assertThat(sut.requireLength(1, lessThan(VALUE)), is(VALUE));
            }

            @Test(expected = IllegalInitialValueException.class)
            public void requireLengthは_左にlength_右にValueObjects$lessThanを置いた時_lengthがlessThanの引数の保持する文字列の文字数と一致したら_IllegalInitialValueExceptionをスローする() {
                sut.requireLength(5, lessThan(VALUE));
            }

            @Test(expected = IllegalInitialValueException.class)
            public void requireLengthは_左にlength_右にValueObjects$lessThanを置いた時_lengthがlessThanの引数の保持する文字列の文字数より大きければ_IllegalInitialValueExceptionをスローする() {
                sut.requireLength(6, lessThan(VALUE));
            }
        }

        public static class lessOrEqual extends DbzTestBase {

            @Test
            public void requireLengthは_左にlength_右にValueObjects$lessOrEqualを置いた時_lessOrEqualがnullを受け取ったら_nullを返す() {
                assertThat(sut.requireLength(4, lessOrEqual((IValueObject<RString>) null)), is(nullValue()));
            }

            @Test(expected = IllegalArgumentException.class)
            public void requireLengthは_左にlength_右にValueObjects$lessOrEqualを置いた時_lengthに0より小さい数値を受け取ったら_IllegalArgumentExceptionをスローする() {
                assertThat(sut.requireLength(-1, lessOrEqual(VALUE)), is(VALUE));
            }

            @Test
            public void requireLengthは_左にlength_右にValueObjects$lessOrEqualを置いた時_lengthがlessOrEqualの引数の保持する文字列の文字数より小さければ_lessOrEqualの引数を返す() {
                assertThat(sut.requireLength(0, lessOrEqual(VALUE)), is(VALUE));
            }

            @Test
            public void requireLengthは_左にlength_右にValueObjects$lessOrEqualを置いた時_lengthがlessOrEqualの引数の保持する文字列の文字数と一致したら_lessOrEqualの引数を返す() {
                assertThat(sut.requireLength(5, lessOrEqual(VALUE)), is(VALUE));
            }

            @Test(expected = IllegalInitialValueException.class)
            public void requireLengthは_左にlength_右にValueObjects$lessOrEqualを置いた時_lengthがlessOrEqualの引数の保持する文字列の文字数より大きければ_IllegalInitialValueExceptionをスローする() {
                sut.requireLength(6, lessOrEqual(VALUE));
            }
        }
    }

    public static class ILengthOfValueMatcherTest extends DbzTestBase {

        @Test(expected = IllegalArgumentException.class)
        public void equalは_lengthに0より小さい数値を受け取ったら_IllegalArgumentExceptionをスローする() {
            sut.equal(-1);
        }

        @Test
        public void equalは_lengthに0以上の数値を受け取ったら_ILengthOfValueMatcherを生成する() {
            assertThat(sut.equal(0), isA(ILengthOfValueMatcher.class));
        }

        @Test(expected = IllegalArgumentException.class)
        public void lessOrEqualは_lengthに0より小さい数値を受け取ったら_IllegalArgumentExceptionをスローする() {
            sut.lessOrEqual(-1);
        }

        @Test
        public void lessOrEqualは_lengthに0以上の数値を受け取ったら_ILengthOfValueMatcherを生成する() {
            assertThat(sut.lessOrEqual(0), isA(ILengthOfValueMatcher.class));
        }

        @Test(expected = IllegalArgumentException.class)
        public void lessThanは_lengthに1より小さい数値を受け取ったら_IllegalArgumentExceptionをスローする() {
            sut.lessThan(0);
        }

        @Test
        public void lessThanは_lengthに1以上の数値を受け取ったら_ILengthOfValueMatcherを生成する() {
            assertThat(sut.lessThan(1), isA(ILengthOfValueMatcher.class));
        }
    }
}
