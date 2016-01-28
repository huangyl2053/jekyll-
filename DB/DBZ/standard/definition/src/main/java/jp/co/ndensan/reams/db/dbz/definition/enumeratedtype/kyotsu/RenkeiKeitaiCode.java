package jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.kyotsu;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 連携形態コードを表す列挙型です。
 *
 * @author LDNS
 */
public enum RenkeiKeitaiCode {

    /**
     * コード:01 名称:FD 略称:定義なし
     */
    FD("01", "FD"),
    /**
     * コード:02 名称:ネットワーク 略称:定義なし
     */
    ネットワーク("02", "ネットワーク");

    private final RString code;
    private final RString fullName;

    private RenkeiKeitaiCode(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 連携形態コードのコードを返します。
     *
     * @return 連携形態コードのコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 連携形態コードの名称を返します。
     *
     * @return 連携形態コードの名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 連携形態コードのコードと一致する内容を探します。
     *
     * @param code 連携形態コードのコード
     * @return {@code code} に対応する連携形態コード
     */
    public static RenkeiKeitaiCode toValue(RString code) {

        for (RenkeiKeitaiCode renkeiKeitaiCode : RenkeiKeitaiCode.values()) {
            if (renkeiKeitaiCode.code.equals(code)) {
                return renkeiKeitaiCode;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("連携形態コード"));
    }
}
