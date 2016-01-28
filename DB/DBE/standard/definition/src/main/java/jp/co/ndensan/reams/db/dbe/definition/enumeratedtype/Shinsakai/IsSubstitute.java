package jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.Shinsakai;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 補欠を表す列挙型です。
 *
 * @author LDNS
 */
public enum IsSubstitute {

    /**
     * コード:True 名称:補欠 略称:定義なし
     */
    補欠(true, "補欠"),
    /**
     * コード:False 名称:通常 略称:定義なし
     */
    通常(false, "通常");

    private final boolean code;
    private final RString fullName;

    private IsSubstitute(boolean code, String fullname) {
        this.code = code;
        this.fullName = new RString(fullname);
    }

    /**
     * 補欠のコードを返します。
     *
     * @return 補欠のコード
     */
    public boolean getコード() {
        return code;
    }

    /**
     * 補欠の名称を返します。
     *
     * @return 補欠の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 補欠のコードと一致する内容を探します。
     *
     * @param code 補欠のコード
     * @return {@code code} に対応する補欠
     */
    public static IsSubstitute toValue(boolean code) {
        for (IsSubstitute isSubstitute : IsSubstitute.values()) {
            if (isSubstitute.code == code) {
                return isSubstitute;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("補欠"));
    }
}
