/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.koiki;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 合併市町村を表示するか表示しないかの区分です。
 *
 * @author N3327 三浦 凌
 */
public enum GappeiShichosonDisplay {

    /**
     * 表示する<br/>
     * コード:"1"
     */
    表示する("1"),
    /**
     * 表示しない<br/>
     * コード:"2"
     */
    表示しない("0");
    private final RString theCode;

    private GappeiShichosonDisplay(String code) {
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
     * 引数のコードに対応する GappeiShichosonDisplay を返します。
     *
     * @param code コード
     * @return コードに対応する GappeiShichosonDisplay
     * @throws IllegalArgumentException コードに対応する GappeiShichosonDisplay が無い時
     */
    public static GappeiShichosonDisplay toValue(RString code) throws IllegalArgumentException {
        GappeiShichosonDisplay value = CodeToValue.get(code);
        if (value != null) {
            return value;
        }
        throw new IllegalArgumentException();
    }

    //<editor-fold defaultstate="collapsed" desc="CodeToValue">
    private static final class CodeToValue {

        private static final Map<RString, GappeiShichosonDisplay> DICTHIONARY;

        static {
            Map<RString, GappeiShichosonDisplay> map = new HashMap<>();
            for (GappeiShichosonDisplay value : values()) {
                map.put(value.code(), value);
            }
            DICTHIONARY = Collections.unmodifiableMap(map);
        }

        static GappeiShichosonDisplay get(RString code) {
            return DICTHIONARY.get(code);
        }
    }
    //</editor-fold>
}
