package jp.co.ndensan.reams.db.dbb.definition.core.fuka;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 職権区分を表す列挙型です。
 *
 * @author LDNS
 */
public enum ShokkenKubun {

    /**
     * コード:0 名称:非該当 略称:定義なし
     */
    非該当("0", "非該当"),
    /**
     * コード:1 名称:該当 略称:定義なし
     */
    該当("1", "該当");

    private final RString code;
    private final RString fullName;

    private ShokkenKubun(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 職権区分のコードを返します。
     *
     * @return 職権区分のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 職権区分の名称を返します。
     *
     * @return 職権区分の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 職権区分のコードと一致する内容を探します。
     *
     * @param code 職権区分のコード
     * @return {@code code} に対応する職権区分
     */
    public static ShokkenKubun toValue(RString code) {
        for (ShokkenKubun shokkenKubun : ShokkenKubun.values()) {
            if (shokkenKubun.code.equals(code)) {
                return shokkenKubun;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("職権区分"));
    }
}
