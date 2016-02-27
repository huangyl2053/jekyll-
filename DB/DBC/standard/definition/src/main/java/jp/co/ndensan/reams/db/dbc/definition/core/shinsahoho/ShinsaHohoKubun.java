package jp.co.ndensan.reams.db.dbc.definition.core.shinsahoho;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 審査方法区分を表す列挙型です。
 *
 * @author LDNS
 */
public enum ShinsaHohoKubun {

    /**
     * コード:1 名称:審査依頼 略称:定義なし
     */
    審査依頼("1", "審査依頼"),
    /**
     * コード:2 名称:審査済み 略称:定義なし
     */
    審査済み("2", "審査済み");

    private final RString code;
    private final RString fullName;

    private ShinsaHohoKubun(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 審査方法区分のコードを返します。
     *
     * @return 審査方法区分のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 審査方法区分の名称を返します。
     *
     * @return 審査方法区分の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 審査方法区分のコードと一致する内容を探します。
     *
     * @param code 審査方法区分のコード
     * @return {@code code} に対応する審査方法区分
     */
    public static ShinsaHohoKubun toValue(RString code) {

        for (ShinsaHohoKubun shinsaHohoKubun : ShinsaHohoKubun.values()) {
            if (shinsaHohoKubun.code.equals(code)) {
                return shinsaHohoKubun;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("審査方法区分"));
    }
}
