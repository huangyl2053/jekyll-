/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.definition.core.hokensha;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 群名の印字有無です。
 *
 * @author N3327 三浦 凌
 */
public enum GunNamePrint {

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

    private GunNamePrint(String code) {
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
     * 引数のコードに対応する GunNamePrint を返します。
     *
     * @param code コード
     * @return コードに対応する GunNamePrint
     * @throws IllegalArgumentException コードに対応する GunNamePrint が無い時
     */
    public static GunNamePrint toValue(RString code) throws IllegalArgumentException {
        GunNamePrint value = CodeToValue.get(code);
        if (value != null) {
            return value;
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage(GunNamePrint.class.getSimpleName()));
    }

    //<editor-fold defaultstate="collapsed" desc="CodeToValue">
    private static final class CodeToValue {

        private static final Map<RString, GunNamePrint> DICTHIONARY;

        static {
            Map<RString, GunNamePrint> map = new HashMap<>();
            for (GunNamePrint value : values()) {
                map.put(value.code(), value);
            }
            DICTHIONARY = Collections.unmodifiableMap(map);
        }

        static GunNamePrint get(RString code) {
            return DICTHIONARY.get(code);
        }
    }
    //</editor-fold>
}
