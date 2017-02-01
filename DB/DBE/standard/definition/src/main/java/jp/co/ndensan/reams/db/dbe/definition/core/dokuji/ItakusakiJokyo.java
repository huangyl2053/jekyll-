package jp.co.ndensan.reams.db.dbe.definition.core.dokuji;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 委託先状況を表す列挙型です。
 * RString型codeは連携データ取込のIF上のコード値
 *
 * @author LDNS 作成者漢字名
 */
public enum ItakusakiJokyo {

    /**
     * is有効:True code:1 名称:有効 略称:定義なし
     */
    有効(true, "1", "有効"),
    /**
     * is有効:False code:2 名称:無効 略称:定義なし
     */
    無効(false, "2", "無効");

    private final RString fullName;
    private final boolean is有効;
    private final RString code;

    private ItakusakiJokyo(boolean is有効, String code, String fullname) {
        this.is有効 = is有効;
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 委託先状況が有効であるかどうかを返します。
     *
     * @return 委託先状況のコード
     */
    public boolean is有効() {
        return is有効;
    }

    /**
     * 状況コードを返します。
     *
     * @return 状況コード
     */
    public RString getCode() {
        return code;
    }

    /**
     * 委託先状況の名称を返します。
     *
     * @return 委託先状況の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 委託先状況の真偽値と一致する内容を探します。
     *
     * @param is有効 委託先状況の真偽値
     * @return {@code code} に対応する委託先状況
     */
    public static ItakusakiJokyo toValue(boolean is有効) {
        for (ItakusakiJokyo itakusakiJokyo : ItakusakiJokyo.values()) {
            if (itakusakiJokyo.is有効() == is有効) {
                return itakusakiJokyo;
            }
        }
//        throw new IllegalArgumentException(DcErrorMessages.E09002.getMessage().getMessage());
        return null;
    }

    /**
     * 委託先状況のコードと一致する内容を探します。
     *
     * @param code 委託先状況のコード
     * @return {@code code} に対応する委託先状況
     */
    public static ItakusakiJokyo toValue(RString code) {
        for (ItakusakiJokyo itakusakiJokyo : ItakusakiJokyo.values()) {
            if (itakusakiJokyo.getCode().equals(code)) {
                return itakusakiJokyo;
            }
        }
//        throw new IllegalArgumentException(DcErrorMessages.E09002.getMessage().getMessage());
        return null;
    }
}
