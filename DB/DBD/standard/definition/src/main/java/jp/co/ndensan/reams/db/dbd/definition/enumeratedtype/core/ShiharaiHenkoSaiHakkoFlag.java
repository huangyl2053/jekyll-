package jp.co.ndensan.reams.db.dbd.definition.enumeratedtype.core;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 支払方法変更再発行フラグを表す列挙型です。
 *
 * @author LDNS
 */
public enum ShiharaiHenkoSaiHakkoFlag {

    /**
     * コード:0 名称:再発行対象外 略称:定義なし
     */
    再発行対象外("0", "再発行対象外"),
    /**
     * コード:1 名称:再発行対象 略称:定義なし
     */
    再発行対象("1", "再発行対象");

    private final RString code;
    private final RString fullName;

    private ShiharaiHenkoSaiHakkoFlag(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 支払方法変更再発行フラグのコードを返します。
     *
     * @return 支払方法変更再発行フラグのコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 支払方法変更再発行フラグの名称を返します。
     *
     * @return 支払方法変更再発行フラグの名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 支払方法変更再発行フラグのコードと一致する内容を探します。
     *
     * @param code 支払方法変更再発行フラグのコード
     * @return {@code code} に対応する支払方法変更再発行フラグ
     */
    public static ShiharaiHenkoSaiHakkoFlag toValue(RString code) {

        for (ShiharaiHenkoSaiHakkoFlag shiharaiHenkoSaiHakkoFlag : ShiharaiHenkoSaiHakkoFlag.values()) {
            if (shiharaiHenkoSaiHakkoFlag.code.equals(code)) {
                return shiharaiHenkoSaiHakkoFlag;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("支払方法変更再発行フラグ"));
    }
}
