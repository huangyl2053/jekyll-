package jp.co.ndensan.reams.db.dbe.definition.core.dokuji;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 主治医状況を表す列挙型です。
 *
 * @author LDNS 作成者漢字名
 */
public enum ItakusakiJokyo {

    /**
     * コード:True 名称:有効 略称:定義なし
     */
    有効(true, "1", "有効"),
    /**
     * コード:False 名称:無効 略称:定義なし
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
     * @return 主治医状況のコード
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
     * 主治医状況の名称を返します。
     *
     * @return 主治医状況の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 主治医状況の真偽値と一致する内容を探します。
     *
     * @param is有効 主治医状況の真偽値
     * @return {@code code} に対応する主治医状況
     */
    public static ItakusakiJokyo toValue(boolean is有効) {
        for (ItakusakiJokyo shujiiJokyo : ItakusakiJokyo.values()) {
            if (shujiiJokyo.is有効() == is有効) {
                return shujiiJokyo;
            }
        }
//        throw new IllegalArgumentException(DcErrorMessages.E09002.getMessage().getMessage());
        return null;
    }

    /**
     * 主治医状況のコードと一致する内容を探します。
     *
     * @param code 主治医状況のコード
     * @return {@code code} に対応する主治医状況
     */
    public static ItakusakiJokyo toValue(RString code) {
        for (ItakusakiJokyo shujiiJokyo : ItakusakiJokyo.values()) {
            if (shujiiJokyo.getCode().equals(code)) {
                return shujiiJokyo;
            }
        }
//        throw new IllegalArgumentException(DcErrorMessages.E09002.getMessage().getMessage());
        return null;
    }
}
