package jp.co.ndensan.reams.db.dbb.definition.core.tsuchisho.notsu;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * コンビニ期毎出力を表す列挙型です。
 *
 * @author LDNS
 */
public enum KigotoShutsuryoku {

    /**
     * コード:0 名称:通常出力 略称:定義なし
     */
    通常出力("0", "通常出力"),
    /**
     * コード:1 名称:期毎出力 略称:定義なし
     */
    期毎出力("1", "期毎出力");

    private final RString code;
    private final RString fullName;

    private KigotoShutsuryoku(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * コンビニ期毎出力のコードを返します。
     *
     * @return コンビニ期毎出力のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * コンビニ期毎出力の名称を返します。
     *
     * @return コンビニ期毎出力の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * コンビニ期毎出力のコードと一致する内容を探します。
     *
     * @param code コンビニ期毎出力のコード
     * @return {@code code} に対応するコンビニ期毎出力
     */
    public static KigotoShutsuryoku toValue(RString code) {
        for (KigotoShutsuryoku kigotoShutsuryoku : KigotoShutsuryoku.values()) {
            if (kigotoShutsuryoku.code.equals(code)) {
                return kigotoShutsuryoku;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("コンビニ期毎出力"));
    }
}
