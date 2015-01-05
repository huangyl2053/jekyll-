/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.hokensha;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 方書の印字有無です。
 *
 * @author N3327 三浦 凌
 */
public enum KatagakiPrint {

    /**
     * 印字することを表します。<br/>
     * コード:"1"
     */
    印字する("1"),
    /**
     * 印字しないことを表します。<br/>
     * コード:"0"
     */
    印字しない("0");
    private final RString theCode;

    private KatagakiPrint(String code) {
        this.theCode = new RString(code);
    }

    /**
     * コードを返します。
     *
     * @return コード
     */
    public RString code() {
        return this.theCode;
    }

    /**
     * 引数のコードに対応する KatagakiPrint を返します。
     *
     * @param code コード
     * @return コードに対応する KatagakiPrint
     * @throws IllegalArgumentException コードに対応する KatagakiPrint が無い時
     */
    public static KatagakiPrint toValue(RString code) throws IllegalArgumentException {
        KatagakiPrint value = CodeToValue.get(code);
        if (value != null) {
            return value;
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage(KatagakiPrint.class.getSimpleName()));
    }

    //<editor-fold defaultstate="collapsed" desc="CodeToValue">
    private static final class CodeToValue {

        private static final Map<RString, KatagakiPrint> DICTHIONARY;

        static {
            Map<RString, KatagakiPrint> map = new HashMap<>();
            for (KatagakiPrint value : values()) {
                map.put(value.code(), value);
            }
            DICTHIONARY = Collections.unmodifiableMap(map);
        }

        static KatagakiPrint get(RString code) {
            return DICTHIONARY.get(code);
        }
    }
    //</editor-fold>
}
