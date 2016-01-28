package jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.core;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * サービス種類の有無を表す列挙型です。
 *
 * @author LDNS
 */
public enum IsExistServiseShurui {

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

    private IsExistServiseShurui(boolean code, String fullname) {
        this.code = code;
        this.fullName = new RString(fullname);
    }

    /**
     * サービス種類の有無のコードを返します。
     *
     * @return サービス種類の有無のコード
     */
    public boolean getコード() {
        return code;
    }

    /**
     * サービス種類の有無の名称を返します。
     *
     * @return サービス種類の有無の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * サービス種類の有無のコードと一致する内容を探します。
     *
     * @param code サービス種類の有無のコード
     * @return {@code code} に対応するサービス種類の有無
     */
    public static IsExistServiseShurui toValue(boolean code) {
        for (IsExistServiseShurui isExistServiseShurui : IsExistServiseShurui.values()) {
            if (isExistServiseShurui.code == code) {
                return isExistServiseShurui;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("サービス種類の有無"));
    }
}
