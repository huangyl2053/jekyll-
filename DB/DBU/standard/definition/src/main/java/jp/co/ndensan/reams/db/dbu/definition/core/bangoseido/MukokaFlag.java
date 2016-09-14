package jp.co.ndensan.reams.db.dbu.definition.core.bangoseido;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 無効化フラグを表す列挙型です。
 *
 * @reamsid_L DBU-9999-023 sunhaidi
 */
public enum MukokaFlag {

    /**
     * コード:0 名称:有効 略称:定義なし
     */
    有効("0", "有効"),

    /**
     * コード:1 名称:無効 略称:定義なし
     */
    無効("1", "無効");

    private final RString code;
    private final RString fullName;

    private MukokaFlag(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 無効化フラグのコードを返します。
     *
     * @return 無効化フラグのコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 無効化フラグの名称を返します。
     *
     * @return 無効化フラグの名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 無効化フラグのコードと一致する内容を探します。
     *
     * @param code 無効化フラグのコード
     * @return {@code code} に対応する無効化フラグ
     */
    public static MukokaFlag toValue(RString code) {
        for (MukokaFlag mukokaFlag : MukokaFlag.values()) {
            if (mukokaFlag.code.equals(code)) {
                return mukokaFlag;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getMessage());
    }
}
