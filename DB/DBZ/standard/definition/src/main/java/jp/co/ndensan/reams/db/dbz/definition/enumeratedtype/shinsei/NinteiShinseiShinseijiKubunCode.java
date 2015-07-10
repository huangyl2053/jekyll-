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
 * 要介護認定で使用する申請区分(申請時)のコードです。
 *
 * @author N8235 船山 洋介
 */
public enum NinteiShinseiShinseijiKubunCode {

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
    職権("4"),
    /**
     * 転入申請 <br />
     * コード : 5
     */
    転入申請("5"),
    /**
     * 資格喪失_死亡 <br />
     * コード : 6
     */
    資格喪失_死亡("6"),
    /**
     * 新規申請_事前 <br />
     * コード : A
     */
    新規申請_事前("A"),
    /**
     * 更新申請_事前 <br />
     * コード : B
     */
    更新申請_事前("B");

    private final RString theCode;

    private NinteiShinseiShinseijiKubunCode(String code) {
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
     * 引数のコードに対応する{@link NinteiShinseiShinseijiKubunCode}を返します。
     *
     * @param code コード
     * @return コードに対応する{@link NinteiShinseiShinseijiKubunCode}
     * @throws IllegalArgumentException
     * コードに対応する{@link NinteiShinseiShinseijiKubunCode}が無い時
     */
    public static NinteiShinseiShinseijiKubunCode toValue(RString code) throws IllegalArgumentException {
        NinteiShinseiShinseijiKubunCode value = CodeToValue.get(code);
        if (value != null) {
            return value;
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage(NinteiShinseiShinseijiKubunCode.class.getSimpleName()));
    }

    //<editor-fold defaultstate="collapsed" desc="CodeToValue">
    private static final class CodeToValue {

        private static final Map<RString, NinteiShinseiShinseijiKubunCode> DICTHIONARY;

        static {
            Map<RString, NinteiShinseiShinseijiKubunCode> map = new HashMap<>();
            for (NinteiShinseiShinseijiKubunCode value : values()) {
                map.put(value.code(), value);
            }
            DICTHIONARY = Collections.unmodifiableMap(map);
        }

        static NinteiShinseiShinseijiKubunCode get(RString code) {
            return DICTHIONARY.get(code);
        }
    }
    //</editor-fold>
}
