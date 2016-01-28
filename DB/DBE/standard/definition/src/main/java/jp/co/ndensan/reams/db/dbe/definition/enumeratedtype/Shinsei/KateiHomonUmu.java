package jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.Shinsei;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 家庭訪問の有無を表す列挙型です。
 *
 * @author LDNS
 */
public enum KateiHomonUmu {

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

    private KateiHomonUmu(boolean code, String fullname) {
        this.code = code;
        this.fullName = new RString(fullname);
    }

    /**
     * 家庭訪問の有無のコードを返します。
     *
     * @return 家庭訪問の有無のコード
     */
    public boolean getコード() {
        return code;
    }

    /**
     * 家庭訪問の有無の名称を返します。
     *
     * @return 家庭訪問の有無の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 家庭訪問の有無のコードと一致する内容を探します。
     *
     * @param code 家庭訪問の有無のコード
     * @return {@code code} に対応する家庭訪問の有無
     */
    public static KateiHomonUmu toValue(boolean code) {
        for (KateiHomonUmu kateiHomonUmu : KateiHomonUmu.values()) {
            if (kateiHomonUmu.code == code) {
                return kateiHomonUmu;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("家庭訪問の有無"));
    }
}
