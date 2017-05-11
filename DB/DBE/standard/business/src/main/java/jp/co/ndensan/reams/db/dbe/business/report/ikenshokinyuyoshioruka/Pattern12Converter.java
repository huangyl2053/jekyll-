/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.ikenshokinyuyoshioruka;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;

/**
 *
 */
final class Pattern12Converter {

    private static final RString TWO_DIGIT_YEAR = new RString("[1-9]{2}年");
    private static final RString TWO_DIGIT_MONTH = new RString("[1-9]{2}月");
    private static final RString TWO_DIGIT_DAY = new RString("[1-9]{2}日");
    private static final Map<String, String> YEAR_TABLE;
    private static final Map<String, String> MONTH_TABLE;
    private static final Map<String, String> DAY_TABLE;

    //<editor-fold defaultstate="collapsed" desc="static{...}">
    static {
        {
            Map<String, String> map = new HashMap<>();
            map.put("1年", "元年");
            for (int i = 2; i <= 9; i++) {
                map.put(i + "年", " " + i + "年");
            }
            YEAR_TABLE = Collections.unmodifiableMap(map);
        }
        {
            Map<String, String> map = new HashMap<>();
            for (int i = 1; i <= 9; i++) {
                map.put(i + "月", " " + i + "月");
            }
            MONTH_TABLE = Collections.unmodifiableMap(map);
        }
        {
            Map<String, String> map = new HashMap<>();
            for (int i = 1; i <= 9; i++) {
                map.put(i + "日", " " + i + "日");
            }
            DAY_TABLE = Collections.unmodifiableMap(map);
        }
    }
    //</editor-fold>

    private Pattern12Converter() {
    }

    /**
     * @param rawValue 変換元（元号N年N月N日 の形式、月・日は必須ではない）
     * @return パターン12(元号漢字、元年、年・月・日、半角スペース埋め）に変換した結果
     */
    static RString convert(RString rawValue) {
        RStringBuilder builder = new RStringBuilder();
        builder.append(rawValue);
        if (!Pattern.compile(TWO_DIGIT_YEAR.toString()).matcher(rawValue).find()) {
            replace(builder, YEAR_TABLE);
        }
        if (!Pattern.compile(TWO_DIGIT_MONTH.toString()).matcher(rawValue).find()) {
            replace(builder, MONTH_TABLE);
        }
        if (!Pattern.compile(TWO_DIGIT_DAY.toString()).matcher(rawValue).find()) {
            replace(builder, DAY_TABLE);
        }
        return builder.toRString();
    }

    private static void replace(RStringBuilder builder, Map<String, String> table) {
        for (Map.Entry<String, String> e : table.entrySet()) {
            builder.replace(e.getKey(), e.getValue());
        }
    }

}
