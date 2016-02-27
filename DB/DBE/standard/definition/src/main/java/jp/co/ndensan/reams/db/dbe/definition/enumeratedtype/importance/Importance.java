package jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.importance;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * メモ重要度を表す列挙型です。
 *
 *
 */
public enum Importance {

    /**
     * コード:2 名称:重要
     */
    重要("2", "重要"),
    /**
     * コード:1 名称:通常
     */
    通常("1", "通常");

    private final RString code;
    private final RString fullName;

    private Importance(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * メモ重要度のコードを返します。
     *
     * @return メモ重要度のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * メモ重要度の名称を返します。
     *
     * @return メモ重要度の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * メモ重要度のコードと一致する内容を探します。
     *
     * @param code メモ重要度のコード
     * @return {@code code} に対応するメモ重要度
     */
    public static Importance toValue(RString code) {

        for (Importance chosaKubun : Importance.values()) {
            if (chosaKubun.code.equals(code)) {
                return chosaKubun;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("メモ重要度"));
    }
}
