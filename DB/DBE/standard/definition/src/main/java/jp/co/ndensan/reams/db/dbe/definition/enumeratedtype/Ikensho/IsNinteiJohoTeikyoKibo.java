package jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.Ikensho;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 認定情報提供希望フラグを表す列挙型です。
 *
 * @author LDNS
 */
public enum IsNinteiJohoTeikyoKibo {

    /**
     * コード:True 名称:希望する 略称:定義なし
     */
    希望する(true, "希望する"),
    /**
     * コード:False 名称:希望しない 略称:定義なし
     */
    希望しない(false, "希望しない");

    private final boolean code;
    private final RString fullName;

    private IsNinteiJohoTeikyoKibo(boolean code, String fullname) {
        this.code = code;
        this.fullName = new RString(fullname);
    }

    /**
     * 認定情報提供希望フラグのコードを返します。
     *
     * @return 認定情報提供希望フラグのコード
     */
    public boolean getコード() {
        return code;
    }

    /**
     * 認定情報提供希望フラグの名称を返します。
     *
     * @return 認定情報提供希望フラグの名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 認定情報提供希望フラグのコードと一致する内容を探します。
     *
     * @param code 認定情報提供希望フラグのコード
     * @return {@code code} に対応する認定情報提供希望フラグ
     */
    public static IsNinteiJohoTeikyoKibo toValue(boolean code) {
        for (IsNinteiJohoTeikyoKibo isNinteiJohoTeikyoKibo : IsNinteiJohoTeikyoKibo.values()) {
            if (isNinteiJohoTeikyoKibo.code == code) {
                return isNinteiJohoTeikyoKibo;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("認定情報提供希望フラグ"));
    }
}
