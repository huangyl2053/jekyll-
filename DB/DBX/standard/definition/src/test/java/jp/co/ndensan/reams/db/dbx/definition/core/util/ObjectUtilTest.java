/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.definition.core.util;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link ObjectUtil}のテストです。
 */
@RunWith(Enclosed.class)
public class ObjectUtilTest {

    public ObjectUtilTest() {
    }

    public static class defaultIfNull {

        @Test
        public void testDefaultIfNull() {
            assertThat(ObjectUtil.defaultIfNull(null, RString.EMPTY), is(RString.EMPTY));
        }

        @Test
        public void testDefaultIfNull2() {
            assertThat(ObjectUtil.defaultIfNull(RString.EMPTY, new RString("EMPTY")), is(RString.EMPTY));
        }
    }
}
