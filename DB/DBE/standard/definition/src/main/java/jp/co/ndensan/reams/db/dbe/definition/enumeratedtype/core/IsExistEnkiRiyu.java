package jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.core;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 延期理由の有無を表す列挙型です。
 *
 * @author LDNS
 */
public enum IsExistEnkiRiyu {

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

    private IsExistEnkiRiyu(boolean code, String fullname) {
        this.code = code;
        this.fullName = new RString(fullname);
    }

    /**
     * 延期理由の有無のコードを返します。
     *
     * @return 延期理由の有無のコード
     */
    public boolean getコード() {
        return code;
    }

    /**
     * 延期理由の有無の名称を返します。
     *
     * @return 延期理由の有無の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 延期理由の有無のコードと一致する内容を探します。
     *
     * @param code 延期理由の有無のコード
     * @return {@code code} に対応する延期理由の有無
     */
    public static IsExistEnkiRiyu toValue(boolean code) {
        for (IsExistEnkiRiyu isExistEnkiRiyu : IsExistEnkiRiyu.values()) {
            if (isExistEnkiRiyu.code == code) {
                return isExistEnkiRiyu;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("延期理由の有無"));
    }
}
