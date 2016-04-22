package jp.co.ndensan.reams.db.dbz.definition.batchprm.hanyolist.atena;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 地区を表す列挙型です。
 *
 * @reamsid_L DBZ-9999-023 wangchao
 */
public enum Chiku {

    /**
     * コード:0 名称:全て 略称:定義なし
     */
    全て("0", "全て"),
    /**
     * コード:1 名称:住所 略称:定義なし
     */
    住所("1", "住所"),
    /**
     * コード:2 名称:行政区 略称:定義なし
     */
    行政区("2", "行政区"),
    /**
     * コード:3 名称:地区（家並等） 略称:定義なし
     */
    地区("3", "地区（家並等）");

    private final RString code;
    private final RString fullName;

    private Chiku(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 地区のコードを返します。
     *
     * @return 地区のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 地区の名称を返します。
     *
     * @return 地区の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 地区のコードと一致する内容を探します。
     *
     * @param code 地区のコード
     * @return {@code code} に対応する地区
     */
    public static Chiku toValue(RString code) {
        for (Chiku chiku : Chiku.values()) {
            if (chiku.code.equals(code)) {
                return chiku;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("地区"));
    }
}
