/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.definition.core.util;

import jp.co.ndensan.reams.uz.uza.biz.IValueObject;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * {@link ValueObjects}のテストです。
 */
@RunWith(Enclosed.class)
public class ValueObjectsTest {

    public ValueObjectsTest() {
    }

    public static class valueOrDefault {

        @Test
        public void testValueOrDefault() {
            RString defaultValue = new RString("2");
            assertThat(ValueObjects.valueOrDefault(null, defaultValue), is(defaultValue));
        }

        @Test
        public void testValueOrDefault2() {
            IValueObject<RString> vo = mock(IValueObject.class);
            RString value = new RString("2");
            when(vo.value()).thenReturn(value);
            assertThat(ValueObjects.valueOrDefault(vo, RString.EMPTY), is(value));
        }
    }

    public static class valueOrRStringEMPTY {

        @Test
        public void testValueOrRStringEMPTY() {
            assertThat(ValueObjects.valueOrRStringEMPTY(null), is(RString.EMPTY));
        }

        @Test
        public void testValueOrRStringEMPTY2() {
            IValueObject<RString> vo = mock(IValueObject.class);
            RString value = new RString("2");
            when(vo.value()).thenReturn(value);
            assertThat(ValueObjects.valueOrRStringEMPTY(vo), is(value));
        }
    }

}
