/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.model.util.validations.valueobject.rstring;

import jp.co.ndensan.reams.db.dbz.model.util.validations.valueobject.IValueObjectCheckable;
import jp.co.ndensan.reams.db.dbz.model.util.validations.valueobject.IValueObjectInfo;
import jp.co.ndensan.reams.db.dbz.model.util.validations.valueobject.ValidationMessages;
import jp.co.ndensan.reams.db.dbz.model.util.validations.valueobject.ValueObjectInfo;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.biz.IValueObject;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * CharTypeのテストです。
 *
 * @author N3327 三浦 凌
 */
@RunWith(Enclosed.class)
public class CharTypeTest {

    public CharTypeTest() {
    }

    public static class 半角数のみ extends DbzTestBase {

        private IValueObjectCheckable<RString> sut;
        private IValueObjectInfo info;
        private IValueObject<RString> value;

        @Before
        public void setUp() {
            sut = CharType.半角数のみ;
            info = new ValueObjectInfo.Builder("テスト").build();
        }

        @Test
        public void isValidは_引数がnullの時_trueを返す() {
            assertThat(sut.isValid(value), is(true));
        }

        @Test
        public void checkは_引数のvalueObjectがnullの時_戻り値に_ValidationMessages$半角数のみ_を含まない() {
            assertThat(sut.check(value, info).contains(ValidationMessages.半角数のみ), is(false));
        }

        @Test
        public void isValidは_引数$valueがnullを返す時_trueを返す() {
            value = mock(IValueObject.class);
            when(value.value()).thenReturn(null);
            assertThat(sut.isValid(value), is(true));
        }

        @Test
        public void checkは_引数$valueがnullを返す時_戻り値に_ValidationMessages$半角数のみ_を含まない() {
            value = mock(IValueObject.class);
            when(value.value()).thenReturn(null);
            assertThat(sut.check(value, info).contains(ValidationMessages.半角数のみ), is(false));
        }

        @Test
        public void isValidは_引数が半角数のみの時_trueを返す() {
            value = mock(IValueObject.class);
            when(value.value()).thenReturn(new RString("12345"));
            assertThat(sut.isValid(value), is(true));
        }

        @Test
        public void checkは_引数が半角数のみの時_戻り値に_ValidationMessages$半角数のみ_を含まない() {
            value = mock(IValueObject.class);
            when(value.value()).thenReturn(new RString("12345"));
            assertThat(sut.check(value, info).contains(ValidationMessages.半角数のみ), is(false));
        }

        @Test
        public void isValidは_引数が半角数以外を含む時_falseを返す() {
            value = mock(IValueObject.class);
            when(value.value()).thenReturn(new RString("a12345"));
            assertThat(sut.isValid(value), is(false));
        }

        @Test
        public void checkは_引数が半角数以外を含む時_戻り値に_ValidationMessages$半角数のみ_を含む() {
            value = mock(IValueObject.class);
            when(value.value()).thenReturn(new RString("a12345"));
            assertThat(sut.check(value, info).contains(ValidationMessages.半角数のみ), is(true));
        }
    }

    public static class 半角英数のみ extends DbzTestBase {

        private IValueObjectCheckable<RString> sut;
        private IValueObjectInfo info;
        private IValueObject<RString> value;

        @Before
        public void setUp() {
            sut = CharType.半角英数のみ;
            info = new ValueObjectInfo.Builder("テスト").build();
        }

        @Test
        public void isValidは_引数がnullの時_trueを返す() {
            assertThat(sut.isValid(value), is(true));
        }

        @Test
        public void checkは_引数のvalueObjectがnullの時_戻り値に_ValidationMessages$半角英数のみ_を含まない() {
            assertThat(sut.check(value, info).contains(ValidationMessages.半角英数のみ), is(false));
        }

        @Test
        public void isValidは_引数$valueがnullを返す時_trueを返す() {
            value = mock(IValueObject.class);
            when(value.value()).thenReturn(null);
            assertThat(sut.isValid(value), is(true));
        }

        @Test
        public void checkは_引数$valueがnullを返す時_戻り値に_ValidationMessages$半角英数のみ_を含まない() {
            value = mock(IValueObject.class);
            when(value.value()).thenReturn(null);
            assertThat(sut.check(value, info).contains(ValidationMessages.半角英数のみ), is(false));
        }

        @Test
        public void isValidは_引数が半角英数のみの時_trueを返す() {
            value = mock(IValueObject.class);
            when(value.value()).thenReturn(new RString("a12345"));
            assertThat(sut.isValid(value), is(true));
        }

        @Test
        public void checkは_引数が半角英数のみの時_戻り値に_ValidationMessages$半角英数のみ_を含まない() {
            value = mock(IValueObject.class);
            when(value.value()).thenReturn(new RString("a12345"));
            assertThat(sut.check(value, info).contains(ValidationMessages.半角英数のみ), is(false));
        }

        @Test
        public void isValidは_引数が半角英数以外を含む時_falseを返す() {
            value = mock(IValueObject.class);
            when(value.value()).thenReturn(new RString("１2345"));
            assertThat(sut.isValid(value), is(false));
        }

        @Test
        public void checkは_引数が半角英数以外を含む時_戻り値に_ValidationMessages$半角英数のみ_を含む() {
            value = mock(IValueObject.class);
            when(value.value()).thenReturn(new RString("１2345"));
            assertThat(sut.check(value, info).contains(ValidationMessages.半角英数のみ), is(true));
        }
    }
}
