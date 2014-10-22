/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.model.util.validation.valueobject.rstring;

import jp.co.ndensan.reams.db.dbz.model.util.validation.valueobject.IValueObjectCheckable;
import jp.co.ndensan.reams.db.dbz.model.util.validation.valueobject.IValueObjectInfo;
import jp.co.ndensan.reams.db.dbz.model.util.validation.valueobject.ValidationMessages;
import jp.co.ndensan.reams.db.dbz.model.util.validation.valueobject.ValueObjectInfo;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.biz.IValueObject;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.isA;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Lengthのテストです。
 *
 * @author N3327 三浦 凌
 */
@RunWith(Enclosed.class)
public class LengthTest {

    private static Length sut;

    public LengthTest() {
    }

    public static class staticMethods extends DbzTestBase {

        @Test(expected = IllegalArgumentException.class)
        public void greaterOrEqualは_引数が0よりも小さい時_IllegalArgumentException() {
            sut.greaterOrEqual(-1);
        }

        @Test
        public void greaterOrEqualは_引数が0の時_Lengthのインスタンスを生成する() {
            assertThat(sut.greaterOrEqual(0), is(instanceOf(Length.class)));
        }

        @Test(expected = IllegalArgumentException.class)
        public void equalは_引数が0よりも小さい時_IllegalArgumentException() {
            sut.equal(-1);
        }

        @Test
        public void equalは_引数が0の時_Lengthのインスタンスを生成する() {
            assertThat(sut.equal(0), is(instanceOf(Length.class)));
        }

        @Test(expected = IllegalArgumentException.class)
        public void lessOrEqualは_引数が0よりも小さい時_IllegalArgumentException() {
            sut.lessOrEqual(-1);
        }

        @Test
        public void lessOrEqualは_引数が0の時_Lengthのインスタンスを生成する() {
            assertThat(sut.lessOrEqual(0), is(instanceOf(Length.class)));
        }

        @Test(expected = IllegalArgumentException.class)
        public void lessThanは_引数が0の時_IllegalArgumentException() {
            sut.lessThan(0);
        }

        @Test
        public void lessThanは_引数が1の時_Lengthのインスタンスを生成する() {
            assertThat(sut.lessOrEqual(1), is(instanceOf(Length.class)));
        }
    }

    public static class lessOrEqual extends DbzTestBase {

        private IValueObjectCheckable<RString> checker;
        private IValueObjectInfo info;
        private IValueObject<RString> value;
        private int length;

        @Before
        public void setUp() {
            length = 10;
            checker = sut.lessOrEqual(length);
            info = new ValueObjectInfo.Builder("テスト").build();
        }

        @Test
        public void lessOrEqualで取得したインスタンスの_isValidは_引数がnullの時_trueを返す() {
            assertThat(checker.isValid(value), is(true));
        }

        @Test
        public void lessOrEqualで取得したインスタンスの_checkは_引数がnullの時_戻り値に_ValidationMessages$指定文字数以下_を含まない() {
            assertThat(checker.check(value, info).contains(ValidationMessages.指定文字数以下), is(false));
        }

        @Test
        public void lessOrEqualで取得したインスタンスの_isValidは_引数のvalueObject$valueがnullを返す時_trueを返す() {
            value = mock(IValueObject.class);
            when(value.value()).thenReturn(null);
            assertThat(checker.isValid(value), is(true));
        }

        @Test
        public void lessOrEqualで取得したインスタンスの_checkは_引数のvalueObject$valueがnullを返す時_戻り値に_ValidationMessages$指定文字数以下_を含まない() {
            value = mock(IValueObject.class);
            when(value.value()).thenReturn(null);
            assertThat(checker.check(value, info).contains(ValidationMessages.指定文字数以下), is(false));
        }

        @Test
        public void lessOrEqualで取得したインスタンスの_isValidは_引数のvalueObject$valueがlessOrEqualの引数の値より長い時_falseを返す() {
            value = mock(IValueObject.class);
            when(value.value()).thenReturn(new RString("12345678901"));
            assertThat(checker.isValid(value), is(false));
        }

        @Test
        public void lessOrEqualで取得したインスタンスの_checkは_引数のvalueObject$valueがlessOrEqualの引数の値より長い時_戻り値に_ValidationMessages$指定文字数以下_を含む() {
            value = mock(IValueObject.class);
            when(value.value()).thenReturn(new RString("12345678901"));
            assertThat(checker.check(value, info).contains(ValidationMessages.指定文字数以下), is(true));
        }

        @Test
        public void lessOrEqualで取得したインスタンスの_isValidは_引数のvalueObject$valueがlessOrEqualの引数の値と同じ長さの時_trueを返す() {
            value = mock(IValueObject.class);
            when(value.value()).thenReturn(new RString("1234567890"));
            assertThat(checker.isValid(value), is(true));
        }

        @Test
        public void lessOrEqualで取得したインスタンスの_checkは_引数のvalueObject$valueがlessOrEqualの引数の値と同じ長さの時_戻り値に_ValidationMessages$指定文字数以下_を含まない() {
            value = mock(IValueObject.class);
            when(value.value()).thenReturn(new RString("1234567890"));
            assertThat(checker.check(value, info).contains(ValidationMessages.指定文字数以下), is(false));
        }

        @Test
        public void lessOrEqualで取得したインスタンスの_isValidは_引数のvalueObject$valueがlessOrEqualの引数の値より短い時_trueを返す() {
            value = mock(IValueObject.class);
            when(value.value()).thenReturn(new RString("123456789"));
            assertThat(checker.isValid(value), is(true));
        }

        @Test
        public void lessOrEqualで取得したインスタンスの_checkは_引数のvalueObject$valueがlessOrEqualの引数の値より短い時_戻り値に_ValidationMessages$指定文字数以下_を含まない() {
            value = mock(IValueObject.class);
            when(value.value()).thenReturn(new RString("123456789"));
            assertThat(checker.check(value, info).contains(ValidationMessages.指定文字数以下), is(false));
        }
    }

    public static class lessThan extends DbzTestBase {

        private IValueObjectCheckable<RString> checker;
        private IValueObjectInfo info;
        private IValueObject<RString> value;
        private int length;

        @Before
        public void setUp() {
            length = 10;
            checker = sut.lessThan(length);
            info = new ValueObjectInfo.Builder("テスト").build();
        }

        @Test
        public void lessThanで取得したインスタンスの_isValidは_引数がnullの時_trueを返す() {
            assertThat(checker.isValid(value), is(true));
        }

        @Test
        public void lessThanで取得したインスタンスの_isValidは_引数のvalueObject$valueがnullを返す時_trueを返す() {
            value = mock(IValueObject.class);
            when(value.value()).thenReturn(null);
            assertThat(checker.isValid(value), is(true));
        }

        @Test
        public void lessThanで取得したインスタンスの_isValidは_引数のvalueObject$valueがlessThanの引数の値より長い時_falseを返す() {
            value = mock(IValueObject.class);
            when(value.value()).thenReturn(new RString("12345678901"));
            assertThat(checker.isValid(value), is(false));
        }

        @Test
        public void lessThanで取得したインスタンスの_checkは_引数のvalueObject$valueがlessThanの引数の値より長い時_戻り値に_ValidationMessages$指定文字数未満_を含む() {
            value = mock(IValueObject.class);
            when(value.value()).thenReturn(new RString("12345678901"));
            assertThat(checker.check(value, info).contains(ValidationMessages.指定文字数未満), is(true));
        }

        @Test
        public void lessThanで取得したインスタンスの_isValidは_引数のvalueObject$valueがlessThanの引数の値と同じ長さの時_falseを返す() {
            value = mock(IValueObject.class);
            when(value.value()).thenReturn(new RString("1234567890"));
            assertThat(checker.isValid(value), is(false));
        }

        @Test
        public void lessThanで取得したインスタンスの_checkは_引数のvalueObject$valueがlessThanの引数の値と同じ長さの時_戻り値に_ValidationMessages$指定文字数未満_を含む() {
            value = mock(IValueObject.class);
            when(value.value()).thenReturn(new RString("1234567890"));
            assertThat(checker.check(value, info).contains(ValidationMessages.指定文字数未満), is(true));
        }

        @Test
        public void lessThanで取得したインスタンスの_isValidは_引数のvalueObject$valueがlessThanの引数の値より短い時_trueを返す() {
            value = mock(IValueObject.class);
            when(value.value()).thenReturn(new RString("123456789"));
            assertThat(checker.isValid(value), is(true));
        }

        @Test
        public void lessThanで取得したインスタンスの_checkは_引数のvalueObject$valueがlessThanの引数の値より短い時_戻り値に_ValidationMessages$指定文字数未満_を含まない() {
            value = mock(IValueObject.class);
            when(value.value()).thenReturn(new RString("123456789"));
            assertThat(checker.check(value, info).contains(ValidationMessages.指定文字数未満), is(false));
        }
    }

    public static class equal extends DbzTestBase {

        private IValueObjectCheckable<RString> checker;
        private IValueObjectInfo info;
        private IValueObject<RString> value;
        private int length;

        @Before
        public void setUp() {
            length = 10;
            checker = sut.equal(length);
            info = new ValueObjectInfo.Builder("テスト").build();
        }

        @Test
        public void equalで取得したインスタンスの_isValidは_引数がnullの時_trueを返す() {
            assertThat(checker.isValid(value), is(true));
        }

        @Test
        public void equalで取得したインスタンスの_isValidは_引数のvalueObject$valueがnullを返す時_trueを返す() {
            value = mock(IValueObject.class);
            when(value.value()).thenReturn(null);
            assertThat(checker.isValid(value), is(true));
        }

        @Test
        public void equalで取得したインスタンスの_isValidは_引数のvalueObject$valueがequalの引数の値より長い時_falseを返す() {
            value = mock(IValueObject.class);
            when(value.value()).thenReturn(new RString("12345678901"));
            assertThat(checker.isValid(value), is(false));
        }

        @Test
        public void equalで取得したインスタンスの_checkは_引数のvalueObject$valueがequalの引数の値より長い時_戻り値に_ValidationMessages$指定文字数と一致_を含む() {
            value = mock(IValueObject.class);
            when(value.value()).thenReturn(new RString("12345678901"));
            assertThat(checker.check(value, info).contains(ValidationMessages.指定文字数と一致), is(true));
        }

        @Test
        public void equalで取得したインスタンスの_isValidは_引数のvalueObject$valueがequalの引数の値と同じ長さの時_trueを返す() {
            value = mock(IValueObject.class);
            when(value.value()).thenReturn(new RString("1234567890"));
            assertThat(checker.isValid(value), is(true));
        }

        @Test
        public void equalで取得したインスタンスの_checkは_引数のvalueObject$valueがequalの引数の値と同じ長さの時_戻り値に_ValidationMessages$指定文字数と一致_を含まない() {
            value = mock(IValueObject.class);
            when(value.value()).thenReturn(new RString("1234567890"));
            assertThat(checker.check(value, info).contains(ValidationMessages.指定文字数と一致), is(false));
        }

        @Test
        public void equalで取得したインスタンスの_isValidは_引数のvalueObject$valueがequalの引数の値より短い時_falseを返す() {
            value = mock(IValueObject.class);
            when(value.value()).thenReturn(new RString("123456789"));
            assertThat(checker.isValid(value), is(false));
        }

        @Test
        public void equalで取得したインスタンスの_checkは_引数のvalueObject$valueがequalの引数の値より短い時_戻り値に_ValidationMessages$指定文字数と一致_を含む() {
            value = mock(IValueObject.class);
            when(value.value()).thenReturn(new RString("123456789"));
            assertThat(checker.check(value, info).contains(ValidationMessages.指定文字数と一致), is(true));
        }
    }

    public static class greaterOrEqual extends DbzTestBase {

        private IValueObjectCheckable<RString> checker;
        private IValueObjectInfo info;
        private IValueObject<RString> value;
        private int length;

        @Before
        public void setUp() {
            length = 10;
            checker = sut.greaterOrEqual(length);
            info = new ValueObjectInfo.Builder("テスト").build();
        }

        @Test
        public void greaterOrEqualで取得したインスタンスの_isValidは_引数がnullの時_trueを返す() {
            assertThat(checker.isValid(value), is(true));
        }

        @Test
        public void greaterOrEqualで取得したインスタンスの_isValidは_引数のvalueObject$valueがnullを返す時_trueを返す() {
            value = mock(IValueObject.class);
            when(value.value()).thenReturn(null);
            assertThat(checker.isValid(value), is(true));
        }

        @Test
        public void greaterOrEqualで取得したインスタンスの_isValidは_引数のvalueObject$valueがgreaterOrEqualの引数の値より長い時_trueを返す() {
            value = mock(IValueObject.class);
            when(value.value()).thenReturn(new RString("12345678901"));
            assertThat(checker.isValid(value), is(true));
        }

        @Test
        public void greaterOrEqualで取得したインスタンスの_checkは_引数のvalueObject$valueがgreaterOrEqualの引数の値より長い時_戻り値に_ValidationMessages$指定文字数以上_を含まない() {
            value = mock(IValueObject.class);
            when(value.value()).thenReturn(new RString("12345678901"));
            assertThat(checker.check(value, info).contains(ValidationMessages.指定文字数以上), is(false));
        }

        @Test
        public void greaterOrEqualで取得したインスタンスの_isValidは_引数のvalueObject$valueがgreaterOrEqualの引数の値と同じ長さの時_trueを返す() {
            value = mock(IValueObject.class);
            when(value.value()).thenReturn(new RString("1234567890"));
            assertThat(checker.isValid(value), is(true));
        }

        @Test
        public void greaterOrEqualで取得したインスタンスの_checkは_引数のvalueObject$valueがgreaterOrEqualの引数の値と同じ長さの時_戻り値に_ValidationMessages$指定文字数以上_を含まない() {
            value = mock(IValueObject.class);
            when(value.value()).thenReturn(new RString("1234567890"));
            assertThat(checker.check(value, info).contains(ValidationMessages.指定文字数以上), is(false));
        }

        @Test
        public void greaterOrEqualで取得したインスタンスの_isValidは_引数のvalueObject$valueがgreaterOrEqualの引数の値より短い時_falseを返す() {
            value = mock(IValueObject.class);
            when(value.value()).thenReturn(new RString("123456789"));
            assertThat(checker.isValid(value), is(false));
        }

        @Test
        public void greaterOrEqualで取得したインスタンスの_checkは_引数のvalueObject$valueがgreaterOrEqualの引数の値より短い時_戻り値に_ValidationMessages$指定文字数以上_を含む() {
            value = mock(IValueObject.class);
            when(value.value()).thenReturn(new RString("123456789"));
            assertThat(checker.check(value, info).contains(ValidationMessages.指定文字数以上), is(true));
        }
    }
}
