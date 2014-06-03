/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.valueobject;

import jp.co.ndensan.reams.db.dbz.testhelper.DbeTestBase;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import org.junit.Before;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * 合議体長区分コードのテストです。
 *
 * @author n8178 城間篤人
 */
@RunWith(Enclosed.class)
public class GogitaichoKubunCodeTest {

    private static GogitaichoKubunCode sut;
    private static GogitaichoKubunCode sut2;

    public static class コンストラクタのテスト extends DbeTestBase {

        @Test(expected = NullPointerException.class)
        public void 引数にnullを渡したとき_NullPointerExceptionが発生する() {
            sut = new GogitaichoKubunCode(null);
        }
    }

    public static class compareToのテスト extends DbeTestBase {

        @Before
        public void setUp() {
            sut = new GogitaichoKubunCode(new Code("gogitaicho01"));
        }

        @Test
        public void 比較対象のほうが大きい場合_結果が0より小さくなる() {
            sut2 = new GogitaichoKubunCode(new Code("gogitaicho02"));
            assertThat(sut.compareTo(sut2) < 0, is(true));
        }

        @Test
        public void 比較対象と同じ値の場合_結果が0になる() {
            sut2 = new GogitaichoKubunCode(new Code("gogitaicho01"));
            assertThat(sut.compareTo(sut2) == 0, is(true));
        }

        @Test
        public void 比較対象のほうが小さい場合_結果が0より大きくなる() {
            sut2 = new GogitaichoKubunCode(new Code("gogitaicho00"));
            assertThat(0 < sut.compareTo(sut2), is(true));
        }
    }

    public static class equalsのテスト extends DbeTestBase {

        @Before
        public void setUp() {
            sut = new GogitaichoKubunCode(new Code("12"));
        }

        @Test
        public void nullが渡されたとき_falseが返る() {
            assertThat(sut.equals(null), is(false));
        }

        @Test
        public void 型の違うインスタンスが渡されたとき_falseが返る() {
            assertThat(sut.equals(new RString("12")), is(false));
        }

        @Test
        public void 値が一致しないインスタンスが渡されたとき_falseが返る() {
            sut2 = new GogitaichoKubunCode(new Code("22"));
            assertThat(sut.equals(sut2), is(false));
        }

        @Test
        public void 値が一致するインスタンスが渡されたとき_trueが返る() {
            sut2 = new GogitaichoKubunCode(new Code("12"));
            assertThat(sut.equals(sut2), is(true));
        }
    }

    public static class hashCodeのテスト extends DbeTestBase {

        @Test
        public void 値が一致するインスタンスのhashCodeは_同値になる() {
            sut = new GogitaichoKubunCode(new Code("12"));
            sut2 = new GogitaichoKubunCode(new Code("12"));
            assertThat(sut.hashCode(), is(sut2.hashCode()));
        }
    }
}
