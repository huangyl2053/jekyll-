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
 * 処理タイプです。
 *
 * @author n8223 朴義一
 */
public enum HdnShoriTypeStatus {

    /**
     * 処理タイプモードのNomalAddModeであることを表します。<br/>
     * コード:"1"
     */
    NomalAddMode("1"),
    /**
     * 処理タイプモードのNomalUpdateModeであることを表します。<br/>
     * コード:"2"
     */
    NomalUpdateMode("2"),
     /**
      * 処理タイプモードのSeihoAddModeであることを表します。<br/>
     * コード:"3"
     */
    SeihoAddMode("3"),
     /**
      * 処理タイプモードのSeihoUpdateModeであることを表します。<br/>
     * コード:"4"
     */
    SeihoUpdateMode("4"),
         /**
      * 処理タイプモードのShokaiModeであることを表します。<br/>
     * コード:"4"
     */
    ShokaiMode("5");
    
    
    private final RString theCode;

    private HdnShoriTypeStatus(String code) {
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
     * 引数のコードに対応する HokenshaKosei を返します。
     *
     * @param code コード
     * @return コードに対応する HokenshaKosei
     * @throws IllegalArgumentException コードに対応する HokenshaKosei が無い時
     */
    public static HdnShoriTypeStatus toValue(RString code) throws IllegalArgumentException {
        HdnShoriTypeStatus value = CodeToValue.get(code);
        if (value != null) {
            return value;
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage(HdnShoriTypeStatus.class.getSimpleName()));
    }

    //<editor-fold defaultstate="collapsed" desc="CodeToValue">
    private static final class CodeToValue {

        private static final Map<RString, HdnShoriTypeStatus> DICTHIONARY;

        static {
            Map<RString, HdnShoriTypeStatus> map = new HashMap<>();
            for (HdnShoriTypeStatus value : values()) {
                map.put(value.code(), value);
            }
            DICTHIONARY = Collections.unmodifiableMap(map);
        }

        static HdnShoriTypeStatus get(RString code) {
            return DICTHIONARY.get(code);
        }
    }
    //</editor-fold>
}
