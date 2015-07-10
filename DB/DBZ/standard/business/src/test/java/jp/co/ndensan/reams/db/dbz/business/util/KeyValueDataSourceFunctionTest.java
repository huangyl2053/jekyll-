/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.util;

import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import jp.co.ndensan.reams.ur.urz.definition.code.ICodeValueObject;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;
import org.junit.Before;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * {@link jp.co.ndensan.reams.db.dbz.business.util.CodeMasterToKeyValueFunction}のテストです。
 *
 * @author n8178 城間篤人
 */
@RunWith(Enclosed.class)
public class KeyValueDataSourceFunctionTest {

    private static CodeMasterToKeyValueFunction sut;

    public static class apply extends DbzTestBase {

        private ICodeValueObject input;
        private KeyValueDataSource result;

        @Before
        public void setUp() {
            sut = new CodeMasterToKeyValueFunction();

            input = mock(ICodeValueObject.class);
            when(input.toRString()).thenReturn(new RString("0128"));
            when(input.getRyakusho()).thenReturn(new RString("てすと略称"));
        }

        @Test
        public void 変換前のICodeValueObjectが返すtoRStringの結果と_変換後のKeyValueDataSourceが返すgetKeyが一致する() {
            result = sut.apply(input);
            assertThat(result.getKey(), is(input.toRString()));
        }

        @Test
        public void 変換前のICodeValueObjectが返すgetRyakushoの結果と_変換後のKeyValueDataSourceが返すgetValueが一致する() {
            result = sut.apply(input);
            assertThat(result.getValue(), is(input.getRyakusho()));
        }

    }
}
