package jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.Dokuji;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 医療機関状況を表す列挙型です。
 * 
 * @author LDNS 作成者漢字名
 */
public enum IryoKikanJokyo {

    /**
     * コード:True 名称:有効 略称:定義なし
     */
    有効(true, "有効"),

    /**
     * コード:False 名称:無効 略称:定義なし
     */
    無効(false, "無効");

    private final boolean code;
    private final RString fullName;

    private IryoKikanJokyo(boolean code, String fullname) {
        this.code = code;
        this.fullName = new RString(fullname);
    }

    /**
     * 医療機関状況のコードを返します。
     * 
     * @return 医療機関状況のコード
     */
    public boolean getコード() {
        return code;
    }

    /**
     * 医療機関状況の名称を返します。
     * 
     * @return 医療機関状況の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 医療機関状況のコードと一致する内容を探します。
     * 
     * @param code 医療機関状況のコード
     * @return {@code code} に対応する医療機関状況
     */
    public static IryoKikanJokyo toValue(boolean code) {
        for (IryoKikanJokyo iryoKikanJokyo : IryoKikanJokyo.values()) {
            if (iryoKikanJokyo.code == code) {
                return iryoKikanJokyo;
            }
        }
//        throw new IllegalArgumentException(DcErrorMessages.E09002.getMessage().getMessage());
        return null;
    }
}
