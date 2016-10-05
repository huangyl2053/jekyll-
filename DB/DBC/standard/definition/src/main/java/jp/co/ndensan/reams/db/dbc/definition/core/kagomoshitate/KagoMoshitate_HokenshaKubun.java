/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.core.kagomoshitate;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 過誤申立_保険者区分す列挙型です。
 *
 * @reamsid_L DBC-9999-022 qinzhen
 */
public enum KagoMoshitate_HokenshaKubun {

    /**
     * コード:1 名称:介護給付費 略称:介護（予防）給付費情報
     */
    介護給付費("1", "介護給付費", "介護（予防）給付費情報"),
    /**
     * コード:2 名称:総合事業費_経過措置　略称:総合事業費（経過措置）情報
     */
    総合事業費_経過措置("2", "総合事業費_経過措置", "総合事業費（経過措置）情報"),
    /**
     * コード:3 名称:総合事業費 略称:総合事業費情報
     */
    総合事業費("3", "総合事業費", "総合事業費情報");

    private final RString code;
    private final RString fullName;
    private final RString shortName;

    private KagoMoshitate_HokenshaKubun(String code, String fullname, String shortName) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
        this.shortName = new RString(shortName);
    }

    /**
     * 過誤申立_保険者区分のコードを返します。
     *
     * @return 過誤申立_保険者区分のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 過誤申立_保険者区分の名称を返します。
     *
     * @return 過誤申立_保険者区分の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 過誤申立_保険者区分の略称を返します。
     *
     * @return 過誤申立_保険者区分の略称
     */
    public RString get略称() {
        return shortName;
    }

    /**
     * 過誤申立_保険者区分のコードと一致する内容を探します。
     *
     * @param code 過誤申立_保険者区分のコード
     * @return {@code code} に対応する過誤申立_保険者区分
     */
    public static KagoMoshitate_HokenshaKubun toValue(RString code) {

        for (KagoMoshitate_HokenshaKubun hokenkyufuritsuTeisu : KagoMoshitate_HokenshaKubun.values()) {
            if (hokenkyufuritsuTeisu.code.equals(code)) {
                return hokenkyufuritsuTeisu;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("過誤申立_保険者区分"));
    }
}
