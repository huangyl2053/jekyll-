package jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.Ikensho;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 外科受診の有無を表す列挙型です。
 *
 * @author LDNS
 */
public enum IsGekaJushinUmu {

    /**
     * コード:True 名称:あり 略称:定義なし
     */
    あり(true, "あり"),
    /**
     * コード:False 名称:なし 略称:定義なし
     */
    なし(false, "なし");

    private final boolean code;
    private final RString fullName;

    private IsGekaJushinUmu(boolean code, String fullname) {
        this.code = code;
        this.fullName = new RString(fullname);
    }

    /**
     * 外科受診の有無のコードを返します。
     *
     * @return 外科受診の有無のコード
     */
    public boolean getコード() {
        return code;
    }

    /**
     * 外科受診の有無の名称を返します。
     *
     * @return 外科受診の有無の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 外科受診の有無のコードと一致する内容を探します。
     *
     * @param code 外科受診の有無のコード
     * @return {@code code} に対応する外科受診の有無
     */
    public static IsGekaJushinUmu toValue(boolean code) {
        for (IsGekaJushinUmu isGekaJushinUmu : IsGekaJushinUmu.values()) {
            if (isGekaJushinUmu.code == code) {
                return isGekaJushinUmu;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("外科受診の有無"));
    }
}
