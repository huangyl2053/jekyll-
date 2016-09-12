/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.core.util;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.experimental.runners.Enclosed;
import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;

/**
 * {@link RStrings}のテストです。
 */
@RunWith(Enclosed.class)
public class RStringsTest {

    public RStringsTest() {
    }

    @RunWith(Theories.class)
    public static class TestRemovedSpaces {

        @DataPoints
        public static Fixture[] PARAMS = {
            new Fixture(" 電算 太郎 ", "電算太郎"),
            new Fixture("　電算　太郎　", "電算太郎"),
            new Fixture("　電算 太郎 ", "電算太郎"),
            new Fixture(" 電算　太郎 ", "電算太郎"),
            new Fixture(" 電算 太郎　", "電算太郎"),
            new Fixture(" 電算 太郎 ", "電算太郎"),
            new Fixture("  電算  太郎  ", "電算太郎"),
            new Fixture("  電算 　　　太郎  　　　　 ", "電算太郎"),};

        @Theory
        public void testRemovedSpaces(Fixture f) {
            assertThat(RStrings.removedSpaces(f.raw), is(f.converted));
        }

        public static class Fixture {

            RString raw;
            RString converted;

            Fixture(String raw, String converted) {
                this.raw = new RString(raw);
                this.converted = new RString(converted);
            }
        }

    }
}
