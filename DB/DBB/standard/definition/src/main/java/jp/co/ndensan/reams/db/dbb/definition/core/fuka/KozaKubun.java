package jp.co.ndensan.reams.db.dbb.definition.core.fuka;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 口座区分を表す列挙型です。
 *
 * @author LDNS
 */
public enum KozaKubun {

    /**
     * コード:0 名称:現金納付 略称:定義なし
     */
    現金納付("0", "現金納付"),
    /**
     * コード:1 名称:口座振替 略称:定義なし
     */
    口座振替("1", "口座振替");

    private final RString code;
    private final RString fullName;

    private KozaKubun(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 口座区分のコードを返します。
     *
     * @return 口座区分のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 口座区分の名称を返します。
     *
     * @return 口座区分の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 口座区分のコードと一致する内容を探します。
     *
     * @param code 口座区分のコード
     * @return {@code code} に対応する口座区分
     */
    public static KozaKubun toValue(RString code) {
        for (KozaKubun kozaKubun : KozaKubun.values()) {
            if (kozaKubun.code.equals(code)) {
                return kozaKubun;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("口座区分"));
    }
}
