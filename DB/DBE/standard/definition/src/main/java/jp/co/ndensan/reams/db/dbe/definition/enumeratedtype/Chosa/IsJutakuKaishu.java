package jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.Chosa;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 住宅改修を表す列挙型です。
 *
 * @author LDNS
 */
public enum IsJutakuKaishu {

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

    private IsJutakuKaishu(boolean code, String fullname) {
        this.code = code;
        this.fullName = new RString(fullname);
    }

    /**
     * 住宅改修のコードを返します。
     *
     * @return 住宅改修のコード
     */
    public boolean getコード() {
        return code;
    }

    /**
     * 住宅改修の名称を返します。
     *
     * @return 住宅改修の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 住宅改修のコードと一致する内容を探します。
     *
     * @param code 住宅改修のコード
     * @return {@code code} に対応する住宅改修
     */
    public static IsJutakuKaishu toValue(boolean code) {
        for (IsJutakuKaishu isJutakuKaishu : IsJutakuKaishu.values()) {
            if (isJutakuKaishu.code == code) {
                return isJutakuKaishu;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("住宅改修"));
    }
}
