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
 * 老人保険受給者番号の体系です。
 *
 * @author N3327 三浦 凌
 */
public enum RokenJukyushaNoTaikei {

    /**
     * 住民コード<br/>
     * コード:"1"
     */
    住民コード("1"),
    /**
     * 医療給付サブシステム<br/>
     * コード:"2"
     */
    医療給付サブシステム("2"),
    /**
     * 市町村独自<br/>
     * コード:"3"
     */
    市町村独自("3"),
    /**
     * 設定なし<br/>
     * コード:"" (空文字)
     */
    設定なし("");
    private final RString theCode;

    private RokenJukyushaNoTaikei(String code) {
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
     * 引数のコードに対応する RokenJukyushaNoTaikei を返します。
     *
     * @param code コード
     * @return コードに対応する RokenJukyushaNoTaikei
     * @throws IllegalArgumentException コードに対応する RokenJukyushaNoTaikei が無い時
     */
    public static RokenJukyushaNoTaikei toValue(RString code) throws IllegalArgumentException {
        RokenJukyushaNoTaikei value = CodeToValue.get(code);
        if (value != null) {
            return value;
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage(RokenJukyushaNoTaikei.class.getSimpleName()));
    }

    //<editor-fold defaultstate="collapsed" desc="CodeToValue">
    private static final class CodeToValue {

        private static final Map<RString, RokenJukyushaNoTaikei> DICTHIONARY;

        static {
            Map<RString, RokenJukyushaNoTaikei> map = new HashMap<>();
            for (RokenJukyushaNoTaikei value : values()) {
                map.put(value.code(), value);
            }
            DICTHIONARY = Collections.unmodifiableMap(map);
        }

        static RokenJukyushaNoTaikei get(RString code) {
            return DICTHIONARY.get(code);
        }
    }
    //</editor-fold>
}
