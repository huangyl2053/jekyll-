/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.valueobject;

import jp.co.ndensan.reams.db.dbz.testhelper.DbeTestBase;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertThat;

/**
 * 要介護認定調査の実施場所区分コードを扱うクラスのテストクラスです。
 *
 * @author N8156 宮本 康
 */
@RunWith(Enclosed.class)
public class NinteichosaJisshibashoKubunCodeTest extends DbeTestBase {

    private static final NinteichosaJisshibashoKubunCode 基準コード = new NinteichosaJisshibashoKubunCode(new Code(new RString("1234")));
    private static final NinteichosaJisshibashoKubunCode 基準より小さいコード = new NinteichosaJisshibashoKubunCode(new Code(new RString("1111")));
    private static final NinteichosaJisshibashoKubunCode 基準より大きいコード = new NinteichosaJisshibashoKubunCode(new Code(new RString("2222")));
    private static final NinteichosaJisshibashoKubunCode 基準と異なるコード = new NinteichosaJisshibashoKubunCode(new Code(new RString("5678")));

    public static class コンストラクタ {

        @Test(expected = NullPointerException.class)
        public void 引数がNULLの時_コンストラクタは_NullPointerExceptionを投げる() {
            new NinteichosaJisshibashoKubunCode(null);
        }
    }

    public static class compareTo extends DbeTestBase {

        @Test
        public void 引数と値が一致する時_compareToは_0を返す() {
            assertThat(基準コード.compareTo(基準コード) == 0, is(true));
        }

        @Test
        public void 引数より小さい時_compareToは_0より小さい値を返す() {
            assertThat(基準コード.compareTo(基準より大きいコード) < 0, is(true));
        }

        @Test
        public void 引数より大きい時_compareToは_0より大きい値を返す() {
            assertThat(0 < 基準コード.compareTo(基準より小さいコード), is(true));
        }
    }

    public static class equals extends DbeTestBase {

        @Test
        public void 引数と値が一致する時_equalsは_TRUEを返す() {
            assertThat(基準コード.equals(基準コード), is(true));
        }

        @Test
        public void 引数と値が一致しない時_equalsは_FALSEを返す() {
            assertThat(基準コード.equals(基準と異なるコード), is(false));
        }

        @Test
        public void 引数がNULLの時_equalsは_FALSEを返す() {
            assertThat(基準コード.equals(null), is(false));
        }

        @Test
        public void 引数が異なる型の時_equalsは_FALSEを返す() {
            assertThat(基準コード.equals(FlexibleDate.MIN), is(false));
        }
    }

    public static class hashCode extends DbeTestBase {

        @Test
        public void 引数と値が一致する時_hashCodeは_同一の値を返す() {
            assertThat(基準コード.hashCode(), is(基準コード.hashCode()));
        }

        @Test
        public void 引数と値が一致しない時_hashCodeは_異なる値を返す() {
            assertThat(基準コード.hashCode(), not(基準と異なるコード.hashCode()));
        }
    }
}
