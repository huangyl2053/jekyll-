/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.ikenshokinyuyoshioruka;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.experimental.runners.Enclosed;
import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;

/**
 * {@link Pattern12Converter}のテストです。
 */
@RunWith(Enclosed.class)
public class Pattern12ConverterTest {

    public Pattern12ConverterTest() {
    }

    @RunWith(Theories.class)
    public static class Test {

        @DataPoints
        public static Fixture[] PARAMS = {
            new Fixture("昭和1年1月1日", "昭和元年 1月 1日"),
            new Fixture("平成2年2月2日", "平成 2年 2月 2日"),
            new Fixture("昭和3年3月3日", "昭和 3年 3月 3日"),
            new Fixture("平成4年4月4日", "平成 4年 4月 4日"),
            new Fixture("昭和5年5月5日", "昭和 5年 5月 5日"),
            new Fixture("平成6年6月6日", "平成 6年 6月 6日"),
            new Fixture("昭和7年7月7日", "昭和 7年 7月 7日"),
            new Fixture("平成8年8月8日", "平成 8年 8月 8日"),
            new Fixture("昭和9年9月9日", "昭和 9年 9月 9日"),
            new Fixture("平成1年1月", "平成元年 1月"),
            new Fixture("昭和2年2月", "昭和 2年 2月"),
            new Fixture("平成3年3月", "平成 3年 3月"),
            new Fixture("昭和4年4月", "昭和 4年 4月"),
            new Fixture("平成5年5月", "平成 5年 5月"),
            new Fixture("昭和6年6月", "昭和 6年 6月"),
            new Fixture("平成7年7月", "平成 7年 7月"),
            new Fixture("昭和8年8月", "昭和 8年 8月"),
            new Fixture("平成9年9月", "平成 9年 9月"),
            new Fixture("昭和1年", "昭和元年"),
            new Fixture("平成2年", "平成 2年"),
            new Fixture("昭和3年", "昭和 3年"),
            new Fixture("平成4年", "平成 4年"),
            new Fixture("昭和5年", "昭和 5年"),
            new Fixture("平成6年", "平成 6年"),
            new Fixture("昭和7年", "昭和 7年"),
            new Fixture("平成8年", "平成 8年"),
            new Fixture("昭和9年", "昭和 9年"),
            new Fixture("平成11年1月12日", "平成11年 1月12日"),
            new Fixture("昭和60年1月", "昭和60年 1月"),
            new Fixture("平成5年", "平成 5年")
        };

        @Theory
        public void 正しく変換できる(Fixture f) {
            assertThat(Pattern12Converter.convert(f.rawValue), is(f.converted));
        }

        static class Fixture {

            private final RString rawValue;
            private final RString converted;

            Fixture(String rawValue, String converted) {
                this.rawValue = new RString(rawValue);
                this.converted = new RString(converted);
            }

        }

    }

}
