package jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.shinsakai;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 委員出席を表す列挙型です。
 *
 * @reamsid_L DBE-9999-023 liangbc
 */
public enum IsShusseki {

    /**
     * コード:True 名称:出席 略称:定義なし
     */
    出席(true, "出席"),
    /**
     * コード:False 名称:欠席 略称:定義なし
     */
    欠席(false, "欠席");

    private final boolean code;
    private final RString fullName;

    private IsShusseki(boolean code, String fullname) {
        this.code = code;
        this.fullName = new RString(fullname);
    }

    /**
     * 委員出席のコードを返します。
     *
     * @return 委員出席のコード
     */
    public boolean is委員出席() {
        return code;
    }

    /**
     * 委員出席の名称を返します。
     *
     * @return 委員出席の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 委員出席のコードと一致する内容を探します。
     *
     * @param code 委員出席のコード
     * @return {@code code} に対応する委員出席
     */
    public static IsShusseki toValue(boolean code) {
        for (IsShusseki isShusseki : IsShusseki.values()) {
            if (isShusseki.code == code) {
                return isShusseki;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("委員出席"));
    }
}
