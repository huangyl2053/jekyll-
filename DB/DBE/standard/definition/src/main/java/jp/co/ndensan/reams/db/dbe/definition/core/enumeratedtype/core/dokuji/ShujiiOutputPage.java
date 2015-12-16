package jp.co.ndensan.reams.db.dbe.definition.core.enumeratedtype.core.dokuji;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 主治医医療機関・主治医一覧表改頁を表す列挙型です。
 * 
 * @author LDNS 作成者漢字名
 */
public enum ShujiiOutputPage {

    /**
     * コード:1 名称:医療機関コード 略称:定義なし
     */
    医療機関コード("1", "医療機関コード"),

    /**
     * コード:2 名称:なし 略称:定義なし
     */
    なし("2", "なし");

    private final RString code;
    private final RString fullName;

    private ShujiiOutputPage(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 主治医医療機関・主治医一覧表改頁のコードを返します。
     * 
     * @return 主治医医療機関・主治医一覧表改頁のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 主治医医療機関・主治医一覧表改頁の名称を返します。
     * 
     * @return 主治医医療機関・主治医一覧表改頁の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 主治医医療機関・主治医一覧表改頁のコードと一致する内容を探します。
     * 
     * @param code 主治医医療機関・主治医一覧表改頁のコード
     * @return {@code code} に対応する主治医医療機関・主治医一覧表改頁
     */
    public static ShujiiOutputPage toValue(RString code) {
//        requireNonNull(code, DcErrorMessages.E00001.getMessage().getMessage());
        for (ShujiiOutputPage shujiiOutputPage : ShujiiOutputPage.values()) {
            if (shujiiOutputPage.code.equals(code)) {
                return shujiiOutputPage;
            }
        }
        return null;
//        throw new IllegalArgumentException(DcErrorMessages.E09002.getMessage().getMessage());
    }
}
