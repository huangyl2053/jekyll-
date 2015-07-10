/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.jukyu.shiharaihohohenko;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 支払方法変更で用いる弁明理由です。
 *
 * @author N3327 三浦 凌
 */
public enum BemmeiRiyu {

    /**
     * 公費負担医療の受給です。コード："01"
     */
    公費負担医療の受給("01"),
    /**
     * 災害です。コード："02"
     */
    災害("02"),
    /**
     * 重大な障害または長期入院です。コード："03"
     */
    重大な障害または長期入院("03"),
    /**
     * 滞納保険料の減少です。コード："04"
     */
    滞納保険料の減少("04"),
    /**
     * 保険料完納です。コード："05"
     */
    保険料完納("05"),
    /**
     * その他です。コード："99"
     */
    その他("99");

    private final RString theCode;

    private BemmeiRiyu(String code) {
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
     * {@link #name() name()}を{@link RString}へ変換して返します。
     *
     * @return {@link #name() name()}を{@link RString}へ変換した物
     */
    public RString toRString() {
        return new RString(name());
    }

    /**
     * 引数のコードに対応する{@link BemmeiRiyu}を返します。
     *
     * @param code コード
     * @return コードに対応する{@link BemmeiRiyu}
     * @throws IllegalArgumentException コードに対応する{@link BemmeiRiyu}が無い時
     */
    public static BemmeiRiyu toValue(RString code) throws IllegalArgumentException {
        BemmeiRiyu value = CodeToValue.get(code);
        if (value != null) {
            return value;
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage(BemmeiRiyu.class.getSimpleName()));
    }

    //<editor-fold defaultstate="collapsed" desc="CodeToValue">
    private static final class CodeToValue {

        private static final Map<RString, BemmeiRiyu> DICTHIONARY;

        static {
            Map<RString, BemmeiRiyu> map = new HashMap<>();
            for (BemmeiRiyu value : values()) {
                map.put(value.code(), value);
            }
            DICTHIONARY = Collections.unmodifiableMap(map);
        }

        static BemmeiRiyu get(RString code) {
            return DICTHIONARY.get(code);
        }
    }
    //</editor-fold>
}
