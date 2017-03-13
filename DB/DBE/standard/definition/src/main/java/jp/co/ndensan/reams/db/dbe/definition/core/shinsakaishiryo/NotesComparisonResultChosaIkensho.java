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
public enum NotesComparisonResultChosaIkensho {
    
    主治医が問題視("★"),
    調査員が問題視("☆"),
    意見書が未記入("未");
    
    private final RString code;

    private NotesComparisonResultChosaIkensho(String code) {
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
