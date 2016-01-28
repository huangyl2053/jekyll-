package jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.Chosa;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 現在のサービス区分コードを表す列挙型です。
 *
 * @author LDNS
 */
public enum ServiceKubunCode {

    /**
     * コード:1 名称:予防給付サービス 略称:定義なし
     */
    予防給付サービス("1", "予防給付サービス"),
    /**
     * コード:2 名称:介護給付サービス 略称:定義なし
     */
    介護給付サービス("2", "介護給付サービス"),
    /**
     * コード:9 名称:なし 略称:定義なし
     */
    なし("9", "なし");

    private final RString code;
    private final RString fullName;

    private ServiceKubunCode(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 現在のサービス区分コードのコードを返します。
     *
     * @return 現在のサービス区分コードのコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 現在のサービス区分コードの名称を返します。
     *
     * @return 現在のサービス区分コードの名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 現在のサービス区分コードのコードと一致する内容を探します。
     *
     * @param code 現在のサービス区分コードのコード
     * @return {@code code} に対応する現在のサービス区分コード
     */
    public static ServiceKubunCode toValue(RString code) {

        for (ServiceKubunCode serviceKubunCode : ServiceKubunCode.values()) {
            if (serviceKubunCode.code.equals(code)) {
                return serviceKubunCode;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("現在のサービス区分コード"));
    }
}
