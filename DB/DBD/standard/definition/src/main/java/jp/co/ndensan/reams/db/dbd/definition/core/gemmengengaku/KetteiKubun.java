package jp.co.ndensan.reams.db.dbd.definition.core.gemmengengaku;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 決定区分を表す列挙型です。
 *
 * @author LDNS
 */
public enum KetteiKubun {

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

    private KetteiKubun(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 決定区分のコードを返します。
     *
     * @return 決定区分のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 決定区分の名称を返します。
     *
     * @return 決定区分の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 決定区分のコードと一致する内容を探します。
     *
     * @param code 決定区分のコード
     * @return {@code code} に対応する決定区分
     */
    public static KetteiKubun toValue(RString code) {
        for (KetteiKubun ketteiKubun : KetteiKubun.values()) {
            if (ketteiKubun.code.equals(code)) {
                return ketteiKubun;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("決定区分"));
    }
}
