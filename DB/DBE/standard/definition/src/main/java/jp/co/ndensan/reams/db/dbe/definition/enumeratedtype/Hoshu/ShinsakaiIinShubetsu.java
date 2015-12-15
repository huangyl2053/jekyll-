package jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.Hoshu;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 介護認定審査委員種別を表す列挙型です。
 *
 * @author LDNS
 */
public enum ShinsakaiIinShubetsu {

    /**
     * コード:0 名称:委員 略称:定義なし
     */
    委員("0", "委員"),
    /**
     * コード:1 名称:委員長 略称:定義なし
     */
    委員長("1", "委員長");

    private final RString code;
    private final RString fullName;

    private ShinsakaiIinShubetsu(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 介護認定審査委員種別のコードを返します。
     *
     * @return 介護認定審査委員種別のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 介護認定審査委員種別の名称を返します。
     *
     * @return 介護認定審査委員種別の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 介護認定審査委員種別のコードと一致する内容を探します。
     *
     * @param code 介護認定審査委員種別のコード
     * @return {@code code} に対応する介護認定審査委員種別
     */
    public static ShinsakaiIinShubetsu toValue(RString code) {

        for (ShinsakaiIinShubetsu shinsakaiIinShubetsu : ShinsakaiIinShubetsu.values()) {
            if (shinsakaiIinShubetsu.code.equals(code)) {
                return shinsakaiIinShubetsu;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("介護認定審査委員種別"));
    }
}
