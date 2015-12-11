package jp.co.ndensan.reams.db.dbe.service.core.DBE5210001;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.dc.dca.definition.message.DcErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 性別コードを表す列挙型です。
 *
 * @author LDNS 作成者漢字名
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
        requireNonNull(code, DcErrorMessages.E00002.getMessage().getMessage());
        for (Seibetsu seibetsu : Seibetsu.values()) {
            if (seibetsu.code.equals(code)) {
                return seibetsu;
            }
        }
        throw new IllegalArgumentException(DcErrorMessages.E09002.getMessage().getMessage());
    }
}
