/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.valueobject;

import jp.co.ndensan.reams.db.dbz.testhelper.DbeTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.junit.Before;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * 審査会委員コードのテストクラスです。
 *
 * @author n8178 城間篤人
 */
@RunWith(Enclosed.class)
public class ShinsakaiIinCodeTest {

    private static ShinsakaiIinCode sut1;
    private static ShinsakaiIinCode sut2;

    public static class コンストラクタのテスト extends DbeTestBase {

        @Test(expected = NullPointerException.class)
        public void 引数にnullが渡されたとき_NullPointerExceptionが発生する() {
            sut1 = new ShinsakaiIinCode(null);
            fail();
        }

        @Test(expected = IllegalArgumentException.class)
        public void 引数に8桁に満たない文字列が渡されたとき_IllegalArgumentExceptionが発生する() {
            sut1 = new ShinsakaiIinCode(new RString("1234567"));
            fail();
        }

        @Test(expected = IllegalArgumentException.class)
        public void 引数に8桁より大きい文字列が渡されたとき_IllegalArgumentExceptionが発生する() {
            sut1 = new ShinsakaiIinCode(new RString("123456789"));
            fail();
        }

        @Test
        public void 引数がnullでは無く_かつ8桁の文字列であるとき_インスタンスが生成される() {
            sut1 = new ShinsakaiIinCode(new RString("12345678"));
            assertThat(sut1, instanceOf(ShinsakaiIinCode.class));
        }
    }

    public static class hashCodeのテスト extends DbeTestBase {

        @Test
        public void 同一の審査会委員コードを持つとき_ハッシュコードが同値になる() {
            sut1 = createShinsakaiIinCode("00000001");
            sut2 = createShinsakaiIinCode("00000001");
            assertThat(sut1.hashCode(), is(sut2.hashCode()));
        }
    }

    public static class equalsのテスト extends DbeTestBase {

        @Before
        public void setUp() {
            sut1 = createShinsakaiIinCode("00000001");
        }

        @Test
        public void 引数にnullを渡したとき_falseが返る() {
            assertThat(sut1.equals(null), is(false));
        }

        @Test
        public void 引数に_GogitaiMeisho型以外のものを渡したとき_falseが返る() {
            assertThat(sut1.equals(new RString("00000001")), is(false));
        }

        @Test
        public void 引数に_同値でない値を持っている審査会委員コードを渡したとき_falseが返る() {
            sut2 = createShinsakaiIinCode("00000002");
            assertThat(sut1.equals(sut2), is(false));
        }

        @Test
        public void 引数に_同値を持つ審査会委員コードを渡したとき_trueが返る() {
            sut2 = createShinsakaiIinCode("00000001");
            assertThat(sut1.equals(sut2), is(true));
        }
    }

    public static class compareToのテスト extends DbeTestBase {

        @Before
        public void setUp() {
            sut1 = createShinsakaiIinCode("00000001");
        }

        @Test
        public void 審査会委員コード00000001と_審査会委員コード00000002を比較したとき_0より小さい値が返る() {
            sut2 = createShinsakaiIinCode("00000002");
            assertThat(sut1.compareTo(sut2) < 0, is(true));
        }

        @Test
        public void 審査会委員コード00000001と_審査会委員コード00000000を比較したとき_0より大きい値が返る() {
            sut2 = createShinsakaiIinCode("00000000");
            assertThat(0 < sut1.compareTo(sut2), is(true));
        }

        @Test
        public void 審査会委員コード00000001と_審査会委員コード00000001を比較したとき_0が返る() {
            sut2 = createShinsakaiIinCode("00000001");
            assertThat(sut1.compareTo(sut2) == 0, is(true));
        }
    }

    private static ShinsakaiIinCode createShinsakaiIinCode(String str) {
        return new ShinsakaiIinCode(new RString(str));
    }
}
