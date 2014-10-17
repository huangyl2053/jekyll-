/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.definition.valueobject;

import jp.co.ndensan.reams.db.dbz.testhelper.DbbTestBase;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.junit.Before;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * 賦課エラーコードのテストです。
 *
 * @author n8178 城間篤人
 */
@RunWith(Enclosed.class)
public class FukaErrorCodeTest extends DbbTestBase {

    private static FukaErrorCode sut;
    private static FukaErrorCode other;

    public static class constructor extends DbbTestBase {

        @Test(expected = NullPointerException.class)
        public void 賦課エラーコードにnullが渡されたとき_NullPointerExceptionが発生する() {
            sut = new FukaErrorCode(null);
            fail();
        }

        @Test
        public void 必須項目が渡されたとき_インスタンスが生成される() {
            sut = new FukaErrorCode(new Code("012"));
            assertThat(sut, is(instanceOf(FukaErrorCode.class)));
        }

    }

    public static class compareTo extends DbbTestBase {

        @Before
        public void setUp() {
            sut = new FukaErrorCode(new Code("010"));
        }

        @Test
        public void 自身より大きい値と比較した場合_0より小さい値が返る() {
            other = new FukaErrorCode(new Code("011"));
            assertThat(sut.compareTo(other) < 0, is(true));
        }

        @Test
        public void 自身と同じ大きさの値と比較した場合_0が返る() {
            other = new FukaErrorCode(new Code("010"));
            assertThat(sut.compareTo(other) == 0, is(true));
        }

        @Test
        public void 自身より小さい値と比較した場合_0より大きい値が返る() {
            other = new FukaErrorCode(new Code("009"));
            assertThat(0 < sut.compareTo(other), is(true));
        }
    }

    public static class hashCode extends DbbTestBase {

        @Test
        public void 同じ値を持つエラーコードのhashCodeは_同値になる() {
            sut = new FukaErrorCode(new Code("010"));
            other = new FukaErrorCode(new Code("010"));
            assertThat(sut.hashCode(), is(other.hashCode()));
        }

    }

    public static class equals extends DbbTestBase {

        @Before
        public void setUp() {
            sut = new FukaErrorCode(new Code("010"));
        }

        @Test
        public void nullが渡された場合_falseが返る() {
            assertThat(sut.equals(null), is(false));
        }

        @Test
        public void 異なるオブジェクトと比較した場合_falseが返る() {
            RString otherStr = new RString("010");
            assertThat(sut.equals(otherStr), is(false));
        }

        @Test
        public void 異なるエラーコードと比較した場合_falseが返る() {
            other = new FukaErrorCode(new Code("011"));
            assertThat(sut.equals(other), is(false));
        }

        @Test
        public void 同じエラーコードと比較した場合_trueが返る() {
            other = new FukaErrorCode(new Code("010"));
            assertThat(sut.equals(other), is(true));
        }

    }

}
