/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.model.util.validations.valueobject.common;

import jp.co.ndensan.reams.db.dbz.model.util.validations.valueobject.common.NotEmptyChecker;
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
 * NotEmptyCheckerのテストです。
 *
 * @author N3327 三浦 凌
 */
@RunWith(Enclosed.class)
public class NotEmptyCheckerTest extends DbzTestBase {

    public NotEmptyCheckerTest() {
    }

    public static class RSTRING extends DbzTestBase {

        private IValueObjectCheckable<RString> sut;
        private IValueObjectInfo info;
        private IValueObject<RString> value;

        @Before
        public void setUp() {
            sut = NotEmptyChecker.forRString();
            info = new ValueObjectInfo.Builder("テスト").build();
        }

        @Test
        public void isValidは_引数がnullの時_trueを返す() {
            assertThat(sut.isValid(value), is(true));
        }

        @Test
        public void checkは_引数のvalueObjectがnullの時_戻り値に_ValidationMessages$必須入力_を含まない() {
            assertThat(sut.check(value, info).contains(ValidationMessages.必須入力項目), is(false));
        }

        @Test
        public void isValidは_引数$valueがnullを返す時_trueを返す() {
            value = mock(IValueObject.class);
            when(value.value()).thenReturn(null);
            assertThat(sut.isValid(value), is(true));
        }

        @Test
        public void checkは_引数$valueがnullを返す時_戻り値に_ValidationMessages$必須入力_を含まない() {
            value = mock(IValueObject.class);
            when(value.value()).thenReturn(null);
            assertThat(sut.check(value, info).contains(ValidationMessages.必須入力項目), is(false));
        }

        @Test
        public void isValidは_引数$valueがRString$Emptyを返す時_falseを返す() {
            value = mock(IValueObject.class);
            when(value.value()).thenReturn(RString.EMPTY);
            assertThat(sut.isValid(value), is(false));
        }

        @Test
        public void checkは_引数$valueがRString$Emptyを返す時_戻り値に_ValidationMessages$必須入力_を含む() {
            value = mock(IValueObject.class);
            when(value.value()).thenReturn(RString.EMPTY);
            assertThat(sut.check(value, info).contains(ValidationMessages.必須入力項目), is(true));
        }

        @Test
        public void isValidは_引数$valueが空文字を持つRStringを返す時_falseを返す() {
            value = mock(IValueObject.class);
            when(value.value()).thenReturn(new RString(""));
            assertThat(sut.isValid(value), is(false));
        }

        @Test
        public void checkは_引数$valueが空文字を持つRStringを返す時_戻り値に_ValidationMessages$必須入力_を含む() {
            value = mock(IValueObject.class);
            when(value.value()).thenReturn(new RString(""));
            assertThat(sut.check(value, info).contains(ValidationMessages.必須入力項目), is(true));
        }

        @Test
        public void isValidは_引数$valueがRString$Emptyでない値を返す時_trueを返す() {
            value = mock(IValueObject.class);
            when(value.value()).thenReturn(new RString("a"));
            assertThat(sut.isValid(value), is(true));
        }

        @Test
        public void checkは_引数$valueがRString$Emptyでない値を返す時_戻り値に_ValidationMessages$必須入力_を含まない() {
            value = mock(IValueObject.class);
            when(value.value()).thenReturn(new RString("a"));
            assertThat(sut.check(value, info).contains(ValidationMessages.必須入力項目), is(false));
        }
    }
}
