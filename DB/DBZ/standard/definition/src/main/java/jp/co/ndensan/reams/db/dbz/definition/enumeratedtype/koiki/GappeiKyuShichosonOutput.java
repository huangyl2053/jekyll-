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
public enum GappeiKyuShichosonOutput {

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

    private GappeiKyuShichosonOutput(String code) {
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
     * 引数のコードに対応する GappeiKyuShichosonOutput を返します。
     *
     * @param code コード
     * @return コードに対応する GappeiKyuShichosonOutput
     * @throws IllegalArgumentException コードに対応する GappeiKyuShichosonOutput が無い時
     */
    public static GappeiKyuShichosonOutput toValue(RString code) throws IllegalArgumentException {
        GappeiKyuShichosonOutput value = CodeToValue.get(code);
        if (value != null) {
            return value;
        }
        throw new IllegalArgumentException();
    }

    //<editor-fold defaultstate="collapsed" desc="CodeToValue">
    private static final class CodeToValue {

        private static final Map<RString, GappeiKyuShichosonOutput> DICTHIONARY;

        static {
            Map<RString, GappeiKyuShichosonOutput> map = new HashMap<>();
            for (GappeiKyuShichosonOutput value : values()) {
                map.put(value.code(), value);
            }
            DICTHIONARY = Collections.unmodifiableMap(map);
        }

        static GappeiKyuShichosonOutput get(RString code) {
            return DICTHIONARY.get(code);
        }
    }
    //</editor-fold>
}
