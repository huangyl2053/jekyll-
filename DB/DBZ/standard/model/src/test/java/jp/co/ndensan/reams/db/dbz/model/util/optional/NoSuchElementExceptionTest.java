/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.model.util.optional;

import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * NoSuchElementExceptionのテストです。
 *
 * @author N3327 三浦 凌
 */
@RunWith(Enclosed.class)
public class NoSuchElementExceptionTest extends DbzTestBase {

    public NoSuchElementExceptionTest() {
    }

    public static class constructor extends DbzTestBase {

        @Test
        public void 引数なしのコントラクタは_メッセージを持たない_インスタンスを生成する() {
            NoSuchElementException sut = new NoSuchElementException();
            assertThat(sut.getMessage(), is(nullValue()));
        }

        @Test
        public void Stringの引数をとるコンストラクタは_引数のメッセージをもつ_インスタンスを生成する() {
            String message = "message";
            NoSuchElementException sut = new NoSuchElementException(message);
            assertThat(sut.getMessage(), is(message));
        }
    }
}
