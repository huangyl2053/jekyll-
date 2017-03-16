/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.core.yokaigoninteiimagekanri;

import java.util.LinkedHashMap;
import java.util.Map;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 取り扱うイメージの種類
 */
public enum ImageType {

    /**
     * 認定調査票（概況調査、基本調査）
     */
    調査票("1", "調査票（概況調査＋調査票特記）"),
    /**
     * 概況特記
     */
    概況特記("2", "概況特記"),
    /**
     * 主治医意見書（定型、定型外）
     */
    意見書("3", "主治医意見書（定型・定型外）"),
    /**
     * その他資料
     */
    その他資料("4", "その他資料");

    private final RString aKey;
    private final RString aDisplayName;

    private ImageType(String key, String displayName) {
        this.aKey = new RString(key);
        this.aDisplayName = new RString(displayName);
    }

    /**
     * @return キー
     */
    public RString key() {
        return this.aKey;
    }

    /**
     * @return 表示名称
     */
    public RString displayName() {
        return this.aDisplayName;
    }

    /**
     * @return {@link #key()}の戻り値をキーに、{@link #displayName()}の値をマッピングした形式
     */
    public static Map<RString, RString> toMap() {
        Map<RString, RString> map = new LinkedHashMap<>();
        map.put(調査票.key(), 調査票.displayName());
        map.put(概況特記.key(), 概況特記.displayName());
        map.put(意見書.key(), 意見書.displayName());
        map.put(その他資料.key(), その他資料.displayName());
        return map;
    }
}
