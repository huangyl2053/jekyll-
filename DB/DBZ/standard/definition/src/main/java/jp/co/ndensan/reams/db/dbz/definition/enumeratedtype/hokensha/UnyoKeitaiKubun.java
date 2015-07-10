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
 * 広域保険者の運用形態の区分です。
 *
 * @author N3327 三浦 凌
 */
public enum UnyoKeitaiKubun {

    /**
     * 単独<br/>
     * コード:"1"
     */
    単独("1"),
    /**
     * 広域連合<br/>
     * コード:"2"
     */
    広域連合("2"),
    /**
     * 一部事務組合<br/>
     * コード:"3"
     */
    一部事務組合("3");
    private final RString theCode;

    private UnyoKeitaiKubun(String code) {
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
     * 引数のコードに対応する UnyoKeitaiKubun を返します。
     *
     * @param code コード
     * @return コードに対応する UnyoKeitaiKubun
     * @throws IllegalArgumentException コードに対応する UnyoKeitaiKubun が無い時
     */
    public static UnyoKeitaiKubun toValue(RString code) throws IllegalArgumentException {
        UnyoKeitaiKubun value = CodeToValue.get(code);
        if (value != null) {
            return value;
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage(UnyoKeitaiKubun.class.getSimpleName()));
    }

    //<editor-fold defaultstate="collapsed" desc="CodeToValue">
    private static final class CodeToValue {

        private static final Map<RString, UnyoKeitaiKubun> DICTHIONARY;

        static {
            Map<RString, UnyoKeitaiKubun> map = new HashMap<>();
            for (UnyoKeitaiKubun value : values()) {
                map.put(value.code(), value);
            }
            DICTHIONARY = Collections.unmodifiableMap(map);
        }

        static UnyoKeitaiKubun get(RString code) {
            return DICTHIONARY.get(code);
        }
    }
    //</editor-fold>
}
