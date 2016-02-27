package jp.co.ndensan.reams.db.dbc.definition.core.saihakkokubun;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 再発行区分を表す列挙型です。
 *
 * @author LDNS
 */
public enum SaihakkoKubun {

    /**
     * コード:1 名称:再発行する 略称:定義なし
     */
    再発行する("1", "再発行する"),
    /**
     * コード:0 名称:再発行しない 略称:定義なし
     */
    再発行しない("0", "再発行しない");

    private final RString code;
    private final RString fullName;

    private SaihakkoKubun(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 再発行区分のコードを返します。
     *
     * @return 再発行区分のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 再発行区分の名称を返します。
     *
     * @return 再発行区分の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 再発行区分のコードと一致する内容を探します。
     *
     * @param code 再発行区分のコード
     * @return {@code code} に対応する再発行区分
     */
    public static SaihakkoKubun toValue(RString code) {

        for (SaihakkoKubun saihakkoKubun : SaihakkoKubun.values()) {
            if (saihakkoKubun.code.equals(code)) {
                return saihakkoKubun;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("再発行区分"));
    }
}
