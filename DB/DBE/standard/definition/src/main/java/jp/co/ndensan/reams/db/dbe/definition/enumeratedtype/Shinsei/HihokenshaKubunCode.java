package jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.Shinsei;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 被保険者区分コードを表す列挙型です。
 *
 * @author LDNS
 */
public enum HihokenshaKubunCode {

    /**
     * コード:1 名称:第１号被保険者 略称:定義なし
     */
    第１号被保険者("1", "第１号被保険者"),
    /**
     * コード:2 名称:第２号被保険者 略称:定義なし
     */
    第２号被保険者("2", "第２号被保険者"),
    /**
     * コード:3 名称:その他 略称:定義なし
     */
    その他("3", "その他");

    private final RString code;
    private final RString fullName;

    private HihokenshaKubunCode(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 被保険者区分コードのコードを返します。
     *
     * @return 被保険者区分コードのコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 被保険者区分コードの名称を返します。
     *
     * @return 被保険者区分コードの名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 被保険者区分コードのコードと一致する内容を探します。
     *
     * @param code 被保険者区分コードのコード
     * @return {@code code} に対応する被保険者区分コード
     */
    public static HihokenshaKubunCode toValue(RString code) {

        for (HihokenshaKubunCode hihokenshaKubunCode : HihokenshaKubunCode.values()) {
            if (hihokenshaKubunCode.code.equals(code)) {
                return hihokenshaKubunCode;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("被保険者区分コード"));
    }
}
