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
 * 合議体番号のテストクラスです。
 *
 * @author n8178 城間篤人
 */
@RunWith(Enclosed.class)
public class GogitaiNoTest extends TestBase {

    private static GogitaiNo sut1;
    private static GogitaiNo sut2;

    public static class hashCodeのテスト {

        @Test
        public void 同一の合議体番号を持つとき_ハッシュコードが同値になる() {
            sut1 = createGogitaiNo(123);
            sut2 = createGogitaiNo(123);
            assertThat(sut1.hashCode(), is(sut2.hashCode()));
        }
    }

    public static class equalsのテスト extends TestBase {

        @Override
        public void setUp() {
            sut1 = createGogitaiNo(123);
        }

        @Test
        public void 引数にnullを渡したとき_falseが返る() {
            assertThat(sut1.equals(null), is(false));
        }

        @Test
        public void 引数にGogitaiNo型以外のものを渡したとき_falseが返る() {
            assertThat(sut1.equals(new RString("123")), is(false));
        }

        @Test
        public void 引数に同値でない値を持っている合議体番号を渡したとき_falseが返る() {
            sut2 = createGogitaiNo(321);
            assertThat(sut1.equals(sut2), is(false));
        }

        @Test
        public void 引数に同値を持つ合議体番号を渡したとき_trueが返る() {
            sut2 = createGogitaiNo(123);
            assertThat(sut1.equals(sut2), is(true));
        }
    }

    private static GogitaiNo createGogitaiNo(int num) {
        return new GogitaiNo(num);
    }
}
