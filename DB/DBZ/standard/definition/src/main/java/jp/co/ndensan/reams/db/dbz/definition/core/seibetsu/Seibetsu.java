package jp.co.ndensan.reams.db.dbz.definition.core.seibetsu;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 性別コードを表す列挙型です。
 *
 * @author LDNS
 */
public enum Seibetsu {

    /**
     * コード:1 名称:男 略称:定義なし
     */
    男("1", "男"),
    /**
     * コード:2 名称:女 略称:定義なし
     */
    女("2", "女");

    private final RString code;
    private final RString fullName;

    private Seibetsu(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 性別コードのコードを返します。
     *
     * @return 性別コードのコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 性別コードの名称を返します。
     *
     * @return 性別コードの名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 性別コードのコードと一致する内容を探します。
     *
     * @param code 性別コードのコード
     * @return {@code code} に対応する性別コード
     */
    public static Seibetsu toValue(RString code) {

        for (Seibetsu seibetsu : Seibetsu.values()) {
            if (seibetsu.code.equals(code)) {
                return seibetsu;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("性別コード"));
    }
}
