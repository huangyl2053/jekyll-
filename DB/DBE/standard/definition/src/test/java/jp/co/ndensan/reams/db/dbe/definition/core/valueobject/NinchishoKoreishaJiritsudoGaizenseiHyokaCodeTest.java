/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.core.valueobject;

import jp.co.ndensan.reams.db.dbe.definition.core.valueobject.NinchishoKoreishaJiritsudoGaizenseiHyokaCode;
import jp.co.ndensan.reams.db.dbz.testhelper.DbeTestBase;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.junit.Before;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * 認知症高齢者自立度蓋然性評価コードのテストです。
 *
 * @author n8178 城間篤人
 */
@RunWith(Enclosed.class)
public class NinchishoKoreishaJiritsudoGaizenseiHyokaCodeTest {

    private static NinchishoKoreishaJiritsudoGaizenseiHyokaCode sut;
    private static NinchishoKoreishaJiritsudoGaizenseiHyokaCode sut2;

    public static class コンストラクタのテスト extends DbeTestBase {

        @Test(expected = NullPointerException.class)
        public void 引数にnullが渡されたとき_NullPointerExceptionが発生する() {
            sut = new NinchishoKoreishaJiritsudoGaizenseiHyokaCode(null);
        }
    }

    public static class compareToのテスト extends DbeTestBase {

        @Before
        public void setUp() {
            sut = new NinchishoKoreishaJiritsudoGaizenseiHyokaCode(new Code("20"));
        }

        @Test
        public void 比較対象のほうが大きい場合_0より小さい値が返る() {
            sut2 = new NinchishoKoreishaJiritsudoGaizenseiHyokaCode(new Code("21"));
            assertThat(sut.compareTo(sut2) < 0, is(true));
        }

        @Test
        public void 比較対象と同値の場合_0が返る() {
            sut2 = new NinchishoKoreishaJiritsudoGaizenseiHyokaCode(new Code("20"));
            assertThat(sut.compareTo(sut2) == 0, is(true));
        }

        @Test
        public void 比較対象のほうが小さい場合_0より大きい値が返る() {
            sut2 = new NinchishoKoreishaJiritsudoGaizenseiHyokaCode(new Code("19"));
            assertThat(0 < sut.compareTo(sut2), is(true));
        }
    }

    public static class equalsのテスト extends DbeTestBase {

        @Before
        public void setUp() {
            sut = new NinchishoKoreishaJiritsudoGaizenseiHyokaCode(new Code("20"));
        }

        @Test
        public void nullが渡された場合_falseが返る() {
            assertThat(sut.equals(null), is(false));
        }

        @Test
        public void 型の違うオブジェクトが渡された場合_falseが返る() {
            assertThat(sut.equals(new RString("20")), is(false));
        }

        @Test
        public void 値が一致しない場合_falseが返る() {
            sut2 = new NinchishoKoreishaJiritsudoGaizenseiHyokaCode(new Code("21"));
            assertThat(sut.equals(sut2), is(false));
        }

        @Test
        public void 値が一致した場合_trueが返る() {
            sut2 = new NinchishoKoreishaJiritsudoGaizenseiHyokaCode(new Code("20"));
            assertThat(sut.equals(sut2), is(true));
        }
    }

    public static class hashCodeのテスト extends DbeTestBase {

        @Before
        public void setUp() {
            sut = new NinchishoKoreishaJiritsudoGaizenseiHyokaCode(new Code("20"));
        }

        @Test
        public void 同値の値の場合_hashCodeも同値になる() {
            sut2 = new NinchishoKoreishaJiritsudoGaizenseiHyokaCode(new Code("20"));
            assertThat(sut.hashCode(), is(sut2.hashCode()));
        }
    }
}
