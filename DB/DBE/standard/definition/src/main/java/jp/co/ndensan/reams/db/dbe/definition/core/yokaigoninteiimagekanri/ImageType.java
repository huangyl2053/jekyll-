/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.core.yokaigoninteiimagekanri;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 */
public enum ImageType {

    調査票("1"),
    概況特記("2"),
    意見書("3"),
    その他資料("4");

    private final RString aKey;

    private ImageType(String key) {
        this.aKey = new RString(key);
    }

    /**
     * @return キー
     */
    public RString key() {
        return this.aKey;
    }
}
