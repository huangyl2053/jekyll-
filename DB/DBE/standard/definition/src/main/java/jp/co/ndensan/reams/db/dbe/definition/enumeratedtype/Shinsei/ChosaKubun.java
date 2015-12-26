package jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.Shinsei;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 調査区分を表す列挙型です。
 *
 * @author LDNS
 */
public enum ChosaKubun {

    /**
     * コード:0 名称:新規調査 略称:定義なし
     */
    新規調査("0", "新規調査"),
    /**
     * コード:1 名称:再調査 略称:定義なし
     */
    再調査("1", "再調査");

    private final RString code;
    private final RString fullName;

    private ChosaKubun(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 調査区分のコードを返します。
     *
     * @return 調査区分のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 調査区分の名称を返します。
     *
     * @return 調査区分の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 調査区分のコードと一致する内容を探します。
     *
     * @param code 調査区分のコード
     * @return {@code code} に対応する調査区分
     */
    public static ChosaKubun toValue(RString code) {

        for (ChosaKubun chosaKubun : ChosaKubun.values()) {
            if (chosaKubun.code.equals(code)) {
                return chosaKubun;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("調査区分"));
    }
}
