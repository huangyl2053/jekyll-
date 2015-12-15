package jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.Ikensho;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 眼科受診の有無を表す列挙型です。
 *
 * @author LDNS
 */
public enum GankaJusihnUmu {

    /**
     * コード:True 名称:あり 略称:定義なし
     */
    あり(true, "あり"),
    /**
     * コード:False 名称:なし 略称:定義なし
     */
    なし(false, "なし");

    private final boolean code;
    private final RString fullName;

    private GankaJusihnUmu(boolean code, String fullname) {
        this.code = code;
        this.fullName = new RString(fullname);
    }

    /**
     * 眼科受診の有無のコードを返します。
     *
     * @return 眼科受診の有無のコード
     */
    public boolean getコード() {
        return code;
    }

    /**
     * 眼科受診の有無の名称を返します。
     *
     * @return 眼科受診の有無の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 眼科受診の有無のコードと一致する内容を探します。
     *
     * @param code 眼科受診の有無のコード
     * @return {@code code} に対応する眼科受診の有無
     */
    public static GankaJusihnUmu toValue(boolean code) {
        for (GankaJusihnUmu gankaJusihnUmu : GankaJusihnUmu.values()) {
            if (gankaJusihnUmu.code == code) {
                return gankaJusihnUmu;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("眼科受診の有無"));
    }
}
