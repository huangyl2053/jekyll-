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
 * 申請書管理番号クラスのテストです。
 *
 * @author n8178 城間篤人
 */
@RunWith(Enclosed.class)
public class ShinseishoKanriNoTest extends TestBase {

    public static class コンストラクタのテスト {

        @Test
        public void 必要な値が渡されたとき_インスタンスが生成される() {
            ShinseishoKanriNo sut = new ShinseishoKanriNo(new RString("test001"));
            assertThat(sut, instanceOf(ShinseishoKanriNo.class));
        }

        @Test(expected = NullPointerException.class)
        public void 申請書管理番号にnullが渡されたとき_NullPointerExceptionが発生する() {
            ShinseishoKanriNo sut = new ShinseishoKanriNo(null);
        }
    }

    public static class hashCodeのテスト {

        @Test
        public void 申請書管理番号が同じ文字列とき_hashCodeも同じになる() {
            ShinseishoKanriNo sut1 = new ShinseishoKanriNo(new RString("test001"));
            ShinseishoKanriNo sut2 = new ShinseishoKanriNo(new RString("test001"));
            assertThat(sut1.hashCode(), is(sut2.hashCode()));
        }
    }

    public static class equalsのテスト {

        @Test
        public void 申請書管理番号が同じ文字列のとき_trueを返す() {
            ShinseishoKanriNo sut1 = new ShinseishoKanriNo(new RString("test001"));
            ShinseishoKanriNo sut2 = new ShinseishoKanriNo(new RString("test001"));
            assertThat(sut1.equals(sut2), is(true));
        }

        @Test
        public void 申請書管理番号が違う文字列のとき_falseを返す() {
            ShinseishoKanriNo sut1 = new ShinseishoKanriNo(new RString("test001"));
            ShinseishoKanriNo sut2 = new ShinseishoKanriNo(new RString("test002"));
            assertThat(sut1.equals(sut2), is(false));
        }
    }
}
