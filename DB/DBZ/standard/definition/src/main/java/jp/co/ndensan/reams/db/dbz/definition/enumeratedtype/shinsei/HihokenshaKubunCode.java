/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.shinsei;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 要介護認定申請で使用する被保険者区分の列挙型です。
 *
 * @author N8235 船山 洋介
 */
public enum HihokenshaKubunCode {

    /**
     * 第１号被保険者 <br />
     * コード : 1
     */
    第１号被保険者("1"),
    /**
     * 第２号被保険者 <br />
     * コード : 2
     */
    第２号被保険者("2"),
    /**
     * その他 <br />
     * コード : 3
     */
    その他("3");

    private final RString theCode;

    private HihokenshaKubunCode(String code) {
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
     * 引数のコードに対応する{@link HihokenshaKubunCode}を返します。
     *
     * @param code コード
     * @return コードに対応する{@link HihokenshaKubunCode}
     * @throws IllegalArgumentException コードに対応する{@link HihokenshaKubunCode}が無い時
     */
    public static HihokenshaKubunCode toValue(RString code) throws IllegalArgumentException {
        HihokenshaKubunCode value = CodeToValue.get(code);
        if (value != null) {
            return value;
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage(HihokenshaKubunCode.class.getSimpleName()));
    }

    //<editor-fold defaultstate="collapsed" desc="CodeToValue">
    private static final class CodeToValue {

        private static final Map<RString, HihokenshaKubunCode> DICTHIONARY;

        static {
            Map<RString, HihokenshaKubunCode> map = new HashMap<>();
            for (HihokenshaKubunCode value : values()) {
                map.put(value.code(), value);
            }
            DICTHIONARY = Collections.unmodifiableMap(map);
        }

        static HihokenshaKubunCode get(RString code) {
            return DICTHIONARY.get(code);
        }
    }
    //</editor-fold>
}
