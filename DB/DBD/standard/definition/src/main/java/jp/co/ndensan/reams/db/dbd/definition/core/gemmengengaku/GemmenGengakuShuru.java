/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.definition.core.gemmengengaku;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 利用者負担段階を表す列挙型です。
 *
 * @reamsid_L DBD-3880-050 x_youyj
 */
public enum GemmenGengakuShuru {

    /**
     * コード:01 名称:標準負担額減免 略称:標準負担額減免
     */
    標準負担額減免("01", "標準負担額減免", "標準負担額減免"),
    /**
     * コード:02 名称:特定標準負担額減額 略称:特定標準負担額減額
     */
    特定標準負担額減額("02", "特定標準負担額減額", "特定標準負担額減額"),
    /**
     * コード:03 名称:利用者負担額減額 略称:利用者負担額減額
     */
    利用者負担額減額("03", "利用者負担額減額", "利用者負担額減額"),
    /**
     * コード:04 名称:社会福祉法人等軽減 略称:社会福祉法人等軽減
     */
    社会福祉法人等利用者負担軽減("04", "社会福祉法人等軽減", "社会福祉法人等軽減"),
    /**
     * コード:05 名称:訪問介護利用者負担額減額 略称:訪問介護利用者負担額減額
     */
    訪問介護利用者負担額減額("05", "訪問介護利用者負担額減額", "訪問介護利用者負担額減額"),
    /**
     * コード:06 名称:特別地域加算減免 略称:特別地域加算減免
     */
    特別地域加算減免("06", "特別地域加算減免", "特別地域加算減免"),
    /**
     * コード:07 名称:負担限度額認定 略称:負担限度額認定
     */
    負担限度額認定("07", "負担限度額認定", "負担限度額認定"),
    /**
     * コード:10 名称:障がい者控除 略称:障がい者控除
     */
    障がい者控除("10", "障がい者控除", "障がい者控除");

    private final RString code;
    private final RString fullName;
    private final RString shortName;

    private GemmenGengakuShuru(String code, String fullname, String shortName) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
        this.shortName = new RString(shortName);
    }

    /**
     * 利用者負担段階のコードを返します。
     *
     * @return 利用者負担段階のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 利用者負担段階の名称を返します。
     *
     * @return 利用者負担段階の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 利用者負担段階の略称を返します。
     *
     * @return 利用者負担段階の略称
     */
    public RString get略称() {
        return shortName;
    }

    /**
     * 利用者負担段階のコードと一致する内容を探します。
     *
     * @param code 減免減額種類のコード
     * @return {@code code} に対応する減免減額種類
     */
    public static GemmenGengakuShuru toValue(RString code) {
        for (GemmenGengakuShuru gemmenGengakuShuru : GemmenGengakuShuru.values()) {
            if (gemmenGengakuShuru.code.equals(code)) {
                return gemmenGengakuShuru;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("減免減額種類"));
    }
}
