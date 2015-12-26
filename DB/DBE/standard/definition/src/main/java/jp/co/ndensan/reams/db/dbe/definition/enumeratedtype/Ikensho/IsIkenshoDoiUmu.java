package jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.Ikensho;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 意見書同意フラグを表す列挙型です。
 *
 * @author LDNS
 */
public enum IsIkenshoDoiUmu {

    /**
     * コード:True 名称:しないする 略称:定義なし
     */
    しないする(true, "しないする"),
    /**
     * コード:False 名称:するしない 略称:定義なし
     */
    するしない(false, "するしない");

    private final boolean code;
    private final RString fullName;

    private IsIkenshoDoiUmu(boolean code, String fullname) {
        this.code = code;
        this.fullName = new RString(fullname);
    }

    /**
     * 意見書同意フラグのコードを返します。
     *
     * @return 意見書同意フラグのコード
     */
    public boolean getコード() {
        return code;
    }

    /**
     * 意見書同意フラグの名称を返します。
     *
     * @return 意見書同意フラグの名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 意見書同意フラグのコードと一致する内容を探します。
     *
     * @param code 意見書同意フラグのコード
     * @return {@code code} に対応する意見書同意フラグ
     */
    public static IsIkenshoDoiUmu toValue(boolean code) {
        for (IsIkenshoDoiUmu isIkenshoDoiUmu : IsIkenshoDoiUmu.values()) {
            if (isIkenshoDoiUmu.code == code) {
                return isIkenshoDoiUmu;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("意見書同意フラグ"));
    }
}
