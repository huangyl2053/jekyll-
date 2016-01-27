package jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.core;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * サービス変更理由の有無を表す列挙型です。
 *
 * @author LDNS
 */
public enum IsExistServiseHenkoRiyu {

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

    private IsExistServiseHenkoRiyu(boolean code, String fullname) {
        this.code = code;
        this.fullName = new RString(fullname);
    }

    /**
     * サービス変更理由の有無のコードを返します。
     *
     * @return サービス変更理由の有無のコード
     */
    public boolean getコード() {
        return code;
    }

    /**
     * サービス変更理由の有無の名称を返します。
     *
     * @return サービス変更理由の有無の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * サービス変更理由の有無のコードと一致する内容を探します。
     *
     * @param code サービス変更理由の有無のコード
     * @return {@code code} に対応するサービス変更理由の有無
     */
    public static IsExistServiseHenkoRiyu toValue(boolean code) {
        for (IsExistServiseHenkoRiyu isExistServiseHenkoRiyu : IsExistServiseHenkoRiyu.values()) {
            if (isExistServiseHenkoRiyu.code == code) {
                return isExistServiseHenkoRiyu;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("サービス変更理由の有無"));
    }
}
