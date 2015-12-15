package jp.co.ndensan.reams.db.dbz.definition.core.chohyo.kyotsu;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 口座名義人カナ優先区分を表す列挙型です。
 *
 * @author LDNS
 */
public enum KozaMeigininKanaYusenKubun {

    /**
     * コード:0 名称:表示しない 略称:定義なし
     */
    表示しない("0", "表示しない"),
    /**
     * コード:1 名称:表示する 略称:定義なし
     */
    表示する("1", "表示する");

    private final RString code;
    private final RString fullName;

    private KozaMeigininKanaYusenKubun(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 口座名義人カナ優先区分のコードを返します。
     *
     * @return 口座名義人カナ優先区分のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 口座名義人カナ優先区分の名称を返します。
     *
     * @return 口座名義人カナ優先区分の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 口座名義人カナ優先区分のコードと一致する内容を探します。
     *
     * @param code 口座名義人カナ優先区分のコード
     * @return {@code code} に対応する口座名義人カナ優先区分
     */
    public static KozaMeigininKanaYusenKubun toValue(RString code) {

        for (KozaMeigininKanaYusenKubun kozaMeigininKanaYusenKubun : KozaMeigininKanaYusenKubun.values()) {
            if (kozaMeigininKanaYusenKubun.code.equals(code)) {
                return kozaMeigininKanaYusenKubun;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("口座名義人カナ優先区分"));
    }
}
