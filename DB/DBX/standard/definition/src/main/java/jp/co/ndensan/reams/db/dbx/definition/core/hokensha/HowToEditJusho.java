/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.definition.core.hokensha;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 住所の編集方法クラスです。
 *
 * @author N3327 三浦 凌
 */
public enum HowToEditJusho {

    /**
     * 住所＋番地。
     */
    住所と番地("1"),
    /**
     * 行政区＋番地。
     */
    行政区と番地("2"),
    /**
     * 住所＋番地、（行政区）。
     */
    住所と番地_行政区("3"),
    /**
     * 番地のみ。
     */
    番地のみ("4"),
    /**
     * 表示無し(住所は印字しない)。
     */
    印字しない("5");

    private final RString theCode;

    private HowToEditJusho(String code) {
        this.theCode = new RString(code);
    }

    /**
     * コードを返します。
     *
     * @return コード
     */
    public RString code() {
        return theCode;
    }

    /**
     * 引数のコードに対応する HowToEditJusho を返します。
     *
     * @param code コード
     * @return コードに対応する HowToEditJusho
     * @throws IllegalArgumentException コードに対応する HowToEditJusho が無い時
     */
    public static HowToEditJusho toValue(RString code) throws IllegalArgumentException {
        HowToEditJusho value = CodeToValue.get(code);
        if (value != null) {
            return value;
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage(HowToEditJusho.class.getSimpleName()));
    }

    //<editor-fold defaultstate="collapsed" desc="CodeToValue">
    private static final class CodeToValue {

        private static final Map<RString, HowToEditJusho> DICTHIONARY;

        static {
            Map<RString, HowToEditJusho> map = new HashMap<>();
            for (HowToEditJusho value : values()) {
                map.put(value.code(), value);
            }
            DICTHIONARY = Collections.unmodifiableMap(map);
        }

        static HowToEditJusho get(RString code) {
            return DICTHIONARY.get(code);
        }
    }
    //</editor-fold>
}
