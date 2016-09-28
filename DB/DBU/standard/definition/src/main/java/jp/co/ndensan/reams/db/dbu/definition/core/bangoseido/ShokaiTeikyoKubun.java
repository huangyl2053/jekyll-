package jp.co.ndensan.reams.db.dbu.definition.core.bangoseido;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 初回提供区分を表す列挙型です。
 *
 * @reamsid_L DBU-9999-023 sunhaidi
 */
public enum ShokaiTeikyoKubun {

    /**
     * コード:0 名称:未提供 略称:定義なし
     */
    未提供("0", "未提供"),

    /**
     * コード:1 名称:初回提供済み 略称:定義なし
     */
    初回提供済み("1", "初回提供済み");

    private final RString code;
    private final RString fullName;

    private ShokaiTeikyoKubun(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 初回提供区分のコードを返します。
     *
     * @return 初回提供区分のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 初回提供区分の名称を返します。
     *
     * @return 初回提供区分の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 初回提供区分のコードと一致する内容を探します。
     *
     * @param code 初回提供区分のコード
     * @return {@code code} に対応する初回提供区分
     */
    public static ShokaiTeikyoKubun toValue(RString code) {
        for (ShokaiTeikyoKubun shokaiTeikyoKubun : ShokaiTeikyoKubun.values()) {
            if (shokaiTeikyoKubun.code.equals(code)) {
                return shokaiTeikyoKubun;
            }
        }
       throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getMessage());
    }
}
