/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.divcontroller.util;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;

/**
 * DataGrid用のユーティリティです。
 *
 * @author N3327 三浦 凌
 */
public final class DataGridUtil {

    private static final RString LINE_FEED;

    static {
        LINE_FEED = new RString("<BR />");
    }

    private DataGridUtil() {
    }

    /**
     * 間に改行タグを挟んだ新しいRStringを返します。
     *
     * @param str1 改行タグの前のRString
     * @param str2 改行タグの後のRString
     * @return str1とstr2の間に改行タグを挟んだ新しいRString
     */
    public static RString lineFeedBetween(RString str1, RString str2) {
        return new RStringBuilder(str1).append(LINE_FEED).append(str2).toRString();
    }
}
