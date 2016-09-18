package jp.co.ndensan.reams.db.dbu.definition.core.bangoseido;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 特定個人情報項目区分を表す列挙型です。
 *
 * @reamsid_L DBU-9999-023 sunhaidi
 */
public enum TokuteiKojinJohoKomokuKubun {

    /**
     * コード:1 名称:情報HD 略称:定義なし
     */
    情報HD("1", "情報HD"),

    /**
     * コード:2 名称:繰返し項目 略称:定義なし
     */
    繰返し項目("2", "繰返し項目"),

    /**
     * コード:3 名称:日付項目 略称:定義なし
     */
    日付項目("3", "日付項目"),

    /**
     * コード:4 名称:個別項目 略称:定義なし
     */
    個別項目("4", "個別項目");

    private final RString code;
    private final RString fullName;

    private TokuteiKojinJohoKomokuKubun(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 特定個人情報項目区分のコードを返します。
     *
     * @return 特定個人情報項目区分のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 特定個人情報項目区分の名称を返します。
     *
     * @return 特定個人情報項目区分の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 特定個人情報項目区分のコードと一致する内容を探します。
     *
     * @param code 特定個人情報項目区分のコード
     * @return {@code code} に対応する特定個人情報項目区分
     */
    public static TokuteiKojinJohoKomokuKubun toValue(RString code) {
        for (TokuteiKojinJohoKomokuKubun tokuteiKojinJohoKomokuKubun : TokuteiKojinJohoKomokuKubun.values()) {
            if (tokuteiKojinJohoKomokuKubun.code.equals(code)) {
                return tokuteiKojinJohoKomokuKubun;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getMessage());
    }
}
