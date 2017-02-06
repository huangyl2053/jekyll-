package jp.co.ndensan.reams.db.dbe.definition.core.dokuji;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 医療機関状況を表す列挙型です。
 * RString型codeは連携データ取込のIF上のコード値
 *
 * @author LDNS 作成者漢字名
 */
public enum IryoKikanJokyo {

    /**
     * isコード:True code:1 名称:有効 略称:定義なし
     */
    有効(true, "1", "有効"),
    /**
     * isコード:False code:2 名称:無効 略称:定義なし
     */
    無効(false, "2", "無効");

    private final boolean isコード;
    private final RString code;
    private final RString fullName;

    private IryoKikanJokyo(boolean isコード, String code, String fullname) {
        this.isコード = isコード;
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 医療機関状況の真偽値を返します。
     *
     * @return 医療機関状況の真偽値
     */
    public boolean isコード() {
        return isコード;
    }
    
    /**
     * 医療機関状況のコードを返します。
     * 
     * @return 医療機関状況のコード
     */
    public RString getCode() {
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
     * 医療機関状況の真偽値と一致する内容を探します。
     *
     * @param isコード 医療機関状況の真偽値
     * @return {@code code} に対応する医療機関状況
     */
    public static IryoKikanJokyo toValue(boolean isコード) {
        for (IryoKikanJokyo iryoKikanJokyo : IryoKikanJokyo.values()) {
            if (iryoKikanJokyo.isコード == isコード) {
                return iryoKikanJokyo;
            }
        }
//        throw new IllegalArgumentException(DcErrorMessages.E09002.getMessage().getMessage());
        return null;
    }

    /**
     * 医療機関状況のコードと一致する内容を探します。
     *
     * @param code 医療機関状況のコード
     * @return {@code code} に対応する医療機関状況
     */
    public static IryoKikanJokyo toValue(RString code) {
        for (IryoKikanJokyo iryoKikanJokyo : IryoKikanJokyo.values()) {
            if (iryoKikanJokyo.getCode().equals(code)) {
                return iryoKikanJokyo;
            }
        }
//        throw new IllegalArgumentException(DcErrorMessages.E09002.getMessage().getMessage());
        return null;
    }
}
