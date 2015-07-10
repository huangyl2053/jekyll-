/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.util.function;

import jp.co.ndensan.reams.db.dbz.definition.util.function.Functions;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import static org.hamcrest.CoreMatchers.isA;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * Functionsのテストです。
 *
 * @author N3327 三浦 凌
 */
@RunWith(Enclosed.class)
public class FunctionsTest extends DbzTestBase {

    public FunctionsTest() {
    }

    public static class to extends DbzTestBase {

        private Functions sut;

        @Test
        public void Stringを引数としたto_から生成したFunctionは_StringのオブジェクトをStringへ変換できる() {
            assertThat(sut.to(String.class).apply("1"), isA(String.class));
        }

        @Test
        public void CharSequenceを引数としたto_から生成したFucntionは_StringのオブジェクトをCharSequenceへ変換できる() {
            assertThat(sut.to(CharSequence.class).apply("1"), isA(CharSequence.class));
        }
    }

    public static class toParent extends DbzTestBase {

        private Functions sut;

        @Test
        public void Stringを引数としたtoParent_から生成したFunctionは_StringのオブジェクトをStringへ変換できる() {
            assertThat(sut.toParent(String.class).apply("1"), isA(String.class));
        }

        @Test
        public void CharSequenceを引数としたtoParent_から生成したFucntionは_StringのオブジェクトをCharSequenceへ変換できる() {
            assertThat(sut.toParent(CharSequence.class).apply("1"), isA(CharSequence.class));
        }
    }

    public static class childToParent extends DbzTestBase {

        private Functions sut;

        @Test
        public void childToParent_から生成したFucntionは_あるオブジェクトを親の型へ変換できる() {
            assertThat(sut.<String, CharSequence>childToParent().apply("1"), isA(CharSequence.class));
        }
    }
}
