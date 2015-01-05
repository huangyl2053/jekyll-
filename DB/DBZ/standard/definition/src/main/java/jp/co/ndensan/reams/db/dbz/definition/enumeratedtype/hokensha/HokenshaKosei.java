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
 * 保険者の構成です。
 *
 * @author N3327 三浦 凌
 */
public enum HokenshaKosei {

    /**
     * 単一市町村の保険者であることを表します。<br/>
     * コード:"1"
     */
    単一市町村("1"),
    /**
     * 広域保険者であることを表します。<br/>
     * コード:"2"
     */
    広域市町村("2");
    private final RString theCode;

    private HokenshaKosei(String code) {
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
     * 引数のコードに対応する HokenshaKosei を返します。
     *
     * @param code コード
     * @return コードに対応する HokenshaKosei
     * @throws IllegalArgumentException コードに対応する HokenshaKosei が無い時
     */
    public static HokenshaKosei toValue(RString code) throws IllegalArgumentException {
        HokenshaKosei value = CodeToValue.get(code);
        if (value != null) {
            return value;
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage(HokenshaKosei.class.getSimpleName()));
    }

    //<editor-fold defaultstate="collapsed" desc="CodeToValue">
    private static final class CodeToValue {

        private static final Map<RString, HokenshaKosei> DICTHIONARY;

        static {
            Map<RString, HokenshaKosei> map = new HashMap<>();
            for (HokenshaKosei value : values()) {
                map.put(value.code(), value);
            }
            DICTHIONARY = Collections.unmodifiableMap(map);
        }

        static HokenshaKosei get(RString code) {
            return DICTHIONARY.get(code);
        }
    }
    //</editor-fold>
}
