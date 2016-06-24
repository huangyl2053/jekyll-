/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.core.kyotsu;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * コード変換区分を表す列挙型です。
 *
 * @reamsid_L DBZ-9999-023 wangchao
 */
public enum CodehenkanCheck {

    /**
     * コード:1 名称:付加する 略称:定義なし
     */
    付加する("1", "付加する"),
    /**
     * コード:0 名称:付加しない 略称:定義なし
     */
    付加しない("0", "付加しない");

    private final RString code;
    private final RString fullName;

    private CodehenkanCheck(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * コード変換区分のコードを返します。
     *
     * @return コード変換区分のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * コード変換区分の名称を返します。
     *
     * @return コード変換区分の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * コード変換区分のコードと一致する内容を探します。
     *
     * @param code コード変換区分のコード
     * @return {@code code} に対応するコード変換区分
     */
    public static CodehenkanCheck toValue(RString code) {

        for (CodehenkanCheck value : CodehenkanCheck.values()) {
            if (value.code.equals(code)) {
                return value;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("コード変換区分"));
    }
}
