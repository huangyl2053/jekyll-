/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.definition.core.hokensha;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 保険者構成を表す列挙型です。
 *
 * @reamsid_L DBX-9999-023 liangbc
 */
public enum HokenshaKosei {

    /**
     * コード:1 名称:単一市町村 略称:定義なし
     */
    単一市町村("1", "単一市町村"),
    /**
     * コード:2 名称:広域市町村 略称:定義なし
     */
    広域市町村("2", "広域市町村"),
    /**
     * コード:3 名称:広域保険者 略称:定義なし
     */
    広域保険者("3", "広域保険者"),
    /**
     * コード:4 名称:広域審査会 略称:定義なし
     */
    広域審査会("4", "広域審査会");

    private final RString code;
    private final RString fullName;

    private HokenshaKosei(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 保険者構成のコードを返します。
     *
     * @return 保険者構成のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 保険者構成の名称を返します。
     *
     * @return 保険者構成の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 保険者構成のコードと一致する内容を探します。
     *
     * @param code 保険者構成のコード
     * @return {@code code} に対応する保険者構成
     */
    public static HokenshaKosei toValue(RString code) {
        for (HokenshaKosei hokenshaKosei : HokenshaKosei.values()) {
            if (hokenshaKosei.code.equals(code)) {
                return hokenshaKosei;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("保険者構成"));
    }
}
