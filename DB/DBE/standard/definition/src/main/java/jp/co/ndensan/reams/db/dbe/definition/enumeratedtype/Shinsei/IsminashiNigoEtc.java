package jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.Shinsei;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * みなし2号等対象フラグを表す列挙型です。
 *
 * @author LDNS
 */
public enum IsminashiNigoEtc {

    /**
     * コード:True 名称:対象 略称:定義なし
     */
    対象(true, "対象"),
    /**
     * コード:False 名称:対象外 略称:定義なし
     */
    対象外(false, "対象外");

    private final boolean code;
    private final RString fullName;

    private IsminashiNigoEtc(boolean code, String fullname) {
        this.code = code;
        this.fullName = new RString(fullname);
    }

    /**
     * みなし2号等対象フラグのコードを返します。
     *
     * @return みなし2号等対象フラグのコード
     */
    public boolean getコード() {
        return code;
    }

    /**
     * みなし2号等対象フラグの名称を返します。
     *
     * @return みなし2号等対象フラグの名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * みなし2号等対象フラグのコードと一致する内容を探します。
     *
     * @param code みなし2号等対象フラグのコード
     * @return {@code code} に対応するみなし2号等対象フラグ
     */
    public static IsminashiNigoEtc toValue(boolean code) {
        for (IsminashiNigoEtc isminashiNigoEtc : IsminashiNigoEtc.values()) {
            if (isminashiNigoEtc.code == code) {
                return isminashiNigoEtc;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("みなし2号等対象フラグ"));
    }
}
