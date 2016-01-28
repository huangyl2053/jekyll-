package jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.Ikensho;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 整形外科受診の有無を表す列挙型です。
 *
 * @author LDNS
 */
public enum IsSeikeigekaJushinUmu {

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

    private IsSeikeigekaJushinUmu(boolean code, String fullname) {
        this.code = code;
        this.fullName = new RString(fullname);
    }

    /**
     * 整形外科受診の有無のコードを返します。
     *
     * @return 整形外科受診の有無のコード
     */
    public boolean getコード() {
        return code;
    }

    /**
     * 整形外科受診の有無の名称を返します。
     *
     * @return 整形外科受診の有無の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 整形外科受診の有無のコードと一致する内容を探します。
     *
     * @param code 整形外科受診の有無のコード
     * @return {@code code} に対応する整形外科受診の有無
     */
    public static IsSeikeigekaJushinUmu toValue(boolean code) {
        for (IsSeikeigekaJushinUmu isSeikeigekaJushinUmu : IsSeikeigekaJushinUmu.values()) {
            if (isSeikeigekaJushinUmu.code == code) {
                return isSeikeigekaJushinUmu;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("整形外科受診の有無"));
    }
}
