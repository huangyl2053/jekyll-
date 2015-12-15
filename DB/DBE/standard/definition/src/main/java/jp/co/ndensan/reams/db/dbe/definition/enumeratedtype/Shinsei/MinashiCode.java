package jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.Shinsei;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * みなし要介護区分コードを表す列挙型です。
 *
 * @author LDNS
 */
public enum MinashiCode {

    /**
     * コード:1 名称:通常の認定 略称:定義なし
     */
    通常の認定("1", "通常の認定"),
    /**
     * コード:2 名称:みなし認定（旧措置入所者） 略称:定義なし
     */
    みなし認定_旧措置入所者("2", "みなし認定（旧措置入所者）"),
    /**
     * コード:3 名称:やむを得ない事由 略称:定義なし
     */
    やむを得ない事由("3", "やむを得ない事由");

    private final RString code;
    private final RString fullName;

    private MinashiCode(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * みなし要介護区分コードのコードを返します。
     *
     * @return みなし要介護区分コードのコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * みなし要介護区分コードの名称を返します。
     *
     * @return みなし要介護区分コードの名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * みなし要介護区分コードのコードと一致する内容を探します。
     *
     * @param code みなし要介護区分コードのコード
     * @return {@code code} に対応するみなし要介護区分コード
     */
    public static MinashiCode toValue(RString code) {

        for (MinashiCode minashiCode : MinashiCode.values()) {
            if (minashiCode.code.equals(code)) {
                return minashiCode;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("みなし要介護区分コード"));
    }
}
