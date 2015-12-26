package jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.Shinsei;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 施設入所の有無を表す列挙型です。
 *
 * @author LDNS
 */
public enum IsExistShisetsuNyusho {

    /**
     * コード:True 名称:入所している 略称:定義なし
     */
    入所している(true, "入所している"),
    /**
     * コード:False 名称:入所していない 略称:定義なし
     */
    入所していない(false, "入所していない");

    private final boolean code;
    private final RString fullName;

    private IsExistShisetsuNyusho(boolean code, String fullname) {
        this.code = code;
        this.fullName = new RString(fullname);
    }

    /**
     * 施設入所の有無のコードを返します。
     *
     * @return 施設入所の有無のコード
     */
    public boolean getコード() {
        return code;
    }

    /**
     * 施設入所の有無の名称を返します。
     *
     * @return 施設入所の有無の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 施設入所の有無のコードと一致する内容を探します。
     *
     * @param code 施設入所の有無のコード
     * @return {@code code} に対応する施設入所の有無
     */
    public static IsExistShisetsuNyusho toValue(boolean code) {
        for (IsExistShisetsuNyusho isExistShisetsuNyusho : IsExistShisetsuNyusho.values()) {
            if (isExistShisetsuNyusho.code == code) {
                return isExistShisetsuNyusho;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("施設入所の有無"));
    }
}
