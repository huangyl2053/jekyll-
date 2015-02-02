/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.enumeratedtype;

import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 住所地特例者区分の列挙型です。
 *
 * @author N8156 宮本 康
 */
public enum JushochitokureishaKubun {

    /**
     * 住所地特例区分が空であることを示します。<br/>
     * コード : EMPTY
     */
    EMPTY(""),
    /**
     * 住所地特例者区分が「住所地特例者」であることを表します。 <br />
     * コード：1
     */
    住所地特例者("1"),
    /**
     * 住所地特例者区分が「通常資格者」であることを表します。 <br />
     * コード：2
     */
    通常資格者("2");
    private final RString code;

    private JushochitokureishaKubun(String code) {
        this.code = new RString(code);
    }

    /**
     * コードを返します。
     *
     * @return コード
     */
    public RString code() {
        return this.code;
    }

    /**
     * コードに対応する列挙型を返します。
     * 空文字列、もしくはnullを受け取った場合は"EMPTY"を表すJushochitokureishaKubunを返します。
     *
     * @param code コード
     * @return 列挙型
     * @throws IllegalArgumentException 対応する列挙型がない場合
     */
    public static JushochitokureishaKubun toValue(RString code) throws IllegalArgumentException {
        if (code == null || code.isEmpty()) {
            return EMPTY;
        }

        for (JushochitokureishaKubun data : values()) {
            if (data.code().equals(code)) {
                return data;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("住所地特例者区分"));
    }
}
