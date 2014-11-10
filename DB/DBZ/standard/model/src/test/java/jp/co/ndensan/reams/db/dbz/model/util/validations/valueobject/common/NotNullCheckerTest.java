/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.model.util.validations.valueobject.common;

import jp.co.ndensan.reams.db.dbz.model.util.validations.valueobject.common.NotNullChecker;
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
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * NotNullCheckerのテストです。
 *
 * @author N3327 三浦 凌
 */
public class NotNullCheckerTest extends DbzTestBase {
//
//    private IValueObjectCheckable<RString> sut;
//    private IValueObject<RString> value;
//    private IValueObjectInfo info;
//
//    @Before
//    public void setUp() {
//        sut = NotNullChecker.getInstance(RString.class);
//        info = new ValueObjectInfo._Builder("test").build();
//    }
//
//    @Test
//    public void isValidは_引数がnullの時_falseを返す() {
//        assertThat(sut.isValid(value), is(false));
//    }
//
//    @Test
//    public void checkは_引数がnullの時_戻り値に_ValidationMessages$必須入力項目_を含む() {
//        assertThat(sut.check(value, info).contains(ValidationMessages.必須入力項目), is(true));
//    }
//
//    @Test
//    public void isValidは_引数のvalueObject$valueがnullの時_falseを返す() {
//        value = mock(IValueObject.class);
//        when(value.value()).thenReturn(null);
//        assertThat(sut.isValid(value), is(false));
//    }
//
//    @Test
//    public void checkは_引数のvalueObject$valueがnullの時_戻り値に_ValidationMessages$必須入力項目_を含む() {
//        value = mock(IValueObject.class);
//        when(value.value()).thenReturn(null);
//        assertThat(sut.check(value, info).contains(ValidationMessages.必須入力項目), is(true));
//    }
//
//    @Test
//    public void isValidは_引数のvalueObject$valueがnullでない時_trueを返す() {
//        value = mock(IValueObject.class);
//        when(value.value()).thenReturn(new RString("value"));
//        assertThat(sut.isValid(value), is(true));
//    }
//
//    @Test
//    public void checkは_引数のvalueObject$valueがnullでない時_戻り値に_ValidationMessages$必須入力項目_を含まない() {
//        value = mock(IValueObject.class);
//        when(value.value()).thenReturn(new RString("value"));
//        assertThat(sut.check(value, info).contains(ValidationMessages.必須入力項目), is(false));
//    }
}
