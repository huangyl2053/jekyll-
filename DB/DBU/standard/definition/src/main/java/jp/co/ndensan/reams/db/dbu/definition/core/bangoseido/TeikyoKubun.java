package jp.co.ndensan.reams.db.dbu.definition.core.bangoseido;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 提供区分を表す列挙型です。
 *
 * @reamsid_L DBU-9999-023 sunhaidi
 */
public enum TeikyoKubun {

    /**
     * コード:0 名称:提供済み 略称:定義なし
     */
    提供済み("0", "提供済み"),
    /**
     * コード:1 名称:個人番号未設定により未提供 略称:定義なし
     */
    個人番号未設定により未提供("1", "個人番号未設定により未提供"),
    /**
     * コード:2 名称:その他エラーにより未提供 略称:定義なし
     */
    その他エラーにより未提供("2", "その他エラーにより未提供");

    private final RString code;
    private final RString fullName;

    private TeikyoKubun(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 提供区分のコードを返します。
     *
     * @return 提供区分のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 提供区分の名称を返します。
     *
     * @return 提供区分の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 提供区分のコードと一致する内容を探します。
     *
     * @param code 提供区分のコード
     * @return {@code code} に対応する提供区分
     */
    public static TeikyoKubun toValue(RString code) {
        for (TeikyoKubun teikyoKubun : TeikyoKubun.values()) {
            if (teikyoKubun.code.equals(code)) {
                return teikyoKubun;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getMessage());
    }
}
