/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.mybatisprm.shinseikensaku;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.experimental.runners.Enclosed;
import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;

/**
 * {@link ShinseiKensakuMapperParameter}のテストです。
 */
@RunWith(Enclosed.class)
public class ShinseiKensakuMapperParameterTest {

    public ShinseiKensakuMapperParameterTest() {
    }

    @RunWith(Theories.class)
    public static class set被保険者名 {

        @DataPoints
        public static Fixture[] PARAMs = {
            new Fixture("電算太郎", "電算太郎", true, false),
            new Fixture("電算たろう", "電算たろう", true, false),
            new Fixture("でんさんたろう", "ﾃﾞﾝｻﾝﾀﾛｳ", false, true),
            new Fixture(null, RString.EMPTY, false, false)
        };

        @Theory
        public void set被保険者名(Fixture f) {
            ShinseiKensakuMapperParameter sut = new ShinseiKensakuMapperParameter();
            sut.set被保険者名(f.source);
            System.out.println(sut.getHihokenshaName());
            assertThat(sut.getHihokenshaName(), is(f.result));
            assertThat(sut.usesHihokenshaName(), is(f.usesName));
            assertThat(sut.usesHihokenshaKana(), is(f.usesKana));
        }

        static class Fixture {

            private final RString source;
            private final RString result;
            private final boolean usesName;
            private final boolean usesKana;

            Fixture(String source, String result, boolean usesName, boolean usesKana) {
                this(new RString(source), new RString(result), usesName, usesKana);
            }

            Fixture(RString source, RString result, boolean usesName, boolean usesKana) {
                this.source = source;
                this.result = result;
                this.usesName = usesName;
                this.usesKana = usesKana;
            }
        }
    }
}
