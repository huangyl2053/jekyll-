package jp.co.ndensan.reams.db.dbc.definition.core.shoninkubun;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 承認区分を表す列挙型です。
 *
 * @author LDNS
 */
public enum ShoninKubun {

    /**
     * コード:0 名称:承認しない 略称:定義なし
     */
    承認しない("0", "承認しない"),
    /**
     * コード:1 名称:承認する 略称:定義なし
     */
    承認する("1", "承認する");

    private final RString code;
    private final RString fullName;

    private ShoninKubun(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 承認区分のコードを返します。
     *
     * @return 承認区分のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 承認区分の名称を返します。
     *
     * @return 承認区分の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 承認区分のコードと一致する内容を探します。
     *
     * @param code 承認区分のコード
     * @return {@code code} に対応する承認区分
     */
    public static ShoninKubun toValue(RString code) {

        for (ShoninKubun shoninKubun : ShoninKubun.values()) {
            if (shoninKubun.code.equals(code)) {
                return shoninKubun;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("承認区分"));
    }
}
