package jp.co.ndensan.reams.db.dbd.definition.enumeratedtype.core;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 支払方法変更弁明理由コードを表す列挙型です。
 *
 * @author LDNS
 */
public enum ShiharaiHenkoBenmeiRiyuCode {

    /**
     * コード:01 名称:公費負担医療の受給 略称:定義なし
     */
    公費負担医療の受給("01", "公費負担医療の受給"),
    /**
     * コード:02 名称:災害 略称:定義なし
     */
    災害("02", "災害"),
    /**
     * コード:03 名称:重大な障害または長期入院 略称:定義なし
     */
    重大な障害または長期入院("03", "重大な障害または長期入院"),
    /**
     * コード:04 名称:滞納保険料の減少 略称:定義なし
     */
    滞納保険料の減少("04", "滞納保険料の減少"),
    /**
     * コード:05 名称:保険料完納 略称:定義なし
     */
    保険料完納("05", "保険料完納"),
    /**
     * コード:99 名称:その他 略称:定義なし
     */
    その他("99", "その他");

    private final RString code;
    private final RString fullName;

    private ShiharaiHenkoBenmeiRiyuCode(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 支払方法変更弁明理由コードのコードを返します。
     *
     * @return 支払方法変更弁明理由コードのコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 支払方法変更弁明理由コードの名称を返します。
     *
     * @return 支払方法変更弁明理由コードの名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 支払方法変更弁明理由コードのコードと一致する内容を探します。
     *
     * @param code 支払方法変更弁明理由コードのコード
     * @return {@code code} に対応する支払方法変更弁明理由コード
     */
    public static ShiharaiHenkoBenmeiRiyuCode toValue(RString code) {

        for (ShiharaiHenkoBenmeiRiyuCode shiharaiHenkoBenmeiRiyuCode : ShiharaiHenkoBenmeiRiyuCode.values()) {
            if (shiharaiHenkoBenmeiRiyuCode.code.equals(code)) {
                return shiharaiHenkoBenmeiRiyuCode;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("支払方法変更弁明理由コード"));
    }
}
