package jp.co.ndensan.reams.db.dbx.definition.core.hokenshakosei;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 保険者構成を表す列挙型です。
 */
public enum HokenshaKosei {

    /**
     * コード:1 名称:単一市町村 略称:定義なし
     */
    単一市町村("1", "単一市町村"),
    /**
     * コード:2 名称:広域市町村 略称:定義なし
     */
    広域市町村("2", "広域市町村");

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
