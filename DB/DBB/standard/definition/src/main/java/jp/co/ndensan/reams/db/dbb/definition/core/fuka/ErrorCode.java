package jp.co.ndensan.reams.db.dbb.definition.core.fuka;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * エラーコードを表す列挙型です。
 *
 * @author LDNS
 */
public enum ErrorCode {

    /**
     * コード:0801 名称:被保険者台帳データなし 略称:定義なし
     */
    被保険者台帳データなし("0801", "被保険者台帳データなし"),
    /**
     * コード:02 名称:資格と住基に不整合あり 略称:定義なし
     */
    資格と住基に不整合あり("02", "資格と住基に不整合あり"),
    /**
     * コード:03 名称:世帯員所得データなし 略称:定義なし
     */
    世帯員所得データなし("03", "世帯員所得データなし"),
    /**
     * コード:04 名称:賦課に減免あり 略称:定義なし
     */
    賦課に減免あり("04", "賦課に減免あり");

    private final RString code;
    private final RString fullName;

    private ErrorCode(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * エラーコードのコードを返します。
     *
     * @return エラーコードのコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * エラーコードの名称を返します。
     *
     * @return エラーコードの名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * エラーコードのコードと一致する内容を探します。
     *
     * @param code エラーコードのコード
     * @return {@code code} に対応するエラーコード
     */
    public static ErrorCode toValue(RString code) {
        for (ErrorCode errorCode : ErrorCode.values()) {
            if (errorCode.code.equals(code)) {
                return errorCode;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("エラーコード"));
    }
}
