/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.core.yokaigoninteiimagekanri;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 取り扱うイメージの種類
 */
public enum ImageType {

    /**
     * 認定調査票（概況調査、基本調査）
     */
    調査票("1"),
    /**
     * 概況特記
     */
    概況特記("2"),
    /**
     * 主治医意見書（定型、定型外）
     */
    意見書("3"),
    /**
     * その他資料
     */
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
