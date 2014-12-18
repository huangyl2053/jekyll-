/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.util.function;

import jp.co.ndensan.reams.db.dbz.definition.util.function.ExceptionSuppliers;
import jp.co.ndensan.reams.db.dbz.definition.util.function.ISupplier;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.SystemException;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.isA;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * ExceptionSuppliersのテストです。
 *
 * @author N3327 三浦 凌
 */
@RunWith(Enclosed.class)
public class ExceptionSuppliersTest extends DbzTestBase {

    private static ExceptionSuppliers sut;

    public ExceptionSuppliersTest() {
    }

    public static class nullPointerException extends DbzTestBase {

        @Test
        public void nullPointerException_で生成したsupplierからは_NullPointerExceptionを取得できる() {
            assertThat(sut.nullPointerException().get(), isA(NullPointerException.class));
        }

        @Test
        public void nullPointerException_引数有り_で生成したsupplierからは_引数の文字列をメッセージに持った_NullPointerExceptionを取得できる() {
            String message = "message";
            NullPointerException created = sut.nullPointerException(message).get();
            assertThat(created.getMessage(), is(message));
        }
    }

    public static class applicationException extends DbzTestBase {

        private final String MESSAGE = "message";
        private ISupplier<ApplicationException> created;

        @Before
        public void setUp() {
            created = sut.applicationException(MESSAGE);
        }

        @Test
        public void applicationException_で生成したsupplierからは_ApplicationExceptionを取得できる() {
            assertThat(created.get(), isA(ApplicationException.class));
        }

        @Test
        public void applicationException_で生成したsupplierから取得したApplicationExceptionは_引数の文字列をメッセージに持つ() {
            assertThat(created.get().getMessage(), is(MESSAGE));
        }
    }

    public static class systemException extends DbzTestBase {

        private final String MESSAGE = "message";
        private ISupplier<SystemException> created;

        @Before
        public void setUp() {
            created = sut.systemException(MESSAGE);
        }

        @Test
        public void systemException_で生成したsupplierからは_SystemExceptionを取得できる() {
            assertThat(created.get(), isA(SystemException.class));
        }

        @Test
        public void systemException_で生成したsupplierから取得したSystemExceptionは_引数の文字列をメッセージに持つ() {
            assertThat(created.get().getMessage(), is(MESSAGE));
        }
    }
}
