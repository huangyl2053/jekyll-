/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.core.gemmengengakurirekijyoho;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 減免減額種類を表す列挙型です。
 *
 * @reamsid_L DBC-9999-022 liuxiaoyu
 */
public enum GemmenGengakuShurui {

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
     * コード:04 名称:社会福祉法人等利用者負担軽減 略称:社会福祉法人等軽減
     */
    社会福祉法人等利用者負担軽減("04", "社会福祉法人等利用者負担軽減", "社会福祉法人等軽減"),
    /**
     * コード:05 名称:負担限度額認定 略称:負担限度額認定
     */
    負担限度額認定("05", "負担限度額認定", "負担限度額認定"),
    /**
     * コード:06 名称:特定負担限度額認定 略称:特定負担限度額認定
     */
    特定負担限度額認定("06", "特定負担限度額認定", "特定負担限度額認定"),
    /**
     * コード:07 名称:市民課税特例減額 略称:市民課税特例減額
     */
    市民課税特例減額("07", "市民課税特例減額", "市民課税特例減額");

    private final RString code;
    private final RString fullName;
    private final RString shortName;

    private GemmenGengakuShurui(String code, String fullname, String shortName) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
        this.shortName = new RString(shortName);
    }

    /**
     * 減免減額種類のコードを返します。
     *
     * @return 減免減額種類のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 減免減額種類の名称を返します。
     *
     * @return 減免減額種類の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 減免減額種類の略称を返します。
     *
     * @return 減免減額種類の略称
     */
    public RString get略称() {
        return shortName;
    }

    /**
     * 減免減額種類のコードと一致する内容を探します。
     *
     * @param code 減免減額種類のコード
     * @return {@code code} に対応する減免減額種類
     */
    public static GemmenGengakuShurui toValue(RString code) {

        for (GemmenGengakuShurui gemmenGengakuShurui : GemmenGengakuShurui.values()) {
            if (gemmenGengakuShurui.code.equals(code)) {
                return gemmenGengakuShurui;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("減免減額種類"));
    }
}
