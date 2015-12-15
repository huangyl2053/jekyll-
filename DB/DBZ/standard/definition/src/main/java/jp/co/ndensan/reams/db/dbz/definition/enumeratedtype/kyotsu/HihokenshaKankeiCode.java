package jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.kyotsu;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 被保険者との関係コードを表す列挙型です。
 *
 * @author LDNS
 */
public enum HihokenshaKankeiCode {

    /**
     * コード:1 名称:審査請求人 略称:定義なし
     */
    審査請求人("1", "審査請求人"),
    /**
     * コード:2 名称:代理人 略称:定義なし
     */
    代理人("2", "代理人"),
    /**
     * コード:3 名称:総代 略称:定義なし
     */
    総代("3", "総代");

    private final RString code;
    private final RString fullName;

    private HihokenshaKankeiCode(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 被保険者との関係コードのコードを返します。
     *
     * @return 被保険者との関係コードのコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 被保険者との関係コードの名称を返します。
     *
     * @return 被保険者との関係コードの名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 被保険者との関係コードのコードと一致する内容を探します。
     *
     * @param code 被保険者との関係コードのコード
     * @return {@code code} に対応する被保険者との関係コード
     */
    public static HihokenshaKankeiCode toValue(RString code) {

        for (HihokenshaKankeiCode hihokenshaKankeiCode : HihokenshaKankeiCode.values()) {
            if (hihokenshaKankeiCode.code.equals(code)) {
                return hihokenshaKankeiCode;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("被保険者との関係コード"));
    }
}
