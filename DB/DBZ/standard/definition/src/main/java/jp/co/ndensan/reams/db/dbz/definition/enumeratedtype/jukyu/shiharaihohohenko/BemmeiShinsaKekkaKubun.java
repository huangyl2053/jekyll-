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
 * 支払方法変更で用いる弁明審査結果区分です。
 *
 * @author N3327 三浦 凌
 */
public enum BemmeiShinsaKekkaKubun {

    /**
     * 申請受理です。コード："1"
     */
    申請受理("1"),
    /**
     * 申請却下です。コード："2"
     */
    申請却下("2");

    private final RString theCode;

    private BemmeiShinsaKekkaKubun(String code) {
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
     * 引数のコードに対応する{@link BemmeiShinsaKekkaKubun}を返します。
     *
     * @param code コード
     * @return コードに対応する{@link BemmeiShinsaKekkaKubun}
     * @throws IllegalArgumentException
     * コードに対応する{@link BemmeiShinsaKekkaKubun}が無い時
     */
    public static BemmeiShinsaKekkaKubun toValue(RString code) throws IllegalArgumentException {
        BemmeiShinsaKekkaKubun value = CodeToValue.get(code);
        if (value != null) {
            return value;
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage(BemmeiShinsaKekkaKubun.class.getSimpleName()));
    }

    //<editor-fold defaultstate="collapsed" desc="CodeToValue">
    private static final class CodeToValue {

        private static final Map<RString, BemmeiShinsaKekkaKubun> DICTHIONARY;

        static {
            Map<RString, BemmeiShinsaKekkaKubun> map = new HashMap<>();
            for (BemmeiShinsaKekkaKubun value : values()) {
                map.put(value.code(), value);
            }
            DICTHIONARY = Collections.unmodifiableMap(map);
        }

        static BemmeiShinsaKekkaKubun get(RString code) {
            return DICTHIONARY.get(code);
        }
    }
    //</editor-fold>
}
