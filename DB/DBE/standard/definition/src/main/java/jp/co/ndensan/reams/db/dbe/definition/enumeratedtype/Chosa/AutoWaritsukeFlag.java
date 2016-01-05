package jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.Chosa;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 自動割付フラグを表す列挙型です。
 *
 * @author LDNS
 */
public enum AutoWaritsukeFlag {

    /**
     * コード:True 名称:自動割付可能 略称:定義なし
     */
    自動割付可能(true, "自動割付可能"),
    /**
     * コード:False 名称:自動割付不可能 略称:定義なし
     */
    自動割付不可能(false, "自動割付不可能");

    private final boolean code;
    private final RString fullName;

    private AutoWaritsukeFlag(boolean code, String fullname) {
        this.code = code;
        this.fullName = new RString(fullname);
    }

    /**
     * 自動割付フラグのコードを返します。
     *
     * @return 自動割付フラグのコード
     */
    public boolean getコード() {
        return code;
    }

    /**
     * 自動割付フラグの名称を返します。
     *
     * @return 自動割付フラグの名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 自動割付フラグのコードと一致する内容を探します。
     *
     * @param code 自動割付フラグのコード
     * @return {@code code} に対応する自動割付フラグ
     */
    public static AutoWaritsukeFlag toValue(boolean code) {
        for (AutoWaritsukeFlag autoWaritsukeFlag : AutoWaritsukeFlag.values()) {
            if (autoWaritsukeFlag.code == code) {
                return autoWaritsukeFlag;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("自動割付フラグ"));
    }
}
