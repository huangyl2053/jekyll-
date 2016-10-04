/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.core.kagomoshitate;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 保険者区分す列挙型です。
 *
 * @reamsid_L DBC-9999-022 qinzhen
 */
public enum KagoMoshitateKekka_HokenshaKubun {

    /**
     * コード:1 名称:保険者 略称:保険者分
     */
    保険者("1", "保険者", "保険者分"),
    /**
     * コード:2 名称:公費負担者　略称:公費負担者分
     */
    公費負担者("2", "公費負担者", "公費負担者分"),
    /**
     * コード:3 名称:経過措置_総合事業費 略称:総合事業費(経過措置)分
     */
    経過措置_総合事業費("3", "経過措置_総合事業費", "総合事業費(経過措置)分"),
    /**
     * コード:4 名称:保険者_総合事業費 略称:総合事業費(保険者)分
     */
    保険者_総合事業費("4", "保険者_総合事業費", "総合事業費(保険者)分"),
    /**
     * コード:5 名称:公費負担者_総合事業費 略称:総合事業費(公費負担者)分
     */
    公費負担者_総合事業費("5", "公費負担者_総合事業費", "総合事業費(公費負担者)分");

    private final RString code;
    private final RString fullName;
    private final RString shortName;

    private KagoMoshitateKekka_HokenshaKubun(String code, String fullname, String shortName) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
        this.shortName = new RString(shortName);
    }

    /**
     * 保険者区分のコードを返します。
     *
     * @return 保険者区分のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 保険者区分の名称を返します。
     *
     * @return 保険者区分の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 保険者区分の略称を返します。
     *
     * @return 保険者区分の略称
     */
    public RString get略称() {
        return shortName;
    }

    /**
     * 保険者区分のコードと一致する内容を探します。
     *
     * @param code 保険者区分のコード
     * @return {@code code} に対応する保険者区分
     */
    public static KagoMoshitateKekka_HokenshaKubun toValue(RString code) {

        for (KagoMoshitateKekka_HokenshaKubun hokenkyufuritsuTeisu : KagoMoshitateKekka_HokenshaKubun.values()) {
            if (hokenkyufuritsuTeisu.code.equals(code)) {
                return hokenkyufuritsuTeisu;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("保険者区分"));
    }
}
