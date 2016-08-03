package jp.co.ndensan.reams.db.dbu.definition.core.jigyohokoku;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 保険者種別を表す列挙型です。
 *
 * @reamsid_L DBU-9999-023 wangchao
 */
public enum HokenshaShubetsu {

    /**
     * コード:0 名称:保険者 略称:定義なし
     */
    保険者("0", "保険者"),
    /**
     * コード:1 名称:旧市町村 略称:定義なし
     */
    旧市町村("1", "旧市町村"),
    /**
     * コード:2 名称:構成市町村 略称:定義なし
     */
    構成市町村("2", "構成市町村");

    private final RString code;
    private final RString fullName;

    private HokenshaShubetsu(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 保険者種別のコードを返します。
     *
     * @return 保険者種別のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 保険者種別の名称を返します。
     *
     * @return 保険者種別の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 保険者種別のコードと一致する内容を探します。
     *
     * @param code 保険者種別のコード
     * @return {@code code} に対応する保険者種別
     */
    public static HokenshaShubetsu toValue(RString code) {
        for (HokenshaShubetsu hokenshaShubetsu : HokenshaShubetsu.values()) {
            if (hokenshaShubetsu.code.equals(code)) {
                return hokenshaShubetsu;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("保険者種別"));
    }
}
