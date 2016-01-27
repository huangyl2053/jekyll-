package jp.co.ndensan.reams.db.dbd.definition.enumeratedtype.core;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 申請者関係コードを表す列挙型です。
 *
 * @author LDNS
 */
public enum ShinseishaKankeiCode {

    /**
     * コード:01 名称:居宅介護支援事業者 略称:定義なし
     */
    居宅介護支援事業者("01", "居宅介護支援事業者"),
    /**
     * コード:02 名称:指定介護老人福祉施設 略称:定義なし
     */
    指定介護老人福祉施設("02", "指定介護老人福祉施設"),
    /**
     * コード:03 名称:指定介護老人保健施設 略称:定義なし
     */
    指定介護老人保健施設("03", "指定介護老人保健施設"),
    /**
     * コード:04 名称:指定介護療養型医療施設 略称:定義なし
     */
    指定介護療養型医療施設("04", "指定介護療養型医療施設"),
    /**
     * コード:05 名称:地域包括支援センター 略称:定義なし
     */
    地域包括支援センター("05", "地域包括支援センター");

    private final RString code;
    private final RString fullName;

    private ShinseishaKankeiCode(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 申請者関係コードのコードを返します。
     *
     * @return 申請者関係コードのコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 申請者関係コードの名称を返します。
     *
     * @return 申請者関係コードの名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 申請者関係コードのコードと一致する内容を探します。
     *
     * @param code 申請者関係コードのコード
     * @return {@code code} に対応する申請者関係コード
     */
    public static ShinseishaKankeiCode toValue(RString code) {

        for (ShinseishaKankeiCode shinseishaKankeiCode : ShinseishaKankeiCode.values()) {
            if (shinseishaKankeiCode.code.equals(code)) {
                return shinseishaKankeiCode;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("申請者関係コード"));
    }
}
