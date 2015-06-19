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
 * 要介護認定で使用する申請区分(法令)のコードです。
 *
 * @author N8235 船山 洋介
 */
public enum NinteiShinseiHoreiCode {

    /**
     * 新規申請 <br />
     * コード : 1
     */
    新規申請("1"),
    /**
     * 更新申請 <br />
     * コード : 2
     */
    更新申請("2"),
    /**
     * 区分変更申請 <br />
     * コード : 3
     */
    区分変更申請("3"),
    /**
     * 職権 <br />
     * コード : 4
     */
    職権("4");

    private final RString theCode;

    private NinteiShinseiHoreiCode(String code) {
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
     * 引数のコードに対応する{@link NinteiShinseiHoreiCode}を返します。
     *
     * @param code コード
     * @return コードに対応する{@link NinteiShinseiHoreiCode}
     * @throws IllegalArgumentException
     * コードに対応する{@link NinteiShinseiHoreiCode}が無い時
     */
    public static NinteiShinseiHoreiCode toValue(RString code) throws IllegalArgumentException {
        NinteiShinseiHoreiCode value = CodeToValue.get(code);
        if (value != null) {
            return value;
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage(NinteiShinseiHoreiCode.class.getSimpleName()));
    }

    //<editor-fold defaultstate="collapsed" desc="CodeToValue">
    private static final class CodeToValue {

        private static final Map<RString, NinteiShinseiHoreiCode> DICTHIONARY;

        static {
            Map<RString, NinteiShinseiHoreiCode> map = new HashMap<>();
            for (NinteiShinseiHoreiCode value : values()) {
                map.put(value.code(), value);
            }
            DICTHIONARY = Collections.unmodifiableMap(map);
        }

        static NinteiShinseiHoreiCode get(RString code) {
            return DICTHIONARY.get(code);
        }
    }
    //</editor-fold>
}
