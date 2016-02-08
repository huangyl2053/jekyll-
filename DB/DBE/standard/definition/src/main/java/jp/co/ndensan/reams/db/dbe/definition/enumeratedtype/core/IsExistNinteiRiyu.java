package jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.core;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 認定理由の有無を表す列挙型です。
 *
 * @author LDNS
 */
public enum IsExistNinteiRiyu {

    /**
     * コード:True 名称:である 略称:定義なし
     */
    である(true, "である"),
    /**
     * コード:False 名称:でない 略称:定義なし
     */
    でない(false, "でない");

    private final boolean code;
    private final RString fullName;

    private IsExistNinteiRiyu(boolean code, String fullname) {
        this.code = code;
        this.fullName = new RString(fullname);
    }

    /**
     * 認定理由の有無のコードを返します。
     *
     * @return 認定理由の有無のコード
     */
    public boolean getコード() {
        return code;
    }

    /**
     * 認定理由の有無の名称を返します。
     *
     * @return 認定理由の有無の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 認定理由の有無のコードと一致する内容を探します。
     *
     * @param code 認定理由の有無のコード
     * @return {@code code} に対応する認定理由の有無
     */
    public static IsExistNinteiRiyu toValue(boolean code) {
        for (IsExistNinteiRiyu isExistNinteiRiyu : IsExistNinteiRiyu.values()) {
            if (isExistNinteiRiyu.code == code) {
                return isExistNinteiRiyu;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("認定理由の有無"));
    }
}
