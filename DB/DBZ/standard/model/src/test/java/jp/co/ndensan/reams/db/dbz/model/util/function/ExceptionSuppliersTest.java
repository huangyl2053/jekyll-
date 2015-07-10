/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.model.util.function;

import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.isA;
import org.junit.Test;
import static org.junit.Assert.*;
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
        public void nullPointerException_で生成したsupplierは_NullPointerExceptionを生成する() {
            assertThat(sut.nullPointerException().get(), isA(NullPointerException.class));
        }

        @Test
        public void nullPointerException$withMessage_で生成したsupplierは_withMessageの引数を持った_NullPointerExceptionを生成する() {
            String message = "message";
            NullPointerException created = sut.nullPointerException().withMessage(message).get();
            assertThat(created.getMessage(), is(message));
        }
    }
}
