/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.definition.core.gemmengengaku.shakaifukushihojinkeigen;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 減免区分を表す列挙型です。
 *
 * @reamsid_L DBD-9999-023 wangchao
 */
public enum GemmenKubun {

    /**
     * コード:無 名称:非課税_老年受給 略称:非課税_老年受給
     */
    非課税_老年受給("非課税_老年受給", "非課税_老年受給"),
    /**
     * コード:無 名称:生保に準ずる 略称:生保に準ずる
     */
    生保に準ずる("生保に準ずる", "生保に準ずる"),
    /**
     * コード:無 名称:その他 略称:非課税_老年受給
     */
    その他("その他", "その他"),
    /**
     * コード:無 名称:生計困難 略称:生計困難
     */
    生計困難("生計困難", "生計困難"),
    /**
     * コード:無 名称:激変緩和 略称:激変緩和
     */
    激変緩和("激変緩和", "激変緩和");

    private final RString fullName;
    private final RString shortName;

    private GemmenKubun(String fullname, String shortName) {
        this.fullName = new RString(fullname);
        this.shortName = new RString(shortName);
    }

    /**
     * 減免区分の名称を返します。
     *
     * @return 減免区分の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 減免区分の略称を返します。
     *
     * @return 減免区分の略称
     */
    public RString get略称() {
        return shortName;
    }

    /**
     * 減免区分のコードと一致する内容を探します。
     *
     * @param fullName 減免区分の名称
     * @return {@code code} に対応する減免区分
     */
    public static GemmenKubun toValue(RString fullName) {
        for (GemmenKubun gemmenKubun : GemmenKubun.values()) {
            if (gemmenKubun.fullName.equals(fullName)) {
                return gemmenKubun;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("減免区分"));
    }
}
