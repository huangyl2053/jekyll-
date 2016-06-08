package jp.co.ndensan.reams.db.dbc.definition.core.shinnsanaiyo;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 審査内容区分を表す列挙型です。
 *
 * @author LDNS
 */
public enum ShinsaNaiyoKubun {

    /**
     * コード:1 名称:承認する 略称:定義なし
     */
    承認する("1", "承認する"),
    /**
     * コード:2 名称:却下する 略称:定義なし
     */
    却下する("2", "却下する");

    private final RString code;
    private final RString fullName;

    private ShinsaNaiyoKubun(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 審査内容区分のコードを返します。
     *
     * @return 審査内容区分のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 審査内容区分の名称を返します。
     *
     * @return 審査内容区分の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 審査内容区分のコードと一致する内容を探します。
     *
     * @param code 審査内容区分のコード
     * @return {@code code} に対応する審査内容区分
     */
    public static ShinsaNaiyoKubun toValue(RString code) {

        for (ShinsaNaiyoKubun shinsaNaiyoKubun : ShinsaNaiyoKubun.values()) {
            if (shinsaNaiyoKubun.code.equals(code)) {
                return shinsaNaiyoKubun;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("審査内容区分"));
    }
}
