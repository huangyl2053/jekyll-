package jp.co.ndensan.reams.db.dbz.definition.core.shotoku;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 激変緩和措置区分を表す列挙型です。
 *
 * @author LDNS
 */
public enum GekihenkanwaSochi {

    /**
     * コード:0 名称:対象外 略称:定義なし
     */
    対象外("0", "対象外"),
    /**
     * コード:1 名称:対象 略称:定義なし
     */
    対象("1", "対象");

    private final RString code;
    private final RString fullName;

    private GekihenkanwaSochi(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 激変緩和措置区分のコードを返します。
     *
     * @return 激変緩和措置区分のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 激変緩和措置区分の名称を返します。
     *
     * @return 激変緩和措置区分の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 激変緩和措置区分のコードと一致する内容を探します。
     *
     * @param code 激変緩和措置区分のコード
     * @return {@code code} に対応する激変緩和措置区分
     */
    public static GekihenkanwaSochi toValue(RString code) {

        for (GekihenkanwaSochi gekihenkanwaSochi : GekihenkanwaSochi.values()) {
            if (gekihenkanwaSochi.code.equals(code)) {
                return gekihenkanwaSochi;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("激変緩和措置区分"));
    }
}
