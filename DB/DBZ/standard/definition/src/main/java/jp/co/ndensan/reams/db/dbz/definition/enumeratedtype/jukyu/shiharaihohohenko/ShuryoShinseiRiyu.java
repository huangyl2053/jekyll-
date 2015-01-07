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
 * 支払方法変更で用いる終了申請の理由です。
 *
 * @author N3327 三浦 凌
 */
public enum ShuryoShinseiRiyu {

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
     * 特別な事情です。コード："06"
     */
    特別な事情("06"),
    /**
     * 職権です。コード："98"
     */
    職権("98"),
    /**
     * その他です。コード："99"
     */
    その他("99");

    private final RString theCode;

    private ShuryoShinseiRiyu(String code) {
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
     * 引数のコードに対応する{@link ShuryoShinseiRiyu}を返します。
     *
     * @param code コード
     * @return コードに対応する{@link ShuryoShinseiRiyu}
     * @throws IllegalArgumentException コードに対応する{@link ShuryoShinseiRiyu}が無い時
     */
    public static ShuryoShinseiRiyu toValue(RString code) throws IllegalArgumentException {
        ShuryoShinseiRiyu value = CodeToValue.get(code);
        if (value != null) {
            return value;
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage(ShuryoShinseiRiyu.class.getSimpleName()));
    }

    //<editor-fold defaultstate="collapsed" desc="CodeToValue">
    private static final class CodeToValue {

        private static final Map<RString, ShuryoShinseiRiyu> DICTHIONARY;

        static {
            Map<RString, ShuryoShinseiRiyu> map = new HashMap<>();
            for (ShuryoShinseiRiyu value : values()) {
                map.put(value.code(), value);
            }
            DICTHIONARY = Collections.unmodifiableMap(map);
        }

        static ShuryoShinseiRiyu get(RString code) {
            return DICTHIONARY.get(code);
        }
    }
    //</editor-fold>
}
