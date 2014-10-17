/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.valueobject.util;

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

}
