package jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.core;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 取消理由の有無を表す列挙型です。
 *
 * @author LDNS
 */
public enum IsExistTorikeshiRiyu {

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

    private IsExistTorikeshiRiyu(boolean code, String fullname) {
        this.code = code;
        this.fullName = new RString(fullname);
    }

    /**
     * 取消理由の有無のコードを返します。
     *
     * @return 取消理由の有無のコード
     */
    public boolean getコード() {
        return code;
    }

    /**
     * 取消理由の有無の名称を返します。
     *
     * @return 取消理由の有無の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 取消理由の有無のコードと一致する内容を探します。
     *
     * @param code 取消理由の有無のコード
     * @return {@code code} に対応する取消理由の有無
     */
    public static IsExistTorikeshiRiyu toValue(boolean code) {
        for (IsExistTorikeshiRiyu isExistTorikeshiRiyu : IsExistTorikeshiRiyu.values()) {
            if (isExistTorikeshiRiyu.code == code) {
                return isExistTorikeshiRiyu;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("取消理由の有無"));
    }
}
