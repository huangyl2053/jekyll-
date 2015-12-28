/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.definition.core.hokensha;

import java.util.Objects;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 広域タイプ
 */
public enum KoikiType {

    /**
     * （大北広域、大雪広域）
     */
    タイプ１("1"),
    /**
     * （その他広域）
     */
    タイプ２("2"),
    /**
     *
     */
    未設定("0");

    private final RString aCode;

    private KoikiType(String code) {
        this.aCode = new RString(code);
    }

    /**
     * 指定のコードに該当する広域タイプを返却します。
     *
     * @param code コード
     * @return 広域タイプ
     * @throws IllegalArgumentException 引数のコードに該当する要素が存在しない場合
     */
    public static KoikiType toValue(RString code) {
        for (KoikiType value : values()) {
            if (Objects.equals(value.aCode, code)) {
                return value;
            }
        }
        throw new IllegalArgumentException();
    }
}
