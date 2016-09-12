/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.core.util;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 型変換に関するユーティリティです。
 */
public class ConversionUtil {

    private ConversionUtil() {
    }

    /**
     * 指定のrStringをintへ変換します。
     * 単純な変換に失敗する場合には、{@code defaultValue}を返却します。
     *
     * @param rstr rString
     * @param defaultValue defaultValue
     * @return 指定のrStringをint型へ変換した値. 変換に失敗する場合は、defaultValue.
     */
    public static int toIntOrDefualt(RString rstr, int defaultValue) {
        if (RString.isNullOrEmpty(rstr)) {
            return defaultValue;
        }
        try {
            return Integer.valueOf(rstr.toString());
        } catch (NumberFormatException e) {
            return defaultValue;
        }
    }
}
