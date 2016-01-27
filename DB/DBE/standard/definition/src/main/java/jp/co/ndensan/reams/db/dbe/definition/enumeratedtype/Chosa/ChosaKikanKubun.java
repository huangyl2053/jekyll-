package jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.Chosa;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 機関の区分を表す列挙型です。
 *
 * @author LDNS
 */
public enum ChosaKikanKubun {

    /**
     * コード:0 名称:非調査機関 略称:定義なし
     */
    非調査機関("0", "非調査機関"),
    /**
     * コード:1 名称:調査機関 略称:定義なし
     */
    調査機関("1", "調査機関");

    private final RString code;
    private final RString fullName;

    private ChosaKikanKubun(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 機関の区分のコードを返します。
     *
     * @return 機関の区分のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 機関の区分の名称を返します。
     *
     * @return 機関の区分の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 機関の区分のコードと一致する内容を探します。
     *
     * @param code 機関の区分のコード
     * @return {@code code} に対応する機関の区分
     */
    public static ChosaKikanKubun toValue(RString code) {

        for (ChosaKikanKubun chosaKikanKubun : ChosaKikanKubun.values()) {
            if (chosaKikanKubun.code.equals(code)) {
                return chosaKikanKubun;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("機関の区分"));
    }
}
