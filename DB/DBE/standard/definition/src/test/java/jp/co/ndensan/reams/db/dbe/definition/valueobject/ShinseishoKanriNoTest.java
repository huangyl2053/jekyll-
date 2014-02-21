/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.valueobject;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.testhelper.TestBase;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * 申請書管理番号を表すクラスのテストです。
 *
 * @author n8178 城間篤人
 */
@RunWith(Enclosed.class)
public class ShinseishoKanriNoTest extends TestBase {

    private static ShinseishoKanriNo sut;

    public static class コンストラクタのテスト {

        @Test(expected = NullPointerException.class)
        public void nullが渡されたとき_NullPointerExceptionが発生する() {
            sut = new ShinseishoKanriNo(null);
        }
    }

    public static class equalsのテスト {

        @Test
        public void 引数にnullを渡すと_falseが返る() {
            sut = new ShinseishoKanriNo(new RString("A001"));
            assertThat(sut.equals(null), is(false));
        }

        @Test
        public void 引数にShinseishoKanriNo以外の型を渡すと_falseが返る() {
            sut = new ShinseishoKanriNo(new RString("A001"));
            RString 比較対象 = new RString("A001");
            assertThat(sut.equals(比較対象), is(false));
        }

        @Test
        public void メンバの内容が同一の_ShinseishoKanriNo型のクラスを渡したとき_trueが返る() {
            sut = new ShinseishoKanriNo(new RString("A001"));
            ShinseishoKanriNo 比較対象 = new ShinseishoKanriNo(new RString("A001"));
            assertThat(sut.equals(比較対象), is(true));
        }

        @Test
        public void メンバの内容が違う_ShinseishoKanriNo型のクラスを渡したとき_falseが返る() {
            sut = new ShinseishoKanriNo(new RString("A001"));
            ShinseishoKanriNo 比較対象 = new ShinseishoKanriNo(new RString("B001"));
            assertThat(sut.equals(比較対象), is(false));
        }
    }

    public static class hashCodeのテスト {

        @Test
        public void メンバの内容が同一の_ShinseishoKanriNo型のクラスを渡したとき_hashCodeの値が同じになる() {
            sut = new ShinseishoKanriNo(new RString("A001"));
            ShinseishoKanriNo 比較対象 = new ShinseishoKanriNo(new RString("A001"));
            assertThat(sut.hashCode(), is(比較対象.hashCode()));
        }
    }
}
