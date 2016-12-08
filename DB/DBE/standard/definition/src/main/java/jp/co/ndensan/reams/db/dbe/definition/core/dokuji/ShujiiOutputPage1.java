package jp.co.ndensan.reams.db.dbe.definition.core.dokuji;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 主治医医療機関・主治医一覧表改頁1を表す列挙型です。
 *
 * @author LDNS 作成者漢字名
 */
public enum ShujiiOutputPage1 {

    /**
     * コード:1 名称:主治医医療機関コード毎 略称:定義なし
     */
    主治医医療機関コード毎("1", "主治医医療機関コード毎"),
    /**
     * コード:2 名称: 略称:定義なし
     */
    なし("2", "なし");

    private final RString code;
    private final RString fullName;

    private ShujiiOutputPage1(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 主治医医療機関・主治医一覧表改頁1のコードを返します。
     *
     * @return 主治医医療機関・主治医一覧表改頁1のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 主治医医療機関・主治医一覧表改頁1の名称を返します。
     *
     * @return 主治医医療機関・主治医一覧表改頁1の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 主治医医療機関・主治医一覧表改頁1のコードと一致する内容を探します。
     *
     * @param code 主治医医療機関・主治医一覧表改頁1のコード
     * @return {@code code} に対応する主治医医療機関・主治医一覧表改頁1
     */
    public static ShujiiOutputPage1 toValue(RString code) {
//        requireNonNull(code, DcErrorMessages.E00001.getMessage().getMessage());
        for (ShujiiOutputPage1 shujiiOutputPage1 : ShujiiOutputPage1.values()) {
            if (shujiiOutputPage1.code.equals(code)) {
                return shujiiOutputPage1;
            }
        }
//        throw new IllegalArgumentException(DcErrorMessages.E09002.getMessage().getMessage());
        return null;
    }
}
