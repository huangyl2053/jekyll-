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
 * 削除の方法です。
 */
public enum DeletionMethod {

    /**
     * 原本とマスクの両方を削除
     */
    原本マスクを削除("1", "原本・マスクを削除"),
    /**
     * マスク処理後のイメージのみを削除（原本は残す）
     */
    マスクのみを削除("2", "マスクのみ削除");

    private final RString aKey;
    private final RString aDisplayName;

    private DeletionMethod(String key, String displayName) {
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
    public RString diplayName() {
        return this.aDisplayName;
    }

    /**
     * @return マスクのみ削除の場合、{@code true}.
     */
    public boolean isMaskedOnly() {
        return this == マスクのみを削除;
    }

    public static Map<RString, RString> toMap(boolean hasMasked) {
        Map<RString, RString> map = new LinkedHashMap<>();
        map.put(原本マスクを削除.key(), 原本マスクを削除.diplayName());
        if (hasMasked) {
            map.put(マスクのみを削除.key(), マスクのみを削除.diplayName());
        }
        return map;
    }

    /**
     * @param key キー
     * @return 指定のキーに該当する{@link DeletionMethod}.
     * @throws IllegalArgumentException 指定のキーに該当する要素が存在しない場合
     */
    public static DeletionMethod toValue(RString key) {
        for (DeletionMethod v : values()) {
            if (v.key().equals(key)) {
                return v;
            }
        }
        throw new IllegalArgumentException("指定のkeyよりの変換に失敗しました。 key:" + key);
    }
}
