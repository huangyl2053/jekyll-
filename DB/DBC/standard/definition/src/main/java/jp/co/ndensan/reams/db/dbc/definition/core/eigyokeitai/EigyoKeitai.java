package jp.co.ndensan.reams.db.dbc.definition.core.eigyokeitai;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 営業形態を表す列挙型です。
 *
 * @author LDNS
 */
public enum EigyoKeitai {

    /**
     * コード:1 名称:法人 略称:定義なし
     */
    法人("1", "法人"),
    /**
     * コード:2 名称:個人 略称:定義なし
     */
    個人("2", "個人");

    private final RString code;
    private final RString fullName;

    private EigyoKeitai(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 営業形態のコードを返します。
     *
     * @return 営業形態のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 営業形態の名称を返します。
     *
     * @return 営業形態の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 営業形態のコードと一致する内容を探します。
     *
     * @param code 営業形態のコード
     * @return {@code code} に対応する営業形態
     */
    public static EigyoKeitai toValue(RString code) {

        for (EigyoKeitai eigyoKeitai : EigyoKeitai.values()) {
            if (eigyoKeitai.code.equals(code)) {
                return eigyoKeitai;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("営業形態のコード"));
    }
}
