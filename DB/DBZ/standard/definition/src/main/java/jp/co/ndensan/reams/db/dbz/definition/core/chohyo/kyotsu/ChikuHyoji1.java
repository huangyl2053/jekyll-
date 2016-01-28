package jp.co.ndensan.reams.db.dbz.definition.core.chohyo.kyotsu;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 地区表示1を表す列挙型です。
 *
 * @author LDNS
 */
public enum ChikuHyoji1 {

    /**
     * コード:0 名称:なし 略称:定義なし
     */
    なし("0", "なし"),
    /**
     * コード:1 名称:住所コード 略称:定義なし
     */
    住所コード("1", "住所コード"),
    /**
     * コード:2 名称:行政区コード 略称:定義なし
     */
    行政区コード("2", "行政区コード");

    private final RString code;
    private final RString fullName;

    private ChikuHyoji1(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 地区表示1のコードを返します。
     *
     * @return 地区表示1のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 地区表示1の名称を返します。
     *
     * @return 地区表示1の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 地区表示1のコードと一致する内容を探します。
     *
     * @param code 地区表示1のコード
     * @return {@code code} に対応する地区表示1
     */
    public static ChikuHyoji1 toValue(RString code) {

        for (ChikuHyoji1 chikuHyoji1 : ChikuHyoji1.values()) {
            if (chikuHyoji1.code.equals(code)) {
                return chikuHyoji1;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("地区表示1"));
    }
}
