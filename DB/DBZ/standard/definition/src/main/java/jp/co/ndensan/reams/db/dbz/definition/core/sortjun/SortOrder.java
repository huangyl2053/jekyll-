package jp.co.ndensan.reams.db.dbz.definition.core.sortjun;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * ソート順を表す列挙型です。
 *
 * @author LDNS
 */
public enum SortOrder {

    /**
     * コード:1 名称:ASC 略称:定義なし
     */
    ASC(1, "ASC"),
    /**
     * コード:-1 名称:DESC 略称:定義なし
     */
    DESC(-1, "DESC");

    private final int code;
    private final RString fullName;

    private SortOrder(int code, String fullname) {
        this.code = code;
        this.fullName = new RString(fullname);
    }

    /**
     * ソート順のコードを返します。
     *
     * @return ソート順のコード
     */
    public int getコード() {
        return code;
    }

    /**
     * ソート順の名称を返します。
     *
     * @return ソート順の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * ソート順のコードと一致する内容を探します。
     *
     * @param code ソート順のコード
     * @return {@code code} に対応するソート順
     */
    public static SortOrder toValue(int code) {
        for (SortOrder sortOrder : SortOrder.values()) {
            if (sortOrder.code == code) {
                return sortOrder;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("ソート順"));
    }
}
