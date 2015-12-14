package jp.co.ndensan.reams.db.dbb.definition.core.tsuchisho.notsu;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 出力形式を表す列挙型です。
 *
 * @author LDNS
 */
public enum ShutsuryokuKeishiki {

    /**
     * コード:1 名称:現金 略称:定義なし
     */
    現金("1", "現金"),
    /**
     * コード:2 名称:口座 略称:定義なし
     */
    口座("2", "口座");

    private final RString code;
    private final RString fullName;

    private ShutsuryokuKeishiki(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 出力形式のコードを返します。
     *
     * @return 出力形式のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 出力形式の名称を返します。
     *
     * @return 出力形式の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 出力形式のコードと一致する内容を探します。
     *
     * @param code 出力形式のコード
     * @return {@code code} に対応する出力形式
     */
    public static ShutsuryokuKeishiki toValue(RString code) {
        for (ShutsuryokuKeishiki shutsuryokuKeishiki : ShutsuryokuKeishiki.values()) {
            if (shutsuryokuKeishiki.code.equals(code)) {
                return shutsuryokuKeishiki;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("出力形式"));
    }
}
