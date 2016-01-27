package jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.Dokuji;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 主治医の状況判定を表す列挙型です。
 * 
 * @author LDNS 作成者漢字名
 */
public enum ShujiiHateiJokyo {

    /**
     * コード:1 名称:有効のみ 略称:定義なし
     */
    有効のみ("1", "有効のみ"),

    /**
     * コード:2 名称:無効のみ 略称:定義なし
     */
    無効のみ("2", "無効のみ"),

    /**
     * コード:3 名称:全て 略称:定義なし
     */
    全て("3", "全て");

    private final RString code;
    private final RString fullName;

    private ShujiiHateiJokyo(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 主治医の状況判定のコードを返します。
     * 
     * @return 主治医の状況判定のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 主治医の状況判定の名称を返します。
     * 
     * @return 主治医の状況判定の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 主治医の状況判定のコードと一致する内容を探します。
     * 
     * @param code 主治医の状況判定のコード
     * @return {@code code} に対応する主治医の状況判定
     */
    public static ShujiiHateiJokyo toValue(RString code) {
//        requireNonNull(code, DcErrorMessages.E00001.getMessage().getMessage());
        for (ShujiiHateiJokyo shujiiHateiJokyo : ShujiiHateiJokyo.values()) {
            if (shujiiHateiJokyo.code.equals(code)) {
                return shujiiHateiJokyo;
            }
        }
//        throw new IllegalArgumentException(DcErrorMessages.E09002.getMessage().getMessage());
        return null;
    }
}
