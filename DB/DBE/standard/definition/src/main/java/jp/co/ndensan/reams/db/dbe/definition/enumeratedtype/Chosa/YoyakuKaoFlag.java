package jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.Chosa;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 予約可能フラグを表す列挙型です。
 *
 * @author LDNS
 */
public enum YoyakuKaoFlag {

    /**
     * コード:True 名称:可能 略称:定義なし
     */
    可能(true, "可能"),
    /**
     * コード:False 名称:不可能 略称:定義なし
     */
    不可能(false, "不可能");

    private final boolean code;
    private final RString fullName;

    private YoyakuKaoFlag(boolean code, String fullname) {
        this.code = code;
        this.fullName = new RString(fullname);
    }

    /**
     * 予約可能フラグのコードを返します。
     *
     * @return 予約可能フラグのコード
     */
    public boolean getコード() {
        return code;
    }

    /**
     * 予約可能フラグの名称を返します。
     *
     * @return 予約可能フラグの名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 予約可能フラグのコードと一致する内容を探します。
     *
     * @param code 予約可能フラグのコード
     * @return {@code code} に対応する予約可能フラグ
     */
    public static YoyakuKaoFlag toValue(boolean code) {
        for (YoyakuKaoFlag yoyakuKaoFlag : YoyakuKaoFlag.values()) {
            if (yoyakuKaoFlag.code == code) {
                return yoyakuKaoFlag;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("予約可能フラグ"));
    }
}
