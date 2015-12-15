package jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.Shinsakai;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 審査会自動割付フラグを表す列挙型です。
 *
 * @author LDNS
 */
public enum IsShinsakaiJidoWaritsuke {

    /**
     * コード:True 名称:自動 略称:定義なし
     */
    自動(true, "自動"),
    /**
     * コード:False 名称:手動 略称:定義なし
     */
    手動(false, "手動");

    private final boolean code;
    private final RString fullName;

    private IsShinsakaiJidoWaritsuke(boolean code, String fullname) {
        this.code = code;
        this.fullName = new RString(fullname);
    }

    /**
     * 審査会自動割付フラグのコードを返します。
     *
     * @return 審査会自動割付フラグのコード
     */
    public boolean getコード() {
        return code;
    }

    /**
     * 審査会自動割付フラグの名称を返します。
     *
     * @return 審査会自動割付フラグの名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 審査会自動割付フラグのコードと一致する内容を探します。
     *
     * @param code 審査会自動割付フラグのコード
     * @return {@code code} に対応する審査会自動割付フラグ
     */
    public static IsShinsakaiJidoWaritsuke toValue(boolean code) {
        for (IsShinsakaiJidoWaritsuke isShinsakaiJidoWaritsuke : IsShinsakaiJidoWaritsuke.values()) {
            if (isShinsakaiJidoWaritsuke.code == code) {
                return isShinsakaiJidoWaritsuke;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("審査会自動割付フラグ"));
    }
}
