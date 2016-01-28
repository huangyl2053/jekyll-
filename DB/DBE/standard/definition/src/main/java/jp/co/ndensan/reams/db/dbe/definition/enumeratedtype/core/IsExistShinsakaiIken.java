package jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.core;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 審査会意見の有無を表す列挙型です。
 *
 * @author LDNS
 */
public enum IsExistShinsakaiIken {

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

    private IsExistShinsakaiIken(boolean code, String fullname) {
        this.code = code;
        this.fullName = new RString(fullname);
    }

    /**
     * 審査会意見の有無のコードを返します。
     *
     * @return 審査会意見の有無のコード
     */
    public boolean getコード() {
        return code;
    }

    /**
     * 審査会意見の有無の名称を返します。
     *
     * @return 審査会意見の有無の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 審査会意見の有無のコードと一致する内容を探します。
     *
     * @param code 審査会意見の有無のコード
     * @return {@code code} に対応する審査会意見の有無
     */
    public static IsExistShinsakaiIken toValue(boolean code) {
        for (IsExistShinsakaiIken isExistShinsakaiIken : IsExistShinsakaiIken.values()) {
            if (isExistShinsakaiIken.code == code) {
                return isExistShinsakaiIken;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("審査会意見の有無"));
    }
}
