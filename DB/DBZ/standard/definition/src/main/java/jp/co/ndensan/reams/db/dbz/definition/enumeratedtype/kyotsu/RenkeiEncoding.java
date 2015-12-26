package jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.kyotsu;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 連携エンコーディングを表す列挙型です。
 *
 * @author LDNS
 */
public enum RenkeiEncoding {

    /**
     * コード:無し 名称:Shift-Jis 略称:定義なし
     */
    Shift_Jis("Shift-Jis"),
    /**
     * コード:無し 名称:Unicode 略称:定義なし
     */
    Unicode("Unicode"),
    /**
     * コード:無し 名称:UTF-7 略称:定義なし
     */
    UTF_7("UTF-7"),
    /**
     * コード:無し 名称:UTF-8 略称:定義なし
     */
    UTF_8("UTF-8");

    private final RString fullName;

    private RenkeiEncoding(String fullname) {
        this.fullName = new RString(fullname);
    }

    /**
     * 連携エンコーディングの名称を返します。
     *
     * @return 連携エンコーディングの名称
     */
    public RString get名称() {
        return fullName;
    }

}
