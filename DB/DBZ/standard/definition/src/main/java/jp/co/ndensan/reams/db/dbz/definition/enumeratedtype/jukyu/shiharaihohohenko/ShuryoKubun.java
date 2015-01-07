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
 * 支払方法変更で用いる終了区分です。
 *
 * @author N3327 三浦 凌
 */
public enum ShuryoKubun {

    /**
     * 差止措置終了依頼書受理です。コード："01"
     */
    差止措置終了依頼書受理("01"),
    /**
     * 弁明書受理です。コード："02"
     */
    弁明書受理("02"),
    /**
     * 終了申請書受理です。コード："03"
     */
    終了申請書受理("03"),
    /**
     * 減額免除申請書受理です。コード："04"
     */
    減額免除申請書受理("04"),
    /**
     * 職権です。コード："98"
     */
    職権("98"),
    /**
     * その他です。コード："99"
     */
    その他("99");

    private final RString theCode;

    private ShuryoKubun(String code) {
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
     * 引数のコードに対応する{@link ShuryoKubun}を返します。
     *
     * @param code コード
     * @return コードに対応する{@link ShuryoKubun}
     * @throws IllegalArgumentException コードに対応する{@link ShuryoKubun}が無い時
     */
    public static ShuryoKubun toValue(RString code) throws IllegalArgumentException {
        ShuryoKubun value = CodeToValue.get(code);
        if (value != null) {
            return value;
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage(ShuryoKubun.class.getSimpleName()));
    }

    //<editor-fold defaultstate="collapsed" desc="CodeToValue">
    private static final class CodeToValue {

        private static final Map<RString, ShuryoKubun> DICTHIONARY;

        static {
            Map<RString, ShuryoKubun> map = new HashMap<>();
            for (ShuryoKubun value : values()) {
                map.put(value.code(), value);
            }
            DICTHIONARY = Collections.unmodifiableMap(map);
        }

        static ShuryoKubun get(RString code) {
            return DICTHIONARY.get(code);
        }
    }
    //</editor-fold>
}
