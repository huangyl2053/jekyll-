package jp.co.ndensan.reams.db.dbd.definition.enumeratedtype.core;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 情報提供への同意有無を表す列挙型です。
 *
 * @author LDNS
 */
public enum IsExistJohoTeikyoDoui {

    /**
     * コード:true 名称:同意する 略称:定義なし
     */
    同意する(true, "同意する"),
    /**
     * コード:false 名称:同意しない 略称:定義なし
     */
    同意しない(false, "同意しない");

    private final boolean code;
    private final RString fullName;

    private IsExistJohoTeikyoDoui(boolean code, String fullname) {
        this.code = code;
        this.fullName = new RString(fullname);
    }

    /**
     * 情報提供への同意有無のコードを返します。
     *
     * @return 情報提供への同意有無のコード
     */
    public boolean getコード() {
        return code;
    }

    /**
     * 情報提供への同意有無の名称を返します。
     *
     * @return 情報提供への同意有無の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 情報提供への同意有無のコードと一致する内容を探します。
     *
     * @param code 情報提供への同意有無のコード
     * @return {@code code} に対応する情報提供への同意有無
     */
    public static IsExistJohoTeikyoDoui toValue(boolean code) {
        for (IsExistJohoTeikyoDoui isExistJohoTeikyoDoui : IsExistJohoTeikyoDoui.values()) {
            if (isExistJohoTeikyoDoui.code == code) {
                return isExistJohoTeikyoDoui;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("情報提供への同意有無"));
    }
}
