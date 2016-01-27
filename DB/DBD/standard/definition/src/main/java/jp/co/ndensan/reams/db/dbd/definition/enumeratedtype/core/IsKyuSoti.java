package jp.co.ndensan.reams.db.dbd.definition.enumeratedtype.core;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 旧措置適用フラグを表す列挙型です。
 *
 * @author LDNS
 */
public enum IsKyuSoti {

    /**
     * コード:True 名称:旧措置適用 略称:定義なし
     */
    旧措置適用(true, "旧措置適用"),
    /**
     * コード:False 名称:適用外 略称:定義なし
     */
    適用外(false, "適用外");

    private final boolean code;
    private final RString fullName;

    private IsKyuSoti(boolean code, String fullname) {
        this.code = code;
        this.fullName = new RString(fullname);
    }

    /**
     * 旧措置適用フラグのコードを返します。
     *
     * @return 旧措置適用フラグのコード
     */
    public boolean getコード() {
        return code;
    }

    /**
     * 旧措置適用フラグの名称を返します。
     *
     * @return 旧措置適用フラグの名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 旧措置適用フラグのコードと一致する内容を探します。
     *
     * @param code 旧措置適用フラグのコード
     * @return {@code code} に対応する旧措置適用フラグ
     */
    public static IsKyuSoti toValue(boolean code) {

        for (IsKyuSoti isKyuSoti : IsKyuSoti.values()) {
            if (isKyuSoti.code == code) {
                return isKyuSoti;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("旧措置適用フラグ"));
    }
}
