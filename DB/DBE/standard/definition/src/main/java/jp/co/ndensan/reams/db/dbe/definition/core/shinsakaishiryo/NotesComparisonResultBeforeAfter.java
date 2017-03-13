/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jp.co.ndensan.reams.db.dbe.definition.core.shinsakaishiryo;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * @author n3423
 */
public enum NotesComparisonResultBeforeAfter {
    
    前回よりn段階改善("▽"),
    前回よりn段階悪化("▲");
    
    private final RString code;

    private NotesComparisonResultBeforeAfter(String code) {
        this.code = new RString(code);
    }

    /**
     * 印字する凡例を返します。
     *
     * @return 印字する凡例
     */
    public RString getCode() {
        return this.code;
    }
}
