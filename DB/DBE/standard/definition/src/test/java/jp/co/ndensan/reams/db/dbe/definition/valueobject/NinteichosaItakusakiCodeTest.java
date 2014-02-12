/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.valueobject;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.testhelper.TestBase;
import static org.hamcrest.CoreMatchers.is;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * 認定調査委託先コードを表すクラスのテストです。
 *
 * @author n8178 城間篤人
 */
@RunWith(Enclosed.class)
public class NinteichosaItakusakiCodeTest extends TestBase {

    private static NinteichosaItakusakiCode sut;

    public static class コンストラクタのテスト {

        @Test(expected = NullPointerException.class)
        public void nullが渡されたとき_NullPinterExceptionが発生する() {
            sut = new NinteichosaItakusakiCode(null);
        }
    }

    public static class equalsのテスト {

        @Test
        public void 引数にnullを渡すと_falseが返る() {
            sut = new NinteichosaItakusakiCode(new RString("A001"));
            assertThat(sut.equals(null), is(false));
        }

        @Test
        public void 引数にNinteichosaItakusakiCode以外の型を渡すと_falseが返る() {
            sut = new NinteichosaItakusakiCode(new RString("A001"));
            RString 比較対象 = new RString("A001");
            assertThat(sut.equals(比較対象), is(false));
        }

        @Test
        public void メンバの内容が同一の_NinteichosaItakusakiCode型のクラスを渡したとき_trueが返る() {
            sut = new NinteichosaItakusakiCode(new RString("A001"));
            NinteichosaItakusakiCode 比較対象 = new NinteichosaItakusakiCode(new RString("A001"));
            assertThat(sut.equals(比較対象), is(true));
        }

        @Test
        public void メンバの内容が違う_NinteichosaItakusakiCode型のクラスを渡したとき_falseが返る() {
            sut = new NinteichosaItakusakiCode(new RString("A001"));
            NinteichosaItakusakiCode 比較対象 = new NinteichosaItakusakiCode(new RString("B001"));
            assertThat(sut.equals(比較対象), is(false));
        }
    }

    public static class hashCodeのテスト {

        @Test
        public void メンバの内容が同一の_NinteichosaItakusakiCode型のクラスを渡したとき_hashCodeの値が同じになる() {
            sut = new NinteichosaItakusakiCode(new RString("A001"));
            NinteichosaItakusakiCode 比較対象 = new NinteichosaItakusakiCode(new RString("A001"));
            assertThat(sut.hashCode(), is(比較対象.hashCode()));
        }
    }
}
