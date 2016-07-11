package jp.co.ndensan.reams.db.dbe.definition.core.hoshu;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 訪問種別を表す列挙型です。
 *
 * @reamsid_L DBE-9999-023 liangbc
 */
public enum HomonShubetsu {

    /**
     * コード:1 名称:在宅 略称:定義なし
     */
    在宅("1", "在宅"),
    /**
     * コード:2 名称:施設 略称:定義なし
     */
    施設("2", "施設");

    private final RString code;
    private final RString fullName;

    private HomonShubetsu(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 訪問種別のコードを返します。
     *
     * @return 訪問種別のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 訪問種別の名称を返します。
     *
     * @return 訪問種別の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 訪問種別のコードと一致する内容を探します。
     *
     * @param code 訪問種別のコード
     * @return {@code code} に対応する訪問種別
     */
    public static HomonShubetsu toValue(RString code) {

        for (HomonShubetsu homonShubetsu : HomonShubetsu.values()) {
            if (homonShubetsu.code.equals(code)) {
                return homonShubetsu;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("訪問種別"));
    }
}
