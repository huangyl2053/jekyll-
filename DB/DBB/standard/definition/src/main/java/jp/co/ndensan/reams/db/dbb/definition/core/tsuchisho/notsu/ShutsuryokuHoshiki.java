package jp.co.ndensan.reams.db.dbb.definition.core.tsuchisho.notsu;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 出力方式を表す列挙型です。
 *
 * @author LDNS
 */
public enum ShutsuryokuHoshiki {

    /**
     * コード:1 名称:全件出力 略称:定義なし
     */
    全件出力("1", "全件出力"),
    /**
     * コード:2 名称:別々出力 略称:定義なし
     */
    別々出力("2", "別々出力");

    private final RString code;
    private final RString fullName;

    private ShutsuryokuHoshiki(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 出力方式のコードを返します。
     *
     * @return 出力方式のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 出力方式の名称を返します。
     *
     * @return 出力方式の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 出力方式のコードと一致する内容を探します。
     *
     * @param code 出力方式のコード
     * @return {@code code} に対応する出力方式
     */
    public static ShutsuryokuHoshiki toValue(RString code) {
        for (ShutsuryokuHoshiki shutsuryokuHoshiki : ShutsuryokuHoshiki.values()) {
            if (shutsuryokuHoshiki.code.equals(code)) {
                return shutsuryokuHoshiki;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("出力方式"));
    }
}
