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
 * 外国人氏名の表示に関する区分です。
 *
 * @author N3327 三浦 凌
 */
public enum ForeignersNameOutput {

    /**
     * 通称名があれば通称名、なければ正式名を設定します。<br/>
     * コード:"1"
     */
    通称名優先("1"),
    /**
     * 無条件に正式名を設定します。<br/>
     * コード:"2"
     */
    正式名("2");

    private final RString theCode;

    private ForeignersNameOutput(String code) {
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
     * 引数のコードに対応する ForeignersNameOutput を返します。
     *
     * @param code コード
     * @return コードに対応する ForeignersNameOutput
     * @throws IllegalArgumentException コードに対応する ForeignersNameOutput が無い時
     */
    public static ForeignersNameOutput toValue(RString code) throws IllegalArgumentException {
        ForeignersNameOutput value = CodeToValue.get(code);
        if (value != null) {
            return value;
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage(ForeignersNameOutput.class.getSimpleName()));
    }

    //<editor-fold defaultstate="collapsed" desc="CodeToValue">
    private static final class CodeToValue {

        private static final Map<RString, ForeignersNameOutput> DICTHIONARY;

        static {
            Map<RString, ForeignersNameOutput> map = new HashMap<>();
            for (ForeignersNameOutput value : values()) {
                map.put(value.code(), value);
            }
            DICTHIONARY = Collections.unmodifiableMap(map);
        }

        static ForeignersNameOutput get(RString code) {
            return DICTHIONARY.get(code);
        }
    }
    //</editor-fold>
}
