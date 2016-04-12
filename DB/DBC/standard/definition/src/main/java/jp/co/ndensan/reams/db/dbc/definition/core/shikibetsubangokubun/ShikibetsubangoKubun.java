/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.core.shikibetsubangokubun;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 識別番号区分を表す列挙型です。
 *
 * @reamsid_L DBC-9999-022 xicongwang
 */
public enum ShikibetsubangoKubun {

    /**
     * コード:1 名称:交換情報識別番号 略称:定義なし
     */
    交換情報識別番号("1", "交換情報識別番号"),
    /**
     * コード:2 名称:入力識別番号 略称:定義なし
     */
    入力識別番号("2", "入力識別番号");
    private final RString code;
    private final RString fullName;

    private ShikibetsubangoKubun(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 識別番号区分のコードを返します。
     *
     * @return 識別番号区分のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 識別番号区分の名称を返します。
     *
     * @return 識別番号区分の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 識別番号区分のコードと一致する内容を探します。
     *
     * @param code 識別番号区分のコード
     * @return {@code code} に対応する識別番号区分
     */
    public static ShikibetsubangoKubun toValue(RString code) {

        for (ShikibetsubangoKubun value : ShikibetsubangoKubun.values()) {
            if (value.code.equals(code)) {
                return value;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("識別番号区分"));
    }
}
