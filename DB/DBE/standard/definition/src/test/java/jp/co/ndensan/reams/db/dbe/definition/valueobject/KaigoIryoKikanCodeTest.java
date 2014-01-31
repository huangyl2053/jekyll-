/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.valueobject;

import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.testhelper.TestBase;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * 介護医療機関コードを表すクラスのテストです。
 *
 * @author n8178 城間篤人
 */
@RunWith(Enclosed.class)
public class KaigoIryoKikanCodeTest extends TestBase {

    private static KaigoIryoKikanCode sut;

    public static class コンストラクタのテスト {

        @Test
        public void 引数に値が渡されたとき_インスタンスが生成される() {
            sut = create介護医療機関コード("0123");
            assertThat(sut, instanceOf(KaigoIryoKikanCode.class));
        }

        @Test(expected = NullPointerException.class)
        public void 引数にnullが渡されたとき_NullPointerExceptionが返る() {
            sut = new KaigoIryoKikanCode(null);
        }
    }

    public static class hashCodeのテスト {

        @Test
        public void 同じ値を持つ介護医療機関コードのhashCodeを比較すると_同値になる() {
            sut = create介護医療機関コード("0123");
            assertThat(sut.hashCode(), is(create介護医療機関コード("0123").hashCode()));
        }
    }

    public static class equalsのテスト extends TestBase {

        @Override
        public void setUp() {
            sut = create介護医療機関コード("0123");
        }

        @Test
        public void 引数にnullが渡されたとき_falseが返る() {
            assertThat(sut.equals(null), is(false));
        }

        @Test
        public void 引数に違う型の変数が入ったとき_falseが返る() {
            assertThat(sut.equals(FlexibleDate.MIN), is(false));
        }

        @Test
        public void 引数にKaigoIryoKikanCode型で_値が違う変数が入ったとき_falseを返す() {
            assertThat(sut.equals(create介護医療機関コード("2345")), is(false));
        }

        @Test
        public void 引数にKaigoIryoKikanCode型で_値が同じ変数が入ったとき_trueが返る() {
            assertThat(sut.equals(create介護医療機関コード("0123")), is(true));
        }
    }

    public static class compareToのテスト extends TestBase {

        @Override
        public void setUp() {
            sut = create介護医療機関コード("0123");
        }

        @Test
        public void 引数にコード_0123が渡されたとき_0が返る() {
            assertThat(sut.compareTo(create介護医療機関コード("0123")) == 0, is(true));
        }

        @Test
        public void 引数にコード_0126が渡されたとき_0より小さい値が返る() {
            assertThat(sut.compareTo(create介護医療機関コード("0126")) < 0, is(true));
        }

        @Test
        public void 引数にコード_0121が渡されたとき_0より大きい値が返る() {
            assertThat(sut.compareTo(create介護医療機関コード("0121")) > 0, is(true));
        }
    }

    private static KaigoIryoKikanCode create介護医療機関コード(String str) {
        return new KaigoIryoKikanCode(new RString(str));
    }
}
