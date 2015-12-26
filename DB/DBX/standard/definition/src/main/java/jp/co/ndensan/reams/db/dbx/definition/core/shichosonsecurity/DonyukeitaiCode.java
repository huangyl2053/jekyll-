package jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 導入形態コードを表す列挙型です。
 *
 */
public enum DonyukeitaiCode {

    /**
     * コード:111 名称:事務広域 略称:定義なし
     */
    事務広域("111", "事務広域"),
    /**
     * コード:112 名称:事務構成市町村 略称:定義なし
     */
    事務構成市町村("112", "事務構成市町村"),
    /**
     * コード:120 名称:事務単一 略称:定義なし
     */
    事務単一("120", "事務単一"),
    /**
     * コード:211 名称:認定広域 略称:定義なし
     */
    認定広域("211", "認定広域"),
    /**
     * コード:220 名称:認定単一 略称:定義なし
     */
    認定単一("220", "認定単一");

    private final RString code;
    private final RString fullName;

    private DonyukeitaiCode(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 導入形態コードのコードを返します。
     *
     * @return 導入形態コードのコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 導入形態コードの名称を返します。
     *
     * @return 導入形態コードの名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 導入形態コードのコードと一致する内容を探します。
     *
     * @param code 導入形態コードのコード
     * @return {@code code} に対応する導入形態コード
     */
    public static DonyukeitaiCode toValue(RString code) {
        for (DonyukeitaiCode donyukeitaiCode : DonyukeitaiCode.values()) {
            if (donyukeitaiCode.code.equals(code)) {
                return donyukeitaiCode;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("導入形態コード"));
    }
}
