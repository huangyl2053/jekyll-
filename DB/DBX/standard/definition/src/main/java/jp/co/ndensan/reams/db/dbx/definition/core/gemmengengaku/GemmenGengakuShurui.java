/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.definition.core.gemmengengaku;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 受給者（総合事業対象者）が受けることができる、各種減免・減額の一覧です。
 */
public enum GemmenGengakuShurui {

    /**
     * 標準負担額減額
     */
    標準負担額減免("01"),
    /**
     * 特定標準負担額減額
     */
    特定標準負担額減額("02"),
    /**
     * 利用者負担額減額
     */
    利用者負担額減額("03"),
    /**
     * 社会福祉法人等利用者負担軽減
     */
    社会福祉法人等利用者負担軽減("04"),
    /**
     * 訪問介護利用者負担減額
     */
    訪問介護利用者負担額減額("05"),
    /**
     * 特別地域加算減免
     */
    特別地域加算減免("06"),
    /**
     * 負担限度額認定
     */
    負担限度額認定("07");

    private final RString aCode;

    private GemmenGengakuShurui(String code) {
        this.aCode = new RString(code);
    }

    /**
     * コードを返却します。
     *
     * @return コード
     */
    public RString code() {
        return aCode;
    }

    /**
     * 指定のコードに対応する GemmenGengakuShurui を返します。
     *
     * @param code コード
     * @return コードに対応する GemmenGengakuShurui
     * @throws IllegalArgumentException 指定のコードに対応する GemmenGengakuShurui が無い時
     */
    public static GemmenGengakuShurui toValue(RString code) throws IllegalArgumentException {
        GemmenGengakuShurui value = CodeToValue.get(code);
        if (value != null) {
            return value;
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage(
                GemmenGengakuShurui.class.getSimpleName()));
    }

    //<editor-fold defaultstate="collapsed" desc="CodeToValue">
    private static final class CodeToValue {

        private static final Map<RString, GemmenGengakuShurui> DICTHIONARY;

        static {
            Map<RString, GemmenGengakuShurui> map = new HashMap<>();
            for (GemmenGengakuShurui value : values()) {
                map.put(value.code(), value);
            }
            DICTHIONARY = Collections.unmodifiableMap(map);
        }

        static GemmenGengakuShurui get(RString code) {
            return DICTHIONARY.get(code);
        }
    }
    //</editor-fold>
}
