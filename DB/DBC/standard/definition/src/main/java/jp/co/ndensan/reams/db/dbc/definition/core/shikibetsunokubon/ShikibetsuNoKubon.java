/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.core.shikibetsunokubon;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 識別番号区分を表す列挙型です。
 *
 * @author LDNS 席従望
 */
public enum ShikibetsuNoKubon {

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

    private ShikibetsuNoKubon(String code, String fullname) {
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
    public static ShikibetsuNoKubon toValue(RString code) {

        for (ShikibetsuNoKubon shikibetsuNoKubon : ShikibetsuNoKubon.values()) {
            if (shikibetsuNoKubon.code.equals(code)) {
                return shikibetsuNoKubon;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("識別番号区分のコード"));
    }
}
