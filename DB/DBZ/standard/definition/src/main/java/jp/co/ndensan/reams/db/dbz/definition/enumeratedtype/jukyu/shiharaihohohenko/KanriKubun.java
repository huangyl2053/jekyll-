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
 * 支払方法変更で使用する管理区分です。
 *
 * @author N3327 三浦 凌
 */
public enum KanriKubun {

    ニ号差止("1", "2号差止"),
    一号償還払い化("2", "1号償還払い化"),
    一号給付額減額("3", "1号給付額減額");

    private final RString theCode;
    private final RString theName;

    private KanriKubun(String code, String name) {
        this.theCode = new RString(code);
        this.theName = new RString(name);
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
     * 名称を返します。
     *
     * @return 名称
     */
    public RString getName() {
        return this.theName;
    }

    /**
     * 引数のコードに対応する{@link KanriKubun}を返します。
     *
     * @param code コード
     * @return コードに対応する{@link KanriKubun}
     * @throws IllegalArgumentException コードに対応する{@link KanriKubun}が無い時
     */
    public static KanriKubun toValue(RString code) throws IllegalArgumentException {
        KanriKubun value = CodeToValue.get(code);
        if (value != null) {
            return value;
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage(KanriKubun.class.getSimpleName()));
    }

    //<editor-fold defaultstate="collapsed" desc="CodeToValue">
    private static final class CodeToValue {

        private static final Map<RString, KanriKubun> DICTHIONARY;

        static {
            Map<RString, KanriKubun> map = new HashMap<>();
            for (KanriKubun value : values()) {
                map.put(value.code(), value);
            }
            DICTHIONARY = Collections.unmodifiableMap(map);
        }

        static KanriKubun get(RString code) {
            return DICTHIONARY.get(code);
        }
    }
    //</editor-fold>
}
