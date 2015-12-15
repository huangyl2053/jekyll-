package jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.Ikensho;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 主たる原因疾患を表す列挙型です。
 *
 * @author LDNS
 */
public enum IsShutaruGeninShikkan {

    /**
     * コード:True 名称:主たる原因 略称:定義なし
     */
    主たる原因(true, "主たる原因"),
    /**
     * コード:False 名称:主たる原因ではない 略称:定義なし
     */
    主たる原因ではない(false, "主たる原因ではない");

    private final boolean code;
    private final RString fullName;

    private IsShutaruGeninShikkan(boolean code, String fullname) {
        this.code = code;
        this.fullName = new RString(fullname);
    }

    /**
     * 主たる原因疾患のコードを返します。
     *
     * @return 主たる原因疾患のコード
     */
    public boolean getコード() {
        return code;
    }

    /**
     * 主たる原因疾患の名称を返します。
     *
     * @return 主たる原因疾患の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 主たる原因疾患のコードと一致する内容を探します。
     *
     * @param code 主たる原因疾患のコード
     * @return {@code code} に対応する主たる原因疾患
     */
    public static IsShutaruGeninShikkan toValue(boolean code) {
        for (IsShutaruGeninShikkan isShutaruGeninShikkan : IsShutaruGeninShikkan.values()) {
            if (isShutaruGeninShikkan.code == code) {
                return isShutaruGeninShikkan;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("主たる原因疾患"));
    }
}
