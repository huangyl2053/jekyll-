package jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.Chosa;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 自地区フラグを表す列挙型です。
 *
 * @author LDNS
 */
public enum JiChikuFlag {

    /**
     * コード:True 名称:自地区 略称:定義なし
     */
    自地区(true, "自地区"),
    /**
     * コード:False 名称:他地区 略称:定義なし
     */
    他地区(false, "他地区");

    private final boolean code;
    private final RString fullName;

    private JiChikuFlag(boolean code, String fullname) {
        this.code = code;
        this.fullName = new RString(fullname);
    }

    /**
     * 自地区フラグのコードを返します。
     *
     * @return 自地区フラグのコード
     */
    public boolean getコード() {
        return code;
    }

    /**
     * 自地区フラグの名称を返します。
     *
     * @return 自地区フラグの名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 自地区フラグのコードと一致する内容を探します。
     *
     * @param code 自地区フラグのコード
     * @return {@code code} に対応する自地区フラグ
     */
    public static JiChikuFlag toValue(boolean code) {
        for (JiChikuFlag jiChikuFlag : JiChikuFlag.values()) {
            if (jiChikuFlag.code == code) {
                return jiChikuFlag;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("自地区フラグ"));
    }
}
