package jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.Chosa;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 事前調査フラグを表す列挙型です。
 *
 * @author LDNS
 */
public enum IsJizenChosa {

    /**
     * コード:True 名称:出力 略称:定義なし
     */
    出力(true, "出力"),
    /**
     * コード:False 名称:未出力 略称:定義なし
     */
    未出力(false, "未出力");

    private final boolean code;
    private final RString fullName;

    private IsJizenChosa(boolean code, String fullname) {
        this.code = code;
        this.fullName = new RString(fullname);
    }

    /**
     * 事前調査フラグのコードを返します。
     *
     * @return 事前調査フラグのコード
     */
    public boolean getコード() {
        return code;
    }

    /**
     * 事前調査フラグの名称を返します。
     *
     * @return 事前調査フラグの名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 事前調査フラグのコードと一致する内容を探します。
     *
     * @param code 事前調査フラグのコード
     * @return {@code code} に対応する事前調査フラグ
     */
    public static IsJizenChosa toValue(boolean code) {
        for (IsJizenChosa isJizenChosa : IsJizenChosa.values()) {
            if (isJizenChosa.code == code) {
                return isJizenChosa;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("事前調査フラグ"));
    }
}
