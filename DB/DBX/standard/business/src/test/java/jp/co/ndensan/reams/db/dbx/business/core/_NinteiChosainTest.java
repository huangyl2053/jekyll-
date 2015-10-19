/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.business.core;

import jp.co.ndensan.reams.db.dbx.testhelper.DbxTestBase;
import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.IName;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import static org.mockito.Mockito.mock;

/**
 * {@link _NinteiChosain}のテストクラスです。
 *
 * @author N2204 三井 沙織
 */
@RunWith(Enclosed.class)
public class _NinteiChosainTest extends DbxTestBase {

    private static _NinteiChosain sut;

    @BeforeClass
    public static void setUpClass() {

        RString 介護調査員番号 = TestUtil.createNumber();
        IName 氏名 = mock(IName.class);
        IKaigoJigyosha 所属事業者 = mock(IKaigoJigyosha.class);
        sut = new _NinteiChosain(介護調査員番号, 氏名, 所属事業者);
    }

    public static class コンストラクタ extends DbxTestBase {

        @Test(expected = NullPointerException.class)
        public void コンストラクタの引数の介護調査員番号にnullを渡すと_コンストラクタは_NullPointerExceptionを発生させる() {
            new _NinteiChosain(null, mock(IName.class), mock(IKaigoJigyosha.class));
        }

        @Test(expected = NullPointerException.class)
        public void コンストラクタの引数の氏名にnullを渡すと_コンストラクタは_NullPointerExceptionを発生させる() {
            new _NinteiChosain(TestUtil.createNumber(), null, mock(IKaigoJigyosha.class));
        }

        @Test(expected = NullPointerException.class)
        public void コンストラクタの引数の所属事業者にnullを渡すと_コンストラクタは_NullPointerExceptionを発生させる() {
            new _NinteiChosain(TestUtil.createNumber(), mock(IName.class), null);
        }
    }

    public static class LDNS_コンストラクタ extends DbxTestBase {

        @Test(expected = NullPointerException.class)
        public void LDNS_コンストラクタの引数の介護調査員番号にnullを渡すと_コンストラクタは_NullPointerExceptionを発生させる() {
            sut = new _NinteiChosain(null, mock(IName.class), mock(IKaigoJigyosha.class));
        }

        @Test(expected = NullPointerException.class)
        public void LDNS_コンストラクタの引数の氏名にnullを渡すと_コンストラクタは_NullPointerExceptionを発生させる() {
            sut = new _NinteiChosain(TestUtil.createNumber(), null, mock(IKaigoJigyosha.class));
        }

        @Test(expected = NullPointerException.class)
        public void LDNS_コンストラクタの引数の所属事業者にnullを渡すと_コンストラクタは_NullPointerExceptionを発生させる() {
            sut = new _NinteiChosain(TestUtil.createNumber(), mock(IName.class), null);
        }
    }

    public static class get介護調査員番号のテスト extends DbxTestBase {

        @Test
        public void LDNS_介護調査員番号指定する場合_get介護調査員番号は_介護調査員番号を返す() {
            assertThat(sut.get介護調査員番号(), is(TestUtil.createNumber()));
        }
    }

    public static class get氏名のテスト extends DbxTestBase {

        @Test
        public void LDNS_氏名指定する場合_get氏名は_氏名を返す() {
            assertThat(sut.get氏名(), instanceOf(IName.class));
        }
    }

    public static class get所属事業者のテスト extends DbxTestBase {

        @Test
        public void LDNS_所属事業者指定する場合_get所属事業者は_所属事業者を返す() {
            assertThat(sut.get所属事業者(), instanceOf(IKaigoJigyosha.class));
        }
    }

    private static class TestUtil {

        private static RString createNumber() {
            return new RString("0123456789");
        }
    }
}
