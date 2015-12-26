package jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.core;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 意見書メモの有無を表す列挙型です。
 *
 * @author LDNS
 */
public enum IsExistIkenshoMemo {

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

    private IsExistIkenshoMemo(boolean code, String fullname) {
        this.code = code;
        this.fullName = new RString(fullname);
    }

    /**
     * 意見書メモの有無のコードを返します。
     *
     * @return 意見書メモの有無のコード
     */
    public boolean getコード() {
        return code;
    }

    /**
     * 意見書メモの有無の名称を返します。
     *
     * @return 意見書メモの有無の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 意見書メモの有無のコードと一致する内容を探します。
     *
     * @param code 意見書メモの有無のコード
     * @return {@code code} に対応する意見書メモの有無
     */
    public static IsExistIkenshoMemo toValue(boolean code) {
        for (IsExistIkenshoMemo isExistIkenshoMemo : IsExistIkenshoMemo.values()) {
            if (isExistIkenshoMemo.code == code) {
                return isExistIkenshoMemo;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("意見書メモの有無"));
    }
}
