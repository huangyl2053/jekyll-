/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.core.kagomoshitate;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 過誤申立_保険者区分を表す列挙型です。
 *
 * @reamsid_L DBC-9999-022 pengxingyi
 */
public enum KagoMoshitateHokenshaKubun {

    /**
     * コード:1 名称:介護給付費 略称:定義なし
     */
    介護給付費("1", "介護（予防）給付費情報"),
    /**
     * コード:2 名称:総合事業費_経過措置 略称:定義なし
     */
    総合事業費_経過措置("2", "総合事業費（経過措置）情報"),
    /**
     * コード:3 名称:総合事業費 略称:定義なし
     */
    総合事業費("3", "総合事業費情報");

    private final RString code;
    private final RString fullName;

    private KagoMoshitateHokenshaKubun(String code, String fullName) {
        this.code = new RString(code);
        this.fullName = new RString(fullName);
    }

    /**
     * 過誤申立_保険者区分のコードを返します。
     *
     * @return 介護合算_異動区分のコード
     */
    public RString getCode() {
        return code;
    }

    /**
     * 過誤申立_保険者区分の名称を返します。
     *
     * @return 介護合算_異動区分の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 過誤申立_保険者区分のコードと一致する内容を探します。
     *
     * @param code 過誤申立_保険者区分のコード
     * @return {@code code} に対応する過誤申立_保険者区分
     */
    public static KagoMoshitateHokenshaKubun toValue(RString code) {
        for (KagoMoshitateHokenshaKubun kagoMoshitateHokenshaKubun : KagoMoshitateHokenshaKubun.values()) {
            if (kagoMoshitateHokenshaKubun.code.equals(code)) {
                return kagoMoshitateHokenshaKubun;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("過誤申立_保険者区分"));
    }
}
