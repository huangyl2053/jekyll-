/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.hokensha;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 最優先地区コードの区分です。
 *
 * @author N3327 三浦 凌
 */
public enum TopPriorityChikuCode {

    /**
     * 地区コード１<br/>
     * コード:"1"
     */
    地区コード１("1"),
    /**
     * 地区コード２<br/>
     * コード:"2"
     */
    地区コード２("2"),
    /**
     * 地区コード３<br/>
     * コード:"3"
     */
    地区コード３("3"),
    /**
     * 未使用<br/>
     * コード:"4"
     */
    未使用("4");
    private final RString theCode;

    private TopPriorityChikuCode(String code) {
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
     * 引数のコードに対応する TopPriorityChikuCode を返します。
     *
     * @param code コード
     * @return コードに対応する TopPriorityChikuCode
     * @throws IllegalArgumentException コードに対応する TopPriorityChikuCode が無い時
     */
    public static TopPriorityChikuCode toValue(RString code) throws IllegalArgumentException {
        TopPriorityChikuCode value = CodeToValue.get(code);
        if (value != null) {
            return value;
        }
        throw new IllegalArgumentException();
    }

    //<editor-fold defaultstate="collapsed" desc="CodeToValue">
    private static final class CodeToValue {

        private static final Map<RString, TopPriorityChikuCode> DICTHIONARY;

        static {
            Map<RString, TopPriorityChikuCode> map = new HashMap<>();
            for (TopPriorityChikuCode value : values()) {
                map.put(value.code(), value);
            }
            DICTHIONARY = Collections.unmodifiableMap(map);
        }

        static TopPriorityChikuCode get(RString code) {
            return DICTHIONARY.get(code);
        }
    }
    //</editor-fold>
}
