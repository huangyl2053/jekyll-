/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.config;

import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.configvalues.ConfigValueBoolean}のテストです。
 *
 * @author n8178 城間篤人
 */
@RunWith(Enclosed.class)
public class ConfigValueBooleanTest {

    public static class perseBoolean extends DbzTestBase {

        private RString target;

        @Test
        public void 引数に_1_が指定された場合_trueが返る() {
            target = new RString("1");
            assertThat(ConfigValueBoolean.parseBoolean(target), is(true));
        }

        @Test
        public void 上記以外の場合_falseが返る() {
            target = new RString("0");
            assertThat(ConfigValueBoolean.parseBoolean(target), is(false));
        }
    }
}
