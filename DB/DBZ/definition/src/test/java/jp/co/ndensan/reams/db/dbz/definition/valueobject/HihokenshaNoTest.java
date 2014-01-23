/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.valueobject;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.testhelper.TestBase;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * 被保険者番号クラスのテストです。
 *
 * @author n8178 城間篤人
 */
@RunWith(Enclosed.class)
public class HihokenshaNoTest extends TestBase {

    public static class コンストラクタのテスト {

        @Test
        public void 必要な値が渡されたとき_インスタンスが生成される() {
            HihokenshaNo sut = new HihokenshaNo(new RString("test001"));
            assertThat(sut, instanceOf(HihokenshaNo.class));
        }

        @Test(expected = NullPointerException.class)
        public void 被保険者番号にnullが渡されたとき_NullPointerExceptionが発生する() {
            HihokenshaNo sut = new HihokenshaNo(null);
        }
    }

    public static class hashCodeのテスト {

        @Test
        public void 被保険者番号が同じ文字列とき_hashCodeも同じになる() {
            HihokenshaNo sut1 = new HihokenshaNo(new RString("test001"));
            HihokenshaNo sut2 = new HihokenshaNo(new RString("test001"));
            assertThat(sut1.hashCode(), is(sut2.hashCode()));
        }
    }

    public static class equalsのテスト {

        @Test
        public void 被保険者番号が同じ文字列のとき_trueを返す() {
            HihokenshaNo sut1 = new HihokenshaNo(new RString("test001"));
            HihokenshaNo sut2 = new HihokenshaNo(new RString("test001"));
            assertThat(sut1.equals(sut2), is(true));
        }

        @Test
        public void 被保険者番号が違う文字列のとき_falseを返す() {
            HihokenshaNo sut1 = new HihokenshaNo(new RString("test001"));
            HihokenshaNo sut2 = new HihokenshaNo(new RString("test002"));
            assertThat(sut1.equals(sut2), is(false));
        }
    }
}
