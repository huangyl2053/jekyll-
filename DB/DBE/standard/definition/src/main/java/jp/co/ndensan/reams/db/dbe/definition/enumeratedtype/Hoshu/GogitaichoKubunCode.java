package jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.Hoshu;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 合議体長区分コードを表す列挙型です。
 *
 * @author LDNS
 */
public enum GogitaichoKubunCode {

    /**
     * コード:0 名称:通常 略称:定義なし
     */
    通常("0", "通常"),
    /**
     * コード:1 名称:副合議体長 略称:定義なし
     */
    副合議体長("1", "副合議体長"),
    /**
     * コード:2 名称:合議体長 略称:定義なし
     */
    合議体長("2", "合議体長");

    private final RString code;
    private final RString fullName;

    private GogitaichoKubunCode(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 合議体長区分コードのコードを返します。
     *
     * @return 合議体長区分コードのコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 合議体長区分コードの名称を返します。
     *
     * @return 合議体長区分コードの名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 合議体長区分コードのコードと一致する内容を探します。
     *
     * @param code 合議体長区分コードのコード
     * @return {@code code} に対応する合議体長区分コード
     */
    public static GogitaichoKubunCode toValue(RString code) {

        for (GogitaichoKubunCode gogitaichoKubunCode : GogitaichoKubunCode.values()) {
            if (gogitaichoKubunCode.code.equals(code)) {
                return gogitaichoKubunCode;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("合議体長区分コード"));
    }
}
