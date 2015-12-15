package jp.co.ndensan.reams.db.dbd.definition.enumeratedtype.core;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 支払方法変更差止対象フラグを表す列挙型です。
 *
 * @author LDNS
 */
public enum ShiharaiHenkoSashitomeTaishoFlag {

    /**
     * コード:0 名称:差止対象外 略称:定義なし
     */
    差止対象外("0", "差止対象外"),
    /**
     * コード:1 名称:差止対象 略称:定義なし
     */
    差止対象("1", "差止対象");

    private final RString code;
    private final RString fullName;

    private ShiharaiHenkoSashitomeTaishoFlag(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 支払方法変更差止対象フラグのコードを返します。
     *
     * @return 支払方法変更差止対象フラグのコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 支払方法変更差止対象フラグの名称を返します。
     *
     * @return 支払方法変更差止対象フラグの名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 支払方法変更差止対象フラグのコードと一致する内容を探します。
     *
     * @param code 支払方法変更差止対象フラグのコード
     * @return {@code code} に対応する支払方法変更差止対象フラグ
     */
    public static ShiharaiHenkoSashitomeTaishoFlag toValue(RString code) {

        for (ShiharaiHenkoSashitomeTaishoFlag value : ShiharaiHenkoSashitomeTaishoFlag.values()) {
            if (value.code.equals(code)) {
                return value;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("支払方法変更差止対象フラグ"));
    }
}
