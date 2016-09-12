/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.definition.core.gemmengengaku;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;

/**
 * {@link GemmenGengakuShurui}のテストです。
 */
@RunWith(Enclosed.class)
public class GemmenGengakuShuruiTest {

    public GemmenGengakuShuruiTest() {
    }

    @RunWith(Theories.class)
    public static class Values {

        @DataPoints
        public static Fixture[] PARAMs = {
            new Fixture("01", GemmenGengakuShurui.標準負担額減免),
            new Fixture("02", GemmenGengakuShurui.特定標準負担額減額),
            new Fixture("03", GemmenGengakuShurui.利用者負担額減額),
            new Fixture("04", GemmenGengakuShurui.社会福祉法人等利用者負担軽減),
            new Fixture("05", GemmenGengakuShurui.訪問介護利用者負担額減額),
            new Fixture("06", GemmenGengakuShurui.特別地域加算減免),
            new Fixture("07", GemmenGengakuShurui.負担限度額認定)};

        @Theory
        public void それぞれの要素が特定のコードを返却する(Fixture p) {
            assertThat(p.sut.getコード(), is(p.code));
        }

        @Theory
        public void 指定のコードより_特定の要素が返却される(Fixture p) {
            assertThat(GemmenGengakuShurui.toValue(p.code), is(p.sut));
        }

        static class Fixture {

            GemmenGengakuShurui sut;
            RString code;

            Fixture(String code, GemmenGengakuShurui sut) {
                this.code = new RString(code);
                this.sut = sut;
            }
        }
    }

    public static class toValue {

        @Test(expected = IllegalArgumentException.class)
        public void toValueは_指定のコードに該当すル要素が存在しない場合_IllegalArgumentExceptionをスローする() {
            GemmenGengakuShurui.toValue(new RString("99"));
        }
    }
}
