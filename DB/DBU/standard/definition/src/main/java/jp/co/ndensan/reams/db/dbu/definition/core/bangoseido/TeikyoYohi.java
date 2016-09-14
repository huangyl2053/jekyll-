package jp.co.ndensan.reams.db.dbu.definition.core.bangoseido;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 提供要否を表す列挙型です。
 *
 * @reamsid_L DBU-9999-023 sunhaidi
 */
public enum TeikyoYohi {

    /**
     * コード:0 名称:提供不要 略称:定義なし
     */
    提供不要("0", "提供不要"),
    /**
     * コード:1 名称:提供要 略称:定義なし
     */
    提供要("1", "提供要");

    private final RString code;
    private final RString fullName;

    private TeikyoYohi(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 提供要否のコードを返します。
     *
     * @return 提供要否のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 提供要否の名称を返します。
     *
     * @return 提供要否の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 提供要否のコードと一致する内容を探します。
     *
     * @param code 提供要否のコード
     * @return {@code code} に対応する提供要否
     */
    public static TeikyoYohi toValue(RString code) {
        for (TeikyoYohi teikyoYohi : TeikyoYohi.values()) {
            if (teikyoYohi.code.equals(code)) {
                return teikyoYohi;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getMessage());
    }
}
