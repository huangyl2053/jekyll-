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
 * 合議体名称のテストクラスです。
 *
 * @author n8178 城間篤人
 */
@RunWith(Enclosed.class)
public class GogitaiMeishoTest {

    private static GogitaiMeisho sut1;
    private static GogitaiMeisho sut2;

    public static class コンストラクタのテスト extends DbeTestBase {

        @Test(expected = NullPointerException.class)
        public void 引数にnullが渡されたとき_NullPointerExceptionが発生する() {
            sut1 = new GogitaiMeisho(null);
        }
    }

    public static class hashCodeのテスト extends DbeTestBase {

        @Test
        public void 同一の合議体名称を持つとき_ハッシュコードが同値になる() {
            sut1 = createGogitaiMeisho("合議体1");
            sut2 = createGogitaiMeisho("合議体1");
            assertThat(sut1.hashCode(), is(sut2.hashCode()));
        }
    }

    public static class equalsのテスト extends DbeTestBase {

        @Before
        public void setUp() {
            sut1 = createGogitaiMeisho("合議体1");
        }

        @Test
        public void 引数にnullを渡したとき_falseが返る() {
            assertThat(sut1.equals(null), is(false));
        }

        @Test
        public void 引数に_GogitaiMeisho型以外のものを渡したとき_falseが返る() {
            assertThat(sut1.equals(new RString("合議体1")), is(false));
        }

        @Test
        public void 引数に_同値でない値を持っている合議体名称を渡したとき_falseが返る() {
            sut2 = createGogitaiMeisho("合議体123");
            assertThat(sut1.equals(sut2), is(false));
        }

        @Test
        public void 引数に_同値を持つ合議体名称を渡したとき_trueが返る() {
            sut2 = createGogitaiMeisho("合議体1");
            assertThat(sut1.equals(sut2), is(true));
        }
    }

    private static GogitaiMeisho createGogitaiMeisho(String str) {
        return new GogitaiMeisho(new RString(str));
    }
}
