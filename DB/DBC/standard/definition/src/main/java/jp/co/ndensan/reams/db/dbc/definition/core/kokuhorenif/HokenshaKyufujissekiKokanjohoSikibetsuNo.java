/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.core.kokuhorenif;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 保険者給付実績交換情報識別番号を表す列挙型です。
 *
 * @reamsid_L DBC-2460-010 gongliang
 */
public enum HokenshaKyufujissekiKokanjohoSikibetsuNo {

    /**
     * コード:1131 名称:平成15年3月以前
     */
    平成15年3月以前("1131", "平成15年3月以前"),
    /**
     * コード:1132 名称:平成15年4月以降
     */
    平成15年4月以降("1132", "平成15年4月以降"),
    /**
     * コード:1133 名称:平成17年10月以降
     */
    平成17年10月以降("1133", "平成17年10月以降"),
    /**
     * コード:1134 名称:平成18年4月以降
     */
    平成18年4月以降("1134", "平成18年4月以降"),
    /**
     * コード:1135 名称:平成20年4月以降
     */
    平成20年4月以降("1135", "平成20年4月以降"),
    /**
     * コード:1136 名称:平成21年4月以降
     */
    平成21年4月以降("1136", "平成21年4月以降"),
    /**
     * コード:1137 名称:平成24年4月以降
     */
    平成24年4月以降("1137", "平成24年4月以降"),
    /**
     * コード:1138 名称:平成27年4月以降
     */
    平成27年4月以降("1138", "平成27年4月以降");

    private final RString code;
    private final RString fullName;

    private HokenshaKyufujissekiKokanjohoSikibetsuNo(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 保険者給付実績交換情報識別番号のコードを返します。
     *
     * @return 保険者給付実績交換情報識別番号のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 保険者給付実績交換情報識別番号の名称を返します。
     *
     * @return 保険者給付実績交換情報識別番号の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 保険者給付実績交換情報識別番号のコードと一致する内容を探します。
     *
     * @param code 保険者給付実績交換情報識別番号のコード
     * @return {@code code} に対応する保険者給付実績交換情報識別番号
     */
    public static HokenshaKyufujissekiKokanjohoSikibetsuNo toValue(RString code) {

        for (HokenshaKyufujissekiKokanjohoSikibetsuNo kubun : HokenshaKyufujissekiKokanjohoSikibetsuNo.values()) {
            if (kubun.code.equals(code)) {
                return kubun;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("保険者給付実績交換情報識別番号"));
    }
}
