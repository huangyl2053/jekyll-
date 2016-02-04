/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.core.jyushochitokureisha;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 住所地特例者区分列挙型です。
 *
 */
public enum JushochitokureishaKubun {

    /**
     * コード:1 名称:住所地特例者 略称:定義なし
     */
    住所地特例者("1", "住所地特例者"),
    /**
     * コード:0 名称:通常資格者 略称:定義なし
     */
    通常資格者("0", "通常資格者");

    private final RString code;
    private final RString fullName;

    private JushochitokureishaKubun(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 住所地特例者区分のコードを返します。
     *
     * @return 住所地特例者区分のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 住所地特例者区分の名称を返します。
     *
     * @return 住所地特例者区分の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 住所地特例者区分のコードと一致する内容を探します。
     *
     * @param code 住所地特例者区分のコード
     * @return {@code code} に対応する住所地特例者区分
     */
    public static JushochitokureishaKubun toValue(RString code) {

        for (JushochitokureishaKubun value : JushochitokureishaKubun.values()) {
            if (value.code.equals(code)) {
                return value;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("住所地特例者区分"));
    }
}
