package jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.core;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 廃止フラグを表す列挙型です。
 *
 * @author LDNS
 */
public enum IsHaishi {

    /**
     * コード:True 名称:廃止 略称:定義なし
     */
    廃止(true, "廃止"),
    /**
     * コード:False 名称:廃止されていない 略称:定義なし
     */
    廃止されていない(false, "廃止されていない");

    private final boolean code;
    private final RString fullName;

    private IsHaishi(boolean code, String fullname) {
        this.code = code;
        this.fullName = new RString(fullname);
    }

    /**
     * 廃止フラグのコードを返します。
     *
     * @return 廃止フラグのコード
     */
    public boolean getコード() {
        return code;
    }

    /**
     * 廃止フラグの名称を返します。
     *
     * @return 廃止フラグの名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 廃止フラグのコードと一致する内容を探します。
     *
     * @param code 廃止フラグのコード
     * @return {@code code} に対応する廃止フラグ
     */
    public static IsHaishi toValue(boolean code) {
        for (IsHaishi isHaishi : IsHaishi.values()) {
            if (isHaishi.code == code) {
                return isHaishi;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("廃止フラグ"));
    }
}
