package jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.core;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 指定医フラグを表す列挙型です。
 *
 * @author LDNS
 */
public enum ShiteiiFlg {

    /**
     * コード:0 名称:指定医になれる 略称:定義なし
     */
    指定医になれる("0", "指定医になれる"),
    /**
     * コード:1 名称:なれない 略称:定義なし
     */
    なれない("1", "なれない");

    private final RString code;
    private final RString fullName;

    private ShiteiiFlg(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 指定医フラグのコードを返します。
     *
     * @return 指定医フラグのコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 指定医フラグの名称を返します。
     *
     * @return 指定医フラグの名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 指定医フラグのコードと一致する内容を探します。
     *
     * @param code 指定医フラグのコード
     * @return {@code code} に対応する指定医フラグ
     */
    public static ShiteiiFlg toValue(RString code) {

        for (ShiteiiFlg shiteiiFlg : ShiteiiFlg.values()) {
            if (shiteiiFlg.code.equals(code)) {
                return shiteiiFlg;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("指定医フラグ"));
    }
}
